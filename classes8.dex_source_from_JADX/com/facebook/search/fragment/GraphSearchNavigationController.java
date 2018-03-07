package com.facebook.search.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.common.ActionSource;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.groups.constants.GroupIntentBuilder;
import com.facebook.inject.Assisted;
import com.facebook.ipc.pages.PageViewReferrer;
import com.facebook.qe.api.QeAccessor;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.ReactionSessionHelper;
import com.facebook.reaction.analytics.perflog.ReactionPerfLogger;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ModifierKeys;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.SearchResultsPerformanceLogger;
import com.facebook.search.logging.SuggestionsTypeaheadAnalyticHelper;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.search.logging.perf.SearchWaterfallLogger;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.model.GraphSearchQuerySpecHelper;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import com.facebook.search.model.KeywordTypeaheadUnit.Source;
import com.facebook.search.model.NearbyTypeaheadUnit;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.model.ReactionSearchData;
import com.facebook.search.model.ShortcutTypeaheadUnit;
import com.facebook.search.model.awareness.AwarenessGraphSearchConfiguration;
import com.facebook.search.results.environment.tabs.SearchResultsTab;
import com.facebook.search.results.fragment.GraphSearchResultFragment;
import com.facebook.search.results.fragment.spec.GraphSearchResultFragmentSpecificationRegistry;
import com.facebook.search.results.fragment.tabs.SearchResultsTabConfig;
import com.facebook.search.results.fragment.tabs.SearchResultsTabsFragment;
import com.facebook.search.results.loader.SearchResultsObjectInitializer;
import com.facebook.search.results.loader.modules.SearchResultsFeedModulesDataLoader;
import com.facebook.search.suggestions.SuggestionsFragment;
import com.facebook.search.suggestions.log.ActivityLoggingUpdateTypeVisitor;
import com.facebook.search.suggestions.log.ActivityLoggingUpdateTypeVisitor.ActivityLogUpdateType;
import com.facebook.search.util.GraphSearchConfig;
import com.facebook.search.util.bugreporter.SearchBugReportEvent;
import com.facebook.search.util.bugreporter.SearchBugReportExtraDataProvider;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.ufiservices.flyout.UFIPopoverFragment;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.video.channelfeed.activity.ChannelFeedActivity;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ThrowbackSettingsSubscriptionMutation */
public class GraphSearchNavigationController {
    public static final String f21897E = GraphSearchNavigationController.class.getSimpleName();
    private static final ImmutableMap<Source, SearchResultsSource> f21898F = new Builder().b(Source.SUGGESTION, SearchResultsSource.a).b(Source.SINGLE_STATE, SearchResultsSource.b).b(Source.RECENT_SEARCHES, SearchResultsSource.f).b(Source.SEARCH_BUTTON, SearchResultsSource.c).b(Source.ECHO, SearchResultsSource.d).b(Source.ESCAPE, SearchResultsSource.e).b(Source.TRENDING_ENTITY, SearchResultsSource.g).b(Source.NULL_STATE_MODULE, SearchResultsSource.v).b(Source.SS_SEE_MORE_LINK, SearchResultsSource.E).b(Source.SS_SEE_MORE_BUTTON, SearchResultsSource.F).b();
    private static final ImmutableSet<SearchResultsSource> f21899a = ImmutableSet.of(SearchResultsSource.w, SearchResultsSource.A);
    @Nullable
    public AwarenessGraphSearchConfiguration f21900A;
    private boolean f21901B = true;
    private String f21902C;
    private final ActivityLoggingUpdateTypeVisitor f21903D;
    public final Context f21904b;
    public final FbUriIntentHandler f21905c;
    public final GraphQLLinkExtractor f21906d;
    public final GraphSearchChildFragmentInstanceManager f21907e;
    public final GraphSearchChildFragmentNavigator f21908f;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ReactionExperimentController> f21909g = UltralightRuntime.b();
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ReactionPerfLogger> f21910h = UltralightRuntime.b();
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ReactionSessionHelper> f21911i = UltralightRuntime.b();
    public final FragmentManager f21912j;
    private final SearchWaterfallLogger f21913k;
    private final GraphSearchErrorReporter f21914l;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SearchResultsIntentBuilder> f21915m = UltralightRuntime.b();
    private final SearchResultsPerformanceLogger f21916n;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SearchResultsFeedModulesDataLoader> f21917o = UltralightRuntime.b();
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SecureContextHelper> f21918p = UltralightRuntime.b();
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GraphSearchResultFragmentSpecificationRegistry> f21919q = UltralightRuntime.b();
    public final QeAccessor f21920r;
    public final GatekeeperStoreImpl f21921s;
    private final SearchResultsTabConfig f21922t;
    public final SearchBugReportExtraDataProvider f21923u;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SearchResultsObjectInitializer> f21924v = UltralightRuntime.b();
    public SearchTypeaheadSession f21925w = SearchTypeaheadSession.a;
    public GraphSearchQuerySpec f21926x;
    public GraphSearchQuery f21927y;
    public SearchResultsSource f21928z;

