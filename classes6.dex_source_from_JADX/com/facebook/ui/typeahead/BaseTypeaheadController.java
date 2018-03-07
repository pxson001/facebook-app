package com.facebook.ui.typeahead;

import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.util.StringUtil;
import com.facebook.search.util.bugreporter.SearchBugReportEvent;
import com.facebook.search.util.bugreporter.SearchBugReportExtraDataProvider;
import com.facebook.ui.typeahead.TypeaheadFetcher.OnSuggestionsFetchedListener;
import com.facebook.ui.typeahead.querycache.DefaultTypeaheadQueryCachePolicy;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCache;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCacheManager;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCacheManager.MergeStrategy;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: creative_editing_in_composer */
public abstract class BaseTypeaheadController<T> implements MemoryTrimmable, OnSuggestionsFetchedListener<T> {
    private static final Class f18387c;
    private static final String f18388d;
    protected T f18389a;
    public TypeaheadRequest f18390b = TypeaheadRequest.f15457a;
    private final SynchronousTypeaheadFetchStrategy f18391e;
    private final DefaultTypeaheadQueryCachePolicy f18392f;
    public final TypeaheadSuggestionListUtil<T> f18393g;
    public final TypeaheadSuggestionDeduper<T> f18394h;
    private final TypeaheadQueryCacheManager f18395i;
    private final DefaultTypeaheadDispatchStrategy f18396j;
    private final SearchBugReportExtraDataProvider f18397k;
    public final Map<T, T> f18398l = Maps.c();
    private final TypeaheadQueryCache<T> f18399m = new TypeaheadQueryCache();
    public OnNewSuggestionsListener<T> f18400n;

    /* compiled from: creative_editing_in_composer */
    public interface OnNewSuggestionsListener<T> {
        void m26974a(TypeaheadResponse<T> typeaheadResponse);
    }

    protected SuggestionFilter<T> m26980a(TypeaheadResponse<T> typeaheadResponse, String str) {
        return NoOpSuggestionFilter.f18411a;
    }

    public SearchResponse<T> m26989b(TypeaheadResponse<T> typeaheadResponse) {
        if (typeaheadResponse.f18439a.mo1224a()) {
            return m26993c((TypeaheadResponse) typeaheadResponse);
        }
        SearchResponse searchResponse;
        TypeaheadResponse a = this.f18399m.m27062a(typeaheadResponse.f18439a.f15459c, this.f18390b.f15458b);
        MatchType matchType = MatchType.EXACT;
        if (!this.f18390b.f15458b.equals(typeaheadResponse.f18439a.f15458b)) {
            matchType = MatchType.PREFIX;
            if (a != null && !a.f18440b.f18413b.isEmpty() && a.f18441c == FetchSource.REMOTE && a.f18442d == MatchType.EXACT) {
                return a.f18440b;
            }
        }
        SearchResponse searchResponse2 = m26995d(typeaheadResponse).f18440b;
        if (a != null) {
            searchResponse = a.f18440b;
        } else {
            searchResponse = SearchResponse.f18412a;
        }
        return m26975a(new TypeaheadResponse(typeaheadResponse.f18439a, this.f18393g.m27054a(searchResponse, searchResponse2, FetchSource.MEMORY_CACHE), typeaheadResponse.f18441c, matchType), this.f18396j.m27025a(typeaheadResponse, searchResponse2, searchResponse, matchType));
    }

    protected ImmutableList<T> m26991b() {
        return RegularImmutableList.a;
    }

    static {
        Class cls = BaseTypeaheadController.class;
        f18387c = cls;
        f18388d = cls.getSimpleName();
    }

    public BaseTypeaheadController(SynchronousTypeaheadFetchStrategy synchronousTypeaheadFetchStrategy, DefaultTypeaheadQueryCachePolicy defaultTypeaheadQueryCachePolicy, TypeaheadSuggestionDeduper typeaheadSuggestionDeduper, TypeaheadSuggestionListUtilProvider typeaheadSuggestionListUtilProvider, TypeaheadQueryCacheManager typeaheadQueryCacheManager, DefaultTypeaheadDispatchStrategy defaultTypeaheadDispatchStrategy, SearchBugReportExtraDataProvider searchBugReportExtraDataProvider) {
        this.f18391e = synchronousTypeaheadFetchStrategy;
        this.f18392f = defaultTypeaheadQueryCachePolicy;
        this.f18394h = typeaheadSuggestionDeduper;
        this.f18393g = TypeaheadSuggestionListUtilProvider.m27056a(this.f18394h);
        this.f18395i = typeaheadQueryCacheManager;
        this.f18391e.f18433h = this;
        this.f18396j = defaultTypeaheadDispatchStrategy;
        this.f18397k = searchBugReportExtraDataProvider;
    }

