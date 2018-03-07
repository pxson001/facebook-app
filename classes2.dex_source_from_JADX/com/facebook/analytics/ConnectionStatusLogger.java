package com.facebook.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.os.Handler;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.util.AnalyticsConnectionUtils;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.http.observer.ConnectionQualityTraceLogger;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: release_notes */
public class ConnectionStatusLogger {
    private static volatile ConnectionStatusLogger f7629p;
    private final Lazy<FbDataConnectionManager> f7630a;
    public final Lazy<FbBroadcastManager> f7631b;
    private final Provider<TriState> f7632c;
    public final Provider<Boolean> f7633d;
    private final AnalyticsConnectionUtils f7634e;
    private final Handler f7635f;
    private final Lazy<AnalyticsLogger> f7636g;
    public final Lazy<NavigationLogger> f7637h;
    public SelfRegistrableReceiverImpl f7638i;
    public BroadcastReceiver f7639j;
    public boolean f7640k = true;
    public NetworkInfo f7641l;
    private ConnectionQuality f7642m = ConnectionQuality.UNKNOWN;
    private ConnectionQuality f7643n = ConnectionQuality.UNKNOWN;
    private ConnectionQuality f7644o = ConnectionQuality.UNKNOWN;

    /* compiled from: release_notes */
    public class C03722 implements ActionReceiver {
        final /* synthetic */ ConnectionStatusLogger f8491a;

