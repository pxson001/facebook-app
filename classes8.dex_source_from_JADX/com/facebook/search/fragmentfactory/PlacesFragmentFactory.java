package com.facebook.search.fragmentfactory;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.search.results.fragment.places.SearchResultsPlacesFragment;

/* compiled from: ThirdPartyTrackerHandler */
public class PlacesFragmentFactory implements IFragmentFactory {
    public final Fragment m25437a(Intent intent) {
        SearchResultsPlacesFragment searchResultsPlacesFragment = new SearchResultsPlacesFragment();
        searchResultsPlacesFragment.g(intent.getExtras());
        return searchResultsPlacesFragment;
    }
}
