package com.facebook.graphql.executor;

import android.util.Pair;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.feedcache.memory.FeedUnitCache;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLQueryExecutor.CacheProcessor;
import com.facebook.graphql.executor.GraphQLQueryExecutor.DataSource;
import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLRequestLock;
import com.facebook.graphql.executor.GraphQLResponseParser.GraphQLBatchResultCallback;
import com.facebook.graphql.executor.GraphQLResult.Builder;
import com.facebook.graphql.executor.cache.ConsistencyCacheFactoryImpl;
import com.facebook.graphql.executor.cache.GraphQLDiskCache;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.executor.iface.ConsistencyCacheFactory;
import com.facebook.graphql.executor.iface.ConsistencyMemoryCache;
import com.facebook.graphql.executor.iface.ConsistentMemoryCache;
import com.facebook.graphql.query.GraphQLRefParam;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import javax.inject.Inject;

/* compiled from: sdcard */
public class GraphQLBatchRunner implements Runnable {
    private static final Class<?> f2956a = GraphQLBatchRunner.class;
    public final Lazy<GraphQLDiskCache> f2957b;
    private final ConsistencyCacheFactoryImpl f2958c;
    private final GraphQLQueryScheduler f2959d;
    private final ReadWriteLock f2960e;
    private final GenericGraphQLBatchMethod f2961f;
    private final AbstractSingleMethodRunner f2962g;
    private final DefaultCacheProcessorFactory f2963h;
    public final GraphQLBatchRequest f2964i;
    public GraphQLQueryScheduler$GraphQLBatchRequestLock f2965j;
    public GraphQLQueryAnalyticsEvent f2966k;
    private final AnalyticsLogger f2967l;
    private final AbstractFbErrorReporter f2968m;
    private final KeyFactory f2969n;
    private final Set<ConsistentMemoryCache> f2970o;
    private final QuickPerformanceLogger f2971p;
    private final int f2972q;
    public int f2973r;
    public int f2974s;
    public Map<GraphQLRequest, SingleRequestState> f2975t = Maps.d();
    private final GraphQLBatchResultCallback f2976u = new C01371(this);

    /* compiled from: sdcard */
    class C01371 implements GraphQLBatchResultCallback {
        final /* synthetic */ GraphQLBatchRunner f2977a;

        C01371(GraphQLBatchRunner graphQLBatchRunner) {
            this.f2977a = graphQLBatchRunner;
        }

        public final void m3215a(GraphQLResult graphQLResult, GraphQLRequest graphQLRequest) {
            GraphQLBatchRunner graphQLBatchRunner = this.f2977a;
            graphQLBatchRunner.f2973r++;
            SingleRequestState singleRequestState = (SingleRequestState) this.f2977a.f2975t.get(graphQLRequest);
            GraphQLResult a = this.f2977a.f2965j.a(singleRequestState.f2982a.b(graphQLResult));
            singleRequestState.f2984c.add(a);
            Builder a2 = Builder.a(a);
            a2.d = this.f2977a.f2965j;
            this.f2977a.f2964i.a(graphQLRequest, this.f2977a.f2965j.c(a2.a()));
            this.f2977a.f2965j.b();
            this.f2977a.f2966k.a(graphQLRequest);
        }

        public final void m3216a(Exception exception, GraphQLRequest graphQLRequest) {
            GraphQLBatchRunner graphQLBatchRunner = this.f2977a;
            graphQLBatchRunner.f2974s++;
            this.f2977a.f2966k.a(graphQLRequest, exception);
            this.f2977a.f2966k.a(graphQLRequest);
            this.f2977a.f2965j.a(null);
            this.f2977a.f2964i.a(graphQLRequest, exception);
            this.f2977a.f2965j.b();
        }

        public final void m3214a() {
            this.f2977a.f2965j.a(null);
            this.f2977a.f2964i.f();
            this.f2977a.f2965j.b();
        }
    }

    /* compiled from: sdcard */
    public class SingleRequestState {
        public CacheProcessor f2982a;
        DataSource f2983b;
        List<GraphQLResult> f2984c = Lists.a();
    }

