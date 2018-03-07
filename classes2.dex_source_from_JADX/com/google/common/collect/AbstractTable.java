package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Table.Cell;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: summary */
abstract class AbstractTable<R, C, V> implements Table<R, C, V> {
    private transient Set<Cell<R, C, V>> f3836a;

    abstract Iterator<Cell<R, C, V>> mo891c();

    AbstractTable() {
    }

    public boolean mo889a(@Nullable Object obj) {
        return Maps.m835b(mo892e(), obj);
    }

    public V mo886a(@Nullable Object obj, @Nullable Object obj2) {
        Map map = (Map) Maps.m810a(mo892e(), obj);
        return map == null ? null : Maps.m810a(map, obj2);
    }

    public void mo888a() {
        Iterators.m1429h(mo894b().iterator());
    }

    public V mo887a(R r, C c, V v) {
        return mo890b(r).put(c, v);
    }

    public Set<Cell<R, C, V>> mo894b() {
        Set<Cell<R, C, V>> set = this.f3836a;
        if (set != null) {
            return set;
        }
        set = new CellSet(this);
        this.f3836a = set;
        return set;
    }

    public boolean equals(@Nullable Object obj) {
        return Tables.a(this, obj);
    }

    public int hashCode() {
        return mo894b().hashCode();
    }

    public String toString() {
        return mo892e().toString();
    }
}
