package com.facebook.orca.contacts;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: onion_rewrite_enabled */
public class Boolean_IsDivebarPresenceUpdateFixEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(796, false));
    }
}
