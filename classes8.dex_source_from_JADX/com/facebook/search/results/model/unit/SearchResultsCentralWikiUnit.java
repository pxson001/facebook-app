package com.facebook.search.results.model.unit;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.search.model.SearchResultsBaseFeedUnit;
import com.facebook.search.results.model.contract.SearchResultsEntitiesTrackable;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: Reset all awareness opt-out flags */
public class SearchResultsCentralWikiUnit extends SearchResultsBaseFeedUnit implements SearchResultsEntitiesTrackable, SearchResultsFeedImpressionTrackable {
    public final GraphQLNode f23457a;
    private final String f23458b;
    private final Optional<String> f23459c;

    public SearchResultsCentralWikiUnit(GraphQLNode graphQLNode, @Nullable String str, @Nullable String str2) {
        this.f23457a = graphQLNode;
        this.f23458b = str;
        this.f23459c = Optional.fromNullable(str2);
    }

    public final GraphQLGraphSearchResultRole mo1321k() {
        return GraphQLGraphSearchResultRole.WIKIPEDIA_CARD;
    }

    public final Optional<String> mo1322l() {
        return this.f23459c;
    }

    public final ImmutableList<String> mo1328a() {
        String dp = this.f23457a.dp();
        return dp != null ? ImmutableList.of(dp) : RegularImmutableList.a;
    }

    @Nullable
    public final String m27145m() {
        return this.f23458b == null ? null : this.f23458b;
    }
}
