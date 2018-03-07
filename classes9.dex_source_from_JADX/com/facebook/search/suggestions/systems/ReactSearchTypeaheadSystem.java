package com.facebook.search.suggestions.systems;

import android.os.Bundle;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ModifierKeys;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit.Source;
import com.facebook.search.model.SearchBoxQueryState;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.search.typeahead.TypeaheadUnitCollection;
import com.facebook.search.util.GraphSearchConfig;
import com.facebook.ui.typeahead.FetchState;
import com.facebook.ui.typeahead.SearchResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import javax.inject.Inject;

/* compiled from: viewerDidComment() not supported yet */
public class ReactSearchTypeaheadSystem implements SearchTypeaheadSystem {
    public final GraphSearchTitleSearchBoxSupplier f311a;
    public Bundle f312b = new Bundle();

    @Inject
    public ReactSearchTypeaheadSystem(GraphSearchTitleSearchBoxSupplier graphSearchTitleSearchBoxSupplier) {
        this.f311a = graphSearchTitleSearchBoxSupplier;
    }

    public final ImmutableList<TypeaheadUnit> mo44a(GraphSearchQuery graphSearchQuery, SearchResponse<TypeaheadUnit> searchResponse, TypeaheadUnit typeaheadUnit, FetchState fetchState) {
        return null;
    }

    public final void mo40a() {
    }

    public final SearchBoxQueryState mo42b() {
        return null;
    }

    public final boolean mo41a(GraphSearchQuery graphSearchQuery, TypeaheadUnitCollection typeaheadUnitCollection) {
        return false;
    }

    public final TypeaheadUnit mo43a(GraphSearchQuery graphSearchQuery) {
        String str;
        if (this.f311a.a == null || this.f311a.a.e == null) {
            str = "";
        } else {
            str = this.f311a.a.e.getText().toString();
        }
        String trim = str.trim();
        ImmutableMap immutableMap = graphSearchQuery.k;
        Builder builder = ImmutableMap.builder();
        builder.b(ModifierKeys.MARKETPLACE, this.f312b);
        KeywordTypeaheadUnit.Builder builder2 = new KeywordTypeaheadUnit.Builder();
        builder2.b = trim;
        builder2 = builder2;
        builder2.d = trim;
        KeywordTypeaheadUnit.Builder builder3 = builder2;
        builder3.e = "scoped";
        builder3 = builder3;
        builder3.f = ExactMatchInputExactMatch.FALSE;
        builder3 = builder3;
        builder3.k = Source.SEARCH_BUTTON;
        builder3 = builder3;
        builder3.v = GraphSearchConfig.a(graphSearchQuery);
        builder3 = builder3;
        builder3.w = builder.b();
        builder3 = builder3.a(graphSearchQuery.f, graphSearchQuery.g, graphSearchQuery.h);
        builder3.c = "";
        return builder3.b();
    }
}
