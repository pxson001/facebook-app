package com.facebook.android.maps;

import android.graphics.Point;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.LatLngBounds;

/* compiled from: backing_application */
public final class CameraUpdateFactory {
    public static CameraUpdate m14202a(LatLng latLng) {
        CameraUpdate cameraUpdate = new CameraUpdate();
        cameraUpdate.f8038a = latLng;
        return cameraUpdate;
    }

    public static CameraUpdate m14204a(LatLngBounds latLngBounds, int i) {
        return m14205a(latLngBounds, 0, 0, i);
    }

    public static CameraUpdate m14205a(LatLngBounds latLngBounds, int i, int i2, int i3) {
        CameraUpdate cameraUpdate = new CameraUpdate();
        cameraUpdate.f8046i = latLngBounds;
        cameraUpdate.f8047j = i;
        cameraUpdate.f8048k = i2;
        cameraUpdate.f8049l = i3;
        return cameraUpdate;
    }

    public static CameraUpdate m14203a(LatLng latLng, float f) {
        CameraUpdate cameraUpdate = new CameraUpdate();
        cameraUpdate.f8038a = latLng;
        cameraUpdate.f8039b = f;
        return cameraUpdate;
    }

    public static CameraUpdate m14201a(float f, Point point) {
        CameraUpdate cameraUpdate = new CameraUpdate();
        cameraUpdate.f8040c = f;
        if (point != null) {
            cameraUpdate.f8041d = (float) point.x;
            cameraUpdate.f8042e = (float) point.y;
        }
        return cameraUpdate;
    }

    public static CameraUpdate m14200a() {
        return m14201a(1.0f, null);
    }

    public static CameraUpdate m14206b() {
        return m14201a(-1.0f, null);
    }
}
