package com.facebook.search.results.model.unit;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.search.results.model.contract.SearchResultsEntitiesTrackable;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.facebook.search.results.model.specification.SearchResultsSupportDeclaration;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: RenderThumbnails */
public class SearchResultsPulseTopicMetadataUnit extends SearchResultsEntityWithCoverPhotoFeedUnit implements SearchResultsEntitiesTrackable, SearchResultsFeedImpressionTrackable {
    private final GraphQLNode f23504a;
    private final Optional<String> f23505b;

    public SearchResultsPulseTopicMetadataUnit(GraphQLNode graphQLNode, @Nullable String str) {
        this.f23504a = graphQLNode;
        this.f23505b = Optional.fromNullable(str);
    }

    public final GraphQLGraphSearchResultRole mo1321k() {
        return SearchResultsSupportDeclaration.f23408B.f23406a;
    }

    public final Optional<String> mo1322l() {
        return this.f23505b;
    }

    public final GraphQLNode mo1326n() {
        return this.f23504a;
    }

    public final String mo1324f() {
        return this.f23504a.eP();
    }

    @Nullable
    public final String mo1325m() {
        return null;
    }

    @Nullable
    public final String mo1327o() {
        return this.f23504a.iz() != null ? this.f23504a.iz().b() : null;
    }

    public final ImmutableList<String> mo1328a() {
        String dp = this.f23504a.dp();
        return dp != null ? ImmutableList.of(dp) : RegularImmutableList.a;
    }
}
