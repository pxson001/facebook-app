package com.facebook.graphql.executor;

import com.facebook.graphql.executor.cache.ConsistencyCacheFactoryImpl;
import com.facebook.graphql.executor.cache.GraphQLDiskCache;
import com.facebook.graphql.executor.cache.GraphQLRequestDiskCache;
import com.facebook.graphql.executor.iface.ConsistencyCacheFactory;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: saver_info */
public class DefaultCacheProcessorFactory {
    private static volatile DefaultCacheProcessorFactory f6099d;
    private Lazy<GraphQLDiskCache> f6100a;
    private ConsistencyCacheFactoryImpl f6101b;
    private final QuickPerformanceLogger f6102c;

    public static com.facebook.graphql.executor.DefaultCacheProcessorFactory m10240a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6099d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.graphql.executor.DefaultCacheProcessorFactory.class;
        monitor-enter(r1);
        r0 = f6099d;	 Catch:{ all -> 0x003a }
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
        r0 = m10241b(r0);	 Catch:{ all -> 0x0035 }
        f6099d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6099d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.DefaultCacheProcessorFactory.a(com.facebook.inject.InjectorLike):com.facebook.graphql.executor.DefaultCacheProcessorFactory");
    }

    private static DefaultCacheProcessorFactory m10241b(InjectorLike injectorLike) {
        return new DefaultCacheProcessorFactory(IdBasedSingletonScopeProvider.m1810b(injectorLike, 2183), ConsistencyCacheFactoryImpl.m10244b(injectorLike), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike));
    }

    @Inject
    public DefaultCacheProcessorFactory(Lazy<GraphQLDiskCache> lazy, ConsistencyCacheFactory consistencyCacheFactory, QuickPerformanceLogger quickPerformanceLogger) {
        this.f6100a = lazy;
        this.f6101b = consistencyCacheFactory;
        this.f6102c = quickPerformanceLogger;
    }

    public final <T> DefaultCacheProcessor<T> m10242a(GraphQLRequest<T> graphQLRequest) {
        GraphQLRequestDiskCache graphQLRequestDiskCache = graphQLRequest.f7101t;
        if (graphQLRequestDiskCache == null) {
            graphQLRequestDiskCache = (GraphQLRequestDiskCache) this.f6100a.get();
        }
        return new DefaultCacheProcessor(graphQLRequest, graphQLRequestDiskCache, this.f6101b, this.f6102c);
    }
}
