package com.facebook.feedplugins.egolistview.fetcher;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.feed.hscroll.HScrollFeedUnitFetcher;
import com.facebook.feed.protocol.FetchPaginatedGroupsYouShouldJoinGraphQL.PaginatedGroupsYouShouldJoinQueryString;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.feed.util.event.StoryEvents.FeedUnitSubscribeEvent;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLPaginatedGroupsYouShouldJoinFeedUnit;
import com.facebook.graphql.model.GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection;
import com.facebook.graphql.model.GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge;
import com.facebook.graphql.model.IsValidUtil;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.ScrollableItemListFeedUnitImpl;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.graphql.model.mutator.FeedUnitMutator;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: grid_load_failure */
public class PaginatedGYSJFeedUnitFetcher extends HScrollFeedUnitFetcher<GraphQLPaginatedGroupsYouShouldJoinFeedUnit> {
    private static volatile PaginatedGYSJFeedUnitFetcher f12019k;
    public final Set<String> f12020a = new HashSet();
    public final GraphQLQueryExecutor f12021b;
    public final ExecutorService f12022c;
    public final AbstractFbErrorReporter f12023d;
    public final FeedStoryMutator f12024e;
    public final PerformanceLogger f12025f;
    public final TasksManager<TaskKey> f12026g;
    private final Lazy<FeedbackGraphQLGenerator> f12027h;
    public final GraphQLStoryHelper f12028i;
    public final FeedEventBus f12029j;

    /* compiled from: grid_load_failure */
    public class C12883 implements Function<GraphQLResult<GraphQLNode>, GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection> {
        final /* synthetic */ PaginatedGYSJFeedUnitFetcher f12018a;

