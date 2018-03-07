package com.facebook.graphql.executor.cache;

import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.executor.iface.ConsistencyMemoryCache;
import com.facebook.graphql.modelutil.ConsistencyIndexValue;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.Lazy;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: left */
public class ImmutableConsistencyMemoryCache implements ConsistentFieldWritingVisitor, ConsistencyMemoryCache {
    public final Map<String, Map<String, Object>> f3250a = new HashMap();
    private final Lazy<GraphQLDiskCache> f3251b;

    public ImmutableConsistencyMemoryCache(Collection<ConsistencyIndexValue> collection, Lazy<GraphQLDiskCache> lazy) {
        this.f3251b = lazy;
        Preconditions.checkNotNull(collection);
        for (ConsistencyIndexValue consistencyIndexValue : collection) {
            Map map = (Map) this.f3250a.get(consistencyIndexValue.f4780a);
            if (map == null) {
                map = new HashMap();
                this.f3250a.put(consistencyIndexValue.f4780a, map);
            }
            map.put(consistencyIndexValue.f4781b, consistencyIndexValue.f4782c);
        }
    }

    public final CacheVisitor m6321d() {
        return this;
    }

    public final <T> T m6312a(T t) {
        if (t instanceof GraphQLVisitableModel) {
            return m6317b((GraphQLVisitableModel) t);
        }
        return t;
    }

    public final <T extends GraphQLVisitableModel> T m6317b(T t) {
        return (GraphQLVisitableModel) new RecursiveModelTransformer(GraphQLPersistableNode.class, new CloningConsistentFieldTransform(this.f3250a)).a(t);
    }

    public final boolean m6322d(GraphQLVisitableModel graphQLVisitableModel) {
        InPlaceConsistentFieldVisitor inPlaceConsistentFieldVisitor = new InPlaceConsistentFieldVisitor(this.f3250a);
        inPlaceConsistentFieldVisitor.b(graphQLVisitableModel);
        return inPlaceConsistentFieldVisitor.c;
    }

    public final boolean m6318b() {
        return this.f3250a.isEmpty();
    }

    public final Set<String> m6313a() {
        return this.f3250a.keySet();
    }

    public final void m6320c() {
        if (!m6318b()) {
            ((GraphQLDiskCache) this.f3251b.get()).a(Collections.unmodifiableMap(this.f3250a));
        }
    }

    public final <T extends GraphQLVisitableModel> T m6319c(T t) {
        throw new UnsupportedOperationException();
    }

    public final boolean m6316a(Map<String, Object> map) {
        throw new UnsupportedOperationException();
    }

    public final boolean m6314a(GraphQLVisitableModel graphQLVisitableModel) {
        throw new UnsupportedOperationException();
    }

    public final boolean m6315a(String str, String str2, Object obj) {
        throw new UnsupportedOperationException();
    }
}
