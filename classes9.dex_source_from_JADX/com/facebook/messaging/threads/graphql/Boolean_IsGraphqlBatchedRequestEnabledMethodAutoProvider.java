package com.facebook.messaging.threads.graphql;

import com.facebook.inject.AbstractProvider;

/* compiled from: com.facebook.messaging.payment.ACTION_PRESET_CARD_ADDED */
public class Boolean_IsGraphqlBatchedRequestEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return MessagingThreadsGraphQLModule.m17832c(Boolean_IsGraphqlModeEnabledGatekeeperAutoProvider.m17722b(this), Boolean_IsGraphqlBatchedRequestEnabledGkGatekeeperAutoProvider.m17720b(this));
    }
}
