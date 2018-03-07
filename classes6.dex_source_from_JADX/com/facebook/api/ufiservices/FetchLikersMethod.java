package com.facebook.api.ufiservices;

import com.facebook.api.graphql.fetchfeedback.FetchLikersGraphQL.StaticLikersString;
import com.facebook.api.ufiservices.common.FetchNodeListParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.story.GraphQLStoryHelper;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: promotion_campaign */
public final class FetchLikersMethod {
    private final FetchFeedbackMethod f7161a;
    public final GraphQLStoryHelper f7162b;
    public final SizeAwareImageUtil f7163c;

    @Inject
    public FetchLikersMethod(FetchFeedbackMethod fetchFeedbackMethod, GraphQLStoryHelper graphQLStoryHelper, SizeAwareImageUtil sizeAwareImageUtil) {
        this.f7161a = fetchFeedbackMethod;
        this.f7162b = graphQLStoryHelper;
        this.f7163c = sizeAwareImageUtil;
    }

    public final GraphQLRequest<GraphQLFeedback> m10335a(FetchNodeListParams fetchNodeListParams, @Nullable CallerContext callerContext) {
        GraphQlQueryString staticLikersString = new StaticLikersString();
        GraphQLStoryHelper graphQLStoryHelper = this.f7162b;
        staticLikersString.a("profile_image_size", GraphQLStoryHelper.a()).a("likers_profile_image_size", this.f7162b.c());
        if (fetchNodeListParams != null) {
            staticLikersString.a("feedback_id", fetchNodeListParams.a).a("max_likers", String.valueOf(fetchNodeListParams.b));
            if (fetchNodeListParams.c != null) {
                staticLikersString.a("before_likers", fetchNodeListParams.c);
            }
            if (fetchNodeListParams.d != null) {
                staticLikersString.a("after_likers", fetchNodeListParams.d);
            }
        }
        this.f7163c.a(staticLikersString);
        GraphQLRequest a = GraphQLRequest.a(staticLikersString);
        a.f = callerContext;
        GraphQLRequest<GraphQLFeedback> a2 = a.a(RequestPriority.INTERACTIVE);
        if (fetchNodeListParams.e == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA) {
            a2.a(GraphQLCachePolicy.d);
        } else {
            a2.a(GraphQLCachePolicy.a);
        }
        a2.h = this.f7161a.a(fetchNodeListParams, a2);
        return a2;
    }
}
