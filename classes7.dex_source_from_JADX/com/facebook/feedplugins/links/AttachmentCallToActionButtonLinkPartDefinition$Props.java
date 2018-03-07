package com.facebook.feedplugins.links;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import javax.annotation.Nullable;

/* compiled from: SWAP_ASSET */
public class AttachmentCallToActionButtonLinkPartDefinition$Props {
    public final FeedProps<GraphQLStoryAttachment> f23503a;
    public final GraphQLStoryAttachment f23504b;
    public final LinkedViewAdapter f23505c;
    @Nullable
    public final LinkEventFactory f23506d;

    public AttachmentCallToActionButtonLinkPartDefinition$Props(FeedProps<GraphQLStoryAttachment> feedProps, LinkedViewAdapter linkedViewAdapter) {
        this(feedProps, linkedViewAdapter, null);
    }

    public AttachmentCallToActionButtonLinkPartDefinition$Props(FeedProps<GraphQLStoryAttachment> feedProps, LinkedViewAdapter linkedViewAdapter, LinkEventFactory<FeedProps<GraphQLStoryAttachment>> linkEventFactory) {
        this.f23503a = feedProps;
        this.f23504b = (GraphQLStoryAttachment) feedProps.a;
        this.f23505c = linkedViewAdapter;
        this.f23506d = linkEventFactory;
    }
}