    @Inject
    public GraphQLBatchRunner(@Assisted ReadWriteLock readWriteLock, @Assisted GraphQLBatchRequest graphQLBatchRequest, @Assisted GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent, @Assisted int i, Lazy<GraphQLDiskCache> lazy, ConsistencyCacheFactory consistencyCacheFactory, GraphQLQueryScheduler graphQLQueryScheduler, GenericGraphQLBatchMethod genericGraphQLBatchMethod, SingleMethodRunner singleMethodRunner, DefaultCacheProcessorFactory defaultCacheProcessorFactory, AnalyticsLogger analyticsLogger, FbErrorReporter fbErrorReporter, KeyFactory keyFactory, Set<ConsistentMemoryCache> set, QuickPerformanceLogger quickPerformanceLogger) {
        this.f2957b = lazy;
        this.f2958c = consistencyCacheFactory;
        this.f2959d = graphQLQueryScheduler;
        this.f2960e = readWriteLock;
        this.f2964i = graphQLBatchRequest;
        this.f2961f = genericGraphQLBatchMethod;
        this.f2962g = singleMethodRunner;
        this.f2963h = defaultCacheProcessorFactory;
        this.f2966k = graphQLQueryAnalyticsEvent;
        this.f2967l = analyticsLogger;
        this.f2968m = fbErrorReporter;
        this.f2964i.a(this.f2976u);
        this.f2969n = keyFactory;
        this.f2970o = set;
        this.f2972q = i;
        this.f2971p = quickPerformanceLogger;
    }

    public final void run() {
        HoneyClientEvent a;
        Throwable e;
        HoneyClientEvent a2;
        short s = (short) 3;
        if (this.f2960e.readLock().tryLock()) {
            this.f2966k.a("dequeue");
            this.f2971p.a(3211303, this.f2972q, (short) 15);
            try {
                m3210e();
                this.f2960e.readLock().unlock();
                a = this.f2966k.a();
                m3213h();
                this.f2971p.b(3211303, this.f2972q, (short) 2);
                if (a != null) {
                    this.f2967l.a(a);
                }
                this.f2966k = GraphQLQueryAnalyticsEventPool.a;
                return;
            } catch (Throwable e2) {
                BLog.a(f2956a, "Exception during graphql executor query", e2);
                this.f2964i.a(e2);
                this.f2966k.a(e2);
                this.f2960e.readLock().unlock();
                a = this.f2966k.a();
                m3213h();
                this.f2971p.b(3211303, this.f2972q, (short) 3);
                if (a != null) {
                    this.f2967l.a(a);
                }
                this.f2966k = GraphQLQueryAnalyticsEventPool.a;
                return;
            } catch (Throwable th) {
                e2 = th;
                this.f2960e.readLock().unlock();
                a2 = this.f2966k.a();
                m3213h();
                this.f2971p.b(3211303, this.f2972q, s);
                if (a2 != null) {
                    this.f2967l.a(a2);
                }
                this.f2966k = GraphQLQueryAnalyticsEventPool.a;
                throw e2;
            }
        }
        this.f2964i.a(new IOException("Unable to acquire run lock, query runner is shut down"));
        this.f2971p.markerCancel(3211303, this.f2972q);
    }

    private int m3203a() {
        int b;
        try {
            b = m3207b();
            this.f2966k.a("local_db_read", String.valueOf(b));
            m3206a("num_cache_hits", b);
            this.f2971p.b(3211303, this.f2972q, "local_db_read", "success");
        } catch (Throwable e) {
            RunnerHelper.a("local_db_read", e, this.f2966k, this.f2971p, 3211303, this.f2972q);
            this.f2968m.a("GraphQLBatchRunner.satisfyFromCache", e);
            return 0;
        } finally {
            this.f2971p.a(3211303, this.f2972q, (short) 23);
        }
        return b;
    }

