package com.facebook.analytics.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import com.facebook.analytics.FeatureDataUsageCounters;
import com.facebook.analytics.MemoryAnalyticsCounters;
import com.facebook.analytics.cache.CacheCounters;
import com.facebook.analytics.counter.CountersPrefReader;
import com.facebook.analytics.counter.CountersPrefReaderMethodAutoProvider;
import com.facebook.analytics.counter.GenericAnalyticsCounters;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.timeline.TimelineDiskCacheEvictionCounters;
import com.facebook.analytics.webrequest.WebRequestCounters;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.cpu.ProcessorInfoUtil;
import com.facebook.common.cpu.ProcessorInfoUtilMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.device.DeviceMemoryInfoReader;
import com.facebook.device.DeviceMemoryInfoReaderMethodAutoProvider;
import com.facebook.device.MemoryInfoCompat;
import com.facebook.device.resourcemonitor.ResourceManager;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.annotations.VisibleForTesting;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: has_bluetooth_permission */
public class AnalyticsDeviceUtils {
    private static volatile AnalyticsDeviceUtils f10876u;
    private final Lazy<ResourceManager> f10877a;
    public final GenericAnalyticsCounters f10878b;
    public final CacheCounters f10879c;
    public final WebRequestCounters f10880d;
    public final FeatureDataUsageCounters f10881e;
    public final TimelineDiskCacheEvictionCounters f10882f;
    public final CountersPrefReader f10883g;
    private final Context f10884h;
    public final ProcessorInfoUtil f10885i;
    private final Lazy<MemoryAnalyticsCounters> f10886j;
    private final DeviceMemoryInfoReader f10887k;
    private final AppStateManager f10888l;
    private Field f10889m;
    private Field f10890n;
    private Method f10891o;
    private Method f10892p;
    private Method f10893q;
    private Method f10894r;
    private int f10895s = 0;
    private int f10896t = 0;

