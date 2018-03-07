package com.facebook.photos.progressiveimagequality.datausage;

import android.net.Uri;
import android.os.Handler;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.datasensitivity.pref.DataSensitivitySettingsPrefUtil;
import com.facebook.device.datausage.DataUsageSyncer;
import com.facebook.device.datausage.SqlUtils;
import com.facebook.device.resourcemonitor.DataUsageBytes;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: seen_by */
public class CompressionSavingsAnalyticsLogger {
    private static volatile CompressionSavingsAnalyticsLogger f2878f;
    public final AnalyticsLogger f2879a;
    public final DataUsageSyncer f2880b;
    private final FbNetworkManager f2881c;
    private final Handler f2882d;
    private final DataSensitivitySettingsPrefUtil f2883e;

    public static com.facebook.photos.progressiveimagequality.datausage.CompressionSavingsAnalyticsLogger m3141a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2878f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.progressiveimagequality.datausage.CompressionSavingsAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f2878f;	 Catch:{ all -> 0x003a }
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
        r0 = m3143b(r0);	 Catch:{ all -> 0x0035 }
        f2878f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2878f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.progressiveimagequality.datausage.CompressionSavingsAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.photos.progressiveimagequality.datausage.CompressionSavingsAnalyticsLogger");
    }

    private static CompressionSavingsAnalyticsLogger m3143b(InjectorLike injectorLike) {
        return new CompressionSavingsAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), DataUsageSyncer.a(injectorLike), FbNetworkManager.a(injectorLike), Handler_ForNonUiThreadMethodAutoProvider.b(injectorLike), DataSensitivitySettingsPrefUtil.a(injectorLike));
    }

    public static void m3142a(CompressionSavingsAnalyticsLogger compressionSavingsAnalyticsLogger, long j, DataUsageBytes dataUsageBytes, Date date) {
        long j2 = dataUsageBytes.c + dataUsageBytes.b;
        HoneyClientEvent b = new HoneyClientEvent("date_bytes").a("data_used_bytes", j2).a("data_saved_bytes", j).b("date", SqlUtils.a(date));
        b.c = "data_sensitivity";
        HoneyAnalyticsEvent honeyAnalyticsEvent = b;
        if (compressionSavingsAnalyticsLogger.f2883e.a(false)) {
            honeyAnalyticsEvent = honeyAnalyticsEvent.a("data_used_bytes_data_saving_mode_users", j2).a("data_saved_bytes_data_saving_mode_users", j);
        }
        compressionSavingsAnalyticsLogger.f2879a.a(honeyAnalyticsEvent);
    }

    @Inject
    public CompressionSavingsAnalyticsLogger(AnalyticsLogger analyticsLogger, DataUsageSyncer dataUsageSyncer, FbNetworkManager fbNetworkManager, Handler handler, DataSensitivitySettingsPrefUtil dataSensitivitySettingsPrefUtil) {
        this.f2879a = analyticsLogger;
        this.f2880b = dataUsageSyncer;
        this.f2881c = fbNetworkManager;
        this.f2882d = handler;
        this.f2883e = dataSensitivitySettingsPrefUtil;
    }

    public final void m3144a(long j, Date date) {
        HandlerDetour.a(this.f2882d, new 1(this, date, j), 1381697901);
    }

    public final void m3145a(Uri uri, CallerContext callerContext, long j, long j2) {
        if (Math.random() <= 0.05d) {
            HandlerDetour.a(this.f2882d, new 2(this, uri, callerContext, this.f2881c.k(), this.f2881c.l(), j, j2), 905915917);
        }
    }
}
