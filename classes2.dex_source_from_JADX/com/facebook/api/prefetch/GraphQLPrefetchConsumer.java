package com.facebook.api.prefetch;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.inject.Assisted;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: post */
public class GraphQLPrefetchConsumer<T> {
    private final GraphQLPrefetchController f9431a;
    private final GraphQLPrefetchPolicy<T> f9432b;

    @Inject
    public GraphQLPrefetchConsumer(GraphQLPrefetchController graphQLPrefetchController, @Assisted GraphQLPrefetchPolicy<T> graphQLPrefetchPolicy) {
        this.f9431a = graphQLPrefetchController;
        this.f9432b = graphQLPrefetchPolicy;
    }

    public final void m14420a(String str, FutureCallback<GraphQLPrefetchResult<T>> futureCallback, FutureCallback<GraphQLPrefetchResult<T>> futureCallback2, CallerContext callerContext, Executor executor) {
        this.f9431a.m14409a(this.f9432b, str, (FutureCallback) futureCallback, (FutureCallback) futureCallback2, callerContext, executor);
    }

    public final void m14419a(String str, FutureCallback<GraphQLPrefetchResult<T>> futureCallback, CallerContext callerContext, Executor executor) {
        this.f9431a.m14408a(this.f9432b, str, futureCallback, callerContext, executor);
    }
}
