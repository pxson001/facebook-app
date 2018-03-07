package com.facebook.reaction.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.RecyclerListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.FindViewUtil;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.ui.basefeedfragment.BaseFeedFragment;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.ReactionThemedContextHelper;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionCommonConstants.CardSearchType;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.common.ReactionInteractionTrackerProvider;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.ui.recyclerview.ReactionFeedRowViewHolder;
import com.facebook.reaction.ui.recyclerview.ReactionShowMoreComponentsRecyclerViewAdapter;
import com.facebook.reaction.ui.recyclerview.ReactionShowMoreComponentsRecyclerViewAdapterProvider;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Unknown item type */
public class ReactionShowMoreComponentsFragment extends BaseFeedFragment implements ReactionCardContainer {
    @Inject
    ReactionShowMoreComponentsRecyclerViewAdapterProvider f21148a;
    public BetterRecyclerView al;
    private ReactionSession am;
    private String an;
    private Surface ao;
    @Inject
    MultipleRowsStoriesRecycleCallback f21149b;
    @Inject
    ReactionInteractionTrackerProvider f21150c;
    @Inject
    MonotonicClock f21151d;
    @Inject
    ReactionSessionManager f21152e;
    @Inject
    ReactionThemedContextHelper f21153f;
    public ReactionShowMoreComponentsRecyclerViewAdapter f21154g;
    private ReactionInteractionTracker f21155h;
    public BetterLinearLayoutManager f21156i;

    /* compiled from: Unknown item type */
    class C22411 extends OnScrollListener {
        final /* synthetic */ ReactionShowMoreComponentsFragment f21143a;

        C22411(ReactionShowMoreComponentsFragment reactionShowMoreComponentsFragment) {
            this.f21143a = reactionShowMoreComponentsFragment;
        }

        public final void m24778a(RecyclerView recyclerView, int i) {
        }

        public final void m24779a(RecyclerView recyclerView, int i, int i2) {
            ReactionShowMoreComponentsFragment reactionShowMoreComponentsFragment = this.f21143a;
            int n = reactionShowMoreComponentsFragment.f21156i.n();
            int aZ_ = reactionShowMoreComponentsFragment.f21154g.aZ_();
            if (aZ_ > 0 && n >= (aZ_ - 5) - 1) {
                reactionShowMoreComponentsFragment.f21154g.m24816e();
            }
        }
    }

    /* compiled from: Unknown item type */
    class C22422 implements RecyclerListener {
        final /* synthetic */ ReactionShowMoreComponentsFragment f21144a;

        C22422(ReactionShowMoreComponentsFragment reactionShowMoreComponentsFragment) {
            this.f21144a = reactionShowMoreComponentsFragment;
        }

        public final void m24780a(ViewHolder viewHolder) {
            if (viewHolder instanceof ReactionFeedRowViewHolder) {
                MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback = this.f21144a.f21149b;
                MultipleRowsStoriesRecycleCallback.a(viewHolder.a);
            }
        }
    }

    /* compiled from: Unknown item type */
    public class C22443 implements Delegate {
        final /* synthetic */ ReactionShowMoreComponentsFragment f21147a;

        public C22443(ReactionShowMoreComponentsFragment reactionShowMoreComponentsFragment) {
            this.f21147a = reactionShowMoreComponentsFragment;
        }

        public final void m24782a(final HasScrollListenerSupportImpl hasScrollListenerSupportImpl) {
            this.f21147a.al.a(new OnScrollListener(this) {
                final /* synthetic */ C22443 f21146b;

                public final void m24781a(RecyclerView recyclerView, int i, int i2) {
                    super.a(recyclerView, i, i2);
                    hasScrollListenerSupportImpl.b();
                }
            });
        }
    }

