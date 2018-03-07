package com.facebook.search.results.mutator;

import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.graphql.model.GraphQLActor;
import javax.inject.Inject;

/* compiled from: RedSpaceBatchResult2{mResult1= */
public class SearchResultsStoryLikeMutator {
    public final FeedStoryMutator f23557a;
    public final GraphQLActor f23558b;

    @Inject
    public SearchResultsStoryLikeMutator(FeedStoryMutator feedStoryMutator, GraphQLActorCacheImpl graphQLActorCacheImpl) {
        this.f23557a = feedStoryMutator;
        this.f23558b = graphQLActorCacheImpl.a();
    }
}
