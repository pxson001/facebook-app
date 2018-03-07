package com.facebook.api.feedcache.omnistore;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: kvm_null_flag */
public class Boolean_IsOmnistoreVpvUpdateEnableGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(664, false));
    }
}
