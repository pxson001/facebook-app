package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: zero_rating2/clearable/default_optin/description_text_key */
public interface BiMap<K, V> extends Map<K, V> {
    @Nullable
    V mo65a(@Nullable K k, @Nullable V v);

    BiMap<V, K> a_();

    Set<V> mo67c();

    @Nullable
    V put(@Nullable K k, @Nullable V v);
}
