package com.facebook.messaging.profile;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: dest_long */
public class Boolean_IsWebpProfileEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(959, false));
    }
}
