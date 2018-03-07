package com.facebook.search.results.model.unit;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.search.model.SearchResultsBaseFeedUnit;
import com.facebook.search.results.model.contract.SearchResultsEntitiesTrackable;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.facebook.search.results.model.specification.SearchResultsSupportDeclaration;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: Reset Awareness Opt-Outs */
public class SearchResultsNewsContextUnit extends SearchResultsBaseFeedUnit implements SearchResultsEntitiesTrackable, SearchResultsFeedImpressionTrackable {
    public final GraphQLNode f23490a;
    private final Optional<String> f23491b;
    private GraphQLObjectType f23492c;

    public SearchResultsNewsContextUnit(GraphQLNode graphQLNode, @Nullable String str) {
        Object obj;
        GraphQLObjectType graphQLObjectType;
        this.f23490a = graphQLNode;
        this.f23491b = Optional.fromNullable(str);
        GraphQLNode iw = graphQLNode.iw();
        if (iw == null || iw.j().g() != 82650203) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            graphQLObjectType = new GraphQLObjectType(82650203);
        } else if (graphQLNode.iL() == null || graphQLNode.iL().l() == null) {
            graphQLObjectType = null;
        } else {
            graphQLObjectType = new GraphQLObjectType(77090322);
        }
        this.f23492c = graphQLObjectType;
    }

    public final GraphQLGraphSearchResultRole mo1321k() {
        return SearchResultsSupportDeclaration.f23437q.f23406a;
    }

    public final Optional<String> mo1322l() {
        return this.f23491b;
    }

    public final ImmutableList<String> mo1328a() {
        String dp = this.f23490a.dp();
        return dp != null ? ImmutableList.of(dp) : RegularImmutableList.a;
    }

    public GraphQLObjectType getType() {
        return this.f23492c;
    }
}
