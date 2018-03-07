package com.facebook.pages.common.util;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.quickpromotion.controller.QuickPromotionController;
import com.facebook.quickpromotion.ui.QuickPromotionInterstitialController;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: corrected_query_function */
public class PagesQuickPromotionUtils {
    private static volatile PagesQuickPromotionUtils f16890c;
    private final InterstitialManager f16891a;
    private final SecureContextHelper f16892b;

    public static com.facebook.pages.common.util.PagesQuickPromotionUtils m20188a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16890c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.common.util.PagesQuickPromotionUtils.class;
        monitor-enter(r1);
        r0 = f16890c;	 Catch:{ all -> 0x003a }
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
        r0 = m20190b(r0);	 Catch:{ all -> 0x0035 }
        f16890c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16890c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.util.PagesQuickPromotionUtils.a(com.facebook.inject.InjectorLike):com.facebook.pages.common.util.PagesQuickPromotionUtils");
    }

    private static PagesQuickPromotionUtils m20190b(InjectorLike injectorLike) {
        return new PagesQuickPromotionUtils(InterstitialManager.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    PagesQuickPromotionUtils(InterstitialManager interstitialManager, SecureContextHelper secureContextHelper) {
        this.f16891a = interstitialManager;
        this.f16892b = secureContextHelper;
    }

    private static Intent m20189b(QuickPromotionController quickPromotionController, Context context) {
        String b = quickPromotionController.b();
        if (QuickPromotionInterstitialController.a.equals(b) || "2610".equals(b)) {
            return quickPromotionController.a(context);
        }
        return null;
    }

    public static Intent m20187a(QuickPromotionController quickPromotionController, Context context) {
        if ("1820".equals(quickPromotionController.b())) {
            return quickPromotionController.a(context);
        }
        return null;
    }

    public final boolean m20191a(InterstitialTrigger interstitialTrigger, Context context) {
        QuickPromotionController quickPromotionController = (QuickPromotionController) this.f16891a.a(interstitialTrigger, QuickPromotionController.class);
        if (quickPromotionController == null) {
            return false;
        }
        Intent b = m20189b(quickPromotionController, context);
        if (b == null) {
            return false;
        }
        this.f16892b.a(b, context);
        return true;
    }
}
