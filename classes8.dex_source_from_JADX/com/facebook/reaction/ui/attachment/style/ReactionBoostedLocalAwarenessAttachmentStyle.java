package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionBoostedLocalAwarenessHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIEW_PAGE_INSIGHTS */
public class ReactionBoostedLocalAwarenessAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionBoostedLocalAwarenessHandler> f21011a;

    @Inject
    public ReactionBoostedLocalAwarenessAttachmentStyle(Provider<ReactionBoostedLocalAwarenessHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.BOOSTED_LOCAL_AWARENESS_TIP);
        this.f21011a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21011a.get();
    }
}
