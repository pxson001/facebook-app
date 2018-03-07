package com.facebook.reviews.util.helper;

import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewWithFeedbackModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.UserReviewsModel.AuthoredReviewsModel.EdgesModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.UserReviewsModel.AuthoredReviewsModel.EdgesModel.Builder;

/* compiled from: profile_video_model */
public class AuthoredReviewsMutator {
    public static EdgesModel m4907a(EdgesModel edgesModel, ReviewWithFeedback reviewWithFeedback) {
        Builder builder = new Builder();
        builder = Builder.a(EdgesModel.a(edgesModel));
        builder.b = ReviewWithFeedbackModel.a(reviewWithFeedback);
        return builder.a();
    }
}
