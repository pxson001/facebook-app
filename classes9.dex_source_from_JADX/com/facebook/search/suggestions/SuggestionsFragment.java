package com.facebook.search.suggestions;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.annotations.DoNotOptimize;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.viewport.ViewportEventListener;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.graphql.enums.GraphQLSearchAwarenessTemplatesEnum;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.InterstitialStartHelper;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.megaphone.ui.QuickPromotionMegaphoneStoryView;
import com.facebook.placetips.bootstrap.PresenceDescription;
import com.facebook.placetips.logging.PlaceTipsAnalyticsEvent;
import com.facebook.placetips.logging.PlaceTipsAnalyticsLogger;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.reaction.placetips.PlaceTipsReactionManager;
import com.facebook.reaction.placetips.PlaceTipsReactionManager.Callback;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.abtest.gk.IsTypeaheadBackstackEnabled;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ModifierKeys;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.GraphSearchQuery.ScopedSearchStyle;
import com.facebook.search.api.GraphSearchQueryTabModifier;
import com.facebook.search.api.NullStateStatus;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.bootstrap.PendingBootstrapEntitiesManager;
import com.facebook.search.bootstrap.db.DbBootstrapPerformanceLogger;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.fragment.GraphSearchChildFragment;
import com.facebook.search.fragment.GraphSearchChildFragment.OnResultClickListener;
import com.facebook.search.logging.SuggestionsTypeaheadAnalyticHelper;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.search.logging.perf.NullStatePerformanceLogger;
import com.facebook.search.logging.perf.SearchWaterfallLogger;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit.Builder;
import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import com.facebook.search.model.KeywordTypeaheadUnit.Source;
import com.facebook.search.model.NearbyTypeaheadUnit;
import com.facebook.search.model.NullStateModuleSuggestionUnit;
import com.facebook.search.model.NullStateModuleSuggestionUnit.Type;
import com.facebook.search.model.NullStateSeeMoreTypeaheadUnit;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.model.PlaceTipsTypeaheadUnit;
import com.facebook.search.model.SearchBoxQueryState;
import com.facebook.search.model.SeeMoreResultPageUnit;
import com.facebook.search.model.SeeMoreTypeaheadUnit;
import com.facebook.search.model.ShortcutTypeaheadUnit;
import com.facebook.search.model.SuggestionTabType;
import com.facebook.search.model.TrendingTypeaheadUnit;
import com.facebook.search.model.TypeaheadCollectionUnit;
import com.facebook.search.model.TypeaheadSuggestionVisitor;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.protocol.awareness.SearchAwarenessInterfaces.SearchAwarenessSuggestionFieldsFragment;
import com.facebook.search.quickpromotion.AwarenessType;
import com.facebook.search.quickpromotion.SearchAwarenessController;
import com.facebook.search.quickpromotion.SearchAwarenessNullStateController;
import com.facebook.search.quickpromotion.SearchAwarenessOptOutController;
import com.facebook.search.quickpromotion.SearchAwarenessOptOutController.OnActionClickListener;
import com.facebook.search.quickpromotion.SearchNullStateMegaphoneController;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.search.suggestions.log.LogSelectedSuggestionToActivityLogHelper;
import com.facebook.search.suggestions.logging.DelegatingSuggestionsPerformanceLogger;
import com.facebook.search.suggestions.logging.SuggestionsLoggingViewportEventListener;
import com.facebook.search.suggestions.logging.SuggestionsPerformanceLogger;
import com.facebook.search.suggestions.nullstate.NullStateSupplier;
import com.facebook.search.suggestions.nullstate.NullStateSupplier.RefreshPolicy;
import com.facebook.search.suggestions.nullstate.NullStateViewController;
import com.facebook.search.suggestions.nullstate.RecentSearchesMutatorSelector;
import com.facebook.search.suggestions.nullstate.SearchSpotlightNullStateSupplier;
import com.facebook.search.suggestions.simplesearch.RemoteTypeaheadFetcher;
import com.facebook.search.suggestions.systems.SearchTypeaheadSystem;
import com.facebook.search.survey.SearchSurveyLauncher;
import com.facebook.search.titlebar.GraphSearchTitleSearchBox;
import com.facebook.search.titlebar.GraphSearchTitleSearchBox$OnInitStateLeftListener;
import com.facebook.search.titlebar.GraphSearchTitleSearchBox.OnClearClickedListener;
import com.facebook.search.typeahead.TypeaheadUnitCollection;
import com.facebook.search.util.GraphSearchConfig;
import com.facebook.search.util.SearchThemeHelper;
import com.facebook.search.util.bugreporter.SearchBugReportEvent;
import com.facebook.search.util.bugreporter.SearchBugReportExtraDataProvider;
import com.facebook.search.util.toast.ThrottledToaster;
import com.facebook.sequencelogger.Sequence;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.keyboard.SmoothKeyboardFragmentBehavior;
import com.facebook.ui.search.SearchEditText;
import com.facebook.ui.search.SearchEditText.OnSubmitListener;
import com.facebook.ui.search.SearchEditText.SoftKeyboardListener;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.typeahead.BaseTypeaheadController.OnNewSuggestionsListener;
import com.facebook.ui.typeahead.FetchState;
import com.facebook.ui.typeahead.SearchResponse;
import com.facebook.ui.typeahead.TypeaheadRequest;
import com.facebook.ui.typeahead.TypeaheadResponse;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.CustomViewPager;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.LazyView;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from:   */
public class SuggestionsFragment extends FbFragment implements AnalyticsFragment, GraphSearchChildFragment, OnClearClickedListener, GraphSearchTitleSearchBox$OnInitStateLeftListener, OnNewSuggestionsListener<TypeaheadUnit> {
    public static final CallerContext f98a = CallerContext.a(SuggestionsFragment.class, "search");
    public static final String f99b = SuggestionsFragment.class.getSimpleName();
    public static final GraphQLSearchAwarenessTemplatesEnum f100c = GraphQLSearchAwarenessTemplatesEnum.LEARNING_NUX_SECOND_STEP;
    @Inject
    public QeAccessor aA;
    @Inject
    public GraphSearchConfig aB;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PlaceTipsReactionManager> aC = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<PlaceTipsAnalyticsLogger> aD = UltralightRuntime.b;
    @Inject
    @IsTypeaheadBackstackEnabled
    private Provider<Boolean> aE;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<PendingBootstrapEntitiesManager> aF = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ComposerPublishServiceHelper> aG = UltralightRuntime.b;
    @Inject
    public RecentSearchesMutatorSelector aH;
    @Inject
    private SingleSearchSuggestionListControllerProvider aI;
    @Inject
    private SearchSuggestionsPagerAdapterProvider aJ;
    @Inject
    public SearchAwarenessController aK;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SearchAwarenessOptOutController> aL = UltralightRuntime.b;
    @Inject
    public SearchBugReportExtraDataProvider aM;
    @Inject
    public GatekeeperStoreImpl aN;
    @Inject
    private SearchSurveyLauncher aO;
    @Inject
    private FbTitleBarSupplier aP;
    @Inject
    public SearchThemeHelper aQ;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ViewportMonitor> aR = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SuggestionsLoggingViewportEventListener> aS = UltralightRuntime.b;
    @Inject
    public SearchSuggestionsInitializer aT;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SearchSpotlightNullStateSupplier> aU = UltralightRuntime.b;
    @Nullable
    public View aV;
    public FbSwipeRefreshLayout aW = null;
    public OnResultClickListener aX;
    public GraphSearchQuery aY = GraphSearchQuery.e;
    public ContextThemeWrapper aZ;
    @Inject
    public DbBootstrapPerformanceLogger al;
    @Inject
    private ThrottledToaster am;
    @Inject
    public com.facebook.inject.Lazy<SuggestionsTypeaheadAnalyticHelper> an;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<LogSelectedSuggestionToActivityLogHelper> ao = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbUriIntentHandler> ap = UltralightRuntime.b;
    @Inject
    @LoggedInUserId
    public String aq;
    @Inject
    private Context ar;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<InterstitialStartHelper> as = UltralightRuntime.b;
    @Inject
    public SearchWaterfallLogger at;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<AndroidThreadUtil> au = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<NavigationLogger> av = UltralightRuntime.b;
    @Inject
    public NullStatePerformanceLogger aw;
    @Inject
    private SearchNullStateMegaphoneController ax;
    @Inject
    public GraphSearchErrorReporter ay;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SecureContextHelper> az = UltralightRuntime.b;
    public SearchSuggestionListController ba;
    public SuggestionTabType bb = SuggestionTabType.GLOBAL;
    private FragmentManager bc;
    public boolean bd = true;
    private boolean be = false;
    public boolean bf = false;
    private boolean bg;
    public final DispatchTypeaheadSuggestionClickVisitor f101d = new DispatchTypeaheadSuggestionClickVisitor(this);
    private final PlaceTipsCallback f102e = new PlaceTipsCallback(this);
    public final GraphSearchTitleSearchBox$OnInitStateLeftListener f103f = this;
    @Inject
    public Clock f104g;
    @Inject
    public GraphSearchTitleSearchBoxSupplier f105h;
    @Inject
    public DelegatingSuggestionsPerformanceLogger f106i;

