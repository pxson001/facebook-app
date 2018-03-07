package com.facebook.feed.pulltorefresh;

import android.os.Handler;
import android.util.Pair;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.xconfig.BackToBackPTRXConfig;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.xconfig.core.XConfigReader;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: offers/detail/view/?offer_view_id=%s&share_id=%s&notif_trigger=%s&notif_medium=%s&rule=%s */
public class PullToRefreshLogger {
    private static volatile PullToRefreshLogger f11566v;
    public boolean f11567a = false;
    public long f11568b = 0;
    public long f11569c = 0;
    public long f11570d = 0;
    public long f11571e = 0;
    public long f11572f = 0;
    public long f11573g = 0;
    public long f11574h = 0;
    public long f11575i = 0;
    public int f11576j = 0;
    public int f11577k = 0;
    public int f11578l = 0;
    public final Clock f11579m;
    private final AnalyticsLogger f11580n;
    public final ScrollStateManager f11581o;
    public final Handler f11582p = new Handler();
    public final Runnable f11583q = new C04811(this);
    public final Runnable f11584r = new C04822(this);
    private final XConfigReader f11585s;
    public boolean f11586t = false;
    public boolean f11587u = false;

    /* compiled from: offers/detail/view/?offer_view_id=%s&share_id=%s&notif_trigger=%s&notif_medium=%s&rule=%s */
    class C04811 implements Runnable {
        final /* synthetic */ PullToRefreshLogger f11592a;

        C04811(PullToRefreshLogger pullToRefreshLogger) {
            this.f11592a = pullToRefreshLogger;
        }

        public void run() {
            PullToRefreshLogger.m16883a(this.f11592a, "ptr_scroll_without_ptr");
            this.f11592a.f11586t = false;
        }
    }

    /* compiled from: offers/detail/view/?offer_view_id=%s&share_id=%s&notif_trigger=%s&notif_medium=%s&rule=%s */
    class C04822 implements Runnable {
        final /* synthetic */ PullToRefreshLogger f11593a;

        C04822(PullToRefreshLogger pullToRefreshLogger) {
            this.f11593a = pullToRefreshLogger;
        }

        public void run() {
            PullToRefreshLogger.m16883a(this.f11593a, "ptr_jump_without_ptr");
            this.f11593a.f11587u = false;
        }
    }

    public static com.facebook.feed.pulltorefresh.PullToRefreshLogger m16882a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11566v;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.pulltorefresh.PullToRefreshLogger.class;
        monitor-enter(r1);
        r0 = f11566v;	 Catch:{ all -> 0x003a }
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
        r0 = m16884b(r0);	 Catch:{ all -> 0x0035 }
        f11566v = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11566v;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.pulltorefresh.PullToRefreshLogger.a(com.facebook.inject.InjectorLike):com.facebook.feed.pulltorefresh.PullToRefreshLogger");
    }

    private static PullToRefreshLogger m16884b(InjectorLike injectorLike) {
        return new PullToRefreshLogger(SystemClockMethodAutoProvider.m1498a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), ScrollStateManager.m16891a(injectorLike), XConfigReader.m2681a(injectorLike));
    }

    @Inject
    public PullToRefreshLogger(Clock clock, AnalyticsLogger analyticsLogger, ScrollStateManager scrollStateManager, XConfigReader xConfigReader) {
        this.f11579m = clock;
        this.f11580n = analyticsLogger;
        this.f11581o = scrollStateManager;
        this.f11585s = xConfigReader;
    }

    public final long m16887c() {
        return this.f11569c;
    }

    public final void m16885a(int i) {
        this.f11573g = this.f11570d;
        this.f11570d = this.f11579m.mo211a();
        this.f11576j = i;
    }

    public final void m16888d() {
        this.f11575i = this.f11579m.mo211a();
    }

    public final void m16889e() {
        if (this.f11586t && this.f11567a) {
            HandlerDetour.a(this.f11582p, this.f11583q);
            this.f11586t = false;
            m16883a(this, "ptr_scroll_then_ptr");
        }
        if (this.f11587u && this.f11567a) {
            HandlerDetour.a(this.f11582p, this.f11584r);
            this.f11587u = false;
            m16883a(this, "ptr_jump_then_ptr");
        }
        if (this.f11567a && this.f11568b - this.f11571e < 5000) {
            m16883a(this, "ptr_back_to_back_ptr");
        }
        m16883a(this, this.f11567a ? "ptr_manual_refresh" : "ptr_auto_refresh");
    }

    public final boolean m16890f() {
        if (this.f11579m.mo211a() - this.f11568b < this.f11585s.m2684a(BackToBackPTRXConfig.c, 5000)) {
            return true;
        }
        return false;
    }

    public static void m16883a(PullToRefreshLogger pullToRefreshLogger, String str) {
        HoneyClientEventFast a = pullToRefreshLogger.f11580n.mo535a(str, false);
        if (a.m17388a()) {
            if (pullToRefreshLogger.f11568b > 0) {
                a.m17382a("time_elapsed_since_manual_refresh", pullToRefreshLogger.f11568b - pullToRefreshLogger.f11571e);
            }
            if (pullToRefreshLogger.f11569c > 0) {
                a.m17382a("time_elapsed_since_fetch_attempt", pullToRefreshLogger.f11569c - pullToRefreshLogger.f11572f);
                a.m17382a("time_elapsed_current_fetch_attempt", pullToRefreshLogger.f11579m.mo211a() - pullToRefreshLogger.f11569c);
            }
            if (pullToRefreshLogger.f11570d > 0) {
                a.m17382a("time_elapsed_since_fetch_result", pullToRefreshLogger.f11570d - pullToRefreshLogger.f11573g);
                a.m17381a("num_stories_fetched_in_last_result", pullToRefreshLogger.f11576j);
            }
            if (pullToRefreshLogger.f11574h > 0) {
                a.m17382a("time_elapsed_since_scroll_to_top", pullToRefreshLogger.f11579m.mo211a() - pullToRefreshLogger.f11574h);
            }
            if (pullToRefreshLogger.f11575i > 0) {
                a.m17382a("time_elapsed_since_newsfeed_fragment_active", pullToRefreshLogger.f11579m.mo211a() - pullToRefreshLogger.f11575i);
            }
            a.m17381a("num_server_unseen_bumped_stories_in_last_result", pullToRefreshLogger.f11577k);
            a.m17381a("num_client_unseen_stories_in_last_result", pullToRefreshLogger.f11578l);
            a.m17379a("android_pull_to_refresh");
            a.m17390b();
        }
    }

    public final void m16886a(Pair<Integer, Integer> pair) {
        this.f11577k = ((Integer) pair.first).intValue();
        this.f11578l = ((Integer) pair.second).intValue();
    }
}
