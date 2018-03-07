package com.facebook.common.netchecker;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import com.facebook.analytics.MqttAnalyticsLogger;
import com.facebook.base.broadcast.BackgroundBroadcastThread;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.Handler_BackgroundBroadcastThreadMethodAutoProvider;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.powermanagement.listener.RadioPowerStateChange;
import com.facebook.push.mqtt.external.PushStateEvent;
import com.facebook.push.mqtt.service.ChannelConnectivityTracker;
import com.facebook.push.mqtt.service.ConnectionState;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: mTextureView.getParent is not null after removeView */
public class NetChecker implements INeedInit, RadioPowerStateChange {
    public static final ListenableFuture f8523a = Futures.a(null);
    private static volatile NetChecker f8524o;
    private final ScheduledExecutorService f8525b;
    public final MonotonicClock f8526c;
    public final CaptivePortalDetector f8527d;
    public final BaseFbBroadcastManager f8528e;
    public final FbNetworkManager f8529f;
    public final ChannelConnectivityTracker f8530g;
    private final MqttAnalyticsLogger f8531h;
    @BackgroundBroadcastThread
    public final Handler f8532i;
    private final Provider<Boolean> f8533j;
    private final Product f8534k;
    private volatile long f8535l;
    public volatile NetCheckState f8536m = NetCheckState.NOT_CHECKED;
    private volatile Future<?> f8537n = f8523a;

    /* compiled from: mTextureView.getParent is not null after removeView */
    public class C04372 implements ActionReceiver {
        final /* synthetic */ NetChecker f9774a;