    protected void m26981a() {
        TypeaheadResponse typeaheadResponse = new TypeaheadResponse(TypeaheadRequest.f15457a, new SearchResponse(m26991b()), FetchSource.NULL_STATE, MatchType.EXACT);
        m26978g(typeaheadResponse);
        m26998e(typeaheadResponse);
    }

    protected TypeaheadResponse<T> m26990b(TypeaheadResponse<T> typeaheadResponse, String str) {
        return typeaheadResponse;
    }

    protected void m26986a(ImmutableList<T> immutableList) {
    }

    public void m26984a(TypeaheadRequest typeaheadRequest) {
        m26992b(typeaheadRequest);
    }

    public boolean m26992b(TypeaheadRequest typeaheadRequest) {
        this.f18390b = typeaheadRequest;
        Object searchResponse = new SearchResponse(RegularImmutableList.a);
        if (StringUtil.c(typeaheadRequest.f15458b)) {
            m26996d();
        } else {
            Object obj;
            searchResponse = m27000g();
            m26986a(searchResponse.f18413b);
            String str = this.f18390b.f15458b;
            ImmutableList immutableList = searchResponse.f18413b;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                immutableList.get(i).toString();
            }
            for (Entry entry : this.f18395i.f18448b.entrySet()) {
                if (((FetchSource) entry.getKey()).isRemote() && ((TypeaheadQueryCache) entry.getValue()).m27065b(typeaheadRequest.f15459c, typeaheadRequest.f15458b)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                m26976a("remote query cache", searchResponse.f18413b.size());
                return false;
            }
            m26976a("local query cache", searchResponse.f18413b.size());
        }
        this.f18391e.m27050a(typeaheadRequest.mo1226c().m23081a(ImmutableBiMap.b("CACHED_RESPONSE", searchResponse)).mo1223a());
        return true;
    }

    public final void m26983a(OnFetchStateChangedListener onFetchStateChangedListener) {
        this.f18391e.f18434i = onFetchStateChangedListener;
    }

    public final String m26994c() {
        return this.f18390b.f15458b;
    }

    public final void m26987a(ImmutableMap<String, String> immutableMap) {
        this.f18391e.m27051a((ImmutableMap) immutableMap);
    }

