package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionProfileHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VERTICAL_STACK */
public class ReactionProfileAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionProfileHandler> f21037a;

    @Inject
    public ReactionProfileAttachmentStyle(Provider<ReactionProfileHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.PROFILE_BLOCKS);
        this.f21037a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21037a.get();
    }
}
