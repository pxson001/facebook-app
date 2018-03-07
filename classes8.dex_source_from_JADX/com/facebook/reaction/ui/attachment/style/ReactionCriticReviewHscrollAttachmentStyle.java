package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionCriticReviewHscrollHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIEW_PAGE_CHECKINS */
public class ReactionCriticReviewHscrollAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionCriticReviewHscrollHandler> f21012a;

    @Inject
    public ReactionCriticReviewHscrollAttachmentStyle(Provider<ReactionCriticReviewHscrollHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.CRITIC_REVIEW_HORIZONTAL_SCROLL);
        this.f21012a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21012a.get();
    }
}
