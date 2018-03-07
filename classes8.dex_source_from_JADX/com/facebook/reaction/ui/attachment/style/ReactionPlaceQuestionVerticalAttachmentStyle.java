package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionPlaceQuestionVerticalAttachmentHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIDEO_CHANNELS */
public class ReactionPlaceQuestionVerticalAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionPlaceQuestionVerticalAttachmentHandler> f21035a;

    @Inject
    public ReactionPlaceQuestionVerticalAttachmentStyle(Provider<ReactionPlaceQuestionVerticalAttachmentHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.PLACE_QUESTION_VERTICAL);
        this.f21035a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21035a.get();
    }
}
