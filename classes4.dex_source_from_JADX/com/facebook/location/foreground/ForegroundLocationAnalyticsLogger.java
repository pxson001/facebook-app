package com.facebook.location.foreground;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationManagerException;
import com.facebook.location.ImmutableLocation;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_result_from_server */
public class ForegroundLocationAnalyticsLogger {
    private static volatile ForegroundLocationAnalyticsLogger f9891c;
    public final AnalyticsLogger f9892a;
    private final Clock f9893b;

    public static com.facebook.location.foreground.ForegroundLocationAnalyticsLogger m10283a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9891c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.location.foreground.ForegroundLocationAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f9891c;	 Catch:{ all -> 0x003a }
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
        r0 = m10284b(r0);	 Catch:{ all -> 0x0035 }
        f9891c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9891c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.location.foreground.ForegroundLocationAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.location.foreground.ForegroundLocationAnalyticsLogger");
    }

    private static ForegroundLocationAnalyticsLogger m10284b(InjectorLike injectorLike) {
        return new ForegroundLocationAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ForegroundLocationAnalyticsLogger(AnalyticsLogger analyticsLogger, Clock clock) {
        this.f9892a = analyticsLogger;
        this.f9893b = clock;
    }

    public final void m10285a(ImmutableLocation immutableLocation) {
        this.f9892a.a(m10281a(m10282a("foreground_location_cached_location_at_start"), immutableLocation));
    }

    public final void m10287b(ImmutableLocation immutableLocation) {
        this.f9892a.a(m10281a(m10282a("foreground_location_location_success"), immutableLocation));
    }

    public final void m10286a(Throwable th) {
        HoneyClientEvent a = m10282a("foreground_location_location_failure").a("throwable_class", th.getClass());
        if (th instanceof FbLocationManagerException) {
            a.a("location_error_type", ((FbLocationManagerException) th).type);
        }
        this.f9892a.a(a);
    }

    public static HoneyClientEvent m10282a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "foreground_location";
        return honeyClientEvent;
    }

    private HoneyClientEvent m10281a(HoneyClientEvent honeyClientEvent, ImmutableLocation immutableLocation) {
        return honeyClientEvent.a("accuracy_meters", immutableLocation.c().get()).a("age_ms", this.f9893b.a() - ((Long) immutableLocation.g().get()).longValue());
    }
}
