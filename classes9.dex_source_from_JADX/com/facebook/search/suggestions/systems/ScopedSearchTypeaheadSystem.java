package com.facebook.search.suggestions.systems;

import android.content.res.Resources;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit.Source;
import com.facebook.search.model.SuggestionGroup;
import com.facebook.search.model.SuggestionGroup.Type;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.search.suggestions.SuggestionsListRowItemFactory;
import com.facebook.search.util.GraphSearchConfig;
import com.facebook.ui.typeahead.FetchState;
import com.facebook.ui.typeahead.SearchResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: viewerCanEnable */
public class ScopedSearchTypeaheadSystem extends BaseSearchTypeaheadSystem {
    private final Resources f313a;
    private final SuggestionsListRowItemFactory f314b;
    private final GraphSearchTitleSearchBoxSupplier f315c;

    @Inject
    public ScopedSearchTypeaheadSystem(Resources resources, SuggestionsListRowItemFactory suggestionsListRowItemFactory, GraphSearchTitleSearchBoxSupplier graphSearchTitleSearchBoxSupplier) {
        this.f313a = resources;
        this.f314b = suggestionsListRowItemFactory;
        this.f315c = graphSearchTitleSearchBoxSupplier;
    }

    public final ImmutableList<TypeaheadUnit> mo44a(GraphSearchQuery graphSearchQuery, SearchResponse<TypeaheadUnit> searchResponse, TypeaheadUnit typeaheadUnit, FetchState fetchState) {
        Builder builder = new Builder();
        String toLowerCase = m463c().trim().toLowerCase(Locale.getDefault());
        ImmutableList immutableList = searchResponse.b;
        int size = immutableList.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            TypeaheadUnit typeaheadUnit2 = (TypeaheadUnit) immutableList.get(i);
            builder.c(typeaheadUnit2);
            if (obj == null && (typeaheadUnit2 instanceof KeywordTypeaheadUnit) && ((KeywordTypeaheadUnit) typeaheadUnit2).a().trim().equalsIgnoreCase(toLowerCase)) {
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
        if (obj == null) {
            builder.c(m462a(graphSearchQuery, Source.ECHO, toLowerCase));
        }
        SuggestionGroup.Builder builder2 = new SuggestionGroup.Builder();
        builder2.b = builder.b();
        builder2 = builder2;
        builder2.a = Type.KEYWORD;
        builder2 = builder2;
        if (graphSearchQuery.h != ScopedEntityType.VIDEO) {
            builder2.c = this.f313a.getString(2131237425);
        }
        return SuggestionsListRowItemFactory.b(ImmutableList.of(builder2.a()));
    }

    public final TypeaheadUnit mo43a(GraphSearchQuery graphSearchQuery) {
        return m462a(graphSearchQuery, Source.SEARCH_BUTTON, m463c().trim());
    }

    private static KeywordTypeaheadUnit m462a(GraphSearchQuery graphSearchQuery, Source source, String str) {
        KeywordTypeaheadUnit.Builder builder = new KeywordTypeaheadUnit.Builder();
        builder.b = str;
        builder = builder;
        builder.d = str;
        builder = builder;
        builder.e = "scoped";
        builder = builder;
        builder.f = ExactMatchInputExactMatch.FALSE;
        builder = builder;
        builder.k = source;
        builder = builder;
        builder.v = GraphSearchConfig.a(graphSearchQuery);
        builder = builder;
        builder.w = graphSearchQuery.k;
        builder = builder.a(graphSearchQuery.f, graphSearchQuery.g, graphSearchQuery.h);
        builder.c = SearchQueryFunctions.a(graphSearchQuery.h, str, graphSearchQuery.f, graphSearchQuery.k);
        return builder.b();
    }

    private String m463c() {
        if (this.f315c.a == null || this.f315c.a.e == null) {
            return "";
        }
        return this.f315c.a.e.getText().toString();
    }
}
