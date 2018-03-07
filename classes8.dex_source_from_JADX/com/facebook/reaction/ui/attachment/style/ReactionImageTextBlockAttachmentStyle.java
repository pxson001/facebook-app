package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentNode;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.feed.rows.attachments.ReactionImageTextBlockAttachmentPartDefinition;
import com.facebook.reaction.ui.attachment.handler.ReactionImageTextBlockHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIEW_CONTRO */
public class ReactionImageTextBlockAttachmentStyle extends ReactionAttachmentStyle {
    private final Lazy<ReactionImageTextBlockAttachmentPartDefinition> f21020a;
    private final Provider<ReactionImageTextBlockHandler> f21021b;

    @Inject
    public ReactionImageTextBlockAttachmentStyle(Provider<ReactionImageTextBlockHandler> provider, Lazy<ReactionImageTextBlockAttachmentPartDefinition> lazy) {
        super(GraphQLReactionStoryAttachmentsStyle.IMAGE_TEXT_BLOCK);
        this.f21020a = lazy;
        this.f21021b = provider;
    }

    public final MultiRowPartWithIsNeeded<ReactionAttachmentNode, ? extends AnyEnvironment> mo1148a() {
        return (MultiRowPartWithIsNeeded) this.f21020a.get();
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21021b.get();
    }
}
