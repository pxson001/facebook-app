package com.facebook.search.results.fragment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.ui.VideoFeedStoryMenuHelperProvider;
import com.facebook.graphql.calls.SearchQueryInputQueryArguments.FilteredQueryArguments.Filters;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.SearchResultsLoggingViewportEventListener;
import com.facebook.search.logging.SearchResultsLoggingViewportEventListenerProvider;
import com.facebook.search.logging.api.SearchResultsAnalytics;
import com.facebook.search.model.FilterType;
import com.facebook.search.results.environment.FeedMenuHelperReference;
import com.facebook.search.results.environment.SearchResultsEnvironment;
import com.facebook.search.results.environment.SearchResultsEnvironmentGeneratedProvider;
import com.facebook.search.results.filters.controller.SearchResultPageFilterController;
import com.facebook.search.results.filters.controller.SearchResultPageFilterController.OnFilterClearButtonClickListener;
import com.facebook.search.results.filters.definition.FilterPersistentState;
import com.facebook.search.results.filters.model.SearchResultPageMainFilterConverter;
import com.facebook.search.results.filters.ui.SearchResultPageFilterFragment;
import com.facebook.search.results.filters.ui.SearchResultPageFilterFragment.OnFilterValuesSelectedListener;
import com.facebook.search.results.fragment.controllers.SearchResultsControllerCallbacksDispatcher;
import com.facebook.search.results.fragment.controllers.SearchResultsControllerCallbacksDispatcherFactory;
import com.facebook.search.results.loader.SearchResultsFilterer;
import com.facebook.search.results.loader.SearchResultsLoader;
import com.facebook.search.results.model.SearchResultUnit;
import com.facebook.search.results.model.SearchResultsCollection;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.protocol.SearchResultsGraphQLModels.SearchResultsGraphQLModel;
import com.facebook.search.results.protocol.SearchResultsMetaDataInterfaces.SearchResultsMetaData;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageFiltersFragmentModel;
import com.facebook.search.results.rows.SearchResultsRootPartDefinition;
import com.facebook.search.widget.resultspage.SearchResultsPage.LoadingIndicatorType;
import com.facebook.search.widget.resultspage.SearchResultsPage.State;
import com.facebook.search.widget.resultspage.SearchResultsPageView;
import com.facebook.search.widget.resultspage.SearchResultsPageView$FilterButtonClickListener;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.google.common.base.Absent;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: SIMPLEPICKER */
public class SearchResultsFragment extends SearchResultsBaseFragment implements AnalyticsFragmentWithExtraData, OnFilterClearButtonClickListener, OnFilterValuesSelectedListener, SearchResultsPageView$FilterButtonClickListener {
    private static final FeedListType aB = new C24481();
    private static final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> aC = ImmutableList.of(GraphQLGraphSearchResultsDisplayStyle.USERS);
    @Inject
    Lazy<SearchResultPageMainFilterConverter> aA;
    private String aD;
    public SearchResultsCollection aE;
    private SearchResultsControllerCallbacksDispatcher aF;
    public MultiRowAdapter aG;
    private SearchResultsLoggingViewportEventListener aH;
    private SearchResultsPageView aI;
    private State aJ;
    public ScrollingViewProxy aK;
    public FrameRateLogger aL;
    public boolean aM;
    public boolean aN = true;
    public boolean aO = false;
    public boolean aP = false;
    public int aQ = 0;
    @Inject
    MultiRowAdapterBuilder al;
    @Inject
    Provider<MultipleRowsStoriesRecycleCallback> am;
    @Inject
    SearchResultsControllerCallbacksDispatcherFactory an;
    @Inject
    SearchResultsEnvironmentGeneratedProvider ao;
    @Inject
    SearchResultsLoader ap;
    @Inject
    SearchResultsLogger aq;
    @Inject
    SearchResultsFilterer ar;
    @Inject
    Lazy<SearchResultsRootPartDefinition> as;
    @Inject
    TasksManager at;
    @Inject
    VideoFeedStoryMenuHelperProvider au;
    @Inject
    ViewportMonitor av;
    @Inject
    SearchResultsLoggingViewportEventListenerProvider aw;
    @Inject
    public Lazy<SearchResultPageFilterController> ax;
    @Inject
    Lazy<AndroidThreadUtil> ay;
    @Inject
    QeAccessor az;
    @Inject
    FrameRateLoggerProvider f22967h;
    @Inject
    GraphSearchErrorReporter f22968i;

