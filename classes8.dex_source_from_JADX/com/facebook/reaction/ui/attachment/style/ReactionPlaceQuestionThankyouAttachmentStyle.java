package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionPlaceQuestionThankyouAttachmentHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIDEO_CONTROL */
public class ReactionPlaceQuestionThankyouAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionPlaceQuestionThankyouAttachmentHandler> f21034a;

    @Inject
    public ReactionPlaceQuestionThankyouAttachmentStyle(Provider<ReactionPlaceQuestionThankyouAttachmentHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.PLACE_SURVEY_THANK_YOU);
        this.f21034a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21034a.get();
    }
}
