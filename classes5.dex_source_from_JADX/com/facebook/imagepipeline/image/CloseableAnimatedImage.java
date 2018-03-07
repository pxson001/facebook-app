package com.facebook.imagepipeline.image;

import com.facebook.imagepipeline.animated.base.AnimatedImageResult;

/* compiled from: TRAILER_RENTAL */
public class CloseableAnimatedImage extends CloseableImage {
    private AnimatedImageResult f13703a;

    public CloseableAnimatedImage(AnimatedImageResult animatedImageResult) {
        this.f13703a = animatedImageResult;
    }

    public final synchronized int m23042f() {
        return c() ? 0 : this.f13703a.m22882a().a();
    }

    public final synchronized int m23043g() {
        return c() ? 0 : this.f13703a.m22882a().b();
    }

    public void close() {
        synchronized (this) {
            if (this.f13703a == null) {
                return;
            }
            AnimatedImageResult animatedImageResult = this.f13703a;
            this.f13703a = null;
            animatedImageResult.m22885d();
        }
    }

    public final synchronized boolean m23040c() {
        return this.f13703a == null;
    }

    public final synchronized int m23039b() {
        return c() ? 0 : this.f13703a.m22882a().g();
    }

    public final boolean m23041e() {
        return true;
    }

    public final synchronized AnimatedImageResult m23038a() {
        return this.f13703a;
    }
}
