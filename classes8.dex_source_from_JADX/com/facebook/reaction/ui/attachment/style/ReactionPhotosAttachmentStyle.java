package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.photos.ReactionDefaultPhotosHandlerProvider;
import javax.inject.Inject;

/* compiled from: VIDEO_TOO_LONG */
public class ReactionPhotosAttachmentStyle extends ReactionAttachmentStyle {
    private final ReactionDefaultPhotosHandlerProvider f21030a;

    @Inject
    public ReactionPhotosAttachmentStyle(ReactionDefaultPhotosHandlerProvider reactionDefaultPhotosHandlerProvider) {
        super(GraphQLReactionStoryAttachmentsStyle.PHOTOS);
        this.f21030a = reactionDefaultPhotosHandlerProvider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return this.f21030a.m24637a(GraphQLReactionStoryAttachmentsStyle.PHOTOS);
    }
}
