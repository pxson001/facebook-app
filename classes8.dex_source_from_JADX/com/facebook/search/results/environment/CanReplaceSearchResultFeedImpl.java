package com.facebook.search.results.environment;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.search.results.model.SearchResultsBridge;
import com.facebook.search.results.model.SearchResultsFeedCollection;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import javax.inject.Inject;

/* compiled from: SuggestedPicUploadService */
public class CanReplaceSearchResultFeedImpl implements CanReplaceSearchResult {
    private final SearchResultsFeedCollection f22537a;
    private final HasSearchResultPosition f22538b;

    @Inject
    public CanReplaceSearchResultFeedImpl(@Assisted SearchResultsFeedCollection searchResultsFeedCollection, @Assisted HasSearchResultPosition hasSearchResultPosition) {
        this.f22537a = searchResultsFeedCollection;
        this.f22538b = hasSearchResultPosition;
    }

    public final boolean mo1244a(FeedUnit feedUnit) {
        for (SearchResultsBridge searchResultsBridge : this.f22537a.m27070d()) {
            if (CanReplaceSearchResultImpl.m26014a(searchResultsBridge.f23332b.f23325a, feedUnit)) {
                return true;
            }
        }
        return false;
    }

    public final void mo1243a(SearchResultsEdgeModel searchResultsEdgeModel, SearchResultsEdgeModel searchResultsEdgeModel2) {
        int a = this.f22538b.mo1247a(searchResultsEdgeModel);
        if (a == -1) {
            throw new IllegalArgumentException("Item not found: " + searchResultsEdgeModel);
        }
        this.f22537a.m27068b(a, SearchResultsBridge.m27031a(searchResultsEdgeModel2, null));
    }

    public final void mo1242a(GraphQLStory graphQLStory) {
        for (SearchResultsBridge searchResultsBridge : this.f22537a.m27070d()) {
            SearchResultsEdgeModel searchResultsEdgeModel = searchResultsBridge.f23332b.f23325a;
            SearchResultsEdgeModel a = CanReplaceSearchResultImpl.m26013a(searchResultsEdgeModel, graphQLStory);
            if (a != null) {
                mo1243a(searchResultsEdgeModel, a);
                return;
            }
        }
    }
}
