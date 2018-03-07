package com.facebook.api.prefetch;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.Executor;

/* compiled from: android_place_picker_edit_menu */
class GraphQLPrefetchController$3 implements Runnable {
    final /* synthetic */ GraphQLPrefetchPolicy f10245a;
    final /* synthetic */ String f10246b;
    final /* synthetic */ FutureCallback f10247c;
    final /* synthetic */ CallerContext f10248d;
    final /* synthetic */ Executor f10249e;
    final /* synthetic */ GraphQLPrefetchController f10250f;

    GraphQLPrefetchController$3(GraphQLPrefetchController graphQLPrefetchController, GraphQLPrefetchPolicy graphQLPrefetchPolicy, String str, FutureCallback futureCallback, CallerContext callerContext, Executor executor) {
        this.f10250f = graphQLPrefetchController;
        this.f10245a = graphQLPrefetchPolicy;
        this.f10246b = str;
        this.f10247c = futureCallback;
        this.f10248d = callerContext;
        this.f10249e = executor;
    }

    public void run() {
        GraphQLPrefetchController.a(this.f10250f, this.f10245a, this.f10246b, this.f10247c, this.f10248d, this.f10249e, GraphQLCachePolicy.a);
    }
}
