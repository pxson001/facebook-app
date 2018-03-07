package com.facebook.search.suggestions.systems;

import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit.Builder;
import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import com.facebook.search.model.KeywordTypeaheadUnit.Source;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.ui.typeahead.FetchState;
import com.facebook.ui.typeahead.SearchResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.LinkedHashMultimap;
import javax.inject.Inject;

/* compiled from: viewer(){peer_to_peer_payment_pin{id}} */
public class SearchKeywordsEntitiesTypeaheadSystem extends BaseSearchTypeaheadSystem {
    public final GraphSearchTitleSearchBoxSupplier f316a;
    public final int f317b;
    public final int f318c;

    @Inject
    public SearchKeywordsEntitiesTypeaheadSystem(GraphSearchTitleSearchBoxSupplier graphSearchTitleSearchBoxSupplier, QeAccessor qeAccessor) {
        this.f316a = graphSearchTitleSearchBoxSupplier;
        this.f317b = qeAccessor.a(ExperimentsForSearchAbTestModule.z, 6);
        this.f318c = qeAccessor.a(ExperimentsForSearchAbTestModule.k, 2);
    }

    public final ImmutableList<TypeaheadUnit> mo44a(GraphSearchQuery graphSearchQuery, SearchResponse<TypeaheadUnit> searchResponse, TypeaheadUnit typeaheadUnit, FetchState fetchState) {
        LinkedHashMultimap u = LinkedHashMultimap.u();
        LinkedHashMultimap u2 = LinkedHashMultimap.u();
        ImmutableList immutableList = searchResponse.b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            TypeaheadUnit typeaheadUnit2 = (TypeaheadUnit) immutableList.get(i);
            if (typeaheadUnit2 instanceof KeywordTypeaheadUnit) {
                Builder a = Builder.a((KeywordTypeaheadUnit) typeaheadUnit2);
                a.g = KeywordType.keyword;
                u.a(((KeywordTypeaheadUnit) typeaheadUnit2).a(), a.b());
            } else if ((typeaheadUnit2 instanceof EntityTypeaheadUnit) && ((EntityTypeaheadUnit) typeaheadUnit2).j && u2.f() < this.f318c) {
                u2.a(((EntityTypeaheadUnit) typeaheadUnit2).b.toLowerCase(), typeaheadUnit2);
            } else if (typeaheadUnit2 instanceof EntityTypeaheadUnit) {
                String toLowerCase = ((EntityTypeaheadUnit) typeaheadUnit2).b.toLowerCase();
                Builder a2 = Builder.a(((EntityTypeaheadUnit) typeaheadUnit2).b.toLowerCase(), Source.SUGGESTION);
                a2.g = KeywordType.keyword;
                u.a(toLowerCase, a2.b());
            }
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int i2 = 0;
        for (KeywordTypeaheadUnit keywordTypeaheadUnit : u.i()) {
            if (i2 == this.f317b - u2.i().size()) {
                break;
            } else if (!u2.f(keywordTypeaheadUnit.a())) {
                builder.c(keywordTypeaheadUnit);
                i2++;
            }
        }
        builder.b(u2.i());
        builder.c(m466c());
        return builder.b();
    }

    public final TypeaheadUnit mo43a(GraphSearchQuery graphSearchQuery) {
        return Builder.a(this.f316a.c(), Source.SEARCH_BUTTON).b();
    }

    private TypeaheadUnit m466c() {
        Builder a = Builder.a(this.f316a.c(), Source.ESCAPE);
        a.g = KeywordType.escape;
        return a.b();
    }
}
