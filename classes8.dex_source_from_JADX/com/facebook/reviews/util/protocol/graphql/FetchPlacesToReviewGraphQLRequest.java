package com.facebook.reviews.util.protocol.graphql;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.PlacesToReviewModel;
import com.facebook.reviews.util.helper.ReviewsImageHelper;
import com.facebook.reviews.util.protocol.graphql.FetchUserReviews.FetchPlacesToReviewQueryString;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: profile_video_android_nux_main_button_clicked */
public class FetchPlacesToReviewGraphQLRequest {
    private final GraphQLQueryExecutor f5011a;
    private final ReviewsImageHelper f5012b;

    @Inject
    public FetchPlacesToReviewGraphQLRequest(GraphQLQueryExecutor graphQLQueryExecutor, ReviewsImageHelper reviewsImageHelper) {
        this.f5011a = graphQLQueryExecutor;
        this.f5012b = reviewsImageHelper;
    }

    public final ListenableFuture<GraphQLResult<PlacesToReviewModel>> m4961a(String str, int i, @Nullable String str2) {
        GraphQlQueryString fetchPlacesToReviewQueryString = new FetchPlacesToReviewQueryString();
        fetchPlacesToReviewQueryString.a("user_id", str).a("after_cursor", str2).a("review_profile_pic_size", this.f5012b.m4924b()).a("count", String.valueOf(i));
        return this.f5011a.a(GraphQLRequest.a(fetchPlacesToReviewQueryString));
    }
}
