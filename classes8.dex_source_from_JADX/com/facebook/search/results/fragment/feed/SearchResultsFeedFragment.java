package com.facebook.search.results.fragment.feed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.SeparatedSpannableStringBuilder;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.dumpsys.DumpsysContext;
import com.facebook.debug.dumpsys.DumpsysDumpable;
import com.facebook.debug.dumpsys.DumpsysDumper;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.popover.PopoverMenuWindow.OnMenuItemClickListener;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.rows.LikeProcessor;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.core.events.Action;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.events.Subscription;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherFactory;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherWrapper;
import com.facebook.feed.ui.VideoFeedStoryMenuHelperProvider;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.graphql.calls.ForSaleInputForSaleAvailability;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.calls.SearchQueryInputQueryArguments.FilteredQueryArguments.Filters;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLSearchAwarenessTemplatesEnum;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.ReactionThemedContextHelper;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionCommonConstants.CardSearchType;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.common.ReactionInteractionTrackerProvider;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandler;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandlerProvider;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.GraphSearchQuery.ModifierKeys;
import com.facebook.search.api.GraphSearchQueryCommerceModifier;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.SearchResultsFeedHeightLoggingEventListener;
import com.facebook.search.logging.SearchResultsFeedLoggingViewportEventListener;
import com.facebook.search.logging.SearchResultsFeedLoggingViewportEventListenerProvider;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.SearchResultsLogger.Event;
import com.facebook.search.logging.SearchResultsPerformanceLogger;
import com.facebook.search.logging.api.SearchResultsAnalytics.PageType;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.search.model.FilterType;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.protocol.BatchedSearchLoader;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchQueryModel.SearchPivotsModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchQueryModel.SearchPivotsModel.NodesModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchQueryModel.SearchPivotsModel.NodesModel.QueryTitleModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchQueryModel.SearchPivotsModel.NodesModel.UnderlyingEntityModel;
import com.facebook.search.quickpromotion.SearchAwarenessController;
import com.facebook.search.quickpromotion.SearchTrendingAwarenessNuxInterstitialController;
import com.facebook.search.results.environment.FeedMenuHelperReference;
import com.facebook.search.results.environment.SearchResultsFeedEnvironmentGenerated;
import com.facebook.search.results.environment.SearchResultsFeedEnvironmentGeneratedProvider;
import com.facebook.search.results.filters.controller.SearchResultPageFilterController;
import com.facebook.search.results.filters.controller.SearchResultPageFilterController.OnFilterClearButtonClickListener;
import com.facebook.search.results.filters.definition.FilterPersistentState;
import com.facebook.search.results.filters.ui.SearchResultPageFilterFragment;
import com.facebook.search.results.filters.ui.SearchResultPageFilterFragment.OnFilterValuesSelectedListener;
import com.facebook.search.results.fragment.SearchResultsBaseFragment;
import com.facebook.search.results.fragment.feed.SearchResultsFeedEventsManager.FeedUnitMutatedEventSubscriber;
import com.facebook.search.results.fragment.feed.SearchResultsFeedEventsManager.SearchResultsStoryLikeEventAction;
import com.facebook.search.results.fragment.feed.SearchResultsFeedEventsManager.SearchResultsStoryReactionUpdatedEventAction;
import com.facebook.search.results.fragment.tabs.SearchResultsTabsFragment;
import com.facebook.search.results.livefeed.loader.LiveFeedDataHandler;
import com.facebook.search.results.livefeed.loader.LiveFeedDataLoader;
import com.facebook.search.results.livefeed.loader.LiveFeedDataLoaderProvider;
import com.facebook.search.results.loader.modules.C2510x73e72fcc;
import com.facebook.search.results.loader.modules.SearchResultsFeedLoadMoreRequestType;
import com.facebook.search.results.loader.modules.SearchResultsFeedModulesDataLoader;
import com.facebook.search.results.logging.SearchResultsFeedLoggingProcessor;
import com.facebook.search.results.model.SearchResults;
import com.facebook.search.results.model.SearchResultsFeedCollection;
import com.facebook.search.results.model.SearchResultsFeedCollectionProvider;
import com.facebook.search.results.model.SearchResultsLastContextProvider;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.model.SearchResultsNewsTitle;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.rows.SearchDenseFeedListType;
import com.facebook.search.results.rows.SearchDenseNoUFIFeedListType;
import com.facebook.search.results.rows.SearchFeedListType;
import com.facebook.search.results.rows.SearchResultsFeedRootPartDefinition;
import com.facebook.search.results.rows.events.SearchResultsFeedUnitUpdateEvent;
import com.facebook.search.results.rows.events.SearchResultsStoryLikeEvent;
import com.facebook.search.results.rows.events.SearchResultsStoryReactionUpdatedEvent;
import com.facebook.search.results.ui.SearchResultsGroupCommerceFilter;
import com.facebook.search.results.ui.SearchResultsGroupCommerceFilter.C26551;
import com.facebook.search.results.ui.SearchResultsGroupCommerceFilter.FilterIndex;
import com.facebook.search.results.ui.SearchResultsTitleBarController;
import com.facebook.search.results.ui.SearchResultsTitleBarControllerProvider;
import com.facebook.search.titlebar.GraphSearchTitleSearchBox;
import com.facebook.search.util.SearchPivotData;
import com.facebook.search.util.bugreporter.SearchBugReportEvent;
import com.facebook.search.util.bugreporter.SearchBugReportExtraDataProvider;
import com.facebook.search.widget.resultspage.SearchResultsPage.LoadingIndicatorType;
import com.facebook.search.widget.resultspage.SearchResultsPage.State;
import com.facebook.search.widget.resultspage.SearchResultsPageView;
import com.facebook.search.widget.resultspage.SearchResultsPageView$FilterButtonClickListener;
import com.facebook.search.widget.resultspage.SearchResultsPageView$SearchPivotClickListener;
import com.facebook.search.widget.resultspage.SearchResultsPageView.2;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: SET_SEARCH_CELL */
public class SearchResultsFeedFragment extends SearchResultsBaseFragment implements DumpsysDumpable, OnMenuItemClickListener, ReactionCardContainer, OnFilterClearButtonClickListener, OnFilterValuesSelectedListener, SearchResultsPageView$FilterButtonClickListener, SearchResultsPageView$SearchPivotClickListener, RetryClickedListener {
    private static final GraphQLSearchAwarenessTemplatesEnum aN = GraphQLSearchAwarenessTemplatesEnum.LEARNING_NUX_SERP_SUCCESS;
    private static final String aO = SearchResultsFeedFragment.class.getSimpleName();
    @Inject
    MultiRowImagePrefetcherFactory aA;
    @Inject
    InterstitialManager aB;
    @Inject
    QeAccessor aC;
    @Inject
    ViewportMonitor aD;
    @Inject
    DefaultAndroidThreadUtil aE;
    @Inject
    SearchResultsIntentBuilder aF;
    @Inject
    SearchResultsLastContextProvider aG;
    @Inject
    LiveFeedDataLoaderProvider aH;
    @Inject
    FrameRateLoggerProvider aI;
    @Inject
    GatekeeperStoreImpl aJ;
    @Inject
    VideoFeedStoryMenuHelperProvider aK;
    @Inject
    ReactionFeedActionHandlerProvider aL;
    @Inject
    ReactionInteractionTrackerProvider aM;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ComposerPublishServiceHelper> aP = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<Toaster> aQ = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<GraphSearchErrorReporter> aR = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<DumpsysDumper> aS = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SearchAwarenessController> aT = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SecureContextHelper> aU = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SearchBugReportExtraDataProvider> aV = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SearchResultPageFilterController> aW = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ReactionSessionManager> aX = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ReactionThemedContextHelper> aY = UltralightRuntime.b;
    private boolean aZ = false;
    @Inject
    EventsStream al;
    @Inject
    SearchResultsFeedLoggingProcessor am;
    @Inject
    SearchResultsPerformanceLogger an;
    @Inject
    BatchedSearchLoader ao;
    @Inject
    SearchResultsFeedEventsManagerProvider ap;
    @Inject
    SearchResultsFeedModulesDataLoader aq;
    @Inject
    SearchResultsLogger ar;
    @Inject
    MultiRowAdapterBuilder as;
    @Inject
    com.facebook.inject.Lazy<SearchResultsFeedRootPartDefinition> at;
    @Inject
    SearchResultsFeedEnvironmentGeneratedProvider au;
    @Inject
    Provider<MultipleRowsStoriesRecycleCallback> av;
    @Inject
    SearchResultsTitleBarControllerProvider aw;
    @Inject
    SearchResultsGroupCommerceFilter ax;
    @Inject
    SearchResultsFeedLoggingViewportEventListenerProvider ay;
    @Inject
    SearchResultsFeedHeightLoggingEventListener az;
    public FrameRateLogger bA;
    private Runnable bB;
    public LiveFeedDataLoader bC;
    public SearchResultsMutableContext bD;
    public boolean bE = false;
    private boolean bF = false;
    public SearchResultsTabsFragment bG;
    private String bH;
    @Nullable
    private ReactionSession ba;
    @Nullable
    private ReactionInteractionTracker bb;
    public final ConcurrentLinkedQueue<String> bc = new ConcurrentLinkedQueue();
    private final C24571 bd = new C24571(this);
    private final Action<SearchResultsFeedUnitUpdateEvent> be = new Action<SearchResultsFeedUnitUpdateEvent>(this) {
        final /* synthetic */ SearchResultsFeedFragment f23030a;

        {
            this.f23030a = r1;
        }

        public final void m26660a(Object obj) {
            SearchResultsFeedFragment.aC(this.f23030a);
        }
    };
    public SearchResultsFeedCollection bf;
    private SearchResultsFeedEventBusManager bg;
    public SearchResultsPageView bh;
    private State bi;
    public ScrollingViewProxy bj;
    public MultiRowAdapter bk;
    private MultiRowImagePrefetcherWrapper bl;
    public SearchResultsNewsTitle bm;
    @Nullable
    public String bn;
    @Nullable
    public String bo;
    private SearchResultsFeedEventsManager bp;
    public boolean bq = true;
    public boolean br = false;
    public boolean bs = true;
    private boolean bt = false;
    private int bu = 0;
    private int bv = 0;
    private Subscription<SearchResultsFeedUnitUpdateEvent, Void> bw;
    private SearchResultsFeedLoggingViewportEventListener bx;
    public Optional<SearchResultsTitleBarController> by = Absent.INSTANCE;
    private boolean bz;
    @Inject
    SearchResultsFeedCollectionProvider f23044h;
    @Inject
    SearchResultsFeedEventBusManagerProvider f23045i;

