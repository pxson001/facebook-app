package com.facebook.analytics.analyticsmodule;

import android.content.Context;
import android.provider.Settings.System;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.RawJsonBlobNode;
import com.facebook.analytics.logger.AnalyticsConfig;
import com.facebook.analytics.logger.AnalyticsConfig.Level;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.logger.ILegacyPeriodicEventReporter;
import com.facebook.analytics.util.AnalyticsConnectionUtils;
import com.facebook.analytics.util.AnalyticsDeviceUtils;
import com.facebook.common.hardware.BatteryStateManager;
import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.common.process.ProcessName;
import com.facebook.common.process.ProcessNameMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.device.DeviceMemoryInfoReader;
import com.facebook.device.DeviceMemoryInfoReaderMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.common.NetworkSystemSettings;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: has_consistent_fields */
public class DeviceStatusPeriodicReporter implements ILegacyPeriodicEventReporter {
    private static final Class<?> f10860a = DeviceStatusPeriodicReporter.class;
    private static volatile DeviceStatusPeriodicReporter f10861p;
    private final Context f10862b;
    public final FbSharedPreferences f10863c;
    private final DeviceConditionHelper f10864d;
    public final NetworkSystemSettings f10865e;
    private final BaseAnalyticsConfig f10866f;
    private final SystemBatteryStateManager f10867g;
    private final AnalyticsDeviceUtils f10868h;
    private final AnalyticsConnectionUtils f10869i;
    private final DeviceMemoryInfoReader f10870j;
    public final Provider<Long> f10871k;
    private final GatekeeperStoreImpl f10872l;
    private final MonotonicClock f10873m;
    private final ProcessName f10874n;
    private final Lazy<UUID> f10875o;

