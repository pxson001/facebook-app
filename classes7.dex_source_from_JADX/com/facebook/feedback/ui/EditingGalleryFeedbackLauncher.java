package com.facebook.feedback.ui;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.NotificationSource;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.SizeUtil;
import com.facebook.debug.log.BLog;
import com.facebook.friendsharing.photoremix.utils.PhotoRemixCommentSource;
import com.facebook.friendsharing.photoremix.utils.PhotoRemixSavePhotoUtils;
import com.facebook.friendsharing.photoremix.utils.PhotoRemixSavePhotoUtils.1;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration.Builder;
import com.facebook.ipc.editgallery.EntryPoint;
import com.facebook.ipc.media.MediaItem;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.MediaItemFactory.FallbackMediaId;
import com.facebook.photos.base.media.MediaItemFactory.Storage;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageLoggerProvider;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.FramePack;
import com.facebook.photos.creativeediting.swipeable.common.FramesAggregator;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsHelper;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsListBuilderProvider;
import com.facebook.photos.editgallery.EditGalleryFragmentManager;
import com.facebook.photos.editgallery.EditGalleryFragmentManager.EditGalleryCallback;
import com.facebook.photos.editgallery.EditGalleryFragmentManager.UsageParams;
import com.facebook.photos.editgallery.EditGalleryUsageLoggingUtils;
import com.facebook.timeline.tempprofilepic.model.ExpirationState;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ufiservices.analytics.UFIServicesAnalyticsEventBuilder;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.facebook.ufiservices.flyout.UFIPopoverFragment;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;

/* compiled from: scheduleTime */
public class EditingGalleryFeedbackLauncher {
    public static final String f4433b = EditingGalleryFeedbackLauncher.class.getName();
    @DefaultExecutorService
    ListeningExecutorService f4434a;
    public final MediaItemFactory f4435c;
    public final Context f4436d;
    public final FeedbackPopoverLauncher f4437e;
    public final PhotoRemixSavePhotoUtils f4438f;
    public final CreativeEditingUsageLoggerProvider f4439g;
    public final AnalyticsLogger f4440h;
    public final UFIServicesAnalyticsEventBuilder f4441i;
    public final SwipeableParamsHelper f4442j;
    public final FramesAggregator f4443k;
    public final SwipeableParamsListBuilderProvider f4444l;
    public EditGalleryFragmentManager f4445m;
    public EditGalleryLaunchConfiguration f4446n;

