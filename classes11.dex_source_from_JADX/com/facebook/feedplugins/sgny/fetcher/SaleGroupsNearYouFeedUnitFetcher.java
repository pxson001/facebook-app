package com.facebook.feedplugins.sgny.fetcher;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.feed.hscroll.HScrollFeedUnitFetcher;
import com.facebook.feed.protocol.FetchSaleGroupsNearYouGraphQL.SaleGroupsNearYouQueryString;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.feed.util.event.StoryEvents.FeedUnitSubscribeEvent;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnit;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnitGroupsConnection;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnitGroupsEdge;
import com.facebook.graphql.model.IsValidUtil;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.ScrollableItemListFeedUnitImpl;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.graphql.model.mutator.FeedUnitMutator;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
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
/* compiled from: bundle_collection_others */
public class SaleGroupsNearYouFeedUnitFetcher extends HScrollFeedUnitFetcher<GraphQLSaleGroupsNearYouFeedUnit> {
    private static volatile SaleGroupsNearYouFeedUnitFetcher f9358i;
    public final Set<String> f9359a = new HashSet();
    public final GraphQLQueryExecutor f9360b;
    public final ExecutorService f9361c;
    public final AbstractFbErrorReporter f9362d;
    public final FeedStoryMutator f9363e;
    public final TasksManager<TaskKey> f9364f;
    public final GraphQLStoryHelper f9365g;
    public final FeedEventBus f9366h;

    /* compiled from: bundle_collection_others */
    public class C11233 implements Function<GraphQLResult<GraphQLNode>, GraphQLSaleGroupsNearYouFeedUnitGroupsConnection> {
        final /* synthetic */ SaleGroupsNearYouFeedUnitFetcher f9357a;

