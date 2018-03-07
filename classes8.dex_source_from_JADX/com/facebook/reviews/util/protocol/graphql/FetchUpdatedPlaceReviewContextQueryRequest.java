package com.facebook.reviews.util.protocol.graphql;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.reviews.util.helper.ReviewsImageHelper;
import javax.inject.Inject;

/* compiled from: profile_video_android_chose_existing_video */
public class FetchUpdatedPlaceReviewContextQueryRequest {
    public final GraphQLQueryExecutor f5015a;
    public final ReviewsImageHelper f5016b;

    @Inject
    public FetchUpdatedPlaceReviewContextQueryRequest(GraphQLQueryExecutor graphQLQueryExecutor, ReviewsImageHelper reviewsImageHelper) {
        this.f5015a = graphQLQueryExecutor;
        this.f5016b = reviewsImageHelper;
    }
}
