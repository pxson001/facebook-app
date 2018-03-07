package com.facebook.controller.mutation.util;

import com.facebook.graphql.executor.iface.ConsistencyMemoryCache;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;

/* compiled from: accessibility_caption */
class FeedbackGraphQLGenerator$2 extends RecursiveFeedbackTransform {
    final /* synthetic */ String f11716a;
    final /* synthetic */ boolean f11717b;
    final /* synthetic */ GraphQLActor f11718c;
    final /* synthetic */ FeedbackGraphQLGenerator f11719d;

    FeedbackGraphQLGenerator$2(FeedbackGraphQLGenerator feedbackGraphQLGenerator, ConsistencyMemoryCache consistencyMemoryCache, String[] strArr, String str, boolean z, GraphQLActor graphQLActor) {
        this.f11719d = feedbackGraphQLGenerator;
        this.f11716a = str;
        this.f11717b = z;
        this.f11718c = graphQLActor;
        super(consistencyMemoryCache, strArr);
    }

    public final GraphQLFeedback m19777a(GraphQLFeedback graphQLFeedback) {
        return (graphQLFeedback == null || !this.f11716a.equals(graphQLFeedback.j()) || !GraphQLHelper.c(graphQLFeedback) || this.f11717b == graphQLFeedback.y_()) ? graphQLFeedback : this.f11719d.c.a(graphQLFeedback, this.f11718c);
    }
}
