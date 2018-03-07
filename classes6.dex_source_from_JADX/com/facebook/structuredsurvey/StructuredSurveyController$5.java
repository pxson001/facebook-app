package com.facebook.structuredsurvey;

import com.facebook.ui.toaster.ToastBuilder;

/* compiled from: draft_disabled_for_source_type */
class StructuredSurveyController$5 implements Runnable {
    final /* synthetic */ String f17099a;
    final /* synthetic */ StructuredSurveyController f17100b;

    StructuredSurveyController$5(StructuredSurveyController structuredSurveyController, String str) {
        this.f17100b = structuredSurveyController;
        this.f17099a = str;
    }

    public void run() {
        this.f17100b.I.a(new ToastBuilder(this.f17099a));
    }
}
