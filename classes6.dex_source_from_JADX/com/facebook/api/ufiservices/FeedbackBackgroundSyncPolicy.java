package com.facebook.api.ufiservices;

import com.facebook.api.prefetch.GraphQLPrefetchPolicy;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FetchFeedbackParams;
import com.facebook.api.ufiservices.common.FetchFeedbackParams.FetchType;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: promotion_items */
public class FeedbackBackgroundSyncPolicy extends GraphQLPrefetchPolicy<GraphQLFeedback> {
    private final FetchFeedbackMethod f7160a;

    public static FeedbackBackgroundSyncPolicy m10327b(InjectorLike injectorLike) {
        return new FeedbackBackgroundSyncPolicy(FetchFeedbackMethod.b(injectorLike));
    }

    @Inject
    public FeedbackBackgroundSyncPolicy(FetchFeedbackMethod fetchFeedbackMethod) {
        this.f7160a = fetchFeedbackMethod;
    }

    public final String m10330c() {
        return "feedback_background_sync";
    }

    public final boolean m10329a(GraphQLResult<GraphQLFeedback> graphQLResult) {
        return true;
    }

    public final boolean m10331d() {
        return true;
    }

    public final boolean m10332e() {
        return true;
    }

    public final int m10333f() {
        return 10;
    }

    public final boolean m10334g() {
        return true;
    }

    public final GraphQLRequest<GraphQLFeedback> m10328a(String str) {
        return this.f7160a.a(new FetchFeedbackParams(str, 25, FetchType.BASE, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, CommentOrderType.DEFAULT_ORDER, null, true, false, false));
    }
}
