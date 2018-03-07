package com.facebook.feed.rows.sections.attachments.ui;

import com.facebook.feed.collage.CollageItem;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLMedia;

/* compiled from: VOIP_QUEUE_TYPE */
public class MediaCollageItem implements CollageItem {
    private final FeedProps<GraphQLMedia> f21073a;

    public MediaCollageItem(FeedProps<GraphQLMedia> feedProps) {
        this.f21073a = feedProps;
    }

    public final boolean m23941a() {
        GraphQLMedia graphQLMedia = (GraphQLMedia) this.f21073a.a;
        return graphQLMedia.j() != null && graphQLMedia.j().g() == 82650203;
    }

    public final GraphQLMedia m23942b() {
        return (GraphQLMedia) this.f21073a.a;
    }
}
