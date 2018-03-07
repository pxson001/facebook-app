package com.facebook.graphql.executor;

import com.facebook.http.interfaces.RequestFuture;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: messenger_fetching_delta_stickerpack_metadata */
public class GraphQLQueryFuture<T> implements RequestFuture<T> {
    public final ListenableFuture<T> f13998a;
    @Nullable
    public final GraphQLRequest f13999b;

    public GraphQLQueryFuture(ListenableFuture<T> listenableFuture, GraphQLRequest graphQLRequest) {
        this.f13998a = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.f13999b = (GraphQLRequest) Preconditions.checkNotNull(graphQLRequest);
    }

    public final void mo2693a(RequestPriority requestPriority) {
        if (this.f13999b != null) {
            this.f13999b.m11609g().m11636a(requestPriority, true);
        }
    }

    public final void mo223a(Runnable runnable, Executor executor) {
        this.f13998a.mo223a(runnable, executor);
    }

    public boolean cancel(boolean z) {
        return this.f13998a.cancel(z);
    }

    public boolean isCancelled() {
        return this.f13998a.isCancelled();
    }

    public boolean isDone() {
        return this.f13998a.isDone();
    }

    public T get() {
        return FutureDetour.a(this.f13998a, 1590502595);
    }

    public T get(long j, TimeUnit timeUnit) {
        return FutureDetour.a(this.f13998a, j, timeUnit, 950571750);
    }
}
