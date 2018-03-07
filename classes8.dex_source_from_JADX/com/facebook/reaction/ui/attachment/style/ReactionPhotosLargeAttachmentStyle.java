package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.handler.photos.ReactionDefaultPhotosHandlerProvider;
import javax.inject.Inject;

/* compiled from: VIDEO_TAP */
public class ReactionPhotosLargeAttachmentStyle extends ReactionAttachmentStyle {
    private final ReactionDefaultPhotosHandlerProvider f21031a;

    @Inject
    public ReactionPhotosLargeAttachmentStyle(ReactionDefaultPhotosHandlerProvider reactionDefaultPhotosHandlerProvider) {
        super(GraphQLReactionStoryAttachmentsStyle.PHOTOS_LARGE);
        this.f21031a = reactionDefaultPhotosHandlerProvider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        return this.f21031a.m24637a(GraphQLReactionStoryAttachmentsStyle.PHOTOS_LARGE);
    }
}
