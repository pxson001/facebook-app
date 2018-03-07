package com.facebook.timeline.datafetcher;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.FirstUnitsObservables;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams;
import com.facebook.timeline.viewfeaturedcontainers.abtest.FavPhotosVsFeaturedContainersController;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersQueryFactory;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: greeting_cards */
public class TimelineNonSelfFirstUnitsQueryExecutor implements TimelineFirstUnitsQueryExecutor {
    private static volatile TimelineNonSelfFirstUnitsQueryExecutor f10570c;
    private final GraphQLQueryExecutor f10571a;
    private final TimelineNonSelfFirstUnitsQueryBuilder f10572b;

    public static com.facebook.timeline.datafetcher.TimelineNonSelfFirstUnitsQueryExecutor m10653a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10570c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.datafetcher.TimelineNonSelfFirstUnitsQueryExecutor.class;
        monitor-enter(r1);
        r0 = f10570c;	 Catch:{ all -> 0x003a }
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
        r0 = m10654b(r0);	 Catch:{ all -> 0x0035 }
        f10570c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10570c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.datafetcher.TimelineNonSelfFirstUnitsQueryExecutor.a(com.facebook.inject.InjectorLike):com.facebook.timeline.datafetcher.TimelineNonSelfFirstUnitsQueryExecutor");
    }

    private static TimelineNonSelfFirstUnitsQueryExecutor m10654b(InjectorLike injectorLike) {
        return new TimelineNonSelfFirstUnitsQueryExecutor(GraphQLQueryExecutor.a(injectorLike), new TimelineNonSelfFirstUnitsQueryBuilder((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), TimelineUnseenStoriesQueryBuilder.m10733a(injectorLike), TimelineFirstUnitsQueryBuilder.m10587a(injectorLike), ProtilesQueryFactory.m10534a(injectorLike), TimelineSectionQueryExecutor.m10663b(injectorLike), FeaturedContainersQueryFactory.m12782a(injectorLike), FavPhotosVsFeaturedContainersController.m12774a(injectorLike)));
    }

    @Inject
    public TimelineNonSelfFirstUnitsQueryExecutor(GraphQLQueryExecutor graphQLQueryExecutor, TimelineNonSelfFirstUnitsQueryBuilder timelineNonSelfFirstUnitsQueryBuilder) {
        this.f10571a = graphQLQueryExecutor;
        this.f10572b = timelineNonSelfFirstUnitsQueryBuilder;
    }

    public final FirstUnitsObservables mo506a(boolean z, FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, CallerContext callerContext) {
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("TimelineNonSelfFirstUnits");
        FirstUnitsObservables a = mo505a(graphQLBatchRequest, 0, z, fetchTimelineFirstUnitsParams, callerContext);
        this.f10571a.a(graphQLBatchRequest);
        return a;
    }

    public final FirstUnitsObservables mo505a(GraphQLBatchRequest graphQLBatchRequest, int i, boolean z, FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, CallerContext callerContext) {
        FirstUnitsObservables a = m10652a(graphQLBatchRequest, z, fetchTimelineFirstUnitsParams, i, callerContext);
        if (z) {
            return a;
        }
        return FirstUnitsReplayableBatchFetcher.m10529a(fetchTimelineFirstUnitsParams, callerContext, a, this);
    }

    private FirstUnitsObservables m10652a(GraphQLBatchRequest graphQLBatchRequest, boolean z, FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, int i, CallerContext callerContext) {
        RequestObservable a = this.f10572b.m10646a(graphQLBatchRequest, i, fetchTimelineFirstUnitsParams, callerContext);
        GraphQLRequest a2 = this.f10572b.m10645a(fetchTimelineFirstUnitsParams, z, i, callerContext);
        RequestObservable a3 = this.f10572b.m10647a(graphQLBatchRequest, a2);
        RequestObservable a4 = this.f10572b.m10648a(graphQLBatchRequest, a2, z, i, callerContext);
        RequestObservable a5 = this.f10572b.m10649a(graphQLBatchRequest, fetchTimelineFirstUnitsParams, z, i, callerContext);
        return new FirstUnitsObservables(a3, a4, a5, RequestObservable.b(), RequestObservable.b(), this.f10572b.m10650b(graphQLBatchRequest, fetchTimelineFirstUnitsParams, z, i, callerContext), this.f10572b.m10651c(graphQLBatchRequest, fetchTimelineFirstUnitsParams, z, i, callerContext), a, null);
    }
}
