package com.facebook.search.logging;

import android.util.Pair;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.debug.log.BLog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.GraphSearchQuery.ScopedSearchStyle;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.bootstrap.db.data.BootstrapDbFetchHelper;
import com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.NearbyTypeaheadUnit;
import com.facebook.search.model.NullStateModuleSuggestionUnit;
import com.facebook.search.model.NullStateModuleSuggestionUnit.Type;
import com.facebook.search.model.NullStateModuleUnit;
import com.facebook.search.model.NullStateSeeMoreTypeaheadUnit;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.model.PlaceTipsTypeaheadUnit;
import com.facebook.search.model.SearchBoxQueryState;
import com.facebook.search.model.ShortcutTypeaheadUnit;
import com.facebook.search.model.SuggestionTabType;
import com.facebook.search.model.TrendingTypeaheadUnit;
import com.facebook.search.model.TypeaheadSuggestionsCache;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.model.visitor.GetTitleOfTypeaheadSuggestionVisitor;
import com.facebook.ui.typeahead.FetchState;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Test Tutorial Nux Configuration */
public class SuggestionsTypeaheadAnalyticHelper extends SearchAnalyticHelper {
    public static final Class<?> f21991a = SuggestionsTypeaheadAnalyticHelper.class;
    public final AnalyticsLogger f21992b;
    private final FbNetworkManager f21993c;
    private final GetTitleOfTypeaheadSuggestionVisitor f21994d;
    private final Lazy<BootstrapEntitiesLoader> f21995e;
    private final Lazy<TypeaheadSuggestionsCache> f21996f;
    private final GatekeeperStoreImpl f21997g;
    private final GraphSearchErrorReporter f21998h;
    private final ListeningExecutorService f21999i;
    private final ListeningExecutorService f22000j;
    public final Lazy<BootstrapDbFetchHelper> f22001k;
    public SearchTypeaheadSession f22002l = SearchTypeaheadSession.a;
    public String f22003m;
    public int f22004n;
    public int f22005o;
    private HoneyClientEvent f22006p;
    private ImmutableList<String> f22007q;
    private ImmutableList<String> f22008r;
    public final List<TypeaheadUnit> f22009s = new ArrayList();
    public final List<TypeaheadUnit> f22010t = new ArrayList();
    public final List<TypeaheadUnit> f22011u = new ArrayList();

