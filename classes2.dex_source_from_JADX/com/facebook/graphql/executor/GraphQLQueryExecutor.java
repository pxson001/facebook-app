package com.facebook.graphql.executor;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.executors.BackgroundWorkLogger;
import com.facebook.common.executors.BaseBackgroundWorkLogger;
import com.facebook.common.executors.C0275x5d33d28;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLWriteLock;
import com.facebook.graphql.executor.cache.GraphQLDiskCache;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.NeedsApplicationInjector;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.offlinemode.db.PendingGraphQlMutationRequest;
import com.facebook.offlinemode.db.PendingGraphQlMutationRequest.Builder;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: save_session */
public class GraphQLQueryExecutor {
    public static final GraphQLResult f6237a = new GraphQLResult(null, DataFreshnessResult.NO_DATA, 0);
    private static final Class<?> f6238b = GraphQLQueryExecutor.class;
    private static final Function<GraphQLResult, OperationResult> f6239c = new C02741();
    public static volatile ReadWriteLock f6240t = new ReentrantReadWriteLock();
    private static final AtomicInteger f6241u = new AtomicInteger(1);
    public static final AtomicInteger f6242v = new AtomicInteger(Integer.MIN_VALUE);
    private static GraphQLQueryExecutor f6243w;
    private static final Object f6244x = new Object();
    private final ListeningExecutorService f6245d;
    private final GraphQLQueryScheduler f6246e;
    private final Lazy<DefaultCacheProcessorFactory> f6247f;
    public final ViewerContextManager f6248g;
    public final ViewerContextManager f6249h;
    private final Lazy<MutationRunner> f6250i;
    private final MutationServiceManager f6251j;
    private final Lazy<CacheReadRunnerFactory> f6252k;
    private final Lazy<OfflineMutationsManager> f6253l;
    public final BackgroundWorkLogger f6254m;
    public final GraphQLBatchRunnerProvider f6255n;
    private final NetworkOnlyGraphQLBatchRunnerProvider f6256o;
    private final GraphQLCacheAggregator f6257p;
    private final Lazy<GraphQLDiskCache> f6258q;
    public final GraphQLQueryAnalyticsEventPool f6259r;
    public final QuickPerformanceLogger f6260s;

    /* compiled from: save_session */
    final class C02741 implements Function<GraphQLResult, OperationResult> {
        C02741() {
        }

        public final Object apply(@Nullable Object obj) {
            return OperationResult.m30115a((GraphQLResult) obj);
        }
    }

    /* compiled from: save_session */
    public interface CacheProcessor<T> {
        GraphQLResult<T> mo2681a();

        GraphQLResult<T> mo2682a(GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent);

        boolean mo2683a(GraphQLResult<T> graphQLResult);

        GraphQLResult<T> mo2684b(GraphQLResult<T> graphQLResult);
    }

    /* compiled from: save_session */
    public enum DataSource {
        MEMORY_CACHE,
        DB_CACHE,
        NETWORK
    }