    public final void m25428a(ShortcutTypeaheadUnit shortcutTypeaheadUnit) {
        boolean z;
        String str;
        if (shortcutTypeaheadUnit.f22277c.g() == 811944494) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        String uri = shortcutTypeaheadUnit.f22282h == null ? "" : shortcutTypeaheadUnit.f22282h.toString();
        if (shortcutTypeaheadUnit.f22281g == null) {
            str = "";
        } else {
            str = shortcutTypeaheadUnit.f22281g.toString();
        }
        if (!this.f21905c.a(this.f21904b, str)) {
            this.f21914l.a(GraphSearchError.BAD_SUGGESTION, StringFormatUtil.formatStrLocaleSafe("Shortcut (id: %s) has bad field (path: %s)", shortcutTypeaheadUnit.f22275a, str));
            if (!this.f21905c.a(this.f21904b, uri)) {
                this.f21914l.a(GraphSearchError.BAD_SUGGESTION, StringFormatUtil.formatStrLocaleSafe("Shortcut (id: %s) has bad field (fallback_path: %s)", shortcutTypeaheadUnit.f22275a, uri));
            }
        }
    }

    public final void m25427a(NearbyTypeaheadUnit nearbyTypeaheadUnit) {
        String str = nearbyTypeaheadUnit.f22156a;
        if (TextUtils.isEmpty(str)) {
            this.f21914l.b(GraphSearchError.BAD_NEARBY_SUGGESTION, "Click on nearby suggestion without id!");
            return;
        }
        String uuid = SafeUUIDGenerator.a().toString();
        Surface surface = Surface.ANDROID_SEARCH_LOCAL_NULL;
        ((ReactionPerfLogger) this.f21910h.get()).b(1966082, uuid, surface);
        ((ReactionPerfLogger) this.f21910h.get()).a(1966090, uuid, surface);
        if (((ReactionExperimentController) this.f21909g.get()).j()) {
            long parseLong = Long.parseLong(str);
            ReactionSessionHelper reactionSessionHelper = (ReactionSessionHelper) this.f21911i.get();
            ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
            reactionQueryParams.f18631l = Long.valueOf(parseLong);
            reactionQueryParams = reactionQueryParams;
            reactionQueryParams.f18639t = Long.valueOf(parseLong);
            reactionSessionHelper.m22585a(uuid, surface, reactionQueryParams);
        }
        this.f21925w = this.f21907e.m25375e();
        if (((ReactionExperimentController) this.f21909g.get()).k()) {
            m25409a(nearbyTypeaheadUnit, str, uuid, surface);
        } else {
            m25411a(str, nearbyTypeaheadUnit.f22157b, uuid, surface);
        }
    }

