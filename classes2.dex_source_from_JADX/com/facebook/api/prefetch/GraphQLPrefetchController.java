package com.facebook.api.prefetch;

import android.content.Context;
import com.facebook.analytics.PrefetchAnalytics;
import com.facebook.analytics.PrefetchAnalyticsProvider;
import com.facebook.annotationprocessors.transformer.api.Clone;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.C0336x1fe4bb6b;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLResult.Builder;
import com.facebook.graphql.executor.cache.GraphQLDiskCache;
import com.facebook.graphql.executor.cache.GraphQLDiskCacheImpl;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: postNewAttributionId */
public final class GraphQLPrefetchController {
    public static final String f9410a = GraphQLPrefetchController.class.getSimpleName();
    private static final CallerContext f9411b = CallerContext.m9060a(GraphQLPrefetchController.class);
    private static GraphQLPrefetchController f9412r;
    private static final Object f9413s = new Object();
    private final GraphQLQueryExecutor f9414c;
    private final ScheduledExecutorService f9415d;
    private final GraphQLDiskCache f9416e;
    public final ConcurrentMap<GraphQLPrefetchPolicy, ConcurrentSkipListSet<String>> f9417f = new MapMaker().m1483c(2).m1476a(8).m1489l();
    public final ConcurrentLinkedQueue<FeedbackItemPair> f9418g = new ConcurrentLinkedQueue();
    private final InFlightRequestsMap f9419h = new InFlightRequestsMap();
    private final InFlightRequestsMap f9420i = new InFlightRequestsMap();
    private final ConcurrentMap<GraphQLPrefetchPolicy, PrefetchAnalytics> f9421j = new MapMaker().m1483c(2).m1476a(8).m1489l();
    private final PrefetchAnalyticsProvider f9422k;
    private final FbDataConnectionManager f9423l;
    private final Runnable f9424m = new C04081(this);
    private ScheduledFuture f9425n = null;
    private final Lazy<PerfTestConfig> f9426o;
    private final GatekeeperStoreImpl f9427p;
    private final QeAccessor f9428q;

    /* compiled from: postNewAttributionId */
    class C04081 implements Runnable {
        final /* synthetic */ GraphQLPrefetchController f9430a;

        C04081(GraphQLPrefetchController graphQLPrefetchController) {
            this.f9430a = graphQLPrefetchController;
        }

        public void run() {
            for (Entry entry : this.f9430a.f9417f.entrySet()) {
                while (!((ConcurrentSkipListSet) entry.getValue()).isEmpty()) {
                    GraphQLPrefetchController.m14402c(this.f9430a, (GraphQLPrefetchPolicy) entry.getKey());
                }
            }
            while (true) {
                FeedbackItemPair feedbackItemPair = (FeedbackItemPair) this.f9430a.f9418g.poll();
                if (feedbackItemPair != null) {
                    GraphQLPrefetchController.m14390a(this.f9430a, feedbackItemPair.f21629a, feedbackItemPair.f21630b, feedbackItemPair.f21631c);
                } else {
                    return;
                }
            }
        }
    }

    /* compiled from: postNewAttributionId */
    public class FeedbackItemPair {
        public final GraphQLFeedback f21629a;
        public final GraphQLPrefetchPolicy<?> f21630b;
        @Clone(from = "action", processor = "com.facebook.thecount.transformer.Transformer")
        public Integer f21631c;

        @Clone(from = "<init>", processor = "com.facebook.thecount.transformer.Transformer")
        public FeedbackItemPair(GraphQLFeedback graphQLFeedback, GraphQLPrefetchPolicy<?> graphQLPrefetchPolicy, Integer num) {
            this.f21629a = graphQLFeedback;
            this.f21630b = graphQLPrefetchPolicy;
            this.f21631c = num;
        }
    }

