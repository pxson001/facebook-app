package com.facebook.controller.mutation.util;

import com.facebook.api.ufiservices.common.ToggleLikeParams;
import com.facebook.api.ufiservices.common.TogglePageLikeParams;
import com.facebook.fbservice.service.OperationResult;
import java.util.concurrent.Callable;

/* compiled from: accessibility_caption */
class FeedbackGraphQLGenerator$6 implements Callable<OperationResult> {
    final /* synthetic */ TogglePageLikeParams f11730a;
    final /* synthetic */ FeedbackGraphQLGenerator f11731b;

    FeedbackGraphQLGenerator$6(FeedbackGraphQLGenerator feedbackGraphQLGenerator, TogglePageLikeParams togglePageLikeParams) {
        this.f11731b = feedbackGraphQLGenerator;
        this.f11730a = togglePageLikeParams;
    }

    public Object call() {
        FeedbackGraphQLGenerator feedbackGraphQLGenerator = this.f11731b;
        TogglePageLikeParams togglePageLikeParams = this.f11730a;
        return FeedbackGraphQLGenerator.a(feedbackGraphQLGenerator, new ToggleLikeParams(togglePageLikeParams.f10336a, togglePageLikeParams.f10337b, togglePageLikeParams.f10338c, togglePageLikeParams.f10339d, null, togglePageLikeParams.f10340e), "feed_toggle_page_like");
    }
}
