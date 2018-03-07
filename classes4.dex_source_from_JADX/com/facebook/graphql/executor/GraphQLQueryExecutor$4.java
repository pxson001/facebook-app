package com.facebook.graphql.executor;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.graphql.executor.request.MutationRequest;
import java.util.concurrent.Callable;

/* compiled from: feed_toggle_like */
class GraphQLQueryExecutor$4 implements Callable<String> {
    final /* synthetic */ MutationRequest f11840a;
    final /* synthetic */ GraphQLQueryExecutor f11841b;

    GraphQLQueryExecutor$4(GraphQLQueryExecutor graphQLQueryExecutor, MutationRequest mutationRequest) {
        this.f11841b = graphQLQueryExecutor;
        this.f11840a = mutationRequest;
    }

    public Object call() {
        ViewerContext viewerContext;
        if (this.f11840a.f11812e != null) {
            viewerContext = this.f11840a.f11812e;
        } else if (this.f11841b.g.b() != null) {
            viewerContext = this.f11841b.g.b();
        } else {
            viewerContext = this.f11841b.g.d();
        }
        return viewerContext.mUserId;
    }
}
