package com.facebook.search.results.filters.controller;

import com.facebook.inject.Assisted;
import com.facebook.search.model.NeedleFilter;
import com.facebook.search.results.filters.loader.FilterValueLoader;
import com.facebook.search.results.filters.loader.OnFilterValuesFetchedListener;
import com.facebook.search.results.filters.model.QueryCache;
import com.facebook.search.results.protocol.filters.FilterValue;
import com.facebook.ui.typeahead.FetchSource;
import com.facebook.ui.typeahead.MatchType;
import com.facebook.ui.typeahead.SearchResponse;
import com.facebook.ui.typeahead.TypeaheadRequest;
import com.facebook.ui.typeahead.TypeaheadResponse;
import com.facebook.ui.typeahead.TypeaheadSuggestionListUtil;
import com.facebook.ui.typeahead.TypeaheadSuggestionListUtilProvider;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: SOURCE_IMAGE */
public class FilterValueSearchController {
    public static final SearchResponse<FilterValue> f22772a = new SearchResponse(RegularImmutableList.a);
    public final FilterValueLoader f22773b;
    public final Map<String, QueryCache<FilterValue>> f22774c = new HashMap();
    public final Map<String, String> f22775d = new HashMap();
    public final Set<String> f22776e = new HashSet();
    public final OnFilterValuesFetchedListener f22777f;
    public final TypeaheadSuggestionListUtil<FilterValue> f22778g;
    public NeedleFilter f22779h;
    public String f22780i = "";

    /* compiled from: SOURCE_IMAGE */
    public class FilterValuesListener implements OnFilterValuesFetchedListener {
        final /* synthetic */ FilterValueSearchController f22771a;

        public FilterValuesListener(FilterValueSearchController filterValueSearchController) {
            this.f22771a = filterValueSearchController;
        }

        public final void mo1270a(String str, String str2, String str3, SearchResponse<FilterValue> searchResponse) {
            FilterValueSearchController filterValueSearchController = this.f22771a;
            if (!filterValueSearchController.f22774c.containsKey(str3)) {
                filterValueSearchController.f22774c.put(str3, new QueryCache());
            }
            QueryCache queryCache = (QueryCache) filterValueSearchController.f22774c.get(str3);
            FilterValueSearchController.m26415a(this.f22771a, queryCache, str2, searchResponse);
            this.f22771a.f22775d.put(str3, str);
            this.f22771a.f22776e.remove(str2);
            if (this.f22771a.f22780i.equals(str2)) {
                FilterValueSearchController.m26416a(this.f22771a, queryCache.m26511a(str2).b);
            } else if (this.f22771a.f22780i.startsWith(str2)) {
                TypeaheadResponse b = queryCache.m26513b(this.f22771a.f22780i);
                FilterValueSearchController.m26416a(this.f22771a, this.f22771a.f22778g.a(b != null ? FilterValueSearchController.m26417b(this.f22771a.f22780i, b) : FilterValueSearchController.f22772a, new SearchResponse(FilterValueSearchController.m26418b(this.f22771a.f22780i, (List) searchResponse.b), searchResponse.c), FetchSource.UNSET));
            }
        }

        public final void mo1269a(String str) {
            this.f22771a.f22777f.mo1269a(str);
            this.f22771a.f22776e.remove(str);
        }

        public final void mo1271b(String str) {
            this.f22771a.f22777f.mo1271b(str);
            this.f22771a.f22776e.remove(str);
        }
    }

    public static SearchResponse<FilterValue> m26417b(String str, TypeaheadResponse<FilterValue> typeaheadResponse) {
        if (typeaheadResponse.a.b.equals(str)) {
            return typeaheadResponse.b;
        }
        return new SearchResponse(m26418b(str, (List) typeaheadResponse.b.b), typeaheadResponse.b.c);
    }

    @Inject
    public FilterValueSearchController(@Assisted OnFilterValuesFetchedListener onFilterValuesFetchedListener, FilterValueLoader filterValueLoader, FilterValueSuggestionDeduper filterValueSuggestionDeduper, TypeaheadSuggestionListUtilProvider typeaheadSuggestionListUtilProvider) {
        this.f22777f = onFilterValuesFetchedListener;
        this.f22773b = filterValueLoader;
        this.f22778g = TypeaheadSuggestionListUtilProvider.a(filterValueSuggestionDeduper);
        this.f22773b.f22857f = new FilterValuesListener(this);
    }

    public final void m26420a(String str) {
        boolean z;
        Object obj;
        this.f22780i = m26419e(str);
        if (Strings.isNullOrEmpty(this.f22779h.f22171a)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z);
        String str2 = this.f22780i;
        TypeaheadResponse typeaheadResponse = null;
        if (this.f22774c.containsKey(this.f22779h.f22172b)) {
            typeaheadResponse = ((QueryCache) this.f22774c.get(this.f22779h.f22172b)).m26513b(str2);
        }
        if (typeaheadResponse == null) {
            m26416a(this, f22772a);
        } else {
            m26416a(this, m26417b(str2, typeaheadResponse));
        }
        if (typeaheadResponse == null || !typeaheadResponse.a.b.equals(str2)) {
            obj = 1;
        } else {
            obj = null;
        }
        Object obj2 = obj;
        if (!this.f22776e.contains(this.f22780i) && obj2 != null) {
            this.f22776e.add(this.f22780i);
            this.f22773b.m26509a(this.f22779h.f22171a, this.f22780i, this.f22779h.f22172b, 12);
        }
    }

    public static ImmutableList<FilterValue> m26418b(String str, List<FilterValue> list) {
        Builder builder = ImmutableList.builder();
        for (FilterValue filterValue : list) {
            if (!filterValue.f8692d && m26419e(filterValue.f8689a).startsWith(str)) {
                builder.c(filterValue);
            }
        }
        return builder.b();
    }

    public static void m26416a(FilterValueSearchController filterValueSearchController, SearchResponse searchResponse) {
        filterValueSearchController.f22777f.mo1270a(filterValueSearchController.f22779h.f22171a, filterValueSearchController.f22780i, filterValueSearchController.f22779h.f22172b, searchResponse);
    }

    public static void m26415a(FilterValueSearchController filterValueSearchController, QueryCache queryCache, String str, SearchResponse searchResponse) {
        SearchResponse searchResponse2;
        TypeaheadResponse b = queryCache.m26513b(str);
        if (b == null) {
            searchResponse2 = f22772a;
        } else {
            searchResponse2 = new SearchResponse(m26418b(str, (List) b.b.b), b.b.c);
        }
        queryCache.m26512a(str, new TypeaheadResponse(new TypeaheadRequest(str), filterValueSearchController.f22778g.a(searchResponse2, searchResponse, FetchSource.UNSET), FetchSource.UNSET, MatchType.EXACT));
        for (String str2 : queryCache.f22858a.keySet()) {
            if (str2.startsWith(str) && !str2.equals(str)) {
                SearchResponse searchResponse3 = queryCache.m26511a(str2).b;
                queryCache.m26512a(str2, new TypeaheadResponse(new TypeaheadRequest(str2), filterValueSearchController.f22778g.a(searchResponse3, new SearchResponse(m26418b(str2, (List) searchResponse.b), searchResponse3.c), FetchSource.UNSET), FetchSource.UNSET, MatchType.EXACT));
            }
        }
    }

    private static String m26419e(String str) {
        return str.toLowerCase(Locale.getDefault()).trim();
    }
}
