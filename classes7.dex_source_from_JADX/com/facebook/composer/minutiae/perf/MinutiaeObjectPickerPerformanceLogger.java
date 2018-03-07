package com.facebook.composer.minutiae.perf;

import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.inject.InjectorLike;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: tip_jar_bottom_sheet_nux_shown */
public class MinutiaeObjectPickerPerformanceLogger extends MinutiaePerformanceLogger {
    private static final Map<String, String> f1607a = ImmutableMap.of("minutiae_object_picker_time_to_fetch_end", "minutiae_object_picker_time_to_fetch_end_cached", "minutiae_object_picker_time_to_results_shown", "minutiae_object_picker_time_to_results_shown_cached", "minutiae_object_picker_fetch_time", "minutiae_object_picker_fetch_time_cached");
    private static final Map<Integer, Integer> f1608b = ImmutableMap.of(Integer.valueOf(4325379), Integer.valueOf(4325384), Integer.valueOf(4325380), Integer.valueOf(4325385), Integer.valueOf(4325381), Integer.valueOf(4325386));
    private static volatile MinutiaeObjectPickerPerformanceLogger f1609c;

    public static com.facebook.composer.minutiae.perf.MinutiaeObjectPickerPerformanceLogger m1656a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1609c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.minutiae.perf.MinutiaeObjectPickerPerformanceLogger.class;
        monitor-enter(r1);
        r0 = f1609c;	 Catch:{ all -> 0x003a }
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
        r0 = m1657b(r0);	 Catch:{ all -> 0x0035 }
        f1609c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1609c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.minutiae.perf.MinutiaeObjectPickerPerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.composer.minutiae.perf.MinutiaeObjectPickerPerformanceLogger");
    }

    private static MinutiaeObjectPickerPerformanceLogger m1657b(InjectorLike injectorLike) {
        return new MinutiaeObjectPickerPerformanceLogger((PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike));
    }

    @Inject
    public MinutiaeObjectPickerPerformanceLogger(PerformanceLogger performanceLogger) {
        super(performanceLogger, f1607a, f1608b);
    }

    public final void m1658a() {
        m1655c(4325377, "minutiae_object_picker_time_to_init");
        m1655c(4325378, "minutiae_object_picker_time_to_fetch_start");
        m1655c(4325379, "minutiae_object_picker_time_to_fetch_end");
        m1655c(4325380, "minutiae_object_picker_time_to_results_shown");
        m1655c(4325383, "minutiae_object_picker_time_to_search_shown");
    }

    public final void m1660c() {
        m1655c(4325387, "minutiae_object_picker_time_to_scroll_load");
    }

    public final void m1661d() {
        m1654b(4325387, "minutiae_object_picker_time_to_scroll_load");
    }

    public final void m1659a(DataFreshnessResult dataFreshnessResult) {
        m1653a(4325379, "minutiae_object_picker_time_to_fetch_end", dataFreshnessResult);
        m1653a(4325381, "minutiae_object_picker_fetch_time", dataFreshnessResult);
        m1655c(4325382, "minutiae_object_picker_rendering_time");
    }

    public final void m1662g() {
        m1652a(4325379, "minutiae_object_picker_time_to_fetch_end");
        m1652a(4325380, "minutiae_object_picker_time_to_results_shown");
        m1652a(4325381, "minutiae_object_picker_fetch_time");
    }
}
