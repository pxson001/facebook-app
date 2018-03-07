package com.facebook.pages.identity.batching;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.time.Clock;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.Assisted;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.fb4a.data.graphql.story.PageStoryGraphQL.PageStoryCardsQueryString;
import com.facebook.pages.fb4a.data.graphql.story.PageStoryGraphQLModels.PageStoryCardsQueryModel;
import com.facebook.pages.fb4a.data.graphql.story.PageStoryGraphQLModels.PageStoryCardsQueryModel.CouponsModel.NodesModel;
import com.facebook.pages.identity.cards.reviews.PageIdentityReviewsCardSpecification;
import com.facebook.pages.identity.common.PageCardSpecifications.PageBatchFetchingCardSpecification;
import com.facebook.pages.identity.common.PageViewPlaceHolder;
import com.facebook.pages.identity.timeline.PageIdentityInfinitePostsTimelineFragment;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.story.GraphQLStoryHelper;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: privacy_review_core_event */
public class PageCardsBatchingFetcher {
    private final Context f3149a;
    private final LayoutInflater f3150b;
    private final long f3151c;
    private final Map<PageCardType, PageViewPlaceHolder> f3152d;
    private final GraphQLQueryExecutor f3153e;
    private final FbAndroidBatchedCardsProvider f3154f;
    private final GraphQLStoryHelper f3155g;
    private final SizeAwareImageUtil f3156h;
    private final GraphQLImageHelper f3157i;
    private final ExecutorService f3158j;
    private final PagesAnalytics f3159k;
    private final PageCardsRenderSchedulerProvider f3160l;
    public final Clock f3161m;
    private boolean f3162n = false;

    @Inject
    public PageCardsBatchingFetcher(@Assisted Context context, @Assisted LayoutInflater layoutInflater, @Assisted Long l, @Assisted Map<PageCardType, PageViewPlaceHolder> map, GraphQLQueryExecutor graphQLQueryExecutor, FbAndroidBatchedCardsProvider fbAndroidBatchedCardsProvider, GraphQLStoryHelper graphQLStoryHelper, SizeAwareImageUtil sizeAwareImageUtil, GraphQLImageHelper graphQLImageHelper, ExecutorService executorService, PagesAnalytics pagesAnalytics, PageCardsRenderSchedulerProvider pageCardsRenderSchedulerProvider, Clock clock) {
        this.f3149a = context;
        this.f3150b = layoutInflater;
        this.f3151c = l.longValue();
        this.f3152d = map;
        this.f3153e = graphQLQueryExecutor;
        this.f3154f = fbAndroidBatchedCardsProvider;
        this.f3155g = graphQLStoryHelper;
        this.f3156h = sizeAwareImageUtil;
        this.f3157i = graphQLImageHelper;
        this.f3158j = executorService;
        this.f3159k = pagesAnalytics;
        this.f3160l = pageCardsRenderSchedulerProvider;
        this.f3161m = clock;
    }

    public final ListenableFuture<Boolean> m4238a(PageHeaderData pageHeaderData, PageIdentityInfinitePostsTimelineFragment pageIdentityInfinitePostsTimelineFragment, GraphQLCachePolicy graphQLCachePolicy, FbFragment fbFragment) {
        return m4236a(pageHeaderData, this.f3154f.f3146a, pageIdentityInfinitePostsTimelineFragment, graphQLCachePolicy, fbFragment);
    }

    public final ListenableFuture<Boolean> m4239a(PageHeaderData pageHeaderData, List<PageBatchFetchingCardSpecification> list, GraphQLCachePolicy graphQLCachePolicy, FbFragment fbFragment) {
        return m4236a(pageHeaderData, list, null, graphQLCachePolicy, fbFragment);
    }

