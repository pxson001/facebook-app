package com.facebook.reaction.ui.attachment.handler;

import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.events.common.EventsDateUtil;
import com.facebook.events.widget.eventcard.EventsCardView;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: WIDE */
public class ReactionEventHScrollLargeHandler extends AbstractReactionHscrollHandler {
    private static final CallerContext f20818b = CallerContext.a(ReactionEventHScrollLargeHandler.class, "reaction_dialog");
    private final ReactionEventsCardLargeViewHelper f20819c;
    private final ReactionIntentFactory f20820d;

    @Inject
    public ReactionEventHScrollLargeHandler(ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher, ReactionUtil reactionUtil, ReactionEventsCardLargeViewHelper reactionEventsCardLargeViewHelper) {
        super(reactionIntentFactory, reactionIntentLauncher, reactionUtil);
        this.f20820d = reactionIntentFactory;
        this.f20819c = reactionEventsCardLargeViewHelper;
    }

    protected final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        return this.f20820d.m22738a(reactionStoryAttachmentFragmentModel.n().dL_());
    }

    protected final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        this.f20819c.m24476a(reactionStoryAttachmentFragmentModel, (EventsCardView) m22840a(2130906596), f20818b);
        return this.f20819c.f20826a;
    }

    protected final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel.n() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.n().dL_()) || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.n().dM_()) || !EventsDateUtil.a(reactionStoryAttachmentFragmentModel.n().dN_())) ? false : true;
    }
}
