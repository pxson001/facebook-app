package com.facebook.controller.mutation.util;

import android.os.Bundle;
import com.facebook.api.ufiservices.common.EditCommentParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: accessibility_caption */
class FeedbackGraphQLGenerator$8 implements Callable<OperationResult> {
    final /* synthetic */ EditCommentParams f11734a;
    final /* synthetic */ FeedbackGraphQLGenerator f11735b;

    FeedbackGraphQLGenerator$8(FeedbackGraphQLGenerator feedbackGraphQLGenerator, EditCommentParams editCommentParams) {
        this.f11735b = feedbackGraphQLGenerator;
        this.f11734a = editCommentParams;
    }

    public Object call() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("editCommentParams", this.f11734a);
        return (OperationResult) FutureDetour.a(BlueServiceOperationFactoryDetour.a(this.f11735b.e, "feed_edit_comment", bundle, -1795121334).a(), 60, TimeUnit.SECONDS, -487369838);
    }
}
