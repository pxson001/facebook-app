package com.facebook.composer.minutiae.perf;

import com.facebook.inject.InjectorLike;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: tip_jar */
public class MinutiaeVerbPickerPerformanceLogger extends MinutiaePerformanceLogger {
    private static final Map<String, String> f1610a = ImmutableMap.of("minutiae_verb_picker_time_to_fetch_end", "minutiae_verb_picker_time_to_fetch_end_cached", "minutiae_verb_picker_time_to_verbs_shown", "minutiae_verb_picker_time_to_verbs_shown_cached", "minutiae_verb_picker_fetch_time", "minutiae_verb_picker_fetch_time_cached", "minutiae_verb_picker_tti", "minutiae_verb_picker_tti_cached");
    private static final Map<Integer, Integer> f1611b = ImmutableMap.of(Integer.valueOf(4390915), Integer.valueOf(4390919), Integer.valueOf(4390923), Integer.valueOf(4390920), Integer.valueOf(4390916), Integer.valueOf(4390921), Integer.valueOf(4390918), Integer.valueOf(4390922));
    private static volatile MinutiaeVerbPickerPerformanceLogger f1612c;

    public static com.facebook.composer.minutiae.perf.MinutiaeVerbPickerPerformanceLogger m1663a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1612c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.minutiae.perf.MinutiaeVerbPickerPerformanceLogger.class;
        monitor-enter(r1);
        r0 = f1612c;	 Catch:{ all -> 0x003a }
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
        r0 = m1664b(r0);	 Catch:{ all -> 0x0035 }
        f1612c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1612c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.minutiae.perf.MinutiaeVerbPickerPerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.composer.minutiae.perf.MinutiaeVerbPickerPerformanceLogger");
    }

    private static MinutiaeVerbPickerPerformanceLogger m1664b(InjectorLike injectorLike) {
        return new MinutiaeVerbPickerPerformanceLogger((PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike));
    }

    @Inject
    public MinutiaeVerbPickerPerformanceLogger(PerformanceLogger performanceLogger) {
        super(performanceLogger, f1610a, f1611b);
    }
}