    @java.lang.Deprecated
    @javax.annotation.Nullable
    private <T> com.facebook.graphql.executor.GraphQLResult<T> m10437a(com.facebook.graphql.executor.GraphQLRequest<T> r7, @javax.annotation.Nullable com.facebook.graphql.executor.GraphQLQueryExecutor.CacheProcessor<T> r8) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0047 in list [B:14:0x0042]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r6 = this;
        r0 = 0;
        if (r8 != 0) goto L_0x000b;
    L_0x0003:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "Must call GraphQLRequest.setCacheProcessor() for this to do anything";
        r0.<init>(r1);
        throw r0;
    L_0x000b:
        r3 = new com.facebook.graphql.executor.GraphQLQueryScheduler$GraphQLMainThreadLock;
        r1 = r6.f6246e;
        r1.getClass();
        r2 = new com.facebook.graphql.executor.GraphQLReadMutex;
        r4 = 0;
        r2.<init>(r4);
        r3.<init>(r1, r2);
        r3.mo3087a();
        r1 = r6.f6248g;
        r1 = r1.mo215b();
        r2 = r7.m11613k();
        if (r2 == 0) goto L_0x0077;
    L_0x002a:
        r1 = r7.m11613k();
        r2 = r1;
    L_0x002f:
        if (r2 == 0) goto L_0x0036;
    L_0x0031:
        r1 = r6.f6249h;
        r1.mo214b(r2);
    L_0x0036:
        r1 = r8.mo2681a();	 Catch:{ all -> 0x006e }
        r4 = f6237a;	 Catch:{ all -> 0x006e }
        if (r1 == r4) goto L_0x0040;
    L_0x003e:
        if (r1 != 0) goto L_0x0048;
    L_0x0040:
        if (r2 == 0) goto L_0x0047;
    L_0x0042:
        r1 = r6.f6249h;
        r1.mo219f();
    L_0x0047:
        return r0;
    L_0x0048:
        r4 = r3.f14132f;	 Catch:{  }
        r5 = r1.m10402f();	 Catch:{  }
        r4.mo2714a(r5);	 Catch:{  }
        r1 = r3.m20455c(r1);	 Catch:{  }
        r3 = r1.m10404a();	 Catch:{  }
        r4 = com.facebook.fbservice.results.DataFreshnessResult.FROM_CACHE_STALE;	 Catch:{  }
        if (r3 != r4) goto L_0x0065;
    L_0x005d:
        if (r2 == 0) goto L_0x0047;
    L_0x005f:
        r1 = r6.f6249h;
        r1.mo219f();
        goto L_0x0047;
    L_0x0065:
        if (r2 == 0) goto L_0x006c;
    L_0x0067:
        r0 = r6.f6249h;
        r0.mo219f();
    L_0x006c:
        r0 = r1;
        goto L_0x0047;
    L_0x006e:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0076;
    L_0x0071:
        r1 = r6.f6249h;
        r1.mo219f();
    L_0x0076:
        throw r0;
    L_0x0077:
        r2 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.GraphQLQueryExecutor.a(com.facebook.graphql.executor.GraphQLRequest, com.facebook.graphql.executor.GraphQLQueryExecutor$CacheProcessor):com.facebook.graphql.executor.GraphQLResult<T>");
    }

    @java.lang.Deprecated
    public final void m10455a(com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLWriteLock r3, @javax.annotation.Nullable com.facebook.graphql.executor.iface.ConsistencyMemoryCache r4) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0024 in list [B:10:0x001f]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r2 = this;
        r0 = r2.f6248g;
        r1 = r0.mo215b();
        if (r1 == 0) goto L_0x000d;
    L_0x0008:
        r0 = r2.f6249h;
        r0.mo214b(r1);
    L_0x000d:
        r0 = r2.f6257p;	 Catch:{ all -> 0x0025 }
        r0.m10383a(r3);	 Catch:{ all -> 0x0025 }
        if (r4 == 0) goto L_0x001d;	 Catch:{ all -> 0x0025 }
    L_0x0014:
        r0 = r4.b();	 Catch:{ all -> 0x0025 }
        if (r0 != 0) goto L_0x001d;	 Catch:{ all -> 0x0025 }
    L_0x001a:
        r4.c();	 Catch:{ all -> 0x0025 }
    L_0x001d:
        if (r1 == 0) goto L_0x0024;
    L_0x001f:
        r0 = r2.f6249h;
        r0.mo219f();
    L_0x0024:
        return;
    L_0x0025:
        r0 = move-exception;
        if (r1 == 0) goto L_0x002d;
    L_0x0028:
        r1 = r2.f6249h;
        r1.mo219f();
    L_0x002d:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.GraphQLQueryExecutor.a(com.facebook.graphql.executor.GraphQLQueryScheduler$GraphQLWriteLock, com.facebook.graphql.executor.iface.ConsistencyMemoryCache):void");
    }

    private static GraphQLQueryExecutor m10441b(InjectorLike injectorLike) {
        return new GraphQLQueryExecutor(C0275x5d33d28.m10458a(injectorLike), GraphQLQueryScheduler.m10388a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2183), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2159), ViewerContextManagerProvider.m2495a(injectorLike), ViewerContextManagerProvider.m2496b(injectorLike.getApplicationInjector()), IdBasedLazy.m1808a(injectorLike, 2158), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2173), BaseBackgroundWorkLogger.m1660a(injectorLike), IdBasedLazy.m1808a(injectorLike, 2171), MutationServiceManager.m10461a(injectorLike), (GraphQLBatchRunnerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GraphQLBatchRunnerProvider.class), GraphQLQueryAnalyticsEventPool.m10495a(injectorLike), (NetworkOnlyGraphQLBatchRunnerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(NetworkOnlyGraphQLBatchRunnerProvider.class), GraphQLCacheAggregator.m10379a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike));
    }

    public static GraphQLQueryExecutor m10435a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GraphQLQueryExecutor b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f6244x) {
                GraphQLQueryExecutor graphQLQueryExecutor;
                if (a2 != null) {
                    graphQLQueryExecutor = (GraphQLQueryExecutor) a2.mo818a(f6244x);
                } else {
                    graphQLQueryExecutor = f6243w;
                }
                if (graphQLQueryExecutor == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m10441b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f6244x, b3);
                        } else {
                            f6243w = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = graphQLQueryExecutor;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public GraphQLQueryExecutor(ListeningExecutorService listeningExecutorService, GraphQLQueryScheduler graphQLQueryScheduler, Lazy<GraphQLDiskCache> lazy, Lazy<DefaultCacheProcessorFactory> lazy2, ViewerContextManager viewerContextManager, @NeedsApplicationInjector ViewerContextManager viewerContextManager2, Lazy<CacheReadRunnerFactory> lazy3, Lazy<OfflineMutationsManager> lazy4, BackgroundWorkLogger backgroundWorkLogger, Lazy<MutationRunner> lazy5, MutationServiceManager mutationServiceManager, GraphQLBatchRunnerProvider graphQLBatchRunnerProvider, GraphQLQueryAnalyticsEventPool graphQLQueryAnalyticsEventPool, NetworkOnlyGraphQLBatchRunnerProvider networkOnlyGraphQLBatchRunnerProvider, GraphQLCacheAggregator graphQLCacheAggregator, QuickPerformanceLogger quickPerformanceLogger) {
        this.f6245d = listeningExecutorService;
        this.f6246e = graphQLQueryScheduler;
        this.f6258q = lazy;
        this.f6247f = lazy2;
        this.f6248g = viewerContextManager;
        this.f6249h = viewerContextManager2;
        this.f6252k = lazy3;
        this.f6253l = lazy4;
        this.f6254m = backgroundWorkLogger;
        this.f6250i = lazy5;
        this.f6251j = mutationServiceManager;
        this.f6255n = graphQLBatchRunnerProvider;
        this.f6259r = graphQLQueryAnalyticsEventPool;
        this.f6256o = networkOnlyGraphQLBatchRunnerProvider;
        this.f6257p = graphQLCacheAggregator;
        this.f6260s = quickPerformanceLogger;
    }

    public final void m10451a() {
        2 2 = new 2(this);
        2.start();
        try {
            2.join();
        } catch (InterruptedException e) {
        }
    }

    public final <T> GraphQLQueryFuture<GraphQLResult<T>> m10446a(GraphQLRequest<T> graphQLRequest) {
        return new GraphQLQueryFuture(m10443c((GraphQLRequest) graphQLRequest), graphQLRequest);
    }

    private <T> ListenableFuture<GraphQLResult<T>> m10443c(GraphQLRequest<T> graphQLRequest) {
        if (graphQLRequest.m11611i()) {
            throw new IllegalArgumentException("GraphQLQueryExecutor.start() cannot be used with mutations, use .mutate() instead");
        }
        TracerDetour.a("GraphQLQueryExecutor.startInner", -1678071225);
        try {
            CacheProcessor cacheProcessor = graphQLRequest.f7090h;
            if (cacheProcessor == null) {
                cacheProcessor = ((DefaultCacheProcessorFactory) this.f6247f.get()).m10242a((GraphQLRequest) graphQLRequest);
            }
            int incrementAndGet = f6241u.incrementAndGet();
            this.f6260s.mo478e(3211302, incrementAndGet);
            this.f6260s.mo465b(3211302, incrementAndGet, "query_name", graphQLRequest.m11605b().m11324c());
            this.f6260s.mo465b(3211302, incrementAndGet, "cache_policy", graphQLRequest.m11606c().f7114f);
            GraphQLQueryAnalyticsEvent a = this.f6259r.m10497a(graphQLRequest.m11605b().m11324c(), graphQLRequest.m11606c().f7114f, false, false);
            if (graphQLRequest.f7084b) {
                a.mo1469b();
                this.f6260s.mo464b(3211302, incrementAndGet, "consistency_enabled");
            }
            if (graphQLRequest.f7095m) {
                a.mo1472d();
                this.f6260s.mo464b(3211302, incrementAndGet, "subscription_rerun");
            }
            CacheReadRunner a2 = ((CacheReadRunnerFactory) this.f6252k.get()).m20298a(f6240t, graphQLRequest, cacheProcessor, a, incrementAndGet);
            final CancellationFuture cancellationFuture = new CancellationFuture();
            ListenableFuture a3 = m10438a(cancellationFuture, a2);
            Futures.m2458a(a3, new FutureCallback<GraphQLResult<T>>(this) {
                final /* synthetic */ GraphQLQueryExecutor f13997b;

                public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
                }

                public void onFailure(Throwable th) {
                    if (th instanceof CancellationException) {
                        cancellationFuture.f13992a.cancel(false);
                    }
                }
            }, MoreExecutors.m1813a());
            return a3;
        } finally {
            TracerDetour.a(1723068272);
        }
    }

    private <T> ListenableFuture<GraphQLResult<T>> m10438a(CancellationFuture cancellationFuture, CacheReadRunner<T> cacheReadRunner) {
        cancellationFuture.f13992a = this.f6245d.mo269a((Runnable) cacheReadRunner);
        return cacheReadRunner.f13981n;
    }

    private <T> void m10445c(MutationRequest<T> mutationRequest) {
        if (mutationRequest != null) {
            GraphQLProtocolHelper.m9431a(mutationRequest.a, "client_mutation_id", GraphQLProtocolHelper.f5534b);
            GraphQLProtocolHelper.m9431a(mutationRequest.a, "actor_id", new 4(this, mutationRequest));
        }
    }

    public final <T> ListenableFuture<GraphQLResult<T>> m10448a(MutationRequest<T> mutationRequest) {
        return m10449a((MutationRequest) mutationRequest, OfflineQueryBehavior.a);
    }

    public final <T> ListenableFuture<GraphQLResult<T>> m10457b(MutationRequest<T> mutationRequest) {
        return m10439a(new Builder().a(mutationRequest).b(), OfflineQueryBehavior.a, true);
    }

    public final <T> ListenableFuture<GraphQLResult<T>> m10449a(MutationRequest<T> mutationRequest, OfflineQueryBehavior offlineQueryBehavior) {
        return m10450a(new Builder().a(mutationRequest).b(), offlineQueryBehavior);
    }

    public final <T> ListenableFuture<GraphQLResult<T>> m10450a(PendingGraphQlMutationRequest pendingGraphQlMutationRequest, OfflineQueryBehavior offlineQueryBehavior) {
        return m10439a(pendingGraphQlMutationRequest, offlineQueryBehavior, false);
    }

    public final <T> ListenableFuture<GraphQLResult<T>> m10447a(LegacyMutation<T> legacyMutation) {
        int incrementAndGet = f6241u.incrementAndGet();
        this.f6260s.mo478e(3211305, incrementAndGet);
        this.f6260s.mo465b(3211305, incrementAndGet, "mutation_name", legacyMutation.a());
        this.f6260s.mo464b(3211305, incrementAndGet, "legacy");
        GraphQLWriteLock a = this.f6246e.m10395a(((OfflineMutationsManager) this.f6253l.get()).a(legacyMutation));
        GraphQLQueryAnalyticsEvent a2 = this.f6259r.m10497a(legacyMutation.a(), null, false, true);
        MutationRunnerParams mutationRunnerParams = new MutationRunnerParams(null, null, OfflineQueryBehavior.a, a, a2, f6240t, incrementAndGet, legacyMutation);
        a2.mo1468a(true);
        return this.f6251j.m10464a(mutationRunnerParams);
    }

    private <T> ListenableFuture<GraphQLResult<T>> m10439a(PendingGraphQlMutationRequest pendingGraphQlMutationRequest, OfflineQueryBehavior offlineQueryBehavior, boolean z) {
        try {
            MutationRequest d = pendingGraphQlMutationRequest.d();
            int incrementAndGet = f6241u.incrementAndGet();
            this.f6260s.mo478e(3211305, incrementAndGet);
            this.f6260s.mo465b(3211305, incrementAndGet, "mutation_name", d.a.m11324c());
            if (offlineQueryBehavior != OfflineQueryBehavior.a) {
                this.f6260s.mo464b(3211305, incrementAndGet, "offline_supported");
                this.f6260s.mo465b(3211305, incrementAndGet, "attempt_number", String.valueOf(pendingGraphQlMutationRequest.f));
            }
            m10445c(d);
            GraphQLWriteLock a = ((OfflineMutationsManager) this.f6253l.get()).a(pendingGraphQlMutationRequest);
            if (a == null) {
                a = this.f6246e.m10395a(((OfflineMutationsManager) this.f6253l.get()).a(d));
            }
            GraphQLQueryAnalyticsEvent a2 = this.f6259r.m10497a(d.a.m11324c(), null, false, true);
            MutationRunnerParams mutationRunnerParams = new MutationRunnerParams(pendingGraphQlMutationRequest, d, offlineQueryBehavior, a, a2, f6240t, incrementAndGet, null);
            if (d.d() == null && this.f6248g.mo215b() != null) {
                d.a(this.f6248g.mo215b());
            }
            if (z) {
                a2.mo1468a(true);
                this.f6260s.mo464b(3211305, incrementAndGet, "service_enabled");
                return this.f6251j.m10464a(mutationRunnerParams);
            }
            a2.mo1468a(false);
            return ((MutationRunner) this.f6250i.get()).a(mutationRunnerParams);
        } catch (Throwable e) {
            throw Throwables.propagate(e);
        }
    }

    public final void m10452a(GraphQLBatchRequest graphQLBatchRequest) {
        Executor executor = this.f6245d;
        int incrementAndGet = f6242v.incrementAndGet();
        this.f6260s.mo478e(3211303, incrementAndGet);
        if (this.f6260s.mo484j(3211303, incrementAndGet)) {
            this.f6260s.mo465b(3211303, incrementAndGet, "batch_name", graphQLBatchRequest.f6472c);
            this.f6260s.mo465b(3211303, incrementAndGet, "num_queries", String.valueOf(graphQLBatchRequest.f6471b.size()));
        }
        ExecutorDetour.a(executor, this.f6255n.m10493a(f6240t, graphQLBatchRequest, this.f6259r.m10497a(graphQLBatchRequest.f6472c, null, true, false), incrementAndGet), 181040304);
    }

    @Deprecated
    @Nullable
    public final <T> GraphQLResult<T> m10456b(GraphQLRequest<T> graphQLRequest) {
        return m10437a((GraphQLRequest) graphQLRequest, graphQLRequest.f7090h);
    }

    public final void m10453a(GraphQLBatchRequest graphQLBatchRequest, ExecutorService executorService) {
        ViewerContext b = this.f6248g.mo215b();
        GraphQLQueryAnalyticsEvent a = this.f6259r.m10497a(graphQLBatchRequest.f6472c, null, true, false);
        InjectorLike injectorLike = this.f6256o;
        NetworkOnlyGraphQLBatchRunner networkOnlyGraphQLBatchRunner = new NetworkOnlyGraphQLBatchRunner(graphQLBatchRequest, a, GenericGraphQLBatchMethod.m11701b(injectorLike), SingleMethodRunnerImpl.m11724a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
        if (executorService == null) {
            executorService = this.f6245d;
        }
        if (b != null) {
            ExecutorDetour.a(executorService, new 5(this, b, networkOnlyGraphQLBatchRunner), -528175254);
        } else {
            ExecutorDetour.a(executorService, networkOnlyGraphQLBatchRunner, 1153512994);
        }
    }

    @Deprecated
    public final void m10454a(GraphQLWriteLock graphQLWriteLock) {
        m10455a(graphQLWriteLock, null);
    }

    public static <T> ListenableFuture<T> m10440a(ListenableFuture<GraphQLResult<T>> listenableFuture) {
        return Futures.m2449a((ListenableFuture) listenableFuture, new 6());
    }

    public static <T, R> ListenableFuture<List<T>> m10442b(ListenableFuture<GraphQLResult<R>> listenableFuture) {
        return Futures.m2449a((ListenableFuture) listenableFuture, new 8());
    }

    public static <T extends GraphQLPersistableNode, R> ListenableFuture<Map<String, T>> m10444c(ListenableFuture<GraphQLResult<R>> listenableFuture) {
        return Futures.m2449a((ListenableFuture) listenableFuture, new 9());
    }

    public static <T> GraphQLQueryFuture<OperationResult> m10436a(GraphQLQueryFuture<GraphQLResult<T>> graphQLQueryFuture) {
        if (graphQLQueryFuture == null) {
            return null;
        }
        Function function = f6239c;
        Preconditions.checkNotNull(function);
        return new GraphQLQueryFuture(Futures.m2449a(graphQLQueryFuture.f13998a, function), graphQLQueryFuture.f13999b);
    }
}
