package com.facebook.android.maps;

import com.facebook.android.maps.internal.RectD;
import com.facebook.android.maps.model.LatLng;
import java.util.List;

/* compiled from: b9310d780c61e914ec01df61ad950fa9 */
public class DrawableHelper {
    public static double[] m14266a(List<LatLng> list, boolean z) {
        int i;
        int size = list.size();
        int i2 = size * 4;
        if (z) {
            i = i2;
        } else {
            i = i2 - 4;
        }
        double[] dArr = new double[i];
        LatLng latLng = (LatLng) list.get(0);
        dArr[i - 2] = (double) Projection.d(latLng.f8569b);
        dArr[i - 1] = (double) Projection.b(latLng.f8568a);
        int i3 = size - 1;
        int i4 = 0;
        for (size = 0; size < i3; size++) {
            i2 = i4 == 0 ? i - 2 : i4 - 2;
            int i5 = i4 + 1;
            int i6 = i2 + 1;
            dArr[i4] = dArr[i2];
            i4 = i5 + 1;
            dArr[i5] = dArr[i6];
            latLng = (LatLng) list.get(size + 1);
            i5 = i4 + 1;
            dArr[i4] = (double) Projection.d(latLng.f8569b);
            i4 = i5 + 1;
            dArr[i5] = (double) Projection.b(latLng.f8568a);
        }
        if (z) {
            i2 = i4 - 2;
            size = i4 + 1;
            i3 = i2 + 1;
            dArr[i4] = dArr[i2];
            dArr[size] = dArr[i3];
        }
        for (i2 = 0; i2 < i; i2 += 4) {
            double d = dArr[i2 + 2] - dArr[i2];
            if (d > 0.5d) {
                dArr[i2] = dArr[i2] + 1.0d;
            } else if (d < -0.5d) {
                int i7 = i2 + 2;
                dArr[i7] = dArr[i7] + 1.0d;
            }
        }
        return dArr;
    }

    public static double[] m14265a(List<LatLng> list) {
        int size = list.size();
        double[] dArr = new double[(size * 2)];
        int i = 0;
        int i2 = 0;
        while (i < size) {
            LatLng latLng = (LatLng) list.get(i);
            LatLng latLng2 = (LatLng) list.get(i + 1 == size ? 0 : i + 1);
            if (latLng.f8569b >= latLng2.f8569b) {
                LatLng latLng3 = latLng2;
                latLng2 = latLng;
                latLng = latLng3;
            }
            double toRadians = Math.toRadians(latLng2.f8568a);
            double toRadians2 = Math.toRadians(latLng2.f8569b);
            double toRadians3 = Math.toRadians(latLng.f8568a);
            double toRadians4 = Math.toRadians(latLng.f8569b) - toRadians2;
            double cos = Math.cos(toRadians);
            double sin = Math.sin(toRadians);
            toRadians4 = Math.atan2(Math.sin(toRadians4), (Math.tan(toRadians3) * cos) - (Math.cos(toRadians4) * sin));
            toRadians3 = Math.asin(Math.sin(toRadians4) * cos);
            if (Double.compare(1.5707963267948966d, toRadians4) == 0 && toRadians == 0.0d) {
                toRadians4 = 0.0d;
            } else {
                toRadians4 = Math.atan2(sin, Math.cos(toRadians4) * cos);
            }
            toRadians = toRadians2 - Math.atan2(Math.sin(toRadians3) * Math.sin(toRadians4), Math.cos(toRadians4));
            int i3 = i2 + 1;
            dArr[i2] = toRadians3;
            int i4 = i3 + 1;
            dArr[i3] = toRadians;
            i++;
            i2 = i4;
        }
        return dArr;
    }

    public static RectD[] m14267a(double[] dArr, double[] dArr2) {
        int length = dArr.length;
        RectD[] rectDArr = new RectD[(length / 4)];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            double d = (double) Projection.d(Math.toDegrees(dArr2[i3 + 1] - 1.5707963267948966d));
            double b = (double) Projection.b(Math.toDegrees(Math.asin(Math.cos(dArr2[i3]))));
            double d2 = 0.5d + d;
            RectD rectD = new RectD();
            if (dArr[i] < dArr[i + 2]) {
                rectD.c = dArr[i];
                rectD.d = dArr[i + 2];
            } else {
                rectD.c = dArr[i + 2];
                rectD.d = dArr[i];
            }
            if (dArr[i + 1] < dArr[i + 3]) {
                rectD.a = dArr[i + 1];
                rectD.b = dArr[i + 3];
            } else {
                rectD.a = dArr[i + 3];
                rectD.b = dArr[i + 1];
            }
            if (Math.ceil(rectD.c - d) <= Math.floor(rectD.d - d)) {
                rectD.a = b;
            } else if (Math.ceil(rectD.c - d2) <= Math.floor(rectD.d - d2)) {
                rectD.b = 1.0d - b;
            }
            rectDArr[i2] = rectD;
            i3 += 2;
            i += 4;
            i2++;
        }
        return rectDArr;
    }

    public static double m14264a(double d, double d2, double d3) {
        double d4 = (6.283185307179586d * (d - 0.5d)) - d3;
        d4 = Math.sin(Math.atan2(Math.sin(d4) * Math.cos(d2), Math.sin(d2)));
        return (Math.log((1.0d + d4) / (1.0d - d4)) / 12.566370614359172d) + 0.5d;
    }
}
