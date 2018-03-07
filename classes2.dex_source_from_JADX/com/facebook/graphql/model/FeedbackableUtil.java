package com.facebook.graphql.model;

/* compiled from: growth */
public final class FeedbackableUtil {
    private FeedbackableUtil() {
    }

    public static boolean m29215b(Feedbackable feedbackable) {
        GraphQLFeedback l = feedbackable.mo2890l();
        return l != null && l.mo2930c();
    }

    public static boolean m29216c(Feedbackable feedbackable) {
        GraphQLFeedback l = feedbackable.mo2890l();
        return l != null && l.y_();
    }

    public static int m29217d(Feedbackable feedbackable) {
        GraphQLFeedback l = feedbackable.mo2890l();
        return l != null ? GraphQLHelper.m22522p(l) : 0;
    }

    public static int m29218e(Feedbackable feedbackable) {
        GraphQLFeedback l = feedbackable.mo2890l();
        return l != null ? GraphQLHelper.m22504f(l) : 0;
    }
}
