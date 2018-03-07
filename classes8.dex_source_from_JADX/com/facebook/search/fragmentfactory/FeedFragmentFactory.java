package com.facebook.search.fragmentfactory;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.results.fragment.SearchResultsFragment;
import com.facebook.search.results.fragment.feed.SearchResultsFeedFragment;
import javax.inject.Inject;

/* compiled from: ThrowbackFeedViewCreation */
public class FeedFragmentFactory implements IFragmentFactory {
    private final GatekeeperStoreImpl f21929a;

    @Inject
    public FeedFragmentFactory(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f21929a = gatekeeperStoreImpl;
    }

    public final Fragment m25432a(Intent intent) {
        Fragment a = this.f21929a.a(SearchAbTestGatekeepers.h, false) ? SearchResultsFragment.m26590a("graph_search_results_page_blended") : SearchResultsFeedFragment.m26674c("graph_search_results_page_blended");
        a.g(intent.getExtras());
        return a;
    }
}
