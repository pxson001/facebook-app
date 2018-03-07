package com.facebook.feed.data.freshfeed;

import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: setterVisibility */
public class FreshFeedFetcherProvider extends AbstractAssistedProvider<FreshFeedFetcher> {
    public final FreshFeedFetcher m9070a(FreshFeedDataLoaderUIHandler freshFeedDataLoaderUIHandler, FreshFeedBackgroundUIWorkHandler freshFeedBackgroundUIWorkHandler) {
        return new FreshFeedFetcher(freshFeedDataLoaderUIHandler, freshFeedBackgroundUIWorkHandler, (FreshFeedNetworkHandlerProvider) getOnDemandAssistedProviderForStaticDi(FreshFeedNetworkHandlerProvider.class), (FreshFeedDBHandlerProvider) getOnDemandAssistedProviderForStaticDi(FreshFeedDBHandlerProvider.class), FbHandlerThreadFactory.m3575a((InjectorLike) this));
    }
}
