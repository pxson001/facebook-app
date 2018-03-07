package com.facebook.graphql.executor;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.feedcache.memory.FeedUnitCache;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.calls.GraphQlMutationCallInput;
import com.facebook.graphql.consistency.service.GraphQLConsistencyQueue;
import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLWriteLock;
import com.facebook.graphql.executor.cache.ConsistencyCacheFactoryImpl;
import com.facebook.graphql.executor.cache.ConsistentFieldWritingVisitor;
import com.facebook.graphql.executor.cache.GraphQLDiskCache;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.executor.iface.ConsistencyCacheFactory;
import com.facebook.graphql.executor.iface.ConsistencyMemoryCache;
import com.facebook.graphql.executor.iface.ConsistentMemoryCache;
import com.facebook.graphql.executor.iface.STATICDI_MULTIBIND_PROVIDER;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.query.ShimmedMutationRequestParams.ResultQuery;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunner$Batch;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.NeedsApplicationInjector;
import com.facebook.offlinemode.common.OfflineModeHelper;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.offlinemode.common.OfflineQueryBehavior.FakeResult;
import com.facebook.offlinemode.common.PendingRequest;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReadWriteLock;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: feed_set_notify_me */
public class MutationRunner {
    public final ListeningExecutorService f11853a;
    private final Lazy<GraphQLDiskCache> f11854b;
    private final AbstractSingleMethodRunner f11855c;
    private final GenericGraphQLMethod f11856d;
    private final OfflineMutationsManager f11857e;
    public final OfflineModeHelper f11858f;
    private final Set<ConsistentMemoryCache> f11859g;
    private final AnalyticsLogger f11860h;
    private final MonotonicClock f11861i;
    private final ApiMethodRunnerImpl f11862j;
    private final ShimmedMutationMethodProvider f11863k;
    private final FbObjectMapper f11864l;
    private final PureJsonGraphQLMethod f11865m;
    public final DefaultAndroidThreadUtil f11866n;
    private final AbstractFbErrorReporter f11867o;
    private final ViewerContextManager f11868p;
    private final ConsistencyCacheFactoryImpl f11869q;
    private final GraphQLConsistencyQueue f11870r;
    public final QuickPerformanceLogger f11871s;

