package com.facebook.redspace.fetcher;

import android.support.annotation.Nullable;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.graphql.executor.RequestObserver;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.Executor;

/* compiled from: USE_EXISTING_MUTE_STATE */
public class RedSpaceBatchFetcher {
    @Inject
    public GraphQLQueryExecutor f21305a;
    @Inject
    @ForUiThread
    public Executor f21306b;
    public GraphQLBatchRequest f21307c;

    public static RedSpaceBatchFetcher m24922b(InjectorLike injectorLike) {
        RedSpaceBatchFetcher redSpaceBatchFetcher = new RedSpaceBatchFetcher();
        Executor executor = (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike);
        redSpaceBatchFetcher.f21305a = GraphQLQueryExecutor.a(injectorLike);
        redSpaceBatchFetcher.f21306b = executor;
        return redSpaceBatchFetcher;
    }

    public final <T> void m24924a(final GraphQLBatchRequest graphQLBatchRequest, RequestObservable<T> requestObservable, @Nullable final FutureCallback<T> futureCallback) {
        this.f21307c = graphQLBatchRequest;
        requestObservable.a(this.f21306b).a(new RequestObserver<T>(this) {
            final /* synthetic */ RedSpaceBatchFetcher f21304c;

            public final void m24919a() {
            }

            public final void m24921a(Throwable th) {
                if (this.f21304c.f21307c == graphQLBatchRequest) {
                    this.f21304c.f21307c = null;
                    if (futureCallback != null) {
                        futureCallback.onFailure(th);
                    }
                }
            }

            public final void m24920a(T t) {
                if (this.f21304c.f21307c == graphQLBatchRequest) {
                    this.f21304c.f21307c = null;
                    if (futureCallback != null) {
                        futureCallback.onSuccess(t);
                    }
                }
            }
        });
        this.f21305a.a(graphQLBatchRequest);
    }

    public final void m24923a() {
        this.f21307c = null;
    }

    public final boolean m24925b() {
        return this.f21307c != null;
    }
}