    /* compiled from: SET_SEARCH_CELL */
    public class C24571 {
        public final /* synthetic */ SearchResultsFeedFragment f23031a;

        C24571(SearchResultsFeedFragment searchResultsFeedFragment) {
            this.f23031a = searchResultsFeedFragment;
        }
    }

    /* compiled from: SET_SEARCH_CELL */
    class C24582 implements OnRefreshListener {
        final /* synthetic */ SearchResultsFeedFragment f23032a;

        C24582(SearchResultsFeedFragment searchResultsFeedFragment) {
            this.f23032a = searchResultsFeedFragment;
        }

        public final void m26661a() {
            this.f23032a.br = true;
            this.f23032a.aq();
        }
    }

    /* compiled from: SET_SEARCH_CELL */
    class C24593 implements OnRefreshListener {
        final /* synthetic */ SearchResultsFeedFragment f23033a;

        C24593(SearchResultsFeedFragment searchResultsFeedFragment) {
            this.f23033a = searchResultsFeedFragment;
        }

        public final void m26662a() {
            SearchResultsFeedFragment.aB(this.f23033a);
            if (this.f23033a.bC == null) {
                this.f23033a.bC = this.f23033a.aH.m26909a(this.f23033a.bD, new LiveFeedDataHandler(this.f23033a) {
                    final /* synthetic */ SearchResultsFeedFragment f23027a;
                    private final ImmutableList<GraphQLGraphSearchResultRole> f23028b = ImmutableList.of(GraphQLGraphSearchResultRole.CENTRAL, GraphQLGraphSearchResultRole.NEWS_CONTEXT);

                    {
                        this.f23027a = r3;
                    }

                    public final void mo1296a(ImmutableList<GraphQLStory> immutableList, Optional<DefaultPageInfoFields> optional, String str, String str2, String str3) {
                        this.f23027a.bh.getSwipeLayout().setRefreshing(false);
                        this.f23027a.bD.m27092c(str);
                        this.f23027a.bD.m27090b(str2);
                        this.f23027a.bD.m27093d(str3);
                        this.f23027a.ar.m25470a(this.f23027a.bD, 0, immutableList.size(), null, PageType.HEAD);
                        if (!immutableList.isEmpty()) {
                            this.f23027a.bo = optional.isPresent() ? ((DefaultPageInfoFields) optional.get()).v_() : null;
                            Builder builder = new Builder();
                            int size = immutableList.size();
                            for (int i = 0; i < size; i++) {
                                builder.c(((GraphQLStory) immutableList.get(i)).c());
                            }
                            SearchResultsCollectionUnit searchResultsCollectionUnit = new SearchResultsCollectionUnit(GraphQLGraphSearchResultsDisplayStyle.STORIES, GraphQLGraphSearchResultRole.LIVE_CONVERSATION_MODULE, this.f23027a.jW_().getString(2131237508), (ImmutableList) immutableList, builder.b(), null, null, null, null, null);
                            this.f23027a.ar.m25472a(this.f23027a.f22960h, m26654a(searchResultsCollectionUnit), GraphQLGraphSearchResultRole.LIVE_CONVERSATION_MODULE, (String) searchResultsCollectionUnit.mo1322l().orNull());
                            this.f23027a.bk.notifyDataSetChanged();
                        }
                    }

                    public final void mo1297b(ImmutableList<GraphQLStory> immutableList, Optional<DefaultPageInfoFields> optional, String str, String str2, String str3) {
                    }

                    public final void mo1295a(GraphSearchException graphSearchException) {
                        ((GraphSearchErrorReporter) this.f23027a.aR.get()).a(graphSearchException.mError, "Failed to load latest posts", graphSearchException);
                    }

                    private int m26654a(SearchResultsCollectionUnit<GraphQLStory> searchResultsCollectionUnit) {
                        int i;
                        int i2 = 0;
                        for (int i3 = 0; i3 < this.f23027a.bf.m27051a(); i3++) {
                            FeedUnit b = this.f23027a.bf.m27065b(i3);
                            if (b instanceof SearchResultsFeedImpressionTrackable) {
                                GraphQLGraphSearchResultRole k = ((SearchResultsFeedImpressionTrackable) b).mo1321k();
                                if (k == GraphQLGraphSearchResultRole.LIVE_CONVERSATION_MODULE) {
                                    i = i3;
                                    break;
                                } else if (this.f23028b.contains(k)) {
                                    i2 = i3 + 1;
                                }
                            }
                        }
                        i = -1;
                        if (i != -1) {
                            this.f23027a.bf.m27068b(i, searchResultsCollectionUnit);
                            return i;
                        }
                        SearchResultsFeedCollection searchResultsFeedCollection = this.f23027a.bf;
                        if (i2 >= 0 && i2 <= searchResultsFeedCollection.f23349d.size()) {
                            searchResultsFeedCollection.f23349d.add(i2, searchResultsCollectionUnit);
                        }
                        return i2;
                    }
                });
            }
            this.f23033a.bC.m26908a(this.f23033a.bo, Integer.valueOf(4));
            SearchResultsLogger searchResultsLogger = this.f23033a.ar;
            HoneyClientEvent a = SearchResultsLogger.m25459a(Event.PULL_TO_REFRESH, this.f23033a.f22960h);
            searchResultsLogger.f21958c.a(a);
            if (BLog.b(3)) {
                String str = a.d;
                a.u();
            }
        }
    }

