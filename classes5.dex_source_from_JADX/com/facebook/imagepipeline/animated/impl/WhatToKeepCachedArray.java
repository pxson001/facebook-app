package com.facebook.imagepipeline.animated.impl;

import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: TRAVELLABLE */
class WhatToKeepCachedArray {
    private final boolean[] f13676a;

    WhatToKeepCachedArray(int i) {
        this.f13676a = new boolean[i];
    }

    final boolean m22995a(int i) {
        return this.f13676a[i];
    }

    final void m22994a(boolean z) {
        for (int i = 0; i < this.f13676a.length; i++) {
            this.f13676a[i] = z;
        }
    }

    final void m22992a(int i, int i2) {
        for (int i3 = 0; i3 < this.f13676a.length; i3++) {
            if (AnimatedDrawableUtil.a(i, i2, i3)) {
                this.f13676a[i3] = false;
            }
        }
    }

    final void m22993a(int i, boolean z) {
        this.f13676a[i] = z;
    }
}
