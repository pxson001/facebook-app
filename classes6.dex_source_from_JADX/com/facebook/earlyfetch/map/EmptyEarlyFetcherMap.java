package com.facebook.earlyfetch.map;

import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.earlyfetch.EarlyFetcher;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: nux_flow_finish */
public class EmptyEarlyFetcherMap implements EarlyFetcherMap {
    public static EmptyEarlyFetcherMap m12697a(InjectorLike injectorLike) {
        return new EmptyEarlyFetcherMap();
    }

    @Nullable
    public final EarlyFetcher m12698a(ContentFragmentType contentFragmentType) {
        return null;
    }

    public final ImmutableList<? extends EarlyFetcher> m12699a() {
        return RegularImmutableList.a;
    }
}
