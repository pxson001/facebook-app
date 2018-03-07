package com.google.protobuf;

import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.FieldSet.FieldDescriptorLite;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: allowedChars */
public class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    public final int f20997a;
    public List<Entry> f20998b = Collections.emptyList();
    public Map<K, V> f20999c = Collections.emptyMap();
    public boolean f21000d;
    private volatile EntrySet f21001e;

    /* compiled from: allowedChars */
    final class C24441 extends SmallSortedMap<FieldDescriptorType, Object> {
        C24441(int i) {
            super(i);
        }

        public final /* synthetic */ Object put(Object obj, Object obj2) {
            return super.m21450a((FieldDescriptor) obj, obj2);
        }

        public final void mo921a() {
            if (!this.f21000d) {
                for (int i = 0; i < m21453c(); i++) {
                    java.util.Map.Entry b = m21452b(i);
                    if (((FieldDescriptor) b.getKey()).m21239m()) {
                        b.setValue(Collections.unmodifiableList((List) b.getValue()));
                    }
                }
                for (java.util.Map.Entry entry : m21454d()) {
                    if (((FieldDescriptor) entry.getKey()).m21239m()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.mo921a();
        }
    }

    /* compiled from: allowedChars */
    public class EmptySet {
        public static final Iterator<Object> f21002a = new C24451();
        public static final Iterable<Object> f21003b = new C24462();

        /* compiled from: allowedChars */
        final class C24451 implements Iterator<Object> {
            C24451() {
            }

            public final boolean hasNext() {
                return false;
            }

            public final Object next() {
                throw new NoSuchElementException();
            }

            public final void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* compiled from: allowedChars */
        final class C24462 implements Iterable<Object> {
            C24462() {
            }

            public final Iterator<Object> iterator() {
                return EmptySet.f21002a;
            }
        }
    }

    /* compiled from: allowedChars */
    public class Entry implements Comparable<Entry>, java.util.Map.Entry<K, V> {
        final /* synthetic */ SmallSortedMap f21004a;
        public final K f21005b;
        private V f21006c;

        public int compareTo(Object obj) {
            return this.f21005b.compareTo(((Entry) obj).f21005b);
        }

        Entry(SmallSortedMap smallSortedMap, java.util.Map.Entry<K, V> entry) {
            this(smallSortedMap, (Comparable) entry.getKey(), entry.getValue());
        }

        Entry(SmallSortedMap smallSortedMap, K k, V v) {
            this.f21004a = smallSortedMap;
            this.f21005b = k;
            this.f21006c = v;
        }

        public /* synthetic */ Object getKey() {
            return this.f21005b;
        }

        public V getValue() {
            return this.f21006c;
        }

        public V setValue(V v) {
            SmallSortedMap.m21448e(this.f21004a);
            V v2 = this.f21006c;
            this.f21006c = v;
            return v2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            if (m21456a(this.f21005b, entry.getKey()) && m21456a(this.f21006c, entry.getValue())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.f21005b == null ? 0 : this.f21005b.hashCode();
            if (this.f21006c != null) {
                i = this.f21006c.hashCode();
            }
            return hashCode ^ i;
        }

        public String toString() {
            return this.f21005b + "=" + this.f21006c;
        }

        private static boolean m21456a(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            } else {
                return obj.equals(obj2);
            }
        }
    }

    /* compiled from: allowedChars */
    class EntryIterator implements Iterator<java.util.Map.Entry<K, V>> {
        final /* synthetic */ SmallSortedMap f21007a;
        private int f21008b = -1;
        private boolean f21009c;
        private Iterator<java.util.Map.Entry<K, V>> f21010d;

        public EntryIterator(SmallSortedMap smallSortedMap) {
            this.f21007a = smallSortedMap;
        }

        public boolean hasNext() {
            return this.f21008b + 1 < this.f21007a.f20998b.size() || m21457b().hasNext();
        }

        public Object next() {
            this.f21009c = true;
            int i = this.f21008b + 1;
            this.f21008b = i;
            if (i < this.f21007a.f20998b.size()) {
                return (java.util.Map.Entry) this.f21007a.f20998b.get(this.f21008b);
            }
            return (java.util.Map.Entry) m21457b().next();
        }

        public void remove() {
            if (this.f21009c) {
                this.f21009c = false;
                SmallSortedMap.m21448e(this.f21007a);
                if (this.f21008b < this.f21007a.f20998b.size()) {
                    SmallSortedMap smallSortedMap = this.f21007a;
                    int i = this.f21008b;
                    this.f21008b = i - 1;
                    SmallSortedMap.m21447c(smallSortedMap, i);
                    return;
                }
                m21457b().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        private Iterator<java.util.Map.Entry<K, V>> m21457b() {
            if (this.f21010d == null) {
                this.f21010d = this.f21007a.f20999c.entrySet().iterator();
            }
            return this.f21010d;
        }
    }

    /* compiled from: allowedChars */
    class EntrySet extends AbstractSet<java.util.Map.Entry<K, V>> {
        final /* synthetic */ SmallSortedMap f21011a;

        public EntrySet(SmallSortedMap smallSortedMap) {
            this.f21011a = smallSortedMap;
        }

        public boolean add(Object obj) {
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            if (contains(entry)) {
                return false;
            }
            this.f21011a.m21450a((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public Iterator<java.util.Map.Entry<K, V>> iterator() {
            return new EntryIterator(this.f21011a);
        }

        public int size() {
            return this.f21011a.size();
        }

        public boolean contains(Object obj) {
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            Object obj2 = this.f21011a.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        public boolean remove(Object obj) {
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            this.f21011a.remove(entry.getKey());
            return true;
        }

        public void clear() {
            this.f21011a.clear();
        }
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m21450a((Comparable) obj, obj2);
    }

    static <FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> SmallSortedMap<FieldDescriptorType, Object> m21446a(int i) {
        return new C24441(i);
    }

    public SmallSortedMap(int i) {
        this.f20997a = i;
    }

    public void mo921a() {
        if (!this.f21000d) {
            Map emptyMap;
            if (this.f20999c.isEmpty()) {
                emptyMap = Collections.emptyMap();
            } else {
                emptyMap = Collections.unmodifiableMap(this.f20999c);
            }
            this.f20999c = emptyMap;
            this.f21000d = true;
        }
    }

    public final int m21453c() {
        return this.f20998b.size();
    }

    public final java.util.Map.Entry<K, V> m21452b(int i) {
        return (java.util.Map.Entry) this.f20998b.get(i);
    }

    public final Iterable<java.util.Map.Entry<K, V>> m21454d() {
        if (this.f20999c.isEmpty()) {
            return EmptySet.f21003b;
        }
        return this.f20999c.entrySet();
    }

    public int size() {
        return this.f20998b.size() + this.f20999c.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return m21445a(comparable) >= 0 || this.f20999c.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a = m21445a(comparable);
        if (a >= 0) {
            return ((Entry) this.f20998b.get(a)).getValue();
        }
        return this.f20999c.get(comparable);
    }

    public final V m21450a(K k, V v) {
        m21448e(this);
        int a = m21445a((Comparable) k);
        if (a >= 0) {
            return ((Entry) this.f20998b.get(a)).setValue(v);
        }
        m21448e(this);
        if (this.f20998b.isEmpty() && !(this.f20998b instanceof ArrayList)) {
            this.f20998b = new ArrayList(this.f20997a);
        }
        int i = -(a + 1);
        if (i >= this.f20997a) {
            return m21449f().put(k, v);
        }
        if (this.f20998b.size() == this.f20997a) {
            Entry entry = (Entry) this.f20998b.remove(this.f20997a - 1);
            m21449f().put(entry.f21005b, entry.getValue());
        }
        this.f20998b.add(i, new Entry(this, k, v));
        return null;
    }

    public void clear() {
        m21448e(this);
        if (!this.f20998b.isEmpty()) {
            this.f20998b.clear();
        }
        if (!this.f20999c.isEmpty()) {
            this.f20999c.clear();
        }
    }

    public V remove(Object obj) {
        m21448e(this);
        Comparable comparable = (Comparable) obj;
        int a = m21445a(comparable);
        if (a >= 0) {
            return m21447c(this, a);
        }
        if (this.f20999c.isEmpty()) {
            return null;
        }
        return this.f20999c.remove(comparable);
    }

    public static Object m21447c(SmallSortedMap smallSortedMap, int i) {
        m21448e(smallSortedMap);
        Object value = ((Entry) smallSortedMap.f20998b.remove(i)).getValue();
        if (!smallSortedMap.f20999c.isEmpty()) {
            Iterator it = smallSortedMap.m21449f().entrySet().iterator();
            smallSortedMap.f20998b.add(new Entry(smallSortedMap, (java.util.Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private int m21445a(K k) {
        int compareTo;
        int size = this.f20998b.size() - 1;
        if (size >= 0) {
            compareTo = k.compareTo(((Entry) this.f20998b.get(size)).f21005b);
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        int i2 = size;
        while (i <= i2) {
            size = (i + i2) / 2;
            compareTo = k.compareTo(((Entry) this.f20998b.get(size)).f21005b);
            if (compareTo < 0) {
                i2 = size - 1;
            } else if (compareTo <= 0) {
                return size;
            } else {
                i = size + 1;
            }
        }
        return -(i + 1);
    }

    public Set<java.util.Map.Entry<K, V>> entrySet() {
        if (this.f21001e == null) {
            this.f21001e = new EntrySet(this);
        }
        return this.f21001e;
    }

    public static void m21448e(SmallSortedMap smallSortedMap) {
        if (smallSortedMap.f21000d) {
            throw new UnsupportedOperationException();
        }
    }

    private SortedMap<K, V> m21449f() {
        m21448e(this);
        if (this.f20999c.isEmpty() && !(this.f20999c instanceof TreeMap)) {
            this.f20999c = new TreeMap();
        }
        return (SortedMap) this.f20999c;
    }
}
