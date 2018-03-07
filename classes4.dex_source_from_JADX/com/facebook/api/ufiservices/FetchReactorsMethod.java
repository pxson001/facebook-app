package com.facebook.api.ufiservices;

import com.facebook.api.ufiservices.common.FetchReactionsParams;
import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: platform_share */
public final class FetchReactorsMethod {
    private final FetchFeedbackMethod f4549a;
    public final FetchReactorsParamBuilderUtil f4550b;
    public final FetchRecentActivityParamBuilderUtil f4551c;
    public final SizeAwareImageUtil f4552d;

    public static FetchReactorsMethod m5060b(InjectorLike injectorLike) {
        return new FetchReactorsMethod(FetchFeedbackMethod.b(injectorLike), FetchReactorsParamBuilderUtil.a(injectorLike), FetchRecentActivityParamBuilderUtil.a(injectorLike), SizeAwareImageUtil.a(injectorLike));
    }

    @Inject
    public FetchReactorsMethod(FetchFeedbackMethod fetchFeedbackMethod, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, FetchRecentActivityParamBuilderUtil fetchRecentActivityParamBuilderUtil, SizeAwareImageUtil sizeAwareImageUtil) {
        this.f4549a = fetchFeedbackMethod;
        this.f4550b = fetchReactorsParamBuilderUtil;
        this.f4551c = fetchRecentActivityParamBuilderUtil;
        this.f4552d = sizeAwareImageUtil;
    }

    public final GraphQLRequest<GraphQLFeedback> m5061a(GraphQlQueryString graphQlQueryString, FetchReactionsParams fetchReactionsParams, @Nullable CallerContext callerContext) {
        this.f4550b.b(graphQlQueryString);
        this.f4551c.a(graphQlQueryString);
        if (fetchReactionsParams != null) {
            graphQlQueryString.a("feedback_id", fetchReactionsParams.a).a("max_reactors", String.valueOf(fetchReactionsParams.b));
            if (fetchReactionsParams.a != FeedbackReaction.c.e) {
                graphQlQueryString.a("reaction_type", Integer.valueOf(fetchReactionsParams.a));
            }
            if (fetchReactionsParams.c != null) {
                graphQlQueryString.a("before_reactors", fetchReactionsParams.c);
            }
            if (fetchReactionsParams.d != null) {
                graphQlQueryString.a("after_reactors", fetchReactionsParams.d);
            }
        }
        this.f4552d.a(graphQlQueryString);
        GraphQLRequest a = GraphQLRequest.a(graphQlQueryString, GraphQLFeedback.class);
        a.f = callerContext;
        GraphQLRequest<GraphQLFeedback> a2 = a.a(RequestPriority.INTERACTIVE);
        if (fetchReactionsParams.e == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA) {
            a2.a(GraphQLCachePolicy.d);
        } else {
            a2.a(GraphQLCachePolicy.a);
        }
        a2.h = this.f4549a.a(fetchReactionsParams, a2);
        return a2;
    }
}
