package com.facebook.search.results.environment.entity;

import com.facebook.inject.Assisted;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import javax.inject.Inject;

/* compiled from: SelectAtTagActivity */
public class CanLogEntityNavigationEntitiesImpl implements CanLogEntityNavigation {
    private final HasSearchResultsContext f22669a;
    private final HasSearchResultPosition f22670b;
    private final SearchResultsLogger f22671c;

    @Inject
    public CanLogEntityNavigationEntitiesImpl(@Assisted HasSearchResultsContext hasSearchResultsContext, @Assisted HasSearchResultPosition hasSearchResultPosition, SearchResultsLogger searchResultsLogger) {
        this.f22669a = hasSearchResultsContext;
        this.f22670b = hasSearchResultPosition;
        this.f22671c = searchResultsLogger;
    }

    public final void mo1256c(SearchResultsProps searchResultsProps) {
        NodeModel nodeModel = (NodeModel) searchResultsProps.f23388a;
        this.f22671c.m25476a(this.f22669a.mo1248s(), this.f22670b.mo1247a(searchResultsProps.f23390c), nodeModel.mo572C());
    }
}
