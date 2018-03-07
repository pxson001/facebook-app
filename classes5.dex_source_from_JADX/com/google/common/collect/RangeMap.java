package com.google.common.collect;

import com.google.common.annotations.Beta;
import java.util.Map;

@Beta
/* compiled from: buyer_name */
public interface RangeMap<K extends Comparable, V> {
    void mo930a(Range<K> range, V v);

    Map<Range<K>, V> mo931b();
}
