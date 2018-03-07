package com.facebook.feed.rows.sections.inlinesurvey.data;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.feed.rows.sections.inlinesurvey.protocol.InlineSurveySubmitMutation.InlineSurveySubmitMutationString;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.InlineSurveySubmitInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.ui.futures.TasksManager;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: in_app_sounds_enabled */
public class InlineSurveySubmitMutator {
    private final TasksManager f20279a;
    private final GraphQLQueryExecutor f20280b;
    private final String f20281c;

    @Inject
    public InlineSurveySubmitMutator(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, String str) {
        this.f20279a = tasksManager;
        this.f20280b = graphQLQueryExecutor;
        this.f20281c = str;
    }

    public final void m27952a(@Nullable String str, int i, int i2, int i3, AbstractDisposableFutureCallback abstractDisposableFutureCallback) {
        String str2;
        TypedGraphQLMutationString inlineSurveySubmitMutationString = new InlineSurveySubmitMutationString();
        String str3 = "input";
        InlineSurveySubmitInputData inlineSurveySubmitInputData = new InlineSurveySubmitInputData();
        inlineSurveySubmitInputData.m11397a("actor_id", this.f20281c);
        GraphQlCallInput graphQlCallInput = inlineSurveySubmitInputData;
        graphQlCallInput.m11397a("data_ft", str);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.m11397a("selection", String.valueOf(i));
        GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
        if (i2 <= 0) {
            str2 = null;
        } else {
            str2 = String.valueOf(i2);
        }
        graphQlCallInput2.m11397a("followup_selection", str2);
        graphQlCallInput = graphQlCallInput2;
        graphQlCallInput.m11396a("event_timestamp", Integer.valueOf(i3));
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.m11397a("event", "inline_responded");
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.m11397a("survey_pool_type", "inline_android");
        inlineSurveySubmitMutationString.m11310a(str3, graphQlCallInput);
        this.f20279a.m14562c("MUTATE_INLINE_SURVEY_SUBMIT_KEY", this.f20280b.m10448a(GraphQLRequest.m11588a(inlineSurveySubmitMutationString)), abstractDisposableFutureCallback);
    }
}