        public C12883(PaginatedGYSJFeedUnitFetcher paginatedGYSJFeedUnitFetcher) {
            this.f12018a = paginatedGYSJFeedUnitFetcher;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                return null;
            }
            return ((GraphQLNode) graphQLResult.e).A();
        }
    }

    /* compiled from: grid_load_failure */
    enum TaskKey {
        GYSJ_FETCH_MORE
    }

    public static com.facebook.feedplugins.egolistview.fetcher.PaginatedGYSJFeedUnitFetcher m14074a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12019k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.egolistview.fetcher.PaginatedGYSJFeedUnitFetcher.class;
        monitor-enter(r1);
        r0 = f12019k;	 Catch:{ all -> 0x003a }
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
        r0 = m14076b(r0);	 Catch:{ all -> 0x0035 }
        f12019k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12019k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.egolistview.fetcher.PaginatedGYSJFeedUnitFetcher.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.egolistview.fetcher.PaginatedGYSJFeedUnitFetcher");
    }

    private static PaginatedGYSJFeedUnitFetcher m14076b(InjectorLike injectorLike) {
        return new PaginatedGYSJFeedUnitFetcher((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), FeedStoryMutator.b(injectorLike), TasksManager.b(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), IdBasedLazy.a(injectorLike, 995), GraphQLStoryHelper.a(injectorLike), FeedEventBus.a(injectorLike));
    }

    @Inject
    public PaginatedGYSJFeedUnitFetcher(FbErrorReporter fbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, FeedStoryMutator feedStoryMutator, TasksManager tasksManager, PerformanceLogger performanceLogger, Lazy<FeedbackGraphQLGenerator> lazy, GraphQLStoryHelper graphQLStoryHelper, FeedEventBus feedEventBus) {
        this.f12023d = fbErrorReporter;
        this.f12021b = graphQLQueryExecutor;
        this.f12022c = executorService;
        this.f12024e = feedStoryMutator;
        this.f12026g = tasksManager;
        this.f12025f = performanceLogger;
        this.f12027h = lazy;
        this.f12028i = graphQLStoryHelper;
        this.f12029j = feedEventBus;
    }

    public static boolean m14075a(GraphQLPaginatedGroupsYouShouldJoinFeedUnit graphQLPaginatedGroupsYouShouldJoinFeedUnit) {
        GraphQLPageInfo c = m14077c(graphQLPaginatedGroupsYouShouldJoinFeedUnit);
        return (c == null || !c.b() || c.a() == null) ? false : true;
    }

    public final void m14079b(final GraphQLPaginatedGroupsYouShouldJoinFeedUnit graphQLPaginatedGroupsYouShouldJoinFeedUnit) {
        final GraphQLPageInfo c = m14077c(graphQLPaginatedGroupsYouShouldJoinFeedUnit);
        if (c != null && c.a() != null) {
            this.f12020a.add(graphQLPaginatedGroupsYouShouldJoinFeedUnit.g());
            this.f12026g.a(TaskKey.GYSJ_FETCH_MORE, new Callable<ListenableFuture<GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection>>(this) {
                final /* synthetic */ PaginatedGYSJFeedUnitFetcher f12014c;

                public Object call() {
                    PaginatedGYSJFeedUnitFetcher paginatedGYSJFeedUnitFetcher = this.f12014c;
                    String p = graphQLPaginatedGroupsYouShouldJoinFeedUnit.p();
                    return Futures.a(paginatedGYSJFeedUnitFetcher.f12021b.a(GraphQLRequest.a((PaginatedGroupsYouShouldJoinQueryString) new PaginatedGroupsYouShouldJoinQueryString().a("node_id", p).a("gysj_cover_photo_width_param", Integer.valueOf(GraphQLStoryHelper.o().intValue() * 3)).a("gysj_facepile_size_param", GraphQLStoryHelper.o()).a("gysj_size_param", paginatedGYSJFeedUnitFetcher.f12028i.m()).a("after_param", c.a()).a("gysj_facepile_count_param", Integer.valueOf(3)))), new C12883(paginatedGYSJFeedUnitFetcher), paginatedGYSJFeedUnitFetcher.f12022c);
                }
            }, new AbstractDisposableFutureCallback<GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection>(this) {
                final /* synthetic */ PaginatedGYSJFeedUnitFetcher f12017c;

                protected final void m14072a(Object obj) {
                    GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection = (GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection) obj;
                    this.f12017c.f12025f.c(6553601, "PaginatedGysjFeedUnitTTI");
                    this.f12017c.f12020a.remove(graphQLPaginatedGroupsYouShouldJoinFeedUnit.g());
                    if (!graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.a().isEmpty()) {
                        FeedStoryMutator feedStoryMutator = this.f12017c.f12024e;
                        GraphQLPaginatedGroupsYouShouldJoinFeedUnit graphQLPaginatedGroupsYouShouldJoinFeedUnit = graphQLPaginatedGroupsYouShouldJoinFeedUnit;
                        Builder builder = ImmutableList.builder();
                        builder.b(ScrollableItemListFeedUnitImpl.a(graphQLPaginatedGroupsYouShouldJoinFeedUnit));
                        if (graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.a() != null) {
                            ImmutableList a = graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.a();
                            int size = a.size();
                            for (int i = 0; i < size; i++) {
                                GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge = (GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge) a.get(i);
                                if (IsValidUtil.a(graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge)) {
                                    builder.c(graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge);
                                }
                            }
                        }
                        ImmutableList b = builder.b();
                        GraphQLPaginatedGroupsYouShouldJoinFeedUnit.Builder a2 = GraphQLPaginatedGroupsYouShouldJoinFeedUnit.Builder.a(graphQLPaginatedGroupsYouShouldJoinFeedUnit);
                        GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.Builder a3 = GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.Builder.a(graphQLPaginatedGroupsYouShouldJoinFeedUnit.o());
                        a3.d = b;
                        GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.Builder builder2 = a3;
                        builder2.e = graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.j();
                        a2.d = builder2.a();
                        GraphQLPaginatedGroupsYouShouldJoinFeedUnit.Builder builder3 = a2;
                        builder3.g = feedStoryMutator.i.a();
                        GraphQLPaginatedGroupsYouShouldJoinFeedUnit graphQLPaginatedGroupsYouShouldJoinFeedUnit2 = (GraphQLPaginatedGroupsYouShouldJoinFeedUnit) FeedUnitMutator.a(builder3.a()).b(graphQLPaginatedGroupsYouShouldJoinFeedUnit.u().c).a();
                        VisibleItemHelper.a(graphQLPaginatedGroupsYouShouldJoinFeedUnit2, graphQLPaginatedGroupsYouShouldJoinFeedUnit.ac_());
                        PropertyHelper.a(graphQLPaginatedGroupsYouShouldJoinFeedUnit2, null);
                        graphQLPaginatedGroupsYouShouldJoinFeedUnit = graphQLPaginatedGroupsYouShouldJoinFeedUnit2;
                        int i2 = 0;
                        if (graphQLPaginatedGroupsYouShouldJoinFeedUnit != null) {
                            i2 = graphQLPaginatedGroupsYouShouldJoinFeedUnit.l().size();
                        }
                        this.f12017c.f12023d.c(GraphQLPaginatedGroupsYouShouldJoinFeedUnit.class.getSimpleName(), String.valueOf(c) + " Size=" + i2);
                        this.f12017c.f12029j.a(new FeedUnitMutatedEvent(graphQLPaginatedGroupsYouShouldJoinFeedUnit));
                        this.f12017c.f12029j.a(new FeedUnitSubscribeEvent(graphQLPaginatedGroupsYouShouldJoinFeedUnit));
                    }
                }

                protected final void m14073a(Throwable th) {
                    this.f12017c.f12020a.remove(graphQLPaginatedGroupsYouShouldJoinFeedUnit.g());
                    this.f12017c.f12025f.f(6553601, "PaginatedGysjFeedUnitTTI");
                }
            });
        }
    }

    public final boolean m14078a(GraphQLPaginatedGroupsYouShouldJoinFeedUnit graphQLPaginatedGroupsYouShouldJoinFeedUnit, int i) {
        int size = graphQLPaginatedGroupsYouShouldJoinFeedUnit.l().size();
        if (i == size) {
            this.f12025f.a(new MarkerConfig(6553601, "PaginatedGysjFeedUnitTTI").a(new String[]{"native_newsfeed"}), true);
        }
        int i2;
        if (size <= 3) {
            i2 = 1;
        } else {
            i2 = 1;
        }
        if (this.f12020a.contains(graphQLPaginatedGroupsYouShouldJoinFeedUnit.g()) || i < size - i2) {
            return false;
        }
        return true;
    }

    private static GraphQLPageInfo m14077c(GraphQLPaginatedGroupsYouShouldJoinFeedUnit graphQLPaginatedGroupsYouShouldJoinFeedUnit) {
        return graphQLPaginatedGroupsYouShouldJoinFeedUnit.o() != null ? graphQLPaginatedGroupsYouShouldJoinFeedUnit.o().j() : null;
    }
}
