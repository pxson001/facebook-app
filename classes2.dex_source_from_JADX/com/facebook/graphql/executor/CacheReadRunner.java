package com.facebook.graphql.executor;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.debug.log.BLog;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.consistency.service.GraphQLConsistencyQueue;
import com.facebook.graphql.executor.GraphQLQueryExecutor.CacheProcessor;
import com.facebook.graphql.executor.GraphQLQueryExecutor.DataSource;
import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLRequestLock;
import com.facebook.graphql.executor.GraphQLResult.Builder;
import com.facebook.graphql.executor.abtest.ExperimentsForGraphQLQueryExecutorModule;
import com.facebook.graphql.executor.cache.ConsistencyCacheFactoryImpl;
import com.facebook.graphql.executor.cache.ConsistencyConfig;
import com.facebook.graphql.executor.cache.ConsistencyConfigImpl;
import com.facebook.graphql.executor.cache.GraphQLDiskCache;
import com.facebook.graphql.executor.cache.ImmutableConsistencyMemoryCache;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.facebook.graphql.executor.iface.ConsistencyCacheFactory;
import com.facebook.graphql.executor.iface.ConsistencyMemoryCache;
import com.facebook.graphql.executor.iface.ConsistentMemoryCache;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.SettableFuture;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import javax.annotation.Nullable;

/* compiled from: messenger_global_delete_placeholder_android */
public class CacheReadRunner<T> implements Runnable {
    private static final Class<?> f13968a = CacheReadRunner.class;
    private final GraphQLRequest<T> f13969b;
    private GraphQLQueryAnalyticsEvent f13970c;
    private final CacheProcessor<T> f13971d;
    private final ConsistencyCacheFactoryImpl f13972e;
    private final ReadWriteLock f13973f;
    private final GenericGraphQLMethod f13974g;
    private final GraphQLQueryScheduler f13975h;
    private final AbstractSingleMethodRunner f13976i;
    private final ViewerContext f13977j;
    private final ViewerContextManager f13978k;
    private final Set<ConsistentMemoryCache> f13979l;
    private final AnalyticsLogger f13980m;
    public SettableFuture<GraphQLResult<T>> f13981n = SettableFuture.m1547f();
    private final KeyFactory f13982o;
    private final QeAccessor f13983p;
    private final ConsistencyConfigImpl f13984q;
    private final Lazy<GraphQLDiskCache> f13985r;
    private final QuickPerformanceLogger f13986s;
    private final GraphQLConsistencyQueue f13987t;
    private final int f13988u;

    public CacheReadRunner(ConsistencyCacheFactory consistencyCacheFactory, ReadWriteLock readWriteLock, GenericGraphQLMethod genericGraphQLMethod, GraphQLQueryScheduler graphQLQueryScheduler, SingleMethodRunner singleMethodRunner, GraphQLRequest<T> graphQLRequest, CacheProcessor<T> cacheProcessor, ViewerContextManager viewerContextManager, @Nullable ViewerContext viewerContext, Set<ConsistentMemoryCache> set, GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent, AnalyticsLogger analyticsLogger, KeyFactory keyFactory, QeAccessor qeAccessor, ConsistencyConfig consistencyConfig, Lazy<GraphQLDiskCache> lazy, QuickPerformanceLogger quickPerformanceLogger, GraphQLConsistencyQueue graphQLConsistencyQueue, int i) {
        this.f13972e = consistencyCacheFactory;
        this.f13973f = readWriteLock;
        this.f13974g = genericGraphQLMethod;
        this.f13975h = graphQLQueryScheduler;
        this.f13976i = singleMethodRunner;
        this.f13969b = graphQLRequest;
        this.f13971d = cacheProcessor;
        this.f13977j = viewerContext;
        this.f13978k = viewerContextManager;
        this.f13979l = set;
        this.f13970c = graphQLQueryAnalyticsEvent;
        this.f13980m = analyticsLogger;
        this.f13982o = keyFactory;
        this.f13983p = qeAccessor;
        this.f13984q = consistencyConfig;
        this.f13985r = lazy;
        this.f13986s = quickPerformanceLogger;
        this.f13987t = graphQLConsistencyQueue;
        this.f13988u = i;
    }

