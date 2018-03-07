package com.facebook.feedplugins.attachments.linkshare.offlinesave;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;

/* compiled from: fetchNotificationURI */
public class OfflineAttachmentSaveFooterKey implements ContextStateKey<String, OfflineAttachmentSaveFooterPersistentState> {
    private static final String f24279a = OfflineAttachmentSaveFooterKey.class.getName();
    private final String f24280b;

    public OfflineAttachmentSaveFooterKey(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStory c = AttachmentProps.m28714c(feedProps);
        String str = (c == null || c.mo2507g() == null) ? f24279a : f24279a + c.mo2507g();
        this.f24280b = str;
    }

    public final Object mo2130a() {
        return new OfflineAttachmentSaveFooterPersistentState();
    }

    public final Object mo2131b() {
        return this.f24280b;
    }
}
