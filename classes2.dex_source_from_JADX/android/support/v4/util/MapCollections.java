package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: {"er */
abstract class MapCollections<K, V> {
    EntrySet f228b;
    KeySet f229c;
    ValuesCollection f230d;

    /* compiled from: {"er */
    final class ValuesCollection implements Collection<V> {
        final /* synthetic */ MapCollections f18699a;

        ValuesCollection(MapCollections mapCollections) {
            this.f18699a = mapCollections;
        }

        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            this.f18699a.m446c();
        }

        public final boolean contains(Object obj) {
            return this.f18699a.m443b(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return this.f18699a.m436a() == 0;
        }

        public final Iterator<V> iterator() {
            return new ArrayIterator(this.f18699a, 1);
        }

        public final boolean remove(Object obj) {
            int b = this.f18699a.m443b(obj);
            if (b < 0) {
                return false;
            }
            this.f18699a.m440a(b);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            int i = 0;
            int a = this.f18699a.m436a();
            boolean z = false;
            while (i < a) {
                if (collection.contains(this.f18699a.m438a(i, 1))) {
                    this.f18699a.m440a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final boolean retainAll(Collection<?> collection) {
            int i = 0;
            int a = this.f18699a.m436a();
            boolean z = false;
            while (i < a) {
                if (!collection.contains(this.f18699a.m438a(i, 1))) {
                    this.f18699a.m440a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final int size() {
            return this.f18699a.m436a();
        }

        public final Object[] toArray() {
            return this.f18699a.m445b(1);
        }

        public final <T> T[] toArray(T[] tArr) {
            return this.f18699a.m442a((Object[]) tArr, 1);
        }
    }

    /* compiled from: {"er */
    final class ArrayIterator<T> implements Iterator<T> {
        final int f18700a;
        int f18701b;
        int f18702c;
        boolean f18703d = false;
        final /* synthetic */ MapCollections f18704e;

        ArrayIterator(MapCollections mapCollections, int i) {
            this.f18704e = mapCollections;
            this.f18700a = i;
            this.f18701b = mapCollections.m436a();
        }

        public final boolean hasNext() {
            return this.f18702c < this.f18701b;
        }

        public final T next() {
            T a = this.f18704e.m438a(this.f18702c, this.f18700a);
            this.f18702c++;
            this.f18703d = true;
            return a;
        }

        public final void remove() {
            if (this.f18703d) {
                this.f18702c--;
                this.f18701b--;
                this.f18703d = false;
                this.f18704e.m440a(this.f18702c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: {"er */
    final class KeySet implements Set<K> {
        final /* synthetic */ MapCollections f18705a;

        KeySet(MapCollections mapCollections) {
            this.f18705a = mapCollections;
        }

        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            this.f18705a.m446c();
        }

        public final boolean contains(Object obj) {
            return this.f18705a.m437a(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            boolean z;
            Map b = this.f18705a.m444b();
            for (Object containsKey : collection) {
                if (!b.containsKey(containsKey)) {
                    z = false;
                    break;
                }
            }
            z = true;
            return z;
        }

        public final boolean isEmpty() {
            return this.f18705a.m436a() == 0;
        }

        public final Iterator<K> iterator() {
            return new ArrayIterator(this.f18705a, 0);
        }

        public final boolean remove(Object obj) {
            int a = this.f18705a.m437a(obj);
            if (a < 0) {
                return false;
            }
            this.f18705a.m440a(a);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            Map b = this.f18705a.m444b();
            int size = b.size();
            for (Object remove : collection) {
                b.remove(remove);
            }
            return size != b.size();
        }

        public final boolean retainAll(Collection<?> collection) {
            return MapCollections.m435c(this.f18705a.m444b(), collection);
        }

        public final int size() {
            return this.f18705a.m436a();
        }

        public final Object[] toArray() {
            return this.f18705a.m445b(0);
        }

        public final <T> T[] toArray(T[] tArr) {
            return this.f18705a.m442a((Object[]) tArr, 0);
        }

        public final boolean equals(Object obj) {
            return MapCollections.m434a((Set) this, obj);
        }

        public final int hashCode() {
            int i = 0;
            for (int a = this.f18705a.m436a() - 1; a >= 0; a--) {
                Object a2 = this.f18705a.m438a(a, 0);
                i += a2 == null ? 0 : a2.hashCode();
            }
            return i;
        }
    }

    /* compiled from: {"er */
    final class EntrySet implements Set<Entry<K, V>> {
        final /* synthetic */ MapCollections f19660a;

        EntrySet(MapCollections mapCollections) {
            this.f19660a = mapCollections;
        }

        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int a = this.f19660a.m436a();
            for (Entry entry : collection) {
                this.f19660a.m441a(entry.getKey(), entry.getValue());
            }
            return a != this.f19660a.m436a();
        }

        public final void clear() {
            this.f19660a.m446c();
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = this.f19660a.m437a(entry.getKey());
            if (a >= 0) {
                return ContainerHelpers.a(this.f19660a.m438a(a, 1), entry.getValue());
            }
            return false;
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return this.f19660a.m436a() == 0;
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new MapIterator(this.f19660a);
        }

        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final int size() {
            return this.f19660a.m436a();
        }

        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public final boolean equals(Object obj) {
            return MapCollections.m434a((Set) this, obj);
        }

        public final int hashCode() {
            int a = this.f19660a.m436a() - 1;
            int i = 0;
            while (a >= 0) {
                Object a2 = this.f19660a.m438a(a, 0);
                Object a3 = this.f19660a.m438a(a, 1);
                a--;
                i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
            }
            return i;
        }
    }

    /* compiled from: {"er */
    final class MapIterator implements Iterator<Entry<K, V>>, Entry<K, V> {
        int f19661a;
        int f19662b;
        boolean f19663c = false;
        final /* synthetic */ MapCollections f19664d;

        MapIterator(MapCollections mapCollections) {
            this.f19664d = mapCollections;
            this.f19661a = mapCollections.m436a() - 1;
            this.f19662b = -1;
        }

        public final boolean hasNext() {
            return this.f19662b < this.f19661a;
        }

        public final Object next() {
            this.f19662b++;
            this.f19663c = true;
            return this;
        }

        public final void remove() {
            if (this.f19663c) {
                this.f19664d.m440a(this.f19662b);
                this.f19662b--;
                this.f19661a--;
                this.f19663c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public final K getKey() {
            if (this.f19663c) {
                return this.f19664d.m438a(this.f19662b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V getValue() {
            if (this.f19663c) {
                return this.f19664d.m438a(this.f19662b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V setValue(V v) {
            if (this.f19663c) {
                return this.f19664d.m439a(this.f19662b, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            if (!this.f19663c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (ContainerHelpers.a(entry.getKey(), this.f19664d.m438a(this.f19662b, 0)) && ContainerHelpers.a(entry.getValue(), this.f19664d.m438a(this.f19662b, 1))) {
                    return true;
                }
                return false;
            }
        }

        public final int hashCode() {
            int i = 0;
            if (this.f19663c) {
                Object a = this.f19664d.m438a(this.f19662b, 0);
                Object a2 = this.f19664d.m438a(this.f19662b, 1);
                int hashCode = a == null ? 0 : a.hashCode();
                if (a2 != null) {
                    i = a2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    protected abstract int m436a();

    protected abstract int m437a(Object obj);

    protected abstract Object m438a(int i, int i2);

    protected abstract V m439a(int i, V v);

    protected abstract void m440a(int i);

    protected abstract void m441a(K k, V v);

    protected abstract int m443b(Object obj);

    protected abstract Map<K, V> m444b();

    protected abstract void m446c();

    MapCollections() {
    }

    public static <K, V> boolean m435c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public final Object[] m445b(int i) {
        int a = m436a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = m438a(i2, i);
        }
        return objArr;
    }

    public final <T> T[] m442a(T[] tArr, int i) {
        T[] tArr2;
        int a = m436a();
        if (tArr.length < a) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = m438a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    public static <T> boolean m434a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() == set2.size() && set.containsAll(set2)) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public final Set<Entry<K, V>> m447d() {
        if (this.f228b == null) {
            this.f228b = new EntrySet(this);
        }
        return this.f228b;
    }

    public final Set<K> m448e() {
        if (this.f229c == null) {
            this.f229c = new KeySet(this);
        }
        return this.f229c;
    }

    public final Collection<V> m449f() {
        if (this.f230d == null) {
            this.f230d = new ValuesCollection(this);
        }
        return this.f230d;
    }
}
