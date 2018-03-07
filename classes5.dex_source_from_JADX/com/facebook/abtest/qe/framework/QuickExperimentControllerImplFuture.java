package com.facebook.abtest.qe.framework;

import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentControllerFuture;
import com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheFuture;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.LazyFutures;
import com.google.common.base.Function;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Future;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: total_device_power */
public class QuickExperimentControllerImplFuture extends ForwardingListenableFuture<QuickExperimentController> implements QuickExperimentControllerFuture {
    private static volatile QuickExperimentControllerImplFuture f1731b;
    private final Lazy<ListenableFuture<QuickExperimentController>> f1732a;

    public static com.facebook.abtest.qe.framework.QuickExperimentControllerImplFuture m2376a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1731b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.abtest.qe.framework.QuickExperimentControllerImplFuture.class;
        monitor-enter(r1);
        r0 = f1731b;	 Catch:{ all -> 0x003a }
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
        r0 = m2377b(r0);	 Catch:{ all -> 0x0035 }
        f1731b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1731b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.abtest.qe.framework.QuickExperimentControllerImplFuture.a(com.facebook.inject.InjectorLike):com.facebook.abtest.qe.framework.QuickExperimentControllerImplFuture");
    }

    private static QuickExperimentControllerImplFuture m2377b(InjectorLike injectorLike) {
        return new QuickExperimentControllerImplFuture(IdBasedSingletonScopeProvider.b(injectorLike, 4561), IdBasedSingletonScopeProvider.b(injectorLike, 83));
    }

    protected final /* synthetic */ Future m2378a() {
        return m2379b();
    }

    protected final /* synthetic */ Object m2380e() {
        return m2379b();
    }

    @Inject
    public QuickExperimentControllerImplFuture(Lazy<QuickExperimentMemoryCacheFuture> lazy, final Lazy<QuickExperimentController> lazy2) {
        this.f1732a = LazyFutures.a(lazy, new Function<QuickExperimentMemoryCache, QuickExperimentController>(this) {
            final /* synthetic */ QuickExperimentControllerImplFuture f1730b;

            @Nullable
            public Object apply(@Nullable Object obj) {
                return (QuickExperimentController) lazy2.get();
            }
        }, MoreExecutors.a());
    }

    protected final ListenableFuture<QuickExperimentController> m2379b() {
        return (ListenableFuture) this.f1732a.get();
    }
}