    private ListenableFuture<Boolean> m4236a(PageHeaderData pageHeaderData, List<PageBatchFetchingCardSpecification> list, @Nullable PageIdentityInfinitePostsTimelineFragment pageIdentityInfinitePostsTimelineFragment, GraphQLCachePolicy graphQLCachePolicy, FbFragment fbFragment) {
        PageCardsRenderScheduler a = this.f3160l.m4245a(((PageBatchFetchingCardSpecification) list.get(0)).mo79b(), Boolean.valueOf(graphQLCachePolicy == GraphQLCachePolicy.d));
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("PageSecondaryCardsBatchRequest");
        Builder builder = new Builder();
        for (PageBatchFetchingCardSpecification pageBatchFetchingCardSpecification : list) {
            if (pageBatchFetchingCardSpecification.mo77a()) {
                PageViewPlaceHolder pageViewPlaceHolder = (PageViewPlaceHolder) this.f3152d.get(pageBatchFetchingCardSpecification.mo79b());
                Preconditions.checkArgument(pageViewPlaceHolder != null);
                if (pageBatchFetchingCardSpecification instanceof PageIdentityReviewsCardSpecification) {
                    ((PageIdentityReviewsCardSpecification) pageBatchFetchingCardSpecification).m4707a(fbFragment);
                }
                Optional a2 = pageBatchFetchingCardSpecification.mo81a(this.f3151c, graphQLBatchRequest, pageViewPlaceHolder, this.f3149a, this.f3150b, pageHeaderData, graphQLCachePolicy, a);
                if (a2.isPresent()) {
                    builder.c(a2.get());
                }
            }
        }
        m4237a(graphQLBatchRequest, pageIdentityInfinitePostsTimelineFragment, pageHeaderData.g().y(), graphQLCachePolicy);
        this.f3153e.a(graphQLBatchRequest);
        return a.m4242a(builder);
    }

    private void m4237a(GraphQLBatchRequest graphQLBatchRequest, @Nullable final PageIdentityInfinitePostsTimelineFragment pageIdentityInfinitePostsTimelineFragment, boolean z, GraphQLCachePolicy graphQLCachePolicy) {
        if (z && pageIdentityInfinitePostsTimelineFragment != null) {
            GraphQlQueryString pageStoryCardsQueryString = new PageStoryCardsQueryString();
            pageStoryCardsQueryString.a("page_id", String.valueOf(this.f3151c)).a("angora_attachment_cover_image_size", this.f3155g.r()).a("angora_attachment_profile_image_size", GraphQLStoryHelper.a()).a("image_large_aspect_height", this.f3155g.z()).a("image_large_aspect_width", this.f3155g.y());
            this.f3156h.a(pageStoryCardsQueryString, this.f3157i.c());
            GraphQLRequest a = GraphQLRequest.a(pageStoryCardsQueryString).a(graphQLCachePolicy);
            a.e = ImmutableSet.of("GraphQlPageCardTag");
            Futures.a(graphQLBatchRequest.b(a), new FutureCallback<GraphQLResult<PageStoryCardsQueryModel>>(this) {
                final /* synthetic */ PageCardsBatchingFetcher f3148b;

                public void onSuccess(@Nullable Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    GraphQLStory graphQLStory = null;
                    if (graphQLResult != null && graphQLResult.e != null) {
                        GraphQLStory j;
                        int i;
                        PageStoryCardsQueryModel pageStoryCardsQueryModel = (PageStoryCardsQueryModel) graphQLResult.e;
                        if (pageStoryCardsQueryModel.m3954j() != null) {
                            j = pageStoryCardsQueryModel.m3954j();
                            FetchTimeMsHelper.a(j, this.f3148b.f3161m.a());
                        } else {
                            j = null;
                        }
                        PageCardsBatchingFetcher pageCardsBatchingFetcher = this.f3148b;
                        if (pageStoryCardsQueryModel.m3951a() == null || pageStoryCardsQueryModel.m3951a().m3945a().isEmpty() || ((NodesModel) pageStoryCardsQueryModel.m3951a().m3945a().get(0)).m3938a() == null) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                        if (i != 0) {
                            graphQLStory = ((NodesModel) pageStoryCardsQueryModel.m3951a().m3945a().get(0)).m3938a();
                            FetchTimeMsHelper.a(graphQLStory, this.f3148b.f3161m.a());
                        }
                        pageIdentityInfinitePostsTimelineFragment.m5134a(j, graphQLStory);
                    }
                }

                public void onFailure(Throwable th) {
                }
            }, this.f3158j);
        }
    }
}
