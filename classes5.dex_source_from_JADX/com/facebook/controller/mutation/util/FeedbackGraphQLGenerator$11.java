package com.facebook.controller.mutation.util;

import android.os.Bundle;
import com.facebook.api.ufiservices.common.SetNotifyMeParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: accessibility_caption */
class FeedbackGraphQLGenerator$11 implements Callable<OperationResult> {
    final /* synthetic */ SetNotifyMeParams f11706a;
    final /* synthetic */ FeedbackGraphQLGenerator f11707b;

    FeedbackGraphQLGenerator$11(FeedbackGraphQLGenerator feedbackGraphQLGenerator, SetNotifyMeParams setNotifyMeParams) {
        this.f11707b = feedbackGraphQLGenerator;
        this.f11706a = setNotifyMeParams;
    }

    public Object call() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("setNotifyMeParams", this.f11706a);
        return (OperationResult) FutureDetour.a(BlueServiceOperationFactoryDetour.a(this.f11707b.e, "feed_set_notify_me", bundle, 747462268).a(), 60, TimeUnit.SECONDS, 1386538486);
    }
}
