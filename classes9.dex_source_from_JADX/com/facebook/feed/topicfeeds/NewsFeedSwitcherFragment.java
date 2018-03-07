package com.facebook.feed.topicfeeds;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.api.feedtype.newsfeed.NewsFeedType;
import com.facebook.api.feedtype.newsfeed.NewsFeedTypeValue;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bugreporter.activity.ComponentWithDebugInfo;
import com.facebook.bugreporter.activity.FragmentWithDebugInfo;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.debug.dumpsys.DumpsysContext;
import com.facebook.debug.dumpsys.DumpsysDumpable;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.diode.abtest.ExperimentsForFeedDiodeTestModule;
import com.facebook.feed.fragment.NewsFeedFragment.Builder;
import com.facebook.feed.goodfriends.GoodFriendsFeedFragment;
import com.facebook.feed.goodfriends.nux.GoodFriendsNuxController;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.topicfeeds.TopicFeedsNavigationLogger.NavigationEventType;
import com.facebook.feed.topicfeeds.abtest.TopicFeedsTestUtil;
import com.facebook.feed.topicfeeds.events.TopicFeedsEventBus;
import com.facebook.feed.topicfeeds.events.TopicFeedsEvents.TopicFeedsListItemToggledEvent;
import com.facebook.feed.topicfeeds.events.TopicFeedsEvents.TopicFeedsListItemToggledEventSubscriber;
import com.facebook.feed.topicfeeds.events.TopicFeedsEvents.TopicFeedsListUpdatedEvent;
import com.facebook.feed.topicfeeds.events.TopicFeedsEvents.TopicFeedsListUpdatedEventSubscriber;
import com.facebook.feed.topicfeeds.events.TopicFeedsEvents.UpdatedState;
import com.facebook.feed.topicfeeds.favorites.TopicFeedFavoritesFragment;
import com.facebook.feed.topicfeeds.nux.TopicFeedsSwitcherInterstitialController;
import com.facebook.feed.topicfeeds.switcher.FeedSwitcherAdapter;
import com.facebook.feed.topicfeeds.switcher.FeedSwitcherAdapterProvider;
import com.facebook.feed.topicfeeds.switcher.FeedSwitcherItem;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.goodfriends.analytics.GoodFriendsAnalyticsLogger.Event;
import com.facebook.graphql.calls.FeedStyleInputStyle;
import com.facebook.graphql.calls.OrderbyInputNewsFeedOrdering;
import com.facebook.graphql.calls.TopicProjectInputTopicProject;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.InterstitialStartHelper;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.interfaces.GraphSearchTitleSupport;
import com.facebook.topics.data.TopicListFetcher;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedFragmentModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedListModel;
import com.facebook.topics.protocol.TopicModelHelper;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.listview.ScrollableListContainer;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.recyclerview.JustifiedLinearLayoutManager;
import com.facebook.widget.text.AllCapsTransformationMethod;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

@GraphSearchTitleSupport
/* compiled from: TT2; */
public class NewsFeedSwitcherFragment extends FbFragment implements AnalyticsFragment, CanHandleBackPressed, FragmentWithDebugInfo, DumpsysDumpable, ScrollableListContainer {
    private static final String an = NewsFeedSwitcherFragment.class.getSimpleName();
    public static final String ao = FeedType.b.a();
    @Inject
    Lazy<FbErrorReporter> f24551a;
    public boolean aA = false;
    private AllCapsTransformationMethod aB;
    public TopicFeedListModel aC;
    public List<FeedSwitcherItem> aD = new ArrayList();
    public FeedSwitcherItem aE;
    private FeedSwitcherItem aF;
    private FeedSwitcherItem aG;
    public FeedSwitcherItem aH;
    public int aI = -1;
    public boolean aJ;
    @Inject
    QeAccessor al;
    @Inject
    GatekeeperStoreImpl am;
    private final TopicsListItemToggledEventSubscriber ap = new TopicsListItemToggledEventSubscriber(this);
    private final TopicsListUpdatedEventSubscriber aq = new TopicsListUpdatedEventSubscriber(this);
    public final List<FeedSwitcherItem> ar = new ArrayList();
    public RecyclerView as;
    public FragmentPagerController at;
    public NewsFeedSwitcherFragmentPagerAdapter au;
    private LinearLayoutManager av;
    public FeedSwitcherAdapter aw;
    public Builder ax;
    private boolean ay = false;
    public boolean az = false;
    @Inject
    FeedSwitcherAdapterProvider f24552b;
    @Inject
    public TopicListFetcher f24553c;
    @Inject
    TopicFeedsEventBus f24554d;
    @Inject
    public Lazy<InterstitialStartHelper> f24555e;
    @Inject
    FeedLoggingViewportEventListener f24556f;
    @Inject
    TopicFeedsTestUtil f24557g;
    @Inject
    GoodFriendsNuxController f24558h;
    @Inject
    TopicFeedsNavigationLogger f24559i;

