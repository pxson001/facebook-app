package com.facebook.abtest.qe.cache;

import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache.QuickExperimentMemoryCacheObserver;
import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentCacheUpdateListener;
import com.facebook.abtest.qe.bootstrap.registry.STATICDI_MULTIBIND_PROVIDER$QuickExperimentCacheUpdateListener;
import com.facebook.common.init.INeedInit;
import com.facebook.inject.InjectorLike;
import com.facebook.placetips.pulsarcore.PulsarFeatureController;
import com.google.common.collect.MapMaker;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: updateMemoryUsage throws */
public class QuickExperimentMemoryCacheObserverManager implements INeedInit {
    private static volatile QuickExperimentMemoryCacheObserverManager f1821e;
    @GuardedBy("this")
    private final Map<QuickExperimentMemoryCacheObserver, Boolean> f1822a = new MapMaker().m1485e().m1489l();
    @GuardedBy("this")
    private final Provider<Set<QuickExperimentCacheUpdateListener>> f1823b;
    @GuardedBy("this")
    private boolean f1824c = false;
    @GuardedBy("this")
    private boolean f1825d = false;

    public static com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheObserverManager m3652a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1821e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheObserverManager.class;
        monitor-enter(r1);
        r0 = f1821e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m3653b(r0);	 Catch:{ all -> 0x0035 }
        f1821e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1821e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheObserverManager.a(com.facebook.inject.InjectorLike):com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheObserverManager");
    }

    private static QuickExperimentMemoryCacheObserverManager m3653b(InjectorLike injectorLike) {
        return new QuickExperimentMemoryCacheObserverManager(new STATICDI_MULTIBIND_PROVIDER$QuickExperimentCacheUpdateListener(injectorLike.getScopeAwareInjector()));
    }

    @Inject
    public QuickExperimentMemoryCacheObserverManager(Provider<Set<QuickExperimentCacheUpdateListener>> provider) {
        this.f1823b = provider;
    }

    @Deprecated
    final synchronized void m3655a(QuickExperimentMemoryCacheObserver quickExperimentMemoryCacheObserver) {
        this.f1822a.put(quickExperimentMemoryCacheObserver, Boolean.valueOf(true));
        if (this.f1824c && this.f1825d) {
            quickExperimentMemoryCacheObserver.mo634b();
        }
    }

    final synchronized void m3654a() {
        this.f1825d = true;
        if (this.f1824c) {
            for (QuickExperimentMemoryCacheObserver b : this.f1822a.keySet()) {
                b.mo634b();
            }
            for (PulsarFeatureController a : (Set) this.f1823b.get()) {
                a.a();
            }
        }
    }

    public final synchronized void m3656b() {
        for (QuickExperimentMemoryCacheObserver c : this.f1822a.keySet()) {
            c.mo635c();
        }
        for (PulsarFeatureController b : (Set) this.f1823b.get()) {
            b.b();
        }
    }

    public synchronized void init() {
        this.f1824c = true;
        if (this.f1825d) {
            m3654a();
        }
    }
}
