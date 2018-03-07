package com.facebook.graphql.executor.cache;

import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: fetchBroadcastEligibility */
public class ConsistencyTaggedCacheVisitor implements ConsistentFieldWritingVisitor {
    private final GraphQLConsistencyMemoryCache f11798a;

    public ConsistencyTaggedCacheVisitor(GraphQLConsistencyMemoryCache graphQLConsistencyMemoryCache) {
        this.f11798a = graphQLConsistencyMemoryCache;
    }

    public final Object mo270a(Object obj) {
        if (obj == null || this.f11798a.mo875b()) {
            return obj;
        }
        if (obj instanceof GraphQLVisitableModel) {
            return this.f11798a.mo874b((GraphQLVisitableModel) obj);
        } else if (!(obj instanceof Map)) {
            return obj;
        } else {
            Map map = (Map) obj;
            Map c = Maps.c();
            Object obj2 = null;
            for (Entry entry : map.entrySet()) {
                if (entry.getValue() instanceof GraphQLVisitableModel) {
                    Object obj3;
                    GraphQLVisitableModel graphQLVisitableModel = (GraphQLVisitableModel) entry.getValue();
                    GraphQLVisitableModel b = this.f11798a.mo874b(graphQLVisitableModel);
                    if (b != graphQLVisitableModel) {
                        obj3 = 1;
                    } else {
                        obj3 = obj2;
                    }
                    c.put(entry.getKey(), b);
                    obj2 = obj3;
                } else {
                    c.put(entry.getKey(), entry.getValue());
                }
            }
            if (obj2 != null) {
                return c;
            }
            return map;
        }
    }

    public final Set<String> mo268a() {
        return this.f11798a.f11787a.keySet();
    }
}
