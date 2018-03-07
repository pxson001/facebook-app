package com.facebook.feedplugins.placetips;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.feedplugins.placetips.graphql.SuggestifierQuestionVoteMutationModels.SuggestifierQuestionVoteMutationModel;
import com.facebook.graphql.executor.GraphQLResult;

/* compiled from: friend_suggestions_done */
class PlaceTipsFeedUnitBinder$2 extends AbstractDisposableFutureCallback<GraphQLResult<SuggestifierQuestionVoteMutationModel>> {
    final /* synthetic */ PlaceTipsFeedUnitBinder f12918a;

    PlaceTipsFeedUnitBinder$2(PlaceTipsFeedUnitBinder placeTipsFeedUnitBinder) {
        this.f12918a = placeTipsFeedUnitBinder;
    }

    protected final void m14661a(Throwable th) {
        this.f12918a.b.a(PlaceTipsFeedUnitBinder.a, "Failed to submit Suggestifier question response");
    }
}
