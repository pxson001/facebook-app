package com.facebook.uberbar.core;

import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.FbInjector;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.SearchTypeaheadResult;
import com.facebook.search.api.SearchTypeaheadResult.Type;
import com.facebook.search.api.SearchTypeaheadResultsCreator;
import com.facebook.search.api.protocol.FetchSearchTypeaheadResultParams.Builder;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.uberbar.analytics.UberbarPerformanceConstants;
import com.facebook.uberbar.analytics.UberbarPerformanceLogger;
import com.facebook.uberbar.resolvers.LocalUberbarResultResolver;
import com.facebook.uberbar.ui.UberSearchResultsAdapter.FetchStatus;
import com.facebook.uberbar.ui.UberbarResultsFragment;
import com.facebook.uberbar.ui.UberbarResultsFragment.1;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: total_search_attempts */
public class UberbarResultFetcher {
    public static final String f1426a = UberbarResultFetcher.class.getSimpleName();
    public static final List<SearchTypeaheadResult> f1427b = Collections.emptyList();
    public static final ImmutableList<Type> f1428c = ImmutableList.of(Type.APP, Type.USER, Type.PAGE, Type.GROUP, Type.EVENT, Type.HASHTAG_EXACT);
    public static final ImmutableList<Type> f1429d = ImmutableList.of(Type.PAGE);
    private final LocalUberbarResultResolver f1430e;
    private final LocalUberbarResultResolver f1431f;
    public final DefaultAndroidThreadUtil f1432g;
    public final DefaultBlueServiceOperationFactory f1433h;
    public final GraphSearchQuery f1434i;
    public final String f1435j;
    private final long f1436k;
    public boolean f1437l = false;
    public boolean f1438m = false;
    public boolean f1439n = false;
    @Nullable
    public 1 f1440o;
    public List<SearchTypeaheadResult> f1441p;
    public List<SearchTypeaheadResult> f1442q;
    public List<SearchTypeaheadResult> f1443r;
    public final boolean f1444s;
    public final UberbarPerformanceLogger f1445t;
    private final SearchTypeaheadResultsCreator f1446u;
    public final AbstractFbErrorReporter f1447v;

    /* compiled from: total_search_attempts */
    class C01381 implements Runnable {
        final /* synthetic */ UberbarResultFetcher f1418a;

        C01381(UberbarResultFetcher uberbarResultFetcher) {
            this.f1418a = uberbarResultFetcher;
        }

        public void run() {
            if (!this.f1418a.f1437l) {
                UberbarResultFetcher uberbarResultFetcher = this.f1418a;
                uberbarResultFetcher.f1445t.m1515c();
                uberbarResultFetcher.f1445t.m1516d();
                Bundle bundle = new Bundle();
                List list = uberbarResultFetcher.f1444s ? UberbarResultFetcher.f1429d : UberbarResultFetcher.f1428c;
                Builder builder = new Builder();
                builder.a = uberbarResultFetcher.f1434i;
                builder = builder;
                builder.b = uberbarResultFetcher.f1435j;
                builder = builder;
                builder.c = 100;
                builder = builder;
                builder.d = list;
                bundle.putParcelable("fetchQueryResultParams", builder.a());
                Futures.a(BlueServiceOperationFactoryDetour.a(uberbarResultFetcher.f1433h, "fetch_uberbar_result", bundle, -583223572).a(), new C01392(uberbarResultFetcher));
            }
        }
    }

    /* compiled from: total_search_attempts */
    public class C01392 implements FutureCallback<OperationResult> {
        final /* synthetic */ UberbarResultFetcher f1419a;

        public C01392(UberbarResultFetcher uberbarResultFetcher) {
            this.f1419a = uberbarResultFetcher;
        }

        public void onSuccess(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (!this.f1419a.f1437l) {
                this.f1419a.f1443r = operationResult.l();
                UberbarResultFetcher.m1541g(this.f1419a);
                m1538a(true);
            }
        }

