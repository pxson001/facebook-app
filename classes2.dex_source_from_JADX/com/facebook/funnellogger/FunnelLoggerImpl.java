package com.facebook.funnellogger;

import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.samplingpolicy.AnalyticsFunnelSamplingHelper;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.C0087xd695ba9d;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.funnellogger.Funnel.EndType;
import com.facebook.funnellogger.beacon.BeaconLogger;
import com.facebook.funnellogger.beacon.BeaconLogger.BeaconType;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: solve_captcha */
public class FunnelLoggerImpl {
    public static final String f4344g = FunnelLoggerImpl.class.getSimpleName();
    private static volatile FunnelLoggerImpl f4345h;
    AnalyticsLogger f4346a;
    AnalyticsFunnelSamplingHelper f4347b;
    Clock f4348c;
    Random f4349d;
    BeaconLogger f4350e;
    @GuardedBy("this")
    HashMap<String, Funnel> f4351f = new HashMap();

    /* compiled from: solve_captcha */
    public class C02271 implements ActionReceiver {
        final /* synthetic */ FunnelLoggerImpl f4360a;

        public C02271(FunnelLoggerImpl funnelLoggerImpl) {
            this.f4360a = funnelLoggerImpl;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1565968796);
            String str = FunnelLoggerImpl.f4344g;
            this.f4360a.m8032a();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1322330489, a);
        }
    }

    public static com.facebook.funnellogger.FunnelLoggerImpl m8018a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4345h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.funnellogger.FunnelLoggerImpl.class;
        monitor-enter(r1);
        r0 = f4345h;	 Catch:{ all -> 0x003a }
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
        r0 = m8026b(r0);	 Catch:{ all -> 0x0035 }
        f4345h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4345h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.funnellogger.FunnelLoggerImpl.a(com.facebook.inject.InjectorLike):com.facebook.funnellogger.FunnelLoggerImpl");
    }

    private static FunnelLoggerImpl m8026b(InjectorLike injectorLike) {
        return new FunnelLoggerImpl(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), AnalyticsFunnelSamplingHelper.m8046a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), Random_InsecureRandomMethodAutoProvider.m2102a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike), new BeaconLogger((Context) injectorLike.getInstance(Context.class), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), C0087xd695ba9d.m2486a(injectorLike)));
    }

    private static String m8030d(FunnelDefinition funnelDefinition) {
        return funnelDefinition.f21181a;
    }

    @Inject
    public FunnelLoggerImpl(AnalyticsLogger analyticsLogger, AnalyticsFunnelSamplingHelper analyticsFunnelSamplingHelper, Clock clock, Random random, BaseFbBroadcastManager baseFbBroadcastManager, BeaconLogger beaconLogger) {
        this.f4346a = analyticsLogger;
        this.f4347b = analyticsFunnelSamplingHelper;
        this.f4348c = clock;
        this.f4349d = random;
        this.f4350e = beaconLogger;
        baseFbBroadcastManager.m2951a().mo506a(AppStateManager.f1111c, new C02271(this)).mo503a().m3296b();
    }

    private boolean m8025a(Funnel funnel) {
        if (!funnel.a.f21184d) {
            return false;
        }
        m8019a(funnel, EndType.SESSION_END);
        return true;
    }

    final synchronized void m8032a() {
        ArrayList arrayList = new ArrayList();
        for (Entry entry : this.f4351f.entrySet()) {
            Funnel funnel = (Funnel) entry.getValue();
            if (m8025a(funnel) || m8028b(funnel)) {
                arrayList.add(entry.getKey());
            }
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.f4351f.remove((String) arrayList.get(i));
        }
    }

    public final void m8033a(FunnelDefinition funnelDefinition) {
        m8021a(m8030d(funnelDefinition), funnelDefinition, this.f4349d.nextLong());
    }

    public final void m8034a(FunnelDefinition funnelDefinition, long j) {
        m8021a(m8031e(funnelDefinition, j), funnelDefinition, j);
    }

    private synchronized void m8021a(String str, FunnelDefinition funnelDefinition, long j) {
        Funnel funnel = (Funnel) this.f4351f.get(str);
        if (funnel != null) {
            m8019a(funnel, EndType.RESTART);
            this.f4351f.remove(str);
        }
        funnel = m8029d(funnelDefinition, j);
        if (funnel != null) {
            this.f4350e.m8050a(BeaconType.FUNNEL_STARTED, funnel);
            this.f4351f.put(str, funnel);
        }
    }

    @Nullable
    private Funnel m8029d(FunnelDefinition funnelDefinition, long j) {
        AnalyticsFunnelSamplingHelper analyticsFunnelSamplingHelper = this.f4347b;
        int i = Integer.MAX_VALUE;
        int a = analyticsFunnelSamplingHelper.f4353a.m2869a("funnel_analytics", funnelDefinition.f21181a, null);
        if (a == -1) {
            int intValue;
            if (DefaultFunnelSamplingPolicy.a.containsKey(funnelDefinition)) {
                intValue = ((Integer) DefaultFunnelSamplingPolicy.a.get(funnelDefinition)).intValue();
            } else {
                intValue = 100;
            }
            a = intValue;
        }
        if (a > 0) {
            if (a == 1) {
                i = a;
            } else if (analyticsFunnelSamplingHelper.f4354b.nextInt(a) == 0) {
                i = a;
            }
        }
        int i2 = i;
        if (i2 == Integer.MAX_VALUE) {
            funnelDefinition.m28908a();
            return null;
        }
        return new Funnel(funnelDefinition, j, this.f4348c, i2);
    }

    private void m8019a(Funnel funnel, EndType endType) {
        funnel.a(new FunnelAction("funnel_end", (int) (this.f4348c.mo211a() - funnel.e), endType.tag()));
        this.f4350e.m8050a(BeaconType.FUNNEL_ENDED, funnel);
        this.f4346a.mo531b(funnel.h());
        funnel.b();
        endType.tag();
    }

    private static String m8031e(FunnelDefinition funnelDefinition, long j) {
        return funnelDefinition.f21181a + ":" + j;
    }

    public final void m8037a(FunnelDefinition funnelDefinition, String str) {
        m8022a(m8030d(funnelDefinition), str);
    }

    public final synchronized void m8035a(FunnelDefinition funnelDefinition, long j, String str) {
        m8022a(m8031e(funnelDefinition, j), str);
    }

    private synchronized void m8022a(String str, String str2) {
        Funnel funnel = (Funnel) this.f4351f.get(str);
        if (funnel != null) {
            funnel.a(str2);
        }
    }

    public final void m8043b(FunnelDefinition funnelDefinition, String str) {
        m8038a(funnelDefinition, str, null);
    }

    public final void m8042b(FunnelDefinition funnelDefinition, long j, String str) {
        m8036a(funnelDefinition, j, str, null);
    }

    public final void m8038a(FunnelDefinition funnelDefinition, String str, String str2) {
        m8023a(m8030d(funnelDefinition), str, str2);
    }

    public final void m8036a(FunnelDefinition funnelDefinition, long j, String str, String str2) {
        m8031e(funnelDefinition, j);
        m8023a(m8031e(funnelDefinition, j), str, str2);
    }

    public final void m8039a(FunnelDefinition funnelDefinition, String str, @Nullable String str2, @Nullable PayloadBundle payloadBundle) {
        m8024a(m8030d(funnelDefinition), str, str2, payloadBundle);
    }

    private synchronized void m8024a(String str, String str2, String str3, PayloadBundle payloadBundle) {
        Funnel funnel = (Funnel) this.f4351f.get(str);
        if (funnel != null) {
            funnel.a(new FunnelAction(str2, (int) (this.f4348c.mo211a() - funnel.d()), str3, payloadBundle));
        }
    }

    private synchronized void m8023a(String str, String str2, String str3) {
        Funnel funnel = (Funnel) this.f4351f.get(str);
        if (funnel != null) {
            funnel.a(new FunnelAction(str2, (int) (this.f4348c.mo211a() - funnel.d()), str3));
            if (!funnel.g()) {
                m8019a(funnel, EndType.ACTIONS_FULL);
                this.f4351f.remove(str);
            }
        }
    }

    public final void m8044c(FunnelDefinition funnelDefinition) {
        m8027b(m8030d(funnelDefinition));
    }

    public final void m8045c(FunnelDefinition funnelDefinition, long j) {
        m8027b(m8031e(funnelDefinition, j));
    }

    public final void m8040b(FunnelDefinition funnelDefinition) {
        m8020a(m8030d(funnelDefinition));
    }

    public final void m8041b(FunnelDefinition funnelDefinition, long j) {
        m8020a(m8031e(funnelDefinition, j));
    }

    private synchronized void m8020a(String str) {
        Funnel funnel = (Funnel) this.f4351f.get(str);
        if (funnel != null) {
            this.f4351f.remove(str);
            m8019a(funnel, EndType.EXPLICIT);
        }
    }

    private boolean m8028b(Funnel funnel) {
        if (this.f4348c.mo211a() - funnel.f <= ((long) funnel.a.f21183c) * 1000) {
            return false;
        }
        m8019a(funnel, EndType.TIMEOUT);
        return true;
    }

    private synchronized void m8027b(String str) {
        Funnel funnel = (Funnel) this.f4351f.get(str);
        this.f4351f.remove(str);
        this.f4350e.m8050a(BeaconType.FUNNEL_CANCELLED, funnel);
    }
}
