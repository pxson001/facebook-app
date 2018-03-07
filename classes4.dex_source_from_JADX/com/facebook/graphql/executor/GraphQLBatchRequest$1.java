package com.facebook.graphql.executor;

import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.SettableFuture;

/* compiled from: search_constraint */
class GraphQLBatchRequest$1 implements RequestObserver<GraphQLResult<T>> {
    final /* synthetic */ SettableFuture f2949a;
    final /* synthetic */ GraphQLBatchRequest f2950b;

    GraphQLBatchRequest$1(GraphQLBatchRequest graphQLBatchRequest, SettableFuture settableFuture) {
        this.f2950b = graphQLBatchRequest;
        this.f2949a = settableFuture;
    }

    public final void m3201a(Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (!this.f2949a.isCancelled()) {
            FutureDetour.a(this.f2949a, graphQLResult, 981790559);
        }
    }

    public final void m3200a() {
        this.f2949a.cancel(false);
    }

    public final void m3202a(Throwable th) {
        if (!this.f2949a.isCancelled()) {
            this.f2949a.a(th);
        }
    }
}
