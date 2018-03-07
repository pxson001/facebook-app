package com.facebook.controller.mutation.util;

import com.facebook.api.ufiservices.common.ToggleLikeParams;
import com.facebook.fbservice.service.OperationResult;
import java.util.concurrent.Callable;

/* compiled from: accessibility_caption */
class FeedbackGraphQLGenerator$7 implements Callable<OperationResult> {
    final /* synthetic */ ToggleLikeParams f11732a;
    final /* synthetic */ FeedbackGraphQLGenerator f11733b;

    FeedbackGraphQLGenerator$7(FeedbackGraphQLGenerator feedbackGraphQLGenerator, ToggleLikeParams toggleLikeParams) {
        this.f11733b = feedbackGraphQLGenerator;
        this.f11732a = toggleLikeParams;
    }

    public Object call() {
        return FeedbackGraphQLGenerator.a(this.f11733b, this.f11732a, "feed_toggle_like");
    }
}
