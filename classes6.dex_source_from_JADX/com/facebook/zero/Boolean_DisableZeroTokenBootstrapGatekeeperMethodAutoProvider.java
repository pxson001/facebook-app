package com.facebook.zero;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: com.facebook.platform.extra.PROTOCOL_VERSIONS */
public class Boolean_DisableZeroTokenBootstrapGatekeeperMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return FbZeroModule.e(GatekeeperStoreImplMethodAutoProvider.a(this));
    }
}