    final void m25423a(com.facebook.inject.Lazy<ReactionExperimentController> lazy, com.facebook.inject.Lazy<ReactionPerfLogger> lazy2, com.facebook.inject.Lazy<ReactionSessionHelper> lazy3, com.facebook.inject.Lazy<SearchResultsIntentBuilder> lazy4, com.facebook.inject.Lazy<SearchResultsFeedModulesDataLoader> lazy5, com.facebook.inject.Lazy<SecureContextHelper> lazy6, com.facebook.inject.Lazy<GraphSearchResultFragmentSpecificationRegistry> lazy7, com.facebook.inject.Lazy<SearchResultsObjectInitializer> lazy8) {
        this.f21909g = lazy;
        this.f21910h = lazy2;
        this.f21911i = lazy3;
        this.f21915m = lazy4;
        this.f21917o = lazy5;
        this.f21918p = lazy6;
        this.f21919q = lazy7;
        this.f21924v = lazy8;
    }

    @Inject
    public GraphSearchNavigationController(Context context, FbUriIntentHandler fbUriIntentHandler, GraphQLLinkExtractor graphQLLinkExtractor, @Assisted GraphSearchChildFragmentInstanceManager graphSearchChildFragmentInstanceManager, @Assisted GraphSearchChildFragmentNavigator graphSearchChildFragmentNavigator, @Assisted FragmentManager fragmentManager, SearchWaterfallLogger searchWaterfallLogger, GraphSearchErrorReporter graphSearchErrorReporter, SearchResultsPerformanceLogger searchResultsPerformanceLogger, QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl, SearchResultsTabConfig searchResultsTabConfig, SearchBugReportExtraDataProvider searchBugReportExtraDataProvider, ActivityLoggingUpdateTypeVisitor activityLoggingUpdateTypeVisitor) {
        this.f21904b = context;
        this.f21905c = fbUriIntentHandler;
        this.f21906d = graphQLLinkExtractor;
        this.f21907e = graphSearchChildFragmentInstanceManager;
        this.f21908f = graphSearchChildFragmentNavigator;
        this.f21912j = fragmentManager;
        this.f21913k = searchWaterfallLogger;
        this.f21914l = graphSearchErrorReporter;
        this.f21916n = searchResultsPerformanceLogger;
        this.f21920r = qeAccessor;
        this.f21921s = gatekeeperStoreImpl;
        this.f21922t = searchResultsTabConfig;
        this.f21923u = searchBugReportExtraDataProvider;
        this.f21903D = activityLoggingUpdateTypeVisitor;
    }

    public final void m25422a() {
        if (this.f21901B) {
            m25421d();
        }
        this.f21901B = false;
    }

    public final void m25424a(@Nullable GraphSearchQuery graphSearchQuery, EntityTypeaheadUnit entityTypeaheadUnit) {
        if (GraphSearchConfig.m10643b(graphSearchQuery)) {
            String uri;
            String str = entityTypeaheadUnit.f22045a;
            String str2 = entityTypeaheadUnit.f22046b;
            String str3 = entityTypeaheadUnit.f22049e;
            if (entityTypeaheadUnit.f22048d != null) {
                uri = entityTypeaheadUnit.f22048d.toString();
            } else {
                uri = null;
            }
            m25413a(str, str2, str3, uri);
        } else if (entityTypeaheadUnit.f22047c.g() == 2479791) {
            m25410a(entityTypeaheadUnit.f22045a, entityTypeaheadUnit.f22046b, entityTypeaheadUnit.f22048d, PageViewReferrer.SEARCH_TYPEAHEAD);
        } else if (entityTypeaheadUnit.f22047c.g() == 67338874) {
            m25418b(entityTypeaheadUnit.f22045a);
        } else {
            m25417b(entityTypeaheadUnit.f22047c, entityTypeaheadUnit.f22045a, entityTypeaheadUnit.f22046b, entityTypeaheadUnit.f22048d);
        }
    }

