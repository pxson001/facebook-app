package com.facebook.search.results.loader.modules;

import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchQuery.SearchPivots;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchQueryModel.SearchPivotsModel;
import com.facebook.search.results.model.SearchResults;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsInterfaces.SearchResultPageMainFilterFragment.MainFilter;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: SCROLL_FOCUSED_VIEW_TO_RECT */
public class C2510x73e72fcc {
    private final SearchResults f23286a;
    @Nullable
    private final String f23287b;
    @Nullable
    private final String f23288c;
    @Nullable
    private final String f23289d;
    private final String f23290e;
    private final boolean f23291f;
    private final SearchPivotsModel f23292g;
    @Nullable
    private final ImmutableList<? extends MainFilter> f23293h;

    public C2510x73e72fcc(SearchResults searchResults, String str, String str2, String str3, String str4, boolean z, SearchPivots searchPivots, ImmutableList<? extends MainFilter> immutableList) {
        this.f23293h = immutableList;
        this.f23292g = searchPivots;
        this.f23291f = z;
        this.f23290e = str4;
        this.f23289d = str3;
        this.f23288c = str2;
        this.f23287b = str;
        this.f23286a = searchResults;
    }

    public final SearchResults m26974a() {
        return this.f23286a;
    }

    @Nullable
    public final String m26975b() {
        return this.f23287b;
    }

    @Nullable
    public final String m26976c() {
        return this.f23288c;
    }

    @Nullable
    public final String m26977d() {
        return this.f23289d;
    }

    public final String m26978e() {
        return this.f23290e;
    }

    public final boolean m26979f() {
        return this.f23291f;
    }

    public final SearchPivotsModel m26980g() {
        return this.f23292g;
    }

    @Nullable
    public final ImmutableList<? extends MainFilter> m26981h() {
        return this.f23293h;
    }
}