    private static GraphQLPrefetchController m14394b(InjectorLike injectorLike) {
        return new GraphQLPrefetchController(GraphQLQueryExecutor.m10435a(injectorLike), C0336x1fe4bb6b.m12496a(injectorLike), (PrefetchAnalyticsProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PrefetchAnalyticsProvider.class), GraphQLDiskCacheImpl.m10254a(injectorLike), FbDataConnectionManager.m3787a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 593), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public static GraphQLPrefetchController m14385a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GraphQLPrefetchController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f9413s) {
                GraphQLPrefetchController graphQLPrefetchController;
                if (a2 != null) {
                    graphQLPrefetchController = (GraphQLPrefetchController) a2.mo818a(f9413s);
                } else {
                    graphQLPrefetchController = f9412r;
                }
                if (graphQLPrefetchController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m14394b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f9413s, b3);
                        } else {
                            f9412r = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = graphQLPrefetchController;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    GraphQLPrefetchController(GraphQLQueryExecutor graphQLQueryExecutor, ScheduledExecutorService scheduledExecutorService, PrefetchAnalyticsProvider prefetchAnalyticsProvider, GraphQLDiskCache graphQLDiskCache, FbDataConnectionManager fbDataConnectionManager, Lazy<PerfTestConfig> lazy, GatekeeperStore gatekeeperStore, QeAccessor qeAccessor) {
        this.f9414c = graphQLQueryExecutor;
        this.f9415d = scheduledExecutorService;
        this.f9422k = prefetchAnalyticsProvider;
        this.f9416e = graphQLDiskCache;
        this.f9423l = fbDataConnectionManager;
        this.f9426o = lazy;
        this.f9427p = gatekeeperStore;
        this.f9428q = qeAccessor;
    }

    final void m14406a(GraphQLPrefetchPolicy graphQLPrefetchPolicy, GraphQLPrefetchPriority graphQLPrefetchPriority, String str) {
        m14399b(graphQLPrefetchPolicy, str);
        if (null != null) {
            m14405a(graphQLPrefetchPolicy).m29417e(str);
        }
        if (graphQLPrefetchPriority == GraphQLPrefetchPriority.UNKNOWN) {
            m14405a(graphQLPrefetchPolicy).m29412a(str, "unknown_priority");
        } else if ((graphQLPrefetchPolicy.mo1931e() || this.f9423l.m3801c() != ConnectionQuality.EXCELLENT) && graphQLPrefetchPolicy.mo1925a(graphQLPrefetchPriority) && !m14405a(graphQLPrefetchPolicy).m29416d(str)) {
            ConcurrentSkipListSet concurrentSkipListSet = (ConcurrentSkipListSet) this.f9417f.get(graphQLPrefetchPolicy);
            if (concurrentSkipListSet == null) {
                ConcurrentSkipListSet concurrentSkipListSet2 = new ConcurrentSkipListSet();
                concurrentSkipListSet = (ConcurrentSkipListSet) this.f9417f.putIfAbsent(graphQLPrefetchPolicy, concurrentSkipListSet2);
                if (concurrentSkipListSet == null) {
                    concurrentSkipListSet = concurrentSkipListSet2;
                }
            }
            concurrentSkipListSet.add(str);
            m14397b();
        }
    }

    private void m14397b() {
        if (this.f9425n == null || this.f9425n.getDelay(TimeUnit.MILLISECONDS) <= 0) {
            this.f9425n = this.f9415d.schedule(this.f9424m, 1000, TimeUnit.MILLISECONDS);
        }
    }

    final <T> void m14409a(GraphQLPrefetchPolicy<T> graphQLPrefetchPolicy, String str, FutureCallback<GraphQLPrefetchResult<T>> futureCallback, FutureCallback<GraphQLPrefetchResult<T>> futureCallback2, CallerContext callerContext, Executor executor) {
        Object obj;
        boolean z;
        Executor executor2 = executor == null ? this.f9415d : executor;
        m14399b((GraphQLPrefetchPolicy) graphQLPrefetchPolicy, str);
        if (this.f9428q.mo596a(ExperimentsForFeedbackTestModule.f6799C, false) && this.f9428q.mo596a(ExperimentsForFeedbackTestModule.f6800D, false)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null && graphQLPrefetchPolicy.mo1930d()) {
            m14403c(graphQLPrefetchPolicy, str, futureCallback2, callerContext, executor2);
        }
        GraphQLQueryFuture a = this.f9414c.m10446a(m14401c(graphQLPrefetchPolicy, str, GraphQLCachePolicy.f7110b, callerContext));
        if (obj == null && graphQLPrefetchPolicy.mo1930d()) {
            m14403c(graphQLPrefetchPolicy, str, futureCallback2, callerContext, executor2);
        }
        if (graphQLPrefetchPolicy.mo1930d()) {
            z = false;
        } else {
            z = true;
        }
        m14392a(executor, (ListenableFuture) a, m14387a(graphQLPrefetchPolicy, str, futureCallback, z, futureCallback2, callerContext, executor2, executor, false));
    }

    final <T> void m14408a(GraphQLPrefetchPolicy<T> graphQLPrefetchPolicy, String str, FutureCallback<GraphQLPrefetchResult<T>> futureCallback, CallerContext callerContext, Executor executor) {
        m14399b((GraphQLPrefetchPolicy) graphQLPrefetchPolicy, str);
        Executor executor2 = executor;
        m14392a(executor2, this.f9414c.m10446a(m14401c(graphQLPrefetchPolicy, str, GraphQLCachePolicy.f7110b, callerContext)), m14387a(graphQLPrefetchPolicy, str, futureCallback, false, null, callerContext, null, executor, false));
    }

    private <T> FutureCallback<GraphQLResult<T>> m14387a(GraphQLPrefetchPolicy<T> graphQLPrefetchPolicy, String str, FutureCallback<GraphQLPrefetchResult<T>> futureCallback, boolean z, FutureCallback<GraphQLPrefetchResult<T>> futureCallback2, CallerContext callerContext, Executor executor, Executor executor2, boolean z2) {
        return new 2(this, graphQLPrefetchPolicy, z2, str, futureCallback, callerContext, executor2, z, futureCallback2, executor);
    }

    private <T> boolean m14400b(GraphQLPrefetchPolicy<T> graphQLPrefetchPolicy, String str, FutureCallback<GraphQLPrefetchResult<T>> futureCallback, CallerContext callerContext, Executor executor) {
        GraphQLRequest a = m14386a((GraphQLPrefetchPolicy) graphQLPrefetchPolicy, str, GraphQLCachePolicy.f7110b, callerContext);
        if (a == null) {
            return false;
        }
        m14392a(executor, this.f9414c.m10446a(a), m14387a(graphQLPrefetchPolicy, str, futureCallback, false, null, callerContext, null, executor, true));
        return true;
    }

    private <T> void m14392a(Executor executor, ListenableFuture<GraphQLResult<T>> listenableFuture, FutureCallback<GraphQLResult<T>> futureCallback) {
        if (listenableFuture.isDone()) {
            this.f9426o.get();
            if (!PerfTestConfigBase.f1521p) {
                if (!listenableFuture.isCancelled()) {
                    futureCallback.onSuccess(Futures.m2455a((Future) listenableFuture));
                    return;
                }
                return;
            }
        }
        Futures.m2458a((ListenableFuture) listenableFuture, (FutureCallback) futureCallback, executor);
    }

    private <T> void m14391a(GraphQLPrefetchPolicy<T> graphQLPrefetchPolicy, String str, FutureCallback<GraphQLPrefetchResult<T>> futureCallback, CallerContext callerContext, Executor executor, GraphQLCachePolicy graphQLCachePolicy) {
        ListenableFuture a = this.f9414c.m10446a(m14401c(graphQLPrefetchPolicy, str, graphQLCachePolicy, callerContext));
        this.f9419h.m14418a(str, (GraphQLPrefetchPolicy) graphQLPrefetchPolicy, a);
        Futures.m2458a(Futures.m2449a(a, new 5(true)), (FutureCallback) futureCallback, executor);
    }

    private <T> void m14403c(GraphQLPrefetchPolicy<T> graphQLPrefetchPolicy, String str, FutureCallback<GraphQLPrefetchResult<T>> futureCallback, CallerContext callerContext, Executor executor) {
        ListenableFuture a = this.f9420i.m14417a(str, graphQLPrefetchPolicy);
        if (a != null) {
            a.mo223a(new 3(this, graphQLPrefetchPolicy, str, futureCallback, callerContext, executor), executor);
            return;
        }
        m14391a((GraphQLPrefetchPolicy) graphQLPrefetchPolicy, str, (FutureCallback) futureCallback, callerContext, executor, GraphQLCachePolicy.f7112d);
    }

    @Nullable
    private static <T> GraphQLRequest<T> m14386a(GraphQLPrefetchPolicy<T> graphQLPrefetchPolicy, String str, GraphQLCachePolicy graphQLCachePolicy, CallerContext callerContext) {
        GraphQLRequest<T> b = graphQLPrefetchPolicy.mo1928b(str);
        if (b != null) {
            b.m11590a((long) graphQLPrefetchPolicy.mo1927b());
            if (graphQLCachePolicy != null) {
                b.m11594a(graphQLCachePolicy);
            }
            if (callerContext != null) {
                b.f7088f = callerContext;
            }
        }
        return b;
    }

    private static <T> GraphQLRequest<T> m14396b(GraphQLPrefetchPolicy<T> graphQLPrefetchPolicy, String str, GraphQLCachePolicy graphQLCachePolicy, CallerContext callerContext) {
        GraphQLRequest<T> a = graphQLPrefetchPolicy.mo1924a(str);
        a.m11590a((long) graphQLPrefetchPolicy.mo1927b());
        if (graphQLCachePolicy != null) {
            a.m11594a(graphQLCachePolicy);
        }
        if (callerContext != null) {
            a.f7088f = callerContext;
        }
        return a;
    }

    private <T> GraphQLRequest<T> m14401c(GraphQLPrefetchPolicy<T> graphQLPrefetchPolicy, String str, GraphQLCachePolicy graphQLCachePolicy, CallerContext callerContext) {
        GraphQLRequest<T> b = m14396b(graphQLPrefetchPolicy, str, graphQLCachePolicy, callerContext);
        if (this.f9427p.m2189a(637, false)) {
            b.m11596a(RequestPriority.INTERACTIVE);
        }
        return b;
    }

    public static void m14402c(GraphQLPrefetchController graphQLPrefetchController, GraphQLPrefetchPolicy graphQLPrefetchPolicy) {
        int e = m14404e(graphQLPrefetchPolicy);
        ArrayList a = Lists.m1296a();
        ConcurrentSkipListSet concurrentSkipListSet = (ConcurrentSkipListSet) graphQLPrefetchController.f9417f.get(graphQLPrefetchPolicy);
        while (true) {
            String str = (String) concurrentSkipListSet.pollFirst();
            if (str == null) {
                break;
            } else if (graphQLPrefetchPolicy.m14381g() || !graphQLPrefetchController.m14410a(graphQLPrefetchPolicy, str)) {
                a.add(str);
                if (a.size() >= e) {
                    break;
                }
            }
        }
        Collection<String> collection = a;
        if (!collection.isEmpty()) {
            PrefetchAnalytics a2 = graphQLPrefetchController.m14405a(graphQLPrefetchPolicy);
            if (collection != null) {
                for (String f : collection) {
                    a2.m29418f(f);
                }
            }
            Integer.valueOf(collection.size());
            Futures.m2458a(graphQLPrefetchController.m14388a(graphQLPrefetchPolicy, (Collection) collection), new 4(graphQLPrefetchController, a2, collection, graphQLPrefetchPolicy), graphQLPrefetchController.f9415d);
        }
    }

    private ListenableFuture<List<GraphQLResult>> m14388a(GraphQLPrefetchPolicy graphQLPrefetchPolicy, Collection<String> collection) {
        Iterable arrayList = new ArrayList(collection.size());
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest(graphQLPrefetchPolicy.mo1929c());
        for (String str : collection) {
            ListenableFuture b = graphQLBatchRequest.m11224b(m14396b(graphQLPrefetchPolicy, str, GraphQLCachePolicy.f7113e, f9411b));
            this.f9420i.m14418a(str, graphQLPrefetchPolicy, b);
            arrayList.add(b);
        }
        this.f9414c.m10452a(graphQLBatchRequest);
        return Futures.m2451a(arrayList);
    }

    public final boolean m14410a(GraphQLPrefetchPolicy graphQLPrefetchPolicy, String str) {
        return this.f9416e.mo1447d(m14396b(graphQLPrefetchPolicy, str, GraphQLCachePolicy.f7110b, null));
    }

    public static <T> GraphQLPrefetchResult<T> m14395b(@Nullable GraphQLResult<T> graphQLResult, boolean z) {
        if (graphQLResult == null) {
            return new GraphQLPrefetchResult(null, z, true);
        }
        return new GraphQLPrefetchResult(graphQLResult.f6203e, z, false);
    }

    @VisibleForTesting
    public static int m14404e(GraphQLPrefetchPolicy graphQLPrefetchPolicy) {
        return graphQLPrefetchPolicy.mo1932f();
    }

    private void m14399b(GraphQLPrefetchPolicy graphQLPrefetchPolicy, String str) {
        if (((PrefetchAnalytics) this.f9421j.get(graphQLPrefetchPolicy)) == null) {
            this.f9421j.putIfAbsent(graphQLPrefetchPolicy, this.f9422k.m14412a(graphQLPrefetchPolicy.mo1929c(), graphQLPrefetchPolicy.mo1924a(str).f7096o.f6530b));
        }
    }

    @VisibleForTesting
    final PrefetchAnalytics m14405a(GraphQLPrefetchPolicy graphQLPrefetchPolicy) {
        return (PrefetchAnalytics) this.f9421j.get(graphQLPrefetchPolicy);
    }

    public final void m14407a(GraphQLPrefetchPolicy<?> graphQLPrefetchPolicy, GraphQLFeedback graphQLFeedback) {
        this.f9418g.offer(new FeedbackItemPair(graphQLFeedback, graphQLPrefetchPolicy, Integer.valueOf(0)));
        m14397b();
    }

    public final void m14411b(GraphQLPrefetchPolicy<?> graphQLPrefetchPolicy, GraphQLFeedback graphQLFeedback) {
        this.f9418g.offer(new FeedbackItemPair(graphQLFeedback, graphQLPrefetchPolicy, Integer.valueOf(1)));
        m14397b();
    }

    public static void m14390a(GraphQLPrefetchController graphQLPrefetchController, GraphQLFeedback graphQLFeedback, GraphQLPrefetchPolicy graphQLPrefetchPolicy, Integer num) {
        try {
            GraphQLRequest a = graphQLPrefetchPolicy.mo1924a(graphQLFeedback.z_());
            switch (num.intValue()) {
                case 0:
                    graphQLPrefetchController.f9416e.mo1449b(a, new Builder().m21598a((Object) graphQLFeedback).m21600a());
                    return;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    GraphQLResult b = graphQLPrefetchController.f9416e.mo1448b(a);
                    if (b != null && b.m10400d() != null && GraphQLHelper.m22504f((GraphQLFeedback) b.m10400d()) == 0) {
                        graphQLPrefetchController.f9416e.mo1446c(a);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
        }
    }
}
