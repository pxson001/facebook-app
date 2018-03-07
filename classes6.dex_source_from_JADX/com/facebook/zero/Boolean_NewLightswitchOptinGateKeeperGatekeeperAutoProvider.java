package com.facebook.zero;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: com.facebook.platform.extra.MEDIA */
public class Boolean_NewLightswitchOptinGateKeeperGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(885, false));
    }
}
