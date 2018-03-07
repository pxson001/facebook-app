package com.facebook.feedback.prefetcher;

import com.facebook.api.prefetch.GraphQLPrefetchConsumer;
import com.facebook.api.prefetch.GraphQLPrefetchConsumerProvider;
import com.facebook.api.prefetch.GraphQLPrefetchPolicy;
import com.facebook.api.prefetch.GraphQLPrefetchPriority;
import com.facebook.api.prefetch.GraphQLPrefetcher;
import com.facebook.api.prefetch.GraphQLPrefetcherProvider;
import com.facebook.api.ufiservices.FeedbackPrefetchPolicy;
import com.facebook.api.ufiservices.FeedbackPrefetchPolicyProvider;
import com.facebook.api.ufiservices.qe.CommentPrefetchExperimentController;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.graphql.enums.GraphQLFeedbackReadLikelihood;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedbackContext;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: post_permission_setting */
public class FeedbackPrefetcher {
    private static volatile FeedbackPrefetcher f9390f;
    public final Map<GraphQLFeedbackReadLikelihood, GraphQLPrefetchPriority> f9391a = ImmutableMap.of(GraphQLFeedbackReadLikelihood.UNKNOWN, GraphQLPrefetchPriority.UNKNOWN, GraphQLFeedbackReadLikelihood.LOW, GraphQLPrefetchPriority.LOW, GraphQLFeedbackReadLikelihood.HIGH, GraphQLPrefetchPriority.HIGH);
    private final PolicyPrefetchGroup[] f9392b;
    public final QeAccessor f9393c;
    public final CommentPrefetchExperimentController f9394d;
    private final FeedbackPrefetchingExperiments f9395e;

    /* compiled from: post_permission_setting */
    class PolicyPrefetchGroup {
        public final FeedbackPrefetchPolicy f9398a;
        public final GraphQLPrefetchConsumer<GraphQLFeedback> f9399b;
        public final GraphQLPrefetcher f9400c;

        public PolicyPrefetchGroup(FeedbackPrefetchPolicy feedbackPrefetchPolicy, GraphQLPrefetchConsumer<GraphQLFeedback> graphQLPrefetchConsumer, GraphQLPrefetcher graphQLPrefetcher) {
            this.f9398a = feedbackPrefetchPolicy;
            this.f9399b = graphQLPrefetchConsumer;
            this.f9400c = graphQLPrefetcher;
        }
    }

