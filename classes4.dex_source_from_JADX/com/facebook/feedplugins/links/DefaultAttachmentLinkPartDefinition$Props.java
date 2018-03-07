package com.facebook.feedplugins.links;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;

/* compiled from: device_status */
public class DefaultAttachmentLinkPartDefinition$Props {
    public final FeedProps<GraphQLStoryAttachment> f13866a;
    public final LinkEventFactory f13867b;
    public final LinkedViewAdapter f13868c;
    public final String f13869d;

    public DefaultAttachmentLinkPartDefinition$Props(FeedProps<GraphQLStoryAttachment> feedProps, LinkEventFactory linkEventFactory, LinkedViewAdapter linkedViewAdapter, String str) {
        this.f13866a = feedProps;
        this.f13867b = linkEventFactory;
        this.f13868c = linkedViewAdapter;
        this.f13869d = str;
    }
}
