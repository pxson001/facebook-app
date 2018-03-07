package com.facebook.drawee.drawable;

import android.graphics.ColorFilter;

/* compiled from: messaging/compose/new/group */
public class DrawableProperties {
    public int f14244a = -1;
    public boolean f14245b = false;
    public ColorFilter f14246c = null;
    public int f14247d = -1;
    public int f14248e = -1;

    public final void m20635a(ColorFilter colorFilter) {
        this.f14246c = colorFilter;
        this.f14245b = true;
    }

    public final void m20636a(boolean z) {
        this.f14247d = z ? 1 : 0;
    }

    public final void m20637b(boolean z) {
        this.f14248e = z ? 1 : 0;
    }
}
