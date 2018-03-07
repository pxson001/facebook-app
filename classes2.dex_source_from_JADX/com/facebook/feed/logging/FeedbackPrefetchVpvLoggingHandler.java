package com.facebook.feed.logging;

import android.os.Handler;
import android.support.v4.util.ArrayMap;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feedback.prefetcher.FeedbackPrefetcher;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.Collections;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: post_survey_answers */
public class FeedbackPrefetchVpvLoggingHandler {
    private static volatile FeedbackPrefetchVpvLoggingHandler f9383g;
    private final FbDataConnectionManager f9384a;
    public final FeedbackPrefetcher f9385b;
    public final QeAccessor f9386c;
    public final Handler f9387d;
    private final Handler f9388e;
    public final Map<String, Runnable> f9389f = Collections.synchronizedMap(new ArrayMap(2));

    public static com.facebook.feed.logging.FeedbackPrefetchVpvLoggingHandler m14336a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9383g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.logging.FeedbackPrefetchVpvLoggingHandler.class;
        monitor-enter(r1);
        r0 = f9383g;	 Catch:{ all -> 0x003a }
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
        r0 = m14337b(r0);	 Catch:{ all -> 0x0035 }
        f9383g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9383g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.logging.FeedbackPrefetchVpvLoggingHandler.a(com.facebook.inject.InjectorLike):com.facebook.feed.logging.FeedbackPrefetchVpvLoggingHandler");
    }

    private static FeedbackPrefetchVpvLoggingHandler m14337b(InjectorLike injectorLike) {
        return new FeedbackPrefetchVpvLoggingHandler(FbDataConnectionManager.m3787a(injectorLike), FeedbackPrefetcher.m14339a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), Handler_ForUiThreadMethodAutoProvider.m1701b(injectorLike), Handler_ForNonUiThreadMethodAutoProvider.m5523b(injectorLike));
    }

    @Inject
    public FeedbackPrefetchVpvLoggingHandler(FbDataConnectionManager fbDataConnectionManager, FeedbackPrefetcher feedbackPrefetcher, QeAccessor qeAccessor, Handler handler, Handler handler2) {
        this.f9384a = fbDataConnectionManager;
        this.f9385b = feedbackPrefetcher;
        this.f9386c = qeAccessor;
        this.f9387d = handler;
        this.f9388e = handler2;
    }

    public final void m14338a(GraphQLStory graphQLStory) {
        if (graphQLStory != null && graphQLStory.mo2890l() != null && GraphQLHelper.m22504f(graphQLStory.mo2890l()) != 0) {
            ConnectionQuality c = this.f9384a.m3801c();
            if (c.compareTo(ConnectionQuality.EXCELLENT) < 0 && c.compareTo(ConnectionQuality.POOR) > 0) {
                String g = graphQLStory.mo2507g();
                1 1 = new 1(this, graphQLStory);
                int a = this.f9386c.mo572a(ExperimentsForNewsFeedAbTestModule.f5118s, 5000);
                this.f9389f.put(g, 1);
                HandlerDetour.b(this.f9387d, 1, (long) a, -1210931033);
                HandlerDetour.a(this.f9388e, new 2(this, graphQLStory, g, 1), 1301624751);
            }
        }
    }
}
