package com.facebook.stickers.ui;

import android.animation.ValueAnimator;
import com.facebook.imagepipeline.animated.base.AnimatableDrawable;

/* compiled from: duration_voice_call */
public class StickerAnimator {
    public AnimatableDrawable f17027a;
    public ValueAnimator f17028b;
    public boolean f17029c = false;

    public StickerAnimator(AnimatableDrawable animatableDrawable) {
        this.f17027a = animatableDrawable;
        this.f17028b = animatableDrawable.a(5000);
    }

    public final void m24736b() {
        this.f17029c = true;
        this.f17028b.start();
    }

    public final void m24737c() {
        this.f17028b.end();
    }

    public final boolean m24738e() {
        return this.f17028b.isRunning();
    }
}
