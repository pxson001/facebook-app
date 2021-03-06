package com.facebook.assetdownload.logging;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.logger.IAnalyticsPeriodicEventReporter;
import com.facebook.assetdownload.local.DownloadLocalFileManager;
import com.facebook.assetdownload.repository.AssetDownloadConfigurationRepository;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: profile_photo_prompt_uploaded */
public class AssetDownloadPeriodicEventReporter implements IAnalyticsPeriodicEventReporter {
    private static volatile AssetDownloadPeriodicEventReporter f7331e;
    private final AssetDownloadConfigurationRepository f7332a;
    private final DownloadLocalFileManager f7333b;
    private final Clock f7334c;
    private final Provider<Boolean> f7335d;

    public static com.facebook.assetdownload.logging.AssetDownloadPeriodicEventReporter m10437a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7331e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.assetdownload.logging.AssetDownloadPeriodicEventReporter.class;
        monitor-enter(r1);
        r0 = f7331e;	 Catch:{ all -> 0x003a }
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
        r0 = m10438b(r0);	 Catch:{ all -> 0x0035 }
        f7331e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7331e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.assetdownload.logging.AssetDownloadPeriodicEventReporter.a(com.facebook.inject.InjectorLike):com.facebook.assetdownload.logging.AssetDownloadPeriodicEventReporter");
    }

    private static AssetDownloadPeriodicEventReporter m10438b(InjectorLike injectorLike) {
        return new AssetDownloadPeriodicEventReporter(AssetDownloadConfigurationRepository.b(injectorLike), DownloadLocalFileManager.m10425b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3898));
    }

    @Inject
    public AssetDownloadPeriodicEventReporter(AssetDownloadConfigurationRepository assetDownloadConfigurationRepository, DownloadLocalFileManager downloadLocalFileManager, Clock clock, Provider<Boolean> provider) {
        this.f7332a = assetDownloadConfigurationRepository;
        this.f7333b = downloadLocalFileManager;
        this.f7334c = clock;
        this.f7335d = provider;
    }

    @Nullable
    public final HoneyAnalyticsEvent m10439a(long j, String str) {
        if (!((Boolean) this.f7335d.get()).booleanValue()) {
            return null;
        }
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("assetdownload_db_and_fs_stats");
        honeyClientEvent.c = "assetdownload";
        honeyClientEvent.a("db_configs_total", this.f7332a.b());
        honeyClientEvent.a("db_configs_finished", this.f7332a.c());
        honeyClientEvent.a("db_configs_in_quarantine", this.f7332a.a(this.f7334c.a() - 259200000, this.f7334c.a()));
        honeyClientEvent.a("fs_total_dir_size", this.f7333b.m10429b());
        honeyClientEvent.a("fs_total_custom_location_size", this.f7333b.m10430c());
        return honeyClientEvent;
    }
}
