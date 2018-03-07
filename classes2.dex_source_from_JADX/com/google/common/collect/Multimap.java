package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: uri_md5 */
public interface Multimap<K, V> {
    boolean mo409a(@Nullable K k, Iterable<? extends V> iterable);

    boolean mo431a(@Nullable K k, @Nullable V v);

    Map<K, Collection<V>> mo426b();

    boolean mo410b(@Nullable Object obj, @Nullable Object obj2);

    Collection<V> mo427c(@Nullable K k);

    boolean mo412c(@Nullable Object obj, @Nullable Object obj2);

    Collection<V> mo429d(@Nullable Object obj);

    boolean equals(@Nullable Object obj);

    int mo413f();

    boolean mo414f(@Nullable Object obj);

    void mo415g();

    int hashCode();

    Collection<V> mo418i();

    Collection<Entry<K, V>> mo419k();

    boolean mo420n();

    Set<K> mo421p();

    Multiset<K> mo422q();
}
