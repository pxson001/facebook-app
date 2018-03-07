package com.facebook.messaging.clockskew;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: total_request_count */
public class ClockSkewGatekeepers {
    private final GatekeeperStoreImpl f2331a;

    public static ClockSkewGatekeepers m4514b(InjectorLike injectorLike) {
        return new ClockSkewGatekeepers(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public ClockSkewGatekeepers(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f2331a = gatekeeperStoreImpl;
    }

    public final boolean m4515a() {
        return this.f2331a.m2189a(906, false);
    }
}
