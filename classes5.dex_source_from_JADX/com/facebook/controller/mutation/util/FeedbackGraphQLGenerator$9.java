package com.facebook.controller.mutation.util;

import android.os.Bundle;
import com.facebook.api.ufiservices.common.DeleteCommentParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: accessibility_caption */
class FeedbackGraphQLGenerator$9 implements Callable<OperationResult> {
    final /* synthetic */ DeleteCommentParams f11736a;
    final /* synthetic */ FeedbackGraphQLGenerator f11737b;

    FeedbackGraphQLGenerator$9(FeedbackGraphQLGenerator feedbackGraphQLGenerator, DeleteCommentParams deleteCommentParams) {
        this.f11737b = feedbackGraphQLGenerator;
        this.f11736a = deleteCommentParams;
    }

    public Object call() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("deleteCommentParams", this.f11736a);
        return (OperationResult) FutureDetour.a(BlueServiceOperationFactoryDetour.a(this.f11737b.e, "feed_delete_comment", bundle, -533013930).a(), 60, TimeUnit.SECONDS, -1611191519);
    }
}
