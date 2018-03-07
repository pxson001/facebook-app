package com.facebook.placetips.pulsarcore.service;

import com.facebook.placetips.bootstrap.event.PlaceTipsPresenceEvent;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: TE;J */
class PulsarService$1 implements FutureCallback<PlaceTipsPresenceEvent> {
    final /* synthetic */ PulsarService f10787a;

    PulsarService$1(PulsarService pulsarService) {
        this.f10787a = pulsarService;
    }

    public void onSuccess(Object obj) {
        this.f10787a.c.a("Finished \"successful\" scan");
        this.f10787a.stopSelf();
    }

    public void onFailure(Throwable th) {
        this.f10787a.c.a(th, "Failed to execute pulsar scan");
        this.f10787a.stopSelf();
    }
}
