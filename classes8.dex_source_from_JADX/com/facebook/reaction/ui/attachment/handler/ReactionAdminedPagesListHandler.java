package com.facebook.reaction.ui.attachment.handler;

import android.net.Uri;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.fb4a.constants.PagesFb4aConstants.PagesFb4aTabs;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionRecyclableAttachmentHandler;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.ui.recyclerview.ReactionSimpleViewHolder;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.touchlistener.HighlightViewOnTouchListener;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: WRITE_REVIEW_TAP */
public class ReactionAdminedPagesListHandler extends ReactionRecyclableAttachmentHandler<ReactionSimpleViewHolder> {
    public final ReactionIntentFactory f20814a;

    public final void mo1130a(ViewHolder viewHolder, ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        ContentView contentView = (ContentView) ((ReactionSimpleViewHolder) viewHolder).a;
        final String b = reactionStoryAttachmentFragmentModel.X().b();
        final Object c = reactionStoryAttachmentFragmentModel.X().c();
        contentView.setThumbnailPlaceholderResource(2131361970);
        FbTextView fbTextView = (FbTextView) contentView.findViewById(2131565719);
        contentView.setTitleText(c);
        contentView.setThumbnailUri(Uri.parse(reactionStoryAttachmentFragmentModel.X().d().b()));
        if (reactionStoryAttachmentFragmentModel.fs_() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.fs_().a())) {
            fbTextView.setVisibility(8);
            return;
        }
        fbTextView.setText(reactionStoryAttachmentFragmentModel.fs_().a());
        fbTextView.setVisibility(0);
        fbTextView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ReactionAdminedPagesListHandler f20813c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 405963385);
                ReactionAttachmentIntent a2 = this.f20813c.f20814a.m22731a(view.getContext(), b, c, UnitInteractionType.PAGE_NEW_ACTIVITY_COUNT_TAP);
                if (a2.f18831d != null) {
                    a2.f18831d.putExtra("extra_is_admin", true);
                    a2.f18831d.putExtra("extra_page_tab", PagesFb4aTabs.ACTIVITY);
                }
                this.f20813c.mo1138a(b, a2, view);
                Logger.a(2, EntryType.UI_INPUT_END, 2099925522, a);
            }
        });
    }

    @Inject
    public ReactionAdminedPagesListHandler(ReactionIntentLauncher reactionIntentLauncher, ReactionIntentFactory reactionIntentFactory) {
        super(reactionIntentLauncher);
        this.f20814a = reactionIntentFactory;
    }

    public final ViewHolder mo1131g() {
        ContentView contentView = (ContentView) m22840a(2130906116);
        contentView.setOnTouchListener(new HighlightViewOnTouchListener());
        return new ReactionSimpleViewHolder(contentView);
    }

    public final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        return this.f20814a.m22731a(view.getContext(), reactionStoryAttachmentFragmentModel.X().b(), reactionStoryAttachmentFragmentModel.X().c(), UnitInteractionType.PROFILE_TAP);
    }

    public final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel.X() == null || reactionStoryAttachmentFragmentModel.X().d() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.X().d().b()) || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.X().b()) || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.X().c())) ? false : true;
    }
}
