package com.facebook.search.results.loader.modules;

import android.text.TextUtils;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLModels.DefaultPageInfoFieldsStreamingModel;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLGraphSearchSpellerConfidence;
import com.facebook.graphql.enums.GraphQLSearchAwarenessTemplatesEnum;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPageInfo.Builder;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.logging.SearchResultsPerformanceLogger;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.model.SearchResultsRequestType;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchModuleFragment;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchQuery.FilteredQuery.Modules;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel.ResultsModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchQueryModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchQueryModel.FilteredQueryModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchQueryModel.FilteredQueryModel.ModulesModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchQueryModel.FilteredQueryModel.ModulesModel.EdgesModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.ModuleResultEdgeModel;
import com.facebook.search.quickpromotion.SearchAwarenessController;
import com.facebook.search.quickpromotion.SearchAwarenessSearchResultsUnitController;
import com.facebook.search.results.factory.SearchResultsFeedUnitTypeResolver;
import com.facebook.search.results.factory.SearchResultsFeedUnitTypeResolverProvider;
import com.facebook.search.results.factory.graphsearch.GraphSearchFeedUnitMetaFactory;
import com.facebook.search.results.factory.graphsearch.GraphSearchModulesUtil;
import com.facebook.search.results.model.SearchResults;
import com.facebook.search.results.model.specification.SearchResultsSupportDeclaration;
import com.facebook.search.results.model.unit.SearchResultsAwarenessUnit;
import com.facebook.search.results.model.unit.SearchResultsSpellCorrectionUnit;
import com.facebook.search.results.model.unit.SearchResultsWayfinderUnit;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableList;
import com.google.inject.TypeLiteral;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: SCROLL_TRIGGERED */
public class SearchResultsCollectionGraphQLConverter {
    private static final SearchResults f23252i = new SearchResults(RegularImmutableList.a, null);
    private static final GraphQLSearchAwarenessTemplatesEnum f23253j = GraphQLSearchAwarenessTemplatesEnum.LEARNING_NUX_SERP_SUCCESS;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GraphSearchFeedUnitMetaFactory> f23254a = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SearchAwarenessController> f23255b = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GraphSearchErrorReporter> f23256c = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SearchResultsPerformanceLogger> f23257d = UltralightRuntime.b;
    @Inject
    private QeAccessor f23258e;
    @Inject
    private GatekeeperStoreImpl f23259f;
    private final SearchResultsFeedUnitTypeResolverProvider f23260g;
    @GuardedBy("this")
    private SearchResultsFeedUnitTypeResolver f23261h;
    private boolean f23262k = false;
    private boolean f23263l = false;
    private boolean f23264m = false;

