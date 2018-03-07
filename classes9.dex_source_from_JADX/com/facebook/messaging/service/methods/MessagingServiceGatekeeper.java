package com.facebook.messaging.service.methods;

import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.ultralight.Inject;

/* compiled from: custom_locations */
public class MessagingServiceGatekeeper {
    GatekeeperStoreImpl f16950a;

    @Inject
    public MessagingServiceGatekeeper(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f16950a = gatekeeperStoreImpl;
    }

    public final boolean m16984a() {
        return this.f16950a.a(221, false);
    }
}
