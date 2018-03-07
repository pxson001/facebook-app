package com.facebook.reviews.util;

import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewWithFeedbackModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewWithFeedbackModel.Builder;

/* compiled from: profiles_appeared_count */
public class ReviewWithFeedbackMutator {
    public static ReviewWithFeedback m4906a(ReviewWithFeedback reviewWithFeedback, GraphQLFeedback graphQLFeedback) {
        if (reviewWithFeedback == null) {
            return null;
        }
        Builder builder = new Builder();
        builder = Builder.a(ReviewWithFeedbackModel.a(reviewWithFeedback));
        builder.c = DefaultGraphQLConversionHelper.a(graphQLFeedback);
        return builder.a();
    }
}