    /* compiled from:   */
    class C00091 implements OnFocusChangeListener {
        final /* synthetic */ SuggestionsFragment f79a;

        C00091(SuggestionsFragment suggestionsFragment) {
            this.f79a = suggestionsFragment;
        }

        public void onFocusChange(View view, boolean z) {
            if (this.f79a.ba.mo22j() != null) {
                this.f79a.ba.mo22j().a(z);
            }
        }
    }

    /* compiled from:   */
    class C00102 implements OnSubmitListener {
        final /* synthetic */ SuggestionsFragment f80a;

        C00102(SuggestionsFragment suggestionsFragment) {
            this.f80a = suggestionsFragment;
        }

        public final void m148a() {
            this.f80a.ba.mo22j().e();
            if (!StringUtil.c(SuggestionsFragment.aG(this.f80a)) && this.f80a.ba.mo23k() != null && !GraphSearchConfig.c(this.f80a.aY)) {
                this.f80a.f105h.a.k = null;
                this.f80a.ba.mo23k().mo43a(this.f80a.ba.mo21i()).a(this.f80a.f101d);
                this.f80a.f105h.a.k = this.f80a.f103f;
            }
        }
    }

    /* compiled from:   */
    class C00113 implements SoftKeyboardListener {
        final /* synthetic */ SuggestionsFragment f81a;

        C00113(SuggestionsFragment suggestionsFragment) {
            this.f81a = suggestionsFragment;
        }

        public final void m149a() {
            this.f81a.at.d();
        }
    }

    /* compiled from:   */
    public class C00135 {
        public final /* synthetic */ SuggestionsFragment f84a;

        public C00135(SuggestionsFragment suggestionsFragment) {
            this.f84a = suggestionsFragment;
        }
    }

    /* compiled from:   */
    public class C00167 implements OnRefreshListener {
        final /* synthetic */ SuggestionsFragment f88a;

        public C00167(SuggestionsFragment suggestionsFragment) {
            this.f88a = suggestionsFragment;
        }

        public final void m152a() {
            if (SuggestionsFragment.aw(this.f88a) == SearchBoxQueryState.NULL_STATE) {
                this.f88a.ba.mo6a(SuggestionsFragment.f98a, RefreshPolicy.NETWORK_ONLY);
            }
        }
    }

