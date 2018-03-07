package com.facebook.search.fragmentfactory;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.search.results.fragment.feed.SearchResultsLiveFeedFragment;

/* compiled from: ThrowbackFeedDataFetch */
public class LiveFeedFragmentFactory implements IFragmentFactory {
    public final Fragment m25435a(Intent intent) {
        SearchResultsLiveFeedFragment searchResultsLiveFeedFragment = new SearchResultsLiveFeedFragment();
        searchResultsLiveFeedFragment.g(intent.getExtras());
        return searchResultsLiveFeedFragment;
    }
}
