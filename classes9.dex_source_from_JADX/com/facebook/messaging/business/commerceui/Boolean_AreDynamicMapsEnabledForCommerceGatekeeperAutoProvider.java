package com.facebook.messaging.business.commerceui;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: oauth_url */
public class Boolean_AreDynamicMapsEnabledForCommerceGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(187, false));
    }
}