    public static com.facebook.analytics.analyticsmodule.DeviceStatusPeriodicReporter m11303a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10861p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.analyticsmodule.DeviceStatusPeriodicReporter.class;
        monitor-enter(r1);
        r0 = f10861p;	 Catch:{ all -> 0x003a }
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
        r0 = m11307b(r0);	 Catch:{ all -> 0x0035 }
        f10861p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10861p;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.analyticsmodule.DeviceStatusPeriodicReporter.a(com.facebook.inject.InjectorLike):com.facebook.analytics.analyticsmodule.DeviceStatusPeriodicReporter");
    }

    private static DeviceStatusPeriodicReporter m11307b(InjectorLike injectorLike) {
        return new DeviceStatusPeriodicReporter((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), DeviceConditionHelper.a(injectorLike), NetworkSystemSettings.a(injectorLike), SystemBatteryStateManager.a(injectorLike), (BaseAnalyticsConfig) FbAnalyticsConfig.a(injectorLike), AnalyticsDeviceUtils.m11311a(injectorLike), AnalyticsConnectionUtils.a(injectorLike), DeviceMemoryInfoReaderMethodAutoProvider.m11327a(injectorLike), IdBasedProvider.a(injectorLike, 4428), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (MonotonicClock) RealtimeSinceBootClockMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 4487), ProcessNameMethodAutoProvider.b(injectorLike));
    }

    private HoneyClientEvent m11304a(HoneyClientEvent honeyClientEvent, long j) {
        honeyClientEvent.e = j;
        UUID uuid = (UUID) this.f10875o.get();
        if (uuid != null) {
            honeyClientEvent.b("boot_id", uuid.toString());
        }
        honeyClientEvent.a("battery", (double) this.f10867g.a());
        honeyClientEvent.b("charge_state", this.f10867g.b().toString().toLowerCase(Locale.US));
        honeyClientEvent.b("battery_health", this.f10867g.c().toString().toLowerCase(Locale.US));
        honeyClientEvent.a("wifi_enabled", this.f10864d.a());
        honeyClientEvent.a("wifi_connected", this.f10864d.b());
        Optional b = this.f10865e.b();
        if (b.isPresent()) {
            honeyClientEvent.a("mobile_data_enabled", b.get());
        }
        b = this.f10865e.a();
        if (b.isPresent()) {
            honeyClientEvent.a("airplane_mode_on", b.get());
        }
        honeyClientEvent.a("time_since_boot_ms", this.f10873m.now());
        m11308d(honeyClientEvent);
        this.f10869i.a(honeyClientEvent);
        m11305a(honeyClientEvent);
        this.f10868h.f10882f.a(honeyClientEvent);
        if (!this.f10872l.a(1140, false)) {
            this.f10869i.c(honeyClientEvent);
            this.f10868h.f10881e.a(honeyClientEvent);
        }
        if (this.f10866f.a() == Level.CORE_AND_SAMPLED) {
            this.f10868h.f10878b.a(honeyClientEvent);
            this.f10868h.f10879c.a(honeyClientEvent);
            this.f10868h.f10880d.a(honeyClientEvent);
            AnalyticsDeviceUtils analyticsDeviceUtils = this.f10868h;
            if (analyticsDeviceUtils.f10883g != null) {
                Iterator it = analyticsDeviceUtils.f10883g.m11326a().entrySet().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    String str = (String) entry.getKey();
                    Iterator it2 = ((ImmutableMap) entry.getValue()).entrySet().iterator();
                    while (it2.hasNext()) {
                        entry = (Entry) it2.next();
                        honeyClientEvent.a(str + "_" + ((String) entry.getKey()), new RawJsonBlobNode(entry.getValue().toString()));
                    }
                }
            }
        }
        return honeyClientEvent;
    }

    @Inject
    public DeviceStatusPeriodicReporter(Context context, FbSharedPreferences fbSharedPreferences, DeviceConditionHelper deviceConditionHelper, NetworkSystemSettings networkSystemSettings, BatteryStateManager batteryStateManager, AnalyticsConfig analyticsConfig, AnalyticsDeviceUtils analyticsDeviceUtils, AnalyticsConnectionUtils analyticsConnectionUtils, DeviceMemoryInfoReader deviceMemoryInfoReader, Provider<Long> provider, GatekeeperStore gatekeeperStore, MonotonicClock monotonicClock, Lazy<UUID> lazy, ProcessName processName) {
        this.f10862b = context;
        this.f10863c = fbSharedPreferences;
        this.f10864d = deviceConditionHelper;
        this.f10865e = networkSystemSettings;
        this.f10866f = analyticsConfig;
        this.f10867g = batteryStateManager;
        this.f10868h = analyticsDeviceUtils;
        this.f10869i = analyticsConnectionUtils;
        this.f10870j = deviceMemoryInfoReader;
        this.f10871k = provider;
        this.f10872l = gatekeeperStore;
        this.f10873m = monotonicClock;
        this.f10875o = lazy;
        this.f10874n = processName;
    }

    public final HoneyAnalyticsEvent mo804a(long j, String str) {
        return m11302a(j);
    }

    public final long mo803a() {
        long longValue;
        if (this.f10863c.a()) {
            longValue = ((Long) this.f10871k.get()).longValue();
        } else {
            longValue = 3600000;
        }
        return longValue;
    }

    private HoneyAnalyticsEvent m11302a(long j) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("device_status");
        m11304a(honeyClientEvent, j);
        honeyClientEvent.b("process", this.f10874n.f());
        honeyClientEvent.c = "device";
        return honeyClientEvent;
    }

    private void m11305a(HoneyClientEvent honeyClientEvent) {
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        honeyClientEvent.a("free_mem", (maxMemory - (runtime.totalMemory() - runtime.freeMemory())) / 1048576);
        honeyClientEvent.a("total_mem", maxMemory / 1048576);
        String str = "total_mem_device";
        DeviceMemoryInfoReader deviceMemoryInfoReader = this.f10870j;
        long a = deviceMemoryInfoReader.mo828a(null);
        if (a < 0) {
            a = deviceMemoryInfoReader.m11335a().f10908b;
        }
        honeyClientEvent.a(str, a);
    }

    private static void m11306a(Throwable th, String str) {
        BLog.a(f10860a, str, th);
    }

    private void m11308d(HoneyClientEvent honeyClientEvent) {
        try {
            int i = System.getInt(this.f10862b.getContentResolver(), "screen_brightness_mode");
            if (i == 0) {
                i = System.getInt(this.f10862b.getContentResolver(), "screen_brightness");
                Integer.valueOf(i);
                honeyClientEvent.a("screen_brightness_raw_value", i);
            } else if (i == 1) {
                honeyClientEvent.a("screen_brightness_raw_value", -1.0d);
            } else {
                BLog.a(f10860a, "system brightness mode is unknown");
                honeyClientEvent.a("screen_brightness_raw_value", -2.0d);
            }
        } catch (Throwable e) {
            m11306a(e, "Failed to get system brightness setting");
        }
    }
}