    private void m25411a(String str, String str2, String str3, Surface surface) {
        ((SecureContextHelper) this.f21918p.get()).a(((SearchResultsIntentBuilder) this.f21915m.get()).b(str, str2, str3, SearchResultsSource.v, surface, this.f21925w), 11111, this.f21908f.m25376a());
    }

    public final void m25426a(KeywordTypeaheadUnit keywordTypeaheadUnit) {
        this.f21925w = this.f21907e.m25375e();
        switch (keywordTypeaheadUnit.f22118g) {
            case local:
                m25408a(keywordTypeaheadUnit, keywordTypeaheadUnit.mo1211a(), keywordTypeaheadUnit.mo1212b(), keywordTypeaheadUnit.f22122k);
                return;
            case local_category:
                ((SecureContextHelper) this.f21918p.get()).a(((SearchResultsIntentBuilder) this.f21915m.get()).a(keywordTypeaheadUnit.mo1211a(), keywordTypeaheadUnit.mo1212b(), keywordTypeaheadUnit.jH_(), keywordTypeaheadUnit.f22118g.name(), (SearchResultsSource) f21898F.get(keywordTypeaheadUnit.f22122k), this.f21925w, ExactMatchInputExactMatch.TRUE), 11111, this.f21908f.m25376a());
                return;
            default:
                m25406a((GraphSearchQuerySpec) keywordTypeaheadUnit, (SearchResultsSource) f21898F.get(keywordTypeaheadUnit.f22122k), this.f21925w, m25420b(keywordTypeaheadUnit));
                return;
        }
    }

    private void m25408a(KeywordTypeaheadUnit keywordTypeaheadUnit, String str, String str2, Source source) {
        Surface surface;
        String uuid = SafeUUIDGenerator.a().toString();
        if (source == Source.ECHO || source == Source.SINGLE_STATE) {
            surface = Surface.ANDROID_SEARCH_LOCAL_SINGLE;
        } else {
            surface = Surface.ANDROID_SEARCH_LOCAL_TYPEAHEAD;
        }
        Surface surface2 = surface;
        ((ReactionPerfLogger) this.f21910h.get()).b(1966082, uuid, surface2);
        ((ReactionPerfLogger) this.f21910h.get()).a(1966090, uuid, surface2);
        if (((ReactionExperimentController) this.f21909g.get()).j()) {
            ReactionSessionHelper reactionSessionHelper = (ReactionSessionHelper) this.f21911i.get();
            ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
            reactionQueryParams.f18624e = str2;
            reactionSessionHelper.m22585a(uuid, surface2, reactionQueryParams);
        }
        this.f21925w = this.f21907e.m25375e();
        if (((ReactionExperimentController) this.f21909g.get()).k()) {
            m25407a(keywordTypeaheadUnit, uuid, str2, surface2);
        } else {
            m25412a(str, uuid, str2, source, surface2);
        }
    }

    private void m25412a(String str, String str2, String str3, Source source, Surface surface) {
        SearchResultsSource searchResultsSource;
        SearchResultsIntentBuilder searchResultsIntentBuilder = (SearchResultsIntentBuilder) this.f21915m.get();
        if (source == Source.ECHO) {
            searchResultsSource = SearchResultsSource.d;
        } else if (source == Source.SINGLE_STATE) {
            searchResultsSource = SearchResultsSource.b;
        } else {
            searchResultsSource = SearchResultsSource.a;
        }
        ((SecureContextHelper) this.f21918p.get()).a(searchResultsIntentBuilder.a(str, str2, str3, searchResultsSource, surface, this.f21925w), 11111, this.f21908f.m25376a());
    }

    private void m25413a(String str, String str2, String str3, String str4) {
        ((SecureContextHelper) this.f21918p.get()).a(ChannelFeedActivity.a(this.f21904b, str, false, str2, str3, str4), this.f21904b);
    }

