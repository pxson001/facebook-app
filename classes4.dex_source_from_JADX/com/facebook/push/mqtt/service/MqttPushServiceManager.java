package com.facebook.push.mqtt.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.RemoteException;
import com.facebook.analytics.MqttAnalyticsLogger;
import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.auth.component.AuthenticationResult;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.service.CachedBindServiceResult;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.executors.NamedRunnable;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.common.init.INeedInit;
import com.facebook.common.process.ProcessName;
import com.facebook.common.process.ProcessNameMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.mqttlite.Handler_MqttThreadMethodAutoProvider;
import com.facebook.mqttlite.Looper_MqttThreadMethodAutoProvider;
import com.facebook.push.mqtt.C0487xb81a5188;
import com.facebook.push.mqtt.IsCombineForegroundAndSubscriptionEnabledProvider;
import com.facebook.push.mqtt.ListeningScheduledExecutorService_MqttThreadMethodAutoProvider;
import com.facebook.push.mqtt.abtest.ExperimentsForMqttPushModule;
import com.facebook.push.mqtt.external.MqttThread;
import com.facebook.push.mqtt.external.PushStateBroadcaster;
import com.facebook.push.mqtt.ipc.IMqttPushService;
import com.facebook.push.mqtt.ipc.IMqttPushService.Stub;
import com.facebook.push.mqtt.persistence.MqttServicePersistence;
import com.facebook.push.mqtt.service.response.SimpleMqttPushServiceClientFlightRecorderEvent;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Preconditions;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@NotThreadSafe
/* compiled from: time_to_success */
public class MqttPushServiceManager extends AbstractAuthComponent implements INeedInit, MqttClientStateChangeListener {
    private static volatile MqttPushServiceManager f10769E;
    private static final Class<?> f10770a = MqttPushServiceManager.class;
    private ScheduledFuture f10771A;
    private final Runnable f10772B = new NamedRunnable(this, f10770a, "stopService") {
        final /* synthetic */ MqttPushServiceManager f10802c;

        public void run() {
            MqttPushServiceManager.m11229t(this.f10802c);
        }
    };
    private boolean f10773C = false;
    public final ServiceConnection f10774D = new C05067(this);
    private final Provider<Boolean> f10775b;
    private final Provider<Boolean> f10776c;
    public final Context f10777d;
    public final ExecutorService f10778e;
    private final ScheduledExecutorService f10779f;
    private final Provider<MqttServicePersistence> f10780g;
    public final Provider<String> f10781h;
    private final Set<IMqttClientActiveCallback> f10782i;
    private final MqttAnalyticsLogger f10783j;
    public final BaseFbBroadcastManager f10784k;
    public final ClientSubscriptionManager f10785l;
    public final PushServiceTargetingHelper f10786m;
    private final PushStateBroadcaster f10787n;
    public final ChannelConnectivityTracker f10788o;
    public final ProcessName f10789p;
    public final MqttPushServiceClientFlightRecorder f10790q;
    public final MonotonicClock f10791r;
    private final QeAccessor f10792s;
    private final AbstractFbErrorReporter f10793t;
    @MqttThread
    public final Handler f10794u;
    @MqttThread
    public final Looper f10795v;
    public IMqttPushService f10796w;
    private DynamicSecureBroadcastReceiver f10797x;
    private boolean f10798y;
    public String f10799z;

    /* compiled from: time_to_success */
    class C05067 implements ServiceConnection {
        final /* synthetic */ MqttPushServiceManager f10803a;

        C05067(MqttPushServiceManager mqttPushServiceManager) {
            this.f10803a = mqttPushServiceManager;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f10803a.f10790q.a(new SimpleMqttPushServiceClientFlightRecorderEvent(this.f10803a.f10791r.now(), "ServiceConnected (MqttPushServiceManager)", new Object[0]));
            MqttPushServiceManager.m11223a(this.f10803a, iBinder);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f10803a.f10790q.a(new SimpleMqttPushServiceClientFlightRecorderEvent(this.f10803a.f10791r.now(), "ServiceDisconnected (MqttPushServiceManager)", new Object[0]));
            MqttPushServiceManager.m11215B(this.f10803a);
        }
    }

    /* compiled from: time_to_success */
    public class C05112 implements Runnable {
        final /* synthetic */ MqttPushServiceManager f10829a;

        public C05112(MqttPushServiceManager mqttPushServiceManager) {
            this.f10829a = mqttPushServiceManager;
        }

        public void run() {
            TracerDetour.a("%s.doInit.run", MqttPushServiceManager.class.getSimpleName(), -535518077);
            try {
                MqttPushServiceManager.m11227j(this.f10829a);
            } finally {
                TracerDetour.a(536893550);
            }
        }
    }

    /* compiled from: time_to_success */
    public class C05126 implements ActionReceiver {
        final /* synthetic */ MqttPushServiceManager f10830a;

