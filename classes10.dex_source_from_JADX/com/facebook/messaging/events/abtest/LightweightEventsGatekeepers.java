package com.facebook.messaging.events.abtest;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: startDownload() */
public class LightweightEventsGatekeepers {
    public final GatekeeperStoreImpl f2277a;

    public static LightweightEventsGatekeepers m2154b(InjectorLike injectorLike) {
        return new LightweightEventsGatekeepers(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LightweightEventsGatekeepers(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f2277a = gatekeeperStoreImpl;
    }

    public static LightweightEventsGatekeepers m2153a(InjectorLike injectorLike) {
        return m2154b(injectorLike);
    }
}
