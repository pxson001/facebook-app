package com.facebook.composer.minutiae.intent;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQL.FetchSingleTaggableSuggestionQueryString;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.FetchSingleTaggableSuggestionQueryModel;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.TaggableObjectEdgeModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.model.MinutiaeObject.Builder;
import com.facebook.composer.minutiae.protocol.MinutiaeGraphQLVerificationHelper;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: toggle_comment_like_ */
public class SingleMinutiaeFetcher {
    public static final String f1556a = SingleMinutiaeFetcher.class.getSimpleName();
    public TasksManager f1557b;
    public AbstractFbErrorReporter f1558c;
    public GraphQLQueryExecutor f1559d;
    public MinutiaeGraphQLVerificationHelper f1560e;

    /* compiled from: toggle_comment_like_ */
    public class C01491 implements Function<GraphQLResult<FetchSingleTaggableSuggestionQueryModel>, MinutiaeObject> {
        final /* synthetic */ SingleMinutiaeFetcher f1553a;

        public C01491(SingleMinutiaeFetcher singleMinutiaeFetcher) {
            this.f1553a = singleMinutiaeFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            MinutiaeTaggableActivity minutiaeTaggableActivity;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                minutiaeTaggableActivity = (FetchSingleTaggableSuggestionQueryModel) graphQLResult.e;
            } else {
                minutiaeTaggableActivity = null;
            }
            if (minutiaeTaggableActivity == null || minutiaeTaggableActivity.s() == null || minutiaeTaggableActivity.s().a() == null || minutiaeTaggableActivity.s().a().isEmpty() || !this.f1553a.f1560e.m1681a(minutiaeTaggableActivity) || !this.f1553a.f1560e.m1680a((TaggableObjectEdgeModel) minutiaeTaggableActivity.s().a().get(0))) {
                return null;
            }
            Builder builder = new Builder();
            builder.a = minutiaeTaggableActivity;
            Builder builder2 = builder;
            builder2.b = (TaggableObjectEdgeModel) minutiaeTaggableActivity.s().a().get(0);
            return builder2.a();
        }
    }

    public static SingleMinutiaeFetcher m1607b(InjectorLike injectorLike) {
        return new SingleMinutiaeFetcher(TasksManager.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), MinutiaeGraphQLVerificationHelper.m1679b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public SingleMinutiaeFetcher(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, MinutiaeGraphQLVerificationHelper minutiaeGraphQLVerificationHelper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f1557b = tasksManager;
        this.f1559d = graphQLQueryExecutor;
        this.f1560e = minutiaeGraphQLVerificationHelper;
        this.f1558c = abstractFbErrorReporter;
    }

    public final void m1608a(String str, ExecutorService executorService, String str2, String str3, final DisposableFutureCallback<MinutiaeObject> disposableFutureCallback) {
        TasksManager tasksManager = this.f1557b;
        GraphQlQueryString fetchSingleTaggableSuggestionQueryString = new FetchSingleTaggableSuggestionQueryString();
        fetchSingleTaggableSuggestionQueryString.a("legacy_activity_api_id", str2).a("object_id", str3);
        tasksManager.a(str, Futures.a(this.f1559d.a(GraphQLRequest.a(fetchSingleTaggableSuggestionQueryString).a(GraphQLCachePolicy.c)), new C01491(this), executorService), new AbstractDisposableFutureCallback<MinutiaeObject>(this) {
            final /* synthetic */ SingleMinutiaeFetcher f1555b;

            protected final void m1605a(Object obj) {
                MinutiaeObject minutiaeObject = (MinutiaeObject) obj;
                if (minutiaeObject == null) {
                    m1606a(new Throwable());
                } else {
                    disposableFutureCallback.onSuccess(minutiaeObject);
                }
            }

            protected final void m1606a(Throwable th) {
                this.f1555b.f1558c.a(SingleMinutiaeFetcher.f1556a, th);
                disposableFutureCallback.onFailure(th);
            }
        });
    }
}
