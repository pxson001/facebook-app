package com.facebook.adsmanager.deeplinking;

import android.content.Intent;
import android.net.Uri;
import com.facebook.content.AppInfo;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: expires */
public class AdsManagerDeepLinkingUtils {
    private static volatile AdsManagerDeepLinkingUtils f12581c;
    private final QeAccessor f12582a;
    private final AppInfo f12583b;

    public static com.facebook.adsmanager.deeplinking.AdsManagerDeepLinkingUtils m13362a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12581c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.adsmanager.deeplinking.AdsManagerDeepLinkingUtils.class;
        monitor-enter(r1);
        r0 = f12581c;	 Catch:{ all -> 0x003a }
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
        r0 = m13363b(r0);	 Catch:{ all -> 0x0035 }
        f12581c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12581c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adsmanager.deeplinking.AdsManagerDeepLinkingUtils.a(com.facebook.inject.InjectorLike):com.facebook.adsmanager.deeplinking.AdsManagerDeepLinkingUtils");
    }

    private static AdsManagerDeepLinkingUtils m13363b(InjectorLike injectorLike) {
        return new AdsManagerDeepLinkingUtils(AppInfo.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    AdsManagerDeepLinkingUtils(AppInfo appInfo, QeAccessor qeAccessor) {
        this.f12583b = appInfo;
        this.f12582a = qeAccessor;
    }

    public final boolean m13365a() {
        if (m13364d()) {
            return this.f12582a.a(ExperimentsForAdsManagerDeepLinkingModule.b, false);
        }
        return false;
    }

    public final boolean m13366b() {
        if (m13364d()) {
            return this.f12582a.a(ExperimentsForAdsManagerDeepLinkingModule.a, false);
        }
        return false;
    }

    public final boolean m13367c() {
        if (m13364d()) {
            return this.f12582a.a(ExperimentsForAdsManagerDeepLinkingModule.c, false);
        }
        return false;
    }

    private boolean m13364d() {
        return this.f12583b.c("com.facebook.adsmanager");
    }

    public static Intent m13361a(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(402653184);
        return intent;
    }
}