        public C04372(NetChecker netChecker) {
            this.f9774a = netChecker;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1814298741);
            NetChecker.m8787g(this.f9774a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -822078956, a);
        }
    }

    /* compiled from: mTextureView.getParent is not null after removeView */
    public class C04383 implements ActionReceiver {
        final /* synthetic */ NetChecker f9775a;

        public C04383(NetChecker netChecker) {
            this.f9775a = netChecker;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1655536180);
            this.f9775a.m8793e();
            if (NetChecker.m8786b(this.f9775a.f8529f.i())) {
                this.f9775a.m8789a(10000);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1146271394, a);
        }
    }

    /* compiled from: mTextureView.getParent is not null after removeView */
    public class C04394 implements ActionReceiver {
        final /* synthetic */ NetChecker f9776a;

        public C04394(NetChecker netChecker) {
            this.f9776a = netChecker;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 312428427);
            NetChecker.m8784a(this.f9776a, PushStateEvent.fromValue(intent.getIntExtra("event", PushStateEvent.UNKNOWN.toValue())));
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -673813894, a);
        }
    }

    /* compiled from: mTextureView.getParent is not null after removeView */
    public /* synthetic */ class C04405 {
        public static final /* synthetic */ int[] f9777a = new int[ConnectionState.values().length];

        static {
            try {
                f9777a[ConnectionState.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9777a[ConnectionState.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9777a[ConnectionState.DISCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static com.facebook.common.netchecker.NetChecker m8781a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8524o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.netchecker.NetChecker.class;
        monitor-enter(r1);
        r0 = f8524o;	 Catch:{ all -> 0x003a }
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
        r0 = m8785b(r0);	 Catch:{ all -> 0x0035 }
        f8524o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8524o;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.netchecker.NetChecker.a(com.facebook.inject.InjectorLike):com.facebook.common.netchecker.NetChecker");
    }

    private static NetChecker m8785b(InjectorLike injectorLike) {
        return new NetChecker(ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), new CaptivePortalDetector(FbHttpRequestProcessor.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike)), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), FbNetworkManager.a(injectorLike), ChannelConnectivityTracker.a(injectorLike), MqttAnalyticsLogger.m8797a(injectorLike), Handler_BackgroundBroadcastThreadMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3927), ProductMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public NetChecker(ScheduledExecutorService scheduledExecutorService, MonotonicClock monotonicClock, CaptivePortalDetector captivePortalDetector, FbBroadcastManager fbBroadcastManager, FbNetworkManager fbNetworkManager, ChannelConnectivityTracker channelConnectivityTracker, MqttAnalyticsLogger mqttAnalyticsLogger, Handler handler, Provider<Boolean> provider, Product product) {
        this.f8525b = scheduledExecutorService;
        this.f8526c = monotonicClock;
        this.f8527d = captivePortalDetector;
        this.f8528e = fbBroadcastManager;
        this.f8529f = fbNetworkManager;
        this.f8530g = channelConnectivityTracker;
        this.f8531h = mqttAnalyticsLogger;
        this.f8532i = handler;
        this.f8533j = provider;
        this.f8534k = product;
    }

    public final NetCheckState m8791c() {
        return this.f8536m;
    }

    public final long m8792d() {
        return this.f8535l;
    }

    @VisibleForTesting
    final synchronized void m8789a(int i) {
        if (((Boolean) this.f8533j.get()).booleanValue() && this.f8534k == Product.MESSENGER) {
            this.f8537n = this.f8525b.schedule(new 1(this, this.f8529f.t()), (long) i, TimeUnit.MILLISECONDS);
        }
    }

    public static void m8787g(NetChecker netChecker) {
        if (netChecker.f8536m == NetCheckState.CAPTIVE_PORTAL && netChecker.f8537n == f8523a && m8786b(netChecker.f8529f.i())) {
            netChecker.m8789a(10000);
        }
    }

    public void init() {
        C04372 c04372 = new C04372(this);
        this.f8528e.a().a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", new C04383(this)).a().b();
        this.f8528e.a().a(AppStateManager.b, c04372).a(this.f8532i).a().b();
        this.f8528e.a().a("com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED", new C04394(this)).a().b();
        PushStateEvent pushStateEvent = PushStateEvent.UNKNOWN;
        switch (C04405.f9777a[this.f8530g.b().ordinal()]) {
            case 1:
                pushStateEvent = PushStateEvent.CHANNEL_CONNECTED;
                break;
            case 2:
                pushStateEvent = PushStateEvent.CHANNEL_CONNECTING;
                break;
            case 3:
                pushStateEvent = PushStateEvent.CHANNEL_DISCONNECTED;
                break;
        }
        m8784a(this, pushStateEvent);
        m8793e();
        m8789a(10000);
    }

    public static void m8784a(NetChecker netChecker, PushStateEvent pushStateEvent) {
        if (pushStateEvent == PushStateEvent.CHANNEL_CONNECTED) {
            netChecker.f8535l = netChecker.f8526c.now();
            m8783a(netChecker, NetCheckState.NOT_CAPTIVE_PORTAL);
            netChecker.f8537n.cancel(true);
            netChecker.f8537n = f8523a;
        }
    }

    @VisibleForTesting
    final synchronized void m8793e() {
        this.f8537n.cancel(true);
        this.f8537n = f8523a;
        this.f8535l = 0;
        m8783a(this, NetCheckState.NOT_CHECKED);
    }

    public static synchronized void m8783a(NetChecker netChecker, NetCheckState netCheckState) {
        synchronized (netChecker) {
            NetCheckState netCheckState2 = netChecker.f8536m;
            netChecker.f8536m = netCheckState;
            if (netChecker.f8536m != netCheckState2) {
                netChecker.f8528e.a(new Intent("com.facebook.common.netchecker.ACTION_NETCHECK_STATE_CHANGED").putExtra("state", netChecker.f8536m.name()));
            }
            netChecker.f8531h.m8800a(netChecker.f8536m.toString(), netChecker.f8535l);
        }
    }

    public static boolean m8786b(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.getType() == 1;
    }

    public final void mo691a() {
        m8787g(this);
    }

    public final void mo692b() {
    }
}
