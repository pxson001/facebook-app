package com.facebook.analytics.immediateactiveseconds;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.analytics.eventlisteners.AnalyticsEventListener;
import com.facebook.analytics.immediateactiveseconds.ImmediateActiveSecondsConfig.Params;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.CurrentModuleHolder;
import com.facebook.analytics.tagging.ModuleInfo;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.base.broadcast.Handler_BackgroundBroadcastThreadMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: trace */
public class ImmediateActiveSecondReporter implements AnalyticsEventListener {
    private static volatile ImmediateActiveSecondReporter f15177g;
    public final Clock f15178a;
    private final Lazy<AnalyticsLogger> f15179b;
    private final Lazy<CurrentModuleHolder> f15180c;
    private final ImmediateActiveSecondsConfig f15181d;
    private long f15182e = -1;
    public volatile long f15183f;

    @Singleton
    /* compiled from: trace */
    public class ImmediateActiveSecondReporterBroadcastReceiverRegistration extends INeedInitForBroadcastReceiverRegistration<ImmediateActiveSecondReporter> {
        private static volatile ImmediateActiveSecondReporterBroadcastReceiverRegistration f2297a;

        public static com.facebook.analytics.immediateactiveseconds.ImmediateActiveSecondReporter.ImmediateActiveSecondReporterBroadcastReceiverRegistration m4481a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
            r0 = f2297a;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.analytics.immediateactiveseconds.ImmediateActiveSecondReporter.ImmediateActiveSecondReporterBroadcastReceiverRegistration.class;
            monitor-enter(r1);
            r0 = f2297a;	 Catch:{ all -> 0x003a }
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
            r0 = m4482b(r0);	 Catch:{ all -> 0x0035 }
            f2297a = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.m1338a(r4);
            r2.m1505c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f2297a;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.immediateactiveseconds.ImmediateActiveSecondReporter.ImmediateActiveSecondReporterBroadcastReceiverRegistration.a(com.facebook.inject.InjectorLike):com.facebook.analytics.immediateactiveseconds.ImmediateActiveSecondReporter$ImmediateActiveSecondReporterBroadcastReceiverRegistration");
        }

        private static ImmediateActiveSecondReporterBroadcastReceiverRegistration m4482b(InjectorLike injectorLike) {
            return new ImmediateActiveSecondReporterBroadcastReceiverRegistration(IdBasedSingletonScopeProvider.m1810b(injectorLike, 169), Handler_BackgroundBroadcastThreadMethodAutoProvider.m4110a(injectorLike));
        }

        protected void onReceive(Context context, Intent intent, Object obj) {
            ImmediateActiveSecondReporter immediateActiveSecondReporter = (ImmediateActiveSecondReporter) obj;
            immediateActiveSecondReporter.f15183f = immediateActiveSecondReporter.f15178a.mo211a();
        }

        @Inject
        public ImmediateActiveSecondReporterBroadcastReceiverRegistration(Lazy<ImmediateActiveSecondReporter> lazy, Handler handler) {
            super(FbBroadcastManagerType.LOCAL, (Lazy) lazy, handler, AppStateManager.f1110b);
        }
    }

    public static com.facebook.analytics.immediateactiveseconds.ImmediateActiveSecondReporter m21688a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15177g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.immediateactiveseconds.ImmediateActiveSecondReporter.class;
        monitor-enter(r1);
        r0 = f15177g;	 Catch:{ all -> 0x003a }
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
        r0 = m21692b(r0);	 Catch:{ all -> 0x0035 }
        f15177g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15177g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.immediateactiveseconds.ImmediateActiveSecondReporter.a(com.facebook.inject.InjectorLike):com.facebook.analytics.immediateactiveseconds.ImmediateActiveSecondReporter");
    }

    private static ImmediateActiveSecondReporter m21692b(InjectorLike injectorLike) {
        return new ImmediateActiveSecondReporter(SystemClockMethodAutoProvider.m1498a(injectorLike), ImmediateActiveSecondsConfig.m21698a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 175), IdBasedSingletonScopeProvider.m1810b(injectorLike, 193));
    }

    @Inject
    public ImmediateActiveSecondReporter(Clock clock, ImmediateActiveSecondsConfig immediateActiveSecondsConfig, Lazy<AnalyticsLogger> lazy, Lazy<CurrentModuleHolder> lazy2) {
        this.f15178a = clock;
        this.f15179b = lazy;
        this.f15180c = lazy2;
        this.f15183f = clock.mo211a();
        this.f15181d = immediateActiveSecondsConfig;
    }

    @VisibleForTesting
    private static boolean m21691a(long j, Params params) {
        return params.b == j % params.a;
    }

    @VisibleForTesting
    private void m21693c(long j) {
        long j2 = j / 1000;
        if (j2 > this.f15182e) {
            long j3 = this.f15182e * 1000;
            this.f15182e = j2;
            Params a = this.f15181d.m21700a();
            if (a != null && a.a() && m21691a(j2, a)) {
                ((AnalyticsLogger) this.f15179b.get()).mo533c(m21689a((HoneyClientEvent) new HoneyClientEvent("immediate_active_seconds").m5084a("activity_time", j).m5084a("last_activity_time", j3).m5084a("last_foreground_time", this.f15183f).m5109a("upload_this_event_now", "true")));
            }
        }
    }

    @VisibleForTesting
    private static boolean m21690a(long j, long j2, Params params) {
        long j3 = params.a;
        long j4 = params.b;
        if (j2 - j < j3 && (((j4 - (j % j3)) + j3) % j3) + j > j2) {
            return false;
        }
        return true;
    }

    public final void m21696a(String str, long j, long j2) {
        Params a = this.f15181d.m21700a();
        if (a != null && a.a() && m21690a(j, j2, a)) {
            long j3 = 1000 * j2;
            ((AnalyticsLogger) this.f15179b.get()).mo533c(m21689a((HoneyClientEvent) new HoneyClientEvent("immediate_active_seconds").m5090b("event", str).m5084a("start_time", j * 1000).m5084a("end_time", j3).m5109a("upload_this_event_now", "true")));
        }
    }

    private HoneyClientEvent m21689a(HoneyClientEvent honeyClientEvent) {
        ModuleInfo c = ((CurrentModuleHolder) this.f15180c.get()).m5555c();
        if (c != null) {
            honeyClientEvent.f3099c = c.toString();
        }
        return honeyClientEvent;
    }

    public final long m21694a() {
        return this.f15178a.mo211a();
    }

    public final void mo2664b(long j) {
        m21693c(j);
    }

    public final void mo2663a(long j) {
        m21693c(j);
    }
}
