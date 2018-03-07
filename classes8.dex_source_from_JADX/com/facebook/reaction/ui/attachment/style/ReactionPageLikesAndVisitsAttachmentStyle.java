package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentNode;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.feed.rows.attachments.ReactionPageLikesAndVisitsAttachmentPartDefinition;
import com.facebook.reaction.ui.attachment.handler.ReactionPageLikesAndVisitsHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIEW_ALDRIN_TOS */
public class ReactionPageLikesAndVisitsAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionPageLikesAndVisitsHandler> f21025a;
    private final Lazy<ReactionPageLikesAndVisitsAttachmentPartDefinition> f21026b;

    @Inject
    public ReactionPageLikesAndVisitsAttachmentStyle(Provider<ReactionPageLikesAndVisitsHandler> provider, Lazy<ReactionPageLikesAndVisitsAttachmentPartDefinition> lazy) {
        super(GraphQLReactionStoryAttachmentsStyle.PAGE_LIKES_AND_VISITS);
        this.f21025a = provider;
        this.f21026b = lazy;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21025a.get();
    }

    public final MultiRowPartWithIsNeeded<ReactionAttachmentNode, ? extends AnyEnvironment> mo1148a() {
        return (MultiRowPartWithIsNeeded) this.f21026b.get();
    }
}
