package com.facebook.graphql.executor;

import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLRequestLock;
import com.facebook.graphql.executor.GraphQLResult.Builder;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: messenger_client_analytics_android */
public class GraphQLReadMutex<T> implements GraphQLMutex {
    volatile CacheVisitor f14134a = null;
    private ImmutableSet<String> f14135b = RegularImmutableSet.f688a;
    private ImmutableSet<String> f14136c = RegularImmutableSet.f688a;
    public final boolean f14137d;

    public final ImmutableSet<String> mo2716a() {
        return this.f14136c;
    }

    public final void m20463a(@Nullable Collection<String> collection, Collection<String> collection2) {
        if (collection != null || collection2 != null) {
            Collection a = collection == null ? Sets.m1313a() : Sets.m1324b(collection);
            if (collection2 != null) {
                a.addAll(collection2);
                this.f14135b = ImmutableSet.copyOf((Collection) collection2);
            }
            this.f14136c = ImmutableSet.copyOf(a);
        }
    }

    public final GraphQLMutex mo2714a(Set set) {
        if (set != null) {
            if (this.f14136c.isEmpty() && (set instanceof ImmutableSet)) {
                this.f14136c = (ImmutableSet) set;
            } else {
                this.f14136c = ImmutableSet.builder().m4809b(this.f14136c).m4809b((Iterable) set).m4812b();
            }
        }
        return this;
    }

    public final GraphQLResult mo2715a(GraphQLResult graphQLResult) {
        if (graphQLResult.freshness != DataFreshnessResult.FROM_SERVER) {
            return GraphQLQueryScheduler.f6187a;
        }
        return graphQLResult;
    }

    public GraphQLReadMutex(boolean z) {
        this.f14137d = z;
    }

    public final boolean mo2717a(GraphQLRequestLock graphQLRequestLock) {
        if (graphQLRequestLock.f14132f instanceof GraphQLReadMutex) {
            GraphQLReadMutex graphQLReadMutex = (GraphQLReadMutex) graphQLRequestLock.f14132f;
            if (!graphQLReadMutex.f14137d || !this.f14137d) {
                return true;
            }
            Iterator it = this.f14135b.iterator();
            while (it.hasNext()) {
                if (graphQLReadMutex.mo2716a().contains((String) it.next())) {
                    return false;
                }
            }
        }
        return true;
    }

    public final GraphQLResult mo2718b(GraphQLResult graphQLResult) {
        TracerDetour.a("GraphQLReadMutex.partiallyUpdateStale", -1304506553);
        try {
            GraphQLResult a;
            CacheVisitor cacheVisitor = this.f14134a;
            if (cacheVisitor != null) {
                a = Builder.m21595a(graphQLResult).m21598a(cacheVisitor.a(graphQLResult.m10400d())).m21600a();
            } else {
                a = GraphQLQueryScheduler.f6187a;
                TracerDetour.a(1667414049);
            }
            return a;
        } finally {
            TracerDetour.a(1042907254);
        }
    }
}