    public void m26985a(TypeaheadResponse<T> typeaheadResponse) {
        m26976a(typeaheadResponse.f18441c.toString(), typeaheadResponse.f18440b.f18413b.size());
        if (typeaheadResponse.f18441c == FetchSource.REMOTE) {
            Object obj;
            if (typeaheadResponse.f18440b.f18413b.isEmpty()) {
                obj = null;
            } else {
                obj = typeaheadResponse.f18440b.f18413b.get(0);
            }
            this.f18389a = obj;
        }
        if (typeaheadResponse.f18441c == FetchSource.REMOTE || (typeaheadResponse.f18439a.f15458b.equals(this.f18390b.f15458b) && typeaheadResponse.f18441c == FetchSource.LOCAL)) {
            m26989b((TypeaheadResponse) typeaheadResponse);
        }
        if (typeaheadResponse.f18441c == FetchSource.REMOTE) {
            ImmutableList immutableList = typeaheadResponse.f18440b.f18413b;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                Object obj2 = immutableList.get(i);
                this.f18398l.put(obj2, obj2);
            }
        }
    }

    public void m26996d() {
        m26987a(m26999f().b());
        m26981a();
        if (this.f18392f.m27058a()) {
            m26979h();
        }
    }

    public void m26997e() {
    }

    public void m26988a(boolean z) {
    }

    protected Builder<String, String> m26999f() {
        return ImmutableMap.builder();
    }

    public void m26982a(MemoryTrimType memoryTrimType) {
        if (this.f18392f.m27059a(memoryTrimType)) {
            m26979h();
        }
    }

    protected SearchResponse<T> m27000g() {
        return m26989b(m26977c(this.f18390b));
    }

    private TypeaheadResponse<T> m26977c(TypeaheadRequest typeaheadRequest) {
        List<TypeaheadResponse> a = this.f18395i.m27070a(typeaheadRequest);
        DefaultTypeaheadDispatchStrategy defaultTypeaheadDispatchStrategy = this.f18396j;
        MergeStrategy mergeStrategy = MergeStrategy.APPEND;
        SearchResponse searchResponse = SearchResponse.f18412a;
        SearchResponse searchResponse2 = searchResponse;
        for (TypeaheadResponse d : a) {
            TypeaheadResponse d2 = m26995d(d2);
            TypeaheadSuggestionListUtil typeaheadSuggestionListUtil;
            switch (mergeStrategy) {
                case PREPEND:
                    typeaheadSuggestionListUtil = this.f18393g;
                    if (d2 != null) {
                        searchResponse = d2.f18440b;
                    } else {
                        searchResponse = null;
                    }
                    searchResponse2 = typeaheadSuggestionListUtil.m27055b(searchResponse2, searchResponse, FetchSource.MEMORY_CACHE);
                    break;
                case APPEND:
                    typeaheadSuggestionListUtil = this.f18393g;
                    if (d2 != null) {
                        searchResponse = d2.f18440b;
                    } else {
                        searchResponse = null;
                    }
                    searchResponse2 = typeaheadSuggestionListUtil.m27054a(searchResponse2, searchResponse, FetchSource.MEMORY_CACHE);
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported merge strategy.");
            }
        }
        return new TypeaheadResponse(typeaheadRequest, searchResponse2, FetchSource.MEMORY_CACHE, MatchType.EXACT);
    }

    protected SearchResponse<T> m26993c(TypeaheadResponse<T> typeaheadResponse) {
        return m26975a((TypeaheadResponse) typeaheadResponse, null);
    }

    private SearchResponse<T> m26975a(TypeaheadResponse<T> typeaheadResponse, @Nullable TypeaheadResponse<T> typeaheadResponse2) {
        TypeaheadResponse b = m26990b(typeaheadResponse, this.f18390b.f15458b);
        m26978g(typeaheadResponse2 == null ? b : m26990b(typeaheadResponse2, this.f18390b.f15458b));
        m26998e(b);
        return b.f18440b;
    }

    protected TypeaheadResponse<T> m26995d(TypeaheadResponse<T> typeaheadResponse) {
        return new TypeaheadResponse(typeaheadResponse.f18439a, SearchResponse.m27031a(typeaheadResponse.f18440b, m26980a((TypeaheadResponse) typeaheadResponse, this.f18390b.f15458b).mo1390a(typeaheadResponse, this.f18390b.f15458b)), typeaheadResponse.f18441c, MatchType.EXACT);
    }

    protected void m26998e(TypeaheadResponse<T> typeaheadResponse) {
        if (this.f18400n != null) {
            OnNewSuggestionsListener onNewSuggestionsListener = this.f18400n;
            SearchResponse searchResponse = typeaheadResponse.f18440b;
            ImmutableList.Builder builder = new ImmutableList.Builder();
            ImmutableList immutableList = searchResponse.f18413b;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                Object obj = immutableList.get(i);
                Object obj2 = this.f18398l.get(obj);
                if (obj2 == null) {
                    builder.c(obj);
                } else {
                    builder.c(this.f18394h.mo1397a(obj, obj2, FetchSource.MEMORY_CACHE));
                }
            }
            onNewSuggestionsListener.m26974a(new TypeaheadResponse(typeaheadResponse.f18439a, SearchResponse.m27031a(searchResponse, builder.b()), typeaheadResponse.f18441c, typeaheadResponse.f18442d));
        }
    }

    private void m26978g(TypeaheadResponse<T> typeaheadResponse) {
        this.f18399m.m27064a(typeaheadResponse.f18439a.f15459c, this.f18390b.f15458b, typeaheadResponse);
    }

    private void m26979h() {
        this.f18398l.clear();
    }

    private void m26976a(String str, int i) {
        if (i > 0) {
            this.f18397k.a(f18388d, SearchBugReportEvent.TYPEAHEAD_UNITS_LOADED, "Source: " + str + ", Num: " + i);
        }
    }
}
