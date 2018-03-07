package com.facebook.reaction.ui.attachment.handler;

import android.net.Uri;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.facebook.events.common.EventsDateUtil;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCardFragment;
import com.facebook.events.widget.eventrow.EventRowProfilePictureView;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.LayoutParams;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.ui.touchlistener.HighlightViewOnTouchListener;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: WIFI */
public class ReactionEventBlocksHandler extends ReactionAttachmentHandler {
    private final EventsDashboardTimeFormatUtil f20816a;
    private final ReactionIntentFactory f20817b;

    @Inject
    public ReactionEventBlocksHandler(EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil, ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher) {
        super(reactionIntentLauncher);
        this.f20816a = eventsDashboardTimeFormatUtil;
        this.f20817b = reactionIntentFactory;
    }

    protected final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        return this.f20817b.m22738a(reactionStoryAttachmentFragmentModel.n().dL_());
    }

    protected final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        EventCardFragment n = reactionStoryAttachmentFragmentModel.n();
        ContentView contentView = (ContentView) m22840a(2130906592);
        contentView.setTitleTextAppearance(2131624405);
        contentView.setSubtitleTextAppearance(2131624403);
        contentView.setTitleText(n.dM_());
        contentView.setSubtitleText(this.f20816a.a(n.g(), EventsDateUtil.b(n.dN_()), EventsDateUtil.c(n.b())));
        contentView.setThumbnailSize(ThumbnailSize.MEDIUM);
        EventRowProfilePictureView eventRowProfilePictureView = new EventRowProfilePictureView(new ContextThemeWrapper(this.f18821d, 2131625821));
        eventRowProfilePictureView.setGravity(17);
        int dimensionPixelSize = this.f18821d.getResources().getDimensionPixelSize(2131427472);
        eventRowProfilePictureView.setLayoutParams(new LayoutParams(dimensionPixelSize, dimensionPixelSize));
        eventRowProfilePictureView.m13427a(Uri.parse(n.c().b()), EventsDateUtil.b(n.dN_()), "reaction_events");
        contentView.setThumbnailView(eventRowProfilePictureView);
        contentView.setOnTouchListener(new HighlightViewOnTouchListener());
        return contentView;
    }

    protected final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel.n() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.n().dL_()) || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.n().dM_()) || !EventsDateUtil.a(reactionStoryAttachmentFragmentModel.n().dN_()) || reactionStoryAttachmentFragmentModel.n().c() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.n().c().b())) ? false : true;
    }
}
