package com.facebook.search.fragmentfactory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.config.application.Product;
import com.facebook.search.fragment.GraphSearchFragment;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.search.logging.perf.SearchPerfLogger;
import com.facebook.search.results.fragment.feed.SearchResultsFeedFragment;
import javax.inject.Inject;

/* compiled from: ThrowbackFeedQuery */
public class GraphSearchFragmentFactory implements IFragmentFactory {
    private final Product f21930a;
    private final SearchResultsIntentBuilder f21931b;
    private final SearchPerfLogger f21932c;

    @Inject
    public GraphSearchFragmentFactory(Product product, SearchResultsIntentBuilder searchResultsIntentBuilder, SearchPerfLogger searchPerfLogger) {
        this.f21930a = product;
        this.f21931b = searchResultsIntentBuilder;
        this.f21932c = searchPerfLogger;
    }

    public final Fragment m25434a(Intent intent) {
        Object obj;
        if (this.f21930a != Product.PAA) {
            this.f21932c.mo1206c();
        }
        Fragment searchResultsFeedFragment = this.f21930a == Product.PAA ? new SearchResultsFeedFragment() : new GraphSearchFragment();
        Bundle extras = intent.getExtras();
        if (extras == null || extras.getString("hashtag_feed_id") == null || extras.getString("hashtag_feed_title") == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            searchResultsFeedFragment.g(this.f21931b.a(SearchTypeaheadSession.a, extras.getString("hashtag_feed_id"), extras.getString("hashtag_feed_title"), SearchResultsSource.o).getExtras());
        } else {
            searchResultsFeedFragment.g(intent.getExtras());
        }
        return searchResultsFeedFragment;
    }
}
