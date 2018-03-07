package com.facebook.photos.mediafetcher;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Assisted;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcher;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcher.Status;
import com.facebook.photos.mediafetcher.interfaces.QueryParam;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaPageInfoModel;
import com.facebook.photos.mediafetcher.query.PaginatedMediaQuery;
import com.google.common.base.Absent;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: last_active_state_pref */
public class PaginatedGraphQLFetcher<GRAPHQL_RESULT_TYPE, PAGE_RESULT_TYPE> extends MediaFetcher<PaginatedMediaQuery, PAGE_RESULT_TYPE> {
    public static final String f10546a = PaginatedGraphQLFetcher.class.getSimpleName();
    private final PaginatedMediaQuery<GRAPHQL_RESULT_TYPE, ? extends QueryParam, PAGE_RESULT_TYPE> f10547b;
    private final DefaultAndroidThreadUtil f10548c;
    private final ExecutorService f10549d;
    private final GraphQLSubscriptionHolder f10550e;
    public final List<PageResult<PAGE_RESULT_TYPE>> f10551f = Lists.a();
    private NewPageFetchingCallback f10552g;
    @Nullable
    private ListenableFuture<GraphQLResult<GRAPHQL_RESULT_TYPE>> f10553h;
    private Optional<String> f10554i = Absent.INSTANCE;

    /* compiled from: last_active_state_pref */
    class DataUpdateCallback extends AbstractDisposableFutureCallback<GraphQLResult<GRAPHQL_RESULT_TYPE>> {
        final /* synthetic */ PaginatedGraphQLFetcher f10535a;
        private final int f10536b;

        protected final void m12396a(Object obj) {
            PaginatedGraphQLFetcher.m12408a(this.f10535a, this.f10536b, (GraphQLResult) obj);
        }

        DataUpdateCallback(PaginatedGraphQLFetcher paginatedGraphQLFetcher, int i) {
            this.f10535a = paginatedGraphQLFetcher;
            this.f10536b = i;
        }

        protected final void m12397a(Throwable th) {
        }
    }

    /* compiled from: last_active_state_pref */
    class NewPageFetchingCallback extends AbstractDisposableFutureCallback<GraphQLResult<GRAPHQL_RESULT_TYPE>> {
        final /* synthetic */ PaginatedGraphQLFetcher f10537a;
        private final int f10538b;

        protected final void m12398a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            PaginatedGraphQLFetcher.m12410h(this.f10537a);
            this.f10537a.m12403a(Status.DONE);
            PaginatedGraphQLFetcher.m12408a(this.f10537a, this.f10538b, graphQLResult);
        }

        NewPageFetchingCallback(PaginatedGraphQLFetcher paginatedGraphQLFetcher, int i) {
            this.f10537a = paginatedGraphQLFetcher;
            this.f10538b = i;
        }

        protected final void m12399a(Throwable th) {
            PaginatedGraphQLFetcher.m12410h(this.f10537a);
            BLog.b(PaginatedGraphQLFetcher.f10546a, "Fetch failed", th);
            this.f10537a.m12403a(Status.ERROR);
        }
    }

    @Inject
    public PaginatedGraphQLFetcher(@Assisted PaginatedMediaQuery paginatedMediaQuery, DefaultAndroidThreadUtil defaultAndroidThreadUtil, ExecutorService executorService, GraphQLSubscriptionHolder graphQLSubscriptionHolder, AbstractFbErrorReporter abstractFbErrorReporter) {
        super(paginatedMediaQuery, defaultAndroidThreadUtil, abstractFbErrorReporter);
        this.f10547b = paginatedMediaQuery;
        this.f10548c = defaultAndroidThreadUtil;
        this.f10549d = executorService;
        this.f10550e = graphQLSubscriptionHolder;
    }

    public final void mo597a(int i, Optional<String> optional) {
        boolean z;
        boolean z2 = false;
        this.f10548c.a();
        if (this.f10543e != Status.CLOSED) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Can not fetchMore() on closed media fetcher");
        Preconditions.checkState(mo599d(), "Requesting more media than we can provide");
        if (this.f10543e == Status.LOADING) {
            BLog.a(f10546a, "fetchMore() called while loading");
            return;
        }
        Preconditions.checkState(this.f10553h == null);
        if (this.f10552g == null) {
            z2 = true;
        }
        Preconditions.checkState(z2);
        m12403a(Status.LOADING);
        this.f10554i = optional;
        MediaPageInfoModel f = m12409f();
        GraphQLRequest a = this.f10547b.mo600a(i, f == null ? null : f.m12611a()).a(GraphQLCachePolicy.a);
        a.b = true;
        a = a.a(RequestPriority.INTERACTIVE).a(180);
        int size = this.f10551f.size();
        this.f10553h = this.f10550e.a(a, new DataUpdateCallback(this, size), this.f10547b.getClass().getSimpleName() + "_" + size);
        this.f10552g = new NewPageFetchingCallback(this, size);
        Futures.a(this.f10553h, this.f10552g, this.f10549d);
    }

    public final boolean mo599d() {
        if (this.f10543e == Status.CLOSED) {
            return false;
        }
        MediaPageInfoModel f = m12409f();
        if (f == null || f.m12613b()) {
            return true;
        }
        return false;
    }

    @Nullable
    private MediaPageInfoModel m12409f() {
        if (this.f10551f.isEmpty()) {
            return null;
        }
        return ((PageResult) Iterators.f(this.f10551f.listIterator())).f10534b;
    }

    public final void mo598c() {
        super.mo598c();
        m12410h(this);
        this.f10550e.a();
    }

    public static void m12410h(PaginatedGraphQLFetcher paginatedGraphQLFetcher) {
        if (paginatedGraphQLFetcher.f10553h != null) {
            paginatedGraphQLFetcher.f10553h.cancel(false);
            paginatedGraphQLFetcher.f10553h = null;
        }
        if (paginatedGraphQLFetcher.f10552g != null) {
            paginatedGraphQLFetcher.f10552g.jc_();
            paginatedGraphQLFetcher.f10552g = null;
        }
    }

    public static void m12408a(PaginatedGraphQLFetcher paginatedGraphQLFetcher, int i, GraphQLResult graphQLResult) {
        paginatedGraphQLFetcher.f10548c.a();
        if (i < paginatedGraphQLFetcher.f10551f.size()) {
            paginatedGraphQLFetcher.f10551f.remove(i);
        }
        paginatedGraphQLFetcher.f10551f.add(i, paginatedGraphQLFetcher.f10547b.mo601a(graphQLResult));
        Collection b = Lists.b();
        for (PageResult pageResult : paginatedGraphQLFetcher.f10551f) {
            b.addAll(pageResult.f10533a);
        }
        ImmutableList copyOf = ImmutableList.copyOf(b);
        if (paginatedGraphQLFetcher.f10554i.isPresent() && paginatedGraphQLFetcher.mo599d()) {
            int size = copyOf.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (Objects.equal(((GraphQLPersistableNode) copyOf.get(i2)).a(), paginatedGraphQLFetcher.f10554i.get())) {
                    paginatedGraphQLFetcher.f10554i = Absent.INSTANCE;
                    paginatedGraphQLFetcher.m12404a(copyOf);
                    return;
                }
            }
            paginatedGraphQLFetcher.mo597a(Math.min(copyOf.size() * 2, 128), paginatedGraphQLFetcher.f10554i);
            return;
        }
        paginatedGraphQLFetcher.m12404a(copyOf);
    }
}
