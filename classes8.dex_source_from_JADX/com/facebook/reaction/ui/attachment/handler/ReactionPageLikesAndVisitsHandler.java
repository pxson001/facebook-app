package com.facebook.reaction.ui.attachment.handler;

import android.view.View;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.feed.rows.ui.ReactionTitleAndLabelView;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: View */
public class ReactionPageLikesAndVisitsHandler extends ReactionAttachmentHandler {
    @Inject
    public ReactionPageLikesAndVisitsHandler(ReactionIntentLauncher reactionIntentLauncher) {
        super(reactionIntentLauncher);
    }

    public final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        View a = m22840a(2130906611);
        ReactionTitleAndLabelView reactionTitleAndLabelView = (ReactionTitleAndLabelView) a.findViewById(2131566622);
        reactionTitleAndLabelView.setTitle(m24526b(reactionStoryAttachmentFragmentModel.ab()));
        reactionTitleAndLabelView.setLabel(reactionStoryAttachmentFragmentModel.ac().a());
        m24525a(reactionTitleAndLabelView);
        reactionTitleAndLabelView = (ReactionTitleAndLabelView) a.findViewById(2131566623);
        if (reactionStoryAttachmentFragmentModel.ad() > 0) {
            reactionTitleAndLabelView.setTitle(m24526b(reactionStoryAttachmentFragmentModel.ad()));
            reactionTitleAndLabelView.setLabel(reactionStoryAttachmentFragmentModel.ae().a());
            m24525a(reactionTitleAndLabelView);
        } else {
            reactionTitleAndLabelView.setVisibility(8);
        }
        return a;
    }

    public final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        return null;
    }

    public final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel.ac() == null || reactionStoryAttachmentFragmentModel.ae() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.ac().a()) || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.ae().a())) ? false : true;
    }

    private static void m24525a(ReactionTitleAndLabelView reactionTitleAndLabelView) {
        reactionTitleAndLabelView.setTitleTextAppearance(2131625824);
        reactionTitleAndLabelView.setLabelTextAppearance(2131625825);
    }

    private static String m24526b(int i) {
        return StringLocaleUtil.a("%,d", new Object[]{Integer.valueOf(i)});
    }
}
