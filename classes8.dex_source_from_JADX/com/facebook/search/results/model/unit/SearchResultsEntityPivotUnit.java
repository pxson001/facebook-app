package com.facebook.search.results.model.unit;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.search.model.SearchResultsBaseFeedUnit;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.facebook.search.results.model.contract.SearchResultsSeeMoreFeedUnit;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: Reset Force Modes */
public class SearchResultsEntityPivotUnit extends SearchResultsBaseFeedUnit implements SearchResultsFeedImpressionTrackable, SearchResultsSeeMoreFeedUnit {
    private static final ImmutableMap<GraphQLGraphSearchResultRole, GraphQLGraphSearchResultsDisplayStyle> f23479a = ImmutableMap.builder().b(GraphQLGraphSearchResultRole.ENTITY_USER, GraphQLGraphSearchResultsDisplayStyle.USERS).b(GraphQLGraphSearchResultRole.ENTITY_PAGES, GraphQLGraphSearchResultsDisplayStyle.PAGES).b(GraphQLGraphSearchResultRole.TOPIC_MEDIA, GraphQLGraphSearchResultsDisplayStyle.PHOTOS).b(GraphQLGraphSearchResultRole.ENTITY_EVENTS, GraphQLGraphSearchResultsDisplayStyle.EVENTS).b(GraphQLGraphSearchResultRole.ENTITY_PLACES, GraphQLGraphSearchResultsDisplayStyle.PLACES).b(GraphQLGraphSearchResultRole.ENTITY_GROUPS, GraphQLGraphSearchResultsDisplayStyle.GROUPS).b(GraphQLGraphSearchResultRole.ENTITY_APPS, GraphQLGraphSearchResultsDisplayStyle.APPS).b();
    @Nullable
    public final String f23480b;
    @Nullable
    private final String f23481c;
    public final int f23482d;
    private final GraphQLGraphSearchResultRole f23483e;
    public final String f23484f;
    public final GraphQLObjectType f23485g;
    private final GraphQLGraphSearchResultsDisplayStyle f23486h;

    public final Optional<String> mo1322l() {
        return Absent.INSTANCE;
    }

    public SearchResultsEntityPivotUnit(GraphQLNode graphQLNode) {
        this.f23480b = graphQLNode.kb() != null ? graphQLNode.kb().a() : null;
        this.f23482d = graphQLNode.kI();
        this.f23483e = GraphQLGraphSearchResultRole.fromString(graphQLNode.ka());
        this.f23484f = graphQLNode.dp();
        this.f23485g = graphQLNode.j();
        this.f23481c = graphQLNode.jZ();
        this.f23486h = f23479a.containsKey(this.f23483e) ? (GraphQLGraphSearchResultsDisplayStyle) f23479a.get(this.f23483e) : GraphQLGraphSearchResultsDisplayStyle.STORIES;
    }

    public final GraphQLGraphSearchResultRole mo1321k() {
        return this.f23483e;
    }

    public final Optional<String> mo1329f() {
        return Optional.of(this.f23480b);
    }

    public final Optional<String> mo1330m() {
        return Optional.of(this.f23481c);
    }

    public final GraphQLGraphSearchResultsDisplayStyle mo1331n() {
        return this.f23486h;
    }
}
