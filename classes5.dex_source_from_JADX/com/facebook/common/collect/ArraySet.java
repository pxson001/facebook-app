package com.facebook.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: story_save_nux_min_consume_duration */
public class ArraySet<T> implements List<T>, Set<T> {
    public ArrayList<T> f2496a;
    public final boolean f2497b;
    public HashMap<T, Integer> f2498c;

    /* compiled from: story_save_nux_min_consume_duration */
    class ListIter implements ListIterator<T> {
        int f2493a;
        int f2494b = -1;
        final /* synthetic */ ArraySet f2495c;

        ListIter(ArraySet arraySet, int i) {
            this.f2495c = arraySet;
            this.f2493a = i;
        }

        public void add(T t) {
            ArraySet arraySet = this.f2495c;
            int i = this.f2493a;
            this.f2493a = i + 1;
            arraySet.add(i, t);
            this.f2494b = -1;
        }

        public boolean hasNext() {
            return this.f2493a < this.f2495c.f2496a.size();
        }

        public boolean hasPrevious() {
            return this.f2493a > 0;
        }

        public T next() {
            if (this.f2493a >= this.f2495c.f2496a.size()) {
                throw new NoSuchElementException();
            }
            this.f2494b = this.f2493a;
            ArrayList arrayList = this.f2495c.f2496a;
            int i = this.f2493a;
            this.f2493a = i + 1;
            return arrayList.get(i);
        }

        public int nextIndex() {
            return this.f2493a;
        }

        public T previous() {
            int i = this.f2493a - 1;
            if (i < 0) {
                throw new NoSuchElementException();
            }
            this.f2493a = i;
            ArrayList arrayList = this.f2495c.f2496a;
            this.f2494b = i;
            return arrayList.get(i);
        }

        public int previousIndex() {
            return this.f2493a - 1;
        }

        public void remove() {
            if (this.f2494b < 0) {
                throw new IllegalStateException();
            }
            this.f2495c.remove(this.f2494b);
            this.f2493a = this.f2494b;
            this.f2494b = -1;
        }

        public void set(T t) {
            if (this.f2494b < 0) {
                throw new IllegalStateException();
            }
            this.f2495c.set(this.f2494b, t);
        }
    }

    public ArraySet() {
        this(true);
    }

    public ArraySet(boolean z) {
        this.f2496a = new ArrayList();
        this.f2497b = z;
        if (this.f2497b) {
            this.f2498c = new HashMap();
        }
    }

    private int m3623a(Object obj) {
        if (!this.f2497b) {
            return this.f2496a.indexOf(obj);
        }
        Integer num = (Integer) this.f2498c.get(obj);
        return num != null ? num.intValue() : -1;
    }

    private void m3625a(T t, int i) {
        if (this.f2497b) {
            Preconditions.checkState(Objects.equal(this.f2496a.get(i), t));
            this.f2498c.put(t, Integer.valueOf(i));
        }
    }

    private void m3624a(int i) {
        if (i < 0 || i >= this.f2496a.size()) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.f2496a.size());
        }
    }

    private void m3626b(int i) {
        if (i < 0 || i > this.f2496a.size()) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.f2496a.size());
        }
    }

    public boolean add(T t) {
        if (m3623a((Object) t) != -1) {
            return false;
        }
        this.f2496a.add(t);
        m3625a(t, this.f2496a.size() - 1);
        return true;
    }

    public void add(int i, T t) {
        m3626b(i);
        int a = m3623a((Object) t);
        if (a != i) {
            if (a != -1) {
                throw new IllegalArgumentException("Element already exists");
            }
            this.f2496a.add(i, t);
            if (this.f2497b) {
                while (i < this.f2496a.size()) {
                    this.f2498c.put(this.f2496a.get(i), Integer.valueOf(i));
                    i++;
                }
            }
        }
    }

    public boolean addAll(Collection<? extends T> collection) {
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public boolean addAll(int i, Collection<? extends T> collection) {
        boolean z = false;
        m3626b(i);
        if (i == this.f2496a.size()) {
            return addAll(collection);
        }
        ArraySet arraySet = new ArraySet(this.f2497b);
        arraySet.addAll(this.f2496a.subList(0, i));
        if (arraySet.addAll(collection) && arraySet.addAll(this.f2496a.subList(i, size()))) {
            z = true;
        }
        this.f2496a = arraySet.f2496a;
        this.f2498c = arraySet.f2498c;
        return z;
    }

    public void clear() {
        this.f2496a.clear();
        if (this.f2497b) {
            this.f2498c.clear();
        }
    }

    public boolean contains(Object obj) {
        return m3623a(obj) != -1;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public int indexOf(Object obj) {
        return m3623a(obj);
    }

    public boolean isEmpty() {
        return this.f2496a.size() == 0;
    }

    public Iterator<T> iterator() {
        return new ListIter(this, 0);
    }

    public ListIterator<T> listIterator() {
        return new ListIter(this, 0);
    }

    public ListIterator<T> listIterator(int i) {
        m3626b(i);
        return new ListIter(this, i);
    }

    public int lastIndexOf(Object obj) {
        return m3623a(obj);
    }

    public T remove(int i) {
        T remove = this.f2496a.remove(i);
        if (this.f2497b) {
            this.f2498c.remove(remove);
            while (i < size()) {
                this.f2498c.put(this.f2496a.get(i), Integer.valueOf(i));
                i++;
            }
        }
        return remove;
    }

    public boolean remove(Object obj) {
        int a = m3623a(obj);
        if (a == -1) {
            return false;
        }
        Preconditions.checkState(Objects.equal(this.f2496a.get(a), obj));
        int size = this.f2496a.size() - 1;
        if (a < size) {
            Object obj2 = this.f2496a.get(size);
            this.f2496a.set(a, obj2);
            m3625a(obj2, a);
        }
        if (this.f2497b) {
            this.f2498c.remove(obj);
        }
        this.f2496a.remove(size);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation not supported by this set");
    }

    public T set(int i, T t) {
        m3624a(i);
        int a = m3623a((Object) t);
        if (a == i) {
            return t;
        }
        if (a != -1) {
            throw new IllegalArgumentException("Element already exists");
        }
        T t2 = this.f2496a.set(i, t);
        if (this.f2497b) {
            this.f2498c.remove(t2);
            this.f2498c.put(t, Integer.valueOf(i));
        }
        return t2;
    }

    public int size() {
        return this.f2496a.size();
    }

    public List subList(int i, int i2) {
        List arraySet = new ArraySet(this.f2497b);
        arraySet.addAll(this.f2496a.subList(i, i2));
        return arraySet;
    }

    public T get(int i) {
        return this.f2496a.get(i);
    }

    public Object[] toArray() {
        return this.f2496a.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f2496a.toArray(tArr);
    }
}
