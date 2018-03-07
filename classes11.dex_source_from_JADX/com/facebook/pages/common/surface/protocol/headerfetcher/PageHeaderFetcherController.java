package com.facebook.pages.common.surface.protocol.headerfetcher;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureUtils;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.facebook.ipc.pages.PageProfileType;
import com.facebook.ipc.pages.PageViewReferrer;
import com.facebook.pages.common.constants.PagesAsyncTaskType;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.sequencelogger.PageHeaderSequenceLoggerHelper;
import com.facebook.pages.common.sequencelogger.PagesManagerStartupSequencesHelper;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: review_steps */
public class PageHeaderFetcherController {
    public final QuickPerformanceLogger f2515a;
    public final PagesManagerStartupSequencesHelper f2516b;
    public final PageHeaderSequenceLoggerHelper f2517c;
    private final PagesAnalytics f2518d;
    public final TasksManager f2519e;
    private final PageHeaderFetchQueryExecutor f2520f;
    private final PageHeaderEarlyFetcher f2521g;
    public PageHeaderDataListener f2522h;
    public String f2523i;
    private long f2524j;
    private PageViewReferrer f2525k;
    private boolean f2526l = false;
    private boolean f2527m = false;
    private boolean f2528n = false;
    private PageHeaderEarlyFetchIdentifier f2529o;
    public ListenableFuture<GraphQLResult<FetchPageHeaderQueryModel>> f2530p;
    public ListenableFuture<GraphQLResult<FetchPageHeaderQueryModel>> f2531q;
    @Nullable
    public String f2532r;
    @Nullable
    public String f2533s;
    public NetworkFutureExpectedState f2534t = NetworkFutureExpectedState.INSTEAD_OF_CACHE_HIT;

    /* compiled from: review_steps */
    public interface PageHeaderDataListener {
        void mo53a(GraphQLResult<FetchPageHeaderQueryModel> graphQLResult, PageDataFetchType pageDataFetchType);

        void mo54a(Throwable th);
    }

    /* compiled from: review_steps */
    public class C03301 implements Callable<ListenableFuture<GraphQLResult<FetchPageHeaderQueryModel>>> {
        final /* synthetic */ PageHeaderFetcherController f2508a;

        public C03301(PageHeaderFetcherController pageHeaderFetcherController) {
            this.f2508a = pageHeaderFetcherController;
        }

        public Object call() {
            return this.f2508a.f2530p;
        }
    }

    /* compiled from: review_steps */
    public class C03312 extends AbstractDisposableFutureCallback<GraphQLResult<FetchPageHeaderQueryModel>> {
        final /* synthetic */ PageHeaderFetcherController f2509a;

        public C03312(PageHeaderFetcherController pageHeaderFetcherController) {
            this.f2509a = pageHeaderFetcherController;
        }

        protected final void m3453a(Object obj) {
            PageHeaderFetcherController.m3460a(this.f2509a, (GraphQLResult) obj);
        }

        protected final void m3454a(Throwable th) {
            this.f2509a.f2530p = null;
            if (this.f2509a.f2531q == null) {
                this.f2509a.f2522h.mo54a(th);
            }
        }
    }

    /* compiled from: review_steps */
    class C03323 implements Callable<ListenableFuture<GraphQLResult<FetchPageHeaderQueryModel>>> {
        final /* synthetic */ PageHeaderFetcherController f2510a;

        C03323(PageHeaderFetcherController pageHeaderFetcherController) {
            this.f2510a = pageHeaderFetcherController;
        }

        public Object call() {
            return this.f2510a.f2531q;
        }
    }

    /* compiled from: review_steps */
    enum NetworkFutureExpectedState {
        AFTER_CACHE_HIT,
        INSTEAD_OF_CACHE_HIT,
        FORCED_BY_USER
    }

    /* compiled from: review_steps */
    public enum PageDataFetchType {
        DEFAULT,
        FORCED_BY_USER,
        FORCED_SERVER_AFTER_CACHE_HIT
    }

