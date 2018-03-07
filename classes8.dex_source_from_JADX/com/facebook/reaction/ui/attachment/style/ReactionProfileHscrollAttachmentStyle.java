package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionProfileHscrollHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VERSION_CHECK */
public class ReactionProfileHscrollAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionProfileHscrollHandler> f21038a;

    @Inject
    public ReactionProfileHscrollAttachmentStyle(Provider<ReactionProfileHscrollHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.PROFILE_HORIZONTAL_SCROLL);
        this.f21038a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21038a.get();
    }
}
