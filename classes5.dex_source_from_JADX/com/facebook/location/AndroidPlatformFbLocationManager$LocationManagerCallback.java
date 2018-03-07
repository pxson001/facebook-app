package com.facebook.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/* compiled from: TEA_ROOM */
class AndroidPlatformFbLocationManager$LocationManagerCallback implements LocationListener {
    final /* synthetic */ AndroidPlatformFbLocationManager f14227a;

    public AndroidPlatformFbLocationManager$LocationManagerCallback(AndroidPlatformFbLocationManager androidPlatformFbLocationManager) {
        this.f14227a = androidPlatformFbLocationManager;
    }

    public void onLocationChanged(Location location) {
        ImmutableLocation a = AndroidPlatformFbLocationManager.a(location);
        if (a != null) {
            this.f14227a.a(a);
        }
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onProviderDisabled(String str) {
    }
}