    public static void m3458a(PageHeaderFetcherController pageHeaderFetcherController, GraphQLResult graphQLResult, boolean z) {
        PageDataFetchType pageDataFetchType;
        pageHeaderFetcherController.m3457a(graphQLResult.freshness);
        pageHeaderFetcherController.f2531q = null;
        if (pageHeaderFetcherController.f2530p != null) {
            pageHeaderFetcherController.f2518d.b(pageHeaderFetcherController.f2524j, pageHeaderFetcherController.f2525k);
        }
        pageHeaderFetcherController.f2530p = null;
        pageHeaderFetcherController.f2519e.c(PagesAsyncTaskType.FETCH_PAGES_HEADER);
        if (z) {
            pageHeaderFetcherController.f2518d.a(pageHeaderFetcherController.f2524j, PageProfileType.HEADER, pageHeaderFetcherController.f2525k);
        }
        PageHeaderDataListener pageHeaderDataListener = pageHeaderFetcherController.f2522h;
        switch (pageHeaderFetcherController.f2534t) {
            case INSTEAD_OF_CACHE_HIT:
                pageDataFetchType = PageDataFetchType.DEFAULT;
                break;
            case AFTER_CACHE_HIT:
                pageDataFetchType = PageDataFetchType.FORCED_SERVER_AFTER_CACHE_HIT;
                break;
            case FORCED_BY_USER:
                pageDataFetchType = PageDataFetchType.FORCED_BY_USER;
                break;
            default:
                pageDataFetchType = null;
                break;
        }
        pageHeaderDataListener.mo53a(graphQLResult, pageDataFetchType);
    }

    @Inject
    public PageHeaderFetcherController(QuickPerformanceLogger quickPerformanceLogger, PagesManagerStartupSequencesHelper pagesManagerStartupSequencesHelper, PageHeaderSequenceLoggerHelper pageHeaderSequenceLoggerHelper, PagesAnalytics pagesAnalytics, TasksManager tasksManager, PageHeaderFetchQueryExecutor pageHeaderFetchQueryExecutor, PageHeaderEarlyFetcher pageHeaderEarlyFetcher, @Assisted PageHeaderDataListener pageHeaderDataListener, @Assisted Long l, @Assisted PageViewReferrer pageViewReferrer, @Assisted String str) {
        this.f2515a = quickPerformanceLogger;
        this.f2516b = pagesManagerStartupSequencesHelper;
        this.f2517c = pageHeaderSequenceLoggerHelper;
        this.f2518d = pagesAnalytics;
        this.f2519e = tasksManager;
        this.f2520f = pageHeaderFetchQueryExecutor;
        this.f2521g = pageHeaderEarlyFetcher;
        this.f2522h = pageHeaderDataListener;
        this.f2524j = l.longValue();
        this.f2525k = pageViewReferrer;
        this.f2523i = str;
        this.f2529o = new PageHeaderEarlyFetchIdentifier(this.f2524j);
    }

    public final void m3464a() {
        this.f2519e.c();
    }

    public final void m3465a(PageDataFetchType pageDataFetchType) {
        switch (pageDataFetchType) {
            case DEFAULT:
                m3462f();
                return;
            case FORCED_BY_USER:
                m3461e();
                return;
            default:
                return;
        }
    }

