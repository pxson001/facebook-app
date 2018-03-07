package com.facebook.nearby.cluster;

import android.graphics.Point;
import android.graphics.RectF;
import android.location.Location;
import com.facebook.maps.Locations;
import com.google.android.maps.Projection;

/* compiled from: user_image_size */
public class MapPinViewSizeHelperV1 {
    public final Projection f304a;

    public MapPinViewSizeHelperV1(Projection projection) {
        this.f304a = projection;
    }

    public final RectF m394a(Location location) {
        Point toPixels = this.f304a.toPixels(Locations.a(location), null);
        return new RectF((float) (toPixels.x - 25), (float) (toPixels.y - 50), (float) (toPixels.x + 25), (float) toPixels.y);
    }

    public final RectF m395b(Location location) {
        Point toPixels = this.f304a.toPixels(Locations.a(location), null);
        return new RectF((float) (toPixels.x - 60), (float) (toPixels.y - 120), (float) (toPixels.x + 60), (float) toPixels.y);
    }
}
