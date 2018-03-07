package com.facebook.timeline.stagingground;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.ui.underwood.common.ButtonAnimator;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLModels.ProfileOverlayCategoryPageFieldsModel;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLModels.ImageOverlayWithSwipeableOverlaysModel;
import com.facebook.heisman.swipeable.FrameConversions;
import com.facebook.inject.Assisted;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.ipc.editgallery.EditGalleryIntentCreator;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration;
import com.facebook.ipc.editgallery.EditGalleryZoomCropParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.CreativeEditingData.Builder;
import com.facebook.photos.creativeediting.model.CreativeEditingDataUtil;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.photos.creativeediting.renderers.CreativeEditingPhotoOverlayView;
import com.facebook.photos.creativeediting.renderers.PhotoOverlayController;
import com.facebook.photos.creativeediting.renderers.PhotoOverlayController.OverlayType;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableFramesHScrollCirclePageIndicator;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableLayout;
import com.facebook.photos.creativeediting.utilities.CreativeEditingImageHelper;
import com.facebook.photos.crop.CropImageOverlay;
import com.facebook.photos.crop.ProfilePicZoomableImageView;
import com.facebook.photos.crop.ZoomableImageViewGestureListener;
import com.facebook.photos.crop.ZoomableImageViewGestureListener.OnTouchCallback;
import com.facebook.photos.editgallery.utils.CropImageUtils;
import com.facebook.photos.editgallery.utils.CropImageUtils.CropCallback;
import com.facebook.photos.editgallery.utils.CropImageUtilsProvider;
import com.facebook.photos.editgallery.utils.FetchImageUtils;
import com.facebook.qe.api.QeAccessor;
import com.facebook.resources.ui.FbButton;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.protocol.TimelineCommonGraphQL;
import com.facebook.timeline.protocol.TimelineCommonGraphQL.TimelinePhotoUriQueryString;
import com.facebook.timeline.protocol.TimelineCommonGraphQLModels.TimelinePhotoUriQueryModel;
import com.facebook.timeline.stagingground.StagingGroundController.C10701;
import com.facebook.timeline.tempprofilepic.ExpirationDialogController;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.LazyView;
import com.facebook.widget.SwitchCompat;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: failed to serialize model */
public class StagingGroundProfileImageController extends StagingGroundProfileMediaController {
    private CropImageUtils f14834A;
    public final StagingGroundSwipeableControllerProvider f14835B;
    public final GraphQLQueryExecutor f14836C;
    @Nullable
    public StagingGroundSwipeableController f14837D;
    @Inject
    private CreativeEditingImageHelper f14838E;
    private FrameLayout f14839F;
    public View f14840G;
    public FbDraweeView f14841H;
    public ProfilePicZoomableImageView f14842I;
    public CropImageOverlay f14843J;
    private CreativeEditingPhotoOverlayView f14844K;
    private PhotoOverlayController f14845L;
    public LazyView<CreativeEditingSwipeableLayout> f14846M;
    public LazyView<StagingGroundHScrollCirclePageIndicator> f14847N;
    public String f14848O;
    public String f14849P;
    public final boolean f14850Q;
    public boolean f14851R;
    @Inject
    volatile Provider<AllCapsTransformationMethod> f14852a = UltralightRuntime.a();
    @Inject
    volatile Provider<SecureContextHelper> f14853b = UltralightRuntime.a();
    @Inject
    public volatile Provider<BitmapUtils> f14854c = UltralightRuntime.a();
    @Inject
    volatile Provider<FetchImageUtils> f14855d = UltralightRuntime.a();
    public EditGalleryIpcBundle f14856t;
    public CreativeEditingData f14857u;
    public EditGalleryLaunchConfiguration f14858v;
    private boolean f14859w;
    @Nullable
    public ImageOverlayWithSwipeableOverlaysModel f14860x;
    @Nullable
    public ImageOverlayFieldsModel f14861y;
    private AbstractDisposableFutureCallback<Uri> f14862z;

    /* compiled from: failed to serialize model */
    class C10793 implements OnTouchCallback {
        final /* synthetic */ StagingGroundProfileImageController f14799a;

        C10793(StagingGroundProfileImageController stagingGroundProfileImageController) {
            this.f14799a = stagingGroundProfileImageController;
        }

