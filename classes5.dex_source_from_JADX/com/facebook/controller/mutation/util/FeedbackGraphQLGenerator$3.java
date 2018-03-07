package com.facebook.controller.mutation.util;

import com.facebook.graphql.model.GraphQLFeedback;

/* compiled from: accessibility_caption */
public class FeedbackGraphQLGenerator$3 extends RecursiveFeedbackTransform {
    final /* synthetic */ String f11720a;
    final /* synthetic */ String f11721b;
    final /* synthetic */ FeedbackGraphQLGenerator f11722c;

    public FeedbackGraphQLGenerator$3(FeedbackGraphQLGenerator feedbackGraphQLGenerator, String[] strArr, String str, String str2) {
        this.f11722c = feedbackGraphQLGenerator;
        this.f11720a = str;
        this.f11721b = str2;
        super(strArr);
    }

    public final GraphQLFeedback m19778a(GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback == null || !this.f11720a.equals(graphQLFeedback.j())) {
            return graphQLFeedback;
        }
        return this.f11722c.c.a(graphQLFeedback, this.f11721b);
    }
}
