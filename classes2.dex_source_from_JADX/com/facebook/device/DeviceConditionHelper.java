package com.facebook.device;

import android.content.Context;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import com.facebook.common.android.WifiManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.init.INeedInit;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: tag_table_rowid_ref_index */
public class DeviceConditionHelper implements INeedInit {
    private static volatile DeviceConditionHelper f3316m;
    private final Context f3317a;
    private final FbNetworkManager f3318b;
    private final WifiManager f3319c;
    private final Clock f3320d;
    private final FbSharedPreferences f3321e;
    public final AbstractFbErrorReporter f3322f;
    private DynamicSecureBroadcastReceiver f3323g;
    private volatile WifiState f3324h = WifiState.WIFI_UNKNOWN;
    private long f3325i;
    private OnSharedPreferenceChangeListener f3326j;
    private boolean f3327k;
    public ConcurrentMap<WifiStateChangedListener, Boolean> f3328l;

    @VisibleForTesting
    /* compiled from: tag_table_rowid_ref_index */
    public enum WifiState {
        WIFI_ON,
        WIFI_OFF,
        WIFI_UNKNOWN
    }

    /* compiled from: tag_table_rowid_ref_index */
    public interface WifiStateChangedListener {
        void mo1327a(DeviceConditionHelper deviceConditionHelper);
    }

    public static com.facebook.device.DeviceConditionHelper m5526a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3316m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.device.DeviceConditionHelper.class;
        monitor-enter(r1);
        r0 = f3316m;	 Catch:{ all -> 0x003a }
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
        r0 = m5528b(r0);	 Catch:{ all -> 0x0035 }
        f3316m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3316m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.DeviceConditionHelper.a(com.facebook.inject.InjectorLike):com.facebook.device.DeviceConditionHelper");
    }

    private static DeviceConditionHelper m5528b(InjectorLike injectorLike) {
        return new DeviceConditionHelper((Context) injectorLike.getInstance(Context.class), FbNetworkManager.m3811a(injectorLike), WifiManagerMethodAutoProvider.m3852b(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public DeviceConditionHelper(Context context, FbNetworkManager fbNetworkManager, WifiManager wifiManager, Clock clock, FbSharedPreferences fbSharedPreferences, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f3317a = context;
        this.f3318b = fbNetworkManager;
        this.f3319c = wifiManager;
        this.f3320d = clock;
        this.f3325i = 0;
        this.f3321e = fbSharedPreferences;
        this.f3322f = abstractFbErrorReporter;
        this.f3328l = new MapMaker().m1485e().m1489l();
    }

    public void init() {
        Map a = Maps.m812a(3);
        a.put("android.net.wifi.supplicant.CONNECTION_CHANGE", new 1(this));
        a.put("android.net.wifi.STATE_CHANGE", new 2(this));
        a.put("android.net.conn.CONNECTIVITY_CHANGE", new 3(this));
        this.f3323g = new DynamicSecureBroadcastReceiver(a);
        this.f3317a.registerReceiver(this.f3323g, new IntentFilter("android.net.wifi.supplicant.CONNECTION_CHANGE"));
        this.f3317a.registerReceiver(this.f3323g, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        this.f3317a.registerReceiver(this.f3323g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f3326j = new 4(this);
        this.f3321e.mo279a(DevicePrefKeys.a, this.f3326j);
        m5530f(this);
    }

    public final boolean m5532a() {
        return this.f3319c != null && this.f3319c.isWifiEnabled();
    }

    public final boolean m5534b() {
        return m5533a(false);
    }

    public final boolean m5533a(boolean z) {
        if (this.f3327k) {
            return false;
        }
        if (z || this.f3324h == WifiState.WIFI_UNKNOWN) {
            NetworkInfo c = m5535c();
            if (c == null || c.getType() != 1) {
                m5527a(this, WifiState.WIFI_OFF);
            } else {
                m5527a(this, c.isConnected() ? WifiState.WIFI_ON : WifiState.WIFI_UNKNOWN);
            }
        }
        if (this.f3324h == WifiState.WIFI_ON) {
            return true;
        }
        return false;
    }

    public final NetworkInfo m5535c() {
        return this.f3318b.m3833i();
    }

    public final void m5531a(WifiStateChangedListener wifiStateChangedListener) {
        this.f3328l.put(wifiStateChangedListener, Boolean.valueOf(true));
    }

    @VisibleForTesting
    private void m5529e() {
        Builder builder = new Builder();
        synchronized (this) {
            for (WifiStateChangedListener c : this.f3328l.keySet()) {
                builder.m4813c(c);
            }
        }
        Iterator it = builder.m4812b().iterator();
        while (it.hasNext()) {
            ((WifiStateChangedListener) it.next()).mo1327a(this);
        }
    }

    public static void m5530f(DeviceConditionHelper deviceConditionHelper) {
        deviceConditionHelper.f3327k = deviceConditionHelper.f3321e.mo286a(DevicePrefKeys.a, false);
    }

    public static void m5527a(DeviceConditionHelper deviceConditionHelper, WifiState wifiState) {
        if (deviceConditionHelper.f3324h != wifiState) {
            deviceConditionHelper.f3324h = wifiState;
            deviceConditionHelper.m5529e();
        }
    }
}