    /* compiled from: TT2; */
    public class C29531 {
        public final /* synthetic */ NewsFeedSwitcherFragment f24538a;

        C29531(NewsFeedSwitcherFragment newsFeedSwitcherFragment) {
            this.f24538a = newsFeedSwitcherFragment;
        }
    }

    /* compiled from: TT2; */
    public class C29542 {
        public final /* synthetic */ NewsFeedSwitcherFragment f24539a;

        C29542(NewsFeedSwitcherFragment newsFeedSwitcherFragment) {
            this.f24539a = newsFeedSwitcherFragment;
        }
    }

    /* compiled from: TT2; */
    class C29553 implements OnGlobalLayoutListener {
        final /* synthetic */ NewsFeedSwitcherFragment f24540a;

        C29553(NewsFeedSwitcherFragment newsFeedSwitcherFragment) {
            this.f24540a = newsFeedSwitcherFragment;
        }

        public void onGlobalLayout() {
            this.f24540a.as.a(this.f24540a.aI);
            CustomViewUtils.a(this.f24540a.as, this);
        }
    }

    /* compiled from: TT2; */
    class C29564 implements OnTouchListener {
        final /* synthetic */ NewsFeedSwitcherFragment f24541a;

        C29564(NewsFeedSwitcherFragment newsFeedSwitcherFragment) {
            this.f24541a = newsFeedSwitcherFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getActionMasked()) {
                case 1:
                    this.f24541a.as.getParent().requestDisallowInterceptTouchEvent(false);
                    break;
                case 2:
                    this.f24541a.as.getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                case 3:
                    this.f24541a.as.getParent().requestDisallowInterceptTouchEvent(false);
                    return true;
            }
            return false;
        }
    }

    /* compiled from: TT2; */
    public class C29575 extends AbstractDisposableFutureCallback<GraphQLResult<TopicFeedListModel>> {
        final /* synthetic */ NewsFeedSwitcherFragment f24542a;

        public C29575(NewsFeedSwitcherFragment newsFeedSwitcherFragment) {
            this.f24542a = newsFeedSwitcherFragment;
        }

        public final void m26448a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null) {
                this.f24542a.aC = (TopicFeedListModel) graphQLResult.e;
                this.f24542a.aD = NewsFeedSwitcherFragment.m26460a(this.f24542a, this.f24542a.aC);
                NewsFeedSwitcherFragment.aB(this.f24542a);
                NewsFeedSwitcherFragment.au(this.f24542a);
                NewsFeedSwitcherFragment newsFeedSwitcherFragment = this.f24542a;
                ((InterstitialStartHelper) newsFeedSwitcherFragment.f24555e.get()).a(newsFeedSwitcherFragment.getContext(), new InterstitialTrigger(Action.FEED_STORY_LOADED), TopicFeedsSwitcherInterstitialController.class, newsFeedSwitcherFragment.as);
                this.f24542a.aw.notifyDataSetChanged();
            }
        }

        public final void m26449a(Throwable th) {
            ((AbstractFbErrorReporter) this.f24542a.f24551a.get()).a("feeds_switcher_load_topics_failed", "GraphQL query to load topics failed", th);
            if (!this.f24542a.az) {
                this.f24542a.as.setVisibility(8);
            }
        }
    }

    /* compiled from: TT2; */
    public class NewsFeedSwitcherFragmentPagerAdapter {
        public final /* synthetic */ NewsFeedSwitcherFragment f24547a;
        public final BiMap<String, Fragment> f24548b = HashBiMap.a();

        public NewsFeedSwitcherFragmentPagerAdapter(NewsFeedSwitcherFragment newsFeedSwitcherFragment) {
            this.f24547a = newsFeedSwitcherFragment;
        }

        public final Fragment m26454a(int i) {
            FeedSwitcherItem feedSwitcherItem = (FeedSwitcherItem) this.f24547a.ar.get(i);
            String str = feedSwitcherItem.f24534b;
            if (!this.f24548b.containsKey(str)) {
                this.f24548b.put(str, feedSwitcherItem.mo1155d());
            }
            return (Fragment) this.f24548b.get(str);
        }
    }

    /* compiled from: TT2; */
    class TopicsListItemToggledEventSubscriber extends TopicFeedsListItemToggledEventSubscriber {
        final /* synthetic */ NewsFeedSwitcherFragment f24549a;

        public TopicsListItemToggledEventSubscriber(NewsFeedSwitcherFragment newsFeedSwitcherFragment) {
            this.f24549a = newsFeedSwitcherFragment;
        }

        public final void m26456b(FbEvent fbEvent) {
            int i;
            TopicFeedsListItemToggledEvent topicFeedsListItemToggledEvent = (TopicFeedsListItemToggledEvent) fbEvent;
            TopicFeedFragmentModel topicFeedFragmentModel = topicFeedsListItemToggledEvent.f24595b;
            ImmutableList a = this.f24549a.aC.a();
            int size = a.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                if (StringUtil.a(((TopicFeedFragmentModel) a.get(i2)).fb_(), topicFeedFragmentModel.fb_())) {
                    i = i3;
                    break;
                } else {
                    i3++;
                    i2++;
                }
            }
            i = -1;
            int i4 = i;
            this.f24549a.aC = TopicModelHelper.a(topicFeedsListItemToggledEvent.f24596c);
            this.f24549a.aD = NewsFeedSwitcherFragment.m26460a(this.f24549a, this.f24549a.aC);
            NewsFeedSwitcherFragment.aB(this.f24549a);
            if (topicFeedsListItemToggledEvent.f24594a == UpdatedState.FAVORITE_INSERTED) {
                this.f24549a.aw.k_(NewsFeedSwitcherFragment.m26459a(this.f24549a, topicFeedsListItemToggledEvent.f24595b.fb_()));
            } else {
                this.f24549a.aw.l_(i4 + 1);
            }
            i4 = NewsFeedSwitcherFragment.m26459a(this.f24549a, "more");
            if (i4 == -1) {
                ((AbstractFbErrorReporter) this.f24549a.f24551a.get()).b(this.f24549a.getClass().getSimpleName(), "Trying to set current position to an invalid topic after toggling a topic.");
            } else {
                NewsFeedSwitcherFragment.m26472h(this.f24549a, i4);
            }
        }
    }

    /* compiled from: TT2; */
    class TopicsListUpdatedEventSubscriber extends TopicFeedsListUpdatedEventSubscriber {
        final /* synthetic */ NewsFeedSwitcherFragment f24550a;

        public TopicsListUpdatedEventSubscriber(NewsFeedSwitcherFragment newsFeedSwitcherFragment) {
            this.f24550a = newsFeedSwitcherFragment;
        }

        public final void m26458b(FbEvent fbEvent) {
            TopicFeedsListUpdatedEvent topicFeedsListUpdatedEvent = (TopicFeedsListUpdatedEvent) fbEvent;
            String str = ((FeedSwitcherItem) this.f24550a.ar.get(this.f24550a.aI)).f24534b;
            this.f24550a.aC = topicFeedsListUpdatedEvent.f24597a;
            this.f24550a.aD = NewsFeedSwitcherFragment.m26460a(this.f24550a, this.f24550a.aC);
            NewsFeedSwitcherFragment.aB(this.f24550a);
            int a = NewsFeedSwitcherFragment.m26459a(this.f24550a, str);
            NewsFeedSwitcherFragment newsFeedSwitcherFragment = this.f24550a;
            if (a == -1) {
                a = NewsFeedSwitcherFragment.m26459a(this.f24550a, NewsFeedSwitcherFragment.ao);
            }
            NewsFeedSwitcherFragment.m26471g(newsFeedSwitcherFragment, a);
        }
    }

    public static void m26465a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((NewsFeedSwitcherFragment) obj).m26464a(IdBasedSingletonScopeProvider.b(fbInjector, 494), (FeedSwitcherAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FeedSwitcherAdapterProvider.class), TopicListFetcher.b(fbInjector), TopicFeedsEventBus.m26511a(fbInjector), IdBasedLazy.a(fbInjector, 2352), FeedLoggingViewportEventListener.a(fbInjector), TopicFeedsTestUtil.b(fbInjector), GoodFriendsNuxController.m26386b(fbInjector), new TopicFeedsNavigationLogger(NavigationLogger.a(fbInjector)), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector));
    }

    private void m26464a(Lazy<FbErrorReporter> lazy, FeedSwitcherAdapterProvider feedSwitcherAdapterProvider, TopicListFetcher topicListFetcher, TopicFeedsEventBus topicFeedsEventBus, Lazy<InterstitialStartHelper> lazy2, FeedLoggingViewportEventListener feedLoggingViewportEventListener, TopicFeedsTestUtil topicFeedsTestUtil, GoodFriendsNuxController goodFriendsNuxController, TopicFeedsNavigationLogger topicFeedsNavigationLogger, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore) {
        this.f24551a = lazy;
        this.f24552b = feedSwitcherAdapterProvider;
        this.f24553c = topicListFetcher;
        this.f24554d = topicFeedsEventBus;
        this.f24555e = lazy2;
        this.f24556f = feedLoggingViewportEventListener;
        this.f24557g = topicFeedsTestUtil;
        this.f24558h = goodFriendsNuxController;
        this.f24559i = topicFeedsNavigationLogger;
        this.al = qeAccessor;
        this.am = gatekeeperStore;
    }

    public final void m26479c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = NewsFeedSwitcherFragment.class;
        m26465a((Object) this, getContext());
        this.aB = new AllCapsTransformationMethod(getContext());
        if (bundle != null) {
            m26472h(this, bundle.getInt("current_position"));
            this.aC = (TopicFeedListModel) FlatBufferModelHelper.a(bundle, "topic_list_model");
        }
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.ax = (Builder) bundle2.getParcelable("newsfeed_fragment_builder");
            this.ay = bundle2.getBoolean("topic_feed_enabled");
            this.az = bundle2.getBoolean("good_friends_feed_enabled");
            this.aA = bundle2.getBoolean("feed_diode_enabled");
        }
        if (this.ax == null) {
            ((AbstractFbErrorReporter) this.f24551a.get()).a("feeds_switcher_missing_fragment_builder", "No Params Passed for Building Home NewsFeedFragment");
            Builder builder = new Builder();
            builder.a = FeedType.b;
            builder = builder;
            builder.c = true;
            this.ax = builder;
        }
        this.aE = ax();
        if (this.az) {
            this.aG = az();
        }
        if (this.aA) {
            this.aH = aA();
        }
        if (this.ay) {
            this.f24553c.a(TopicProjectInputTopicProject.TOPIC_FEEDS, GraphQLCachePolicy.a, new C29575(this));
            this.aD = m26460a(this, this.aC);
            this.aF = ay();
        }
        aB(this);
        if (this.am.a(1151, false)) {
            this.av = new JustifiedLinearLayoutManager(getContext());
        } else {
            this.av = new LinearLayoutManager(getContext());
        }
        this.av.b(0);
        if (this.f24557g.o()) {
            this.at = new SwipingFragmentPagerController(getContext(), s(), this.av, this.ar, new C29531(this), this.f24559i);
        } else {
            this.at = new TappingFragmentPagerController(s(), 2131564238, this.f24559i);
        }
        this.au = new NewsFeedSwitcherFragmentPagerAdapter(this);
        this.at.mo1162a(this.au);
        this.aw = this.f24552b.m26534a(this.aA, this.az, this.ay, new C29542(this));
        this.aw.m26533a(this.ar);
        this.aw.f24633h = this.aI;
        this.f24554d.a(this.ap);
        this.f24554d.a(this.aq);
        if (bundle == null) {
            m26471g(this, 0);
        }
    }

    public static void m26470c(NewsFeedSwitcherFragment newsFeedSwitcherFragment, View view) {
        if (view instanceof TextView) {
            Object obj;
            TextView textView = (TextView) view;
            if (newsFeedSwitcherFragment.az && newsFeedSwitcherFragment.aG.f24535c.equals(textView.getText())) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null && newsFeedSwitcherFragment.aJ) {
                GoodFriendsNuxController goodFriendsNuxController = newsFeedSwitcherFragment.f24558h;
                Context context = newsFeedSwitcherFragment.getContext();
                if (goodFriendsNuxController.f24487b.a(GoodFriendsNuxController.f24486a, true)) {
                    Tooltip tooltip = new Tooltip(context, 2);
                    tooltip.t = -1;
                    tooltip.b(2131241427);
                    Resources resources = context.getResources();
                    tooltip.a(resources.getDimensionPixelSize(2131434000), 0, resources.getDimensionPixelSize(2131434001), 0);
                    tooltip.f(textView);
                    goodFriendsNuxController.f24488c.a(Event.NUX_SHOWN);
                }
                newsFeedSwitcherFragment.f24558h.f24487b.edit().putBoolean(GoodFriendsNuxController.f24486a, false).commit();
            }
        }
    }

    public final View m26474a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1086267153);
        View a2 = this.at.mo1159a(layoutInflater, viewGroup);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 166053868, a);
        return a2;
    }

    public final void m26476a(View view, @javax.annotation.Nullable Bundle bundle) {
        super.a(view, bundle);
        this.as = (RecyclerView) FindViewUtil.b(view, 2131564237);
        this.as.setLayoutManager(this.av);
        if (this.az || this.aA) {
            au(this);
        }
        if (bundle != null) {
            NewsFeedSwitcherFragmentPagerAdapter newsFeedSwitcherFragmentPagerAdapter = this.au;
            int i = this.aI;
            Fragment a = this.at.mo1158a();
            if (a != null && i >= 0 && i <= newsFeedSwitcherFragmentPagerAdapter.f24547a.ar.size() - 1) {
                newsFeedSwitcherFragmentPagerAdapter.f24548b.put(((FeedSwitcherItem) newsFeedSwitcherFragmentPagerAdapter.f24547a.ar.get(i)).f24534b, a);
            }
        }
    }

    public final void m26475a(int i, int i2, Intent intent) {
        Fragment a = this.at.mo1158a();
        if (a != null) {
            a.a(i, i2, intent);
        }
    }

    public final void m26481g(boolean z) {
        this.aJ = z;
        if (this.at != null) {
            Fragment a = this.at.mo1158a();
            if (a != null) {
                a.g(z);
            }
        }
        if (this.f24556f != null) {
            this.f24556f.a(am_());
        }
    }

    public final void m26480e(Bundle bundle) {
        bundle.putInt("current_position", this.aI);
        FlatBufferModelHelper.a(bundle, "topic_list_model", this.aC);
        super.e(bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.as != null) {
            this.as.getViewTreeObserver().addOnGlobalLayoutListener(new C29553(this));
        }
    }

    public final String am_() {
        Fragment a = this.at.mo1158a();
        if (a instanceof AnalyticsFragment) {
            return ((AnalyticsFragment) a).am_();
        }
        return "unknown";
    }

    public Map<String, String> getDebugInfo() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("NewsFeedSwitcherFragment_current_position: ", Integer.toString(this.aI));
        hashMap.put("NewsFeedSwitcherFragment_current_position_itemid: ", ((FeedSwitcherItem) this.ar.get(this.aI)).f24534b);
        hashMap.put("NewsFeedSwitcherFragment_switcher_itemIds: ", this.ar.toString());
        Writer stringWriter = new StringWriter();
        kO_().a("", null, new PrintWriter(stringWriter), new String[0]);
        hashMap.put("NewsFeedSwitcherFragment_fragmentManager_dump: ", stringWriter.toString());
        hashMap.put("NewsFeedSwitcherFragment_local_fragment_hashmap: ", this.au.f24548b.toString());
        Fragment a = this.at.mo1158a();
        if (a != null && (a instanceof ComponentWithDebugInfo)) {
            hashMap.putAll(((ComponentWithDebugInfo) a).getDebugInfo());
        }
        return hashMap;
    }

    public final void m26477a(DumpsysContext dumpsysContext) {
        dumpsysContext.f.a(this.at.mo1158a(), dumpsysContext);
    }

    public static void au(NewsFeedSwitcherFragment newsFeedSwitcherFragment) {
        if (newsFeedSwitcherFragment.as != null && newsFeedSwitcherFragment.as.o == null) {
            newsFeedSwitcherFragment.as.setAdapter(newsFeedSwitcherFragment.aw);
            newsFeedSwitcherFragment.as.setOnTouchListener(new C29564(newsFeedSwitcherFragment));
        }
    }

    public final boolean O_() {
        return m26466a(NavigationEventType.BACK_BUTTON);
    }

    public final boolean m26478a() {
        return gC_() && m26466a(NavigationEventType.NEWS_FEED_TAB);
    }

    public final boolean ar() {
        return this.aI == 0 && this.au.m26454a(0) != null;
    }

    public static int m26459a(NewsFeedSwitcherFragment newsFeedSwitcherFragment, String str) {
        for (int i = 0; i < newsFeedSwitcherFragment.ar.size(); i++) {
            if (StringUtil.a(((FeedSwitcherItem) newsFeedSwitcherFragment.ar.get(i)).f24534b, str)) {
                return i;
            }
        }
        return -1;
    }

    public final boolean gC_() {
        Fragment a = this.at.mo1158a();
        return a == null || !(a instanceof ScrollableListContainer) || ((ScrollableListContainer) a).gC_();
    }

    public final void gB_() {
        if (this.at.mo1158a() != null) {
            ((ScrollableListContainer) this.at.mo1158a()).gB_();
        }
    }

    public final ScrollingViewProxy m26482n() {
        return this.at.mo1158a() == null ? null : ((ScrollableListContainer) this.at.mo1158a()).n();
    }

    public final void m26473I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1571090343);
        this.f24554d.b(this.ap);
        this.f24554d.b(this.aq);
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1826603914, a);
    }

    public static void m26471g(NewsFeedSwitcherFragment newsFeedSwitcherFragment, int i) {
        newsFeedSwitcherFragment.m26461a(i, null);
    }

    private void m26461a(int i, View view) {
        m26468b(i, view);
        if (this.aI != i) {
            Fragment a = this.at.mo1158a();
            if (a != null) {
                a.g(false);
            }
            m26472h(this, i);
            a = this.at.mo1158a();
            if (a != null) {
                a.g(this.aJ);
            }
        } else if (!gC_()) {
            gB_();
        }
    }

    private void m26468b(int i, View view) {
        if (view != null) {
            int width = this.as.getWidth();
            this.as.a(((view.getLeft() + this.as.getPaddingLeft()) - (width / 2)) + (view.getWidth() / 2), 0);
        } else if (this.as != null) {
            this.as.b(i);
        }
    }

    private boolean m26466a(NavigationEventType navigationEventType) {
        if (ar()) {
            return false;
        }
        int a = m26459a(this, ao);
        m26463a(this, a, navigationEventType);
        m26461a(a, null);
        return true;
    }

    public static void m26463a(NewsFeedSwitcherFragment newsFeedSwitcherFragment, int i, NavigationEventType navigationEventType) {
        if (i != newsFeedSwitcherFragment.aI) {
            newsFeedSwitcherFragment.at.mo1161a(newsFeedSwitcherFragment.au.m26454a(i), newsFeedSwitcherFragment.getContext(), i, newsFeedSwitcherFragment.ar, newsFeedSwitcherFragment.av, navigationEventType);
        }
    }

    private FeedSwitcherItem ax() {
        String string = jW_().getString(2131239089);
        if (this.aA) {
            string = this.al.a(ExperimentsForFeedDiodeTestModule.e, string);
        }
        return new FeedSwitcherItem(this, ao, m26467b(string)) {
            final /* synthetic */ NewsFeedSwitcherFragment f24543a;

            public final Fragment mo1155d() {
                FeedType newsFeedType;
                if (this.f24543a.aA) {
                    newsFeedType = new NewsFeedType(new NewsFeedTypeValue(FeedStyleInputStyle.values()[this.f24543a.al.a(ExperimentsForFeedDiodeTestModule.d, FeedStyleInputStyle.NULL.ordinal())].toString(), OrderbyInputNewsFeedOrdering.TOP_STORIES.toString()), Name.a);
                } else {
                    newsFeedType = FeedType.b;
                }
                Builder builder = this.f24543a.ax;
                builder.a = newsFeedType;
                return builder.d();
            }
        };
    }

    private String m26467b(String str) {
        return this.aB.getTransformation(str, null).toString();
    }

    private FeedSwitcherItem ay() {
        return new FeedSwitcherItem(this, "more", null, 2130839902) {
            final /* synthetic */ NewsFeedSwitcherFragment f24544a;

            public final Fragment mo1155d() {
                TopicFeedListModel topicFeedListModel = this.f24544a.aC;
                TopicFeedFavoritesFragment topicFeedFavoritesFragment = new TopicFeedFavoritesFragment();
                Bundle bundle = new Bundle();
                FlatBufferModelHelper.a(bundle, "bundle_topic_model", topicFeedListModel);
                topicFeedFavoritesFragment.g(bundle);
                return topicFeedFavoritesFragment;
            }
        };
    }

    private FeedSwitcherItem az() {
        return new FeedSwitcherItem(this, "good_friends", m26467b(jW_().getString(2131239090))) {
            final /* synthetic */ NewsFeedSwitcherFragment f24545a;

            public final Fragment mo1155d() {
                return new GoodFriendsFeedFragment();
            }
        };
    }

    private FeedSwitcherItem aA() {
        return new FeedSwitcherItem(this, "feed_diode", m26467b(this.al.a(ExperimentsForFeedDiodeTestModule.i, jW_().getString(2131241419)))) {
            final /* synthetic */ NewsFeedSwitcherFragment f24546a;

            public final Fragment mo1155d() {
                NewsFeedType newsFeedType = new NewsFeedType(new NewsFeedTypeValue(FeedStyleInputStyle.values()[this.f24546a.al.a(ExperimentsForFeedDiodeTestModule.h, FeedStyleInputStyle.FRIENDS_FEED_ONLY.ordinal())].toString(), OrderbyInputNewsFeedOrdering.TOP_STORIES.toString()), Name.a, "friends_only_feed");
                Builder builder = this.f24546a.ax;
                builder.a = newsFeedType;
                return builder.d();
            }
        };
    }

    public static List m26460a(@Nullable NewsFeedSwitcherFragment newsFeedSwitcherFragment, TopicFeedListModel topicFeedListModel) {
        if (topicFeedListModel == null) {
            return Collections.emptyList();
        }
        List arrayList = new ArrayList();
        ImmutableList a = topicFeedListModel.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            final TopicFeedFragmentModel topicFeedFragmentModel = (TopicFeedFragmentModel) a.get(i);
            if (topicFeedFragmentModel.fc_()) {
                String str;
                if (topicFeedFragmentModel.k() == null) {
                    str = "";
                } else {
                    str = newsFeedSwitcherFragment.m26467b(topicFeedFragmentModel.k());
                }
                arrayList.add(new FeedSwitcherItem(newsFeedSwitcherFragment, topicFeedFragmentModel.fb_(), str) {
                    final /* synthetic */ NewsFeedSwitcherFragment f24537b;

                    public final Fragment mo1155d() {
                        GraphQLExploreFeed.Builder builder = new GraphQLExploreFeed.Builder();
                        builder.i = topicFeedFragmentModel.fb_();
                        builder = builder;
                        builder.l = topicFeedFragmentModel.k();
                        builder = builder;
                        builder.d = topicFeedFragmentModel.b();
                        GraphQLExploreFeed a = builder.a();
                        Builder builder2 = this.f24537b.ax;
                        builder2.a = new FeedType(a, Name.k, "explore_feed");
                        return builder2.d();
                    }
                });
            }
        }
        return arrayList;
    }

    public static void aB(NewsFeedSwitcherFragment newsFeedSwitcherFragment) {
        newsFeedSwitcherFragment.ar.clear();
        newsFeedSwitcherFragment.ar.add(newsFeedSwitcherFragment.aE);
        if (newsFeedSwitcherFragment.az) {
            newsFeedSwitcherFragment.ar.add(newsFeedSwitcherFragment.aG);
        }
        if (newsFeedSwitcherFragment.aA) {
            newsFeedSwitcherFragment.ar.add(newsFeedSwitcherFragment.aH);
        }
        if (newsFeedSwitcherFragment.ay && newsFeedSwitcherFragment.aC != null) {
            newsFeedSwitcherFragment.ar.addAll(newsFeedSwitcherFragment.aD);
            newsFeedSwitcherFragment.ar.add(newsFeedSwitcherFragment.aF);
        }
        if (newsFeedSwitcherFragment.at != null) {
            newsFeedSwitcherFragment.at.mo1163b();
        }
        if (newsFeedSwitcherFragment.aw != null) {
            newsFeedSwitcherFragment.aw.m26533a(newsFeedSwitcherFragment.ar);
        }
    }

    public static void m26472h(NewsFeedSwitcherFragment newsFeedSwitcherFragment, int i) {
        newsFeedSwitcherFragment.aI = i;
        if (newsFeedSwitcherFragment.at != null) {
            newsFeedSwitcherFragment.at.mo1160a(i);
        }
        if (newsFeedSwitcherFragment.aw != null) {
            newsFeedSwitcherFragment.aw.f24633h = i;
            newsFeedSwitcherFragment.aw.notifyDataSetChanged();
        }
    }
}