    public static com.facebook.feedback.prefetcher.FeedbackPrefetcher m14339a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9390f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedback.prefetcher.FeedbackPrefetcher.class;
        monitor-enter(r1);
        r0 = f9390f;	 Catch:{ all -> 0x003a }
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
        r0 = m14340b(r0);	 Catch:{ all -> 0x0035 }
        f9390f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9390f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.prefetcher.FeedbackPrefetcher.a(com.facebook.inject.InjectorLike):com.facebook.feedback.prefetcher.FeedbackPrefetcher");
    }

    private static FeedbackPrefetcher m14340b(InjectorLike injectorLike) {
        return new FeedbackPrefetcher((GraphQLPrefetcherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GraphQLPrefetcherProvider.class), (FeedbackPrefetchPolicyProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedbackPrefetchPolicyProvider.class), (GraphQLPrefetchConsumerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GraphQLPrefetchConsumerProvider.class), QeInternalImplMethodAutoProvider.m3744a(injectorLike), CommentPrefetchExperimentController.m14352b(injectorLike), FeedbackPrefetchingExperiments.m14356b(injectorLike));
    }

    @Inject
    public FeedbackPrefetcher(GraphQLPrefetcherProvider graphQLPrefetcherProvider, FeedbackPrefetchPolicyProvider feedbackPrefetchPolicyProvider, GraphQLPrefetchConsumerProvider graphQLPrefetchConsumerProvider, QeAccessor qeAccessor, CommentPrefetchExperimentController commentPrefetchExperimentController, FeedbackPrefetchingExperiments feedbackPrefetchingExperiments) {
        this.f9393c = qeAccessor;
        this.f9394d = commentPrefetchExperimentController;
        this.f9395e = feedbackPrefetchingExperiments;
        this.f9392b = new PolicyPrefetchGroup[4];
        for (int i = 0; i < 4; i++) {
            boolean z;
            boolean z2;
            if ((i & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((i & 1) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            GraphQLPrefetchPolicy a = feedbackPrefetchPolicyProvider.m14350a(Boolean.valueOf(z), Boolean.valueOf(z2));
            GraphQLPrefetcher a2 = graphQLPrefetcherProvider.m14349a(a);
            this.f9392b[i] = new PolicyPrefetchGroup(a, graphQLPrefetchConsumerProvider.m14351a(a), a2);
        }
    }

    public final void m14346a(GraphQLStory graphQLStory, DataFreshnessResult dataFreshnessResult) {
        GraphQLPrefetcher c = m14341c(graphQLStory);
        GraphQLFeedback l = graphQLStory.mo2890l();
        if (l != null) {
            boolean z = true;
            boolean z2 = GraphQLHelper.m22504f(l) == 0 && this.f9393c.mo596a(ExperimentsForNewsFeedAbTestModule.f5114o, false) && !this.f9393c.mo596a(ExperimentsForNewsFeedAbTestModule.f5121v, false);
            if (z2) {
                c.m14383a(l);
            }
            if (GraphQLHelper.m22504f(l) <= 0 || !this.f9393c.mo596a(ExperimentsForNewsFeedAbTestModule.f5113n, false) || this.f9393c.mo596a(ExperimentsForNewsFeedAbTestModule.f5121v, false)) {
                z = false;
            }
            if (z) {
                c.m14384b(l);
            }
            if (z2) {
                return;
            }
        }
        if (!this.f9393c.mo596a(ExperimentsForNewsFeedAbTestModule.f5119t, false)) {
            GraphQLFeedbackContext aa = graphQLStory.aa();
            if (aa != null && !aa.m24203m().isEmpty() && this.f9394d.m14353a() && (!this.f9394d.m14354c() || dataFreshnessResult == DataFreshnessResult.FROM_SERVER)) {
                GraphQLFeedback l2 = graphQLStory.mo2890l();
                while (l2 == null) {
                    GraphQLStory L = graphQLStory.m22326L();
                    if (L == null) {
                        break;
                    }
                    l2 = L.mo2890l();
                }
                if (l2 != null) {
                    c.m14382a(GraphQLPrefetchPriority.HIGH, l2.z_());
                }
            }
            if (l != null) {
                aa = graphQLStory.aa();
                if (aa != null) {
                    GraphQLPrefetchPriority graphQLPrefetchPriority = (GraphQLPrefetchPriority) this.f9391a.get(aa.m24204n());
                    if (graphQLPrefetchPriority == null) {
                        graphQLPrefetchPriority = GraphQLPrefetchPriority.UNKNOWN;
                    }
                    m14345a(graphQLStory, graphQLPrefetchPriority);
                }
            }
        }
    }

    public final boolean m14347a(GraphQLStory graphQLStory) {
        GraphQLFeedback l = graphQLStory.mo2890l();
        if (l != null) {
            GraphQLPrefetcher c = m14341c(graphQLStory);
            if (c.f9408a.m14410a(c.f9409b, l.z_())) {
                return true;
            }
        }
        return false;
    }

    public final void m14344a(GraphQLFeedback graphQLFeedback, boolean z, @Nullable String str) {
        PolicyPrefetchGroup c = m14342c(z, str != null);
        if (str != null) {
            c.f9398a.m14362a(graphQLFeedback.z_(), str);
        }
        c.f9400c.m14383a(graphQLFeedback);
        c.f9398a.m14368c(graphQLFeedback.z_());
    }

    public final void m14345a(GraphQLStory graphQLStory, GraphQLPrefetchPriority graphQLPrefetchPriority) {
        GraphQLFeedback l = graphQLStory.mo2890l();
        if (l != null) {
            m14341c(graphQLStory).m14382a(graphQLPrefetchPriority, l.z_());
        }
    }

    public final GraphQLPrefetchConsumer<GraphQLFeedback> m14343a(boolean z, boolean z2) {
        return m14342c(z, z2).f9399b;
    }

    public final FeedbackPrefetchPolicy m14348b(boolean z, boolean z2) {
        return m14342c(z, z2).f9398a;
    }

    private PolicyPrefetchGroup m14342c(boolean z, boolean z2) {
        int i;
        int i2 = 1;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        i = (i << 1) | 0;
        if (!z2) {
            i2 = 0;
        }
        return this.f9392b[i2 | i];
    }

    private GraphQLPrefetcher m14341c(GraphQLStory graphQLStory) {
        boolean z = true;
        boolean z2 = this.f9395e.m14357a() && GraphQLHelper.m22521o(graphQLStory);
        GraphQLFeedbackContext aa = graphQLStory.aa();
        if (aa == null || aa.m24203m().isEmpty()) {
            z = false;
        }
        return m14342c(z2, z).f9400c;
    }
}
