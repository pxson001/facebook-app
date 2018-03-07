package com.facebook.search.results.model.unit;

import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.model.SearchResultsBaseFeedUnit;

/* compiled from: Referer */
public class SearchResultsWayfinderUnit extends SearchResultsBaseFeedUnit {
    public final String f23552a;
    public final ScopedEntityType f23553b;

    public SearchResultsWayfinderUnit(GraphSearchQuerySpec graphSearchQuerySpec) {
        this.f23552a = graphSearchQuerySpec.mo1211a();
        this.f23553b = graphSearchQuerySpec.jI_();
    }
}
