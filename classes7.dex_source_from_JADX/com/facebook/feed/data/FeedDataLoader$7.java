package com.facebook.feed.data;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.imageloader.ImagePreprocessor;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.photos.adaptiveimagequality.base.ImageQuality;
import com.google.common.collect.ImmutableList;

/* compiled from: application/vobsub */
class FeedDataLoader$7 implements Runnable {
    final /* synthetic */ ImmutableList f19160a;
    final /* synthetic */ FeedDataLoader f19161b;

    FeedDataLoader$7(FeedDataLoader feedDataLoader, ImmutableList immutableList) {
        this.f19161b = feedDataLoader;
        this.f19160a = immutableList;
    }

    public void run() {
        int size = this.f19160a.size();
        for (int i = 0; i < size; i++) {
            GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) this.f19160a.get(i);
            FeedDataLoader feedDataLoader = this.f19161b;
            if (feedDataLoader.as == null) {
                feedDataLoader.as = feedDataLoader.aq.a(CallerContext.a(feedDataLoader.getClass(), "prefetch_newsfeed_image_in_fg"), (ImagePreprocessor) feedDataLoader.ar.get());
            }
            feedDataLoader.as.m24864a(FeedProps.c(graphQLFeedUnitEdge.c()), ImageQuality.OFF);
        }
    }
}