    /* compiled from:   */
    /* synthetic */ class C00189 {
        static final /* synthetic */ int[] f91a = new int[FetchState.values().length];

        static {
            try {
                f91a[FetchState.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f91a[FetchState.IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f91a[FetchState.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @TargetApi(21)
    @DoNotOptimize
    /* compiled from:   */
    class Api21AndUpUtil {
        private Api21AndUpUtil() {
        }

        static void m153a(Activity activity, GraphSearchQuery graphSearchQuery) {
            activity.getWindow().setStatusBarColor(ContextUtils.c(SuggestionsFragment.m177b((Context) activity, graphSearchQuery), 16843857, 0));
        }
    }

    /* compiled from:   */
    public class DispatchTypeaheadSuggestionClickVisitor extends TypeaheadSuggestionVisitor {
        final /* synthetic */ SuggestionsFragment f94a;

        public DispatchTypeaheadSuggestionClickVisitor(SuggestionsFragment suggestionsFragment) {
            this.f94a = suggestionsFragment;
        }

        public final void m154a(EntityTypeaheadUnit entityTypeaheadUnit) {
            long a = this.f94a.f104g.a();
            if (this.f94a.aX != null) {
                this.f94a.aX.a(this.f94a.ba.mo21i(), entityTypeaheadUnit);
            }
            SuggestionsFragment.m175a(this.f94a, "entity", (TypeaheadUnit) entityTypeaheadUnit, a);
            SuggestionsFragment.m172a(this.f94a, (TypeaheadUnit) entityTypeaheadUnit);
            this.f94a.aH.m332a(this.f94a.ba.mo21i()).a(entityTypeaheadUnit);
            try {
                if (!entityTypeaheadUnit.u()) {
                    ((PendingBootstrapEntitiesManager) this.f94a.aF.get()).a(entityTypeaheadUnit.A());
                }
            } catch (GraphSearchException e) {
                this.f94a.ay.a(e);
            }
        }

        public final void m161a(SeeMoreResultPageUnit seeMoreResultPageUnit) {
            long a = this.f94a.f104g.a();
            if (this.f94a.aX != null) {
                this.f94a.aX.a(seeMoreResultPageUnit);
            }
            SuggestionsFragment.m175a(this.f94a, "entity", (TypeaheadUnit) seeMoreResultPageUnit, a);
            SuggestionsFragment.m172a(this.f94a, (TypeaheadUnit) seeMoreResultPageUnit);
            this.f94a.aH.m332a(this.f94a.ba.mo21i()).a(seeMoreResultPageUnit);
        }

        public final void m164a(TrendingTypeaheadUnit trendingTypeaheadUnit) {
            long a = this.f94a.f104g.a();
            if (this.f94a.aX != null) {
                this.f94a.aX.a(trendingTypeaheadUnit);
            }
            SuggestionsFragment.m175a(this.f94a, "trending", (TypeaheadUnit) trendingTypeaheadUnit, a);
            CharSequence charSequence = trendingTypeaheadUnit.i;
            if (Strings.isNullOrEmpty(charSequence)) {
                charSequence = trendingTypeaheadUnit.a();
            }
            this.f94a.f105h.a.e.setText(charSequence);
            SuggestionsFragment.m172a(this.f94a, (TypeaheadUnit) trendingTypeaheadUnit);
        }

        public final void m155a(KeywordTypeaheadUnit keywordTypeaheadUnit) {
            long a = this.f94a.f104g.a();
            if (this.f94a.aX != null) {
                this.f94a.aX.a(keywordTypeaheadUnit);
            }
            if (keywordTypeaheadUnit.g == KeywordType.escape_pps_style) {
                SuggestionsTypeaheadAnalyticHelper suggestionsTypeaheadAnalyticHelper = (SuggestionsTypeaheadAnalyticHelper) this.f94a.an.get();
                String c = keywordTypeaheadUnit.c();
                ImmutableList aC = SuggestionsFragment.aC(this.f94a);
                String toLowerCase = keywordTypeaheadUnit.k.toString().toLowerCase(Locale.US);
                boolean aM = SuggestionsFragment.aM(this.f94a);
                FetchState e = this.f94a.ba.mo17e();
                SearchBoxQueryState aw = SuggestionsFragment.aw(this.f94a);
                SuggestionTabType suggestionTabType = this.f94a.bb;
                ScopedEntityType scopedEntityType = this.f94a.aY.h;
                suggestionsTypeaheadAnalyticHelper.a(c, aC, toLowerCase, aM, e, aw);
                return;
            }
            SuggestionsFragment.m175a(this.f94a, "keyword", (TypeaheadUnit) keywordTypeaheadUnit, a);
            SearchEditText searchEditText = this.f94a.f105h.a.e;
            if (keywordTypeaheadUnit.i() == null || keywordTypeaheadUnit.jI_() == ScopedEntityType.USER) {
                searchEditText.setText(keywordTypeaheadUnit.a());
            } else {
                searchEditText.a(keywordTypeaheadUnit.a(), keywordTypeaheadUnit.i());
            }
            if (!this.f94a.aN.a(SearchAbTestGatekeepers.u, false) && (keywordTypeaheadUnit.h() == null || keywordTypeaheadUnit.jI_() == ScopedEntityType.VIDEO)) {
                this.f94a.aH.m332a(this.f94a.ba.mo21i()).a(keywordTypeaheadUnit);
            }
            SuggestionsFragment.m172a(this.f94a, (TypeaheadUnit) keywordTypeaheadUnit);
            this.f94a.at.f();
        }

        public final void m159a(final NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit) {
            long a = this.f94a.f104g.a();
            if (this.f94a.aX != null) {
                this.f94a.aX.a(this.f94a.ba.mo21i(), nullStateSuggestionTypeaheadUnit);
            }
            SuggestionsFragment.m175a(this.f94a, "recent_search", (TypeaheadUnit) nullStateSuggestionTypeaheadUnit, a);
            SuggestionsFragment.m172a(this.f94a, (TypeaheadUnit) nullStateSuggestionTypeaheadUnit);
            if (nullStateSuggestionTypeaheadUnit.z()) {
                this.f94a.f105h.a.e.setText(nullStateSuggestionTypeaheadUnit.b);
            }
            if (nullStateSuggestionTypeaheadUnit.d) {
                ((DefaultAndroidThreadUtil) this.f94a.au.get()).a(new Runnable(this) {
                    final /* synthetic */ DispatchTypeaheadSuggestionClickVisitor f93b;

                    public void run() {
                        this.f93b.f94a.aH.m332a(this.f93b.f94a.ba.mo21i()).a(nullStateSuggestionTypeaheadUnit);
                    }
                }, 500);
            }
        }

        public final void m163a(ShortcutTypeaheadUnit shortcutTypeaheadUnit) {
            long a = this.f94a.f104g.a();
            if (this.f94a.aX != null) {
                this.f94a.aX.a(shortcutTypeaheadUnit);
            }
            SuggestionsFragment.m175a(this.f94a, "shortcut", (TypeaheadUnit) shortcutTypeaheadUnit, a);
            SuggestionsFragment.m172a(this.f94a, (TypeaheadUnit) shortcutTypeaheadUnit);
            this.f94a.aH.m332a(this.f94a.ba.mo21i()).a(shortcutTypeaheadUnit);
        }

        public final void m158a(NullStateSeeMoreTypeaheadUnit nullStateSeeMoreTypeaheadUnit) {
            ((SuggestionsTypeaheadAnalyticHelper) this.f94a.an.get()).a(nullStateSeeMoreTypeaheadUnit, SuggestionsFragment.aw(this.f94a), this.f94a.bb, this.f94a.aY.h, SuggestionsFragment.ay(this.f94a));
            NullStateSupplier h = this.f94a.ba.mo20h();
            if (h != null) {
                h.a(nullStateSeeMoreTypeaheadUnit.k());
                if (this.f94a.ba.mo24l() != null) {
                    this.f94a.ba.mo24l().m529a((List) h.get());
                }
                if (this.f94a.ba.mo16d() != null) {
                    this.f94a.ba.mo16d().notifyDataSetChanged();
                }
                SuggestionsFragment.m172a(this.f94a, (TypeaheadUnit) nullStateSeeMoreTypeaheadUnit);
            }
        }

        public final void m162a(SeeMoreTypeaheadUnit seeMoreTypeaheadUnit) {
            String aG = SuggestionsFragment.aG(this.f94a);
            if (!(this.f94a.aX == null || aG == null)) {
                SuggestionsFragment.aN(this.f94a);
                this.f94a.aX.a();
                SuggestionsTypeaheadAnalyticHelper suggestionsTypeaheadAnalyticHelper = (SuggestionsTypeaheadAnalyticHelper) this.f94a.an.get();
                ImmutableList aC = SuggestionsFragment.aC(this.f94a);
                String str = seeMoreTypeaheadUnit.a;
                boolean aM = SuggestionsFragment.aM(this.f94a);
                FetchState e = this.f94a.ba.mo17e();
                SearchBoxQueryState aw = SuggestionsFragment.aw(this.f94a);
                SuggestionTabType suggestionTabType = this.f94a.bb;
                ScopedEntityType scopedEntityType = this.f94a.aY.h;
                suggestionsTypeaheadAnalyticHelper.a(aG, aC, str, aM, e, aw);
            }
            SuggestionsFragment.m172a(this.f94a, (TypeaheadUnit) seeMoreTypeaheadUnit);
        }

        public final void m160a(PlaceTipsTypeaheadUnit placeTipsTypeaheadUnit) {
            long a = this.f94a.f104g.a();
            if (this.f94a.aX != null) {
                this.f94a.aX.a(placeTipsTypeaheadUnit);
            }
            PresenceDescription presenceDescription = placeTipsTypeaheadUnit.a;
            Preconditions.checkNotNull(presenceDescription);
            ((PlaceTipsAnalyticsLogger) this.f94a.aD.get()).a(PlaceTipsAnalyticsEvent.SEARCH_NULL_STATE_CLICK, presenceDescription.l(), presenceDescription.i(), presenceDescription.d());
            SuggestionsFragment.m175a(this.f94a, "place_tip", (TypeaheadUnit) placeTipsTypeaheadUnit, a);
            SuggestionsFragment.m172a(this.f94a, (TypeaheadUnit) placeTipsTypeaheadUnit);
        }

        public final void m156a(NearbyTypeaheadUnit nearbyTypeaheadUnit) {
            long a = this.f94a.f104g.a();
            if (this.f94a.aX != null) {
                this.f94a.aX.a(nearbyTypeaheadUnit);
            }
            SuggestionsFragment.m175a(this.f94a, "nearby", (TypeaheadUnit) nearbyTypeaheadUnit, a);
            SuggestionsFragment.m172a(this.f94a, (TypeaheadUnit) nearbyTypeaheadUnit);
        }

        public final void m157a(NullStateModuleSuggestionUnit nullStateModuleSuggestionUnit) {
            String str;
            long a = this.f94a.f104g.a();
            if (nullStateModuleSuggestionUnit.a.equals(Type.ns_trending) || nullStateModuleSuggestionUnit.a.equals(Type.ns_interest)) {
                str = "news_v2";
            } else {
                str = "content";
            }
            String n = str.equals("news_v2") ? nullStateModuleSuggestionUnit.n() : null;
            Builder builder = new Builder();
            builder.b = nullStateModuleSuggestionUnit.i;
            builder = builder;
            builder.d = nullStateModuleSuggestionUnit.i;
            builder = builder;
            builder.c = nullStateModuleSuggestionUnit.h;
            builder = builder;
            builder.e = str;
            Builder builder2 = builder;
            builder2.f = ExactMatchInputExactMatch.FALSE;
            builder2 = builder2;
            builder2.g = KeywordType.keyword;
            builder2 = builder2;
            builder2.k = Source.NULL_STATE_MODULE;
            builder2 = builder2;
            builder2.i = n;
            builder2 = builder2;
            builder2.x = nullStateModuleSuggestionUnit.j;
            KeywordTypeaheadUnit b = builder2.b();
            if (this.f94a.aX != null) {
                this.f94a.aX.a(b);
            }
            SuggestionsFragment suggestionsFragment = this.f94a;
            if (nullStateModuleSuggestionUnit.a.equals(Type.ns_trending)) {
                str = "trending";
            } else {
                str = "keyword";
            }
            SuggestionsFragment.m175a(suggestionsFragment, str, (TypeaheadUnit) nullStateModuleSuggestionUnit, a);
            SearchEditText searchEditText = this.f94a.f105h.a.e;
            if (!(this.f94a.f105h.a == null || this.f94a.f105h.a.e == null)) {
                CharSequence charSequence;
                if (Strings.isNullOrEmpty(nullStateModuleSuggestionUnit.g)) {
                    Object obj = nullStateModuleSuggestionUnit.i;
                } else {
                    charSequence = nullStateModuleSuggestionUnit.g;
                }
                searchEditText.setText(charSequence);
            }
            SuggestionsFragment.m172a(this.f94a, (TypeaheadUnit) nullStateModuleSuggestionUnit);
        }
    }

    /* compiled from:   */
    public class ExternalStateChangeListener {
        public final /* synthetic */ SuggestionsFragment f95a;

        public ExternalStateChangeListener(SuggestionsFragment suggestionsFragment) {
            this.f95a = suggestionsFragment;
        }

        public final void m165a(ProgressBar progressBar, ScrollingViewProxy scrollingViewProxy, NullStateSupplier nullStateSupplier, NullStateViewController nullStateViewController, TypeaheadUnitCollection typeaheadUnitCollection, MultiRowAdapter multiRowAdapter, SingleSearchSuggestionListController singleSearchSuggestionListController) {
            if (StringUtil.c(SuggestionsFragment.aG(this.f95a))) {
                try {
                    TracerDetour.a("SuggestionsFragment.onLoadNullState", -1981067581);
                    this.f95a.aA.a(Liveness.Cached, ExperimentsForSearchAbTestModule.aS);
                    nullStateViewController.m329a(NullStateStatus.READY, SuggestionsFragment.aO(this.f95a));
                    ImmutableList immutableList = (ImmutableList) nullStateSupplier.get();
                    NullStateStatus c = nullStateSupplier.c();
                    if (c.equals(NullStateStatus.READY) || !this.f95a.aA.a(ExperimentsForSearchAbTestModule.aU, true)) {
                        singleSearchSuggestionListController.m98b(FetchState.IDLE);
                    } else {
                        singleSearchSuggestionListController.m98b(FetchState.ACTIVE);
                    }
                    if (scrollingViewProxy == null || this.f95a.aV == null || !SuggestionsFragment.aO(this.f95a)) {
                        this.f95a.aw.a(c);
                    } else {
                        scrollingViewProxy.a(8);
                        this.f95a.aV.setVisibility(0);
                        this.f95a.aw.h();
                    }
                    SuggestionsFragment.m171a(this.f95a, progressBar, scrollingViewProxy, singleSearchSuggestionListController.m97b());
                    SuggestionsFragment.m173a(this.f95a, typeaheadUnitCollection, multiRowAdapter, immutableList);
                } finally {
                    TracerDetour.a(298089049);
                }
            }
        }
    }

    /* compiled from:   */
    public class ListInteractionListener {
        public final /* synthetic */ SuggestionsFragment f96a;

        public ListInteractionListener(SuggestionsFragment suggestionsFragment) {
            this.f96a = suggestionsFragment;
        }

        public final void m167b() {
            SuggestionsFragment.aN(this.f96a);
        }

        public final boolean m166a(TypeaheadUnitCollection typeaheadUnitCollection, MultiRowAdapter multiRowAdapter, NullStateSupplier nullStateSupplier) {
            DelegatingSuggestionsPerformanceLogger delegatingSuggestionsPerformanceLogger = this.f96a.f106i;
            List list = typeaheadUnitCollection.f422a;
            delegatingSuggestionsPerformanceLogger.f147c.mo35a(list);
            delegatingSuggestionsPerformanceLogger.f148d.mo35a(list);
            delegatingSuggestionsPerformanceLogger.f146b.mo35a(list);
            delegatingSuggestionsPerformanceLogger.f145a.mo35a(list);
            delegatingSuggestionsPerformanceLogger.f149e.mo35a(list);
            this.f96a.aw.a(SuggestionsFragment.aw(this.f96a));
            this.f96a.aT.m33a();
            if (SuggestionsFragment.aw(this.f96a) == SearchBoxQueryState.NULL_STATE && typeaheadUnitCollection.m527a() != 0) {
                ImmutableList immutableList = (ImmutableList) nullStateSupplier.get();
                if (immutableList.size() > typeaheadUnitCollection.m527a()) {
                    SuggestionsFragment suggestionsFragment = this.f96a;
                    List subList = immutableList.subList(0, Math.min(typeaheadUnitCollection.m527a() + 6, immutableList.size()));
                    typeaheadUnitCollection.m529a(subList);
                    Integer.valueOf(subList.size());
                    multiRowAdapter.notifyDataSetChanged();
                }
            }
            return false;
        }
    }

    /* compiled from:   */
    class PlaceTipsCallback implements Callback {
        final /* synthetic */ SuggestionsFragment f97a;

        public PlaceTipsCallback(SuggestionsFragment suggestionsFragment) {
            this.f97a = suggestionsFragment;
        }

        public final void m168a() {
            if (StringUtil.c(SuggestionsFragment.aG(this.f97a))) {
                this.f97a.ba.mo28p();
            }
        }
    }

    public static void m176a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((SuggestionsFragment) obj).m170a((Clock) SystemClockMethodAutoProvider.a(injectorLike), GraphSearchTitleSearchBoxSupplier.a(injectorLike), DelegatingSuggestionsPerformanceLogger.m258a(injectorLike), DbBootstrapPerformanceLogger.a(injectorLike), ThrottledToaster.a(injectorLike), IdBasedLazy.a(injectorLike, 10494), IdBasedLazy.a(injectorLike, 10847), IdBasedSingletonScopeProvider.b(injectorLike, 616), String_LoggedInUserIdMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), IdBasedLazy.a(injectorLike, 2352), SearchWaterfallLogger.a(injectorLike), IdBasedLazy.a(injectorLike, 517), IdBasedSingletonScopeProvider.b(injectorLike, 137), NullStatePerformanceLogger.a(injectorLike), SearchNullStateMegaphoneController.a(injectorLike), GraphSearchErrorReporter.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 968), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GraphSearchConfig.a(injectorLike), IdBasedLazy.a(injectorLike, 3263), IdBasedSingletonScopeProvider.b(injectorLike, 3007), IdBasedProvider.a(injectorLike, 4322), IdBasedSingletonScopeProvider.b(injectorLike, 10456), IdBasedLazy.a(injectorLike, 5272), RecentSearchesMutatorSelector.m330a(injectorLike), (SingleSearchSuggestionListControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SingleSearchSuggestionListControllerProvider.class), (SearchSuggestionsPagerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchSuggestionsPagerAdapterProvider.class), SearchAwarenessController.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 10520), SearchBugReportExtraDataProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), SearchSurveyLauncher.m507a(injectorLike), (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(injectorLike), SearchThemeHelper.a(injectorLike), IdBasedLazy.a(injectorLike, 820), IdBasedLazy.a(injectorLike, 10849), SearchSuggestionsInitializer.m29a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3401));
    }

    public final void m192a(TypeaheadResponse<TypeaheadUnit> typeaheadResponse) {
        String str = typeaheadResponse.a.c;
        SearchResponse searchResponse = typeaheadResponse.b;
        ImmutableList a = this.ba.mo2a((TypeaheadResponse) typeaheadResponse);
        if (BLog.b(3)) {
            aG(this);
            searchResponse.b.toString();
            a.toString();
        }
        if (!StringUtil.a(aG(this))) {
            aB();
        }
        this.ba.mo13a(str, a);
        this.ba.mo12a(str, NullStateStatus.READY, false);
        DelegatingSuggestionsPerformanceLogger delegatingSuggestionsPerformanceLogger = this.f106i;
        List list = this.ba.mo1a(str).f422a;
        SuggestionsPerformanceLogger suggestionsPerformanceLogger = delegatingSuggestionsPerformanceLogger.f149e;
        suggestionsPerformanceLogger.f163f.a();
        Sequence e = suggestionsPerformanceLogger.f152a.e(suggestionsPerformanceLogger.mo31a());
        if (e != null) {
            String valueOf = String.valueOf(suggestionsPerformanceLogger.f155d);
            if (e.c("end_to_end_prerendering", valueOf)) {
                if (list.isEmpty()) {
                    SequenceLoggerDetour.a(e, "end_to_end_prerendering", valueOf, -2011804666);
                } else {
                    SequenceLoggerDetour.b(e, "end_to_end_prerendering", valueOf, null, -1465277606);
                }
                suggestionsPerformanceLogger.f155d++;
            }
        }
        if (!StringUtil.a(aG(this))) {
            aD();
        }
    }

    public final void m197c(Bundle bundle) {
        SearchSuggestionListController searchSuggestionsPagerAdapter;
        super.c(bundle);
        a(new SmoothKeyboardFragmentBehavior());
        Class cls = SuggestionsFragment.class;
        m176a((Object) this, getContext());
        this.bc = this.D;
        Bundle bundle2 = this.s;
        if (!(bundle2 == null || bundle2.getParcelable("initial_typeahead_query") == null)) {
            this.aY = (GraphSearchQuery) bundle2.getParcelable("initial_typeahead_query");
        }
        this.aZ = m177b(getContext(), this.aY);
        if (bundle == null || !bundle.containsKey("recycler_view_enabled")) {
            this.bg = this.aN.a(SearchAbTestGatekeepers.A, false);
        } else {
            this.bg = bundle.getBoolean("recycler_view_enabled");
        }
        if (this.aB.e(this.aY)) {
            SearchSuggestionsPagerAdapterProvider searchSuggestionsPagerAdapterProvider = this.aJ;
            Context context = this.aZ;
            GraphSearchQuery graphSearchQuery = this.aY;
            Boolean valueOf = Boolean.valueOf(this.bg);
            searchSuggestionsPagerAdapter = new SearchSuggestionsPagerAdapter(context, graphSearchQuery, valueOf, this.bc, (SingleSearchSuggestionListControllerProvider) searchSuggestionsPagerAdapterProvider.getOnDemandAssistedProviderForStaticDi(SingleSearchSuggestionListControllerProvider.class), (SingleSearchSuggestionsReactControllerProvider) searchSuggestionsPagerAdapterProvider.getOnDemandAssistedProviderForStaticDi(SingleSearchSuggestionsReactControllerProvider.class));
        } else {
            searchSuggestionsPagerAdapter = this.aI.m114a(this.aZ, this.aY);
        }
        this.ba = searchSuggestionsPagerAdapter;
        this.ba.mo10a((OnNewSuggestionsListener) this);
        this.ba.mo4a(this.aZ, this.f101d);
        ((ViewportMonitor) this.aR.get()).a((ViewportEventListener) this.aS.get());
        this.am.c = 15000;
    }

    public final View m188a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        LazyView lazyView = null;
        int i2 = 0;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 687454362);
        if (this.aB.e(this.aY)) {
            i = 2130904455;
        } else if (this.bg) {
            i = 2130904453;
        } else {
            i = 2130904454;
        }
        this.aQ.a(this.aZ);
        View inflate = LayoutInflater.from(this.aZ).inflate(i, viewGroup, false);
        m184e(inflate);
        aL();
        SearchEditText searchEditText = this.f105h.a.e;
        searchEditText.setOnFocusChangeListener(new C00091(this));
        searchEditText.f = new C00102(this);
        searchEditText.g = new C00113(this);
        SearchSuggestionListController searchSuggestionListController = this.ba;
        View b = this.aB.e(this.aY) ? null : this.bg ? FindViewUtil.b(inflate, 2131567298) : FindViewUtil.b(inflate, 2131567300);
        searchSuggestionListController.mo5a(b, new ListInteractionListener(this), this.bg);
        if (aO(this)) {
            m180c(inflate);
            this.aK.b(f100c);
            this.bf = true;
        }
        if (!this.aB.e(this.aY)) {
            this.aW = (FbSwipeRefreshLayout) FindViewUtil.b(inflate, 2131561342);
            if (this.aN.a(SearchAbTestGatekeepers.d, false)) {
                this.aW.e = new C00167(this);
            } else {
                this.aW.setEnabled(false);
            }
        }
        if (this.ax.a()) {
            final QuickPromotionMegaphoneStoryView quickPromotionMegaphoneStoryView = new QuickPromotionMegaphoneStoryView(getContext());
            this.ax.a(quickPromotionMegaphoneStoryView);
            quickPromotionMegaphoneStoryView.g = new Runnable(this) {
                final /* synthetic */ SuggestionsFragment f83b;

                public void run() {
                    if (this.f83b.ba.mo19g() != null) {
                        this.f83b.ba.mo19g().a(quickPromotionMegaphoneStoryView);
                    }
                }
            };
            if (!(quickPromotionMegaphoneStoryView.getVisibility() != 0 || this.aB.e(this.aY) || this.ba.mo19g() == null)) {
                this.ba.mo19g().d(quickPromotionMegaphoneStoryView);
            }
        }
        ImmutableList c = this.ba.mo15c();
        int size = c.size();
        while (i2 < size) {
            ((View) c.get(i2)).setOnCreateContextMenuListener(this);
            i2++;
        }
        GraphSearchTitleSearchBox graphSearchTitleSearchBox = this.f105h.a;
        if (graphSearchTitleSearchBox != null) {
            graphSearchTitleSearchBox.a(this);
            graphSearchTitleSearchBox.k = this.f103f;
        }
        SearchSuggestionListController searchSuggestionListController2 = this.ba;
        if (!this.aB.e(this.aY)) {
            lazyView = new LazyView((ViewStub) FindViewUtil.b(inflate, 2131567299));
        }
        searchSuggestionListController2.mo11a(lazyView, this.aV, aO(this));
        SearchSuggestionsInitializer searchSuggestionsInitializer = this.aT;
        if (!searchSuggestionsInitializer.f8g) {
            ((RemoteTypeaheadFetcher) searchSuggestionsInitializer.f6e.get()).m400g();
        }
        LogUtils.f(-1945221111, a);
        return inflate;
    }

    public static SearchBoxQueryState aw(SuggestionsFragment suggestionsFragment) {
        if (StringUtil.c(aG(suggestionsFragment))) {
            NullStateSupplier h = suggestionsFragment.ba.mo20h();
            return h == null ? SearchBoxQueryState.NULL_STATE : h.f();
        } else {
            SearchTypeaheadSystem k = suggestionsFragment.ba.mo23k();
            return k == null ? SearchBoxQueryState.TYPED : k.mo42b();
        }
    }

    @Nullable
    public static SuggestionTabType ax(SuggestionsFragment suggestionsFragment) {
        return suggestionsFragment.bb;
    }

    public static ScopedSearchStyle ay(SuggestionsFragment suggestionsFragment) {
        if (suggestionsFragment.aB.e(suggestionsFragment.aY)) {
            return ScopedSearchStyle.TAB;
        }
        return null;
    }

    public static void az(SuggestionsFragment suggestionsFragment) {
        if (suggestionsFragment.aE()) {
            ScrollingViewProxy g = suggestionsFragment.ba.mo19g();
            if (g != null) {
                suggestionsFragment.aB();
                g.b((OnScrollListener) suggestionsFragment.aR.get());
                ((ViewportMonitor) suggestionsFragment.aR.get()).a(true, g);
            }
        }
    }

    public static void aA(SuggestionsFragment suggestionsFragment) {
        if (suggestionsFragment.aE()) {
            ScrollingViewProxy g = suggestionsFragment.ba.mo19g();
            if (g != null) {
                g.c((OnScrollListener) suggestionsFragment.aR.get());
                ((ViewportMonitor) suggestionsFragment.aR.get()).a(false, g);
            }
        }
    }

    private void aB() {
        if (aE()) {
            ((ViewportMonitor) this.aR.get()).g.clear();
            SuggestionsLoggingViewportEventListener suggestionsLoggingViewportEventListener = (SuggestionsLoggingViewportEventListener) this.aS.get();
            suggestionsLoggingViewportEventListener.f150a.clear();
            suggestionsLoggingViewportEventListener.f151b.clear();
        }
    }

    public static ImmutableList aC(SuggestionsFragment suggestionsFragment) {
        if (!suggestionsFragment.aE()) {
            return m178b(suggestionsFragment.aJ());
        }
        ImmutableList copyOf = ImmutableList.copyOf(((SuggestionsLoggingViewportEventListener) suggestionsFragment.aS.get()).f150a);
        suggestionsFragment.aB();
        return copyOf;
    }

    private void aD() {
        if (aE()) {
            ScrollingViewProxy g = this.ba.mo19g();
            if (g != null && (g instanceof RecyclerViewProxy)) {
                MultiRowAdapter d = this.ba.mo16d();
                if (d != null) {
                    LayoutManager layoutManager = ((RecyclerViewProxy) g).c.getLayoutManager();
                    if (layoutManager != null && (layoutManager instanceof BetterLinearLayoutManager)) {
                        BetterLinearLayoutManager betterLinearLayoutManager = (BetterLinearLayoutManager) layoutManager;
                        int l = betterLinearLayoutManager.l();
                        ((ViewportMonitor) this.aR.get()).a(g, l, (betterLinearLayoutManager.n() - l) + 1, d.getCount());
                    }
                }
            }
        }
    }

    private boolean aE() {
        return this.aN.a(SearchAbTestGatekeepers.k, false);
    }

    public static ImmutableList<TypeaheadUnit> m178b(List<TypeaheadUnit> list) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (TypeaheadUnit typeaheadUnit : list) {
            if (typeaheadUnit instanceof TypeaheadCollectionUnit) {
                builder.b(((TypeaheadCollectionUnit) typeaheadUnit).f());
            } else {
                builder.c(typeaheadUnit);
            }
        }
        return builder.b();
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1504720959);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.c(true);
        }
        if (StringUtil.c(aG(this))) {
            this.aw.g();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 171952898, a);
    }

    public final void m185G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 120968847);
        super.G();
        az(this);
        this.ba.mo9a(new ExternalStateChangeListener(this));
        if (StringUtil.c(aG(this))) {
            this.ba.mo28p();
        }
        ((PlaceTipsReactionManager) this.aC.get()).a(this.f102e);
        this.ba.mo6a(f98a, RefreshPolicy.MEMORY);
        this.aM.a(f99b, SearchBugReportEvent.FRAGMENT_RESUMED, "Typeahead launched with text: \"" + aG(this) + "\"");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 520875542, a);
    }

    public final void m186H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2070485965);
        if (this.f102e != null) {
            ((PlaceTipsReactionManager) this.aC.get()).b(this.f102e);
        }
        this.ba.mo9a(null);
        this.al.e();
        this.aw.h();
        this.aM.a(f99b, SearchBugReportEvent.FRAGMENT_PAUSED);
        aA(this);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1007016556, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 208252166);
        super.mj_();
        if (this.ba.mo22j() != null) {
            this.ba.mo22j().b(ImmutableBiMap.b("typeahead_sid", as().b));
        }
        this.aw.h();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1196155915, a);
    }

    public final void m189a(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 1756) {
            ((ComposerPublishServiceHelper) this.aG.get()).c(intent);
        }
    }

    public static void m179b(SuggestionsFragment suggestionsFragment, String str) {
        if (suggestionsFragment.be && !str.equals(suggestionsFragment.aY.b)) {
            suggestionsFragment.f105h.a.e.setSelectAllOnFocus(false);
            suggestionsFragment.ba.mo25m();
        }
        TypeaheadRequest a = GraphSearchQuery.a(suggestionsFragment.ba.mo21i(), str);
        DelegatingSuggestionsPerformanceLogger delegatingSuggestionsPerformanceLogger = suggestionsFragment.f106i;
        delegatingSuggestionsPerformanceLogger.f147c.mo32a(a);
        delegatingSuggestionsPerformanceLogger.f148d.mo32a(a);
        delegatingSuggestionsPerformanceLogger.f146b.mo32a(a);
        delegatingSuggestionsPerformanceLogger.f145a.mo32a(a);
        delegatingSuggestionsPerformanceLogger.f149e.mo32a(a);
        if (!(suggestionsFragment.ba.mo22j() == null || suggestionsFragment.ba.mo22j().b(a))) {
            delegatingSuggestionsPerformanceLogger = suggestionsFragment.f106i;
            delegatingSuggestionsPerformanceLogger.f147c.m274b(a);
            delegatingSuggestionsPerformanceLogger.f148d.m274b(a);
            delegatingSuggestionsPerformanceLogger.f146b.m274b(a);
            delegatingSuggestionsPerformanceLogger.f145a.m274b(a);
            m182c(suggestionsFragment, str);
        }
        SearchTypeaheadSystem k = suggestionsFragment.ba.mo23k();
        if (StringUtil.c(str) && k != null) {
            k.mo40a();
            if (suggestionsFragment.aW != null) {
                suggestionsFragment.aW.setEnabled(suggestionsFragment.aN.a(SearchAbTestGatekeepers.d, false));
            }
        } else if (suggestionsFragment.aW != null) {
            suggestionsFragment.aW.setEnabled(false);
        }
        SuggestionsTypeaheadAnalyticHelper suggestionsTypeaheadAnalyticHelper = (SuggestionsTypeaheadAnalyticHelper) suggestionsFragment.an.get();
        int length = str.length();
        suggestionsTypeaheadAnalyticHelper.l = new SearchTypeaheadSession(suggestionsTypeaheadAnalyticHelper.l.b, SafeUUIDGenerator.a().toString());
        suggestionsTypeaheadAnalyticHelper.n += Math.abs(suggestionsTypeaheadAnalyticHelper.o - length);
        suggestionsTypeaheadAnalyticHelper.o = length;
    }

    public static void m182c(SuggestionsFragment suggestionsFragment, String str) {
        SearchTypeaheadSystem k = suggestionsFragment.ba.mo23k();
        TypeaheadUnitCollection l = suggestionsFragment.ba.mo24l();
        if (!str.isEmpty() && k != null && k.mo41a(suggestionsFragment.ba.mo21i(), l)) {
            if (BLog.b(3)) {
                Class cls = k.getClass();
                String str2 = "Typeahead Cleaned Up";
                for (TypeaheadUnit obj : l.f422a) {
                    obj.toString();
                }
            }
            suggestionsFragment.ba.mo16d().notifyDataSetChanged();
        }
    }

    public static String aG(SuggestionsFragment suggestionsFragment) {
        if (suggestionsFragment.f105h.a == null || suggestionsFragment.f105h.a.e == null) {
            return "";
        }
        return suggestionsFragment.f105h.a.e.getText().toString();
    }

    public final void m190a(GraphSearchQuery graphSearchQuery) {
        if (graphSearchQuery != null) {
            m181c(graphSearchQuery);
        }
        if (VERSION.SDK_INT >= 21) {
            Api21AndUpUtil.m153a(o(), graphSearchQuery);
        }
        boolean z = this.aB.h(this.aY) || this.aB.g(this.aY);
        this.be = z;
        this.f105h.a.e.setText(this.aY.b);
        SearchSurveyLauncher searchSurveyLauncher = this.aO;
        Context ao = ao();
        SearchResultsMutableContext searchResultsMutableContext = searchSurveyLauncher.f386d.a;
        if (searchResultsMutableContext != null) {
            String l = searchResultsMutableContext.v().l();
            l = SearchQueryFunctions.e(searchResultsMutableContext.b()) ? "1710062295913737" : (l != null && l.equals("news_v2") && SearchSurveyLauncher.f384b.contains(searchResultsMutableContext.b)) ? "1210444112300428" : (l == null || !SearchSurveyLauncher.f383a.containsKey(l)) ? null : (String) SearchSurveyLauncher.f383a.get(l);
            if (l != null) {
                RapidFeedbackController rapidFeedbackController = (RapidFeedbackController) searchSurveyLauncher.f385c.get();
                if (searchResultsMutableContext.q != null) {
                    rapidFeedbackController.a("results_vertical", searchResultsMutableContext.q);
                }
                if (searchResultsMutableContext.b() != null) {
                    rapidFeedbackController.a("query_function", searchResultsMutableContext.b());
                }
                if (searchResultsMutableContext.a() != null) {
                    rapidFeedbackController.a("query", searchResultsMutableContext.a());
                }
                if (searchResultsMutableContext.b != null) {
                    rapidFeedbackController.a("results_source", searchResultsMutableContext.b.toString());
                }
                if (!(searchResultsMutableContext.d == null || searchResultsMutableContext.d.b == null)) {
                    rapidFeedbackController.a("typeahead_sid", searchResultsMutableContext.d.b);
                }
                if (searchResultsMutableContext.r != null) {
                    rapidFeedbackController.a("session_id", searchResultsMutableContext.r);
                }
                ((RapidFeedbackController) searchSurveyLauncher.f385c.get()).a(l, ao);
                searchSurveyLauncher.f386d.a = null;
            }
        }
        this.ba.mo3a(0);
    }

    public final void m193a(String str, GraphSearchQuery graphSearchQuery) {
        if (graphSearchQuery != null) {
            m181c(graphSearchQuery);
        }
        m179b(this, str);
    }

    private void aH() {
        if (this.bd && this.f105h.a != null) {
            this.f105h.a.e.b();
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1412333488);
        super.mY_();
        this.ba.mo27o();
        this.aV = null;
        this.aW = null;
        GraphSearchTitleSearchBox graphSearchTitleSearchBox = this.f105h.a;
        if (graphSearchTitleSearchBox != null) {
            graphSearchTitleSearchBox.b(this);
            graphSearchTitleSearchBox.k = null;
            graphSearchTitleSearchBox.setOnLongClickListener(null);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1803141756, a);
    }

    public final void m187I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -389539221);
        this.ba.mo26n();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1035423466, a);
    }

    public final void m199e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("recycler_view_enabled", this.bg);
    }

    public final void m198c(boolean z) {
        super.c(z);
        try {
            TracerDetour.a("SuggestionsFragment.onHiddenChanged", -909355794);
            aL();
            if (!z) {
                this.bd = true;
            } else if (this.aw != null) {
                this.aw.h();
            }
            if (this.ba != null) {
                this.ba.mo3a(z ? 8 : 0);
                if (!(z || !StringUtil.c(aG(this)) || this.ba.mo22j() == null)) {
                    this.ba.mo22j().h();
                }
            }
            TracerDetour.a(-1697170748);
        } catch (Throwable th) {
            TracerDetour.a(1455298374);
        }
    }

    public final boolean m195a(boolean z) {
        GraphSearchTitleSearchBox graphSearchTitleSearchBox = this.f105h.a;
        if (this.bf) {
            this.aK.b(f100c, true);
        }
        if (((SearchSpotlightNullStateSupplier) this.aU.get()).a() && (aG(this).isEmpty() || !((Boolean) this.aE.get()).booleanValue())) {
            ((SearchSpotlightNullStateSupplier) this.aU.get()).b();
        }
        if (graphSearchTitleSearchBox == null) {
            return false;
        }
        if (((Boolean) this.aE.get()).booleanValue() && aw(this) == SearchBoxQueryState.TYPED) {
            ((SuggestionsTypeaheadAnalyticHelper) this.an.get()).a(aK(), aC(this), aM(this), this.ba.mo17e(), aw(this), this.bb, this.aY.h, ay(this));
            graphSearchTitleSearchBox.f();
            ((SuggestionsTypeaheadAnalyticHelper) this.an.get()).a("");
            return true;
        }
        ((SuggestionsTypeaheadAnalyticHelper) this.an.get()).a(aK(), aC(this), aM(this), this.ba.mo17e(), aw(this), this.bb, this.aY.h, ay(this));
        return false;
    }

    private List<TypeaheadUnit> aJ() {
        TypeaheadUnitCollection l = this.ba.mo24l();
        if (l != null) {
            return l.f422a;
        }
        return RegularImmutableList.a;
    }

    private String aK() {
        BaseSuggestionsTypeaheadController j = this.ba.mo22j();
        return j != null ? j.c() : "";
    }

    static /* synthetic */ void m173a(SuggestionsFragment suggestionsFragment, TypeaheadUnitCollection typeaheadUnitCollection, MultiRowAdapter multiRowAdapter, ImmutableList immutableList) {
        List subList = immutableList.subList(0, Math.min(typeaheadUnitCollection.m527a() + 6, immutableList.size()));
        typeaheadUnitCollection.m529a(subList);
        Integer.valueOf(subList.size());
        multiRowAdapter.notifyDataSetChanged();
    }

    private void aL() {
        try {
            TracerDetour.a("SuggestionsFragment.maybeInitializeTitleBox", 668070190);
            if (!A()) {
                CharSequence aK = aK();
                GraphSearchQuery i = this.ba.mo21i();
                if (this.aB.e(i)) {
                    this.f105h.b().a(i);
                }
                if (this.f105h.b() != null) {
                    SearchEditText searchEditText = this.f105h.b().getSearchEditText();
                    searchEditText.setText(aK);
                    if (this.be && aK.equals(this.aY.e())) {
                        searchEditText.selectAll();
                        searchEditText.setSelectAllOnFocus(true);
                    }
                }
                if (!StringUtil.a(aK)) {
                    this.bd = true;
                }
                aH();
                TracerDetour.a(-1412387218);
            }
        } finally {
            TracerDetour.a(2122204391);
        }
    }

    public static void m171a(SuggestionsFragment suggestionsFragment, ProgressBar progressBar, ScrollingViewProxy scrollingViewProxy, FetchState fetchState) {
        switch (C00189.f91a[fetchState.ordinal()]) {
            case 1:
                progressBar.setVisibility(0);
                return;
            case 2:
                progressBar.setVisibility(8);
                if (suggestionsFragment.aW != null && suggestionsFragment.aW.isEnabled()) {
                    suggestionsFragment.aW.setRefreshing(false);
                    return;
                }
                return;
            case 3:
                progressBar.setVisibility(8);
                if (suggestionsFragment.aW != null && suggestionsFragment.aW.isEnabled()) {
                    suggestionsFragment.aW.setRefreshing(false);
                }
                scrollingViewProxy.a(0);
                if (suggestionsFragment.aV != null) {
                    suggestionsFragment.aV.setVisibility(8);
                }
                return;
            default:
                return;
        }
    }

    public static void m174a(SuggestionsFragment suggestionsFragment, FetchState fetchState) {
        if (fetchState == FetchState.ERROR && suggestionsFragment.mx_()) {
            ThrottledToaster throttledToaster = suggestionsFragment.am;
            ToastBuilder toastBuilder = new ToastBuilder(suggestionsFragment.b(2131237435));
            long a = throttledToaster.b.a();
            if (a - throttledToaster.d > throttledToaster.c) {
                throttledToaster.a.b(toastBuilder);
                throttledToaster.d = a;
            }
        }
    }

    public final String am_() {
        return "search_typeahead";
    }

    public static void m175a(SuggestionsFragment suggestionsFragment, String str, TypeaheadUnit typeaheadUnit, long j) {
        suggestionsFragment.at.f();
        ((SuggestionsTypeaheadAnalyticHelper) suggestionsFragment.an.get()).a(str, typeaheadUnit, suggestionsFragment.aK(), aC(suggestionsFragment), aM(suggestionsFragment), suggestionsFragment.ba.mo17e(), aw(suggestionsFragment), ax(suggestionsFragment), suggestionsFragment.aY.h(), ay(suggestionsFragment), j);
    }

    public static boolean aM(SuggestionsFragment suggestionsFragment) {
        ScrollingViewProxy g = suggestionsFragment.ba.mo19g();
        return g != null && g.u() > 0;
    }

    public static void m172a(SuggestionsFragment suggestionsFragment, TypeaheadUnit typeaheadUnit) {
        ((LogSelectedSuggestionToActivityLogHelper) suggestionsFragment.ao.get()).m257a(suggestionsFragment.ba.mo21i(), typeaheadUnit, suggestionsFragment.aK());
    }

    public static void aN(SuggestionsFragment suggestionsFragment) {
        GraphSearchTitleSearchBox graphSearchTitleSearchBox = suggestionsFragment.f105h.a;
        if (graphSearchTitleSearchBox != null) {
            graphSearchTitleSearchBox.e.c();
        }
    }

    public final Fragment m196b() {
        return this;
    }

    public final void aq() {
        this.ba.mo29q();
        if (!this.K) {
            ((SuggestionsTypeaheadAnalyticHelper) this.an.get()).a(aK(), aw(this), this.bb, this.aY.h, ay(this));
            ((InterstitialStartHelper) this.as.get()).a(this.ar, new InterstitialTrigger(Action.SIMPLE_SEARCH_CLEAR_TEXT_ICON_CLICK), InterstitialController.class, null);
        }
    }

    public final void mo30a(String str, String str2) {
        Object obj = null;
        SearchTypeaheadSystem k = this.ba.mo23k();
        if (k != null) {
            Object obj2;
            Object obj3;
            if (k.mo42b() != SearchBoxQueryState.SINGLE_STATE || str2.equals(this.aY.b)) {
                obj3 = null;
            } else {
                obj3 = 1;
            }
            if (!StringUtil.c(str) || StringUtil.c(str2)) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (!(obj2 == null && r2 == null)) {
                int i = 1;
            }
        }
        if (obj != null) {
            m183d(this, str);
            if (aw(this) == SearchBoxQueryState.SINGLE_STATE) {
                this.ba.mo25m();
            }
        }
    }

    public final SearchTypeaheadSession as() {
        return ((SuggestionsTypeaheadAnalyticHelper) this.an.get()).l;
    }

    public final void m191a(OnResultClickListener onResultClickListener) {
        this.aX = onResultClickListener;
    }

    public static void m183d(SuggestionsFragment suggestionsFragment, String str) {
        NullStateSupplier h = suggestionsFragment.ba.mo20h();
        SearchTypeaheadSystem k = suggestionsFragment.ba.mo23k();
        SearchBoxQueryState f = h != null ? h.f() : aw(suggestionsFragment);
        SearchBoxQueryState b = k != null ? k.mo42b() : aw(suggestionsFragment);
        if (!Strings.isNullOrEmpty(str)) {
            f = b;
        }
        if (f == SearchBoxQueryState.SINGLE_STATE || f == SearchBoxQueryState.NULL_STATE) {
            SuggestionsTypeaheadAnalyticHelper suggestionsTypeaheadAnalyticHelper = (SuggestionsTypeaheadAnalyticHelper) suggestionsFragment.an.get();
            ImmutableList aC = aC(suggestionsFragment);
            SuggestionTabType suggestionTabType = suggestionsFragment.bb;
            ScopedEntityType scopedEntityType = suggestionsFragment.aY.h;
            Object obj = 1;
            Object obj2 = (f == SearchBoxQueryState.SINGLE_STATE && suggestionsTypeaheadAnalyticHelper.t.isEmpty() && suggestionTabType != SuggestionTabType.SCOPED) ? 1 : null;
            if (!(f == SearchBoxQueryState.SINGLE_STATE && suggestionsTypeaheadAnalyticHelper.u.isEmpty() && suggestionTabType == SuggestionTabType.SCOPED)) {
                obj = null;
            }
            if (SearchBoxQueryState.NULL_STATE.equals(f) && suggestionsTypeaheadAnalyticHelper.s.isEmpty()) {
                suggestionsTypeaheadAnalyticHelper.s.addAll(aC);
            } else if (obj2 != null) {
                suggestionsTypeaheadAnalyticHelper.t.addAll(aC);
            } else if (obj != null) {
                suggestionsTypeaheadAnalyticHelper.u.addAll(aC);
            }
        }
    }

    private void m181c(GraphSearchQuery graphSearchQuery) {
        this.aY = graphSearchQuery;
        this.ba.mo7a(graphSearchQuery);
    }

    public static boolean aO(SuggestionsFragment suggestionsFragment) {
        return !suggestionsFragment.aB.e(suggestionsFragment.aY) && suggestionsFragment.aK.a(f100c);
    }

    private void m180c(View view) {
        this.aV = ((ViewStub) FindViewUtil.b(view, 2131567256)).inflate();
        SearchAwarenessController searchAwarenessController = this.aK;
        View view2 = this.aV;
        SearchAwarenessNullStateController searchAwarenessNullStateController = (SearchAwarenessNullStateController) searchAwarenessController.h.get(GraphQLSearchAwarenessTemplatesEnum.LEARNING_NUX_SECOND_STEP);
        if (searchAwarenessNullStateController != null) {
            int i;
            int i2 = 8;
            SearchAwarenessSuggestionFieldsFragment searchAwarenessSuggestionFieldsFragment = searchAwarenessNullStateController.b.a;
            BetterTextView betterTextView = (BetterTextView) view2.findViewById(2131567251);
            BetterTextView betterTextView2 = (BetterTextView) view2.findViewById(2131567252);
            BetterTextView betterTextView3 = (BetterTextView) view2.findViewById(2131567253);
            BetterTextView betterTextView4 = (BetterTextView) view2.findViewById(2131567254);
            BetterTextView betterTextView5 = (BetterTextView) view2.findViewById(2131567255);
            CharSequence a = SearchAwarenessNullStateController.a(searchAwarenessSuggestionFieldsFragment.c(), 0);
            betterTextView3.setText(a);
            betterTextView3.setVisibility(TextUtils.isEmpty(a) ? 8 : 0);
            CharSequence a2 = SearchAwarenessNullStateController.a(searchAwarenessSuggestionFieldsFragment.c(), 1);
            betterTextView4.setText(a2);
            if (TextUtils.isEmpty(a2)) {
                i = 8;
            } else {
                i = 0;
            }
            betterTextView4.setVisibility(i);
            a2 = SearchAwarenessNullStateController.a(searchAwarenessSuggestionFieldsFragment.c(), 2);
            betterTextView5.setText(a2);
            if (TextUtils.isEmpty(a2)) {
                i = 8;
            } else {
                i = 0;
            }
            betterTextView5.setVisibility(i);
            betterTextView.setText(searchAwarenessSuggestionFieldsFragment.g());
            if (TextUtils.isEmpty(searchAwarenessSuggestionFieldsFragment.g())) {
                i = 8;
            } else {
                i = 0;
            }
            betterTextView.setVisibility(i);
            betterTextView2.setText(searchAwarenessSuggestionFieldsFragment.d());
            if (!TextUtils.isEmpty(searchAwarenessSuggestionFieldsFragment.d())) {
                i2 = 0;
            }
            betterTextView2.setVisibility(i2);
        }
        if (this.aV != null) {
            final GlyphView glyphView = (GlyphView) FindViewUtil.b(this.aV, 2131559781);
            glyphView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SuggestionsFragment f87b;

                /* compiled from:   */
                class C00141 implements OnActionClickListener {
                    final /* synthetic */ C00156 f85a;

                    C00141(C00156 c00156) {
                        this.f85a = c00156;
                    }

                    public final void m150a() {
                        SuggestionsFragment.aQ(this.f85a.f87b);
                    }

                    public final void m151b() {
                        SuggestionsFragment.aQ(this.f85a.f87b);
                    }
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1145274666);
                    if (this.f87b.aN.a(SearchAbTestGatekeepers.l, false)) {
                        ((SearchAwarenessOptOutController) this.f87b.aL.get()).a(AwarenessType.LEARNING_NUX, new C00141(this), glyphView.getWindowToken());
                    } else {
                        SuggestionsFragment.aQ(this.f87b);
                    }
                    LogUtils.a(345894265, a);
                }
            });
        }
    }

    public static void aQ(SuggestionsFragment suggestionsFragment) {
        if (suggestionsFragment.aV != null) {
            suggestionsFragment.aV.setVisibility(8);
            suggestionsFragment.ba.mo3a(0);
            SearchAwarenessController searchAwarenessController = suggestionsFragment.aK;
            SearchAwarenessNullStateController searchAwarenessNullStateController = (SearchAwarenessNullStateController) searchAwarenessController.h.get(GraphQLSearchAwarenessTemplatesEnum.LEARNING_NUX_SECOND_STEP);
            if (searchAwarenessNullStateController != null) {
                searchAwarenessController.a(GraphQLSearchAwarenessTemplatesEnum.LEARNING_NUX_SECOND_STEP, true);
                if (searchAwarenessNullStateController.i) {
                    searchAwarenessNullStateController.d.b(searchAwarenessNullStateController.b, ImmutableBiMap.b("dismissed_by_user", Boolean.valueOf(true)));
                    searchAwarenessNullStateController.i = false;
                }
            }
        }
    }

    @Nullable
    public static View aR(SuggestionsFragment suggestionsFragment) {
        if (suggestionsFragment.aB.e(suggestionsFragment.aY)) {
            return null;
        }
        List<TypeaheadUnit> aJ = suggestionsFragment.aJ();
        TypeaheadUnit typeaheadUnit = null;
        for (TypeaheadUnit typeaheadUnit2 : aJ) {
            TypeaheadUnit typeaheadUnit22;
            if (typeaheadUnit22.l()) {
                if ((typeaheadUnit instanceof KeywordTypeaheadUnit) && !(typeaheadUnit22 instanceof KeywordTypeaheadUnit)) {
                    break;
                }
            }
            typeaheadUnit22 = typeaheadUnit;
            typeaheadUnit = typeaheadUnit22;
        }
        Object obj = null;
        if (aJ.contains(typeaheadUnit)) {
            ScrollingViewProxy g = suggestionsFragment.ba.mo19g();
            int indexOf = aJ.indexOf(typeaheadUnit);
            int q = g.q() + g.p();
            if (indexOf >= g.q() && indexOf < q) {
                obj = 1;
            }
        }
        if (obj != null) {
            return suggestionsFragment.ba.mo19g().c(aJ.indexOf(typeaheadUnit));
        }
        return null;
    }

    private void m184e(View view) {
        if (this.aB.e(this.aY)) {
            SuggestionTabType suggestionTabType;
            int indexOf;
            TabbedViewPagerIndicator tabbedViewPagerIndicator = (TabbedViewPagerIndicator) FindViewUtil.b(view, 2131562216);
            CustomViewPager customViewPager = (CustomViewPager) FindViewUtil.b(view, 2131562217);
            final SearchSuggestionsPagerAdapter searchSuggestionsPagerAdapter = (SearchSuggestionsPagerAdapter) this.ba;
            tabbedViewPagerIndicator.l = new SimpleOnPageChangeListener(this) {
                final /* synthetic */ SuggestionsFragment f90b;

                public final void e_(int i) {
                    SuggestionsFragment.m183d(this.f90b, SuggestionsFragment.aG(this.f90b));
                    SuggestionsFragment.aA(this.f90b);
                    searchSuggestionsPagerAdapter.m56b(i);
                    this.f90b.bb = (SuggestionTabType) SuggestionTabType.getTabs(this.f90b.aY).get(i);
                    this.f90b.al.e();
                    this.f90b.aw.h();
                    this.f90b.f105h.a.a(this.f90b.bb, this.f90b.aY.h);
                    SuggestionsFragment.az(this.f90b);
                    SuggestionsFragment.m179b(this.f90b, SuggestionsFragment.aG(this.f90b));
                }
            };
            customViewPager.setAdapter(searchSuggestionsPagerAdapter);
            tabbedViewPagerIndicator.setViewPager(customViewPager);
            SuggestionTabType suggestionTabType2 = SuggestionTabType.GLOBAL;
            int i = customViewPager.k;
            GraphSearchQueryTabModifier graphSearchQueryTabModifier = (GraphSearchQueryTabModifier) this.aY.a(ModifierKeys.SCOPED_TAB);
            if (graphSearchQueryTabModifier != null) {
                if (graphSearchQueryTabModifier.a) {
                    suggestionTabType = SuggestionTabType.SCOPED;
                } else {
                    suggestionTabType = SuggestionTabType.GLOBAL;
                }
                indexOf = SuggestionTabType.getTabs(this.aY).indexOf(suggestionTabType);
            } else {
                suggestionTabType = suggestionTabType2;
                indexOf = 0;
            }
            searchSuggestionsPagerAdapter.m56b(indexOf);
            customViewPager.setCurrentItem(indexOf);
            this.bb = suggestionTabType;
        }
    }

    public static ContextThemeWrapper m177b(Context context, @Nullable GraphSearchQuery graphSearchQuery) {
        Object obj;
        int i;
        if (graphSearchQuery == null || graphSearchQuery.h != ScopedEntityType.VIDEO) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            i = 2131625944;
        } else {
            i = 2131625943;
        }
        return new ContextThemeWrapper(context, i);
    }

    private void m170a(Clock clock, GraphSearchTitleSearchBoxSupplier graphSearchTitleSearchBoxSupplier, DelegatingSuggestionsPerformanceLogger delegatingSuggestionsPerformanceLogger, DbBootstrapPerformanceLogger dbBootstrapPerformanceLogger, ThrottledToaster throttledToaster, com.facebook.inject.Lazy<SuggestionsTypeaheadAnalyticHelper> lazy, com.facebook.inject.Lazy<LogSelectedSuggestionToActivityLogHelper> lazy2, com.facebook.inject.Lazy<FbUriIntentHandler> lazy3, String str, Context context, com.facebook.inject.Lazy<InterstitialStartHelper> lazy4, SearchWaterfallLogger searchWaterfallLogger, com.facebook.inject.Lazy<AndroidThreadUtil> lazy5, com.facebook.inject.Lazy<NavigationLogger> lazy6, NullStatePerformanceLogger nullStatePerformanceLogger, SearchNullStateMegaphoneController searchNullStateMegaphoneController, GraphSearchErrorReporter graphSearchErrorReporter, com.facebook.inject.Lazy<SecureContextHelper> lazy7, QeAccessor qeAccessor, GraphSearchConfig graphSearchConfig, com.facebook.inject.Lazy<PlaceTipsReactionManager> lazy8, com.facebook.inject.Lazy<PlaceTipsAnalyticsLogger> lazy9, Provider<Boolean> provider, com.facebook.inject.Lazy<PendingBootstrapEntitiesManager> lazy10, com.facebook.inject.Lazy<ComposerPublishServiceHelper> lazy11, RecentSearchesMutatorSelector recentSearchesMutatorSelector, SingleSearchSuggestionListControllerProvider singleSearchSuggestionListControllerProvider, SearchSuggestionsPagerAdapterProvider searchSuggestionsPagerAdapterProvider, SearchAwarenessController searchAwarenessController, com.facebook.inject.Lazy<SearchAwarenessOptOutController> lazy12, SearchBugReportExtraDataProvider searchBugReportExtraDataProvider, GatekeeperStore gatekeeperStore, SearchSurveyLauncher searchSurveyLauncher, FbTitleBarSupplier fbTitleBarSupplier, SearchThemeHelper searchThemeHelper, com.facebook.inject.Lazy<ViewportMonitor> lazy13, com.facebook.inject.Lazy<SuggestionsLoggingViewportEventListener> lazy14, SearchSuggestionsInitializer searchSuggestionsInitializer, com.facebook.inject.Lazy<SearchSpotlightNullStateSupplier> lazy15) {
        this.f104g = clock;
        this.f105h = graphSearchTitleSearchBoxSupplier;
        this.f106i = delegatingSuggestionsPerformanceLogger;
        this.al = dbBootstrapPerformanceLogger;
        this.am = throttledToaster;
        this.an = lazy;
        this.ao = lazy2;
        this.ap = lazy3;
        this.aq = str;
        this.ar = context;
        this.as = lazy4;
        this.at = searchWaterfallLogger;
        this.au = lazy5;
        this.av = lazy6;
        this.aw = nullStatePerformanceLogger;
        this.ax = searchNullStateMegaphoneController;
        this.ay = graphSearchErrorReporter;
        this.az = lazy7;
        this.aA = qeAccessor;
        this.aB = graphSearchConfig;
        this.aC = lazy8;
        this.aD = lazy9;
        this.aE = provider;
        this.aF = lazy10;
        this.aG = lazy11;
        this.aH = recentSearchesMutatorSelector;
        this.aI = singleSearchSuggestionListControllerProvider;
        this.aJ = searchSuggestionsPagerAdapterProvider;
        this.aK = searchAwarenessController;
        this.aL = lazy12;
        this.aM = searchBugReportExtraDataProvider;
        this.aN = gatekeeperStore;
        this.aO = searchSurveyLauncher;
        this.aP = fbTitleBarSupplier;
        this.aQ = searchThemeHelper;
        this.aR = lazy13;
        this.aS = lazy14;
        this.aT = searchSuggestionsInitializer;
        this.aU = lazy15;
    }
}
