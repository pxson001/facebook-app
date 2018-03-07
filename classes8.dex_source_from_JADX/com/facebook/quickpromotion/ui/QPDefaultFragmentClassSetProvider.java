package com.facebook.quickpromotion.ui;

import com.facebook.quickpromotion.annotations.QuickPromotionFragmentClassSetProvider;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.TemplateType;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: reaction_aggregated_units_count */
public class QPDefaultFragmentClassSetProvider implements QuickPromotionFragmentClassSetProvider {
    private static volatile QPDefaultFragmentClassSetProvider f4765a;

    public static com.facebook.quickpromotion.ui.QPDefaultFragmentClassSetProvider m4652a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f4765a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.quickpromotion.ui.QPDefaultFragmentClassSetProvider.class;
        monitor-enter(r1);
        r0 = f4765a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m4653b();	 Catch:{ all -> 0x0034 }
        f4765a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f4765a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quickpromotion.ui.QPDefaultFragmentClassSetProvider.a(com.facebook.inject.InjectorLike):com.facebook.quickpromotion.ui.QPDefaultFragmentClassSetProvider");
    }

    private static QPDefaultFragmentClassSetProvider m4653b() {
        return new QPDefaultFragmentClassSetProvider();
    }

    @Inject
    QPDefaultFragmentClassSetProvider() {
    }

    public final ImmutableMap<TemplateType, Class<? extends QuickPromotionFragment>> mo224a() {
        return ImmutableMap.builder().b(TemplateType.ANDROID_FOOTER, QuickPromotionFooterFragment.class).b(TemplateType.TOAST_FOOTER, QuickPromotionToastFooterFragment.class).b(TemplateType.ANDROID_MESSAGES_INTERSTITIAL_2_BUTTON, QuickPromotionInterstitialFragment.class).b(TemplateType.INTERSTITIAL_1_BUTTON_X, QuickPromotionInterstitialFragment.class).b(TemplateType.INTERSTITIAL_2_BUTTON, QuickPromotionInterstitialFragment.class).b(TemplateType.CARD, QuickPromotionInterstitialFragment.class).b(TemplateType.CARD_WITH_HEADER, QuickPromotionInterstitialFragment.class).b(TemplateType.FIG_DIALOG, QuickPromotionInterstitialFragment.class).b(TemplateType.MESSENGER_CARD, QuickPromotionInterstitialFragment.class).b(TemplateType.MESSENGER_CARD_NO_BADGE, QuickPromotionInterstitialFragment.class).b(TemplateType.ANDROID_PAGER, QuickPromotionMultiPageInterstitialMainFragment.class).b();
    }
}
