package com.facebook.messaging.threads.graphql;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.sync.annotations.IsGraphqlBatchedRequestEnabled;
import com.facebook.messaging.sync.annotations.IsGraphqlFetchPinnedThreadEnabled;
import com.facebook.messaging.sync.annotations.IsGraphqlSearchThreadEnabled;

@InjectorModule
/* compiled from: com.facebook.growth.constants.nux_completed */
public class MessagingThreadsGraphQLModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsGraphqlFetchPinnedThreadEnabled
    public static Boolean m17830a(Boolean bool, Boolean bool2) {
        boolean z = bool.booleanValue() && bool2.booleanValue();
        return Boolean.valueOf(z);
    }

    @ProviderMethod
    @IsGraphqlSearchThreadEnabled
    public static Boolean m17831b(Boolean bool, Boolean bool2) {
        boolean z = bool.booleanValue() && bool2.booleanValue();
        return Boolean.valueOf(z);
    }

    @ProviderMethod
    @IsGraphqlBatchedRequestEnabled
    public static Boolean m17832c(Boolean bool, Boolean bool2) {
        boolean z = bool.booleanValue() && bool2.booleanValue();
        return Boolean.valueOf(z);
    }
}