    /* compiled from: SIMPLEPICKER */
    final class C24481 implements FeedListType {
        C24481() {
        }

        public final FeedListName m26585a() {
            return FeedListName.SEARCH_RESULTS;
        }
    }

    /* compiled from: SIMPLEPICKER */
    class C24492 implements Runnable {
        final /* synthetic */ SearchResultsFragment f22962a;

        C24492(SearchResultsFragment searchResultsFragment) {
            this.f22962a = searchResultsFragment;
        }

        public void run() {
            this.f22962a.aG.notifyDataSetChanged();
        }
    }

    /* compiled from: SIMPLEPICKER */
    class C24514 extends AbstractDisposableFutureCallback<GraphQLResult<SearchResultsGraphQLModel>> {
        final /* synthetic */ SearchResultsFragment f22965a;

        C24514(SearchResultsFragment searchResultsFragment) {
            this.f22965a = searchResultsFragment;
        }

        protected final void m26586a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f22965a.aM = false;
            SearchResultsMetaData a = ((SearchResultsGraphQLModel) graphQLResult.e).m9825a();
            if (a == null) {
                this.f22965a.f22968i.a(GraphSearchError.RESULTS_DATA_LOADER_ERROR, "CombinedResults were null.");
                SearchResultsFragment.aD(this.f22965a);
                return;
            }
            ImmutableList e;
            boolean z;
            State state;
            SearchResultsMutableContext searchResultsMutableContext = this.f22965a.f22960h;
            searchResultsMutableContext.f23385t = a;
            ImmutableList a2 = this.f22965a.ar.m26941a(a.m9816a());
            this.f22965a.aE.m27039a(SearchResultUnit.m27023a(a2), a.m9817b());
            this.f22965a.aG.notifyDataSetChanged();
            SearchResultsLogger searchResultsLogger = this.f22965a.aq;
            int i = this.f22965a.aE.f23339c;
            int size = a2.size();
            int i2 = this.f22965a.aQ;
            if (this.f22965a.aO) {
                e = ((SearchResultPageFilterController) this.f22965a.ax.get()).m26438e();
            } else {
                e = null;
            }
            searchResultsLogger.m25469a(searchResultsMutableContext, i, size, i2, e, null, null);
            SearchResultsCollection searchResultsCollection = this.f22965a.aE;
            searchResultsCollection.f23339c++;
            SearchResultsFragment.m26592a(this.f22965a, graphQLResult);
            SearchResultsFragment searchResultsFragment = this.f22965a;
            if (!this.f22965a.aE.m27041b() || this.f22965a.aE.m27042e().b()) {
                z = true;
            } else {
                z = false;
            }
            searchResultsFragment.aN = z;
            if (!this.f22965a.aE.m27042e().b() || a2.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            boolean z2;
            if (!this.f22965a.aP && this.f22965a.aE.m27042e().b() && a2.isEmpty()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z || r1) {
                state = State.LOADING_MORE;
            } else if (this.f22965a.aE.m27041b()) {
                state = State.EMPTY;
            } else {
                state = State.LOADING_FINISHED;
            }
            SearchResultsFragment.m26593a(this.f22965a, state);
            if (a2.isEmpty() && !this.f22965a.aP && this.f22965a.aE.m27042e().b()) {
                this.f22965a.aP = true;
                SearchResultsFragment.aE(this.f22965a);
                return;
            }
            this.f22965a.aP = false;
        }

        protected final void m26587a(Throwable th) {
            this.f22965a.aM = false;
            this.f22965a.aN = false;
            SearchResultsFragment.aD(this.f22965a);
            this.f22965a.f22968i.a(GraphSearchError.RESULTS_DATA_LOADER_ERROR, th);
            this.f22965a.aq.m25471a(this.f22965a.f22960h, this.f22965a.aE.f23339c, this.f22965a.aQ, th.toString());
        }
    }

    /* compiled from: SIMPLEPICKER */
    class C24525 implements OnScrollListener {
        final /* synthetic */ SearchResultsFragment f22966a;

        C24525(SearchResultsFragment searchResultsFragment) {
            this.f22966a = searchResultsFragment;
        }

        public final void m26588a(ScrollingViewProxy scrollingViewProxy, int i) {
            if (i == 0) {
                this.f22966a.aL.b();
                this.f22966a.av.b(this.f22966a.aK);
                return;
            }
            this.f22966a.aL.a();
        }

