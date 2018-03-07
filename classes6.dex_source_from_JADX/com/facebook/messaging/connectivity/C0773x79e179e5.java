package com.facebook.messaging.connectivity;

import com.facebook.inject.AbstractProvider;

/* compiled from: is_offsite_ad */
public class C0773x79e179e5 extends AbstractProvider<ConnectionStatusNotification> {
    public Object get() {
        return MessagesConnectivityModule.c((ConnectionStatusNotificationProvider) getOnDemandAssistedProviderForStaticDi(ConnectionStatusNotificationProvider.class));
    }
}
