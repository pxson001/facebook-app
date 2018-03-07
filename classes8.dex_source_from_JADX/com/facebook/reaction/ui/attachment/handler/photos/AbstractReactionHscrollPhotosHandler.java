package com.facebook.reaction.ui.attachment.handler.photos;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionAttachmentListener;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.interfaces.ReactionUnitParent;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.widget.hscrollrecyclerview.HScrollLinearLayoutManager;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: WAITING_TO_STEAL_GESTURE */
public abstract class AbstractReactionHscrollPhotosHandler extends ReactionAttachmentHandler {
    public LinearLayoutManager f20850a;
    protected final Provider<HScrollLinearLayoutManager> f20851b;
    public RecyclerView f20852c;

    public AbstractReactionHscrollPhotosHandler(Provider<HScrollLinearLayoutManager> provider, ReactionIntentLauncher reactionIntentLauncher) {
        super(reactionIntentLauncher);
        this.f20851b = provider;
    }

    public final void mo1127a(ReactionAttachmentListener reactionAttachmentListener, ViewGroup viewGroup, ReactionCardContainer reactionCardContainer, String str, Surface surface, @Nullable ReactionUnitParent reactionUnitParent) {
        super.mo1127a(reactionAttachmentListener, viewGroup, reactionCardContainer, str, surface, reactionUnitParent);
        View a = m22840a(2130906609);
        this.f18820c.addView(a);
        this.f20852c = (RecyclerView) a.findViewById(2131566616);
        this.f20850a = (LinearLayoutManager) this.f20851b.get();
        this.f20850a.b(0);
        this.f20852c.setLayoutManager(this.f20850a);
    }

    protected final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return null;
    }

    protected final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        return null;
    }
}
