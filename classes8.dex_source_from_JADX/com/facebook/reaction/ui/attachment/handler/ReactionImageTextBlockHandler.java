package com.facebook.reaction.ui.attachment.handler;

import android.net.Uri;
import android.view.View;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: WAITING_FOR_DOWN */
public class ReactionImageTextBlockHandler extends ReactionAttachmentHandler {
    @Inject
    public ReactionImageTextBlockHandler(ReactionIntentLauncher reactionIntentLauncher) {
        super(reactionIntentLauncher);
    }

    public final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        ContentView contentView = (ContentView) m22840a(2130906592);
        contentView.setThumbnailUri(Uri.parse(reactionStoryAttachmentFragmentModel.r().b()));
        contentView.setTitleText(reactionStoryAttachmentFragmentModel.z().a());
        contentView.setMaxLinesFromThumbnailSize(false);
        contentView.setGravity(48);
        contentView.setThumbnailSize(ThumbnailSize.LARGE);
        contentView.setTitleTextAppearance(2131625826);
        return contentView;
    }

    public final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        return null;
    }

    public final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel.z() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.z().a()) || reactionStoryAttachmentFragmentModel.r() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.r().b())) ? false : true;
    }
}
