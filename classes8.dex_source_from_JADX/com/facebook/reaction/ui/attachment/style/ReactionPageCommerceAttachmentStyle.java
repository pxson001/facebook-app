package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionPageCommerceProductHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIEW_APP_TAP */
public class ReactionPageCommerceAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionPageCommerceProductHandler> f21024a;

    @Inject
    public ReactionPageCommerceAttachmentStyle(Provider<ReactionPageCommerceProductHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.PAGE_COMMERCE_UNITS);
        this.f21024a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21024a.get();
    }
}
