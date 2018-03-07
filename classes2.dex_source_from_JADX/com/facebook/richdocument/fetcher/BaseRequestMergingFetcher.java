package com.facebook.richdocument.fetcher;

import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: fetch_thread_queue_enabled */
public class BaseRequestMergingFetcher<T> extends BaseRichDocumentFetcher<T> {
    private final KeyFactory f23870a;
    public final GatekeeperStoreImpl f23871b;
    private final Cache<String, RequestCallbackHolder> f23872c = CacheBuilder.newBuilder().m1122a(5).m1123a(5, TimeUnit.MINUTES).m1148q();

    public BaseRequestMergingFetcher(GraphQLQueryExecutor graphQLQueryExecutor, KeyFactory keyFactory, GatekeeperStoreImpl gatekeeperStoreImpl) {
        super(graphQLQueryExecutor);
        this.f23870a = keyFactory;
        this.f23871b = gatekeeperStoreImpl;
    }

    public void mo3508a(@Nullable RichDocumentFetchParams<GraphQLRequest<T>> richDocumentFetchParams, @Nullable DisposableFutureCallback<GraphQLResult<T>> disposableFutureCallback) {
        if (richDocumentFetchParams != null && disposableFutureCallback != null) {
            GraphQLRequest graphQLRequest = (GraphQLRequest) richDocumentFetchParams.a();
            if (this.f23871b.m2189a(685, false)) {
                RequestCallbackHolder a = m32260a(graphQLRequest);
                long j = graphQLRequest.f7086d;
                if (a == null || j < a.d) {
                    Object a2 = graphQLRequest.m11601a(this.f23870a);
                    if (a == null) {
                        Object requestCallbackHolder = new RequestCallbackHolder(this, a2, graphQLRequest.f7086d, disposableFutureCallback);
                        this.f23872c.mo114a(a2, requestCallbackHolder);
                        super.mo3508a(richDocumentFetchParams, requestCallbackHolder);
                        return;
                    }
                    super.mo3508a(richDocumentFetchParams, disposableFutureCallback);
                    return;
                }
                graphQLRequest.m11594a(GraphQLCachePolicy.f7110b);
                MergingCallbackDelegate mergingCallbackDelegate = new MergingCallbackDelegate(this, disposableFutureCallback);
                a.a(mergingCallbackDelegate);
                super.mo3508a(new DiskOnlyDelegatingFetchParams(this, richDocumentFetchParams), mergingCallbackDelegate);
                return;
            }
            super.mo3508a(richDocumentFetchParams, disposableFutureCallback);
        }
    }

    private synchronized RequestCallbackHolder m32260a(GraphQLRequest<T> graphQLRequest) {
        return (RequestCallbackHolder) this.f23872c.mo110a(graphQLRequest.m11601a(this.f23870a));
    }

    public static synchronized void m32261a(BaseRequestMergingFetcher baseRequestMergingFetcher, String str) {
        synchronized (baseRequestMergingFetcher) {
            baseRequestMergingFetcher.f23872c.mo116b(str);
        }
    }
}
