package com.facebook.graphql.executor;

import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLRequestLock;
import com.facebook.graphql.executor.GraphQLResult.Builder;
import com.facebook.graphql.executor.cache.ConsistentFieldWritingVisitor;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import java.util.Set;

/* compiled from: feed_subscriber */
public class GraphQLWriteMutex implements GraphQLMutex {
    public volatile CacheVisitor f11842a;
    public volatile boolean f11843b = false;
    public ImmutableSet<String> f11844c;

    public final ImmutableSet<String> m12436a() {
        return this.f11844c;
    }

    public final boolean m12439b() {
        return this.f11842a != null;
    }

    public GraphQLWriteMutex(CacheVisitor cacheVisitor) {
        this.f11842a = cacheVisitor;
        if (this.f11842a == null || this.f11842a.mo268a() == null) {
            this.f11844c = RegularImmutableSet.a;
        } else {
            this.f11844c = ImmutableSet.copyOf(this.f11842a.mo268a());
        }
    }

    public final GraphQLMutex m12434a(Set set) {
        if (set != null) {
            this.f11844c = ImmutableSet.builder().b(this.f11844c).b(set).b();
        }
        return this;
    }

    public final boolean m12437a(GraphQLRequestLock graphQLRequestLock) {
        if (this.f11843b) {
            return true;
        }
        if (graphQLRequestLock.f instanceof GraphQLReadMutex) {
            return m12439b();
        }
        return graphQLRequestLock.f instanceof GraphQLWriteMutex ? false : false;
    }

    public final GraphQLResult m12435a(GraphQLResult graphQLResult) {
        TracerDetour.a("GraphQLWriteMutex.updateStale", 764432441);
        try {
            GraphQLResult a;
            if (m12439b()) {
                Object a2 = this.f11842a.mo270a(graphQLResult.d());
                Builder a3 = Builder.a(graphQLResult).a(a2);
                if (!(this.f11842a instanceof ConsistentFieldWritingVisitor)) {
                    a3.a(GraphQLResponseParser.a(a2));
                }
                a = a3.a();
                TracerDetour.a(-697539205);
            } else {
                a = GraphQLQueryScheduler.a;
            }
            return a;
        } finally {
            TracerDetour.a(967883253);
        }
    }

    public final GraphQLResult m12438b(GraphQLResult graphQLResult) {
        return GraphQLQueryScheduler.a;
    }
}
