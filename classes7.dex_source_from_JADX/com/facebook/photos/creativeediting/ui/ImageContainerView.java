package com.facebook.photos.creativeediting.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.imageprocessing.FiltersRepeatedPostprocessor;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mMediaModel */
public class ImageContainerView extends CustomFrameLayout {
    private static final CallerContext f9960a = CallerContext.a(ImageContainerView.class, "stickers_in_composer");
    private final DraweeHolder<GenericDraweeHierarchy> f9961b;
    private final GenericDraweeHierarchy f9962c;
    public Provider<FbDraweeControllerBuilder> f9963d;
    private Drawable f9964e;
    private int f9965f;
    private int f9966g;
    private int f9967h;
    private int f9968i;
    public ImageContainerListener f9969j;
    @Nullable
    public FiltersRepeatedPostprocessor f9970k;

    /* compiled from: mMediaModel */
    public interface ImageContainerListener {
        void mo507a();
    }

    /* compiled from: mMediaModel */
    class C08321 extends BaseControllerListener {
        final /* synthetic */ ImageContainerView f9959a;

        C08321(ImageContainerView imageContainerView) {
            this.f9959a = imageContainerView;
        }

        public final void m11914b(String str, @Nullable Object obj) {
            if (this.f9959a.f9970k != null && this.f9959a.f9970k.d()) {
                this.f9959a.f9970k.e();
            }
            this.f9959a.f9969j.mo507a();
        }

        public final void m11912a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            this.f9959a.f9969j.mo507a();
        }

        public final void m11913a(String str, Throwable th) {
            if (this.f9959a.f9970k != null) {
                this.f9959a.f9970k.e();
            }
        }
    }

    private static <T extends View> void m11917a(Class<T> cls, T t) {
        m11918a((Object) t, t.getContext());
    }

    private static void m11918a(Object obj, Context context) {
        ((ImageContainerView) obj).f9963d = IdBasedProvider.a(FbInjector.get(context), 1117);
    }

    public ImageContainerView(Context context) {
        super(context);
        m11916a();
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
        genericDraweeHierarchyBuilder.d = 0;
        genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder.e(ScaleType.c);
        genericDraweeHierarchyBuilder.f = new AutoRotateDrawable(getResources().getDrawable(2130844043), 1000);
        this.f9962c = genericDraweeHierarchyBuilder.u();
        this.f9961b = DraweeHolder.a(this.f9962c, getContext());
    }

    public ImageContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11916a();
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
        genericDraweeHierarchyBuilder.d = 0;
        genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder.e(ScaleType.c);
        genericDraweeHierarchyBuilder.f = new AutoRotateDrawable(getResources().getDrawable(2130844043), 1000);
        this.f9962c = genericDraweeHierarchyBuilder.u();
        this.f9961b = DraweeHolder.a(this.f9962c, getContext());
    }

    public ImageContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11916a();
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
        genericDraweeHierarchyBuilder.d = 0;
        genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder.e(ScaleType.c);
        genericDraweeHierarchyBuilder.f = new AutoRotateDrawable(getResources().getDrawable(2130844043), 1000);
        this.f9962c = genericDraweeHierarchyBuilder.u();
        this.f9961b = DraweeHolder.a(this.f9962c, getContext());
    }

    @Inject
    private void m11919a(Provider<FbDraweeControllerBuilder> provider) {
        this.f9963d = provider;
    }

    private void m11916a() {
        m11917a(ImageContainerView.class, (View) this);
    }

    public final void m11922a(Uri uri, int i, int i2, FiltersRepeatedPostprocessor filtersRepeatedPostprocessor, ImageContainerListener imageContainerListener) {
        this.f9969j = imageContainerListener;
        this.f9967h = i;
        this.f9968i = i2;
        this.f9970k = filtersRepeatedPostprocessor;
        FbDraweeControllerBuilder fbDraweeControllerBuilder = (FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f9963d.get()).a(f9960a).a(getControllerListener());
        ImageRequestBuilder a = ImageRequestBuilder.a(uri);
        a.d = new ResizeOptions(this.f9967h, this.f9968i);
        a = a;
        a.j = filtersRepeatedPostprocessor;
        this.f9961b.a(((FbDraweeControllerBuilder) fbDraweeControllerBuilder.c(a.m())).s());
        this.f9964e = this.f9961b.h();
        this.f9964e.setCallback(this);
    }

    private ControllerListener<ImageInfo> getControllerListener() {
        return new C08321(this);
    }

    public Rect getBounds() {
        return this.f9964e.getBounds();
    }

    private int m11920b() {
        return (getResources().getDimensionPixelSize(2131429548) + getResources().getDimensionPixelSize(2131429549)) + getResources().getDimensionPixelSize(2131429550);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1078867242);
        super.onAttachedToWindow();
        this.f9961b.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1692158097, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f9961b.d();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f9961b.b();
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1590242347);
        super.onDetachedFromWindow();
        this.f9961b.d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1133884324, a);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f9964e.draw(canvas);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable) || this.f9964e == drawable) {
            return true;
        }
        return false;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f9964e != null) {
            int dimensionPixelSize = (i4 - getResources().getDimensionPixelSize(2131431904)) - m11920b();
            double d = ((double) this.f9967h) / ((double) this.f9968i);
            this.f9965f = i3 - (getResources().getDimensionPixelSize(2131431903) * 2);
            this.f9966g = (int) (((double) this.f9965f) / d);
            if (this.f9966g > dimensionPixelSize) {
                this.f9966g = dimensionPixelSize;
                this.f9965f = (int) (((double) this.f9966g) * d);
            }
            int i5 = i3 / 2;
            dimensionPixelSize = (i4 - m11920b()) / 2;
            this.f9964e.setBounds(i5 - (this.f9965f / 2), dimensionPixelSize - (this.f9966g / 2), i5 + (this.f9965f / 2), dimensionPixelSize + (this.f9966g / 2));
        }
    }
}
