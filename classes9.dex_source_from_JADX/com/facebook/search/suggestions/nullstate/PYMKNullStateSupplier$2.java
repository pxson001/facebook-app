package com.facebook.search.suggestions.nullstate;

import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.model.CachedSuggestionList;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: web_view_title */
class PYMKNullStateSupplier$2 implements FutureCallback<CachedSuggestionList> {
    final /* synthetic */ PYMKNullStateSupplier f202a;

    PYMKNullStateSupplier$2(PYMKNullStateSupplier pYMKNullStateSupplier) {
        this.f202a = pYMKNullStateSupplier;
    }

    public void onSuccess(Object obj) {
        CachedSuggestionList cachedSuggestionList = (CachedSuggestionList) obj;
        PYMKNullStateSupplier.k(this.f202a);
        this.f202a.a(cachedSuggestionList);
        PYMKNullStateSupplier.a(this.f202a, cachedSuggestionList.a());
        synchronized (this) {
            PYMKNullStateSupplier.a(this.f202a, null);
        }
    }

    public void onFailure(Throwable th) {
        PYMKNullStateSupplier.k(this.f202a);
        this.f202a.i();
        this.f202a.h.a(GraphSearchError.FETCH_NULL_STATE_PYMK_FAIL, th);
        synchronized (this) {
            PYMKNullStateSupplier.a(this.f202a, null);
        }
    }
}
