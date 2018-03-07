package com.facebook.graphql.executor;

import com.facebook.graphql.executor.GraphQLQueryExecutor.CacheProcessor;
import com.facebook.graphql.executor.GraphQLResult.Builder;
import com.facebook.graphql.executor.cache.ConsistencyCacheFactoryImpl;
import com.facebook.graphql.executor.cache.GraphQLRequestDiskCache;
import com.facebook.graphql.executor.iface.ConsistencyCacheFactory;
import com.facebook.graphql.executor.iface.ConsistencyMemoryCache;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: messenger_ignore_read_push_notification */
public class DefaultCacheProcessor<T> implements CacheProcessor<T> {
    private static final AtomicInteger f13947e = new AtomicInteger();
    final GraphQLRequest<T> f13948a;
    private final QuickPerformanceLogger f13949b;
    private GraphQLRequestDiskCache f13950c;
    private ConsistencyCacheFactoryImpl f13951d;

    public DefaultCacheProcessor(GraphQLRequest<T> graphQLRequest, GraphQLRequestDiskCache graphQLRequestDiskCache, ConsistencyCacheFactory consistencyCacheFactory, QuickPerformanceLogger quickPerformanceLogger) {
        this.f13948a = graphQLRequest;
        this.f13950c = graphQLRequestDiskCache;
        this.f13951d = consistencyCacheFactory;
        this.f13949b = quickPerformanceLogger;
        this.f13949b.mo463b(3211294, 10);
    }

    public final GraphQLResult<T> mo2681a() {
        return null;
    }

    public final GraphQLResult<T> mo2682a(GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent) {
        int andIncrement = f13947e.getAndIncrement();
        try {
            this.f13949b.mo442a(3211294, andIncrement, "query", this.f13948a.m11605b().m11324c());
            GraphQLResult<T> b = this.f13950c.mo1448b(this.f13948a);
            boolean z = (b == null || b.m10400d() == null || !this.f13948a.f7084b) ? false : true;
            this.f13949b.mo465b(3211294, andIncrement, "consistency-enabled", String.valueOf(z));
            if (z) {
                TracerDetour.a("DefaultCacheProcessor.needConsistency", -1720085952);
                try {
                    if (b.m10400d() instanceof GraphQLVisitableModel) {
                        GraphQLVisitableModel graphQLVisitableModel = (GraphQLVisitableModel) b.m10400d();
                        ConsistencyMemoryCache a = this.f13951d.m10246a(b.m10402f());
                        if (!a.b() && a.d(graphQLVisitableModel)) {
                            graphQLQueryAnalyticsEvent.mo1471c();
                        }
                    } else if (b.m10400d() instanceof Map) {
                        ConsistencyMemoryCache a2 = this.f13951d.m10246a(b.m10402f());
                        if (!a2.b()) {
                            Object obj = null;
                            for (Entry entry : ((Map) b.m10400d()).entrySet()) {
                                Object obj2;
                                if (entry.getValue() instanceof GraphQLVisitableModel) {
                                    z = a2.d((GraphQLVisitableModel) entry.getValue());
                                    if (obj != null || z) {
                                        obj2 = 1;
                                    } else {
                                        obj2 = null;
                                    }
                                } else {
                                    obj2 = obj;
                                }
                                obj = obj2;
                            }
                            if (obj != null) {
                                graphQLQueryAnalyticsEvent.mo1471c();
                            }
                        }
                    }
                    TracerDetour.a(71443951);
                } catch (Throwable th) {
                    TracerDetour.a(154601318);
                }
            }
            this.f13949b.mo466b(3211294, andIncrement, (short) 2);
            return b;
        } catch (Exception e) {
            this.f13949b.mo466b(3211294, andIncrement, (short) 3);
            throw e;
        }
    }

    public final boolean mo2683a(GraphQLResult<T> graphQLResult) {
        int andIncrement = f13947e.getAndIncrement();
        try {
            this.f13949b.mo442a(3211299, andIncrement, "query", this.f13948a.m11605b().m11324c());
            Map h = this.f13948a.m11610h();
            if (h != null) {
                for (Entry entry : ((Map) graphQLResult.m10400d()).entrySet()) {
                    if (h.get(entry.getKey()) != null) {
                        this.f13950c.mo1449b((GraphQLRequest) h.get(entry.getKey()), Builder.m21595a((GraphQLResult) graphQLResult).m21598a(entry.getValue()).m21600a());
                    }
                }
            } else {
                this.f13950c.mo1449b(this.f13948a, graphQLResult);
            }
            this.f13949b.mo466b(3211299, andIncrement, (short) 2);
            return true;
        } catch (Exception e) {
            this.f13949b.mo466b(3211299, andIncrement, (short) 3);
            throw e;
        }
    }

    public final GraphQLResult<T> mo2684b(GraphQLResult<T> graphQLResult) {
        return graphQLResult;
    }
}
