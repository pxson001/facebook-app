package com.facebook.feedplugins.pymi.fetcher;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.feed.hscroll.HScrollFeedUnitFetcher;
import com.facebook.friends.protocol.FetchPeopleYouMayInviteGraphQL.PeopleYouMayInviteQueryString;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnitContactsConnection;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnitContactsEdge;
import com.facebook.graphql.model.IsValidUtil;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: collection/{%s}/{%s}/{%s} */
public class PeopleYouMayInviteFeedUnitFetcher extends HScrollFeedUnitFetcher<GraphQLPeopleYouMayInviteFeedUnit> {
    private static volatile PeopleYouMayInviteFeedUnitFetcher f8681g;
    public final Set<String> f8682a = new HashSet();
    public final GraphQLQueryExecutor f8683b;
    public final Executor f8684c;
    public final FeedStoryMutator f8685d;
    public final TasksManager<Void> f8686e;
    public final Lazy<FeedbackGraphQLGenerator> f8687f;

    /* compiled from: collection/{%s}/{%s}/{%s} */
    public class C10653 implements Function<GraphQLResult<GraphQLNode>, GraphQLPeopleYouMayInviteFeedUnitContactsConnection> {
        final /* synthetic */ PeopleYouMayInviteFeedUnitFetcher f8680a;

