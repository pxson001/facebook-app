package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionAdminedPagesListHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIEW_PAGE_LIKERS */
public class ReactionAdminedPagesListAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionAdminedPagesListHandler> f21010a;

    @Inject
    public ReactionAdminedPagesListAttachmentStyle(Provider<ReactionAdminedPagesListHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.ADMINED_PAGES_LIST);
        this.f21010a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21010a.get();
    }
}
