package com.facebook.search.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Product;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.pandora.common.events.PandoraEvents.LaunchConsumptionGalleryEvent;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ModifierKeys;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.bootstrap.db.data.BootstrapDbCacheWarmer;
import com.facebook.search.events.FriendshipEventSubscriber;
import com.facebook.search.fragment.GraphSearchChildFragment.OnResultClickListener;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.search.logging.perf.SearchPerfLogger;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.FilterType;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.model.GraphSearchQuerySpecImpl;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit.Builder;
import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import com.facebook.search.model.KeywordTypeaheadUnit.Source;
import com.facebook.search.model.NearbyTypeaheadUnit;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.model.PlaceTipsTypeaheadUnit;
import com.facebook.search.model.ReactionSearchData;
import com.facebook.search.model.SeeMoreResultPageUnit;
import com.facebook.search.model.ShortcutTypeaheadUnit;
import com.facebook.search.model.TrendingTypeaheadUnit;
import com.facebook.search.model.awareness.AwarenessGraphSearchConfiguration;
import com.facebook.search.module.SearchPerfLoggerMethodAutoProvider;
import com.facebook.search.quickpromotion.SearchAwarenessController;
import com.facebook.search.quickpromotion.SearchAwarenessTutorialNuxController;
import com.facebook.search.results.fragment.pps.SeeMoreResultsListAdapter;
import com.facebook.search.results.fragment.pps.SeeMoreResultsListFragment;
import com.facebook.search.results.fragment.pps.SeeMoreResultsPagerAdapter;
import com.facebook.search.results.fragment.pps.SimpleAndGraphSearchFetchHelper;
import com.facebook.search.searchbox.GraphSearchTitleEditTextSupplier;
import com.facebook.search.suggestions.SearchSuggestionsInitializer;
import com.facebook.search.suggestions.SuggestionsFragment;
import com.facebook.search.suggestions.nullstate.NullStatePartDefinitionInitializer;
import com.facebook.search.suggestions.nullstate.NullStateSupplier.RefreshPolicy;
import com.facebook.search.suggestions.nullstate.RecentSearchesMutatorSelector;
import com.facebook.search.suggestions.nullstate.mutator.NullStateSupplierFactory;
import com.facebook.search.titlebar.GraphSearchTitleBarLifeCycleController;
import com.facebook.search.titlebar.GraphSearchTitleSearchBox;
import com.facebook.search.util.GraphSearchConfig;
import com.facebook.search.util.bugreporter.SearchBugReportEvent;
import com.facebook.tablet.abtest.SideshowCompatibleContainer;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ufiservices.flyout.UFIPopoverFragment;
import com.facebook.ui.search.SearchEditText;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.text.BetterEditTextView;
import com.facebook.widget.text.BetterEditTextView.TextInteractionListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TimeToActionBarRendered */
public class GraphSearchFragment extends FbFragment implements AnalyticsFragmentWithExtraData, CanHandleBackPressed, SideshowCompatibleContainer {
    private static final CallerContext f21887a = CallerContext.a(GraphSearchFragment.class, "search");
    @Inject
    private GraphSearchConfig al;
    @Inject
    private GatekeeperStoreImpl am;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RapidFeedbackController> an = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SearchAwarenessController> ao = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<NullStatePartDefinitionInitializer> ap = UltralightRuntime.b;
    @Inject
    private SearchSuggestionsInitializer aq;
    private GraphSearchTitleSearchBox ar;
    public GraphSearchNavigationController as;
    private GraphSearchChildFragmentNavigator at;
    private OnTouchListener au;
    private OnResultClickListener av = new C23633(this);
    @Inject
    private GraphSearchTitleBarLifeCycleController f21888b;
    @Inject
    private GraphSearchTitleEditTextSupplier f21889c;
    @Inject
    private GraphSearchNavigationControllerProvider f21890d;
    @Inject
    private GraphSearchChildFragmentNavigatorProvider f21891e;
    @Inject
    private NullStateSupplierFactory f21892f;
    @Inject
    private RecentSearchesMutatorSelector f21893g;
    @Inject
    private SearchPerfLogger f21894h;
    @Inject
    private FriendshipEventSubscriber f21895i;