    public final void m25425a(GraphSearchQuery graphSearchQuery, NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit) {
        int g = nullStateSuggestionTypeaheadUnit.f22236c.g();
        KeywordTypeaheadUnit.Builder builder;
        if (g == 907720311) {
            Source source = Source.RECENT_SEARCHES;
            KeywordType keywordType = KeywordType.keyword;
            if (nullStateSuggestionTypeaheadUnit.f22241h == KeywordType.local || nullStateSuggestionTypeaheadUnit.f22241h == KeywordType.local_category) {
                keywordType = nullStateSuggestionTypeaheadUnit.f22241h;
            }
            KeywordTypeaheadUnit.Builder builder2 = new KeywordTypeaheadUnit.Builder();
            builder2.f22088c = nullStateSuggestionTypeaheadUnit.f22234a;
            builder2 = builder2;
            builder2.f22087b = nullStateSuggestionTypeaheadUnit.f22235b;
            builder2 = builder2;
            builder2.f22089d = nullStateSuggestionTypeaheadUnit.f22235b;
            builder2 = builder2;
            builder2.f22090e = "content";
            builder2 = builder2;
            builder2.f22091f = ExactMatchInputExactMatch.FALSE;
            builder2 = builder2;
            builder2.f22092g = keywordType;
            KeywordTypeaheadUnit.Builder builder3 = builder2;
            builder3.f22096k = source;
            builder = builder3;
            builder.f22107v = GraphSearchConfig.m10640a(graphSearchQuery);
            m25426a(builder.m25651b());
        } else if (g == -466486798) {
            builder = KeywordTypeaheadUnit.Builder.m25648a(nullStateSuggestionTypeaheadUnit.f22235b, Source.RECENT_SEARCHES);
            builder.f22107v = GraphSearchConfig.m10640a(graphSearchQuery);
            m25426a(builder.m25651b());
        } else if (g == 811944494) {
            ShortcutTypeaheadUnit.Builder builder4 = new ShortcutTypeaheadUnit.Builder();
            builder4.f22267a = nullStateSuggestionTypeaheadUnit.f22234a;
            builder4 = builder4;
            builder4.f22268b = nullStateSuggestionTypeaheadUnit.f22235b;
            builder4 = builder4;
            builder4.f22269c = nullStateSuggestionTypeaheadUnit.f22236c;
            builder4 = builder4;
            builder4.f22270d = nullStateSuggestionTypeaheadUnit.f22238e;
            builder4 = builder4;
            builder4.f22273g = nullStateSuggestionTypeaheadUnit.f22239f;
            builder4 = builder4;
            builder4.f22274h = nullStateSuggestionTypeaheadUnit.f22240g;
            m25428a(builder4.m25748i());
        } else if (GraphSearchConfig.m10643b(graphSearchQuery)) {
            m25413a(nullStateSuggestionTypeaheadUnit.f22234a, nullStateSuggestionTypeaheadUnit.f22235b, null, nullStateSuggestionTypeaheadUnit.f22238e != null ? nullStateSuggestionTypeaheadUnit.f22238e.toString() : null);
        } else if (g == 2479791) {
            m25410a(nullStateSuggestionTypeaheadUnit.f22234a, nullStateSuggestionTypeaheadUnit.f22235b, nullStateSuggestionTypeaheadUnit.f22238e, PageViewReferrer.RECENT_SEARCHS);
        } else if (g == 67338874) {
            m25418b(nullStateSuggestionTypeaheadUnit.f22234a);
        } else {
            m25417b(nullStateSuggestionTypeaheadUnit.f22236c, nullStateSuggestionTypeaheadUnit.f22234a, nullStateSuggestionTypeaheadUnit.f22235b, nullStateSuggestionTypeaheadUnit.f22238e);
        }
    }

