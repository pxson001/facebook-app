package com.facebook.cache;

import com.facebook.analytics.cache.CacheTracker;
import com.facebook.cache.TrackedLruCache.Factory;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderMethod;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: selfupdate_starting_operation */
public class CacheModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static Factory m9818a(CacheTracker.Factory factory, Lazy<FbErrorReporter> lazy, MemoryTrimmableRegistry memoryTrimmableRegistry) {
        return new Factory(factory, lazy, memoryTrimmableRegistry);
    }
}