    public static SuggestionsTypeaheadAnalyticHelper m25537b(InjectorLike injectorLike) {
        return new SuggestionsTypeaheadAnalyticHelper(AnalyticsLoggerMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike), GetTitleOfTypeaheadSuggestionVisitor.m25815a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 10475), IdBasedSingletonScopeProvider.b(injectorLike, 10500), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), GraphSearchErrorReporter.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 10465));
    }

    @Inject
    public SuggestionsTypeaheadAnalyticHelper(AnalyticsLogger analyticsLogger, FbNetworkManager fbNetworkManager, GetTitleOfTypeaheadSuggestionVisitor getTitleOfTypeaheadSuggestionVisitor, Lazy<BootstrapEntitiesLoader> lazy, Lazy<TypeaheadSuggestionsCache> lazy2, GatekeeperStore gatekeeperStore, GraphSearchErrorReporter graphSearchErrorReporter, ListeningExecutorService listeningExecutorService, ListeningExecutorService listeningExecutorService2, Lazy<BootstrapDbFetchHelper> lazy3) {
        this.f21992b = analyticsLogger;
        this.f21993c = fbNetworkManager;
        this.f21994d = getTitleOfTypeaheadSuggestionVisitor;
        this.f21995e = lazy;
        this.f21996f = lazy2;
        this.f21997g = gatekeeperStore;
        this.f21998h = graphSearchErrorReporter;
        this.f21999i = listeningExecutorService;
        this.f22000j = listeningExecutorService2;
        this.f22001k = lazy3;
        this.f22002l = new SearchTypeaheadSession(this.f22002l.b, SafeUUIDGenerator.a().toString());
        m25543a("");
    }

    public final void m25543a(String str) {
        this.f22002l = new SearchTypeaheadSession(SafeUUIDGenerator.a().toString(), this.f22002l.c);
        this.f22004n = 0;
        this.f22009s.clear();
        this.f22010t.clear();
        this.f22011u.clear();
        this.f22003m = str;
    }

    public final String m25540a() {
        return this.f22002l.b;
    }

    public final void m25546a(String str, TypeaheadUnit typeaheadUnit, String str2, ImmutableList<TypeaheadUnit> immutableList, boolean z, FetchState fetchState, @Nullable SearchBoxQueryState searchBoxQueryState, @Nullable SuggestionTabType suggestionTabType, @Nullable ScopedEntityType scopedEntityType, @Nullable ScopedSearchStyle scopedSearchStyle, long j) {
        HoneyClientEvent a = m25527a("selection", str, typeaheadUnit, str2, immutableList, searchBoxQueryState, suggestionTabType, scopedEntityType, scopedSearchStyle, true);
        m25538b(a);
        m25531a(a, fetchState);
        m25533a(a, z);
        m25543a(str2);
        a.a(j);
        m25532a(a, (List) immutableList, z);
    }

    public final void m25545a(String str, TypeaheadUnit typeaheadUnit, String str2, ImmutableList<TypeaheadUnit> immutableList, @Nullable SearchBoxQueryState searchBoxQueryState, @Nullable SuggestionTabType suggestionTabType, @Nullable ScopedEntityType scopedEntityType) {
        HoneyClientEvent a = m25527a("invalidated_suggestion", str, typeaheadUnit, str2, immutableList, searchBoxQueryState, suggestionTabType, scopedEntityType, null, false);
        this.f21992b.c(a);
        a.toString();
        if (BLog.b(3)) {
            a.u();
        }
    }

    private HoneyClientEvent m25527a(String str, String str2, TypeaheadUnit typeaheadUnit, String str3, ImmutableList<TypeaheadUnit> immutableList, @Nullable SearchBoxQueryState searchBoxQueryState, @Nullable SuggestionTabType suggestionTabType, @Nullable ScopedEntityType scopedEntityType, @Nullable ScopedSearchStyle scopedSearchStyle, boolean z) {
        HoneyClientEvent c = m25539c(str);
        c.b("selected_type", str2);
        c.b("selected_text", (String) typeaheadUnit.a(this.f21994d));
        c.b("selected_input_query", str3);
        c.a("selected_position", SearchAnalyticHelper.m25444a(typeaheadUnit, (ImmutableList) immutableList));
        c.a("selected_is_bootstrap_entity", m25536a(typeaheadUnit));
        c.a("last_state", searchBoxQueryState);
        m25529a(c, scopedSearchStyle);
        m25530a(c, suggestionTabType, scopedEntityType);
        typeaheadUnit.a(c);
        if (z) {
            m25528a(c);
        }
        return c;
    }

    public final void m25547a(String str, List<TypeaheadUnit> list, String str2, boolean z, FetchState fetchState, @Nullable SearchBoxQueryState searchBoxQueryState) {
        HoneyClientEvent a = m25539c("end_see_more").b("selected_input_query", str).b("session_end_reason", "selected_see_more").b("see_more_source", str2).a("last_state", searchBoxQueryState);
        m25538b(a);
        m25528a(a);
        m25531a(a, fetchState);
        m25532a(a, (List) list, z);
        m25543a(str);
    }

    public final void m25548a(String str, List<TypeaheadUnit> list, boolean z, FetchState fetchState, @Nullable SearchBoxQueryState searchBoxQueryState, @Nullable SuggestionTabType suggestionTabType, @Nullable ScopedEntityType scopedEntityType, @Nullable ScopedSearchStyle scopedSearchStyle) {
        HoneyClientEvent a = m25539c("end_back_button").b("selected_input_query", str).b("session_end_reason", "back_press").a("last_state", searchBoxQueryState);
        m25529a(a, scopedSearchStyle);
        m25530a(a, suggestionTabType, scopedEntityType);
        m25538b(a);
        m25528a(a);
        m25531a(a, fetchState);
        m25533a(a, z);
        m25532a(a, (List) list, z);
    }

    public final void m25544a(String str, @Nullable SearchBoxQueryState searchBoxQueryState, @Nullable SuggestionTabType suggestionTabType, @Nullable ScopedEntityType scopedEntityType, @Nullable ScopedSearchStyle scopedSearchStyle) {
        this.f22005o = 0;
        HoneyClientEvent a = m25539c("clear_button").b("selected_input_query", str).a("last_state", searchBoxQueryState);
        m25529a(a, scopedSearchStyle);
        m25530a(a, suggestionTabType, scopedEntityType);
        this.f21992b.c(a);
        a.toString();
        if (BLog.b(3)) {
            a.u();
        }
    }

    public final void m25541a(NullStateSeeMoreTypeaheadUnit nullStateSeeMoreTypeaheadUnit, @Nullable SearchBoxQueryState searchBoxQueryState, @Nullable SuggestionTabType suggestionTabType, @Nullable ScopedEntityType scopedEntityType, @Nullable ScopedSearchStyle scopedSearchStyle) {
        HoneyClientEvent a = m25539c("null_state_see_more").b("null_state_group_type", nullStateSeeMoreTypeaheadUnit.k().toString()).a("last_state", searchBoxQueryState);
        m25529a(a, scopedSearchStyle);
        m25530a(a, suggestionTabType, scopedEntityType);
        this.f21992b.c(a);
        a.toString();
        if (BLog.b(3)) {
            a.u();
        }
    }

    private static void m25529a(HoneyClientEvent honeyClientEvent, @Nullable ScopedSearchStyle scopedSearchStyle) {
        if (scopedSearchStyle != null && scopedSearchStyle == ScopedSearchStyle.TAB) {
            honeyClientEvent.b("typeahead_mode", "scoped_tabbed");
        }
    }

    private static void m25530a(HoneyClientEvent honeyClientEvent, SuggestionTabType suggestionTabType, ScopedEntityType scopedEntityType) {
        if (suggestionTabType == SuggestionTabType.SCOPED) {
            honeyClientEvent.a("filter", scopedEntityType);
        } else {
            honeyClientEvent.b("filter", "global");
        }
    }

    private HoneyClientEvent m25539c(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("click");
        honeyClientEvent.c = "typeahead";
        HoneyClientEvent a = honeyClientEvent.b("typeahead_sid", this.f22002l.b).b("candidate_result_sid", this.f22002l.c).b("action", str).a("keypresses", this.f22004n);
        a.b("network_type", this.f21993c.k());
        a.b("network_subtype", this.f21993c.l());
        a.b("search_type", this.f21997g.a(SearchAbTestGatekeepers.f).asBoolean(false) ? "graph_search" : "simple_search");
        return a;
    }

    private void m25528a(HoneyClientEvent honeyClientEvent) {
        boolean z;
        honeyClientEvent.a("was_bootstrap_loaded_at_click_time", ((BootstrapEntitiesLoader) this.f21995e.get()).c());
        if (((BootstrapEntitiesLoader) this.f21995e.get()).c()) {
            honeyClientEvent.a("bootstrap_load_time", ((BootstrapEntitiesLoader) this.f21995e.get()).d());
        }
        if (((BootstrapEntitiesLoader) this.f21995e.get()).p != GraphSearchError.NO_ERROR) {
            z = true;
        } else {
            z = false;
        }
        if (Boolean.valueOf(z).booleanValue()) {
            honeyClientEvent.b("bootstrap_load_error", ((BootstrapEntitiesLoader) this.f21995e.get()).p.toString());
        }
    }

    private void m25531a(HoneyClientEvent honeyClientEvent, FetchState fetchState) {
        honeyClientEvent.b("fetch_state", fetchState.toString().toLowerCase());
        if (fetchState == FetchState.ERROR && this.f21998h.g != null) {
            honeyClientEvent.b("error_message", this.f21998h.g.getMessage());
        }
    }

    private void m25532a(final HoneyClientEvent honeyClientEvent, final List<TypeaheadUnit> list, final boolean z) {
        Futures.a(this.f21999i.a(new Callable<Pair<ImmutableList<String>, ImmutableList<String>>>(this) {
            final /* synthetic */ SuggestionsTypeaheadAnalyticHelper f21986b;

            public Object call() {
                Builder builder = new Builder();
                Builder builder2 = new Builder();
                for (int i = 0; i < list.size(); i++) {
                    TypeaheadUnit typeaheadUnit = (TypeaheadUnit) list.get(i);
                    if (typeaheadUnit instanceof EntityTypeaheadUnit) {
                        EntityTypeaheadUnit entityTypeaheadUnit = (EntityTypeaheadUnit) typeaheadUnit;
                        if (!entityTypeaheadUnit.f22054j) {
                            builder.c(entityTypeaheadUnit.f22045a);
                        }
                    } else if (typeaheadUnit instanceof KeywordTypeaheadUnit) {
                        KeywordTypeaheadUnit keywordTypeaheadUnit = (KeywordTypeaheadUnit) typeaheadUnit;
                        if (!keywordTypeaheadUnit.f22124m) {
                            builder2.c(keywordTypeaheadUnit.mo1211a());
                        }
                    }
                }
                return Pair.create(((BootstrapDbFetchHelper) this.f21986b.f22001k.get()).a(builder.b()), ((BootstrapDbFetchHelper) this.f21986b.f22001k.get()).b(builder2.b()));
            }
        }), new FutureCallback<Pair<ImmutableList<String>, ImmutableList<String>>>(this) {
            final /* synthetic */ SuggestionsTypeaheadAnalyticHelper f21990d;

            public void onSuccess(Object obj) {
                Pair pair = (Pair) obj;
                this.f21990d.m25535a("suggestions_at_end_of_session", honeyClientEvent, list, z, (ImmutableList) pair.first, (ImmutableList) pair.second);
                this.f21990d.f21992b.a(honeyClientEvent);
                honeyClientEvent.toString();
                if (BLog.b(3)) {
                    honeyClientEvent.u();
                }
            }

            public void onFailure(Throwable th) {
                BLog.b(SuggestionsTypeaheadAnalyticHelper.f21991a, "Couldn't add bootstrap info to logs: %s", new Object[]{th.getMessage()});
            }
        }, this.f22000j);
    }

    private void m25533a(HoneyClientEvent honeyClientEvent, boolean z) {
        if (!this.f22009s.isEmpty()) {
            m25535a("null_state_candidate_results", honeyClientEvent, this.f22009s, z, RegularImmutableList.a, RegularImmutableList.a);
        }
        if (!this.f22010t.isEmpty()) {
            m25535a("single_state_candidate_results", honeyClientEvent, this.f22010t, z, RegularImmutableList.a, RegularImmutableList.a);
        }
        if (!this.f22011u.isEmpty()) {
            m25535a("scoped_singlestate_candidate_results", honeyClientEvent, this.f22011u, z, RegularImmutableList.a, RegularImmutableList.a);
        }
    }

    private void m25535a(String str, HoneyClientEvent honeyClientEvent, List<TypeaheadUnit> list, boolean z, ImmutableList<String> immutableList, ImmutableList<String> immutableList2) {
        this.f22006p = honeyClientEvent;
        this.f22007q = immutableList;
        this.f22008r = immutableList2;
        ArrayNode a = m25446a(list);
        honeyClientEvent.a("megaphone_visible", z);
        honeyClientEvent.a(str, a);
    }

    protected final void mo1203a(ObjectNode objectNode, TypeaheadUnit typeaheadUnit) {
        TypeaheadSuggestionsCache typeaheadSuggestionsCache = (TypeaheadSuggestionsCache) this.f21996f.get();
        if (typeaheadUnit instanceof NullStateModuleUnit) {
            objectNode.a("keyword_source", ((NullStateModuleUnit) typeaheadUnit).mo1223p().name());
        }
        if (typeaheadUnit instanceof GraphSearchQuerySpec) {
            GraphSearchQuerySpec graphSearchQuerySpec = (GraphSearchQuerySpec) typeaheadUnit;
            objectNode.a("result_style_list", graphSearchQuerySpec.mo1215f().toString());
            objectNode.a("semantic", graphSearchQuerySpec.mo1212b());
            objectNode.a("text", graphSearchQuerySpec.mo1211a());
            if (typeaheadUnit instanceof KeywordTypeaheadUnit) {
                KeywordTypeaheadUnit keywordTypeaheadUnit = (KeywordTypeaheadUnit) typeaheadUnit;
                objectNode.a("is_bootstrap_entity", keywordTypeaheadUnit.f22124m);
                objectNode.a("is_mem_cached_entity", typeaheadSuggestionsCache.m25794a(typeaheadUnit));
                objectNode.a("keyword_type", keywordTypeaheadUnit.f22118g.name());
                objectNode.a("fetch_source", keywordTypeaheadUnit.f22122k.name());
                objectNode.a("fetch_mode", keywordTypeaheadUnit.f22123l);
                objectNode.a("type", "keyword");
                objectNode.a("keyword_source", keywordTypeaheadUnit.f22119h);
                if (this.f22008r.contains(keywordTypeaheadUnit.mo1213c())) {
                    objectNode.a("is_failed_bootstrap_entity", Boolean.TRUE.toString());
                }
            } else if (typeaheadUnit instanceof TrendingTypeaheadUnit) {
                objectNode.a("type", "trending");
                objectNode.a("topic_id", ((TrendingTypeaheadUnit) typeaheadUnit).f22295a);
                this.f22006p.b("trending_query_id", ((TrendingTypeaheadUnit) typeaheadUnit).f22302h);
            }
        } else if (typeaheadUnit instanceof NullStateModuleSuggestionUnit) {
            NullStateModuleSuggestionUnit nullStateModuleSuggestionUnit = (NullStateModuleSuggestionUnit) typeaheadUnit;
            objectNode.a("semantic", nullStateModuleSuggestionUnit.f22215h);
            objectNode.a("text", nullStateModuleSuggestionUnit.f22216i);
            objectNode.a("tracking", nullStateModuleSuggestionUnit.f22218k);
            objectNode.a("type", Type.ns_trending.equals(nullStateModuleSuggestionUnit.f22208a) ? "trending" : "keyword");
        } else if (typeaheadUnit instanceof EntityTypeaheadUnit) {
            typeaheadUnit = (EntityTypeaheadUnit) typeaheadUnit;
            SearchAnalyticHelper.m25445a(objectNode, (EntityTypeaheadUnit) typeaheadUnit);
            objectNode.a("is_bootstrap_entity", typeaheadUnit.f22054j);
            objectNode.a("is_mem_cached_entity", typeaheadSuggestionsCache.m25794a(typeaheadUnit));
            objectNode.a("is_phonetic_matched_entity", typeaheadUnit.f22056l);
            objectNode.a("type", typeaheadUnit.f22047c.e().toLowerCase(Locale.getDefault()));
            if (this.f22007q.contains(typeaheadUnit.f22045a)) {
                objectNode.a("is_failed_bootstrap_entity", Boolean.TRUE.toString());
            }
        } else if (typeaheadUnit instanceof NullStateSuggestionTypeaheadUnit) {
            NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit = (NullStateSuggestionTypeaheadUnit) typeaheadUnit;
            objectNode.a("semantic", nullStateSuggestionTypeaheadUnit.f22234a);
            objectNode.a("text", nullStateSuggestionTypeaheadUnit.f22235b);
            objectNode.a("result_style_list", nullStateSuggestionTypeaheadUnit.f22236c.e());
            objectNode.a("type", nullStateSuggestionTypeaheadUnit.f22236c.e().toLowerCase(Locale.getDefault()));
            objectNode.a("is_recent_entity", true);
            if (((NullStateSuggestionTypeaheadUnit) typeaheadUnit).m25717z()) {
                objectNode.a("type", "keyword");
            }
        } else if (typeaheadUnit instanceof ShortcutTypeaheadUnit) {
            ShortcutTypeaheadUnit shortcutTypeaheadUnit = (ShortcutTypeaheadUnit) typeaheadUnit;
            objectNode.a("semantic", shortcutTypeaheadUnit.f22275a);
            objectNode.a("text", shortcutTypeaheadUnit.f22276b);
            objectNode.a("result_style_list", shortcutTypeaheadUnit.f22277c.e());
            objectNode.a("type", shortcutTypeaheadUnit.f22277c.e().toLowerCase(Locale.getDefault()));
            objectNode.a("shortcut_path", shortcutTypeaheadUnit.f22281g.toString());
            objectNode.a("shortcut_fallback_path", shortcutTypeaheadUnit.f22282h.toString());
        } else if (typeaheadUnit instanceof PlaceTipsTypeaheadUnit) {
            String str;
            PlaceTipsTypeaheadUnit placeTipsTypeaheadUnit = (PlaceTipsTypeaheadUnit) typeaheadUnit;
            objectNode.a("semantic", placeTipsTypeaheadUnit.m25720f());
            String str2 = "text";
            if (placeTipsTypeaheadUnit.f22245a == null) {
                str = "";
            } else {
                str = placeTipsTypeaheadUnit.f22245a.m3694h();
            }
            objectNode.a(str2, str);
            objectNode.a("type", "place_tip");
        } else if (typeaheadUnit instanceof NearbyTypeaheadUnit) {
            NearbyTypeaheadUnit nearbyTypeaheadUnit = (NearbyTypeaheadUnit) typeaheadUnit;
            objectNode.a("semantic", SearchQueryFunctions.r(nearbyTypeaheadUnit.f22156a));
            objectNode.a("text", nearbyTypeaheadUnit.f22157b);
            objectNode.a("type", "nearby");
            objectNode.a("local_module_rank", nearbyTypeaheadUnit.f22165j);
        } else {
            this.f21998h.a(GraphSearchError.LOGGING_UNIMPLEMENTED_RESULT_ROW_TYPE, String.format(Locale.US, "Candidate result logging not implemented for TypeaheadUnit of type %s.", new Object[]{typeaheadUnit.getClass().toString()}));
        }
    }

    private void m25538b(HoneyClientEvent honeyClientEvent) {
        if (!Strings.isNullOrEmpty(this.f22003m)) {
            honeyClientEvent.b("navigation_text", this.f22003m);
        }
    }

    private static boolean m25536a(TypeaheadUnit typeaheadUnit) {
        return (typeaheadUnit instanceof EntityTypeaheadUnit) && ((EntityTypeaheadUnit) typeaheadUnit).f22054j;
    }
}
