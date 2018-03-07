package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: runnable parameter is null */
public interface SetMultimap<K, V> extends Multimap<K, V> {
    Set<V> mo1474a(@Nullable K k);

    Set<V> mo1475b(@Nullable Object obj);
}
