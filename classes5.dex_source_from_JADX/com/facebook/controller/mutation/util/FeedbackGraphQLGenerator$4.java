package com.facebook.controller.mutation.util;

import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;

/* compiled from: accessibility_caption */
public class FeedbackGraphQLGenerator$4 extends RecursiveFeedbackTransform {
    final /* synthetic */ String f11723a;
    final /* synthetic */ GraphQLComment f11724b;
    final /* synthetic */ FeedbackGraphQLGenerator f11725c;

    public FeedbackGraphQLGenerator$4(FeedbackGraphQLGenerator feedbackGraphQLGenerator, String[] strArr, String str, GraphQLComment graphQLComment) {
        this.f11725c = feedbackGraphQLGenerator;
        this.f11723a = str;
        this.f11724b = graphQLComment;
        super(strArr);
    }

    public final GraphQLFeedback m19779a(GraphQLFeedback graphQLFeedback) {
        return (graphQLFeedback == null || !this.f11723a.equals(graphQLFeedback.j())) ? graphQLFeedback : this.f11725c.c.b(graphQLFeedback, this.f11724b);
    }
}
