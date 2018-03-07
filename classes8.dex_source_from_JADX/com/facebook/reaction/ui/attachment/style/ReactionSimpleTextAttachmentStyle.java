package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionSimpleTextHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: User friends search fetch failed */
public class ReactionSimpleTextAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionSimpleTextHandler> f21043a;

    @Inject
    public ReactionSimpleTextAttachmentStyle(Provider<ReactionSimpleTextHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.SIMPLE_TEXT);
        this.f21043a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21043a.get();
    }
}
