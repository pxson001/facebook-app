package com.facebook.api.prefetch;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: post_id */
public class GraphQLPrefetchConsumerProvider extends AbstractAssistedProvider<GraphQLPrefetchConsumer> {
    public final <T> GraphQLPrefetchConsumer<T> m14351a(GraphQLPrefetchPolicy<T> graphQLPrefetchPolicy) {
        return new GraphQLPrefetchConsumer(GraphQLPrefetchController.m14385a((InjectorLike) this), graphQLPrefetchPolicy);
    }
}
