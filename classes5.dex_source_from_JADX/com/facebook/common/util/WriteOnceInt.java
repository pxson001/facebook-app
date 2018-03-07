package com.facebook.common.util;

/* compiled from: set_count */
public final class WriteOnceInt {
    public boolean f2796a;
    private int f2797b;

    public final int m3931b() {
        if (this.f2796a) {
            return this.f2797b;
        }
        throw new IllegalStateException();
    }

    public final void m3930a(int i) {
        if (this.f2796a) {
            throw new IllegalStateException();
        }
        this.f2797b = i;
        this.f2796a = true;
    }
}
