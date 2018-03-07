package com.facebook.reaction.ui.attachment.handler;

import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: WIFI_CONNECTED */
public class ReactionEventAttachmentHelper {
    @Nullable
    public static String m24462a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        if (reactionStoryAttachmentFragmentModel.n().l() == null || reactionStoryAttachmentFragmentModel.n().l().b() == null || reactionStoryAttachmentFragmentModel.n().l().b().dQ_() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.n().l().b().dQ_().b())) {
            return null;
        }
        return reactionStoryAttachmentFragmentModel.n().l().b().dQ_().b();
    }
}
