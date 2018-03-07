package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.RichDocumentContextWrapper;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.richdocument.view.util.BlurryPreviewGenerator;
import com.facebook.richdocument.view.widget.media.MediaView;
import com.facebook.richdocument.view.widget.media.MediaViewDelegate;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: page_number */
public class RichDocumentImageView extends GenericDraweeView implements MediaView {
    private static final CallerContext f7311c = CallerContext.a(RichDocumentImageView.class, "unknown");
    @Inject
    FbDraweeControllerBuilder f7312a;
    @Inject
    BlurryPreviewGenerator f7313b;
    private CallerContext f7314d;
    private MediaViewDelegate f7315e;
    public boolean f7316f;
    private String f7317g;
    public ImageSetListener f7318h;

    /* compiled from: page_number */
    public interface ImageSetListener {
        void mo395a(RichDocumentImageView richDocumentImageView);

        void mo396b(RichDocumentImageView richDocumentImageView);
    }

    /* compiled from: page_number */
    class C08361 implements FutureCallback<Drawable> {
        final /* synthetic */ RichDocumentImageView f7309a;

        C08361(RichDocumentImageView richDocumentImageView) {
            this.f7309a = richDocumentImageView;
        }

        public void onSuccess(@Nullable Object obj) {
            Drawable drawable = (Drawable) obj;
            if (drawable != null) {
                ((GenericDraweeHierarchy) this.f7309a.getHierarchy()).b(drawable);
                ((GenericDraweeHierarchy) this.f7309a.getHierarchy()).a(RichDocumentUIConfig.f6541L);
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: page_number */
    class C08372 extends BaseControllerListener {
        final /* synthetic */ RichDocumentImageView f7310a;

        C08372(RichDocumentImageView richDocumentImageView) {
            this.f7310a = richDocumentImageView;
        }

        public final void m7574a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            boolean z;
            CloseableImage closeableImage = (CloseableImage) obj;
            RichDocumentImageView richDocumentImageView = this.f7310a;
            if (closeableImage != null) {
                z = true;
            } else {
                z = false;
            }
            richDocumentImageView.f7316f = z;
            if (animatable != null) {
                animatable.start();
            }
            if (this.f7310a.f7316f && this.f7310a.f7318h != null) {
                this.f7310a.f7318h.mo396b(this.f7310a);
            }
        }

        public final void m7575b(String str, @Nullable Object obj) {
            boolean z;
            CloseableImage closeableImage = (CloseableImage) obj;
            RichDocumentImageView richDocumentImageView = this.f7310a;
            if (closeableImage != null) {
                z = true;
            } else {
                z = false;
            }
            richDocumentImageView.f7316f = z;
            if (this.f7310a.f7316f && this.f7310a.f7318h != null) {
                this.f7310a.f7318h.mo395a(this.f7310a);
            }
        }
    }

    private static <T extends View> void m7577a(Class<T> cls, T t) {
        m7578a((Object) t, t.getContext());
    }

    private static void m7578a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RichDocumentImageView) obj).m7576a(FbDraweeControllerBuilder.b(fbInjector), BlurryPreviewGenerator.m7349b(fbInjector));
    }

    public RichDocumentImageView(Context context) {
        super(context);
        m7583e();
    }

    public RichDocumentImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7583e();
    }

    public RichDocumentImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7583e();
    }

    private void m7583e() {
        m7577a(RichDocumentImageView.class, (View) this);
        this.f7315e = new MediaViewDelegate(this);
        this.f7314d = f7311c;
        Class b = RichDocumentContextWrapper.m5023b(getContext());
        if (b != null) {
            this.f7314d = CallerContext.a(b, "unknown");
        }
    }

    public void setCallerContext(CallerContext callerContext) {
        if (callerContext != null) {
            this.f7314d = callerContext;
        }
    }

    public final void m7587c() {
        setVisibility(8);
        ((GenericDraweeHierarchy) getHierarchy()).a(0);
        this.f7316f = false;
        this.f7317g = null;
    }

    public final void m7585a(String str, int i, int i2) {
        if (str != null) {
            Futures.a(this.f7313b.m1810a(str, ((float) i) / ((float) i2)), new C08361(this));
            setVisibility(0);
            this.f7315e.f7604b = ((float) i) / ((float) i2);
        }
    }

    public final void m7586a(String str, int i, int i2, String str2) {
        this.f7317g = str;
        m7579a(str, str2);
        setVisibility(0);
        this.f7315e.f7604b = ((float) i) / ((float) i2);
    }

    public final void m7584a(ImageRequest imageRequest, int i, int i2) {
        if (imageRequest != null) {
            FbDraweeControllerBuilder controllerBuilder = getControllerBuilder();
            ImageRequest[] imageRequestArr = new ImageRequest[2];
            imageRequestArr[0] = imageRequest;
            if (this.f7317g != null) {
                ImageRequestBuilder a = ImageRequestBuilder.a(Uri.parse(this.f7317g));
                a.b = RequestLevel.DISK_CACHE;
                controllerBuilder.d(a.m());
                a = ImageRequestBuilder.a(Uri.parse(this.f7317g));
                a.b = RequestLevel.FULL_FETCH;
                imageRequestArr[1] = a.m();
            }
            controllerBuilder.c(null);
            controllerBuilder.a(imageRequestArr, false);
            setController(controllerBuilder.s());
            setVisibility(0);
            this.f7315e.f7604b = ((float) i) / ((float) i2);
        }
    }

    public void setFadeDuration(int i) {
        ((GenericDraweeHierarchy) getHierarchy()).a(i);
    }

    public void setImageSetListener(ImageSetListener imageSetListener) {
        this.f7318h = imageSetListener;
    }

    public final boolean ja_() {
        return this.f7316f;
    }

    protected void onMeasure(int i, int i2) {
        Rect a = this.f7315e.m7853a();
        super.onMeasure(MeasureSpec.makeMeasureSpec(a.width(), 1073741824), MeasureSpec.makeMeasureSpec(a.height(), 1073741824));
    }

    public float getMediaAspectRatio() {
        return this.f7315e.f7604b;
    }

    public View getView() {
        return this;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    private void m7579a(String str, String str2) {
        FbDraweeControllerBuilder controllerBuilder = getControllerBuilder();
        controllerBuilder.a(null, true);
        if (str != null) {
            controllerBuilder.b(Uri.parse(str));
        }
        if (str2 != null) {
            controllerBuilder.d(ImageRequest.a(str2));
        }
        setController(controllerBuilder.s());
    }

    private FbDraweeControllerBuilder getControllerBuilder() {
        return (FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f7312a.a(this.f7314d).b(getController())).a(new C08372(this));
    }

    private void m7576a(FbDraweeControllerBuilder fbDraweeControllerBuilder, BlurryPreviewGenerator blurryPreviewGenerator) {
        this.f7312a = fbDraweeControllerBuilder;
        this.f7313b = blurryPreviewGenerator;
    }
}
