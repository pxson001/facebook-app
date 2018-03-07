package com.facebook.messaging.photos.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThreadImmediate;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.messaging.media.download.MediaDownloadServiceHandler;
import com.facebook.messaging.media.download.PhotoDownloadDestination;
import com.facebook.messaging.media.imagepipelinewrapper.ImagePipelineWrapper;
import com.facebook.messaging.photos.service.MediaMessageItem;
import com.facebook.samples.zoomable.ZoomableDraweeView;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.CustomViewGroup;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: registration_profile_pic_step_shown */
public class PhotoMessageView extends CustomViewGroup {
    public static final Class<?> f3601g = PhotoMessageView.class;
    public static final CallerContext f3602h = CallerContext.a(PhotoMessageView.class, "photo_message_view");
    @Inject
    FbDraweeControllerBuilder f3603a;
    @Inject
    AnalyticsTagger f3604b;
    @Inject
    public GatekeeperStoreImpl f3605c;
    @Inject
    ImagePipelineWrapper f3606d;
    @DefaultExecutorService
    @Inject
    ListeningExecutorService f3607e;
    @Inject
    @ForUiThreadImmediate
    Executor f3608f;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MediaDownloadServiceHandler> f3609i = UltralightRuntime.b;
    public ZoomableDraweeView f3610j;
    public PhotoViewZoomableController f3611k;

    public static void m3426a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PhotoMessageView) obj).m3425a(FbDraweeControllerBuilder.b(fbInjector), AnalyticsTagger.a(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector), ImagePipelineWrapper.a(fbInjector), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(fbInjector), IdBasedLazy.a(fbInjector, 7909));
    }

    private void m3425a(FbDraweeControllerBuilder fbDraweeControllerBuilder, AnalyticsTagger analyticsTagger, GatekeeperStore gatekeeperStore, ImagePipelineWrapper imagePipelineWrapper, ListeningExecutorService listeningExecutorService, Executor executor, com.facebook.inject.Lazy<MediaDownloadServiceHandler> lazy) {
        this.f3603a = fbDraweeControllerBuilder;
        this.f3604b = analyticsTagger;
        this.f3605c = gatekeeperStore;
        this.f3606d = imagePipelineWrapper;
        this.f3607e = listeningExecutorService;
        this.f3608f = executor;
        this.f3609i = lazy;
    }

    public PhotoMessageView(Context context) {
        super(context);
        Class cls = PhotoMessageView.class;
        m3426a(this, getContext());
        setContentView(2130905821);
        this.f3610j = (ZoomableDraweeView) getView(2131565048);
        AnalyticsTagger.a(this, f3602h);
        AutoRotateDrawable autoRotateDrawable = new AutoRotateDrawable(context.getResources().getDrawable(2130844043), 1000);
        Resources resources = getResources();
        this.f3611k = new PhotoViewZoomableController();
        GenericDraweeHierarchyBuilder e = new GenericDraweeHierarchyBuilder(resources).e(ScaleType.c);
        e.d = 0;
        e = e;
        e.l = autoRotateDrawable;
        GenericDraweeHierarchy u = e.u();
        this.f3610j.setZoomableController(this.f3611k);
        this.f3610j.setHierarchy(u);
    }

    public static FbDraweeControllerBuilder m3427b(PhotoMessageView photoMessageView, MediaMessageItem mediaMessageItem) {
        ImageRequest imageRequest;
        final Uri d = mediaMessageItem.d();
        ((FbDraweeControllerBuilder) photoMessageView.f3603a.a(f3602h).b(photoMessageView.f3610j.getController())).r().a(new BaseControllerListener(photoMessageView) {
            final /* synthetic */ PhotoMessageView f3596b;

            public final void m3423a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
                if (animatable != null) {
                    animatable.start();
                }
            }

            public final void m3424b(String str, Throwable th) {
                super.b(str, th);
                BLog.c(PhotoMessageView.f3601g, th, "PhotoMessageView failed to load uri: %s", new Object[]{d});
            }
        });
        if (mediaMessageItem == null || mediaMessageItem.e() == null || StringUtil.a(mediaMessageItem.e().u) || !photoMessageView.f3605c.a(241, false)) {
            imageRequest = null;
        } else {
            File a = ((MediaDownloadServiceHandler) photoMessageView.f3609i.get()).a(mediaMessageItem.e().u, PhotoDownloadDestination.GALLERY);
            imageRequest = a != null ? ImageRequest.a(Uri.fromFile(a)) : null;
        }
        ImageRequest imageRequest2 = imageRequest;
        ImageRequestBuilder a2 = ImageRequestBuilder.a(d);
        a2.g = true;
        ImageRequest m = a2.m();
        if (imageRequest2 != null) {
            photoMessageView.f3603a.a(new ImageRequest[]{imageRequest2, m});
        } else {
            photoMessageView.f3603a.c(m);
        }
        return photoMessageView.f3606d.a(photoMessageView.f3603a);
    }

    public void setPhotoMessageItem(final MediaMessageItem mediaMessageItem) {
        if (this.f3606d.a()) {
            Futures.a(this.f3607e.a(new Callable<FbDraweeControllerBuilder>(this) {
                final /* synthetic */ PhotoMessageView f3598b;

                public Object call() {
                    return PhotoMessageView.m3427b(this.f3598b, mediaMessageItem);
                }
            }), new FutureCallback<FbDraweeControllerBuilder>(this) {
                final /* synthetic */ PhotoMessageView f3600b;

                public void onSuccess(@Nullable Object obj) {
                    FbDraweeControllerBuilder fbDraweeControllerBuilder = (FbDraweeControllerBuilder) obj;
                    if (fbDraweeControllerBuilder != null) {
                        this.f3600b.f3610j.setController(fbDraweeControllerBuilder.s());
                    }
                }

                public void onFailure(Throwable th) {
                    BLog.b(PhotoMessageView.f3601g, th, "Failed to get FbDraweeControllerBuilder from ImagePipelineWrapper. Image=%s", new Object[]{mediaMessageItem.d()});
                }
            }, this.f3608f);
        } else {
            this.f3610j.setController(m3427b(this, mediaMessageItem).s());
        }
    }
}
