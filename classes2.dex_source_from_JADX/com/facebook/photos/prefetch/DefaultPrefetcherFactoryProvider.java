package com.facebook.photos.prefetch;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: param_interval_ms */
public class DefaultPrefetcherFactoryProvider extends AbstractAssistedProvider<DefaultPrefetcherFactory> {
    public final DefaultPrefetcherFactory m15497a(PrefetchRange prefetchRange) {
        return new DefaultPrefetcherFactory((DefaultPrefetcherProvider) getOnDemandAssistedProviderForStaticDi(DefaultPrefetcherProvider.class), IdBasedProvider.m1811a(this, 2976), IdBasedProvider.m1811a(this, 9415), IdBasedProvider.m1811a(this, 2975), QeInternalImplMethodAutoProvider.m3744a(this), prefetchRange);
    }
}
