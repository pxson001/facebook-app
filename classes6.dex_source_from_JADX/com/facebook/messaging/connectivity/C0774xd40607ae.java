package com.facebook.messaging.connectivity;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: is_new_high_score */
public class C0774xd40607ae extends AbstractProvider<ConnectionStatusNotification> {
    private static ConnectionStatusNotification m18930b(InjectorLike injectorLike) {
        return MessagesConnectivityModule.a((ConnectionStatusNotificationProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ConnectionStatusNotificationProvider.class));
    }

    public Object get() {
        return MessagesConnectivityModule.a((ConnectionStatusNotificationProvider) getOnDemandAssistedProviderForStaticDi(ConnectionStatusNotificationProvider.class));
    }
}
