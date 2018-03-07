package com.facebook.search.suggestions.systems;

import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import com.facebook.search.model.KeywordTypeaheadUnit.Source;
import com.facebook.search.model.SeeMoreTypeaheadUnit;
import com.facebook.search.model.SuggestionGroup.Type;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.ui.typeahead.FetchState;
import com.facebook.ui.typeahead.SearchResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: viewer() { peer_to_peer_payments { iris_sequence_id } } */
public class SimpleSearchTypeaheadSystem extends BaseSearchTypeaheadSystem {
    private final GraphSearchTitleSearchBoxSupplier f332a;
    private boolean f333b;
    private boolean f334c;

    @Inject
    public SimpleSearchTypeaheadSystem(GraphSearchTitleSearchBoxSupplier graphSearchTitleSearchBoxSupplier, GatekeeperStoreImpl gatekeeperStoreImpl, QeAccessor qeAccessor) {
        this.f332a = graphSearchTitleSearchBoxSupplier;
        this.f333b = qeAccessor.a(ExperimentsForSearchAbTestModule.aj, false);
        this.f334c = gatekeeperStoreImpl.a(SearchAbTestGatekeepers.u, false);
    }

    public final ImmutableList<TypeaheadUnit> mo44a(GraphSearchQuery graphSearchQuery, SearchResponse<TypeaheadUnit> searchResponse, TypeaheadUnit typeaheadUnit, FetchState fetchState) {
        if (this.f332a.c().trim().length() == 1 && searchResponse.b.isEmpty()) {
            return RegularImmutableList.a;
        }
        Object a;
        Builder builder = new Builder();
        ImmutableList immutableList = searchResponse.b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            TypeaheadUnit typeaheadUnit2 = (TypeaheadUnit) immutableList.get(i);
            if (typeaheadUnit2.k() != Type.KEYWORD) {
                builder.c(typeaheadUnit2);
            }
        }
        if (this.f334c) {
            a = m475a(Source.ESCAPE);
        } else if (this.f333b) {
            a = m475a(Source.SS_SEE_MORE_LINK);
        } else {
            a = new SeeMoreTypeaheadUnit("see_more_link");
        }
        builder.c(a);
        return builder.b();
    }

    public final TypeaheadUnit mo43a(GraphSearchQuery graphSearchQuery) {
        if (this.f334c) {
            return m475a(Source.SEARCH_BUTTON);
        }
        if (this.f333b) {
            return m475a(Source.SS_SEE_MORE_BUTTON);
        }
        return new SeeMoreTypeaheadUnit("search_button");
    }

    private KeywordTypeaheadUnit m475a(Source source) {
        KeywordType keywordType;
        String c = this.f332a.c();
        KeywordTypeaheadUnit.Builder builder = new KeywordTypeaheadUnit.Builder();
        builder.b = c;
        builder = builder;
        builder.d = c;
        builder = builder;
        builder.e = "content";
        builder = builder;
        builder.f = ExactMatchInputExactMatch.FALSE;
        builder = builder;
        builder.k = source;
        builder = builder;
        builder.c = SearchQueryFunctions.o(c);
        builder = builder;
        if (this.f334c) {
            keywordType = KeywordType.escape;
        } else {
            keywordType = KeywordType.escape_pps_style;
        }
        builder.g = keywordType;
        return builder.b();
    }
}
