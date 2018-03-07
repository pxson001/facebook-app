package com.facebook.reviews.feed;

import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.reviews.controller.ReviewStoriesFeedController;
import com.facebook.reviews.event.ReviewEvents.PageOverallRatingUpdatedEvent;
import com.facebook.reviews.feed.ReviewsFeedComposerLauncherAndHandler.C23043;
import com.facebook.reviews.protocol.graphql.PageReviewsFragmentsModels.PageOverallStarRatingModel;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQuery.OverallRatingAndViewerReviewStoryString;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQuery.ReviewsFeedHeaderString;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQuery.ReviewsFeedStoriesString;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQueryModels.OverallRatingAndViewerReviewStoryModel;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQueryModels.ReviewsFeedHeaderModel;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQueryModels.ReviewsFeedStoriesModel;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQueryModels.ReviewsFeedStoriesModel.ReviewFeedStoriesModel;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Trying to open structured menu but no menu is available */
public class ReviewsFeedLoader {
    private final GraphQLQueryExecutor f21566a;
    public final TasksManager<String> f21567b;
    private final ViewerContextManager f21568c;
    private final Product f21569d;

    public static ReviewsFeedLoader m25123b(InjectorLike injectorLike) {
        return new ReviewsFeedLoader(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), ViewerContextManagerProvider.b(injectorLike), ProductMethodAutoProvider.b(injectorLike));
    }

    public final void m25125a(String str, final ReviewStoriesFeedController reviewStoriesFeedController) {
        GraphQlQueryString reviewsFeedHeaderString = new ReviewsFeedHeaderString();
        reviewsFeedHeaderString.a("page_id", str);
        GraphQLRequest a = GraphQLRequest.a(reviewsFeedHeaderString);
        m25122a(a);
        this.f21567b.a("key_load_feed_header" + str, this.f21566a.a(a), new AbstractDisposableFutureCallback<GraphQLResult<ReviewsFeedHeaderModel>>(this) {
            final /* synthetic */ ReviewsFeedLoader f21559b;

            protected final void m25116a(@Nullable Object obj) {
                ReviewsFeedHeaderModel reviewsFeedHeaderModel;
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                ReviewStoriesFeedController reviewStoriesFeedController = reviewStoriesFeedController;
                if (graphQLResult == null) {
                    reviewsFeedHeaderModel = null;
                } else {
                    reviewsFeedHeaderModel = (ReviewsFeedHeaderModel) graphQLResult.e;
                }
                reviewStoriesFeedController.m25084a(reviewsFeedHeaderModel, false);
            }

            protected final void m25117a(Throwable th) {
                ReviewStoriesFeedController reviewStoriesFeedController = reviewStoriesFeedController;
                reviewStoriesFeedController.f21504k = false;
                reviewStoriesFeedController.f21505l.av();
                reviewStoriesFeedController.f21500g.e(reviewStoriesFeedController.f21513t);
                reviewStoriesFeedController.f21502i.a(new ToastBuilder(2131235346));
            }
        });
    }

    @Inject
    public ReviewsFeedLoader(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, ViewerContextManager viewerContextManager, Product product) {
        this.f21566a = graphQLQueryExecutor;
        this.f21567b = tasksManager;
        this.f21568c = viewerContextManager;
        this.f21569d = product;
    }

    private void m25122a(GraphQLRequest graphQLRequest) {
        if (this.f21569d != Product.PAA) {
            graphQLRequest.s = this.f21568c.a();
        }
    }

    public final void m25124a(String str, int i, final ReviewStoriesFeedController reviewStoriesFeedController, @Nullable String str2) {
        GraphQlQueryString reviewsFeedStoriesString = new ReviewsFeedStoriesString();
        reviewsFeedStoriesString.a("page_id", str);
        reviewsFeedStoriesString.a("story_count", Integer.valueOf(i));
        reviewsFeedStoriesString.a("feed_story_attachments_location", "reviews_feed");
        reviewsFeedStoriesString.a("last_cursor", str2);
        reviewsFeedStoriesString.a("action_links_location", "reviews_feed");
        GraphQLRequest a = GraphQLRequest.a(reviewsFeedStoriesString);
        m25122a(a);
        final GraphQLQueryFuture a2 = this.f21566a.a(a);
        this.f21567b.a("key_load_review_stories" + str, new Callable<ListenableFuture<GraphQLResult<ReviewsFeedStoriesModel>>>(this) {
            final /* synthetic */ ReviewsFeedLoader f21563b;

            public Object call() {
                return a2;
            }
        }, new AbstractDisposableFutureCallback<GraphQLResult<ReviewsFeedStoriesModel>>(this) {
            final /* synthetic */ ReviewsFeedLoader f21565b;

            protected final void m25120a(@Nullable Object obj) {
                ReviewFeedStoriesModel reviewFeedStoriesModel;
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                ReviewStoriesFeedController reviewStoriesFeedController = reviewStoriesFeedController;
                if (graphQLResult == null || graphQLResult.e == null) {
                    reviewFeedStoriesModel = null;
                } else {
                    reviewFeedStoriesModel = ((ReviewsFeedStoriesModel) graphQLResult.e).a();
                }
                reviewStoriesFeedController.m25085a(reviewFeedStoriesModel);
            }

            protected final void m25121a(Throwable th) {
                ReviewStoriesFeedController reviewStoriesFeedController = reviewStoriesFeedController;
                reviewStoriesFeedController.f21502i.a(new ToastBuilder(2131235346));
                reviewStoriesFeedController.f21504k = false;
                reviewStoriesFeedController.f21505l.ay();
                reviewStoriesFeedController.f21500g.c(reviewStoriesFeedController.f21513t);
            }
        });
    }

    public final void m25126a(String str, final C23043 c23043) {
        GraphQlQueryString overallRatingAndViewerReviewStoryString = new OverallRatingAndViewerReviewStoryString();
        overallRatingAndViewerReviewStoryString.a("page_id", str);
        overallRatingAndViewerReviewStoryString.a("feed_story_attachments_location", "reviews_feed");
        GraphQLRequest a = GraphQLRequest.a(overallRatingAndViewerReviewStoryString);
        m25122a(a);
        this.f21567b.a("key_overall_rating_and_viewer_review" + str, this.f21566a.a(a), new AbstractDisposableFutureCallback<GraphQLResult<OverallRatingAndViewerReviewStoryModel>>(this) {
            final /* synthetic */ ReviewsFeedLoader f21561b;

            protected final void m25118a(@Nullable Object obj) {
                PageOverallStarRatingModel pageOverallStarRatingModel;
                GraphQLStory graphQLStory;
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null) {
                    pageOverallStarRatingModel = null;
                } else {
                    pageOverallStarRatingModel = ((OverallRatingAndViewerReviewStoryModel) graphQLResult.e).a();
                }
                if (graphQLResult == null || graphQLResult.e == null || ((OverallRatingAndViewerReviewStoryModel) graphQLResult.e).j() == null) {
                    graphQLStory = null;
                } else {
                    graphQLStory = ((OverallRatingAndViewerReviewStoryModel) graphQLResult.e).j().a();
                }
                GraphQLStory graphQLStory2 = graphQLStory;
                C23043 c23043 = c23043;
                if (pageOverallStarRatingModel != null) {
                    c23043.f21542c.f21547e.a(new PageOverallRatingUpdatedEvent(pageOverallStarRatingModel, c23043.f21540a));
                }
                ReviewsFeedComposerLauncherAndHandler.m25111a(c23043.f21542c, c23043.f21540a, c23043.f21541b, Optional.fromNullable(graphQLStory2));
            }

            protected final void m25119a(Throwable th) {
                C23043 c23043 = c23043;
                ReviewsFeedComposerLauncherAndHandler.m25111a(c23043.f21542c, c23043.f21540a, c23043.f21541b, (Optional) Absent.INSTANCE);
            }
        });
    }
}
