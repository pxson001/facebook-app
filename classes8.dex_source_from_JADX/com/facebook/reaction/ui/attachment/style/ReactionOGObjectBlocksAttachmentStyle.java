package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionOGObjectBlocksHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIEW_COMMENT_TAP */
public class ReactionOGObjectBlocksAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionOGObjectBlocksHandler> f21022a;

    @Inject
    public ReactionOGObjectBlocksAttachmentStyle(Provider<ReactionOGObjectBlocksHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.OG_OBJECT_BLOCKS);
        this.f21022a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21022a.get();
    }
}
