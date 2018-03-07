package com.facebook.nearby.protocol;

import android.content.res.Resources;
import android.graphics.Point;
import android.location.Location;
import com.facebook.common.util.SizeUtil;
import com.facebook.nearby.maps.NearbyMapController;
import javax.inject.Inject;

/* compiled from: tried_stories_count */
public class NearbyProtocolZoomHelper {
    private final Resources f525a;

    @Inject
    public NearbyProtocolZoomHelper(Resources resources) {
        this.f525a = resources;
    }

    public final float m651a(NearbyMapController nearbyMapController) {
        Location d = nearbyMapController.m476d();
        Location e = nearbyMapController.m477e();
        Point a = nearbyMapController.m463a(e);
        float log = (float) (21.0d - (Math.log(((Math.min(Math.abs(d.getLongitude() - e.getLongitude()), Math.abs(d.getLatitude() - e.getLatitude())) * 8.5445656E7d) * 3.141592653589793d) / (((double) ((float) SizeUtil.b(this.f525a, (float) Math.min(a.x, a.y)))) * 180.0d)) / Math.log(2.0d)));
        if (Float.isInfinite(log) || Float.isNaN(log)) {
            return 14.0f;
        }
        return log;
    }
}
