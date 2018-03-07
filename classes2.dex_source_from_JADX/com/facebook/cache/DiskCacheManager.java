package com.facebook.cache;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.file.StatFsHelperMethodAutoProvider;
import com.facebook.common.ratelimiter.RateLimiter;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.device.resourcemonitor.ResourceManager;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.annotations.VisibleForTesting;
import java.util.Map;
import java.util.WeakHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: set_contact_logs_upload_setting */
public class DiskCacheManager implements DiskTrimmableRegistry {
    private static final Class<?> f5296b = DiskCacheManager.class;
    private static volatile DiskCacheManager f5297j;
    C02571 f5298a = new C02571(this);
    private final Map<DiskTrimmable, Boolean> f5299c = new WeakHashMap();
    private long f5300d = 0;
    private final Clock f5301e;
    private final StatFsHelper f5302f;
    private final RateLimiter f5303g;
    private final AnalyticsLogger f5304h;
    private final BaseAnalyticsConfig f5305i;

    /* compiled from: set_contact_logs_upload_setting */
    public class C02571 {
        public final /* synthetic */ DiskCacheManager f5380a;

        C02571(DiskCacheManager diskCacheManager) {
            this.f5380a = diskCacheManager;
        }
    }

    public static com.facebook.cache.DiskCacheManager m9192a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5297j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.cache.DiskCacheManager.class;
        monitor-enter(r1);
        r0 = f5297j;	 Catch:{ all -> 0x003a }
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
        r0 = m9194b(r0);	 Catch:{ all -> 0x0035 }
        f5297j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5297j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.DiskCacheManager.a(com.facebook.inject.InjectorLike):com.facebook.cache.DiskCacheManager");
    }

    private static DiskCacheManager m9194b(InjectorLike injectorLike) {
        return new DiskCacheManager(ResourceManager.m9199a(injectorLike), StatFsHelperMethodAutoProvider.m2307a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), FbAnalyticsConfig.m3559a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    @Inject
    public DiskCacheManager(ResourceManager resourceManager, StatFsHelper statFsHelper, AnalyticsLogger analyticsLogger, BaseAnalyticsConfig baseAnalyticsConfig, Clock clock) {
        resourceManager.f5322h.put(this.f5298a, Integer.valueOf(1));
        this.f5301e = clock;
        this.f5302f = statFsHelper;
        this.f5303g = new RateLimiter(this.f5301e, 2, 3600000);
        this.f5304h = analyticsLogger;
        this.f5305i = baseAnalyticsConfig;
    }

    public final void mo1325a(DiskTrimmable diskTrimmable) {
        this.f5299c.put(diskTrimmable, Boolean.valueOf(true));
    }

    @VisibleForTesting
    public final void m9195a(long j) {
        if (j < 204800) {
            long a = this.f5301e.mo211a();
            if (a - this.f5300d > 300000) {
                this.f5300d = a;
                for (DiskTrimmable b : this.f5299c.keySet()) {
                    try {
                        b.mo1323b();
                    } catch (Exception e) {
                        BLog.a(f5296b, e.toString());
                    }
                }
                this.f5302f.m2316b();
                m9193a(j, "trimToNothing");
                return;
            }
        }
        for (DiskTrimmable b2 : this.f5299c.keySet()) {
            try {
                b2.ai_();
            } catch (Exception e2) {
                BLog.a(f5296b, e2.toString());
            }
        }
        this.f5302f.m2316b();
        m9193a(j, "trimToMinimum");
    }

    private void m9193a(long j, String str) {
        if (this.f5303g.m9265a() && this.f5305i.m3563a("disk_cache_trim")) {
            long a = this.f5302f.m2314a(StorageType.INTERNAL);
            HoneyClientEventFast a2 = this.f5304h.mo535a("disk_cache_trim", false);
            if (a2.m17388a()) {
                a2.m17382a("before", j);
                a2.m17382a("after", a);
                a2.m17385a("call", str);
                JsonNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
                for (DiskTrimmable diskTrimmable : this.f5299c.keySet()) {
                    arrayNode.m13394h(diskTrimmable.getClass().getSimpleName());
                }
                a2.m17383a("caches", arrayNode);
                a2.m17390b();
            }
        }
    }
}
