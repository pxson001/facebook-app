package com.facebook.search.quickpromotion;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.prefs.SearchAwarenessPrefKeys;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.LearningNuxConfigurationModel;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ultralight.Inject;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: TEXT_CAPTION_CREDIT */
public class SearchAwarenessLearningNuxConfigurationLoader {
    public FbSharedPreferences f22386a;
    public final TasksManager<String> f22387b;
    public final GraphQLQueryExecutor f22388c;
    public SearchAwarenessController f22389d;

    /* compiled from: TEXT_CAPTION_CREDIT */
    public class C23801 implements Callable<ListenableFuture<GraphQLResult<LearningNuxConfigurationModel>>> {
        final /* synthetic */ GraphQLRequest f22383a;
        final /* synthetic */ SearchAwarenessLearningNuxConfigurationLoader f22384b;

        public C23801(SearchAwarenessLearningNuxConfigurationLoader searchAwarenessLearningNuxConfigurationLoader, GraphQLRequest graphQLRequest) {
            this.f22384b = searchAwarenessLearningNuxConfigurationLoader;
            this.f22383a = graphQLRequest;
        }

        public Object call() {
            return this.f22384b.f22388c.a(this.f22383a);
        }
    }

    /* compiled from: TEXT_CAPTION_CREDIT */
    public class C23812 extends AbstractDisposableFutureCallback<GraphQLResult<LearningNuxConfigurationModel>> {
        final /* synthetic */ SearchAwarenessLearningNuxConfigurationLoader f22385a;

        public C23812(SearchAwarenessLearningNuxConfigurationLoader searchAwarenessLearningNuxConfigurationLoader) {
            this.f22385a = searchAwarenessLearningNuxConfigurationLoader;
        }

        protected final void m25876a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            SearchAwarenessLearningNuxConfigurationLoader searchAwarenessLearningNuxConfigurationLoader = this.f22385a;
            LearningNuxConfigurationModel learningNuxConfigurationModel = (LearningNuxConfigurationModel) graphQLResult.e;
            if (searchAwarenessLearningNuxConfigurationLoader.f22389d != null) {
                SearchAwarenessController searchAwarenessController = searchAwarenessLearningNuxConfigurationLoader.f22389d;
                if (learningNuxConfigurationModel.m9003k() != null && searchAwarenessController.a(learningNuxConfigurationModel.m9003k())) {
                    searchAwarenessController.p = learningNuxConfigurationModel;
                }
                ((FbSharedPreferences) searchAwarenessController.n.get()).edit().a(SearchAwarenessPrefKeys.e, learningNuxConfigurationModel.m9002j() ? ((Clock) searchAwarenessController.o.get()).a() + 86400000 : ((Clock) searchAwarenessController.o.get()).a() + (((long) learningNuxConfigurationModel.m8998a()) * 3600000)).commit();
            }
            searchAwarenessLearningNuxConfigurationLoader.f22386a.edit().putBoolean(SearchAwarenessPrefKeys.f, false).commit();
        }

        protected final void m25877a(Throwable th) {
            SearchAwarenessLearningNuxConfigurationLoader searchAwarenessLearningNuxConfigurationLoader = this.f22385a;
            GraphSearchException graphSearchException = new GraphSearchException(GraphSearchError.FETCH_AWARENESS_LEARNING_CONFIG_FAIL, th);
            if (searchAwarenessLearningNuxConfigurationLoader.f22389d != null) {
                ((AbstractFbErrorReporter) searchAwarenessLearningNuxConfigurationLoader.f22389d.m.get()).a("SearchAwareness", graphSearchException);
            }
        }
    }

    @Inject
    public SearchAwarenessLearningNuxConfigurationLoader(FbSharedPreferences fbSharedPreferences, TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f22386a = fbSharedPreferences;
        this.f22387b = tasksManager;
        this.f22388c = graphQLQueryExecutor;
    }
}