    public static SearchResultsCollectionGraphQLConverter m26961b(InjectorLike injectorLike) {
        SearchResultsCollectionGraphQLConverter searchResultsCollectionGraphQLConverter = new SearchResultsCollectionGraphQLConverter((SearchResultsFeedUnitTypeResolverProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchResultsFeedUnitTypeResolverProvider.class));
        searchResultsCollectionGraphQLConverter.m26960a(IdBasedLazy.a(injectorLike, 10540), IdBasedSingletonScopeProvider.b(injectorLike, 3383), IdBasedSingletonScopeProvider.b(injectorLike, 3374), IdBasedSingletonScopeProvider.b(injectorLike, 10492), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
        return searchResultsCollectionGraphQLConverter;
    }

    public static SearchResultsCollectionGraphQLConverter m26954a(InjectorLike injectorLike) {
        return m26961b(injectorLike);
    }

    @Inject
    public SearchResultsCollectionGraphQLConverter(SearchResultsFeedUnitTypeResolverProvider searchResultsFeedUnitTypeResolverProvider) {
        this.f23260g = searchResultsFeedUnitTypeResolverProvider;
    }

    private void m26960a(com.facebook.inject.Lazy<GraphSearchFeedUnitMetaFactory> lazy, com.facebook.inject.Lazy<SearchAwarenessController> lazy2, com.facebook.inject.Lazy<GraphSearchErrorReporter> lazy3, com.facebook.inject.Lazy<SearchResultsPerformanceLogger> lazy4, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore) {
        this.f23254a = lazy;
        this.f23255b = lazy2;
        this.f23256c = lazy3;
        this.f23257d = lazy4;
        this.f23258e = qeAccessor;
        this.f23259f = gatekeeperStore;
    }

    public final SearchResults m26962a(KeywordSearchQueryModel keywordSearchQueryModel, SearchResultsRequestType searchResultsRequestType, SearchResultsSource searchResultsSource, GraphSearchQuerySpec graphSearchQuerySpec) {
        FilteredQueryModel a = keywordSearchQueryModel.m8635a();
        if (a == null) {
            ((GraphSearchErrorReporter) this.f23256c.get()).a(GraphSearchError.FETCH_KEYWORD_SEARCH_RESULT_DATA_FAIL, "filtered query was null");
            return f23252i;
        }
        ModulesModel c = a.m8589c();
        if (c == null) {
            ((GraphSearchErrorReporter) this.f23256c.get()).a(GraphSearchError.FETCH_KEYWORD_SEARCH_RESULT_DATA_FAIL, "modules was null");
            return f23252i;
        }
        ImmutableList c2 = c.m8573c();
        Builder builder = new Builder();
        DefaultPageInfoFieldsStreamingModel d = c.m8574d();
        if (d == null) {
            builder.a(false);
        } else {
            builder.a(d.b()).b(d.c()).b(d.d()).a(d.a());
        }
        String a2 = a.m8591g() != null ? a.m8591g().m8580a() : null;
        ImmutableList.Builder builder2 = new ImmutableList.Builder();
        builder2.b(m26957a(c, a.jA_()));
        builder2.b(m26955a(graphSearchQuerySpec));
        builder2.b(m26958a(c, a2, searchResultsSource, a.jA_(), graphSearchQuerySpec));
        ImmutableMap.Builder builder3 = new ImmutableMap.Builder();
        ImmutableMap.Builder builder4 = new ImmutableMap.Builder();
        HashSet hashSet = new HashSet();
        int size = c2.size();
        for (int i = 0; i < size; i++) {
            KeywordSearchModuleFragmentModel a3 = ((EdgesModel) c2.get(i)).m8564a();
            if (!(a3 == null || a3.jx_() == null)) {
                ImmutableList a4 = ((GraphSearchFeedUnitMetaFactory) this.f23254a.get()).m26323a(a3);
                builder2.b(a4);
                ((SearchResultsPerformanceLogger) this.f23257d.get()).m25512a(searchResultsRequestType, a3, a4);
                ImmutableList a5 = m26956a(a3);
                int size2 = a5.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) a5.get(i2);
                    if (!hashSet.contains(str)) {
                        builder3.b(str, a3.jx_());
                        if (a3.m8539c() != null) {
                            builder4.b(str, a3.m8539c());
                        }
                        hashSet.add(str);
                    }
                }
            }
        }
        return new SearchResults(m26959a(builder2.b()), builder.a(), builder3.b(), builder4.b());
    }

    public final void m26963a() {
        this.f23262k = false;
        this.f23263l = false;
        this.f23264m = false;
    }

    public final synchronized void m26964b() {
        int i;
        if (this.f23261h == null) {
            int a;
            try {
                TracerDetour.a("Initializing-SearchResultsSupportDeclaration", 644628363);
                i = null;
                a = SearchResultsFeedUnitTypeResolverProvider.m26279a(ImmutableSet.of(SearchResultsSupportDeclaration.f23416J), null);
                this.f23261h = a;
                TracerDetour.a(a);
                i = -1029010422;
                TracerDetour.a("Initializing-FeedUnitMetaFactory", -1029010422);
                a = (GraphSearchFeedUnitMetaFactory) this.f23254a.get();
                a.getClass();
                TracerDetour.a(a);
            } catch (Throwable th) {
                a = th;
                TracerDetour.a(i);
            } finally {
                i = 876139765;
                TracerDetour.a(876139765);
            }
        }
    }

    private synchronized ImmutableList<String> m26956a(KeywordSearchModuleFragment keywordSearchModuleFragment) {
        ImmutableList<String> of;
        m26964b();
        TypeLiteral a = this.f23261h.m26278a(keywordSearchModuleFragment.jx_(), GraphSearchModulesUtil.m26327a(keywordSearchModuleFragment));
        if (a == null || !a.equals(SearchResultsSupportDeclaration.f23416J.f23405d)) {
            of = ImmutableList.of();
        } else {
            ImmutableList.Builder builder = new ImmutableList.Builder();
            ResultsModel g = keywordSearchModuleFragment.m8541g();
            if (g != null) {
                ImmutableList a2 = g.m8515a();
                int size = a2.size();
                for (int i = 0; i < size; i++) {
                    GraphQLNode b = ((ModuleResultEdgeModel) a2.get(i)).m8668b();
                    if (b != null) {
                        String at = b.at();
                        if (at != null) {
                            builder.c(at);
                        }
                    }
                }
            }
            of = builder.b();
        }
        return of;
    }

    private ImmutableList<FeedUnit> m26958a(Modules modules, String str, SearchResultsSource searchResultsSource, String str2, GraphSearchQuerySpec graphSearchQuerySpec) {
        GraphQLGraphSearchSpellerConfidence g = modules.m8575g();
        if (!this.f23262k) {
            Object obj;
            if (searchResultsSource == SearchResultsSource.c || searchResultsSource == SearchResultsSource.e || searchResultsSource == SearchResultsSource.d) {
                obj = 1;
            } else {
                obj = null;
            }
            if (!(obj == null || g == GraphQLGraphSearchSpellerConfidence.NONE || g == GraphQLGraphSearchSpellerConfidence.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || modules.m8570a() == null || modules.m8570a().m8557b() == null)) {
                this.f23262k = true;
                return ImmutableList.of(new SearchResultsSpellCorrectionUnit(g, str, str2, modules.m8570a().m8557b().m8551a(), modules.m8570a().m8556a(), graphSearchQuerySpec));
            }
        }
        return RegularImmutableList.a;
    }

    private ImmutableList<FeedUnit> m26955a(GraphSearchQuerySpec graphSearchQuerySpec) {
        if (!SearchQueryFunctions.d(graphSearchQuerySpec.mo1212b()) || this.f23258e.a(ExperimentsForSearchAbTestModule.l, false) || !this.f23259f.a(SearchAbTestGatekeepers.I, false) || this.f23264m || this.f23263l || TextUtils.isEmpty(graphSearchQuerySpec.mo1211a())) {
            return RegularImmutableList.a;
        }
        this.f23263l = true;
        return ImmutableList.of(new SearchResultsWayfinderUnit(graphSearchQuerySpec));
    }

    private ImmutableList<FeedUnit> m26959a(ImmutableList<FeedUnit> immutableList) {
        if (!this.f23263l || immutableList.size() != 1 || !(immutableList.get(0) instanceof SearchResultsWayfinderUnit)) {
            return immutableList;
        }
        this.f23263l = false;
        return RegularImmutableList.a;
    }

    private ImmutableList<FeedUnit> m26957a(Modules modules, String str) {
        if (!((SearchAwarenessController) this.f23255b.get()).a(f23253j) || !SearchQueryFunctions.d(str)) {
            return RegularImmutableList.a;
        }
        ImmutableList<FeedUnit> of;
        ((SearchAwarenessController) this.f23255b.get()).a(f23253j, ImmutableBiMap.b("browse_session_id", modules.jB_()));
        ((SearchAwarenessController) this.f23255b.get()).a(f23253j, true);
        SearchAwarenessSearchResultsUnitController searchAwarenessSearchResultsUnitController = (SearchAwarenessSearchResultsUnitController) ((SearchAwarenessController) this.f23255b.get()).h.get(GraphQLSearchAwarenessTemplatesEnum.LEARNING_NUX_SERP_SUCCESS);
        if (searchAwarenessSearchResultsUnitController != null) {
            of = ImmutableList.of(new SearchResultsAwarenessUnit(searchAwarenessSearchResultsUnitController.f22415a.f22251a));
        } else {
            of = RegularImmutableList.a;
        }
        ImmutableList<FeedUnit> immutableList = of;
        this.f23264m = !immutableList.isEmpty();
        return immutableList;
    }
}
