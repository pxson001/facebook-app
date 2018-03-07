package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Table.Cell;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: sun.misc.JavaLangAccess */
public class StandardTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private transient Map<R, Map<C, V>> f3835a;
    @GwtTransient
    public final Map<R, Map<C, V>> backingMap;
    @GwtTransient
    public final Supplier<? extends Map<C, V>> factory;

    StandardTable(Map<R, Map<C, V>> map, Supplier<? extends Map<C, V>> supplier) {
        this.backingMap = map;
        this.factory = supplier;
    }

    public boolean mo889a(@Nullable Object obj) {
        return obj != null && Maps.m835b(this.backingMap, obj);
    }

    public V mo886a(@Nullable Object obj, @Nullable Object obj2) {
        return (obj == null || obj2 == null) ? null : super.mo886a(obj, obj2);
    }

    public int mo893f() {
        int i = 0;
        for (Map size : this.backingMap.values()) {
            i = size.size() + i;
        }
        return i;
    }

    public void mo888a() {
        this.backingMap.clear();
    }

    public V mo887a(R r, C c, V v) {
        Preconditions.checkNotNull(r);
        Preconditions.checkNotNull(c);
        Preconditions.checkNotNull(v);
        Map map = (Map) this.backingMap.get(r);
        if (map == null) {
            map = (Map) this.factory.get();
            this.backingMap.put(r, map);
        }
        return map.put(c, v);
    }

    final Iterator<Cell<R, C, V>> mo891c() {
        return new CellIterator(this);
    }

    public Map<C, V> mo890b(R r) {
        return new Row(this, r);
    }

    public Map<R, Map<C, V>> mo892e() {
        Map<R, Map<C, V>> map = this.f3835a;
        if (map != null) {
            return map;
        }
        map = new RowMap(this);
        this.f3835a = map;
        return map;
    }
}
