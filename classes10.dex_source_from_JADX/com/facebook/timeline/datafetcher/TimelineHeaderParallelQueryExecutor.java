package com.facebook.timeline.datafetcher;

import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.feed.seefirst.seefirstnux.SeeFirstNuxManager;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.intent.ModelBundleGraphQLInterfaces.ModelBundleProfileGraphQL;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.ViewerTopFriendsQueryModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderParams;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: grid_profile_image_size */
public class TimelineHeaderParallelQueryExecutor {
    private static volatile TimelineHeaderParallelQueryExecutor f10537e;
    public final TimelineHeaderRequestFactory f10538a;
    private final DefaultAppChoreographer f10539b;
    public final GraphQLQueryExecutor f10540c;
    private final SeeFirstNuxManager f10541d;

    public static com.facebook.timeline.datafetcher.TimelineHeaderParallelQueryExecutor m10623a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10537e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.datafetcher.TimelineHeaderParallelQueryExecutor.class;
        monitor-enter(r1);
        r0 = f10537e;	 Catch:{ all -> 0x003a }
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
        r0 = m10625b(r0);	 Catch:{ all -> 0x0035 }
        f10537e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10537e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.datafetcher.TimelineHeaderParallelQueryExecutor.a(com.facebook.inject.InjectorLike):com.facebook.timeline.datafetcher.TimelineHeaderParallelQueryExecutor");
    }

    private static TimelineHeaderParallelQueryExecutor m10625b(InjectorLike injectorLike) {
        return new TimelineHeaderParallelQueryExecutor(TimelineHeaderRequestFactory.m10637a(injectorLike), DefaultAppChoreographer.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), SeeFirstNuxManager.a(injectorLike));
    }

    @Inject
    public TimelineHeaderParallelQueryExecutor(TimelineHeaderRequestFactory timelineHeaderRequestFactory, DefaultAppChoreographer defaultAppChoreographer, GraphQLQueryExecutor graphQLQueryExecutor, SeeFirstNuxManager seeFirstNuxManager) {
        this.f10538a = timelineHeaderRequestFactory;
        this.f10539b = defaultAppChoreographer;
        this.f10540c = graphQLQueryExecutor;
        this.f10541d = seeFirstNuxManager;
    }

    public final HeaderFetchFutures m10627a(GraphQLBatchRequest graphQLBatchRequest, FetchTimelineHeaderParams fetchTimelineHeaderParams, @Nullable ModelBundleProfileGraphQL modelBundleProfileGraphQL, @Nullable CallerContext callerContext) {
        GraphQLQueryFuture graphQLQueryFuture;
        GraphQLQueryFuture graphQLQueryFuture2 = null;
        GraphQLQueryFuture a = this.f10540c.a(this.f10538a.m10642a(fetchTimelineHeaderParams, GraphQLCachePolicy.b, callerContext, RequestPriority.INTERACTIVE));
        GraphQLRequest a2 = this.f10538a.m10642a(fetchTimelineHeaderParams, GraphQLCachePolicy.d, callerContext, RequestPriority.INTERACTIVE);
        ListenableFuture b = graphQLBatchRequest.b(a2);
        if (m10624a(modelBundleProfileGraphQL)) {
            GraphQLRequest a3 = this.f10538a.m10641a(fetchTimelineHeaderParams, callerContext);
            graphQLQueryFuture = new GraphQLQueryFuture(graphQLBatchRequest.b(a3), a3);
        } else {
            graphQLQueryFuture = null;
        }
        if (this.f10541d.a()) {
            graphQLQueryFuture2 = m10622a(callerContext, graphQLBatchRequest);
        }
        return new HeaderFetchFutures(a, new GraphQLQueryFuture(b, a2), graphQLQueryFuture, graphQLQueryFuture2);
    }

    public final void m10628a(HeaderFetchFutures headerFetchFutures) {
        this.f10539b.a(headerFetchFutures.f10416a);
        this.f10539b.a(headerFetchFutures.f10417b);
        if (headerFetchFutures.f10418c != null) {
            this.f10539b.a(headerFetchFutures.f10418c);
        }
        if (headerFetchFutures.f10419d != null) {
            this.f10539b.a(headerFetchFutures.f10419d);
        }
    }

    public final GraphQLQueryFuture m10626a(FetchTimelineHeaderParams fetchTimelineHeaderParams, GraphQLCachePolicy graphQLCachePolicy, @Nullable CallerContext callerContext) {
        GraphQLQueryFuture a = this.f10540c.a(this.f10538a.m10642a(fetchTimelineHeaderParams, graphQLCachePolicy, callerContext, RequestPriority.INTERACTIVE));
        this.f10539b.a(a);
        return a;
    }

    public static boolean m10624a(@Nullable ModelBundleProfileGraphQL modelBundleProfileGraphQL) {
        Object obj = (modelBundleProfileGraphQL == null || modelBundleProfileGraphQL.dB_() == null || modelBundleProfileGraphQL.dB_().b() == null) ? null : 1;
        return obj == null;
    }

    private GraphQLQueryFuture<GraphQLResult<ViewerTopFriendsQueryModel>> m10622a(@Nullable CallerContext callerContext, GraphQLBatchRequest graphQLBatchRequest) {
        GraphQLRequest a = this.f10538a.m10640a(callerContext);
        return new GraphQLQueryFuture(graphQLBatchRequest.b(a), a);
    }
}
