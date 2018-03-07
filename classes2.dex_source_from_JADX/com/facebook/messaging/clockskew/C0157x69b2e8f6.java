package com.facebook.messaging.clockskew;

import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: total_requests_waited */
public class C0157x69b2e8f6 extends INeedInitForBroadcastReceiverRegistration<ClockSkewChecker> {
    private static volatile C0157x69b2e8f6 f2325f;
    private Lazy<ClockSkewCheckBackgroundTask> f2326a;
    private final ClockSkewGatekeepers f2327b;
    private final Lazy<AutoDateTimeChecker> f2328c;
    private final Lazy<EstimatedServerClock> f2329d;
    private final ClockSkewLogger f2330e;

    public static com.facebook.messaging.clockskew.C0157x69b2e8f6 m4512a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2325f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.clockskew.C0157x69b2e8f6.class;
        monitor-enter(r1);
        r0 = f2325f;	 Catch:{ all -> 0x003a }
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
        r0 = com.facebook.messaging.clockskew.C0157x69b2e8f6.m4513b(r0);	 Catch:{ all -> 0x0035 }
        f2325f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2325f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.clockskew.ClockSkewChecker$ClockSkewCheckerOnInitBroadcastReceiverRegistration.a(com.facebook.inject.InjectorLike):com.facebook.messaging.clockskew.ClockSkewChecker$ClockSkewCheckerOnInitBroadcastReceiverRegistration");
    }

    private static C0157x69b2e8f6 m4513b(InjectorLike injectorLike) {
        return new C0157x69b2e8f6(ClockSkewGatekeepers.m4514b(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2579), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2581), IdBasedLazy.m1808a(injectorLike, 2578), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2584), ClockSkewLogger.m4516b(injectorLike));
    }

    @Inject
    public C0157x69b2e8f6(ClockSkewGatekeepers clockSkewGatekeepers, Lazy<ClockSkewCheckBackgroundTask> lazy, Lazy<ClockSkewChecker> lazy2, Lazy<AutoDateTimeChecker> lazy3, Lazy<EstimatedServerClock> lazy4, ClockSkewLogger clockSkewLogger) {
        super(FbBroadcastManagerType.CROSS_PROCESS, (Lazy) lazy2, "android.intent.action.TIME_SET");
        this.f2326a = lazy;
        this.f2327b = clockSkewGatekeepers;
        this.f2328c = lazy3;
        this.f2329d = lazy4;
        this.f2330e = clockSkewLogger;
    }

    protected void onReceive(Context context, Intent intent, Object obj) {
        if (this.f2327b.m4515a()) {
            boolean a = ((AutoDateTimeChecker) this.f2328c.get()).a();
            ClockSkewLogger clockSkewLogger = this.f2330e;
            clockSkewLogger.f2332a.mo526a(new HoneyClientEvent("time_changed_event").m5087a("auto_time", a));
            if (a) {
                ((EstimatedServerClock) this.f2329d.get()).d();
                return;
            }
            EstimatedServerClock estimatedServerClock = (EstimatedServerClock) this.f2329d.get();
            long a2 = estimatedServerClock.b.mo211a() - estimatedServerClock.d.now();
            estimatedServerClock.b(estimatedServerClock.f + (a2 - estimatedServerClock.h));
            estimatedServerClock.h = a2;
            ClockSkewCheckBackgroundTask clockSkewCheckBackgroundTask = (ClockSkewCheckBackgroundTask) this.f2326a.get();
            if (clockSkewCheckBackgroundTask.d.m4515a()) {
                clockSkewCheckBackgroundTask.f = 0;
                clockSkewCheckBackgroundTask.g = 0;
                clockSkewCheckBackgroundTask.g();
            }
        }
    }
}
