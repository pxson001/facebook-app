package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionPlaceQuestionHorizontalAttachmentHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIDEO_SEARCH */
public class ReactionPlaceQuestionHorizontalAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionPlaceQuestionHorizontalAttachmentHandler> f21033a;

    @Inject
    public ReactionPlaceQuestionHorizontalAttachmentStyle(Provider<ReactionPlaceQuestionHorizontalAttachmentHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.PLACE_QUESTION_HORIZONTAL);
        this.f21033a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21033a.get();
    }
}
