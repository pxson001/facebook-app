package com.facebook.search.results.rows.sections.common;

import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.environment.HasFeedItemPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.contract.SearchResultsSeeMoreFeedUnit;

/* compiled from: REORDER */
public interface SearchResultsSeeMoreLogger {
    <E extends HasSearchResultsContext & HasFeedItemPosition> void mo1334a(SearchResultsLogger searchResultsLogger, E e, SearchResultsSeeMoreFeedUnit searchResultsSeeMoreFeedUnit);
}
