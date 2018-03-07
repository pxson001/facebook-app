package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionVideoHscrollHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Updated_ALBUM */
public class ReactionVideoHscrollAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionVideoHscrollHandler> f21049a;

    @Inject
    public ReactionVideoHscrollAttachmentStyle(Provider<ReactionVideoHscrollHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.VIDEO_HORIZONTAL_SCROLL);
        this.f21049a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21049a.get();
    }
}
