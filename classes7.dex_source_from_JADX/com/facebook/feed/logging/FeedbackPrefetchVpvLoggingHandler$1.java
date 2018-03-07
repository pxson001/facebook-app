package com.facebook.feed.logging;

import com.facebook.api.prefetch.GraphQLPrefetchPriority;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: android.intent.action.PACKAGE_FULLY_REMOVED */
class FeedbackPrefetchVpvLoggingHandler$1 implements Runnable {
    final /* synthetic */ GraphQLStory f19344a;
    final /* synthetic */ FeedbackPrefetchVpvLoggingHandler f19345b;

    FeedbackPrefetchVpvLoggingHandler$1(FeedbackPrefetchVpvLoggingHandler feedbackPrefetchVpvLoggingHandler, GraphQLStory graphQLStory) {
        this.f19345b = feedbackPrefetchVpvLoggingHandler;
        this.f19344a = graphQLStory;
    }

    public void run() {
        this.f19345b.b.a(this.f19344a, GraphQLPrefetchPriority.HIGH);
    }
}
