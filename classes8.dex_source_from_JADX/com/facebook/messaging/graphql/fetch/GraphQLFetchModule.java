package com.facebook.messaging.graphql.fetch;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.sync.annotations.IsCustomTagEnabled;

@InjectorModule
/* compiled from: tosTermsUrl */
public class GraphQLFetchModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsCustomTagEnabled
    public static Boolean m1693a() {
        return Boolean.valueOf(false);
    }
}
