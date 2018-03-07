package com.facebook.graphql.executor.cache;

import com.facebook.common.executors.C0055x2995691a;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: place_feed */
public class GraphQLCacheManager {
    private static volatile GraphQLCacheManager f9822f;
    public final GraphQLDiskCache f9823a;
    private final ListeningExecutorService f9824b;
    public final Object f9825c = new Object();
    @GuardedBy("mDeleteByTagsLock")
    public final Set<String> f9826d = new HashSet();
    @GuardedBy("mDeleteByTagsLock")
    public SettableFuture<Void> f9827e = null;

    public static com.facebook.graphql.executor.cache.GraphQLCacheManager m14847a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9822f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.graphql.executor.cache.GraphQLCacheManager.class;
        monitor-enter(r1);
        r0 = f9822f;	 Catch:{ all -> 0x003a }
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
        r0 = m14849b(r0);	 Catch:{ all -> 0x0035 }
        f9822f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9822f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.cache.GraphQLCacheManager.a(com.facebook.inject.InjectorLike):com.facebook.graphql.executor.cache.GraphQLCacheManager");
    }

    private static GraphQLCacheManager m14849b(InjectorLike injectorLike) {
        return new GraphQLCacheManager(GraphQLDiskCacheImpl.m10254a(injectorLike), C0055x2995691a.m1881a(injectorLike));
    }

    @Inject
    public GraphQLCacheManager(GraphQLDiskCache graphQLDiskCache, ListeningExecutorService listeningExecutorService) {
        this.f9823a = graphQLDiskCache;
        this.f9824b = listeningExecutorService;
    }

    public final ListenableFuture<Void> m14852a(Set<String> set) {
        ListenableFuture listenableFuture;
        Object obj = null;
        synchronized (this.f9825c) {
            if (this.f9827e == null) {
                obj = 1;
                this.f9827e = SettableFuture.m1547f();
            }
            listenableFuture = this.f9827e;
            this.f9826d.addAll(set);
        }
        if (obj != null) {
            ExecutorDetour.a(this.f9824b, new CacheDeleteRunner(this), 617745298);
        }
        return listenableFuture;
    }

    public final ListenableFuture<Void> m14851a(GraphQLRequest graphQLRequest) {
        return this.f9824b.mo270a(new 1(this, graphQLRequest), null);
    }

    public static void m14850b(GraphQLCacheManager graphQLCacheManager, Set set) {
        graphQLCacheManager.f9823a.mo1444a(set);
    }
}
