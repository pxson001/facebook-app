package com.facebook.feed.data;

import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_FeedFetchExecutorServiceMethodAutoProvider;
import com.facebook.feed.data.util.StreamingFeedLogger;
import com.facebook.feed.loader.FeedLoaderParams;
import com.facebook.feedback.prefetcher.FeedbackPrefetcher;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.concurrent.ExecutorService;

/* compiled from: wear_app_soft_alarm */
public class GraphQLQueryExecutorFeedFetchProvider extends AbstractAssistedProvider<GraphQLQueryExecutorFeedFetch> {
    public final GraphQLQueryExecutorFeedFetch m195a(FeedLoaderParams feedLoaderParams) {
        return new GraphQLQueryExecutorFeedFetch(feedLoaderParams, GraphQLQueryExecutor.a(this), Handler_ForUiThreadMethodAutoProvider.b(this), IdBasedSingletonScopeProvider.b(this, 1417), IdBasedSingletonScopeProvider.b(this, 1311), StreamingFeedLogger.m231b((InjectorLike) this), IdBasedProvider.a(this, 3981), (ExecutorService) ListeningExecutorService_FeedFetchExecutorServiceMethodAutoProvider.a(this), FeedbackPrefetcher.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
