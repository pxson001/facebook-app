package com.facebook.graphql.model;

import com.facebook.graphql.model.GraphQLFeedback.FeedbackExtra;

/* compiled from: gk_names */
public class GraphQLFeedbackHelper {
    public static GraphQLTopReactionsConnection m30217a(GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback == null) {
            return null;
        }
        FeedbackExtra Y = graphQLFeedback.m23231Y();
        if (Y == null || Y.f22288a == null) {
            return graphQLFeedback.m23219M();
        }
        return Y.f22288a.a;
    }
}