    private void m20303b() {
        Throwable th;
        Object obj = 1;
        TracerDetour.a("CacheReadRunner.tryFetch", -1779560436);
        try {
            String a = this.f13969b.m11601a(this.f13982o);
            GraphQLRequestLock b;
            try {
                DataSource dataSource;
                GraphQLResult a2;
                DataSource dataSource2;
                GraphQLResult graphQLResult;
                GraphQLRequestLock graphQLRequestLock;
                if (this.f13969b.f7083a.f7115g) {
                    b = this.f13975h.m10396b(false, ImmutableSet.of(a));
                    try {
                        dataSource = DataSource.DB_CACHE;
                        if (b.mo3496a(dataSource) != null) {
                            throw new IllegalStateException("Unexpected upstream cache lock exception");
                        }
                        a2 = RunnerHelper.m20472a(this.f13970c, this.f13971d, this.f13986s, 3211302, this.f13988u);
                    } catch (Throwable th2) {
                        th = th2;
                        if (b != null) {
                            b.m20451a(this.f13969b.m11615p());
                        }
                        throw th;
                    }
                }
                a2 = null;
                dataSource = null;
                b = null;
                if (a2 == null && this.f13969b.f7083a.f7117i) {
                    if (b != null) {
                        b.m20458e();
                    }
                    GraphQLRequestLock b2 = this.f13975h.m10396b(true, ImmutableSet.of(a));
                    try {
                        dataSource2 = DataSource.NETWORK;
                        GraphQLRequestLock a3 = b2.mo3496a(dataSource2);
                        if (a3 != null) {
                            DataSource dataSource3 = DataSource.MEMORY_CACHE;
                            GraphQLRequestLock graphQLRequestLock2 = a3;
                            int i = 0;
                            while (graphQLRequestLock2 != null) {
                                this.f13969b.m11605b();
                                graphQLRequestLock2.m20459f();
                                graphQLRequestLock2 = b2.mo3496a(dataSource3);
                                i++;
                            }
                            this.f13986s.mo465b(3211302, this.f13988u, "network_blocker_count", String.valueOf(i));
                            if (this.f13969b.f7083a.f7115g) {
                                dataSource3 = DataSource.DB_CACHE;
                                if (b2.mo3496a(dataSource3) != null) {
                                    throw new IllegalStateException("Unexpected upstream lock exception");
                                }
                                a2 = RunnerHelper.m20472a(this.f13970c, this.f13971d, this.f13986s, 3211302, this.f13988u);
                                if (a2 != null) {
                                    m20307f();
                                }
                            }
                            if (a2 == null) {
                                dataSource2 = DataSource.NETWORK;
                                if (b2.mo3496a(dataSource2) != null) {
                                    throw new IllegalStateException("Unexpected upstream lock exception");
                                }
                            }
                            dataSource2 = dataSource3;
                            graphQLResult = a2;
                            graphQLRequestLock = b2;
                        }
                        graphQLResult = RunnerHelper.m20471a(this.f13970c, this.f13974g, this.f13969b, this.f13976i, this.f13986s, 3211302, this.f13988u);
                        graphQLRequestLock = b2;
                    } catch (Throwable th3) {
                        th = th3;
                        b = b2;
                        if (b != null) {
                            b.m20451a(this.f13969b.m11615p());
                        }
                        throw th;
                    }
                }
                dataSource2 = dataSource;
                GraphQLResult graphQLResult2 = a2;
                graphQLRequestLock = b;
                graphQLResult = graphQLResult2;
                if (graphQLResult == null) {
                    try {
                        m20304c();
                        FutureDetour.a(this.f13981n, null, -1579565680);
                        if (graphQLRequestLock != null) {
                            graphQLRequestLock.m20451a(this.f13969b.m11615p());
                        }
                        TracerDetour.a(-195896877);
                        return;
                    } catch (Throwable th4) {
                        Throwable th5 = th4;
                        b = graphQLRequestLock;
                        th = th5;
                        if (b != null) {
                            b.m20451a(this.f13969b.m11615p());
                        }
                        throw th;
                    }
                }
                Collection collection;
                ConsistencyMemoryCache consistencyMemoryCache;
                GraphQLResult b3 = this.f13971d.mo2684b(graphQLResult);
                m20300a(b3);
                Set set = Collections.EMPTY_SET;
                if (!(this.f13969b.m11616s() && this.f13983p.mo596a(ExperimentsForGraphQLQueryExecutorModule.a, false))) {
                    obj = null;
                }
                if (dataSource2 == DataSource.NETWORK) {
                    if (obj != null) {
                        MutableFlatBuffer b4 = m20302b(b3);
                        if (b4 != null) {
                            this.f13969b.m11605b();
                            Collection hashSet = new HashSet();
                            set = new HashSet();
                            IdFindingTraversal.a(b4.m21533a(), this.f13969b.m11605b().m11332m(), this.f13984q, set, hashSet);
                            Integer.valueOf(set.size());
                            this.f13969b.m11605b();
                            b3 = Builder.m21595a(b3).m21602b(hashSet).m21600a();
                            m20305d();
                            m20301a("num_tags", hashSet);
                            m20301a("num_consistent_fields", set);
                        }
                        collection = set;
                        graphQLResult = graphQLRequestLock.m20450a(b3, this.f13986s, 3211302, this.f13988u);
                        this.f13970c.mo1466a("state_lock", "success");
                        RunnerHelper.m20473a(graphQLRequestLock, graphQLResult, this.f13970c, this.f13981n, this.f13986s, 3211302, this.f13988u);
                        RunnerHelper.m20476a(this.f13969b, graphQLResult);
                        if (dataSource2 == DataSource.NETWORK && (this.f13969b.f7083a.f7116h || this.f13969b.f7084b)) {
                            if (this.f13969b.f7084b) {
                                consistencyMemoryCache = null;
                            } else {
                                if (obj == null) {
                                    consistencyMemoryCache = new ImmutableConsistencyMemoryCache(collection, this.f13985r);
                                    if (!consistencyMemoryCache.b()) {
                                        ((GraphQLReadMutex) graphQLRequestLock.f14132f).f14134a = consistencyMemoryCache;
                                    }
                                } else {
                                    consistencyMemoryCache = this.f13972e.m10245a();
                                    RunnerHelper.m20477a(graphQLResult, consistencyMemoryCache);
                                    ((GraphQLReadMutex) graphQLRequestLock.f14132f).f14134a = consistencyMemoryCache.d();
                                }
                                m20306e();
                                this.f13987t.m18556b(this.f13987t.m18553a(), ((GraphQLReadMutex) graphQLRequestLock.f14132f).f14134a);
                            }
                            RunnerHelper.m20475a(graphQLRequestLock, consistencyMemoryCache, this.f13970c, this.f13979l, this.f13986s, 3211302, this.f13988u);
                            RunnerHelper.m20474a(graphQLRequestLock, graphQLResult, consistencyMemoryCache, this.f13970c, this.f13971d, this.f13969b, this.f13986s, 3211302, this.f13988u);
                        }
                        if (graphQLRequestLock != null) {
                            graphQLRequestLock.m20451a(this.f13969b.m11615p());
                        }
                        TracerDetour.a(243615852);
                    } else if (b3.f6200b) {
                        Object f = b3.m10402f();
                        m20305d();
                        m20301a("num_tags", f);
                        Integer.valueOf(f.size());
                    }
                }
                Object obj2 = set;
                graphQLResult = graphQLRequestLock.m20450a(b3, this.f13986s, 3211302, this.f13988u);
                this.f13970c.mo1466a("state_lock", "success");
                RunnerHelper.m20473a(graphQLRequestLock, graphQLResult, this.f13970c, this.f13981n, this.f13986s, 3211302, this.f13988u);
                RunnerHelper.m20476a(this.f13969b, graphQLResult);
                if (this.f13969b.f7084b) {
                    consistencyMemoryCache = null;
                } else {
                    if (obj == null) {
                        consistencyMemoryCache = this.f13972e.m10245a();
                        RunnerHelper.m20477a(graphQLResult, consistencyMemoryCache);
                        ((GraphQLReadMutex) graphQLRequestLock.f14132f).f14134a = consistencyMemoryCache.d();
                    } else {
                        consistencyMemoryCache = new ImmutableConsistencyMemoryCache(collection, this.f13985r);
                        if (consistencyMemoryCache.b()) {
                            ((GraphQLReadMutex) graphQLRequestLock.f14132f).f14134a = consistencyMemoryCache;
                        }
                    }
                    m20306e();
                    this.f13987t.m18556b(this.f13987t.m18553a(), ((GraphQLReadMutex) graphQLRequestLock.f14132f).f14134a);
                }
                RunnerHelper.m20475a(graphQLRequestLock, consistencyMemoryCache, this.f13970c, this.f13979l, this.f13986s, 3211302, this.f13988u);
                RunnerHelper.m20474a(graphQLRequestLock, graphQLResult, consistencyMemoryCache, this.f13970c, this.f13971d, this.f13969b, this.f13986s, 3211302, this.f13988u);
                if (graphQLRequestLock != null) {
                    graphQLRequestLock.m20451a(this.f13969b.m11615p());
                }
                TracerDetour.a(243615852);
            } catch (Throwable th6) {
                th = th6;
                b = null;
                if (b != null) {
                    b.m20451a(this.f13969b.m11615p());
                }
                throw th;
            }
        } catch (Throwable th7) {
            TracerDetour.a(1199121319);
        }
    }

