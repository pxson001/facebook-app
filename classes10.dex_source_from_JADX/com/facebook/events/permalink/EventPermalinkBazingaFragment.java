package com.facebook.events.permalink;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.events.common.ActionSource;
import com.facebook.events.feed.ui.EventsFeedListType;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.permalink.adapters.EventPermalinkAdapter;
import com.facebook.events.permalink.adapters.EventPermalinkRecyclerViewAdapter;
import com.facebook.events.permalink.adapters.EventPermalinkRecyclerViewAdapter.C25782;
import com.facebook.events.permalink.adapters.EventPermalinkRecyclerViewAdapter.C25847;
import com.facebook.events.permalink.adapters.EventPermalinkRecyclerViewAdapterProvider;
import com.facebook.events.permalink.perf.EventPermalinkSequenceLogger;
import com.facebook.events.permalink.perf.EventPermalinkSequenceLogger.LoadingState;
import com.facebook.events.permalink.tabbar.StickyTabBarController;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.ui.DisabledFeedStoryMenuHelper;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionHelper;
import com.facebook.reaction.ReactionSessionListener;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.ReactionThemedContextHelper;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionCommonConstants.CardSearchType;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.common.ReactionInteractionTrackerProvider;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.ui.recyclerview.ReactionMixedRecyclerViewAdapter;
import com.facebook.reaction.ui.recyclerview.ReactionMixedRecyclerViewAdapterProvider;
import com.facebook.tablet.Boolean_IsTabletMethodAutoProvider;
import com.facebook.tablet.IsTablet;
import com.facebook.ui.statusbar.StatusBarUtil;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: canvas_pause */
public class EventPermalinkBazingaFragment extends EventPermalinkFragment implements ReactionSessionListener, ReactionCardContainer {
    private static final boolean bq = (VERSION.SDK_INT >= 21);
    @Inject
    @IsTablet
    Boolean f17844a;
    @Inject
    StatusBarUtil al;
    @Inject
    EventPermalinkRecyclerViewAdapterProvider f17845b;
    public boolean bA;
    private boolean bB;
    public boolean bC = true;
    private Context br;
    @Nullable
    public ReactionSession bs;
    public EventPermalinkRecyclerViewAdapter bt;
    public ReactionMixedRecyclerViewAdapter bu;
    private BetterLinearLayoutManager bv;
    public ReactionInteractionTracker bw;
    private RecyclerViewProxy bx;
    private BetterRecyclerView by;
    public StickyTabBarController bz;
    @Inject
    public EventPermalinkSequenceLogger f17846c;
    @Inject
    Lazy<DisabledFeedStoryMenuHelper> f17847d;
    @Inject
    public ReactionInteractionTrackerProvider f17848e;
    @Inject
    ReactionMixedRecyclerViewAdapterProvider f17849f;
    @Inject
    public ReactionSessionHelper f17850g;
    @Inject
    public ReactionSessionManager f17851h;
    @Inject
    ReactionThemedContextHelper f17852i;

    /* compiled from: canvas_pause */
    class C25251 extends OnScrollListener {
        final /* synthetic */ EventPermalinkBazingaFragment f17834a;

        C25251(EventPermalinkBazingaFragment eventPermalinkBazingaFragment) {
            this.f17834a = eventPermalinkBazingaFragment;
        }

        public final void m18216a(RecyclerView recyclerView, int i, int i2) {
            if (i2 > 0 && !this.f17834a.bA) {
                int paramValue;
                int paramValue2;
                if (this.f17834a.bp == null) {
                    paramValue = ActionSource.UNKNOWN.getParamValue();
                } else {
                    paramValue = this.f17834a.bp.b.e.getParamValue();
                }
                if (this.f17834a.bp == null) {
                    paramValue2 = ActionSource.UNKNOWN.getParamValue();
                } else {
                    paramValue2 = this.f17834a.bp.b.f.getParamValue();
                }
                this.f17834a.az.m18142c(this.f17834a.bA, paramValue, paramValue2);
                this.f17834a.bA = true;
            }
            if (EventPermalinkBazingaFragment.au(this.f17834a) && this.f17834a.bu.aZ_() > 0) {
                this.f17834a.bt.m18609e(i2);
                this.f17834a.bz.a(recyclerView, i, i2);
            }
        }
    }