    public static EditingGalleryFeedbackLauncher m5031b(InjectorLike injectorLike) {
        return new EditingGalleryFeedbackLauncher(MediaItemFactory.b(injectorLike), (Context) injectorLike.getInstance(Context.class), FeedbackPopoverLauncher.a(injectorLike), PhotoRemixSavePhotoUtils.b(injectorLike), (CreativeEditingUsageLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CreativeEditingUsageLoggerProvider.class), AnalyticsLoggerMethodAutoProvider.a(injectorLike), UFIServicesAnalyticsEventBuilder.a(injectorLike), SwipeableParamsHelper.m11713b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), FramesAggregator.b(injectorLike), (SwipeableParamsListBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SwipeableParamsListBuilderProvider.class));
    }

    @Inject
    public EditingGalleryFeedbackLauncher(MediaItemFactory mediaItemFactory, Context context, FeedbackPopoverLauncher feedbackPopoverLauncher, PhotoRemixSavePhotoUtils photoRemixSavePhotoUtils, CreativeEditingUsageLoggerProvider creativeEditingUsageLoggerProvider, AnalyticsLogger analyticsLogger, UFIServicesAnalyticsEventBuilder uFIServicesAnalyticsEventBuilder, SwipeableParamsHelper swipeableParamsHelper, ListeningExecutorService listeningExecutorService, FramesAggregator framesAggregator, SwipeableParamsListBuilderProvider swipeableParamsListBuilderProvider) {
        this.f4435c = mediaItemFactory;
        this.f4436d = context;
        this.f4437e = feedbackPopoverLauncher;
        this.f4438f = photoRemixSavePhotoUtils;
        this.f4439g = creativeEditingUsageLoggerProvider;
        this.f4440h = analyticsLogger;
        this.f4441i = uFIServicesAnalyticsEventBuilder;
        this.f4442j = swipeableParamsHelper;
        this.f4434a = listeningExecutorService;
        this.f4443k = framesAggregator;
        this.f4444l = swipeableParamsListBuilderProvider;
        Activity activity = (Activity) ContextUtils.a(context, Activity.class);
        if (activity instanceof FbFragmentActivity) {
            this.f4445m = new EditGalleryFragmentManager(((FbFragmentActivity) activity).kO_());
        }
    }

    public final OnClickListener m5033a(Uri uri, GraphQLFeedback graphQLFeedback, EntryPoint entryPoint, PhotoRemixCommentSource photoRemixCommentSource) {
        if (this.f4445m == null) {
            return null;
        }
        final Uri uri2 = uri;
        final GraphQLFeedback graphQLFeedback2 = graphQLFeedback;
        final EntryPoint entryPoint2 = entryPoint;
        final PhotoRemixCommentSource photoRemixCommentSource2 = photoRemixCommentSource;
        return new OnClickListener(this) {
            final /* synthetic */ EditingGalleryFeedbackLauncher f4425e;

            /* compiled from: scheduleTime */
            class C04091 implements Runnable {
                final /* synthetic */ C04101 f4420a;

                /* compiled from: scheduleTime */
                class C04081 extends AbstractDisposableFutureCallback<ImmutableList<FramePack>> {
                    final /* synthetic */ C04091 f4419a;

                    /* compiled from: scheduleTime */
                    class C04071 extends AbstractDisposableFutureCallback<Uri> {
                        final /* synthetic */ C04081 f4418a;

                        C04071(C04081 c04081) {
                            this.f4418a = c04081;
                        }

                        protected final void m5021a(Object obj) {
                            Uri uri = (Uri) obj;
                            this.f4418a.f4419a.f4420a.f4425e.f4445m.m12201a(uri, SizeUtil.a(this.f4418a.f4419a.f4420a.f4425e.f4436d, 180.0f), SizeUtil.a(this.f4418a.f4419a.f4420a.f4425e.f4436d, 180.0f), this.f4418a.f4419a.f4420a.f4425e.f4446n, EditingGalleryFeedbackLauncher.m5032b(this.f4418a.f4419a.f4420a.f4425e, uri, graphQLFeedback2, entryPoint2, photoRemixCommentSource2), null, null);
                        }

                        protected final void m5022a(Throwable th) {
                            BLog.c(EditingGalleryFeedbackLauncher.f4433b, "Error saving photo", th);
                        }
                    }

                    C04081(C04091 c04091) {
                        this.f4419a = c04091;
                    }

                    protected final void m5023a(Object obj) {
                        ImmutableList immutableList = (ImmutableList) obj;
                        int a = SizeUtil.a(this.f4419a.f4420a.f4425e.f4436d, 180.0f);
                        int a2 = SizeUtil.a(this.f4419a.f4420a.f4425e.f4436d, 180.0f);
                        EditingGalleryFeedbackLauncher editingGalleryFeedbackLauncher = this.f4419a.f4420a.f4425e;
                        Builder b = new Builder().a(EditFeature.STICKER).b(EditFeature.FILTER);
                        b.f = true;
                        b = b;
                        b.l = this.f4419a.f4420a.f4425e.f4444l.m11726a(a, a2).m11723b(immutableList).m11722a(this.f4419a.f4420a.f4425e.f4442j.m11716a()).m11724b();
                        editingGalleryFeedbackLauncher.f4446n = b.a();
                        PhotoRemixSavePhotoUtils photoRemixSavePhotoUtils = this.f4419a.f4420a.f4425e.f4438f;
                        Uri uri = uri2;
                        C04071 c04071 = new C04071(this);
                        photoRemixSavePhotoUtils.c.d(ImageRequest.a(uri), PhotoRemixSavePhotoUtils.b).a(new 1(photoRemixSavePhotoUtils, c04071), photoRemixSavePhotoUtils.e);
                    }

                    protected final void m5024a(Throwable th) {
                        BLog.b(EditingGalleryFeedbackLauncher.f4433b, "Error fetching swipeable params", th);
                    }
                }

                C04091(C04101 c04101) {
                    this.f4420a = c04101;
                }

                public void run() {
                    Futures.a(this.f4420a.f4425e.f4443k.a(), new C04081(this), this.f4420a.f4425e.f4434a);
                }
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -913372324);
                ExecutorDetour.a(this.f4425e.f4434a, new C04091(this), 1995230958);
                Logger.a(2, EntryType.UI_INPUT_END, -948685424, a);
            }
        };
    }

    public static EditGalleryCallback m5032b(EditingGalleryFeedbackLauncher editingGalleryFeedbackLauncher, Uri uri, GraphQLFeedback graphQLFeedback, EntryPoint entryPoint, PhotoRemixCommentSource photoRemixCommentSource) {
        final Uri uri2 = uri;
        final GraphQLFeedback graphQLFeedback2 = graphQLFeedback;
        final PhotoRemixCommentSource photoRemixCommentSource2 = photoRemixCommentSource;
        final EntryPoint entryPoint2 = entryPoint;
        return new EditGalleryCallback(editingGalleryFeedbackLauncher) {
            final /* synthetic */ EditingGalleryFeedbackLauncher f4430e;
            private MediaItem f4431f;
            private CreativeEditingData f4432g = null;

            public final void mo221a(CreativeEditingData creativeEditingData) {
                Preconditions.checkNotNull(creativeEditingData);
                this.f4432g = creativeEditingData;
                Uri p = creativeEditingData.p();
                if (p == null) {
                    p = creativeEditingData.o();
                }
                if (p != null) {
                    this.f4431f = this.f4430e.f4435c.a(p, FallbackMediaId.REMOTE_MEDIA, Storage.INTERNAL);
                }
            }

            public final int mo220a(int i) {
                this.f4431f = this.f4430e.f4435c.a(uri2, FallbackMediaId.REMOTE_MEDIA);
                return i;
            }

            public final void mo222a(UsageParams usageParams, ExpirationState expirationState, boolean z) {
                if (this.f4431f != null) {
                    UFIServicesAnalyticsEventBuilder uFIServicesAnalyticsEventBuilder = this.f4430e.f4441i;
                    HoneyClientEvent a = UFIServicesAnalyticsEventBuilder.a(false, null, graphQLFeedback2.z_(), graphQLFeedback2.j(), null, "photo_remix");
                    a.a("photo_remix_source", photoRemixCommentSource2);
                    this.f4430e.f4440h.a(a);
                    FeedbackLoggingParams.Builder builder = new FeedbackLoggingParams.Builder();
                    builder.c = "photo_remix";
                    builder = builder;
                    builder.f = photoRemixCommentSource2;
                    builder = builder;
                    builder.e = NotificationSource.JEWEL;
                    FeedbackLoggingParams a2 = builder.a();
                    this.f4430e.f4439g.m11493a(SafeUUIDGenerator.a().toString()).m11492a(uri2.toString(), EditGalleryUsageLoggingUtils.m12203a(this.f4432g, entryPoint2, usageParams, z, this.f4431f.g()));
                    if (entryPoint2 == EntryPoint.PHOTO_REMIX_COMMENT_INPUT) {
                        FragmentManagerHost fragmentManagerHost = (FragmentManagerHost) ContextUtils.a(this.f4430e.f4436d, FragmentManagerHost.class);
                        if (fragmentManagerHost != null) {
                            UFIPopoverFragment uFIPopoverFragment = (UFIPopoverFragment) fragmentManagerHost.kO_().a("chromeless:content:fragment:tag");
                            if (uFIPopoverFragment != null) {
                                BaseFeedbackFragment baseFeedbackFragment = (BaseFeedbackFragment) uFIPopoverFragment.aD();
                                if (baseFeedbackFragment != null) {
                                    baseFeedbackFragment.aG.m4959a(a2);
                                    baseFeedbackFragment.aG.m4960a(this.f4431f);
                                    return;
                                }
                            }
                        }
                    }
                    FeedbackParams.Builder builder2 = new FeedbackParams.Builder();
                    builder2.a = graphQLFeedback2;
                    builder2 = builder2;
                    builder2.d = graphQLFeedback2.z_();
                    builder2 = builder2;
                    builder2.e = graphQLFeedback2.j();
                    builder2 = builder2;
                    builder2.l = this.f4431f;
                    builder2 = builder2;
                    builder2.g = a2;
                    this.f4430e.f4437e.a(this.f4430e.f4436d, builder2.a());
                }
            }
        };
    }
}
