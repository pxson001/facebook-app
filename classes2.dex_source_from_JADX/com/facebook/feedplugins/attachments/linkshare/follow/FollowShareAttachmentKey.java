package com.facebook.feedplugins.attachments.linkshare.follow;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;

/* compiled from: fetchZeroHeaderRequestParams */
public class FollowShareAttachmentKey implements ContextStateKey<String, FollowShareAttachmentPersistentState> {
    private static final String f24265a = FollowShareAttachmentKey.class.getName();
    private final String f24266b;

    public FollowShareAttachmentKey(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStory c = AttachmentProps.m28714c(feedProps);
        String str = (c == null || c.mo2507g() == null) ? "0" : f24265a + c.mo2507g();
        this.f24266b = str;
    }

    public final Object mo2130a() {
        return new FollowShareAttachmentPersistentState();
    }

    public final Object mo2131b() {
        return this.f24266b;
    }
}
