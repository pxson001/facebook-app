package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionPageResidenceHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VID_ */
public class ReactionPageResidenceAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionPageResidenceHandler> f21027a;

    @Inject
    public ReactionPageResidenceAttachmentStyle(Provider<ReactionPageResidenceHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.PAGE_WELCOME_HOME);
        this.f21027a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21027a.get();
    }
}
