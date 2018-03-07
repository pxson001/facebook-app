package com.facebook.location;

import com.facebook.location.FbLocationOperation.LocationCallback;

/* compiled from: 日 */
public class BaseFbLocationManager$2 implements Runnable {
    final /* synthetic */ ImmutableLocation f7a;
    final /* synthetic */ BaseFbLocationManager f8b;

    public BaseFbLocationManager$2(BaseFbLocationManager baseFbLocationManager, ImmutableLocation immutableLocation) {
        this.f8b = baseFbLocationManager;
        this.f7a = immutableLocation;
    }

    public void run() {
        if (this.f8b.m.get()) {
            BaseFbLocationManager baseFbLocationManager = this.f8b;
            baseFbLocationManager.q++;
            LocationCallback locationCallback = this.f8b.j;
            FbLocationOperation.a(locationCallback.a, this.f7a);
        }
    }
}
