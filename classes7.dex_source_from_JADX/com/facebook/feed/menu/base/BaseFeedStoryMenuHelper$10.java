package com.facebook.feed.menu.base;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.executor.GraphQLResult;

/* compiled from: analytics_extra_data */
class BaseFeedStoryMenuHelper$10 extends AbstractDisposableFutureCallback<GraphQLResult> {
    final /* synthetic */ FeedProps f19368a;
    final /* synthetic */ BaseFeedStoryMenuHelper f19369b;

    BaseFeedStoryMenuHelper$10(BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, FeedProps feedProps) {
        this.f19369b = baseFeedStoryMenuHelper;
        this.f19368a = feedProps;
    }

    protected final void m22807a(Object obj) {
        this.f19369b.a(this.f19368a);
    }

    protected final void m22808a(Throwable th) {
    }
}
