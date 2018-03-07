package com.facebook.maps.delegate;

import com.facebook.android.maps.Projection;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.LatLngBounds;
import com.facebook.android.maps.model.VisibleRegion;

/* compiled from: vnd.android.cursor.item/organization */
public class ProjectionDelegate {
    private final Projection f404a;
    private final com.google.android.gms.maps.Projection f405b;

    public ProjectionDelegate(Projection projection) {
        this.f404a = projection;
        this.f405b = null;
    }

    public ProjectionDelegate(com.google.android.gms.maps.Projection projection) {
        this.f405b = projection;
        this.f404a = null;
    }

    public final VisibleRegion m368a() {
        if (this.f404a != null) {
            return this.f404a.a();
        }
        VisibleRegion visibleRegion;
        com.google.android.gms.maps.model.VisibleRegion a = this.f405b.m9218a();
        if (a == null) {
            visibleRegion = null;
        } else {
            LatLngBounds latLngBounds;
            LatLng a2 = MapUtils.m349a(a.f6822a);
            LatLng a3 = MapUtils.m349a(a.f6823b);
            LatLng a4 = MapUtils.m349a(a.f6824c);
            LatLng a5 = MapUtils.m349a(a.f6825d);
            com.google.android.gms.maps.model.LatLngBounds latLngBounds2 = a.f6826e;
            if (latLngBounds2 == null || latLngBounds2.f6753a == null || latLngBounds2.f6754b == null) {
                latLngBounds = null;
            } else {
                latLngBounds = new LatLngBounds(MapUtils.m349a(latLngBounds2.f6753a), MapUtils.m349a(latLngBounds2.f6754b));
            }
            visibleRegion = new VisibleRegion(a2, a3, a4, a5, latLngBounds);
        }
        return visibleRegion;
    }
}
