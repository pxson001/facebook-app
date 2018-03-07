package com.facebook.messaging.threads.graphql;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: com.facebook.messaging.payment.ACTION_PAYMENT_PLATFORM_CONTEXTS_CACHE_UPDATED */
public class Boolean_IsGraphqlSearchThreadEnabledGkGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m17723b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(233, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(233, false));
    }
}