    public static MutationRunner m12452b(InjectorLike injectorLike) {
        return new MutationRunner(ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2183), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), GenericGraphQLMethod.a(injectorLike), OfflineMutationsManager.m8657a(injectorLike), OfflineModeHelper.a(injectorLike), STATICDI_MULTIBIND_PROVIDER.ConsistentMemoryCache.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), ApiMethodRunnerImpl.a(injectorLike), (ShimmedMutationMethodProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ShimmedMutationMethodProvider.class), FbObjectMapperMethodAutoProvider.a(injectorLike), PureJsonGraphQLMethod.m12459a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ConsistencyCacheFactoryImpl.a(injectorLike), ViewerContextManagerProvider.a(injectorLike.getApplicationInjector()), GraphQLConsistencyQueue.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike));
    }

    private static boolean m12454b(MutationRunnerParams mutationRunnerParams) {
        return mutationRunnerParams.f11847c instanceof FakeResult;
    }

    private static <T> GraphQLResult<T> m12455c(MutationRunnerParams mutationRunnerParams) {
        OfflineQueryBehavior offlineQueryBehavior = mutationRunnerParams.f11847c;
        Preconditions.checkState(offlineQueryBehavior instanceof FakeResult);
        return (GraphQLResult) ((FakeResult) offlineQueryBehavior).f11816d;
    }

    @Inject
    public MutationRunner(ListeningExecutorService listeningExecutorService, Lazy<GraphQLDiskCache> lazy, SingleMethodRunner singleMethodRunner, GenericGraphQLMethod genericGraphQLMethod, OfflineMutationsManager offlineMutationsManager, OfflineModeHelper offlineModeHelper, Set<ConsistentMemoryCache> set, AnalyticsLogger analyticsLogger, MonotonicClock monotonicClock, ApiMethodRunner apiMethodRunner, ShimmedMutationMethodProvider shimmedMutationMethodProvider, FbObjectMapper fbObjectMapper, PureJsonGraphQLMethod pureJsonGraphQLMethod, AndroidThreadUtil androidThreadUtil, FbErrorReporter fbErrorReporter, ConsistencyCacheFactory consistencyCacheFactory, @NeedsApplicationInjector ViewerContextManager viewerContextManager, GraphQLConsistencyQueue graphQLConsistencyQueue, QuickPerformanceLogger quickPerformanceLogger) {
        this.f11853a = listeningExecutorService;
        this.f11854b = lazy;
        this.f11855c = singleMethodRunner;
        this.f11856d = genericGraphQLMethod;
        this.f11857e = offlineMutationsManager;
        this.f11858f = offlineModeHelper;
        this.f11859g = set;
        this.f11860h = analyticsLogger;
        this.f11861i = monotonicClock;
        this.f11862j = apiMethodRunner;
        this.f11863k = shimmedMutationMethodProvider;
        this.f11864l = fbObjectMapper;
        this.f11865m = pureJsonGraphQLMethod;
        this.f11866n = androidThreadUtil;
        this.f11867o = fbErrorReporter;
        this.f11869q = consistencyCacheFactory;
        this.f11868p = viewerContextManager;
        this.f11870r = graphQLConsistencyQueue;
        this.f11871s = quickPerformanceLogger;
    }

    public final <T> ListenableFuture<GraphQLResult<T>> m12457a(final MutationRunnerParams mutationRunnerParams) {
        final SettableFuture f = SettableFuture.f();
        ExecutorDetour.a(this.f11853a, new Runnable(this, null) {
            final /* synthetic */ MutationRunner f11875d;

            public void run() {
                this.f11875d.f11871s.a(3211305, mutationRunnerParams.f11851g, (short) 15);
                MutationRunner.m12453b(this.f11875d, mutationRunnerParams, f, null);
            }
        }, 748070217);
        return f;
    }

    private <T> void m12449a(MutationRunnerParams mutationRunnerParams, SettableFuture<GraphQLResult<T>> settableFuture, Exception exception) {
        if (exception instanceof CancellationException) {
            settableFuture.cancel(false);
            return;
        }
        OfflineQueryBehavior offlineQueryBehavior = mutationRunnerParams.f11847c;
        Object obj = (this.f11858f.a(exception, offlineQueryBehavior) && offlineQueryBehavior == OfflineQueryBehavior.f11814b) ? 1 : null;
        if (obj == null) {
            settableFuture.a(exception);
        }
    }

    public static <T> void m12453b(MutationRunner mutationRunner, MutationRunnerParams mutationRunnerParams, @Nullable SettableFuture settableFuture, String str) {
        int a = mutationRunner.f11870r.a();
        if (mutationRunnerParams.m12443d() != null) {
            mutationRunner.f11870r.a(a, mutationRunnerParams.m12443d().h());
        }
        try {
            mutationRunner.m12456c(mutationRunnerParams, settableFuture, str);
            if (mutationRunnerParams.m12443d() != null) {
                mutationRunner.f11870r.b(a, mutationRunnerParams.m12443d().h());
            }
        } catch (Exception e) {
            mutationRunner.m12449a(mutationRunnerParams, settableFuture, e);
            mutationRunner.f11870r.a(a);
        }
    }

    private <T> void m12456c(MutationRunnerParams mutationRunnerParams, SettableFuture<GraphQLResult<T>> settableFuture, @Nullable String str) {
        ViewerContext d;
        Throwable th;
        Throwable th2;
        short s;
        HoneyClientEvent a;
        GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent;
        PendingRequest a2 = mutationRunnerParams.m12440a();
        MutationRequest b = mutationRunnerParams.m12441b();
        OfflineQueryBehavior c = mutationRunnerParams.m12442c();
        GraphQLQueryAnalyticsEvent e = mutationRunnerParams.m12444e();
        GraphQLWriteLock d2 = mutationRunnerParams.m12443d();
        ReadWriteLock f = mutationRunnerParams.m12445f();
        LegacyMutation h = mutationRunnerParams.m12447h();
        Object obj = null;
        boolean z = (b == null && h == null) ? false : true;
        Preconditions.checkState(z, "A mutation or legacyMutation is required");
        if (f.readLock().tryLock()) {
            if (b != null) {
                d = b.m12414d();
            } else {
                d = null;
            }
            if (d != null) {
                this.f11868p.b(d);
            }
            int g = mutationRunnerParams.m12446g();
            try {
                GraphQLResult c2;
                e.a("dequeue");
                this.f11871s.a(3211305, g, (short) 157, "network_blocker_count", String.valueOf(d2.a(this.f11871s, 3211305, g)));
                z = (a2 == null || a2.m12429b()) ? false : true;
                if (h != null) {
                    c2 = h.c();
                } else if (b.f11808a.n()) {
                    this.f11871s.b(3211305, g, "shimmed");
                    c2 = m12448a(b, str, z);
                } else {
                    GraphQLRequest a3 = GraphQLRequest.a(b.f11808a, b.f11808a.c);
                    a3.b(z);
                    c2 = (GraphQLResult) this.f11855c.a(this.f11856d, a3, null, GraphQLRequest.a(a3.f, a3.n()));
                }
                e.a("network");
                this.f11871s.a(3211305, g, (short) 16);
                GraphQLVisitableModel graphQLVisitableModel = (GraphQLVisitableModel) c2.d();
                ConsistencyMemoryCache a4 = this.f11869q.a();
                CacheVisitor a5 = this.f11857e.m8665a(b, graphQLVisitableModel, a4);
                e.a("populate_consistency_memory_cache");
                this.f11871s.a(3211305, g, (short) 151);
                d2.a(a5);
                d2.a(true);
                this.f11871s.a(3211305, g, (short) 20);
                e.b("return_to_caller");
                FutureDetour.a(settableFuture, c2, -1976975029);
                try {
                    d2.c();
                    for (FeedUnitCache a6 : this.f11859g) {
                        a6.a(a5);
                    }
                    this.f11871s.a(3211305, g, (short) 17);
                    e.a("memory_cache_visit");
                    d2.d();
                    if (!(a5 instanceof ConsistentFieldWritingVisitor)) {
                        m12450a(a5);
                    }
                    this.f11871s.a(3211305, g, (short) 18);
                    e.a("disk_cache_visit");
                    if (!a4.mo875b()) {
                        a4.mo877c();
                    }
                    this.f11871s.a(3211305, g, (short) 19);
                    e.a("consistency_update");
                    this.f11871s.b(3211305, g, "local_db_write", "success");
                } catch (Throwable th3) {
                    this.f11867o.a("MutationRunner.updateDB", th3);
                    this.f11871s.b(3211305, g, "local_db_write", "error");
                }
                if (!(a2 == null || a2.m12429b())) {
                    this.f11871s.b(3211305, g, "offline_retry_success");
                    this.f11858f.c(a2);
                }
                d2.e();
                if (d != null) {
                    this.f11868p.f();
                }
                HoneyClientEvent a7 = e.a();
                if (a7 != null) {
                    this.f11860h.a(a7);
                }
                GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent2 = GraphQLQueryAnalyticsEventPool.a;
                f.readLock().unlock();
                this.f11871s.b(3211305, g, (short) 2);
                return;
            } catch (Throwable th32) {
                th2 = th32;
                if (a2 != null) {
                    if (this.f11858f.a(th2, c)) {
                        d2.a();
                        e.a("network_offline");
                        this.f11857e.m8666a(a2.m12433e(), d2);
                        if (m12454b(mutationRunnerParams)) {
                            FutureDetour.a(settableFuture, m12455c(mutationRunnerParams), -590708668);
                        }
                        throw th2;
                    }
                }
                d2.a(false);
                e.a(th2);
                Object obj2 = null;
                throw th2;
            } catch (Throwable th22) {
                obj = 1;
                th32 = th22;
                s = (short) 3;
                if (obj == null) {
                    d2.e();
                }
                if (d != null) {
                    this.f11868p.f();
                }
                a = e.a();
                if (a != null) {
                    this.f11860h.a(a);
                }
                graphQLQueryAnalyticsEvent = GraphQLQueryAnalyticsEventPool.a;
                f.readLock().unlock();
                this.f11871s.b(3211305, g, s);
                throw th32;
            }
        }
        throw new CancellationException("Unable to acquire run lock, runner is shut down");
    }

    private <T> GraphQLResult<T> m12448a(MutationRequest<T> mutationRequest, @Nullable String str, boolean z) {
        ApiMethodRunner$Batch a = this.f11862j.a();
        String str2 = "Mutation";
        Builder a2 = BatchOperation.m12541a(this.f11863k.m12458a(str, z), mutationRequest.f11808a);
        a2.f11927c = str2;
        a.mo888a(a2.m12548a(true).m12549a());
        ResultQuery[] a3 = mutationRequest.f11808a.b.a(mutationRequest.f11808a.a.e(), this.f11864l);
        for (ResultQuery resultQuery : a3) {
            TypedGraphQlQueryString b = resultQuery.b();
            Builder a4 = BatchOperation.m12541a(this.f11865m, GraphQLRequest.a(b, b.c));
            a4.f11927c = resultQuery.a();
            Builder builder = a4;
            builder.f11928d = str2;
            a.mo888a(builder.m12548a(true).m12549a());
        }
        a.mo889a("shimmedMutation", CallerContext.a(getClass()));
        ObjectNode c = this.f11864l.d().c();
        int length = a3.length;
        int i = 0;
        while (i < length) {
            String a5 = a3[i].a();
            Iterator H = ((JsonNode) a.mo887a(a5)).H();
            if (H.hasNext()) {
                boolean z2;
                c.c(a5, (JsonNode) ((Entry) H.next()).getValue());
                if (H.hasNext()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                Preconditions.checkArgument(z2, "Should not return multiple items");
                i++;
            } else {
                m12451a(mutationRequest, a, str2, a3);
                throw new ServiceException(OperationResult.a(ErrorCode.OTHER, "Batch response came back with an empty node."));
            }
        }
        return new GraphQLResult(this.f11864l.a(c, mutationRequest.f11808a.c), DataFreshnessResult.FROM_SERVER, this.f11861i.now());
    }

    private void m12451a(MutationRequest mutationRequest, ApiMethodRunner$Batch apiMethodRunner$Batch, String str, ResultQuery[] resultQueryArr) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = mutationRequest.f11808a.a.e().get("input");
        if (obj instanceof GraphQlMutationCallInput) {
            GraphQlMutationCallInput graphQlMutationCallInput = (GraphQlMutationCallInput) obj;
            stringBuilder.append("actor_id: ").append(graphQlMutationCallInput.m("actor_id")).append("\n");
            stringBuilder.append("client_mutation_id: ").append(graphQlMutationCallInput.m("client_mutation_id")).append("\n");
        }
        String str2 = (String) apiMethodRunner$Batch.mo887a(str);
        StringBuilder append = stringBuilder.append(str).append(": ");
        if (str2 == null) {
            str2 = "NULL";
        }
        append.append(str2).append("\n");
        for (ResultQuery resultQuery : resultQueryArr) {
            str2 = resultQuery.e;
            stringBuilder.append(str2).append(": ");
            Exception b = apiMethodRunner$Batch.mo890b(str2);
            if (b != null) {
                stringBuilder.append("EXCEPTION\n").append(b.toString());
            } else {
                JsonNode jsonNode = (JsonNode) apiMethodRunner$Batch.mo887a(str2);
                if (jsonNode != null) {
                    stringBuilder.append(jsonNode.toString());
                } else {
                    stringBuilder.append("NULL");
                }
            }
            stringBuilder.append("\n");
        }
        this.f11867o.a(SoftError.m4758a("MutationRunnerMalformedBatch", stringBuilder.toString()).m4765g());
    }

    private void m12450a(CacheVisitor cacheVisitor) {
        ((GraphQLDiskCache) this.f11854b.get()).a(cacheVisitor);
    }
}
