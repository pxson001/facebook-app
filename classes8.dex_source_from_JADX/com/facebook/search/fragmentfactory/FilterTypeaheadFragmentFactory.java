package com.facebook.search.fragmentfactory;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.search.results.filters.ui.SearchFilterTypeaheadFragment;

/* compiled from: ThrowbackFeedTTI */
public class FilterTypeaheadFragmentFactory implements IFragmentFactory {
    public final Fragment m25433a(Intent intent) {
        SearchFilterTypeaheadFragment searchFilterTypeaheadFragment = new SearchFilterTypeaheadFragment();
        searchFilterTypeaheadFragment.g(intent.getExtras());
        return searchFilterTypeaheadFragment;
    }
}
