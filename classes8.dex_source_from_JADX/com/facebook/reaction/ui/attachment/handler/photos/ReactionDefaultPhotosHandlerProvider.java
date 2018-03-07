package com.facebook.reaction.ui.attachment.handler.photos;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.ReactionMediaGalleryUtil;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.intent.ReactionIntentLauncher;

/* compiled from: VIEW_POST_INSIGHTS */
public class ReactionDefaultPhotosHandlerProvider extends AbstractAssistedProvider<ReactionDefaultPhotosHandler> {
    public final ReactionDefaultPhotosHandler m24637a(GraphQLReactionStoryAttachmentsStyle graphQLReactionStoryAttachmentsStyle) {
        return new ReactionDefaultPhotosHandler(ReactionExperimentController.a(this), IdBasedProvider.a(this, 3727), ReactionIntentFactory.m22683a((InjectorLike) this), ReactionIntentLauncher.m24381a(this), ReactionMediaGalleryUtil.m22513b(this), ReactionUtil.m22637a((InjectorLike) this), graphQLReactionStoryAttachmentsStyle);
    }
}
