package com.facebook.graphql.connection.configuration;

import com.facebook.graphql.connection.ConnectionTailLoaderManager.CachePolicy;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.ConnectionFetcherState;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.quicklog.QuickPerformanceLogger;
import java.util.concurrent.Executor;

/* compiled from: wiki_card */
public interface BatchConfiguration {
    long mo11a();

    GraphQLBatchRequest mo12a(QuickPerformanceLogger quickPerformanceLogger, ConnectionFetcherState connectionFetcherState, Executor executor, TailFetchLocation tailFetchLocation);

    @CachePolicy
    int mo13b();
}
