package com.facebook.richdocument.fetcher;

import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLResult;
import javax.annotation.Nullable;

/* compiled from: previous-slide */
class BaseLocalCachingFetcher$DelegatingDisposableFutureCallback implements DisposableFutureCallback<GraphQLResult<T>> {
    final /* synthetic */ BaseLocalCachingFetcher f5200a;
    private final DisposableFutureCallback<GraphQLResult<T>> f5201b;
    private final String f5202c;

    public void onSuccess(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        this.f5200a.c.a(this.f5202c, new BaseLocalCachingFetcher$CacheUnit(this.f5200a, this.f5200a.b.now(), graphQLResult.e));
        this.f5201b.onSuccess(graphQLResult);
    }

    public BaseLocalCachingFetcher$DelegatingDisposableFutureCallback(BaseLocalCachingFetcher baseLocalCachingFetcher, DisposableFutureCallback<GraphQLResult<T>> disposableFutureCallback, String str) {
        this.f5200a = baseLocalCachingFetcher;
        this.f5201b = disposableFutureCallback;
        this.f5202c = str;
    }

    public final void jc_() {
        this.f5201b.jc_();
    }

    public final boolean ba_() {
        return this.f5201b.ba_();
    }

    public void onFailure(Throwable th) {
        this.f5201b.onFailure(th);
    }
}
