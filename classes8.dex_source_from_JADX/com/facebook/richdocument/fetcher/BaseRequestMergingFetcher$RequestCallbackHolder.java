package com.facebook.richdocument.fetcher;

import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.annotation.Nullable;

/* compiled from: preset_search_location */
public class BaseRequestMergingFetcher$RequestCallbackHolder implements DisposableFutureCallback<GraphQLResult<T>> {
    final /* synthetic */ BaseRequestMergingFetcher f5208a;
    private final List<DisposableFutureCallback<GraphQLResult<T>>> f5209b = new Vector();
    private final String f5210c;
    public final long f5211d;
    private GraphQLResult<T> f5212e;
    private boolean f5213f = false;
    private Throwable f5214g;

    public void onSuccess(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        synchronized (this) {
            this.f5212e = graphQLResult;
            List<DisposableFutureCallback> arrayList = new ArrayList(this.f5209b);
            this.f5209b.clear();
        }
        for (DisposableFutureCallback disposableFutureCallback : arrayList) {
            if (!(disposableFutureCallback == null || disposableFutureCallback.ba_())) {
                disposableFutureCallback.onSuccess(graphQLResult);
            }
        }
        BaseRequestMergingFetcher.a(this.f5208a, this.f5210c);
    }

    public BaseRequestMergingFetcher$RequestCallbackHolder(BaseRequestMergingFetcher baseRequestMergingFetcher, String str, long j, DisposableFutureCallback<GraphQLResult<T>> disposableFutureCallback) {
        this.f5208a = baseRequestMergingFetcher;
        this.f5210c = str;
        this.f5211d = j;
        this.f5209b.add(disposableFutureCallback);
    }

    public final void m5154a(DisposableFutureCallback<GraphQLResult<T>> disposableFutureCallback) {
        if (disposableFutureCallback != null && !disposableFutureCallback.ba_()) {
            synchronized (this) {
                if (this.f5212e != null) {
                    disposableFutureCallback.onSuccess(this.f5212e);
                } else if (this.f5214g != null) {
                    disposableFutureCallback.onFailure(this.f5214g);
                } else {
                    this.f5209b.add(disposableFutureCallback);
                }
            }
        }
    }

    public final synchronized void jc_() {
        this.f5213f = true;
    }

    public final boolean ba_() {
        return this.f5213f;
    }

    public void onFailure(Throwable th) {
        synchronized (this) {
            this.f5214g = th;
            List<DisposableFutureCallback> arrayList = new ArrayList(this.f5209b);
            this.f5209b.clear();
        }
        for (DisposableFutureCallback disposableFutureCallback : arrayList) {
            if (!(disposableFutureCallback == null || disposableFutureCallback.ba_())) {
                disposableFutureCallback.onFailure(th);
            }
        }
        BaseRequestMergingFetcher.a(this.f5208a, this.f5210c);
    }
}
