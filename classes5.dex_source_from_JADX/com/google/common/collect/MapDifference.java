package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;

@GwtCompatible
/* compiled from: bump_reason */
public interface MapDifference<K, V> {
    Map<K, V> mo973a();

    Map<K, V> mo974b();

    Map<K, V> mo975c();

    Map<K, ValueDifference<V>> mo976d();
}
