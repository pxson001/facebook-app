package com.facebook.resources;

import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsConfig;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.locale.FBLocaleMapper;
import com.facebook.common.locale.Locales;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: value_reuse_ */
public class FbResourcesUsageLogger {
    private static volatile FbResourcesUsageLogger f1311g;
    @GuardedBy("this")
    private int f1312a = 0;
    private Locale f1313b = null;
    @GuardedBy("this")
    private final HashMap<Long, Long> f1314c = Maps.m838c();
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<AnalyticsLogger> f1315d = UltralightRuntime.f368b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<AnalyticsConfig> f1316e = UltralightRuntime.f368b;
    private final Locales f1317f;

    public static com.facebook.resources.FbResourcesUsageLogger m2557a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1311g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.resources.FbResourcesUsageLogger.class;
        monitor-enter(r1);
        r0 = f1311g;	 Catch:{ all -> 0x003a }
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
        r0 = m2560b(r0);	 Catch:{ all -> 0x0035 }
        f1311g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1311g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.resources.FbResourcesUsageLogger.a(com.facebook.inject.InjectorLike):com.facebook.resources.FbResourcesUsageLogger");
    }

    private static FbResourcesUsageLogger m2560b(InjectorLike injectorLike) {
        FbResourcesUsageLogger fbResourcesUsageLogger = new FbResourcesUsageLogger(Locales.m2604a(injectorLike));
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.m1810b(injectorLike, 175);
        com.facebook.inject.Lazy b2 = IdBasedSingletonScopeProvider.m1810b(injectorLike, 2406);
        fbResourcesUsageLogger.f1315d = b;
        fbResourcesUsageLogger.f1316e = b2;
        return fbResourcesUsageLogger;
    }

    @Inject
    public FbResourcesUsageLogger(Locales locales) {
        this.f1317f = locales;
    }

    private synchronized void m2559a(long j) {
        long j2 = 0;
        if (this.f1314c.containsKey(Long.valueOf(j))) {
            j2 = ((Long) this.f1314c.get(Long.valueOf(j))).longValue();
        }
        this.f1314c.put(Long.valueOf(j), Long.valueOf(j2 + 1));
        this.f1312a++;
    }

    private synchronized void m2558a() {
        if (!(this.f1312a == 0 || this.f1313b == null)) {
            HoneyClientEventFast a = ((AnalyticsLogger) this.f1315d.get()).mo535a("fbt_string_batch", false);
            if (a.m17388a()) {
                a.m17385a("locale", FBLocaleMapper.m9532a(this.f1317f.m2610a(this.f1313b)));
                for (Entry entry : this.f1314c.entrySet()) {
                    a.m17384a("string_" + entry.getKey(), entry.getValue());
                }
                a.m17390b();
            }
            this.f1314c.clear();
            this.f1312a = 0;
        }
    }

    public final synchronized void m2561a(long j, Locale locale) {
        if (((BaseAnalyticsConfig) this.f1316e.get()).m3563a("fbt_string_batch")) {
            if (locale != this.f1313b) {
                m2558a();
                this.f1313b = locale;
            }
            m2559a(j);
            if (this.f1312a >= 50) {
                m2558a();
            }
        }
    }
}
