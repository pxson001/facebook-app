package com.facebook.feedback.reactions.api;

import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: search_query */
class FeedbackReactionsVectorAssetFetcher$1 implements Function<ImmutableList<ReactionInfosModel>, AnimationModel> {
    final /* synthetic */ int f2937a;
    final /* synthetic */ FeedbackReactionsVectorAssetFetcher f2938b;

    FeedbackReactionsVectorAssetFetcher$1(FeedbackReactionsVectorAssetFetcher feedbackReactionsVectorAssetFetcher, int i) {
        this.f2938b = feedbackReactionsVectorAssetFetcher;
        this.f2937a = i;
    }

    public Object apply(@Nullable Object obj) {
        ImmutableList immutableList = (ImmutableList) obj;
        if (immutableList == null) {
            return null;
        }
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ReactionInfosModel reactionInfosModel = (ReactionInfosModel) immutableList.get(i);
            if (reactionInfosModel.m3196j() == this.f2937a) {
                return reactionInfosModel.m3193a();
            }
        }
        return null;
    }
}
