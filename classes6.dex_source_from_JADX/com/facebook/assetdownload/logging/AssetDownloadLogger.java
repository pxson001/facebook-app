package com.facebook.assetdownload.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.assetdownload.AssetDownloadConfiguration;
import com.facebook.assetdownload.background.AssetDownloadRunner.EligibilityCallback;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import java.util.HashSet;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: profile_pic_method */
public class AssetDownloadLogger {
    private static final Class<?> f7327a = AssetDownloadLogger.class;
    private static volatile AssetDownloadLogger f7328d;
    private final AnalyticsLogger f7329b;
    private final MonotonicClock f7330c;

    public static com.facebook.assetdownload.logging.AssetDownloadLogger m10432a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7328d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.assetdownload.logging.AssetDownloadLogger.class;
        monitor-enter(r1);
        r0 = f7328d;	 Catch:{ all -> 0x003a }
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
        r0 = m10433b(r0);	 Catch:{ all -> 0x0035 }
        f7328d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7328d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.assetdownload.logging.AssetDownloadLogger.a(com.facebook.inject.InjectorLike):com.facebook.assetdownload.logging.AssetDownloadLogger");
    }

    private static AssetDownloadLogger m10433b(InjectorLike injectorLike) {
        return new AssetDownloadLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AssetDownloadLogger(AnalyticsLogger analyticsLogger, MonotonicClock monotonicClock) {
        this.f7329b = analyticsLogger;
        this.f7330c = monotonicClock;
    }

    public final void m10435a(AssetDownloadConfiguration assetDownloadConfiguration, long j, long j2, boolean z) {
        HoneyClientEvent a = m10431a(assetDownloadConfiguration, j, z);
        a.b("download_status", "success");
        a.a("content_bytes", j2);
        this.f7329b.a(a, 20);
    }

    public final void m10436a(AssetDownloadConfiguration assetDownloadConfiguration, long j, Exception exception, boolean z) {
        String str = null;
        HoneyClientEvent a = m10431a(assetDownloadConfiguration, j, z);
        a.b("download_status", "failure");
        a.b("exception", exception != null ? exception.getMessage() : null);
        String str2 = "exception_class";
        if (exception != null) {
            str = exception.getClass().getName();
        }
        a.b(str2, str);
        this.f7329b.a(a);
    }

    public final void m10434a(long j, HashSet<EligibilityCallback> hashSet, int i, int i2, long j2, boolean z) {
        HoneyClientEventFast a = this.f7329b.a("assetdownload_session", false);
        if (a.a()) {
            a.a("time_elapsed", this.f7330c.now() - j);
            StringBuilder stringBuilder = new StringBuilder();
            try {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    EligibilityCallback eligibilityCallback = (EligibilityCallback) it.next();
                    if (!eligibilityCallback.mo903a()) {
                        if (stringBuilder.length() != 0) {
                            stringBuilder.append(", ");
                        }
                        stringBuilder.append(eligibilityCallback.mo905c());
                    }
                }
            } catch (Exception e) {
            }
            a.a("failing_eligibility_callbacks", stringBuilder.toString());
            a.a("total_assets_processed", i);
            a.a("total_assets_downloaded", i2);
            a.a("total_content_bytes", j2);
            a.a("wifi_available", z);
            a.b();
        }
    }

    private HoneyClientEvent m10431a(AssetDownloadConfiguration assetDownloadConfiguration, long j, boolean z) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("assetdownload_download");
        honeyClientEvent.b("identifier", assetDownloadConfiguration.mIdentifier);
        honeyClientEvent.b("analytics_tag", assetDownloadConfiguration.mAnalyticsTag);
        honeyClientEvent.a("storage", assetDownloadConfiguration.mStorageConstraint);
        honeyClientEvent.a("connection", assetDownloadConfiguration.mConnectionConstraint);
        honeyClientEvent.a("time_elapsed", this.f7330c.now() - j);
        honeyClientEvent.a("wifi_available", z);
        return honeyClientEvent;
    }
}
