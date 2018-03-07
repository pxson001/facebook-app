package com.facebook.quickpromotion.ui;

import android.content.Context;
import android.content.Intent;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.quickpromotion.controller.QuickPromotionController;
import com.facebook.quickpromotion.controller.QuickPromotionControllerDelegateProvider;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.TemplateType;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: reaction_after_cursor */
public final class QuickPromotionDiveBarController extends QuickPromotionController {
    public static final InterstitialTrigger f4766a = new InterstitialTrigger(Action.DIVEBAR_OPEN);
    private static volatile QuickPromotionDiveBarController f4767b;

    public static com.facebook.quickpromotion.ui.QuickPromotionDiveBarController m4655a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4767b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.quickpromotion.ui.QuickPromotionDiveBarController.class;
        monitor-enter(r1);
        r0 = f4767b;	 Catch:{ all -> 0x003a }
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
        r0 = m4656b(r0);	 Catch:{ all -> 0x0035 }
        f4767b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4767b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quickpromotion.ui.QuickPromotionDiveBarController.a(com.facebook.inject.InjectorLike):com.facebook.quickpromotion.ui.QuickPromotionDiveBarController");
    }

    private static QuickPromotionDiveBarController m4656b(InjectorLike injectorLike) {
        return new QuickPromotionDiveBarController((QuickPromotionControllerDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(QuickPromotionControllerDelegateProvider.class));
    }

    @Inject
    public QuickPromotionDiveBarController(QuickPromotionControllerDelegateProvider quickPromotionControllerDelegateProvider) {
        super(quickPromotionControllerDelegateProvider);
    }

    public final String m4658b() {
        return "1824";
    }

    public final Intent m4657b(Context context) {
        return new Intent();
    }

    protected final long m4659f() {
        return 0;
    }

    public final String m4660g() {
        return "Divebar";
    }

    public final Set<TemplateType> m4661j() {
        return ImmutableSet.of(TemplateType.DIVEBAR_HEADER_MEDIUM);
    }
}
