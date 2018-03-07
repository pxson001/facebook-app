package com.facebook.assetdownload.debug;

import com.facebook.assetdownload.AssetDownloadManager;
import com.facebook.assetdownload.background.AssetDownloadConditionalWorker;
import com.facebook.assetdownload.local.DownloadLocalFileManager;
import com.facebook.assetdownload.local.DownloadLocalFileMapper;
import com.facebook.assetdownload.repository.AssetDownloadConfigurationRepository;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: profile_picture_overlays */
public class AssetDownloadDumperPlugin {
    private static volatile AssetDownloadDumperPlugin f7315e;
    private final AssetDownloadDebugHelper f7316a;
    private final AssetDownloadManager f7317b;
    private final DownloadLocalFileMapper f7318c;
    private final TimeFormatUtil f7319d;

    public static com.facebook.assetdownload.debug.AssetDownloadDumperPlugin m10423a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7315e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.assetdownload.debug.AssetDownloadDumperPlugin.class;
        monitor-enter(r1);
        r0 = f7315e;	 Catch:{ all -> 0x003a }
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
        r0 = m10424b(r0);	 Catch:{ all -> 0x0035 }
        f7315e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7315e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.assetdownload.debug.AssetDownloadDumperPlugin.a(com.facebook.inject.InjectorLike):com.facebook.assetdownload.debug.AssetDownloadDumperPlugin");
    }

    private static AssetDownloadDumperPlugin m10424b(InjectorLike injectorLike) {
        return new AssetDownloadDumperPlugin(new AssetDownloadDebugHelper(AssetDownloadConfigurationRepository.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), AssetDownloadConditionalWorker.m10391b(injectorLike), DownloadLocalFileManager.m10425b(injectorLike), DownloadLocalFileMapper.b(injectorLike)), AssetDownloadManager.a(injectorLike), DownloadLocalFileMapper.b(injectorLike), (TimeFormatUtil) DefaultTimeFormatUtil.a(injectorLike));
    }

    @Inject
    public AssetDownloadDumperPlugin(AssetDownloadDebugHelper assetDownloadDebugHelper, AssetDownloadManager assetDownloadManager, DownloadLocalFileMapper downloadLocalFileMapper, TimeFormatUtil timeFormatUtil) {
        this.f7316a = assetDownloadDebugHelper;
        this.f7317b = assetDownloadManager;
        this.f7318c = downloadLocalFileMapper;
        this.f7319d = timeFormatUtil;
    }
}
