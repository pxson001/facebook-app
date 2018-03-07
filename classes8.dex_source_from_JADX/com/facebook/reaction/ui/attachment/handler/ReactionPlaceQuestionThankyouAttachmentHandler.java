package com.facebook.reaction.ui.attachment.handler;

import android.view.View;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.ui.util.ReactionViewUtil;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: Video ad fetcher returned no result */
public class ReactionPlaceQuestionThankyouAttachmentHandler extends ReactionAttachmentHandler {
    @Inject
    public ReactionPlaceQuestionThankyouAttachmentHandler(ReactionIntentLauncher reactionIntentLauncher) {
        super(reactionIntentLauncher);
    }

    protected final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        View a = m22840a(2130906706);
        ReactionViewUtil.m24824a(a, 2131561866, reactionStoryAttachmentFragmentModel.J());
        ReactionViewUtil.m24824a(a, 2131561867, reactionStoryAttachmentFragmentModel.I());
        return a;
    }

    protected final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        return null;
    }

    protected final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        boolean z;
        boolean z2 = reactionStoryAttachmentFragmentModel.J() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.J().a());
        if (reactionStoryAttachmentFragmentModel.I() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.I().a())) {
            z = true;
        } else {
            z = false;
        }
        return (z2 && z) ? false : true;
    }
}
