package com.facebook.video.player;

import com.google.common.base.Preconditions;

/* compiled from: composer_minutiae_cancel */
public abstract class RichVideoPlayerScheduledRunnable implements Runnable {
    public final float f19205a;
    public final float f19206b;

    public RichVideoPlayerScheduledRunnable(float f, float f2) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkArgument(f < f2);
        if (f >= 0.0f) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (f2 > 1.0f) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.f19205a = f;
        this.f19206b = f2;
    }

    public final float m27997a() {
        return this.f19205a;
    }

    public final float m27998b() {
        return this.f19206b;
    }
}
