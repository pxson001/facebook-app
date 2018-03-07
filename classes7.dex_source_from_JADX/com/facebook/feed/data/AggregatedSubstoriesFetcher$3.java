package com.facebook.feed.data;

import com.facebook.feed.protocol.FetchAggregatedStoryGraphQLModels.AggregatedStorySubstoryQueryModel;
import com.facebook.feed.protocol.FetchAggregatedStoryGraphQLModels.AggregatedStorySubstoryQueryModel.AllSubstoriesModel;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: application/x-quicktime-tx3g */
public class AggregatedSubstoriesFetcher$3 implements Function<GraphQLResult<AggregatedStorySubstoryQueryModel>, AllSubstoriesModel> {
    final /* synthetic */ AggregatedSubstoriesFetcher f19156a;

    public AggregatedSubstoriesFetcher$3(AggregatedSubstoriesFetcher aggregatedSubstoriesFetcher) {
        this.f19156a = aggregatedSubstoriesFetcher;
    }

    @Nullable
    public Object apply(@Nullable Object obj) {
        return ((AggregatedStorySubstoryQueryModel) ((GraphQLResult) obj).e).a();
    }
}
