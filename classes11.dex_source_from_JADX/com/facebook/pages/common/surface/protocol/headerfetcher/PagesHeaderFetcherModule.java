package com.facebook.pages.common.surface.protocol.headerfetcher;

import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import com.google.common.annotations.VisibleForTesting;

@InjectorModule
/* compiled from: reset_period */
public class PagesHeaderFetcherModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @VisibleForTesting
    public static GraphQLCacheManager getInstanceForTest_GraphQLCacheManager(FbInjector fbInjector) {
        return GraphQLCacheManager.a(fbInjector);
    }
}
