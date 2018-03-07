package com.facebook.messaging.deliveryreceipt;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: maxMessageSize */
public class Boolean_IsDisplayOfDeliveryReceiptsEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(201, false));
    }
}
