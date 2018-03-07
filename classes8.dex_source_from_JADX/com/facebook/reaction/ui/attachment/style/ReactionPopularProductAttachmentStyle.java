package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionPopularProductHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIDEO_CAMERA_OPEN */
public class ReactionPopularProductAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionPopularProductHandler> f21036a;

    @Inject
    public ReactionPopularProductAttachmentStyle(Provider<ReactionPopularProductHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.PAGE_PRODUCT_LIST);
        this.f21036a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21036a.get();
    }
}
