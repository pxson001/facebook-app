package com.facebook.feedplugins.storyset.fetcher;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.controller.mutation.util.FeedStoryCacheAdapter;
import com.facebook.controller.mutation.util.FeedStoryCacheAdapter.16;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.hscroll.HScrollFeedUnitFetcher;
import com.facebook.feed.hscroll.PaginatedHScrollFeedUnitCursorHelper;
import com.facebook.feedplugins.storyset.ExperimentsForStorySetModule;
import com.facebook.feedplugins.storyset.prefs.StorySetPrefKeys;
import com.facebook.feedplugins.storyset.protocol.FetchPaginatedStorySetItemsGraphQL.FetchPaginatedStorySetItemsQueryString;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryExecutor.DataSource;
import com.facebook.graphql.executor.GraphQLQueryScheduler;
import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLWriteLock;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.model.GraphQLAdditionalSuggestedPostAdItemsConnection;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.graphql.model.StorySetHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Function;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: SHOW_EDITED_URI */
public class PaginatedStorySetFetcher extends HScrollFeedUnitFetcher<GraphQLStorySet> {
    private static volatile PaginatedStorySetFetcher f23812k;
    public final Set<String> f23813a = Sets.a();
    public final Set<String> f23814b = Sets.a();
    private final GraphQLQueryScheduler f23815c;
    public final GraphQLQueryExecutor f23816d;
    public final Executor f23817e;
    public final Lazy<FeedStoryCacheAdapter> f23818f;
    public final PaginatedHScrollFeedUnitCursorHelper f23819g;
    private final NewsFeedAnalyticsEventBuilder f23820h;
    public final AnalyticsLogger f23821i;
    public final QeAccessor f23822j;

    /* compiled from: SHOW_EDITED_URI */
    enum LinkPagePostFormat {
        LARGE,
        NEKO
    }

