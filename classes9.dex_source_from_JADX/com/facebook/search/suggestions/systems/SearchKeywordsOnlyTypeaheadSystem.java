package com.facebook.search.suggestions.systems;

import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit.Builder;
import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import com.facebook.search.model.KeywordTypeaheadUnit.Source;
import com.facebook.search.model.SearchBoxQueryState;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.search.typeahead.TypeaheadUnitCollection;
import com.facebook.ui.typeahead.FetchState;
import com.facebook.ui.typeahead.SearchResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.LinkedHashMultimap;
import javax.inject.Inject;

/* compiled from: viewer() {primary_email} */
public class SearchKeywordsOnlyTypeaheadSystem implements SearchTypeaheadSystem {
    public final GraphSearchTitleSearchBoxSupplier f319a;
    private final int f320b;

    @Inject
    public SearchKeywordsOnlyTypeaheadSystem(GraphSearchTitleSearchBoxSupplier graphSearchTitleSearchBoxSupplier, QeAccessor qeAccessor) {
        this.f319a = graphSearchTitleSearchBoxSupplier;
        this.f320b = qeAccessor.a(ExperimentsForSearchAbTestModule.z, 6);
    }

    public final ImmutableList<TypeaheadUnit> mo44a(GraphSearchQuery graphSearchQuery, SearchResponse<TypeaheadUnit> searchResponse, TypeaheadUnit typeaheadUnit, FetchState fetchState) {
        LinkedHashMultimap u = LinkedHashMultimap.u();
        ImmutableList immutableList = searchResponse.b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            TypeaheadUnit typeaheadUnit2 = (TypeaheadUnit) immutableList.get(i);
            if (typeaheadUnit2 instanceof KeywordTypeaheadUnit) {
                Builder a = Builder.a((KeywordTypeaheadUnit) typeaheadUnit2);
                a.g = KeywordType.keyword;
                u.a(((KeywordTypeaheadUnit) typeaheadUnit2).a(), a.b());
            } else if (typeaheadUnit2 instanceof EntityTypeaheadUnit) {
                String toLowerCase = ((EntityTypeaheadUnit) typeaheadUnit2).b.toLowerCase();
                Builder a2 = Builder.a(((EntityTypeaheadUnit) typeaheadUnit2).b.toLowerCase(), Source.SUGGESTION);
                a2.g = KeywordType.keyword;
                u.a(toLowerCase, a2.b());
            }
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int i2 = 0;
        for (TypeaheadUnit typeaheadUnit22 : u.i()) {
            if (i2 == this.f320b) {
                break;
            }
            builder.c(typeaheadUnit22);
            i2++;
        }
        Builder a3 = Builder.a(this.f319a.c(), Source.ESCAPE);
        a3.g = KeywordType.escape;
        builder.c(a3.b());
        return builder.b();
    }

    public final TypeaheadUnit mo43a(GraphSearchQuery graphSearchQuery) {
        return Builder.a(this.f319a.c(), Source.SEARCH_BUTTON).b();
    }

    public final void mo40a() {
    }

    public final SearchBoxQueryState mo42b() {
        return SearchBoxQueryState.TYPED;
    }

    public final boolean mo41a(GraphSearchQuery graphSearchQuery, TypeaheadUnitCollection typeaheadUnitCollection) {
        return false;
    }
}
