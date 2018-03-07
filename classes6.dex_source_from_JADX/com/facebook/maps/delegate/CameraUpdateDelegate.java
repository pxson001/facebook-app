package com.facebook.maps.delegate;

import android.graphics.Point;
import com.facebook.android.maps.CameraUpdate;
import com.facebook.android.maps.CameraUpdateFactory;
import com.facebook.android.maps.model.CameraPosition;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.LatLngBounds;

/* compiled from: voice */
public class CameraUpdateDelegate {
    int f343a;
    CameraPosition f344b;
    LatLng f345c;
    LatLngBounds f346d;
    Point f347e;
    float f348f;
    float f349g;
    float f350h;
    float f351i;
    int f352j;
    int f353k;
    int f354l;

    public CameraUpdateDelegate(int i) {
        this.f343a = i;
    }

    public final CameraUpdate m294a() {
        CameraUpdate cameraUpdate;
        float f;
        switch (this.f343a) {
            case 0:
                CameraPosition cameraPosition = this.f344b;
                cameraUpdate = new CameraUpdate();
                cameraUpdate.a = cameraPosition.a;
                if (cameraPosition.b != Float.MIN_VALUE) {
                    cameraUpdate.b = cameraPosition.b;
                }
                if (cameraPosition.d != Float.MIN_VALUE) {
                    cameraUpdate.h = cameraPosition.d;
                }
                return cameraUpdate;
            case 1:
                return CameraUpdateFactory.a(this.f345c);
            case 2:
                return CameraUpdateFactory.a(this.f346d, this.f354l);
            case 3:
                return CameraUpdateFactory.a(this.f346d, this.f352j, this.f353k, this.f354l);
            case 4:
                return CameraUpdateFactory.a(this.f345c, this.f348f);
            case 5:
                f = this.f350h;
                float f2 = this.f351i;
                cameraUpdate = new CameraUpdate();
                cameraUpdate.f = f;
                cameraUpdate.g = f2;
                return cameraUpdate;
            case 6:
                return CameraUpdateFactory.a(this.f349g, null);
            case 7:
                return CameraUpdateFactory.a(this.f349g, this.f347e);
            case 8:
                return CameraUpdateFactory.a();
            case 9:
                return CameraUpdateFactory.b();
            case 10:
                f = this.f348f;
                cameraUpdate = new CameraUpdate();
                cameraUpdate.b = f;
                return cameraUpdate;
            default:
                return null;
        }
    }

    public final com.google.android.gms.maps.CameraUpdate m295b() {
        switch (this.f343a) {
            case 0:
                return com.google.android.gms.maps.CameraUpdateFactory.m9147a(MapUtils.m352a(this.f344b));
            case 1:
                return com.google.android.gms.maps.CameraUpdateFactory.m9148a(MapUtils.m353a(this.f345c));
            case 2:
                return com.google.android.gms.maps.CameraUpdateFactory.m9150a(MapUtils.m354a(this.f346d), this.f354l);
            case 3:
                return com.google.android.gms.maps.CameraUpdateFactory.m9151a(MapUtils.m354a(this.f346d), this.f352j, this.f353k, this.f354l);
            case 4:
                return com.google.android.gms.maps.CameraUpdateFactory.m9149a(MapUtils.m353a(this.f345c), this.f348f);
            case 5:
                return com.google.android.gms.maps.CameraUpdateFactory.m9145a(this.f350h, this.f351i);
            case 6:
                return com.google.android.gms.maps.CameraUpdateFactory.m9154b(this.f349g);
            case 7:
                return com.google.android.gms.maps.CameraUpdateFactory.m9146a(this.f349g, this.f347e);
            case 8:
                return com.google.android.gms.maps.CameraUpdateFactory.m9143a();
            case 9:
                return com.google.android.gms.maps.CameraUpdateFactory.m9153b();
            case 10:
                return com.google.android.gms.maps.CameraUpdateFactory.m9144a(this.f348f);
            default:
                return null;
        }
    }
}
