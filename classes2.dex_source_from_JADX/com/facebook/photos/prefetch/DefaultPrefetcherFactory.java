package com.facebook.photos.prefetch;

import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: pages_android_new_edit_page */
public class DefaultPrefetcherFactory {
    public final DefaultPrefetcherProvider f10438a;
    public final Provider<OldImageFetcher> f10439b;
    public final Provider<ExperimentalImageFetcher> f10440c;
    public final Provider<BatchingExperimentalImageFetcher> f10441d;
    public final PrefetchRange f10442e;
    public final QeAccessor f10443f;

    @Inject
    public DefaultPrefetcherFactory(DefaultPrefetcherProvider defaultPrefetcherProvider, Provider<OldImageFetcher> provider, Provider<ExperimentalImageFetcher> provider2, Provider<BatchingExperimentalImageFetcher> provider3, QeAccessor qeAccessor, @Assisted PrefetchRange prefetchRange) {
        this.f10438a = defaultPrefetcherProvider;
        this.f10439b = provider;
        this.f10440c = provider2;
        this.f10441d = provider3;
        this.f10443f = qeAccessor;
        this.f10442e = prefetchRange;
    }
}
