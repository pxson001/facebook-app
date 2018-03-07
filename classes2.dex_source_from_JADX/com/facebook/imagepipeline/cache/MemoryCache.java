package com.facebook.imagepipeline.cache;

import com.android.internal.util.Predicate;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;

/* compiled from: orca_looping_sticker_animations_android */
public interface MemoryCache<K, V> {
    int mo2070a(Predicate<K> predicate);

    @Nullable
    CloseableReference<V> mo2071a(K k);

    @Nullable
    CloseableReference<V> mo2072a(K k, CloseableReference<V> closeableReference);

    boolean mo2073b(Predicate<K> predicate);
}
