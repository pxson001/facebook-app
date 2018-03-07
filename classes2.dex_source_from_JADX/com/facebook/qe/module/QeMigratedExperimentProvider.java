package com.facebook.qe.module;

import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache;
import com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: unnecessary */
public class QeMigratedExperimentProvider {
    public final QuickExperimentMemoryCache f1928a;

    public static QeMigratedExperimentProvider m3848b(InjectorLike injectorLike) {
        return new QeMigratedExperimentProvider(QuickExperimentMemoryCacheImpl.m3605a(injectorLike));
    }

    @Inject
    public QeMigratedExperimentProvider(QuickExperimentMemoryCache quickExperimentMemoryCache) {
        this.f1928a = quickExperimentMemoryCache;
    }
}
