package com.facebook.feed.logging;

import com.facebook.graphql.model.GraphQLStory;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: android.intent.action.PACKAGE_FULLY_REMOVED */
class FeedbackPrefetchVpvLoggingHandler$2 implements Runnable {
    final /* synthetic */ GraphQLStory f19346a;
    final /* synthetic */ String f19347b;
    final /* synthetic */ Runnable f19348c;
    final /* synthetic */ FeedbackPrefetchVpvLoggingHandler f19349d;

    FeedbackPrefetchVpvLoggingHandler$2(FeedbackPrefetchVpvLoggingHandler feedbackPrefetchVpvLoggingHandler, GraphQLStory graphQLStory, String str, Runnable runnable) {
        this.f19349d = feedbackPrefetchVpvLoggingHandler;
        this.f19346a = graphQLStory;
        this.f19347b = str;
        this.f19348c = runnable;
    }

    public void run() {
        if (this.f19349d.b.a(this.f19346a)) {
            this.f19349d.f.remove(this.f19347b);
            HandlerDetour.a(this.f19349d.d, this.f19348c);
        }
    }
}
