package com.facebook.location;

import android.location.Location;
import javax.annotation.Nullable;

/* compiled from: request_analytics_tag */
public class LocationValidityUtil {
    static boolean m11965a(@Nullable Location location) {
        return (location == null || location.getTime() == 0 || ((location.getLatitude() == 0.0d && location.getLongitude() == 0.0d) || !location.hasAccuracy())) ? false : true;
    }

    private LocationValidityUtil() {
    }
}
