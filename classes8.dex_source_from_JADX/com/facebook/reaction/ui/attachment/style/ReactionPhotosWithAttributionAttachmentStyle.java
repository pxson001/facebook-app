package com.facebook.reaction.ui.attachment.style;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.ReactionMediaGalleryUtil;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.ui.attachment.handler.photos.ReactionPhotosWithAttributionHandler;
import com.facebook.reaction.ui.attachment.handler.photos.ReactionPhotosWithAttributionHandlerProvider;
import com.facebook.reaction.ui.attachment.handler.photos.ReactionPhotosWithAttributionRecyclerAdapterProvider;
import javax.inject.Inject;

/* compiled from: VIDEO_SEEK_BAR */
public class ReactionPhotosWithAttributionAttachmentStyle extends ReactionAttachmentStyle {
    private final ReactionPhotosWithAttributionHandlerProvider f21032a;

    @Inject
    public ReactionPhotosWithAttributionAttachmentStyle(ReactionPhotosWithAttributionHandlerProvider reactionPhotosWithAttributionHandlerProvider) {
        super(GraphQLReactionStoryAttachmentsStyle.PHOTOS_WITH_ATTRIBUTION);
        this.f21032a = reactionPhotosWithAttributionHandlerProvider;
    }

    public final ReactionAttachmentHandler mo1147c() {
        InjectorLike injectorLike = this.f21032a;
        return new ReactionPhotosWithAttributionHandler((ReactionPhotosWithAttributionRecyclerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionPhotosWithAttributionRecyclerAdapterProvider.class), ReactionExperimentController.a(injectorLike), IdBasedProvider.a(injectorLike, 3727), ReactionIntentFactory.m22683a(injectorLike), ReactionIntentLauncher.m24381a(injectorLike), ReactionMediaGalleryUtil.m22513b(injectorLike), ReactionUtil.m22637a(injectorLike), GraphQLReactionStoryAttachmentsStyle.PHOTOS_WITH_ATTRIBUTION);
    }
}
