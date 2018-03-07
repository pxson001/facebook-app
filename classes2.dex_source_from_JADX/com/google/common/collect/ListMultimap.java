package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: ur_PK */
public interface ListMultimap<K, V> extends Multimap<K, V> {
    List<V> mo424a(@Nullable K k);

    List<V> mo425b(@Nullable Object obj);
}
