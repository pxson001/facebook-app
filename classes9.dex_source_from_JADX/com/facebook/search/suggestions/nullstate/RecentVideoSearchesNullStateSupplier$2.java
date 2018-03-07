package com.facebook.search.suggestions.nullstate;

import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.model.CachedSuggestionList;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: web_view_dismiss_url */
class RecentVideoSearchesNullStateSupplier$2 implements FutureCallback<CachedSuggestionList> {
    final /* synthetic */ RecentVideoSearchesNullStateSupplier f208a;

    RecentVideoSearchesNullStateSupplier$2(RecentVideoSearchesNullStateSupplier recentVideoSearchesNullStateSupplier) {
        this.f208a = recentVideoSearchesNullStateSupplier;
    }

    public void onSuccess(Object obj) {
        CachedSuggestionList cachedSuggestionList = (CachedSuggestionList) obj;
        RecentVideoSearchesNullStateSupplier.m(this.f208a);
        this.f208a.a(cachedSuggestionList);
        RecentVideoSearchesNullStateSupplier.a(this.f208a, cachedSuggestionList.a);
        this.f208a.i = null;
    }

    public void onFailure(Throwable th) {
        RecentVideoSearchesNullStateSupplier.m(this.f208a);
        this.f208a.i();
        this.f208a.d.a(GraphSearchError.FETCH_NULL_STATE_RECENT_SEARCHES_FAIL, th);
        this.f208a.i = null;
    }
}
