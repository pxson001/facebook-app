package com.facebook.reviews.feed;

import com.facebook.api.feedcache.memory.FeedUnitTagHelper;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams.Builder;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents.StoryDeleteEvent;
import com.facebook.feed.util.event.HideEvents.StoryDeleteEventSubscriber;
import com.facebook.feedback.ui.FeedbackController;
import com.facebook.feedback.ui.FeedbackControllerParams;
import com.facebook.feedback.ui.FeedbackControllerProvider;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.reviews.controller.ReviewStoriesFeedController;
import com.facebook.reviews.environment.ReviewsFeedEnvironment;
import com.facebook.reviews.event.ReviewEventBus;
import com.facebook.reviews.event.ReviewEvents.PageOverallRatingUpdatedEvent;
import com.facebook.reviews.event.ReviewEvents.PageOverallRatingUpdatedEventSubscriber;
import com.facebook.reviews.event.ReviewEvents.ViewerReviewEventSubscriber;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQueryModels.ReviewsFeedStoriesModel.ReviewFeedStoriesModel;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQueryModels.ReviewsFeedStoriesModel.ReviewFeedStoriesModel.EdgesModel;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEvent;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEventSubscriber;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Triggers Firing Page */
public class ReviewsFeedSubscriber {
    public final FeedbackController f21599a;
    public final FeedEventBus f21600b;
    public final GraphQLSubscriptionHolder f21601c;
    private final Clock f21602d;
    public final ReviewEventBus f21603e;
    public final FbEventSubscriberListManager f21604f;
    public Optional<FbEventSubscriberListManager> f21605g = Absent.INSTANCE;

    public static ReviewsFeedSubscriber m25148b(InjectorLike injectorLike) {
        return new ReviewsFeedSubscriber((Clock) SystemClockMethodAutoProvider.a(injectorLike), (FeedbackControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedbackControllerProvider.class), FeedEventBus.a(injectorLike), GraphQLSubscriptionHolder.b(injectorLike), ReviewEventBus.m4876a(injectorLike), FbEventSubscriberListManager.a(injectorLike));
    }

    @Inject
    public ReviewsFeedSubscriber(Clock clock, FeedbackControllerProvider feedbackControllerProvider, FeedEventBus feedEventBus, GraphQLSubscriptionHolder graphQLSubscriptionHolder, ReviewEventBus reviewEventBus, FbEventSubscriberListManager fbEventSubscriberListManager) {
        this.f21602d = clock;
        this.f21599a = feedbackControllerProvider.a(FeedbackControllerParams.a);
        this.f21600b = feedEventBus;
        this.f21601c = graphQLSubscriptionHolder;
        this.f21603e = reviewEventBus;
        this.f21604f = fbEventSubscriberListManager;
    }

    public final void m25149a(ReviewFeedStoriesModel reviewFeedStoriesModel, ReviewsFeedEnvironment reviewsFeedEnvironment, ReviewsItemCollection reviewsItemCollection) {
        for (int i = 0; i < reviewFeedStoriesModel.a().size(); i++) {
            GraphQLStory a = ((EdgesModel) reviewFeedStoriesModel.a().get(i)).a();
            if (a != null) {
                m25146a(a, reviewsFeedEnvironment, reviewsItemCollection);
            }
        }
    }

