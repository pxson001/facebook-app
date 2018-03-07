package com.facebook.video.watchandshop;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideoAnnotation;
import com.google.common.base.Preconditions;

/* compiled from: shouldShowPayOption */
public class WatchAndShopProductItemViewModel {
    public final FeedProps<GraphQLVideoAnnotation> f3465a;
    public final FeedProps<GraphQLStoryAttachment> f3466b;
    private final int f3467c;

    public WatchAndShopProductItemViewModel(FeedProps<GraphQLVideoAnnotation> feedProps, FeedProps<GraphQLStoryAttachment> feedProps2, int i) {
        Preconditions.checkNotNull(feedProps);
        Preconditions.checkNotNull(feedProps.a);
        Preconditions.checkNotNull(feedProps2);
        Preconditions.checkNotNull(feedProps2.a);
        this.f3465a = feedProps;
        this.f3466b = feedProps2;
        this.f3467c = i;
    }
}
