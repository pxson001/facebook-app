package com.facebook.graphql.executor;

import com.facebook.api.feedcache.memory.FeedUnitCache;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLRequestLock;
import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLWriteLock;
import com.facebook.graphql.executor.cache.ConsistencyCacheFactoryImpl;
import com.facebook.graphql.executor.cache.GraphQLDiskCache;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.executor.iface.ConsistencyCacheFactory;
import com.facebook.graphql.executor.iface.ConsistencyMemoryCache;
import com.facebook.graphql.executor.iface.ConsistentMemoryCache;
import com.facebook.graphql.executor.iface.STATICDI_MULTIBIND_PROVIDER$ConsistentMemoryCache;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.google.common.base.Preconditions;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: saved_collection */
public class GraphQLCacheAggregator {
    private final Lazy<GraphQLDiskCache> f6180a;
    private final Set<ConsistentMemoryCache> f6181b;
    private final DefaultAndroidThreadUtil f6182c;
    private final ConsistencyCacheFactoryImpl f6183d;
    private final GraphQLQueryScheduler f6184e;
    private final ExecutorService f6185f;

    public static GraphQLCacheAggregator m10380b(InjectorLike injectorLike) {
        return new GraphQLCacheAggregator(IdBasedSingletonScopeProvider.m1810b(injectorLike, 2183), STATICDI_MULTIBIND_PROVIDER$ConsistentMemoryCache.m10387a(injectorLike), DefaultAndroidThreadUtil.m1646b(injectorLike), ConsistencyCacheFactoryImpl.m10244b(injectorLike), GraphQLQueryScheduler.m10388a(injectorLike), C0055x2995691a.m1881a(injectorLike));
    }

    public static GraphQLCacheAggregator m10379a(InjectorLike injectorLike) {
        return m10380b(injectorLike);
    }

    @Inject
    public GraphQLCacheAggregator(Lazy<GraphQLDiskCache> lazy, Set<ConsistentMemoryCache> set, AndroidThreadUtil androidThreadUtil, ConsistencyCacheFactory consistencyCacheFactory, GraphQLQueryScheduler graphQLQueryScheduler, ExecutorService executorService) {
        this.f6180a = lazy;
        this.f6181b = set;
        this.f6182c = androidThreadUtil;
        this.f6183d = consistencyCacheFactory;
        this.f6184e = graphQLQueryScheduler;
        this.f6185f = executorService;
    }

    public final void m10386a(GraphQLVisitableModel graphQLVisitableModel) {
        this.f6182c.m1655b();
        if (graphQLVisitableModel != null) {
            Preconditions.checkArgument(!(graphQLVisitableModel instanceof TypeModel));
            ConsistencyMemoryCache a = this.f6183d.m10245a();
            a.a(graphQLVisitableModel);
            if (!a.b()) {
                m10385a(a);
            }
        }
    }

    public final void m10385a(ConsistencyMemoryCache consistencyMemoryCache) {
        this.f6182c.m1655b();
        GraphQLRequestLock a = this.f6184e.m10395a(consistencyMemoryCache.d());
        a.mo3497g();
        a.m32020a(true);
        try {
            consistencyMemoryCache.c();
        } finally {
            a.m20458e();
        }
    }

    public final void m10384a(CacheVisitor cacheVisitor) {
        this.f6182c.m1655b();
        m10381b(cacheVisitor);
        m10382c(cacheVisitor);
    }

    final void m10383a(GraphQLWriteLock graphQLWriteLock) {
        graphQLWriteLock.m20456c();
        m10381b(graphQLWriteLock.m32022h());
        graphQLWriteLock.m20457d();
        m10382c(graphQLWriteLock.m32022h());
    }

    private void m10381b(CacheVisitor cacheVisitor) {
        for (FeedUnitCache a : this.f6181b) {
            a.m10556a(cacheVisitor);
        }
    }

    private void m10382c(CacheVisitor cacheVisitor) {
        ((GraphQLDiskCache) this.f6180a.get()).mo1442a(cacheVisitor);
    }
}
