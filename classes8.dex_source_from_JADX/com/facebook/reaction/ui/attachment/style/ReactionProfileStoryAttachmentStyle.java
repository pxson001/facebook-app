package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentNode;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.feed.rows.attachments.ReactionProfileStoryAttachmentSelectorPartDefinition;
import com.facebook.reaction.ui.attachment.handler.ReactionProfileStoryHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: UserFriendsSearchQuery */
public class ReactionProfileStoryAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionProfileStoryHandler> f21039a;
    private final Lazy<ReactionProfileStoryAttachmentSelectorPartDefinition> f21040b;

    @Inject
    public ReactionProfileStoryAttachmentStyle(Provider<ReactionProfileStoryHandler> provider, Lazy<ReactionProfileStoryAttachmentSelectorPartDefinition> lazy) {
        super(GraphQLReactionStoryAttachmentsStyle.FEED_STORY_PROFILE_BLOCKS);
        this.f21039a = provider;
        this.f21040b = lazy;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21039a.get();
    }

    public final MultiRowPartWithIsNeeded<ReactionAttachmentNode, ? extends AnyEnvironment> mo1148a() {
        return (MultiRowPartWithIsNeeded) this.f21040b.get();
    }
}
