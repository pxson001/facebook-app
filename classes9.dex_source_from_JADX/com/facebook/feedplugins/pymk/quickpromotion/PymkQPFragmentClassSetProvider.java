package com.facebook.feedplugins.pymk.quickpromotion;

import com.facebook.quickpromotion.annotations.QuickPromotionFragmentClassSetProvider;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.TemplateType;
import com.facebook.quickpromotion.ui.QuickPromotionFragment;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: TOOK_PICTURE */
public class PymkQPFragmentClassSetProvider implements QuickPromotionFragmentClassSetProvider {
    private static volatile PymkQPFragmentClassSetProvider f24727a;

    public static com.facebook.feedplugins.pymk.quickpromotion.PymkQPFragmentClassSetProvider m26592a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f24727a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.feedplugins.pymk.quickpromotion.PymkQPFragmentClassSetProvider.class;
        monitor-enter(r1);
        r0 = f24727a;	 Catch:{ all -> 0x0039 }
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
        r0 = m26593b();	 Catch:{ all -> 0x0034 }
        f24727a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f24727a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.pymk.quickpromotion.PymkQPFragmentClassSetProvider.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.pymk.quickpromotion.PymkQPFragmentClassSetProvider");
    }

    private static PymkQPFragmentClassSetProvider m26593b() {
        return new PymkQPFragmentClassSetProvider();
    }

    @Inject
    PymkQPFragmentClassSetProvider() {
    }

    public final ImmutableMap<TemplateType, Class<? extends QuickPromotionFragment>> m26594a() {
        return ImmutableBiMap.b(TemplateType.FEED_PYMK, QuickPromotionFeedPYMKFragment.class);
    }
}
