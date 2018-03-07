package com.facebook.tablet.sideshow;

import android.view.View;
import com.facebook.tablet.sideshow.loader.LoadResult;

/* compiled from: handle_delivery_receipt */
public class SideshowUnitWrapper {
    public SideshowUnit f10112a;
    public LoadResult f10113b;
    public View f10114c;
    public int f10115d = 0;
    public long f10116e;
    public long f10117f;

    public SideshowUnitWrapper(SideshowUnit sideshowUnit) {
        this.f10112a = sideshowUnit;
    }

    public final void m10178b() {
        if (this.f10115d == 1 || this.f10115d == 3) {
            this.f10115d = 2;
            this.f10112a.a();
        }
    }

    public final void m10179c() {
        if (this.f10115d == 2) {
            this.f10115d = 3;
            this.f10112a.b();
        }
    }

    public final String m10180g() {
        return this.f10112a.d();
    }
}
