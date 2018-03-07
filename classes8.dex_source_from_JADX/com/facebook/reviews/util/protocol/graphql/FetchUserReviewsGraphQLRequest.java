package com.facebook.reviews.util.protocol.graphql;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.reviews.util.helper.ReviewsImageHelper;
import javax.inject.Inject;

/* compiled from: profile_video_android_call_to_action_button_clicked */
public class FetchUserReviewsGraphQLRequest {
    public final GraphQLQueryExecutor f5019a;
    public final ReviewsImageHelper f5020b;

    @Inject
    public FetchUserReviewsGraphQLRequest(GraphQLQueryExecutor graphQLQueryExecutor, ReviewsImageHelper reviewsImageHelper) {
        this.f5019a = graphQLQueryExecutor;
        this.f5020b = reviewsImageHelper;
    }
}
