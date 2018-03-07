package com.facebook.maps;

import android.location.Location;
import com.google.android.maps.GeoPoint;

/* compiled from: whatsapp_profile */
public class Locations {
    private static double f254a = 1000000.0d;

    public static Location m226a(double d, double d2) {
        Location location = new Location("");
        location.setLatitude(d);
        location.setLongitude(d2);
        return location;
    }

    public static Location m227a(GeoPoint geoPoint) {
        return m226a(((double) geoPoint.getLatitudeE6()) / f254a, ((double) geoPoint.getLongitudeE6()) / f254a);
    }

    public static GeoPoint m228a(Location location) {
        return new GeoPoint((int) (location.getLatitude() * f254a), (int) (location.getLongitude() * f254a));
    }
}
