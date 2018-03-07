package com.facebook.location;

import com.google.common.collect.ImmutableSet;
import java.util.Iterator;

/* compiled from: TEA_ROOM */
class AndroidPlatformFbLocationManager$1 implements Runnable {
    final /* synthetic */ ImmutableSet f14225a;
    final /* synthetic */ AndroidPlatformFbLocationManager f14226b;

    AndroidPlatformFbLocationManager$1(AndroidPlatformFbLocationManager androidPlatformFbLocationManager, ImmutableSet immutableSet) {
        this.f14226b = androidPlatformFbLocationManager;
        this.f14225a = immutableSet;
    }

    public void run() {
        synchronized (this.f14226b) {
            if (this.f14226b.e.get()) {
                Iterator it = this.f14225a.iterator();
                while (it.hasNext()) {
                    this.f14226b.c.requestLocationUpdates((String) it.next(), this.f14226b.d.e, 0.0f, this.f14226b.f);
                }
                return;
            }
        }
    }
}
