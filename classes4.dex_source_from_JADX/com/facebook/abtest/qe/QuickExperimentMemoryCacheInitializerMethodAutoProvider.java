package com.facebook.abtest.qe;

import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache;
import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache.QuickExperimentMemoryCacheInitializer;
import com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheImpl;
import com.facebook.inject.AbstractProvider;

/* compiled from: … */
public class QuickExperimentMemoryCacheInitializerMethodAutoProvider extends AbstractProvider<QuickExperimentMemoryCacheInitializer> {
    public Object get() {
        return QuickExperimentClientModule.a((QuickExperimentMemoryCache) QuickExperimentMemoryCacheImpl.a(this));
    }
}
