package com.facebook.common.network;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v4.net.ConnectivityManagerCompat;
import android.telephony.TelephonyManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossFbAppBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.android.ConnectivityManagerMethodAutoProvider;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.common.android.WifiManagerMethodAutoProvider;
import com.facebook.common.collect.RingBuffer;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.flightrecorder.FbHttpNetworkCustomDataSupplier;
import com.facebook.common.flightrecorder.FlightRecorderEvent;
import com.facebook.common.hardware.NetworkConnectionChanged;
import com.facebook.common.hardware.TelephonyManagerUtils;
import com.facebook.common.init.INeedInit;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringUtil;
import com.facebook.http.onion.TorProxy;
import com.facebook.http.onion.TorProxyMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import com.google.common.base.Absent;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: unpin_thread */
public class FbNetworkManager implements FbHttpNetworkCustomDataSupplier, INeedInit {
    private static volatile FbNetworkManager f1902z;
    private final ConnectivityManager f1903a;
    public final TelephonyManager f1904b;
    private final WifiManager f1905c;
    public final MonotonicClock f1906d;
    private final BaseFbBroadcastManager f1907e;
    public final BaseFbBroadcastManager f1908f;
    private final AbstractFbErrorReporter f1909g;
    private final TorProxy f1910h;
    private final QeAccessor f1911i;
    private final RingBuffer<FlightRecorderEvent> f1912j;
    private final Object f1913k = new Object();
    public NetworkConnectionChanged f1914l;
    private long f1915m = Long.MIN_VALUE;
    private long f1916n = Long.MIN_VALUE;
    public volatile long f1917o;
    public volatile long f1918p;
    private volatile Boolean f1919q;
    private final AtomicInteger f1920r = new AtomicInteger(0);
    private final AtomicInteger f1921s = new AtomicInteger(0);
    public final Object f1922t = new Object();
    @GuardedBy("mCurrentNetworkInfoLock")
    private NetworkInfo f1923u;
    @GuardedBy("mCurrentNetworkInfoLock")
    private String f1924v;
    @GuardedBy("mCurrentNetworkInfoLock")
    private String f1925w;
    @GuardedBy("mCurrentNetworkInfoLock")
    private String f1926x;
    private volatile boolean f1927y;

