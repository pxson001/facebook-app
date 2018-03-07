package com.facebook.search.results.fragment.tabs;

import android.support.v4.app.FragmentManager;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.fragment.GraphSearchChildFragment.OnResultClickListener;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.results.environment.tabs.CanSwitchResultPageTabImpl.OnSwitchTabListener;
import com.facebook.search.results.environment.tabs.SearchResultsTab;
import com.facebook.search.results.fragment.spec.GraphSearchResultFragmentSpecificationRegistry;
import com.google.common.collect.ImmutableList;

/* compiled from: SECONDARY */
public class SearchResultsTabsPagerAdapterProvider extends AbstractAssistedProvider<SearchResultsTabsPagerAdapter> {
    public final SearchResultsTabsPagerAdapter m26899a(FragmentManager fragmentManager, KeywordTypeaheadUnit keywordTypeaheadUnit, SearchTypeaheadSession searchTypeaheadSession, SearchResultsSource searchResultsSource, OnResultClickListener onResultClickListener, OnSwitchTabListener onSwitchTabListener, ImmutableList<SearchResultsTab> immutableList) {
        return new SearchResultsTabsPagerAdapter(fragmentManager, keywordTypeaheadUnit, searchTypeaheadSession, searchResultsSource, onResultClickListener, onSwitchTabListener, immutableList, GraphSearchResultFragmentSpecificationRegistry.m26828a((InjectorLike) this), RTLUtil.a(this));
    }
}
