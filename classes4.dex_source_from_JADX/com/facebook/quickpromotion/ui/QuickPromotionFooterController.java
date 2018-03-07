package com.facebook.quickpromotion.ui;

import android.content.Context;
import android.content.Intent;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.quickpromotion.controller.QuickPromotionController;
import com.facebook.quickpromotion.controller.QuickPromotionControllerDelegateProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: request_lockscreen_reset */
public final class QuickPromotionFooterController extends QuickPromotionController {
    public static final InterstitialTrigger f3432a = new InterstitialTrigger(Action.THREAD_LIST_OPEN);
    public static final InterstitialTrigger f3433b = new InterstitialTrigger(Action.GROUP_MALL_VIEW);
    public static final InterstitialTrigger f3434c = new InterstitialTrigger(Action.TAB_NAVIGATION_FRIEND_REQUESTS);
    public static final InterstitialTrigger f3435d = new InterstitialTrigger(Action.TIMELINE);
    public static final InterstitialTrigger f3436e = new InterstitialTrigger(Action.PAGE_ADMIN_TIMELINE_VIEW);
    public static final InterstitialTrigger f3437f = new InterstitialTrigger(Action.PAGE_ADMIN_TIMELINE_VIEW_VERIFY_ELIGIBLE);
    public static final InterstitialTrigger f3438g = new InterstitialTrigger(Action.PERSONAL_PROFILE_OWNER);
    public static final InterstitialTrigger f3439h = new InterstitialTrigger(Action.PERSONAL_PROFILE_FRIEND);
    public static final InterstitialTrigger f3440i = new InterstitialTrigger(Action.PERSONAL_PROFILE_NONFRIEND);
    private static volatile QuickPromotionFooterController f3441j;

    public static com.facebook.quickpromotion.ui.QuickPromotionFooterController m3656a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3441j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.quickpromotion.ui.QuickPromotionFooterController.class;
        monitor-enter(r1);
        r0 = f3441j;	 Catch:{ all -> 0x003a }
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
        r0 = m3657b(r0);	 Catch:{ all -> 0x0035 }
        f3441j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3441j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quickpromotion.ui.QuickPromotionFooterController.a(com.facebook.inject.InjectorLike):com.facebook.quickpromotion.ui.QuickPromotionFooterController");
    }

    private static QuickPromotionFooterController m3657b(InjectorLike injectorLike) {
        return new QuickPromotionFooterController((QuickPromotionControllerDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(QuickPromotionControllerDelegateProvider.class));
    }

    @Inject
    QuickPromotionFooterController(QuickPromotionControllerDelegateProvider quickPromotionControllerDelegateProvider) {
        super(quickPromotionControllerDelegateProvider);
    }

    public final String m3659b() {
        return "1820";
    }

    public final Intent m3658b(Context context) {
        return new Intent();
    }

    protected final long m3660f() {
        return 0;
    }

    public final String m3661g() {
        return "Footer";
    }

    protected final boolean m3662k() {
        return true;
    }
}