    public static com.facebook.common.network.FbNetworkManager m3811a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1902z;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.network.FbNetworkManager.class;
        monitor-enter(r1);
        r0 = f1902z;	 Catch:{ all -> 0x003a }
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
        r0 = m3816b(r0);	 Catch:{ all -> 0x0035 }
        f1902z = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1902z;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.network.FbNetworkManager.a(com.facebook.inject.InjectorLike):com.facebook.common.network.FbNetworkManager");
    }

    private static FbNetworkManager m3816b(InjectorLike injectorLike) {
        return new FbNetworkManager(ConnectivityManagerMethodAutoProvider.m3847b(injectorLike), TelephonyManagerMethodAutoProvider.m3851b(injectorLike), WifiManagerMethodAutoProvider.m3852b(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), CrossFbAppBroadcastManager.m3885a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), TorProxyMethodAutoProvider.m3888b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    static /* synthetic */ void m3814a(FbNetworkManager fbNetworkManager, int i) {
        if (i == 0) {
            fbNetworkManager.f1917o = 0;
        } else if (fbNetworkManager.f1917o == 0) {
            fbNetworkManager.f1917o = fbNetworkManager.f1906d.now();
        }
    }

    @Inject
    public FbNetworkManager(ConnectivityManager connectivityManager, TelephonyManager telephonyManager, WifiManager wifiManager, MonotonicClock monotonicClock, BaseFbBroadcastManager baseFbBroadcastManager, BaseFbBroadcastManager baseFbBroadcastManager2, AbstractFbErrorReporter abstractFbErrorReporter, TorProxy torProxy, QeAccessor qeAccessor) {
        this.f1903a = connectivityManager;
        this.f1904b = telephonyManager;
        this.f1905c = wifiManager;
        this.f1906d = monotonicClock;
        this.f1907e = baseFbBroadcastManager;
        this.f1908f = baseFbBroadcastManager2;
        this.f1909g = abstractFbErrorReporter;
        this.f1910h = torProxy;
        this.f1911i = qeAccessor;
        this.f1912j = new RingBuffer(10);
    }

    public void init() {
        m3826a(m3827b());
        1 1 = new 1(this);
        this.f1907e.m2951a().mo506a("android.net.conn.CONNECTIVITY_CHANGE", 1).mo506a("android.net.conn.INET_CONDITION_ACTION", 1).mo503a().m3296b();
        this.f1910h.mo561a(new 2(this));
    }

    @Nullable
    public final NetworkInfo m3827b() {
        NetworkInfo networkInfo;
        synchronized (this.f1922t) {
            if (this.f1927y) {
                networkInfo = null;
            } else {
                if (this.f1923u != null) {
                    networkInfo = this.f1923u;
                } else {
                    networkInfo = m3820w(this);
                    this.f1923u = networkInfo;
                }
            }
        }
        return networkInfo;
    }

    @Nullable
    public static NetworkInfo m3820w(FbNetworkManager fbNetworkManager) {
        try {
            NetworkInfo activeNetworkInfo = fbNetworkManager.f1903a.getActiveNetworkInfo();
            fbNetworkManager.f1920r.incrementAndGet();
            return activeNetworkInfo;
        } catch (Throwable e) {
            int incrementAndGet = fbNetworkManager.f1921s.incrementAndGet();
            if (incrementAndGet % 64 == 1) {
                fbNetworkManager.f1909g.mo336a(SoftError.a("FbNetworkManager", "success: " + fbNetworkManager.f1920r.get() + " failures: " + incrementAndGet).a(e).a(true).g());
            }
            return null;
        }
    }

    public static void m3821x(FbNetworkManager fbNetworkManager) {
        NetworkInfo b = fbNetworkManager.m3827b();
        boolean z = b != null && b.isConnected();
        Boolean.valueOf(z);
        fbNetworkManager.f1908f.m2955a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED");
        synchronized (fbNetworkManager.f1913k) {
            fbNetworkManager.f1915m = z ? fbNetworkManager.f1906d.now() : Long.MIN_VALUE;
            fbNetworkManager.f1916n = fbNetworkManager.f1906d.now();
            ObjectDetour.c(fbNetworkManager.f1913k, -1008380408);
        }
    }

    public final boolean m3828d() {
        NetworkInfo b = m3827b();
        return b != null && b.isConnected();
    }

    public final Optional<Long> m3829e() {
        Optional<Long> withType;
        synchronized (this.f1913k) {
            if (this.f1915m == Long.MIN_VALUE) {
                withType = Absent.withType();
            } else {
                withType = Optional.of(Long.valueOf(this.f1906d.now() - this.f1915m));
            }
        }
        return withType;
    }

    public final Optional<Long> m3830f() {
        Optional<Long> withType;
        synchronized (this.f1913k) {
            if (this.f1916n == Long.MIN_VALUE) {
                withType = Absent.withType();
            } else {
                withType = Optional.of(Long.valueOf(this.f1906d.now() - this.f1916n));
            }
        }
        return withType;
    }

    public final boolean m3831g() {
        NetworkInfo i = m3833i();
        if (i != null) {
            return TelephonyManagerUtils.m27407a(i.getType(), i.getSubtype());
        }
        return false;
    }

    public final boolean m3832h() {
        Boolean bool;
        if (this.f1919q != null) {
            bool = this.f1919q;
        } else {
            bool = Boolean.valueOf(m3822y(this));
            this.f1919q = bool;
        }
        return bool.booleanValue();
    }

    public static boolean m3822y(FbNetworkManager fbNetworkManager) {
        return ConnectivityManagerCompat.m11177a(fbNetworkManager.f1903a);
    }

    @Nullable
    public final NetworkInfo m3833i() {
        NetworkInfo b = m3827b();
        if (b == null || !b.isConnected()) {
            return null;
        }
        return b;
    }

    @Nonnull
    public final String m3834j() {
        CharSequence charSequence = null;
        NetworkInfo i = m3833i();
        if (i != null) {
            DetailedState detailedState = i.getDetailedState();
            if (detailedState != null) {
                charSequence = detailedState.name();
            }
        }
        if (StringUtil.m3589a(charSequence)) {
            return "none";
        }
        return charSequence;
    }

    @Nonnull
    public final String m3835k() {
        String str;
        synchronized (this.f1922t) {
            if (this.f1924v != null) {
                str = this.f1924v;
            } else {
                str = m3823z();
                this.f1924v = str;
            }
        }
        return str;
    }

    @Nonnull
    private String m3823z() {
        NetworkInfo i = m3833i();
        return (i == null || StringUtil.m3589a(i.getTypeName())) ? "none" : i.getTypeName().toLowerCase(Locale.US);
    }

    @Nonnull
    public final String m3836l() {
        String str;
        synchronized (this.f1922t) {
            if (this.f1925w != null) {
                str = this.f1925w;
            } else {
                str = m3809A();
                this.f1925w = str;
            }
        }
        return str;
    }

    @Nonnull
    private String m3809A() {
        NetworkInfo i = m3833i();
        return (i == null || StringUtil.m3589a(i.getSubtypeName())) ? "none" : i.getSubtypeName().toLowerCase(Locale.US);
    }

    @Nonnull
    public final String m3837m() {
        String str;
        synchronized (this.f1922t) {
            if (this.f1926x != null) {
                str = this.f1926x;
            } else {
                str = m3835k() + "-" + m3836l();
                this.f1926x = str;
            }
        }
        return str;
    }

    @Nullable
    public final WifiInfo m3838o() {
        WifiInfo wifiInfo = null;
        if (m3828d()) {
            try {
                wifiInfo = this.f1905c.getConnectionInfo();
            } catch (Exception e) {
            }
        }
        return wifiInfo;
    }

    @Nonnull
    public final String m3839p() {
        NetworkInfo i = m3833i();
        if (i != null) {
            return i.getTypeName() + "_" + i.getSubtypeName();
        }
        return "disconnected";
    }

    public final NetworkConnectionChanged m3840q() {
        return this.f1914l;
    }

    public final int m3841r() {
        WifiInfo connectionInfo = this.f1905c.getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getRssi() : Integer.MIN_VALUE;
    }

    public final int m3842s() {
        return WifiManager.calculateSignalLevel(m3841r(), 5);
    }

    public final long m3843t() {
        int type;
        int subtype;
        Object obj;
        Object obj2;
        NetworkInfo b = m3827b();
        WifiInfo connectionInfo = this.f1905c.getConnectionInfo();
        String str = "";
        State state = State.DISCONNECTED;
        State state2;
        if (b != null) {
            if (connectionInfo != null) {
                str = connectionInfo.getSSID();
            }
            type = b.getType();
            subtype = b.getSubtype();
            state = b.getState();
            b.getTypeName();
            b.getSubtypeName();
            b.getState().toString();
            state2 = state;
            obj = str;
            obj2 = state2;
        } else {
            subtype = 0;
            type = 0;
            state2 = state;
            String str2 = str;
            State state3 = state2;
        }
        return (long) Objects.hashCode(Integer.valueOf(type), Integer.valueOf(subtype), obj2, obj);
    }

    public final void m3826a(@Nullable NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnected()) {
            this.f1918p = 0;
        } else if (this.f1918p == 0) {
            this.f1918p = this.f1906d.now();
        }
    }

    public final List<FlightRecorderEvent> mo559a() {
        return this.f1912j.m4066b();
    }

    public final boolean m3844v() {
        NetworkInfo i = m3833i();
        if (i == null) {
            return false;
        }
        if (i.getType() == 1) {
            return true;
        }
        return false;
    }

    public final void m3825a(long j) {
        long now = this.f1906d.now() + j;
        long now2 = now - this.f1906d.now();
        synchronized (this.f1913k) {
            while (now2 > 0) {
                if (m3828d()) {
                    break;
                }
                ObjectDetour.a(this.f1913k, now2, -392204181);
                now2 = now - this.f1906d.now();
            }
        }
    }

    public static void m3815a(FbNetworkManager fbNetworkManager, NetworkInfo networkInfo, int i) {
        Object networkConnectionChanged = new NetworkConnectionChanged(networkInfo, i, fbNetworkManager.f1903a);
        NetworkConnectionChanged networkConnectionChanged2 = fbNetworkManager.f1914l;
        Object obj = null;
        if (networkConnectionChanged2 != null && Objects.equal(networkConnectionChanged.a, networkConnectionChanged2.a) && networkConnectionChanged.c == networkConnectionChanged2.c && networkConnectionChanged.d == networkConnectionChanged2.d) {
            obj = 1;
        }
        if (obj == null) {
            fbNetworkManager.f1914l = networkConnectionChanged;
            fbNetworkManager.f1912j.m4065a(networkConnectionChanged);
        }
    }
}
