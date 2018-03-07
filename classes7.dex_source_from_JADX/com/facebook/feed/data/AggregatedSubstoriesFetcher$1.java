package com.facebook.feed.data;

import com.facebook.feed.protocol.FetchAggregatedStoryGraphQL.AggregatedStorySubstoryQueryString;
import com.facebook.feed.protocol.FetchAggregatedStoryGraphQLModels.AggregatedStorySubstoryQueryModel.AllSubstoriesModel;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: application/x-quicktime-tx3g */
public class AggregatedSubstoriesFetcher$1 implements Callable<ListenableFuture<AllSubstoriesModel>> {
    final /* synthetic */ GraphQLStory f19150a;
    final /* synthetic */ int f19151b;
    final /* synthetic */ AggregatedSubstoriesFetcher f19152c;

    public AggregatedSubstoriesFetcher$1(AggregatedSubstoriesFetcher aggregatedSubstoriesFetcher, GraphQLStory graphQLStory, int i) {
        this.f19152c = aggregatedSubstoriesFetcher;
        this.f19150a = graphQLStory;
        this.f19151b = i;
    }

    public Object call() {
        AggregatedSubstoriesFetcher aggregatedSubstoriesFetcher = this.f19152c;
        GraphQLStory graphQLStory = this.f19150a;
        int i = this.f19151b;
        GraphQlQueryString aggregatedStorySubstoryQueryString = new AggregatedStorySubstoryQueryString();
        aggregatedStorySubstoryQueryString.a("node_id", graphQLStory.c()).a("after_cursor", StoryHierarchyHelper.a(graphQLStory).k().a()).a("num_substories", Integer.toString(i));
        return Futures.a(aggregatedSubstoriesFetcher.d.a(GraphQLRequest.a(aggregatedStorySubstoryQueryString)), new AggregatedSubstoriesFetcher$3(aggregatedSubstoriesFetcher), aggregatedSubstoriesFetcher.g);
    }
}
