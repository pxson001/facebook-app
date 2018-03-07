package com.facebook.flatbuffers.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: removed */
public class MapEntrySetToKeyListAdapter<K, V> implements List<K> {
    private final Set<Entry<K, V>> f3167a;

    public MapEntrySetToKeyListAdapter(Set<Entry<K, V>> set) {
        this.f3167a = set;
    }

    public int size() {
        return this.f3167a.size();
    }

    public Iterator<K> iterator() {
        final Iterator it = this.f3167a.iterator();
        return new Iterator<K>(this) {
            final /* synthetic */ MapEntrySetToKeyListAdapter f3166b;

            public boolean hasNext() {
                return it.hasNext();
            }

            public K next() {
                return ((Entry) it.next()).getKey();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public void add(int i, K k) {
        throw new UnsupportedOperationException();
    }

    public boolean add(K k) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int i, Collection<? extends K> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends K> collection) {
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

    public K get(int i) {
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

    public ListIterator<K> listIterator() {
        throw new UnsupportedOperationException();
    }

    public ListIterator<K> listIterator(int i) {
        throw new UnsupportedOperationException();
    }

    public K remove(int i) {
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

    public K set(int i, K k) {
        throw new UnsupportedOperationException();
    }

    public List<K> subList(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public <T> T[] toArray(T[] tArr) {
        throw new UnsupportedOperationException();
    }
}
