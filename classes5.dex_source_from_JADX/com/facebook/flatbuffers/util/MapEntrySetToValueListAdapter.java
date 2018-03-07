package com.facebook.flatbuffers.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: remove_item_action_info */
public class MapEntrySetToValueListAdapter<K, V> implements List<V> {
    private final Set<Entry<K, V>> f3170a;

    public MapEntrySetToValueListAdapter(Set<Entry<K, V>> set) {
        this.f3170a = set;
    }

    public int size() {
        return this.f3170a.size();
    }

    public Iterator<V> iterator() {
        final Iterator it = this.f3170a.iterator();
        return new Iterator<V>(this) {
            final /* synthetic */ MapEntrySetToValueListAdapter f3169b;

            public boolean hasNext() {
                return it.hasNext();
            }

            public V next() {
                return ((Entry) it.next()).getValue();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public void add(int i, V v) {
        throw new UnsupportedOperationException();
    }

    public boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int i, Collection<? extends V> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends V> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public V get(int i) {
        throw new UnsupportedOperationException();
    }

    public int indexOf(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    public int lastIndexOf(Object obj) {
        throw new UnsupportedOperationException();
    }

    public ListIterator<V> listIterator() {
        throw new UnsupportedOperationException();
    }

    public ListIterator<V> listIterator(int i) {
        throw new UnsupportedOperationException();
    }

    public V remove(int i) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public V set(int i, V v) {
        throw new UnsupportedOperationException();
    }

    public List<V> subList(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public <T> T[] toArray(T[] tArr) {
        throw new UnsupportedOperationException();
    }
}
