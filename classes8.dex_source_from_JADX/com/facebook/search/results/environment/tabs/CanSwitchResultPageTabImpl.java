package com.facebook.search.results.environment.tabs;

import com.facebook.inject.Assisted;
import com.facebook.search.results.fragment.tabs.SearchResultsTabsFragment;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Search Awareness and Education */
public class CanSwitchResultPageTabImpl implements CanSwitchResultPageTab {
    @Nullable
    private final SearchResultsTabsFragment f22711a;

    @Inject
    public CanSwitchResultPageTabImpl(@Nullable @Assisted SearchResultsTabsFragment searchResultsTabsFragment) {
        this.f22711a = searchResultsTabsFragment;
    }

    public final void mo1258a(SearchResultsTab searchResultsTab) {
        if (this.f22711a != null) {
            this.f22711a.m26888a(searchResultsTab);
        }
    }
}
