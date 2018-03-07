package com.facebook.reaction.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.FindViewUtil;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.debug.fps.FrameRateRecyclerViewScrollListener;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.MultiRowFeedLifecycleSubscribers;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.ui.DisabledFeedStoryMenuHelper;
import com.facebook.feed.ui.MultiRowAdapterRecyclerViewProxy;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionListener;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.ReactionThemedContextHelper;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionCommonConstants.CardSearchType;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.common.ReactionInteractionTrackerProvider;
import com.facebook.reaction.feed.ReactionFeedListType;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.ui.recyclerview.AbstractReactionRecyclerViewAdapter;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderViewWithTouchDelegate;
import com.facebook.reaction.ui.recyclerview.ReactionMixedRecyclerViewAdapterProvider;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.LayoutManagerWithKeepAttachedHack;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: join_event_tap */
public abstract class BaseReactionFragment extends FbFragment implements AnalyticsFragment, ReactionSessionListener, ReactionCardContainer {
    public View f10503a;
    public int aA = 0;
    public long aB = 0;
    @Inject
    ReactionThemedContextHelper al;
    private FrameRateLogger am;
    public ReactionHeaderViewWithTouchDelegate an;
    public ReactionInteractionTracker ao;
    public BetterLinearLayoutManager ap;
    public BetterRecyclerView aq;
    private MultiRowAdapterRecyclerViewProxy ar;
    public ViewGroup as;
    public AbstractReactionRecyclerViewAdapter at;
    private ReactionAnalyticsParams au;
    public ReactionSession av;
    public OnGlobalLayoutListener aw;
    public boolean ax = false;
    public boolean ay = false;
    public long az = 0;
    @Inject
    Lazy<DisabledFeedStoryMenuHelper> f10504b;
    @Inject
    MultiRowFeedLifecycleSubscribers f10505c;
    @Inject
    FrameRateLoggerProvider f10506d;
    @Inject
    ReactionInteractionTrackerProvider f10507e;
    @Inject
    ReactionMixedRecyclerViewAdapterProvider f10508f;
    @Inject
    public MonotonicClock f10509g;
    @Inject
    public QuickPerformanceLogger f10510h;
    @Inject
    ReactionSessionManager f10511i;

    /* compiled from: join_event_tap */
    public class C22332 implements OnGlobalLayoutListener {
        final /* synthetic */ BaseReactionFragment f21123a;

        public C22332(BaseReactionFragment baseReactionFragment) {
            this.f21123a = baseReactionFragment;
        }

        public void onGlobalLayout() {
            if (this.f21123a.E != null) {
                this.f21123a.aW();
                int measuredHeight = this.f21123a.jW_().getDisplayMetrics().heightPixels - this.f21123a.an.getMeasuredHeight();
                if (this.f21123a.as != null && this.f21123a.as.getHeight() != measuredHeight) {
                    this.f21123a.as.setLayoutParams(new LayoutParams(-1, measuredHeight, 80));
                }
            }
        }
    }

