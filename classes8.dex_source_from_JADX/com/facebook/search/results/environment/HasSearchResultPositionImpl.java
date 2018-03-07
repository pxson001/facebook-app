package com.facebook.search.results.environment;

import com.facebook.inject.Assisted;
import com.facebook.search.results.model.SearchResultUnit;
import com.facebook.search.results.model.SearchResultsCollection;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import javax.inject.Inject;

/* compiled from: StyleLowercase */
public class HasSearchResultPositionImpl implements HasSearchResultPosition {
    private final SearchResultsCollection f22546a;

    @Inject
    public HasSearchResultPositionImpl(@Assisted SearchResultsCollection searchResultsCollection) {
        this.f22546a = searchResultsCollection;
    }

    public final int mo1247a(SearchResultsEdgeModel searchResultsEdgeModel) {
        for (int i = 0; i < this.f22546a.m27037a(); i++) {
            SearchResultUnit b = this.f22546a.m27040b(i);
            if ((b instanceof SearchResultUnit) && b.f23325a == searchResultsEdgeModel) {
                return i;
            }
        }
        return -1;
    }

    public final int mo1246a(SearchResultsProps searchResultsProps) {
        return mo1247a(searchResultsProps.f23390c);
    }
}
