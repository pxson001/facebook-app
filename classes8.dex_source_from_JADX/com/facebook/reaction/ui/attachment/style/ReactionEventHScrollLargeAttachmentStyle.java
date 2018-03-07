package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionEventHScrollLargeHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIEW_GROUP_PHOTOS_TAP */
public class ReactionEventHScrollLargeAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionEventHScrollLargeHandler> f21015a;

    @Inject
    public ReactionEventHScrollLargeAttachmentStyle(Provider<ReactionEventHScrollLargeHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.EVENT_CARD_LARGE_HORIZONTAL_SCROLL);
        this.f21015a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21015a.get();
    }
}