    public static void m12392a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BaseReactionFragment) obj).m12391a(IdBasedSingletonScopeProvider.b(injectorLike, 6073), MultiRowFeedLifecycleSubscribers.a(injectorLike), (FrameRateLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), (ReactionInteractionTrackerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionInteractionTrackerProvider.class), (ReactionMixedRecyclerViewAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionMixedRecyclerViewAdapterProvider.class), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), ReactionSessionManager.m22590a(injectorLike), ReactionThemedContextHelper.m22628a(injectorLike));
    }

    public abstract String am_();

    protected abstract ReactionSession ax();

    protected FeedListType aP() {
        return ReactionFeedListType.f18943a;
    }

    private void m12391a(Lazy<DisabledFeedStoryMenuHelper> lazy, MultiRowFeedLifecycleSubscribers multiRowFeedLifecycleSubscribers, FrameRateLoggerProvider frameRateLoggerProvider, ReactionInteractionTrackerProvider reactionInteractionTrackerProvider, ReactionMixedRecyclerViewAdapterProvider reactionMixedRecyclerViewAdapterProvider, MonotonicClock monotonicClock, QuickPerformanceLogger quickPerformanceLogger, ReactionSessionManager reactionSessionManager, ReactionThemedContextHelper reactionThemedContextHelper) {
        this.f10504b = lazy;
        this.f10505c = multiRowFeedLifecycleSubscribers;
        this.f10506d = frameRateLoggerProvider;
        this.f10507e = reactionInteractionTrackerProvider;
        this.f10508f = reactionMixedRecyclerViewAdapterProvider;
        this.f10509g = monotonicClock;
        this.f10510h = quickPerformanceLogger;
        this.f10511i = reactionSessionManager;
        this.al = reactionThemedContextHelper;
    }

    public void mo743c(@Nullable Bundle bundle) {
        String str;
        super.c(bundle);
        Class cls = BaseReactionFragment.class;
        m12392a((Object) this, getContext());
        az();
        ReactionAnalyticsParams reactionAnalyticsParams = this.s == null ? null : (ReactionAnalyticsParams) this.s.getParcelable("extra_reaction_analytics_params");
        if (this.av == null) {
            str = "unknown";
        } else {
            str = this.av.f18660c.name();
        }
        this.au = new ReactionAnalyticsParams(reactionAnalyticsParams, str, "unknown", null);
        this.am = this.f10506d.a(Boolean.valueOf(false), "reaction_fragment_scroll_perf", Optional.of(String.valueOf(am_())));
        this.ao = this.f10507e.m22880a(this.av, null);
        aC();
    }

    public View m12398a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1995718199);
        super.a(layoutInflater, viewGroup, bundle);
        Preconditions.checkNotNull(this.av);
        View a2 = m12399a(viewGroup, this.av);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -650349442, a);
        return a2;
    }

    public void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -929790011);
        super.mi_();
        Bundle bundle = this.s;
        if (bundle != null) {
            mo1307b(bundle.getString("source_name"));
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 159926057, a);
    }

    public final void m12406a(ReactionHeaderViewWithTouchDelegate reactionHeaderViewWithTouchDelegate) {
        this.an = reactionHeaderViewWithTouchDelegate;
        if (this.at != null) {
            this.at.m12312a(this.an, getContext());
        }
        ay();
    }

    protected final View m12399a(ViewGroup viewGroup, ReactionSession reactionSession) {
        Context a = ReactionThemedContextHelper.m22627a(getContext(), reactionSession.f18660c);
        LayoutInflater from = LayoutInflater.from(a);
        View a2 = mo1154a(from, viewGroup);
        this.aq = (BetterRecyclerView) FindViewUtil.b(a2, 16908298);
        this.ap = m12402a(this.aq);
        this.ao.m18931a(this.ap, this.f10509g.now(), false);
        this.aq.setLayoutManager(this.ap);
        this.ar = new MultiRowAdapterRecyclerViewProxy(this.aq);
        if (this.at == null) {
            this.at = mo742b(a);
            this.at.mo709a(this.au);
            m12393b(from, a2);
            boolean z = false;
            if (this.an == null || 1 == 0) {
                this.f10503a = from.inflate(aU(), a2, false);
                a2.addView(this.f10503a);
                m12390a(this.f10503a, this.ax);
                View view = this.an;
                if (!this.ax) {
                    z = true;
                }
                m12390a(view, z);
            }
        }
        m12407a(this.aq, this.at, a);
        if (this.an != null) {
            this.at.m12312a(this.an, getContext());
        }
        this.at.mo711a(reactionSession);
        as();
        this.ay = true;
        return a2;
    }

    protected BetterLinearLayoutManager m12402a(BetterRecyclerView betterRecyclerView) {
        return new LayoutManagerWithKeepAttachedHack(betterRecyclerView);
    }

    protected void m12407a(BetterRecyclerView betterRecyclerView, AbstractReactionRecyclerViewAdapter abstractReactionRecyclerViewAdapter, Context context) {
        Preconditions.checkNotNull(abstractReactionRecyclerViewAdapter);
        betterRecyclerView.setAdapter(abstractReactionRecyclerViewAdapter);
    }

    protected AbstractReactionRecyclerViewAdapter mo742b(Context context) {
        return this.f10508f.m24812a(context, aP(), aO(), this);
    }

    protected int aq() {
        return 2130906617;
    }

    protected FrameLayout mo1154a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (FrameLayout) layoutInflater.inflate(aq(), viewGroup, false);
    }

    public void m12395G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1474697270);
        super.G();
        if (this.f10505c != null) {
            this.f10505c.a();
        }
        if (this.at != null) {
            this.at.mo722m();
        }
        av();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1234722617, a);
    }

    protected long av() {
        this.az = this.f10509g.now();
        this.ao.m18951e(this.az);
        return this.az;
    }

    public void m12396H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1947606527);
        super.H();
        if (this.at != null) {
            this.at.mo721l();
        }
        aw();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -982988699, a);
    }

    protected long aw() {
        if (this.az == 0) {
            return 0;
        }
        long now = this.f10509g.now();
        this.aB += now - this.az;
        this.ao.m18949d(now);
        return now;
    }

    protected void mo1304a(@Nullable ReactionSession reactionSession) {
        if (reactionSession != null && reactionSession.m22546A()) {
            ImmutableList p = reactionSession.m22569p();
            int size = p.size();
            for (int i = 0; i < size; i++) {
                this.at.mo710a((ReactionStories) p.get(i));
            }
            m12414b(false);
        }
    }

    public void mo1303I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 736828526);
        if (this.av != null) {
            this.f10511i.m22619g(this.av.f18658a);
            this.av = null;
        }
        if (this.at != null) {
            this.at.mo723n();
            this.at.jc_();
            this.at.b(this.aq);
        }
        if (!(this.an == null || this.aw == null)) {
            CustomViewUtils.a(this.an, this.aw);
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -554280822, a);
    }

    public final void ay() {
        boolean z = true;
        boolean z2 = this.at == null || this.at.mo715d() == 0;
        boolean z3;
        if (this.an == null || 1 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2 && r3) {
            z2 = true;
        } else {
            z2 = false;
        }
        m12390a(this.f10503a, z2);
        View view = this.an;
        if (z2) {
            z = false;
        }
        m12390a(view, z);
    }

    public final void m12414b(boolean z) {
        m12390a(this.as, z);
    }

    protected final void az() {
        ReactionSession b = this.f10511i.m22614b(aB());
        if (b == null) {
            b = ax();
        }
        this.av = b;
    }

    public final void m12412b(ReactionSession reactionSession) {
        this.av.m22554a();
        this.f10511i.m22619g(this.av.f18658a);
        this.av = reactionSession;
        aA();
        this.at.mo714b(reactionSession);
    }

    protected final void aA() {
        this.ao.m18922a();
        this.ao = this.f10507e.m22880a(this.av, this.ap);
    }

    protected void aC() {
        this.f10511i.m22610a(this.av.f18658a, (ReactionSessionListener) this);
    }

    protected void mo1307b(String str) {
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a_(str);
        }
    }

    public static void m12390a(@Nullable View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public final boolean mo728a(ReactionUnitFragment reactionUnitFragment, String str, CardSearchType cardSearchType) {
        return this.at.mo712a(reactionUnitFragment, str, cardSearchType);
    }

    public final boolean mo729a(String str, CardSearchType cardSearchType) {
        return this.at.mo713a(str, cardSearchType);
    }

    @Nullable
    public final ReactionUnitFragment mo725a(String str) {
        return this.at.mo707a(str);
    }

    public boolean aD() {
        return false;
    }

    @Nullable
    public ViewGroup getCardViewGroup() {
        return this.aq;
    }

    public Fragment getFragment() {
        return this;
    }

    @Nullable
    public ReactionInteractionTracker getInteractionTracker() {
        return this.ao;
    }

    public String getSessionId() {
        return this.av == null ? "NO_SESSION_ID" : this.av.f18658a;
    }

    @Nullable
    public Surface getSurface() {
        return this.av == null ? null : this.av.f18660c;
    }

    public boolean kq_() {
        return this.ay;
    }

    public final void mo727a(String str, Optional<PendingStory> optional) {
    }

    public void mo726a(ReactionStories reactionStories) {
        if (this.aq.o == null) {
            mo1304a(this.av);
        } else {
            this.at.mo710a(reactionStories);
        }
    }

    public final void kr_() {
        if (this.aq.o != null) {
            this.at.notifyDataSetChanged();
        }
    }

    public void kQ_() {
        this.ay = false;
        aJ();
        mo1304a(this.av);
        ay();
        au();
    }

    @Nullable
    protected String aB() {
        Bundle bundle = this.s;
        return bundle == null ? null : bundle.getString("reaction_session_id");
    }

    protected final void aJ() {
        if (this.at != null) {
            this.at.mo719j();
        }
    }

    public void kp_() {
        m12414b(false);
        ay();
        this.ax = true;
    }

    protected final int aK() {
        return this.ap.l();
    }

    protected BaseFeedStoryMenuHelper aO() {
        return (BaseFeedStoryMenuHelper) this.f10504b.get();
    }

    public final long aQ() {
        return this.f10509g.now();
    }

    protected void m12403a(RecyclerView recyclerView) {
    }

    private void m12393b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (this.an != null) {
            ViewTreeObserver viewTreeObserver = this.an.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                if (this.aw == null) {
                    this.aw = new C22332(this);
                }
                viewTreeObserver.addOnGlobalLayoutListener(this.aw);
            }
        }
        this.as = (ViewGroup) layoutInflater.inflate(2130906669, viewGroup, false);
        viewGroup.addView(this.as);
        if (this.ax || (this.av != null && this.av.m22577z())) {
            m12414b(false);
        }
    }

    public int aU() {
        return 2130906667;
    }

    private void as() {
        this.aq.setOnScrollListener(new FrameRateRecyclerViewScrollListener(this, this.am) {
            final /* synthetic */ BaseReactionFragment f21122a;

            public final void m24738a(RecyclerView recyclerView, int i, int i2) {
                long now = this.f21122a.f10509g.now();
                BaseReactionFragment baseReactionFragment = this.f21122a;
                baseReactionFragment.aA += i2;
                if (i2 > 0 && this.f21122a.ao.f16108m) {
                    this.f21122a.ao.m18948c((now - this.f21122a.az) + this.f21122a.aB);
                }
                this.f21122a.ao.m18924a(now);
                this.f21122a.m12403a(recyclerView);
                this.f21122a.au();
            }

            protected final void m24739b(RecyclerView recyclerView, int i) {
                super.b(recyclerView, i);
            }
        });
    }

    private void au() {
        Object obj;
        if (this.at.mo718f(this.ap.n() - this.at.m12321f()) >= this.at.mo718f(this.at.mo715d()) - 2) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            aV();
        }
    }

    protected void aV() {
        this.at.m12324h();
    }

    protected void aW() {
    }
}
