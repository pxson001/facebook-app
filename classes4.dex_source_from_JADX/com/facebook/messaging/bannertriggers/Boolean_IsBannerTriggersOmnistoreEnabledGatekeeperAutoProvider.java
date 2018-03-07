package com.facebook.messaging.bannertriggers;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: language_switcher_login_displayed */
public class Boolean_IsBannerTriggersOmnistoreEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(166, false));
    }
}