    private static MutableFlatBuffer m20302b(GraphQLResult graphQLResult) {
        Object obj = graphQLResult.f6203e;
        if (obj instanceof MutableFlattenable) {
            return ((MutableFlattenable) obj).w_();
        }
        return null;
    }

    public void run() {
        HoneyAnalyticsEvent a;
        Throwable th;
        short s;
        Throwable th2;
        if (this.f13973f.readLock().tryLock()) {
            TracerDetour.a("CacheReadRunner.run", 1989714538);
            short s2 = (short) 2;
            try {
                this.f13986s.mo445a(3211302, this.f13988u, (short) 15);
                this.f13970c.mo1465a("dequeue");
                if (this.f13969b.m11613k() != null) {
                    this.f13978k.mo214b(this.f13969b.m11613k());
                } else if (this.f13977j != null) {
                    this.f13978k.mo214b(this.f13977j);
                }
                try {
                    m20303b();
                    if (!(this.f13969b.m11613k() == null && this.f13977j == null)) {
                        this.f13978k.mo219f();
                    }
                    this.f13973f.readLock().unlock();
                    a = this.f13970c.mo1460a();
                    if (a != null) {
                        this.f13980m.mo526a(a);
                    }
                    this.f13970c = GraphQLQueryAnalyticsEventPool.f6284a;
                } catch (Throwable e) {
                    BLog.a(f13968a, e, "Exception during graphql executor query", new Object[0]);
                    s2 = (short) 3;
                    m20304c();
                    this.f13970c.mo1464a((Exception) e);
                    this.f13981n.mo222a(e);
                    if (!(this.f13969b.m11613k() == null && this.f13977j == null)) {
                        this.f13978k.mo219f();
                    }
                    this.f13973f.readLock().unlock();
                    a = this.f13970c.mo1460a();
                    if (a != null) {
                        this.f13980m.mo526a(a);
                    }
                    this.f13970c = GraphQLQueryAnalyticsEventPool.f6284a;
                } catch (Throwable e2) {
                    th = e2;
                    s = s2;
                    th2 = th;
                    try {
                        if (!(this.f13969b.m11613k() == null && this.f13977j == null)) {
                            this.f13978k.mo219f();
                        }
                        this.f13973f.readLock().unlock();
                        HoneyAnalyticsEvent a2 = this.f13970c.mo1460a();
                        if (a2 != null) {
                            this.f13980m.mo526a(a2);
                        }
                        this.f13970c = GraphQLQueryAnalyticsEventPool.f6284a;
                    } catch (Throwable th3) {
                        th2 = th3;
                        TracerDetour.a(-66054554);
                        this.f13986s.mo466b(3211302, this.f13988u, s);
                        throw th2;
                    }
                }
                TracerDetour.a(-1644100179);
                this.f13986s.mo466b(3211302, this.f13988u, s2);
                return;
            } catch (Throwable e22) {
                th = e22;
                s = (short) 2;
                th2 = th;
                TracerDetour.a(-66054554);
                this.f13986s.mo466b(3211302, this.f13988u, s);
                throw th2;
            }
        }
        this.f13981n.cancel(false);
        this.f13986s.markerCancel(3211302, this.f13988u);
    }

