package com.facebook.search.results.fragment.common;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.model.GraphQLGraphSearchQuery;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.loader.GraphSearchDataLoader;
import com.facebook.search.logging.perf.GraphSearchPerformanceLogger;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SIMILAR_NAME */
public class ResultDataFetcher {
    private final DefaultAndroidThreadUtil f22975a;
    public final GraphSearchDataLoader f22976b;
    private final GraphSearchErrorReporter f22977c;
    public final GraphSearchPerformanceLogger f22978d;
    public ListenableFuture<OperationResult> f22979e;

    @Inject
    public ResultDataFetcher(DefaultAndroidThreadUtil defaultAndroidThreadUtil, GraphSearchDataLoader graphSearchDataLoader, GraphSearchErrorReporter graphSearchErrorReporter, GraphSearchPerformanceLogger graphSearchPerformanceLogger) {
        this.f22975a = defaultAndroidThreadUtil;
        this.f22976b = graphSearchDataLoader;
        this.f22977c = graphSearchErrorReporter;
        this.f22978d = graphSearchPerformanceLogger;
    }

    final void m26611a(SearchResultsMutableContext searchResultsMutableContext, @Nullable String str, ResultsDataAndListStateController resultsDataAndListStateController) {
        m26610b(searchResultsMutableContext, str, resultsDataAndListStateController);
    }

    private void m26610b(final SearchResultsMutableContext searchResultsMutableContext, final String str, final ResultsDataAndListStateController resultsDataAndListStateController) {
        m26607a(new Callable<ListenableFuture<OperationResult>>(this) {
            final /* synthetic */ ResultDataFetcher f22974c;

            public Object call() {
                return this.f22974c.f22976b.m25443a(searchResultsMutableContext, 10, str);
            }
        }, new OperationResultFutureCallback(this) {
            final /* synthetic */ ResultDataFetcher f22971c;

            protected final void m26603a(Object obj) {
                OperationResult operationResult = (OperationResult) obj;
                ResultDataFetcher resultDataFetcher = this.f22971c;
                GraphQLGraphSearchQuery j = ((GraphQLGraphSearchQuery) operationResult.h()).j();
                ResultsDataAndListStateController resultsDataAndListStateController = resultsDataAndListStateController;
                boolean isNullOrEmpty = Strings.isNullOrEmpty(str);
                resultDataFetcher.f22978d.m25559a();
                resultDataFetcher.f22979e = null;
                resultsDataAndListStateController.m26617a(j, isNullOrEmpty);
            }

            protected final void m26602a(ServiceException serviceException) {
                if (str == null) {
                    ResultDataFetcher.m26606a(this.f22971c, GraphSearchError.FETCH_GRAPH_SEARCH_RESULT_DATA_FAIL, serviceException, resultsDataAndListStateController);
                } else {
                    ResultDataFetcher.m26609b(this.f22971c, GraphSearchError.FETCH_MORE_GRAPH_SEARCH_RESULT_DATA_FAIL, serviceException, resultsDataAndListStateController);
                }
            }

            protected final void m26604a(CancellationException cancellationException) {
                ResultDataFetcher resultDataFetcher = this.f22971c;
                ResultsDataAndListStateController resultsDataAndListStateController = resultsDataAndListStateController;
                resultDataFetcher.f22978d.m25563c();
                resultDataFetcher.f22979e = null;
                resultsDataAndListStateController.m26622e();
            }
        });
    }

    private void m26607a(Callable<ListenableFuture<OperationResult>> callable, OperationResultFutureCallback operationResultFutureCallback) {
        m26608b();
        this.f22978d.m25565f();
        try {
            this.f22979e = (ListenableFuture) callable.call();
            this.f22975a.a(this.f22979e, operationResultFutureCallback);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static void m26606a(ResultDataFetcher resultDataFetcher, GraphSearchError graphSearchError, Exception exception, ResultsDataAndListStateController resultsDataAndListStateController) {
        resultDataFetcher.m26605a(graphSearchError, exception);
        resultsDataAndListStateController.m26620b();
    }

    public static void m26609b(ResultDataFetcher resultDataFetcher, GraphSearchError graphSearchError, Exception exception, ResultsDataAndListStateController resultsDataAndListStateController) {
        resultDataFetcher.m26605a(graphSearchError, exception);
        resultsDataAndListStateController.m26621c();
    }

    private void m26605a(GraphSearchError graphSearchError, Exception exception) {
        this.f22978d.m25561b();
        this.f22979e = null;
        this.f22977c.a(graphSearchError, exception);
    }

    private void m26608b() {
        if (this.f22979e != null) {
            this.f22979e.cancel(true);
        }
    }
}