    private int m3207b() {
        Map c = m3208c();
        Preconditions.checkState(c.size() == this.f2964i.b.size(), "All requests should have an associated result list. (may be null for a cache miss)");
        int i = 0;
        for (Entry entry : c.entrySet()) {
            int i2;
            if (entry.getValue() != null) {
                int i3 = i;
                for (GraphQLResult a : (List) entry.getValue()) {
                    this.f2964i.d().a(a, (GraphQLRequest) entry.getKey());
                    this.f2964i.d.add((GraphQLRequest) entry.getKey());
                    i3++;
                }
                i2 = i3;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    private Map<GraphQLRequest, List<GraphQLResult>> m3208c() {
        GraphQLRequestLock a = this.f2965j.a(DataSource.DB_CACHE);
        while (a != null) {
            a.f();
            a = this.f2965j.a(DataSource.DB_CACHE);
        }
        Map<GraphQLRequest, List<GraphQLResult>> d = m3209d();
        DataSource dataSource = DataSource.DB_CACHE;
        for (GraphQLRequest graphQLRequest : d.keySet()) {
            if (d.get(graphQLRequest) != null) {
                ((SingleRequestState) this.f2975t.get(graphQLRequest)).f2983b = dataSource;
            }
        }
        return d;
    }

    private Map<GraphQLRequest, List<GraphQLResult>> m3209d() {
        List<GraphQLRequest> list = this.f2964i.b;
        Map hashMap = new HashMap();
        Set hashSet = new HashSet();
        for (GraphQLRequest graphQLRequest : list) {
            GraphQLRequest graphQLRequest2;
            if (!hashSet.contains(graphQLRequest2)) {
                Object obj;
                if (graphQLRequest2.a.g) {
                    Object obj2;
                    List<GraphQLRequest> a = m3204a(graphQLRequest2, hashMap);
                    if (a == null) {
                        obj2 = null;
                    } else {
                        List a2 = Lists.a(a.size());
                        for (GraphQLRequest graphQLRequest3 : a) {
                            SingleRequestState singleRequestState = (SingleRequestState) this.f2975t.get(graphQLRequest3);
                            obj2 = singleRequestState != null ? singleRequestState.f2982a.a(this.f2966k) : ((GraphQLDiskCache) this.f2957b.get()).b(graphQLRequest3);
                            if (obj2 == null) {
                                obj2 = null;
                                break;
                            }
                            a2.add(obj2);
                        }
                        List list2 = a2;
                    }
                    obj = obj2;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    hashMap.put(graphQLRequest2, obj);
                } else {
                    Iterator it = this.f2964i.e(graphQLRequest2).iterator();
                    while (it.hasNext()) {
                        graphQLRequest2 = (GraphQLRequest) it.next();
                        hashSet.add(graphQLRequest2);
                        hashMap.put(graphQLRequest2, null);
                    }
                }
            }
        }
        return hashMap;
    }

    private static List<GraphQLRequest> m3204a(GraphQLRequest graphQLRequest, Map<GraphQLRequest, List<GraphQLResult>> map) {
        if (graphQLRequest.d() == null) {
            return ImmutableList.of(graphQLRequest);
        }
        Map b = graphQLRequest.d().b();
        if (b == null || b.isEmpty()) {
            return ImmutableList.of(graphQLRequest);
        }
        GraphQlQueryParamSet graphQlQueryParamSet = new GraphQlQueryParamSet(graphQLRequest.d().e());
        Pair pair = null;
        for (Entry entry : b.entrySet()) {
            String str = (String) entry.getKey();
            GraphQLRefParam graphQLRefParam = (GraphQLRefParam) entry.getValue();
            if (!(graphQLRefParam.a instanceof GraphQLRequest)) {
                return null;
            }
            List list = (List) map.get(graphQLRefParam.a);
            if (list == null || list.isEmpty()) {
                return null;
            }
            list = (List) ((GraphQLResult) list.get(0)).c().get(graphQLRefParam.b);
            if (list == null || list.isEmpty()) {
                return null;
            }
            Pair create;
            switch (2.a[graphQLRefParam.c.ordinal()]) {
                case 1:
                case 2:
                    graphQlQueryParamSet.a(str, (String) list.get(0));
                    continue;
                case 3:
                    graphQlQueryParamSet.a(str, (String) list.get(list.size() - 1));
                    continue;
                case 4:
                    graphQlQueryParamSet.a(str, list);
                    continue;
                case 5:
                    create = Pair.create(str, list);
                    break;
                default:
                    create = pair;
                    break;
            }
            pair = create;
        }
        if (pair == null || pair.second == null) {
            return ImmutableList.of(GraphQLRequest.a(graphQLRequest.o, graphQLRequest.p).a(graphQlQueryParamSet));
        }
        List<GraphQLRequest> a = Lists.a(((List) pair.second).size());
        for (String str2 : (List) pair.second) {
            GraphQlQueryParamSet graphQlQueryParamSet2 = new GraphQlQueryParamSet(graphQlQueryParamSet.e());
            graphQlQueryParamSet2.a((String) pair.first, str2);
            a.add(GraphQLRequest.a(graphQLRequest.o, graphQLRequest.p).a(graphQlQueryParamSet2));
        }
        return a;
    }

    private void m3210e() {
        TracerDetour.a("GraphQLBatchRunner.tryFetch", 1282413327);
        try {
            Collection a = Sets.a();
            for (GraphQLRequest graphQLRequest : this.f2964i.b) {
                SingleRequestState singleRequestState = new SingleRequestState();
                CacheProcessor cacheProcessor = graphQLRequest.h;
                if (cacheProcessor == null) {
                    cacheProcessor = this.f2963h.a(graphQLRequest);
                }
                singleRequestState.f2982a = cacheProcessor;
                this.f2975t.put(graphQLRequest, singleRequestState);
                a.add(graphQLRequest.a(this.f2969n));
            }
            this.f2965j = this.f2959d.a(false, a);
            if (m3203a() == this.f2964i.b.size()) {
                this.f2964i.f();
                return;
            }
            this.f2965j.e();
            this.f2965j = this.f2959d.a(true, a);
            GraphQLRequestLock a2 = this.f2965j.a(DataSource.NETWORK);
            int i = 0;
            while (a2 != null) {
                a2.f();
                a2 = this.f2965j.a(DataSource.NETWORK);
                i++;
            }
            m3206a("network_blocker_count", i);
            m3211f();
            this.f2964i.f();
            for (GraphQLRequest graphQLRequest2 : this.f2964i.b) {
                if (!this.f2964i.d(graphQLRequest2)) {
                    ((SingleRequestState) this.f2975t.get(graphQLRequest2)).f2983b = DataSource.NETWORK;
                }
            }
            try {
                m3205a(m3212g());
            } catch (Throwable e) {
                this.f2968m.a("GraphQLBatchRunner.updateDB", "Failed to update caches in batch", e);
            }
            if (this.f2965j != null) {
                this.f2965j.e();
            }
            TracerDetour.a(1600192805);
        } finally {
            if (this.f2965j != null) {
                this.f2965j.e();
            }
            TracerDetour.a(-516611768);
        }
    }

    private void m3211f() {
        try {
            this.f2962g.a(this.f2961f, this.f2964i);
            RunnerHelper.a("network", this.f2966k, this.f2971p, 3211303, this.f2972q);
            this.f2971p.a(3211303, this.f2972q, (short) 16);
        } catch (Exception e) {
            RunnerHelper.a("network", e, this.f2966k, this.f2971p, 3211303, this.f2972q);
            throw e;
        } catch (Throwable th) {
            this.f2971p.a(3211303, this.f2972q, (short) 16);
        }
    }

    private void m3205a(ConsistencyMemoryCache consistencyMemoryCache) {
        Exception e;
        int i;
        Throwable th;
        TracerDetour.a("GraphQLBatchRunner.updateDBForBatch", -145794097);
        int i2 = 0;
        try {
            this.f2965j.d();
            if (!(consistencyMemoryCache == null || consistencyMemoryCache.mo875b())) {
                consistencyMemoryCache.mo877c();
                this.f2971p.b(3211303, this.f2972q, "has_consistent_fields");
            }
            this.f2971p.a(3211303, this.f2972q, (short) 19);
            for (GraphQLRequest graphQLRequest : this.f2964i.b) {
                if (graphQLRequest.c().h && !this.f2964i.d(graphQLRequest)) {
                    for (GraphQLResult a : ((SingleRequestState) this.f2975t.get(graphQLRequest)).f2984c) {
                        int i3 = i2 + 1;
                        try {
                            ((SingleRequestState) this.f2975t.get(graphQLRequest)).f2982a.a(a);
                            i2 = i3;
                        } catch (Exception e2) {
                            e = e2;
                            i = i3;
                        } catch (Throwable th2) {
                            th = th2;
                            i2 = i3;
                        }
                    }
                    continue;
                }
                i2 = i2;
            }
            RunnerHelper.a("local_db_write", this.f2966k, this.f2971p, 3211303, this.f2972q);
            m3206a("db_write_count", i2);
            this.f2971p.a(3211303, this.f2972q, (short) 30);
            TracerDetour.a(1097538231);
        } catch (Exception e3) {
            e = e3;
            i = 0;
            try {
                RunnerHelper.a("local_db_write", e, this.f2966k, this.f2971p, 3211303, this.f2972q);
                throw e;
            } catch (Throwable th3) {
                th = th3;
                i2 = i;
                m3206a("db_write_count", i2);
                this.f2971p.a(3211303, this.f2972q, (short) 30);
                TracerDetour.a(1701411168);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            m3206a("db_write_count", i2);
            this.f2971p.a(3211303, this.f2972q, (short) 30);
            TracerDetour.a(1701411168);
            throw th;
        }
    }

    private ConsistencyMemoryCache m3212g() {
        TracerDetour.a("GraphQLBatchRunner.updateDBForBatch", 1354033109);
        try {
            ConsistencyMemoryCache a = this.f2958c.a();
            int i = 0;
            for (GraphQLRequest graphQLRequest : this.f2964i.b) {
                int i2;
                SingleRequestState singleRequestState = (SingleRequestState) this.f2975t.get(graphQLRequest);
                if (graphQLRequest.b) {
                    i2 = i;
                    for (GraphQLResult a2 : singleRequestState.f2984c) {
                        i2++;
                        RunnerHelper.a(a2, a);
                    }
                } else {
                    i2 = i;
                }
                ((GraphQLReadMutex) this.f2965j.f).a = a.mo878d();
                i = i2;
            }
            m3206a("consistent_models", i);
            this.f2971p.a(3211303, this.f2972q, (short) 151);
            try {
                this.f2965j.c();
                if (!a.mo875b()) {
                    CacheVisitor d = a.mo878d();
                    for (FeedUnitCache a3 : this.f2970o) {
                        a3.a(d);
                    }
                }
                RunnerHelper.a("local_memory_write", this.f2966k, this.f2971p, 3211303, this.f2972q);
                this.f2971p.a(3211303, this.f2972q, (short) 17);
                return a;
            } catch (Throwable e) {
                BLog.b(f2956a, "Error updating memory cache", e);
                RunnerHelper.a("local_memory_write", e, this.f2966k, this.f2971p, 3211303, this.f2972q);
                throw e;
            } catch (Throwable th) {
                this.f2971p.a(3211303, this.f2972q, (short) 17);
            }
        } finally {
            TracerDetour.a(-1268027300);
        }
    }

    private void m3206a(String str, int i) {
        if (this.f2971p.j(3211303, this.f2972q)) {
            this.f2971p.b(3211303, this.f2972q, str, String.valueOf(i));
        }
    }

    private void m3213h() {
        if (this.f2971p.j(3211303, this.f2972q)) {
            this.f2971p.b(3211303, this.f2972q, "results_returned", String.valueOf(this.f2973r));
            this.f2971p.b(3211303, this.f2972q, "errors_returned", String.valueOf(this.f2974s));
        }
    }
}
