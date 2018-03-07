package com.facebook.search.suggestions.simplesearch;

import com.facebook.common.util.StringUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.logging.SuggestionsTypeaheadAnalyticHelper;
import com.facebook.search.model.TypeaheadSuggestionsCache;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.module.TypeaheadDispatchStrategyMethodAutoProvider;
import com.facebook.search.suggestions.BaseSuggestionsTypeaheadController;
import com.facebook.search.suggestions.QueryTextSuggestionFilter;
import com.facebook.search.suggestions.loader.GraphSearchTypeaheadSuggestionDeduper;
import com.facebook.search.typeahead.SearchSynchronousTypeaheadFetchStrategy;
import com.facebook.search.util.GraphSearchConfig;
import com.facebook.search.util.bugreporter.SearchBugReportExtraDataProvider;
import com.facebook.ui.typeahead.BaseTypeaheadController.TypeaheadDispatchStrategy;
import com.facebook.ui.typeahead.CompoundSuggestionFilter;
import com.facebook.ui.typeahead.FetchSource;
import com.facebook.ui.typeahead.MatchType;
import com.facebook.ui.typeahead.NoOpSuggestionFilter;
import com.facebook.ui.typeahead.SearchResponse;
import com.facebook.ui.typeahead.SuggestionFilter;
import com.facebook.ui.typeahead.TypeaheadFetcher;
import com.facebook.ui.typeahead.TypeaheadRequest;
import com.facebook.ui.typeahead.TypeaheadResponse;
import com.facebook.ui.typeahead.TypeaheadSuggestionDeduper;
import com.facebook.ui.typeahead.TypeaheadSuggestionListUtilProvider;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCacheManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap.Builder;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: vnd.android.cursor.dir/raw_contact */
public class SimpleSearchSuggestionsTypeaheadController extends BaseSuggestionsTypeaheadController {
    private final Lazy<QueryTextSuggestionFilter> f284c;
    private final Lazy<VideoScopedSuggestionsFilter> f285d;
    private final TypeaheadFetcher<TypeaheadUnit> f286e;
    private final TypeaheadSuggestionsCache f287f;
    private String f288g;
    private SuggestionsTypeaheadAnalyticHelper f289h;

