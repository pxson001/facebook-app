package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionPageAttributionHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIEW_BLOCK_INTERSTITIAL */
public class ReactionPageAttributionAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionPageAttributionHandler> f21023a;

    @Inject
    public ReactionPageAttributionAttachmentStyle(Provider<ReactionPageAttributionHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.PAGE_ATTRIBUTION_FOOTER);
        this.f21023a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21023a.get();
    }
}
