package com.facebook.search.results.environment.tabs;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.search.results.fragment.tabs.SearchResultsTabsFragment;

/* compiled from: Search */
public class CanSwitchResultPageTabImplProvider extends AbstractAssistedProvider<CanSwitchResultPageTabImpl> {
    public static CanSwitchResultPageTabImpl m26266a(SearchResultsTabsFragment searchResultsTabsFragment) {
        return new CanSwitchResultPageTabImpl(searchResultsTabsFragment);
    }
}
