package com.facebook.nearby.maps;

import android.graphics.Point;
import android.graphics.RectF;
import android.location.Location;

/* compiled from: upsell_card */
public class MapRegionCalculator {
    public static RectF m444a(NearbyMapController nearbyMapController) {
        Point a = nearbyMapController.m463a(nearbyMapController.m476d());
        Point a2 = nearbyMapController.m463a(nearbyMapController.m477e());
        int ceil = (int) Math.ceil(180.0d);
        a.y -= ceil;
        a.x -= ceil;
        a2.y += ceil;
        a2.x = ceil + a2.x;
        Location a3 = nearbyMapController.m464a(a);
        Location a4 = nearbyMapController.m464a(a2);
        return new RectF((float) a3.getLongitude(), (float) a3.getLatitude(), (float) a4.getLongitude(), (float) a4.getLatitude());
    }
}
