package com.facebook.rapidfeedback.debug;

import android.content.Context;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.debug.context.DebugContext;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.FbInjector;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.rapidfeedback.RapidFeedbackController$4;
import com.facebook.structuredsurvey.StructuredSurveyController;
import com.facebook.structuredsurvey.StructuredSurveyController$4;
import com.facebook.structuredsurvey.graphql.StructuredSurveyQuery.StructuredSurveyQueryString;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;

/* compiled from: failed to add metadata to bug report */
public class DebugRapidFeedbackActivity extends FbFragmentActivity implements DebugContext {
    public RapidFeedbackController f15396p;

    private static <T extends Context> void m23006a(Class<T> cls, T t) {
        m23007a((Object) t, (Context) t);
    }

    public static void m23007a(Object obj, Context context) {
        ((DebugRapidFeedbackActivity) obj).f15396p = RapidFeedbackController.b(FbInjector.get(context));
    }

    protected final void m23008b(Bundle bundle) {
        super.b(bundle);
        Class cls = DebugRapidFeedbackActivity.class;
        m23007a((Object) this, (Context) this);
        if (bundle == null) {
            String string = getIntent().getExtras().getString("args_survey_id");
            String string2 = getIntent().getExtras().getString("args_integration_point_id");
            if (string != null && !string.equals("UNKNOWN")) {
                RapidFeedbackController rapidFeedbackController = this.f15396p;
                ((StructuredSurveyController) rapidFeedbackController.d.get()).E = this;
                StructuredSurveyController structuredSurveyController = (StructuredSurveyController) rapidFeedbackController.d.get();
                Runnable rapidFeedbackController$4 = new RapidFeedbackController$4(rapidFeedbackController, RapidFeedbackController.a(this), string, 2131625665);
                structuredSurveyController.H = ((GraphQLQueryExecutor) structuredSurveyController.f.get()).a(GraphQLRequest.a((StructuredSurveyQueryString) new StructuredSurveyQueryString().a("survey_id", string)).a(GraphQLCachePolicy.c));
                Futures.a(structuredSurveyController.H, new StructuredSurveyController$4(structuredSurveyController, rapidFeedbackController$4), structuredSurveyController.i);
            } else if (string2 != null && !string2.equals("UNKNOWN")) {
                this.f15396p.a(string2, this);
            }
        }
    }

    @Inject
    private void m23005a(RapidFeedbackController rapidFeedbackController) {
        this.f15396p = rapidFeedbackController;
    }
}
