package com.facebook.graphql.executor;

import com.facebook.graphql.consistency.service.GraphQLConsistencyQueue;
import com.facebook.graphql.executor.cache.ConsistencyConfigImpl;
import com.facebook.graphql.executor.cache.ConsistencyConfigImpl.LazyHolder;
import com.facebook.graphql.executor.cache.GraphQLConsistencyMemoryCache;
import com.facebook.graphql.executor.cache.GraphQLDiskCache;
import com.facebook.graphql.executor.cache.GraphQLDiskCacheImpl;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: network_info_write_count */
public class LegacyConsistencyBridge {
    private final ConsistencyConfigImpl f12468a;
    private final GraphQLDiskCache f12469b;
    private final QeAccessor f12470c;
    private final QuickPerformanceLogger f12471d;
    public final GraphQLConsistencyQueue f12472e;

    public static LegacyConsistencyBridge m18540b(InjectorLike injectorLike) {
        return new LegacyConsistencyBridge(LazyHolder.f12473a, GraphQLDiskCacheImpl.m10254a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), GraphQLConsistencyQueue.m18548a(injectorLike));
    }

    @Inject
    public LegacyConsistencyBridge(ConsistencyConfigImpl consistencyConfigImpl, GraphQLDiskCache graphQLDiskCache, QeAccessor qeAccessor, QuickPerformanceLogger quickPerformanceLogger, GraphQLConsistencyQueue graphQLConsistencyQueue) {
        this.f12468a = consistencyConfigImpl;
        this.f12469b = graphQLDiskCache;
        this.f12470c = qeAccessor;
        this.f12471d = quickPerformanceLogger;
        this.f12472e = graphQLConsistencyQueue;
    }

    public final void m18544a(ListenableFuture<?> listenableFuture, GraphQLVisitableModel graphQLVisitableModel) {
        m18543a((ListenableFuture) listenableFuture, m18541b(graphQLVisitableModel));
    }

    @Deprecated
    public final void m18543a(ListenableFuture<?> listenableFuture, CacheVisitor cacheVisitor) {
        int a = this.f12472e.m18553a();
        this.f12472e.m18555a(a, cacheVisitor);
        Futures.m2458a((ListenableFuture) listenableFuture, new 1(this, a, cacheVisitor), (Executor) DirectExecutor.INSTANCE);
    }

    public final void m18542a(GraphQLVisitableModel graphQLVisitableModel) {
        this.f12472e.m18556b(this.f12472e.m18553a(), m18541b(graphQLVisitableModel));
    }

    private CacheVisitor m18541b(GraphQLVisitableModel graphQLVisitableModel) {
        GraphQLConsistencyMemoryCache graphQLConsistencyMemoryCache = new GraphQLConsistencyMemoryCache(this.f12468a, this.f12469b, this.f12471d, this.f12470c);
        graphQLConsistencyMemoryCache.a(graphQLVisitableModel);
        return graphQLConsistencyMemoryCache.d();
    }
}
