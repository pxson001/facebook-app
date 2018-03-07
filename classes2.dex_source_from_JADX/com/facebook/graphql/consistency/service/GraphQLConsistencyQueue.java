package com.facebook.graphql.consistency.service;

import android.util.SparseArray;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.C0061x63d21d68;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.executor.iface.CacheVisitorAnalytics;
import com.facebook.graphql.executor.iface.GraphQLOptimisticConsistentCache;
import com.facebook.graphql.executor.iface.STATICDI_MULTIBIND_PROVIDER$GraphQLOptimisticConsistentCache;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: network_info_signal_level */
public class GraphQLConsistencyQueue implements IHaveUserData {
    private static volatile GraphQLConsistencyQueue f12475h;
    private final AtomicInteger f12476a = new AtomicInteger(1);
    public final SparseArray<CacheVisitor> f12477b = new SparseArray();
    public final DefaultAndroidThreadUtil f12478c;
    private final ExecutorService f12479d;
    private final GatekeeperStoreImpl f12480e;
    public final QuickPerformanceLogger f12481f;
    public final Set<GraphQLOptimisticConsistentCache> f12482g;

    public static com.facebook.graphql.consistency.service.GraphQLConsistencyQueue m18548a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12475h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.graphql.consistency.service.GraphQLConsistencyQueue.class;
        monitor-enter(r1);
        r0 = f12475h;	 Catch:{ all -> 0x003a }
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
        r0 = m18550b(r0);	 Catch:{ all -> 0x0035 }
        f12475h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12475h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.consistency.service.GraphQLConsistencyQueue.a(com.facebook.inject.InjectorLike):com.facebook.graphql.consistency.service.GraphQLConsistencyQueue");
    }

    private static GraphQLConsistencyQueue m18550b(InjectorLike injectorLike) {
        return new GraphQLConsistencyQueue(DefaultAndroidThreadUtil.m1646b(injectorLike), C0061x63d21d68.m2106b(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$GraphQLOptimisticConsistentCache(injectorLike)));
    }

    public static String m18551b(CacheVisitor cacheVisitor) {
        return cacheVisitor instanceof CacheVisitorAnalytics ? ((CacheVisitorAnalytics) cacheVisitor).b() : cacheVisitor.getClass().getName();
    }

    public static void m18549a(GraphQLConsistencyQueue graphQLConsistencyQueue, int i, int i2, Collection collection) {
        graphQLConsistencyQueue.f12481f.mo465b(i, i2, "queue_size", String.valueOf(graphQLConsistencyQueue.f12476a.get() - i2));
        graphQLConsistencyQueue.f12481f.mo465b(i, i2, "optimistic_visitor_count", String.valueOf(graphQLConsistencyQueue.f12477b.size()));
        graphQLConsistencyQueue.f12481f.mo465b(i, i2, "tags_to_visit_count", String.valueOf(collection.size()));
    }

    @Inject
    public GraphQLConsistencyQueue(AndroidThreadUtil androidThreadUtil, ExecutorService executorService, GatekeeperStore gatekeeperStore, QuickPerformanceLogger quickPerformanceLogger, Set<GraphQLOptimisticConsistentCache> set) {
        this.f12478c = androidThreadUtil;
        this.f12479d = executorService;
        this.f12480e = gatekeeperStore;
        this.f12481f = quickPerformanceLogger;
        this.f12482g = set;
    }

    public final int m18553a() {
        return this.f12476a.incrementAndGet();
    }

    public final void m18555a(int i, CacheVisitor cacheVisitor) {
        if (m18552b() && cacheVisitor != null && cacheVisitor.a() != null && !cacheVisitor.a().isEmpty()) {
            this.f12481f.mo478e(9764865, i);
            synchronized (this.f12477b) {
                this.f12477b.put(i, cacheVisitor);
            }
            ExecutorDetour.a(this.f12479d, new OptimisticRunnable(this, i), -1579935211);
        }
    }

    public final void m18556b(int i, CacheVisitor cacheVisitor) {
        if (m18552b() && cacheVisitor != null && !cacheVisitor.a().isEmpty()) {
            this.f12481f.mo478e(9764866, i);
            ExecutorDetour.a(this.f12479d, new ConfirmedRunnable(this, i, cacheVisitor), 1655589208);
        }
    }

    public final void m18554a(int i) {
        if (m18552b()) {
            Collection collection = null;
            synchronized (this.f12477b) {
                if (this.f12477b.get(i) != null) {
                    collection = ((CacheVisitor) this.f12477b.get(i)).a();
                }
                this.f12477b.remove(i);
            }
            if (collection != null) {
                ExecutorDetour.a(this.f12479d, new CancelRunnable(this, i, collection), -2105329627);
            }
        }
    }

    public void clearUserData() {
        synchronized (this.f12477b) {
            this.f12477b.clear();
        }
        this.f12479d.shutdownNow();
        this.f12481f.mo477e(9764865);
        this.f12481f.mo477e(9764866);
    }

    private boolean m18552b() {
        return this.f12480e.m2189a(90, false);
    }
}
