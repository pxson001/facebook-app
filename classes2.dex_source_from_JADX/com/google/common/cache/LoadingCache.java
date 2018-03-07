package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;

@GwtCompatible
/* compiled from: zero_campiagn_not_enabled */
public interface LoadingCache<K, V> extends Function<K, V>, Cache<K, V> {
    @Deprecated
    V apply(K k);

    V mo108c(K k);

    V mo109d(K k);
}