    public final void m3466b() {
        boolean z;
        if (!(this.f2531q == null || this.f2531q.isCancelled() || !this.f2531q.isDone())) {
            GraphQLResult graphQLResult = (GraphQLResult) FutureUtils.a(this.f2531q);
            if (graphQLResult != null) {
                m3458a(this, graphQLResult, true);
                return;
            }
        }
        if (this.f2530p != null && this.f2530p.isDone() && m3460a(this, (GraphQLResult) FutureUtils.a(this.f2530p))) {
            z = false;
        } else {
            z = true;
        }
        if (this.f2531q != null && this.f2531q.isCancelled()) {
            this.f2531q = this.f2520f.m3451a(Long.valueOf(this.f2524j), GraphQLCachePolicy.d);
        }
        if (this.f2530p != null && this.f2530p.isCancelled()) {
            this.f2530p = this.f2520f.m3451a(Long.valueOf(this.f2524j), GraphQLCachePolicy.b);
        }
        if (this.f2531q != null) {
            m3459a(z);
        }
        if (this.f2530p != null) {
            this.f2519e.a(PagesAsyncTaskType.FETCH_PAGES_HEADER, new C03301(this), new C03312(this));
        }
    }

    private void m3461e() {
        if (this.f2531q == null) {
            this.f2534t = NetworkFutureExpectedState.FORCED_BY_USER;
            this.f2531q = this.f2520f.m3451a(Long.valueOf(this.f2524j), GraphQLCachePolicy.d);
            this.f2526l = false;
            if (this.f2531q != null) {
                m3459a(true);
            }
        }
    }

