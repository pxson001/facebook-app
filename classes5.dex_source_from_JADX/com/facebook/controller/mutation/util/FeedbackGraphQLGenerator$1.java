package com.facebook.controller.mutation.util;

import com.facebook.graphql.model.GraphQLFeedback;

/* compiled from: accessibility_caption */
public class FeedbackGraphQLGenerator$1 extends RecursiveFeedbackTransform {
    final /* synthetic */ String f11713a;
    final /* synthetic */ boolean f11714b;
    final /* synthetic */ FeedbackGraphQLGenerator f11715c;

    public FeedbackGraphQLGenerator$1(FeedbackGraphQLGenerator feedbackGraphQLGenerator, String[] strArr, String str, boolean z) {
        this.f11715c = feedbackGraphQLGenerator;
        this.f11713a = str;
        this.f11714b = z;
        super(strArr);
    }

    public final GraphQLFeedback m19776a(GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback == null || !this.f11713a.equals(graphQLFeedback.j()) || this.f11714b == graphQLFeedback.A()) {
            return graphQLFeedback;
        }
        return this.f11715c.c.a(graphQLFeedback, this.f11714b);
    }
}
