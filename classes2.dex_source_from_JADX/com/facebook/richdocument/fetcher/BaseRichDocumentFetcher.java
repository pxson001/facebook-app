package com.facebook.richdocument.fetcher;

import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: fetch_thread_list */
public abstract class BaseRichDocumentFetcher<T> {
    private final GraphQLQueryExecutor f23873a;

    public BaseRichDocumentFetcher(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f23873a = graphQLQueryExecutor;
    }

    public void mo3508a(@Nullable RichDocumentFetchParams<GraphQLRequest<T>> richDocumentFetchParams, @Nullable DisposableFutureCallback<GraphQLResult<T>> disposableFutureCallback) {
        if (richDocumentFetchParams != null && disposableFutureCallback != null) {
            Futures.m2458a(this.f23873a.m10446a((GraphQLRequest) richDocumentFetchParams.a()), (FutureCallback) disposableFutureCallback, (Executor) DirectExecutor.INSTANCE);
        }
    }
}
