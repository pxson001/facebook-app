package com.facebook.messaging.threads.graphql;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: com.facebook.messaging.sms.COMPOSE_SMS */
public class Boolean_IsGraphqlBatchedRequestEnabledGkGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m17720b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(230, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(230, false));
    }
}
