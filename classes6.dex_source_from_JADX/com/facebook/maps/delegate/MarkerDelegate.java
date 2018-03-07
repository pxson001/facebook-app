package com.facebook.maps.delegate;

import com.facebook.android.maps.model.BitmapDescriptor;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.Marker;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: vnd.android.cursor.item/postal-address_v2 */
public class MarkerDelegate {
    private static final WeakHashMap<Marker, WeakReference<MarkerDelegate>> f398c = new WeakHashMap();
    private static final WeakHashMap<com.google.android.gms.maps.model.Marker, WeakReference<MarkerDelegate>> f399d = new WeakHashMap();
    public final Marker f400a;
    public final com.google.android.gms.maps.model.Marker f401b;

    public static MarkerDelegate m359a(Marker marker) {
        WeakReference weakReference = (WeakReference) f398c.get(marker);
        MarkerDelegate markerDelegate = weakReference == null ? null : (MarkerDelegate) weakReference.get();
        if (markerDelegate != null) {
            return markerDelegate;
        }
        markerDelegate = new MarkerDelegate(marker);
        f398c.put(marker, new WeakReference(markerDelegate));
        return markerDelegate;
    }

    public static MarkerDelegate m360a(com.google.android.gms.maps.model.Marker marker) {
        WeakReference weakReference = (WeakReference) f399d.get(marker);
        MarkerDelegate markerDelegate = weakReference == null ? null : (MarkerDelegate) weakReference.get();
        if (markerDelegate != null) {
            return markerDelegate;
        }
        markerDelegate = new MarkerDelegate(marker);
        f399d.put(marker, new WeakReference(markerDelegate));
        return markerDelegate;
    }

    private MarkerDelegate(Marker marker) {
        this.f400a = marker;
        this.f401b = null;
    }

    private MarkerDelegate(com.google.android.gms.maps.model.Marker marker) {
        this.f401b = marker;
        this.f400a = null;
    }

    public final LatLng m361a() {
        if (this.f400a != null) {
            return this.f400a.a();
        }
        return MapUtils.m349a(this.f401b.m9664b());
    }

    public final String m365b() {
        if (this.f400a != null) {
            return this.f400a.D;
        }
        return this.f401b.m9665c();
    }

    public final void m363a(LatLng latLng) {
        if (this.f400a != null) {
            this.f400a.a(latLng);
        } else {
            this.f401b.m9662a(MapUtils.m353a(latLng));
        }
    }

    public final void m364a(String str) {
        if (this.f400a != null) {
            this.f400a.a(str);
        } else {
            this.f401b.m9663a(str);
        }
    }

    public final void m366d() {
        if (this.f400a != null) {
            this.f400a.q();
        } else {
            this.f401b.m9666d();
        }
    }

    public final void m367e() {
        if (this.f400a != null) {
            this.f400a.p();
        } else {
            this.f401b.m9667e();
        }
    }

    public final void m362a(BitmapDescriptor bitmapDescriptor) {
        if (this.f400a != null) {
            this.f400a.a(bitmapDescriptor);
        } else {
            this.f401b.m9661a(MapUtils.m351a(bitmapDescriptor));
        }
    }
}
