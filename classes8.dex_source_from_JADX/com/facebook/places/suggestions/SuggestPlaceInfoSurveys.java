package com.facebook.places.suggestions;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.survey.graphql.FetchSurveyConfig.FetchSurveyConfigString;
import com.facebook.survey.graphql.FetchSurveyConfigModels.FetchSurveyConfigModel;
import com.facebook.survey.util.SurveyUtil;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: season */
public class SuggestPlaceInfoSurveys {
    public final GraphQLQueryExecutor f3710a;
    private final TasksManager<Integer> f3711b;
    public final SurveyUtil f3712c;
    public Long f3713d;
    public Long f3714e;

    /* compiled from: season */
    class C04771 implements FutureCallback<Long> {
        final /* synthetic */ SuggestPlaceInfoSurveys f3704a;

        C04771(SuggestPlaceInfoSurveys suggestPlaceInfoSurveys) {
            this.f3704a = suggestPlaceInfoSurveys;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f3704a.f3713d = (Long) obj;
        }

        public void onFailure(Throwable th) {
            this.f3704a.f3713d = null;
        }
    }

    /* compiled from: season */
    class C04782 implements FutureCallback<Long> {
        final /* synthetic */ SuggestPlaceInfoSurveys f3705a;

        C04782(SuggestPlaceInfoSurveys suggestPlaceInfoSurveys) {
            this.f3705a = suggestPlaceInfoSurveys;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f3705a.f3714e = (Long) obj;
        }

        public void onFailure(Throwable th) {
            this.f3705a.f3714e = null;
        }
    }

    @Inject
    public SuggestPlaceInfoSurveys(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, SurveyUtil surveyUtil) {
        this.f3710a = graphQLQueryExecutor;
        this.f3711b = tasksManager;
        this.f3712c = surveyUtil;
    }

    public final void m3630a() {
        m3629a(1, "461790513959484", new C04771(this));
        m3629a(2, "708206572588680", new C04782(this));
    }

    private void m3629a(int i, final String str, final FutureCallback<Long> futureCallback) {
        this.f3711b.a(Integer.valueOf(i), new Callable<ListenableFuture<GraphQLResult<FetchSurveyConfigModel>>>(this) {
            final /* synthetic */ SuggestPlaceInfoSurveys f3707b;

            public Object call() {
                GraphQlQueryString fetchSurveyConfigString = new FetchSurveyConfigString();
                fetchSurveyConfigString.a("survey_config_id", str).a("view_type", "RFMCard");
                GraphQLRequest a = GraphQLRequest.a(fetchSurveyConfigString);
                a.a(GraphQLCachePolicy.c);
                return this.f3707b.f3710a.a(a);
            }
        }, new AbstractDisposableFutureCallback<GraphQLResult<FetchSurveyConfigModel>>(this) {
            final /* synthetic */ SuggestPlaceInfoSurveys f3709b;

            protected final void m3627a(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.d() == null || ((FetchSurveyConfigModel) graphQLResult.d()).a() == null || Strings.isNullOrEmpty(((FetchSurveyConfigModel) graphQLResult.d()).j())) {
                    futureCallback.onSuccess(null);
                    return;
                }
                try {
                    futureCallback.onSuccess(Long.valueOf(Long.parseLong(((FetchSurveyConfigModel) graphQLResult.d()).a().j())));
                } catch (Throwable e) {
                    futureCallback.onFailure(e);
                }
            }

            protected final void m3628a(Throwable th) {
                futureCallback.onFailure(th);
            }
        });
    }
}
