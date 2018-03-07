package com.facebook.messaging.business.commerceui;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: nux_scroll_trigger_count */
public class Boolean_IsMessengerCommerceShoppingEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(188, false));
    }
}
