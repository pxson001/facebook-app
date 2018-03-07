package com.facebook.feed.rows.prefetch;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.prefetch.DefaultPrefetcherFactory;

/* compiled from: param */
public class MultiRowImagePrefetcherWrapperImplProvider extends AbstractAssistedProvider<MultiRowImagePrefetcherWrapperImpl> {
    public final MultiRowImagePrefetcherWrapperImpl m15498a(DefaultPrefetcherFactory defaultPrefetcherFactory) {
        return new MultiRowImagePrefetcherWrapperImpl(DefaultAndroidThreadUtil.m1646b((InjectorLike) this), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(this), defaultPrefetcherFactory, ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(this));
    }
}
