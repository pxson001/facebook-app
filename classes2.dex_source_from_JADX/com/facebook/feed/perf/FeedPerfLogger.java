package com.facebook.feed.perf;

import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedParams.FetchTypeForLogging;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feedtype.FeedType;
import com.facebook.apptab.state.TabTag;
import com.facebook.backgroundworklog.observer.MultiplexBackgroundWorkObserver;
import com.facebook.base.lwperf.perfstats.BackgroundChecker;
import com.facebook.base.lwperf.perfstats.PerfStats;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.classmarkers.ClassMarkerLoader;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.TriState;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.data.typemanager.PreferredFeedTypeManager;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.places.checkin.analytics.PlacesPerformanceLogger;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QPLVisitorForNetworkInfo;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.sequencelogger.Fb4aSequences;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@NotThreadSafe
/* compiled from: upload_audio_interstitial */
public class FeedPerfLogger {
    private static volatile FeedPerfLogger f1653M;
    private static final Class<?> f1654a = FeedPerfLogger.class;
    private static final ImmutableList<MarkerConfig> f1655b = ImmutableList.of(new MarkerConfig(655431, "NNFWarm_FragmentCreateToDataFetched"), new MarkerConfig(655361, "NNFColdStart"), new MarkerConfig(655364, "NNFWarmStart"));
    private static final ImmutableList<MarkerConfig> f1656c = ImmutableList.of(new MarkerConfig(655380, "NNFFreshContentStart"), new MarkerConfig(655375, "NNFFreshFetch"), new MarkerConfig(655437, "NNFColdStartNetwork"), new MarkerConfig(655392, "NNFColdStartAndRenderTime"), new MarkerConfig(655441, "NNFCold_NetworkFetchedToNextRender"));
    private static final ImmutableList<MarkerConfig> f1657d = ImmutableList.builder().m1065b(f1656c).m1067b(new MarkerConfig(655379, "NNFWarmStartTTI"), new MarkerConfig(655393, "NNFWarmStartFromMemory"), new MarkerConfig(655394, "NNFWarmStartFromDb"), new MarkerConfig(655383, "NNFWarmStartFromNetwork"), new MarkerConfig(655395, "NNFWarmStartAndRenderTime"), new MarkerConfig(655396, "NNFWarmStartAndFreshRenderTime"), new MarkerConfig(655397, "NNFWarmStartAndCachedRenderTime")).m1068b();
    private static final ImmutableList<MarkerConfig> f1658e = ImmutableList.of(new MarkerConfig(655422, "NNFTailFetchTime"), new MarkerConfig(655426, "NNFTailFetchNetworkCallTime"), new MarkerConfig(655427, "NNFTailFetchNotConnectedCallTime"), new MarkerConfig(655423, "NNFTailFetchRenderTime"));
    private static final int[] f1659f = new int[]{655410};
    private static final ImmutableList<MarkerConfig> f1660g = ImmutableList.of(new MarkerConfig(655403, "NNFHotStartAndRenderTime"), new MarkerConfig(655404, "NNFHotStartAndFreshRenderTime"), new MarkerConfig(655434, "NNFHotStartAndFreshRenderTimeNotVisible"), new MarkerConfig(655416, "NNFHotStartTTI"));
    private boolean f1661A = false;
    public boolean f1662B = false;
    public long f1663C = -1;
    private long f1664D;
    private long f1665E;
    public boolean f1666F = false;
    public int f1667G = -1;
    private final AtomicBoolean f1668H = new AtomicBoolean(true);
    private volatile boolean f1669I = false;
    private volatile boolean f1670J = false;
    private boolean f1671K = false;
    public boolean f1672L = false;
    public final PerformanceLogger f1673h;
    public final QuickPerformanceLogger f1674i;
    public final StartupPerfLogger f1675j;
    public final SequenceLogger f1676k;
    public final MonotonicClock f1677l;
    private final FbNetworkManager f1678m;
    private final AppStateManager f1679n;
    private final ListeningExecutorService f1680o;
    private final PreferredFeedTypeManager f1681p;
    private final MultiplexBackgroundWorkObserver f1682q;
    public final PlacesPerformanceLogger f1683r;
    private boolean f1684s = false;
    public boolean f1685t = false;
    private boolean f1686u = false;
    public boolean f1687v = false;
    private boolean f1688w = false;
    private boolean f1689x = false;
    private ColdStartStoryStatus f1690y = ColdStartStoryStatus.NOT_SET;
    public boolean f1691z = false;

    /* compiled from: upload_audio_interstitial */
    enum ColdStartStoryStatus {
        NOT_SET,
        DEFAULT_FRESH_NETWORK_FETCH,
        DEFAULT_CACHED_FRESH_WITHOUT_NETWORK_FETCH,
        ASYNC_CACHE_UNSEEN_STORY,
        ASYNC_CACHE_SEEN_STORY,
        ASYNC_NO_CACHE,
        ASYNC_FRESH_FAST_NETWORK_FETCH,
        FRESH_FEED_NETWORK,
        FRESH_FEED_CACHE
    }

