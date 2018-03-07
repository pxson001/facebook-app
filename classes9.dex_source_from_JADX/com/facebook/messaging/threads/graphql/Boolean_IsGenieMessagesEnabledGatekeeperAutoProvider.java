package com.facebook.messaging.threads.graphql;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: com.facebook.messaging.sms.DOWNLOAD_MMS */
public class Boolean_IsGenieMessagesEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(908, false));
    }
}
