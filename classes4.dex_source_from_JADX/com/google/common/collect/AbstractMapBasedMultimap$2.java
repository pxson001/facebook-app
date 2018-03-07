package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap.Itr;
import java.util.Map.Entry;

/* compiled from: log_event */
class AbstractMapBasedMultimap$2 extends Itr<Entry<K, V>> {
    final /* synthetic */ AbstractMapBasedMultimap f11493a;

    AbstractMapBasedMultimap$2(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        this.f11493a = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap);
    }

    final Object m11977a(Object obj, Object obj2) {
        return Maps.a(obj, obj2);
    }
}
