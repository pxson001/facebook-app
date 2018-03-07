package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentNode;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.feed.rows.attachments.ReactionSimpleLeftRightTextAttachmentPartDefinition;
import com.facebook.reaction.ui.attachment.handler.ReactionSimpleLeftRightTextHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: UserFriendsCollectionQuery */
public class ReactionSimpleLeftRightTextAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionSimpleLeftRightTextHandler> f21041a;
    private final Lazy<ReactionSimpleLeftRightTextAttachmentPartDefinition> f21042b;

    @Inject
    public ReactionSimpleLeftRightTextAttachmentStyle(Provider<ReactionSimpleLeftRightTextHandler> provider, Lazy<ReactionSimpleLeftRightTextAttachmentPartDefinition> lazy) {
        super(GraphQLReactionStoryAttachmentsStyle.SIMPLE_LEFT_RIGHT_TEXT);
        this.f21041a = provider;
        this.f21042b = lazy;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21041a.get();
    }

    public final MultiRowPartWithIsNeeded<ReactionAttachmentNode, ? extends AnyEnvironment> mo1148a() {
        return (MultiRowPartWithIsNeeded) this.f21042b.get();
    }
}
