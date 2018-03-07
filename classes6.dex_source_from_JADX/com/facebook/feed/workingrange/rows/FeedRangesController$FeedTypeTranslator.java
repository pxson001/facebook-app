package com.facebook.feed.workingrange.rows;

import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.graphql.model.FeedEdge;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: members */
class FeedRangesController$FeedTypeTranslator implements Function<Object, FeedEdge> {
    final /* synthetic */ FeedRangesController f10437a;

    public FeedRangesController$FeedTypeTranslator(FeedRangesController feedRangesController) {
        this.f10437a = feedRangesController;
    }

    @Nullable
    public Object apply(@Nullable Object obj) {
        if (obj instanceof BoundedAdapter) {
            return ((BoundedAdapter) obj).d;
        }
        return null;
    }
}