    /* compiled from: SET_SEARCH_CELL */
    class C24604 implements Runnable {
        final /* synthetic */ SearchResultsFeedFragment f23034a;

        C24604(SearchResultsFeedFragment searchResultsFeedFragment) {
            this.f23034a = searchResultsFeedFragment;
        }

        public void run() {
            SearchResultsFeedFragment.aC(this.f23034a);
        }
    }

    /* compiled from: SET_SEARCH_CELL */
    class C24615 implements OnDrawListener {
        final /* synthetic */ SearchResultsFeedFragment f23035a;

        C24615(SearchResultsFeedFragment searchResultsFeedFragment) {
            this.f23035a = searchResultsFeedFragment;
        }

        public final boolean gD_() {
            Collection arrayList = new ArrayList();
            while (!this.f23035a.bc.isEmpty()) {
                arrayList.add(this.f23035a.bc.poll());
            }
            if (!arrayList.isEmpty()) {
                boolean z;
                SearchResultsPerformanceLogger searchResultsPerformanceLogger = this.f23035a.an;
                SearchResultsMutableContext searchResultsMutableContext = this.f23035a.f22960h;
                ImmutableList copyOf = ImmutableList.copyOf(arrayList);
                boolean z2 = this.f23035a.bq;
                if (this.f23035a.bf.m27051a() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                searchResultsPerformanceLogger.m25513a(searchResultsMutableContext, copyOf, z2, z);
            }
            return false;
        }
    }

