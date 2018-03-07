package com.facebook.search.results.fragment.feed;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherFactory;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherWrapper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.api.SearchResultsAnalytics.PageType;
import com.facebook.search.results.environment.SearchResultsLiveFeedEnvironmentGenerated;
import com.facebook.search.results.environment.SearchResultsLiveFeedEnvironmentGeneratedProvider;
import com.facebook.search.results.fragment.SearchResultsBaseFragment;
import com.facebook.search.results.livefeed.loader.LiveFeedDataHandler;
import com.facebook.search.results.livefeed.loader.LiveFeedModuleConfigToRefreshConfigAdapter.C24981;
import com.facebook.search.results.livefeed.loader.LiveFeedRefreshController;
import com.facebook.search.results.livefeed.loader.StoryRefreshController;
import com.facebook.search.results.model.SearchResultsFeedCollection;
import com.facebook.search.results.model.SearchResultsFeedCollectionProvider;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.rows.sections.livefeed.LiveFeedGroupPartDefinition;
import com.facebook.search.widget.resultspage.SearchResultsPage.State;
import com.facebook.search.widget.resultspage.SearchResultsPageView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.listview.ListScrollStateSnapshot;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: SET_FOCUSED_VIEW */
public class SearchResultsLiveFeedFragment extends SearchResultsBaseFragment {
    private static final FeedListType as = new C24661();
    public StoryRefreshController aA;
    public boolean aB = false;
    public SearchResultsPageView aC;
    public ScrollingViewProxy aD;
    public boolean aE = false;
    public boolean aF = false;
    public ListScrollStateSnapshot aG;
    public int aH;
    public View aI;
    @Inject
    Lazy<LiveFeedGroupPartDefinition> al;
    @Inject
    SearchResultsLiveFeedEnvironmentGeneratedProvider am;
    @Inject
    Provider<MultipleRowsStoriesRecycleCallback> an;
    @Inject
    Provider<LiveFeedRefreshController> ao;
    @Inject
    GraphSearchErrorReporter ap;
    @Inject
    SearchResultsLogger aq;
    @Inject
    MultiRowImagePrefetcherFactory ar;
    private int at = 0;
    private final OnScrollListener au = new C24672(this);
    private final RetryClickedListener av = new C24683(this);
    private final OnClickListener aw = new C24694(this);
    public SearchResultsFeedCollection ax;
    public MultiRowAdapter ay;
    private MultiRowImagePrefetcherWrapper az;
    @Inject
    SearchResultsFeedCollectionProvider f23052h;
    @Inject
    MultiRowAdapterBuilder f23053i;

    /* compiled from: SET_FOCUSED_VIEW */
    final class C24661 implements FeedListType {
        C24661() {
        }

        public final FeedListName m26697a() {
            return FeedListName.SEARCH_RESULTS_LIVE_FEED;
        }
    }

    /* compiled from: SET_FOCUSED_VIEW */
    class C24672 implements OnScrollListener {
        final /* synthetic */ SearchResultsLiveFeedFragment f23046a;

        C24672(SearchResultsLiveFeedFragment searchResultsLiveFeedFragment) {
            this.f23046a = searchResultsLiveFeedFragment;
        }

        public final void m26698a(ScrollingViewProxy scrollingViewProxy, int i) {
        }

