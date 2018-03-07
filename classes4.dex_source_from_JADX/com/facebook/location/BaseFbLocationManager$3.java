package com.facebook.location;

import com.facebook.location.FbLocationOperation.LocationCallback;

/* compiled from: is_optimistic */
class BaseFbLocationManager$3 implements Runnable {
    final /* synthetic */ FbLocationManagerException f9936a;
    final /* synthetic */ BaseFbLocationManager f9937b;

    BaseFbLocationManager$3(BaseFbLocationManager baseFbLocationManager, FbLocationManagerException fbLocationManagerException) {
        this.f9937b = baseFbLocationManager;
        this.f9936a = fbLocationManagerException;
    }

    public void run() {
        if (this.f9937b.m.getAndSet(false)) {
            LocationCallback locationCallback = this.f9937b.j;
            FbLocationOperation.a(locationCallback.a, this.f9936a);
            BaseFbLocationManager.h(this.f9937b);
        }
    }
}