    public static SimpleSearchSuggestionsTypeaheadController m416b(InjectorLike injectorLike) {
        return new SimpleSearchSuggestionsTypeaheadController(SearchSynchronousTypeaheadFetchStrategy.m524c(injectorLike), IdBasedLazy.a(injectorLike, 10840), IdBasedLazy.a(injectorLike, 10872), LocalTypeaheadFetcher.m370b(injectorLike), IdBasedProvider.a(injectorLike, 10868), IdBasedProvider.a(injectorLike, 10865), SimpleSearchSuggestionTypeaheadQueryCachePolicy.m412c(injectorLike), TypeaheadSuggestionsCache.a(injectorLike), (TypeaheadSuggestionDeduper) GraphSearchTypeaheadSuggestionDeduper.m212a(injectorLike), (TypeaheadSuggestionListUtilProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TypeaheadSuggestionListUtilProvider.class), TypeaheadQueryCacheManager.b(injectorLike), TypeaheadDispatchStrategyMethodAutoProvider.b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), SearchBugReportExtraDataProvider.a(injectorLike));
    }

    @Inject
    public SimpleSearchSuggestionsTypeaheadController(SearchSynchronousTypeaheadFetchStrategy searchSynchronousTypeaheadFetchStrategy, Lazy<QueryTextSuggestionFilter> lazy, Lazy<VideoScopedSuggestionsFilter> lazy2, LocalTypeaheadFetcher localTypeaheadFetcher, Provider<RemoteTypeaheadFetcher> provider, Provider<RemoteCombinedTypeaheadFetcher> provider2, SimpleSearchSuggestionTypeaheadQueryCachePolicy simpleSearchSuggestionTypeaheadQueryCachePolicy, TypeaheadSuggestionsCache typeaheadSuggestionsCache, TypeaheadSuggestionDeduper typeaheadSuggestionDeduper, TypeaheadSuggestionListUtilProvider typeaheadSuggestionListUtilProvider, TypeaheadQueryCacheManager typeaheadQueryCacheManager, TypeaheadDispatchStrategy typeaheadDispatchStrategy, GatekeeperStore gatekeeperStore, SearchBugReportExtraDataProvider searchBugReportExtraDataProvider) {
        super(searchSynchronousTypeaheadFetchStrategy, simpleSearchSuggestionTypeaheadQueryCachePolicy, typeaheadSuggestionDeduper, typeaheadSuggestionListUtilProvider, typeaheadQueryCacheManager, typeaheadDispatchStrategy, searchBugReportExtraDataProvider);
        this.f284c = lazy;
        this.f285d = lazy2;
        typeaheadQueryCacheManager.a(FetchSource.LOCAL, localTypeaheadFetcher.c());
        searchSynchronousTypeaheadFetchStrategy.b(localTypeaheadFetcher);
        if (m415a((GatekeeperStoreImpl) gatekeeperStore)) {
            RemoteCombinedTypeaheadFetcher remoteCombinedTypeaheadFetcher = (RemoteCombinedTypeaheadFetcher) provider2.get();
            remoteCombinedTypeaheadFetcher.m382a(0, 3);
            typeaheadQueryCacheManager.a(remoteCombinedTypeaheadFetcher.m383a());
            searchSynchronousTypeaheadFetchStrategy.m525a(remoteCombinedTypeaheadFetcher);
            this.f286e = remoteCombinedTypeaheadFetcher;
        } else {
            RemoteTypeaheadFetcher remoteTypeaheadFetcher = (RemoteTypeaheadFetcher) provider.get();
            remoteTypeaheadFetcher.m364a(0);
            typeaheadQueryCacheManager.a(FetchSource.REMOTE, remoteTypeaheadFetcher.c());
            searchSynchronousTypeaheadFetchStrategy.a(remoteTypeaheadFetcher);
            this.f286e = remoteTypeaheadFetcher;
        }
        searchSynchronousTypeaheadFetchStrategy.a();
        this.f287f = typeaheadSuggestionsCache;
    }

    private static boolean m415a(GatekeeperStoreImpl gatekeeperStoreImpl) {
        return gatekeeperStoreImpl.a(SearchAbTestGatekeepers.f).asBoolean(false) && !gatekeeperStoreImpl.a(SearchAbTestGatekeepers.x).asBoolean(false);
    }

    public final void m419a(TypeaheadRequest typeaheadRequest) {
        this.f288g = typeaheadRequest.b;
        super.a(typeaheadRequest);
    }

    protected final SuggestionFilter<TypeaheadUnit> m417a(TypeaheadResponse<TypeaheadUnit> typeaheadResponse, String str) {
        Object obj = null;
        Object obj2 = 1;
        boolean a = GraphSearchConfig.a(this.b);
        TypeaheadRequest typeaheadRequest = this.b;
        Object obj3 = null;
        if (!typeaheadResponse.b.b.isEmpty()) {
            int i;
            if (!typeaheadRequest.b.equals(typeaheadResponse.a.b)) {
                i = 1;
            } else if (!(typeaheadResponse.c == FetchSource.REMOTE || (typeaheadResponse.c == FetchSource.MEMORY_CACHE && typeaheadResponse.d == MatchType.EXACT))) {
                i = 1;
            }
        }
        if (obj3 == null) {
            obj2 = null;
        }
        if (!StringUtil.a(str, this.f288g)) {
            obj = obj2;
        }
        if (obj != null && a) {
            return new CompoundSuggestionFilter(ImmutableList.of(this.f284c.get(), this.f285d.get()));
        }
        if (obj != null) {
            return (SuggestionFilter) this.f284c.get();
        }
        if (a) {
            return (SuggestionFilter) this.f285d.get();
        }
        return NoOpSuggestionFilter.a;
    }

    public final void m418a(SuggestionsTypeaheadAnalyticHelper suggestionsTypeaheadAnalyticHelper) {
        this.f289h = suggestionsTypeaheadAnalyticHelper;
        ((TypeaheadSessionHandler) this.f286e).mo38a(suggestionsTypeaheadAnalyticHelper);
    }

    public final void m420a(ImmutableList<TypeaheadUnit> immutableList) {
        this.f287f.a.addAll(immutableList);
    }

    protected final TypeaheadResponse<TypeaheadUnit> m421b(TypeaheadResponse<TypeaheadUnit> typeaheadResponse, String str) {
        if (typeaheadResponse.c == FetchSource.LOCAL) {
            SearchResponse searchResponse = typeaheadResponse.b;
            if (searchResponse.b.size() > 12) {
                typeaheadResponse = new TypeaheadResponse(typeaheadResponse.a, new SearchResponse(searchResponse.b.subList(0, 12), typeaheadResponse.b.c), typeaheadResponse.c, typeaheadResponse.d);
            }
        }
        return super.b(typeaheadResponse, str);
    }

    protected final Builder<String, String> m422f() {
        Builder<String, String> f = super.f();
        if (this.f289h != null) {
            f.b("typeahead_sid", this.f289h.a());
        }
        return f;
    }
}
