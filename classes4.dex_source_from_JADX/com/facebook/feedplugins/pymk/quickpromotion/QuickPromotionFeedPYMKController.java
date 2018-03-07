package com.facebook.feedplugins.pymk.quickpromotion;

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
/* compiled from: removeControllers() must be called before setting controllers */
public final class QuickPromotionFeedPYMKController extends QuickPromotionController {
    public static final InterstitialTrigger f3479a = new InterstitialTrigger(Action.FEED_PYMK_FRIEND_REQUEST_SENT);
    public static final InterstitialTrigger f3480b = new InterstitialTrigger(Action.FEED_PYMK_SCROLLED);
    public static final InterstitialTrigger f3481c = new InterstitialTrigger(Action.FEED_PYMK_XOUTED);
    private static volatile QuickPromotionFeedPYMKController f3482d;

    public static com.facebook.feedplugins.pymk.quickpromotion.QuickPromotionFeedPYMKController m3752a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3482d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.pymk.quickpromotion.QuickPromotionFeedPYMKController.class;
        monitor-enter(r1);
        r0 = f3482d;	 Catch:{ all -> 0x003a }
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
        r0 = m3753b(r0);	 Catch:{ all -> 0x0035 }
        f3482d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3482d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.pymk.quickpromotion.QuickPromotionFeedPYMKController.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.pymk.quickpromotion.QuickPromotionFeedPYMKController");
    }

    private static QuickPromotionFeedPYMKController m3753b(InjectorLike injectorLike) {
        return new QuickPromotionFeedPYMKController((QuickPromotionControllerDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(QuickPromotionControllerDelegateProvider.class));
    }

    @Inject
    public QuickPromotionFeedPYMKController(QuickPromotionControllerDelegateProvider quickPromotionControllerDelegateProvider) {
        super(quickPromotionControllerDelegateProvider);
    }

    protected final Intent m3754b(Context context) {
        return new Intent();
    }

    protected final long m3756f() {
        return 0;
    }

    public final String m3757g() {
        return "Feed PYMK";
    }

    public final String m3755b() {
        return "3279";
    }

    protected final boolean m3758k() {
        return true;
    }
}
