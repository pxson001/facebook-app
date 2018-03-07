package com.facebook.reviews.util.protocol.graphql;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.reviews.protocol.graphql.PageReviewsFragmentsInterfaces.PageOverallStarRating;
import com.facebook.reviews.util.protocol.graphql.FetchPageOverallRatingModels.FetchPageOverallRatingModel;
import com.google.common.base.Function;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: profile_video_android_preview_opened */
public class FetchPageOverallRatingGraphQLRequest {
    public final GraphQLQueryExecutor f5008a;
    public final ListeningExecutorService f5009b;

    /* compiled from: profile_video_android_preview_opened */
    public class C06711 implements Function<GraphQLResult<FetchPageOverallRatingModel>, PageOverallStarRating> {
        final /* synthetic */ FetchPageOverallRatingGraphQLRequest f5007a;

        public C06711(FetchPageOverallRatingGraphQLRequest fetchPageOverallRatingGraphQLRequest) {
            this.f5007a = fetchPageOverallRatingGraphQLRequest;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            return (graphQLResult == null || graphQLResult.e == null) ? null : ((FetchPageOverallRatingModel) graphQLResult.e).m4957a();
        }
    }

    @Inject
    public FetchPageOverallRatingGraphQLRequest(GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService) {
        this.f5008a = graphQLQueryExecutor;
        this.f5009b = listeningExecutorService;
    }
}
