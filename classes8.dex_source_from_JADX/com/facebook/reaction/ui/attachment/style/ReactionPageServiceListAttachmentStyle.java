package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionPageServiceItemHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIDEO_V1 */
public class ReactionPageServiceListAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionPageServiceItemHandler> f21028a;

    @Inject
    public ReactionPageServiceListAttachmentStyle(Provider<ReactionPageServiceItemHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.PAGE_SERVICE_LIST);
        this.f21028a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21028a.get();
    }
}
