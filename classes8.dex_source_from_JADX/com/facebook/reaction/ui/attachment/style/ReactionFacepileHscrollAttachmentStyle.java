package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionFacepileHscrollHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIEW_EVENT_GUEST_LIST */
public class ReactionFacepileHscrollAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionFacepileHscrollHandler> f21018a;

    @Inject
    public ReactionFacepileHscrollAttachmentStyle(Provider<ReactionFacepileHscrollHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.FACEPILE_HORIZONTAL_SCROLL);
        this.f21018a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21018a.get();
    }
}
