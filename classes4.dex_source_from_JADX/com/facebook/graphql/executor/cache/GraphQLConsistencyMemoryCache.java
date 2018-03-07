package com.facebook.graphql.executor.cache;

import android.text.TextUtils;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.executor.iface.ConsistencyMemoryCache;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.qe.api.QeAccessor;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.google.common.base.Throwables;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: fetchFacebookEmployeeStatus */
public class GraphQLConsistencyMemoryCache implements ConsistencyMemoryCache {
    public final Map<String, Map<String, Object>> f11787a;
    private final GraphQLDiskCache f11788b;
    private final ConsistencyConfigImpl f11789c;
    private final ConsistencyTuple f11790d = new ConsistencyTuple();
    private final QuickPerformanceLogger f11791e;
    private final QeAccessor f11792f;

    public GraphQLConsistencyMemoryCache(ConsistencyConfigImpl consistencyConfigImpl, GraphQLDiskCache graphQLDiskCache, QuickPerformanceLogger quickPerformanceLogger, QeAccessor qeAccessor) {
        this.f11789c = consistencyConfigImpl;
        this.f11788b = graphQLDiskCache;
        this.f11787a = Maps.c();
        this.f11791e = quickPerformanceLogger;
        this.f11792f = qeAccessor;
    }

    public GraphQLConsistencyMemoryCache(ConsistencyConfig consistencyConfig, GraphQLDiskCache graphQLDiskCache, QuickPerformanceLogger quickPerformanceLogger, QeAccessor qeAccessor, Collection<String> collection) {
        this.f11789c = consistencyConfig;
        this.f11788b = graphQLDiskCache;
        this.f11791e = quickPerformanceLogger;
        this.f11792f = qeAccessor;
        this.f11787a = this.f11788b.a(collection);
    }

    public final boolean mo875b() {
        return this.f11787a.isEmpty();
    }

    public final synchronized boolean mo871a(GraphQLVisitableModel graphQLVisitableModel) {
        GraphQLConsistencyCacheVisitor graphQLConsistencyCacheVisitor;
        graphQLConsistencyCacheVisitor = new GraphQLConsistencyCacheVisitor(this, this.f11789c);
        graphQLConsistencyCacheVisitor.b(graphQLVisitableModel);
        return graphQLConsistencyCacheVisitor.f11794a;
    }

    public final synchronized boolean mo873a(Map<String, Object> map) {
        boolean z;
        z = false;
        for (Entry entry : map.entrySet()) {
            boolean z2;
            if (entry.getValue() != null && (entry.getValue() instanceof GraphQLVisitableModel) && mo871a((GraphQLVisitableModel) entry.getValue())) {
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        return z;
    }

    public final synchronized <T extends GraphQLVisitableModel> T mo874b(T t) {
        GraphQLVisitableModel graphQLVisitableModel;
        try {
            this.f11791e.b(3211295);
            graphQLVisitableModel = (GraphQLVisitableModel) new RecursiveModelTransformer(GraphQLPersistableNode.class, new CloningConsistentFieldTransform(this.f11787a)).m3273a((Object) t);
            this.f11791e.b(3211295, (short) 2);
        } catch (Throwable e) {
            this.f11791e.b(3211295, (short) 3);
            throw Throwables.propagate(e);
        }
        return graphQLVisitableModel;
    }

    public final synchronized <T extends GraphQLVisitableModel> T mo876c(T t) {
        if ((t instanceof GraphQLPersistableNode) && (t instanceof GraphQLVisitableConsistentModel) && !this.f11787a.isEmpty()) {
            GraphQLPersistableNode graphQLPersistableNode = (GraphQLPersistableNode) t;
            Map map = (Map) this.f11787a.get(graphQLPersistableNode.a());
            if (!(map == null || map.isEmpty() || !InPlaceConsistentFieldVisitor.m3279a((GraphQLVisitableConsistentModel) graphQLPersistableNode, map, this.f11790d))) {
                try {
                    T t2 = (GraphQLVisitableConsistentModel) t.clone();
                    InPlaceConsistentFieldVisitor.m3282b(t2, map, this.f11790d);
                    t = t2;
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
        }
        return t;
    }

    public final boolean mo879d(GraphQLVisitableModel graphQLVisitableModel) {
        InPlaceConsistentFieldVisitor inPlaceConsistentFieldVisitor = new InPlaceConsistentFieldVisitor(this.f11787a);
        inPlaceConsistentFieldVisitor.b(graphQLVisitableModel);
        return inPlaceConsistentFieldVisitor.f2996c;
    }

    public final boolean mo872a(@Nullable String str, String str2, Object obj) {
        if (!m12375a(str, obj)) {
            return false;
        }
        Map map = (Map) this.f11787a.get(str);
        if (map == null) {
            map = Maps.c();
            this.f11787a.put(str, map);
        }
        map.put(str2, obj);
        return true;
    }

    public final void mo877c() {
        if (!this.f11787a.isEmpty()) {
            this.f11788b.a(this.f11787a);
        }
    }

    public final CacheVisitor mo878d() {
        return new ConsistencyTaggedCacheVisitor(this);
    }

    public static boolean m12375a(String str, Object obj) {
        if (obj == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if ((obj instanceof Enum) && "UNSET_OR_UNRECOGNIZED_ENUM_VALUE".equals(((Enum) obj).name())) {
            return false;
        }
        return true;
    }
}
