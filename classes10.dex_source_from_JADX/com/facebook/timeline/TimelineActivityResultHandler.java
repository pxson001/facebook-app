package com.facebook.timeline;

import android.content.Intent;
import android.view.ViewGroup;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.composer.lifeevent.protocol.ComposerLifeEventParam;
import com.facebook.composer.publish.common.EditPostParams;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.content.event.FbEvent;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.photos.upload.event.BaseMediaUploadEvent.Status;
import com.facebook.photos.upload.event.LifeEventUploadEvent;
import com.facebook.photos.upload.event.LifeEventUploadEvent.LifeEventUploadEventSubscriber;
import com.facebook.places.checkin.launcher.PlacePickerResultHandler;
import com.facebook.platformattribution.result.PlatformAttributionResultController;
import com.facebook.privacy.audience.PostPrivacyUpsellDialogController;
import com.facebook.privacy.audience.PostPrivacyUpsellDialogController.EntryPoint;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reviews.util.intent.ReviewComposerLauncherAndHandler;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.coverphoto.activity.CoverPhotoRepositionActivityLauncher;
import com.facebook.timeline.coverphoto.activity.CoverPhotoRepositionActivityLauncherProvider;
import com.facebook.timeline.datafetcher.TimelineDataFetcher;
import com.facebook.timeline.event.TimelineStoryEventBus;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.editphotohelper.TimelineEditPhotoHelper;
import com.facebook.timeline.stories.TimelineStoryEvents.RedirectToPermalinkEvent;
import com.facebook.timeline.units.model.TimelineAllSectionsData;
import com.facebook.timeline.units.model.TimelineSectionLoadState;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: groups_single_page_mode */
public class TimelineActivityResultHandler {
    private static final Class<?> f10187a = TimelineActivityResultHandler.class;
    public final Provider<GraphQLCacheManager> f10188b;
    public final CoverPhotoRepositionActivityLauncherProvider f10189c;
    public final Provider<PlatformAttributionResultController> f10190d;
    private final Lazy<PostPrivacyUpsellDialogController> f10191e;
    private final Lazy<ReviewComposerLauncherAndHandler> f10192f;
    private final Provider<ReactionSessionManager> f10193g;
    public final PlacePickerResultHandler f10194h;
    public final Provider<Executor> f10195i;
    public final Provider<TimelineStoryEventBus> f10196j;
    public final TimelineAllSectionsData f10197k;
    public final TimelineFragment f10198l;
    public final TimelineContext f10199m;
    public final TimelineHeaderUserData f10200n;
    public final Supplier<TimelineEditPhotoHelper> f10201o;
    public final TimelineDataFetcher f10202p;
    @Nullable
    public CoverPhotoRepositionActivityLauncher f10203q;

    /* compiled from: groups_single_page_mode */
    public class C15012 implements FutureCallback<OperationResult> {
        final /* synthetic */ TimelineActivityResultHandler f10186a;

        public C15012(TimelineActivityResultHandler timelineActivityResultHandler) {
            this.f10186a = timelineActivityResultHandler;
        }

        public void onSuccess(Object obj) {
            ((TimelineStoryEventBus) this.f10186a.f10196j.get()).a(new RedirectToPermalinkEvent(this.f10186a.f10199m.d, ((OperationResult) obj).c));
        }

        public void onFailure(Throwable th) {
            if (this.f10186a.f10197k != null) {
                this.f10186a.f10197k.m12721a(TimelineSectionLoadState.FAILED);
                this.f10186a.f10198l.aC();
            }
            if (this.f10186a.f10202p != null) {
                this.f10186a.f10202p.m10562b().m10726e();
            }
        }
    }

    @Inject
    public TimelineActivityResultHandler(@Assisted TimelineFragment timelineFragment, @Assisted TimelineUserContext timelineUserContext, @Assisted TimelineHeaderUserData timelineHeaderUserData, @Assisted Supplier<TimelineEditPhotoHelper> supplier, @Assisted TimelineDataFetcher timelineDataFetcher, Provider<GraphQLCacheManager> provider, CoverPhotoRepositionActivityLauncherProvider coverPhotoRepositionActivityLauncherProvider, Provider<PlatformAttributionResultController> provider2, Lazy<PostPrivacyUpsellDialogController> lazy, Lazy<ReviewComposerLauncherAndHandler> lazy2, Provider<ReactionSessionManager> provider3, PlacePickerResultHandler placePickerResultHandler, Provider<Executor> provider4, Provider<TimelineStoryEventBus> provider5, TimelineAllSectionsData timelineAllSectionsData) {
        this.f10198l = timelineFragment;
        this.f10199m = timelineUserContext;
        this.f10200n = timelineHeaderUserData;
        this.f10201o = supplier;
        this.f10202p = timelineDataFetcher;
        this.f10188b = provider;
        this.f10189c = coverPhotoRepositionActivityLauncherProvider;
        this.f10190d = provider2;
        this.f10191e = lazy;
        this.f10192f = lazy2;
        this.f10193g = provider3;
        this.f10194h = placePickerResultHandler;
        this.f10195i = provider4;
        this.f10196j = provider5;
        this.f10197k = timelineAllSectionsData;
    }