        public final void m26699a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            if (i == 0) {
                this.f23046a.aI.setVisibility(8);
            }
            if (i + i2 == i3 && SearchResultsLiveFeedFragment.aA(this.f23046a) && !this.f23046a.aA.mo1319e()) {
                SearchResultsLiveFeedFragment.aE(this.f23046a);
            }
        }
    }

    /* compiled from: SET_FOCUSED_VIEW */
    class C24683 implements RetryClickedListener {
        final /* synthetic */ SearchResultsLiveFeedFragment f23047a;

        C24683(SearchResultsLiveFeedFragment searchResultsLiveFeedFragment) {
            this.f23047a = searchResultsLiveFeedFragment;
        }

        public final void m26700a() {
            SearchResultsLiveFeedFragment.aE(this.f23047a);
        }
    }

    /* compiled from: SET_FOCUSED_VIEW */
    class C24694 implements OnClickListener {
        final /* synthetic */ SearchResultsLiveFeedFragment f23048a;

        C24694(SearchResultsLiveFeedFragment searchResultsLiveFeedFragment) {
            this.f23048a = searchResultsLiveFeedFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -856099315);
            if (this.f23048a.aC.r == State.EMPTY && !this.f23048a.ax.m27074i()) {
                if (this.f23048a.ax.m27072f()) {
                    this.f23048a.aC.setState(State.LOADING_MORE);
                } else {
                    this.f23048a.aC.setState(State.LOADING_FINISHED);
                }
            }
            if (this.f23048a.aD.q() > 30) {
                this.f23048a.aD.h(30);
            }
            this.f23048a.aD.e(0);
            LogUtils.a(-1365021793, a);
        }
    }

    /* compiled from: SET_FOCUSED_VIEW */
    class C24705 implements OnRefreshListener {
        final /* synthetic */ SearchResultsLiveFeedFragment f23049a;

        C24705(SearchResultsLiveFeedFragment searchResultsLiveFeedFragment) {
            this.f23049a = searchResultsLiveFeedFragment;
        }

        public final void m26701a() {
            this.f23049a.aE = true;
            StoryRefreshController storyRefreshController = this.f23049a.aA;
            String v_ = this.f23049a.ax.f23356k.v_();
            storyRefreshController.mo1318d();
        }
    }

    /* compiled from: SET_FOCUSED_VIEW */
    class C24716 implements Runnable {
        final /* synthetic */ SearchResultsLiveFeedFragment f23050a;

        C24716(SearchResultsLiveFeedFragment searchResultsLiveFeedFragment) {
            this.f23050a = searchResultsLiveFeedFragment;
        }

        public void run() {
            SearchResultsLiveFeedFragment.aH(this.f23050a);
        }
    }

    /* compiled from: SET_FOCUSED_VIEW */
    public class C24727 implements LiveFeedDataHandler {
        final /* synthetic */ SearchResultsLiveFeedFragment f23051a;

        public C24727(SearchResultsLiveFeedFragment searchResultsLiveFeedFragment) {
            this.f23051a = searchResultsLiveFeedFragment;
        }

        public final void mo1296a(ImmutableList<GraphQLStory> immutableList, Optional<DefaultPageInfoFields> optional, String str, String str2, String str3) {
            SearchResultsMutableContext searchResultsMutableContext = this.f23051a.f22960h;
            searchResultsMutableContext.m27092c(str);
            searchResultsMutableContext.m27090b(str2);
            searchResultsMutableContext.m27093d(str3);
            ImmutableList a = SearchResultsLiveFeedFragment.m26705a(this.f23051a, (ImmutableList) immutableList);
            SearchResultsLiveFeedFragment searchResultsLiveFeedFragment = this.f23051a;
            searchResultsLiveFeedFragment.aG = new ListScrollStateSnapshot();
            searchResultsLiveFeedFragment.aD.a(searchResultsLiveFeedFragment.aG);
            searchResultsLiveFeedFragment.aH = searchResultsLiveFeedFragment.ay.getCount();
            int a2 = this.f23051a.ax.m27052a(a);
            SearchResultsLiveFeedFragment.aH(this.f23051a);
            SearchResultsLiveFeedFragment.m26708b(this.f23051a, a.isEmpty());
            this.f23051a.aq.m25470a(searchResultsMutableContext, this.f23051a.at = this.f23051a.at + 1, a2, null, PageType.HEAD);
        }

        public final void mo1297b(ImmutableList<GraphQLStory> immutableList, Optional<DefaultPageInfoFields> optional, String str, String str2, String str3) {
            SearchResultsMutableContext searchResultsMutableContext = this.f23051a.f22960h;
            searchResultsMutableContext.m27092c(str);
            searchResultsMutableContext.m27093d(str3);
            searchResultsMutableContext.m27090b(str2);
            ImmutableList a = SearchResultsLiveFeedFragment.m26705a(this.f23051a, (ImmutableList) immutableList);
            this.f23051a.ax.m27061a(a, (DefaultPageInfoFields) optional.orNull());
            SearchResultsLiveFeedFragment.aH(this.f23051a);
            this.f23051a.aq.m25470a(searchResultsMutableContext, this.f23051a.at = this.f23051a.at + 1, a.size(), null, null);
            if (a.isEmpty()) {
                if (this.f23051a.ax.m27074i()) {
                    this.f23051a.aC.setState(State.EMPTY);
                } else if (!this.f23051a.ax.m27072f()) {
                    this.f23051a.mo1294e();
                    this.f23051a.aC.setState(State.LOADING_FINISHED);
                }
                this.f23051a.aB = true;
                return;
            }
            this.f23051a.aC.setState(State.LOADING_MORE);
        }

        public final void mo1295a(GraphSearchException graphSearchException) {
            this.f23051a.aC.setState(this.f23051a.ax.m27074i() ? State.ERROR : State.ERROR_LOADING_MORE);
            this.f23051a.ap.a(graphSearchException);
        }
    }

    public static void m26707a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((SearchResultsLiveFeedFragment) obj).m26706a((SearchResultsFeedCollectionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchResultsFeedCollectionProvider.class), MultiRowAdapterBuilder.b(injectorLike), IdBasedLazy.a(injectorLike, 10726), (SearchResultsLiveFeedEnvironmentGeneratedProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchResultsLiveFeedEnvironmentGeneratedProvider.class), IdBasedSingletonScopeProvider.a(injectorLike, 1489), IdBasedProvider.a(injectorLike, 10597), GraphSearchErrorReporter.a(injectorLike), SearchResultsLogger.m25460a(injectorLike), MultiRowImagePrefetcherFactory.a(injectorLike));
    }

    private void m26706a(SearchResultsFeedCollectionProvider searchResultsFeedCollectionProvider, MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<LiveFeedGroupPartDefinition> lazy, SearchResultsLiveFeedEnvironmentGeneratedProvider searchResultsLiveFeedEnvironmentGeneratedProvider, Provider<MultipleRowsStoriesRecycleCallback> provider, Provider<LiveFeedRefreshController> provider2, GraphSearchErrorReporter graphSearchErrorReporter, SearchResultsLogger searchResultsLogger, MultiRowImagePrefetcherFactory multiRowImagePrefetcherFactory) {
        this.f23052h = searchResultsFeedCollectionProvider;
        this.f23053i = multiRowAdapterBuilder;
        this.al = lazy;
        this.am = searchResultsLiveFeedEnvironmentGeneratedProvider;
        this.an = provider;
        this.ao = provider2;
        this.ap = graphSearchErrorReporter;
        this.aq = searchResultsLogger;
        this.ar = multiRowImagePrefetcherFactory;
    }

    protected final Class<?> mo1294e() {
        return SearchResultsLiveFeedFragment.class;
    }

    public final void mo1290c(Bundle bundle) {
        super.mo1290c(bundle);
        Class cls = SearchResultsLiveFeedFragment.class;
        m26707a((Object) this, getContext());
        this.ax = this.f23052h.m27076a(this.f22960h);
        this.az = this.ar.a();
    }

    public final View m26712a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -369748759);
        Context az = az();
        View inflate = LayoutInflater.from(az).inflate(2130904421, viewGroup, false);
        this.aC = (SearchResultsPageView) FindViewUtil.b(inflate, 2131562156);
        this.aC.p.setEnabled(true);
        this.aC.p.e = new C24705(this);
        this.aC.G = this.av;
        this.aD = this.aC.k;
        SearchResultsLiveFeedEnvironmentGenerated a2 = this.am.m26219a(az, as, new C24716(this), null, this.f22960h, HasScrollListenerSupportImpl.a(this.aD));
        Builder a3 = this.f23053i.a(this.al, this.ax);
        a3.f = a2;
        this.ay = a3.e();
        this.aD.a(this.au);
        this.aD.a(this.ay);
        this.aD.a(((MultipleRowsStoriesRecycleCallback) this.an.get()).a());
        this.az.a(this.ay.f());
        this.aI = FindViewUtil.b(inflate, 2131562157);
        this.aI.setOnClickListener(this.aw);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 328850477, a);
        return inflate;
    }

    public final void au() {
        super.au();
        if (!aw() && this.aA != null) {
            if (this.aC.r == State.LOADING) {
                if (this.ax.m27051a() == 0) {
                    this.aF = true;
                } else if (aA(this)) {
                    this.aC.setState(State.LOADING_MORE);
                } else {
                    this.aC.setState(State.LOADING_FINISHED);
                }
            }
            aD();
        }
    }

    public final void mo1282G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1426573863);
        super.mo1282G();
        this.az.a(this.aD);
        this.aD.b(this.az.a());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 84207463, a);
    }

    public final String am_() {
        return "graph_search_results_live_conversation_fragment";
    }

    public final void mo1283H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1166218868);
        this.az.b();
        this.aD.c(this.az.a());
        super.mo1283H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1004672435, a);
    }

    public final void av() {
        if (this.aA != null) {
            this.aA.mo1316b();
        }
        super.av();
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1883147170);
        this.aD.a(null);
        this.aD.a(null);
        this.aI.setOnClickListener(null);
        this.ay.jc_();
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1172956522, a);
    }

    protected final void aq() {
        this.at = 0;
        this.ax.m27071e();
        this.aD.h(0);
        aH(this);
        C24981 c24981 = new C24981();
        if (this.aA != null) {
            this.aA.mo1316b();
        }
        this.aA = (StoryRefreshController) this.ao.get();
        this.aA.mo1314a(this.f22960h, c24981, Absent.INSTANCE);
        this.aA.mo1313a((LiveFeedDataHandler) new C24727(this));
        this.aA.mo1312a();
        this.aB = false;
        mo1294e();
        aC();
    }

    protected final boolean ar() {
        return (this.ax == null || this.ax.m27074i()) ? false : true;
    }

    public static boolean aA(SearchResultsLiveFeedFragment searchResultsLiveFeedFragment) {
        return (searchResultsLiveFeedFragment.aB || searchResultsLiveFeedFragment.ax.m27073g() == null) ? false : true;
    }

    private void aC() {
        this.aA.mo1317c();
        this.aF = false;
    }

    private void aD() {
        if (this.aF) {
            aC();
        }
        this.aA.mo1312a();
    }

    public static void aE(SearchResultsLiveFeedFragment searchResultsLiveFeedFragment) {
        searchResultsLiveFeedFragment.mo1294e();
        searchResultsLiveFeedFragment.aA.mo1315a(searchResultsLiveFeedFragment.ax.m27073g());
    }

    public static ImmutableList m26705a(SearchResultsLiveFeedFragment searchResultsLiveFeedFragment, ImmutableList immutableList) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        LiveFeedGroupPartDefinition liveFeedGroupPartDefinition = (LiveFeedGroupPartDefinition) searchResultsLiveFeedFragment.al.get();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLStory graphQLStory = (GraphQLStory) immutableList.get(i);
            if (liveFeedGroupPartDefinition.m27921a(graphQLStory)) {
                builder.c(graphQLStory);
            }
        }
        return builder.b();
    }

    protected final String as() {
        return this.f22960h.mo1211a() != null ? StringFormatUtil.formatStrLocaleSafe(jW_().getString(2131237487), this.f22960h.mo1211a()) : jW_().getString(2131237486);
    }

    public static void aH(SearchResultsLiveFeedFragment searchResultsLiveFeedFragment) {
        searchResultsLiveFeedFragment.ay.notifyDataSetChanged();
    }

    public static void m26708b(SearchResultsLiveFeedFragment searchResultsLiveFeedFragment, boolean z) {
        if (searchResultsLiveFeedFragment.aE) {
            searchResultsLiveFeedFragment.aE = false;
            searchResultsLiveFeedFragment.aC.p.setRefreshing(false);
        } else if (!z) {
            if (searchResultsLiveFeedFragment.aG != null) {
                int count = searchResultsLiveFeedFragment.ay.getCount() - searchResultsLiveFeedFragment.aH;
                count += searchResultsLiveFeedFragment.aG.a;
                searchResultsLiveFeedFragment.aD.d(count, -searchResultsLiveFeedFragment.aG.c);
                searchResultsLiveFeedFragment.aG = null;
            }
            searchResultsLiveFeedFragment.aI.setVisibility(0);
        }
    }
}