        public final void m26589a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            this.f22966a.av.a(scrollingViewProxy, i, i2, i3);
            SearchResultsFragment searchResultsFragment = this.f22966a;
            Object obj = null;
            if (searchResultsFragment.aE != null && !searchResultsFragment.aM && i2 > 0 && i3 > 0) {
                if (searchResultsFragment.aG.s_(i + i2) + 10 >= searchResultsFragment.aE.m27037a() - 1) {
                    obj = 1;
                }
            }
            if (obj != null && this.f22966a.aE.m27042e().b()) {
                Object obj2;
                if (this.f22966a.aE.m27037a() <= 0 || this.f22966a.aM || !this.f22966a.aN) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (obj2 != null) {
                    SearchResultsFragment.aE(this.f22966a);
                }
            }
        }
    }

    public static void m26594a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((SearchResultsFragment) obj).m26591a((FrameRateLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), GraphSearchErrorReporter.a(injectorLike), MultiRowAdapterBuilder.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 1489), SearchResultsControllerCallbacksDispatcherFactory.m26628a(injectorLike), (SearchResultsEnvironmentGeneratedProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchResultsEnvironmentGeneratedProvider.class), SearchResultsLoader.m26945a(injectorLike), SearchResultsLogger.m25460a(injectorLike), SearchResultsFilterer.m26938a(injectorLike), IdBasedLazy.a(injectorLike, 10612), TasksManager.a(injectorLike), (VideoFeedStoryMenuHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoFeedStoryMenuHelperProvider.class), ViewportMonitor.a(injectorLike), (SearchResultsLoggingViewportEventListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchResultsLoggingViewportEventListenerProvider.class), IdBasedLazy.a(injectorLike, 10563), IdBasedLazy.a(injectorLike, 517), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 10571));
    }

    private void m26591a(FrameRateLoggerProvider frameRateLoggerProvider, GraphSearchErrorReporter graphSearchErrorReporter, MultiRowAdapterBuilder multiRowAdapterBuilder, Provider<MultipleRowsStoriesRecycleCallback> provider, SearchResultsControllerCallbacksDispatcherFactory searchResultsControllerCallbacksDispatcherFactory, SearchResultsEnvironmentGeneratedProvider searchResultsEnvironmentGeneratedProvider, SearchResultsLoader searchResultsLoader, SearchResultsLogger searchResultsLogger, SearchResultsFilterer searchResultsFilterer, Lazy<SearchResultsRootPartDefinition> lazy, TasksManager tasksManager, VideoFeedStoryMenuHelperProvider videoFeedStoryMenuHelperProvider, ViewportMonitor viewportMonitor, SearchResultsLoggingViewportEventListenerProvider searchResultsLoggingViewportEventListenerProvider, Lazy<SearchResultPageFilterController> lazy2, Lazy<AndroidThreadUtil> lazy3, QeAccessor qeAccessor, Lazy<SearchResultPageMainFilterConverter> lazy4) {
        this.f22967h = frameRateLoggerProvider;
        this.f22968i = graphSearchErrorReporter;
        this.al = multiRowAdapterBuilder;
        this.am = provider;
        this.an = searchResultsControllerCallbacksDispatcherFactory;
        this.ao = searchResultsEnvironmentGeneratedProvider;
        this.ap = searchResultsLoader;
        this.aq = searchResultsLogger;
        this.ar = searchResultsFilterer;
        this.as = lazy;
        this.at = tasksManager;
        this.au = videoFeedStoryMenuHelperProvider;
        this.av = viewportMonitor;
        this.aw = searchResultsLoggingViewportEventListenerProvider;
        this.ax = lazy2;
        this.ay = lazy3;
        this.az = qeAccessor;
        this.aA = lazy4;
    }

    public static SearchResultsFragment m26590a(String str) {
        SearchResultsFragment searchResultsFragment = new SearchResultsFragment();
        searchResultsFragment.aD = str;
        return searchResultsFragment;
    }

    public final String am_() {
        if (this.aD != null) {
            return this.aD;
        }
        String a = SearchResultsAnalytics.a(this.f22960h.mo1215f());
        return a == null ? "unknown" : a;
    }

    public final void mo1290c(Bundle bundle) {
        boolean z = false;
        super.mo1290c(bundle);
        Class cls = SearchResultsFragment.class;
        m26594a((Object) this, getContext());
        SearchResultsControllerCallbacksDispatcher searchResultsControllerCallbacksDispatcher = new SearchResultsControllerCallbacksDispatcher(this.an.f22995a);
        searchResultsControllerCallbacksDispatcher.f22994a = searchResultsControllerCallbacksDispatcher.f22994a.kJ_() ? searchResultsControllerCallbacksDispatcher.f22994a : null;
        this.aF = searchResultsControllerCallbacksDispatcher;
        this.aE = new SearchResultsCollection();
        InjectorLike injectorLike = this.aw;
        this.aH = new SearchResultsLoggingViewportEventListener((Clock) SystemClockMethodAutoProvider.a(injectorLike), SearchResultsLogger.m25460a(injectorLike), this.f22960h, this.aE);
        this.aL = this.f22967h.a(Boolean.valueOf(false), "search_results_scroll_perf", Absent.INSTANCE);
        this.av.a(this.aH);
        if (aC.contains(this.f22960h.m27098l()) && this.az.a(ExperimentsForSearchAbTestModule.U, false)) {
            z = true;
        }
        this.aO = z;
    }

    public final View m26598a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1444404113);
        Context az = az();
        this.aI = new SearchResultsPageView(az, FilterType.from(this.f22960h.m27101u()), LoadingIndicatorType.SPINNING_WHEEL);
        this.aI.H = 500;
        TypedValue typedValue = new TypedValue();
        az.getTheme().resolveAttribute(2130773623, typedValue, true);
        this.aI.setBackgroundDrawable(new ColorDrawable(typedValue.data));
        this.aK = this.aI.getScrollingViewProxy();
        FeedMenuHelperReference feedMenuHelperReference = new FeedMenuHelperReference();
        SearchResultsEnvironment a2 = this.ao.m26114a(az, aB, feedMenuHelperReference, new C24492(this), null, HasScrollListenerSupportImpl.a(this.aK), this.aE, ax(), this.aE);
        feedMenuHelperReference.f22541a = this.au.a(a2, NegativeFeedbackExperienceLocation.SEARCH_RESULTS, am_());
        this.aF.m26625a(a2);
        Builder a3 = this.al.a(this.as, this.aE);
        a3.f = a2;
        this.aG = a3.e();
        aA();
        this.aK.a(this.aG);
        this.aK.a(((MultipleRowsStoriesRecycleCallback) this.am.get()).a());
        if (this.aJ != null) {
            this.aI.J = false;
            this.aI.setState(this.aJ);
        }
        this.aK.a(aF());
        this.av.a(true, this.aK);
        this.av.a(this.aH);
        this.aM = false;
        SearchResultsPageView searchResultsPageView = this.aI;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 118173892, a);
        return searchResultsPageView;
    }

    protected final boolean ar() {
        return !this.aE.m27041b();
    }

    protected final void aq() {
        this.aE.m27043f();
        this.aQ = 0;
        this.aM = true;
        this.aK.h(0);
        m26593a(this, State.LOADING);
        this.at.a("search_results_loader_task", this.ap.m26950a(this.f22960h, this.aE.m27042e().a(), RegularImmutableList.a), aC());
    }

    public final void mo1282G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 636467304);
        super.mo1282G();
        this.aF.m26626c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -505621123, a);
    }

    protected final void au() {
        super.au();
        this.av.a(true, this.aK);
    }

    protected final void av() {
        this.at.c();
        this.aL.b();
        this.av.c(this.aK);
        super.av();
    }

    public final void mo1283H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1400390165);
        this.aF.m26627d();
        super.mo1283H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1679792917, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1569487359);
        this.aK = null;
        this.aI = null;
        if (this.aO) {
            SearchResultPageFilterController searchResultPageFilterController = (SearchResultPageFilterController) this.ax.get();
            searchResultPageFilterController.m26429a();
            searchResultPageFilterController.m26434b();
            searchResultPageFilterController.f22794j = null;
        }
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1762027793, a);
    }

    public final void m26597I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1546465191);
        if (this.aG != null) {
            this.aG.jc_();
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1774812334, a);
    }

    public final void kP_() {
        kO_().a().a(SearchResultPageFilterFragment.m26554a(((SearchResultPageFilterController) this.ax.get()).m26437d(), (OnFilterValuesSelectedListener) this), "FILTER_FRAGMENT_TAG").b();
        this.aq.m25468a(this.f22960h);
    }

    public final void mo1284a(Filters filters) {
        this.aE.m27043f();
        this.aG.notifyDataSetChanged();
        m26593a(this, State.LOADING_MORE);
        ImmutableList a = ((SearchResultPageFilterController) this.ax.get()).m26428a(filters);
        this.at.a("search_results_loader_task", this.ap.m26950a(this.f22960h, this.aE.m27042e().a(), a), aC());
        this.aq.m25480a(this.f22960h, filters, ((SearchResultPageFilterController) this.ax.get()).m26438e());
    }

    public final void mo1285a(ImmutableList<FilterPersistentState> immutableList) {
        ((SearchResultPageFilterController) this.ax.get()).m26435b((ImmutableList) immutableList);
        this.aE.m27043f();
        this.aG.notifyDataSetChanged();
        m26593a(this, State.LOADING_MORE);
        this.at.a("search_results_loader_task", this.ap.m26950a(this.f22960h, this.aE.m27042e().a(), ((SearchResultPageFilterController) this.ax.get()).m26438e()), aC());
        this.aq.m25488b(this.f22960h, ((SearchResultPageFilterController) this.ax.get()).m26438e());
    }

    private void aA() {
        if (this.aO) {
            SearchResultPageFilterController searchResultPageFilterController = (SearchResultPageFilterController) this.ax.get();
            searchResultPageFilterController.f22790f = this.aI;
            searchResultPageFilterController.f22794j = this;
            CustomFrameLayout customFrameLayout = (CustomFrameLayout) LayoutInflater.from(getContext()).inflate(2130906986, null);
            searchResultPageFilterController.f22791g = (HScrollRecyclerView) customFrameLayout.findViewById(2131567273);
            this.aI.a(customFrameLayout);
            this.aI.E = this;
            searchResultPageFilterController.m26436c();
        }
    }

    public static void m26592a(SearchResultsFragment searchResultsFragment, GraphQLResult graphQLResult) {
        if (searchResultsFragment.aO && ((SearchResultsGraphQLModel) graphQLResult.e).m9826j().size() != 0) {
            final ImmutableList a = ((SearchResultPageFiltersFragmentModel) ((SearchResultsGraphQLModel) graphQLResult.e).m9826j().get(0)).m10175a();
            if (!a.isEmpty()) {
                ((DefaultAndroidThreadUtil) searchResultsFragment.ay.get()).b(new Runnable(searchResultsFragment) {
                    final /* synthetic */ SearchResultsFragment f22964b;

                    public void run() {
                        SearchResultPageFilterController searchResultPageFilterController = (SearchResultPageFilterController) this.f22964b.ax.get();
                        this.f22964b.aA.get();
                        searchResultPageFilterController.m26433a(SearchResultPageMainFilterConverter.m26516a(a));
                    }
                });
            }
        }
    }

    public static void m26593a(SearchResultsFragment searchResultsFragment, State state) {
        if (searchResultsFragment.aI != null) {
            searchResultsFragment.aI.setState(state);
        }
        searchResultsFragment.aJ = state;
    }

    private AbstractDisposableFutureCallback<GraphQLResult<SearchResultsGraphQLModel>> aC() {
        return new C24514(this);
    }

    public static void aD(SearchResultsFragment searchResultsFragment) {
        m26593a(searchResultsFragment, searchResultsFragment.aE.m27041b() ? State.ERROR : State.ERROR_LOADING_MORE);
    }

    public static void aE(SearchResultsFragment searchResultsFragment) {
        if (!searchResultsFragment.at.a("search_results_loader_more_task")) {
            ImmutableList e;
            SearchResultsMutableContext searchResultsMutableContext = searchResultsFragment.f22960h;
            Preconditions.checkNotNull(searchResultsMutableContext.mo1212b());
            searchResultsFragment.aM = true;
            m26593a(searchResultsFragment, searchResultsFragment.aE.m27041b() ? State.LOADING : State.LOADING_MORE);
            TasksManager tasksManager = searchResultsFragment.at;
            String str = "search_results_loader_more_task";
            SearchResultsLoader searchResultsLoader = searchResultsFragment.ap;
            String a = searchResultsFragment.aE.m27042e().a();
            if (searchResultsFragment.aO) {
                e = ((SearchResultPageFilterController) searchResultsFragment.ax.get()).m26438e();
            } else {
                e = RegularImmutableList.a;
            }
            tasksManager.a(str, searchResultsLoader.m26950a(searchResultsMutableContext, a, e), searchResultsFragment.aC());
        }
    }

    private OnScrollListener aF() {
        return new C24525(this);
    }
}
