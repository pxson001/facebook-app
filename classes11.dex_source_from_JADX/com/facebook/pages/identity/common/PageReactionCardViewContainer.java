package com.facebook.pages.identity.common;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionCommonConstants.CardSearchType;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.widget.CustomViewGroup;
import javax.annotation.Nullable;

/* compiled from: post_options_picker_selected_post_option */
public abstract class PageReactionCardViewContainer extends CustomViewGroup implements ReactionCardContainer {
    protected FbFragment f3652g;
    protected ReactionSession f3653h;
    protected ReactionInteractionTracker f3654i;

    public PageReactionCardViewContainer(Context context, FbFragment fbFragment) {
        super(context);
        this.f3652g = fbFragment;
    }

    public final boolean m4684a(ReactionUnitFragment reactionUnitFragment, String str, CardSearchType cardSearchType) {
        return false;
    }

    public final boolean m4685a(String str, CardSearchType cardSearchType) {
        return false;
    }

    @Nullable
    public final ReactionUnitFragment m4683a(String str) {
        return null;
    }

    public ViewGroup getCardViewGroup() {
        return this;
    }

    @Nullable
    public Fragment getFragment() {
        return this.f3652g;
    }

    @Nullable
    public ReactionInteractionTracker getInteractionTracker() {
        return this.f3654i;
    }

    public String getSessionId() {
        return this.f3653h != null ? this.f3653h.a : "NO_SESSION_ID";
    }

    @Nullable
    public Surface getSurface() {
        return this.f3653h != null ? this.f3653h.c : null;
    }
}
