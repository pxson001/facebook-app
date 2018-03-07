package com.facebook.push.mqtt.service;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.analytics.MqttAnalyticsLogger;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager.ReceiverBuilder;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.executors.NamedRunnable;
import com.facebook.common.hardware.ScreenPowerState;
import com.facebook.common.hardware.ScreenPowerState.PowerChangeListener;
import com.facebook.common.init.INeedInit;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.userinteraction.DeviceUserInteractionManager;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.mqttlite.Handler_MqttThreadMethodAutoProvider;
import com.facebook.push.mqtt.C0487xb81a5188;
import com.facebook.push.mqtt.abtest.ExperimentsForMqttPushModule;
import com.facebook.push.mqtt.external.MqttThread;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: hscroll_recent_enabled */
public class MqttClientStateManager implements INeedInit {
    private static volatile MqttClientStateManager f10679w;
    public final ScheduledExecutorService f10680a;
    private final Set<MqttClientStateChangeListener> f10681b;
    private final Clock f10682c;
    public final AppStateManager f10683d;
    private final DeviceUserInteractionManager f10684e;
    private final BaseFbBroadcastManager f10685f;
    @MqttThread
    private final Handler f10686g;
    public final ScreenPowerState f10687h;
    private final MqttAnalyticsLogger f10688i;
    private final QeAccessor f10689j;
    public final AbstractFbErrorReporter f10690k;
    private ActivityStatus f10691l = ActivityStatus.STOPPED;
    private ActivityStatus f10692m = ActivityStatus.STOPPED;
    private boolean f10693n = false;
    private ScheduledFuture f10694o;
    private ScheduledFuture f10695p;
    public ScheduledFuture f10696q;
    public ScheduledFuture f10697r;
    private final Runnable f10698s = new NamedRunnable(this, "MqttClientStateManager", "appStopped") {
        final /* synthetic */ MqttClientStateManager f10734c;

        public void run() {
            MqttClientStateManager.m11152a(this.f10734c, a());
        }
    };
    private final Runnable f10699t = new NamedRunnable(this, "MqttClientStateManager", "deviceStopped") {
        final /* synthetic */ MqttClientStateManager f10735c;

        public void run() {
            MqttClientStateManager.m11152a(this.f10735c, a());
        }
    };
    public final Runnable f10700u = new NamedRunnable(this, "MqttClientStateManager", "appStateCheck") {
        final /* synthetic */ MqttClientStateManager f10736c;

        public void run() {
            MqttClientStateManager mqttClientStateManager = this.f10736c;
            if (mqttClientStateManager.f10697r == null && mqttClientStateManager.f10683d.o() && !mqttClientStateManager.f10687h.b()) {
                mqttClientStateManager.f10697r = mqttClientStateManager.f10680a.schedule(mqttClientStateManager.f10701v, 5000, TimeUnit.MILLISECONDS);
            }
            mqttClientStateManager.f10696q = null;
        }
    };
    public final Runnable f10701v = new NamedRunnable(this, "MqttClientStateManager", "reportWrongAppState") {
        final /* synthetic */ MqttClientStateManager f10737c;

        public void run() {
            String str;
            MqttClientStateManager mqttClientStateManager = this.f10737c;
            if (mqttClientStateManager.f10683d.u() > 0) {
                str = "WrongAppStateActivity";
            } else if (mqttClientStateManager.f10683d.t() > 0) {
                str = "WrongAppStateFloatingWindow";
            } else {
                return;
            }
            AbstractFbErrorReporter abstractFbErrorReporter = mqttClientStateManager.f10690k;
            SoftErrorBuilder a = SoftError.m4758a(str, "Screen is off, but there are still active windows. Active floating windows=" + mqttClientStateManager.f10683d.t() + ", active activities=" + mqttClientStateManager.f10683d.u());
            a.f4228e = 10000;
            abstractFbErrorReporter.a(a.m4765g());
            mqttClientStateManager.f10697r = null;
        }
    };

    /* compiled from: hscroll_recent_enabled */
    enum ActivityStatus {
        ACTIVE,
        PAUSED,
        STOPPED
    }

