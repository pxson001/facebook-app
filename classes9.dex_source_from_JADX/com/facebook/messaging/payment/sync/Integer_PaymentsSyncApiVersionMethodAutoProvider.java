package com.facebook.messaging.payment.sync;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: fetchP2PEnabled */
public class Integer_PaymentsSyncApiVersionMethodAutoProvider extends AbstractProvider<Integer> {
    public static Integer m15224b(InjectorLike injectorLike) {
        return PaymentsSyncModule.m15239a(Boolean_IsPaymentsSyncV3EnabledGatekeeperAutoProvider.m15223b(injectorLike));
    }

    public Object get() {
        return PaymentsSyncModule.m15239a(Boolean_IsPaymentsSyncV3EnabledGatekeeperAutoProvider.m15223b(this));
    }
}
