package com.facebook.structuredsurvey;

import com.facebook.fbservice.service.OperationResult;
import com.facebook.structuredsurvey.StructuredSurveyConstants.ImpressionType;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: draft_disabled_for_source_type */
class StructuredSurveyController$2 implements FutureCallback<OperationResult> {
    final /* synthetic */ ImpressionType f17094a;
    final /* synthetic */ StructuredSurveyController f17095b;

    StructuredSurveyController$2(StructuredSurveyController structuredSurveyController, ImpressionType impressionType) {
        this.f17095b = structuredSurveyController;
        this.f17094a = impressionType;
    }

    public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
    }

    public void onFailure(Throwable th) {
        this.f17095b.k.a(StructuredSurveyController.d, "NaRF:Survey Post Impression:" + this.f17094a.getImpressionEvent() + " Failed");
    }
}
