package com.facebook.commerce.storefront.fetcher;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: create-group */
public class StorefrontGraphQLFetcher {
    public final GraphQLQueryExecutor f15711a;

    public static StorefrontGraphQLFetcher m16154b(InjectorLike injectorLike) {
        return new StorefrontGraphQLFetcher(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public StorefrontGraphQLFetcher(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f15711a = graphQLQueryExecutor;
    }
}
