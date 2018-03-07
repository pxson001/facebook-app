package com.facebook.controller.mutation;

import com.facebook.api.ufiservices.common.TogglePageLikeParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.rows.core.props.FeedProps;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: tap_outside */
class StoryMutationHelper$1 implements Callable<ListenableFuture<OperationResult>> {
    final /* synthetic */ TogglePageLikeParams f2284a;
    final /* synthetic */ FeedProps f2285b;
    final /* synthetic */ StoryMutationHelper f2286c;

    StoryMutationHelper$1(StoryMutationHelper storyMutationHelper, TogglePageLikeParams togglePageLikeParams, FeedProps feedProps) {
        this.f2286c = storyMutationHelper;
        this.f2284a = togglePageLikeParams;
        this.f2285b = feedProps;
    }

    public Object call() {
        return this.f2286c.g.a(this.f2284a, this.f2285b);
    }
}
