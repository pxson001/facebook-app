package com.facebook.feed.collage;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;

/* compiled from: obsolete */
public class StoryCollageItem implements CollageItem {
    public final FeedProps<GraphQLStoryAttachment> f6295a;

    public StoryCollageItem(FeedProps<GraphQLStoryAttachment> feedProps) {
        this.f6295a = feedProps;
    }

    public final boolean mo563a() {
        return GraphQLStoryAttachmentUtil.d((GraphQLStoryAttachment) this.f6295a.a);
    }

    public final GraphQLMedia mo564b() {
        return ((GraphQLStoryAttachment) this.f6295a.a).r();
    }

    public final FeedProps<GraphQLStoryAttachment> m6770c() {
        return this.f6295a;
    }
}
