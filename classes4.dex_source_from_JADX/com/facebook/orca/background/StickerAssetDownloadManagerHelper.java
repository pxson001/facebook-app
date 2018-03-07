package com.facebook.orca.background;

import com.facebook.assetdownload.AssetDownloadManager;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.data.StickerDbStorage;
import com.facebook.stickers.data.StickersFileUtil;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: failed_batch_ids */
public class StickerAssetDownloadManagerHelper {
    private static final Class<?> f12314a = StickerAssetDownloadManagerHelper.class;
    private static volatile StickerAssetDownloadManagerHelper f12315f;
    private final AssetDownloadManager f12316b;
    private final StickersFileUtil f12317c;
    public final Provider<StickerDbStorage> f12318d;
    public final Provider<StickerCache> f12319e;

    public static com.facebook.orca.background.StickerAssetDownloadManagerHelper m12997a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12315f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.background.StickerAssetDownloadManagerHelper.class;
        monitor-enter(r1);
        r0 = f12315f;	 Catch:{ all -> 0x003a }
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
        r0 = m12998b(r0);	 Catch:{ all -> 0x0035 }
        f12315f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12315f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.background.StickerAssetDownloadManagerHelper.a(com.facebook.inject.InjectorLike):com.facebook.orca.background.StickerAssetDownloadManagerHelper");
    }

    private static StickerAssetDownloadManagerHelper m12998b(InjectorLike injectorLike) {
        return new StickerAssetDownloadManagerHelper(AssetDownloadManager.m12999a(injectorLike), StickersFileUtil.m13050a(injectorLike), ProductMethodAutoProvider.b(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 3447), IdBasedProvider.a(injectorLike, 3445));
    }

    @Inject
    public StickerAssetDownloadManagerHelper(AssetDownloadManager assetDownloadManager, StickersFileUtil stickersFileUtil, Product product, Provider<StickerDbStorage> provider, Provider<StickerCache> provider2) {
        this.f12316b = assetDownloadManager;
        this.f12317c = stickersFileUtil;
        this.f12318d = provider;
        this.f12319e = provider2;
    }
}
