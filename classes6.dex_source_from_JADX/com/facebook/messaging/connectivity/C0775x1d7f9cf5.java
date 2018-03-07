package com.facebook.messaging.connectivity;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: is_nested_story_length */
public class C0775x1d7f9cf5 extends AbstractProvider<ConnectionStatusNotification> {
    public static ConnectionStatusNotification m18931a(InjectorLike injectorLike) {
        return MessagesConnectivityModule.b((ConnectionStatusNotificationProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ConnectionStatusNotificationProvider.class));
    }

    public Object get() {
        return MessagesConnectivityModule.b((ConnectionStatusNotificationProvider) getOnDemandAssistedProviderForStaticDi(ConnectionStatusNotificationProvider.class));
    }
}
