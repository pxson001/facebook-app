package com.facebook.messaging.threads.graphql;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: com.facebook.messaging.payment.ACTION_PAYMENT_REQUEST_CACHE_UPDATED */
public class Boolean_IsGraphqlModeEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m17722b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(232, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(232, false));
    }
}
