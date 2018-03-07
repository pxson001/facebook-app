package com.facebook.graphql.executor;

import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: is_ego_show_single_page_item */
public class GraphQLSubscription<T> {
    protected final FutureCallback<GraphQLResult<T>> f19199a;
    protected final Executor f19200b;
    public ImmutableSet<String> f19201c = RegularImmutableSet.f688a;
    protected final String f19202d;
    protected WeakReference<T> f19203e = null;
    @Nullable
    private final GraphQLQueryExecutor f19204f;
    @Nullable
    public final GraphQLRequest<T> f19205g;
    @Nullable
    public final KeyFactory f19206h;
    private final int f19207i;
    public boolean f19208j = false;
    private boolean f19209k = false;

    /* compiled from: is_ego_show_single_page_item */
    class Preset<T> extends GraphQLSubscription<T> {
        private GraphQLResult<T> f19198f;

        Preset(FutureCallback<GraphQLResult<T>> futureCallback, Executor executor, String str, GraphQLResult<T> graphQLResult) {
            super(null, futureCallback, executor, str, null, null);
            Preconditions.checkNotNull(graphQLResult.f6199a);
            this.f19198f = graphQLResult;
            this.f19201c = ImmutableSet.copyOf(graphQLResult.m10402f());
            Object obj = graphQLResult.f6203e;
            if (obj != null) {
                this.e = new WeakReference(obj);
            }
        }

        protected final void mo3088b() {
            if (this.f19198f != null) {
                this.f19198f = this.f19198f.f6199a.m20452b(this.f19198f);
            }
        }

        protected final ListenableFuture<GraphQLResult<T>> mo3089c() {
            Object obj = null;
            if (this.f19198f == null) {
                return Futures.m2452a(null);
            }
            mo3088b();
            if (this.f19198f != null) {
                obj = this.f19198f.m10403i();
            }
            return Futures.m2452a(obj);
        }
    }

    GraphQLSubscription(@Nullable GraphQLQueryExecutor graphQLQueryExecutor, FutureCallback<GraphQLResult<T>> futureCallback, Executor executor, String str, @Nullable GraphQLRequest<T> graphQLRequest, @Nullable KeyFactory keyFactory) {
        int i;
        GraphQLRequest graphQLRequest2;
        boolean z = false;
        if ((keyFactory == null && graphQLRequest == null) || !(keyFactory == null || graphQLRequest == null)) {
            z = true;
        }
        Preconditions.checkState(z);
        if (graphQLRequest != null) {
            i = graphQLRequest.f7103v;
        } else {
            i = -1;
        }
        this.f19207i = i;
        this.f19199a = futureCallback;
        this.f19204f = graphQLQueryExecutor;
        this.f19200b = executor;
        this.f19202d = str;
        if (graphQLRequest == null) {
            graphQLRequest2 = null;
        } else {
            graphQLRequest2 = new GraphQLRequest(graphQLRequest).m11594a(GraphQLCachePolicy.f7110b).m11590a((graphQLRequest.f7086d / 1000) + 604800);
            graphQLRequest2.f7084b = true;
            graphQLRequest2 = graphQLRequest2;
            graphQLRequest2.f7095m = true;
            graphQLRequest2 = graphQLRequest2;
            graphQLRequest2.f7093k = this;
            graphQLRequest2 = graphQLRequest2;
        }
        this.f19205g = graphQLRequest2;
        this.f19206h = keyFactory;
    }

    protected void mo3088b() {
    }

    protected ListenableFuture<GraphQLResult<T>> mo3089c() {
        return this.f19204f.m10446a(this.f19205g);
    }

    public final void m26912a(int i) {
        if (this.f19207i == -1 || i != this.f19207i) {
            m26910f();
        }
    }

    private void m26910f() {
        Object obj = 1;
        synchronized (this) {
            if (this.f19208j) {
                this.f19209k = true;
            } else {
                obj = null;
            }
        }
        if (obj != null) {
            mo3088b();
            return;
        }
        try {
            Futures.m2458a(mo3089c(), new 1(this), this.f19200b);
        } catch (Throwable e) {
            BLog.a(getClass(), "Exception pushing result", e);
        }
    }

    public final void m26915d() {
        synchronized (this) {
            this.f19208j = false;
            boolean z = this.f19209k;
        }
        if (z) {
            m26910f();
        }
    }

    public final synchronized void m26916e() {
        this.f19208j = true;
    }

    public final GraphQLSubscription<T> m26911a(GraphQLResult<T> graphQLResult) {
        this.f19201c = ImmutableSet.copyOf(graphQLResult.m10402f());
        synchronized (this) {
            this.f19208j = false;
            this.f19209k = false;
        }
        return this;
    }
}