    public static void m24784a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ReactionShowMoreComponentsFragment) obj).m24783a((ReactionShowMoreComponentsRecyclerViewAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionShowMoreComponentsRecyclerViewAdapterProvider.class), MultipleRowsStoriesRecycleCallback.a(injectorLike), (ReactionInteractionTrackerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionInteractionTrackerProvider.class), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), ReactionSessionManager.m22590a(injectorLike), ReactionThemedContextHelper.m22628a(injectorLike));
    }

    public final void m24791c(Bundle bundle) {
        Class cls = ReactionShowMoreComponentsFragment.class;
        m24784a((Object) this, getContext());
        Preconditions.checkState(this.s.containsKey("reaction_session_id"), "REACTION_SESSION_ID_TAG must be present");
        Preconditions.checkState(this.s.get("reaction_surface") instanceof Surface, "REACTION_SURFACE_TAG must be a (non-null) Surface instance");
        this.an = this.s.getString("reaction_session_id");
        this.am = this.f21152e.m22614b(this.an);
        this.f21155h = this.f21150c.m22880a(this.am, null);
        this.ao = (Surface) this.s.get("reaction_surface");
        super.c(bundle);
    }

    public final View m24787a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2143832134);
        Context a2 = ReactionThemedContextHelper.m22627a(getContext(), this.am.f18660c);
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(a2).inflate(2130906712, viewGroup, false);
        this.f21156i = new BetterLinearLayoutManager(getContext());
        this.f21155h.m18931a(this.f21156i, this.f21151d.now(), false);
        this.al = (BetterRecyclerView) FindViewUtil.b(frameLayout, 16908298);
        this.al.setLayoutManager(this.f21156i);
        this.al.setAdapter(m24785b(a2));
        this.al.setEmptyView(frameLayout.findViewById(16908292));
        this.al.a(new C22411(this));
        this.al.setRecyclerListener(new C22422(this));
        this.f21154g.m24816e();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1291659214, a);
        return frameLayout;
    }

    private ReactionShowMoreComponentsRecyclerViewAdapter m24785b(Context context) {
        if (this.f21154g != null) {
            return this.f21154g;
        }
        this.f21154g = this.f21148a.m24817a(context, this, (String) this.s.get("component_id"), this.am, (String) this.s.get("settings_token"), (String) this.s.get("reaction_unit_id"), (String) this.s.get("unit_type_token"), new C22443(this));
        return this.f21154g;
    }

    private void m24783a(ReactionShowMoreComponentsRecyclerViewAdapterProvider reactionShowMoreComponentsRecyclerViewAdapterProvider, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, ReactionInteractionTrackerProvider reactionInteractionTrackerProvider, MonotonicClock monotonicClock, ReactionSessionManager reactionSessionManager, ReactionThemedContextHelper reactionThemedContextHelper) {
        this.f21148a = reactionShowMoreComponentsRecyclerViewAdapterProvider;
        this.f21149b = multipleRowsStoriesRecycleCallback;
        this.f21150c = reactionInteractionTrackerProvider;
        this.f21151d = monotonicClock;
        this.f21152e = reactionSessionManager;
        this.f21153f = reactionThemedContextHelper;
    }

    public final void m24792e() {
        this.f21154g.mo1126d();
    }

    public final void m24786I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -434290306);
        this.f21154g.jc_();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1135016992, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -739130248);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            String string = this.s.getString("show_more_title");
            if (string != null) {
                hasTitleBar.a_(string);
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -866584763, a);
    }

    public final boolean mo728a(ReactionUnitFragment reactionUnitFragment, String str, CardSearchType cardSearchType) {
        return false;
    }

    public final boolean mo729a(String str, CardSearchType cardSearchType) {
        return false;
    }

    @Nullable
    public final ReactionUnitFragment mo725a(String str) {
        return null;
    }

    public ViewGroup getCardViewGroup() {
        return this.al;
    }

    @Nullable
    public Fragment getFragment() {
        return this;
    }

    @Nullable
    public ReactionInteractionTracker getInteractionTracker() {
        return this.f21155h;
    }

    public String getSessionId() {
        return this.an != null ? this.an : "NO_SESSION_ID";
    }

    @Nullable
    public Surface getSurface() {
        return this.ao;
    }
}
