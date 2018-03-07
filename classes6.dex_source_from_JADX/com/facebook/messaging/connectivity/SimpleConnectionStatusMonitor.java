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
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
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
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_media_attached */
public class SimpleConnectionStatusMonitor implements ConnectionStatusMonitor {
    private static volatile SimpleConnectionStatusMonitor f12044l;
    private final ChannelConnectivityTracker f12045a;
    private final FbNetworkManager f12046b;
    private final BaseFbBroadcastManager f12047c;
    private final NetChecker f12048d;
    private final ScheduledExecutorService f12049e;
    private Optional<State> f12050f;
    private ContentResolver f12051g;
    private final Map<ConnectionType, State> f12052h = new HashMap();
    private final Map<ConnectionType, Optional<State>> f12053i;
    public final ConnectivityBannerDisplayTracker f12054j;
    @Nullable
    private ScheduledFuture<?> f12055k;

    /* compiled from: is_media_attached */
    class C07781 implements ActionReceiver {
        final /* synthetic */ SimpleConnectionStatusMonitor f12042a;

        C07781(SimpleConnectionStatusMonitor simpleConnectionStatusMonitor) {
            this.f12042a = simpleConnectionStatusMonitor;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -2100887411);
            this.f12042a.f12054j.m18937a(intent.getAction(), SimpleConnectionStatusMonitor.m18950f(this.f12042a));
            SimpleConnectionStatusMonitor.m18951g(this.f12042a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1655866616, a);
        }
    }

    /* compiled from: is_media_attached */
    class C07792 implements Runnable {
        final /* synthetic */ SimpleConnectionStatusMonitor f12043a;

        C07792(SimpleConnectionStatusMonitor simpleConnectionStatusMonitor) {
            this.f12043a = simpleConnectionStatusMonitor;
        }

        public void run() {
            SimpleConnectionStatusMonitor.m18952h(this.f12043a);
        }
    }

    public static com.facebook.messaging.connectivity.SimpleConnectionStatusMonitor m18945a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12044l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.connectivity.SimpleConnectionStatusMonitor.class;
        monitor-enter(r1);
        r0 = f12044l;	 Catch:{ all -> 0x003a }
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
        r0 = m18946b(r0);	 Catch:{ all -> 0x0035 }
        f12044l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12044l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.connectivity.SimpleConnectionStatusMonitor.a(com.facebook.inject.InjectorLike):com.facebook.messaging.connectivity.SimpleConnectionStatusMonitor");
    }

    private static SimpleConnectionStatusMonitor m18946b(InjectorLike injectorLike) {
        return new SimpleConnectionStatusMonitor(ChannelConnectivityTracker.a(injectorLike), FbNetworkManager.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), NetChecker.a(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), ContentResolverMethodAutoProvider.b(injectorLike), ConnectivityBannerDisplayTracker.m18932a(injectorLike));
    }

    @Inject
    public SimpleConnectionStatusMonitor(ChannelConnectivityTracker channelConnectivityTracker, FbNetworkManager fbNetworkManager, BaseFbBroadcastManager baseFbBroadcastManager, NetChecker netChecker, ScheduledExecutorService scheduledExecutorService, ContentResolver contentResolver, ConnectivityBannerDisplayTracker connectivityBannerDisplayTracker) {
        this.f12045a = channelConnectivityTracker;
        this.f12046b = fbNetworkManager;
        this.f12047c = baseFbBroadcastManager;
        this.f12048d = netChecker;
        this.f12049e = scheduledExecutorService;
        this.f12051g = contentResolver;
        this.f12052h.put(ConnectionType.MQTT, State.CONNECTED);
        this.f12052h.put(ConnectionType.HTTP, State.CONNECTED);
        this.f12053i = new HashMap();
        this.f12053i.put(ConnectionType.MQTT, Absent.INSTANCE);
        this.f12053i.put(ConnectionType.HTTP, Absent.INSTANCE);
        this.f12050f = Absent.INSTANCE;
        this.f12054j = connectivityBannerDisplayTracker;
    }

    public final void m18959e() {
        m18952h(this);
        this.f12054j.m18937a("init", m18950f(this));
        C07781 c07781 = new C07781(this);
        this.f12047c.a().a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", c07781).a("com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED", c07781).a("com.facebook.common.netchecker.ACTION_NETCHECK_STATE_CHANGED", c07781).a().b();
    }

    public static synchronized String m18950f(SimpleConnectionStatusMonitor simpleConnectionStatusMonitor) {
        String stringBuilder;
        synchronized (simpleConnectionStatusMonitor) {
            Object obj;
            StringBuilder stringBuilder2 = new StringBuilder(512);
            stringBuilder2.append("FbNetworkManager.activeNetwork: ");
            StringBuilder append = ConnectivityBannerDisplayTracker.m18934a(stringBuilder2, simpleConnectionStatusMonitor.f12046b.b()).append(", FbNetworkManager.isConnected: ").append(simpleConnectionStatusMonitor.f12046b.d()).append(", ChannelConnectivityTracker.getConnectionState: ").append(simpleConnectionStatusMonitor.f12045a.b()).append(", NetChecker.getNetCheckState: ").append(simpleConnectionStatusMonitor.f12048d.c()).append(", CurrentState (mqtt): ").append(simpleConnectionStatusMonitor.f12052h.get(ConnectionType.MQTT)).append(", CurrentState (http): ").append(simpleConnectionStatusMonitor.f12052h.get(ConnectionType.HTTP)).append(", PreviousState (mqtt): ");
            if (((Optional) simpleConnectionStatusMonitor.f12053i.get(ConnectionType.MQTT)).isPresent()) {
                obj = (Serializable) ((Optional) simpleConnectionStatusMonitor.f12053i.get(ConnectionType.MQTT)).get();
            } else {
                obj = "n/a";
            }
            append = append.append(obj).append(", PreviousState (http): ");
            if (((Optional) simpleConnectionStatusMonitor.f12053i.get(ConnectionType.HTTP)).isPresent()) {
                obj = (Serializable) ((Optional) simpleConnectionStatusMonitor.f12053i.get(ConnectionType.HTTP)).get();
            } else {
                obj = "n/a";
            }
            append = append.append(obj).append(", PreviousState: ");
            if (simpleConnectionStatusMonitor.f12050f.isPresent()) {
                obj = (Serializable) simpleConnectionStatusMonitor.f12050f.get();
            } else {
                obj = "n/a";
            }
            append.append(obj);
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }

    private synchronized State m18947c(ConnectionType connectionType) {
        return (State) this.f12052h.get(connectionType);
    }

    public final State m18953a() {
        if (this.f12045a.b() == ConnectionState.CONNECTED || m18947c(ConnectionType.HTTP) != State.CONNECTED_CAPTIVE_PORTAL) {
            return m18955b() ? State.CONNECTED : State.NO_INTERNET;
        } else {
            return State.CONNECTED_CAPTIVE_PORTAL;
        }
    }

    public final boolean m18954a(ConnectionType connectionType) {
        return m18948d(connectionType);
    }

    public final boolean m18955b() {
        return m18948d(ConnectionType.MQTT) || m18948d(ConnectionType.HTTP);
    }

    public final boolean m18956b(ConnectionType connectionType) {
        return m18949e(connectionType);
    }

    public final synchronized boolean m18957c() {
        boolean z;
        z = this.f12050f.isPresent() && this.f12050f.get() == State.CONNECTED;
        return z;
    }

    public final boolean m18958d() {
        if (VERSION.SDK_INT < 17) {
            if (System.getInt(this.f12051g, "airplane_mode_on", 0) != 0) {
                return true;
            }
            return false;
        } else if (Global.getInt(this.f12051g, "airplane_mode_on", 0) == 0) {
            return false;
        } else {
            return true;
        }
    }

    private synchronized boolean m18948d(ConnectionType connectionType) {
        return this.f12052h.get(connectionType) == State.CONNECTED;
    }

    private synchronized boolean m18949e(ConnectionType connectionType) {
        boolean z;
        z = ((Optional) this.f12053i.get(connectionType)).isPresent() && ((Optional) this.f12053i.get(connectionType)).get() == State.CONNECTED;
        return z;
    }

    public static synchronized void m18951g(SimpleConnectionStatusMonitor simpleConnectionStatusMonitor) {
        synchronized (simpleConnectionStatusMonitor) {
            if (simpleConnectionStatusMonitor.f12055k != null) {
                simpleConnectionStatusMonitor.f12055k.cancel(false);
            }
            if (!simpleConnectionStatusMonitor.m18955b() || simpleConnectionStatusMonitor.m18958d()) {
                m18952h(simpleConnectionStatusMonitor);
            } else {
                simpleConnectionStatusMonitor.f12055k = simpleConnectionStatusMonitor.f12049e.schedule(new C07792(simpleConnectionStatusMonitor), 5000, TimeUnit.MILLISECONDS);
            }
        }
    }

    public static synchronized void m18952h(SimpleConnectionStatusMonitor simpleConnectionStatusMonitor) {
        synchronized (simpleConnectionStatusMonitor) {
            State state;
            State state2;
            State state3 = (State) simpleConnectionStatusMonitor.f12052h.get(ConnectionType.MQTT);
            State state4 = (State) simpleConnectionStatusMonitor.f12052h.get(ConnectionType.HTTP);
            if (simpleConnectionStatusMonitor.f12046b.d() || simpleConnectionStatusMonitor.f12045a.e()) {
                State state5;
                if (simpleConnectionStatusMonitor.f12048d.c() == NetCheckState.CAPTIVE_PORTAL) {
                    state5 = State.CONNECTED_CAPTIVE_PORTAL;
                } else {
                    state5 = State.CONNECTED;
                }
                if (simpleConnectionStatusMonitor.f12045a.e()) {
                    state = State.CONNECTED;
                    state2 = state5;
                } else {
                    state = State.NO_INTERNET;
                    state2 = state5;
                }
            } else {
                state = State.NO_INTERNET;
                state2 = State.NO_INTERNET;
            }
            if (!(state == state3 && ((Optional) simpleConnectionStatusMonitor.f12053i.get(ConnectionType.MQTT)).isPresent())) {
                simpleConnectionStatusMonitor.f12053i.put(ConnectionType.MQTT, Optional.of(state3));
            }
            if (!(state2 == state4 && ((Optional) simpleConnectionStatusMonitor.f12053i.get(ConnectionType.HTTP)).isPresent())) {
                simpleConnectionStatusMonitor.f12053i.put(ConnectionType.HTTP, Optional.of(state4));
            }
            if (!(state3 == state && state2 == state4 && simpleConnectionStatusMonitor.f12050f.isPresent())) {
                simpleConnectionStatusMonitor.f12050f = Optional.of(simpleConnectionStatusMonitor.m18955b() ? State.CONNECTED : State.NO_INTERNET);
            }
            simpleConnectionStatusMonitor.f12052h.put(ConnectionType.MQTT, state);
            simpleConnectionStatusMonitor.f12052h.put(ConnectionType.HTTP, state2);
            if (!(state2 == state4 && state == state3)) {
                simpleConnectionStatusMonitor.f12047c.a(new Intent("com.facebook.orca.CONNECTIVITY_CHANGED"));
            }
        }
    }
}