    public static void m18245a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventPermalinkBazingaFragment) obj).m18244a(Boolean_IsTabletMethodAutoProvider.a(injectorLike), (EventPermalinkRecyclerViewAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventPermalinkRecyclerViewAdapterProvider.class), EventPermalinkSequenceLogger.m19070a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 6073), (ReactionInteractionTrackerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionInteractionTrackerProvider.class), (ReactionMixedRecyclerViewAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionMixedRecyclerViewAdapterProvider.class), ReactionSessionHelper.b(injectorLike), ReactionSessionManager.a(injectorLike), ReactionThemedContextHelper.a(injectorLike), StatusBarUtil.a(injectorLike));
    }

    public final void mo814c(@Nullable Bundle bundle) {
        Class cls = EventPermalinkBazingaFragment.class;
        m18245a((Object) this, getContext());
        if (bundle != null) {
            this.bA = bundle.getBoolean("has_logged_first_scroll", false);
            this.bB = bundle.getBoolean("show_reaction_units", false);
            this.bC = bundle.getBoolean("on_demand_waiting_for_load", true);
        }
        this.br = ReactionThemedContextHelper.a(getContext(), Surface.ANDROID_EVENT_PERMALINK);
        this.bv = new BetterLinearLayoutManager(getContext());
        super.mo814c(bundle);
    }

    public final void m18256e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("has_logged_first_scroll", this.bA);
        bundle.putBoolean("show_reaction_units", this.bB);
        bundle.putBoolean("on_demand_waiting_for_load", this.bC);
    }

    protected final EventPermalinkAdapter mo815e() {
        this.bu = this.f17849f.a(this.br, EventsFeedListType.f17454a, (BaseFeedStoryMenuHelper) this.f17847d.get(), this);
        this.bu.a(new ReactionAnalyticsParams(this.bp.c, this.bp.e, this.bp.d, "unknown", null));
        this.bt = this.f17845b.m18614a(this.aA, this.ar, this.aq, this.bp, this, this.br, this.bu, this.ay, this.bv);
        EventPermalinkRecyclerViewAdapter eventPermalinkRecyclerViewAdapter = this.bt;
        eventPermalinkRecyclerViewAdapter.f18238p.a(new C25782(eventPermalinkRecyclerViewAdapter));
        return this.bt;
    }

    public final View mo808a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -653783433);
        LayoutInflater from = LayoutInflater.from(this.br);
        this.f17846c.m19076a(LoadingState.CREATE_VIEW);
        View inflate = from.inflate(2130904055, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1400215311, a);
        return inflate;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1723357010);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2128569254, a);
    }

    public final void mo807I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -977494593);
        this.f17846c.m19081b(LoadingState.REACTION_FIRST_PAGE_NETWORK_FETCH);
        if (this.bs != null) {
            this.f17851h.g(this.bs.a);
            this.bs = null;
        }
        if (this.bu != null) {
            this.bu.n();
            this.bu.jc_();
            this.bu.b(this.by);
        }
        super.mo807I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1934705753, a);
    }

    public final void mo810a(int i, int i2, Intent intent) {
        super.mo810a(i, i2, intent);
        if (au(this) && i2 == -1 && i == 502) {
            this.bt.m18612i();
        }
    }

    public static boolean au(EventPermalinkBazingaFragment eventPermalinkBazingaFragment) {
        return eventPermalinkBazingaFragment.bo != null && eventPermalinkBazingaFragment.bo.k() == GraphQLConnectionStyle.INTERESTED && eventPermalinkBazingaFragment.bB;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.bz != null) {
            StickyTabBarController stickyTabBarController = this.bz;
            if (stickyTabBarController.f18947a != null) {
                stickyTabBarController.f18947a.setTranslationY((float) stickyTabBarController.m19193b());
            }
        }
    }

    protected final ScrollingViewProxy aq() {
        this.by = (BetterRecyclerView) e(2131559427);
        this.by.setLayoutManager(this.bv);
        this.bx = new RecyclerViewProxy(this.by);
        this.bz = new StickyTabBarController(getContext(), this.aO, (ViewStub) e(2131561343), this.f17844a, bq ? this.al.a(o().getWindow()) : 0);
        EventPermalinkRecyclerViewAdapter eventPermalinkRecyclerViewAdapter = this.bt;
        eventPermalinkRecyclerViewAdapter.f18217F = this.bz;
        eventPermalinkRecyclerViewAdapter.f18231i.f18250b = eventPermalinkRecyclerViewAdapter.f18217F;
        eventPermalinkRecyclerViewAdapter.f18217F.f18949c = new C25847(eventPermalinkRecyclerViewAdapter);
        this.by.a(new C25251(this));
        return this.bx;
    }

    private void m18244a(Boolean bool, EventPermalinkRecyclerViewAdapterProvider eventPermalinkRecyclerViewAdapterProvider, EventPermalinkSequenceLogger eventPermalinkSequenceLogger, Lazy<DisabledFeedStoryMenuHelper> lazy, ReactionInteractionTrackerProvider reactionInteractionTrackerProvider, ReactionMixedRecyclerViewAdapterProvider reactionMixedRecyclerViewAdapterProvider, ReactionSessionHelper reactionSessionHelper, ReactionSessionManager reactionSessionManager, ReactionThemedContextHelper reactionThemedContextHelper, StatusBarUtil statusBarUtil) {
        this.f17844a = bool;
        this.f17845b = eventPermalinkRecyclerViewAdapterProvider;
        this.f17846c = eventPermalinkSequenceLogger;
        this.f17847d = lazy;
        this.f17848e = reactionInteractionTrackerProvider;
        this.f17849f = reactionMixedRecyclerViewAdapterProvider;
        this.f17850g = reactionSessionHelper;
        this.f17851h = reactionSessionManager;
        this.f17852i = reactionThemedContextHelper;
        this.al = statusBarUtil;
    }

    protected final boolean ar() {
        return (this.bx == null || this.bx.c.o == null) ? false : true;
    }

    protected final void as() {
        boolean z = false;
        super.as();
        if (this.bo != null) {
            if (this.bo.k() == GraphQLConnectionStyle.INTERESTED || this.bk.a(ExperimentsForEventsGatingModule.Y, false)) {
                z = true;
            }
            this.bB = z;
            if (!this.bB) {
                this.f17846c.m19077a();
            }
            if (this.bB) {
                this.bC = true;
                if (this.bs == null) {
                    Surface surface = getSurface();
                    if (surface != null) {
                        this.f17846c.m19076a(LoadingState.REACTION_FIRST_PAGE_NETWORK_FETCH);
                        ReactionSessionHelper reactionSessionHelper = this.f17850g;
                        ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
                        reactionQueryParams.b = 2;
                        reactionQueryParams = reactionQueryParams;
                        reactionQueryParams.t = Long.valueOf(Long.parseLong(this.bA));
                        this.bs = reactionSessionHelper.a(surface, reactionQueryParams);
                        Bundle bundle = new Bundle();
                        bundle.putString("source_entity_id", this.bA);
                        this.bs.x = bundle;
                        this.bw = this.f17848e.a(this.bs, null);
                        this.bt.f18219H = this.bw;
                        this.f17851h.a(this.bs.a, this);
                        return;
                    }
                    return;
                }
                if (this.bw != null) {
                    this.bw.e();
                    this.bw.g();
                }
                this.f17846c.m19081b(LoadingState.REACTION_FIRST_PAGE_NETWORK_FETCH);
                this.f17846c.m19076a(LoadingState.REACTION_FIRST_PAGE_NETWORK_FETCH);
                this.f17851h.f(getSessionId());
            }
        }
    }

    public final boolean kq_() {
        return this.bC;
    }

    public final void m18250a(ReactionStories reactionStories) {
        this.bu.a(reactionStories);
    }

    public final void kr_() {
    }

    public final void m18251a(String str, Optional<PendingStory> optional) {
    }

    public final void kQ_() {
        this.bC = false;
        this.f17846c.m19084d(LoadingState.REACTION_FIRST_PAGE_NETWORK_FETCH);
        if (this.aA.m17676g() && this.bk.a(ExperimentsForEventsGatingModule.h, false)) {
            this.aA.m17673b();
        }
        this.bt.m18605b(false);
        if (this.bs != null && this.bs.A()) {
            this.bu.a(this.bs);
            EventPermalinkRecyclerViewAdapter eventPermalinkRecyclerViewAdapter = this.bt;
            eventPermalinkRecyclerViewAdapter.f18216E = true;
            eventPermalinkRecyclerViewAdapter.m18613k();
            eventPermalinkRecyclerViewAdapter.notifyDataSetChanged();
        }
    }

    public final void kp_() {
        this.bt.m18605b(false);
        this.f17846c.m19083c(LoadingState.REACTION_FIRST_PAGE_NETWORK_FETCH);
    }

    public final boolean m18252a(ReactionUnitFragment reactionUnitFragment, String str, CardSearchType cardSearchType) {
        return this.bu.a(reactionUnitFragment, str, cardSearchType);
    }

    public final boolean m18253a(String str, CardSearchType cardSearchType) {
        return this.bu.a(str, cardSearchType);
    }

    @Nullable
    public final ReactionUnitFragment mo809a(String str) {
        return null;
    }

    @Nullable
    public ViewGroup getCardViewGroup() {
        return null;
    }

    public Fragment getFragment() {
        return this;
    }

    @Nullable
    public ReactionInteractionTracker getInteractionTracker() {
        return this.bw;
    }

    public String getSessionId() {
        return this.bs == null ? "NO_SESSION_ID" : this.bs.a;
    }

    @Nullable
    public Surface getSurface() {
        if (this.bo == null) {
            return null;
        }
        return this.bo.k() == GraphQLConnectionStyle.RSVP ? Surface.ANDROID_EVENT_PERMALINK_PRIVATE : Surface.ANDROID_EVENT_PERMALINK;
    }
}
