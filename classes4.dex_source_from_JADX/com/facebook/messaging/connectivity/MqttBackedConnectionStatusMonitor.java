package com.facebook.messaging.connectivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.netchecker.NetCheckState;
import com.facebook.common.netchecker.NetChecker;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.connectivity.ConnectionStatusMonitor.ConnectionType;
import com.facebook.messaging.connectivity.ConnectionStatusMonitor.State;
import com.facebook.push.mqtt.service.ChannelConnectivityTracker;
import com.facebook.push.mqtt.service.ConnectionState;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mThreadsCacheLock */
public class MqttBackedConnectionStatusMonitor implements ConnectionStatusMonitor {
    private static final Class<?> f8512a = MqttBackedConnectionStatusMonitor.class;
    private static volatile MqttBackedConnectionStatusMonitor f8513k;
    public final ChannelConnectivityTracker f8514b;
    public final FbNetworkManager f8515c;
    private final BaseFbBroadcastManager f8516d;
    private final NetChecker f8517e;
    private final ScheduledExecutorService f8518f;
    private ContentResolver f8519g;
    public State f8520h = State.CONNECTED;
    private Optional<State> f8521i = Absent.INSTANCE;
    @Nullable
    private ScheduledFuture<?> f8522j;

    /* compiled from: mThreadsCacheLock */
    class C05293 implements ActionReceiver {
        final /* synthetic */ MqttBackedConnectionStatusMonitor f11133a;

