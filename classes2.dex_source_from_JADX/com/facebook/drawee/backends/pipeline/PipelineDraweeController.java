package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.LightBitmapDrawable;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactoryImpl;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: message_cap_optin */
public class PipelineDraweeController extends AbstractDraweeController<CloseableReference<CloseableImage>, ImageInfo> {
    private static final Class<?> f14353a = PipelineDraweeController.class;
    private static boolean f14354d;
    private static boolean f14355e;
    public final Resources f14356b;
    private final AnimatedDrawableFactoryImpl f14357c;
    private LightBitmapDrawable f14358f;
    public Supplier<DataSource<CloseableReference<CloseableImage>>> f14359g;

    protected final Object mo2767b(Object obj) {
        CloseableReference closeableReference = (CloseableReference) obj;
        Preconditions.b(CloseableReference.m15679a(closeableReference));
        return (CloseableImage) closeableReference.m15682a();
    }

    protected final int mo2769c(@Nullable Object obj) {
        CloseableReference closeableReference = (CloseableReference) obj;
        return closeableReference != null ? closeableReference.m15686e() : 0;
    }

    protected final void mo2770d(@Nullable Object obj) {
        CloseableReference.m15681c((CloseableReference) obj);
    }

    public PipelineDraweeController(Resources resources, DeferredReleaser deferredReleaser, AnimatedDrawableFactory animatedDrawableFactory, Executor executor, Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, Object obj) {
        super(deferredReleaser, executor, str, obj);
        this.f14356b = resources;
        this.f14357c = animatedDrawableFactory;
        this.f14359g = supplier;
    }

    public final void m20722a(Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, Object obj) {
        super.m20743a(str, obj);
        this.f14359g = supplier;
    }

    protected DataSource<CloseableReference<CloseableImage>> mo2766n() {
        if (FLog.a(2)) {
            Integer.valueOf(System.identityHashCode(this));
        }
        return (DataSource) this.f14359g.mo2058a();
    }

    protected Drawable mo2760a(CloseableReference<CloseableImage> closeableReference) {
        Preconditions.b(CloseableReference.m15679a((CloseableReference) closeableReference));
        CloseableImage closeableImage = (CloseableImage) closeableReference.m15682a();
        if (closeableImage instanceof CloseableStaticBitmap) {
            Drawable drawable;
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
            if (f14354d) {
                if (!f14355e || this.f14358f == null) {
                    this.f14358f = new LightBitmapDrawable(this.f14356b, closeableStaticBitmap.mo2979a());
                } else {
                    this.f14358f.a(closeableStaticBitmap.mo2979a());
                }
                drawable = this.f14358f;
            } else {
                drawable = new BitmapDrawable(this.f14356b, closeableStaticBitmap.mo2979a());
            }
            if (closeableStaticBitmap.f17887d == 0 || closeableStaticBitmap.f17887d == -1) {
                return drawable;
            }
            return new OrientedDrawable(drawable, closeableStaticBitmap.f17887d);
        } else if (this.f14357c != null) {
            return this.f14357c.m20777a(closeableImage);
        } else {
            throw new UnsupportedOperationException("Unrecognized image class: " + closeableImage);
        }
    }

    protected final void mo2768b(@Nullable Drawable drawable) {
        if (drawable instanceof DrawableWithCaches) {
            ((DrawableWithCaches) drawable).aj_();
        }
    }

    public String toString() {
        return Objects.m20537a((Object) this).m20544a("super", super.toString()).m20544a("dataSourceSupplier", this.f14359g).toString();
    }

    protected static void m20719a(boolean z, boolean z2) {
        f14354d = z;
        f14355e = z2;
    }
}
