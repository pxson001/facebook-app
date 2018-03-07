package com.facebook.messaging.cache;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: missing required data when calling doCreateAccount() */
public class Boolean_IsGlobalMessageDeleteEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(941, false));
    }
}
