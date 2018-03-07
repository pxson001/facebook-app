package com.facebook.imagepipeline.instrumentation;

import com.facebook.analytics.counter.CountersPrefWriterMethodAutoProvider;
import com.facebook.analytics.counter.SimpleAnalyticsCounters;
import com.facebook.analytics.counter.SimpleAnalyticsCountersProvider;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: oxygen_map */
public class DefaultImageCacheStatsTracker implements ImageCacheStatsTracker {
    private static final Runtime f10637a = Runtime.getRuntime();
    private static volatile DefaultImageCacheStatsTracker f10638h;
    @GuardedBy("this")
    private final SimpleAnalyticsCounters f10639b;
    @GuardedBy("this")
    private List<JsonNode> f10640c = Lists.m1306b();
    private final Clock f10641d;
    @GuardedBy("this")
    private long f10642e;
    @GuardedBy("this")
    private CountingMemoryCache<?, ?> f10643f;
    @GuardedBy("this")
    private CountingMemoryCache<?, ?> f10644g;

    public static com.facebook.imagepipeline.instrumentation.DefaultImageCacheStatsTracker m15878a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10638h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.imagepipeline.instrumentation.DefaultImageCacheStatsTracker.class;
        monitor-enter(r1);
        r0 = f10638h;	 Catch:{ all -> 0x003a }
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
        r0 = m15879b(r0);	 Catch:{ all -> 0x0035 }
        f10638h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10638h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.instrumentation.DefaultImageCacheStatsTracker.a(com.facebook.inject.InjectorLike):com.facebook.imagepipeline.instrumentation.DefaultImageCacheStatsTracker");
    }

    private static DefaultImageCacheStatsTracker m15879b(InjectorLike injectorLike) {
        return new DefaultImageCacheStatsTracker((SimpleAnalyticsCountersProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SimpleAnalyticsCountersProvider.class), SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    @Inject
    public DefaultImageCacheStatsTracker(SimpleAnalyticsCountersProvider simpleAnalyticsCountersProvider, Clock clock) {
        this.f10639b = new SimpleAnalyticsCounters(CountersPrefWriterMethodAutoProvider.m2777a(simpleAnalyticsCountersProvider), "image_cache_stats_counter");
        this.f10641d = clock;
    }

    public final synchronized void mo2042a(CountingMemoryCache<?, ?> countingMemoryCache) {
        this.f10643f = countingMemoryCache;
    }

    public final synchronized void mo2044b(CountingMemoryCache<?, ?> countingMemoryCache) {
        this.f10644g = countingMemoryCache;
    }

    public final synchronized void m15885a(HoneyClientEvent honeyClientEvent) {
        if (!this.f10640c.isEmpty()) {
            honeyClientEvent.m5086a("image_cache_stats_counter", this.f10640c);
            this.f10640c.clear();
        }
    }

    public final void mo2041a() {
        m15880l();
        synchronized (this) {
            this.f10639b.m2591a("bitmap_cache_put", 1);
        }
    }

    public final void mo2043b() {
        m15880l();
        synchronized (this) {
            this.f10639b.m2591a("bitmap_cache_hit", 1);
        }
    }

    public final void mo2045c() {
        m15880l();
        synchronized (this) {
            this.f10639b.m2591a("bitmap_cache_miss", 1);
        }
    }

    public final void mo2046d() {
        m15880l();
        synchronized (this) {
            this.f10639b.m2591a("memory_cache_put", 1);
        }
    }

    public final void mo2047e() {
        m15880l();
        synchronized (this) {
            this.f10639b.m2591a("memory_cache_hit", 1);
        }
    }

    public final void mo2048f() {
        m15880l();
        synchronized (this) {
            this.f10639b.m2591a("memory_cache_miss", 1);
        }
    }

    public final void mo2049g() {
        m15880l();
        synchronized (this) {
            this.f10639b.m2591a("staging_area_hit", 1);
        }
    }

    public final void mo2050h() {
        m15880l();
        synchronized (this) {
            this.f10639b.m2591a("staging_area_miss", 1);
        }
    }

    public final void mo2052j() {
        m15880l();
        synchronized (this) {
            this.f10639b.m2591a("disk_cache_miss", 1);
        }
    }

    public final void mo2051i() {
        m15880l();
        synchronized (this) {
            this.f10639b.m2591a("disk_cache_hit", 1);
        }
    }

    public final void mo2053k() {
        m15880l();
        synchronized (this) {
            this.f10639b.m2591a("disk_cache_get_fail", 1);
        }
    }

    private void m15880l() {
        synchronized (this) {
            if (this.f10641d.mo211a() - this.f10642e <= 300000) {
                return;
            }
            this.f10642e = this.f10641d.mo211a();
            m15881m();
            m15882n();
            m15883o();
            this.f10640c.add(this.f10639b.m2593c());
            this.f10639b.al_();
        }
    }

    private synchronized void m15881m() {
        if (this.f10643f != null) {
            this.f10639b.m2592b("bitmap_memory_cache_entries", (long) this.f10643f.m16143b());
            this.f10639b.m2592b("bitmap_memory_cache_size", (long) this.f10643f.m16145c());
            this.f10639b.m2592b("bitmap_memory_cache_lru_entries", (long) this.f10643f.m16146d());
            this.f10639b.m2592b("bitmap_memory_cache_lru_size", (long) this.f10643f.m16147e());
        }
    }

    private synchronized void m15882n() {
        if (this.f10644g != null) {
            this.f10639b.m2592b("memory_cache_entries", (long) this.f10644g.m16143b());
            this.f10639b.m2592b("memory_cache_size", (long) this.f10644g.m16145c());
            this.f10639b.m2592b("memory_cache_lru_entries", (long) this.f10644g.m16146d());
            this.f10639b.m2592b("memory_cache_lru_size", (long) this.f10644g.m16147e());
        }
    }

    private synchronized void m15883o() {
        this.f10639b.m2592b("memory_usage", f10637a.totalMemory() - f10637a.freeMemory());
    }
}
