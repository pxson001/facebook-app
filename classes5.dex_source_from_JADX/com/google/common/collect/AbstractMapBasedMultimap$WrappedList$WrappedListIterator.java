package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection.WrappedIterator;
import com.google.common.collect.AbstractMapBasedMultimap.WrappedList;
import java.util.ListIterator;

/* compiled from: cameraTargetLng */
class AbstractMapBasedMultimap$WrappedList$WrappedListIterator extends WrappedIterator implements ListIterator<V> {
    final /* synthetic */ WrappedList f7273d;

    AbstractMapBasedMultimap$WrappedList$WrappedListIterator(WrappedList wrappedList) {
        this.f7273d = wrappedList;
        super(wrappedList);
    }

    public AbstractMapBasedMultimap$WrappedList$WrappedListIterator(WrappedList wrappedList, int i) {
        this.f7273d = wrappedList;
        super(wrappedList, wrappedList.g().listIterator(i));
    }

    private ListIterator<V> m13220b() {
        return (ListIterator) a();
    }

    public boolean hasPrevious() {
        return m13220b().hasPrevious();
    }

    public V previous() {
        return m13220b().previous();
    }

    public int nextIndex() {
        return m13220b().nextIndex();
    }

    public int previousIndex() {
        return m13220b().previousIndex();
    }

    public void set(V v) {
        m13220b().set(v);
    }

    public void add(V v) {
        boolean isEmpty = this.f7273d.isEmpty();
        m13220b().add(v);
        AbstractMapBasedMultimap.c(this.f7273d.g);
        if (isEmpty) {
            this.f7273d.d();
        }
    }
}
