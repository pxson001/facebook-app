package com.facebook.quickpromotion.ui;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.quickpromotion.annotations.C0607x483689f;
import com.facebook.quickpromotion.annotations.QuickPromotionFragmentClassSetProvider;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.TemplateType;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: rating_tap */
public class QuickPromotionFragmentFactory {
    private static volatile QuickPromotionFragmentFactory f4812c;
    public final ImmutableMap<TemplateType, Class<? extends QuickPromotionFragment>> f4813a;
    private final AbstractFbErrorReporter f4814b;

    public static com.facebook.quickpromotion.ui.QuickPromotionFragmentFactory m4679a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4812c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.quickpromotion.ui.QuickPromotionFragmentFactory.class;
        monitor-enter(r1);
        r0 = f4812c;	 Catch:{ all -> 0x003a }
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
        r0 = m4680b(r0);	 Catch:{ all -> 0x0035 }
        f4812c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4812c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quickpromotion.ui.QuickPromotionFragmentFactory.a(com.facebook.inject.InjectorLike):com.facebook.quickpromotion.ui.QuickPromotionFragmentFactory");
    }

    private static QuickPromotionFragmentFactory m4680b(InjectorLike injectorLike) {
        return new QuickPromotionFragmentFactory(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new C0607x483689f(injectorLike)), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public QuickPromotionFragmentFactory(Set<QuickPromotionFragmentClassSetProvider> set, FbErrorReporter fbErrorReporter) {
        Builder builder = ImmutableMap.builder();
        for (QuickPromotionFragmentClassSetProvider a : set) {
            builder.a(a.mo224a());
        }
        this.f4813a = builder.b();
        this.f4814b = fbErrorReporter;
    }

    @Nullable
    public final QuickPromotionFragment m4681a(Intent intent) {
        Preconditions.checkNotNull(intent);
        TemplateType e = ((QuickPromotionDefinition) intent.getParcelableExtra("qp_definition")).e();
        if (e == TemplateType.UNKNOWN) {
            return null;
        }
        Class cls = (Class) this.f4813a.get(e);
        if (cls == null) {
            return null;
        }
        try {
            QuickPromotionFragment quickPromotionFragment = (QuickPromotionFragment) cls.newInstance();
            Bundle extras = intent.getExtras();
            extras.setClassLoader(cls.getClassLoader());
            quickPromotionFragment.g(extras);
            return quickPromotionFragment;
        } catch (Throwable e2) {
            this.f4814b.a(QuickPromotionFragmentFactory.class.getSimpleName() + "_instantiation", "Unable to create QP fragment", e2);
            return null;
        } catch (Throwable e22) {
            this.f4814b.a(QuickPromotionFragmentFactory.class.getSimpleName() + "_access", "Unable to create QP fragment", e22);
            return null;
        }
    }
}
