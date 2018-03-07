package com.facebook.events.permalink.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.feed.data.EventFeedPager;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLModels.EventPinnedPostAndRecentStoryFragmentModel.BoostableStoryModel;
import com.facebook.events.feed.ui.EventFeedStoryPinMutator.StoryUpdater;
import com.facebook.events.feed.ui.EventsFeedListType;
import com.facebook.events.feed.ui.environment.EventFeedEnvironmentGeneratedProvider;
import com.facebook.events.gating.EventPermalinkBazingaHelper;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.model.Event;
import com.facebook.events.permalink.actionbar.ActionItemInvite;
import com.facebook.events.permalink.actionbar.ActionItemPost;
import com.facebook.events.permalink.actionbar.EventPermalinkStandardActionBar;
import com.facebook.events.permalink.calltoaction.EventCallToActionController;
import com.facebook.events.permalink.calltoaction.EventCheckinButtonController;
import com.facebook.events.permalink.pinnedpost.PinnedPostGroupPartDefinition;
import com.facebook.events.permalink.summary.EventSummaryContextRowsStateTracker;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.rows.NewsFeedRootGroupPartDefinition;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.OneItemListItemCollection;
import com.facebook.feed.rows.adapter.api.ListItemCollectionEndProvider;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.BaseProxyOnScrollListener;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.RecyclerListener;
import com.facebook.widget.viewdiagnostics.ViewDiagnosticsWrapper;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.ImmutableRangeMap.Builder;
import com.google.common.collect.Range;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: buttons */
public class EventPermalinkListAdapter extends BaseAdapter implements EventPermalinkAdapter<ListViewProxy> {
    private final Context f18177a;
    private final EventInfoAdapter f18178b;
    private final EventPendingPostsAdapter f18179c;
    private final OneItemListItemCollection<GraphQLStory> f18180d = new OneItemListItemCollection();
    public final MultiRowAdapter f18181e;
    private final PostingStoryProgressBarAdapter f18182f;
    @Nullable
    public final MultiRowAdapter f18183g;
    @Nullable
    private final MultiRowAdapter f18184h;
    @Nullable
    private final Function<GraphQLStory, Void> f18185i;
    @Nullable
    private final OneItemListItemCollection<GraphQLStory> f18186j;
    private final ComposerActionBarAdapter f18187k;
    private final ImmutableList<FbListAdapter> f18188l;
    private final MultipleRowsStoriesRecycleCallback f18189m;
    private final int f18190n;
    private final Function<GraphQLStory, Void> f18191o = new C25701(this);
    private final EventPermalinkBazingaHelper f18192p;
    private final EventFeedPager f18193q;
    private ImmutableRangeMap<Integer, AdapterWithOffsets<FbListAdapter>> f18194r;
    private int f18195s;
    public ScrollingViewProxy f18196t;
    private boolean f18197u;

    /* compiled from: buttons */
    class C25701 implements Function<GraphQLStory, Void> {
        final /* synthetic */ EventPermalinkListAdapter f18168a;

        C25701(EventPermalinkListAdapter eventPermalinkListAdapter) {
            this.f18168a = eventPermalinkListAdapter;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            this.f18168a.mo826a((GraphQLStory) obj);
            return null;
        }
    }

    /* compiled from: buttons */
    class C25712 implements Runnable {
        final /* synthetic */ EventPermalinkListAdapter f18169a;

        C25712(EventPermalinkListAdapter eventPermalinkListAdapter) {
            this.f18169a = eventPermalinkListAdapter;
        }

        public void run() {
            this.f18169a.f18181e.notifyDataSetChanged();
            this.f18169a.mo829b();
        }
    }

    /* compiled from: buttons */
    class C25734 implements Runnable {
        final /* synthetic */ EventPermalinkListAdapter f18172a;

        C25734(EventPermalinkListAdapter eventPermalinkListAdapter) {
            this.f18172a = eventPermalinkListAdapter;
        }

        public void run() {
            this.f18172a.mo829b();
        }
    }

    /* compiled from: buttons */
    class C25755 implements Delegate {
        final /* synthetic */ EventPermalinkListAdapter f18175a;

        C25755(EventPermalinkListAdapter eventPermalinkListAdapter) {
            this.f18175a = eventPermalinkListAdapter;
        }