        public C05126(MqttPushServiceManager mqttPushServiceManager) {
            this.f10830a = mqttPushServiceManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1089599600);
            MqttPushServiceManager.m11224a(this.f10830a, true);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -530227137, a);
        }
    }

    /* compiled from: time_to_success */
    class C05133 implements ActionReceiver {
        final /* synthetic */ MqttPushServiceManager f10849a;

        C05133(MqttPushServiceManager mqttPushServiceManager) {
            this.f10849a = mqttPushServiceManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1523848687);
            if ("com.facebook.rti.mqtt.intent.ACTION_WAKEUP".equals(intent.getAction())) {
                MqttPushServiceManager.m11222a(this.f10849a, intent);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1864737541, a);
        }
    }

    /* compiled from: time_to_success */
    class C05148 implements Runnable {
        final /* synthetic */ MqttPushServiceManager f10859a;

        C05148(MqttPushServiceManager mqttPushServiceManager) {
            this.f10859a = mqttPushServiceManager;
        }

        public void run() {
            MqttPushServiceManager mqttPushServiceManager = this.f10859a;
            Handler ipcAckHandler = new IpcAckHandler(mqttPushServiceManager.f10795v);
            mqttPushServiceManager.f10786m.a(mqttPushServiceManager.f10777d, new Intent("Orca.START").putExtra("MESSENGER", new Messenger(ipcAckHandler)));
            ipcAckHandler.f11002a.a(new C05169(mqttPushServiceManager), mqttPushServiceManager.f10778e);
        }
    }

    /* compiled from: time_to_success */
    public class C05169 implements Runnable {
        final /* synthetic */ MqttPushServiceManager f11003a;

        public C05169(MqttPushServiceManager mqttPushServiceManager) {
            this.f11003a = mqttPushServiceManager;
        }

        public void run() {
            MqttPushServiceManager.m11232y(this.f11003a);
        }
    }

    public static com.facebook.push.mqtt.service.MqttPushServiceManager m11221a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10769E;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.mqtt.service.MqttPushServiceManager.class;
        monitor-enter(r1);
        r0 = f10769E;	 Catch:{ all -> 0x003a }
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
        r0 = m11225b(r0);	 Catch:{ all -> 0x0035 }
        f10769E = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10769E;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.mqtt.service.MqttPushServiceManager.a(com.facebook.inject.InjectorLike):com.facebook.push.mqtt.service.MqttPushServiceManager");
    }

    private static MqttPushServiceManager m11225b(InjectorLike injectorLike) {
        return new MqttPushServiceManager(IdBasedProvider.a(injectorLike, 4273), IsCombineForegroundAndSubscriptionEnabledProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (ExecutorService) ListeningScheduledExecutorService_MqttThreadMethodAutoProvider.m11240a(injectorLike), (ScheduledExecutorService) C0487xb81a5188.m11157a(injectorLike), IdBasedProvider.a(injectorLike, 3193), IdBasedProvider.a(injectorLike, 4442), STATICDI_MULTIBIND_PROVIDER$IMqttClientActiveCallback.m11242a(injectorLike), MqttAnalyticsLogger.m8797a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), ClientSubscriptionManager.a(injectorLike), PushServiceTargetingHelper.a(injectorLike), PushStateBroadcaster.a(injectorLike), ChannelConnectivityTracker.a(injectorLike), ProcessNameMethodAutoProvider.a(injectorLike), MqttPushServiceClientFlightRecorder.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), Handler_MqttThreadMethodAutoProvider.a(injectorLike), Looper_MqttThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MqttPushServiceManager(Provider<Boolean> provider, IsCombineForegroundAndSubscriptionEnabledProvider isCombineForegroundAndSubscriptionEnabledProvider, Context context, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, Provider<MqttServicePersistence> provider2, Provider<String> provider3, Set<IMqttClientActiveCallback> set, MqttAnalyticsLogger mqttAnalyticsLogger, FbBroadcastManager fbBroadcastManager, ClientSubscriptionManager clientSubscriptionManager, PushServiceTargetingHelper pushServiceTargetingHelper, PushStateBroadcaster pushStateBroadcaster, ChannelConnectivityTracker channelConnectivityTracker, ProcessName processName, MqttPushServiceClientFlightRecorder mqttPushServiceClientFlightRecorder, MonotonicClock monotonicClock, QeAccessor qeAccessor, FbErrorReporter fbErrorReporter, Handler handler, Looper looper) {
        this.f10775b = provider;
        this.f10776c = isCombineForegroundAndSubscriptionEnabledProvider;
        this.f10777d = context;
        this.f10778e = executorService;
        this.f10779f = scheduledExecutorService;
        this.f10780g = provider2;
        this.f10781h = provider3;
        this.f10782i = set;
        this.f10783j = mqttAnalyticsLogger;
        this.f10784k = fbBroadcastManager;
        this.f10785l = clientSubscriptionManager;
        this.f10786m = pushServiceTargetingHelper;
        this.f10787n = pushStateBroadcaster;
        this.f10789p = processName;
        this.f10788o = channelConnectivityTracker;
        this.f10790q = mqttPushServiceClientFlightRecorder;
        this.f10791r = monotonicClock;
        this.f10792s = qeAccessor;
        this.f10793t = fbErrorReporter;
        this.f10794u = handler;
        this.f10795v = looper;
    }

    public void init() {
        if (!((Boolean) this.f10775b.get()).booleanValue() && this.f10789p.e()) {
            ExecutorDetour.a(this.f10778e, new C05112(this), -1412254924);
        }
    }

    public static void m11227j(MqttPushServiceManager mqttPushServiceManager) {
        Preconditions.checkState(mqttPushServiceManager.f10789p.e());
        AppInitLockHelper.a(mqttPushServiceManager.f10777d);
        mqttPushServiceManager.f10784k.a().a("com.facebook.orca.login.AuthStateMachineMonitor.LOGIN_COMPLETE", new C05126(mqttPushServiceManager)).a(mqttPushServiceManager.f10794u).a().b();
        mqttPushServiceManager.m11226b(true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.rti.mqtt.intent.ACTION_WAKEUP");
        mqttPushServiceManager.f10797x = new DynamicSecureBroadcastReceiver("com.facebook.rti.mqtt.intent.ACTION_WAKEUP", new C05133(mqttPushServiceManager));
        mqttPushServiceManager.f10777d.registerReceiver(mqttPushServiceManager.f10797x, intentFilter, null, mqttPushServiceManager.f10794u);
    }

    public final void m11234a(@Nullable final AuthenticationResult authenticationResult) {
        if (!((Boolean) this.f10775b.get()).booleanValue()) {
            ExecutorDetour.a(this.f10778e, new Runnable(this) {
                final /* synthetic */ MqttPushServiceManager f1533b;

                public void run() {
                    this.f1533b.f10799z = authenticationResult.mo88a();
                    MqttPushServiceManager.m11224a(this.f1533b, true);
                }
            }, 1842976945);
        }
    }

    public final void m11235c() {
        if (!((Boolean) this.f10775b.get()).booleanValue()) {
            ExecutorDetour.a(this.f10778e, new 5(this), 640375442);
        }
    }

    public static void m11224a(MqttPushServiceManager mqttPushServiceManager, boolean z) {
        if (mqttPushServiceManager.f10789p.e()) {
            mqttPushServiceManager.m11226b(z);
        } else {
            Boolean.valueOf(z);
        }
    }

    private void m11226b(boolean z) {
        Preconditions.checkState(this.f10789p.e());
        Boolean.valueOf(z);
        if (this.f10798y != z) {
            this.f10798y = z;
            this.f10783j.m8801a(z, null);
        }
        if (m11216D()) {
            m11228q();
        } else {
            m11229t(this);
        }
    }

    public static void m11222a(MqttPushServiceManager mqttPushServiceManager, Intent intent) {
        if (!mqttPushServiceManager.m11216D()) {
            mqttPushServiceManager.m11230u();
        } else if (intent.hasExtra("EXPIRED_SESSION")) {
            long longExtra = intent.getLongExtra("EXPIRED_SESSION", 0);
            Long.valueOf(longExtra);
            mqttPushServiceManager.f10786m.a(mqttPushServiceManager.f10777d, new Intent().setAction("Orca.EXPIRE_CONNECTION").putExtra("EXPIRED_SESSION", longExtra));
        } else {
            mqttPushServiceManager.m11228q();
        }
    }

    public final void mo614k() {
        if (m11216D()) {
            m11228q();
        } else {
            m11230u();
        }
    }

    public final void mo615l() {
        this.f10773C = true;
        if (m11216D()) {
            m11228q();
        } else {
            m11230u();
        }
        m11217E();
    }

    public final void mo616m() {
        this.f10773C = false;
        if (!m11216D()) {
            m11230u();
        }
        m11217E();
    }

    public final void mo617n() {
        if (!m11216D()) {
            m11230u();
        }
    }

    private void m11228q() {
        m11231v();
        if (this.f10796w == null) {
            CachedBindServiceResult a = this.f10786m.a(this.f10777d, new Intent(), this.f10774D, 1);
            if (a.f10848b != null) {
                m11223a(this, a.f10848b);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setAction("Orca.PERSISTENT_KICK");
        this.f10786m.a(this.f10777d, intent);
    }

    public static void m11229t(MqttPushServiceManager mqttPushServiceManager) {
        mqttPushServiceManager.f10786m.b(mqttPushServiceManager.f10777d, new Intent());
        mqttPushServiceManager.m11219G();
        mqttPushServiceManager.f10786m.a(mqttPushServiceManager.f10774D);
        m11215B(mqttPushServiceManager);
        mqttPushServiceManager.m11231v();
    }

    private synchronized void m11230u() {
        if (this.f10771A == null || this.f10771A.isDone()) {
            Long.valueOf(m11220H() / 1000);
            try {
                this.f10771A = this.f10779f.schedule(this.f10772B, m11220H(), TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                BLog.a(f10770a, th, "Failed to schedule stopping service, trying to stop it now", new Object[0]);
                this.f10793t.a(SoftError.m4758a("MqttPushServiceManager", "stopServiceDelayed got exception " + th.toString()).m4765g());
                ExecutorDetour.a(this.f10778e, this.f10772B, -820372807);
            }
        }
    }

    private synchronized void m11231v() {
        if (this.f10771A != null) {
            this.f10771A.cancel(false);
            this.f10771A = null;
        }
    }

    public static void m11223a(MqttPushServiceManager mqttPushServiceManager, IBinder iBinder) {
        mqttPushServiceManager.f10796w = Stub.a(iBinder);
        ExecutorDetour.a(mqttPushServiceManager.f10778e, new C05148(mqttPushServiceManager), -1571973321);
    }

    public static void m11232y(MqttPushServiceManager mqttPushServiceManager) {
        if (mqttPushServiceManager.f10796w != null) {
            mqttPushServiceManager.m11233z();
        }
    }

    private void m11233z() {
        m11217E();
        m11218F();
        ClientSubscriptionManager clientSubscriptionManager = this.f10785l;
        ExecutorDetour.a(clientSubscriptionManager.a, new ClientSubscriptionManager$9(clientSubscriptionManager, this.f10796w), -248016073);
    }

    public static void m11215B(MqttPushServiceManager mqttPushServiceManager) {
        mqttPushServiceManager.f10796w = null;
        ExecutorDetour.a(mqttPushServiceManager.f10778e, new Runnable(mqttPushServiceManager) {
            final /* synthetic */ MqttPushServiceManager f1020a;

            {
                this.f1020a = r1;
            }

            public void run() {
                MqttPushServiceManager mqttPushServiceManager = this.f1020a;
                ClientSubscriptionManager clientSubscriptionManager = mqttPushServiceManager.f10785l;
                ExecutorDetour.a(clientSubscriptionManager.a, new ClientSubscriptionManager$10(clientSubscriptionManager), -1778075031);
                mqttPushServiceManager.f10788o.g();
            }
        }, 1746280711);
    }

    private boolean m11216D() {
        boolean z = true;
        if (!this.f10798y) {
            this.f10783j.m8801a(this.f10798y, "NOT_ENABLED");
            return false;
        } else if (((Boolean) this.f10775b.get()).booleanValue()) {
            this.f10783j.m8801a(this.f10798y, "FORCE_DISABLED");
            return false;
        } else {
            String str;
            if (this.f10799z != null) {
                str = this.f10799z;
            } else {
                str = (String) this.f10781h.get();
            }
            if (str == null) {
                this.f10783j.m8801a(this.f10798y, "NOT_LOGGED_IN");
                return false;
            }
            for (IMqttClientActiveCallback iMqttClientActiveCallback : this.f10782i) {
                if (iMqttClientActiveCallback.mo826a()) {
                    iMqttClientActiveCallback.getClass();
                    return true;
                }
            }
            MqttServicePersistence mqttServicePersistence = (MqttServicePersistence) this.f10780g.get();
            switch (mqttServicePersistence) {
                case ALWAYS:
                    break;
                case APP_USE:
                    Boolean.valueOf(this.f10773C);
                    z = this.f10773C;
                    break;
                default:
                    BLog.a(f10770a, "Invalid value from HighestMqttPersistenceProvider: %s", new Object[]{mqttServicePersistence});
                    z = false;
                    break;
            }
            this.f10783j.m8801a(this.f10798y, mqttServicePersistence.name() + "_" + z);
            return z;
        }
    }

    private void m11217E() {
        try {
            if (this.f10796w != null && !((Boolean) this.f10776c.get()).booleanValue()) {
                this.f10796w.a(this.f10773C);
            }
        } catch (RemoteException e) {
        }
    }

    private void m11218F() {
        try {
            if (this.f10796w != null) {
                this.f10796w.a(this.f10788o.a());
                this.f10788o.a().a(this.f10796w.f());
            }
        } catch (RemoteException e) {
        }
    }

    private void m11219G() {
        try {
            if (this.f10796w != null) {
                this.f10796w.b(this.f10788o.a());
            }
        } catch (RemoteException e) {
        }
    }

    private long m11220H() {
        return this.f10792s.a(ExperimentsForMqttPushModule.f10805b, 480) * 1000;
    }
}
