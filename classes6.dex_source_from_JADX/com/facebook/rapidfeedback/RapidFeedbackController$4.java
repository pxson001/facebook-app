package com.facebook.rapidfeedback;

import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.structuredsurvey.StructuredSurveyController;
import java.util.concurrent.TimeUnit;

/* compiled from: fallbackPath */
public class RapidFeedbackController$4 implements Runnable {
    final /* synthetic */ FragmentManagerHost f15337a;
    final /* synthetic */ String f15338b;
    final /* synthetic */ int f15339c;
    final /* synthetic */ RapidFeedbackController f15340d;

    public RapidFeedbackController$4(RapidFeedbackController rapidFeedbackController, FragmentManagerHost fragmentManagerHost, String str, int i) {
        this.f15340d = rapidFeedbackController;
        this.f15337a = fragmentManagerHost;
        this.f15338b = str;
        this.f15339c = i;
    }

    public void run() {
        if (this.f15337a.kO_().c()) {
            if (this.f15338b.equals("1007435825948876") && RapidFeedbackController.p(this.f15340d)) {
                RapidFeedbackController.a(this.f15340d, this.f15337a);
            } else {
                RapidFeedbackController.a(this.f15340d, this.f15337a, this.f15339c);
            }
            this.f15340d.i.schedule(this.f15340d.j, 15, TimeUnit.SECONDS);
            this.f15340d.a(StructuredSurveyController.b, this.f15338b);
        }
    }
}