    public final void m10265a(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 124:
                    m10262d(intent);
                    return;
                case 125:
                    m10261c(intent);
                    return;
                case 127:
                case 9916:
                    this.f10202p.m10555a().m10618d();
                    this.f10200n.g();
                    ((GraphQLCacheManager) this.f10188b.get()).a(Sets.a(new String[]{"CoverImageRequest"}));
                    this.f10198l.aC();
                    return;
                case 130:
                    this.f10198l.mo470e();
                    return;
                case 1004:
                    ((PlatformAttributionResultController) this.f10190d.get()).a(i, i2, intent);
                    return;
                case 1756:
                case 1758:
                    m10264f(intent);
                    return;
                case 1759:
                    m10258a(i2, intent);
                    return;
                case 1760:
                    m10263e(intent);
                    return;
                case 1821:
                case 1822:
                    this.f10202p.m10555a().m10614a(1);
                    return;
                case 1823:
                    this.f10198l.mo470e();
                    return;
                case 1856:
                    m10259a(intent);
                    return;
                case 5002:
                    this.f10194h.a(intent);
                    return;
                case 9915:
                    ((GraphQLCacheManager) this.f10188b.get()).a(Sets.a(new String[]{"ProfileImageRequest"}));
                    if (!intent.getBooleanExtra("camera_roll", false)) {
                        intent.putExtra("profile_photo_method_extra", "existing");
                    }
                    ((TimelineEditPhotoHelper) this.f10201o.get()).a(intent.getExtras());
                    return;
                case 22243:
                    ((GraphQLCacheManager) this.f10188b.get()).a(Sets.a(new String[]{"ProfileImageRequest"}));
                    ((GraphQLCacheManager) this.f10188b.get()).a(Sets.a(new String[]{"CoverImageRequest"}));
                    this.f10198l.mo470e();
                    return;
                default:
                    BLog.b(f10187a, "Unexpected request code received " + i);
                    return;
            }
        }
    }

    private void m10259a(Intent intent) {
        GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) FlatBufferModelHelper.a(intent, "privacy_option_to_upsell");
        if (graphQLPrivacyOption != null) {
            ((PostPrivacyUpsellDialogController) this.f10191e.get()).a(this.f10198l.getContext(), (ViewGroup) this.f10198l.T, graphQLPrivacyOption, EntryPoint.TIMELINE);
        }
    }

    private void m10261c(Intent intent) {
        if (intent.getData() != null) {
            TimelineEditPhotoHelper timelineEditPhotoHelper = (TimelineEditPhotoHelper) this.f10201o.get();
            timelineEditPhotoHelper.j.a(timelineEditPhotoHelper.b.o(), SafeUUIDGenerator.a().toString(), intent.getData(), 3, 130, null, null, 0);
            return;
        }
        ((GraphQLCacheManager) this.f10188b.get()).a(Sets.a(new String[]{"ProfileImageRequest"}));
        ((TimelineEditPhotoHelper) this.f10201o.get()).a(intent.getExtras());
    }

    private void m10262d(Intent intent) {
        ((GraphQLCacheManager) this.f10188b.get()).a(Sets.a(new String[]{"CoverImageRequest"}));
        if (this.f10199m != null) {
            Preconditions.checkArgument(this.f10199m != null);
            if (this.f10203q == null) {
                this.f10203q = this.f10189c.a(Long.valueOf(this.f10199m.b));
            }
            this.f10203q.a(this.f10198l, intent, false);
        }
    }

    private void m10263e(Intent intent) {
        TimelineFragment timelineFragment = this.f10198l;
        if (timelineFragment.cJ == null) {
            timelineFragment.cJ = new LifeEventUploadEventSubscriber(timelineFragment) {
                final /* synthetic */ TimelineFragment f10225a;

                {
                    this.f10225a = r1;
                }

                public final void m10283b(FbEvent fbEvent) {
                    final LifeEventUploadEvent lifeEventUploadEvent = (LifeEventUploadEvent) fbEvent;
                    if (lifeEventUploadEvent.a.w != null && this.f10225a.cf.b == Long.parseLong(lifeEventUploadEvent.a.w.userId)) {
                        this.f10225a.o().runOnUiThread(new Runnable(this) {
                            final /* synthetic */ AnonymousClass20 f10224b;

                            public void run() {
                                if (lifeEventUploadEvent.b == Status.UPLOAD_SUCCESS && this.f10224b.f10225a.bD != null) {
                                    this.f10224b.f10225a.bD.m10565c();
                                } else if (lifeEventUploadEvent.b == Status.UPLOAD_FAILED && this.f10224b.f10225a.aH != null) {
                                    this.f10224b.f10225a.aH.m12721a(TimelineSectionLoadState.FAILED);
                                    this.f10224b.f10225a.aC();
                                }
                                if (lifeEventUploadEvent.a != null && lifeEventUploadEvent.a.w != null && lifeEventUploadEvent.a.w.startDate != null) {
                                    ((TimelineStoryEventBus) this.f10224b.f10225a.aq.get()).a(new RedirectToPermalinkEvent(this.f10224b.f10225a.cf.d, lifeEventUploadEvent.a));
                                } else if (this.f10224b.f10225a.bD != null) {
                                    this.f10224b.f10225a.bD.m10562b().m10726e();
                                }
                                ((ReactionSessionManager) this.f10224b.f10225a.aW.get()).b(lifeEventUploadEvent.a.w.composerSessionId, this.f10224b.f10225a);
                            }
                        });
                    }
                }
            };
            timelineFragment.ce.a(timelineFragment.cJ);
        }
        if (intent.getBooleanExtra("is_uploading_media", false)) {
            if (this.f10198l.mx_()) {
                this.f10197k.m12721a(TimelineSectionLoadState.LOADING);
                this.f10198l.aC();
            }
            this.f10202p.m10562b().m10727f();
            this.f10198l.m10316h(this.f10198l.bC.m12061d());
            return;
        }
        if (this.f10198l.mx_()) {
            this.f10197k.m12721a(TimelineSectionLoadState.LOADING);
            this.f10198l.aC();
        }
        this.f10202p.m10562b().m10727f();
        ListenableFuture d = this.f10198l.aG().d(intent);
        ComposerLifeEventParam composerLifeEventParam = (ComposerLifeEventParam) intent.getParcelableExtra("publishLifeEventParams");
        if (composerLifeEventParam.startDate != null) {
            Futures.a(d, new C15012(this), (Executor) this.f10195i.get());
        } else {
            m10260a(d, true);
        }
        ((ReactionSessionManager) this.f10193g.get()).a(composerLifeEventParam.composerSessionId);
    }

    private void m10264f(Intent intent) {
        this.f10198l.aM();
        if (intent.getBooleanExtra("is_uploading_media", false)) {
            this.f10198l.aG().c(intent);
        } else {
            if (this.f10198l.mx_() && intent.hasExtra("publishPostParams")) {
                this.f10197k.m12721a(TimelineSectionLoadState.LOADING);
                this.f10198l.aC();
            }
            this.f10202p.m10562b().m10727f();
            m10260a(this.f10198l.aG().c(intent), false);
        }
        if (intent.hasExtra("publishPostParams")) {
            PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
            ((ReactionSessionManager) this.f10193g.get()).a(publishPostParams.composerSessionId);
            this.f10198l.aN();
            if (publishPostParams.composerType != ComposerType.SHARE) {
                this.f10198l.m10316h(this.f10198l.bC.m12061d());
                return;
            }
            return;
        }
        EditPostParams editPostParams = (EditPostParams) intent.getParcelableExtra("publishEditPostParamsKey");
        if (editPostParams.cacheIds != null && !editPostParams.cacheIds.isEmpty()) {
            this.f10198l.at().m12724a((String) editPostParams.cacheIds.get(0), editPostParams.legacyStoryApiId, editPostParams.composerSessionId, StoryVisibility.GONE);
        }
    }

    private void m10258a(int i, Intent intent) {
        int i2 = i;
        Intent intent2 = intent;
        ((ReviewComposerLauncherAndHandler) this.f10192f.get()).a(i2, intent2, "story_view", Absent.INSTANCE, Optional.of(this.f10198l.getContext()));
    }

    private void m10260a(ListenableFuture<OperationResult> listenableFuture, final boolean z) {
        Futures.a(listenableFuture, new FutureCallback<OperationResult>(this) {
            final /* synthetic */ TimelineActivityResultHandler f10185b;

            public void onSuccess(Object obj) {
                if (this.f10185b.f10202p != null) {
                    this.f10185b.f10202p.m10565c();
                    this.f10185b.f10202p.m10562b().m10726e();
                }
                if (z) {
                    this.f10185b.f10198l.m10316h(this.f10185b.f10198l.bC.m12061d());
                }
                this.f10185b.f10197k.m12721a(TimelineSectionLoadState.COMPLETED);
                this.f10185b.f10198l.aC();
            }

            public void onFailure(Throwable th) {
                if (this.f10185b.f10197k != null) {
                    this.f10185b.f10197k.m12721a(TimelineSectionLoadState.FAILED);
                    this.f10185b.f10198l.aC();
                }
                if (this.f10185b.f10202p != null) {
                    this.f10185b.f10202p.m10562b().m10726e();
                }
            }
        }, (Executor) this.f10195i.get());
    }
}
