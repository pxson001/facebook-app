package com.facebook.reaction.ui.attachment.handler;

import android.view.View;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.feed.rows.ui.ReactionTitleAndLabelView;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: VOLUME */
public class ReactionSimpleLeftRightTextHandler extends ReactionAttachmentHandler {
    @Inject
    public ReactionSimpleLeftRightTextHandler(ReactionIntentLauncher reactionIntentLauncher) {
        super(reactionIntentLauncher);
    }

    public final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        String a = reactionStoryAttachmentFragmentModel.x().a();
        String a2 = reactionStoryAttachmentFragmentModel.w().a();
        String a3 = reactionStoryAttachmentFragmentModel.T().a();
        String a4 = reactionStoryAttachmentFragmentModel.S().a();
        View a5 = m22840a(2130906611);
        m24587a(a5, 2131566622, a, a2);
        m24587a(a5, 2131566623, a3, a4);
        return a5;
    }

    public final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        return null;
    }

    public final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel.x() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.x().a()) || reactionStoryAttachmentFragmentModel.w() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.w().a()) || reactionStoryAttachmentFragmentModel.T() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.T().a()) || reactionStoryAttachmentFragmentModel.S() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.S().a())) ? false : true;
    }

    private static void m24587a(View view, int i, String str, String str2) {
        ReactionTitleAndLabelView reactionTitleAndLabelView = (ReactionTitleAndLabelView) view.findViewById(i);
        reactionTitleAndLabelView.setTitle(str);
        reactionTitleAndLabelView.setLabel(str2);
        reactionTitleAndLabelView.setTitleTextAppearance(2131625822);
        reactionTitleAndLabelView.setLabelTextAppearance(2131625823);
    }
}
