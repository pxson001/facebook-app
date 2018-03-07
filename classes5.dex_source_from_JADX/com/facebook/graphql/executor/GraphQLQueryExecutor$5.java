package com.facebook.graphql.executor;

import com.facebook.auth.viewercontext.ViewerContext;

/* compiled from: lightweight_place_picker_search_results_id */
class GraphQLQueryExecutor$5 implements Runnable {
    final /* synthetic */ ViewerContext f3204a;
    final /* synthetic */ NetworkOnlyGraphQLBatchRunner f3205b;
    final /* synthetic */ GraphQLQueryExecutor f3206c;

    GraphQLQueryExecutor$5(GraphQLQueryExecutor graphQLQueryExecutor, ViewerContext viewerContext, NetworkOnlyGraphQLBatchRunner networkOnlyGraphQLBatchRunner) {
        this.f3206c = graphQLQueryExecutor;
        this.f3204a = viewerContext;
        this.f3205b = networkOnlyGraphQLBatchRunner;
    }

    public void run() {
        try {
            this.f3206c.h.b(this.f3204a);
            this.f3205b.run();
        } finally {
            this.f3206c.h.f();
        }
    }
}
