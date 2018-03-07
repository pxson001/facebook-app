package com.facebook.feedback.reactions.api;

import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: search_query */
public class FeedbackReactionsVectorAssetFetcher$2 implements Function<GraphQLResult<FetchFeedbackReactionsVectorDataQueryModel>, ImmutableList<ReactionInfosModel>> {
    final /* synthetic */ FeedbackReactionsVectorAssetFetcher f2936a;

    public FeedbackReactionsVectorAssetFetcher$2(FeedbackReactionsVectorAssetFetcher feedbackReactionsVectorAssetFetcher) {
        this.f2936a = feedbackReactionsVectorAssetFetcher;
    }

    public Object apply(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null) {
            return null;
        }
        return ((FetchFeedbackReactionsVectorDataQueryModel) graphQLResult.e).m3179a().m3191a();
    }
}
