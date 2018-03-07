package com.facebook.analytics;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: t_sp */
public class ClientEventGenerator {
    private static volatile ClientEventGenerator f3443f;
    private final Clock f3444a;
    private final Lazy<ClientPeriodicEventReporterManager> f3445b;
    private final Lazy<AnalyticsBeaconGenerator> f3446c;
    private int f3447d = -1;
    private int f3448e = -1;

    public static com.facebook.analytics.ClientEventGenerator m5657a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3443f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.ClientEventGenerator.class;
        monitor-enter(r1);
        r0 = f3443f;	 Catch:{ all -> 0x003a }
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
        r0 = m5658b(r0);	 Catch:{ all -> 0x0035 }
        f3443f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3443f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.ClientEventGenerator.a(com.facebook.inject.InjectorLike):com.facebook.analytics.ClientEventGenerator");
    }

    private static ClientEventGenerator m5658b(InjectorLike injectorLike) {
        return new ClientEventGenerator(SystemClockMethodAutoProvider.m1498a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 125), IdBasedSingletonScopeProvider.m1810b(injectorLike, 117));
    }

    @Inject
    public ClientEventGenerator(Clock clock, Lazy<ClientPeriodicEventReporterManager> lazy, Lazy<AnalyticsBeaconGenerator> lazy2) {
        this.f3444a = clock;
        this.f3445b = lazy;
        this.f3446c = lazy2;
    }

    @Nullable
    public final List<HoneyAnalyticsEvent> m5660a() {
        return ((ClientPeriodicEventReporterManager) this.f3445b.get()).m5672a(this.f3444a.mo211a());
    }

    @Nullable
    public final List<HoneyAnalyticsEvent> m5661a(int i) {
        List<HoneyAnalyticsEvent> list = null;
        try {
            HoneyAnalyticsEvent b = m5659b(i);
            if (b != null) {
                list = ImmutableList.of(b);
            }
        } catch (IllegalArgumentException e) {
            if (e.getMessage().contains("Unknown URL")) {
                BLog.a("ClientEventGenerator", "Ignoring early beacon generation: " + e);
            } else {
                throw e;
            }
        }
        return list;
    }

    @Nullable
    private HoneyAnalyticsEvent m5659b(int i) {
        if (i == 1) {
            this.f3447d++;
            if (this.f3447d % 11 == 0) {
                return ((AnalyticsBeaconGenerator) this.f3446c.get()).a();
            }
        }
        this.f3448e++;
        if (this.f3448e % 97 == 0) {
            return ((AnalyticsBeaconGenerator) this.f3446c.get()).b();
        }
        return null;
    }
}
