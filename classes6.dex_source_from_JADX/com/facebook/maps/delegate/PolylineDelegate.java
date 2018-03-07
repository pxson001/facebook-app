package com.facebook.maps.delegate;

import com.facebook.android.maps.model.Polyline;

/* compiled from: vnd.android.cursor.item/photo */
public class PolylineDelegate {
    private final Polyline f402a;
    private final com.google.android.gms.maps.model.Polyline f403b;

    public PolylineDelegate(Polyline polyline) {
        this.f402a = polyline;
        this.f403b = null;
    }

    public PolylineDelegate(com.google.android.gms.maps.model.Polyline polyline) {
        this.f402a = null;
        this.f403b = polyline;
    }
}
