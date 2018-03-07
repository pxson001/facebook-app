package com.facebook.events.permalink.adapters;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.impression.ImpressionManager;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.event.FbEvent;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.feed.data.EventFeedPager;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLModels.EventPinnedPostAndRecentStoryFragmentModel.BoostableStoryModel;
import com.facebook.events.feed.ui.EventFeedStoryPinMutator.StoryUpdater;
import com.facebook.events.feed.ui.EventsFeedListType;
import com.facebook.events.gating.EventPermalinkBazingaHelper;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.model.Event;
import com.facebook.events.permalink.EventPermalinkFragment;
import com.facebook.events.permalink.actionbar.ActionItemInvite;
import com.facebook.events.permalink.actionbar.ActionItemPost;
import com.facebook.events.permalink.actionbar.EventPermalinkStandardActionBar;
import com.facebook.events.permalink.calltoaction.EventCallToActionController;
import com.facebook.events.permalink.calltoaction.EventCheckinButtonController;
import com.facebook.events.permalink.multirow.EventFeedComposerRootPartDefinition;
import com.facebook.events.permalink.multirow.EventPermalinkRootPartSelector;
import com.facebook.events.permalink.multirow.environment.EventPermalinkEnvironment;
import com.facebook.events.permalink.multirow.environment.EventPermalinkEnvironmentGenerated;
import com.facebook.events.permalink.multirow.environment.EventPermalinkEnvironmentGeneratedProvider;
import com.facebook.events.permalink.summary.EventSummaryContextRowsStateTracker;
import com.facebook.events.permalink.tabbar.EventPermalinkTabBar.OnTabChangeListener;
import com.facebook.events.permalink.tabbar.StickyTabBarController;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.api.ListItemCollectionEndProvider;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.core.parts.MultiRowGroupPartDefinitions;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.event.ReactionEventBus;
import com.facebook.reaction.event.ReactionUiEvents.ReactionEventsSeeAllPostsEvent;
import com.facebook.reaction.event.ReactionUiEvents.ReactionEventsSeeAllPostsEventSubscriber;
import com.facebook.reaction.ui.recyclerview.ReactionMixedRecyclerViewAdapter;
import com.facebook.widget.listview.BaseProxyOnScrollListener;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.facebook.widget.viewdiagnostics.ViewDiagnosticsWrapper;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.ImmutableRangeMap.Builder;
import com.google.common.collect.Range;
import java.util.IdentityHashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: button_transparent */
public class EventPermalinkRecyclerViewAdapter extends Adapter<ViewHolder> implements EventPermalinkAdapter<RecyclerViewProxy> {
    private ImmutableRangeMap<Integer, AdapterWithOffsets<FbListAdapter>> f18212A;
    private IdentityHashMap<FbListAdapter, Integer> f18213B;
    private int f18214C;
    public ScrollingViewProxy f18215D;
    public boolean f18216E;
    public StickyTabBarController f18217F;
    private ReactionEventsSeeAllPostsEventSubscriber f18218G;
    @Nullable
    public ReactionInteractionTracker f18219H;
    private boolean f18220I;
    public TabsScrollState f18221J;
    private QeAccessor f18222K;
    public final AnalyticsLogger f18223a;
    public final Context f18224b;
    private final EventInfoAdapter f18225c;
    public final EventPermalinkItemCollection f18226d;
    private final EventFeedComposerItemCollection f18227e;
    public final ImpressionManager f18228f;
    private final MultiRowAdapter f18229g;
    private final MultiRowAdapter f18230h;
    public final EventPermalinkTabFooterAdapter f18231i;
    private final EventPermalinkTabsBarAdapter f18232j;
    private final EventPendingPostsAdapter f18233k;
    private final MultipleRowsStoriesRecycleCallback f18234l;
    private int f18235m;
    public final EventAnalyticsParams f18236n;
    private Function<GraphQLStory, Void> f18237o;
    public ReactionMixedRecyclerViewAdapter f18238p;
    private EventProgressBarAdapter f18239q;
    public Event f18240r;
    private final MonotonicClock f18241s;
    public final BetterLinearLayoutManager f18242t;
    private final ReactionEventBus f18243u;
    private final EventPermalinkBazingaHelper f18244v;
    public final EventFeedPager f18245w;
    @Nullable
    public AdapterWithOffsets f18246x;
    public ImmutableList<AdapterWithOffsets> f18247y = ImmutableList.of();
    private ImmutableRangeMap<Integer, AdapterWithOffsets<?>> f18248z;

