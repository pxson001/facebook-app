package com.facebook.graphql.executor;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.consistency.service.GraphQLConsistencyQueue;
import com.facebook.graphql.executor.GraphQLQueryExecutor.CacheProcessor;
import com.facebook.graphql.executor.cache.ConsistencyCacheFactoryImpl;
import com.facebook.graphql.executor.cache.ConsistencyConfig;
import com.facebook.graphql.executor.cache.ConsistencyConfigImpl;
import com.facebook.graphql.executor.cache.GraphQLDiskCache;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.facebook.graphql.executor.iface.ConsistencyCacheFactory;
import com.facebook.graphql.executor.iface.ConsistentMemoryCache;
import com.facebook.graphql.executor.iface.STATICDI_MULTIBIND_PROVIDER$ConsistentMemoryCache;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.NeedsApplicationInjector;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import javax.inject.Inject;

@ContextScoped
/* compiled from: messenger_hot_emojilikes_thread_details */
public class CacheReadRunnerFactory {
    private static CacheReadRunnerFactory f13952o;
    private static final Object f13953p = new Object();
    private final ConsistencyCacheFactoryImpl f13954a;
    private final Lazy<GenericGraphQLMethod> f13955b;
    private final GraphQLQueryScheduler f13956c;
    private final AbstractSingleMethodRunner f13957d;
    private final ViewerContextManager f13958e;
    private final ViewerContextManager f13959f;
    private final Set<ConsistentMemoryCache> f13960g;
    private final AnalyticsLogger f13961h;
    private final KeyFactory f13962i;
    private final QeAccessor f13963j;
    private final ConsistencyConfigImpl f13964k;
    private final Lazy<GraphQLDiskCache> f13965l;
    private final QuickPerformanceLogger f13966m;
    private final GraphQLConsistencyQueue f13967n;

    private static CacheReadRunnerFactory m20297b(InjectorLike injectorLike) {
        return new CacheReadRunnerFactory(ConsistencyCacheFactoryImpl.m10244b(injectorLike), IdBasedLazy.m1808a(injectorLike, 2161), GraphQLQueryScheduler.m10388a(injectorLike), SingleMethodRunnerImpl.m11724a(injectorLike), ViewerContextManagerProvider.m2496b(injectorLike), ViewerContextManagerProvider.m2496b(injectorLike.getApplicationInjector()), STATICDI_MULTIBIND_PROVIDER$ConsistentMemoryCache.m10387a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), KeyFactory.m10333b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), ConsistencyConfigMethodAutoProvider.m20299a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2183), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), GraphQLConsistencyQueue.m18548a(injectorLike));
    }

    @Inject
    public CacheReadRunnerFactory(ConsistencyCacheFactory consistencyCacheFactory, Lazy<GenericGraphQLMethod> lazy, GraphQLQueryScheduler graphQLQueryScheduler, SingleMethodRunner singleMethodRunner, ViewerContextManager viewerContextManager, @NeedsApplicationInjector ViewerContextManager viewerContextManager2, Set<ConsistentMemoryCache> set, AnalyticsLogger analyticsLogger, KeyFactory keyFactory, QeAccessor qeAccessor, ConsistencyConfig consistencyConfig, Lazy<GraphQLDiskCache> lazy2, QuickPerformanceLogger quickPerformanceLogger, GraphQLConsistencyQueue graphQLConsistencyQueue) {
        this.f13954a = consistencyCacheFactory;
        this.f13955b = lazy;
        this.f13956c = graphQLQueryScheduler;
        this.f13957d = singleMethodRunner;
        this.f13958e = viewerContextManager;
        this.f13959f = viewerContextManager2;
        this.f13960g = set;
        this.f13961h = analyticsLogger;
        this.f13962i = keyFactory;
        this.f13963j = qeAccessor;
        this.f13964k = consistencyConfig;
        this.f13965l = lazy2;
        this.f13966m = quickPerformanceLogger;
        this.f13967n = graphQLConsistencyQueue;
    }

    public static CacheReadRunnerFactory m20295a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CacheReadRunnerFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13953p) {
                CacheReadRunnerFactory cacheReadRunnerFactory;
                if (a2 != null) {
                    cacheReadRunnerFactory = (CacheReadRunnerFactory) a2.mo818a(f13953p);
                } else {
                    cacheReadRunnerFactory = f13952o;
                }
                if (cacheReadRunnerFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m20297b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13953p, b3);
                        } else {
                            f13952o = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = cacheReadRunnerFactory;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final <T> CacheReadRunner<T> m20298a(ReadWriteLock readWriteLock, GraphQLRequest<T> graphQLRequest, CacheProcessor<T> cacheProcessor, GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent, int i) {
        return new CacheReadRunner(this.f13954a, readWriteLock, m20296a((GraphQLRequest) graphQLRequest), this.f13956c, this.f13957d, graphQLRequest, cacheProcessor, this.f13959f, this.f13958e.mo215b(), this.f13960g, graphQLQueryAnalyticsEvent, this.f13961h, this.f13962i, this.f13963j, this.f13964k, this.f13965l, this.f13966m, this.f13967n, i);
    }

    private GenericGraphQLMethod m20296a(GraphQLRequest graphQLRequest) {
        GenericGraphQLMethod genericGraphQLMethod = graphQLRequest.f7102u;
        return genericGraphQLMethod != null ? genericGraphQLMethod : (GenericGraphQLMethod) this.f13955b.get();
    }
}
