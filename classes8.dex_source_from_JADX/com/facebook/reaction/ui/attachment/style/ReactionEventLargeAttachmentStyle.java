package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionEventLargeHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIEW_GROUP_EVENTS_TAP */
public class ReactionEventLargeAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionEventLargeHandler> f21016a;

    @Inject
    public ReactionEventLargeAttachmentStyle(Provider<ReactionEventLargeHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.EVENT_CARD_LARGE);
        this.f21016a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21016a.get();
    }
}
