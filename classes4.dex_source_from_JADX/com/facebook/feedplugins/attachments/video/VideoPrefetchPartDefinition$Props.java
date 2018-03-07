package com.facebook.feedplugins.attachments.video;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: phone_address_book_snapshot */
public class VideoPrefetchPartDefinition$Props {
    public final FeedProps<GraphQLStoryAttachment> f5007a;
    public final GraphQLStoryAttachment f5008b;
    public final int f5009c;

    public VideoPrefetchPartDefinition$Props(FeedProps<GraphQLStoryAttachment> feedProps, int i) {
        this.f5007a = feedProps;
        this.f5008b = (GraphQLStoryAttachment) feedProps.a;
        this.f5009c = i;
    }
}
