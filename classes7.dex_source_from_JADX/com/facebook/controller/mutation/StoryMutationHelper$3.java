package com.facebook.controller.mutation;

import com.facebook.api.ufiservices.common.TogglePostLikeParams;
import com.facebook.fbservice.service.OperationResult;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: tap_outside */
class StoryMutationHelper$3 implements Callable<ListenableFuture<OperationResult>> {
    final /* synthetic */ TogglePostLikeParams f2293a;
    final /* synthetic */ StoryMutationHelper f2294b;

    StoryMutationHelper$3(StoryMutationHelper storyMutationHelper, TogglePostLikeParams togglePostLikeParams) {
        this.f2294b = storyMutationHelper;
        this.f2293a = togglePostLikeParams;
    }

    public Object call() {
        return this.f2294b.g.a(this.f2293a);
    }
}
