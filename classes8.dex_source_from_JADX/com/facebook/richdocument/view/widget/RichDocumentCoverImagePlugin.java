package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThreadImmediate;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.minipreview.MiniPreviewCoverPhotoProcessor;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: offers_detail_page */
public class RichDocumentCoverImagePlugin extends CoverImagePlugin {
    private static final CallerContext f7304n = CallerContext.a(RichDocumentImageView.class, "unknown");
    @Inject
    public FbDraweeControllerBuilder f7305d;
    @Inject
    @ForUiThreadImmediate
    public Executor f7306l;
    @Inject
    public MiniPreviewCoverPhotoProcessor f7307m;
    public final RichDocumentVideoPlayer f7308o;

    /* compiled from: offers_detail_page */
    class C08341 extends BaseControllerListener {
        final /* synthetic */ RichDocumentCoverImagePlugin f7298a;

        C08341(RichDocumentCoverImagePlugin richDocumentCoverImagePlugin) {
            this.f7298a = richDocumentCoverImagePlugin;
        }

        public final void m7571a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            this.f7298a.f7308o.setCoverImageLoaded(((CloseableImage) obj) != null);
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    /* compiled from: offers_detail_page */
    public class C08352 implements FutureCallback<Drawable> {
        final /* synthetic */ RichDocumentCoverImagePlugin f7299a;

        public C08352(RichDocumentCoverImagePlugin richDocumentCoverImagePlugin) {
            this.f7299a = richDocumentCoverImagePlugin;
        }

        public void onSuccess(@javax.annotation.Nullable Object obj) {
            Drawable drawable = (Drawable) obj;
            if (drawable != null) {
                ((GenericDraweeHierarchy) this.f7299a.a.getHierarchy()).b(drawable);
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: offers_detail_page */
    public class RichDocumentCoverImageParams {
        public final String f7300a;
        public final int f7301b;
        public final int f7302c;
        public final ImageRequest f7303d;

        public RichDocumentCoverImageParams(String str, String str2, int i, int i2) {
            this.f7303d = ImageRequest.a(Uri.parse(str));
            this.f7300a = str2;
            this.f7301b = i;
            this.f7302c = i2;
        }
    }

    public static void m7572a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RichDocumentCoverImagePlugin richDocumentCoverImagePlugin = (RichDocumentCoverImagePlugin) obj;
        FbDraweeControllerBuilder b = FbDraweeControllerBuilder.b(fbInjector);
        Executor executor = (Executor) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(fbInjector);
        MiniPreviewCoverPhotoProcessor a = MiniPreviewCoverPhotoProcessor.m1807a(fbInjector);
        richDocumentCoverImagePlugin.f7305d = b;
        richDocumentCoverImagePlugin.f7306l = executor;
        richDocumentCoverImagePlugin.f7307m = a;
    }

    public RichDocumentCoverImagePlugin(Context context, RichDocumentVideoPlayer richDocumentVideoPlayer) {
        super(context);
        Class cls = RichDocumentCoverImagePlugin.class;
        m7572a((Object) this, getContext());
        this.f7308o = richDocumentVideoPlayer;
    }

    protected final void m7573a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.a(richVideoPlayerParams, z);
        Object obj = richVideoPlayerParams.b.get("CoverImageParamsKey");
        if (obj instanceof RichDocumentCoverImageParams) {
            RichDocumentCoverImageParams richDocumentCoverImageParams = (RichDocumentCoverImageParams) obj;
            this.a.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f7305d.a(f7304n).c(richDocumentCoverImageParams.f7303d)).b(this.a.getController())).a(new C08341(this))).s());
            String str = richDocumentCoverImageParams.f7300a;
            int i = richDocumentCoverImageParams.f7301b;
            int i2 = richDocumentCoverImageParams.f7302c;
            if (str != null) {
                Futures.a(this.f7307m.m1810a(str, ((float) i) / ((float) i2)), new C08352(this), this.f7306l);
            }
        }
    }
}
