package com.facebook.richdocument.fetcher;

import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableSet;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: fetch_tincan_identity_keys */
public abstract class BaseLocalCachingFetcher<T> extends BaseRequestMergingFetcher<T> {
    private final KeyFactory f23867a;
    public final MonotonicClock f23868b;
    public final Cache<String, CacheUnit> f23869c;

    public BaseLocalCachingFetcher(GraphQLQueryExecutor graphQLQueryExecutor, KeyFactory keyFactory, GatekeeperStoreImpl gatekeeperStoreImpl, MonotonicClock monotonicClock, long j, TimeUnit timeUnit) {
        super(graphQLQueryExecutor, keyFactory, gatekeeperStoreImpl);
        this.f23867a = keyFactory;
        this.f23868b = monotonicClock;
        this.f23869c = CacheBuilder.newBuilder().m1122a(5).m1131b(j, timeUnit).m1148q();
    }

    public BaseLocalCachingFetcher(GraphQLQueryExecutor graphQLQueryExecutor, KeyFactory keyFactory, MonotonicClock monotonicClock, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this(graphQLQueryExecutor, keyFactory, gatekeeperStoreImpl, monotonicClock, 30, TimeUnit.MINUTES);
    }

    public final void mo3508a(@Nullable RichDocumentFetchParams<GraphQLRequest<T>> richDocumentFetchParams, @Nullable DisposableFutureCallback<GraphQLResult<T>> disposableFutureCallback) {
        GraphQLRequest graphQLRequest = (GraphQLRequest) richDocumentFetchParams.a();
        Object a = graphQLRequest.m11601a(this.f23867a);
        CacheUnit cacheUnit = (CacheUnit) this.f23869c.mo110a(a);
        if (cacheUnit != null) {
            Object obj;
            long j = cacheUnit.b;
            if (this.f23868b.now() - j < graphQLRequest.f7086d) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                GraphQLResult graphQLResult = new GraphQLResult(cacheUnit.a, DataFreshnessResult.FROM_CACHE_UP_TO_DATE, this.f23868b.now(), ImmutableSet.of("FROM_MEMORY_CACHE"));
                if (disposableFutureCallback != null) {
                    disposableFutureCallback.onSuccess(graphQLResult);
                    return;
                }
                return;
            }
        }
        super.mo3508a((RichDocumentFetchParams) richDocumentFetchParams, new DelegatingDisposableFutureCallback(this, disposableFutureCallback, a));
    }
}
