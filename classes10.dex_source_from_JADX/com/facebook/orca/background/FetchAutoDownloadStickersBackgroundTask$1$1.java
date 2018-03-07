package com.facebook.orca.background;

import com.facebook.device.DeviceConditionHelper;
import com.facebook.orca.background.FetchAutoDownloadStickersBackgroundTask.1;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: page_suggestions */
class FetchAutoDownloadStickersBackgroundTask$1$1 implements Runnable {
    final /* synthetic */ DeviceConditionHelper f5226a;
    final /* synthetic */ 1 f5227b;

    FetchAutoDownloadStickersBackgroundTask$1$1(1 1, DeviceConditionHelper deviceConditionHelper) {
        this.f5227b = 1;
        this.f5226a = deviceConditionHelper;
    }

    public void run() {
        if (!this.f5226a.b()) {
            ListenableFuture listenableFuture = (ListenableFuture) this.f5227b.a.k.getAndSet(null);
            if (listenableFuture != null) {
                listenableFuture.cancel(true);
            }
        } else if (this.f5227b.a.i()) {
            this.f5227b.a.g();
        }
    }
}
