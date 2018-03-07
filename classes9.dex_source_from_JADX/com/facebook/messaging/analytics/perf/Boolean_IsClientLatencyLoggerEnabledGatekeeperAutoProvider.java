package com.facebook.messaging.analytics.perf;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: p2p_inconsistent_status */
public class Boolean_IsClientLatencyLoggerEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(183, false));
    }
}
