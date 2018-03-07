package com.facebook.analytics.throttling;

import android.util.SparseArray;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.common.executors.ExecutorService_AnalyticsThreadExecutorMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: updateMessagingFavorites */
public class AnalyticsHighEventsRateReporter {
    public static final Class<?> f499a = AnalyticsHighEventsRateReporter.class;
    private static volatile AnalyticsHighEventsRateReporter f500h;
    public final MonotonicClock f501b;
    public final Executor f502c;
    @GuardedBy("mCleanupSync")
    public final SparseArray<RateTracker> f503d;
    public final CleanupRunnable f504e;
    public final Object f505f = new Object();
    public long f506g = 0;

    /* compiled from: updateMessagingFavorites */
    class CleanupRunnable implements Runnable {
        final /* synthetic */ AnalyticsHighEventsRateReporter f507a;

        public CleanupRunnable(AnalyticsHighEventsRateReporter analyticsHighEventsRateReporter) {
            this.f507a = analyticsHighEventsRateReporter;
        }

        public void run() {
            synchronized (this.f507a.f505f) {
                long now = this.f507a.f501b.now();
                for (int i = 0; i < this.f507a.f503d.size(); i++) {
                    int keyAt = this.f507a.f503d.keyAt(i);
                    if (this.f507a.f503d.get(keyAt) != null && ((RateTracker) this.f507a.f503d.get(keyAt)).b(now) <= 0.0d) {
                        this.f507a.f503d.remove(keyAt);
                    }
                }
            }
        }
    }

    public static com.facebook.analytics.throttling.AnalyticsHighEventsRateReporter m797a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f500h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.throttling.AnalyticsHighEventsRateReporter.class;
        monitor-enter(r1);
        r0 = f500h;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m800b(r0);	 Catch:{ all -> 0x0035 }
        f500h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f500h;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.throttling.AnalyticsHighEventsRateReporter.a(com.facebook.inject.InjectorLike):com.facebook.analytics.throttling.AnalyticsHighEventsRateReporter");
    }

    private static AnalyticsHighEventsRateReporter m800b(InjectorLike injectorLike) {
        return new AnalyticsHighEventsRateReporter((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), ExecutorService_AnalyticsThreadExecutorMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AnalyticsHighEventsRateReporter(MonotonicClock monotonicClock, ExecutorService executorService) {
        this.f501b = monotonicClock;
        this.f502c = executorService;
        this.f503d = new SparseArray();
        this.f504e = new CleanupRunnable(this);
        this.f506g = this.f501b.now();
    }

    public final void m801a(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        if (honeyAnalyticsEvent == null) {
            BLog.a(f499a, "Got null event in maybeLogWarning()");
            return;
        }
        if (m798a(m799b(honeyAnalyticsEvent))) {
            BLog.a(f499a, "Too many events logged for this type: %s. Current Rate: %.2f events/min. See fburl.com/12412193 for how to address this.", new Object[]{honeyAnalyticsEvent.toString(), Double.valueOf(r0)});
        }
        long now = this.f501b.now();
        if (now - this.f506g > 180000) {
            this.f506g = now;
            ExecutorDetour.a(this.f502c, this.f504e, 1094573999);
        }
    }

    @VisibleForTesting
    private static boolean m798a(double d) {
        return d > 5.0d;
    }

    @VisibleForTesting
    private double m799b(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        double a;
        synchronized (this.f505f) {
            RateTracker rateTracker = (RateTracker) this.f503d.get(honeyAnalyticsEvent.hashCode());
            if (rateTracker == null) {
                rateTracker = new RateTracker(honeyAnalyticsEvent.a());
                this.f503d.put(honeyAnalyticsEvent.hashCode(), rateTracker);
            }
            a = rateTracker.a(honeyAnalyticsEvent.a());
            if (a > 5.0d) {
                this.f503d.remove(honeyAnalyticsEvent.hashCode());
            }
        }
        return a;
    }
}
