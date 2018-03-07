package com.facebook.maps;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsConfig;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: edit_privacy_open */
public class MapAnalyticsLogger {
    private static volatile MapAnalyticsLogger f13402d;
    public final Lazy<AnalyticsConfig> f13403a;
    public final Lazy<AnalyticsLogger> f13404b;
    public final AbstractFbErrorReporter f13405c;

    public static com.facebook.maps.MapAnalyticsLogger m14303a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13402d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.maps.MapAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f13402d;	 Catch:{ all -> 0x003a }
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
        r0 = m14304b(r0);	 Catch:{ all -> 0x0035 }
        f13402d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13402d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.maps.MapAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.maps.MapAnalyticsLogger");
    }

    private static MapAnalyticsLogger m14304b(InjectorLike injectorLike) {
        return new MapAnalyticsLogger(IdBasedSingletonScopeProvider.b(injectorLike, 2406), IdBasedSingletonScopeProvider.b(injectorLike, 175), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public MapAnalyticsLogger(Lazy<AnalyticsConfig> lazy, Lazy<AnalyticsLogger> lazy2, FbErrorReporter fbErrorReporter) {
        this.f13403a = lazy;
        this.f13404b = lazy2;
        this.f13405c = fbErrorReporter;
    }

    public final void m14305a(String str, long[] jArr, int i, long j, long j2, long j3) {
        HoneyClientEventFast a = ((AnalyticsLogger) this.f13404b.get()).a(str, false);
        if (a.a()) {
            a.a("oxygen_map").a("percentile_25", jArr[0]).a("percentile_50", jArr[1]).a("percentile_75", jArr[2]).a("percentile_90", jArr[3]).a("percentile_99", jArr[4]).a("instance_size", i).a("max_sample_value", j).a("min_sample_value", j2).a("sum_sample_value", j3);
            a.b();
        }
    }
}
