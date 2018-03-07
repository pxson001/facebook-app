package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.ReactionFriendYouMayInviteToLikePageHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIEW_EVENTS_DASHBOARD_TAP */
public class ReactionFriendYouMayInviteToLikePageAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionFriendYouMayInviteToLikePageHandler> f21019a;

    @Inject
    public ReactionFriendYouMayInviteToLikePageAttachmentStyle(Provider<ReactionFriendYouMayInviteToLikePageHandler> provider) {
        super(GraphQLReactionStoryAttachmentsStyle.FRIEND_YOU_MAY_INVITE_TO_LIKE_PAGE);
        this.f21019a = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21019a.get();
    }
}