        public void onFailure(Throwable th) {
            if (!this.f1419a.f1437l) {
                this.f1419a.f1443r = UberbarResultFetcher.f1427b;
                UberbarResultFetcher.m1541g(this.f1419a);
                this.f1419a.f1447v.a(UberbarResultFetcher.f1426a, "Remote ubersearch failed: ", th);
                m1538a(false);
            }
        }

        private void m1538a(boolean z) {
            if (z) {
                this.f1419a.f1445t.m1517e();
            } else {
                this.f1419a.f1445t.m1518f();
            }
            UberbarPerformanceLogger uberbarPerformanceLogger = this.f1419a.f1445t;
            ImmutableBiMap b = ImmutableBiMap.b("results_were_received", Boolean.toString(z));
            uberbarPerformanceLogger.f1402a.b(UberbarPerformanceConstants.f1400a, b, uberbarPerformanceLogger.f1403b.now());
        }
    }

    /* compiled from: total_search_attempts */
    /* synthetic */ class C01434 {
        static final /* synthetic */ int[] f1425a = new int[Type.values().length];

        static {
            try {
                f1425a[Type.USER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1425a[Type.PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    UberbarResultFetcher(LocalUberbarResultResolver localUberbarResultResolver, LocalUberbarResultResolver localUberbarResultResolver2, DefaultAndroidThreadUtil defaultAndroidThreadUtil, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, int i, GraphSearchQuery graphSearchQuery, String str, boolean z, UberbarPerformanceLogger uberbarPerformanceLogger, SearchTypeaheadResultsCreator searchTypeaheadResultsCreator, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f1430e = (LocalUberbarResultResolver) Preconditions.checkNotNull(localUberbarResultResolver);
        this.f1431f = (LocalUberbarResultResolver) Preconditions.checkNotNull(localUberbarResultResolver2);
        this.f1432g = (DefaultAndroidThreadUtil) Preconditions.checkNotNull(defaultAndroidThreadUtil);
        this.f1433h = (DefaultBlueServiceOperationFactory) Preconditions.checkNotNull(defaultBlueServiceOperationFactory);
        Preconditions.checkArgument(i >= 0, "mRemoteFetchDelayIntervalMillis must be >= 0");
        this.f1436k = (long) i;
        this.f1434i = (GraphSearchQuery) Preconditions.checkNotNull(graphSearchQuery);
        this.f1435j = str;
        this.f1444s = z;
        this.f1445t = uberbarPerformanceLogger;
        this.f1446u = searchTypeaheadResultsCreator;
        this.f1447v = abstractFbErrorReporter;
    }

    public final void m1542a() {
        this.f1438m = false;
        this.f1439n = false;
        this.f1445t.m1513a();
        this.f1445t.m1519g();
        this.f1445t.m1514b();
        if (this.f1437l) {
            this.f1447v.a(f1426a, "Fetch called when in aborted state");
        } else if (!StringUtil.a(this.f1434i.b)) {
            if (this.f1444s) {
                this.f1438m = true;
            } else {
                this.f1445t.m1520h();
                Futures.a(this.f1430e.m1548a(this.f1434i), m1540a(Type.USER));
            }
            this.f1445t.m1523k();
            Futures.a(this.f1431f.m1548a(this.f1434i), m1540a(Type.PAGE));
            this.f1432g.b(new C01381(this), this.f1436k);
        }
    }

    public final void m1543b() {
        this.f1437l = true;
    }

    public static void m1541g(UberbarResultFetcher uberbarResultFetcher) {
        if (uberbarResultFetcher.f1440o != null) {
            List list;
            List list2;
            FetchStatus fetchStatus;
            List list3 = uberbarResultFetcher.f1443r == null ? f1427b : uberbarResultFetcher.f1443r;
            if (uberbarResultFetcher.f1441p == null) {
                list = f1427b;
            } else {
                list = uberbarResultFetcher.f1441p;
            }
            if (uberbarResultFetcher.f1442q == null) {
                list2 = f1427b;
            } else {
                list2 = uberbarResultFetcher.f1442q;
            }
            list3 = SearchTypeaheadResultsCreator.a(list3, list, list2);
            1 1 = uberbarResultFetcher.f1440o;
            Object obj = (uberbarResultFetcher.f1443r == null || uberbarResultFetcher.f1441p == null || uberbarResultFetcher.f1442q == null) ? null : 1;
            Object obj2 = obj;
            UberbarResultsFragment uberbarResultsFragment = 1.a;
            if (obj2 != null) {
                fetchStatus = FetchStatus.COMPLETED;
            } else {
                fetchStatus = FetchStatus.ONGOING;
            }
            if (uberbarResultsFragment.an == null) {
                ((AbstractFbErrorReporter) FbErrorReporterImpl.a(FbInjector.get(uberbarResultsFragment.getContext()))).a(SoftError.a("ubersearch", "resultsUpdated called while mSearchResultsAdapter is null").g());
            }
            uberbarResultsFragment.an.a(list3, fetchStatus);
        }
    }

    private FutureCallback<List<SearchTypeaheadResult>> m1540a(final Type type) {
        return new FutureCallback<List<SearchTypeaheadResult>>(this) {
            final /* synthetic */ UberbarResultFetcher f1424b;

            /* compiled from: total_search_attempts */
            class C01401 implements Runnable {
                final /* synthetic */ C01423 f1420a;

                C01401(C01423 c01423) {
                    this.f1420a = c01423;
                }

                public void run() {
                    UberbarResultFetcher.m1541g(this.f1420a.f1424b);
                }
            }

            public void onSuccess(Object obj) {
                List list = (List) obj;
                if (!this.f1424b.f1437l) {
                    switch (C01434.f1425a[type.ordinal()]) {
                        case 1:
                            this.f1424b.f1441p = list;
                            this.f1424b.f1438m = true;
                            this.f1424b.f1445t.m1521i();
                            break;
                        case 2:
                            this.f1424b.f1442q = list;
                            this.f1424b.f1439n = true;
                            this.f1424b.f1445t.m1524l();
                            break;
                        default:
                            this.f1424b.f1447v.a(UberbarResultFetcher.f1426a, "Unsupported search type found in creating future.");
                            break;
                    }
                    this.f1424b.f1432g.a(new C01401(this));
                    C01423.m1539a(this);
                }
            }

            public void onFailure(final Throwable th) {
                this.f1424b.f1432g.a(new Runnable(this) {
                    final /* synthetic */ C01423 f1422b;

                    public void run() {
                        if (!this.f1422b.f1424b.f1437l) {
                            switch (C01434.f1425a[type.ordinal()]) {
                                case 1:
                                    this.f1422b.f1424b.f1441p = UberbarResultFetcher.f1427b;
                                    this.f1422b.f1424b.f1438m = true;
                                    this.f1422b.f1424b.f1445t.m1522j();
                                    break;
                                case 2:
                                    this.f1422b.f1424b.f1442q = UberbarResultFetcher.f1427b;
                                    this.f1422b.f1424b.f1439n = true;
                                    this.f1422b.f1424b.f1445t.m1525m();
                                    break;
                            }
                            UberbarResultFetcher.m1541g(this.f1422b.f1424b);
                            C01423.m1539a(this.f1422b);
                            this.f1422b.f1424b.f1447v.a(UberbarResultFetcher.f1426a, "Local " + type.name() + " search failed: ", th);
                        }
                    }
                });
            }

            public static void m1539a(C01423 c01423) {
                if (c01423.f1424b.f1438m && c01423.f1424b.f1439n) {
                    UberbarPerformanceLogger uberbarPerformanceLogger = c01423.f1424b.f1445t;
                    uberbarPerformanceLogger.f1402a.b(UberbarPerformanceConstants.f1401b);
                }
            }
        };
    }
}