    private void m3462f() {
        boolean z = true;
        this.f2516b.a("FetchPageHeaderDataFromServer");
        this.f2516b.a("FetchPageHeaderDataFromCache");
        this.f2517c.a("FetchPageHeaderDataFromServer", this.f2523i, null);
        this.f2517c.a("FetchPageHeaderDataFromCache", this.f2523i, null);
        this.f2515a.b(1245306);
        this.f2518d.a(this.f2524j, this.f2525k);
        PageHeaderEarlyFetchFuturesHolder pageHeaderEarlyFetchFuturesHolder = (PageHeaderEarlyFetchFuturesHolder) this.f2521g.b(this.f2529o);
        if (pageHeaderEarlyFetchFuturesHolder == null || pageHeaderEarlyFetchFuturesHolder.f2476a == null || pageHeaderEarlyFetchFuturesHolder.f2476a.isCancelled()) {
            this.f2530p = this.f2520f.m3451a(Long.valueOf(this.f2524j), GraphQLCachePolicy.b);
        } else {
            this.f2530p = pageHeaderEarlyFetchFuturesHolder.f2476a;
        }
        if (pageHeaderEarlyFetchFuturesHolder == null || pageHeaderEarlyFetchFuturesHolder.f2477b == null || pageHeaderEarlyFetchFuturesHolder.f2477b.isCancelled()) {
            this.f2531q = this.f2520f.m3451a(Long.valueOf(this.f2524j), GraphQLCachePolicy.d);
            this.f2526l = false;
        } else {
            this.f2531q = pageHeaderEarlyFetchFuturesHolder.f2477b;
            this.f2526l = true;
        }
        if (pageHeaderEarlyFetchFuturesHolder != null) {
            boolean z2;
            this.f2532r = pageHeaderEarlyFetchFuturesHolder.f2479d;
            if (this.f2532r != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f2528n = z2;
            this.f2533s = pageHeaderEarlyFetchFuturesHolder.f2478c;
            if (this.f2533s == null) {
                z = false;
            }
            this.f2527m = z;
        }
        m3463g();
    }

    private void m3463g() {
        this.f2517c.d("TimeToHeaderFuture", this.f2523i, ImmutableMap.of("HeaderFromEarlyFetcher", this.f2526l ? "1" : "0", "SurfaceFirstCardFromEarlyFetcher", this.f2527m ? "1" : "0", "SurfaceFirstCardCachedWithEarlyFetcher", this.f2528n ? "1" : "0"));
    }

    public static boolean m3460a(PageHeaderFetcherController pageHeaderFetcherController, GraphQLResult graphQLResult) {
        pageHeaderFetcherController.f2530p = null;
        if (graphQLResult == null || graphQLResult.freshness == DataFreshnessResult.NO_DATA) {
            return false;
        }
        pageHeaderFetcherController.m3457a(graphQLResult.freshness);
        pageHeaderFetcherController.f2534t = NetworkFutureExpectedState.AFTER_CACHE_HIT;
        pageHeaderFetcherController.f2518d.a(pageHeaderFetcherController.f2524j, PageProfileType.HEADER, pageHeaderFetcherController.f2525k);
        pageHeaderFetcherController.f2522h.mo53a(graphQLResult, PageDataFetchType.DEFAULT);
        return true;
    }

    private void m3459a(final boolean z) {
        this.f2519e.a(PagesAsyncTaskType.FETCH_PAGES_HEADER_NOCACHE, new C03323(this), new AbstractDisposableFutureCallback<GraphQLResult<FetchPageHeaderQueryModel>>(this) {
            final /* synthetic */ PageHeaderFetcherController f2512b;

            protected final void m3455a(Object obj) {
                PageHeaderFetcherController.m3458a(this.f2512b, (GraphQLResult) obj, z);
            }

            protected final void m3456a(Throwable th) {
                this.f2512b.f2531q = null;
                this.f2512b.f2530p = null;
                this.f2512b.f2522h.mo54a(th);
            }
        });
    }

    private void m3457a(DataFreshnessResult dataFreshnessResult) {
        if (this.f2517c.c("FetchPageHeaderDataFromServer", this.f2523i)) {
            Object obj;
            Object obj2;
            String str = "HeaderFromEarlyFetcher";
            Object obj3 = this.f2526l ? "1" : "0";
            String str2 = "SurfaceFirstCardFromEarlyFetcher";
            if (this.f2527m) {
                obj = "1";
            } else {
                obj = "0";
            }
            String str3 = "SurfaceFirstCardCachedWithEarlyFetcher";
            if (this.f2528n) {
                obj2 = "1";
            } else {
                obj2 = "0";
            }
            ImmutableMap of = ImmutableMap.of(str, obj3, str2, obj, str3, obj2);
            if (dataFreshnessResult.equals(DataFreshnessResult.FROM_SERVER)) {
                this.f2515a.a(1245306, "from_network");
                this.f2515a.a(1245312, (short) 24);
                this.f2517c.c("FetchPageHeaderDataFromServer", this.f2523i, of);
                this.f2517c.c("TimeToFetchPageHeaderDataFromServer", this.f2523i, null);
                this.f2517c.a("FetchPageHeaderDataFromCache", this.f2523i);
                this.f2517c.a("TimeToFetchPageHeaderDataFromCache", this.f2523i);
                this.f2516b.b("FetchPageHeaderDataFromServer");
                this.f2516b.e("FetchPageHeaderDataFromCache");
            } else {
                this.f2515a.a(1245306, "from_cache");
                this.f2515a.a(1245312, (short) 34);
                this.f2517c.a("FetchPageHeaderDataFromServer", this.f2523i);
                this.f2517c.a("TimeToFetchPageHeaderDataFromServer", this.f2523i);
                this.f2517c.c("FetchPageHeaderDataFromCache", this.f2523i, of);
                this.f2517c.c("TimeToFetchPageHeaderDataFromCache", this.f2523i, null);
                this.f2516b.e("FetchPageHeaderDataFromServer");
                this.f2516b.b("FetchPageHeaderDataFromCache");
            }
            if (this.f2526l) {
                this.f2517c.e(this.f2523i, "HeaderFromEarlyFetcher", null);
                this.f2515a.a(1245306, "early_fetch");
            }
            if (this.f2527m) {
                this.f2517c.e(this.f2523i, "SurfaceFirstCardFromEarlyFetcher", null);
                this.f2515a.a(1245306, "surface_first_card_early_fetch");
            }
            if (this.f2528n) {
                this.f2517c.e(this.f2523i, "SurfaceFirstCardCachedWithEarlyFetcher", null);
                this.f2515a.a(1245306, "surface_first_card_cached_early_fetch");
            }
            this.f2515a.b(1245306, (short) 2);
        }
    }
}
