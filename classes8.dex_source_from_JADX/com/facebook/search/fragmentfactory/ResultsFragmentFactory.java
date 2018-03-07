package com.facebook.search.fragmentfactory;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.search.results.fragment.SearchResultsFragment;

/* compiled from: There were no prefetched questions */
public class ResultsFragmentFactory implements IFragmentFactory {
    public final Fragment m25438a(Intent intent) {
        SearchResultsFragment searchResultsFragment = new SearchResultsFragment();
        searchResultsFragment.g(intent.getExtras());
        return searchResultsFragment;
    }
}
