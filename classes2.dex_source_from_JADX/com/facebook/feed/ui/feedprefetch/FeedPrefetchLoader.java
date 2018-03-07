package com.facebook.feed.ui.feedprefetch;

import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.prefetch.GraphQLPrefetcherProvider;
import com.facebook.api.ufiservices.FeedbackPrefetchPolicyProvider;
import com.facebook.api.ufiservices.qe.CommentPrefetchExperimentController;
import com.facebook.api.ufiservices.qe.ExperimentsForUfiServiceQeModule;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feedback.prefetcher.FeedbackPrefetcher;
import com.facebook.feedback.prefetcher.FeedbackPrefetchingExperiments;
import com.facebook.graphql.model.GraphQLFeedHomeStories;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.visitor.GraphQLReadOnlyVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.video.server.prefetcher.VideoPrefetchLocation;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: offers/wallet */
public class FeedPrefetchLoader {
    public final CommentPrefetchExperimentController f11553a;
    private final FeedbackContextVisitor f11554b;
    private final VideoPrefetchVisitorProvider f11555c;
    public final QeAccessor f11556d;
    private final DefaultProcessIdleExecutor f11557e;
    private final ExecutorService f11558f;
    private final boolean f11559g;
    public final FeedbackPrefetcher f11560h;
    public final FeedbackPrefetchingExperiments f11561i;
    @Nullable
    private PrefetchVisitorCollection f11562j;

    /* compiled from: offers/wallet */
    class FeedbackContextVisitorRefactor extends FeedbackContextVisitor {
        final /* synthetic */ FeedPrefetchLoader f11563c;

        public FeedbackContextVisitorRefactor(FeedPrefetchLoader feedPrefetchLoader) {
            this.f11563c = feedPrefetchLoader;
            super(feedPrefetchLoader);
        }

        public final void mo2180a(GraphQLStory graphQLStory) {
            this.f11563c.f11560h.m14346a(graphQLStory, this.f11564a);
        }
    }

    /* compiled from: offers/wallet */
    public abstract class FeedbackContextVisitor implements GraphQLStoryVisitor {
        protected DataFreshnessResult f11564a;
        final /* synthetic */ FeedPrefetchLoader f11565b;

        public FeedbackContextVisitor(FeedPrefetchLoader feedPrefetchLoader) {
            this.f11565b = feedPrefetchLoader;
        }

        public final void m16880a(DataFreshnessResult dataFreshnessResult) {
            this.f11564a = dataFreshnessResult;
        }
    }

    /* compiled from: offers/wallet */
    public interface GraphQLStoryVisitor {
        void mo2180a(GraphQLStory graphQLStory);
    }

    /* compiled from: offers/wallet */
    class PrefetchVisitorCollection extends GraphQLReadOnlyVisitor {
        final /* synthetic */ FeedPrefetchLoader f19012a;
        private final GraphQLStoryVisitor[] f19013b;

        public PrefetchVisitorCollection(FeedPrefetchLoader feedPrefetchLoader, GraphQLStoryVisitor... graphQLStoryVisitorArr) {
            this.f19012a = feedPrefetchLoader;
            this.f19013b = graphQLStoryVisitorArr;
        }

        public final boolean mo2927a(GraphQLVisitableModel graphQLVisitableModel) {
            if (!(graphQLVisitableModel instanceof GraphQLStory)) {
                return true;
            }
            m26744a((GraphQLStory) graphQLVisitableModel);
            return false;
        }

        private void m26744a(@Nullable GraphQLStory graphQLStory) {
            if (graphQLStory != null) {
                ImmutableList j = StoryHierarchyHelper.m27434a(graphQLStory).m22608j();
                int size = j.size();
                for (int i = 0; i < size; i++) {
                    m26744a((GraphQLStory) j.get(i));
                }
                m26744a(graphQLStory.m22326L());
                for (int length = this.f19013b.length - 1; length >= 0; length--) {
                    this.f19013b[length].mo2180a(graphQLStory);
                }
            }
        }
    }