    public static void m26671a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((SearchResultsFeedFragment) obj).m26668a((SearchResultsFeedCollectionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchResultsFeedCollectionProvider.class), (SearchResultsFeedEventBusManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchResultsFeedEventBusManagerProvider.class), EventsStream.a(injectorLike), SearchResultsFeedLoggingProcessor.m27017a(injectorLike), SearchResultsPerformanceLogger.m25495a(injectorLike), BatchedSearchLoader.m8259a(injectorLike), IdBasedLazy.a(injectorLike, 5272), (SearchResultsFeedEventsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchResultsFeedEventsManagerProvider.class), SearchResultsFeedModulesDataLoader.m26987a(injectorLike), SearchResultsLogger.m25460a(injectorLike), IdBasedLazy.a(injectorLike, 3588), IdBasedSingletonScopeProvider.b(injectorLike, 3374), MultiRowAdapterBuilder.a(injectorLike), IdBasedLazy.a(injectorLike, 10610), (SearchResultsFeedEnvironmentGeneratedProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchResultsFeedEnvironmentGeneratedProvider.class), IdBasedSingletonScopeProvider.a(injectorLike, 1489), (SearchResultsTitleBarControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchResultsTitleBarControllerProvider.class), SearchResultsGroupCommerceFilter.m28562a(injectorLike), (SearchResultsFeedLoggingViewportEventListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchResultsFeedLoggingViewportEventListenerProvider.class), SearchResultsFeedHeightLoggingEventListener.m25448a(injectorLike), MultiRowImagePrefetcherFactory.a(injectorLike), InterstitialManager.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 5454), ViewportMonitor.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3383), DefaultAndroidThreadUtil.a(injectorLike), SearchResultsIntentBuilder.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 968), IdBasedSingletonScopeProvider.b(injectorLike, 3404), SearchResultsLastContextProvider.m27077a(injectorLike), (LiveFeedDataLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LiveFeedDataLoaderProvider.class), (FrameRateLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), IdBasedLazy.a(injectorLike, 10563), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (VideoFeedStoryMenuHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoFeedStoryMenuHelperProvider.class), (ReactionFeedActionHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionFeedActionHandlerProvider.class), (ReactionInteractionTrackerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionInteractionTrackerProvider.class), IdBasedSingletonScopeProvider.b(injectorLike, 9836), IdBasedLazy.a(injectorLike, 9838));
    }

    public final void m26682a(DumpsysContext dumpsysContext) {
        dumpsysContext.f.a(this.bk, dumpsysContext);
    }

    public static SearchResultsFeedFragment m26674c(String str) {
        SearchResultsFeedFragment searchResultsFeedFragment = new SearchResultsFeedFragment();
        searchResultsFeedFragment.bH = str;
        return searchResultsFeedFragment;
    }

    protected final Class<?> mo1294e() {
        return SearchResultsFeedFragment.class;
    }

    public final void mo1290c(Bundle bundle) {
        super.mo1290c(bundle);
        Class cls = SearchResultsFeedFragment.class;
        m26671a((Object) this, getContext());
        SearchResultsMutableContext searchResultsMutableContext = this.f22960h;
        this.bf = this.f23044h.m27076a(searchResultsMutableContext);
        SearchResultsFeedEventBusManagerProvider searchResultsFeedEventBusManagerProvider = this.f23045i;
        this.bg = new SearchResultsFeedEventBusManager(this.bf, FeedEventBus.a(searchResultsFeedEventBusManagerProvider), (SearchResultsStoryLikeClickSubscriberProvider) searchResultsFeedEventBusManagerProvider.getOnDemandAssistedProviderForStaticDi(SearchResultsStoryLikeClickSubscriberProvider.class), (SearchResultsStoryReactionUpdateSubscriberProvider) searchResultsFeedEventBusManagerProvider.getOnDemandAssistedProviderForStaticDi(SearchResultsStoryReactionUpdateSubscriberProvider.class));
        this.bl = this.aA.a();
        InjectorLike injectorLike = this.ay;
        this.bx = new SearchResultsFeedLoggingViewportEventListener((Clock) SystemClockMethodAutoProvider.a(injectorLike), SearchResultsLogger.m25460a(injectorLike), searchResultsMutableContext, this.bf);
        this.aD.a(this.az);
        this.aD.a(this.bx);
        this.aZ = this.aC.a(ExperimentsForSearchAbTestModule.N, false);
        this.bD = new SearchResultsMutableContext();
        this.bD.m27087a(searchResultsMutableContext, searchResultsMutableContext.f23369d, searchResultsMutableContext.f23367b);
        aB(this);
        this.bA = this.aI.a(Boolean.valueOf(false), "search_results_feed_scroll_perf", Absent.INSTANCE);
    }

    public final View m26678a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context a;
        GraphQLGraphSearchResultsDisplayStyle l;
        ReactionFeedActionHandler a2;
        int a3 = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1694966096);
        if (this.aZ) {
            this.aY.get();
            a = ReactionThemedContextHelper.m22627a(az(), getSurface());
        } else {
            a = az();
        }
        this.bh = new SearchResultsPageView(a, FilterType.from(ax().m27101u()), LoadingIndicatorType.SPINNING_WHEEL);
        if (SearchQueryFunctions.b(ax().mo1212b())) {
            this.bh.getSwipeLayout().setEnabled(true);
            this.bh.getSwipeLayout().setOnRefreshListener(new C24582(this));
        } else if (!this.aJ.a(SearchAbTestGatekeepers.B, false) || SearchQueryFunctions.c(ax().mo1212b()) || SearchQueryFunctions.e(ax().mo1212b())) {
            this.bh.getSwipeLayout().setEnabled(false);
        } else {
            this.bh.getSwipeLayout().setEnabled(true);
            this.bh.getSwipeLayout().setOnRefreshListener(new C24593(this));
        }
        this.bh.setResultPageFadeTransitionDuration(500);
        ((SearchResultPageFilterController) this.aW.get()).m26431a(this.bh);
        ((SearchResultPageFilterController) this.aW.get()).m26430a((OnFilterClearButtonClickListener) this);
        this.bh.setRetryClickedListener(this);
        this.bh.setSearchPivotClickListener(this);
        this.bh.setFilterButtonClickListener(this);
        if (this.bi != null) {
            this.bh.setIsInitialLoad(false);
            this.bh.setState(this.bi);
        }
        TypedValue typedValue = new TypedValue();
        a.getTheme().resolveAttribute(2130773623, typedValue, true);
        this.bh.setBackgroundDrawable(new ColorDrawable(typedValue.data));
        this.bj = this.bh.getScrollingViewProxy();
        if (this.aZ && this.ba == null) {
            this.ba = ((ReactionSessionManager) this.aX.get()).m22603a(SafeUUIDGenerator.a().toString(), getSurface());
        }
        FeedMenuHelperReference feedMenuHelperReference = new FeedMenuHelperReference();
        GraphQLGraphSearchResultsDisplayStyle fromString = mt_() != null ? GraphQLGraphSearchResultsDisplayStyle.fromString(mt_().getString("display_style")) : null;
        if (fromString == null) {
            l = ax().m27098l();
        } else {
            l = fromString;
        }
        SearchResultsFeedEnvironmentGeneratedProvider searchResultsFeedEnvironmentGeneratedProvider = this.au;
        if (this.aZ) {
            a2 = this.aL.m23162a(a, this);
        } else {
            a2 = null;
        }
        SearchResultsFeedEnvironmentGenerated a4 = searchResultsFeedEnvironmentGeneratedProvider.m26182a(a2, a, m26664a(l), feedMenuHelperReference, new C24604(this), null, this.bl, null, a, this, getInteractionTracker(), this.ba, HasScrollListenerSupportImpl.a(this.bj), this.bf, this.bf, ax(), this.bf, ax(), this.bf, this.bf, this.bG, ax(), this.bf, this.bf);
        feedMenuHelperReference.m26019a(this.aK.a(a4, NegativeFeedbackExperienceLocation.SEARCH_RESULTS, am_()));
        this.bp = this.ap.m26650a(ax(), this.bf, a4);
        this.bk = this.as.a(this.at, this.bf).a(a4).e();
        if (SearchQueryFunctions.c(ax().mo1212b())) {
            CustomFrameLayout customFrameLayout = (CustomFrameLayout) LayoutInflater.from(getContext()).inflate(2130906986, null);
            ((SearchResultPageFilterController) this.aW.get()).m26432a((HScrollRecyclerView) customFrameLayout.findViewById(2131567273));
            this.bh.a(customFrameLayout);
        }
        this.bj.a(this.bk);
        this.bj.a(((MultipleRowsStoriesRecycleCallback) this.av.get()).a());
        this.bl.a(this.bk.f());
        this.bj.b(new C24615(this));
        this.bj.a(aG());
        this.aD.a(true, this.bj);
        this.bo = null;
        this.bc.clear();
        ((SearchResultPageFilterController) this.aW.get()).m26436c();
        SearchResultsPageView searchResultsPageView = this.bh;
        LogUtils.f(676290573, a3);
        return searchResultsPageView;
    }

    public static void m26667a(SearchResultsFeedFragment searchResultsFeedFragment, SearchResultsFeedLoadMoreRequestType searchResultsFeedLoadMoreRequestType) {
        GraphSearchQuerySpec graphSearchQuerySpec = searchResultsFeedFragment.f22960h;
        Preconditions.checkNotNull(graphSearchQuerySpec.mo1212b());
        searchResultsFeedFragment.m26670a(searchResultsFeedFragment.bf.m27074i() ? State.LOADING : State.LOADING_MORE);
        searchResultsFeedFragment.aq.m27012a(graphSearchQuerySpec, searchResultsFeedFragment.bf.m27073g(), graphSearchQuerySpec.f23369d.b, graphSearchQuerySpec.f23367b, searchResultsFeedLoadMoreRequestType, ((SearchResultPageFilterController) searchResultsFeedFragment.aW.get()).m26438e());
    }

    private void aA() {
        if (!this.f22960h.jJ_().containsKey(ModifierKeys.GROUP_COMMERCE.name())) {
            return;
        }
        SearchResultsTitleBarController searchResultsTitleBarController;
        if (!this.bz) {
            if (this.by.isPresent()) {
                searchResultsTitleBarController = (SearchResultsTitleBarController) this.by.get();
                if (searchResultsTitleBarController.f25326e == null) {
                    TitleBarButtonSpec titleBarButtonSpec;
                    C24571 c24571 = searchResultsTitleBarController.f25325d;
                    SearchResultsGroupCommerceFilter aI = aI(c24571.f23031a);
                    if (aI != null) {
                        TitleBarButtonSpec titleBarButtonSpec2;
                        GraphSearchQueryCommerceModifier graphSearchQueryCommerceModifier = (GraphSearchQueryCommerceModifier) c24571.f23031a.f22960h.jJ_().get(ModifierKeys.GROUP_COMMERCE.name());
                        if (graphSearchQueryCommerceModifier == null || !graphSearchQueryCommerceModifier.b) {
                            titleBarButtonSpec2 = TitleBarButtonSpec.b;
                        } else {
                            TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
                            a.g = aI.f25320a.getString(2131237489);
                            titleBarButtonSpec2 = a.a();
                        }
                        titleBarButtonSpec = titleBarButtonSpec2;
                    } else {
                        titleBarButtonSpec = TitleBarButtonSpec.b;
                    }
                    searchResultsTitleBarController.f25326e = titleBarButtonSpec;
                }
                searchResultsTitleBarController.f25322a.b(searchResultsTitleBarController.f25326e);
                searchResultsTitleBarController.f25322a.a(searchResultsTitleBarController.f25323b);
            }
        } else if (this.by.isPresent()) {
            searchResultsTitleBarController = (SearchResultsTitleBarController) this.by.get();
            searchResultsTitleBarController.f25322a.b(TitleBarButtonSpec.b);
            searchResultsTitleBarController.f25322a.a(null);
        }
    }

    public static void aB(SearchResultsFeedFragment searchResultsFeedFragment) {
        SearchResultsMutableContext searchResultsMutableContext = searchResultsFeedFragment.f22960h;
        String a = searchResultsMutableContext.mo1211a();
        String l = (searchResultsMutableContext.jH_() == null || !searchResultsMutableContext.jH_().equals("news_v2")) ? SearchQueryFunctions.l(a) : SearchQueryFunctions.a(searchResultsMutableContext.mo1212b(), a);
        searchResultsFeedFragment.bD.m27088a(l);
    }

    public static SearchResultsGroupCommerceFilter aI(SearchResultsFeedFragment searchResultsFeedFragment) {
        if (searchResultsFeedFragment.f22960h.jJ_().containsKey(ModifierKeys.GROUP_COMMERCE.name())) {
            return searchResultsFeedFragment.ax;
        }
        return null;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1596582214);
        super.mi_();
        this.by = Optional.of(new SearchResultsTitleBarController((HasTitleBar) a(HasTitleBar.class), this.bd));
        if (this.by.isPresent()) {
            ((SearchResultsTitleBarController) this.by.get()).f25324c = this;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 31653472, a);
    }

    protected final boolean ar() {
        return (this.bf == null || this.bf.m27074i()) ? false : true;
    }

    public final void au() {
        super.au();
        if (this.bw == null) {
            this.bw = this.al.a(SearchResultsFeedUnitUpdateEvent.class, this.be);
        }
        SearchResultsFeedEventBusManager searchResultsFeedEventBusManager = this.bg;
        searchResultsFeedEventBusManager.f23007e.a(searchResultsFeedEventBusManager.f23004b);
        BatchedSearchLoader batchedSearchLoader = this.ao;
        batchedSearchLoader.m8262b();
        HandlerDetour.a(batchedSearchLoader.f7870b, batchedSearchLoader.f7874f, -280237790);
        SearchResultsFeedModulesDataLoader searchResultsFeedModulesDataLoader = this.aq;
        if (searchResultsFeedModulesDataLoader.f23320x != null) {
            searchResultsFeedModulesDataLoader.m27013b();
        }
        searchResultsFeedModulesDataLoader.f23320x = this;
        SearchResultsFeedEventsManager searchResultsFeedEventsManager = this.bp;
        searchResultsFeedEventsManager.m26649b();
        ((LikeProcessor) searchResultsFeedEventsManager.f23025l.get()).a();
        searchResultsFeedEventsManager.f23020g.add(searchResultsFeedEventsManager.f23014a.a(SearchResultsStoryLikeEvent.class, new SearchResultsStoryLikeEventAction(searchResultsFeedEventsManager)));
        searchResultsFeedEventsManager.f23020g.add(searchResultsFeedEventsManager.f23014a.a(SearchResultsStoryReactionUpdatedEvent.class, new SearchResultsStoryReactionUpdatedEventAction(searchResultsFeedEventsManager)));
        searchResultsFeedEventsManager.f23026m = new FeedUnitMutatedEventSubscriber(searchResultsFeedEventsManager);
        searchResultsFeedEventsManager.f23015b.a(searchResultsFeedEventsManager.f23026m);
        if (this.bf.m27051a() > 0 && this.bs && this.aq.m27014c()) {
            m26667a(this, SearchResultsFeedLoadMoreRequestType.ON_RESUME_RETRY);
        } else if (!this.bf.m27074i()) {
            this.an.m25514b();
        }
    }

    public final void mo1282G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1347233316);
        super.mo1282G();
        this.bl.a(this.bj);
        this.bj.b(this.bl.a());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 358671209, a);
    }

    public final void m26680a() {
        this.bv++;
        m26667a(this, SearchResultsFeedLoadMoreRequestType.ON_TIMEOUT_RETRY);
    }

    public final void mo1283H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -591864206);
        this.bl.b();
        this.bj.c(this.bl.a());
        this.bA.b();
        super.mo1283H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1651229188, a);
    }

    public final void av() {
        if (this.bw != null) {
            this.al.a(this.bw);
            this.bw = null;
        }
        SearchResultsFeedEventBusManager searchResultsFeedEventBusManager = this.bg;
        searchResultsFeedEventBusManager.f23007e.b(searchResultsFeedEventBusManager.f23004b);
        this.ao.m8262b();
        this.bp.m26649b();
        this.aq.f23320x = null;
        this.aq.m27013b();
        this.an.m25515b((GraphSearchQuerySpec) this.f22960h);
        if (this.bB != null) {
            HandlerDetour.a(this.f22954b, this.bB);
        }
        this.aD.c(this.bj);
        super.av();
    }

    public final boolean mo1191a(boolean z) {
        if (this.bB != null) {
            HandlerDetour.a(this.f22954b, this.bB);
        }
        ((SearchAwarenessController) this.aT.get()).c(aN);
        return super.mo1191a(z);
    }

    protected final void aq() {
        this.bv = 0;
        this.bu = 0;
        if (!this.br) {
            if (!this.bf.m27074i()) {
                this.bf.m27071e();
                aC(this);
            }
            if (!(this.bm == null || SearchQueryFunctions.c(this.f22960h.mo1212b()))) {
                this.bh.a(this.bm, this.bn);
            }
            m26670a(State.LOADING);
        }
        this.bq = true;
        this.bF = false;
        this.aq.m27010a((GraphSearchQuerySpec) this.f22960h, this.f22960h.f23369d.b, this.f22960h.f23367b, false);
        aA();
    }

    public final void m26681a(int i, int i2, Intent intent) {
        if (i == 1756 && i2 == -1) {
            ((ComposerPublishServiceHelper) this.aP.get()).c(intent);
        }
    }

    public final void m26695c(boolean z) {
        super.c(z);
        if (this.bB != null && z) {
            HandlerDetour.a(this.f22954b, this.bB);
        }
        this.bz = z;
        aA();
    }

    private FeedListType m26664a(GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle) {
        if (graphQLGraphSearchResultsDisplayStyle == GraphQLGraphSearchResultsDisplayStyle.BLENDED && this.aC.a(ExperimentsForSearchAbTestModule.t, false)) {
            return this.aC.a(ExperimentsForSearchAbTestModule.y, false) ? SearchDenseNoUFIFeedListType.f23563a : SearchDenseFeedListType.f23562a;
        } else {
            if (graphQLGraphSearchResultsDisplayStyle == GraphQLGraphSearchResultsDisplayStyle.STORIES && this.aC.a(ExperimentsForSearchAbTestModule.s, false)) {
                return this.aC.a(ExperimentsForSearchAbTestModule.x, false) ? SearchDenseNoUFIFeedListType.f23563a : SearchDenseFeedListType.f23562a;
            } else {
                return SearchFeedListType.f23564a;
            }
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1271107685);
        this.bk.jc_();
        ((SearchAwarenessController) this.aT.get()).c(aN);
        this.bh.D = null;
        this.bh.E = null;
        ((SearchResultPageFilterController) this.aW.get()).m26429a();
        ((SearchResultPageFilterController) this.aW.get()).m26434b();
        ((SearchResultPageFilterController) this.aW.get()).f22794j = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -369770940, a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.bk.a(configuration);
    }

    public final boolean m26690a(MenuItem menuItem) {
        SearchResultsGroupCommerceFilter aI = aI(this);
        SearchResultsMutableContext searchResultsMutableContext = this.f22960h;
        if (aI != null) {
            boolean z = false;
            GraphSearchQueryCommerceModifier graphSearchQueryCommerceModifier = (GraphSearchQueryCommerceModifier) searchResultsMutableContext.jJ_().get(ModifierKeys.GROUP_COMMERCE.name());
            if (graphSearchQueryCommerceModifier != null) {
                switch (C26551.f25319a[FilterIndex.values()[menuItem.getItemId()].ordinal()]) {
                    case 1:
                        boolean z2 = graphSearchQueryCommerceModifier.c;
                        graphSearchQueryCommerceModifier.c = false;
                        z = z2;
                        break;
                    case 2:
                        if (!graphSearchQueryCommerceModifier.c) {
                            z = true;
                        }
                        graphSearchQueryCommerceModifier.c = true;
                        if (z) {
                            graphSearchQueryCommerceModifier.a = ForSaleInputForSaleAvailability.AVAILABLE;
                            break;
                        }
                        break;
                    case 3:
                        z = SearchResultsGroupCommerceFilter.m28564a(graphSearchQueryCommerceModifier, ForSaleInputForSaleAvailability.AVAILABLE);
                        break;
                    case 4:
                        z = SearchResultsGroupCommerceFilter.m28564a(graphSearchQueryCommerceModifier, ForSaleInputForSaleAvailability.SOLD);
                        break;
                    case 5:
                        z = SearchResultsGroupCommerceFilter.m28564a(graphSearchQueryCommerceModifier, ForSaleInputForSaleAvailability.EXPIRED);
                        break;
                    default:
                        break;
                }
            }
            if (z) {
                this.bf.m27071e();
                aC(this);
                ay();
            }
        }
        return true;
    }

    public final String am_() {
        return this.bH;
    }

    public final void mo1298a(String str, String str2) {
        if (!Strings.isNullOrEmpty(str) && !Strings.isNullOrEmpty(str2)) {
            ((SecureContextHelper) this.aU.get()).a(this.aF.a(str2, str, this.f22960h.f23382q, SearchResultsSource.w, this.f22960h.f23369d, ExactMatchInputExactMatch.FALSE), getContext());
            SearchResultsLogger searchResultsLogger = this.ar;
            HoneyClientEvent a = SearchResultsLogger.m25459a(Event.ITEM_TAPPED, this.f22960h);
            a.b("results_module_type", "trending_topic_pivot");
            a.b("query_function", str);
            a.b("query", str2);
            searchResultsLogger.f21958c.a(a);
            if (BLog.b(3)) {
                String str3 = a.d;
                a.u();
            }
        }
    }

    public final void mo1281a(GraphSearchQuerySpec graphSearchQuerySpec, SearchTypeaheadSession searchTypeaheadSession, SearchResultsSource searchResultsSource) {
        super.mo1281a(graphSearchQuerySpec, searchTypeaheadSession, searchResultsSource);
        if (this.bh == null) {
            return;
        }
        if (SearchQueryFunctions.c(this.f22960h.mo1212b()) || SearchQueryFunctions.e(this.f22960h.mo1212b())) {
            this.bh.p.setEnabled(false);
        }
    }

    private void m26670a(State state) {
        if (this.bi != state) {
            ((SearchBugReportExtraDataProvider) this.aV.get()).a(aO, SearchBugReportEvent.FETCH_STATE_CHANGED, "Old: " + this.bi + ", New: " + state);
        }
        this.bi = state;
        if (this.bh != null) {
            this.bh.setState(state);
        }
    }

    public final void kP_() {
        kO_().a().a(SearchResultPageFilterFragment.m26554a(((SearchResultPageFilterController) this.aW.get()).m26437d(), (OnFilterValuesSelectedListener) this), "FILTER_FRAGMENT_TAG").b();
        this.ar.m25468a(this.f22960h);
    }

    public final void m26686a(C2510x73e72fcc c2510x73e72fcc) {
        State state;
        this.bc.add(c2510x73e72fcc.m26978e());
        SearchResultsMutableContext ax = ax();
        ax.m27090b(c2510x73e72fcc.m26976c());
        m26669a(ax, c2510x73e72fcc.m26975b());
        ax.m27093d(c2510x73e72fcc.m26977d());
        if (m26673a(ax())) {
            this.bh.getSwipeLayout().setEnabled(false);
        }
        this.aG.f23359a = ax;
        SearchResults a = c2510x73e72fcc.m26974a();
        final SearchPivotsModel g = c2510x73e72fcc.m26980g();
        final ImmutableList h = c2510x73e72fcc.m26981h();
        boolean z = a.m27026c() > 0 || !(this.bt || a.m27025b() == null || !a.m27025b().b());
        this.bs = z;
        if (this.bu == 0 && this.aC.a(ExperimentsForSearchAbTestModule.bL, false)) {
            m26666a(g);
        }
        if (g != null && !this.bF) {
            this.bF = true;
            this.aE.a(new Runnable(this) {
                final /* synthetic */ SearchResultsFeedFragment f23037b;

                public void run() {
                    SearchResultsPageView searchResultsPageView = this.f23037b.bh;
                    SearchPivotsModel searchPivotsModel = g;
                    if (searchPivotsModel.m8629a() != null && !searchPivotsModel.m8629a().isEmpty() && ((NodesModel) searchPivotsModel.m8629a().get(0)).m8625c() != null && ((CustomLinearLayout) searchResultsPageView.q.a()).getVisibility() != 0) {
                        UnderlyingEntityModel c = ((NodesModel) searchPivotsModel.m8629a().get(0)).m8625c();
                        searchResultsPageView.o.setTitleText(searchResultsPageView.getResources().getString(2131237657).toUpperCase(Locale.getDefault()));
                        searchResultsPageView.o.setSubtitleText(new SeparatedSpannableStringBuilder(": ").a(c.m8618d(), new TextAppearanceSpan(searchResultsPageView.getContext(), 2131625992), 17).a(c.m8617c().m8606a(), new TextAppearanceSpan(searchResultsPageView.getContext(), 2131625991), 17));
                        searchResultsPageView.o.setThumbnailUri(c.m8616b().b());
                        searchResultsPageView.o.setOnClickListener(new 2(searchResultsPageView, searchPivotsModel));
                        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 128.0f, 0.0f);
                        translateAnimation.setDuration(300);
                        translateAnimation.setInterpolator(new DecelerateInterpolator());
                        searchResultsPageView.o.setVisibility(0);
                        searchResultsPageView.o.startAnimation(translateAnimation);
                    }
                }
            }, ((long) this.aC.a(ExperimentsForSearchAbTestModule.aZ, 5)) * 1000);
        } else if (!(h == null || h.isEmpty() || m26672a(a))) {
            this.aE.b(new Runnable(this) {
                final /* synthetic */ SearchResultsFeedFragment f23039b;

                public void run() {
                    ((SearchResultPageFilterController) this.f23039b.aW.get()).m26433a(h);
                }
            });
        }
        if (this.br) {
            this.bf.m27071e();
            this.br = false;
            this.bh.getSwipeLayout().setRefreshing(false);
        }
        boolean i = this.bf.m27074i();
        int a2 = this.bf.m27051a();
        z = this.bf.m27075j();
        if (this.bs || !this.bt || this.aJ.a(SearchAbTestGatekeepers.n, false)) {
            this.bf.m27060a(a);
        } else {
            this.bf.m27067b(a);
        }
        if (this.bf.m27075j() != z) {
            z = true;
        } else {
            z = false;
        }
        this.bf.m27062a(a.m27027d().entrySet(), a.m27028e().entrySet());
        this.bE = c2510x73e72fcc.m26979f();
        if (a.m27026c() > 0 || r0) {
            aC(this);
            this.am.m27021a(ax, a, this.bf, ((SearchResultPageFilterController) this.aW.get()).m26438e(), this.bu, this.bv);
            this.bu++;
        }
        boolean z2 = a.m27025b().b() && a.m27026c() == 0 && !this.bt;
        if (z2 && !aJ()) {
            state = State.LOADING;
        } else if (this.bf.m27072f() && this.bs) {
            state = State.LOADING_MORE;
        } else if (this.bf.m27063b() == 0) {
            state = State.LOADING_FINISHED_NO_RESULTS;
        } else {
            state = State.LOADING_FINISHED;
        }
        m26670a(state);
        if (i) {
            this.bj.h(0);
        }
        if (a2 == this.bf.m27051a() && this.bc.remove(c2510x73e72fcc.m26978e())) {
            this.an.m25513a(ax(), ImmutableList.of(c2510x73e72fcc.m26978e()), this.bq, false);
        }
        if (z2) {
            this.bt = true;
            m26667a(this, SearchResultsFeedLoadMoreRequestType.ON_SCROLL);
        } else if (this.bs && this.bt) {
            this.bt = false;
        }
    }

    public final void m26684a(GraphSearchException graphSearchException) {
        this.bc.clear();
        this.bs = false;
        m26670a(this.bf.m27074i() ? State.ERROR : State.ERROR_LOADING_MORE);
        this.ar.m25471a(this.f22960h, this.bu, this.bv, graphSearchException.toString());
        ((GraphSearchErrorReporter) this.aR.get()).a(graphSearchException);
        if (BuildConstants.i) {
            ((Toaster) this.aQ.get()).b(new ToastBuilder(graphSearchException.toString()));
        }
        ((SearchBugReportExtraDataProvider) this.aV.get()).a(aO, SearchBugReportEvent.RESULTS_LOAD_FAILURE, "Exception: " + graphSearchException);
    }

    public final void A_(int i) {
        this.bc.clear();
        this.bs = false;
        this.an.m25507a((GraphSearchQuerySpec) this.f22960h, i);
        m26670a(State.REQUEST_TIMED_OUT);
        this.ar.m25471a(this.f22960h, this.bu, this.bv, "Timeout: " + i);
    }

    public final void m26688a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        if (this.bk != null && !this.bk.ba_()) {
            m26682a(new DumpsysContext(str, fileDescriptor, printWriter, strArr, (DumpsysDumper) this.aS.get()));
        }
    }

    public static void aC(SearchResultsFeedFragment searchResultsFeedFragment) {
        searchResultsFeedFragment.bk.notifyDataSetChanged();
    }

    private void m26666a(SearchPivotsModel searchPivotsModel) {
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            View lh_ = hasTitleBar.lh_();
            if (lh_ != null && (lh_ instanceof GraphSearchTitleSearchBox)) {
                final InterstitialTrigger interstitialTrigger = new InterstitialTrigger(InterstitialTrigger.Action.SEARCH_TRENDING_TOPIC_LOADED);
                final SearchTrendingAwarenessNuxInterstitialController searchTrendingAwarenessNuxInterstitialController = (SearchTrendingAwarenessNuxInterstitialController) this.aB.a("3699", SearchTrendingAwarenessNuxInterstitialController.class);
                if (searchTrendingAwarenessNuxInterstitialController != null) {
                    if (searchPivotsModel != null) {
                        Builder builder = new Builder();
                        ImmutableList a = searchPivotsModel.m8629a();
                        int size = a.size();
                        int i = 0;
                        int i2 = 0;
                        while (i < size) {
                            int i3;
                            NodesModel nodesModel = (NodesModel) a.get(i);
                            QueryTitleModel b = nodesModel.m8624b();
                            if (b != null) {
                                builder.c(new SearchPivotData(b.m8598a(), nodesModel.m8623a()));
                                i3 = i2 + 1;
                            } else {
                                i3 = i2;
                            }
                            if (i3 == searchTrendingAwarenessNuxInterstitialController.f22526f.f22516b) {
                                break;
                            }
                            i++;
                            i2 = i3;
                        }
                        searchTrendingAwarenessNuxInterstitialController.f22528h = builder.b();
                    }
                    searchTrendingAwarenessNuxInterstitialController.f22529i = ((GraphSearchTitleSearchBox) lh_).e;
                    searchTrendingAwarenessNuxInterstitialController.f22527g = new Runnable(this) {
                        final /* synthetic */ SearchResultsFeedFragment f23041b;

                        public void run() {
                            this.f23041b.aB.a().d(searchTrendingAwarenessNuxInterstitialController.m25991b());
                        }
                    };
                    searchTrendingAwarenessNuxInterstitialController.f22530j = this.f22960h;
                    this.bB = new Runnable(this) {
                        final /* synthetic */ SearchResultsFeedFragment f23043b;

                        public void run() {
                            SearchTrendingAwarenessNuxInterstitialController searchTrendingAwarenessNuxInterstitialController = (SearchTrendingAwarenessNuxInterstitialController) this.f23043b.aB.a(interstitialTrigger, SearchTrendingAwarenessNuxInterstitialController.class);
                            if (searchTrendingAwarenessNuxInterstitialController != null) {
                                searchTrendingAwarenessNuxInterstitialController.m25989a(this.f23043b.getContext(), null);
                                this.f23043b.aB.a().a(searchTrendingAwarenessNuxInterstitialController.m25991b());
                            }
                        }
                    };
                    HandlerDetour.b(this.f22954b, this.bB, (long) this.aC.a(ExperimentsForSearchAbTestModule.bI, 6000), 375214447);
                }
            }
        }
    }

    private void m26669a(SearchResultsMutableContext searchResultsMutableContext, @Nullable String str) {
        if (this.aC.a(ExperimentsForSearchAbTestModule.bf, false)) {
            if (searchResultsMutableContext.f23383r != null) {
                return;
            }
        } else if (this.aC.a(ExperimentsForSearchAbTestModule.bg, false)) {
            if (str == null) {
                return;
            }
        }
        searchResultsMutableContext.m27092c(str);
    }

    private OnScrollListener aG() {
        return new OnScrollListener(this) {
            final /* synthetic */ SearchResultsFeedFragment f23029a;

            {
                this.f23029a = r1;
            }

            public final void m26658a(ScrollingViewProxy scrollingViewProxy, int i) {
                if (i == 0) {
                    this.f23029a.aD.b(this.f23029a.bj);
                    this.f23029a.bA.b();
                    return;
                }
                this.f23029a.bA.a();
            }

            public final void m26659a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
                this.f23029a.aD.a(scrollingViewProxy, i, i2, i3);
                SearchResultsFeedFragment searchResultsFeedFragment = this.f23029a;
                Object obj = 1;
                if (searchResultsFeedFragment.bf == null || i2 <= 0 || i3 <= 0) {
                    obj = null;
                } else {
                    int i4 = i + i2;
                    if (searchResultsFeedFragment.bE) {
                        if (i4 < i3 - 1) {
                            obj = null;
                        }
                    } else if (searchResultsFeedFragment.bk.s_(i4) + 10 < searchResultsFeedFragment.bf.m27051a() - 1) {
                        obj = null;
                    }
                }
                if (obj != null && this.f23029a.bf.m27072f() && !this.f23029a.aq.m27014c()) {
                    this.f23029a.an.m25506a((GraphSearchQuerySpec) this.f23029a.f22960h);
                    SearchResultsFeedFragment.m26667a(this.f23029a, SearchResultsFeedLoadMoreRequestType.ON_SCROLL);
                }
            }
        };
    }

    private void m26668a(SearchResultsFeedCollectionProvider searchResultsFeedCollectionProvider, SearchResultsFeedEventBusManagerProvider searchResultsFeedEventBusManagerProvider, EventsStream eventsStream, SearchResultsFeedLoggingProcessor searchResultsFeedLoggingProcessor, SearchResultsPerformanceLogger searchResultsPerformanceLogger, BatchedSearchLoader batchedSearchLoader, com.facebook.inject.Lazy<ComposerPublishServiceHelper> lazy, SearchResultsFeedEventsManagerProvider searchResultsFeedEventsManagerProvider, SearchResultsFeedModulesDataLoader searchResultsFeedModulesDataLoader, SearchResultsLogger searchResultsLogger, com.facebook.inject.Lazy<Toaster> lazy2, com.facebook.inject.Lazy<GraphSearchErrorReporter> lazy3, MultiRowAdapterBuilder multiRowAdapterBuilder, com.facebook.inject.Lazy<SearchResultsFeedRootPartDefinition> lazy4, SearchResultsFeedEnvironmentGeneratedProvider searchResultsFeedEnvironmentGeneratedProvider, Provider<MultipleRowsStoriesRecycleCallback> provider, SearchResultsTitleBarControllerProvider searchResultsTitleBarControllerProvider, SearchResultsGroupCommerceFilter searchResultsGroupCommerceFilter, SearchResultsFeedLoggingViewportEventListenerProvider searchResultsFeedLoggingViewportEventListenerProvider, SearchResultsFeedHeightLoggingEventListener searchResultsFeedHeightLoggingEventListener, MultiRowImagePrefetcherFactory multiRowImagePrefetcherFactory, InterstitialManager interstitialManager, QeAccessor qeAccessor, com.facebook.inject.Lazy<DumpsysDumper> lazy5, ViewportMonitor viewportMonitor, com.facebook.inject.Lazy<SearchAwarenessController> lazy6, AndroidThreadUtil androidThreadUtil, SearchResultsIntentBuilder searchResultsIntentBuilder, com.facebook.inject.Lazy<SecureContextHelper> lazy7, com.facebook.inject.Lazy<SearchBugReportExtraDataProvider> lazy8, SearchResultsLastContextProvider searchResultsLastContextProvider, LiveFeedDataLoaderProvider liveFeedDataLoaderProvider, FrameRateLoggerProvider frameRateLoggerProvider, com.facebook.inject.Lazy<SearchResultPageFilterController> lazy9, GatekeeperStore gatekeeperStore, VideoFeedStoryMenuHelperProvider videoFeedStoryMenuHelperProvider, ReactionFeedActionHandlerProvider reactionFeedActionHandlerProvider, ReactionInteractionTrackerProvider reactionInteractionTrackerProvider, com.facebook.inject.Lazy<ReactionSessionManager> lazy10, com.facebook.inject.Lazy<ReactionThemedContextHelper> lazy11) {
        this.f23044h = searchResultsFeedCollectionProvider;
        this.f23045i = searchResultsFeedEventBusManagerProvider;
        this.al = eventsStream;
        this.am = searchResultsFeedLoggingProcessor;
        this.an = searchResultsPerformanceLogger;
        this.ao = batchedSearchLoader;
        this.aP = lazy;
        this.ap = searchResultsFeedEventsManagerProvider;
        this.aq = searchResultsFeedModulesDataLoader;
        this.ar = searchResultsLogger;
        this.aQ = lazy2;
        this.aR = lazy3;
        this.as = multiRowAdapterBuilder;
        this.at = lazy4;
        this.au = searchResultsFeedEnvironmentGeneratedProvider;
        this.av = provider;
        this.aw = searchResultsTitleBarControllerProvider;
        this.ax = searchResultsGroupCommerceFilter;
        this.ay = searchResultsFeedLoggingViewportEventListenerProvider;
        this.az = searchResultsFeedHeightLoggingEventListener;
        this.aA = multiRowImagePrefetcherFactory;
        this.aB = interstitialManager;
        this.aC = qeAccessor;
        this.aS = lazy5;
        this.aD = viewportMonitor;
        this.aT = lazy6;
        this.aE = androidThreadUtil;
        this.aF = searchResultsIntentBuilder;
        this.aU = lazy7;
        this.aV = lazy8;
        this.aG = searchResultsLastContextProvider;
        this.aH = liveFeedDataLoaderProvider;
        this.aI = frameRateLoggerProvider;
        this.aW = lazy9;
        this.aJ = gatekeeperStore;
        this.aK = videoFeedStoryMenuHelperProvider;
        this.aL = reactionFeedActionHandlerProvider;
        this.aM = reactionInteractionTrackerProvider;
        this.aX = lazy10;
        this.aY = lazy11;
    }

    @Nullable
    public Surface getSurface() {
        return Surface.ANDROID_GPS_LOCATION_SUGGESTION;
    }

    public String getSessionId() {
        return (!this.aZ || this.ba == null) ? "NO_SESSION_ID" : this.ba.f18658a;
    }

    @Nullable
    public ReactionInteractionTracker getInteractionTracker() {
        if (this.aZ && this.bb == null) {
            this.bb = this.aM.m22880a(this.ba, null);
        }
        return this.bb;
    }

    public Fragment getFragment() {
        return this;
    }

    @Nullable
    public ViewGroup getCardViewGroup() {
        return this.bj.b();
    }

    @Nullable
    public final ReactionUnitFragment mo725a(String str) {
        return null;
    }

    public final boolean mo729a(String str, CardSearchType cardSearchType) {
        return false;
    }

    public final boolean mo728a(ReactionUnitFragment reactionUnitFragment, String str, CardSearchType cardSearchType) {
        return false;
    }

    public final void mo1285a(ImmutableList<FilterPersistentState> immutableList) {
        ((SearchResultPageFilterController) this.aW.get()).m26435b((ImmutableList) immutableList);
        this.bf.m27071e();
        this.bk.notifyDataSetChanged();
        m26670a(State.LOADING_MORE);
        this.aq.m27011a(this.f22960h, this.f22960h.f23369d.b, this.f22960h.f23367b, false, ((SearchResultPageFilterController) this.aW.get()).m26438e());
        this.ar.m25488b(this.f22960h, ((SearchResultPageFilterController) this.aW.get()).m26438e());
    }

    public final void mo1284a(Filters filters) {
        ImmutableList a = ((SearchResultPageFilterController) this.aW.get()).m26428a(filters);
        this.bf.m27071e();
        this.bk.notifyDataSetChanged();
        m26670a(State.LOADING_MORE);
        this.aq.m27011a(this.f22960h, this.f22960h.f23369d.b, this.f22960h.f23367b, false, a);
        this.ar.m25480a(this.f22960h, filters, ((SearchResultPageFilterController) this.aW.get()).m26438e());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m26673a(com.facebook.search.results.model.SearchResultsMutableContext r6) {
        /*
        r5 = this;
        r0 = 1;
        r1 = r6.mo1212b();
        r1 = com.facebook.search.api.SearchQueryFunctions.a(r1);
        if (r1 != 0) goto L_0x0025;
    L_0x000b:
        r3 = r6.m27102v();
        if (r3 == 0) goto L_0x0032;
    L_0x0011:
        r3 = "news_v2";
        r4 = r6.m27102v();
        r4 = r4.mo596l();
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0032;
    L_0x0021:
        r3 = 1;
    L_0x0022:
        r1 = r3;
        if (r1 == 0) goto L_0x0030;
    L_0x0025:
        r1 = r5.aC;
        r2 = com.facebook.search.abtest.ExperimentsForSearchAbTestModule.bR;
        r1 = r1.a(r2, r0);
        if (r1 != 0) goto L_0x0030;
    L_0x002f:
        return r0;
    L_0x0030:
        r0 = 0;
        goto L_0x002f;
    L_0x0032:
        r3 = 0;
        goto L_0x0022;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.fragment.feed.SearchResultsFeedFragment.a(com.facebook.search.results.model.SearchResultsMutableContext):boolean");
    }

    private boolean m26672a(SearchResults searchResults) {
        return this.bf.m27074i() && searchResults.m27026c() == 0 && ((SearchResultPageFilterController) this.aW.get()).m26438e().isEmpty();
    }

    private boolean aJ() {
        return this.bi == State.LOADING_MORE || this.bi == State.LOADING_FINISHED || this.bi == State.LOADING_FINISHED_NO_RESULTS;
    }
}
