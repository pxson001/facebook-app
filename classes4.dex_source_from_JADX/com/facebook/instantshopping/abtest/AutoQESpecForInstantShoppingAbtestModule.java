package com.facebook.instantshopping.abtest;

import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecification;
import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecificationBuilder;
import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentSpecificationHolder;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.abtest.GeneratedInstantShoppingQEParams.Config;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: last_failure */
public class AutoQESpecForInstantShoppingAbtestModule implements QuickExperimentSpecificationHolder {
    private static final ImmutableSet<QuickExperimentSpecification> f9583a;
    private static volatile AutoQESpecForInstantShoppingAbtestModule f9584c;
    private final AutoQECacheForInstantShoppingAbtestModule f9585b;

    public static com.facebook.instantshopping.abtest.AutoQESpecForInstantShoppingAbtestModule m9969a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9584c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.instantshopping.abtest.AutoQESpecForInstantShoppingAbtestModule.class;
        monitor-enter(r1);
        r0 = f9584c;	 Catch:{ all -> 0x003a }
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
        r0 = m9970b(r0);	 Catch:{ all -> 0x0035 }
        f9584c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9584c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.instantshopping.abtest.AutoQESpecForInstantShoppingAbtestModule.a(com.facebook.inject.InjectorLike):com.facebook.instantshopping.abtest.AutoQESpecForInstantShoppingAbtestModule");
    }

    private static AutoQESpecForInstantShoppingAbtestModule m9970b(InjectorLike injectorLike) {
        return new AutoQESpecForInstantShoppingAbtestModule(AutoQECacheForInstantShoppingAbtestModule.m9977a(injectorLike));
    }

    static {
        QuickExperimentSpecificationBuilder newBuilder = QuickExperimentSpecification.newBuilder();
        newBuilder.f9571a = "instant_shopping_fb4a_qe_universe";
        newBuilder = newBuilder.m9953a(GeneratedInstantShoppingQEParams.class);
        newBuilder.f9573c = false;
        f9583a = ImmutableSet.of(newBuilder.m9952a());
    }

    @Inject
    public AutoQESpecForInstantShoppingAbtestModule(AutoQECacheForInstantShoppingAbtestModule autoQECacheForInstantShoppingAbtestModule) {
        this.f9585b = autoQECacheForInstantShoppingAbtestModule;
    }

    public final ImmutableSet<QuickExperimentSpecification> mo765a() {
        return f9583a;
    }

    public final Config m9972b() {
        return this.f9585b.m9980b();
    }
}