    public static com.facebook.feed.perf.FeedPerfLogger m3326a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f1653M;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.perf.FeedPerfLogger.class;
        monitor-enter(r1);
        r0 = f1653M;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m3335b(r0);	 Catch:{ all -> 0x0035 }
        f1653M = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1653M;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.perf.FeedPerfLogger.a(com.facebook.inject.InjectorLike):com.facebook.feed.perf.FeedPerfLogger");
    }

    private static FeedPerfLogger m3335b(InjectorLike injectorLike) {
        return new FeedPerfLogger(DelegatingPerformanceLogger.m2803a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), StartupPerfLogger.m3414b(injectorLike), SequenceLoggerImpl.m3464a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), FbNetworkManager.m3811a(injectorLike), AppStateManager.m2245a(injectorLike), C0055x2995691a.m1881a(injectorLike), PreferredFeedTypeManager.m4198a(injectorLike), MultiplexBackgroundWorkObserver.m1670a(injectorLike), QPLVisitorForNetworkInfo.m3222a(injectorLike), PlacesPerformanceLogger.m4202a(injectorLike));
    }

    @Inject
    public FeedPerfLogger(PerformanceLogger performanceLogger, QuickPerformanceLogger quickPerformanceLogger, StartupPerfLogger startupPerfLogger, SequenceLogger sequenceLogger, MonotonicClock monotonicClock, FbNetworkManager fbNetworkManager, AppStateManager appStateManager, ListeningExecutorService listeningExecutorService, PreferredFeedTypeManager preferredFeedTypeManager, MultiplexBackgroundWorkObserver multiplexBackgroundWorkObserver, QPLVisitorForNetworkInfo qPLVisitorForNetworkInfo, PlacesPerformanceLogger placesPerformanceLogger) {
        this.f1673h = performanceLogger;
        this.f1674i = quickPerformanceLogger;
        this.f1675j = startupPerfLogger;
        this.f1676k = sequenceLogger;
        this.f1677l = monotonicClock;
        this.f1678m = fbNetworkManager;
        this.f1679n = appStateManager;
        this.f1680o = listeningExecutorService;
        this.f1681p = preferredFeedTypeManager;
        this.f1682q = multiplexBackgroundWorkObserver;
        this.f1683r = placesPerformanceLogger;
        qPLVisitorForNetworkInfo.m3225a(655410);
        qPLVisitorForNetworkInfo.m3225a(655425);
        qPLVisitorForNetworkInfo.m3225a(655382);
    }

    public final void m3348a(FetchFeedParams fetchFeedParams) {
        FetchTypeForLogging fetchTypeForLogging = fetchFeedParams.f5798p;
        if (this.f1681p.m4200a() != fetchFeedParams.f5784b || !fetchTypeForLogging.equals(FetchTypeForLogging.CHUNKED_INITIAL)) {
            return;
        }
        if (fetchFeedParams.f5788f.isManual()) {
            m3336b(655445, "NNFPullToRefreshBeforeExecuteTime");
        } else {
            m3336b(m3360d(this.f1681p.m4200a()), m3344a("TimeToFeedFetchExecuteFromTrigger", this.f1681p.m4200a()));
        }
    }

    private void m3343y() {
        this.f1684s = true;
        this.f1685t = true;
        this.f1686u = false;
    }

    public final void m3345a() {
        this.f1675j.f1718e = true;
        this.f1675j.f1719f = true;
        this.f1675j.f1720g = true;
        this.f1683r.f2057b = true;
        m3321O();
    }

    public final void m3353a(boolean z) {
        if (this.f1685t && !this.f1686u) {
            this.f1686u = true;
            m3323Q();
            this.f1675j.m3456f(655379, "NNFWarmStartTTI");
            this.f1673h.mo389c(655380, "NNFFreshContentStart");
            this.f1675j.m3454e(655375, "NNFFreshFetch");
            if (m3312F()) {
                m3339c(655437, "NNFColdStartNetwork");
            }
            if (this.f1675j.m3462l(655383, "NNFWarmStartFromNetwork")) {
                this.f1675j.m3460j(655394, "NNFWarmStartFromDb");
            }
        }
        if (z && !m3310C()) {
            this.f1673h.mo389c(655424, "NNFPullToRefreshNetworkTime");
        }
    }

    public final void m3349a(FetchFeedResult fetchFeedResult, boolean z) {
        if (this.f1684s) {
            this.f1684s = false;
            long now = this.f1677l.now();
            this.f1675j.m3448c(655431, "NNFWarm_FragmentCreateToDataFetched", null, null, now).m3431a(655430, "NNFWarm_DataFetchedToFirstRender", null, null, now);
            this.f1675j.m3429a(655432, "NNFCold_DataFetchedToFirstRender");
        }
        if (z && !m3310C() && m3334a(fetchFeedResult)) {
            this.f1673h.mo389c(655424, "NNFPullToRefreshNetworkTime");
            m3327a(655445, "NNFPullToRefreshBeforeExecuteTime");
        }
        if (this.f1685t && z) {
            DataFreshnessResult dataFreshnessResult = fetchFeedResult.freshness;
            if (!this.f1686u && (dataFreshnessResult == DataFreshnessResult.FROM_CACHE_UP_TO_DATE || dataFreshnessResult == DataFreshnessResult.FROM_SERVER)) {
                this.f1686u = true;
                m3323Q();
                this.f1675j.m3456f(655379, "NNFWarmStartTTI");
                this.f1673h.mo389c(655380, "NNFFreshContentStart");
                this.f1675j.m3454e(655375, "NNFFreshFetch");
                if (m3312F()) {
                    this.f1675j.m3434a(655441, "NNFCold_NetworkFetchedToNextRender", true);
                    m3339c(655437, "NNFColdStartNetwork");
                }
                if (this.f1675j.m3462l(655383, "NNFWarmStartFromNetwork")) {
                    this.f1675j.m3460j(655394, "NNFWarmStartFromDb");
                }
            }
        }
        if (this.f1673h.mo400h(655422, "NNFTailFetchTime")) {
            m3329a(655423, "NNFTailFetchRenderTime", false);
            this.f1673h.mo389c(655426, "NNFTailFetchNetworkCallTime");
            this.f1673h.mo389c(655427, "NNFTailFetchNotConnectedCallTime");
        }
        if (fetchFeedResult.m10404a() == DataFreshnessResult.FROM_CACHE_STALE && this.f1675j.m3462l(655394, "NNFWarmStartFromDb")) {
            this.f1675j.m3460j(655383, "NNFWarmStartFromNetwork");
        }
        if (!this.f1687v && this.f1673h.mo400h(655416, "NNFHotStartTTI") && z) {
            this.f1687v = true;
            this.f1675j.m3450d(655416, "NNFHotStartTTI");
        }
    }

    private static boolean m3334a(FetchFeedResult fetchFeedResult) {
        return (fetchFeedResult == null || fetchFeedResult.f15756a == null || fetchFeedResult.f15756a.f5788f == null || !fetchFeedResult.f15756a.f5788f.isManual()) ? false : true;
    }

    public final void m3352a(String str, boolean z, FeedType feedType) {
        int size;
        int i;
        if (str == null) {
            str = "UnknownError";
        }
        Map b = ImmutableBiMap.m978b("exception_name", str);
        if (this.f1684s && !z) {
            this.f1684s = false;
            size = f1655b.size();
            for (i = 0; i < size; i++) {
                this.f1673h.mo393d(((MarkerConfig) f1655b.get(i)).m3387a(b));
            }
        }
        if (this.f1685t) {
            this.f1685t = false;
            size = f1657d.size();
            for (i = 0; i < size; i++) {
                this.f1673h.mo393d(((MarkerConfig) f1657d.get(i)).m3387a(b));
            }
            if (!this.f1689x) {
                this.f1673h.mo393d(new MarkerConfig(655382, "NNFColdStartTTI").m3387a(b));
                this.f1673h.mo393d(new MarkerConfig(655501, "NNFColdStartTTILegacy").m3387a(b));
            }
        }
        if (this.f1673h.mo400h(655416, "NNFHotStartTTI")) {
            size = f1660g.size();
            for (i = 0; i < size; i++) {
                this.f1673h.mo393d(((MarkerConfig) f1660g.get(i)).m3387a(b));
            }
        }
        this.f1675j.m3437a(ImmutableList.of(new MarkerConfig(655361, "NNFColdStart"), new MarkerConfig(655420, "NNFColdStartChromeLoadTime"), new MarkerConfig(655382, "NNFColdStartTTI"), new MarkerConfig(655501, "NNFColdStartTTILegacy"), new MarkerConfig(655437, "NNFColdStartNetwork"), new MarkerConfig(655392, "NNFColdStartAndRenderTime"), new MarkerConfig(655418, "NNFFirstRunColdStart"), new MarkerConfig(655446, "NNFCold_LoginActivityCreateToFragmentCreate"), new MarkerConfig(655382, "NNFColdStartAsyncTTI")));
        this.f1675j.m3445b(ImmutableList.of(new MarkerConfig(655379, "NNFWarmStartTTI"), new MarkerConfig(655395, "NNFWarmStartAndRenderTime"), new MarkerConfig(655396, "NNFWarmStartAndFreshRenderTime"), new MarkerConfig(655397, "NNFWarmStartAndCachedRenderTime"), new MarkerConfig(655364, "NNFWarmStart"), new MarkerConfig(655394, "NNFWarmStartFromDb"), new MarkerConfig(655393, "NNFWarmStartFromMemory"), new MarkerConfig(655383, "NNFWarmStartFromNetwork"), new MarkerConfig(655380, "NNFFreshContentStart")));
        this.f1675j.m3449c(ImmutableList.of(new MarkerConfig(655416, "NNFHotStartTTI"), new MarkerConfig(655403, "NNFHotStartAndRenderTime"), new MarkerConfig(655404, "NNFHotStartAndFreshRenderTime"), new MarkerConfig(655434, "NNFHotStartAndFreshRenderTimeNotVisible")));
        int size2 = f1658e.size();
        for (i = 0; i < size2; i++) {
            this.f1673h.mo393d((MarkerConfig) f1658e.get(i));
        }
        for (int size3 : f1659f) {
            this.f1674i.mo468b(size3, (short) 3);
        }
        this.f1673h.mo397f(655424, "NNFPullToRefreshNetworkTime");
        this.f1674i.mo468b(655425, (short) 3);
        m3327a(655445, "NNFPullToRefreshBeforeExecuteTime");
        if (!z) {
            this.f1674i.mo468b(2293779, (short) 3);
            this.f1674i.mo468b(655386, (short) 3);
        }
        this.f1675j.m3457g(m3360d(this.f1681p.m4200a()), m3344a("FragmentResumeToRender", feedType));
        m3321O();
    }

    public final void m3358b(boolean z) {
        int size;
        int i;
        if (this.f1684s && !z) {
            this.f1684s = false;
            size = f1655b.size();
            for (i = 0; i < size; i++) {
                this.f1673h.mo398f((MarkerConfig) f1655b.get(i));
            }
        }
        if (this.f1685t) {
            this.f1685t = false;
            size = f1657d.size();
            for (i = 0; i < size; i++) {
                this.f1673h.mo398f((MarkerConfig) f1657d.get(i));
            }
            if (!this.f1689x) {
                this.f1673h.mo398f(new MarkerConfig(655382, "NNFColdStartTTI"));
                this.f1673h.mo398f(new MarkerConfig(655501, "NNFColdStartTTILegacy"));
                this.f1673h.mo398f(new MarkerConfig(655382, "NNFColdStartAsyncTTI"));
            }
        }
        if (this.f1673h.mo400h(655416, "NNFHotStartTTI")) {
            size = f1660g.size();
            for (i = 0; i < size; i++) {
                this.f1673h.mo398f((MarkerConfig) f1660g.get(i));
            }
        }
        size = f1658e.size();
        for (i = 0; i < size; i++) {
            this.f1673h.mo398f((MarkerConfig) f1658e.get(i));
        }
        for (int d : f1659f) {
            this.f1674i.mo476d(d);
        }
        if (!z) {
            this.f1674i.mo468b(2293779, (short) 4);
            this.f1674i.mo468b(655386, (short) 4);
        }
        m3327a(655424, "NNFPullToRefreshNetworkTime");
        this.f1674i.mo468b(655425, (short) 3);
        m3327a(655445, "NNFPullToRefreshBeforeExecuteTime");
        m3321O();
    }

    public final boolean m3356a(boolean z, FeedType feedType, boolean z2) {
        if (!this.f1681p.m4201a(feedType)) {
            return false;
        }
        if (m3318L() || this.f1673h.mo400h(655395, "NNFWarmStartAndRenderTime") || this.f1674i.mo460a(655421)) {
            return false;
        }
        long j;
        this.f1676k.mo518b(Fb4aSequences.f2221f);
        StartupPerfLogger startupPerfLogger = this.f1675j;
        if (this.f1663C > 0) {
            j = this.f1663C;
        } else {
            j = this.f1677l.now();
        }
        startupPerfLogger.m3436a(j, ImmutableList.of(new MarkerConfig(655366, "NNFHotStart"), new MarkerConfig(655416, "NNFHotStartTTI"), new MarkerConfig(655403, "NNFHotStartAndRenderTime"), new MarkerConfig(655433, "NNFHotStartAndCachedRenderTime"), new MarkerConfig(655404, "NNFHotStartAndFreshRenderTime"), new MarkerConfig(655434, "NNFHotStartAndFreshRenderTimeNotVisible")));
        if (z) {
            this.f1687v = false;
            this.f1675j.m3460j(655433, "NNFHotStartAndCachedRenderTime");
            if (z2) {
                this.f1675j.m3460j(655434, "NNFHotStartAndFreshRenderTimeNotVisible");
            } else {
                this.f1675j.m3460j(655404, "NNFHotStartAndFreshRenderTime");
            }
        } else {
            this.f1675j.m3460j(655404, "NNFHotStartAndFreshRenderTime");
            this.f1675j.m3460j(655434, "NNFHotStartAndFreshRenderTimeNotVisible");
        }
        this.f1675j.m3450d(655366, "NNFHotStart");
        if (this.f1675j.m3462l(655433, "NNFHotStartAndCachedRenderTime")) {
            this.f1675j.m3450d(655403, "NNFHotStartAndRenderTime");
            this.f1675j.m3450d(655433, "NNFHotStartAndCachedRenderTime");
            this.f1675j.m3450d(655416, "NNFHotStartTTI");
            this.f1676k.mo518b(Fb4aSequences.f2221f);
            return false;
        } else if (!this.f1675j.m3462l(655434, "NNFHotStartAndFreshRenderTimeNotVisible")) {
            return true;
        } else {
            this.f1675j.m3450d(655403, "NNFHotStartAndRenderTime");
            this.f1675j.m3450d(655434, "NNFHotStartAndFreshRenderTimeNotVisible");
            this.f1675j.m3450d(655416, "NNFHotStartTTI");
            this.f1676k.mo518b(Fb4aSequences.f2221f);
            return false;
        }
    }

    public final boolean m3355a(FeedType feedType, int i) {
        boolean z;
        long now = this.f1677l.now();
        m3322P();
        if (m3319M()) {
            this.f1675j.m3439a(Fb4aSequences.f2217b);
            this.f1676k.mo523d(Fb4aSequences.f2216a);
        } else {
            this.f1676k.mo523d(Fb4aSequences.f2217b);
        }
        m3338b("FragmentResumeToRender", feedType);
        if (this.f1673h.mo400h(655395, "NNFWarmStartAndRenderTime")) {
            this.f1675j.m3448c(655430, "NNFWarm_DataFetchedToFirstRender", null, null, now);
            this.f1675j.m3448c(655364, "NNFWarmStart", null, null, now);
            this.f1675j.m3456f(655393, "NNFWarmStartFromMemory");
            this.f1675j.m3456f(655394, "NNFWarmStartFromDb");
            this.f1675j.m3456f(655383, "NNFWarmStartFromNetwork");
            this.f1676k.mo518b(Fb4aSequences.f2222g);
            if (this.f1666F) {
                if (this.f1686u && this.f1685t) {
                    this.f1685t = false;
                    this.f1675j.m3451d(655395, "NNFWarmStartAndRenderTime", now);
                    this.f1675j.m3451d(655396, "NNFWarmStartAndFreshRenderTime", now);
                    this.f1673h.mo374a(655397, "NNFWarmStartAndCachedRenderTime");
                    this.f1676k.mo518b(Fb4aSequences.f2220e);
                    z = true;
                }
                z = false;
            } else {
                this.f1675j.m3451d(655379, "NNFWarmStartTTI", now);
                this.f1675j.m3451d(655395, "NNFWarmStartAndRenderTime", now);
                this.f1675j.m3451d(655397, "NNFWarmStartAndCachedRenderTime", now);
                this.f1673h.mo374a(655396, "NNFWarmStartAndFreshRenderTime");
                this.f1676k.mo518b(Fb4aSequences.f2220e);
                z = true;
            }
        } else {
            if (m3318L()) {
                MarkerConfig b;
                if (this.f1673h.mo400h(655437, "NNFColdStartNetwork")) {
                    this.f1675j.m3442b(655432, "NNFCold_DataFetchedToFirstRender", null, null, now);
                } else {
                    this.f1675j.m3461k(655432, "NNFCold_DataFetchedToFirstRender");
                }
                if (m3319M()) {
                    this.f1675j.m3447c(655418, "NNFFirstRunColdStart", now);
                    this.f1673h.mo374a(655361, "NNFColdStart");
                    this.f1673h.mo374a(655382, "NNFColdStartTTI");
                    this.f1673h.mo374a(655501, "NNFColdStartTTILegacy");
                    this.f1673h.mo374a(655437, "NNFColdStartNetwork");
                    this.f1673h.mo374a(655392, "NNFColdStartAndRenderTime");
                } else {
                    this.f1673h.mo374a(655418, "NNFFirstRunColdStart");
                    if (i > 0) {
                        b = new MarkerConfig(655361, "NNFColdStart").m3391b(now);
                        if (this.f1689x) {
                            b.m3386a("feedFreshWithoutFetch", "1");
                        } else {
                            b.m3386a("feedFreshWithoutFetch", "0");
                        }
                        m3332a(b);
                    }
                    if (this.f1673h.mo400h(655492, "NNFCold_Network")) {
                        this.f1671K = true;
                    }
                    if (this.f1689x) {
                        m3331a(ColdStartStoryStatus.DEFAULT_CACHED_FRESH_WITHOUT_NETWORK_FETCH);
                        if (i > 0) {
                            m3313G();
                        }
                        m3314H();
                    } else if (this.f1690y == ColdStartStoryStatus.ASYNC_CACHE_UNSEEN_STORY) {
                        if (i > 0) {
                            m3315I();
                            m3313G();
                        }
                        m3314H();
                    }
                }
                if (this.f1686u && this.f1685t && i > 0) {
                    this.f1685t = false;
                    b = new MarkerConfig(655392, "NNFColdStartAndRenderTime");
                    b.f1699h = now;
                    b = b;
                    if (this.f1671K) {
                        b.m3386a("networkFetchIsCritPath", "1");
                    } else {
                        b.m3386a("networkFetchIsCritPath", "0");
                    }
                    m3332a(b);
                    m3328a(655441, "NNFCold_NetworkFetchedToNextRender", now);
                    if (!this.f1689x) {
                        m3313G();
                        m3314H();
                    }
                    m3315I();
                    this.f1675j.m3439a(Fb4aSequences.f2216a);
                    z = true;
                }
            }
            z = false;
        }
        this.f1674i.mo468b(655386, (short) 2);
        if (this.f1674i.mo460a(2293779) && (this.f1686u || i > 0)) {
            short s;
            if (this.f1686u) {
                s = (short) 27;
            } else if (this.f1689x) {
                s = (short) 28;
            } else if (this.f1690y == ColdStartStoryStatus.ASYNC_CACHE_UNSEEN_STORY) {
                s = (short) 25;
            } else if (this.f1690y == ColdStartStoryStatus.ASYNC_FRESH_FAST_NETWORK_FETCH) {
                s = (short) 27;
            } else {
                s = (short) 2;
            }
            this.f1674i.mo448a(2293779, this.f1690y.toString());
            this.f1674i.mo468b(2293779, s);
            z = true;
        }
        Sequence e = this.f1676k.mo524e(Fb4aSequences.f2225j);
        if (e != null) {
            if (e.mo631f("NNFSwitchToFeedRenderFromOnCreateView")) {
                SequenceLoggerDetour.b(e, "NNFSwitchToFeedRenderFromOnCreateView", 1664687125);
            }
            this.f1676k.mo518b(Fb4aSequences.f2225j);
        }
        this.f1672L = false;
        int e2 = m3340e(feedType);
        if (this.f1674i.mo460a(e2)) {
            this.f1674i.mo468b(e2, (short) 2);
        } else if (this.f1674i.mo460a(655413)) {
            this.f1674i.mo468b(655413, (short) 2);
            z = true;
        } else if (this.f1674i.mo460a(655414)) {
            this.f1674i.mo468b(655414, (short) 2);
            z = true;
        }
        if (z || m3311E()) {
            return z;
        }
        return true;
    }

    private int m3340e(FeedType feedType) {
        return feedType.equals(this.f1681p.m4200a()) ? 655421 : 655428;
    }

    public final void m3363e() {
        if (this.f1675j.m3462l(655361, "NNFColdStart")) {
            this.f1675j.m3434a(655450, "NNFCold_MaintabCreateToFeedCreate", true);
        } else if (this.f1675j.m3462l(655364, "NNFWarmStart")) {
            this.f1675j.m3440b(655451, "NNFWarm_MaintabCreateToFeedCreate");
        }
        if (m3319M()) {
            this.f1673h.mo374a(655420, "NNFColdStartChromeLoadTime");
            return;
        }
        this.f1675j.m3442b(655420, "NNFColdStartChromeLoadTime", null, null, this.f1677l.now());
    }

    public final void m3350a(FeedType feedType) {
        this.f1666F = false;
        this.f1667G = -1;
        if (m3311E()) {
            this.f1675j.m3446c(655450, "NNFCold_MaintabCreateToFeedCreate");
            this.f1675j.m3456f(655451, "NNFWarm_MaintabCreateToFeedCreate");
        } else {
            Sequence f = m3341f(feedType);
            if (f != null) {
                SequenceLoggerDetour.a(f, "NNFSwitchToFeedOnCreateToOnCreateView", -168207060);
            }
        }
        this.f1675j.m3458h(m3360d(feedType), m3344a("FragmentCreate", feedType));
        this.f1675j.m3443b(m3360d(feedType), m3344a("FragmentOnCreateTime", feedType), true);
    }

    public final void m3365f() {
        this.f1689x = true;
        this.f1676k.mo523d(Fb4aSequences.f2217b);
        this.f1676k.mo523d(Fb4aSequences.f2216a);
        int size = f1656c.size();
        for (int i = 0; i < size; i++) {
            this.f1673h.mo398f((MarkerConfig) f1656c.get(i));
        }
        m3321O();
    }

    public final void m3366g() {
        m3331a(ColdStartStoryStatus.ASYNC_CACHE_UNSEEN_STORY);
    }

    public final void m3368h() {
        m3331a(ColdStartStoryStatus.ASYNC_CACHE_SEEN_STORY);
    }

    public final void m3369i() {
        m3331a(ColdStartStoryStatus.ASYNC_NO_CACHE);
    }

    public final void m3370j() {
        m3331a(ColdStartStoryStatus.ASYNC_FRESH_FAST_NETWORK_FETCH);
    }

    public final void m3371k() {
        m3331a(ColdStartStoryStatus.FRESH_FEED_NETWORK);
    }

    public final void m3372l() {
        m3331a(ColdStartStoryStatus.FRESH_FEED_CACHE);
    }

    public final void m3351a(FeedType feedType, boolean z) {
        m3338b("FragmentCreate", feedType);
        this.f1675j.m3458h(m3360d(feedType), m3344a("FragmentResumeToRender", feedType));
        if (this.f1684s && z) {
            this.f1675j.m3460j(655394, "NNFWarmStartFromDb");
            this.f1675j.m3460j(655383, "NNFWarmStartFromNetwork");
            return;
        }
        this.f1675j.m3460j(655393, "NNFWarmStartFromMemory");
    }

    public final void m3373o() {
        m3337b(this.f1677l.now());
        this.f1675j.m3429a(655455, "NNFCold_LoginActivityEndToEnd").m3429a(655456, "NNFCold_LoginActivityCreate");
        if (!m3312F()) {
            this.f1675j.m3440b(655457, "NNFWarm_LoginActivityEndToEnd").m3440b(655458, "NNFWarm_LoginActivityCreate");
        }
    }

    public final void m3346a(long j) {
        m3337b(j);
    }

    private void m3337b(long j) {
        m3343y();
        this.f1675j.m3441b(655459, "NNFCold_AppCreateToLoginActivityCreate", j).m3430a(655446, "NNFCold_LoginActivityCreateToFragmentCreate", j).m3430a(655515, "NNFColdLoadInlineComposerAfterLoggedIn", j);
        if (!m3319M() && this.f1679n.m2263k() == TriState.YES) {
            m3309A();
        }
        if (!this.f1673h.mo400h(655361, "NNFColdStart")) {
            PerfStats a = PerfStats.a();
            this.f1665E = this.f1677l.now();
            this.f1675j.m3438a(ImmutableList.of(new MarkerConfig(655379, "NNFWarmStartTTI"), new MarkerConfig(655395, "NNFWarmStartAndRenderTime"), new MarkerConfig(655396, "NNFWarmStartAndFreshRenderTime"), new MarkerConfig(655397, "NNFWarmStartAndCachedRenderTime"), new MarkerConfig(655364, "NNFWarmStart"), new MarkerConfig(655393, "NNFWarmStartFromMemory"), new MarkerConfig(655394, "NNFWarmStartFromDb"), new MarkerConfig(655383, "NNFWarmStartFromNetwork"), new MarkerConfig(655380, "NNFFreshContentStart"), new MarkerConfig(655516, "NNFWarmLoadInlineComposerAfterLoggedIn")), j, a);
        }
        this.f1683r.m4212f();
    }

    public final void m3361d(boolean z) {
        if (z) {
            this.f1673h.mo392d(m3360d(this.f1681p.m4200a()), m3344a("TimeToFeedFetchExecuteFromTrigger", this.f1681p.m4200a()));
        }
    }

    private void m3309A() {
        this.f1675j.m3437a(ImmutableList.of(new MarkerConfig(655361, "NNFColdStart"), new MarkerConfig(655420, "NNFColdStartChromeLoadTime"), new MarkerConfig(655382, "NNFColdStartTTI"), new MarkerConfig(655501, "NNFColdStartTTILegacy"), new MarkerConfig(655437, "NNFColdStartNetwork"), new MarkerConfig(655392, "NNFColdStartAndRenderTime"), new MarkerConfig(655418, "NNFFirstRunColdStart"), new MarkerConfig(655444, "NNFColdFreshContentStart"), new MarkerConfig(655446, "NNFCold_LoginActivityCreateToFragmentCreate"), new MarkerConfig(655456, "NNFCold_LoginActivityCreate"), new MarkerConfig(655455, "NNFCold_LoginActivityEndToEnd"), new MarkerConfig(655382, "NNFColdStartAsyncTTI"), new MarkerConfig[0]));
    }

    public final void m3374q() {
        m3309A();
        this.f1675j.m3445b(ImmutableList.of(new MarkerConfig(655379, "NNFWarmStartTTI"), new MarkerConfig(655395, "NNFWarmStartAndRenderTime"), new MarkerConfig(655396, "NNFWarmStartAndFreshRenderTime"), new MarkerConfig(655397, "NNFWarmStartAndCachedRenderTime"), new MarkerConfig(655364, "NNFWarmStart"), new MarkerConfig(655394, "NNFWarmStartFromDb"), new MarkerConfig(655393, "NNFWarmStartFromMemory"), new MarkerConfig(655380, "NNFFreshContentStart"), new MarkerConfig(655460, "NNFWarm_LoginActivityCreateToFragmentCreate"), new MarkerConfig(655458, "NNFWarm_LoginActivityCreate"), new MarkerConfig(655455, "NNFCold_LoginActivityEndToEnd")));
        this.f1675j.m3457g(m3360d(this.f1681p.m4200a()), m3344a("FragmentResumeToRender", this.f1681p.m4200a()));
        m3321O();
    }

    public final void m3375s() {
        this.f1675j.m3429a(655459, "NNFCold_AppCreateToLoginActivityCreate");
    }

    public final void m3347a(long j, PerfStats perfStats, boolean z) {
        this.f1688w = z;
        Boolean.valueOf(z);
        m3320N();
        MarkerConfig markerConfig = new MarkerConfig(655382, "NNFColdStartTTI");
        MarkerConfig markerConfig2 = new MarkerConfig(655382, "NNFColdStartAsyncTTI");
        MarkerConfig markerConfig3 = new MarkerConfig(655437, "NNFColdStartNetwork");
        this.f1664D = this.f1677l.now();
        this.f1665E = this.f1664D;
        this.f1675j.m3435a(j, perfStats, BackgroundChecker.a().d(), ImmutableList.of(markerConfig, new MarkerConfig(655501, "NNFColdStartTTILegacy"), markerConfig3, new MarkerConfig(655392, "NNFColdStartAndRenderTime"), new MarkerConfig(655418, "NNFFirstRunColdStart"), new MarkerConfig(655361, "NNFColdStart"), new MarkerConfig(655420, "NNFColdStartChromeLoadTime"), markerConfig2));
        if (this.f1682q != null) {
            this.f1682q.mo232a(1, "ColdStart", Arrays.asList(new MarkerConfig[]{markerConfig, markerConfig3}));
        }
    }

    public final void m3359c(FeedType feedType) {
        if (m3311E()) {
            m3329a(655417, "NNFFragmentViewCreate", true);
        } else {
            Sequence f = m3341f(feedType);
            if (f != null) {
                SequenceLoggerDetour.b(f, "NNFSwitchToFeedOnCreateToOnCreateView", 1904587374);
                SequenceLoggerDetour.a(f, "NNFSwitchToFeedRenderFromOnCreateView", -793099126);
                SequenceLoggerDetour.a(f, "NNFNotStartupFragmentViewCreate", 1963154454);
            }
        }
        m3338b("FragmentOnCreateTime", feedType);
        this.f1675j.m3443b(m3360d(feedType), m3344a("FragmentOnViewCreateTime", feedType), true);
        this.f1663C = -1;
    }

    public final void m3364e(boolean z) {
        this.f1676k.mo510a(Fb4aSequences.f2225j);
        this.f1672L = true;
        if (z) {
            m3330a(655414, false);
        } else {
            m3330a(655413, false);
        }
    }

    public final void m3354a(boolean z, FeedType feedType) {
        if (z) {
            this.f1675j.m3456f(655460, "NNFWarm_LoginActivityCreateToFragmentCreate").m3440b(655431, "NNFWarm_FragmentCreateToDataFetched");
            this.f1675j.m3446c(655446, "NNFCold_LoginActivityCreateToFragmentCreate");
        }
        m3338b("FragmentOnViewCreateTime", feedType);
        if (this.f1673h.mo400h(655417, "NNFFragmentViewCreate")) {
            this.f1673h.mo389c(655417, "NNFFragmentViewCreate");
            return;
        }
        Sequence e = this.f1676k.mo524e(Fb4aSequences.f2225j);
        if (e != null) {
            SequenceLoggerDetour.b(e, "NNFNotStartupFragmentViewCreate", 930980769);
        }
    }

    private Sequence<?> m3341f(FeedType feedType) {
        if (this.f1672L) {
            return this.f1676k.mo524e(Fb4aSequences.f2225j);
        }
        this.f1672L = true;
        Sequence<?> a = this.f1676k.mo510a(Fb4aSequences.f2225j);
        m3330a(m3340e(feedType), false);
        return a;
    }

    public final void m3376t() {
        this.f1662B = false;
        m3329a(655424, "NNFPullToRefreshNetworkTime", false);
        m3330a(655425, false);
        this.f1673h.mo392d(655445, "NNFPullToRefreshBeforeExecuteTime");
    }

    public final boolean m3362d() {
        if (!this.f1674i.mo460a(655425) || (!m3310C() && !this.f1662B)) {
            return false;
        }
        this.f1674i.mo468b(655425, (short) 2);
        return true;
    }

    private boolean m3310C() {
        return !this.f1673h.mo400h(655424, "NNFPullToRefreshNetworkTime");
    }

    public final void m3357b(int i) {
        if (this.f1667G != -1 && this.f1667G <= i) {
            this.f1667G = -1;
            this.f1674i.mo469b(655410, (short) 2, 0);
        }
    }

    public final void m3367g(boolean z) {
        boolean d = this.f1678m.m3828d();
        if (!this.f1673h.mo400h(655422, "NNFTailFetchTime")) {
            m3329a(655422, "NNFTailFetchTime", false);
            if (d) {
                m3329a(655426, "NNFTailFetchNetworkCallTime", false);
            } else {
                m3329a(655427, "NNFTailFetchNotConnectedCallTime", false);
            }
        }
        if (z && this.f1673h.mo400h(655422, "NNFTailFetchTime") && !this.f1674i.mo460a(655410)) {
            m3330a(655410, false);
        }
    }

    private void m3329a(int i, String str, boolean z) {
        MarkerConfig a = new MarkerConfig(i, str).m3388a(m3342x());
        a.f1705n = false;
        a = a;
        if (z) {
            a = a.m3390b();
        }
        this.f1673h.mo391c(a);
    }

    private void m3330a(int i, boolean z) {
        this.f1674i.mo440a(i, 0, this.f1677l.now(), z);
        this.f1674i.mo451a(i, Collections.singleton(m3342x()));
    }

    public final String m3344a(String str, FeedType feedType) {
        if (this.f1673h.mo400h(655361, "NNFColdStart")) {
            return "NNFCold" + str;
        }
        if (this.f1673h.mo400h(655364, "NNFWarmStart")) {
            return "NNFWarm" + str;
        }
        if (!this.f1674i.mo460a(m3340e(feedType))) {
            return "NNFOther" + str;
        }
        if (feedType.equals(this.f1681p.m4200a())) {
            return "NNFNavigate" + str;
        }
        return "NNFNavigateOther" + str;
    }

    public final int m3360d(FeedType feedType) {
        if (this.f1673h.mo400h(655361, "NNFColdStart")) {
            return 655476;
        }
        if (this.f1673h.mo400h(655364, "NNFWarmStart")) {
            return 655477;
        }
        if (!this.f1674i.mo460a(m3340e(feedType))) {
            return 655480;
        }
        if (feedType.equals(this.f1681p.m4200a())) {
            return 655478;
        }
        return 655479;
    }

    private void m3338b(String str, FeedType feedType) {
        if (this.f1673h.mo400h(655361, "NNFColdStart")) {
            this.f1675j.m3446c(655476, "NNFCold" + str);
        } else if (this.f1673h.mo400h(655364, "NNFWarmStart")) {
            this.f1675j.m3456f(655477, "NNFWarm" + str);
        } else {
            String str2;
            int i;
            if (!this.f1674i.mo460a(m3340e(feedType))) {
                str2 = "NNFOther" + str;
                i = 655480;
            } else if (feedType.equals(this.f1681p.m4200a())) {
                str2 = "NNFNavigate" + str;
                i = 655478;
            } else {
                str2 = "NNFNavigateOther" + str;
                i = 655479;
            }
            this.f1675j.m3459i(i, str2);
        }
    }

    private void m3327a(int i, String str) {
        this.f1673h.mo397f(i, str);
    }

    private void m3336b(int i, String str) {
        this.f1673h.mo389c(i, str);
    }

    private boolean m3311E() {
        return m3312F() || this.f1673h.mo400h(655392, "NNFColdStartAndRenderTime") || this.f1673h.mo400h(655420, "NNFColdStartChromeLoadTime") || this.f1673h.mo400h(655361, "NNFColdStart") || this.f1673h.mo400h(655379, "NNFWarmStartTTI") || this.f1673h.mo400h(655395, "NNFWarmStartAndRenderTime") || this.f1673h.mo400h(655396, "NNFWarmStartAndFreshRenderTime") || this.f1673h.mo400h(655397, "NNFWarmStartAndCachedRenderTime") || this.f1673h.mo400h(655364, "NNFWarmStart") || this.f1673h.mo400h(655403, "NNFHotStartAndRenderTime") || this.f1674i.mo460a(655386) || this.f1674i.mo460a(2293779);
    }

    private boolean m3312F() {
        return this.f1675j.m3453d();
    }

    private void m3328a(int i, String str, long j) {
        if (m3319M()) {
            this.f1675j.m3460j(i, str);
        } else {
            this.f1675j.m3447c(i, str, j);
        }
    }

    private void m3339c(int i, String str) {
        if (m3319M()) {
            this.f1675j.m3460j(i, str);
        } else {
            this.f1675j.m3454e(i, str);
        }
    }

    private void m3332a(MarkerConfig markerConfig) {
        if (m3319M()) {
            this.f1675j.m3444b(markerConfig);
            return;
        }
        StartupPerfLogger startupPerfLogger = this.f1675j;
        if (startupPerfLogger.f1718e) {
            if (startupPerfLogger.m3453d()) {
                startupPerfLogger.f1716c.mo398f(markerConfig);
            }
            return;
        }
        startupPerfLogger.f1716c.mo387b(markerConfig);
    }

    private void m3313G() {
        if (this.f1673h.mo400h(655382, "NNFColdStartTTI") && m3324R()) {
            ClassMarkerLoader.loadClass("com.facebook.common.classmarkers.IsColdStartTTIRun");
        }
        m3332a(new MarkerConfig(655382, "NNFColdStartTTI").m3386a("coldStartFinishReason", m3316J()));
    }

    private void m3314H() {
        m3332a(new MarkerConfig(655501, "NNFColdStartTTILegacy").m3386a("coldStartFinishReason", m3316J()));
    }

    private void m3315I() {
        if (!this.f1691z) {
            this.f1675j.m3444b(m3317K());
        } else if (!this.f1661A) {
            MarkerConfig K = m3317K();
            K.m3386a("coldStartFinishReason", m3316J());
            m3332a(K);
            this.f1661A = true;
        }
    }

    private String m3316J() {
        switch (1.a[this.f1690y.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "D_Fresh";
            case 3:
                return "D_Cached";
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return "A_CachedUnseen";
            case 5:
                return "A_FreshSeenCache";
            case 6:
                return "A_FreshNoCache";
            case 7:
                return "A_FreshFastNetwork";
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return "F_Network";
            case 9:
                return "F_Cache";
            default:
                return "UK";
        }
    }

    private void m3331a(ColdStartStoryStatus coldStartStoryStatus) {
        if (this.f1690y == ColdStartStoryStatus.NOT_SET) {
            this.f1690y = coldStartStoryStatus;
        }
    }

    private static MarkerConfig m3317K() {
        return new MarkerConfig(655382, "NNFColdStartAsyncTTI");
    }

    private boolean m3318L() {
        return this.f1673h.mo400h(655392, "NNFColdStartAndRenderTime") || this.f1673h.mo400h(655361, "NNFColdStart");
    }

    private boolean m3319M() {
        return this.f1688w || this.f1679n.f1134U || this.f1679n.f1135V;
    }

    public final long m3377v() {
        return this.f1677l.now() - this.f1665E;
    }

    public final long m3378w() {
        return this.f1677l.now() - this.f1664D;
    }

    public static String m3342x() {
        return TabTag.Feed.analyticsTag;
    }

    private void m3320N() {
        if (m3319M() && this.f1668H.getAndSet(false)) {
            ClassMarkerLoader.loadIsNotColdStartRunMarker();
        }
    }

    private void m3321O() {
        if (this.f1668H.getAndSet(false)) {
            this.f1669I = false;
            this.f1670J = false;
            ClassMarkerLoader.loadIsNotColdStartRunMarker();
        }
    }

    private void m3322P() {
        if (this.f1668H.get() && m3324R()) {
            this.f1669I = true;
            m3325S();
        }
    }

    private void m3323Q() {
        if (this.f1668H.get() && m3324R()) {
            this.f1670J = true;
            m3325S();
        }
    }

    private boolean m3324R() {
        if (this.f1679n.m2263k() == TriState.YES) {
            m3333a("Class List Generation: Cancelling: App Started in background.");
            return false;
        } else if (!this.f1679n.m2262j()) {
            return true;
        } else {
            m3333a("Class List Generation: Cancelling: App is in the background.");
            return false;
        }
    }

    private void m3325S() {
        if (this.f1669I && this.f1670J && this.f1668H.getAndSet(false)) {
            ClassMarkerLoader.loadIsColdStartRunMarker();
            this.f1669I = false;
            this.f1670J = false;
        }
    }

    private void m3333a(String str) {
        if (this.f1668H.getAndSet(false)) {
            ClassMarkerLoader.loadIsNotColdStartRunMarker();
        }
    }
}
