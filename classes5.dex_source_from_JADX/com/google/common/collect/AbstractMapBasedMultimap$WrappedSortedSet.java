package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap.WrappedCollection;
import java.util.Comparator;
import java.util.SortedSet;
import javax.annotation.Nullable;

/* compiled from: cameraTargetLng */
class AbstractMapBasedMultimap$WrappedSortedSet extends WrappedCollection implements SortedSet<V> {
    final /* synthetic */ AbstractMapBasedMultimap f7274a;

    private SortedSet<V> m13221g() {
        return (SortedSet) this.c;
    }

    AbstractMapBasedMultimap$WrappedSortedSet(AbstractMapBasedMultimap abstractMapBasedMultimap, @Nullable K k, SortedSet<V> sortedSet, @Nullable WrappedCollection wrappedCollection) {
        this.f7274a = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, k, sortedSet, wrappedCollection);
    }

    public Comparator<? super V> comparator() {
        return m13221g().comparator();
    }

    public V first() {
        a();
        return m13221g().first();
    }

    public V last() {
        a();
        return m13221g().last();
    }

    public SortedSet<V> headSet(V v) {
        WrappedCollection wrappedCollection;
        a();
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.f7274a;
        Object obj = this.b;
        SortedSet headSet = m13221g().headSet(v);
        if (this.d != null) {
            wrappedCollection = this.d;
        }
        return new AbstractMapBasedMultimap$WrappedSortedSet(abstractMapBasedMultimap, obj, headSet, wrappedCollection);
    }

    public SortedSet<V> subSet(V v, V v2) {
        WrappedCollection wrappedCollection;
        a();
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.f7274a;
        Object obj = this.b;
        SortedSet subSet = m13221g().subSet(v, v2);
        if (this.d != null) {
            wrappedCollection = this.d;
        }
        return new AbstractMapBasedMultimap$WrappedSortedSet(abstractMapBasedMultimap, obj, subSet, wrappedCollection);
    }

    public SortedSet<V> tailSet(V v) {
        WrappedCollection wrappedCollection;
        a();
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.f7274a;
        Object obj = this.b;
        SortedSet tailSet = m13221g().tailSet(v);
        if (this.d != null) {
            wrappedCollection = this.d;
        }
        return new AbstractMapBasedMultimap$WrappedSortedSet(abstractMapBasedMultimap, obj, tailSet, wrappedCollection);
    }
}
