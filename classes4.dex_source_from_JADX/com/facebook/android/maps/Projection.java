package com.facebook.android.maps;

import android.graphics.Point;
import com.facebook.android.maps.internal.RectD;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.LatLngBounds;
import com.facebook.android.maps.model.VisibleRegion;

/* compiled from: dst_THREADLIST */
public final class Projection {
    private final FacebookMap f13547a;
    private final float[] f13548b = new float[2];
    private final RectD f13549c = new RectD();

    public static double m14396a(double d) {
        return 57.29577951308232d * ((Math.atan(Math.exp((1.0d - (d * 2.0d)) * 3.141592653589793d)) * 2.0d) - 1.5707963267948966d);
    }

    public static float m14399b(double d) {
        double sin = Math.sin((3.141592653589793d * d) / 180.0d);
        return (float) (0.5d - (Math.log((1.0d + sin) / (1.0d - sin)) / 12.566370614359172d));
    }

    public static double m14400c(double d) {
        return (360.0d * d) - 180.0d;
    }

    public static float m14402d(double d) {
        return ((float) (180.0d + d)) / 360.0f;
    }

    public static double m14397a(double d, double d2, double d3) {
        return (Math.toDegrees(d3 / 6371009.0d) / Math.cos(Math.toRadians(d2))) + d;
    }

    public static double m14398b(double d, double d2, double d3) {
        return (Math.cos(Math.toRadians(d3)) * Math.toRadians(d2 - d)) * 6371009.0d;
    }

    Projection(FacebookMap facebookMap) {
        this.f13547a = facebookMap;
    }

    public final LatLng m14406a(Point point) {
        return m14405a((float) point.x, (float) point.y);
    }

    public final VisibleRegion m14407a() {
        MapView mapView = this.f13547a.A;
        LatLng a = m14405a((float) this.f13547a.c, (float) (mapView.d - this.f13547a.f));
        LatLng a2 = m14405a((float) (mapView.c - this.f13547a.e), (float) (mapView.d - this.f13547a.f));
        LatLng a3 = m14405a((float) this.f13547a.c, (float) this.f13547a.d);
        LatLng a4 = m14405a((float) (mapView.c - this.f13547a.e), (float) this.f13547a.d);
        return new VisibleRegion(a, a2, a3, a4, LatLngBounds.a().a(a).a(a3).a(a2).a(a4).a());
    }

    public final void m14408a(double d, double d2, float[] fArr) {
        MapView mapView = this.f13547a.A;
        double d3 = mapView.m;
        m14410a(this.f13549c);
        if (this.f13549c.f13554c > d3 || d3 > this.f13549c.f13555d) {
            d3 += (double) ((int) Math.ceil(this.f13549c.f13554c - d3));
        }
        float f = (float) (d2 - mapView.n);
        fArr[0] = ((float) (d - d3)) * ((float) mapView.r);
        fArr[1] = ((float) mapView.r) * f;
        mapView.k.mapVectors(fArr);
        fArr[0] = fArr[0] + mapView.e;
        fArr[1] = fArr[1] + mapView.f;
    }

    public final void m14412b(double d, double d2, float[] fArr) {
        double ceil;
        m14410a(this.f13549c);
        if (d < this.f13549c.f13554c || d > this.f13549c.f13555d) {
            ceil = d + ((double) ((int) Math.ceil(this.f13549c.f13554c - d)));
            if (ceil > this.f13549c.f13555d) {
                if (this.f13549c.f13554c - (ceil - 1.0d) < ceil - this.f13549c.f13555d) {
                    ceil -= 1.0d;
                }
            }
        } else {
            ceil = d;
        }
        m14408a(ceil, d2, fArr);
    }

    public final void m14409a(float f, float f2, float[] fArr) {
        MapView mapView = this.f13547a.A;
        fArr[0] = f - mapView.e;
        fArr[1] = f2 - mapView.f;
        mapView.l.mapVectors(fArr);
        fArr[0] = (float) (mapView.m + ((double) (fArr[0] / ((float) mapView.r))));
        fArr[1] = (float) (((double) (fArr[1] / ((float) mapView.r))) + mapView.n);
        if (fArr[0] > 1.0f) {
            fArr[0] = fArr[0] - 1.0f;
        } else if (fArr[0] < 0.0f) {
            fArr[0] = fArr[0] + 1.0f;
        }
    }

    private void m14401c(double d, double d2, float[] fArr) {
        m14412b((double) m14402d(d2), (double) m14399b(d), fArr);
    }

    public final Point m14404a(LatLng latLng) {
        m14401c(latLng.a, latLng.b, this.f13548b);
        return new Point((int) this.f13548b[0], (int) this.f13548b[1]);
    }

    final LatLng m14405a(float f, float f2) {
        m14409a(f, f2, this.f13548b);
        return new LatLng(m14396a((double) this.f13548b[1]), m14400c((double) this.f13548b[0]));
    }

    public final void m14410a(RectD rectD) {
        MapView mapView = this.f13547a.A;
        rectD.f13552a = mapView.n - mapView.p;
        rectD.f13553b = mapView.n + mapView.p;
        rectD.f13554c = mapView.m - mapView.o;
        rectD.f13555d = mapView.o + mapView.m;
        if (rectD.f13554c < 0.0d) {
            int ceil = (int) Math.ceil(-rectD.f13554c);
            rectD.f13554c += (double) ceil;
            rectD.f13555d = ((double) ceil) + rectD.f13555d;
        }
    }

    public final double m14403a(float f) {
        MapView mapView = this.f13547a.A;
        return (double) (f / (mapView.h * ((float) mapView.r)));
    }

    public final float m14411b() {
        float f = this.f13547a.A.j;
        if (f < 0.0f) {
            return f + 360.0f;
        }
        return f;
    }
}
