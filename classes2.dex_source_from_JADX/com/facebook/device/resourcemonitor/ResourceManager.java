package com.facebook.device.resourcemonitor;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.base.broadcast.BackgroundBroadcastThread;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.Handler_BackgroundBroadcastThreadMethodAutoProvider;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.cache.DiskCacheManager.C02571;
import com.facebook.common.android.ActivityManagerMethodAutoProvider;
import com.facebook.common.android.RuntimeMethodAutoProvider;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.diagnostics.VMMemoryInfo;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.file.StatFsHelperMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.common.memory.MemoryManager.1;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.device.DeviceConditionHelper.WifiStateChangedListener;
import com.facebook.device.FbTrafficStats;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: set_client_settings */
public class ResourceManager implements INeedInit {
    private static volatile ResourceManager f5306I;
    @VisibleForTesting
    static final PrefKey f5307a;
    @VisibleForTesting
    static final PrefKey f5308b = ((PrefKey) f5310d.m2011a("data_usage_v2"));
    private static final Class<?> f5309c = ResourceManager.class;
    private static final PrefKey f5310d;
    public static TypeReference<Map<String, Map<MonitoredProcess, DataUsageInfo>>> f5311e;
    public static TypeReference<Map<String, DataUsageInfo>> f5312f;
    private VMMemoryInfo f5313A;
    private DataUsageBytes f5314B = m9198a(MonitoredProcess.MY_APP.uid);
    private DataUsageInfo f5315C = m9211l();
    private Map<String, DataUsageInfo> f5316D;
    private Long f5317E;
    public Long f5318F;
    private boolean f5319G;
    public boolean f5320H;
    public final ConcurrentMap<MemoryUsageChangedListener, Integer> f5321g = new MapMaker().m1485e().m1489l();
    public final ConcurrentMap<DiskUsageChangedListener, Integer> f5322h = new MapMaker().m1485e().m1489l();
    private final Runtime f5323i;
    private final Clock f5324j;
    private final ResourceManagerConfig f5325k;
    private final ResourceMonitor f5326l;
    private final DeviceConditionHelper f5327m;
    private final WifiStateChangedListener f5328n;
    public final ActivityManager f5329o;
    private final WindowManager f5330p;
    public final AbstractFbErrorReporter f5331q;
    private final StatFsHelper f5332r;
    private final FbTrafficStats f5333s;
    private final FbSharedPreferences f5334t;
    private final JsonFactory f5335u;
    @BackgroundBroadcastThread
    private final Handler f5336v;
    private final BaseFbBroadcastManager f5337w;
    private SelfRegistrableReceiverImpl f5338x;
    private final ActionReceiver f5339y;
    private final ActionReceiver f5340z;

    /* compiled from: set_client_settings */
    class C02543 implements WifiStateChangedListener {
        final /* synthetic */ ResourceManager f5373a;

        C02543(ResourceManager resourceManager) {
            this.f5373a = resourceManager;
        }

        public final void mo1327a(DeviceConditionHelper deviceConditionHelper) {
            this.f5373a.m9218g();
        }
    }

    /* compiled from: set_client_settings */
    class C02554 implements ActionReceiver {
        final /* synthetic */ ResourceManager f5378a;

