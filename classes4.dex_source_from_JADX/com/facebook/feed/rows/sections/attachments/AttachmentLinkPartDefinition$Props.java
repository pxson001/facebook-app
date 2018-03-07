package com.facebook.feed.rows.sections.attachments;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import java.util.Map;

/* compiled from: dex_unopt */
public class AttachmentLinkPartDefinition$Props {
    public final FeedProps<GraphQLStoryAttachment> f13855a;
    public final GraphQLStoryAttachment f13856b;
    public final Map<String, ?> f13857c;

    public AttachmentLinkPartDefinition$Props(FeedProps<GraphQLStoryAttachment> feedProps) {
        this(feedProps, null);
    }

    public AttachmentLinkPartDefinition$Props(FeedProps<GraphQLStoryAttachment> feedProps, Map<String, ?> map) {
        this.f13855a = feedProps;
        this.f13856b = (GraphQLStoryAttachment) feedProps.a;
        this.f13857c = map;
    }
}