    public final boolean m25429a(boolean z) {
        Fragment a = this.f21912j.a("chromeless:content:fragment:tag");
        Object obj = ((a instanceof UFIPopoverFragment) && a.z()) ? 1 : null;
        if (obj != null) {
            return false;
        }
        this.f21923u.a(f21897E, z ? SearchBugReportEvent.UP_BUTTON_PRESSED : SearchBugReportEvent.BACK_BUTTON_PRESSED);
        Fragment a2 = this.f21908f.m25376a();
        if ((a2 instanceof GraphSearchChildFragment) && ((GraphSearchChildFragment) a2).mo1191a(z)) {
            return true;
        }
        SuggestionsFragment a3 = this.f21907e.m25370a(this.f21927y);
        boolean a4 = m25414a(a2, z);
        if (a3.z() || !a4) {
            this.f21913k.m25602e();
            return false;
        }
        if (a2 instanceof SearchResultsTabsFragment) {
            a3.bd = false;
        }
        this.f21908f.m25378b(a3);
        a3.a(this.f21927y);
        return true;
    }

    private void m25421d() {
        Preconditions.checkState(this.f21901B);
        if (this.f21926x != null) {
            m25406a(this.f21926x, this.f21928z, this.f21925w, false);
        } else if (!this.f21921s.a(SearchAbTestGatekeepers.m, false) || this.f21900A == null) {
            SuggestionsFragment a = this.f21907e.m25370a(this.f21927y);
            this.f21908f.m25378b(a);
            a.a(this.f21927y);
            SuggestionsTypeaheadAnalyticHelper suggestionsTypeaheadAnalyticHelper = (SuggestionsTypeaheadAnalyticHelper) a.an.get();
            suggestionsTypeaheadAnalyticHelper.f22003m = a.aY.b;
            a.ba.a(suggestionsTypeaheadAnalyticHelper);
        } else {
            this.f21908f.m25378b(this.f21907e.m25374d());
        }
    }

    private void m25410a(String str, String str2, Uri uri, PageViewReferrer pageViewReferrer) {
        String a = GraphQLLinkExtractor.a(2479791, new Object[]{str});
        Bundle bundle = new Bundle();
        ModelBundle.b(bundle, str, str2, uri.toString());
        bundle.putSerializable("page_view_referrer", pageViewReferrer);
        this.f21905c.a(this.f21904b, a, bundle);
    }

    private void m25418b(String str) {
        String a = GraphQLLinkExtractor.a(67338874, new Object[]{str});
        Bundle bundle = new Bundle();
        ActionSource.putActionRef(bundle, ActionSource.GRAPH_SEARCH);
        this.f21905c.a(this.f21904b, a, bundle);
    }

    private void m25417b(GraphQLObjectType graphQLObjectType, String str, String str2, Uri uri) {
        Bundle bundle;
        if (graphQLObjectType != null && graphQLObjectType.g() == 2645995) {
            bundle = new Bundle();
            ModelBundle.a(bundle, str, uri.toString(), str2);
            this.f21905c.a(this.f21904b, this.f21906d.a(graphQLObjectType, str), bundle);
        } else if (graphQLObjectType == null || graphQLObjectType.g() != 69076575) {
            this.f21905c.a(this.f21904b, this.f21906d.a(graphQLObjectType, str));
        } else {
            bundle = new Bundle();
            GroupIntentBuilder.a(bundle, str, str2, null);
            this.f21905c.a(this.f21904b, this.f21906d.a(graphQLObjectType, str), bundle);
        }
    }

