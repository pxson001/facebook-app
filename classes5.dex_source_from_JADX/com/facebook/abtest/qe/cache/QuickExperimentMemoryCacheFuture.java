package com.facebook.abtest.qe.cache;

import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.LazyFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Future;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: total_possibility_count */
public class QuickExperimentMemoryCacheFuture extends ForwardingListenableFuture<QuickExperimentMemoryCache> {
    private static volatile QuickExperimentMemoryCacheFuture f1723b;
    private final Lazy<ListenableFuture<QuickExperimentMemoryCache>> f1724a;

    public static com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheFuture m2367a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1723b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheFuture.class;
        monitor-enter(r1);
        r0 = f1723b;	 Catch:{ all -> 0x003a }
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
        r0 = m2368b(r0);	 Catch:{ all -> 0x0035 }
        f1723b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1723b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheFuture.a(com.facebook.inject.InjectorLike):com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheFuture");
    }

    private static QuickExperimentMemoryCacheFuture m2368b(InjectorLike injectorLike) {
        return new QuickExperimentMemoryCacheFuture(IdBasedSingletonScopeProvider.b(injectorLike, 72));
    }

    protected final /* synthetic */ Future m2369a() {
        return m2370b();
    }

    protected final /* synthetic */ Object m2371e() {
        return m2370b();
    }

    @Inject
    public QuickExperimentMemoryCacheFuture(final Lazy<QuickExperimentMemoryCache> lazy) {
        this.f1724a = new LazyFuture<QuickExperimentMemoryCache>(this) {
            final /* synthetic */ QuickExperimentMemoryCacheFuture f1722b;

            protected final ListenableFuture<QuickExperimentMemoryCache> m2366a() {
                return ((QuickExperimentMemoryCache) lazy.get()).a();
            }
        };
    }

    protected final ListenableFuture<QuickExperimentMemoryCache> m2370b() {
        return (ListenableFuture) this.f1724a.get();
    }
}
