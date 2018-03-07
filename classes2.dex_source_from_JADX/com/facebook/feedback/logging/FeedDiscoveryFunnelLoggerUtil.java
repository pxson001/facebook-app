package com.facebook.feedback.logging;

import com.facebook.feed.rows.core.binding.StoryKeyUtil;
import com.facebook.feedback.abtest.FeedDiscoveryExperimentUtil;
import com.facebook.funnellogger.FunnelDefinition;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: headline */
public class FeedDiscoveryFunnelLoggerUtil {
    private static volatile FeedDiscoveryFunnelLoggerUtil f21130d;
    private final FunnelLoggerImpl f21131a;
    private final FeedDiscoveryLruCache f21132b;
    public final FeedDiscoveryExperimentUtil f21133c;

    public static com.facebook.feedback.logging.FeedDiscoveryFunnelLoggerUtil m28891a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21130d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedback.logging.FeedDiscoveryFunnelLoggerUtil.class;
        monitor-enter(r1);
        r0 = f21130d;	 Catch:{ all -> 0x003a }
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
        r0 = m28894b(r0);	 Catch:{ all -> 0x0035 }
        f21130d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21130d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.logging.FeedDiscoveryFunnelLoggerUtil.a(com.facebook.inject.InjectorLike):com.facebook.feedback.logging.FeedDiscoveryFunnelLoggerUtil");
    }

    private static FeedDiscoveryFunnelLoggerUtil m28894b(InjectorLike injectorLike) {
        return new FeedDiscoveryFunnelLoggerUtil(FunnelLoggerImpl.m8018a(injectorLike), new FeedDiscoveryLruCache(), FeedDiscoveryExperimentUtil.m10422a(injectorLike));
    }

    @Inject
    public FeedDiscoveryFunnelLoggerUtil(FunnelLoggerImpl funnelLoggerImpl, FeedDiscoveryLruCache feedDiscoveryLruCache, FeedDiscoveryExperimentUtil feedDiscoveryExperimentUtil) {
        this.f21131a = funnelLoggerImpl;
        this.f21132b = feedDiscoveryLruCache;
        this.f21133c = feedDiscoveryExperimentUtil;
    }

    private short m28897h(GraphQLStory graphQLStory) {
        return this.f21132b.m28905a(StoryKeyUtil.m28909a(graphQLStory));
    }

    private void m28895b(FunnelLoggerImpl funnelLoggerImpl, GraphQLStory graphQLStory) {
        funnelLoggerImpl.m8035a(FunnelRegistry.f21166m, (long) m28897h(graphQLStory), this.f21133c.m10424a() ? "QE_TEST_GROUP" : "QE_CONTROL_GROUP");
    }

    private void m28896c(FunnelLoggerImpl funnelLoggerImpl, GraphQLStory graphQLStory) {
        String str;
        FunnelDefinition funnelDefinition = FunnelRegistry.f21166m;
        long h = (long) m28897h(graphQLStory);
        Object obj = (graphQLStory == null || !GraphQLHelper.m22479a(graphQLStory.mo2890l())) ? null : 1;
        if (obj != null) {
            str = "REAL_TIME_ACTIVITY_INFO_PRESENT";
        } else {
            str = "REAL_TIME_ACTIVITY_INFO_ABSENT";
        }
        funnelLoggerImpl.m8035a(funnelDefinition, h, str);
    }

    public final void m28898a(GraphQLStory graphQLStory) {
        this.f21131a.m8034a(FunnelRegistry.f21166m, (long) m28897h(graphQLStory));
        m28892a(this.f21131a, graphQLStory);
    }

    private void m28892a(FunnelLoggerImpl funnelLoggerImpl, GraphQLStory graphQLStory) {
        m28895b(funnelLoggerImpl, graphQLStory);
        m28896c(funnelLoggerImpl, graphQLStory);
    }

    public final void m28899b(GraphQLStory graphQLStory) {
        m28893a(graphQLStory, "saw_recent_activity");
    }

    public final void m28900c(GraphQLStory graphQLStory) {
        m28893a(graphQLStory, "saw_return_to_bling_bar");
    }

    public final void m28901d(GraphQLStory graphQLStory) {
        m28893a(graphQLStory, "clicked_on_bling_bar");
    }

    public final void m28902e(GraphQLStory graphQLStory) {
        m28893a(graphQLStory, "clicked_on_comment");
    }

    public final void m28903f(GraphQLStory graphQLStory) {
        m28893a(graphQLStory, "clicked_on_like");
    }

    public final void m28904g(GraphQLStory graphQLStory) {
        m28893a(graphQLStory, "clicked_on_share");
    }

    private void m28893a(GraphQLStory graphQLStory, String str) {
        if (graphQLStory != null && str != null) {
            this.f21131a.m8042b(FunnelRegistry.f21166m, (long) m28897h(graphQLStory), str);
        }
    }
}