        public C11233(SaleGroupsNearYouFeedUnitFetcher saleGroupsNearYouFeedUnitFetcher) {
            this.f9357a = saleGroupsNearYouFeedUnitFetcher;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                return null;
            }
            return ((GraphQLNode) graphQLResult.e).jE();
        }
    }

    /* compiled from: bundle_collection_others */
    enum TaskKey {
        SGNY_FETCH_MORE
    }

    public static com.facebook.feedplugins.sgny.fetcher.SaleGroupsNearYouFeedUnitFetcher m9960a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9358i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.sgny.fetcher.SaleGroupsNearYouFeedUnitFetcher.class;
        monitor-enter(r1);
        r0 = f9358i;	 Catch:{ all -> 0x003a }
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
        r0 = m9962b(r0);	 Catch:{ all -> 0x0035 }
        f9358i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9358i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.sgny.fetcher.SaleGroupsNearYouFeedUnitFetcher.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.sgny.fetcher.SaleGroupsNearYouFeedUnitFetcher");
    }

    private static SaleGroupsNearYouFeedUnitFetcher m9962b(InjectorLike injectorLike) {
        return new SaleGroupsNearYouFeedUnitFetcher((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), FeedStoryMutator.b(injectorLike), TasksManager.b(injectorLike), IdBasedLazy.a(injectorLike, 995), GraphQLStoryHelper.a(injectorLike), FeedEventBus.a(injectorLike));
    }

    @Inject
    public SaleGroupsNearYouFeedUnitFetcher(FbErrorReporter fbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, FeedStoryMutator feedStoryMutator, TasksManager tasksManager, Lazy<FeedbackGraphQLGenerator> lazy, GraphQLStoryHelper graphQLStoryHelper, FeedEventBus feedEventBus) {
        this.f9362d = fbErrorReporter;
        this.f9360b = graphQLQueryExecutor;
        this.f9361c = executorService;
        this.f9363e = feedStoryMutator;
        this.f9364f = tasksManager;
        this.f9365g = graphQLStoryHelper;
        this.f9366h = feedEventBus;
    }

    public static boolean m9961a(GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit) {
        GraphQLPageInfo c = m9963c(graphQLSaleGroupsNearYouFeedUnit);
        return (c == null || !c.b() || c.a() == null) ? false : true;
    }

    public final void m9965b(final GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit) {
        final GraphQLPageInfo c = m9963c(graphQLSaleGroupsNearYouFeedUnit);
        if (c != null && c.a() != null) {
            this.f9359a.add(graphQLSaleGroupsNearYouFeedUnit.g());
            this.f9364f.a(TaskKey.SGNY_FETCH_MORE, new Callable<ListenableFuture<GraphQLSaleGroupsNearYouFeedUnitGroupsConnection>>(this) {
                final /* synthetic */ SaleGroupsNearYouFeedUnitFetcher f9353c;

                public Object call() {
                    SaleGroupsNearYouFeedUnitFetcher saleGroupsNearYouFeedUnitFetcher = this.f9353c;
                    String p = graphQLSaleGroupsNearYouFeedUnit.p();
                    return Futures.a(saleGroupsNearYouFeedUnitFetcher.f9360b.a(GraphQLRequest.a((SaleGroupsNearYouQueryString) new SaleGroupsNearYouQueryString().a("node_id", p).a("sgny_cover_photo_width_param", Integer.valueOf(GraphQLStoryHelper.o().intValue() * 3)).a("sgny_facepile_size_param", GraphQLStoryHelper.o()).a("sgny_size_param", saleGroupsNearYouFeedUnitFetcher.f9365g.m()).a("after_param", c.a()).a("sgny_facepile_count_param", Integer.valueOf(3)))), new C11233(saleGroupsNearYouFeedUnitFetcher), saleGroupsNearYouFeedUnitFetcher.f9361c);
                }
            }, new AbstractDisposableFutureCallback<GraphQLSaleGroupsNearYouFeedUnitGroupsConnection>(this) {
                final /* synthetic */ SaleGroupsNearYouFeedUnitFetcher f9356c;

                protected final void m9958a(Object obj) {
                    GraphQLSaleGroupsNearYouFeedUnitGroupsConnection graphQLSaleGroupsNearYouFeedUnitGroupsConnection = (GraphQLSaleGroupsNearYouFeedUnitGroupsConnection) obj;
                    this.f9356c.f9359a.remove(graphQLSaleGroupsNearYouFeedUnit.g());
                    if (!graphQLSaleGroupsNearYouFeedUnitGroupsConnection.a().isEmpty()) {
                        FeedStoryMutator feedStoryMutator = this.f9356c.f9363e;
                        GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit = graphQLSaleGroupsNearYouFeedUnit;
                        Builder builder = ImmutableList.builder();
                        builder.b(ScrollableItemListFeedUnitImpl.a(graphQLSaleGroupsNearYouFeedUnit));
                        if (graphQLSaleGroupsNearYouFeedUnitGroupsConnection.a() != null) {
                            ImmutableList a = graphQLSaleGroupsNearYouFeedUnitGroupsConnection.a();
                            int size = a.size();
                            for (int i = 0; i < size; i++) {
                                GraphQLSaleGroupsNearYouFeedUnitGroupsEdge graphQLSaleGroupsNearYouFeedUnitGroupsEdge = (GraphQLSaleGroupsNearYouFeedUnitGroupsEdge) a.get(i);
                                if (IsValidUtil.a(graphQLSaleGroupsNearYouFeedUnitGroupsEdge)) {
                                    builder.c(graphQLSaleGroupsNearYouFeedUnitGroupsEdge);
                                }
                            }
                        }
                        ImmutableList b = builder.b();
                        GraphQLSaleGroupsNearYouFeedUnit.Builder a2 = GraphQLSaleGroupsNearYouFeedUnit.Builder.a(graphQLSaleGroupsNearYouFeedUnit);
                        GraphQLSaleGroupsNearYouFeedUnitGroupsConnection.Builder a3 = GraphQLSaleGroupsNearYouFeedUnitGroupsConnection.Builder.a(graphQLSaleGroupsNearYouFeedUnit.o());
                        a3.d = b;
                        GraphQLSaleGroupsNearYouFeedUnitGroupsConnection.Builder builder2 = a3;
                        builder2.e = graphQLSaleGroupsNearYouFeedUnitGroupsConnection.j();
                        a2.d = builder2.a();
                        GraphQLSaleGroupsNearYouFeedUnit.Builder builder3 = a2;
                        builder3.g = feedStoryMutator.i.a();
                        GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit2 = (GraphQLSaleGroupsNearYouFeedUnit) FeedUnitMutator.a(builder3.a()).b(graphQLSaleGroupsNearYouFeedUnit.u().c).a();
                        VisibleItemHelper.a(graphQLSaleGroupsNearYouFeedUnit2, graphQLSaleGroupsNearYouFeedUnit.ac_());
                        PropertyHelper.a(graphQLSaleGroupsNearYouFeedUnit2, null);
                        GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit3 = graphQLSaleGroupsNearYouFeedUnit2;
                        if (graphQLSaleGroupsNearYouFeedUnit3 != null) {
                            this.f9356c.f9362d.c(GraphQLSaleGroupsNearYouFeedUnit.class.getSimpleName(), String.valueOf(c) + " Size=" + graphQLSaleGroupsNearYouFeedUnit3.l().size());
                            this.f9356c.f9366h.a(new FeedUnitMutatedEvent(graphQLSaleGroupsNearYouFeedUnit3));
                            this.f9356c.f9366h.a(new FeedUnitSubscribeEvent(graphQLSaleGroupsNearYouFeedUnit3));
                        }
                    }
                }

                protected final void m9959a(Throwable th) {
                    this.f9356c.f9359a.remove(graphQLSaleGroupsNearYouFeedUnit.g());
                }
            });
        }
    }

    public final boolean m9964a(GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit, int i) {
        int size = graphQLSaleGroupsNearYouFeedUnit.l().size();
        if (size <= 3) {
        }
        return !this.f9359a.contains(graphQLSaleGroupsNearYouFeedUnit.g()) && i >= size - 1;
    }

    private static GraphQLPageInfo m9963c(GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit) {
        return graphQLSaleGroupsNearYouFeedUnit.o() != null ? graphQLSaleGroupsNearYouFeedUnit.o().j() : null;
    }
}
