package com.facebook.timeline.datafetcher;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.FirstUnitsObservables;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: greeting_card_id */
public class TimelineSelfFirstUnitsQueryExecutor implements TimelineFirstUnitsQueryExecutor {
    private static volatile TimelineSelfFirstUnitsQueryExecutor f10602d;
    private final TimelineSelfFirstUnitsQueryBuilder f10603a;
    private final GraphQLQueryExecutor f10604b;
    private final QeAccessor f10605c;

    public static com.facebook.timeline.datafetcher.TimelineSelfFirstUnitsQueryExecutor m10677a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10602d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.datafetcher.TimelineSelfFirstUnitsQueryExecutor.class;
        monitor-enter(r1);
        r0 = f10602d;	 Catch:{ all -> 0x003a }
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
        r0 = m10678b(r0);	 Catch:{ all -> 0x0035 }
        f10602d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10602d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.datafetcher.TimelineSelfFirstUnitsQueryExecutor.a(com.facebook.inject.InjectorLike):com.facebook.timeline.datafetcher.TimelineSelfFirstUnitsQueryExecutor");
    }

    private static TimelineSelfFirstUnitsQueryExecutor m10678b(InjectorLike injectorLike) {
        return new TimelineSelfFirstUnitsQueryExecutor(TimelineSelfFirstUnitsQueryBuilder.m10667b(injectorLike), GraphQLQueryExecutor.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TimelineSelfFirstUnitsQueryExecutor(TimelineSelfFirstUnitsQueryBuilder timelineSelfFirstUnitsQueryBuilder, GraphQLQueryExecutor graphQLQueryExecutor, QeAccessor qeAccessor) {
        this.f10603a = timelineSelfFirstUnitsQueryBuilder;
        this.f10604b = graphQLQueryExecutor;
        this.f10605c = qeAccessor;
    }

    public final FirstUnitsObservables mo506a(boolean z, FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, CallerContext callerContext) {
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("TimelineSelfFirstUnits");
        FirstUnitsObservables a = mo505a(graphQLBatchRequest, 0, z, fetchTimelineFirstUnitsParams, callerContext);
        this.f10604b.a(graphQLBatchRequest);
        return a;
    }

    public final FirstUnitsObservables mo505a(GraphQLBatchRequest graphQLBatchRequest, int i, boolean z, FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, CallerContext callerContext) {
        FirstUnitsObservables a = m10676a(graphQLBatchRequest, fetchTimelineFirstUnitsParams, i, callerContext, z ? GraphQLCachePolicy.d : GraphQLCachePolicy.a);
        if (z) {
            return a;
        }
        return FirstUnitsReplayableBatchFetcher.m10529a(fetchTimelineFirstUnitsParams, callerContext, a, this);
    }

    private FirstUnitsObservables m10676a(GraphQLBatchRequest graphQLBatchRequest, FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, int i, CallerContext callerContext, GraphQLCachePolicy graphQLCachePolicy) {
        RequestObservable a = this.f10603a.m10673a(graphQLBatchRequest, fetchTimelineFirstUnitsParams, graphQLCachePolicy, i, callerContext);
        RequestObservable a2 = this.f10603a.m10670a(graphQLBatchRequest, graphQLCachePolicy, i, callerContext);
        GraphQLRequest a3 = this.f10603a.m10668a(fetchTimelineFirstUnitsParams, graphQLCachePolicy, i, callerContext);
        RequestObservable a4 = this.f10603a.m10671a(graphQLBatchRequest, a3);
        RequestObservable a5 = this.f10603a.m10672a(graphQLBatchRequest, a3, graphQLCachePolicy, i, callerContext);
        RequestObservable a6 = TimelineTaggedMediaSetQueryExecutor.m10732a(graphQLBatchRequest, String.valueOf(fetchTimelineFirstUnitsParams.m12092a()), i, callerContext, graphQLCachePolicy);
        RequestObservable c = this.f10603a.m10675c(graphQLBatchRequest, fetchTimelineFirstUnitsParams, graphQLCachePolicy, i, callerContext);
        RequestObservable b = this.f10603a.m10674b(graphQLBatchRequest, fetchTimelineFirstUnitsParams, graphQLCachePolicy, i, callerContext);
        RequestObservable requestObservable = null;
        if (this.f10605c.a(ExperimentsForTimelineAbTestModule.O, false)) {
            requestObservable = this.f10603a.m10669a(graphQLBatchRequest, i, callerContext);
        }
        return new FirstUnitsObservables(a4, a5, a6, a, a2, c, b, null, requestObservable);
    }
}
