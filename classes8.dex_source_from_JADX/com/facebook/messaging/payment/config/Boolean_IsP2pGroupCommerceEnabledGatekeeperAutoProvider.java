package com.facebook.messaging.payment.config;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: top_friend_birthday_promotion */
public class Boolean_IsP2pGroupCommerceEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(1034, false));
    }
}
