package com.facebook.api.prefetch;

import com.facebook.analytics.PrefetchAnalytics;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Collection;
import java.util.List;

/* compiled from: sd_total_space */
class GraphQLPrefetchController$4 implements FutureCallback<List<GraphQLResult>> {
    final /* synthetic */ PrefetchAnalytics f2978a;
    final /* synthetic */ Collection f2979b;
    final /* synthetic */ GraphQLPrefetchPolicy f2980c;
    final /* synthetic */ GraphQLPrefetchController f2981d;

    GraphQLPrefetchController$4(GraphQLPrefetchController graphQLPrefetchController, PrefetchAnalytics prefetchAnalytics, Collection collection, GraphQLPrefetchPolicy graphQLPrefetchPolicy) {
        this.f2981d = graphQLPrefetchController;
        this.f2978a = prefetchAnalytics;
        this.f2979b = collection;
        this.f2980c = graphQLPrefetchPolicy;
    }

    public void onSuccess(Object obj) {
        this.f2978a.b(this.f2979b);
        String str = GraphQLPrefetchController.a;
        Integer.valueOf(this.f2979b.size());
    }

    public void onFailure(Throwable th) {
        PrefetchAnalytics prefetchAnalytics = this.f2978a;
        Collection<String> collection = this.f2979b;
        String message = th.getMessage();
        if (collection != null) {
            for (String a : collection) {
                prefetchAnalytics.a(a, message);
            }
        }
        BLog.a(GraphQLPrefetchController.a, "Prefetch failed in prefetcher %s: %s", new Object[]{this.f2980c.c(), th.getMessage()});
    }
}
