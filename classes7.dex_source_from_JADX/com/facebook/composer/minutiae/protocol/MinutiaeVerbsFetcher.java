package com.facebook.composer.minutiae.protocol;

import android.support.v4.util.Pair;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.Executor_SameThreadExecutorMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.composer.minutiae.MinutiaeTaggableVerbFragment;
import com.facebook.composer.minutiae.MinutiaeTaggableVerbFragment.C01402;
import com.facebook.composer.minutiae.abtest.ExperimentsForMinutiaeAbTestModule;
import com.facebook.composer.minutiae.analytics.ActivityPickerAnalyticsLogger;
import com.facebook.composer.minutiae.db.MinutiaeDBCacheKeyGenerator;
import com.facebook.composer.minutiae.db.MinutiaeDiskStorage;
import com.facebook.composer.minutiae.graphql.FetchTaggableActivitiesGraphQL.FetchRankedVerbsQueryString;
import com.facebook.composer.minutiae.perf.MinutiaePerformanceLogger;
import com.facebook.composer.minutiae.perf.MinutiaeVerbPickerPerformanceLogger;
import com.facebook.composer.minutiae.prefs.MinutiaePrefKeys;
import com.facebook.composer.minutiae.protocol.FetchMinutiaeVerbsRankedGraphQLRequest.C01551;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ErrorCodeUtil;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.error.GenericErrorView;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: time_bucket */
public class MinutiaeVerbsFetcher {
    private static final String f1714b = "32";
    private static final Object f1715u = new Object();
    @VisibleForTesting
    protected boolean f1716a = false;
    public final FetchMinutiaeVerbsUnrankedGraphQLRequest f1717c;
    public final FetchMinutiaeVerbsRankedGraphQLRequest f1718d;
    public final MinutiaeDiskStorage f1719e;
    public final Executor f1720f;
    public final ListeningExecutorService f1721g;
    public final MinutiaeDBCacheKeyGenerator f1722h;
    public final MinutiaeTaggableObjectsPreloader f1723i;
    private final MinutiaeActiveUserStore f1724j;
    public TasksManager<Task> f1725k;
    public MinutiaeTaggableVerbFragment f1726l;
    public MinutiaeVerbPickerPerformanceLogger f1727m;
    public final QeAccessor f1728n;
    public final AnalyticsLogger f1729o;
    public String f1730p;
    public boolean f1731q;
    public int f1732r;
    @Nullable
    public VerbResult f1733s;
    public boolean f1734t = this.f1728n.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForMinutiaeAbTestModule.f1455a, false);

    /* compiled from: time_bucket */
    class C01631 implements Callable<ListenableFuture<VerbResult>> {
        final /* synthetic */ MinutiaeVerbsFetcher f1705a;

        C01631(MinutiaeVerbsFetcher minutiaeVerbsFetcher) {
            this.f1705a = minutiaeVerbsFetcher;
        }

        public Object call() {
            return this.f1705a.m1708d();
        }
    }

    /* compiled from: time_bucket */
    class C01642 implements Callable<ListenableFuture<VerbResult>> {
        final /* synthetic */ MinutiaeVerbsFetcher f1706a;

        C01642(MinutiaeVerbsFetcher minutiaeVerbsFetcher) {
            this.f1706a = minutiaeVerbsFetcher;
        }

        public Object call() {
            MinutiaeVerbsFetcher minutiaeVerbsFetcher = this.f1706a;
            return minutiaeVerbsFetcher.f1721g.a(new C01664(minutiaeVerbsFetcher));
        }
    }

    /* compiled from: time_bucket */
    class C01653 extends AbstractDisposableFutureCallback<VerbResult> {
        final /* synthetic */ MinutiaeVerbsFetcher f1707a;

        C01653(MinutiaeVerbsFetcher minutiaeVerbsFetcher) {
            this.f1707a = minutiaeVerbsFetcher;
        }

        protected final void m1697a(Object obj) {
            VerbResult verbResult = (VerbResult) obj;
            this.f1707a.f1733s = verbResult;
            if (this.f1707a.f1731q) {
                int h = MinutiaeVerbsFetcher.m1702h(this.f1707a);
                if (h > 0) {
                    MinutiaeTaggableObjectsPreloader minutiaeTaggableObjectsPreloader = this.f1707a.f1723i;
                    ImmutableList immutableList = this.f1707a.f1733s.f1712a;
                    String str = this.f1707a.f1730p;
                    if (minutiaeTaggableObjectsPreloader.f1700c.size() < h) {
                        List<MinutiaeVerbModelEdge> a = MinutiaeTaggableObjectsPreloader.f1696d.a(immutableList, h);
                        List<FetchMinutiaeTaggableObjectsParams> arrayList = new ArrayList();
                        for (MinutiaeVerbModelEdge minutiaeVerbModelEdge : a) {
                            arrayList.add(FetchMinutiaeTaggableObjectsParamsUtil.m1667a(minutiaeVerbModelEdge.f1703a, 0, str, true, null));
                        }
                        for (FetchMinutiaeTaggableObjectsParams fetchMinutiaeTaggableObjectsParams : arrayList) {
                            minutiaeTaggableObjectsPreloader.f1700c.add(Pair.a(fetchMinutiaeTaggableObjectsParams, minutiaeTaggableObjectsPreloader.f1698a.m1690a(fetchMinutiaeTaggableObjectsParams)));
                        }
                    }
                }
            }
            MinutiaeVerbsFetcher minutiaeVerbsFetcher = this.f1707a;
            HoneyClientEventFast a2;
            if (verbResult.f1713b == DataFreshnessResult.FROM_SERVER) {
                a2 = minutiaeVerbsFetcher.f1729o.a("minutiae_verbs_fetcher_cache_miss", false);
                if (a2.a()) {
                    a2.b();
                }
            } else {
                a2 = minutiaeVerbsFetcher.f1729o.a("minutiae_verbs_fetcher_cache_hit", false);
                if (a2.a()) {
                    a2.b();
                }
            }
            if (this.f1707a.f1726l != null) {
                this.f1707a.f1726l.m1528a(verbResult.f1712a, verbResult.f1713b);
            }
        }

        protected final void m1698a(Throwable th) {
            MinutiaePerformanceLogger minutiaePerformanceLogger = this.f1707a.f1727m;
            minutiaePerformanceLogger.m1652a(4390915, "minutiae_verb_picker_time_to_fetch_end");
            minutiaePerformanceLogger.m1652a(4390923, "minutiae_verb_picker_time_to_verbs_shown");
            minutiaePerformanceLogger.m1652a(4390916, "minutiae_verb_picker_fetch_time");
            minutiaePerformanceLogger.m1652a(4390918, "minutiae_verb_picker_tti");
            if (this.f1707a.f1726l != null) {
                MinutiaeTaggableVerbFragment minutiaeTaggableVerbFragment = this.f1707a.f1726l;
                ActivityPickerAnalyticsLogger activityPickerAnalyticsLogger = minutiaeTaggableVerbFragment.f1443h;
                activityPickerAnalyticsLogger.f1460a.a(ActivityPickerAnalyticsLogger.m1540f("activity_picker_load_failed", minutiaeTaggableVerbFragment.ax.f1835a).a);
                minutiaeTaggableVerbFragment.f1438c.a("minutiae_taggable_activity_fetch_fail", th);
                minutiaeTaggableVerbFragment.ap.d();
                if (ErrorCodeUtil.a(th) == ErrorCode.CONNECTION_FAILURE) {
                    ((GenericErrorView) minutiaeTaggableVerbFragment.ap.a()).m19992a();
                } else {
                    ((GenericErrorView) minutiaeTaggableVerbFragment.ap.a()).m19993b();
                }
                ((GenericErrorView) minutiaeTaggableVerbFragment.ap.a()).setOnClickListener(new C01402(minutiaeTaggableVerbFragment));
            }
            if (this.f1707a.f1734t && !this.f1707a.f1716a) {
                this.f1707a.f1716a = true;
                MinutiaeVerbsFetcher.m1703i(this.f1707a);
            }
        }
    }

    /* compiled from: time_bucket */
    public class C01664 implements Callable<VerbResult> {
        final /* synthetic */ MinutiaeVerbsFetcher f1708a;

        public C01664(MinutiaeVerbsFetcher minutiaeVerbsFetcher) {
            this.f1708a = minutiaeVerbsFetcher;
        }

        public Object call() {
            if (this.f1708a.f1733s != null) {
                return this.f1708a.f1733s;
            }
            this.f1708a.f1732r = new Random().nextInt();
            FetchMinutiaeVerbsRankedGraphQLRequest fetchMinutiaeVerbsRankedGraphQLRequest = this.f1708a.f1718d;
            return (VerbResult) FutureDetour.a(Futures.a(fetchMinutiaeVerbsRankedGraphQLRequest.f1649a.a(GraphQLRequest.a(new FetchRankedVerbsQueryString()).a(MinutiaeVerbsFetcher.m1701b(this.f1708a, true)).a(GraphQLCachePolicy.c)), new C01551(fetchMinutiaeVerbsRankedGraphQLRequest), MoreExecutors.a()), 570217464);
        }
    }

    /* compiled from: time_bucket */
    class C01675 implements Callable<VerbResult> {
        final /* synthetic */ MinutiaeVerbsFetcher f1709a;

        C01675(MinutiaeVerbsFetcher minutiaeVerbsFetcher) {
            this.f1709a = minutiaeVerbsFetcher;
        }

        public Object call() {
            if (this.f1709a.f1733s != null) {
                return this.f1709a.f1733s;
            }
            this.f1709a.f1732r = 0;
            GraphQlQueryParamSet b = MinutiaeVerbsFetcher.m1701b(this.f1709a, false);
            String a = this.f1709a.f1722h.m1562a(b);
            Optional a2 = this.f1709a.f1719e.m1573a(a);
            if (a2.isPresent()) {
                return new VerbResult((ImmutableList) a2.get(), DataFreshnessResult.FROM_CACHE_UP_TO_DATE);
            }
            VerbResult verbResult = (VerbResult) FutureDetour.a(this.f1709a.f1717c.m1671a(b), 545330433);
            this.f1709a.f1719e.m1574a(verbResult.f1712a, a);
            return verbResult;
        }
    }

    /* compiled from: time_bucket */
    public class C01686 implements FutureCallback<VerbResult> {
        final /* synthetic */ AbstractDisposableFutureCallback f1710a;
        final /* synthetic */ MinutiaeVerbsFetcher f1711b;

        public C01686(MinutiaeVerbsFetcher minutiaeVerbsFetcher, AbstractDisposableFutureCallback abstractDisposableFutureCallback) {
            this.f1711b = minutiaeVerbsFetcher;
            this.f1710a = abstractDisposableFutureCallback;
        }

        public void onSuccess(Object obj) {
            this.f1711b.f1719e.m1574a(((VerbResult) obj).f1712a, this.f1711b.f1722h.m1562a(MinutiaeVerbsFetcher.m1701b(this.f1711b, false)));
            this.f1710a.onSuccess(null);
        }

        public void onFailure(Throwable th) {
            this.f1710a.onFailure(th);
        }
    }

    /* compiled from: time_bucket */
    public enum Task {
        ACTIVITIES
    }

    /* compiled from: time_bucket */
    public class VerbResult {
        public final ImmutableList<MinutiaeVerbModelEdge> f1712a;
        public final DataFreshnessResult f1713b;

        public VerbResult(ImmutableList<MinutiaeVerbModelEdge> immutableList, DataFreshnessResult dataFreshnessResult) {
            this.f1712a = immutableList;
            this.f1713b = dataFreshnessResult;
        }
    }

    private static MinutiaeVerbsFetcher m1700b(InjectorLike injectorLike) {
        return new MinutiaeVerbsFetcher(FetchMinutiaeVerbsUnrankedGraphQLRequest.m1670b(injectorLike), new FetchMinutiaeVerbsRankedGraphQLRequest(GraphQLQueryExecutor.a(injectorLike)), MinutiaeDiskStorage.m1565a(injectorLike), MinutiaeDBCacheKeyGenerator.m1561b(injectorLike), Executor_SameThreadExecutorMethodAutoProvider.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), MinutiaeTaggableObjectsPreloader.m1692a(injectorLike), MinutiaeActiveUserStore.m1672a(injectorLike), TasksManager.b(injectorLike), MinutiaeVerbPickerPerformanceLogger.m1663a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.composer.minutiae.protocol.MinutiaeVerbsFetcher m1699a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f1715u;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m1700b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f1715u;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.composer.minutiae.protocol.MinutiaeVerbsFetcher) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.composer.minutiae.protocol.MinutiaeVerbsFetcher) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f1715u;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.composer.minutiae.protocol.MinutiaeVerbsFetcher) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.minutiae.protocol.MinutiaeVerbsFetcher.a(com.facebook.inject.InjectorLike):com.facebook.composer.minutiae.protocol.MinutiaeVerbsFetcher");
    }

    @Inject
    public MinutiaeVerbsFetcher(FetchMinutiaeVerbsUnrankedGraphQLRequest fetchMinutiaeVerbsUnrankedGraphQLRequest, FetchMinutiaeVerbsRankedGraphQLRequest fetchMinutiaeVerbsRankedGraphQLRequest, MinutiaeDiskStorage minutiaeDiskStorage, MinutiaeDBCacheKeyGenerator minutiaeDBCacheKeyGenerator, Executor executor, AnalyticsLogger analyticsLogger, ListeningExecutorService listeningExecutorService, MinutiaeTaggableObjectsPreloader minutiaeTaggableObjectsPreloader, MinutiaeActiveUserStore minutiaeActiveUserStore, TasksManager tasksManager, MinutiaeVerbPickerPerformanceLogger minutiaeVerbPickerPerformanceLogger, QeAccessor qeAccessor) {
        this.f1717c = fetchMinutiaeVerbsUnrankedGraphQLRequest;
        this.f1718d = fetchMinutiaeVerbsRankedGraphQLRequest;
        this.f1719e = minutiaeDiskStorage;
        this.f1722h = minutiaeDBCacheKeyGenerator;
        this.f1720f = executor;
        this.f1721g = listeningExecutorService;
        this.f1723i = minutiaeTaggableObjectsPreloader;
        this.f1724j = minutiaeActiveUserStore;
        this.f1725k = tasksManager;
        this.f1727m = minutiaeVerbPickerPerformanceLogger;
        this.f1728n = qeAccessor;
        this.f1729o = analyticsLogger;
    }

    public static int m1702h(MinutiaeVerbsFetcher minutiaeVerbsFetcher) {
        MinutiaeActiveUserStore minutiaeActiveUserStore = minutiaeVerbsFetcher.f1724j;
        Object obj = null;
        Preconditions.checkArgument(9 >= null);
        long a = minutiaeActiveUserStore.f1669a.a(MinutiaePrefKeys.f1620h, 0);
        if (a > minutiaeActiveUserStore.f1670b.a()) {
            minutiaeActiveUserStore.f1669a.edit().a(MinutiaePrefKeys.f1620h);
        } else if (minutiaeActiveUserStore.f1670b.a() - (((long) 9) * 86400000) < a) {
            int i = 1;
        }
        if (obj != null) {
            return 4;
        }
        return 1;
    }

    public final void m1707a(String str) {
        if (this.f1730p != null || str != null) {
            if (this.f1730p == null || !this.f1730p.equals(str)) {
                this.f1730p = str;
                if (this.f1728n.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForMinutiaeAbTestModule.f1455a, false)) {
                    this.f1733s = null;
                    m1706a();
                }
            }
        }
    }

    public final void m1706a() {
        this.f1716a = false;
        if (this.f1734t) {
            m1704j();
        } else {
            m1703i(this);
        }
    }

    public static void m1703i(MinutiaeVerbsFetcher minutiaeVerbsFetcher) {
        if (minutiaeVerbsFetcher.f1734t && !minutiaeVerbsFetcher.f1716a && minutiaeVerbsFetcher.f1733s == null) {
            minutiaeVerbsFetcher.f1725k.a(Task.ACTIVITIES, minutiaeVerbsFetcher.m1708d(), minutiaeVerbsFetcher.m1705k());
            minutiaeVerbsFetcher.f1716a = true;
            return;
        }
        minutiaeVerbsFetcher.f1725k.a(Task.ACTIVITIES, new C01631(minutiaeVerbsFetcher), minutiaeVerbsFetcher.m1705k());
    }

    private void m1704j() {
        this.f1725k.a(Task.ACTIVITIES, new C01642(this), m1705k());
    }

    @VisibleForTesting
    private AbstractDisposableFutureCallback<VerbResult> m1705k() {
        return new C01653(this);
    }

    protected final ListenableFuture<VerbResult> m1708d() {
        return this.f1721g.a(new C01675(this));
    }

    public static GraphQlQueryParamSet m1701b(MinutiaeVerbsFetcher minutiaeVerbsFetcher, boolean z) {
        Enum a = GraphQlQueryDefaults.a();
        GraphQlQueryParamSet graphQlQueryParamSet = new GraphQlQueryParamSet();
        String str = "image_scale";
        if (a == null) {
            a = GraphQlQueryDefaults.a;
        }
        GraphQlQueryParamSet a2 = graphQlQueryParamSet.a(str, a).a("minutiae_image_size_large", f1714b).a("dont_load_templates", "true");
        if (z) {
            return a2.a("surface", "composer").a("query_type", "VERB_ONLY").a("place_id", minutiaeVerbsFetcher.f1730p).a("query", "").a("session_id", Integer.valueOf(minutiaeVerbsFetcher.f1732r)).a("is_prefetch", Boolean.valueOf(true));
        }
        return a2;
    }
}
