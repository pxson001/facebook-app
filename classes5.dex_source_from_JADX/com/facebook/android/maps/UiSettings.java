package com.facebook.android.maps;

import com.facebook.android.maps.internal.CompassDrawable;
import com.facebook.android.maps.internal.MyLocationButtonDrawable;
import com.facebook.android.maps.internal.ZoomControlsDrawable;

/* compiled from: away_team_primary_color */
public final class UiSettings {
    public boolean f8282a = true;
    public boolean f8283b;
    public boolean f8284c;
    public boolean f8285d;
    public boolean f8286e;
    private FacebookMap f8287f;

    protected UiSettings(FacebookMap facebookMap) {
        this.f8287f = facebookMap;
    }

    public final void m14411a(boolean z) {
        if (z && this.f8287f.f8150x == null) {
            this.f8287f.f8150x = new CompassDrawable(this.f8287f);
            this.f8287f.m14277a(this.f8287f.f8150x);
        } else if (!z && this.f8287f.f8150x != null) {
            this.f8287f.m14289b(this.f8287f.f8150x);
            this.f8287f.f8150x = null;
        }
    }

    public final void m14413f(boolean z) {
        if (z && this.f8287f.f8147u == null) {
            this.f8287f.f8147u = new ZoomControlsDrawable(this.f8287f);
            this.f8287f.m14277a(this.f8287f.f8147u);
        } else if (!z && this.f8287f.f8147u != null) {
            this.f8287f.m14289b(this.f8287f.f8147u);
            this.f8287f.f8147u = null;
        }
    }

    public final void m14412e() {
        Object obj = (this.f8282a && this.f8287f.m14302j()) ? 1 : null;
        if (obj != null && this.f8287f.f8148v == null) {
            this.f8287f.f8148v = new MyLocationButtonDrawable(this.f8287f);
            this.f8287f.m14277a(this.f8287f.f8148v);
        } else if (obj == null && this.f8287f.f8148v != null) {
            this.f8287f.m14289b(this.f8287f.f8148v);
            this.f8287f.f8148v = null;
        }
    }
}
