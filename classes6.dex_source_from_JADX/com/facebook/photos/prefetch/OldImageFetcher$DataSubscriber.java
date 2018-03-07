package com.facebook.photos.prefetch;

import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;

/* compiled from: has_scrolled */
class OldImageFetcher$DataSubscriber extends BaseDataSubscriber {
    final /* synthetic */ OldImageFetcher f13248a;
    private final PrefetchParams f13249b;

    public OldImageFetcher$DataSubscriber(OldImageFetcher oldImageFetcher, PrefetchParams prefetchParams) {
        this.f13248a = oldImageFetcher;
        this.f13249b = prefetchParams;
    }

    protected final void m20921e(DataSource dataSource) {
        this.f13248a.e.a(this.f13249b.c(), Boolean.TRUE);
        OldImageFetcher.b(this.f13248a, this.f13249b, true);
    }

    protected final void m20922f(DataSource dataSource) {
        this.f13248a.e.a(this.f13249b.c(), Boolean.FALSE);
        OldImageFetcher.b(this.f13248a, this.f13249b, false);
    }
}