    /* compiled from: TimeToActionBarRendered */
    class C23611 implements TextInteractionListener {
        final /* synthetic */ GraphSearchFragment f21883a;

        C23611(GraphSearchFragment graphSearchFragment) {
            this.f21883a = graphSearchFragment;
        }

        public final void m25380a(CharSequence charSequence) {
            GraphSearchNavigationController graphSearchNavigationController = this.f21883a.as;
            SuggestionsFragment a = graphSearchNavigationController.f21907e.m25370a(graphSearchNavigationController.f21927y);
            graphSearchNavigationController.f21923u.a(GraphSearchNavigationController.f21897E, SearchBugReportEvent.NEW_TYPEAHEAD_TEXT_TYPED, "\"" + charSequence.toString() + "\"");
            if (graphSearchNavigationController.f21921s.a(SearchAbTestGatekeepers.m, false) && StringUtil.a(charSequence) && graphSearchNavigationController.f21900A != null && !graphSearchNavigationController.f21908f.m25377a(graphSearchNavigationController.f21907e.m25374d())) {
                graphSearchNavigationController.f21908f.m25378b(graphSearchNavigationController.f21907e.m25374d());
            } else if (!graphSearchNavigationController.f21908f.m25377a(a)) {
                graphSearchNavigationController.f21908f.m25378b(a);
                a.a(graphSearchNavigationController.f21927y);
            }
            SuggestionsFragment.b(a, charSequence.toString());
        }
    }

    /* compiled from: TimeToActionBarRendered */
    class C23633 implements OnResultClickListener {
        final /* synthetic */ GraphSearchFragment f21886a;

        C23633(GraphSearchFragment graphSearchFragment) {
            this.f21886a = graphSearchFragment;
        }

        public final void mo1194a(GraphSearchQuery graphSearchQuery, EntityTypeaheadUnit entityTypeaheadUnit) {
            this.f21886a.as.m25424a(graphSearchQuery, entityTypeaheadUnit);
        }

        public final void mo1199a(SeeMoreResultPageUnit seeMoreResultPageUnit) {
            this.f21886a.as.m25424a(null, seeMoreResultPageUnit.f22265a);
        }

        public final void mo1201a(TrendingTypeaheadUnit trendingTypeaheadUnit) {
            GraphSearchNavigationController graphSearchNavigationController = this.f21886a.as;
            if (trendingTypeaheadUnit.m25769u()) {
                graphSearchNavigationController.f21905c.a(graphSearchNavigationController.f21904b, StringFormatUtil.formatStrLocaleSafe(FBLinks.ea, trendingTypeaheadUnit.f22304j, Surface.ANDROID_TRENDING_PLACE_TIPS));
                return;
            }
            Builder builder = new Builder();
            builder.f22087b = trendingTypeaheadUnit.f22297c;
            builder = builder;
            builder.f22088c = trendingTypeaheadUnit.f22298d;
            builder = builder;
            builder.f22089d = trendingTypeaheadUnit.f22295a;
            builder = builder;
            builder.f22090e = "news_v2";
            builder = builder;
            builder.f22107v = trendingTypeaheadUnit.mo1215f();
            builder = builder;
            builder.f22096k = Source.TRENDING_ENTITY;
            builder = builder;
            builder.f22094i = trendingTypeaheadUnit.f22301g;
            builder = builder.m25650a(trendingTypeaheadUnit.f22306l, trendingTypeaheadUnit.f22307m, trendingTypeaheadUnit.f22308n);
            builder.f22109x = trendingTypeaheadUnit.f22309o;
            graphSearchNavigationController.m25426a(builder.m25651b());
        }

        public final void mo1196a(KeywordTypeaheadUnit keywordTypeaheadUnit) {
            this.f21886a.as.m25426a(keywordTypeaheadUnit);
        }

        public final void mo1195a(GraphSearchQuery graphSearchQuery, NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit) {
            this.f21886a.as.m25425a(graphSearchQuery, nullStateSuggestionTypeaheadUnit);
        }

