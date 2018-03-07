package com.facebook.feed.data;

import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.controller.mutation.util.FeedStoryCacheAdapter;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryExecutor.DataSource;
import com.facebook.graphql.executor.GraphQLQueryScheduler;
import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLWriteLock;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: platform_authorize_app */
public class AggregatedSubstoriesFetcher {
    private static volatile AggregatedSubstoriesFetcher f9726h;
    public FbNetworkManager f9727a;
    public final FeedStoryCacheAdapter f9728b;
    public final FeedStoryMutator f9729c;
    public final GraphQLQueryExecutor f9730d;
    private final GraphQLQueryScheduler f9731e;
    public TasksManager f9732f;
    public Executor f9733g;

    public static com.facebook.feed.data.AggregatedSubstoriesFetcher m14738a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9726h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.data.AggregatedSubstoriesFetcher.class;
        monitor-enter(r1);
        r0 = f9726h;	 Catch:{ all -> 0x003a }
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
        r0 = m14740b(r0);	 Catch:{ all -> 0x0035 }
        f9726h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9726h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.data.AggregatedSubstoriesFetcher.a(com.facebook.inject.InjectorLike):com.facebook.feed.data.AggregatedSubstoriesFetcher");
    }

    private static AggregatedSubstoriesFetcher m14740b(InjectorLike injectorLike) {
        return new AggregatedSubstoriesFetcher(FbNetworkManager.m3811a(injectorLike), FeedStoryCacheAdapter.m14594b(injectorLike), FeedStoryMutator.m10586b(injectorLike), GraphQLQueryExecutor.m10435a(injectorLike), GraphQLQueryScheduler.m10388a(injectorLike), TasksManager.m14550b(injectorLike), C0055x2995691a.m1881a(injectorLike));
    }

    @Inject
    public AggregatedSubstoriesFetcher(FbNetworkManager fbNetworkManager, FeedStoryCacheAdapter feedStoryCacheAdapter, FeedStoryMutator feedStoryMutator, GraphQLQueryExecutor graphQLQueryExecutor, GraphQLQueryScheduler graphQLQueryScheduler, TasksManager tasksManager, ExecutorService executorService) {
        this.f9727a = fbNetworkManager;
        this.f9728b = feedStoryCacheAdapter;
        this.f9729c = feedStoryMutator;
        this.f9730d = graphQLQueryExecutor;
        this.f9731e = graphQLQueryScheduler;
        this.f9732f = tasksManager;
        this.f9733g = executorService;
    }

    public static void m14739a(AggregatedSubstoriesFetcher aggregatedSubstoriesFetcher, CacheVisitor cacheVisitor) {
        GraphQLWriteLock a = aggregatedSubstoriesFetcher.f9731e.m10395a(cacheVisitor);
        try {
            a.mo3496a(DataSource.NETWORK);
            a.m32020a(true);
            aggregatedSubstoriesFetcher.f9730d.m10454a(a);
        } catch (Exception e) {
        } finally {
            a.m20458e();
        }
    }
}