        public final void m18552a(final HasScrollListenerSupportImpl hasScrollListenerSupportImpl) {
            this.f18175a.f18196t.b(new BaseProxyOnScrollListener(this) {
                final /* synthetic */ C25755 f18174b;

                public final void m18551a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
                    hasScrollListenerSupportImpl.b();
                }
            });
        }
    }

    /* compiled from: buttons */
    class C25766 implements RecyclerListener {
        final /* synthetic */ EventPermalinkListAdapter f18176a;

        C25766(EventPermalinkListAdapter eventPermalinkListAdapter) {
            this.f18176a = eventPermalinkListAdapter;
        }

        public final void m18553a(View view) {
            MultipleRowsStoriesRecycleCallback.a(view);
        }
    }

    public final void mo827a(ScrollingViewProxy scrollingViewProxy) {
        this.f18196t = (ListViewProxy) scrollingViewProxy;
        this.f18196t.a(new C25766(this));
    }

    public final void mo831b(ScrollingViewProxy scrollingViewProxy) {
        ((ListViewProxy) scrollingViewProxy).a(this);
    }

    @Inject
    public EventPermalinkListAdapter(@Assisted final EventFeedPager eventFeedPager, @Assisted ActionItemPost actionItemPost, @Assisted ActionItemInvite actionItemInvite, @Assisted EventAnalyticsParams eventAnalyticsParams, @Assisted StoryUpdater storyUpdater, @Assisted Context context, @Assisted EventCheckinButtonController eventCheckinButtonController, MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<PinnedPostGroupPartDefinition> lazy, Lazy<NewsFeedRootGroupPartDefinition> lazy2, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, EventFeedEnvironmentGeneratedProvider eventFeedEnvironmentGeneratedProvider, EventCallToActionController eventCallToActionController, EventPendingPostsAdapter eventPendingPostsAdapter, EventPermalinkBazingaHelper eventPermalinkBazingaHelper, EventSummaryContextRowsStateTracker eventSummaryContextRowsStateTracker, QeAccessor qeAccessor) {
        this.f18193q = eventFeedPager;
        this.f18177a = context;
        this.f18192p = eventPermalinkBazingaHelper;
        this.f18178b = new EventInfoAdapter(this.f18177a, actionItemPost, actionItemInvite, eventCallToActionController, eventAnalyticsParams, eventCheckinButtonController, eventPermalinkBazingaHelper, eventSummaryContextRowsStateTracker, qeAccessor);
        this.f18189m = multipleRowsStoriesRecycleCallback;
        this.f18181e = multiRowAdapterBuilder.a(lazy, this.f18180d).a(eventFeedEnvironmentGeneratedProvider.m17841a(storyUpdater, this.f18177a, EventsFeedListType.m17802b(), new C25712(this), null, m18556h())).e();
        this.f18182f = new PostingStoryProgressBarAdapter(this.f18177a);
        this.f18187k = new ComposerActionBarAdapter(context, actionItemPost);
        this.f18179c = eventPendingPostsAdapter;
        this.f18186j = null;
        this.f18185i = null;
        this.f18184h = null;
        C25723 c25723 = new ListItemCollectionEndProvider(this) {
            final /* synthetic */ EventPermalinkListAdapter f18171b;

            public final boolean m18550a() {
                return !eventFeedPager.f17362p;
            }
        };
        this.f18183g = multiRowAdapterBuilder.a(lazy2, eventFeedPager.m17675e()).a(c25723).a(eventFeedEnvironmentGeneratedProvider.m17841a(storyUpdater, this.f18177a, EventsFeedListType.m17802b(), new C25734(this), null, m18556h())).e();
        this.f18188l = ImmutableList.of(this.f18178b, this.f18187k, this.f18179c, this.f18181e, this.f18182f, this.f18183g);
        int i = 0;
        for (int i2 = 0; i2 < this.f18188l.size(); i2++) {
            i += ((FbListAdapter) this.f18188l.get(i2)).getViewTypeCount();
        }
        this.f18190n = i;
    }

    public final void mo829b() {
        if (this.f18183g != null) {
            this.f18183g.notifyDataSetChanged();
            m18558j();
            AdapterDetour.a(this, -319134976);
        }
    }

    private Delegate m18556h() {
        return new C25755(this);
    }

    public final void mo825a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        boolean z;
        if (event != null) {
            GraphQLConnectionStyle graphQLConnectionStyle = event.l;
            z = true;
        } else {
            z = false;
        }
        this.f18197u = z;
        this.f18178b.m18521a(event, fetchEventPermalinkFragmentModel, this.f18197u);
        this.f18187k.f18140c = event;
        this.f18179c.m18526a(event, fetchEventPermalinkFragmentModel);
        m18558j();
    }

    public final void mo832c() {
        this.f18178b.m18519a();
        m18558j();
        AdapterDetour.a(this, 2089975681);
    }

    public final void mo824a(BoostableStoryModel boostableStoryModel) {
        EventPermalinkStandardActionBar i = m18557i();
        if (i != null) {
            i.setBoostableStory(boostableStoryModel);
        }
    }

    public final void mo826a(GraphQLStory graphQLStory) {
        this.f18180d.a = graphQLStory;
        this.f18181e.notifyDataSetChanged();
        m18558j();
    }

    public final void mo830b(GraphQLStory graphQLStory) {
        if (this.f18186j != null && this.f18184h != null) {
            this.f18186j.a = graphQLStory;
            this.f18184h.notifyDataSetChanged();
            m18558j();
        }
    }

    @Nullable
    public final GraphQLStory mo833d() {
        if (this.f18180d.a() == 0) {
            return null;
        }
        return (GraphQLStory) this.f18180d.a(0);
    }

    public final void mo823a(FeedUnitCollection feedUnitCollection) {
        m18554a(feedUnitCollection, this.f18180d, this.f18191o);
        if (this.f18186j != null && this.f18185i != null) {
            m18554a(feedUnitCollection, this.f18186j, this.f18185i);
        }
    }

    private static void m18554a(FeedUnitCollection feedUnitCollection, OneItemListItemCollection<GraphQLStory> oneItemListItemCollection, Function<GraphQLStory, Void> function) {
        if (oneItemListItemCollection.a() != 0) {
            GraphQLStory graphQLStory = (GraphQLStory) oneItemListItemCollection.a(0);
            if (graphQLStory.g() == null) {
                function.apply(feedUnitCollection.b(graphQLStory.ai()));
                return;
            }
            for (GraphQLFeedUnitEdge graphQLFeedUnitEdge : feedUnitCollection.a(graphQLStory.g())) {
                if (graphQLFeedUnitEdge.c() instanceof GraphQLStory) {
                    FeedProps a = StoryProps.a(FeedProps.c((GraphQLStory) graphQLFeedUnitEdge.c()), graphQLStory.g());
                    if (a != null) {
                        function.apply(a.a);
                    }
                }
            }
        }
    }

    @Nullable
    private EventPermalinkStandardActionBar m18557i() {
        if (this.f18196t != null) {
            return (EventPermalinkStandardActionBar) ViewDiagnosticsWrapper.a(this.f18196t.d(2131558633));
        }
        return null;
    }

    private void m18558j() {
        Builder builder = new Builder();
        int size = this.f18188l.size();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < size) {
            int i4;
            FbListAdapter fbListAdapter = (FbListAdapter) this.f18188l.get(i);
            int count = fbListAdapter.getCount();
            int viewTypeCount = fbListAdapter.getViewTypeCount();
            if (count > 0) {
                builder.a(Range.b(Integer.valueOf(i3), Integer.valueOf(i3 + count)), new AdapterWithOffsets(fbListAdapter, i3, i2));
                i4 = i3 + count;
            } else {
                i4 = i3;
            }
            i2 += viewTypeCount;
            i++;
            i3 = i4;
        }
        this.f18194r = builder.a();
        this.f18195s = i3;
    }

    public int getCount() {
        return this.f18195s;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        AdapterWithOffsets adapterWithOffsets = (AdapterWithOffsets) this.f18194r.a(Integer.valueOf(i));
        if (adapterWithOffsets == null) {
            return null;
        }
        View view2 = ((FbListAdapter) adapterWithOffsets.f18135a).getView(adapterWithOffsets.m18506a(i), view, viewGroup);
        Preconditions.checkState(view2 != null, "Unexpected null view from getView()");
        return view2;
    }

    public Object getItem(int i) {
        AdapterWithOffsets adapterWithOffsets = (AdapterWithOffsets) this.f18194r.a(Integer.valueOf(i));
        if (adapterWithOffsets == null) {
            return null;
        }
        return ((FbListAdapter) adapterWithOffsets.f18135a).getItem(adapterWithOffsets.m18506a(i));
    }

    public int getItemViewType(int i) {
        AdapterWithOffsets adapterWithOffsets = (AdapterWithOffsets) this.f18194r.a(Integer.valueOf(i));
        if (adapterWithOffsets == null) {
            return -1;
        }
        return adapterWithOffsets.m18509b(((FbListAdapter) adapterWithOffsets.f18135a).getItemViewType(adapterWithOffsets.m18506a(i)));
    }

    public int getViewTypeCount() {
        return this.f18190n;
    }

    public long getItemId(int i) {
        AdapterWithOffsets adapterWithOffsets = (AdapterWithOffsets) this.f18194r.a(Integer.valueOf(i));
        if (adapterWithOffsets == null) {
            return 0;
        }
        return ((FbListAdapter) adapterWithOffsets.f18135a).getItemId(adapterWithOffsets.m18506a(i));
    }

    public final void mo828a(boolean z, boolean z2) {
        this.f18178b.f18151j = z;
        this.f18178b.f18152k = z2;
        EventPermalinkStandardActionBar i = m18557i();
        if (i == null) {
            return;
        }
        if (z) {
            i.mo819a();
        } else {
            i.mo820a(z2);
        }
    }

    public final void mo836g() {
        m18555a(true);
    }

    public final void mo834e() {
        m18555a(false);
    }

    private void m18555a(boolean z) {
        this.f18182f.f18257b = z;
        m18558j();
        AdapterDetour.a(this, 1193642810);
    }

    public final void mo835f() {
        this.f18181e.jc_();
        if (this.f18184h != null) {
            this.f18184h.jc_();
        }
        if (this.f18183g != null) {
            this.f18183g.jc_();
        }
    }

    public final void mo822a(int i, int i2, int i3) {
        Object obj = null;
        Object obj2 = (this.f18183g == null || this.f18183g.isEmpty()) ? 1 : null;
        if (obj2 == null && i2 > 0 && i3 > 0 && (i + i2) + 5 > i3) {
            obj = 1;
        }
        if (obj != null) {
            this.f18193q.m17674c();
        }
    }
}
