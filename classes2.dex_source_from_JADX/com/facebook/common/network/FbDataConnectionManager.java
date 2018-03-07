package com.facebook.common.network;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.Handler_BackgroundBroadcastThreadMethodAutoProvider;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.C0109x696ccb0c;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.hardware.TelephonyManagerUtils;
import com.facebook.common.init.INeedInit;
import com.facebook.common.network.ServerConnectionQualityManager.ServerConnectionQualityManagerStateChangeListener;
import com.facebook.common.util.TriState;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.http.observer.ConnectionQualityTraceLogger;
import com.facebook.http.observer.DataConnectionXConfig;
import com.facebook.http.observer.DownloadBandwidthManager;
import com.facebook.http.observer.DownloadBandwidthManager.DownloadBandwidthManagerStateChangeListener;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: unseen_pack_count */
public class FbDataConnectionManager implements INeedInit, ServerConnectionQualityManagerStateChangeListener, DownloadBandwidthManagerStateChangeListener {
    public static final String f1876a = (FbDataConnectionManager.class.getCanonicalName() + ".DATA_CONNECTION_STATE_CHANGE");
    public static final String f1877b = (FbDataConnectionManager.class.getCanonicalName() + ".BANDWIDTH_STATE");
    public static final String f1878c = (FbDataConnectionManager.class.getCanonicalName() + ".LATENCY_STATE");
    public static final String f1879d = (FbDataConnectionManager.class.getCanonicalName() + ".CONNECTION_STATE");
    private static volatile FbDataConnectionManager f1880z;
    private final FbNetworkManager f1881e;
    private final BaseFbBroadcastManager f1882f;
    public final ScheduledExecutorService f1883g;
    private final DownloadBandwidthManager f1884h;
    private final ServerConnectionQualityManager f1885i;
    private final HistoricalConnectionQuality f1886j;
    private final Provider<TriState> f1887k;
    public final ConnectionQualityTraceLogger f1888l;
    public final XConfigReader f1889m;
    private final DefaultAndroidThreadUtil f1890n;
    private final Handler f1891o;
    private final ActionReceiver f1892p;
    private final ActionReceiver f1893q;
    private final ActionReceiver f1894r;
    public final ConnectionQualityResetRunnable f1895s = new ConnectionQualityResetRunnable(this);
    public boolean f1896t = true;
    private final AtomicReference<ConnectionQuality> f1897u = new AtomicReference(ConnectionQuality.UNKNOWN);
    private final AtomicReference<ConnectionQuality> f1898v = new AtomicReference(ConnectionQuality.UNKNOWN);
    private final AtomicReference<String> f1899w = new AtomicReference(null);
    private volatile boolean f1900x = false;
    public volatile NetworkInfo f1901y = null;

    /* compiled from: unseen_pack_count */
    class ConnectionQualityResetRunnable implements Runnable {
        final /* synthetic */ FbDataConnectionManager f2032a;

        public ConnectionQualityResetRunnable(FbDataConnectionManager fbDataConnectionManager) {
            this.f2032a = fbDataConnectionManager;
        }

        public void run() {
            if (!this.f2032a.f1896t) {
                this.f2032a.m3805g();
                FbDataConnectionManager.m3794n(this.f2032a);
            }
        }
    }

    /* compiled from: unseen_pack_count */
    class C01421 implements ActionReceiver {
        final /* synthetic */ FbDataConnectionManager f2033a;

