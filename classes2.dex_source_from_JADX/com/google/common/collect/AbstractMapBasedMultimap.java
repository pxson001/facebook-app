package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps.ViewCachingAbstractMap;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: url= */
public abstract class AbstractMapBasedMultimap<K, V> extends AbstractMultimap<K, V> implements Serializable {
    public transient Map<K, Collection<V>> f1543a;
    public transient int f1544b;

    /* compiled from: url= */
    class RandomAccessWrappedList extends WrappedList implements RandomAccess {
        final /* synthetic */ AbstractMapBasedMultimap f7976a;

        RandomAccessWrappedList(AbstractMapBasedMultimap abstractMapBasedMultimap, @Nullable K k, List<V> list, @Nullable WrappedCollection wrappedCollection) {
            this.f7976a = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, list, wrappedCollection);
        }
    }

    /* compiled from: url= */
    class WrappedList extends WrappedCollection implements List<V> {
        final /* synthetic */ AbstractMapBasedMultimap f7977g;

        final List<V> m12550g() {
            return (List) this.f7979c;
        }

        WrappedList(AbstractMapBasedMultimap abstractMapBasedMultimap, @Nullable K k, List<V> list, @Nullable WrappedCollection wrappedCollection) {
            this.f7977g = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, list, wrappedCollection);
        }

        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = m12550g().addAll(i, collection);
            if (!addAll) {
                return addAll;
            }
            int size2 = this.f7979c.size();
            this.f7977g.f1544b = (size2 - size) + this.f7977g.f1544b;
            if (size != 0) {
                return addAll;
            }
            m12553d();
            return addAll;
        }

        public V get(int i) {
            m12551a();
            return m12550g().get(i);
        }

        public V set(int i, V v) {
            m12551a();
            return m12550g().set(i, v);
        }

        public void add(int i, V v) {
            m12551a();
            boolean isEmpty = this.f7979c.isEmpty();
            m12550g().add(i, v);
            this.f7977g.f1544b = this.f7977g.f1544b + 1;
            if (isEmpty) {
                m12553d();
            }
        }

        public V remove(int i) {
            m12551a();
            V remove = m12550g().remove(i);
            this.f7977g.f1544b = this.f7977g.f1544b - 1;
            m12552b();
            return remove;
        }

        public int indexOf(Object obj) {
            m12551a();
            return m12550g().indexOf(obj);
        }

        public int lastIndexOf(Object obj) {
            m12551a();
            return m12550g().lastIndexOf(obj);
        }

        public ListIterator<V> listIterator() {
            m12551a();
            return new WrappedListIterator(this);
        }

        public ListIterator<V> listIterator(int i) {
            m12551a();
            return new WrappedListIterator(this, i);
        }

        public List<V> subList(int i, int i2) {
            WrappedCollection wrappedCollection;
            m12551a();
            AbstractMapBasedMultimap abstractMapBasedMultimap = this.f7977g;
            Object obj = this.f7978b;
            List subList = m12550g().subList(i, i2);
            if (this.f7980d != null) {
                wrappedCollection = this.f7980d;
            }
            return AbstractMapBasedMultimap.m2996a(abstractMapBasedMultimap, obj, subList, wrappedCollection);
        }
    }

    /* compiled from: url= */
    public class WrappedCollection extends AbstractCollection<V> {
        public final K f7978b;
        public Collection<V> f7979c;
        public final WrappedCollection f7980d;
        final Collection<V> f7981e;
        final /* synthetic */ AbstractMapBasedMultimap f7982f;

        /* compiled from: url= */
        public class WrappedIterator implements Iterator<V> {
            final Iterator<V> f7983a;
            final Collection<V> f7984b = this.f7985c.f7979c;
            final /* synthetic */ WrappedCollection f7985c;

            WrappedIterator(WrappedCollection wrappedCollection) {
                this.f7985c = wrappedCollection;
                AbstractMapBasedMultimap abstractMapBasedMultimap = wrappedCollection.f7982f;
                this.f7983a = AbstractMapBasedMultimap.m2998b(wrappedCollection.f7979c);
            }

            WrappedIterator(WrappedCollection wrappedCollection, Iterator<V> it) {
                this.f7985c = wrappedCollection;
                this.f7983a = it;
            }

            private void m12554b() {
                this.f7985c.m12551a();
                if (this.f7985c.f7979c != this.f7984b) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                m12554b();
                return this.f7983a.hasNext();
            }

            public V next() {
                m12554b();
                return this.f7983a.next();
            }

            public void remove() {
                this.f7983a.remove();
                this.f7985c.f7982f.f1544b = this.f7985c.f7982f.f1544b - 1;
                this.f7985c.m12552b();
            }

            final Iterator<V> m12555a() {
                m12554b();
                return this.f7983a;
            }
        }

        WrappedCollection(AbstractMapBasedMultimap abstractMapBasedMultimap, @Nullable K k, Collection<V> collection, @Nullable WrappedCollection wrappedCollection) {
            Collection collection2;
            this.f7982f = abstractMapBasedMultimap;
            this.f7978b = k;
            this.f7979c = collection;
            this.f7980d = wrappedCollection;
            if (wrappedCollection == null) {
                collection2 = null;
            } else {
                collection2 = wrappedCollection.f7979c;
            }
            this.f7981e = collection2;
        }

        final void m12551a() {
            if (this.f7980d != null) {
                this.f7980d.m12551a();
                if (this.f7980d.f7979c != this.f7981e) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.f7979c.isEmpty()) {
                Collection collection = (Collection) this.f7982f.f1543a.get(this.f7978b);
                if (collection != null) {
                    this.f7979c = collection;
                }
            }
        }

        final void m12552b() {
            if (this.f7980d != null) {
                this.f7980d.m12552b();
            } else if (this.f7979c.isEmpty()) {
                this.f7982f.f1543a.remove(this.f7978b);
            }
        }

        final void m12553d() {
            if (this.f7980d != null) {
                this.f7980d.m12553d();
            } else {
                this.f7982f.f1543a.put(this.f7978b, this.f7979c);
            }
        }

        public int size() {
            m12551a();
            return this.f7979c.size();
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            m12551a();
            return this.f7979c.equals(obj);
        }

        public int hashCode() {
            m12551a();
            return this.f7979c.hashCode();
        }

        public String toString() {
            m12551a();
            return this.f7979c.toString();
        }

        public Iterator<V> iterator() {
            m12551a();
            return new WrappedIterator(this);
        }

        public boolean add(V v) {
            m12551a();
            boolean isEmpty = this.f7979c.isEmpty();
            boolean add = this.f7979c.add(v);
            if (add) {
                this.f7982f.f1544b = this.f7982f.f1544b + 1;
                if (isEmpty) {
                    m12553d();
                }
            }
            return add;
        }

        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.f7979c.addAll(collection);
            if (!addAll) {
                return addAll;
            }
            int size2 = this.f7979c.size();
            this.f7982f.f1544b = (size2 - size) + this.f7982f.f1544b;
            if (size != 0) {
                return addAll;
            }
            m12553d();
            return addAll;
        }

        public boolean contains(Object obj) {
            m12551a();
            return this.f7979c.contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            m12551a();
            return this.f7979c.containsAll(collection);
        }

        public void clear() {
            int size = size();
            if (size != 0) {
                this.f7979c.clear();
                this.f7982f.f1544b -= size;
                m12552b();
            }
        }

        public boolean remove(Object obj) {
            m12551a();
            boolean remove = this.f7979c.remove(obj);
            if (remove) {
                this.f7982f.f1544b = this.f7982f.f1544b - 1;
                m12552b();
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.f7979c.removeAll(collection);
            if (!removeAll) {
                return removeAll;
            }
            int size2 = this.f7979c.size();
            this.f7982f.f1544b = (size2 - size) + this.f7982f.f1544b;
            m12552b();
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            Preconditions.checkNotNull(collection);
            int size = size();
            boolean retainAll = this.f7979c.retainAll(collection);
            if (retainAll) {
                int size2 = this.f7979c.size();
                this.f7982f.f1544b = (size2 - size) + this.f7982f.f1544b;
                m12552b();
            }
            return retainAll;
        }
    }

    /* compiled from: url= */
    class C06611 extends Itr<V> {
        final /* synthetic */ AbstractMapBasedMultimap f15137a;

        C06611(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            this.f15137a = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap);
        }

        final V mo2840a(K k, V v) {
            return v;
        }
    }

    /* compiled from: url= */
    abstract class Itr<T> implements Iterator<T> {
        final Iterator<Entry<K, Collection<V>>> f15138b;
        K f15139c = null;
        Collection<V> f15140d = null;
        Iterator<V> f15141e = Iterators.f694b;
        final /* synthetic */ AbstractMapBasedMultimap f15142f;

        abstract T mo2840a(K k, V v);

        Itr(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            this.f15142f = abstractMapBasedMultimap;
            this.f15138b = abstractMapBasedMultimap.f1543a.entrySet().iterator();
        }

        public boolean hasNext() {
            return this.f15138b.hasNext() || this.f15141e.hasNext();
        }

        public T next() {
            if (!this.f15141e.hasNext()) {
                Entry entry = (Entry) this.f15138b.next();
                this.f15139c = entry.getKey();
                this.f15140d = (Collection) entry.getValue();
                this.f15141e = this.f15140d.iterator();
            }
            return mo2840a(this.f15139c, this.f15141e.next());
        }

        public void remove() {
            this.f15141e.remove();
            if (this.f15140d.isEmpty()) {
                this.f15138b.remove();
            }
            this.f15142f.f1544b = this.f15142f.f1544b - 1;
        }
    }

    /* compiled from: url= */
    class KeySet extends com.google.common.collect.Maps.KeySet<K, Collection<V>> {
        final /* synthetic */ AbstractMapBasedMultimap f15143a;

        KeySet(AbstractMapBasedMultimap abstractMapBasedMultimap, Map<K, Collection<V>> map) {
            this.f15143a = abstractMapBasedMultimap;
            super(map);
        }

        public Iterator<K> iterator() {
            final Iterator it = m21659a().entrySet().iterator();
            return new Iterator<K>(this) {
                Entry<K, Collection<V>> f15145a;
                final /* synthetic */ KeySet f15147c;

                public boolean hasNext() {
                    return it.hasNext();
                }

                public K next() {
                    this.f15145a = (Entry) it.next();
                    return this.f15145a.getKey();
                }

                public void remove() {
                    CollectPreconditions.m617a(this.f15145a != null);
                    Collection collection = (Collection) this.f15145a.getValue();
                    it.remove();
                    this.f15147c.f15143a.f1544b -= collection.size();
                    collection.clear();
                }
            };
        }

        public boolean remove(Object obj) {
            int i;
            Collection collection = (Collection) m21659a().remove(obj);
            if (collection != null) {
                int size = collection.size();
                collection.clear();
                this.f15143a.f1544b -= size;
                i = size;
            } else {
                i = 0;
            }
            return i > 0;
        }

        public void clear() {
            Iterators.m1429h(iterator());
        }

        public boolean containsAll(Collection<?> collection) {
            return m21659a().keySet().containsAll(collection);
        }

        public boolean equals(@Nullable Object obj) {
            return this == obj || m21659a().keySet().equals(obj);
        }

        public int hashCode() {
            return m21659a().keySet().hashCode();
        }
    }

    /* compiled from: url= */
    class WrappedSet extends WrappedCollection implements Set<V> {
        final /* synthetic */ AbstractMapBasedMultimap f19192a;

        WrappedSet(AbstractMapBasedMultimap abstractMapBasedMultimap, @Nullable K k, Set<V> set) {
            this.f19192a = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, set, null);
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean a = Sets.m1321a((Set) this.f7979c, (Collection) collection);
            if (!a) {
                return a;
            }
            int size2 = this.f7979c.size();
            this.f19192a.f1544b = (size2 - size) + this.f19192a.f1544b;
            m12552b();
            return a;
        }
    }

    /* compiled from: url= */
    public class AsMap extends ViewCachingAbstractMap<K, Collection<V>> {
        final transient Map<K, Collection<V>> f23129a;
        public final /* synthetic */ AbstractMapBasedMultimap f23130b;

        AsMap(AbstractMapBasedMultimap abstractMapBasedMultimap, Map<K, Collection<V>> map) {
            this.f23130b = abstractMapBasedMultimap;
            this.f23129a = map;
        }

        protected final Set<Entry<K, Collection<V>>> mo3403a() {
            return new AsMapEntries(this);
        }

        public boolean containsKey(Object obj) {
            return Maps.m835b(this.f23129a, obj);
        }

        public Object get(Object obj) {
            Collection collection = (Collection) Maps.m810a(this.f23129a, obj);
            if (collection == null) {
                return null;
            }
            return this.f23130b.m3000a(obj, collection);
        }

        public Set<K> keySet() {
            return this.f23130b.mo421p();
        }

        public int size() {
            return this.f23129a.size();
        }

        public Object remove(Object obj) {
            Collection collection = (Collection) this.f23129a.remove(obj);
            if (collection == null) {
                return null;
            }
            Collection c = this.f23130b.mo411c();
            c.addAll(collection);
            this.f23130b.f1544b -= collection.size();
            collection.clear();
            return c;
        }

        public boolean equals(@Nullable Object obj) {
            return this == obj || this.f23129a.equals(obj);
        }

        public int hashCode() {
            return this.f23129a.hashCode();
        }

        public String toString() {
            return this.f23129a.toString();
        }

        public void clear() {
            if (this.f23129a == this.f23130b.f1543a) {
                this.f23130b.mo415g();
            } else {
                Iterators.m1429h(new AsMapIterator(this));
            }
        }
    }

    abstract Collection<V> mo411c();

    protected AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        Preconditions.checkArgument(map.isEmpty());
        this.f1543a = map;
    }

    final void m3001a(Map<K, Collection<V>> map) {
        this.f1543a = map;
        this.f1544b = 0;
        for (Collection collection : map.values()) {
            boolean z;
            if (collection.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkArgument(z);
            this.f1544b = collection.size() + this.f1544b;
        }
    }

    Collection<V> mo428d() {
        return m2995a(mo411c());
    }

    Collection<V> m3007e(@Nullable K k) {
        return mo411c();
    }

    public int mo413f() {
        return this.f1544b;
    }

    public boolean mo414f(@Nullable Object obj) {
        return this.f1543a.containsKey(obj);
    }

    public boolean mo431a(@Nullable K k, @Nullable V v) {
        Collection collection = (Collection) this.f1543a.get(k);
        if (collection == null) {
            collection = m3007e(k);
            if (collection.add(v)) {
                this.f1544b++;
                this.f1543a.put(k, collection);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v)) {
            return false;
        } else {
            this.f1544b++;
            return true;
        }
    }

    public Collection<V> mo429d(@Nullable Object obj) {
        Collection collection = (Collection) this.f1543a.remove(obj);
        if (collection == null) {
            return mo428d();
        }
        Collection c = mo411c();
        c.addAll(collection);
        this.f1544b -= collection.size();
        collection.clear();
        return m2995a(c);
    }

    private static Collection<V> m2995a(Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        if (collection instanceof List) {
            return Collections.unmodifiableList((List) collection);
        }
        return Collections.unmodifiableCollection(collection);
    }

    public void mo415g() {
        for (Collection clear : this.f1543a.values()) {
            clear.clear();
        }
        this.f1543a.clear();
        this.f1544b = 0;
    }

    public Collection<V> mo427c(@Nullable K k) {
        Collection collection = (Collection) this.f1543a.get(k);
        if (collection == null) {
            collection = m3007e(k);
        }
        return m3000a((Object) k, collection);
    }

    public final Collection<V> m3000a(@Nullable K k, Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return new WrappedSortedSet(this, k, (SortedSet) collection, null);
        }
        if (collection instanceof Set) {
            return new WrappedSet(this, k, (Set) collection);
        }
        if (collection instanceof List) {
            return m2996a(this, k, (List) collection, null);
        }
        return new WrappedCollection(this, k, collection, null);
    }

    public static List m2996a(@Nullable AbstractMapBasedMultimap abstractMapBasedMultimap, Object obj, @Nullable List list, WrappedCollection wrappedCollection) {
        return list instanceof RandomAccess ? new RandomAccessWrappedList(abstractMapBasedMultimap, obj, list, wrappedCollection) : new WrappedList(abstractMapBasedMultimap, obj, list, wrappedCollection);
    }

    public static Iterator<V> m2998b(Collection<V> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    final Set<K> mo432h() {
        return this.f1543a instanceof SortedMap ? new SortedKeySet(this, (SortedMap) this.f1543a) : new KeySet(this, this.f1543a);
    }

    Iterator<V> mo433j() {
        return new C06611(this);
    }

    Iterator<Entry<K, V>> mo434l() {
        return new 2(this);
    }

    final Map<K, Collection<V>> mo435m() {
        return this.f1543a instanceof SortedMap ? new SortedAsMap(this, (SortedMap) this.f1543a) : new AsMap(this, this.f1543a);
    }
}