        public C10653(PeopleYouMayInviteFeedUnitFetcher peopleYouMayInviteFeedUnitFetcher) {
            this.f8680a = peopleYouMayInviteFeedUnitFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                return null;
            }
            return ((GraphQLNode) graphQLResult.e).z();
        }
    }

    public static com.facebook.feedplugins.pymi.fetcher.PeopleYouMayInviteFeedUnitFetcher m9507a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8681g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.pymi.fetcher.PeopleYouMayInviteFeedUnitFetcher.class;
        monitor-enter(r1);
        r0 = f8681g;	 Catch:{ all -> 0x003a }
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
        r0 = m9508b(r0);	 Catch:{ all -> 0x0035 }
        f8681g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8681g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.pymi.fetcher.PeopleYouMayInviteFeedUnitFetcher.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.pymi.fetcher.PeopleYouMayInviteFeedUnitFetcher");
    }

    private static PeopleYouMayInviteFeedUnitFetcher m9508b(InjectorLike injectorLike) {
        return new PeopleYouMayInviteFeedUnitFetcher(GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), FeedStoryMutator.b(injectorLike), TasksManager.b(injectorLike), IdBasedLazy.a(injectorLike, 995));
    }

    @Inject
    public PeopleYouMayInviteFeedUnitFetcher(GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, FeedStoryMutator feedStoryMutator, TasksManager tasksManager, Lazy<FeedbackGraphQLGenerator> lazy) {
        this.f8683b = graphQLQueryExecutor;
        this.f8684c = executorService;
        this.f8685d = feedStoryMutator;
        this.f8686e = tasksManager;
        this.f8687f = lazy;
    }

    public final void m9511a(final GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit) {
        Object obj;
        int ac_ = graphQLPeopleYouMayInviteFeedUnit.ac_();
        int i = 5;
        int size = graphQLPeopleYouMayInviteFeedUnit.r().size();
        if (size < 5) {
            i = 2;
        }
        if (this.f8682a.contains(graphQLPeopleYouMayInviteFeedUnit.g()) || ac_ < size - r1) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            GraphQLPageInfo e = m9510e(graphQLPeopleYouMayInviteFeedUnit);
            if (e == null || !e.b() || e.a() == null) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                e = m9510e(graphQLPeopleYouMayInviteFeedUnit);
                if (!(e == null || e.a() == null)) {
                    this.f8682a.add(graphQLPeopleYouMayInviteFeedUnit.g());
                    this.f8686e.a(null, new Callable<ListenableFuture<GraphQLPeopleYouMayInviteFeedUnitContactsConnection>>(this) {
                        final /* synthetic */ PeopleYouMayInviteFeedUnitFetcher f8677c;

                        public Object call() {
                            PeopleYouMayInviteFeedUnitFetcher peopleYouMayInviteFeedUnitFetcher = this.f8677c;
                            String D = graphQLPeopleYouMayInviteFeedUnit.D();
                            return Futures.a(peopleYouMayInviteFeedUnitFetcher.f8683b.a(GraphQLRequest.a((PeopleYouMayInviteQueryString) new PeopleYouMayInviteQueryString().a("node_id", D).a("after_cursor", e.a()))), new C10653(peopleYouMayInviteFeedUnitFetcher), peopleYouMayInviteFeedUnitFetcher.f8684c);
                        }
                    }, new AbstractDisposableFutureCallback<GraphQLPeopleYouMayInviteFeedUnitContactsConnection>(this) {
                        final /* synthetic */ PeopleYouMayInviteFeedUnitFetcher f8679b;

                        protected final void m9505a(@Nullable Object obj) {
                            GraphQLPeopleYouMayInviteFeedUnitContactsConnection graphQLPeopleYouMayInviteFeedUnitContactsConnection = (GraphQLPeopleYouMayInviteFeedUnitContactsConnection) obj;
                            this.f8679b.f8682a.remove(graphQLPeopleYouMayInviteFeedUnit.g());
                            if (graphQLPeopleYouMayInviteFeedUnitContactsConnection == null || graphQLPeopleYouMayInviteFeedUnitContactsConnection.a().isEmpty()) {
                                PeopleYouMayInviteFeedUnitFetcher.m9509d(this.f8679b, graphQLPeopleYouMayInviteFeedUnit);
                                return;
                            }
                            FeedStoryMutator feedStoryMutator = this.f8679b.f8685d;
                            GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit = graphQLPeopleYouMayInviteFeedUnit;
                            Builder builder = ImmutableList.builder();
                            builder.b(graphQLPeopleYouMayInviteFeedUnit.l());
                            if (graphQLPeopleYouMayInviteFeedUnitContactsConnection.a() != null) {
                                ImmutableList a = graphQLPeopleYouMayInviteFeedUnitContactsConnection.a();
                                int size = a.size();
                                for (int i = 0; i < size; i++) {
                                    GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge = (GraphQLPeopleYouMayInviteFeedUnitContactsEdge) a.get(i);
                                    if (IsValidUtil.a(graphQLPeopleYouMayInviteFeedUnitContactsEdge)) {
                                        builder.c(graphQLPeopleYouMayInviteFeedUnitContactsEdge);
                                    }
                                }
                            }
                            GraphQLPeopleYouMayInviteFeedUnitContactsConnection.Builder a2 = GraphQLPeopleYouMayInviteFeedUnitContactsConnection.Builder.a(graphQLPeopleYouMayInviteFeedUnit.u());
                            a2.d = builder.b();
                            a2 = a2;
                            a2.e = graphQLPeopleYouMayInviteFeedUnitContactsConnection.j();
                            GraphQLPeopleYouMayInviteFeedUnitContactsConnection a3 = a2.a();
                            GraphQLPeopleYouMayInviteFeedUnit.Builder a4 = GraphQLPeopleYouMayInviteFeedUnit.Builder.a(graphQLPeopleYouMayInviteFeedUnit);
                            a4.f = a3;
                            GraphQLPeopleYouMayInviteFeedUnit.Builder builder2 = a4;
                            builder2.n = feedStoryMutator.i.a();
                            GraphQLPeopleYouMayInviteFeedUnit a5 = builder2.a();
                            VisibleItemHelper.a(a5, graphQLPeopleYouMayInviteFeedUnit.ac_());
                            graphQLPeopleYouMayInviteFeedUnit = a5;
                            ((FeedbackGraphQLGenerator) this.f8679b.f8687f.get()).a(graphQLPeopleYouMayInviteFeedUnit.g(), graphQLPeopleYouMayInviteFeedUnit);
                        }

                        protected final void m9506a(Throwable th) {
                            this.f8679b.f8682a.remove(graphQLPeopleYouMayInviteFeedUnit.g());
                            PeopleYouMayInviteFeedUnitFetcher.m9509d(this.f8679b, graphQLPeopleYouMayInviteFeedUnit);
                        }
                    });
                }
            }
        }
    }

    public static void m9509d(PeopleYouMayInviteFeedUnitFetcher peopleYouMayInviteFeedUnitFetcher, GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit) {
        GraphQLPageInfo.Builder builder = new GraphQLPageInfo.Builder();
        builder.f = false;
        GraphQLPageInfo a = builder.a();
        GraphQLPeopleYouMayInviteFeedUnitContactsConnection.Builder a2 = GraphQLPeopleYouMayInviteFeedUnitContactsConnection.Builder.a(graphQLPeopleYouMayInviteFeedUnit.u());
        a2.e = a;
        GraphQLPeopleYouMayInviteFeedUnitContactsConnection a3 = a2.a();
        GraphQLPeopleYouMayInviteFeedUnit.Builder a4 = GraphQLPeopleYouMayInviteFeedUnit.Builder.a(graphQLPeopleYouMayInviteFeedUnit);
        a4.f = a3;
        ((FeedbackGraphQLGenerator) peopleYouMayInviteFeedUnitFetcher.f8687f.get()).a(graphQLPeopleYouMayInviteFeedUnit.g(), a4.a());
    }

    public static GraphQLPageInfo m9510e(GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit) {
        return graphQLPeopleYouMayInviteFeedUnit.u() != null ? graphQLPeopleYouMayInviteFeedUnit.u().j() : null;
    }
}
