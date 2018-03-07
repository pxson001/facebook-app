package com.facebook.feedplugins.pymk.fetcher;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.feed.hscroll.HScrollFeedUnitFetcher;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.friends.protocol.FetchPaginatedPeopleYouMayKnowGraphQL.PaginatedPeopleYouMayKnowQueryString;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.Builder;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Function;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: TOP_CONTACT */
public class PaginatedPYMKFeedUnitFetcher extends HScrollFeedUnitFetcher<GraphQLPaginatedPeopleYouMayKnowFeedUnit> {
    private static volatile PaginatedPYMKFeedUnitFetcher f24705l;
    public final Set<String> f24706a = Sets.a();
    public final GraphQLQueryExecutor f24707b;
    public final GraphQLImageHelper f24708c;
    public final Executor f24709d;
    public final AbstractFbErrorReporter f24710e;
    private final FeedEventBus f24711f;
    public final String f24712g;
    public final FeedStoryMutator f24713h;
    public final PerformanceLogger f24714i;
    private final TasksManager<String> f24715j;
    public final Lazy<FeedbackGraphQLGenerator> f24716k;

    /* compiled from: TOP_CONTACT */
    public class C29813 implements Runnable {
        final /* synthetic */ GraphQLPaginatedPeopleYouMayKnowFeedUnit f24702a;
        final /* synthetic */ PaginatedPYMKFeedUnitFetcher f24703b;

        public C29813(PaginatedPYMKFeedUnitFetcher paginatedPYMKFeedUnitFetcher, GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit) {
            this.f24703b = paginatedPYMKFeedUnitFetcher;
            this.f24702a = graphQLPaginatedPeopleYouMayKnowFeedUnit;
        }

        public void run() {
            ((FeedbackGraphQLGenerator) this.f24703b.f24716k.get()).a(this.f24702a.g(), this.f24702a);
        }
    }

    /* compiled from: TOP_CONTACT */
    public class C29824 implements Function<GraphQLResult<GraphQLNode>, GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection> {
        final /* synthetic */ PaginatedPYMKFeedUnitFetcher f24704a;

        public C29824(PaginatedPYMKFeedUnitFetcher paginatedPYMKFeedUnitFetcher) {
            this.f24704a = paginatedPYMKFeedUnitFetcher;
        }

        public Object apply(@Nullable Object obj) {
            return ((GraphQLNode) ((GraphQLResult) obj).e).E();
        }
    }