    private void m25406a(GraphSearchQuerySpec graphSearchQuerySpec, @Nullable SearchResultsSource searchResultsSource, SearchTypeaheadSession searchTypeaheadSession, boolean z) {
        GraphSearchQuerySpec a;
        Object obj;
        GraphSearchChildFragment a2;
        this.f21916n.m25508a(graphSearchQuerySpec, searchTypeaheadSession.b);
        GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle = (GraphQLGraphSearchResultsDisplayStyle) graphSearchQuerySpec.mo1215f().get(0);
        if (graphSearchQuerySpec.mo1216h() == null) {
            SearchResultsTab searchResultsTab;
            if (m25419b(graphSearchQuerySpec)) {
                ((SearchResultsObjectInitializer) this.f21924v.get()).m26951a();
            }
            boolean a3 = m25415a(graphSearchQuerySpec, graphQLGraphSearchResultsDisplayStyle);
            if (a3) {
                searchResultsTab = SearchResultsTab.TOP;
            } else {
                searchResultsTab = (SearchResultsTab) this.f21922t.m26877a(graphSearchQuerySpec).get(0);
            }
            a = ((GraphSearchResultFragmentSpecificationRegistry) this.f21919q.get()).m26830a(searchResultsTab).mo1309a(graphSearchQuerySpec.mo1211a(), graphSearchQuerySpec.mo1212b(), graphSearchQuerySpec.mo1213c(), m25405a(graphSearchQuerySpec, a3), graphSearchQuerySpec.mo1221m(), graphSearchQuerySpec.mo1214e());
        } else {
            a = graphSearchQuerySpec;
        }
        if (SearchResultsTabConfig.m26876b(graphSearchQuerySpec) || SearchResultsTabConfig.m26874a(graphSearchQuerySpec, this.f21921s)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            ((SearchResultsFeedModulesDataLoader) this.f21917o.get()).m27010a(a, searchTypeaheadSession.b, searchResultsSource, z);
        }
        Bundle bundle = new Bundle();
        bundle.putString("display_style", graphQLGraphSearchResultsDisplayStyle.toString());
        if (GraphSearchQuerySpecHelper.m25629b(graphSearchQuerySpec)) {
            a2 = this.f21907e.m25368a((Bundle) graphSearchQuerySpec.jJ_().get(ModifierKeys.MARKETPLACE));
        } else if (graphQLGraphSearchResultsDisplayStyle == GraphQLGraphSearchResultsDisplayStyle.PHOTOS) {
            a2 = this.f21907e.m25372b();
        } else if (graphQLGraphSearchResultsDisplayStyle == GraphQLGraphSearchResultsDisplayStyle.STORIES) {
            a2 = this.f21907e.m25371b(bundle);
        } else if (graphQLGraphSearchResultsDisplayStyle == GraphQLGraphSearchResultsDisplayStyle.BLENDED_VIDEOS) {
            a2 = this.f21907e.m25369a(graphSearchQuerySpec, bundle, true);
        } else if (graphQLGraphSearchResultsDisplayStyle == GraphQLGraphSearchResultsDisplayStyle.BLENDED) {
            GraphSearchResultFragment b = m25416a(graphSearchQuerySpec, a) ? this.f21907e.m25371b(bundle) : this.f21907e.m25369a(graphSearchQuerySpec, bundle, true);
        } else {
            a2 = this.f21907e.m25367a();
        }
        a2.mo1281a(a, searchTypeaheadSession, searchResultsSource);
        this.f21908f.m25378b(a2.mo1192b());
        this.f21902C = a.jH_();
    }

    private void m25409a(NearbyTypeaheadUnit nearbyTypeaheadUnit, String str, String str2, Surface surface) {
        ReactionSearchData reactionSearchData = new ReactionSearchData(str, null, null, str2, surface);
        GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle = GraphQLGraphSearchResultsDisplayStyle.BLENDED;
        KeywordTypeaheadUnit.Builder builder = new KeywordTypeaheadUnit.Builder();
        builder.f22087b = nearbyTypeaheadUnit.f22157b;
        builder = builder;
        builder.f22088c = SearchQueryFunctions.a(graphQLGraphSearchResultsDisplayStyle, nearbyTypeaheadUnit.f22157b);
        builder = builder;
        builder.f22090e = "content";
        builder = builder;
        builder.f22091f = ExactMatchInputExactMatch.FALSE;
        builder = builder;
        builder.f22107v = ImmutableList.of(graphQLGraphSearchResultsDisplayStyle);
        KeywordTypeaheadUnit.Builder builder2 = builder;
        builder2.f22095j = reactionSearchData;
        builder2 = builder2;
        builder2.f22092g = KeywordType.local;
        GraphSearchQuerySpec b = builder2.m25651b();
        m25406a(b, SearchResultsSource.v, this.f21925w, m25420b((KeywordTypeaheadUnit) b));
    }

