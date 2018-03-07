package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: camera */
final class Maps$FilteredMapValues<K, V> extends Maps$Values<K, V> {
    Map<K, V> f7481a;
    Predicate<? super Entry<K, V>> f7482b;

    Maps$FilteredMapValues(Map<K, V> map, Map<K, V> map2, Predicate<? super Entry<K, V>> predicate) {
        super(map);
        this.f7481a = map2;
        this.f7482b = predicate;
    }

    public final boolean remove(Object obj) {
        return Iterables.b(this.f7481a.entrySet(), Predicates.and(this.f7482b, Maps.b(Predicates.equalTo(obj)))) != null;
    }

    private boolean m13542a(Predicate<? super V> predicate) {
        return Iterables.a(this.f7481a.entrySet(), Predicates.and(this.f7482b, Maps.b(predicate)));
    }

    public final boolean removeAll(Collection<?> collection) {
        return m13542a(Predicates.in(collection));
    }

    public final boolean retainAll(Collection<?> collection) {
        return m13542a(Predicates.not(Predicates.in(collection)));
    }

    public final Object[] toArray() {
        return Lists.a(iterator()).toArray();
    }

    public final <T> T[] toArray(T[] tArr) {
        return Lists.a(iterator()).toArray(tArr);
    }
}
