package com.facebook.search.fragmentfactory;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.search.results.fragment.entities.SearchResultsEntitiesFragment;

/* compiled from: ThrowbackFriendversaryGroupPartDefinition_null_friend_edge */
public class EntitiesFragmentFactory implements IFragmentFactory {
    public final Fragment m25431a(Intent intent) {
        SearchResultsEntitiesFragment searchResultsEntitiesFragment = new SearchResultsEntitiesFragment();
        searchResultsEntitiesFragment.g(intent.getExtras());
        return searchResultsEntitiesFragment;
    }
}
