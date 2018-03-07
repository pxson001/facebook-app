package com.facebook.reviews.event;

import com.facebook.content.event.FbEvent;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.reviews.protocol.graphql.PageReviewsFragmentsInterfaces.PageOverallStarRating.Histogram;
import com.facebook.reviews.protocol.graphql.PageReviewsFragmentsModels.PageOverallStarRatingModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.PlaceToReviewModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.UserReviewsModel.AuthoredReviewsModel.EdgesModel;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: profiles_tapped_count */
public class ReviewEvents {

    /* compiled from: profiles_tapped_count */
    public final class PageOverallRatingUpdatedEvent extends ReviewEvent {
        public final double f4946a;
        public final int f4947b;
        public final Optional<ImmutableList<? extends Histogram>> f4948c;
        public final String f4949d;

        public PageOverallRatingUpdatedEvent(PageOverallStarRatingModel pageOverallStarRatingModel, String str) {
            this(pageOverallStarRatingModel.d(), pageOverallStarRatingModel.b(), Optional.of(pageOverallStarRatingModel.a()), str);
        }

        private PageOverallRatingUpdatedEvent(double d, int i, Optional<ImmutableList<? extends Histogram>> optional, String str) {
            this.f4946a = d;
            this.f4947b = i;
            this.f4948c = optional;
            this.f4949d = str;
        }
    }

    /* compiled from: profiles_tapped_count */
    public abstract class PageOverallRatingUpdatedEventSubscriber extends ReviewEventSubscriber<PageOverallRatingUpdatedEvent> {
        public final Class<PageOverallRatingUpdatedEvent> m4877a() {
            return PageOverallRatingUpdatedEvent.class;
        }
    }

    /* compiled from: profiles_tapped_count */
    public final class ReviewFeedbackUpdatedEvent extends ReviewEvent {
        public final GraphQLFeedback f4950a;

        public ReviewFeedbackUpdatedEvent(GraphQLFeedback graphQLFeedback) {
            this.f4950a = graphQLFeedback;
        }
    }

    /* compiled from: profiles_tapped_count */
    public abstract class ReviewFeedbackUpdatedEventSubscriber extends ReviewEventSubscriber<ReviewFeedbackUpdatedEvent> {
        public final Class<ReviewFeedbackUpdatedEvent> m4878a() {
            return ReviewFeedbackUpdatedEvent.class;
        }
    }

    /* compiled from: profiles_tapped_count */
    public final class UserPlaceToReviewEvent extends ReviewEvent {
        public final String f4951a;
        public final PlaceToReviewModel f4952b;
        public final int f4953c;

        public UserPlaceToReviewEvent(int i, String str, @Nullable PlaceToReviewModel placeToReviewModel) {
            this.f4953c = i;
            this.f4951a = str;
            this.f4952b = placeToReviewModel;
        }
    }

    /* compiled from: profiles_tapped_count */
    public abstract class UserPlaceToReviewEventSubscriber extends ReviewEventSubscriber<UserPlaceToReviewEvent> {
        public abstract void mo1179a(String str, PlaceToReviewModel placeToReviewModel);

        public final void m4881b(FbEvent fbEvent) {
            UserPlaceToReviewEvent userPlaceToReviewEvent = (UserPlaceToReviewEvent) fbEvent;
            switch (userPlaceToReviewEvent.f4953c) {
                case 0:
                    mo1179a(userPlaceToReviewEvent.f4951a, userPlaceToReviewEvent.f4952b);
                    return;
                case 1:
                    return;
                default:
                    throw new IllegalArgumentException("No event type matches: " + userPlaceToReviewEvent.f4953c);
            }
        }

        public final Class<UserPlaceToReviewEvent> m4879a() {
            return UserPlaceToReviewEvent.class;
        }
    }

    /* compiled from: profiles_tapped_count */
    public final class UserReviewEvent extends ReviewEvent {
        public final String f4954a;
        public final EdgesModel f4955b;
        public final int f4956c;

        public UserReviewEvent(int i, String str, @Nullable EdgesModel edgesModel) {
            this.f4956c = i;
            this.f4954a = str;
            this.f4955b = edgesModel;
        }
    }

    /* compiled from: profiles_tapped_count */
    public abstract class UserReviewsEventSubscriber extends ReviewEventSubscriber<UserReviewEvent> {
        public abstract void mo1178a(String str, EdgesModel edgesModel);

        public final void m4884b(FbEvent fbEvent) {
            UserReviewEvent userReviewEvent = (UserReviewEvent) fbEvent;
            switch (userReviewEvent.f4956c) {
                case 0:
                    mo1178a(userReviewEvent.f4954a, userReviewEvent.f4955b);
                    return;
                case 1:
                    return;
                default:
                    throw new IllegalArgumentException("No event type matches: " + userReviewEvent.f4956c);
            }
        }

        public final Class<UserReviewEvent> m4882a() {
            return UserReviewEvent.class;
        }
    }

    /* compiled from: profiles_tapped_count */
    public final class ViewerReviewEvent extends ReviewEvent {
        public final String f4957a;
        public final ReviewWithFeedback f4958b;
        public Optional<GraphQLStory> f4959c = Absent.INSTANCE;
        public final int f4960d;

        public ViewerReviewEvent(int i, String str, @Nullable ReviewWithFeedback reviewWithFeedback) {
            this.f4960d = i;
            this.f4957a = str;
            this.f4958b = reviewWithFeedback;
        }
    }

    /* compiled from: profiles_tapped_count */
    public abstract class ViewerReviewEventSubscriber extends ReviewEventSubscriber<ViewerReviewEvent> {
        public abstract void mo1174a(String str);

        public abstract void mo1175a(String str, @Nullable ReviewWithFeedback reviewWithFeedback, @Nullable GraphQLStory graphQLStory);

        public final void m4888b(FbEvent fbEvent) {
            ViewerReviewEvent viewerReviewEvent = (ViewerReviewEvent) fbEvent;
            switch (viewerReviewEvent.f4960d) {
                case 0:
                    mo1175a(viewerReviewEvent.f4957a, viewerReviewEvent.f4958b, (GraphQLStory) viewerReviewEvent.f4959c.orNull());
                    return;
                case 1:
                    mo1174a(viewerReviewEvent.f4957a);
                    return;
                default:
                    throw new IllegalArgumentException("No event type matches: " + viewerReviewEvent.f4960d);
            }
        }

        public final Class<ViewerReviewEvent> m4885a() {
            return ViewerReviewEvent.class;
        }
    }

    public static ViewerReviewEvent m4890a(String str, @Nullable ReviewWithFeedback reviewWithFeedback) {
        return new ViewerReviewEvent(0, str, reviewWithFeedback);
    }

    public static ViewerReviewEvent m4889a(String str) {
        return new ViewerReviewEvent(1, str, null);
    }
}
