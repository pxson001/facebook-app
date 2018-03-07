package com.facebook.messaging.send.client;

import java.util.LinkedHashMap;

/* compiled from: default_creative_spec */
class StartupRetryManager$3 implements Runnable {
    final /* synthetic */ long f16848a;
    final /* synthetic */ StartupRetryManager f16849b;

    StartupRetryManager$3(StartupRetryManager startupRetryManager, long j) {
        this.f16849b = startupRetryManager;
        this.f16848a = j;
    }

    public void run() {
        LinkedHashMap a = this.f16849b.g.a(this.f16849b.l, ((int) this.f16848a) + 1);
        if (a != null && !a.isEmpty()) {
            if (((long) a.size()) > this.f16848a) {
                StartupRetryManager.e(this.f16849b);
            } else {
                StartupRetryManager.b(this.f16849b, a);
            }
        }
    }
}
