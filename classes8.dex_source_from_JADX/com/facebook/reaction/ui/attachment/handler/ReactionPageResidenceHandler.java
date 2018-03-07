package com.facebook.reaction.ui.attachment.handler;

import android.view.View;
import android.widget.TextView;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: VideosBlended */
public class ReactionPageResidenceHandler extends ReactionAttachmentHandler {
    @Inject
    public ReactionPageResidenceHandler(ReactionIntentLauncher reactionIntentLauncher) {
        super(reactionIntentLauncher);
    }

    public final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        String j = reactionStoryAttachmentFragmentModel.M().j();
        View a = m22840a(2130906606);
        ((TextView) a.findViewById(2131566609)).setText(this.f18821d.getString(2131237287, new Object[]{j}));
        return a;
    }

    public final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        return null;
    }

    public final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel.M() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.M().j())) ? false : true;
    }
}
