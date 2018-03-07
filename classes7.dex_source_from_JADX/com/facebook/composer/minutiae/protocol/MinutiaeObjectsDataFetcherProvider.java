package com.facebook.composer.minutiae.protocol;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;

/* compiled from: timeframe */
public class MinutiaeObjectsDataFetcherProvider extends AbstractAssistedProvider<MinutiaeObjectsDataFetcher> {
    public final MinutiaeObjectsDataFetcher m1685a(Integer num, String str, String str2) {
        return new MinutiaeObjectsDataFetcher(num, str, str2, MinutiaeTaggableObjectsFetcher.m1686a((InjectorLike) this), TasksManager.b(this), MinutiaeTaggableObjectsPreloader.m1692a((InjectorLike) this));
    }
}