    /* compiled from: hscroll_recent_enabled */
    class C04935 implements ActionReceiver {
        final /* synthetic */ MqttClientStateManager f10738a;

        C04935(MqttClientStateManager mqttClientStateManager) {
            this.f10738a = mqttClientStateManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 684942139);
            MqttClientStateManager.m11152a(this.f10738a, intent.getAction());
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -628972563, a);
        }
    }

    /* compiled from: hscroll_recent_enabled */
    class C05076 implements PowerChangeListener {
        final /* synthetic */ MqttClientStateManager f10810a;

        C05076(MqttClientStateManager mqttClientStateManager) {
            this.f10810a = mqttClientStateManager;
        }

        public final void m11243a(boolean z) {
            if (z) {
                if (this.f10810a.f10696q != null) {
                    this.f10810a.f10696q.cancel(false);
                    this.f10810a.f10696q = null;
                }
                if (this.f10810a.f10697r != null) {
                    this.f10810a.f10697r.cancel(false);
                    this.f10810a.f10697r = null;
                }
            } else if (this.f10810a.f10696q == null) {
                this.f10810a.f10696q = this.f10810a.f10680a.schedule(this.f10810a.f10700u, 10000, TimeUnit.MILLISECONDS);
            }
        }
    }

    public static com.facebook.push.mqtt.service.MqttClientStateManager m11151a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10679w;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.mqtt.service.MqttClientStateManager.class;
        monitor-enter(r1);
        r0 = f10679w;	 Catch:{ all -> 0x003a }
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
        r0 = m11153b(r0);	 Catch:{ all -> 0x0035 }
        f10679w = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10679w;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.mqtt.service.MqttClientStateManager.a(com.facebook.inject.InjectorLike):com.facebook.push.mqtt.service.MqttClientStateManager");
    }

    private static MqttClientStateManager m11153b(InjectorLike injectorLike) {
        return new MqttClientStateManager((ScheduledExecutorService) C0487xb81a5188.m11157a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$MqttClientStateChangeListener(injectorLike)), AppStateManager.a(injectorLike), DeviceUserInteractionManager.m11180a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), Handler_MqttThreadMethodAutoProvider.a(injectorLike), ScreenPowerState.a(injectorLike), MqttAnalyticsLogger.m8797a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public MqttClientStateManager(ScheduledExecutorService scheduledExecutorService, Clock clock, Set<MqttClientStateChangeListener> set, AppStateManager appStateManager, DeviceUserInteractionManager deviceUserInteractionManager, FbBroadcastManager fbBroadcastManager, Handler handler, ScreenPowerState screenPowerState, MqttAnalyticsLogger mqttAnalyticsLogger, QeAccessor qeAccessor, FbErrorReporter fbErrorReporter) {
        this.f10680a = scheduledExecutorService;
        this.f10682c = clock;
        this.f10681b = set;
        this.f10683d = appStateManager;
        this.f10684e = deviceUserInteractionManager;
        this.f10685f = fbBroadcastManager;
        this.f10686g = handler;
        this.f10687h = screenPowerState;
        this.f10688i = mqttAnalyticsLogger;
        this.f10689j = qeAccessor;
        this.f10690k = fbErrorReporter;
    }

    public void init() {
        ReceiverBuilder a = this.f10685f.a();
        ImmutableSet of = ImmutableSet.of(AppStateManager.b, DeviceUserInteractionManager.f10725b, AppStateManager.c, DeviceUserInteractionManager.f10726c);
        C04935 c04935 = new C04935(this);
        Iterator it = of.iterator();
        while (it.hasNext()) {
            a.a((String) it.next(), c04935);
        }
        a.a(this.f10686g).a().b();
        m11152a(this, "init");
        this.f10687h.a(new C05076(this), this.f10686g);
    }

    public static void m11152a(MqttClientStateManager mqttClientStateManager, String str) {
        boolean z;
        ActivityStatus activityStatus = mqttClientStateManager.f10691l;
        ActivityStatus activityStatus2 = mqttClientStateManager.f10692m;
        mqttClientStateManager.f10691l = mqttClientStateManager.m11154c();
        mqttClientStateManager.f10692m = mqttClientStateManager.m11155d();
        new StringBuilder().append(mqttClientStateManager.f10691l).append(" ").append(activityStatus).append(" ").append(mqttClientStateManager.f10692m).append(" ").append(activityStatus2).append(" ").append(mqttClientStateManager.f10694o);
        if (str == AppStateManager.b && mqttClientStateManager.f10691l != ActivityStatus.ACTIVE) {
            mqttClientStateManager.f10691l = ActivityStatus.ACTIVE;
        }
        if (mqttClientStateManager.f10691l == ActivityStatus.ACTIVE) {
            mqttClientStateManager.f10692m = ActivityStatus.ACTIVE;
        }
        if (mqttClientStateManager.f10692m == ActivityStatus.PAUSED && mqttClientStateManager.f10691l == ActivityStatus.ACTIVE) {
            mqttClientStateManager.f10691l = ActivityStatus.PAUSED;
        }
        if (mqttClientStateManager.f10692m == ActivityStatus.STOPPED) {
            mqttClientStateManager.f10691l = ActivityStatus.STOPPED;
        }
        boolean z2 = mqttClientStateManager.f10691l != activityStatus;
        if (mqttClientStateManager.f10692m != activityStatus2) {
            z = true;
        } else {
            z = false;
        }
        if (!(z2 || r3)) {
            if (!mqttClientStateManager.f10693n) {
                z = true;
            } else {
                return;
            }
        }
        mqttClientStateManager.f10693n = true;
        if (mqttClientStateManager.f10692m == ActivityStatus.ACTIVE && r3) {
            if (mqttClientStateManager.f10695p != null) {
                mqttClientStateManager.f10695p.cancel(false);
                mqttClientStateManager.f10695p = null;
            }
            for (MqttClientStateChangeListener k : mqttClientStateManager.f10681b) {
                k.mo614k();
            }
        }
        if (mqttClientStateManager.f10691l == ActivityStatus.ACTIVE && z2) {
            if (mqttClientStateManager.f10694o != null) {
                mqttClientStateManager.f10694o.cancel(false);
                mqttClientStateManager.f10694o = null;
            }
            for (MqttClientStateChangeListener k2 : mqttClientStateManager.f10681b) {
                k2.mo615l();
            }
        }
        if (mqttClientStateManager.f10691l == ActivityStatus.PAUSED && z2 && mqttClientStateManager.f10694o == null) {
            mqttClientStateManager.f10694o = mqttClientStateManager.f10680a.schedule(mqttClientStateManager.f10698s, mqttClientStateManager.m11156e(), TimeUnit.MILLISECONDS);
        }
        if (mqttClientStateManager.f10692m == ActivityStatus.PAUSED && r3 && mqttClientStateManager.f10695p == null) {
            mqttClientStateManager.f10695p = mqttClientStateManager.f10680a.schedule(mqttClientStateManager.f10699t, mqttClientStateManager.m11156e(), TimeUnit.MILLISECONDS);
        }
        if (mqttClientStateManager.f10691l == ActivityStatus.STOPPED && z2) {
            mqttClientStateManager.f10694o = null;
            for (MqttClientStateChangeListener k22 : mqttClientStateManager.f10681b) {
                k22.mo616m();
            }
        }
        if (mqttClientStateManager.f10692m == ActivityStatus.STOPPED && r3) {
            mqttClientStateManager.f10695p = null;
            for (MqttClientStateChangeListener k222 : mqttClientStateManager.f10681b) {
                k222.mo617n();
            }
        }
    }

    private ActivityStatus m11154c() {
        if (this.f10683d.o()) {
            return ActivityStatus.ACTIVE;
        }
        if (this.f10683d.q() < m11156e()) {
            return ActivityStatus.PAUSED;
        }
        return ActivityStatus.STOPPED;
    }

    private ActivityStatus m11155d() {
        long a = this.f10682c.a() - this.f10684e.f10732h;
        if (this.f10684e.f10730f.a()) {
            return ActivityStatus.ACTIVE;
        }
        if (a < m11156e()) {
            return ActivityStatus.PAUSED;
        }
        return ActivityStatus.STOPPED;
    }

    private long m11156e() {
        return this.f10689j.a(ExperimentsForMqttPushModule.f10804a, 120) * 1000;
    }
}
