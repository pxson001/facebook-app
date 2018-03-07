package com.facebook.quickpromotion.asset;

import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: qe_group_upsell */
public class QuickPromotionAssetManagerImpl {
    private static volatile QuickPromotionAssetManagerImpl f3941b;
    private final QuickPromotionImageFetcher f3942a;

    public static com.facebook.quickpromotion.asset.QuickPromotionAssetManagerImpl m4401a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3941b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.quickpromotion.asset.QuickPromotionAssetManagerImpl.class;
        monitor-enter(r1);
        r0 = f3941b;	 Catch:{ all -> 0x003a }
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
        r0 = m4402b(r0);	 Catch:{ all -> 0x0035 }
        f3941b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3941b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quickpromotion.asset.QuickPromotionAssetManagerImpl.a(com.facebook.inject.InjectorLike):com.facebook.quickpromotion.asset.QuickPromotionAssetManagerImpl");
    }

    private static QuickPromotionAssetManagerImpl m4402b(InjectorLike injectorLike) {
        return new QuickPromotionAssetManagerImpl(QuickPromotionImageFetcher.m4405a(injectorLike));
    }

    @Inject
    public QuickPromotionAssetManagerImpl(QuickPromotionImageFetcher quickPromotionImageFetcher) {
        this.f3942a = quickPromotionImageFetcher;
    }

    public final boolean m4403a(QuickPromotionDefinition quickPromotionDefinition) {
        for (ImageRequest imageRequest : this.f3942a.m4412a(quickPromotionDefinition).values()) {
            if (!this.f3942a.f3946c.b(imageRequest.c)) {
                return false;
            }
        }
        return true;
    }

    public final void m4404b(QuickPromotionDefinition quickPromotionDefinition) {
        QuickPromotionImageFetcher quickPromotionImageFetcher = this.f3942a;
        for (ImageRequest e : quickPromotionImageFetcher.m4412a(quickPromotionDefinition).values()) {
            quickPromotionImageFetcher.f3946c.e(e, QuickPromotionImageFetcher.f3943a);
        }
    }
}
