package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionFacepileHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIEW_GENERAL_TOS */
public class ReactionFacepileAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionFacepileHandler> f21017a;

    @Inject
    public ReactionFacepileAttachmentStyle(Provider<ReactionFacepileHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.FACEPILE);
        this.f21017a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21017a.get();
    }
}
