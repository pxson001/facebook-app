package com.facebook.location.foreground;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: Unknown collection type in getLongString() */
public class GeoPixelController$2 implements FutureCallback<Map<String, Object>> {
    final /* synthetic */ GeoPixelController f10442a;

    public GeoPixelController$2(GeoPixelController geoPixelController) {
        this.f10442a = geoPixelController;
    }

    public void onSuccess(@Nullable Object obj) {
        HoneyClientEvent a = new HoneyClientEvent("geopixel_rtt").a((Map) obj);
        a.c = "oxygen_map";
        this.f10442a.h.a(a);
    }

    public void onFailure(Throwable th) {
        this.f10442a.j.a(GeoPixelController.a, th);
    }
}
