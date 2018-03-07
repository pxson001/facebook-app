package com.facebook.reaction.ui.attachment.handler;

import android.view.View;
import android.widget.TextView;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: VISIBILITY */
public class ReactionSimpleTextHandler extends ReactionAttachmentHandler {
    @Inject
    public ReactionSimpleTextHandler(ReactionIntentLauncher reactionIntentLauncher) {
        super(reactionIntentLauncher);
    }

    public final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        CharSequence a = reactionStoryAttachmentFragmentModel.v().a();
        CharSequence a2 = reactionStoryAttachmentFragmentModel.fr_().a();
        View a3 = m22840a(2130906612);
        ((TextView) a3.findViewById(2131566625)).setText(a);
        ((TextView) a3.findViewById(2131566624)).setText(a2);
        return a3;
    }

    public final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        return null;
    }

    public final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel.v() == null || reactionStoryAttachmentFragmentModel.fr_() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.v().a()) || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.fr_().a())) ? false : true;
    }
}
