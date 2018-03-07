package com.facebook.messaging.business.commerceui;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: nux_refresher_finished_fragment */
public class Boolean_IsMessengerMonypennyEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(268, false));
    }
}
