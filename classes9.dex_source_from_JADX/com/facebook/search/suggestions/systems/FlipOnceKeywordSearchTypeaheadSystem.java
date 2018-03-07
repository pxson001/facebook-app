package com.facebook.search.suggestions.systems;

import android.content.res.Resources;
import com.facebook.common.locale.Locales;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import com.facebook.search.model.KeywordTypeaheadUnit.Source;
import com.facebook.search.model.SuggestionGroup;
import com.facebook.search.model.SuggestionGroup.Type;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.search.suggestions.SuggestionsListRowItemFactory;
import com.facebook.search.suggestions.model.DividerTypeaheadUnit;
import com.facebook.ui.typeahead.FetchState;
import com.facebook.ui.typeahead.SearchResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: viewinmoments */
public class FlipOnceKeywordSearchTypeaheadSystem extends BaseSearchTypeaheadSystem {
    private final Resources f290a;
    private final SuggestionsListRowItemFactory f291b;
    private final GraphSearchTitleSearchBoxSupplier f292c;
    private final Locales f293d;
    private Type f294e = Type.NO_GROUP;
    private Type f295f;

    @Inject
    public FlipOnceKeywordSearchTypeaheadSystem(Resources resources, SuggestionsListRowItemFactory suggestionsListRowItemFactory, GraphSearchTitleSearchBoxSupplier graphSearchTitleSearchBoxSupplier, Locales locales) {
        this.f290a = resources;
        this.f291b = suggestionsListRowItemFactory;
        this.f292c = graphSearchTitleSearchBoxSupplier;
        this.f293d = locales;
    }

    public final ImmutableList<TypeaheadUnit> mo44a(GraphSearchQuery graphSearchQuery, SearchResponse<TypeaheadUnit> searchResponse, TypeaheadUnit typeaheadUnit, FetchState fetchState) {
        Map linkedHashMap = new LinkedHashMap();
        String toLowerCase = this.f292c.c().trim().toLowerCase(this.f293d.a());
        if (this.f295f != null && typeaheadUnit != null && this.f295f.equals(Type.ENTITY) && typeaheadUnit.k().equals(Type.KEYWORD)) {
            this.f294e = typeaheadUnit.k();
        }
        if (!this.f294e.equals(Type.NO_GROUP)) {
            linkedHashMap.put(this.f294e, new Builder());
        }
        ImmutableList immutableList = searchResponse.b;
        int size = immutableList.size();
        Object obj = null;
        for (int i = 0; i < size; i++) {
            TypeaheadUnit typeaheadUnit2 = (TypeaheadUnit) immutableList.get(i);
            if (!typeaheadUnit2.y()) {
                Type k = typeaheadUnit2.k();
                if (!linkedHashMap.containsKey(k)) {
                    linkedHashMap.put(k, new Builder());
                }
                if (obj == null && k.equals(Type.KEYWORD) && ((KeywordTypeaheadUnit) typeaheadUnit2).a().trim().equalsIgnoreCase(toLowerCase)) {
                    obj = 1;
                } else if (obj != null && k.equals(Type.KEYWORD) && ((KeywordTypeaheadUnit) typeaheadUnit2).a().trim().equalsIgnoreCase(toLowerCase)) {
                    if (((KeywordTypeaheadUnit) typeaheadUnit2).o().equals(KeywordType.keyword)) {
                    }
                }
                ((Builder) linkedHashMap.get(k)).c(typeaheadUnit2);
            }
        }
        if (obj == null) {
            if (!linkedHashMap.containsKey(Type.KEYWORD)) {
                linkedHashMap.put(Type.KEYWORD, new Builder());
            }
            ((Builder) linkedHashMap.get(Type.KEYWORD)).c(m432a(Source.ECHO, toLowerCase));
        }
        Builder builder = new Builder();
        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            Type type = (Type) it.next();
            SuggestionGroup.Builder builder2 = new SuggestionGroup.Builder();
            builder2.a = type;
            builder2 = builder2;
            builder2.b = ((Builder) linkedHashMap.get(type)).b();
            builder.c(builder2.a());
            if (it.hasNext()) {
                SuggestionGroup.Builder builder3 = new SuggestionGroup.Builder();
                builder3.a = Type.NO_GROUP;
                builder3 = builder3;
                builder3.b = ImmutableList.of(DividerTypeaheadUnit.m298f());
                builder.c(builder3.a());
            }
        }
        if (linkedHashMap.keySet().iterator().hasNext()) {
            this.f295f = (Type) linkedHashMap.keySet().iterator().next();
        }
        return this.f291b.a(builder.b());
    }

    public final TypeaheadUnit mo43a(GraphSearchQuery graphSearchQuery) {
        return m432a(Source.SEARCH_BUTTON, this.f292c.c().trim());
    }

    private KeywordTypeaheadUnit m432a(Source source, String str) {
        KeywordTypeaheadUnit.Builder builder = new KeywordTypeaheadUnit.Builder();
        builder.b = str;
        builder = builder;
        builder.r = this.f290a.getString(2131237499);
        builder = builder;
        builder.d = str;
        builder = builder;
        builder.e = "content";
        builder = builder;
        builder.f = ExactMatchInputExactMatch.FALSE;
        builder = builder;
        builder.k = source;
        builder = builder;
        builder.c = SearchQueryFunctions.o(str);
        return builder.b();
    }
}
