package com.facebook.structuredsurvey;

import com.facebook.fbservice.service.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: draft_disabled_for_source_type */
class StructuredSurveyController$3 implements FutureCallback<OperationResult> {
    final /* synthetic */ StructuredSurveyController f17096a;

    StructuredSurveyController$3(StructuredSurveyController structuredSurveyController) {
        this.f17096a = structuredSurveyController;
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
    }

    public void onFailure(Throwable th) {
        this.f17096a.k.a(StructuredSurveyController.d, "NaRF:Survey Post Answer Failed", th);
    }
}
