package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentNode;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.feed.rows.attachments.ReactionTopicBlocksAttachmentPartDefinition;
import com.facebook.reaction.ui.attachment.handler.ReactionTopicBlocksHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: User ID was null during attempt to clean xconfig storage */
public class ReactionTopicBlocksAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionTopicBlocksHandler> f21047a;
    private final Lazy<ReactionTopicBlocksAttachmentPartDefinition> f21048b;

    @Inject
    public ReactionTopicBlocksAttachmentStyle(Provider<ReactionTopicBlocksHandler> provider, Lazy<ReactionTopicBlocksAttachmentPartDefinition> lazy) {
        super(GraphQLReactionStoryAttachmentsStyle.TOPIC_LIST);
        this.f21047a = provider;
        this.f21048b = lazy;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21047a.get();
    }

    public final MultiRowPartWithIsNeeded<ReactionAttachmentNode, ? extends AnyEnvironment> mo1148a() {
        return (MultiRowPartWithIsNeeded) this.f21048b.get();
    }
}
