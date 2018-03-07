package com.facebook.messaging.threads.graphql;

import com.facebook.inject.AbstractProvider;

/* compiled from: com.facebook.messaging.payment.ACTION_PAYMENT_CARD_UPDATED */
public class Boolean_IsGraphqlSearchThreadEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return MessagingThreadsGraphQLModule.m17831b(Boolean_IsGraphqlModeEnabledGatekeeperAutoProvider.m17722b(this), Boolean_IsGraphqlSearchThreadEnabledGkGatekeeperAutoProvider.m17723b(this));
    }
}