    /* compiled from: button_transparent */
    class C25771 extends ReactionEventsSeeAllPostsEventSubscriber {
        final /* synthetic */ EventPermalinkRecyclerViewAdapter f18198a;

        C25771(EventPermalinkRecyclerViewAdapter eventPermalinkRecyclerViewAdapter) {
            this.f18198a = eventPermalinkRecyclerViewAdapter;
        }

        public final void m18575b(FbEvent fbEvent) {
            ReactionEventsSeeAllPostsEvent reactionEventsSeeAllPostsEvent = (ReactionEventsSeeAllPostsEvent) fbEvent;
            if (this.f18198a.f18240r != null && reactionEventsSeeAllPostsEvent.a.equals(this.f18198a.f18240r.a)) {
                this.f18198a.m18612i();
            }
        }
    }

    /* compiled from: button_transparent */
    public class C25782 extends AdapterDataObserver {
        final /* synthetic */ EventPermalinkRecyclerViewAdapter f18199a;

        public C25782(EventPermalinkRecyclerViewAdapter eventPermalinkRecyclerViewAdapter) {
            this.f18199a = eventPermalinkRecyclerViewAdapter;
        }

        public final void bb_() {
            this.f18199a.m18613k();
            this.f18199a.notifyDataSetChanged();
        }
    }

    /* compiled from: button_transparent */
    class C25804 implements Function<GraphQLStory, Void> {
        final /* synthetic */ EventPermalinkRecyclerViewAdapter f18202a;

        C25804(EventPermalinkRecyclerViewAdapter eventPermalinkRecyclerViewAdapter) {
            this.f18202a = eventPermalinkRecyclerViewAdapter;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            this.f18202a.mo826a((GraphQLStory) obj);
            return null;
        }
    }

    /* compiled from: button_transparent */
    class C25815 implements Runnable {
        final /* synthetic */ EventPermalinkRecyclerViewAdapter f18203a;

        C25815(EventPermalinkRecyclerViewAdapter eventPermalinkRecyclerViewAdapter) {
            this.f18203a = eventPermalinkRecyclerViewAdapter;
        }

        public void run() {
            this.f18203a.m18613k();
            this.f18203a.notifyDataSetChanged();
        }
    }

    /* compiled from: button_transparent */
    public class C25836 implements Delegate {
        final /* synthetic */ EventPermalinkRecyclerViewAdapter f18206a;

        public C25836(EventPermalinkRecyclerViewAdapter eventPermalinkRecyclerViewAdapter) {
            this.f18206a = eventPermalinkRecyclerViewAdapter;
        }

