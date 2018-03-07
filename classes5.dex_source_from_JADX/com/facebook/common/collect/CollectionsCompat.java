package com.facebook.common.collect;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: story_save_nux_max_consume_duration */
public class CollectionsCompat {

    /* compiled from: story_save_nux_max_consume_duration */
    class SetFromMap<E> extends AbstractSet<E> implements Serializable {
        private transient Set<E> f2499a;
        private Map<E, Boolean> f2500m;

        SetFromMap(Map<E, Boolean> map) {
            this.f2500m = map;
            this.f2499a = map.keySet();
        }

        public boolean equals(Object obj) {
            return this.f2499a.equals(obj);
        }

        public int hashCode() {
            return this.f2499a.hashCode();
        }

        public boolean add(E e) {
            return this.f2500m.put(e, Boolean.TRUE) == null;
        }

        public void clear() {
            this.f2500m.clear();
        }

        public String toString() {
            return this.f2499a.toString();
        }

        public boolean contains(Object obj) {
            return this.f2499a.contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return this.f2499a.containsAll(collection);
        }

        public boolean isEmpty() {
            return this.f2500m.isEmpty();
        }

        public boolean remove(Object obj) {
            return this.f2500m.remove(obj) != null;
        }

        public boolean retainAll(Collection<?> collection) {
            return this.f2499a.retainAll(collection);
        }

        public Object[] toArray() {
            return this.f2499a.toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f2499a.toArray(tArr);
        }

        public Iterator<E> iterator() {
            return this.f2499a.iterator();
        }

        public int size() {
            return this.f2500m.size();
        }

        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            this.f2499a = this.f2500m.keySet();
        }
    }

    public static <E> Set<E> m3627a(Map<E, Boolean> map) {
        if (map.isEmpty()) {
            return new SetFromMap(map);
        }
        throw new IllegalArgumentException();
    }
}
