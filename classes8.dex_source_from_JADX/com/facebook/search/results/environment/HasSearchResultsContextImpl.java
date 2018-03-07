package com.facebook.search.results.environment;

import com.facebook.inject.Assisted;
import com.facebook.search.results.model.SearchResultsMutableContext;
import javax.inject.Inject;

/* compiled from: Story cacheId was null */
public class HasSearchResultsContextImpl implements HasSearchResultsContext {
    private final SearchResultsMutableContext f22547a;

    @Inject
    public HasSearchResultsContextImpl(@Assisted SearchResultsMutableContext searchResultsMutableContext) {
        this.f22547a = searchResultsMutableContext;
    }

    public final SearchResultsMutableContext mo1248s() {
        return this.f22547a;
    }
}
