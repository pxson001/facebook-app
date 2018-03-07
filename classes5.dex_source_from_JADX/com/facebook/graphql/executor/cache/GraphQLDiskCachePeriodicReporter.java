package com.facebook.graphql.executor.cache;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.IAnalyticsPeriodicEventReporter;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: legacyApiPostId */
public class GraphQLDiskCachePeriodicReporter implements IAnalyticsPeriodicEventReporter {
    private static volatile GraphQLDiskCachePeriodicReporter f3247c;
    private final Provider<GraphQLDiskCacheDatabaseSupplier> f3248a;
    private final Provider<GraphQLDiskCacheQueryFormatter> f3249b;

    public static com.facebook.graphql.executor.cache.GraphQLDiskCachePeriodicReporter m6309a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3247c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.graphql.executor.cache.GraphQLDiskCachePeriodicReporter.class;
        monitor-enter(r1);
        r0 = f3247c;	 Catch:{ all -> 0x003a }
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
        r0 = m6310b(r0);	 Catch:{ all -> 0x0035 }
        f3247c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3247c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.cache.GraphQLDiskCachePeriodicReporter.a(com.facebook.inject.InjectorLike):com.facebook.graphql.executor.cache.GraphQLDiskCachePeriodicReporter");
    }

    private static GraphQLDiskCachePeriodicReporter m6310b(InjectorLike injectorLike) {
        return new GraphQLDiskCachePeriodicReporter(IdBasedSingletonScopeProvider.a(injectorLike, 2182), IdBasedSingletonScopeProvider.a(injectorLike, 2184));
    }

    @Inject
    public GraphQLDiskCachePeriodicReporter(Provider<GraphQLDiskCacheDatabaseSupplier> provider, Provider<GraphQLDiskCacheQueryFormatter> provider2) {
        this.f3248a = provider;
        this.f3249b = provider2;
    }

    public final HoneyAnalyticsEvent m6311a(long j, String str) {
        this.f3249b.get();
        String b = GraphQLDiskCacheQueryFormatter.b();
        this.f3249b.get();
        return DiskCacheEntriesLogEventFactory.m6300a(((GraphQLDiskCacheDatabaseSupplier) this.f3248a.get()).a(), "fb4a_graphql_disk_cache_snapshot_table", "snapshot_analytics", b, GraphQLDiskCacheQueryFormatter.a(j));
    }
}
