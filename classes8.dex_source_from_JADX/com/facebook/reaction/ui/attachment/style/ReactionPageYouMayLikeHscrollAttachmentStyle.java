package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionPageYouMayLikeHscrollHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIDEO_TOO_SMALL */
public class ReactionPageYouMayLikeHscrollAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionPageYouMayLikeHscrollHandler> f21029a;

    @Inject
    public ReactionPageYouMayLikeHscrollAttachmentStyle(Provider<ReactionPageYouMayLikeHscrollHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.PAGE_YOU_MAY_LIKE_HORIZONTAL_SCROLL);
        this.f21029a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21029a.get();
    }
}
