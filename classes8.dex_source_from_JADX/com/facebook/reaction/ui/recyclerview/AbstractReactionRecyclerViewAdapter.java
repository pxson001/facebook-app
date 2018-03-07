package com.facebook.reaction.ui.recyclerview;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.facebook.common.dispose.Disposable;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionCommonConstants.CardSearchType;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.common.ReactionItem;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.search.results.model.SearchResultsMutableContext;

/* compiled from: key_load_initial_user_reviews_data */
public abstract class AbstractReactionRecyclerViewAdapter extends Adapter<ViewHolder> implements Disposable {
    protected ReactionSession f10455a = null;
    protected ReactionAnalyticsLogger f10456b;
    protected ReactionAnalyticsParams f10457c;
    public ReactionCardContainer f10458d;
    protected Clock f10459e;
    protected ReactionExperimentController f10460f;
    protected ReactionUtil f10461g;
    public SearchResultsMutableContext f10462h;
    protected ReactionUnitValidator f10463i;
    public ReactionHeaderViewWithTouchDelegate f10464j;
    public ReactionHeaderTouchDelegateView f10465k;
    private ReactionContextItemsView f10466l;

    public abstract ReactionUnitFragment mo707a(String str);

    public abstract void mo708a(Configuration configuration);

    public abstract void mo709a(ReactionAnalyticsParams reactionAnalyticsParams);

    public abstract void mo710a(ReactionStories reactionStories);

    public abstract boolean mo711a(ReactionSession reactionSession);

    public abstract boolean mo712a(ReactionUnitFragment reactionUnitFragment, String str, CardSearchType cardSearchType);

    public abstract boolean mo713a(String str, CardSearchType cardSearchType);

    public abstract void mo714b(ReactionSession reactionSession);

    public abstract int mo715d();

    public abstract int mo716e();

    public abstract ReactionItem mo717e(int i);

    public abstract int mo718f(int i);

    public abstract void mo719j();

    public abstract void mo720k();

    public abstract void mo721l();

    public abstract void mo722m();

    public abstract void mo723n();

    public AbstractReactionRecyclerViewAdapter(ReactionCardContainer reactionCardContainer, ReactionAnalyticsLogger reactionAnalyticsLogger, Clock clock, ReactionExperimentController reactionExperimentController, ReactionUtil reactionUtil, ReactionUnitValidator reactionUnitValidator) {
        this.f10458d = reactionCardContainer;
        this.f10456b = reactionAnalyticsLogger;
        this.f10459e = clock;
        this.f10460f = reactionExperimentController;
        this.f10461g = reactionUtil;
        this.f10463i = reactionUnitValidator;
    }

    public final int m12321f() {
        if (m12331o()) {
            return this.f10466l == null ? 1 : 2;
        } else {
            return 0;
        }
    }

    public final int m12323g() {
        return (m12321f() + mo715d()) - 1;
    }

    public int aZ_() {
        return (m12321f() + mo715d()) + 1;
    }

    public final void m12324h() {
        if (this.f10455a != null) {
            boolean z = this.f10455a.f18673p;
            if (!this.f10461g.m22666a(this.f10455a) && z != this.f10455a.f18673p) {
                notifyDataSetChanged();
            }
        }
    }

    public final int m12325i() {
        return (!m12331o() || this.f10466l == null) ? -1 : 1;
    }

    public final ReactionContextItemsView m12308a(Context context) {
        if (this.f10466l == null) {
            this.f10466l = new ReactionContextItemsView(context);
        }
        return this.f10466l;
    }

    public ReactionHeaderTouchDelegateView m12316b(Context context) {
        if (this.f10465k == null) {
            this.f10465k = new ReactionHeaderTouchDelegateView(this.f10464j == null ? new View(context) : this.f10464j);
        }
        return this.f10465k;
    }

    public final void m12312a(ReactionHeaderViewWithTouchDelegate reactionHeaderViewWithTouchDelegate, Context context) {
        this.f10464j = reactionHeaderViewWithTouchDelegate;
        this.f10465k = null;
        this.f10464j.m24801a(m12316b(context));
        k_(0);
    }

    protected final boolean m12331o() {
        return this.f10464j != null;
    }

    protected final void m12332p() {
        if (this.f10458d.getInteractionTracker() != null) {
            ReactionInteractionTracker interactionTracker = this.f10458d.getInteractionTracker();
            long a = this.f10459e.a();
            if (interactionTracker.f16110o == 0) {
                String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s:%d", "PAGE_NUMBER", Integer.valueOf(interactionTracker.f16104i));
                interactionTracker.f16105j.a(1966093, interactionTracker.f16107l.f18658a, interactionTracker.f16107l.f18660c);
                interactionTracker.f16105j.a(1966093, interactionTracker.f16107l.f18658a, formatStrLocaleSafe);
                interactionTracker.f16105j.a(1966084, interactionTracker.f16107l.f18658a, interactionTracker.f16107l.f18660c);
                interactionTracker.f16105j.a(1966084, interactionTracker.f16107l.f18658a, formatStrLocaleSafe);
                interactionTracker.f16110o = a;
            }
        }
    }
}
