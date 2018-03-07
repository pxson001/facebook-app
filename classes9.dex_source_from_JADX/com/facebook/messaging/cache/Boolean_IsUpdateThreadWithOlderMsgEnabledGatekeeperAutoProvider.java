package com.facebook.messaging.cache;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: minutiae_action_id */
public class Boolean_IsUpdateThreadWithOlderMsgEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(342, false));
    }
}
