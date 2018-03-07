package com.facebook.feedplugins.base.footer.ui;

import com.facebook.api.ufiservices.FeedbackPrefetchPolicy;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ufiservices.data.FeedbackCacheStateProvider;

/* compiled from: Sync network */
class CommentCacheStateUtil$1 implements Runnable {
    final /* synthetic */ Footer f23023a;
    final /* synthetic */ GraphQLStory f23024b;
    final /* synthetic */ CommentCacheStateUtil f23025c;

    CommentCacheStateUtil$1(CommentCacheStateUtil commentCacheStateUtil, Footer footer, GraphQLStory graphQLStory) {
        this.f23025c = commentCacheStateUtil;
        this.f23023a = footer;
        this.f23024b = graphQLStory;
    }

    public void run() {
        CommentCacheStateUtil commentCacheStateUtil = this.f23025c;
        Footer footer = this.f23023a;
        FeedbackCacheStateProvider feedbackCacheStateProvider = this.f23025c.a;
        GraphQLStory graphQLStory = this.f23024b;
        FeedbackPrefetchPolicy a = feedbackCacheStateProvider.b.a(Boolean.valueOf(GraphQLHelper.o(graphQLStory)), Boolean.valueOf(false));
        HandlerDetour.a(commentCacheStateUtil.c, new CommentCacheStateUtil$2(commentCacheStateUtil, footer, feedbackCacheStateProvider.a.d(a.a(graphQLStory.l().z_()).a((long) a.b()).a(GraphQLCachePolicy.b))), 1409333904);
    }
}
