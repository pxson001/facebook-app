package com.facebook.search.results.model.unit;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLNode.Builder;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.search.model.SearchResultsBaseFeedUnit;
import com.facebook.search.results.model.contract.SearchResultsEntitiesTrackable;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.facebook.search.results.model.specification.SearchResultsSupportDeclaration;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: Requested view of type %s but got view of type %s. Types must be identical. */
public class SearchResultsPulseContextUnit extends SearchResultsBaseFeedUnit implements SearchResultsEntitiesTrackable, SearchResultsFeedImpressionTrackable {
    public final GraphQLNode f23497a;
    private final Optional<String> f23498b;

    public SearchResultsPulseContextUnit(GraphQLNode graphQLNode, @Nullable String str) {
        this.f23497a = graphQLNode;
        this.f23498b = Optional.fromNullable(str);
    }

    private SearchResultsPulseContextUnit(GraphQLNode graphQLNode, Optional<String> optional) {
        this.f23497a = graphQLNode;
        this.f23498b = optional;
    }

    public final String m27180m() {
        return this.f23497a.cv();
    }

    public final GraphQLTextWithEntities m27181n() {
        return this.f23497a.hY();
    }

    public final GraphQLTextWithEntities m27182o() {
        return this.f23497a.it();
    }

    @Nullable
    public final GraphQLSavedState m27183p() {
        return this.f23497a.eU() != null ? this.f23497a.eU().jn() : null;
    }

    @Nullable
    public final SearchResultsPulseContextUnit m27176a(GraphQLSavedState graphQLSavedState) {
        if (this.f23497a.eU() == null) {
            return null;
        }
        GraphQLNode a = Builder.a(this.f23497a.eU()).a(graphQLSavedState).a();
        Builder a2 = Builder.a(this.f23497a);
        a2.fF = a;
        return new SearchResultsPulseContextUnit(a2.a(), this.f23498b);
    }

    public final GraphQLGraphSearchResultRole mo1321k() {
        return SearchResultsSupportDeclaration.f23441u.f23406a;
    }

    public final Optional<String> mo1322l() {
        return this.f23498b;
    }

    public final ImmutableList<String> mo1328a() {
        String dp = this.f23497a.dp();
        return dp != null ? ImmutableList.of(dp) : RegularImmutableList.a;
    }
}
