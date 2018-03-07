package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: camera */
final class Maps$1 extends TransformedIterator<K, Entry<K, V>> {
    final /* synthetic */ Function f7469a;

    Maps$1(Iterator it, Function function) {
        this.f7469a = function;
        super(it);
    }

    final Object m13525a(Object obj) {
        return Maps.a(obj, this.f7469a.apply(obj));
    }
}
