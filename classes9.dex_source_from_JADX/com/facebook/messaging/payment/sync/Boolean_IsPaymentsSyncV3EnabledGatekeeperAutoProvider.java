package com.facebook.messaging.payment.sync;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: fetchP2PSendEligibility */
public class Boolean_IsPaymentsSyncV3EnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m15223b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(958, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(958, false));
    }
}