    private void m25146a(GraphQLStory graphQLStory, final ReviewsFeedEnvironment reviewsFeedEnvironment, final ReviewsItemCollection reviewsItemCollection) {
        this.f21601c.a(new FutureCallback<GraphQLResult<GraphQLStory>>(this) {
            final /* synthetic */ ReviewsFeedSubscriber f21585c;

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null && graphQLResult.e != null) {
                    reviewsItemCollection.m25156b((GraphQLStory) graphQLResult.e);
                    reviewsFeedEnvironment.hL_();
                }
            }

            public void onFailure(Throwable th) {
            }
        }, graphQLStory.c(), this.f21601c.a(graphQLStory, DataFreshnessResult.FROM_SERVER, this.f21602d.a(), FeedUnitTagHelper.a(graphQLStory, false)));
    }

    public final void m25150a(final String str, final ReviewsFeedEnvironment reviewsFeedEnvironment, final ReviewsItemCollection reviewsItemCollection, final ReviewStoriesFeedController reviewStoriesFeedController) {
        this.f21605g = Optional.of(new FbEventSubscriberListManager());
        FbEventSubscriberListManager fbEventSubscriberListManager = (FbEventSubscriberListManager) this.f21605g.get();
        fbEventSubscriberListManager.a(new LikeClickedEventSubscriber(this) {
            final /* synthetic */ ReviewsFeedSubscriber f21595b;

            public final void m25144b(FbEvent fbEvent) {
                GraphQLStory a = reviewsItemCollection.m25153a(((LikeClickedEvent) fbEvent).a);
                if (a != null) {
                    Builder builder = new Builder();
                    builder.c = "reviews_feed";
                    this.f21595b.f21599a.a(a.l(), builder.a());
                }
            }
        });
        fbEventSubscriberListManager.a(new StoryDeleteEventSubscriber(this) {
            final /* synthetic */ ReviewsFeedSubscriber f21598c;

            public final void m25145b(FbEvent fbEvent) {
                reviewsItemCollection.m25157c(((StoryDeleteEvent) fbEvent).a());
                reviewsFeedEnvironment.hL_();
            }
        });
        fbEventSubscriberListManager.a(this.f21600b);
        final String str2 = str;
        final ReviewsFeedEnvironment reviewsFeedEnvironment2 = reviewsFeedEnvironment;
        final ReviewsItemCollection reviewsItemCollection2 = reviewsItemCollection;
        final ReviewStoriesFeedController reviewStoriesFeedController2 = reviewStoriesFeedController;
        this.f21604f.a(new ViewerReviewEventSubscriber(this) {
            final /* synthetic */ ReviewsFeedSubscriber f21590e;

            public final void mo1175a(String str, @Nullable ReviewWithFeedback reviewWithFeedback, @Nullable GraphQLStory graphQLStory) {
                if (!str2.equals(str)) {
                    return;
                }
                if (graphQLStory == null || Strings.isNullOrEmpty(graphQLStory.c())) {
                    reviewStoriesFeedController2.m25086f();
                } else {
                    ReviewsFeedSubscriber.m25147a(this.f21590e, graphQLStory, reviewsFeedEnvironment2, reviewsItemCollection2, reviewStoriesFeedController2);
                }
            }

            public final void mo1174a(String str) {
            }
        });
        this.f21604f.a(new PageOverallRatingUpdatedEventSubscriber(this) {
            final /* synthetic */ ReviewsFeedSubscriber f21593c;

            public final void m25143b(FbEvent fbEvent) {
                PageOverallRatingUpdatedEvent pageOverallRatingUpdatedEvent = (PageOverallRatingUpdatedEvent) fbEvent;
                if (!str.equals(pageOverallRatingUpdatedEvent.f4949d)) {
                    return;
                }
                if (pageOverallRatingUpdatedEvent.f4948c.isPresent()) {
                    reviewStoriesFeedController.m25082a(pageOverallRatingUpdatedEvent.f4946a, pageOverallRatingUpdatedEvent.f4947b, (ImmutableList) pageOverallRatingUpdatedEvent.f4948c.get());
                } else {
                    reviewStoriesFeedController.m25086f();
                }
            }
        });
        this.f21604f.a(this.f21603e);
    }

    public static void m25147a(ReviewsFeedSubscriber reviewsFeedSubscriber, GraphQLStory graphQLStory, ReviewsFeedEnvironment reviewsFeedEnvironment, ReviewsItemCollection reviewsItemCollection, ReviewStoriesFeedController reviewStoriesFeedController) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(graphQLStory.c()), "New story argument must have an id");
        GraphQLStory.Builder a = GraphQLStory.Builder.a(graphQLStory);
        a.F = reviewsFeedSubscriber.f21602d.a();
        GraphQLStory a2 = a.a();
        if (reviewsItemCollection.f21608c.containsKey(a2.c())) {
            reviewsItemCollection.m25156b(a2);
        } else {
            reviewsItemCollection.m25155a(a2);
            reviewsFeedSubscriber.m25146a(a2, reviewsFeedEnvironment, reviewsItemCollection);
            reviewStoriesFeedController.m25087g();
        }
        reviewsFeedEnvironment.hL_();
    }
}