        C05293(MqttBackedConnectionStatusMonitor mqttBackedConnectionStatusMonitor) {
            this.f11133a = mqttBackedConnectionStatusMonitor;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 278435380);
            if (this.f11133a.f8515c.d()) {
                State a2 = MqttBackedConnectionStatusMonitor.m8761a(this.f11133a, this.f11133a.f8514b.b());
                if (a2 != this.f11133a.f8520h) {
                    MqttBackedConnectionStatusMonitor.m8763a(this.f11133a, a2);
                }
            } else {
                MqttBackedConnectionStatusMonitor.m8763a(this.f11133a, State.NO_INTERNET);
            }
            LogUtils.e(-1298948111, a);
        }
    }

    /* compiled from: mThreadsCacheLock */
    class C05302 implements ActionReceiver {
        final /* synthetic */ MqttBackedConnectionStatusMonitor f11134a;

        C05302(MqttBackedConnectionStatusMonitor mqttBackedConnectionStatusMonitor) {
            this.f11134a = mqttBackedConnectionStatusMonitor;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 651492686);
            MqttBackedConnectionStatusMonitor.m8763a(this.f11134a, MqttBackedConnectionStatusMonitor.m8761a(this.f11134a, this.f11134a.f8514b.b()));
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 82968291, a);
        }
    }

    /* compiled from: mThreadsCacheLock */
    class C05311 implements ActionReceiver {
        final /* synthetic */ MqttBackedConnectionStatusMonitor f11135a;

        C05311(MqttBackedConnectionStatusMonitor mqttBackedConnectionStatusMonitor) {
            this.f11135a = mqttBackedConnectionStatusMonitor;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1254691023);
            MqttBackedConnectionStatusMonitor.m8763a(this.f11135a, MqttBackedConnectionStatusMonitor.m8761a(this.f11135a, this.f11135a.f8514b.b()));
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1870669941, a);
        }
    }

    /* compiled from: mThreadsCacheLock */
    public /* synthetic */ class C05635 {
        public static final /* synthetic */ int[] f11625a = new int[ConnectionState.values().length];

        static {
            try {
                f11625a[ConnectionState.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11625a[ConnectionState.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11625a[ConnectionState.DISCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static com.facebook.messaging.connectivity.MqttBackedConnectionStatusMonitor m8762a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8513k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.connectivity.MqttBackedConnectionStatusMonitor.class;
        monitor-enter(r1);
        r0 = f8513k;	 Catch:{ all -> 0x003a }
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
        r0 = m8764b(r0);	 Catch:{ all -> 0x0035 }
        f8513k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8513k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.connectivity.MqttBackedConnectionStatusMonitor.a(com.facebook.inject.InjectorLike):com.facebook.messaging.connectivity.MqttBackedConnectionStatusMonitor");
    }

    private static MqttBackedConnectionStatusMonitor m8764b(InjectorLike injectorLike) {
        return new MqttBackedConnectionStatusMonitor(ChannelConnectivityTracker.a(injectorLike), FbNetworkManager.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), NetChecker.m8781a(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), ContentResolverMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public MqttBackedConnectionStatusMonitor(ChannelConnectivityTracker channelConnectivityTracker, FbNetworkManager fbNetworkManager, BaseFbBroadcastManager baseFbBroadcastManager, NetChecker netChecker, ScheduledExecutorService scheduledExecutorService, ContentResolver contentResolver) {
        this.f8514b = channelConnectivityTracker;
        this.f8515c = fbNetworkManager;
        this.f8516d = baseFbBroadcastManager;
        this.f8517e = netChecker;
        this.f8518f = scheduledExecutorService;
        this.f8519g = contentResolver;
    }

    public final void mo690e() {
        this.f8516d.a().a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", new C05293(this)).a("com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED", new C05302(this)).a("com.facebook.common.netchecker.ACTION_NETCHECK_STATE_CHANGED", new C05311(this)).a().b();
        if (!this.f8515c.d()) {
            m8765b(this, State.NO_INTERNET);
        } else if (this.f8514b.b() == ConnectionState.DISCONNECTED) {
            m8765b(this, State.WAITING_TO_CONNECT);
        }
    }

    public final State mo684a() {
        if (this.f8520h == State.CONNECTING && this.f8517e.f8536m == NetCheckState.CAPTIVE_PORTAL) {
            return State.CONNECTED_CAPTIVE_PORTAL;
        }
        return this.f8520h;
    }

    public final boolean mo685a(ConnectionType connectionType) {
        return mo686b();
    }

    public final boolean mo686b() {
        return this.f8520h == State.CONNECTED;
    }

    public final boolean mo687b(ConnectionType connectionType) {
        return mo688c();
    }

    public final boolean mo688c() {
        return this.f8521i.isPresent() && this.f8521i.get() == State.CONNECTED;
    }

    public final boolean mo689d() {
        if (VERSION.SDK_INT < 17) {
            if (System.getInt(this.f8519g, "airplane_mode_on", 0) != 0) {
                return true;
            }
            return false;
        } else if (Global.getInt(this.f8519g, "airplane_mode_on", 0) == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void m8763a(MqttBackedConnectionStatusMonitor mqttBackedConnectionStatusMonitor, final State state) {
        new StringBuilder("Handling potential change to: ").append(state);
        if (mqttBackedConnectionStatusMonitor.f8522j != null) {
            mqttBackedConnectionStatusMonitor.f8522j.cancel(false);
        }
        if (mqttBackedConnectionStatusMonitor.f8520h == State.CONNECTED) {
            mqttBackedConnectionStatusMonitor.f8522j = mqttBackedConnectionStatusMonitor.f8518f.schedule(new Runnable(mqttBackedConnectionStatusMonitor) {
                final /* synthetic */ MqttBackedConnectionStatusMonitor f11640b;

                public void run() {
                    MqttBackedConnectionStatusMonitor.m8765b(this.f11640b, state);
                }
            }, 5000, TimeUnit.MILLISECONDS);
            return;
        }
        m8765b(mqttBackedConnectionStatusMonitor, state);
    }

    public static void m8765b(MqttBackedConnectionStatusMonitor mqttBackedConnectionStatusMonitor, State state) {
        mqttBackedConnectionStatusMonitor.f8521i = Optional.of(mqttBackedConnectionStatusMonitor.f8520h);
        mqttBackedConnectionStatusMonitor.f8520h = state;
        mqttBackedConnectionStatusMonitor.f8516d.a(new Intent("com.facebook.orca.CONNECTIVITY_CHANGED"));
    }

    static /* synthetic */ State m8761a(MqttBackedConnectionStatusMonitor mqttBackedConnectionStatusMonitor, ConnectionState connectionState) {
        State state;
        switch (C05635.f11625a[connectionState.ordinal()]) {
            case 1:
                state = State.CONNECTED;
                break;
            case 2:
                state = State.CONNECTING;
                break;
            default:
                state = State.WAITING_TO_CONNECT;
                break;
        }
        return state;
    }
}
