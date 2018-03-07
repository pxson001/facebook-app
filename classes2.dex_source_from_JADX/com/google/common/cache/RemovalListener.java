package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* compiled from: zeroInterstitialContent */
public interface RemovalListener<K, V> {
    void onRemoval(RemovalNotification<K, V> removalNotification);
}
