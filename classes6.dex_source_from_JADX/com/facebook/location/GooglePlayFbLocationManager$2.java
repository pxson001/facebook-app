package com.facebook.location;

import com.facebook.location.FbLocationManagerException.Type;
import com.google.android.gms.location.LocationServices;

/* compiled from: ر.ق. */
class GooglePlayFbLocationManager$2 implements Runnable {
    final /* synthetic */ GooglePlayFbLocationManager f37a;

    GooglePlayFbLocationManager$2(GooglePlayFbLocationManager googlePlayFbLocationManager) {
        this.f37a = googlePlayFbLocationManager;
    }

    public void run() {
        synchronized (this.f37a) {
            if (this.f37a.j) {
                try {
                    LocationServices.b.a(this.f37a.h, GooglePlayFbLocationManager.a(this.f37a, this.f37a.g), this.f37a.i);
                } catch (SecurityException e) {
                    GooglePlayFbLocationManager.e(this.f37a);
                    this.f37a.a(new FbLocationManagerException(Type.PERMISSION_DENIED));
                }
                return;
            }
        }
    }
}