    public static FeedPrefetchLoader m16874a(InjectorLike injectorLike) {
        return new FeedPrefetchLoader(IdleExecutor_ForUiThreadMethodAutoProvider.m10033b(injectorLike), C0055x2995691a.m1881a(injectorLike), (FeedbackPrefetchPolicyProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedbackPrefetchPolicyProvider.class), (GraphQLPrefetcherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GraphQLPrefetcherProvider.class), (VideoPrefetchVisitorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoPrefetchVisitorProvider.class), CommentPrefetchExperimentController.m14352b(injectorLike), FeedbackPrefetcher.m14339a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), FeedbackPrefetchingExperiments.m14356b(injectorLike));
    }

    @Inject
    public FeedPrefetchLoader(DefaultProcessIdleExecutor defaultProcessIdleExecutor, ExecutorService executorService, FeedbackPrefetchPolicyProvider feedbackPrefetchPolicyProvider, GraphQLPrefetcherProvider graphQLPrefetcherProvider, VideoPrefetchVisitorProvider videoPrefetchVisitorProvider, CommentPrefetchExperimentController commentPrefetchExperimentController, FeedbackPrefetcher feedbackPrefetcher, QeAccessor qeAccessor, FeedbackPrefetchingExperiments feedbackPrefetchingExperiments) {
        this.f11555c = videoPrefetchVisitorProvider;
        this.f11560h = feedbackPrefetcher;
        this.f11561i = feedbackPrefetchingExperiments;
        if (this.f11561i.m14358b()) {
            this.f11554b = new FeedbackContextVisitorRefactor(this);
        } else {
            this.f11554b = new FeedbackContextVisitorNoRefactor(this, graphQLPrefetcherProvider.m14349a(feedbackPrefetchPolicyProvider.m14350a(Boolean.valueOf(false), Boolean.valueOf(false))), graphQLPrefetcherProvider.m14349a(feedbackPrefetchPolicyProvider.m14350a(Boolean.valueOf(true), Boolean.valueOf(false))));
        }
        this.f11553a = commentPrefetchExperimentController;
        this.f11556d = qeAccessor;
        this.f11557e = defaultProcessIdleExecutor;
        this.f11558f = executorService;
        this.f11559g = qeAccessor.mo596a(ExperimentsForNewsFeedAbTestModule.f5097X, false);
    }

    private PrefetchVisitorCollection m16873a() {
        if (this.f11562j == null) {
            this.f11562j = new PrefetchVisitorCollection(this, this.f11554b, this.f11555c.m16878a(VideoPrefetchLocation.NEWSFEED, CallerContext.m9060a(FeedPrefetchLoader.class)));
        }
        return this.f11562j;
    }

    public final void m16877a(final FetchFeedResult fetchFeedResult) {
        if (this.f11553a.f9396a.mo596a(ExperimentsForUfiServiceQeModule.f6625j, false)) {
            ExecutorDetour.a(this.f11558f, new Runnable(this) {
                final /* synthetic */ FeedPrefetchLoader f22515b;

                public void run() {
                    FeedPrefetchLoader.m16876b(this.f22515b, fetchFeedResult);
                }
            }, -292878816);
        } else if (this.f11559g) {
            this.f11557e.mo269a(new 2(this, fetchFeedResult));
        } else {
            m16876b(this, fetchFeedResult);
        }
    }

    public static void m16876b(FeedPrefetchLoader feedPrefetchLoader, FetchFeedResult fetchFeedResult) {
        TracerDetour.a("FeedPrefetchLoader.handleDataLoaded", 1013833778);
        if (fetchFeedResult == null) {
            TracerDetour.a(-1705455556);
            return;
        }
        try {
            GraphQLFeedHomeStories c = fetchFeedResult.m22438c();
            if (c == null || c.m22430k() == null) {
                TracerDetour.a(989827875);
                return;
            }
            feedPrefetchLoader.f11554b.m16880a(fetchFeedResult.freshness);
            ImmutableList k = c.m22430k();
            int size = k.size();
            for (int i = 0; i < size; i++) {
                m16875a((GraphQLFeedUnitEdge) k.get(i), feedPrefetchLoader.m16873a());
            }
            TracerDetour.a(-139463146);
        } catch (Throwable th) {
            TracerDetour.a(-990718708);
        }
    }

    private static void m16875a(GraphQLFeedUnitEdge graphQLFeedUnitEdge, GraphQLReadOnlyVisitor graphQLReadOnlyVisitor) {
        GraphQLVisitableModel c = graphQLFeedUnitEdge.mo2540c();
        if (c != null) {
            graphQLReadOnlyVisitor.mo2928b(c);
        }
    }
}
