package com.facebook.upnp;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.init.INeedInit;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: threads LEFT JOIN thread_participants ON  */
public class UpnpDiscovery implements INeedInit {
    public static final Set<String> f3015a = new TreeSet();
    public static final Set<String> f3016b = new TreeSet();
    private static final Class<?> f3017c = UpnpDiscovery.class;
    public static boolean f3018k = false;
    private static volatile UpnpDiscovery f3019l;
    public final Lazy<FbHttpRequestProcessor> f3020d;
    private final BaseFbBroadcastManager f3021e;
    public final FbNetworkManager f3022f;
    public final DefaultAndroidThreadUtil f3023g;
    public final GatekeeperStoreImpl f3024h;
    private final AnalyticsLogger f3025i;
    public final Clock f3026j;

    /* compiled from: threads LEFT JOIN thread_participants ON  */
    class C01881 implements ActionReceiver {
        final /* synthetic */ UpnpDiscovery f3027a;

        C01881(UpnpDiscovery upnpDiscovery) {
            this.f3027a = upnpDiscovery;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -920112598);
            if (this.f3027a.f3024h.m2189a(558, false)) {
                NetworkInfo i = this.f3027a.f3022f.m3833i();
                if (i != null && i.getType() == 1) {
                    WifiInfo o = this.f3027a.f3022f.m3838o();
                    if (o != null) {
                        UpnpDiscovery.f3015a.add(o.getBSSID());
                        UpnpDiscovery upnpDiscovery = this.f3027a;
                        if (UpnpDiscovery.m4998a() != null) {
                            upnpDiscovery.f3023g.m1648a(new RunDiscoveryTask(upnpDiscovery), r2);
                        }
                    }
                }
                LogUtils.e(-1168817508, a);
                return;
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1092502108, a);
        }
    }

    public static com.facebook.upnp.UpnpDiscovery m4997a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3019l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.upnp.UpnpDiscovery.class;
        monitor-enter(r1);
        r0 = f3019l;	 Catch:{ all -> 0x003a }
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
        r0 = m5001b(r0);	 Catch:{ all -> 0x0035 }
        f3019l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3019l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.upnp.UpnpDiscovery.a(com.facebook.inject.InjectorLike):com.facebook.upnp.UpnpDiscovery");
    }

    private static UpnpDiscovery m5001b(InjectorLike injectorLike) {
        return new UpnpDiscovery(IdBasedSingletonScopeProvider.m1810b(injectorLike, 2217), LocalFbBroadcastManager.m2946a(injectorLike), FbNetworkManager.m3811a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), DefaultAndroidThreadUtil.m1646b(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    @Inject
    UpnpDiscovery(Lazy<FbHttpRequestProcessor> lazy, FbBroadcastManager fbBroadcastManager, FbNetworkManager fbNetworkManager, GatekeeperStore gatekeeperStore, AndroidThreadUtil androidThreadUtil, AnalyticsLogger analyticsLogger, Clock clock) {
        this.f3020d = lazy;
        this.f3021e = fbBroadcastManager;
        this.f3022f = fbNetworkManager;
        this.f3024h = gatekeeperStore;
        this.f3023g = androidThreadUtil;
        this.f3025i = analyticsLogger;
        this.f3026j = clock;
    }

    public void init() {
        this.f3021e.m2951a().mo506a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", new C01881(this)).mo503a().m3296b();
    }

    @Nullable
    public static InetAddress m4998a() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                if (networkInterface.getName().equals("wlan0")) {
                    Enumeration inetAddresses = networkInterface.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            return inetAddress;
                        }
                    }
                    continue;
                }
            }
            return null;
        } catch (SocketException e) {
            return null;
        }
    }

    private HoneyClientEvent m4996a(UpnpDevice upnpDevice, String str, String str2, String str3, long j, String str4) {
        Object obj;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("ntt_discovered_device");
        honeyClientEvent.m5090b("type", str2);
        honeyClientEvent.m5090b("scan_start_time", Long.toString(j));
        honeyClientEvent.m5090b("count", Long.toString(upnpDevice.f));
        honeyClientEvent.m5090b("hash", str);
        if (f3016b.contains(str)) {
            obj = null;
        } else {
            f3016b.add(str);
            obj = 1;
        }
        if (obj != null) {
            honeyClientEvent.m5090b("body", str3);
        } else {
            honeyClientEvent.m5090b("body", "");
        }
        honeyClientEvent.m5090b("linked_hash", str4);
        return honeyClientEvent;
    }

    public static void m4999a(UpnpDiscovery upnpDiscovery, UpnpDevice upnpDevice, long j) {
        String c = upnpDevice.c();
        String d = upnpDevice.d();
        upnpDiscovery.f3025i.mo526a(upnpDiscovery.m4996a(upnpDevice, c, "ssdp", upnpDevice.b(), j, d));
        upnpDiscovery.f3025i.mo526a(upnpDiscovery.m4996a(upnpDevice, d, "xml", upnpDevice.b == null ? "" : upnpDevice.b, j, c));
    }
}
