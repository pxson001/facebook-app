package com.facebook.pages.identity.cards.reviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageCardView;
import com.facebook.pages.data.graphql.cards.AttributionEntryConversionHelper;
import com.facebook.pages.data.graphql.cards.ReviewNeedyPlaceCardGraphQL.ReviewNeedyPlaceCardQueryString;
import com.facebook.pages.data.graphql.cards.ReviewNeedyPlaceCardGraphQLModels.ReviewNeedyPlaceCardQueryModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.batching.PageCardsRenderScheduler;
import com.facebook.pages.identity.common.PageCardSpecifications.FetchType;
import com.facebook.pages.identity.common.PageCardSpecifications.PageBatchFetchingCardSpecification;
import com.facebook.pages.identity.common.PageViewPlaceHolder;
import com.facebook.reviews.util.helper.ReviewsGraphQLHelper;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: post_age */
public class PageIdentityReviewNeedyPlaceCardSpecification implements PageBatchFetchingCardSpecification {
    private final ExecutorService f3672a;

    public static PageIdentityReviewNeedyPlaceCardSpecification m4692b(InjectorLike injectorLike) {
        return new PageIdentityReviewNeedyPlaceCardSpecification((ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    public static PageIdentityReviewNeedyPlaceCardSpecification m4691a(InjectorLike injectorLike) {
        return m4692b(injectorLike);
    }

    @Inject
    public PageIdentityReviewNeedyPlaceCardSpecification(ExecutorService executorService) {
        this.f3672a = executorService;
    }

    private static GraphQLRequest<ReviewNeedyPlaceCardQueryModel> m4690a(long j) {
        GraphQLRequest a = GraphQLRequest.a((ReviewNeedyPlaceCardQueryString) new ReviewNeedyPlaceCardQueryString().a("page_id", String.valueOf(j)));
        a.e = ImmutableSet.of("GraphQlPageCardTag");
        return a.a(RequestPriority.INTERACTIVE);
    }

    public final Optional<ListenableFuture<GraphQLResult<ReviewNeedyPlaceCardQueryModel>>> mo81a(long j, GraphQLBatchRequest graphQLBatchRequest, PageViewPlaceHolder pageViewPlaceHolder, Context context, LayoutInflater layoutInflater, PageHeaderData pageHeaderData, GraphQLCachePolicy graphQLCachePolicy, PageCardsRenderScheduler pageCardsRenderScheduler) {
        if (!pageHeaderData.g().r() || !pageHeaderData.g().W()) {
            return Absent.withType();
        }
        GraphQLRequest a = m4690a(j);
        if (a == null) {
            return Absent.withType();
        }
        a.a(graphQLCachePolicy);
        ListenableFuture b = graphQLBatchRequest.b(a);
        final PageViewPlaceHolder pageViewPlaceHolder2 = pageViewPlaceHolder;
        final LayoutInflater layoutInflater2 = layoutInflater;
        final Context context2 = context;
        final long j2 = j;
        final PageHeaderData pageHeaderData2 = pageHeaderData;
        final PageCardsRenderScheduler pageCardsRenderScheduler2 = pageCardsRenderScheduler;
        Futures.a(b, new FutureCallback<GraphQLResult<ReviewNeedyPlaceCardQueryModel>>(this) {
            final /* synthetic */ PageIdentityReviewNeedyPlaceCardSpecification f3671g;

            public void onSuccess(@Nullable Object obj) {
                Object obj2;
                final GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null || ((ReviewNeedyPlaceCardQueryModel) graphQLResult.e).j() == null || ((ReviewNeedyPlaceCardQueryModel) graphQLResult.e).j().j() == null || StringUtil.a(((ReviewNeedyPlaceCardQueryModel) graphQLResult.e).j().j().a())) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (obj2 == null) {
                    View view = pageViewPlaceHolder2.f3791d;
                    if (view != null) {
                        view.setVisibility(8);
                        return;
                    }
                    return;
                }
                pageCardsRenderScheduler2.m4244a(this.f3671g.mo79b(), new Runnable(this) {
                    final /* synthetic */ C05021 f3664b;

                    public void run() {
                        int i;
                        GraphQLPrivacyOption graphQLPrivacyOption;
                        View view = pageViewPlaceHolder2.f3791d;
                        if (view == null) {
                            view = (View) this.f3664b.f3671g.mo76a(layoutInflater2, context2);
                            pageViewPlaceHolder2.m4758a(view);
                        }
                        view.setVisibility(0);
                        PageIdentityReviewNeedyPlaceCardView pageIdentityReviewNeedyPlaceCardView = (PageIdentityReviewNeedyPlaceCardView) view;
                        ReviewNeedyPlaceCardQueryModel reviewNeedyPlaceCardQueryModel = (ReviewNeedyPlaceCardQueryModel) graphQLResult.e;
                        long j = j2;
                        String D = pageHeaderData2.e.D();
                        pageIdentityReviewNeedyPlaceCardView.f3685k = Long.valueOf(j);
                        pageIdentityReviewNeedyPlaceCardView.f3686l = D;
                        pageIdentityReviewNeedyPlaceCardView.f3681g.setText(reviewNeedyPlaceCardQueryModel.a().b().a());
                        if (reviewNeedyPlaceCardQueryModel.a().a() != null) {
                            pageIdentityReviewNeedyPlaceCardView.f3682h.a(AttributionEntryConversionHelper.a(reviewNeedyPlaceCardQueryModel.a().a()), (float) pageIdentityReviewNeedyPlaceCardView.getResources().getDimensionPixelSize(2131427402), 0);
                        }
                        if (reviewNeedyPlaceCardQueryModel.b() == null) {
                            i = 0;
                        } else {
                            i = reviewNeedyPlaceCardQueryModel.b().b();
                        }
                        pageIdentityReviewNeedyPlaceCardView.f3684j = i;
                        if (reviewNeedyPlaceCardQueryModel.b() == null) {
                            graphQLPrivacyOption = null;
                        } else {
                            graphQLPrivacyOption = ReviewsGraphQLHelper.c(reviewNeedyPlaceCardQueryModel.b());
                        }
                        pageIdentityReviewNeedyPlaceCardView.f3683i = graphQLPrivacyOption;
                        pageIdentityReviewNeedyPlaceCardView.f3678d.setRating(pageIdentityReviewNeedyPlaceCardView.f3684j);
                        int i2 = 0;
                        pageIdentityReviewNeedyPlaceCardView.f3679e.setVisibility(pageIdentityReviewNeedyPlaceCardView.f3684j == 0 ? 0 : 8);
                        TextView textView = pageIdentityReviewNeedyPlaceCardView.f3680f;
                        if (pageIdentityReviewNeedyPlaceCardView.f3684j == 0) {
                            i2 = 8;
                        }
                        textView.setVisibility(i2);
                    }
                });
            }

            public void onFailure(Throwable th) {
            }
        }, this.f3672a);
        return Optional.of(b);
    }

    public final boolean mo77a() {
        return true;
    }

    public final PageCardView mo76a(LayoutInflater layoutInflater, Context context) {
        return new PageIdentityReviewNeedyPlaceCardView(context, null, 2130773402);
    }

    public final PageCardType mo79b() {
        return PageCardType.REVIEW_NEEDY_PLACE_CARD;
    }

    public final FetchType mo80c() {
        return FetchType.SECONDARY;
    }
}
