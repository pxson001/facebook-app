package com.facebook.api.prefetch;

import com.facebook.analytics.PrefetchAnalytics;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: android_place_picker_edit_menu */
class GraphQLPrefetchController$2 implements FutureCallback<GraphQLResult<T>> {
    final /* synthetic */ GraphQLPrefetchPolicy f10235a;
    final /* synthetic */ boolean f10236b;
    final /* synthetic */ String f10237c;
    final /* synthetic */ FutureCallback f10238d;
    final /* synthetic */ CallerContext f10239e;
    final /* synthetic */ Executor f10240f;
    final /* synthetic */ boolean f10241g;
    final /* synthetic */ FutureCallback f10242h;
    final /* synthetic */ Executor f10243i;
    final /* synthetic */ GraphQLPrefetchController f10244j;

    GraphQLPrefetchController$2(GraphQLPrefetchController graphQLPrefetchController, GraphQLPrefetchPolicy graphQLPrefetchPolicy, boolean z, String str, FutureCallback futureCallback, CallerContext callerContext, Executor executor, boolean z2, FutureCallback futureCallback2, Executor executor2) {
        this.f10244j = graphQLPrefetchController;
        this.f10235a = graphQLPrefetchPolicy;
        this.f10236b = z;
        this.f10237c = str;
        this.f10238d = futureCallback;
        this.f10239e = callerContext;
        this.f10240f = executor;
        this.f10241g = z2;
        this.f10242h = futureCallback2;
        this.f10243i = executor2;
    }

    public void onSuccess(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        PrefetchAnalytics a = this.f10244j.a(this.f10235a);
        if (graphQLResult == null) {
            if (this.f10236b || !GraphQLPrefetchController.a(this.f10244j, this.f10235a, this.f10237c, this.f10238d, this.f10239e, this.f10240f)) {
                a.b(this.f10237c);
            } else {
                return;
            }
        } else if (this.f10235a.d() || this.f10235a.a(graphQLResult)) {
            a.c(this.f10237c);
        } else {
            a.a(this.f10237c);
            this.f10238d.onSuccess(GraphQLPrefetchController.b(graphQLResult, true));
            return;
        }
        if (this.f10241g) {
            GraphQLPrefetchController.b(this.f10244j, this.f10235a, this.f10237c, this.f10242h, this.f10239e, this.f10243i);
        }
        this.f10238d.onSuccess(GraphQLPrefetchController.b(graphQLResult, false));
    }

    public void onFailure(Throwable th) {
        this.f10238d.onFailure(th);
    }
}