    public static com.facebook.analytics.util.AnalyticsDeviceUtils m11311a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10876u;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.util.AnalyticsDeviceUtils.class;
        monitor-enter(r1);
        r0 = f10876u;	 Catch:{ all -> 0x003a }
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
        r0 = m11316b(r0);	 Catch:{ all -> 0x0035 }
        f10876u = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10876u;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.util.AnalyticsDeviceUtils.a(com.facebook.inject.InjectorLike):com.facebook.analytics.util.AnalyticsDeviceUtils");
    }

    private static AnalyticsDeviceUtils m11316b(InjectorLike injectorLike) {
        return new AnalyticsDeviceUtils(IdBasedSingletonScopeProvider.b(injectorLike, 1066), GenericAnalyticsCounters.m11318a(injectorLike), CacheCounters.a(injectorLike), WebRequestCounters.a(injectorLike), FeatureDataUsageCounters.a(injectorLike), TimelineDiskCacheEvictionCounters.m11321a(injectorLike), CountersPrefReaderMethodAutoProvider.m11324a(injectorLike), (Context) injectorLike.getInstance(Context.class), ProcessorInfoUtilMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 4773), DeviceMemoryInfoReaderMethodAutoProvider.m11327a(injectorLike), AppStateManager.a(injectorLike));
    }

    @Inject
    public AnalyticsDeviceUtils(Lazy<ResourceManager> lazy, GenericAnalyticsCounters genericAnalyticsCounters, CacheCounters cacheCounters, WebRequestCounters webRequestCounters, FeatureDataUsageCounters featureDataUsageCounters, TimelineDiskCacheEvictionCounters timelineDiskCacheEvictionCounters, @Nullable CountersPrefReader countersPrefReader, Context context, ProcessorInfoUtil processorInfoUtil, Lazy<MemoryAnalyticsCounters> lazy2, DeviceMemoryInfoReader deviceMemoryInfoReader, AppStateManager appStateManager) {
        this.f10877a = lazy;
        this.f10878b = genericAnalyticsCounters;
        this.f10879c = cacheCounters;
        this.f10880d = webRequestCounters;
        this.f10881e = featureDataUsageCounters;
        this.f10882f = timelineDiskCacheEvictionCounters;
        this.f10883g = countersPrefReader;
        this.f10884h = context;
        this.f10885i = processorInfoUtil;
        this.f10886j = lazy2;
        this.f10887k = deviceMemoryInfoReader;
        this.f10888l = appStateManager;
    }

    @VisibleForTesting
    private ObjectNode m11312a() {
        return m11313a(((ActivityManager) this.f10884h.getSystemService("activity")).getMemoryClass(), this.f10887k.m11335a());
    }

    @VisibleForTesting
    private ObjectNode m11313a(int i, MemoryInfoCompat memoryInfoCompat) {
        Throwable e;
        MemoryInfo memoryInfo = new MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        int c = (int) (((float) (100 * memoryInfoCompat.m11340c())) / ((float) memoryInfoCompat.m11338a()));
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("device_total_mem", memoryInfoCompat.m11339b());
        objectNode.a("mem_available", memoryInfoCompat.m11338a());
        objectNode.a("mem_threshold", memoryInfoCompat.m11340c());
        objectNode.a("mem_is_low", memoryInfoCompat.m11341d());
        objectNode.a("mem_pct_total", c);
        objectNode.a("mem_class", i);
        objectNode.a("total_pd", memoryInfo.getTotalPrivateDirty() * 1024);
        objectNode.a("total_pss", memoryInfo.getTotalPss() * 1024);
        objectNode.a("total_sd", memoryInfo.getTotalSharedDirty() * 1024);
        if (VERSION.SDK_INT >= 19) {
            objectNode.a("total_pc", memoryInfo.getTotalPrivateClean() * 1024);
            objectNode.a("total_sc", memoryInfo.getTotalSharedClean() * 1024);
            objectNode.a("total_swappable", memoryInfo.getTotalSwappablePss() * 1024);
        }
        objectNode.a("dalvik_pd", memoryInfo.dalvikPrivateDirty * 1024);
        objectNode.a("dalvik_pss", memoryInfo.dalvikPss * 1024);
        objectNode.a("dalvik_sd", memoryInfo.dalvikSharedDirty * 1024);
        objectNode.a("native_pd", memoryInfo.nativePrivateDirty * 1024);
        objectNode.a("native_pss", memoryInfo.nativePss * 1024);
        objectNode.a("native_sd", memoryInfo.nativeSharedDirty * 1024);
        objectNode.a("other_pd", memoryInfo.otherPrivateDirty * 1024);
        objectNode.a("other_pss", memoryInfo.otherPss * 1024);
        objectNode.a("other_sd", memoryInfo.otherSharedDirty * 1024);
        objectNode.a("gc_total_count", Debug.getGlobalGcInvocationCount());
        objectNode.a("gc_freed_size", Debug.getGlobalFreedSize());
        objectNode.a("gc_freed_count", Debug.getGlobalFreedCount());
        objectNode.a("native_heap_size", Debug.getNativeHeapSize());
        objectNode.a("native_heap_allocated", Debug.getNativeHeapAllocatedSize());
        objectNode.a("native_heap_free", Debug.getNativeHeapFreeSize());
        try {
            Class cls = MemoryInfo.class;
            if (this.f10889m == null) {
                this.f10889m = cls.getDeclaredField("NUM_OTHER_STATS");
                this.f10895s = ((Integer) this.f10889m.get(null)).intValue();
            }
            if (VERSION.SDK_INT >= 19) {
                try {
                    if (this.f10890n == null) {
                        this.f10890n = cls.getDeclaredField("NUM_DVK_STATS");
                        this.f10896t = ((Integer) this.f10890n.get(null)).intValue();
                    }
                } catch (Throwable e2) {
                    BLog.a("AnalyticsDeviceUtils", e2, "Unable to find NUM_DVK_STATS field", new Object[0]);
                }
            }
            if (this.f10891o == null) {
                this.f10891o = cls.getMethod("getOtherLabel", new Class[]{Integer.TYPE});
            }
            if (this.f10892p == null) {
                this.f10892p = cls.getMethod("getOtherPss", new Class[]{Integer.TYPE});
            }
            if (this.f10893q == null) {
                this.f10893q = cls.getMethod("getOtherPrivateDirty", new Class[]{Integer.TYPE});
            }
            if (this.f10894r == null) {
                this.f10894r = cls.getMethod("getOtherSharedDirty", new Class[]{Integer.TYPE});
            }
            for (c = 0; c < this.f10895s; c++) {
                m11315a(memoryInfo, "other", objectNode, c);
            }
            for (c = 0; c < this.f10896t; c++) {
                m11315a(memoryInfo, "dalvik", objectNode, this.f10895s + c);
            }
        } catch (NoSuchMethodException e3) {
            e2 = e3;
            BLog.a("AnalyticsDeviceUtils", e2, "Unable to send detailed memory info", new Object[0]);
            objectNode.a("is_backgrounded", this.f10888l.j());
            objectNode.a("ever_foregrounded", this.f10888l.m());
            return objectNode;
        } catch (NoSuchFieldException e4) {
            e2 = e4;
            BLog.a("AnalyticsDeviceUtils", e2, "Unable to send detailed memory info", new Object[0]);
            objectNode.a("is_backgrounded", this.f10888l.j());
            objectNode.a("ever_foregrounded", this.f10888l.m());
            return objectNode;
        } catch (IllegalAccessException e5) {
            e2 = e5;
            BLog.a("AnalyticsDeviceUtils", e2, "Unable to send detailed memory info", new Object[0]);
            objectNode.a("is_backgrounded", this.f10888l.j());
            objectNode.a("ever_foregrounded", this.f10888l.m());
            return objectNode;
        } catch (InvocationTargetException e6) {
            e2 = e6;
            BLog.a("AnalyticsDeviceUtils", e2, "Unable to send detailed memory info", new Object[0]);
            objectNode.a("is_backgrounded", this.f10888l.j());
            objectNode.a("ever_foregrounded", this.f10888l.m());
            return objectNode;
        }
        objectNode.a("is_backgrounded", this.f10888l.j());
        objectNode.a("ever_foregrounded", this.f10888l.m());
        return objectNode;
    }

    @VisibleForTesting
    private static String m11314a(String str) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1501161100:
                if (str.equals("image mmap")) {
                    obj = 1;
                    break;
                }
                break;
            case -1185406942:
                if (str.equals("code mmap")) {
                    obj = null;
                    break;
                }
                break;
            case -567800650:
                if (str.equals("Memtrack")) {
                    obj = 4;
                    break;
                }
                break;
            case 2277:
                if (str.equals("GL")) {
                    obj = 3;
                    break;
                }
                break;
            case 165351083:
                if (str.equals("Graphics")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return "oat_mmap";
            case 1:
                return "art_mmap";
            case 2:
                return "egl_mtrack";
            case 3:
                return "gl_mtrack";
            case 4:
                return "other_mtrack";
            default:
                return str.replace(' ', '_').replace(".", "").toLowerCase(Locale.US);
        }
    }

    private void m11315a(MemoryInfo memoryInfo, String str, ObjectNode objectNode, int i) {
        String a = m11314a((String) this.f10891o.invoke(memoryInfo, new Object[]{Integer.valueOf(i)}));
        objectNode.a(str + "_pss_" + a, ((Integer) this.f10892p.invoke(memoryInfo, new Object[]{Integer.valueOf(i)})).intValue() * 1024);
        objectNode.a(str + "_pd_" + a, ((Integer) this.f10893q.invoke(memoryInfo, new Object[]{Integer.valueOf(i)})).intValue() * 1024);
        objectNode.a(str + "_sd_" + a, ((Integer) this.f10894r.invoke(memoryInfo, new Object[]{Integer.valueOf(i)})).intValue() * 1024);
    }

    public final void m11317g(HoneyClientEvent honeyClientEvent) {
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        honeyClientEvent.a("free_mem", maxMemory - (runtime.totalMemory() - runtime.freeMemory()));
        honeyClientEvent.a("total_mem", maxMemory);
        honeyClientEvent.a("core_count", this.f10885i.c());
        honeyClientEvent.a("reliable_core_count", this.f10885i.b());
        honeyClientEvent.a("memory_info", m11312a());
        ((MemoryAnalyticsCounters) this.f10886j.get()).a(honeyClientEvent);
    }
}
