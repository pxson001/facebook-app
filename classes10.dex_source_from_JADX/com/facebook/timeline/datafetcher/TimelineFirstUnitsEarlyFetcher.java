package com.facebook.timeline.datafetcher;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.FirstUnitsObservables;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: groupInformation or groupId is null in editNotificationSetting */
public class TimelineFirstUnitsEarlyFetcher {
    private static volatile TimelineFirstUnitsEarlyFetcher f10469d;
    private final Provider<TimelineSelfFirstUnitsQueryExecutor> f10470a;
    private final Provider<TimelineNonSelfFirstUnitsQueryExecutor> f10471b;
    private final Provider<PerfTestConfig> f10472c;

    public static com.facebook.timeline.datafetcher.TimelineFirstUnitsEarlyFetcher m10584a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10469d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.datafetcher.TimelineFirstUnitsEarlyFetcher.class;
        monitor-enter(r1);
        r0 = f10469d;	 Catch:{ all -> 0x003a }
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
        r0 = m10585b(r0);	 Catch:{ all -> 0x0035 }
        f10469d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10469d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.datafetcher.TimelineFirstUnitsEarlyFetcher.a(com.facebook.inject.InjectorLike):com.facebook.timeline.datafetcher.TimelineFirstUnitsEarlyFetcher");
    }

    private static TimelineFirstUnitsEarlyFetcher m10585b(InjectorLike injectorLike) {
        return new TimelineFirstUnitsEarlyFetcher(IdBasedSingletonScopeProvider.a(injectorLike, 11187), IdBasedSingletonScopeProvider.a(injectorLike, 11183), IdBasedSingletonScopeProvider.a(injectorLike, 593));
    }

    @Inject
    public TimelineFirstUnitsEarlyFetcher(Provider<TimelineSelfFirstUnitsQueryExecutor> provider, Provider<TimelineNonSelfFirstUnitsQueryExecutor> provider2, Provider<PerfTestConfig> provider3) {
        this.f10470a = provider;
        this.f10471b = provider2;
        this.f10472c = provider3;
    }

    public final FirstUnitsObservables m10586a(GraphQLBatchRequest graphQLBatchRequest, long j, boolean z, boolean z2, int i, @Nullable CallerContext callerContext) {
        TimelineFirstUnitsQueryExecutor timelineFirstUnitsQueryExecutor;
        this.f10472c.get();
        boolean z3 = PerfTestConfigBase.f;
        FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams = new FetchTimelineFirstUnitsParams(j, null, z2);
        if (z) {
            timelineFirstUnitsQueryExecutor = (TimelineFirstUnitsQueryExecutor) this.f10470a.get();
        } else {
            timelineFirstUnitsQueryExecutor = (TimelineFirstUnitsQueryExecutor) this.f10471b.get();
        }
        return timelineFirstUnitsQueryExecutor.mo505a(graphQLBatchRequest, i, z3, fetchTimelineFirstUnitsParams, callerContext);
    }
}
