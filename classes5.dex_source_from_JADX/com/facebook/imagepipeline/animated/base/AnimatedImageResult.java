package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: TREEHOUSE_ANDROID_GROUP_PROFILE_MORE */
public class AnimatedImageResult {
    public final AnimatedImage f13614a;
    public final int f13615b;
    @Nullable
    private CloseableReference<Bitmap> f13616c;
    @Nullable
    private List<CloseableReference<Bitmap>> f13617d;

    AnimatedImageResult(AnimatedImageResultBuilder animatedImageResultBuilder) {
        this.f13614a = (AnimatedImage) Preconditions.a(animatedImageResultBuilder.f13618a);
        this.f13615b = animatedImageResultBuilder.f13621d;
        this.f13616c = CloseableReference.b(animatedImageResultBuilder.f13619b);
        this.f13617d = CloseableReference.a(animatedImageResultBuilder.f13620c);
    }

    private AnimatedImageResult(AnimatedImage animatedImage) {
        this.f13614a = (AnimatedImage) Preconditions.a(animatedImage);
        this.f13615b = 0;
    }

    public static AnimatedImageResult m22879a(AnimatedImage animatedImage) {
        return new AnimatedImageResult(animatedImage);
    }

    public static AnimatedImageResultBuilder m22880b(AnimatedImage animatedImage) {
        return new AnimatedImageResultBuilder(animatedImage);
    }

    public final AnimatedImage m22882a() {
        return this.f13614a;
    }

    @Nullable
    public final synchronized CloseableReference<Bitmap> m22881a(int i) {
        CloseableReference<Bitmap> b;
        if (this.f13617d != null) {
            b = CloseableReference.b((CloseableReference) this.f13617d.get(i));
        } else {
            b = null;
        }
        return b;
    }

    public final synchronized boolean m22883b(int i) {
        boolean z;
        z = (this.f13617d == null || this.f13617d.get(i) == null) ? false : true;
        return z;
    }

    public final synchronized CloseableReference<Bitmap> m22884c() {
        return CloseableReference.b(this.f13616c);
    }

    public final synchronized void m22885d() {
        CloseableReference.c(this.f13616c);
        this.f13616c = null;
        CloseableReference.a(this.f13617d);
        this.f13617d = null;
    }
}
