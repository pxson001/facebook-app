package com.facebook.instantshopping.abtest;

import com.facebook.abtest.qe.bootstrap.autoqe.AutoQECache;
import com.facebook.abtest.qe.bootstrap.framework.BaseQuickExperiment;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.abtest.qe.framework.QuickExperimentControllerImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.instantshopping.abtest.GeneratedInstantShoppingQEParams.Config;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: last_db_update_time */
public class AutoQECacheForInstantShoppingAbtestModule implements AutoQECache {
    private static volatile AutoQECacheForInstantShoppingAbtestModule f9587d;
    private final QuickExperimentController f9588a;
    private Lazy<GeneratedInstantShoppingQEParams> f9589b;
    private volatile Config f9590c;

    public static com.facebook.instantshopping.abtest.AutoQECacheForInstantShoppingAbtestModule m9977a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9587d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.instantshopping.abtest.AutoQECacheForInstantShoppingAbtestModule.class;
        monitor-enter(r1);
        r0 = f9587d;	 Catch:{ all -> 0x003a }
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
        r0 = m9978b(r0);	 Catch:{ all -> 0x0035 }
        f9587d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9587d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.instantshopping.abtest.AutoQECacheForInstantShoppingAbtestModule.a(com.facebook.inject.InjectorLike):com.facebook.instantshopping.abtest.AutoQECacheForInstantShoppingAbtestModule");
    }

    private static AutoQECacheForInstantShoppingAbtestModule m9978b(InjectorLike injectorLike) {
        return new AutoQECacheForInstantShoppingAbtestModule((QuickExperimentController) QuickExperimentControllerImpl.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2344));
    }

    @Inject
    public AutoQECacheForInstantShoppingAbtestModule(QuickExperimentController quickExperimentController, Lazy<GeneratedInstantShoppingQEParams> lazy) {
        this.f9588a = quickExperimentController;
        this.f9589b = lazy;
    }

    public final void mo766a() {
        this.f9590c = null;
    }

    public final Config m9980b() {
        if (this.f9590c == null) {
            synchronized (this) {
                if (this.f9590c == null) {
                    this.f9588a.b((BaseQuickExperiment) this.f9589b.get());
                    this.f9590c = (Config) this.f9588a.a((BaseQuickExperiment) this.f9589b.get());
                }
            }
        }
        return this.f9590c;
    }
}