    public static com.facebook.feedplugins.storyset.fetcher.PaginatedStorySetFetcher m25967a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23812k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.storyset.fetcher.PaginatedStorySetFetcher.class;
        monitor-enter(r1);
        r0 = f23812k;	 Catch:{ all -> 0x003a }
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
        r0 = m25970b(r0);	 Catch:{ all -> 0x0035 }
        f23812k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23812k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.storyset.fetcher.PaginatedStorySetFetcher.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.storyset.fetcher.PaginatedStorySetFetcher");
    }

    private static PaginatedStorySetFetcher m25970b(InjectorLike injectorLike) {
        return new PaginatedStorySetFetcher(GraphQLQueryScheduler.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 993), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PaginatedStorySetFetcher(GraphQLQueryScheduler graphQLQueryScheduler, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, Lazy<FeedStoryCacheAdapter> lazy, FbSharedPreferences fbSharedPreferences, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger, QeAccessor qeAccessor) {
        this.f23815c = graphQLQueryScheduler;
        this.f23816d = graphQLQueryExecutor;
        this.f23817e = executorService;
        this.f23818f = lazy;
        this.f23819g = new PaginatedHScrollFeedUnitCursorHelper(fbSharedPreferences, StorySetPrefKeys.f23823a);
        this.f23820h = newsFeedAnalyticsEventBuilder;
        this.f23821i = analyticsLogger;
        this.f23822j = qeAccessor;
    }

    public final boolean m25971a(GraphQLStorySet graphQLStorySet) {
        boolean z = !this.f23814b.contains(graphQLStorySet.g()) && graphQLStorySet.x().size() < this.f23822j.a(ExperimentsForStorySetModule.f23802e, 25);
        return z;
    }

    public final void m25972b(GraphQLStorySet graphQLStorySet) {
        m25968a(graphQLStorySet.g(), StorySetHelper.c(graphQLStorySet), graphQLStorySet.x().size(), graphQLStorySet.ac_(), "NO_RELATED_PAGE");
    }

    private ListenableFuture<GraphQLStorySet> m25968a(final String str, boolean z, final int i, int i2, String str2) {
        SettableFuture f = SettableFuture.f();
        this.f23813a.add(str);
        LinkPagePostFormat linkPagePostFormat = z ? LinkPagePostFormat.NEKO : LinkPagePostFormat.LARGE;
        String num = Integer.toString(i2);
        int min = Math.min(this.f23822j.a(ExperimentsForStorySetModule.f23804g, 8), this.f23822j.a(ExperimentsForStorySetModule.f23802e, 25) - i);
        GraphQlQueryString fetchPaginatedStorySetItemsQueryString = new FetchPaginatedStorySetItemsQueryString();
        fetchPaginatedStorySetItemsQueryString.a("offsetCount", Integer.toString(i)).a("isLargeFormat", linkPagePostFormat.toString()).a("count", Integer.toString(min)).a("afterCursor", num);
        if (!str2.equals("NO_RELATED_PAGE")) {
            fetchPaginatedStorySetItemsQueryString.a("paginationId", "").a("relatedPageId", str2);
        }
        GraphQLRequest a = GraphQLRequest.a(fetchPaginatedStorySetItemsQueryString);
        if (this.f23822j.a(ExperimentsForStorySetModule.f23805h, false)) {
            a = a.a(GraphQLCachePolicy.a).a((long) this.f23822j.a(ExperimentsForStorySetModule.f23803f, 300));
        }
        Futures.a(Futures.a(this.f23816d.a(a), new Function<GraphQLResult<GraphQLViewer>, GraphQLAdditionalSuggestedPostAdItemsConnection>(this) {
            final /* synthetic */ PaginatedStorySetFetcher f23811b;

            public Object apply(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                GraphQLAdditionalSuggestedPostAdItemsConnection k = ((GraphQLViewer) graphQLResult.e).k();
                if (this.f23811b.f23822j.a(ExperimentsForStorySetModule.f23805h, false)) {
                    this.f23811b.f23821i.a(NewsFeedAnalyticsEventBuilder.a(i, GraphQLStorySet.class.toString(), graphQLResult.freshness));
                }
                return k;
            }
        }, this.f23817e), new FutureCallback<GraphQLAdditionalSuggestedPostAdItemsConnection>(this) {
            final /* synthetic */ PaginatedStorySetFetcher f23809b;

            public void onSuccess(Object obj) {
                GraphQLAdditionalSuggestedPostAdItemsConnection graphQLAdditionalSuggestedPostAdItemsConnection = (GraphQLAdditionalSuggestedPostAdItemsConnection) obj;
                this.f23809b.f23813a.remove(str);
                if (graphQLAdditionalSuggestedPostAdItemsConnection.a() == null || graphQLAdditionalSuggestedPostAdItemsConnection.a().isEmpty()) {
                    this.f23809b.f23814b.add(str);
                    return;
                }
                if (!(graphQLAdditionalSuggestedPostAdItemsConnection.j() == null || graphQLAdditionalSuggestedPostAdItemsConnection.j().a() == null)) {
                    this.f23809b.f23819g.a(graphQLAdditionalSuggestedPostAdItemsConnection.j().a());
                }
                PaginatedStorySetFetcher.m25969a(this.f23809b, new 16((FeedStoryCacheAdapter) this.f23809b.f23818f.get(), str, graphQLAdditionalSuggestedPostAdItemsConnection));
            }

            public void onFailure(Throwable th) {
                this.f23809b.f23813a.remove(str);
            }
        }, this.f23817e);
        return f;
    }

    public static void m25969a(PaginatedStorySetFetcher paginatedStorySetFetcher, CacheVisitor cacheVisitor) {
        GraphQLWriteLock a = paginatedStorySetFetcher.f23815c.a(cacheVisitor);
        try {
            a.a(DataSource.NETWORK);
            a.a(true);
            paginatedStorySetFetcher.f23816d.a(a);
        } catch (Exception e) {
        } finally {
            a.e();
        }
    }
}
