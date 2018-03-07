package com.facebook.richdocument.fetcher;

import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLResult;

/* compiled from: preset_search_location */
class BaseRequestMergingFetcher$MergingCallbackDelegate implements DisposableFutureCallback<GraphQLResult<T>> {
    final /* synthetic */ BaseRequestMergingFetcher f5205a;
    private final DisposableFutureCallback<GraphQLResult<T>> f5206b;
    private boolean f5207c = false;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(@javax.annotation.Nullable java.lang.Object r2) {
        /*
        r1 = this;
        r2 = (com.facebook.graphql.executor.GraphQLResult) r2;
        monitor-enter(r1);
        r0 = r1.f5207c;	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x0017;
    L_0x0007:
        r0 = r1.f5206b;	 Catch:{ all -> 0x0023 }
        r0 = r0.ba_();	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x0017;
    L_0x000f:
        if (r2 == 0) goto L_0x0017;
    L_0x0011:
        r0 = r2.d();	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x0019;
    L_0x0017:
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
    L_0x0018:
        return;
    L_0x0019:
        r1.jc_();	 Catch:{ all -> 0x0023 }
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        r0 = r1.f5206b;
        r0.onSuccess(r2);
        goto L_0x0018;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.fetcher.BaseRequestMergingFetcher$MergingCallbackDelegate.onSuccess(java.lang.Object):void");
    }

    public BaseRequestMergingFetcher$MergingCallbackDelegate(BaseRequestMergingFetcher baseRequestMergingFetcher, DisposableFutureCallback<GraphQLResult<T>> disposableFutureCallback) {
        this.f5205a = baseRequestMergingFetcher;
        this.f5206b = disposableFutureCallback;
    }

    public final void jc_() {
        this.f5207c = true;
    }

    public final boolean ba_() {
        return this.f5207c;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFailure(java.lang.Throwable r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.f5207c;	 Catch:{ all -> 0x0019 }
        if (r0 != 0) goto L_0x000d;
    L_0x0005:
        r0 = r1.f5206b;	 Catch:{ all -> 0x0019 }
        r0 = r0.ba_();	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x000f;
    L_0x000d:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
    L_0x000e:
        return;
    L_0x000f:
        r1.jc_();	 Catch:{ all -> 0x0019 }
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        r0 = r1.f5206b;
        r0.onFailure(r2);
        goto L_0x000e;
    L_0x0019:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.fetcher.BaseRequestMergingFetcher$MergingCallbackDelegate.onFailure(java.lang.Throwable):void");
    }
}
