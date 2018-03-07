package com.facebook.search.results.environment;

import com.facebook.inject.InjectorLike;
import com.facebook.search.logging.SearchResultsPerformanceLogger;
import javax.inject.Inject;

/* compiled from: StartEntityCardsScrollWaitTime_ */
public class HasSearchResultsPerformanceLoggerImpl implements HasSearchResultsPerformanceLogger {
    private final SearchResultsPerformanceLogger f22548a;

    public static HasSearchResultsPerformanceLoggerImpl m26039a(InjectorLike injectorLike) {
        return new HasSearchResultsPerformanceLoggerImpl(SearchResultsPerformanceLogger.m25495a(injectorLike));
    }

    @Inject
    public HasSearchResultsPerformanceLoggerImpl(SearchResultsPerformanceLogger searchResultsPerformanceLogger) {
        this.f22548a = searchResultsPerformanceLogger;
    }

    public final void mo1249t() {
        this.f22548a.m25504a();
    }
}