        C01421(FbDataConnectionManager fbDataConnectionManager) {
            this.f2033a = fbDataConnectionManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -234976014);
            this.f2033a.f1896t = true;
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -249189894, a);
        }
    }

    /* compiled from: unseen_pack_count */
    class C01432 implements ActionReceiver {
        final /* synthetic */ FbDataConnectionManager f2034a;

        C01432(FbDataConnectionManager fbDataConnectionManager) {
            this.f2034a = fbDataConnectionManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -503792413);
            this.f2034a.f1896t = false;
            this.f2034a.f1883g.schedule(this.f2034a.f1895s, this.f2034a.f1889m.m2684a(DataConnectionXConfig.f15123e, 15000), TimeUnit.MILLISECONDS);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1949042527, a);
        }
    }

    /* compiled from: unseen_pack_count */
    class C01443 implements ActionReceiver {
        final /* synthetic */ FbDataConnectionManager f2035a;

        C01443(FbDataConnectionManager fbDataConnectionManager) {
            this.f2035a = fbDataConnectionManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -736833504);
            this.f2035a.m3797a();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -2097270793, a);
        }
    }

    public static com.facebook.common.network.FbDataConnectionManager m3787a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1880z;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.network.FbDataConnectionManager.class;
        monitor-enter(r1);
        r0 = f1880z;	 Catch:{ all -> 0x003a }
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
        r0 = m3788b(r0);	 Catch:{ all -> 0x0035 }
        f1880z = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1880z;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.network.FbDataConnectionManager.a(com.facebook.inject.InjectorLike):com.facebook.common.network.FbDataConnectionManager");
    }

    private static FbDataConnectionManager m3788b(InjectorLike injectorLike) {
        return new FbDataConnectionManager(FbNetworkManager.m3811a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike), C0109x696ccb0c.m2944a(injectorLike), DownloadBandwidthManager.m4071a(injectorLike), ServerConnectionQualityManager.m4095a(injectorLike), HistoricalConnectionQuality.m4107a(injectorLike), IdBasedProvider.m1811a(injectorLike, 649), ConnectionQualityTraceLogger.m4087a(injectorLike), XConfigReader.m2681a(injectorLike), DefaultAndroidThreadUtil.m1646b(injectorLike), Handler_BackgroundBroadcastThreadMethodAutoProvider.m4110a(injectorLike));
    }

    @Inject
    public FbDataConnectionManager(FbNetworkManager fbNetworkManager, FbBroadcastManager fbBroadcastManager, ScheduledExecutorService scheduledExecutorService, DownloadBandwidthManager downloadBandwidthManager, ServerConnectionQualityManager serverConnectionQualityManager, HistoricalConnectionQuality historicalConnectionQuality, Provider<TriState> provider, ConnectionQualityTraceLogger connectionQualityTraceLogger, XConfigReader xConfigReader, AndroidThreadUtil androidThreadUtil, Handler handler) {
        this.f1881e = fbNetworkManager;
        this.f1882f = fbBroadcastManager;
        this.f1884h = downloadBandwidthManager;
        this.f1883g = scheduledExecutorService;
        this.f1885i = serverConnectionQualityManager;
        this.f1886j = historicalConnectionQuality;
        this.f1887k = provider;
        this.f1888l = connectionQualityTraceLogger;
        this.f1889m = xConfigReader;
        this.f1890n = androidThreadUtil;
        this.f1891o = handler;
        this.f1893q = new C01421(this);
        this.f1892p = new C01432(this);
        this.f1894r = new C01443(this);
    }

    @VisibleForTesting
    final void m3797a() {
        m3792l();
        this.f1901y = null;
        this.f1883g.schedule(new NetworkConnectivityChangeRunnable(this, m3790j(this)), this.f1889m.m2684a(DataConnectionXConfig.f15122d, 10000), TimeUnit.MILLISECONDS);
    }

    public void init() {
        if (!this.f1900x && !this.f1890n.m1659c()) {
            synchronized (this) {
                if (!this.f1900x) {
                    m3789i();
                    this.f1900x = true;
                }
            }
        }
    }

    private void m3789i() {
        this.f1897u.set(this.f1884h.m4084a((DownloadBandwidthManagerStateChangeListener) this));
        this.f1898v.set(this.f1885i.m4104a((ServerConnectionQualityManagerStateChangeListener) this));
        m3791k();
        if (this.f1882f != null) {
            this.f1882f.m2951a().mo506a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", this.f1894r).mo503a().m3296b();
            this.f1882f.m2951a().mo506a(AppStateManager.f1110b, this.f1893q).mo506a(AppStateManager.f1111c, this.f1892p).mo505a(this.f1891o).mo503a().m3296b();
        }
    }

    public final ConnectionQuality m3799b() {
        init();
        return (ConnectionQuality) this.f1897u.get();
    }

    public final ConnectionQuality m3801c() {
        init();
        ConnectionQuality b = m3799b();
        if (!b.equals(ConnectionQuality.UNKNOWN)) {
            return b;
        }
        NetworkInfo p = m3796p();
        if (p == null) {
            return ConnectionQuality.UNKNOWN;
        }
        b = this.f1886j.m4109a(m3795o());
        if (b.equals(ConnectionQuality.UNKNOWN)) {
            return TelephonyManagerUtils.m27407a(p.getType(), p.getSubtype()) ? ConnectionQuality.POOR : ConnectionQuality.GOOD;
        } else {
            return b;
        }
    }

    public final ConnectionQuality m3802d() {
        init();
        return (ConnectionQuality) this.f1898v.get();
    }

    public final double m3803e() {
        return this.f1884h.m4086b();
    }

    public final double m3804f() {
        ServerConnectionQualityManager serverConnectionQualityManager = this.f1885i;
        return serverConnectionQualityManager.f2023k == null ? -1.0d : serverConnectionQualityManager.f2023k.mo2837a();
    }

    public final void mo557a(ConnectionQuality connectionQuality) {
        this.f1897u.set(connectionQuality);
        m3794n(this);
    }

    public final void mo558b(ConnectionQuality connectionQuality) {
        this.f1898v.set(connectionQuality);
        m3794n(this);
    }

    public static boolean m3790j(FbDataConnectionManager fbDataConnectionManager) {
        return fbDataConnectionManager.f1881e.m3828d();
    }

    public final void m3805g() {
        m3791k();
        this.f1897u.set(ConnectionQuality.UNKNOWN);
        this.f1898v.set(ConnectionQuality.UNKNOWN);
        this.f1885i.m4105a();
        DownloadBandwidthManager downloadBandwidthManager = this.f1884h;
        if (downloadBandwidthManager.f1999c != null) {
            downloadBandwidthManager.f1999c.mo2839b();
        }
        downloadBandwidthManager.f2001e.set(ConnectionQuality.UNKNOWN);
    }

    private void m3791k() {
        if (((TriState) this.f1887k.get()).asBoolean(false)) {
            ConnectionQualityTraceLogger connectionQualityTraceLogger = this.f1888l;
            int i = 0;
            connectionQualityTraceLogger.f2011e.incrementAndGet();
            if (connectionQualityTraceLogger.f2010d.get() == 1337 && connectionQualityTraceLogger.f2008b.nextDouble() < 1.0E-4d) {
                connectionQualityTraceLogger.f2009c.set(new String[HTTPTransportCallback.BODY_BYTES_RECEIVED]);
                connectionQualityTraceLogger.f2010d.set(0);
                i = 1;
            }
            connectionQualityTraceLogger.f2011e.decrementAndGet();
            if (i != 0) {
                this.f1888l.m4092a(m3803e(), m3804f());
                m3793m();
            }
        }
    }

    private void m3792l() {
        if (((TriState) this.f1887k.get()).asBoolean(false)) {
            m3793m();
        }
    }

    private void m3793m() {
        NetworkInfo p = m3796p();
        String o = p == null ? "DISCONNECTED" : m3795o();
        String str = (String) this.f1899w.get();
        if (!o.equals(str) && this.f1899w.compareAndSet(str, o)) {
            if (p != null) {
                this.f1888l.m4094a(m3795o(), this.f1886j.m4109a(m3795o()));
            } else {
                this.f1888l.m4094a("DISCONNECTED", ConnectionQuality.UNKNOWN);
            }
        }
    }

    public static void m3794n(FbDataConnectionManager fbDataConnectionManager) {
        if (fbDataConnectionManager.f1882f != null) {
            Intent intent = new Intent();
            intent.setAction(f1876a).putExtra(f1877b, (Serializable) fbDataConnectionManager.f1897u.get()).putExtra(f1878c, (Serializable) fbDataConnectionManager.f1898v.get()).putExtra(f1879d, m3790j(fbDataConnectionManager));
            fbDataConnectionManager.f1882f.mo406a(intent);
        }
        HistoricalConnectionQuality historicalConnectionQuality = fbDataConnectionManager.f1886j;
        String o = fbDataConnectionManager.m3795o();
        ConnectionQuality connectionQuality = (ConnectionQuality) fbDataConnectionManager.f1897u.get();
        if (historicalConnectionQuality.f2028d.mo284a() && !connectionQuality.equals(ConnectionQuality.UNKNOWN) && !connectionQuality.equals(historicalConnectionQuality.f2029e.get(o))) {
            historicalConnectionQuality.f2029e.put(o, connectionQuality);
            historicalConnectionQuality.f2028d.edit().mo1276a((PrefKey) HistoricalConnectionQuality.f2024a.m2011a(o), connectionQuality.toString()).commit();
        }
    }

    private String m3795o() {
        NetworkInfo p = m3796p();
        if (p == null) {
            return "UNKNOWN";
        }
        switch (p.getType()) {
            case 0:
                return TelephonyManagerUtils.m27405a(p.getSubtype());
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                if (this.f1881e.m3832h()) {
                    return "HOTSPOT";
                }
                return "WIFI";
            default:
                return "UNKNOWN";
        }
    }

    private NetworkInfo m3796p() {
        if (this.f1901y == null) {
            this.f1901y = this.f1881e.m3833i();
        }
        return this.f1901y;
    }
}