    private void m20304c() {
        this.f13986s.mo445a(3211302, this.f13988u, (short) 20);
        this.f13970c.mo1470b("return_to_caller");
    }

    private void m20305d() {
        this.f13986s.mo445a(3211302, this.f13988u, (short) 150);
        this.f13970c.mo1465a("network_response_initial_scan");
    }

    private void m20306e() {
        this.f13986s.mo445a(3211302, this.f13988u, (short) 151);
        this.f13970c.mo1465a("populate_consistency_memory_cache");
    }

    private void m20300a(GraphQLResult graphQLResult) {
        if (this.f13986s.mo484j(3211302, this.f13988u)) {
            MutableFlatBuffer b = m20302b(graphQLResult);
            if (b != null) {
                ByteBuffer byteBuffer = b.f15021a;
                if (byteBuffer != null) {
                    this.f13986s.mo465b(3211302, this.f13988u, "buffer_capacity", String.valueOf(byteBuffer.capacity()));
                }
            }
        }
    }

    private void m20301a(String str, Collection collection) {
        if (this.f13986s.mo484j(3211302, this.f13988u)) {
            this.f13986s.mo465b(3211302, this.f13988u, str, String.valueOf(collection.size()));
        }
    }

    private void m20307f() {
        this.f13986s.mo464b(3211302, this.f13988u, "network_dedupped");
    }
}
