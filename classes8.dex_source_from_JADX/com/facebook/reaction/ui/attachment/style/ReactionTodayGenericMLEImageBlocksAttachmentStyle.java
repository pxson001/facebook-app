package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionTodayGenericProfileHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: User VC must be set */
public class ReactionTodayGenericMLEImageBlocksAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionTodayGenericProfileHandler> f21046a;

    @Inject
    public ReactionTodayGenericMLEImageBlocksAttachmentStyle(Provider<ReactionTodayGenericProfileHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.TODAY_GENERIC_MLE_IMAGE_BLOCKS);
        this.f21046a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21046a.get();
    }
}