    public static com.facebook.feedplugins.pymk.fetcher.PaginatedPYMKFeedUnitFetcher m26577a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f24705l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.pymk.fetcher.PaginatedPYMKFeedUnitFetcher.class;
        monitor-enter(r1);
        r0 = f24705l;	 Catch:{ all -> 0x003a }
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
        r0 = m26579b(r0);	 Catch:{ all -> 0x0035 }
        f24705l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f24705l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.pymk.fetcher.PaginatedPYMKFeedUnitFetcher.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.pymk.fetcher.PaginatedPYMKFeedUnitFetcher");
    }

    private static PaginatedPYMKFeedUnitFetcher m26579b(InjectorLike injectorLike) {
        return new PaginatedPYMKFeedUnitFetcher(ResourcesMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), GraphQLImageHelper.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), FeedStoryMutator.b(injectorLike), FeedEventBus.a(injectorLike), TasksManager.b(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), IdBasedLazy.a(injectorLike, 995));
    }

    @Inject
    public PaginatedPYMKFeedUnitFetcher(Resources resources, FbErrorReporter fbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, GraphQLImageHelper graphQLImageHelper, ExecutorService executorService, FeedStoryMutator feedStoryMutator, FeedEventBus feedEventBus, TasksManager tasksManager, PerformanceLogger performanceLogger, Lazy<FeedbackGraphQLGenerator> lazy) {
        this.f24710e = fbErrorReporter;
        this.f24707b = graphQLQueryExecutor;
        this.f24708c = graphQLImageHelper;
        this.f24709d = executorService;
        this.f24713h = feedStoryMutator;
        this.f24711f = feedEventBus;
        this.f24715j = tasksManager;
        this.f24714i = performanceLogger;
        this.f24712g = String.valueOf(resources.getDimensionPixelSize(2131430278));
        this.f24716k = lazy;
    }

    public final boolean m26581a(GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit, int i) {
        int i2;
        int size = graphQLPaginatedPeopleYouMayKnowFeedUnit.l().size();
        boolean a = m26578a(graphQLPaginatedPeopleYouMayKnowFeedUnit);
        if (a && i == size) {
            this.f24714i.a(new MarkerConfig(3014657, "PaginatedPymkFeedUnitTTI").a(new String[]{"native_newsfeed"}), true);
        }
        if (size <= 3) {
            i2 = 1;
        } else {
            i2 = 10;
        }
        int i3 = i2;
        if (this.f24706a.contains(graphQLPaginatedPeopleYouMayKnowFeedUnit.g()) || i < size - i3 || !a) {
            return false;
        }
        return true;
    }

    public static boolean m26578a(GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit) {
        GraphQLPageInfo e = m26580e(graphQLPaginatedPeopleYouMayKnowFeedUnit);
        return (e == null || !e.b() || e.a() == null) ? false : true;
    }

    public final void m26582b(final GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit) {
        final GraphQLPageInfo e = m26580e(graphQLPaginatedPeopleYouMayKnowFeedUnit);
        if (e != null && e.a() != null) {
            this.f24706a.add(graphQLPaginatedPeopleYouMayKnowFeedUnit.g());
            this.f24715j.a("FETCH_PAGINATED_PYMK", new Callable<ListenableFuture<GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection>>(this) {
                final /* synthetic */ PaginatedPYMKFeedUnitFetcher f24698c;

                public Object call() {
                    PaginatedPYMKFeedUnitFetcher paginatedPYMKFeedUnitFetcher = this.f24698c;
                    String p = graphQLPaginatedPeopleYouMayKnowFeedUnit.p();
                    return Futures.a(paginatedPYMKFeedUnitFetcher.f24707b.a(GraphQLRequest.a((PaginatedPeopleYouMayKnowQueryString) new PaginatedPeopleYouMayKnowQueryString().a("node_id", p).a("pymk_size_param", paginatedPYMKFeedUnitFetcher.f24712g).a("after_param", e.a()).a("media_type", paginatedPYMKFeedUnitFetcher.f24708c.b()))), new C29824(paginatedPYMKFeedUnitFetcher), paginatedPYMKFeedUnitFetcher.f24709d);
                }
            }, new AbstractDisposableFutureCallback<GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection>(this) {
                final /* synthetic */ PaginatedPYMKFeedUnitFetcher f24701c;

                protected final void m26575a(Object obj) {
                    GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection = (GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection) obj;
                    this.f24701c.f24714i.e(3014657, "PaginatedPymkFeedUnitTTI");
                    this.f24701c.f24714i.c(3014657, "PaginatedPymkFeedUnitTTI");
                    this.f24701c.f24706a.remove(graphQLPaginatedPeopleYouMayKnowFeedUnit.g());
                    if (graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.a().isEmpty()) {
                        this.f24701c.m26583c(graphQLPaginatedPeopleYouMayKnowFeedUnit);
                        return;
                    }
                    GraphQLPaginatedPeopleYouMayKnowFeedUnit a = this.f24701c.f24713h.a(graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection, graphQLPaginatedPeopleYouMayKnowFeedUnit);
                    this.f24701c.f24710e.c(GraphQLPaginatedPeopleYouMayKnowFeedUnit.class.getSimpleName(), String.valueOf(e) + " Size=" + a.l().size());
                    PaginatedPYMKFeedUnitFetcher paginatedPYMKFeedUnitFetcher = this.f24701c;
                    ExecutorDetour.a(paginatedPYMKFeedUnitFetcher.f24709d, new C29813(paginatedPYMKFeedUnitFetcher, a), 652407986);
                }

                protected final void m26576a(Throwable th) {
                    this.f24701c.f24706a.remove(graphQLPaginatedPeopleYouMayKnowFeedUnit.g());
                    this.f24701c.m26583c(graphQLPaginatedPeopleYouMayKnowFeedUnit);
                }
            });
        }
    }

    private static GraphQLPageInfo m26580e(GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit) {
        return graphQLPaginatedPeopleYouMayKnowFeedUnit.o() != null ? graphQLPaginatedPeopleYouMayKnowFeedUnit.o().j() : null;
    }

    public final void m26583c(GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit) {
        FeedStoryMutator feedStoryMutator = this.f24713h;
        Builder builder = new Builder();
        GraphQLPageInfo.Builder builder2 = new GraphQLPageInfo.Builder();
        builder2.f = false;
        builder.e = builder2.a();
        this.f24711f.a(new FeedUnitMutatedEvent(feedStoryMutator.a(builder.a(), graphQLPaginatedPeopleYouMayKnowFeedUnit)));
    }
}
