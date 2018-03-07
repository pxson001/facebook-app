package com.facebook.api.prefetch;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: post_main */
public class GraphQLPrefetcherProvider extends AbstractAssistedProvider<GraphQLPrefetcher> {
    public final GraphQLPrefetcher m14349a(GraphQLPrefetchPolicy graphQLPrefetchPolicy) {
        return new GraphQLPrefetcher(GraphQLPrefetchController.m14385a((InjectorLike) this), graphQLPrefetchPolicy);
    }
}
