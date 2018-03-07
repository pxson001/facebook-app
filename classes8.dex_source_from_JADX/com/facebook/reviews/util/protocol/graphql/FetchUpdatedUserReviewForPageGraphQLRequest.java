package com.facebook.reviews.util.protocol.graphql;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.reviews.util.helper.ReviewsImageHelper;
import javax.inject.Inject;

/* compiled from: profile_video_android_camera_closed */
public class FetchUpdatedUserReviewForPageGraphQLRequest {
    public final GraphQLQueryExecutor f5017a;
    public final ReviewsImageHelper f5018b;

    @Inject
    public FetchUpdatedUserReviewForPageGraphQLRequest(GraphQLQueryExecutor graphQLQueryExecutor, ReviewsImageHelper reviewsImageHelper) {
        this.f5017a = graphQLQueryExecutor;
        this.f5018b = reviewsImageHelper;
    }
}
