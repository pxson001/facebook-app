package com.facebook.search.results.environment;

import com.facebook.inject.Assisted;
import com.facebook.search.results.model.SearchResultsBridge;
import com.facebook.search.results.model.SearchResultsFeedCollection;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import javax.inject.Inject;

/* compiled from: StyleUppercase */
public class HasSearchResultPositionFeedImpl implements HasSearchResultPosition {
    private final SearchResultsFeedCollection f22545a;

    @Inject
    public HasSearchResultPositionFeedImpl(@Assisted SearchResultsFeedCollection searchResultsFeedCollection) {
        this.f22545a = searchResultsFeedCollection;
    }

    public final int mo1247a(SearchResultsEdgeModel searchResultsEdgeModel) {
        int i = 0;
        while (i < this.f22545a.m27051a()) {
            if ((this.f22545a.m27065b(i) instanceof SearchResultsBridge) && ((SearchResultsBridge) this.f22545a.m27065b(i)).f23332b.f23325a == searchResultsEdgeModel) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public final int mo1246a(SearchResultsProps searchResultsProps) {
        return mo1247a(searchResultsProps.f23390c);
    }
}
