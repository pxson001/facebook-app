package com.facebook.messaging.threads.graphql;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: com.facebook.messaging.sms.E2E_TEST_RECEIVING_SMS */
public class Boolean_IsFetchWithoutFormerUsersEnabledGkGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(222, false));
    }
}