        public final void m18578a(final HasScrollListenerSupportImpl hasScrollListenerSupportImpl) {
            this.f18206a.f18215D.b(new BaseProxyOnScrollListener(this) {
                final /* synthetic */ C25836 f18205b;

                public final void m18577a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
                    hasScrollListenerSupportImpl.b();
                }
            });
        }
    }

    /* compiled from: button_transparent */
    public class C25847 implements OnTabChangeListener {
        final /* synthetic */ EventPermalinkRecyclerViewAdapter f18207a;

        public C25847(EventPermalinkRecyclerViewAdapter eventPermalinkRecyclerViewAdapter) {
            this.f18207a = eventPermalinkRecyclerViewAdapter;
        }

        public final void mo837a(@IdRes int i, boolean z) {
            if (this.f18207a.f18245w.m17676g() && i == 2131561369) {
                this.f18207a.f18245w.m17673b();
            }
            EventPermalinkRecyclerViewAdapter eventPermalinkRecyclerViewAdapter = this.f18207a;
            HoneyClientEventFast a = eventPermalinkRecyclerViewAdapter.f18223a.a("event_permalink_tab_bar_tapped", false);
            if (a.a()) {
                String str;
                String str2;
                a.a("event_permalink");
                a.d(eventPermalinkRecyclerViewAdapter.f18228f.b(eventPermalinkRecyclerViewAdapter.f18224b));
                a.b("Event");
                if (eventPermalinkRecyclerViewAdapter.f18240r != null) {
                    a.c(eventPermalinkRecyclerViewAdapter.f18240r.a);
                }
                if (eventPermalinkRecyclerViewAdapter.f18217F.m19192a()) {
                    str = "About";
                    str2 = z ? "Discussion" : "About";
                } else {
                    str = "Discussion";
                    str2 = z ? "About" : "Discussion";
                }
                a.a("previous_tab", str2);
                a.a("tapped_tab", str);
                a.a("source_module", eventPermalinkRecyclerViewAdapter.f18236n != null ? eventPermalinkRecyclerViewAdapter.f18236n.d : "event_permalink");
                a.a("ref_module", eventPermalinkRecyclerViewAdapter.f18236n != null ? eventPermalinkRecyclerViewAdapter.f18236n.c : "unknown");
                a.a("ref_mechanism", eventPermalinkRecyclerViewAdapter.f18236n != null ? eventPermalinkRecyclerViewAdapter.f18236n.e : "unknown");
                a.b();
            }
            if (!(!z || this.f18207a.f18217F.m19192a() || this.f18207a.f18219H == null)) {
                this.f18207a.f18219H.c();
            }
            if (this.f18207a.f18221J == null) {
                this.f18207a.f18221J = new TabsScrollState();
            }
            Parcelable f = this.f18207a.f18242t.f();
            if (z && this.f18207a.f18217F.m19194c()) {
                Parcelable parcelable = this.f18207a.f18217F.m19192a() ? this.f18207a.f18221J.f18210a : this.f18207a.f18221J.f18211b;
                if (parcelable != null) {
                    this.f18207a.f18242t.a(parcelable);
                } else {
                    EventPermalinkRecyclerViewAdapter.m18590q(this.f18207a);
                }
                EventPermalinkRecyclerViewAdapter.m18584a(this.f18207a, f, z);
                this.f18207a.m18613k();
                this.f18207a.notifyDataSetChanged();
                return;
            }
            EventPermalinkRecyclerViewAdapter eventPermalinkRecyclerViewAdapter2 = this.f18207a;
            if (!this.f18207a.f18217F.m19194c()) {
                f = null;
            }
            EventPermalinkRecyclerViewAdapter.m18584a(eventPermalinkRecyclerViewAdapter2, f, z);
            this.f18207a.m18613k();
            this.f18207a.notifyDataSetChanged();
            EventPermalinkRecyclerViewAdapter.m18590q(this.f18207a);
        }
    }

    /* compiled from: button_transparent */
    public class EventPermalinkViewHolder extends ViewHolder {
        public final ViewGroup f18208l;
        public final int f18209m;

        public EventPermalinkViewHolder(View view, ViewGroup viewGroup, int i) {
            super(view);
            this.f18208l = viewGroup;
            this.f18209m = i;
        }
    }

    /* compiled from: button_transparent */
    public class EventPermalinkFeedStoryViewHolder extends EventPermalinkViewHolder {
        public EventPermalinkFeedStoryViewHolder(View view, ViewGroup viewGroup, int i) {
            super(view, viewGroup, i);
        }
    }

    /* compiled from: button_transparent */
    public class EventPermalinkTabBarViewHolder extends EventPermalinkViewHolder {
        public EventPermalinkTabBarViewHolder(View view, ViewGroup viewGroup, int i) {
            super(view, viewGroup, i);
        }
    }

    /* compiled from: button_transparent */
    public class TabsScrollState {
        public Parcelable f18210a;
        public Parcelable f18211b;
    }

    public final void mo827a(ScrollingViewProxy scrollingViewProxy) {
        this.f18215D = (RecyclerViewProxy) scrollingViewProxy;
        this.f18231i.f18249a = this.f18215D;
    }

    public final void mo831b(ScrollingViewProxy scrollingViewProxy) {
        ((RecyclerViewProxy) scrollingViewProxy).c.setAdapter(this);
    }

    @Inject
    public EventPermalinkRecyclerViewAdapter(@Assisted EventFeedPager eventFeedPager, @Assisted ActionItemPost actionItemPost, @Assisted ActionItemInvite actionItemInvite, @Assisted EventAnalyticsParams eventAnalyticsParams, @Assisted StoryUpdater storyUpdater, @Assisted Context context, @Assisted ReactionMixedRecyclerViewAdapter reactionMixedRecyclerViewAdapter, @Assisted EventCheckinButtonController eventCheckinButtonController, @Assisted BetterLinearLayoutManager betterLinearLayoutManager, AnalyticsLogger analyticsLogger, MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<EventPermalinkRootPartSelector> lazy, Lazy<EventFeedComposerRootPartDefinition> lazy2, ImpressionManager impressionManager, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, EventPermalinkEnvironmentGeneratedProvider eventPermalinkEnvironmentGeneratedProvider, EventPendingPostsAdapter eventPendingPostsAdapter, EventCallToActionController eventCallToActionController, MonotonicClock monotonicClock, ReactionEventBus reactionEventBus, EventPermalinkBazingaHelper eventPermalinkBazingaHelper, EventSummaryContextRowsStateTracker eventSummaryContextRowsStateTracker, QeAccessor qeAccessor) {
        this.f18245w = eventFeedPager;
        this.f18223a = analyticsLogger;
        this.f18224b = context;
        this.f18236n = eventAnalyticsParams;
        this.f18244v = eventPermalinkBazingaHelper;
        this.f18228f = impressionManager;
        this.f18234l = multipleRowsStoriesRecycleCallback;
        this.f18241s = monotonicClock;
        this.f18242t = betterLinearLayoutManager;
        this.f18238p = reactionMixedRecyclerViewAdapter;
        this.f18243u = reactionEventBus;
        this.f18222K = qeAccessor;
        this.f18218G = new C25771(this);
        this.f18243u.a(this.f18218G);
        this.f18225c = new EventInfoAdapter(this.f18224b, actionItemPost, actionItemInvite, eventCallToActionController, eventAnalyticsParams, eventCheckinButtonController, eventPermalinkBazingaHelper, eventSummaryContextRowsStateTracker, qeAccessor);
        this.f18226d = new EventPermalinkItemCollection();
        this.f18227e = new EventFeedComposerItemCollection();
        this.f18232j = new EventPermalinkTabsBarAdapter(this.f18224b);
        this.f18233k = eventPendingPostsAdapter;
        this.f18239q = new EventProgressBarAdapter(this.f18224b);
        EventPermalinkEnvironmentGenerated a = m18581a((EventPermalinkFragment) storyUpdater, eventPermalinkEnvironmentGeneratedProvider);
        this.f18229g = m18582a(eventFeedPager, multiRowAdapterBuilder, lazy, a);
        this.f18230h = m18583a(multiRowAdapterBuilder, (Lazy) lazy2, a);
        this.f18231i = new EventPermalinkTabFooterAdapter();
        m18587l();
    }

    public final void m18612i() {
        if (this.f18217F != null && this.f18215D != null) {
            this.f18217F.mo837a(2131561369, this.f18217F.m19192a());
            m18590q(this);
        }
    }

    private void m18587l() {
        int i = 0;
        ImmutableList of = ImmutableList.of(this.f18225c, this.f18232j, this.f18230h, this.f18233k, this.f18239q, this.f18229g, this.f18231i);
        this.f18213B = new IdentityHashMap();
        Builder builder = new Builder();
        int size = of.size();
        for (int i2 = 0; i2 < size; i2++) {
            FbListAdapter fbListAdapter = (FbListAdapter) of.get(i2);
            int viewTypeCount = fbListAdapter.getViewTypeCount();
            builder.a(Range.b(Integer.valueOf(i), Integer.valueOf(viewTypeCount + i)), new AdapterWithOffsets(fbListAdapter, i));
            this.f18213B.put(fbListAdapter, Integer.valueOf(i));
            i += viewTypeCount;
        }
        this.f18212A = builder.a();
        this.f18235m = i;
    }

    private MultiRowAdapter m18583a(MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<EventFeedComposerRootPartDefinition> lazy, EventPermalinkEnvironment eventPermalinkEnvironment) {
        this.f18227e.m18514a(this.f18240r);
        MultiRowAdapterBuilder.Builder a = multiRowAdapterBuilder.a(MultiRowGroupPartDefinitions.a(lazy), this.f18227e);
        a.f = eventPermalinkEnvironment;
        return a.e();
    }

    private MultiRowAdapter m18582a(final EventFeedPager eventFeedPager, MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<EventPermalinkRootPartSelector> lazy, EventPermalinkEnvironment eventPermalinkEnvironment) {
        C25793 c25793 = new ListItemCollectionEndProvider(this) {
            final /* synthetic */ EventPermalinkRecyclerViewAdapter f18201b;

            public final boolean m18576a() {
                return !eventFeedPager.f17362p;
            }
        };
        this.f18226d.f18167e = eventFeedPager.f17349c;
        MultiRowAdapterBuilder.Builder a = multiRowAdapterBuilder.a(lazy, this.f18226d).a(c25793);
        a.f = eventPermalinkEnvironment;
        return a.e();
    }

    private EventPermalinkEnvironmentGenerated m18581a(EventPermalinkFragment eventPermalinkFragment, EventPermalinkEnvironmentGeneratedProvider eventPermalinkEnvironmentGeneratedProvider) {
        this.f18237o = new C25804(this);
        return eventPermalinkEnvironmentGeneratedProvider.m19053a(eventPermalinkFragment, this.f18224b, EventsFeedListType.f17454a, new C25815(this), null, new C25836(this));
    }

    public final void mo829b() {
        m18613k();
        notifyDataSetChanged();
    }

    public final void mo825a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        boolean z;
        this.f18240r = event;
        if (event != null) {
            GraphQLConnectionStyle graphQLConnectionStyle = this.f18240r.l;
            z = true;
        } else {
            z = false;
        }
        this.f18220I = z;
        this.f18225c.m18521a(event, fetchEventPermalinkFragmentModel, this.f18220I);
        this.f18227e.m18514a(event);
        this.f18233k.m18526a(event, fetchEventPermalinkFragmentModel);
        m18613k();
    }

    public final void m18609e(int i) {
        int l = this.f18242t.l();
        int n = this.f18242t.n();
        AdapterWithOffsets e = m18586e(l, n);
        if (e != null) {
            if (i > 0 && this.f18217F.m19192a() && this.f18219H != null) {
                Pair a = e.m18507a(l, n);
                if (a != null) {
                    this.f18219H.a(this.f18241s.now(), ((Integer) a.first).intValue(), ((Integer) a.second).intValue());
                }
            }
            l = this.f18238p.aZ_() - 1;
            if (l >= 0) {
                if (this.f18238p.f(Math.min(e.m18506a(n), l) - this.f18238p.f()) >= this.f18238p.f(this.f18238p.d()) - 2) {
                    this.f18238p.h();
                }
            }
        }
    }

    @Nullable
    private AdapterWithOffsets m18586e(int i, int i2) {
        while (i <= i2) {
            if (this.f18248z.a(Integer.valueOf(i)) != null && ((AdapterWithOffsets) this.f18248z.a(Integer.valueOf(i))).f18135a == this.f18238p) {
                return (AdapterWithOffsets) this.f18248z.a(Integer.valueOf(i));
            }
            i++;
        }
        return null;
    }

    public final void mo832c() {
        this.f18225c.m18519a();
        m18613k();
        notifyDataSetChanged();
    }

    public final void m18605b(boolean z) {
        this.f18239q.f18254b = z;
        m18613k();
        notifyDataSetChanged();
    }

    public final void mo824a(BoostableStoryModel boostableStoryModel) {
        EventPermalinkStandardActionBar o = m18588o();
        if (o != null) {
            o.setBoostableStory(boostableStoryModel);
        }
    }

    public final void mo826a(GraphQLStory graphQLStory) {
        this.f18226d.m18547a(graphQLStory);
        m18613k();
    }

    public final void mo830b(GraphQLStory graphQLStory) {
    }

    @Nullable
    public final GraphQLStory mo833d() {
        return this.f18226d.m18549b();
    }

    public final void mo823a(FeedUnitCollection feedUnitCollection) {
        GraphQLStory b = this.f18226d.m18549b();
        if (b != null) {
            Function function = this.f18237o;
            if (b.g() == null) {
                function.apply(feedUnitCollection.b(b.ai()));
                return;
            }
            for (GraphQLFeedUnitEdge graphQLFeedUnitEdge : feedUnitCollection.a(b.g())) {
                if (graphQLFeedUnitEdge.c() instanceof GraphQLStory) {
                    FeedProps a = StoryProps.a(FeedProps.c((GraphQLStory) graphQLFeedUnitEdge.c()), b.g());
                    if (a != null) {
                        function.apply(a.a);
                    }
                }
            }
        }
    }

    @Nullable
    private EventPermalinkStandardActionBar m18588o() {
        if (this.f18215D != null) {
            return (EventPermalinkStandardActionBar) ViewDiagnosticsWrapper.a(this.f18215D.d(2131558633));
        }
        return null;
    }

    public final void m18613k() {
        if (this.f18240r != null) {
            this.f18230h.notifyDataSetChanged();
            this.f18229g.notifyDataSetChanged();
            ImmutableList.Builder builder = new ImmutableList.Builder();
            Builder builder2 = new Builder();
            ImmutableList p = m18589p();
            int size = p.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ReactionMixedRecyclerViewAdapter reactionMixedRecyclerViewAdapter = p.get(i2);
                if (reactionMixedRecyclerViewAdapter instanceof FbListAdapter) {
                    int i3;
                    FbListAdapter fbListAdapter = (FbListAdapter) reactionMixedRecyclerViewAdapter;
                    int count = fbListAdapter.getCount();
                    if (count > 0) {
                        AdapterWithOffsets adapterWithOffsets = new AdapterWithOffsets(fbListAdapter, i, ((Integer) this.f18213B.get(fbListAdapter)).intValue());
                        if (fbListAdapter == this.f18229g) {
                            this.f18246x = adapterWithOffsets;
                        }
                        builder.c(adapterWithOffsets);
                        builder2.a(Range.b(Integer.valueOf(i), Integer.valueOf(i + count)), adapterWithOffsets);
                        i3 = i + count;
                    } else {
                        i3 = i;
                    }
                    i = i3;
                } else if (this.f18216E && reactionMixedRecyclerViewAdapter == this.f18238p) {
                    int aZ_ = this.f18238p.aZ_();
                    AdapterWithOffsets adapterWithOffsets2 = new AdapterWithOffsets(reactionMixedRecyclerViewAdapter, i, this.f18235m);
                    builder2.a(Range.b(Integer.valueOf(i), Integer.valueOf(i + aZ_)), adapterWithOffsets2);
                    builder.c(adapterWithOffsets2);
                    i += aZ_;
                }
            }
            this.f18247y = builder.b();
            this.f18248z = builder2.a();
            this.f18214C = i;
        }
    }

    private ImmutableList<Object> m18589p() {
        boolean z;
        if (this.f18240r.l == GraphQLConnectionStyle.INTERESTED) {
            z = true;
        } else {
            z = false;
        }
        this.f18239q.f18255c = z;
        if (!z) {
            z = this.f18222K.a(ExperimentsForEventsGatingModule.Y, false);
            ImmutableList.Builder builder = new ImmutableList.Builder();
            builder.b(new Object[]{this.f18225c, this.f18230h, this.f18238p});
            if (z) {
                builder.c(this.f18239q);
            }
            builder.c(this.f18229g);
            return builder.b();
        } else if (this.f18217F.m19192a()) {
            return ImmutableList.of(this.f18225c, this.f18232j, this.f18230h, this.f18238p, this.f18239q, this.f18231i);
        } else {
            return ImmutableList.of(this.f18225c, this.f18232j, this.f18230h, this.f18233k, this.f18229g, this.f18231i);
        }
    }

    public boolean isEmpty() {
        return this.f18214C == 0;
    }

    public final int aZ_() {
        return this.f18214C;
    }

    public static void m18584a(EventPermalinkRecyclerViewAdapter eventPermalinkRecyclerViewAdapter, Parcelable parcelable, boolean z) {
        if (z) {
            if (eventPermalinkRecyclerViewAdapter.f18217F.m19192a()) {
                eventPermalinkRecyclerViewAdapter.f18221J.f18211b = parcelable;
            } else {
                eventPermalinkRecyclerViewAdapter.f18221J.f18210a = parcelable;
            }
        } else if (eventPermalinkRecyclerViewAdapter.f18217F.m19192a()) {
            eventPermalinkRecyclerViewAdapter.f18221J.f18210a = parcelable;
        } else {
            eventPermalinkRecyclerViewAdapter.f18221J.f18211b = parcelable;
        }
    }

    public static void m18590q(EventPermalinkRecyclerViewAdapter eventPermalinkRecyclerViewAdapter) {
        AdapterWithOffsets adapterWithOffsets;
        EventPermalinkTabsBarAdapter eventPermalinkTabsBarAdapter = eventPermalinkRecyclerViewAdapter.f18232j;
        int size = eventPermalinkRecyclerViewAdapter.f18247y.size();
        for (int i = 0; i < size; i++) {
            adapterWithOffsets = (AdapterWithOffsets) eventPermalinkRecyclerViewAdapter.f18247y.get(i);
            if (Objects.equal(adapterWithOffsets.f18135a, eventPermalinkTabsBarAdapter)) {
                break;
            }
        }
        adapterWithOffsets = null;
        AdapterWithOffsets adapterWithOffsets2 = adapterWithOffsets;
        int b = eventPermalinkRecyclerViewAdapter.f18217F.m19193b();
        if (eventPermalinkRecyclerViewAdapter.f18217F != null && adapterWithOffsets2 != null) {
            eventPermalinkRecyclerViewAdapter.f18215D.c(adapterWithOffsets2.f18136b, b);
            StickyTabBarController stickyTabBarController = eventPermalinkRecyclerViewAdapter.f18217F;
            if (stickyTabBarController.f18947a != null) {
                stickyTabBarController.f18947a.setVisibility(0);
            }
        }
    }

    public final ViewHolder m18591a(ViewGroup viewGroup, int i) {
        if (i > 16777215) {
            return this.f18238p.a(viewGroup, i);
        }
        if (i >= this.f18235m) {
            return this.f18238p.a(viewGroup, i - this.f18235m);
        }
        AdapterWithOffsets adapterWithOffsets = (AdapterWithOffsets) this.f18212A.a(Integer.valueOf(i));
        if (adapterWithOffsets == null) {
            return null;
        }
        FbListAdapter fbListAdapter = (FbListAdapter) adapterWithOffsets.f18135a;
        int i2 = i - adapterWithOffsets.f18137c;
        View a = fbListAdapter.a(i2, viewGroup);
        Preconditions.checkState(a != null, "Unexpected null view from getView()");
        if (fbListAdapter == this.f18229g || fbListAdapter == this.f18230h) {
            return new EventPermalinkFeedStoryViewHolder(a, viewGroup, i2);
        }
        if (fbListAdapter == this.f18232j && i2 == ViewType.TAB_BAR.ordinal()) {
            this.f18217F.m19191a(new EventPermalinkTabBarViewHolder(a, viewGroup, i2));
        }
        return new EventPermalinkViewHolder(a, viewGroup, i2);
    }

    public final void m18594a(ViewHolder viewHolder, int i) {
        AdapterWithOffsets adapterWithOffsets = (AdapterWithOffsets) this.f18248z.a(Integer.valueOf(i));
        if (adapterWithOffsets != null) {
            int a = adapterWithOffsets.m18506a(i);
            if (adapterWithOffsets.m18511c()) {
                adapterWithOffsets.m18510b().a(viewHolder, a);
                return;
            }
            EventPermalinkViewHolder eventPermalinkViewHolder = (EventPermalinkViewHolder) viewHolder;
            FbListAdapter a2 = adapterWithOffsets.m18508a();
            a2.a(a, a2.getItem(a), eventPermalinkViewHolder.a, eventPermalinkViewHolder.f18209m, eventPermalinkViewHolder.f18208l);
        }
    }

    public final void m18593a(ViewHolder viewHolder) {
        super.a(viewHolder);
        if (viewHolder instanceof EventPermalinkFeedStoryViewHolder) {
            MultipleRowsStoriesRecycleCallback.a(viewHolder.a);
        } else if (!(viewHolder instanceof EventPermalinkViewHolder)) {
            MultipleRowsStoriesRecycleCallback.a(viewHolder.a);
        }
    }

    public final void m18602b(RecyclerView recyclerView) {
        super.b(recyclerView);
        this.f18243u.b(this.f18218G);
    }

    public final long H_(int i) {
        AdapterWithOffsets adapterWithOffsets = (AdapterWithOffsets) this.f18248z.a(Integer.valueOf(i));
        if (adapterWithOffsets == null) {
            return 0;
        }
        int a = adapterWithOffsets.m18506a(i);
        if (adapterWithOffsets.m18511c()) {
            return this.f18238p.H_(a);
        }
        return adapterWithOffsets.m18508a().getItemId(a);
    }

    public int getItemViewType(int i) {
        AdapterWithOffsets adapterWithOffsets = (AdapterWithOffsets) this.f18248z.a(Integer.valueOf(i));
        Preconditions.checkNotNull(adapterWithOffsets);
        int a = adapterWithOffsets.m18506a(i);
        a = adapterWithOffsets.m18511c() ? adapterWithOffsets.m18510b().getItemViewType(a) : adapterWithOffsets.m18508a().getItemViewType(a);
        if (a > 16777215) {
            return a;
        }
        return adapterWithOffsets.m18509b(a);
    }

    public final void mo828a(boolean z, boolean z2) {
        this.f18225c.f18151j = z;
        this.f18225c.f18152k = z2;
        EventPermalinkStandardActionBar o = m18588o();
        if (o == null) {
            return;
        }
        if (z) {
            o.mo819a();
        } else {
            o.mo820a(z2);
        }
    }

    public final void mo836g() {
        m18585d(true);
    }

    public final void mo834e() {
        m18585d(false);
    }

    private void m18585d(boolean z) {
        this.f18226d.m18548a(z);
        m18613k();
        notifyDataSetChanged();
    }

    public final void mo835f() {
        this.f18229g.jc_();
        if (this.f18219H != null && this.f18217F.m19192a()) {
            this.f18219H.c();
        }
    }

    public final void mo822a(int i, int i2, int i3) {
        Object obj;
        if (this.f18240r != null && EventPermalinkBazingaHelper.a(this.f18240r.l) && this.f18217F.m19192a()) {
            obj = null;
        } else {
            Object obj2;
            FeedUnitCollection feedUnitCollection = this.f18226d.f18167e;
            if (feedUnitCollection == null || feedUnitCollection.v()) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null || this.f18245w.f17362p) {
                obj = null;
            } else {
                int i4 = (i + i2) - 1;
                if (i2 <= 0) {
                    obj = null;
                } else if (this.f18246x == null || this.f18246x.f18135a == null) {
                    obj = null;
                } else {
                    Pair a = this.f18246x.m18507a(i, i4);
                    obj = (a == null || ((Integer) a.second).intValue() + 5 <= this.f18246x.m18508a().getCount()) ? null : 1;
                }
            }
        }
        if (obj != null) {
            this.f18245w.m17674c();
        }
    }
}