        public C03722(ConnectionStatusLogger connectionStatusLogger) {
            this.f8491a = connectionStatusLogger;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1559087070);
            if (broadcastReceiverLike.isInitialStickyBroadcast()) {
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1346972266, a);
            } else if (((NavigationLogger) this.f8491a.f7637h.get()).f3315z) {
                LogUtils.e(-840600007, a);
            } else {
                this.f8491a.m12207a(context);
                LogUtils.e(1014284777, a);
            }
        }
    }

    /* compiled from: release_notes */
    public class C03733 implements ActionReceiver {
        final /* synthetic */ ConnectionStatusLogger f8492a;

        public C03733(ConnectionStatusLogger connectionStatusLogger) {
            this.f8492a = connectionStatusLogger;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1624962224);
            this.f8492a.m12208a(intent.getExtras());
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1058241813, a);
        }
    }

    public static com.facebook.analytics.ConnectionStatusLogger m12202a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7629p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.ConnectionStatusLogger.class;
        monitor-enter(r1);
        r0 = f7629p;	 Catch:{ all -> 0x003a }
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
        r0 = m12205b(r0);	 Catch:{ all -> 0x0035 }
        f7629p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7629p;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.ConnectionStatusLogger.a(com.facebook.inject.InjectorLike):com.facebook.analytics.ConnectionStatusLogger");
    }

    private static ConnectionStatusLogger m12205b(InjectorLike injectorLike) {
        return new ConnectionStatusLogger(IdBasedSingletonScopeProvider.m1810b(injectorLike, 584), IdBasedLazy.m1808a(injectorLike, 401), IdBasedProvider.m1811a(injectorLike, 649), IdBasedProvider.m1811a(injectorLike, 3881), AnalyticsConnectionUtils.m12210a(injectorLike), Handler_ForNonUiThreadMethodAutoProvider.m5523b(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 175), IdBasedSingletonScopeProvider.m1810b(injectorLike, 137));
    }

    @Inject
    public ConnectionStatusLogger(Lazy<FbDataConnectionManager> lazy, Lazy<FbBroadcastManager> lazy2, Provider<TriState> provider, Provider<Boolean> provider2, AnalyticsConnectionUtils analyticsConnectionUtils, Handler handler, Lazy<AnalyticsLogger> lazy3, Lazy<NavigationLogger> lazy4) {
        this.f7630a = lazy;
        this.f7631b = lazy2;
        this.f7632c = provider;
        this.f7633d = provider2;
        this.f7634e = analyticsConnectionUtils;
        this.f7635f = handler;
        this.f7636g = lazy3;
        this.f7637h = lazy4;
    }

    public final void m12206a() {
        if (((TriState) this.f7632c.get()).asBoolean(false)) {
            String str;
            ConnectionQualityTraceLogger connectionQualityTraceLogger = ((FbDataConnectionManager) this.f7630a.get()).f1888l;
            String[] strArr = (String[]) connectionQualityTraceLogger.f2009c.get();
            connectionQualityTraceLogger.f2010d.set(1337);
            if (connectionQualityTraceLogger.f2011e.get() != 0) {
                str = null;
            } else if (strArr == null) {
                str = null;
            } else {
                StringBuilder stringBuilder = new StringBuilder(strArr.length * 20);
                stringBuilder.append("[");
                int i = 0;
                while (i < strArr.length && strArr[i] != null) {
                    stringBuilder.append(strArr[i]).append(",");
                    i++;
                }
                connectionQualityTraceLogger.f2009c.compareAndSet(strArr, null);
                stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).append("]");
                str = stringBuilder.toString();
            }
            String str2 = str;
            if (str2 != null) {
                HoneyClientEventFast a = ((AnalyticsLogger) this.f7636g.get()).mo535a("connection_quality_trace", true);
                if (a.m17388a()) {
                    a.m17379a("device");
                    a.m17385a("trace", str2);
                    a.m17390b();
                }
            }
        }
    }

    public final String m12209b() {
        String str;
        NetworkInfo networkInfo = this.f7641l;
        if (networkInfo == null || StringUtil.m3589a(networkInfo.getTypeName())) {
            str = "unknown";
        } else if (StringUtil.m3589a(networkInfo.getSubtypeName())) {
            str = networkInfo.getTypeName();
        } else {
            str = networkInfo.getTypeName() + "." + networkInfo.getSubtypeName().replace('.', '_').replace(' ', '_');
        }
        return str;
    }

    final void m12208a(Bundle bundle) {
        Object obj = bundle.get(FbDataConnectionManager.f1877b);
        Object obj2 = bundle.get(FbDataConnectionManager.f1878c);
        if (!this.f7642m.equals(obj) || !this.f7643n.equals(obj2)) {
            if (ConnectionQuality.UNKNOWN.equals(obj) || ConnectionQuality.UNKNOWN.equals(obj2) || !(ConnectionQuality.UNKNOWN.equals(this.f7642m) || ConnectionQuality.UNKNOWN.equals(this.f7643n))) {
                ConnectionQuality c = ((FbDataConnectionManager) this.f7630a.get()).m3801c();
                if (!c.equals(this.f7644o)) {
                    m12204a(c, false);
                    return;
                }
                return;
            }
            m12204a(((FbDataConnectionManager) this.f7630a.get()).m3801c(), true);
        }
    }

    private void m12204a(ConnectionQuality connectionQuality, boolean z) {
        FbDataConnectionManager fbDataConnectionManager = (FbDataConnectionManager) this.f7630a.get();
        this.f7644o = connectionQuality;
        this.f7642m = fbDataConnectionManager.m3799b();
        this.f7643n = fbDataConnectionManager.m3802d();
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("quality_change");
        honeyClientEvent.f3099c = "device";
        this.f7634e.m12218a(honeyClientEvent);
        honeyClientEvent.m5086a("quality", this.f7644o);
        honeyClientEvent.m5086a("bandwidth", this.f7642m);
        honeyClientEvent.m5086a("latency", this.f7643n);
        if (z) {
            honeyClientEvent.m5082a("raw_kbps", fbDataConnectionManager.m3803e());
            honeyClientEvent.m5082a("raw_rtt", fbDataConnectionManager.m3804f());
        }
        ((AnalyticsLogger) this.f7636g.get()).mo533c(honeyClientEvent);
    }

    public static synchronized void m12203a(ConnectionStatusLogger connectionStatusLogger, NetworkInfo networkInfo) {
        synchronized (connectionStatusLogger) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("connection_change");
            honeyClientEvent.m5094g("device");
            connectionStatusLogger.f7634e.m12218a(honeyClientEvent);
            connectionStatusLogger.f7634e.m12219a(honeyClientEvent, connectionStatusLogger.f7641l);
            connectionStatusLogger.f7634e.m12220b(honeyClientEvent);
            if (networkInfo != null) {
                honeyClientEvent.m5090b("state", networkInfo.getState().toString());
            }
            ((AnalyticsLogger) connectionStatusLogger.f7636g.get()).mo533c(honeyClientEvent);
        }
    }

    final void m12207a(Context context) {
        final NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getState() == State.DISCONNECTED) {
            this.f7640k = true;
        }
        if (!this.f7640k) {
            NetworkInfo networkInfo = this.f7641l;
            Object obj = 1;
            if (networkInfo == null) {
                if (activeNetworkInfo != null) {
                    obj = null;
                }
            } else if (activeNetworkInfo == null) {
                obj = null;
            } else if (!(networkInfo.getType() == activeNetworkInfo.getType() && networkInfo.getSubtype() == activeNetworkInfo.getSubtype())) {
                obj = null;
            }
            if (obj != null) {
                return;
            }
        }
        HandlerDetour.a(this.f7635f, new Runnable(this) {
            final /* synthetic */ ConnectionStatusLogger f8490b;

            public void run() {
                ConnectionStatusLogger.m12203a(this.f8490b, activeNetworkInfo);
            }
        }, -1855154486);
        this.f7641l = activeNetworkInfo;
        this.f7640k = false;
    }
}
