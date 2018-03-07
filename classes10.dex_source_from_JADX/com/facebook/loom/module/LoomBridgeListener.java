package com.facebook.loom.module;

import android.content.Context;
import com.facebook.common.deviceinfo.DeviceInfoCore;
import com.facebook.common.deviceinfo.ThreadInfo;
import com.facebook.common.dextricks.DexLibLoader;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.core.TraceControl.TraceContext;
import com.facebook.loom.core.TraceOrchestrator.LoomListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.loom.provider.NativeEventProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: three_hours */
public class LoomBridgeListener implements LoomListener {
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<NotificationControls> f1443a = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<QuickPerformanceLogger> f1444b = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<Context> f1445c = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbDataConnectionManager> f1446d = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbNetworkManager> f1447e = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<PerfTestConfig> f1448f = UltralightRuntime.b;

    public static LoomBridgeListener m1441b(InjectorLike injectorLike) {
        LoomBridgeListener loomBridgeListener = new LoomBridgeListener();
        loomBridgeListener.m1438a(IdBasedSingletonScopeProvider.b(injectorLike, 2515), IdBasedSingletonScopeProvider.b(injectorLike, 3229), injectorLike.getLazy(Context.class), IdBasedSingletonScopeProvider.b(injectorLike, 584), IdBasedSingletonScopeProvider.b(injectorLike, 585), IdBasedSingletonScopeProvider.b(injectorLike, 593));
        return loomBridgeListener;
    }

    private static void m1442b() {
        HashMap hashMap = new HashMap();
        File file = new File("/proc/self/task");
        if (file.exists() && file.canRead() && file.isDirectory()) {
            for (String str : file.list()) {
                CharSequence a = ThreadInfo.a(file.getAbsolutePath() + File.separator + str + File.separator + "comm");
                if (!StringUtil.a(a)) {
                    hashMap.put(str, a);
                }
            }
        }
        for (Entry entry : hashMap.entrySet()) {
            m1439a((String) entry.getKey(), (String) entry.getValue());
        }
    }

    private void m1438a(com.facebook.inject.Lazy<NotificationControls> lazy, com.facebook.inject.Lazy<QuickPerformanceLogger> lazy2, com.facebook.inject.Lazy<Context> lazy3, com.facebook.inject.Lazy<FbDataConnectionManager> lazy4, com.facebook.inject.Lazy<FbNetworkManager> lazy5, com.facebook.inject.Lazy<PerfTestConfig> lazy6) {
        this.f1443a = lazy;
        this.f1444b = lazy2;
        this.f1445c = lazy3;
        this.f1446d = lazy4;
        this.f1447e = lazy5;
        this.f1448f = lazy6;
    }

    public final void m1443a() {
        ((NotificationControls) this.f1443a.get()).a(NotificationControls$UploadState.Uploading);
        ((QuickPerformanceLogger) this.f1444b.get()).a(8126465, (short) 2, 0);
    }

    public final void m1444a(int i, int i2, int i3, int i4) {
        while (i > 0) {
            ((QuickPerformanceLogger) this.f1444b.get()).a(8126471, (short) 3, 0);
            i--;
        }
        while (i2 > 0) {
            ((QuickPerformanceLogger) this.f1444b.get()).a(8126472, (short) 2, 0);
            i2--;
        }
        while (i3 > 0) {
            ((QuickPerformanceLogger) this.f1444b.get()).a(8126473, (short) 2, 0);
            i3--;
        }
        while (i4 > 0) {
            ((QuickPerformanceLogger) this.f1444b.get()).a(8126474, (short) 2, 0);
            i4--;
        }
    }

    public final void m1447a(File file) {
        ((NotificationControls) this.f1443a.get()).a(NotificationControls$UploadState.Successful);
        ((QuickPerformanceLogger) this.f1444b.get()).a(8126469, (short) 2, 0);
    }

    public final void m1449b(File file) {
        ((NotificationControls) this.f1443a.get()).a(NotificationControls$UploadState.Failed);
        ((QuickPerformanceLogger) this.f1444b.get()).a(8126469, (short) 3, 0);
    }

    public final void m1445a(TraceContext traceContext) {
        ((NotificationControls) this.f1443a.get()).a(true);
    }

    public final void m1448b(TraceContext traceContext) {
        long j;
        int i = !DexLibLoader.deoptTaint ? 1 : 0;
        EntryType entryType = EntryType.TRACE_ANNOTATION;
        if (i != 0) {
            j = 1;
        } else {
            j = 0;
        }
        Logger.a(-1, entryType, 8126475, j);
        DeviceInfoCore deviceInfoCore = new DeviceInfoCore();
        Map a = DeviceInfoCore.a((Context) this.f1445c.get());
        m1440a(a, "os_ver", 8126483);
        m1440a(a, "device_type", 8126478);
        m1440a(a, "brand", 8126479);
        m1440a(a, "manufacturer", 8126480);
        m1440a(a, "year_class", 8126481);
        FbDataConnectionManager fbDataConnectionManager = (FbDataConnectionManager) this.f1446d.get();
        FbNetworkManager fbNetworkManager = (FbNetworkManager) this.f1447e.get();
        Map hashMap = new HashMap();
        if (fbDataConnectionManager != null) {
            hashMap.put("connection_class", fbDataConnectionManager.b().name());
        }
        if (fbNetworkManager != null) {
            hashMap.put("network_type", fbNetworkManager.k());
            hashMap.put("network_subtype", fbNetworkManager.l());
        }
        a = hashMap;
        m1440a(a, "connection_class", 8126484);
        m1440a(a, "network_type", 8126485);
        m1440a(a, "network_subtype", 8126486);
        this.f1448f.get();
        String str = PerfTestConfigBase.u;
        if (str != null) {
            Logger.a(-1, EntryType.TRACE_ANNOTATION, 8126489, 0, 0, "PERF_TEST_INFO", str);
        }
        m1442b();
        NativeEventProvider.a();
    }

    public final void m1450c(TraceContext traceContext) {
        ((NotificationControls) this.f1443a.get()).a(false);
    }

    public final void m1446a(TraceContext traceContext, short s) {
        ((NotificationControls) this.f1443a.get()).a(false);
        ((QuickPerformanceLogger) this.f1444b.get()).a(8126466, s, 0);
    }

    private static void m1439a(String str, String str2) {
        Logger.a(-1, EntryType.TRACE_THREAD_NAME, 0, 0, 0, str, str2);
    }

    public static void m1440a(Map<String, Object> map, String str, int i) {
        if (map.containsKey(str)) {
            Logger.a(-1, EntryType.TRACE_ANNOTATION, i, 0, 0, str, map.get(str).toString());
        }
    }
}