    private void m25407a(KeywordTypeaheadUnit keywordTypeaheadUnit, String str, String str2, Surface surface) {
        ReactionSearchData reactionSearchData = new ReactionSearchData(null, null, str2, str, surface);
        KeywordTypeaheadUnit.Builder a = KeywordTypeaheadUnit.Builder.m25647a(keywordTypeaheadUnit);
        a.f22095j = reactionSearchData;
        GraphSearchQuerySpec b = a.m25651b();
        m25406a(b, (SearchResultsSource) f21898F.get(keywordTypeaheadUnit.f22122k), this.f21925w, m25420b((KeywordTypeaheadUnit) b));
    }

    private static String m25405a(GraphSearchQuerySpec graphSearchQuerySpec, boolean z) {
        String jH_ = graphSearchQuerySpec.jH_();
        if (graphSearchQuerySpec instanceof KeywordTypeaheadUnit) {
            KeywordType keywordType = ((KeywordTypeaheadUnit) graphSearchQuerySpec).f22118g;
            if (keywordType == KeywordType.trending || SearchQueryFunctions.a(graphSearchQuerySpec.mo1212b())) {
                return "news_v2";
            }
            if (keywordType == KeywordType.celebrity && z) {
                return "celebrity";
            }
        }
        return jH_;
    }

    private boolean m25416a(GraphSearchQuerySpec graphSearchQuerySpec, GraphSearchQuerySpec graphSearchQuerySpec2) {
        boolean z = true;
        if (!GraphSearchQuerySpecHelper.m25630c(graphSearchQuerySpec) || this.f21920r.a(ExperimentsForSearchAbTestModule.bR, true)) {
            z = false;
        }
        if (!z) {
            z = false;
            if (!(SearchResultsTabConfig.m26876b(graphSearchQuerySpec) || GraphSearchQuerySpecHelper.m25630c(graphSearchQuerySpec2) || !this.f21920r.a(ExperimentsForSearchAbTestModule.w, false))) {
                z = true;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    private boolean m25415a(GraphSearchQuerySpec graphSearchQuerySpec, GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle) {
        return graphQLGraphSearchResultsDisplayStyle.equals(GraphQLGraphSearchResultsDisplayStyle.BLENDED) && !SearchResultsTabConfig.m26876b(graphSearchQuerySpec) && this.f21920r.a(ExperimentsForSearchAbTestModule.l, false);
    }

    private boolean m25419b(GraphSearchQuerySpec graphSearchQuerySpec) {
        return (SearchResultsTabConfig.m26876b(graphSearchQuerySpec) || this.f21921s.a(SearchAbTestGatekeepers.x, false) || SearchResultsTabConfig.m26874a(graphSearchQuerySpec, this.f21921s)) ? false : true;
    }

    private boolean m25414a(Fragment fragment, boolean z) {
        if (fragment instanceof SearchResultsTabsFragment) {
            Object obj;
            SearchResultsTabsFragment searchResultsTabsFragment = (SearchResultsTabsFragment) fragment;
            if (searchResultsTabsFragment.aq == null || !SearchResultsTabConfig.m26876b(searchResultsTabsFragment.aq)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (!(obj == null || ((ReactionExperimentController) this.f21909g.get()).k())) {
                return false;
            }
        }
        boolean z2;
        if (z && !f21899a.contains(this.f21928z) && this.f21921s.a(SearchAbTestGatekeepers.E, false)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f21925w.b != null || r0) {
            return true;
        }
        return false;
    }

    private boolean m25420b(KeywordTypeaheadUnit keywordTypeaheadUnit) {
        return ActivityLoggingUpdateTypeVisitor.b(keywordTypeaheadUnit) == ActivityLogUpdateType.USE_SERP_ENDPOINT;
    }
}
