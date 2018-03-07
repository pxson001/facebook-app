package com.facebook.reaction.ui.attachment.handler;

import android.view.View;
import com.facebook.common.util.UriUtil;
import com.facebook.localcontent.criticreviews.CriticReviewView;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentHandler.AttachmentClickListener;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: WRITE_POST_TO_PAGE_TAP */
public class ReactionCriticReviewHscrollHandler extends AbstractReactionHscrollHandler {
    private String f20815b;

    @Inject
    public ReactionCriticReviewHscrollHandler(ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher, ReactionUtil reactionUtil) {
        super(reactionIntentFactory, reactionIntentLauncher, reactionUtil);
    }

    protected final int mo1128b(String str, String str2, ReactionAttachmentsModel reactionAttachmentsModel) {
        this.f20815b = str2;
        return super.mo1128b(str, str2, reactionAttachmentsModel);
    }

    protected final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel.Q() == null || reactionStoryAttachmentFragmentModel.Z() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.Z().a()) || reactionStoryAttachmentFragmentModel.o() == null || UriUtil.a(reactionStoryAttachmentFragmentModel.o().a()) == null || reactionStoryAttachmentFragmentModel.R() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.R().b()) || reactionStoryAttachmentFragmentModel.R().d() == null || UriUtil.a(reactionStoryAttachmentFragmentModel.R().d().a()) == null) ? false : true;
    }

    protected final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        CriticReviewView criticReviewView = (CriticReviewView) m22840a(2130906594);
        criticReviewView.setPublisherName(reactionStoryAttachmentFragmentModel.R().c());
        if (reactionStoryAttachmentFragmentModel.N() != null) {
            criticReviewView.setPublishTime(reactionStoryAttachmentFragmentModel.N().a());
        }
        criticReviewView.setPublisherThumbnail(reactionStoryAttachmentFragmentModel.R().d().a());
        criticReviewView.setPublisherContainerOnClickListener(new AttachmentClickListener(this, this.f20805a, this.f20815b, reactionStoryAttachmentFragmentModel));
        criticReviewView.setReviewTitle(reactionStoryAttachmentFragmentModel.Q().a());
        criticReviewView.setReviewSummary(reactionStoryAttachmentFragmentModel.Z().a());
        if (reactionStoryAttachmentFragmentModel.j() != null) {
            criticReviewView.setReviewAuthor(reactionStoryAttachmentFragmentModel.j().a());
        }
        criticReviewView.setReviewThumbnail(reactionStoryAttachmentFragmentModel.o().a());
        return criticReviewView;
    }

    protected final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        if (view.getId() == 2131560850) {
            return this.f20808d.m22742a(reactionStoryAttachmentFragmentModel.R().b(), UnitInteractionType.CRITIC_REVIEW_PAGE_TAP);
        }
        return this.f20808d.m22784h(reactionStoryAttachmentFragmentModel.p());
    }
}
