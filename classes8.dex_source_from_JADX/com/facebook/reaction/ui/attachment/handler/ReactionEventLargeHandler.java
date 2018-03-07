package com.facebook.reaction.ui.attachment.handler;

import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.events.common.EventsDateUtil;
import com.facebook.events.widget.eventcard.EventsCardView;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: WHITELIST_UNIT_TAP */
public class ReactionEventLargeHandler extends ReactionAttachmentHandler {
    private static final CallerContext f20821a = CallerContext.a(ReactionEventLargeHandler.class, "reaction_dialog");
    private final ReactionEventsCardLargeViewHelper f20822b;
    private final ReactionIntentFactory f20823c;

    @Inject
    public ReactionEventLargeHandler(ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher, ReactionEventsCardLargeViewHelper reactionEventsCardLargeViewHelper) {
        super(reactionIntentLauncher);
        this.f20823c = reactionIntentFactory;
        this.f20822b = reactionEventsCardLargeViewHelper;
    }

    protected final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        return this.f20823c.m22738a(reactionStoryAttachmentFragmentModel.n().dL_());
    }

    protected final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        this.f20822b.m24476a(reactionStoryAttachmentFragmentModel, (EventsCardView) m22840a(2130906597), f20821a);
        return this.f20822b.f20826a;
    }

    protected final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel.n() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.n().dL_()) || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.n().dM_()) || !EventsDateUtil.a(reactionStoryAttachmentFragmentModel.n().dN_()) || ReactionEventAttachmentHelper.m24462a(reactionStoryAttachmentFragmentModel) == null) ? false : true;
    }
}
