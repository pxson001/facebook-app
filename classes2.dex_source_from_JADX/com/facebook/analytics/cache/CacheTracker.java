package com.facebook.analytics.cache;

import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.logger.AnalyticsConfig$Level;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheEventListener.EvictionReason;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: set_final_result @ onNewResult */
public class CacheTracker implements CacheEventListener {
    private final CacheCounters f5401a;
    private final String f5402b;
    private final BaseAnalyticsConfig f5403c;
    private final MonotonicClock f5404d;
    private final ThreadLocal<Long> f5405e = new ThreadLocal();
    @GuardedBy("this")
    private final Map<CacheCounterType, String> f5406f = Maps.m838c();

    @Singleton
    /* compiled from: set_final_result @ onNewResult */
    public class Factory {
        private static volatile Factory f5291d;
        private CacheCounters f5292a;
        private BaseAnalyticsConfig f5293b;
        private MonotonicClock f5294c;

        public static com.facebook.analytics.cache.CacheTracker.Factory m9186a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = f5291d;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.analytics.cache.CacheTracker.Factory.class;
            monitor-enter(r1);
            r0 = f5291d;	 Catch:{ all -> 0x003a }
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
            r0 = m9187b(r0);	 Catch:{ all -> 0x0035 }
            f5291d = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.m1338a(r4);
            r2.m1505c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f5291d;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.cache.CacheTracker.Factory.a(com.facebook.inject.InjectorLike):com.facebook.analytics.cache.CacheTracker$Factory");
        }

        private static Factory m9187b(InjectorLike injectorLike) {
            return new Factory(CacheCounters.m9189a(injectorLike), FbAnalyticsConfig.m3559a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
        }

        @Inject
        public Factory(CacheCounters cacheCounters, BaseAnalyticsConfig baseAnalyticsConfig, MonotonicClock monotonicClock) {
            this.f5292a = cacheCounters;
            this.f5293b = baseAnalyticsConfig;
            this.f5294c = monotonicClock;
        }

        public final CacheTracker m9188a(String str) {
            return new CacheTracker(this.f5292a, str, this.f5293b, this.f5294c);
        }
    }

    public CacheTracker(CacheCounters cacheCounters, String str, BaseAnalyticsConfig baseAnalyticsConfig, MonotonicClock monotonicClock) {
        this.f5401a = cacheCounters;
        this.f5402b = str;
        this.f5403c = baseAnalyticsConfig;
        this.f5404d = monotonicClock;
    }

    private String m9297g() {
        return this.f5402b;
    }

    public final synchronized String m9300a(CacheCounterType cacheCounterType) {
        if (!this.f5406f.containsKey(cacheCounterType)) {
            this.f5406f.put(cacheCounterType, m9297g() + "_" + cacheCounterType.toString());
        }
        return (String) this.f5406f.get(cacheCounterType);
    }

    private void m9294a(CacheCounterType cacheCounterType, long j) {
        if (m9299i()) {
            this.f5401a.m2591a(m9300a(cacheCounterType), j);
        }
    }

    private void m9296b(CacheCounterType cacheCounterType, long j) {
        if (m9299i()) {
            this.f5401a.m2592b(m9300a(cacheCounterType), j);
        }
    }

    public final void m9312f() {
        this.f5405e.set(Long.valueOf(this.f5404d.now()));
    }

    private void m9298h() {
        this.f5405e.remove();
    }

    public final void m9302a(long j) {
        m9294a(CacheCounterType.HITS_COUNT, j);
    }

    public final void mo1343a() {
        m9295b(CacheCounterType.HIT_TIME_MS);
        m9302a(1);
    }

    private void m9295b(CacheCounterType cacheCounterType) {
        long now = this.f5404d.now();
        Long l = (Long) this.f5405e.get();
        if (l != null && l.longValue() > 0) {
            m9294a(cacheCounterType, now - l.longValue());
            m9298h();
        }
    }

    public final void m9305b(long j) {
        m9294a(CacheCounterType.MISSES_COUNT, j);
    }

    public final void mo1345b() {
        m9305b(1);
        m9298h();
    }

    public final void mo1344a(EvictionReason evictionReason, int i, long j) {
        switch (1.a[evictionReason.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                m9294a(CacheCounterType.EVICTIONS_ON_CACHE_FULL_CALL, 1);
                m9294a(CacheCounterType.EVICTIONS_ON_CACHE_FULL_ITEM, (long) i);
                m9294a(CacheCounterType.EVICTIONS_ON_CACHE_FULL_SIZE, j);
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                m9294a(CacheCounterType.EVICTIONS_ON_CONTENT_STALE_CALL, 1);
                m9294a(CacheCounterType.EVICTIONS_ON_CONTENT_STALE_ITEM, (long) i);
                m9294a(CacheCounterType.EVICTIONS_ON_CONTENT_STALE_SIZE, j);
                return;
            case 3:
                m9294a(CacheCounterType.EVICTIONS_ON_USER_FORCED_CALL, 1);
                m9294a(CacheCounterType.EVICTIONS_ON_USER_FORCED_ITEM, (long) i);
                m9294a(CacheCounterType.EVICTIONS_ON_USER_FORCED_SIZE, j);
                return;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                m9294a(CacheCounterType.EVICTIONS_ON_CACHE_MANAGER_TRIMMED_CALL, 1);
                m9294a(CacheCounterType.EVICTIONS_ON_CACHE_MANAGER_TRIMMED_ITEM, (long) i);
                m9294a(CacheCounterType.EVICTIONS_ON_CACHE_MANAGER_TRIMMED_SIZE, j);
                return;
            default:
                return;
        }
    }

    public final void m9307c(long j) {
        m9296b(CacheCounterType.BYTES_COUNT, j);
    }

    public final void m9309d(long j) {
        m9296b(CacheCounterType.ENTRIES_COUNT, j);
    }

    public final void m9311e(long j) {
        m9295b(CacheCounterType.INSERTION_TIME_MS);
        m9294a(CacheCounterType.INSERTION_ITEM, 1);
        m9294a(CacheCounterType.INSERTION_SIZE, j);
    }

    public final void mo1348e() {
        m9294a(CacheCounterType.WRITE_EXCEPTION_COUNT, 1);
    }

    public final void mo1346c() {
        m9294a(CacheCounterType.WRITE_ATTEMPTS, 1);
    }

    public final void mo1347d() {
        m9294a(CacheCounterType.READ_EXCEPTION_COUNT, 1);
    }

    private boolean m9299i() {
        return this.f5403c.m3562a() == AnalyticsConfig$Level.CORE_AND_SAMPLED;
    }
}
