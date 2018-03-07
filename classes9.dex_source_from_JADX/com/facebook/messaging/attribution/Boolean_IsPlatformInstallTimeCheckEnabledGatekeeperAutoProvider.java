package com.facebook.messaging.attribution;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: p2p_add_card_save_button_click */
public class Boolean_IsPlatformInstallTimeCheckEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(288, false));
    }
}
