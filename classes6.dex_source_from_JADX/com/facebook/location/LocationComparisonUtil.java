package com.facebook.location;

import android.location.Location;

/* compiled from: лв. */
public class LocationComparisonUtil {
    public static float m44a(ImmutableLocation immutableLocation, ImmutableLocation immutableLocation2) {
        float[] fArr = new float[1];
        Location.distanceBetween(immutableLocation.a(), immutableLocation.b(), immutableLocation2.a(), immutableLocation2.b(), fArr);
        return fArr[0];
    }

    public static long m45b(ImmutableLocation immutableLocation, ImmutableLocation immutableLocation2) {
        return ((Long) immutableLocation2.g().get()).longValue() - ((Long) immutableLocation.g().get()).longValue();
    }
}
