package com.facebook.pages.identity.cards.reviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.RequestedUnits;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageCardView;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.batching.PageCardsRenderScheduler;
import com.facebook.pages.identity.common.PageCardSpecifications.FetchType;
import com.facebook.pages.identity.common.PageCardSpecifications.PageBatchFetchingCardSpecification;
import com.facebook.pages.identity.common.PageViewPlaceHolder;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionQueryFragmentModel;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: pma_ */
public class PageIdentityReviewsCardSpecification implements PageBatchFetchingCardSpecification {
    private static final String f3693a = PageIdentityReviewsCardSpecification.class.getSimpleName();
    public FbFragment f3694b;
    private final ExecutorService f3695c;
    private final Lazy<FbErrorReporter> f3696d;
    private final ReactionUtil f3697e;
    public final ReactionSessionManager f3698f;
    private long f3699g;
    private String f3700h;
    public final Surface f3701i = Surface.ANDROID_PAGE_SINGLE_CARD;
    private final ImmutableList<RequestedUnits> f3702j = ImmutableList.of(RequestedUnits.REVIEWS);
    public ReactionQueryParams f3703k;

    public static PageIdentityReviewsCardSpecification m4703b(InjectorLike injectorLike) {
        return new PageIdentityReviewsCardSpecification((ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), ReactionUtil.a(injectorLike), ReactionSessionManager.a(injectorLike));
    }

    public static PageIdentityReviewsCardSpecification m4702a(InjectorLike injectorLike) {
        return m4703b(injectorLike);
    }

    @Inject
    public PageIdentityReviewsCardSpecification(ExecutorService executorService, Lazy<FbErrorReporter> lazy, ReactionUtil reactionUtil, ReactionSessionManager reactionSessionManager) {
        this.f3695c = executorService;
        this.f3696d = lazy;
        this.f3697e = reactionUtil;
        this.f3698f = reactionSessionManager;
    }

    public final boolean mo77a() {
        return true;
    }

    public final Optional<? extends ListenableFuture<? extends GraphQLResult<?>>> mo81a(long j, GraphQLBatchRequest graphQLBatchRequest, final PageViewPlaceHolder pageViewPlaceHolder, final Context context, LayoutInflater layoutInflater, PageHeaderData pageHeaderData, GraphQLCachePolicy graphQLCachePolicy, final PageCardsRenderScheduler pageCardsRenderScheduler) {
        FetchPageHeaderQueryModel fetchPageHeaderQueryModel = pageHeaderData.e;
        if (!fetchPageHeaderQueryModel.r() || !fetchPageHeaderQueryModel.W()) {
            return Absent.withType();
        }
        this.f3699g = j;
        this.f3700h = SafeUUIDGenerator.a().toString();
        ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
        reactionQueryParams.l = Long.valueOf(this.f3699g);
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.t = Long.valueOf(this.f3699g);
        this.f3703k = reactionQueryParams.b(this.f3702j);
        GraphQLRequest e = m4704e();
        if (e == null) {
            ((AbstractFbErrorReporter) this.f3696d.get()).a(f3693a, "Invalid GraphQL request to fetch Reaction data.");
            return Absent.withType();
        }
        e.a(graphQLCachePolicy);
        ListenableFuture b = graphQLBatchRequest.b(e);
        Futures.a(b, new FutureCallback<GraphQLResult<?>>(this) {
            final /* synthetic */ PageIdentityReviewsCardSpecification f3692d;

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null && graphQLResult.e != null) {
                    final ReactionSession a = this.f3692d.f3698f.a(this.f3692d.f3703k, ((ReactionQueryFragmentModel) graphQLResult.e).j(), this.f3692d.f3701i);
                    pageCardsRenderScheduler.m4244a(this.f3692d.mo79b(), new Runnable(this) {
                        final /* synthetic */ C05061 f3688b;

                        public void run() {
                            View view = pageViewPlaceHolder.f3791d;
                            if (view == null) {
                                view = new PageIdentityReactionReviewsCardViewContainer(context, this.f3688b.f3692d.f3694b).m4688a(a);
                                if (view != null) {
                                    pageViewPlaceHolder.m4758a(view);
                                    return;
                                }
                                return;
                            }
                            new PageIdentityReactionReviewsCardViewContainer(context, this.f3688b.f3692d.f3694b).m4689a(a, (ViewGroup) view);
                        }
                    });
                }
            }

            public void onFailure(Throwable th) {
            }
        }, this.f3695c);
        return Optional.of(b);
    }

    public final PageCardView mo76a(LayoutInflater layoutInflater, Context context) {
        return null;
    }

    public final PageCardType mo79b() {
        return PageCardType.REVIEWS;
    }

    public final FetchType mo80c() {
        return FetchType.SECONDARY;
    }

    private GraphQLRequest<?> m4704e() {
        return this.f3697e.b(this.f3703k, this.f3700h, this.f3701i);
    }

    public final void m4707a(FbFragment fbFragment) {
        this.f3694b = fbFragment;
    }
}
