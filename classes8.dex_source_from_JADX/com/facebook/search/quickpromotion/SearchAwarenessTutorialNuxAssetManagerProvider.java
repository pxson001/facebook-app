package com.facebook.search.quickpromotion;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: TE;Z */
public class SearchAwarenessTutorialNuxAssetManagerProvider extends AbstractAssistedProvider<SearchAwarenessTutorialNuxAssetManager> {
    public final SearchAwarenessTutorialNuxAssetManager m25931a(int i) {
        return new SearchAwarenessTutorialNuxAssetManager(SearchAwarenessImageFetcher.m25873a((InjectorLike) this), i);
    }
}
