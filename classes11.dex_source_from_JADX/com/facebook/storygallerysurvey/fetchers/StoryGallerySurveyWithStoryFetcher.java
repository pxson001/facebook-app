package com.facebook.storygallerysurvey.fetchers;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.storygallerysurvey.protocol.FetchStoryGallerySurveyWithStoryGraphQL.FetchStoryGallerySurveyWithStoryQueryString;
import com.facebook.storygallerysurvey.protocol.FetchStoryGallerySurveyWithStoryGraphQLModels.FetchStoryGallerySurveyWithStoryQueryModel;
import com.facebook.storygallerysurvey.protocol.FetchStoryGallerySurveyWithStoryGraphQLModels.FetchStoryGallerySurveyWithStoryQueryModel.StoryGallerySurveyModel;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Function;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Not on an AsyncTask thread */
public class StoryGallerySurveyWithStoryFetcher {
    public final GraphQLQueryExecutor f12938a;
    public final TasksManager f12939b;
    public final Executor f12940c;
    public StoryGallerySurveyModel f12941d;

    /* compiled from: Not on an AsyncTask thread */
    public class C15261 implements Callable<ListenableFuture<StoryGallerySurveyModel>> {
        final /* synthetic */ StoryGallerySurveyWithStoryFetcher f12934a;

        public C15261(StoryGallerySurveyWithStoryFetcher storyGallerySurveyWithStoryFetcher) {
            this.f12934a = storyGallerySurveyWithStoryFetcher;
        }

        public Object call() {
            StoryGallerySurveyWithStoryFetcher storyGallerySurveyWithStoryFetcher = this.f12934a;
            return Futures.a(storyGallerySurveyWithStoryFetcher.f12938a.a(GraphQLRequest.a(new FetchStoryGallerySurveyWithStoryQueryString())), new C15283(storyGallerySurveyWithStoryFetcher), storyGallerySurveyWithStoryFetcher.f12940c);
        }
    }

    /* compiled from: Not on an AsyncTask thread */
    public class C15272 extends AbstractDisposableFutureCallback<StoryGallerySurveyModel> {
        final /* synthetic */ FutureCallback f12935a;
        final /* synthetic */ StoryGallerySurveyWithStoryFetcher f12936b;

        public C15272(StoryGallerySurveyWithStoryFetcher storyGallerySurveyWithStoryFetcher, FutureCallback futureCallback) {
            this.f12936b = storyGallerySurveyWithStoryFetcher;
            this.f12935a = futureCallback;
        }

        protected final void m13632a(Object obj) {
            StoryGallerySurveyModel storyGallerySurveyModel = (StoryGallerySurveyModel) obj;
            if (storyGallerySurveyModel != null) {
                this.f12935a.onSuccess(storyGallerySurveyModel.m13687a());
            }
        }

        protected final void m13633a(Throwable th) {
            this.f12935a.onFailure(th);
        }
    }

    /* compiled from: Not on an AsyncTask thread */
    public class C15283 implements Function<GraphQLResult<FetchStoryGallerySurveyWithStoryQueryModel>, StoryGallerySurveyModel> {
        final /* synthetic */ StoryGallerySurveyWithStoryFetcher f12937a;

        public C15283(StoryGallerySurveyWithStoryFetcher storyGallerySurveyWithStoryFetcher) {
            this.f12937a = storyGallerySurveyWithStoryFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f12937a.f12941d = ((FetchStoryGallerySurveyWithStoryQueryModel) graphQLResult.e).m13690a();
            return this.f12937a.f12941d;
        }
    }

    public static StoryGallerySurveyWithStoryFetcher m13634b(InjectorLike injectorLike) {
        return new StoryGallerySurveyWithStoryFetcher(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public StoryGallerySurveyWithStoryFetcher(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, ExecutorService executorService) {
        this.f12938a = graphQLQueryExecutor;
        this.f12939b = tasksManager;
        this.f12940c = executorService;
    }
}