        public final void mo1193a() {
            GraphSearchNavigationController graphSearchNavigationController = this.f21886a.as;
            SeeMoreResultsListFragment c = graphSearchNavigationController.f21907e.m25373c();
            SearchTypeaheadSession e = graphSearchNavigationController.f21907e.m25375e();
            if (!(c.al == null || c.al.equals(SeeMoreResultsListFragment.m26755e(c)))) {
                SeeMoreResultsPagerAdapter seeMoreResultsPagerAdapter = c.f23088a;
                SimpleAndGraphSearchFetchHelper simpleAndGraphSearchFetchHelper = seeMoreResultsPagerAdapter.f23109d;
                simpleAndGraphSearchFetchHelper.m26791b();
                simpleAndGraphSearchFetchHelper.f23124c.clear();
                simpleAndGraphSearchFetchHelper.f23125d.clear();
                simpleAndGraphSearchFetchHelper.f23123b.clear();
                simpleAndGraphSearchFetchHelper.f23126e.clear();
                simpleAndGraphSearchFetchHelper.f23127f.clear();
                simpleAndGraphSearchFetchHelper.f23128g.clear();
                simpleAndGraphSearchFetchHelper.f23129h.clear();
                for (FilterType filterType : seeMoreResultsPagerAdapter.f23110e.keySet()) {
                    SeeMoreResultsPagerAdapter.m26768a(seeMoreResultsPagerAdapter, filterType, (SeeMoreResultsListAdapter) seeMoreResultsPagerAdapter.f23110e.get(filterType));
                }
                seeMoreResultsPagerAdapter.f23109d.m26789a(SeeMoreResultsPagerAdapter.m26772i(seeMoreResultsPagerAdapter), FilterType.getCoreFilterTypeAt(seeMoreResultsPagerAdapter.f23118m.k));
            }
            c.al = SeeMoreResultsListFragment.m26755e(c);
            c.f23096i.a(0, false);
            c.f23094g.scrollTo(0, 0);
            c.f23094g.a(0, 0.0f, 0);
            c.f23090c.m25521a(e);
            graphSearchNavigationController.f21908f.m25378b(c);
        }

        public final void mo1200a(ShortcutTypeaheadUnit shortcutTypeaheadUnit) {
            this.f21886a.as.m25428a(shortcutTypeaheadUnit);
        }

        public final void mo1198a(PlaceTipsTypeaheadUnit placeTipsTypeaheadUnit) {
            GraphSearchNavigationController graphSearchNavigationController = this.f21886a.as;
            graphSearchNavigationController.f21905c.a(graphSearchNavigationController.f21904b, StringFormatUtil.formatStrLocaleSafe(FBLinks.af, placeTipsTypeaheadUnit.m25720f()));
        }

        public final void mo1197a(NearbyTypeaheadUnit nearbyTypeaheadUnit) {
            this.f21886a.as.m25427a(nearbyTypeaheadUnit);
        }

        public final boolean mo1202a(LaunchConsumptionGalleryEvent launchConsumptionGalleryEvent) {
            return false;
        }
    }