        C02554(ResourceManager resourceManager) {
            this.f5378a = resourceManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1391093513);
            this.f5378a.m9218g();
            this.f5378a.f5320H = true;
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 243061081, a);
        }
    }

    /* compiled from: set_client_settings */
    class C02565 implements ActionReceiver {
        final /* synthetic */ ResourceManager f5379a;

        C02565(ResourceManager resourceManager) {
            this.f5379a = resourceManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1355229942);
            this.f5379a.m9218g();
            this.f5379a.f5320H = false;
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 667164574, a);
        }
    }

    public static com.facebook.device.resourcemonitor.ResourceManager m9199a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5306I;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.device.resourcemonitor.ResourceManager.class;
        monitor-enter(r1);
        r0 = f5306I;	 Catch:{ all -> 0x003a }
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
        r0 = m9205b(r0);	 Catch:{ all -> 0x0035 }
        f5306I = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5306I;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.resourcemonitor.ResourceManager.a(com.facebook.inject.InjectorLike):com.facebook.device.resourcemonitor.ResourceManager");
    }

    private static ResourceManager m9205b(InjectorLike injectorLike) {
        return new ResourceManager(ResourceMonitor.m9219a(injectorLike), ResourceManagerConfig.m9225a(injectorLike), RuntimeMethodAutoProvider.m9227a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), DeviceConditionHelper.m5526a(injectorLike), WindowManagerMethodAutoProvider.m8708b(injectorLike), ActivityManagerMethodAutoProvider.m2391b(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), StatFsHelperMethodAutoProvider.m2307a(injectorLike), FbTrafficStats.m9228a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), JsonFactoryMethodAutoProvider.m8062a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike), Handler_BackgroundBroadcastThreadMethodAutoProvider.m4110a(injectorLike));
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f991e.m2011a("res_man/");
        f5310d = prefKey;
        f5307a = (PrefKey) prefKey.m2011a("data_usage");
    }

    public final boolean m9213a(VMMemoryInfo vMMemoryInfo) {
        long j;
        long j2 = vMMemoryInfo.f1198d;
        ResourceManagerConfig resourceManagerConfig = this.f5325k;
        if (resourceManagerConfig.f5364a.m2306a()) {
            j = (resourceManagerConfig.f5364a.f1199e * 30) / 100;
        } else {
            j = (resourceManagerConfig.f5364a.f1199e * 15) / 100;
        }
        return j2 < j;
    }

    @Inject
    public ResourceManager(ResourceMonitor resourceMonitor, ResourceManagerConfig resourceManagerConfig, Runtime runtime, Clock clock, DeviceConditionHelper deviceConditionHelper, WindowManager windowManager, ActivityManager activityManager, AbstractFbErrorReporter abstractFbErrorReporter, StatFsHelper statFsHelper, FbTrafficStats fbTrafficStats, FbSharedPreferences fbSharedPreferences, JsonFactory jsonFactory, BaseFbBroadcastManager baseFbBroadcastManager, Handler handler) {
        this.f5326l = resourceMonitor;
        this.f5325k = resourceManagerConfig;
        this.f5329o = activityManager;
        this.f5323i = runtime;
        this.f5324j = clock;
        this.f5327m = deviceConditionHelper;
        this.f5330p = windowManager;
        this.f5333s = fbTrafficStats;
        this.f5334t = fbSharedPreferences;
        this.f5335u = jsonFactory;
        this.f5337w = baseFbBroadcastManager;
        this.f5336v = handler;
        this.f5331q = abstractFbErrorReporter;
        this.f5332r = statFsHelper;
        this.f5328n = new C02543(this);
        this.f5327m.m5531a(this.f5328n);
        this.f5339y = new C02554(this);
        this.f5340z = new C02565(this);
    }

    public void init() {
        this.f5330p.getDefaultDisplay().getMetrics(new DisplayMetrics());
        ResourceMonitor resourceMonitor = this.f5326l;
        resourceMonitor.f5343b = this;
        resourceMonitor.f5348g = resourceMonitor.f5351j.m8544a();
        resourceMonitor.f5349h = resourceMonitor.f5352k.m2264l();
        ResourceMonitor.m9221b(resourceMonitor);
        resourceMonitor.f5355n.m3296b();
        resourceMonitor.f5351j.m8542a(resourceMonitor.f5353l);
        this.f5320H = true;
        this.f5338x = this.f5337w.m2951a().mo506a(AppStateManager.f1110b, this.f5339y).mo506a(AppStateManager.f1111c, this.f5340z).mo505a(this.f5336v).mo503a();
        this.f5338x.m3296b();
        m9218g();
    }

    public final VMMemoryInfo m9212a() {
        return new VMMemoryInfo(this.f5323i);
    }

    public final synchronized DataUsageInfo m9214b() {
        m9218g();
        return this.f5315C;
    }

    public final synchronized void m9215c() {
        this.f5315C = m9211l();
        Map k = m9210k();
        for (String put : k.keySet()) {
            k.put(put, m9211l());
        }
        m9207b(k);
    }

    @VisibleForTesting
    final void m9216e() {
        VMMemoryInfo vMMemoryInfo = new VMMemoryInfo(this.f5323i);
        if (vMMemoryInfo.f1199e != Long.MAX_VALUE) {
            if (this.f5318F == null || vMMemoryInfo.f1196a > this.f5318F.longValue()) {
                this.f5318F = Long.valueOf(vMMemoryInfo.f1196a);
                this.f5331q.mo345c("peak_memory_heap_allocation", this.f5318F.toString());
            }
            boolean a = m9213a(vMMemoryInfo);
            this.f5331q.mo345c("is_low_on_memory", Boolean.toString(a));
            if (a) {
                m9202a(vMMemoryInfo, 80);
            }
            if (this.f5313A == null || Math.abs(vMMemoryInfo.f1196a - this.f5313A.f1196a) > 1048576) {
                m9208c(vMMemoryInfo);
            }
        }
    }

    @VisibleForTesting
    final void m9217f() {
        long a = this.f5332r.m2314a(StorageType.INTERNAL);
        if (a < 5242880) {
            m9201a(a);
        }
    }

    @VisibleForTesting
    final synchronized void m9218g() {
        DataUsageBytes j = m9209j();
        m9203a(this.f5315C, j);
        Map k = m9210k();
        for (DataUsageInfo a : k.values()) {
            m9203a(a, j);
        }
        m9204a(k);
        this.f5319G = this.f5327m.m5534b();
    }

    private void m9203a(DataUsageInfo dataUsageInfo, DataUsageBytes dataUsageBytes) {
        if (this.f5319G) {
            dataUsageInfo.m9255a(dataUsageBytes.f5370b);
            dataUsageInfo.m9256b(dataUsageBytes.f5371c);
            return;
        }
        dataUsageInfo.m9257c(dataUsageBytes.f5370b);
        dataUsageInfo.m9258d(dataUsageBytes.f5371c);
    }

    private DataUsageBytes m9209j() {
        DataUsageBytes a;
        DataUsageBytes a2 = m9198a(MonitoredProcess.MY_APP.uid);
        if (this.f5320H || !MonitoredProcess.MY_APP.trackForegroundOnly) {
            a = a2.m9249a(this.f5314B);
        } else {
            a = new DataUsageBytes(0, 0);
        }
        this.f5314B = a2;
        return a;
    }

    @VisibleForTesting
    private void m9208c(VMMemoryInfo vMMemoryInfo) {
        this.f5313A = vMMemoryInfo;
        Iterator it = this.f5321g.keySet().iterator();
        while (it.hasNext()) {
            it.next();
        }
        vMMemoryInfo.toString();
    }

    @VisibleForTesting
    private void m9202a(VMMemoryInfo vMMemoryInfo, int i) {
        for (1 1 : this.f5321g.keySet()) {
            if (i == 80) {
                1.a.m9816c();
            }
        }
    }

    @VisibleForTesting
    private void m9201a(long j) {
        for (C02571 c02571 : this.f5322h.keySet()) {
            c02571.f5380a.m9195a(j);
        }
    }

    private DataUsageBytes m9198a(int i) {
        return this.f5333s.m9239a(i, 0);
    }

    private synchronized Map<String, DataUsageInfo> m9210k() {
        Map<String, DataUsageInfo> map;
        try {
            if (this.f5316D != null) {
                map = this.f5316D;
            } else if (this.f5334t.mo284a()) {
                String a = this.f5334t.mo278a(f5308b, null);
                if (a != null) {
                    this.f5316D = m9200a(a);
                }
                if (this.f5316D != null) {
                    map = this.f5316D;
                } else {
                    try {
                        a = this.f5334t.mo278a(f5307a, null);
                        if (a != null) {
                            this.f5316D = m9206b(a);
                        }
                    } catch (Throwable e) {
                        BLog.b(f5309c, "Couldn't deserialize In Process Data Usage Byte Trackers", e);
                    }
                    if (this.f5316D == null) {
                        this.f5316D = Maps.m838c();
                    }
                    map = this.f5316D;
                }
            } else {
                map = Maps.m838c();
            }
        } catch (Throwable e2) {
            BLog.b(f5309c, "Couldn't deserialize In Process Data Usage Byte Trackers", e2);
        }
        return map;
    }

    private Map<String, DataUsageInfo> m9200a(String str) {
        JsonParser b = this.f5335u.m7173b(str);
        if (f5312f == null) {
            f5312f = new 2(this);
        }
        return (Map) b.m13258a(f5312f);
    }

    private Map<String, DataUsageInfo> m9206b(String str) {
        JsonParser b = this.f5335u.m7173b(str);
        if (f5311e == null) {
            f5311e = new 1();
        }
        Map map = (Map) b.m13258a(f5311e);
        Map<String, DataUsageInfo> hashMap = new HashMap();
        for (String str2 : map.keySet()) {
            hashMap.put(str2, ((Map) map.get(str2)).get(MonitoredProcess.MY_APP));
        }
        return hashMap;
    }

    private void m9204a(Map<String, DataUsageInfo> map) {
        if (this.f5334t.mo284a() && map != null && map.size() != 0) {
            long a = this.f5324j.mo211a();
            if (this.f5317E == null || a >= this.f5317E.longValue() + 10000) {
                this.f5317E = Long.valueOf(a);
                m9207b((Map) map);
            }
        }
    }

    private void m9207b(Map<String, DataUsageInfo> map) {
        if (map != null) {
            try {
                if (map.size() != 0) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    this.f5335u.m7172b(byteArrayOutputStream).mo1114a((Object) map);
                    this.f5334t.edit().mo1276a(f5308b, byteArrayOutputStream.toString("UTF-8")).commit();
                    return;
                }
            } catch (Throwable e) {
                BLog.b(f5309c, "Couldn't deserialize In Process Data Usage Byte Trackers", e);
                return;
            }
        }
        this.f5334t.edit().mo1271a(f5308b).mo1271a(f5307a).commit();
    }

    private static DataUsageInfo m9211l() {
        return new DataUsageInfo(0, 0, 0, 0);
    }
}
