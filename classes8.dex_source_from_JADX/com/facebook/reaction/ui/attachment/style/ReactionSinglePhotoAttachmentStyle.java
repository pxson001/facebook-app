package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentNode;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.feed.rows.attachments.ReactionSinglePhotoAttachmentPartDefinition;
import com.facebook.reaction.ui.attachment.handler.ReactionSinglePhotoHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: User friends fetch failed */
public class ReactionSinglePhotoAttachmentStyle extends ReactionAttachmentStyle {
    private final Provider<ReactionSinglePhotoHandler> f21044a;
    private final Provider<ReactionSinglePhotoAttachmentPartDefinition> f21045b;

    @Inject
    public ReactionSinglePhotoAttachmentStyle(Provider<ReactionSinglePhotoAttachmentPartDefinition> provider, Provider<ReactionSinglePhotoHandler> provider2) {
        super(GraphQLReactionStoryAttachmentsStyle.SINGLE_LARGE_PHOTO);
        this.f21044a = provider2;
        this.f21045b = provider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return (ReactionAttachmentHandler) this.f21044a.get();
    }

    public final MultiRowPartWithIsNeeded<ReactionAttachmentNode, ? extends AnyEnvironment> mo1148a() {
        return (MultiRowPartWithIsNeeded) this.f21045b.get();
    }
}