        public final void mo546a() {
            StagingGroundProfileImageController.m18708m(this.f14799a);
        }
    }

    /* compiled from: failed to serialize model */
    class C10804 implements OnLayoutChangeListener {
        final /* synthetic */ StagingGroundProfileImageController f14800a;

        C10804(StagingGroundProfileImageController stagingGroundProfileImageController) {
            this.f14800a = stagingGroundProfileImageController;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.f14800a.f14851R) {
                StagingGroundProfileImageController.m18708m(this.f14800a);
            }
        }
    }

    /* compiled from: failed to serialize model */
    class C10815 implements CropCallback {
        final /* synthetic */ StagingGroundProfileImageController f14801a;

        C10815(StagingGroundProfileImageController stagingGroundProfileImageController) {
            this.f14801a = stagingGroundProfileImageController;
        }

        public final void mo595a(CreativeEditingData creativeEditingData) {
            this.f14801a.f14857u = creativeEditingData;
            this.f14801a.g = creativeEditingData.o();
            this.f14801a.m18721c();
        }

        public final void mo596a(Throwable th, CreativeEditingData creativeEditingData) {
            this.f14801a.f14830p.a("timeline_staging_ground", "Failed to crop profile picture preview");
            this.f14801a.m18721c();
        }
    }

    /* compiled from: failed to serialize model */
    class C10826 extends AbstractDisposableFutureCallback<Uri> {
        final /* synthetic */ StagingGroundProfileImageController f14802a;

        C10826(StagingGroundProfileImageController stagingGroundProfileImageController) {
            this.f14802a = stagingGroundProfileImageController;
        }

        protected final void m18676a(Object obj) {
            this.f14802a.g = (Uri) obj;
            StagingGroundProfileImageController.m18703a(this.f14802a, this.f14802a.f14821g);
        }

        protected final void m18677a(Throwable th) {
            this.f14802a.f14830p.a("timeline_staging_ground", "Failure saving");
        }
    }

    @Inject
    public StagingGroundProfileImageController(CropImageUtilsProvider cropImageUtilsProvider, @Assisted String str, Context context, AbstractFbErrorReporter abstractFbErrorReporter, StagingGroundSwipeableControllerProvider stagingGroundSwipeableControllerProvider, GraphQLQueryExecutor graphQLQueryExecutor, PhotoOverlayController photoOverlayController, Executor executor, @Assisted StagingGroundAnalyticsLogger stagingGroundAnalyticsLogger, QeAccessor qeAccessor) {
        super(context, abstractFbErrorReporter, executor, stagingGroundAnalyticsLogger, qeAccessor);
        this.f14835B = stagingGroundSwipeableControllerProvider;
        this.f14836C = graphQLQueryExecutor;
        this.f14834A = cropImageUtilsProvider.m12373a(str);
        this.f14850Q = this.f14833s.a(ExperimentsForTimelineAbTestModule.j, false);
        this.f14845L = photoOverlayController;
    }

    public final void mo1158a(FbFragmentActivity fbFragmentActivity, Bundle bundle, StagingGroundLaunchConfig stagingGroundLaunchConfig) {
        super.mo1158a(fbFragmentActivity, bundle, stagingGroundLaunchConfig);
        this.f14860x = stagingGroundLaunchConfig.f14780l;
        this.f14861y = stagingGroundLaunchConfig.f14781m;
        this.f14858v = (EditGalleryLaunchConfiguration) fbFragmentActivity.getIntent().getExtras().getParcelable("extra_edit_gallery_launch_settings");
        if (this.f14858v == null) {
            BLog.b(StagingGroundActivity.class, "EditGalleryLaunchConfiguration must be set");
            fbFragmentActivity.finish();
            return;
        }
        CreativeEditingData creativeEditingData;
        StagingGroundProfileImageController stagingGroundProfileImageController;
        if (bundle != null && bundle.getParcelable("creativeEditingDataKey") != null) {
            creativeEditingData = (CreativeEditingData) bundle.getParcelable("creativeEditingDataKey");
            stagingGroundProfileImageController = this;
        } else if (stagingGroundLaunchConfig.f14782n != null) {
            creativeEditingData = stagingGroundLaunchConfig.f14782n;
            stagingGroundProfileImageController = this;
        } else {
            creativeEditingData = new Builder().a();
            stagingGroundProfileImageController = this;
        }
        stagingGroundProfileImageController.f14857u = creativeEditingData;
        boolean z = (this.f14823i == null || this.f14824j == null) ? false : true;
        this.f14859w = z;
        if (bundle == null || !bundle.containsKey("didEnterCropKey")) {
            this.f14848O = "no_enter_crop_view";
        } else {
            this.f14848O = bundle.getString("didEnterCropKey");
        }
        if (bundle == null || !bundle.containsKey("didCropKey")) {
            this.f14849P = "no_crop";
        } else {
            this.f14849P = bundle.getString("didCropKey");
        }
    }

    public final void mo1154a() {
        if (this.f14862z != null) {
            this.f14862z.jc_();
        }
        if (this.f14837D != null) {
            StagingGroundSwipeableController stagingGroundSwipeableController = this.f14837D;
            if (stagingGroundSwipeableController.f14900o != null) {
                stagingGroundSwipeableController.f14900o.a(false);
            }
            stagingGroundSwipeableController.f14901p = true;
            this.f14837D = null;
        }
    }

    public final void mo1159a(final C10701 c10701) {
        if (this.f14821g == null) {
            Futures.a(this.f14836C.a(GraphQLRequest.a((TimelinePhotoUriQueryString) TimelineCommonGraphQL.a().a("photo_fbId", this.f14826l))), new FutureCallback<GraphQLResult<TimelinePhotoUriQueryModel>>(this) {
                final /* synthetic */ StagingGroundProfileImageController f14795b;

                public void onSuccess(@Nullable Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    if (graphQLResult == null || ((TimelinePhotoUriQueryModel) graphQLResult.e).a() == null || ((TimelinePhotoUriQueryModel) graphQLResult.e).a().b() == null) {
                        onFailure(new Throwable("Null result or uri was received"));
                        return;
                    }
                    this.f14795b.g = Uri.parse(((TimelinePhotoUriQueryModel) graphQLResult.e).a().b());
                    StagingGroundProfileImageController.m18706c(this.f14795b, c10701);
                }

                public void onFailure(Throwable th) {
                    Toast.makeText(this.f14795b.f14841H.getContext(), this.f14795b.f14841H.getResources().getString(2131237855), 1).show();
                    if (!(th instanceof IOException)) {
                        this.f14795b.f14830p.a("timeline_staging_ground", StringFormatUtil.formatStrLocaleSafe("Could not fetch network uri for fbId: %1$s", this.f14795b.f14826l), th);
                    }
                }
            }, DirectExecutor.INSTANCE);
            return;
        }
        m18706c(this, c10701);
    }

    public static void m18706c(StagingGroundProfileImageController stagingGroundProfileImageController, final C10701 c10701) {
        final BitmapUtils bitmapUtils = (BitmapUtils) stagingGroundProfileImageController.f14854c.get();
        stagingGroundProfileImageController.f14862z = new AbstractDisposableFutureCallback<Uri>(stagingGroundProfileImageController) {
            final /* synthetic */ StagingGroundProfileImageController f14798c;

            protected final void m18671a(Object obj) {
                Uri uri = (Uri) obj;
                this.f14798c.g = uri;
                if (this.f14798c.f14822h == null) {
                    this.f14798c.h = uri;
                }
                if (this.f14798c.f14824j == null) {
                    this.f14798c.j = BitmapUtils.a(this.f14798c.f14821g.getPath());
                }
                if (this.f14798c.f14823i == null) {
                    float f;
                    if (this.f14798c.f14824j.b > this.f14798c.f14824j.a) {
                        f = ((float) (this.f14798c.f14824j.b - this.f14798c.f14824j.a)) / 2.0f;
                        this.f14798c.i = new RectF(f / ((float) this.f14798c.f14824j.b), 0.0f, (f + ((float) this.f14798c.f14824j.a)) / ((float) this.f14798c.f14824j.b), 1.0f);
                        this.f14798c.f14849P = "auto_crop";
                    } else if (this.f14798c.f14824j.b < this.f14798c.f14824j.a) {
                        f = ((float) (this.f14798c.f14824j.a - this.f14798c.f14824j.b)) / 2.0f;
                        this.f14798c.i = new RectF(0.0f, f / ((float) this.f14798c.f14824j.a), 1.0f, (f + ((float) this.f14798c.f14824j.b)) / ((float) this.f14798c.f14824j.a));
                        this.f14798c.f14849P = "auto_crop";
                    } else {
                        this.f14798c.i = StagingGroundProfileMediaController.f14820f;
                        this.f14798c.f14849P = "no_crop";
                    }
                }
                if (this.f14798c.f14850Q) {
                    this.f14798c.f14849P = "force_enter_crop_view";
                }
                c10701.m18653a();
            }

            protected final void m18672a(Throwable th) {
                C10701 c10701 = c10701;
                BLog.b(StagingGroundController.class, "Failed to convert Uri to file scheme: %s", th);
                c10701.f14717b.finish();
            }
        };
        ((FetchImageUtils) stagingGroundProfileImageController.f14855d.get()).m12378a(stagingGroundProfileImageController.f14829o, stagingGroundProfileImageController.f14821g, stagingGroundProfileImageController.f14862z);
    }

    public final void mo1157a(View view) {
        if (this.f14850Q) {
            this.f14843J = new CropImageOverlay(this.f14829o, true);
            this.f14843J.f10066d = 0.9f;
            this.f14839F = (FrameLayout) view.findViewById(2131567600);
            this.f14839F.addView(this.f14843J);
            if (this.f14840G != null) {
                this.f14840G.bringToFront();
            }
            this.f14842I = (ProfilePicZoomableImageView) ((ViewStub) view.findViewById(2131567602)).inflate();
            this.f14842I.setMinBoundingRectRatio(0.9f);
        } else {
            this.f14841H = (FbDraweeView) ((ViewStub) view.findViewById(2131567601)).inflate();
        }
        ViewStub viewStub = (ViewStub) view.findViewById(2131567608);
        this.f14846M = new LazyView((ViewStub) view.findViewById(2131567603));
        this.f14847N = new LazyView(viewStub);
        if (this.f14861y != null) {
            this.f14837D = this.f14835B.m18766a((CreativeEditingSwipeableLayout) this.f14846M.a(), (SwipeableFramesHScrollCirclePageIndicator) this.f14847N.a());
            this.f14837D.m18764a(this.f14860x, this.f14861y, this.f14841H);
        }
    }

    public final void mo1161b() {
        if (this.f14850Q) {
            this.f14842I.setMaxScale((float) Math.min(this.f14824j.b / 180, this.f14824j.a / 180));
            this.f14842I.setOnTouchListener(new ZoomableImageViewGestureListener(this.f14842I, new C10793(this)));
            this.f14842I.addOnLayoutChangeListener(new C10804(this));
            this.f14844K = new CreativeEditingPhotoOverlayView(this.f14829o);
            this.f14844K.setId(2131558578);
            this.f14844K.f9581a = this.f14845L;
            m18708m(this);
        }
        if (this.f14859w || this.f14850Q) {
            m18721c();
        } else {
            m18702a(this, this.f14823i, new C10815(this));
        }
    }

    private void m18701a(ProfileOverlayCategoryPageFieldsModel profileOverlayCategoryPageFieldsModel) {
        ImageOverlayFieldsModel imageOverlayFieldsModel = (ImageOverlayFieldsModel) profileOverlayCategoryPageFieldsModel.m7978d().m7952a().get(0);
        this.f14837D = this.f14835B.m18766a((CreativeEditingSwipeableLayout) this.f14846M.a(), (SwipeableFramesHScrollCirclePageIndicator) this.f14847N.a());
        this.f14837D.m18764a(null, imageOverlayFieldsModel, this.f14841H);
    }

    public final void m18721c() {
        if (this.f14857u == null || !mo1163d()) {
            m18703a(this, this.f14821g);
        } else {
            m18704a(this, this.f14857u, this.f14821g, new C10826(this));
        }
    }

    public static void m18703a(StagingGroundProfileImageController stagingGroundProfileImageController, Uri uri) {
        if (stagingGroundProfileImageController.f14850Q) {
            stagingGroundProfileImageController.f14842I.setImageDrawable(Drawable.createFromPath(uri.getPath()));
        } else {
            stagingGroundProfileImageController.f14841H.a(uri, StagingGroundProfileMediaController.f14819e);
        }
    }

    public final OnToolbarButtonListener mo1153a(final FbFragmentActivity fbFragmentActivity, final ExpirationDialogController expirationDialogController) {
        return new OnToolbarButtonListener(this) {
            final /* synthetic */ StagingGroundProfileImageController f14811c;

            public final void m18684a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                this.f14811c.f14832r.m18648a(this.f14811c.f14827m, this.f14811c.f14826l, this.f14811c.mo1164e(), this.f14811c.f14849P, this.f14811c.f14848O, expirationDialogController.m18773a());
                final RectF k = StagingGroundProfileImageController.m18707k(this.f14811c);
                if (this.f14811c.f14850Q) {
                    StagingGroundProfileImageController.m18702a(this.f14811c, k, new CropCallback(this) {
                        final /* synthetic */ C10867 f14806b;

                        public final void mo595a(final CreativeEditingData creativeEditingData) {
                            StagingGroundProfileImageController.m18704a(this.f14806b.f14811c, creativeEditingData, creativeEditingData.o(), new AbstractDisposableFutureCallback<Uri>(this) {
                                final /* synthetic */ C10841 f14804b;

                                protected final void m18678a(Object obj) {
                                    EditGalleryIpcBundle.Builder a;
                                    Uri uri = (Uri) obj;
                                    if (this.f14804b.f14806b.f14811c.f14856t != null) {
                                        a = EditGalleryIpcBundle.Builder.a(this.f14804b.f14806b.f14811c.f14856t);
                                    } else {
                                        a = new EditGalleryIpcBundle.Builder();
                                        a.e = this.f14804b.f14806b.f14811c.f14826l;
                                        a = a;
                                    }
                                    StagingGroundProfileImageController stagingGroundProfileImageController = this.f14804b.f14806b.f14811c;
                                    a.d = creativeEditingData;
                                    a = a;
                                    a.a = uri;
                                    a = a;
                                    a.f = k;
                                    stagingGroundProfileImageController.f14856t = a.a();
                                    StagingGroundProfileImageController.m18705b(this.f14804b.f14806b.f14811c, fbFragmentActivity, expirationDialogController);
                                }

                                protected final void m18679a(Throwable th) {
                                    this.f14804b.f14806b.f14811c.f14830p.a("timeline_staging_ground", "Failure saving on USE button click");
                                }
                            });
                        }

                        public final void mo596a(Throwable th, CreativeEditingData creativeEditingData) {
                            this.f14806b.f14811c.f14830p.a("timeline_staging_ground", "Failure cropping on USE button click");
                        }
                    });
                    return;
                }
                if (this.f14811c.f14856t == null) {
                    StagingGroundProfileImageController stagingGroundProfileImageController = this.f14811c;
                    EditGalleryIpcBundle.Builder builder = new EditGalleryIpcBundle.Builder();
                    builder.d = this.f14811c.f14857u;
                    builder = builder;
                    builder.a = this.f14811c.f14821g;
                    builder = builder;
                    builder.e = this.f14811c.f14826l;
                    builder = builder;
                    builder.f = k;
                    stagingGroundProfileImageController.f14856t = builder.a();
                } else if (!this.f14811c.f14821g.equals(this.f14811c.f14856t.b)) {
                    StagingGroundProfileImageController stagingGroundProfileImageController2 = this.f14811c;
                    EditGalleryIpcBundle.Builder a = EditGalleryIpcBundle.Builder.a(this.f14811c.f14856t);
                    a.a = this.f14811c.f14821g;
                    stagingGroundProfileImageController2.f14856t = a.a();
                }
                if (this.f14811c.f14837D != null) {
                    Builder builder2;
                    if (this.f14811c.f14857u != null) {
                        builder2 = new Builder(this.f14811c.f14857u);
                    } else {
                        builder2 = new Builder();
                    }
                    final ImageOverlayFieldsModel a2 = this.f14811c.f14837D.m18763a();
                    StagingGroundProfileImageController stagingGroundProfileImageController3 = this.f14811c;
                    builder2.j = ImmutableList.of(FrameConversions.m8019a(a2));
                    stagingGroundProfileImageController3.f14857u = builder2.a();
                    StagingGroundProfileImageController.m18704a(this.f14811c, this.f14811c.f14857u, this.f14811c.f14821g, new AbstractDisposableFutureCallback<Uri>(this) {
                        final /* synthetic */ C10867 f14808b;

                        protected final void m18682a(Object obj) {
                            Uri uri = (Uri) obj;
                            StagingGroundProfileImageController stagingGroundProfileImageController = this.f14808b.f14811c;
                            EditGalleryIpcBundle.Builder a = EditGalleryIpcBundle.Builder.a(this.f14808b.f14811c.f14856t);
                            a.d = this.f14808b.f14811c.f14857u;
                            a = a;
                            a.a = uri;
                            a = a;
                            a.g = a2.c();
                            stagingGroundProfileImageController.f14856t = a.a();
                            StagingGroundProfileImageController.m18705b(this.f14808b.f14811c, fbFragmentActivity, expirationDialogController);
                        }

                        protected final void m18683a(Throwable th) {
                            this.f14808b.f14811c.f14830p.a("timeline_staging_grouund", "Failure applying profile pic frame on USE button click");
                        }
                    });
                    return;
                }
                StagingGroundProfileImageController.m18705b(this.f14811c, fbFragmentActivity, expirationDialogController);
            }
        };
    }

    public static void m18704a(StagingGroundProfileImageController stagingGroundProfileImageController, CreativeEditingData creativeEditingData, Uri uri, AbstractDisposableFutureCallback abstractDisposableFutureCallback) {
        Futures.a(stagingGroundProfileImageController.f14838E.a(1.0f, creativeEditingData, uri, false), abstractDisposableFutureCallback, stagingGroundProfileImageController.f14831q);
    }

    public static void m18702a(StagingGroundProfileImageController stagingGroundProfileImageController, RectF rectF, CropCallback cropCallback) {
        stagingGroundProfileImageController.f14834A.m12372a(stagingGroundProfileImageController.f14857u, stagingGroundProfileImageController.f14822h, stagingGroundProfileImageController.f14824j, rectF, cropCallback);
    }

    public static void m18705b(StagingGroundProfileImageController stagingGroundProfileImageController, FbFragmentActivity fbFragmentActivity, ExpirationDialogController expirationDialogController) {
        Intent intent = new Intent();
        intent.putExtra(EditGalleryIpcBundle.a, stagingGroundProfileImageController.f14856t);
        if (!StringUtil.a(stagingGroundProfileImageController.f14828n)) {
            intent.putExtra("staging_ground_photo_caption", stagingGroundProfileImageController.f14828n);
        }
        intent.putExtra("extra_profile_pic_expiration", expirationDialogController.m18773a());
        if (stagingGroundProfileImageController.f14837D != null) {
            FlatBufferModelHelper.a(intent, "staging_ground_selected_frame", stagingGroundProfileImageController.f14837D.m18763a());
        }
        SwitchCompat switchCompat = (SwitchCompat) fbFragmentActivity.findViewById(2131567613);
        if (switchCompat != null) {
            intent.putExtra("staging_ground_post_to_news_feed", switchCompat.isChecked());
        }
        fbFragmentActivity.setResult(-1, intent);
        fbFragmentActivity.finish();
    }

    public final void mo1162b(final View view) {
        if (this.f14833s.a(ExperimentsForTimelineAbTestModule.j, false)) {
            this.f14840G = view;
            this.f14840G.bringToFront();
            final int dimension = (int) this.f14829o.getResources().getDimension(2131431934);
            RectF rectF = this.f14843J.f10065c;
            if (rectF != null) {
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388691);
                layoutParams.setMargins(((int) rectF.left) + dimension, 0, ((int) rectF.left) + dimension, ((int) rectF.top) + dimension);
                view.setLayoutParams(layoutParams);
            }
            this.f14843J.addOnLayoutChangeListener(new OnLayoutChangeListener(this) {
                final /* synthetic */ StagingGroundProfileImageController f14814c;

                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    RectF hightedRect = this.f14814c.f14843J.getHightedRect();
                    LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388691);
                    layoutParams.setMargins(((int) hightedRect.left) + dimension, 0, ((int) hightedRect.left) + dimension, ((int) hightedRect.top) + dimension);
                    view.setLayoutParams(layoutParams);
                }
            });
        }
        if (this.f14833s.a(ExperimentsForTimelineAbTestModule.n, false)) {
            FbButton fbButton = (FbButton) view.findViewById(2131561125);
            CustomViewUtils.b(fbButton, this.f14829o.getResources().getDrawable(2130838475));
            new ButtonAnimator(ImmutableList.of(this.f14829o.getResources().getDrawable(2130838474), this.f14829o.getResources().getDrawable(2130838475)), fbButton).m2081a();
        }
    }

    public final OnClickListener mo1152a(final FbFragmentActivity fbFragmentActivity) {
        final SecureContextHelper secureContextHelper = (SecureContextHelper) this.f14853b.get();
        final AllCapsTransformationMethod allCapsTransformationMethod = (AllCapsTransformationMethod) this.f14852a.get();
        return new OnClickListener(this) {
            final /* synthetic */ StagingGroundProfileImageController f14818d;

            public void onClick(View view) {
                StickerParams a;
                int a2 = Logger.a(2, EntryType.UI_INPUT_START, -685325738);
                this.f14818d.f14832r.m18649b(this.f14818d.f14827m, this.f14818d.f14826l, this.f14818d.mo1164e());
                this.f14818d.f14848O = "enter_crop_view";
                if (this.f14818d.f14837D != null) {
                    a = FrameConversions.m8019a(this.f14818d.f14837D.m18763a());
                } else {
                    a = null;
                }
                EditGalleryZoomCropParams.Builder builder = new EditGalleryZoomCropParams.Builder();
                builder.a = StagingGroundProfileImageController.m18707k(this.f14818d);
                builder = builder;
                builder.b = a;
                EditGalleryZoomCropParams.Builder builder2 = builder;
                builder2.e = EditGalleryZoomCropParams.a;
                EditGalleryZoomCropParams a3 = builder2.a();
                Context context = this.f14818d.f14829o;
                String str = this.f14818d.f14825k;
                EditGalleryLaunchConfiguration.Builder builder3 = new EditGalleryLaunchConfiguration.Builder(this.f14818d.f14858v);
                builder3.j = this.f14818d.f14857u;
                builder3 = builder3.a(this.f14818d.f14822h, this.f14818d.f14826l);
                builder3.k = null;
                builder3 = builder3;
                builder3.f = false;
                builder3 = builder3;
                builder3.m = a3;
                EditGalleryLaunchConfiguration.Builder b = builder3.b(this.f14818d.f14827m);
                b.i = allCapsTransformationMethod.getTransformation(this.f14818d.f14829o.getString(2131237850), null).toString();
                secureContextHelper.a(EditGalleryIntentCreator.a(context, str, b.a()), 1, fbFragmentActivity);
                LogUtils.a(729582359, a2);
            }
        };
    }

    public static RectF m18707k(StagingGroundProfileImageController stagingGroundProfileImageController) {
        if (!stagingGroundProfileImageController.f14850Q) {
            return stagingGroundProfileImageController.f14823i;
        }
        RectF rectF = stagingGroundProfileImageController.f14843J.f10065c;
        RectF rectF2 = stagingGroundProfileImageController.f14842I.f10076h;
        RectF rectF3 = new RectF((rectF.left - rectF2.left) / rectF2.width(), (rectF.top - rectF2.top) / rectF2.height(), (rectF.right - rectF2.left) / rectF2.width(), (rectF.bottom - rectF2.top) / rectF2.height());
        rectF3.intersect(0.0f, 0.0f, 1.0f, 1.0f);
        return rectF3;
    }

    public static void m18708m(StagingGroundProfileImageController stagingGroundProfileImageController) {
        if (!stagingGroundProfileImageController.f14850Q) {
            return;
        }
        if (stagingGroundProfileImageController.f14857u == null || !stagingGroundProfileImageController.f14857u.k()) {
            stagingGroundProfileImageController.f14845L.m11533d();
            return;
        }
        RectF rectF = stagingGroundProfileImageController.f14842I.f10076h;
        if (rectF.width() == 0.0f || rectF.height() == 0.0f) {
            stagingGroundProfileImageController.f14851R = true;
            return;
        }
        stagingGroundProfileImageController.f14851R = false;
        LayoutParams layoutParams = new FrameLayout.LayoutParams((int) rectF.width(), (int) rectF.height());
        layoutParams.topMargin = (int) rectF.top;
        layoutParams.leftMargin = (int) rectF.left;
        stagingGroundProfileImageController.f14844K.setLayoutParams(layoutParams);
        if (stagingGroundProfileImageController.f14839F.findViewById(2131558578) == null) {
            stagingGroundProfileImageController.f14839F.addView(stagingGroundProfileImageController.f14844K);
            stagingGroundProfileImageController.f14843J.bringToFront();
            if (stagingGroundProfileImageController.f14840G != null) {
                stagingGroundProfileImageController.f14840G.bringToFront();
            }
        }
        stagingGroundProfileImageController.f14845L.mo500b();
        stagingGroundProfileImageController.f14845L.m11529a(stagingGroundProfileImageController.f14857u, (int) rectF.width(), (int) rectF.height(), 0, stagingGroundProfileImageController.f14844K, false, OverlayType.STICKERS, OverlayType.TEXTS, OverlayType.DOODLE);
    }

    public final boolean mo1163d() {
        return CreativeEditingDataUtil.a(this.f14857u);
    }

    @Nullable
    public final String mo1164e() {
        return (this.f14837D == null || this.f14837D.m18763a() == null) ? null : this.f14837D.m18763a().c();
    }

    final void m18717a(Provider<AllCapsTransformationMethod> provider, Provider<SecureContextHelper> provider2, Provider<BitmapUtils> provider3, Provider<FetchImageUtils> provider4, CreativeEditingImageHelper creativeEditingImageHelper) {
        this.f14852a = provider;
        this.f14853b = provider2;
        this.f14854c = provider3;
        this.f14855d = provider4;
        this.f14838E = creativeEditingImageHelper;
    }

    public final DialogInterface.OnClickListener mo1160b(final FbFragmentActivity fbFragmentActivity) {
        return new DialogInterface.OnClickListener(this) {
            final /* synthetic */ StagingGroundProfileImageController f14793b;

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.f14793b.f14857u = null;
                fbFragmentActivity.onBackPressed();
            }
        };
    }

    public final void mo1155a(Activity activity, int i, int i2, Intent intent) {
        if (i == 1) {
            if (i2 != -1) {
                this.f14832r.m18651d(this.f14827m, this.f14826l, mo1164e());
                return;
            }
            EditGalleryIpcBundle editGalleryIpcBundle = (EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a);
            if (!(this.f14850Q || this.f14823i.equals(editGalleryIpcBundle.g))) {
                this.f14849P = "user_crop";
            }
            StagingGroundAnalyticsLogger stagingGroundAnalyticsLogger = this.f14832r;
            String str = this.f14827m;
            String str2 = this.f14826l;
            String e = mo1164e();
            String str3 = this.f14849P;
            HoneyClientEventFast a = stagingGroundAnalyticsLogger.f14714a.a("staging_ground_use_edit", false);
            if (a.a()) {
                a.a(stagingGroundAnalyticsLogger.f14715b);
                a.a("heisman_composer_session_id", str);
                a.a("picture_id", str2);
                a.a("profile_pic_frame_id", e);
                a.a("use_cropping", str3);
                a.b();
            }
            this.f14856t = editGalleryIpcBundle;
            this.f14857u = editGalleryIpcBundle.e;
            if (this.f14850Q) {
                this.f14842I.setInitialZoomCropBounds(editGalleryIpcBundle.g);
                return;
            }
            Uri p;
            if (editGalleryIpcBundle.e.p() != null) {
                p = editGalleryIpcBundle.e.p();
            } else {
                p = editGalleryIpcBundle.b;
            }
            this.g = p;
            this.i = editGalleryIpcBundle.g;
            m18721c();
        } else if (i == 3 && i2 == -1) {
            m18701a((ProfileOverlayCategoryPageFieldsModel) Preconditions.checkNotNull((ProfileOverlayCategoryPageFieldsModel) FlatBufferModelHelper.a(intent, "heisman_profile_overlay_page")));
            this.f14858v = new EditGalleryLaunchConfiguration.Builder(this.f14858v).b(EditFeature.DOODLE).b(EditFeature.FILTER).b(EditFeature.TEXT).b(EditFeature.STICKER).a();
        }
    }

    public final void mo1156a(Bundle bundle) {
        super.mo1156a(bundle);
        bundle.putParcelable("creativeEditingDataKey", this.f14857u);
        bundle.putString("didCropKey", this.f14849P);
        bundle.putString("didEnterCropKey", this.f14848O);
    }

    public final void mo1165f() {
        m18708m(this);
    }

    public final void mo1166g() {
    }

    @StringRes
    public final int mo1167h() {
        return 2131237851;
    }
}
