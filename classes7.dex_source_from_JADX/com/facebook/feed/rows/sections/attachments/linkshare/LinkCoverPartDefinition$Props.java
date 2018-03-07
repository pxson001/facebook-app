package com.facebook.feed.rows.sections.attachments.linkshare;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;

/* compiled from: VideoSubtitles */
public class LinkCoverPartDefinition$Props {
    public final String f20990a;
    public final GraphQLStoryAttachment f20991b;
    public final FeedProps<GraphQLStoryAttachment> f20992c;

    public LinkCoverPartDefinition$Props(FeedProps<GraphQLStoryAttachment> feedProps, String str) {
        this.f20992c = feedProps;
        this.f20990a = str;
        this.f20991b = (GraphQLStoryAttachment) feedProps.a;
    }
}
