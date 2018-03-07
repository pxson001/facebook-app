package com.facebook.search.quickpromotion;

import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.prefs.SearchAwarenessPrefKeys;
import com.facebook.search.protocol.awareness.SearchAwareness;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxConfigurationModel;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: TE;TV;)V */
public class SearchAwarenessTutorialNuxConfigurationLoader {
    @Inject
    public volatile Provider<FbSharedPreferences> f22452a = UltralightRuntime.a;
    private final ExecutorService f22453b;
    private final GraphQLQueryExecutor f22454c;
    public OnConfigurationFetchedListener f22455d;
    private ListenableFuture<GraphQLResult<TutorialNuxConfigurationModel>> f22456e;

    /* compiled from: TE;TV;)V */
    class C23941 implements FutureCallback<GraphQLResult<TutorialNuxConfigurationModel>> {
        final /* synthetic */ SearchAwarenessTutorialNuxConfigurationLoader f22451a;

        C23941(SearchAwarenessTutorialNuxConfigurationLoader searchAwarenessTutorialNuxConfigurationLoader) {
            this.f22451a = searchAwarenessTutorialNuxConfigurationLoader;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                SearchAwarenessTutorialNuxConfigurationLoader searchAwarenessTutorialNuxConfigurationLoader = this.f22451a;
                TutorialNuxConfigurationModel tutorialNuxConfigurationModel = (TutorialNuxConfigurationModel) graphQLResult.e;
                if (searchAwarenessTutorialNuxConfigurationLoader.f22455d != null) {
                    searchAwarenessTutorialNuxConfigurationLoader.f22455d.a(tutorialNuxConfigurationModel);
                }
            }
        }

        public void onFailure(Throwable th) {
            SearchAwarenessTutorialNuxConfigurationLoader searchAwarenessTutorialNuxConfigurationLoader = this.f22451a;
            GraphSearchException graphSearchException = new GraphSearchException(GraphSearchError.FETCH_AWARENESS_TUTORIAL_CONFIG_FAIL, th);
            if (searchAwarenessTutorialNuxConfigurationLoader.f22455d != null) {
                searchAwarenessTutorialNuxConfigurationLoader.f22455d.a(graphSearchException);
            }
        }
    }

    @Inject
    public SearchAwarenessTutorialNuxConfigurationLoader(ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f22453b = executorService;
        this.f22454c = graphQLQueryExecutor;
    }

    public final void m25933a() {
        if (this.f22456e == null || this.f22456e.isDone()) {
            GraphQLCachePolicy graphQLCachePolicy;
            GraphQLRequest a = GraphQLRequest.a(SearchAwareness.b());
            if (((FbSharedPreferences) this.f22452a.get()).a(SearchAwarenessPrefKeys.g, false)) {
                graphQLCachePolicy = GraphQLCachePolicy.c;
            } else {
                graphQLCachePolicy = GraphQLCachePolicy.a;
            }
            m25932a(a.a(graphQLCachePolicy).a(86400));
        }
    }

    public final void m25934b() {
        if (this.f22456e == null || this.f22456e.isDone()) {
            m25932a(GraphQLRequest.a(SearchAwareness.b()).a(GraphQLCachePolicy.c).a(0));
        }
    }

    private void m25932a(GraphQLRequest graphQLRequest) {
        this.f22456e = this.f22454c.a(graphQLRequest);
        Futures.a(this.f22456e, new C23941(this), this.f22453b);
    }
}
