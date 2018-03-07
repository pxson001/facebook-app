package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentNode;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.feed.rows.attachments.ReactionEventBlocksAttachmentPartDefinition;
import com.facebook.reaction.ui.attachment.handler.ReactionEventBlocksHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIEW_GROUP_TAP */
public class ReactionEventBlocksAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionEventBlocksHandler> f21013a;
    private final Lazy<ReactionEventBlocksAttachmentPartDefinition> f21014b;

    @Inject
    public ReactionEventBlocksAttachmentStyle(Provider<ReactionEventBlocksHandler> provider, Lazy<ReactionEventBlocksAttachmentPartDefinition> lazy) {
        super(GraphQLReactionStoryAttachmentsStyle.EVENT_BLOCKS);
        this.f21013a = provider;
        this.f21014b = lazy;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21013a.get();
    }

    public final MultiRowPartWithIsNeeded<ReactionAttachmentNode, ? extends AnyEnvironment> mo1148a() {
        return (MultiRowPartWithIsNeeded) this.f21014b.get();
    }
}
