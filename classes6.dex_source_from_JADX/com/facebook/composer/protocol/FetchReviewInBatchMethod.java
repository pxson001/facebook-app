package com.facebook.composer.protocol;

import com.facebook.common.util.StringUtil;
import com.facebook.composer.protocol.FetchReviewInBatchGraphQL.FetchReviewInBatchString;
import com.facebook.composer.protocol.FetchReviewInBatchGraphQLModels.FetchReviewInBatchModel;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.fasterxml.jackson.core.JsonParser;
import javax.inject.Inject;

/* compiled from: placeIds */
public class FetchReviewInBatchMethod extends AbstractPersistedGraphQlApiMethod<Void, ReviewWithFeedback> {
    @Inject
    public FetchReviewInBatchMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final Object m11487a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        ReviewWithFeedback reviewWithFeedback = (ReviewWithFeedback) jsonParser.a(FetchReviewInBatchModel.class);
        if (reviewWithFeedback != null && reviewWithFeedback.bO_() != null && !StringUtil.a(reviewWithFeedback.bO_().z_()) && reviewWithFeedback.mo329c() != null && reviewWithFeedback.mo329c().m7302a() != null && reviewWithFeedback.mo329c().m7302a().d() != null && reviewWithFeedback.mo329c().m7303b() != null && reviewWithFeedback.mo329c().m7303b().m7295a() != null && !reviewWithFeedback.mo329c().m7303b().m7295a().isEmpty()) {
            return reviewWithFeedback;
        }
        throw new Exception("Invalid JSON result");
    }

    public final int m11488b(Object obj, ApiResponse apiResponse) {
        return 1;
    }

    public final GraphQlQueryString m11489f(Object obj) {
        GraphQlQueryString fetchReviewInBatchString = new FetchReviewInBatchString();
        fetchReviewInBatchString.a("review_id", "{result=post_review:$.id}");
        return fetchReviewInBatchString;
    }
}