    public static void m25392a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((GraphSearchFragment) obj).m25391a(GraphSearchTitleBarLifeCycleController.a(injectorLike), GraphSearchTitleEditTextSupplier.m28573a(injectorLike), (GraphSearchNavigationControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GraphSearchNavigationControllerProvider.class), (GraphSearchChildFragmentNavigatorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GraphSearchChildFragmentNavigatorProvider.class), NullStateSupplierFactory.a(injectorLike), RecentSearchesMutatorSelector.a(injectorLike), SearchPerfLoggerMethodAutoProvider.m25835b(injectorLike), FriendshipEventSubscriber.m25348a(injectorLike), GraphSearchConfig.m10639a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 3253), IdBasedSingletonScopeProvider.b(injectorLike, 3383), IdBasedLazy.a(injectorLike, 10856), SearchSuggestionsInitializer.a(injectorLike));
    }

    public final void m25401c(Bundle bundle) {
        String str = null;
        super.c(bundle);
        Class cls = GraphSearchFragment.class;
        m25392a((Object) this, getContext());
        if (!this.am.a(SearchAbTestGatekeepers.x, false)) {
            ((NullStatePartDefinitionInitializer) this.ap.get()).a();
        }
        FragmentManager s = s();
        GraphSearchChildFragmentInstanceManager graphSearchChildFragmentInstanceManager = new GraphSearchChildFragmentInstanceManager(s, 2131562153);
        GraphSearchQuerySpec as = as();
        GraphSearchQuery at = at();
        GraphSearchChildFragmentNavigatorProvider graphSearchChildFragmentNavigatorProvider = this.f21891e;
        this.at = new GraphSearchChildFragmentNavigator(s, GatekeeperStoreImplMethodAutoProvider.a(graphSearchChildFragmentNavigatorProvider), NavigationLogger.a(graphSearchChildFragmentNavigatorProvider), Handler_ForUiThreadMethodAutoProvider.b(graphSearchChildFragmentNavigatorProvider));
        this.as = this.f21890d.m25430a(graphSearchChildFragmentInstanceManager, this.at, kO_());
        if (as != null) {
            String string;
            Bundle bundle2 = this.s;
            if (bundle2 != null) {
                str = bundle2.getString("typeahead_session_id");
                string = bundle2.getString("candidate_session_id");
            } else {
                string = null;
            }
            GraphSearchNavigationController graphSearchNavigationController = this.as;
            SearchTypeaheadSession searchTypeaheadSession = new SearchTypeaheadSession(str, string);
            SearchResultsSource ar = ar();
            graphSearchNavigationController.f21925w = searchTypeaheadSession;
            graphSearchNavigationController.f21926x = as;
            graphSearchNavigationController.f21928z = ar;
        } else if (at != null) {
            GraphSearchNavigationController graphSearchNavigationController2 = this.as;
            SearchResultsSource ar2 = ar();
            graphSearchNavigationController2.f21927y = at;
            graphSearchNavigationController2.f21928z = ar2;
            graphSearchNavigationController2.f21900A = (AwarenessGraphSearchConfiguration) graphSearchNavigationController2.f21927y.a(ModifierKeys.AWARENESS);
        } else if (aw()) {
            ((SearchAwarenessController) this.ao.get()).a();
        }
        this.aq.c();
        SearchSuggestionsInitializer searchSuggestionsInitializer = this.aq;
        if (!searchSuggestionsInitializer.j) {
            ((FriendshipEventSubscriber) searchSuggestionsInitializer.d.get()).m25350a();
        }
        if (bundle != null) {
            this.at.f21878c = bundle.getString("facebook:graphsearch:current_fragment_tag");
        }
        av();
        this.f21894h.mo1207d();
    }

    public final View m25396a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 568532388);
        int i = 2131625931;
        GraphSearchQuery at = at();
        if (at != null && at.h == ScopedEntityType.VIDEO) {
            i = 2131625933;
        }
        Context contextThemeWrapper = new ContextThemeWrapper(getContext(), i);
        View inflate = LayoutInflater.from(contextThemeWrapper).inflate(2130904419, viewGroup, false);
        this.ar = (GraphSearchTitleSearchBox) LayoutInflater.from(contextThemeWrapper).inflate(2130904632, null);
        GraphSearchTitleBarLifeCycleController graphSearchTitleBarLifeCycleController = this.f21888b;
        GraphSearchTitleSearchBox graphSearchTitleSearchBox = this.ar;
        CharSequence au = au();
        graphSearchTitleBarLifeCycleController.d = graphSearchTitleSearchBox;
        graphSearchTitleBarLifeCycleController.e = graphSearchTitleSearchBox.e;
        graphSearchTitleBarLifeCycleController.b.f25331a = graphSearchTitleSearchBox.e;
        graphSearchTitleBarLifeCycleController.a.f25334a = graphSearchTitleSearchBox;
        graphSearchTitleBarLifeCycleController.e.setText(au);
        graphSearchTitleBarLifeCycleController.e.setHint(2131237414);
        this.f21893g.a(at).d();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1365850224, a);
        return inflate;
    }

    public final ContentFragmentType m25402d() {
        return ContentFragmentType.SEARCH_FRAGMENT;
    }

    public final void m25399a(View view, Bundle bundle) {
        super.a(view, bundle);
        try {
            TracerDetour.a("GraphSearchFragment.onViewCreated", 1573216294);
            this.as.m25422a();
            final SearchEditText b = this.f21889c.m28575b();
            b.setTextInteractionListener(new C23611(this));
            this.au = new OnTouchListener(this) {
                final /* synthetic */ GraphSearchFragment f21885b;

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        GraphSearchNavigationController graphSearchNavigationController = this.f21885b.as;
                        CharSequence text = b.getText();
                        Fragment a = graphSearchNavigationController.f21908f.m25376a();
                        if (!(a == null || (a instanceof SuggestionsFragment) || graphSearchNavigationController.f21900A != null)) {
                            Fragment a2 = graphSearchNavigationController.f21912j.a("chromeless:content:fragment:tag");
                            if ((a2 instanceof UFIPopoverFragment) && a2.z()) {
                                ((UFIPopoverFragment) a2).mE_();
                            }
                            SuggestionsFragment a3 = graphSearchNavigationController.f21907e.m25370a(graphSearchNavigationController.f21927y);
                            graphSearchNavigationController.f21908f.m25378b(a3);
                            a3.a(text.toString(), graphSearchNavigationController.f21927y);
                        }
                    } else if (motionEvent.getAction() == 1) {
                        view.performClick();
                    }
                    return false;
                }
            };
            b.a(this.au);
            this.f21894h.mo1208e();
        } finally {
            TracerDetour.a(51862976);
        }
    }

    public final void m25403d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 192576832);
        super.d(bundle);
        SearchSuggestionsInitializer searchSuggestionsInitializer = this.aq;
        if (!searchSuggestionsInitializer.h) {
            ((BootstrapDbCacheWarmer) searchSuggestionsInitializer.c.get()).a();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 295345995, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -413129017);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            GraphSearchTitleBarLifeCycleController graphSearchTitleBarLifeCycleController = this.f21888b;
            boolean booleanExtra = o().getIntent().getBooleanExtra("search_titles_app_diable_animation", false);
            String au = au();
            Preconditions.checkNotNull(graphSearchTitleBarLifeCycleController.d);
            graphSearchTitleBarLifeCycleController.f = hasTitleBar;
            if (graphSearchTitleBarLifeCycleController.c.equals(Product.PAA)) {
                graphSearchTitleBarLifeCycleController.f.a_(au);
            } else {
                if (!booleanExtra) {
                    graphSearchTitleBarLifeCycleController.f.a(TitleBarButtonSpec.b);
                }
                graphSearchTitleBarLifeCycleController.f.a(null);
                graphSearchTitleBarLifeCycleController.f.a_("");
                graphSearchTitleBarLifeCycleController.f.setCustomTitle(graphSearchTitleBarLifeCycleController.d);
                graphSearchTitleBarLifeCycleController.f.c(true);
            }
        }
        this.f21892f.a(at()).a(f21887a, RefreshPolicy.MEMORY);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -980419497, a);
    }

    public final void m25404e(Bundle bundle) {
        super.e(bundle);
        if (this.at != null) {
            bundle.putString("facebook:graphsearch:current_fragment_tag", this.at.m25376a().J);
        }
    }

    public final void m25393G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -150176768);
        super.G();
        this.f21894h.mo1209f();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1187976222, a);
    }

    public final void m25394H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -239546828);
        super.H();
        GraphSearchTitleBarLifeCycleController graphSearchTitleBarLifeCycleController = this.f21888b;
        if (graphSearchTitleBarLifeCycleController.e != null) {
            graphSearchTitleBarLifeCycleController.e.c();
        }
        this.f21894h.mo1210g();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1184820593, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1796438306);
        super.mY_();
        BetterEditTextView betterEditTextView = this.f21889c.f25331a;
        if (betterEditTextView != null) {
            betterEditTextView.setTextInteractionListener(null);
            betterEditTextView.b(this.au);
        }
        GraphSearchTitleBarLifeCycleController graphSearchTitleBarLifeCycleController = this.f21888b;
        graphSearchTitleBarLifeCycleController.b.f25331a = null;
        graphSearchTitleBarLifeCycleController.a.f25334a = null;
        if (!(graphSearchTitleBarLifeCycleController.f == null || graphSearchTitleBarLifeCycleController.e == null)) {
            graphSearchTitleBarLifeCycleController.f.a(null);
            graphSearchTitleBarLifeCycleController.f.a(null);
            graphSearchTitleBarLifeCycleController.f.setCustomTitle(null);
            graphSearchTitleBarLifeCycleController.f.c(false);
            graphSearchTitleBarLifeCycleController.e = null;
            graphSearchTitleBarLifeCycleController.f = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 265098096, a);
    }

    public final void m25395I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1815338284);
        super.I();
        FriendshipEventSubscriber friendshipEventSubscriber = this.f21895i;
        friendshipEventSubscriber.f21867a.b(friendshipEventSubscriber.f21868b);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -798676866, a);
    }

    public final void m25398a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof GraphSearchChildFragment) {
            ((GraphSearchChildFragment) fragment).mo1190a(this.av);
        }
    }

    public final void m25397a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (intent != null && intent.hasExtra("try_show_survey_on_result_integration_point_id")) {
            String stringExtra = intent.getStringExtra("try_show_survey_on_result_integration_point_id");
            if (intent.getParcelableExtra("try_show_survey_on_result_extra_data") instanceof Bundle) {
                ((RapidFeedbackController) this.an.get()).a((Bundle) intent.getParcelableExtra("try_show_survey_on_result_extra_data"));
            }
            ((RapidFeedbackController) this.an.get()).a(stringExtra, ao());
        }
        GraphSearchNavigationController graphSearchNavigationController = this.as;
        if (i2 == -1) {
            Fragment a = graphSearchNavigationController.f21908f.m25376a();
            if (a != null && i == 1756) {
                a.a(i, i2, intent);
            }
        }
    }

    public final Map<String, Object> m25400c() {
        return this.at.m25379c();
    }

    public final String am_() {
        return this.at.am_();
    }

    public final boolean O_() {
        return this.as.m25429a(false);
    }

    private GraphSearchQuerySpec as() {
        Bundle bundle = this.s;
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("extra_sport_query_live_page_id");
        String string2 = bundle.getString("extra_sport_query_live_page_title");
        Builder builder;
        if (string == null || string2 == null) {
            string = bundle.getString("extra_query_function");
            string2 = bundle.getString("extra_query_display_style");
            String string3 = bundle.getString("extra_query_title");
            if (string == null || string2 == null || string3 == null) {
                string2 = bundle.getString("query_vertical");
                string3 = bundle.getString("source");
                String string4 = bundle.getString("query_title");
                String string5 = bundle.getString("query_function");
                ExactMatchInputExactMatch valueOf = ExactMatchInputExactMatch.valueOf(((String) Optional.fromNullable(bundle.getString("exact_match")).or("FALSE")).toUpperCase());
                String string6 = bundle.getString("graph_search_keyword_type");
                if (string2 == null || string3 == null || string4 == null || string5 == null) {
                    return null;
                }
                Builder builder2 = new Builder();
                builder2.f22087b = string4;
                builder2 = builder2;
                builder2.f22088c = string5;
                builder2 = builder2;
                builder2.f22090e = string2;
                builder2 = builder2;
                builder2.f22091f = valueOf;
                builder = builder2;
                builder.f22107v = ImmutableList.of(GraphQLGraphSearchResultsDisplayStyle.BLENDED);
                builder = builder;
                builder.f22095j = ReactionSearchData.m25723a(bundle);
                builder = builder;
                if (string6 != null) {
                    builder.f22092g = KeywordType.valueOf(string6);
                }
                return builder.m25651b();
            }
            GraphSearchQuerySpecImpl.Builder builder3 = new GraphSearchQuerySpecImpl.Builder();
            builder3.f22061a = string3;
            builder3 = builder3;
            builder3.f22062b = string;
            GraphSearchQuerySpecImpl.Builder builder4 = builder3;
            builder4.f22064d = "news_v2";
            builder4 = builder4;
            builder4.f22065e = ExactMatchInputExactMatch.FALSE;
            builder4 = builder4;
            builder4.f22066f = ImmutableList.of(GraphQLGraphSearchResultsDisplayStyle.fromString(string2));
            return builder4.m25632i();
        }
        builder2 = new Builder();
        builder2.f22088c = StringFormatUtil.a("keywords_topic_sport_match(%s)", new Object[]{string});
        builder = builder2;
        builder.f22087b = string2;
        builder = builder;
        builder.f22090e = "news_v2";
        builder = builder;
        builder.f22091f = ExactMatchInputExactMatch.FALSE;
        builder = builder;
        builder.f22107v = ImmutableList.of(GraphQLGraphSearchResultsDisplayStyle.BLENDED);
        return builder.m25651b();
    }

    private String au() {
        GraphSearchQuerySpec as = as();
        GraphSearchQuery at = at();
        String a = as != null ? as.mo1211a() : at != null ? at.b : null;
        return Strings.nullToEmpty(a);
    }

    private void av() {
        if (aw()) {
            SearchAwarenessController searchAwarenessController = (SearchAwarenessController) this.ao.get();
            Context context = getContext();
            ((SearchAwarenessTutorialNuxController) searchAwarenessController.k.get()).m25948a();
        }
    }

    @Nullable
    private SearchResultsSource ar() {
        Bundle bundle = this.s;
        if (bundle == null) {
            return null;
        }
        return SearchResultsSource.a(bundle.getString("source"));
    }

    @Nullable
    private GraphSearchQuery at() {
        Bundle bundle = this.s;
        if (bundle == null) {
            return null;
        }
        GraphSearchQuery graphSearchQuery = (GraphSearchQuery) bundle.getParcelable("initial_typeahead_query");
        if (graphSearchQuery != null && Strings.isNullOrEmpty(graphSearchQuery.b)) {
            Object obj = (this.al.m10648h(graphSearchQuery) || this.al.m10647g(graphSearchQuery)) ? 1 : null;
            if (obj != null) {
                graphSearchQuery = GraphSearchQuery.a(graphSearchQuery, graphSearchQuery.g);
            }
        }
        if (!bundle.containsKey("search_awareness_config")) {
            return graphSearchQuery;
        }
        if (graphSearchQuery == null) {
            graphSearchQuery = GraphSearchQuery.e;
        }
        graphSearchQuery.a(ModifierKeys.AWARENESS, bundle.getParcelable("search_awareness_config"));
        return graphSearchQuery;
    }

    private boolean aw() {
        return this.s.getBoolean("is_awareness_unit_eligible_intent_flag", false);
    }

    private void m25391a(GraphSearchTitleBarLifeCycleController graphSearchTitleBarLifeCycleController, GraphSearchTitleEditTextSupplier graphSearchTitleEditTextSupplier, GraphSearchNavigationControllerProvider graphSearchNavigationControllerProvider, GraphSearchChildFragmentNavigatorProvider graphSearchChildFragmentNavigatorProvider, NullStateSupplierFactory nullStateSupplierFactory, RecentSearchesMutatorSelector recentSearchesMutatorSelector, SearchPerfLogger searchPerfLogger, FriendshipEventSubscriber friendshipEventSubscriber, GraphSearchConfig graphSearchConfig, GatekeeperStore gatekeeperStore, com.facebook.inject.Lazy<RapidFeedbackController> lazy, com.facebook.inject.Lazy<SearchAwarenessController> lazy2, com.facebook.inject.Lazy<NullStatePartDefinitionInitializer> lazy3, SearchSuggestionsInitializer searchSuggestionsInitializer) {
        this.f21888b = graphSearchTitleBarLifeCycleController;
        this.f21889c = graphSearchTitleEditTextSupplier;
        this.f21890d = graphSearchNavigationControllerProvider;
        this.f21891e = graphSearchChildFragmentNavigatorProvider;
        this.f21892f = nullStateSupplierFactory;
        this.f21893g = recentSearchesMutatorSelector;
        this.f21894h = searchPerfLogger;
        this.f21895i = friendshipEventSubscriber;
        this.al = graphSearchConfig;
        this.am = gatekeeperStore;
        this.an = lazy;
        this.ao = lazy2;
        this.ap = lazy3;
        this.aq = searchSuggestionsInitializer;
    }
}
