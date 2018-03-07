package com.facebook.adinterfaces.util;

import android.graphics.Point;
import android.view.View;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.Projection;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.VisibleRegion;

/* compiled from: UninterpretedOption */
public class MapPickerGeoHelperMetric {
    public final double f23339a;
    public final double f23340b;

    public MapPickerGeoHelperMetric(double d, double d2) {
        this.f23339a = d;
        this.f23340b = d2;
    }

    public static double m25279a(Projection projection, View view) {
        VisibleRegion a = projection.a();
        LatLng a2 = projection.a(new Point(view.getLeft(), view.getTop() + (view.getHeight() / 2)));
        LatLng b = a.e.b();
        return Projection.b(a2.b, b.b, b.a);
    }

    public static float m25280a(FacebookMap facebookMap, LatLng latLng, double d, int i) {
        double log = Math.log(((double) i) / (((double) Math.abs(Projection.d(Projection.a(latLng.b, latLng.a, d)) - Projection.d(latLng.b))) * ((double) facebookMap.B))) / Math.log(2.0d);
        int i2 = (int) log;
        return (float) ((Math.pow(2.0d, log % 1.0d) - 1.0d) + ((double) i2));
    }
}
