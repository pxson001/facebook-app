package com.facebook.identitygrowth.protocol;

import com.facebook.graphql.executor.GraphQLCacheKeySerializer;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadSearchGraphQLInterfaces.TypeaheadResultPage;
import com.facebook.places.future.SimpleExecutor;
import com.google.common.base.Function;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;

/* compiled from: mFriendshipStatus */
public abstract class ProfileInfoTypeaheadFetcher<ModelType> {
    private SimpleExecutor f11105a;
    private GraphQLQueryExecutor f11106b;

    /* compiled from: mFriendshipStatus */
    public interface ResultTransformer<T> extends Function<GraphQLResult<T>, List<TypeaheadResultPage>> {
    }

    public ProfileInfoTypeaheadFetcher(SimpleExecutor simpleExecutor, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f11105a = simpleExecutor;
        this.f11106b = graphQLQueryExecutor;
    }

    public final void m17848a(TypedGraphQlQueryString<ModelType> typedGraphQlQueryString, FutureCallback<List<TypeaheadResultPage>> futureCallback, ResultTransformer<ModelType> resultTransformer) {
        m17849a(typedGraphQlQueryString, futureCallback, resultTransformer, GraphQLCacheKeySerializer.a);
    }

    public final void m17849a(TypedGraphQlQueryString<ModelType> typedGraphQlQueryString, FutureCallback<List<TypeaheadResultPage>> futureCallback, ResultTransformer<ModelType> resultTransformer, GraphQLCacheKeySerializer graphQLCacheKeySerializer) {
        this.f11105a.m22279a(Futures.a(this.f11106b.a(GraphQLRequest.a(typedGraphQlQueryString).a(GraphQLCachePolicy.a).a(3600).a(graphQLCacheKeySerializer)), resultTransformer, MoreExecutors.a()), (FutureCallback) futureCallback);
    }

    public void mo1069a() {
        this.f11105a.m22282c();
    }
}
