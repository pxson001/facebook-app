package com.facebook.api.ufiservices.common;

import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.abtest.FeedDiscoveryExperimentUtil;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: saved/ */
public class FetchRecentActivityParamBuilderUtil {
    private static volatile FetchRecentActivityParamBuilderUtil f6217b;
    private final FeedDiscoveryExperimentUtil f6218a;

    public static com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil m10419a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6217b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil.class;
        monitor-enter(r1);
        r0 = f6217b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m10420b(r0);	 Catch:{ all -> 0x0035 }
        f6217b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6217b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil.a(com.facebook.inject.InjectorLike):com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil");
    }

    private static FetchRecentActivityParamBuilderUtil m10420b(InjectorLike injectorLike) {
        return new FetchRecentActivityParamBuilderUtil(FeedDiscoveryExperimentUtil.m10422a(injectorLike));
    }

    @Inject
    public FetchRecentActivityParamBuilderUtil(FeedDiscoveryExperimentUtil feedDiscoveryExperimentUtil) {
        this.f6218a = feedDiscoveryExperimentUtil;
    }

    public final void m10421a(GraphQlQueryString graphQlQueryString) {
        graphQlQueryString.m11312a("enable_real_time_activity_info", Boolean.valueOf(this.f6218a.m10424a()));
        graphQlQueryString.m11314a("threshold_duration_for_feed_discovery", Long.valueOf(((long) this.f6218a.f6220a.mo572a(ExperimentsForFeedbackTestModule.f6835m, 60)) * 60));
    }
}
