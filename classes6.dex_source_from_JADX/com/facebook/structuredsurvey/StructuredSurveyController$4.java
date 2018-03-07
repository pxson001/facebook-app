package com.facebook.structuredsurvey;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels.StructuredSurveyFragmentModel;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: draft_disabled_for_source_type */
public class StructuredSurveyController$4 implements FutureCallback<GraphQLResult<StructuredSurveyFragmentModel>> {
    final /* synthetic */ Runnable f17097a;
    final /* synthetic */ StructuredSurveyController f17098b;

    public StructuredSurveyController$4(StructuredSurveyController structuredSurveyController, Runnable runnable) {
        this.f17098b = structuredSurveyController;
        this.f17097a = runnable;
    }

    public void onSuccess(@Nullable Object obj) {
        try {
            StructuredSurveyFragmentModel structuredSurveyFragmentModel = (StructuredSurveyFragmentModel) ((GraphQLResult) obj).d();
            StructuredSurveyController.b(this.f17098b, structuredSurveyFragmentModel.m25067j());
            StructuredSurveyController.a(this.f17098b, new StructuredSurveyState());
            StructuredSurveyController.a(this.f17098b, new StructuredSurveyFlowController(structuredSurveyFragmentModel.m25068k(), this.f17098b.s));
            StructuredSurveyController.a(this.f17098b, new StructuredSurveyBuilder(this.f17098b.F, this.f17098b.u));
            this.f17098b.r.m24792a(this.f17098b.F.getString(2131236125));
            this.f17098b.r.m24795b(this.f17098b.F.getString(2131236119));
            this.f17098b.r.m24797c(this.f17098b.F.getString(2131236120));
            this.f17098b.r.m24790a(this.f17098b.q.m24805b());
            this.f17097a.run();
        } catch (Throwable e) {
            StructuredSurveyController.c(this.f17098b, this.f17098b.F.getString(2131236126));
            this.f17098b.k.a(StructuredSurveyController.d, "NaRF:Survey Model Init Failed", e);
        }
    }

    public void onFailure(Throwable th) {
        StructuredSurveyController.c(this.f17098b, this.f17098b.F.getString(2131236129));
        this.f17098b.k.a(StructuredSurveyController.d, "NaRF:Survey GraphQL Fetch Failed", th);
    }
}
