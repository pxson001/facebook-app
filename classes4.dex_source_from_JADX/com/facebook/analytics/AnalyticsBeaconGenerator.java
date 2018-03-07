package com.facebook.analytics;

import com.facebook.analytics.db.AnalyticsDbProperties;
import com.facebook.analytics.db.AnalyticsPropertyUtil;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: time_skew_event */
public class AnalyticsBeaconGenerator {
    private static volatile AnalyticsBeaconGenerator f1024g;
    public int f1025a = -1;
    public int f1026b = -1;
    public int f1027c = -1;
    private AnalyticsLogger f1028d;
    public final AnalyticsPropertyUtil f1029e;
    private final Clock f1030f;

    public static com.facebook.analytics.AnalyticsBeaconGenerator m1335a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1024g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.AnalyticsBeaconGenerator.class;
        monitor-enter(r1);
        r0 = f1024g;	 Catch:{ all -> 0x003a }
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
        r0 = m1336b(r0);	 Catch:{ all -> 0x0035 }
        f1024g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1024g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.AnalyticsBeaconGenerator.a(com.facebook.inject.InjectorLike):com.facebook.analytics.AnalyticsBeaconGenerator");
    }

    private static AnalyticsBeaconGenerator m1336b(InjectorLike injectorLike) {
        return new AnalyticsBeaconGenerator(AnalyticsLoggerMethodAutoProvider.a(injectorLike), AnalyticsPropertyUtil.m1290b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AnalyticsBeaconGenerator(AnalyticsLogger analyticsLogger, AnalyticsPropertyUtil analyticsPropertyUtil, Clock clock) {
        this.f1028d = analyticsLogger;
        this.f1029e = analyticsPropertyUtil;
        this.f1030f = clock;
    }

    public final HoneyAnalyticsEvent m1338a() {
        HoneyClientEvent d = m1337d();
        d.b("tier", "ads");
        String str = "beacon_id";
        int i = 0;
        this.f1025a = this.f1029e.m8549a(AnalyticsDbProperties.f1037g, 0);
        if (this.f1025a != Integer.MAX_VALUE) {
            i = this.f1025a + 1;
        }
        this.f1025a = i;
        this.f1029e.m8556b(AnalyticsDbProperties.f1037g, this.f1025a);
        d.a(str, this.f1025a);
        d.a("upload_this_event_now", "true");
        return d;
    }

    public final HoneyClientEvent m1339b() {
        HoneyClientEvent d = m1337d();
        d.b("tier", "regular");
        String str = "beacon_id";
        int i = 0;
        this.f1026b = this.f1029e.m8549a(AnalyticsDbProperties.f1038h, 0);
        if (this.f1026b != Integer.MAX_VALUE) {
            i = this.f1026b + 1;
        }
        this.f1026b = i;
        this.f1029e.m8556b(AnalyticsDbProperties.f1038h, this.f1026b);
        d.a(str, this.f1026b);
        return d;
    }

    private HoneyClientEvent m1337d() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("marauder_beacon");
        honeyClientEvent.c = "marauder";
        honeyClientEvent.b("impl", this.f1028d.a());
        honeyClientEvent.e = this.f1030f.a();
        return honeyClientEvent;
    }
}
