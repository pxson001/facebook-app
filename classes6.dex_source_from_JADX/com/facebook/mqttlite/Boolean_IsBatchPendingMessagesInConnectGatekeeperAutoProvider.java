package com.facebook.mqttlite;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: time_to_write_bootstrap_keywords */
public class Boolean_IsBatchPendingMessagesInConnectGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(360, false));
    }
}
