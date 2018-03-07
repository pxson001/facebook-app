package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: cameraZoom */
public abstract class AbstractBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
    public transient AbstractBiMap<V, K> f7262a;
    public transient Map<K, V> f7263b;
    private transient Set<K> f7264c;
    private transient Set<V> f7265d;
    private transient Set<Entry<K, V>> f7266e;

    /* compiled from: cameraZoom */
    class EntrySet extends ForwardingSet<Entry<K, V>> {
        final Set<Entry<K, V>> f7260a = this.f7261b.f7263b.entrySet();
        final /* synthetic */ AbstractBiMap f7261b;

        public boolean containsAll(Collection<?> collection) {
            return Collections2.a(this, collection);
        }

        protected final /* synthetic */ Collection m13192b() {
            return m13191a();
        }

        protected final /* synthetic */ Object m13193e() {
            return m13191a();
        }

        public EntrySet(AbstractBiMap abstractBiMap) {
            this.f7261b = abstractBiMap;
        }

        protected final Set<Entry<K, V>> m13191a() {
            return this.f7260a;
        }

        public void clear() {
            this.f7261b.clear();
        }

        public boolean remove(Object obj) {
            if (!this.f7260a.contains(obj)) {
                return false;
            }
            Entry entry = (Entry) obj;
            this.f7261b.f7262a.f7263b.remove(entry.getValue());
            this.f7260a.remove(entry);
            return true;
        }

        public Iterator<Entry<K, V>> iterator() {
            final Iterator it = this.f7260a.iterator();
            return new Iterator<Entry<K, V>>(this) {
                Entry<K, V> f7257a;
                final /* synthetic */ EntrySet f7259c;

                public boolean hasNext() {
                    return it.hasNext();
                }

                public Object next() {
                    this.f7257a = (Entry) it.next();
                    final Entry entry = this.f7257a;
                    return new ForwardingMapEntry<K, V>(this) {
                        final /* synthetic */ C08091 f7256b;

                        protected final /* synthetic */ Object m13190e() {
                            return m13189a();
                        }

                        protected final Entry<K, V> m13189a() {
                            return entry;
                        }

                        public V setValue(V v) {
                            Preconditions.checkState(this.f7256b.f7259c.contains(this), "entry no longer in map");
                            if (Objects.equal(v, getValue())) {
                                return v;
                            }
                            boolean z;
                            if (this.f7256b.f7259c.f7261b.containsValue(v)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            Preconditions.checkArgument(z, "value already present: %s", new Object[]{v});
                            V value = entry.setValue(v);
                            Preconditions.checkState(Objects.equal(v, this.f7256b.f7259c.f7261b.get(getKey())), "entry no longer in map");
                            AbstractBiMap.m13197a(this.f7256b.f7259c.f7261b, getKey(), true, value, v);
                            return value;
                        }
                    };
                }

                public void remove() {
                    CollectPreconditions.a(this.f7257a != null);
                    Object value = this.f7257a.getValue();
                    it.remove();
                    AbstractBiMap.m13199d(this.f7259c.f7261b, value);
                }
            };
        }

        public Object[] toArray() {
            return o();
        }

        public <T> T[] toArray(T[] tArr) {
            return a(tArr);
        }

        public boolean contains(Object obj) {
            return Maps.a(m13191a(), obj);
        }

        public boolean removeAll(Collection<?> collection) {
            return c(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return d(collection);
        }
    }

    /* compiled from: cameraZoom */
    class Inverse<K, V> extends AbstractBiMap<K, V> {
        protected final /* synthetic */ Object mo880e() {
            return super.mo877a();
        }

        public /* synthetic */ Collection values() {
            return super.m13205c();
        }

        public Inverse(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap);
        }

        final K mo887a(K k) {
            return this.f7262a.mo888b(k);
        }

        final V mo888b(V v) {
            return this.f7262a.mo887a(v);
        }

        @GwtIncompatible("java.io.ObjectOuputStream")
        private void writeObject(ObjectOutputStream objectOutputStream) {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(a_());
        }

        @GwtIncompatible("java.io.ObjectInputStream")
        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            this.f7262a = (AbstractBiMap) objectInputStream.readObject();
        }

        @GwtIncompatible("Not needed in the emulated source.")
        Object readResolve() {
            return a_().a_();
        }
    }

    /* compiled from: cameraZoom */
    class KeySet extends ForwardingSet<K> {
        final /* synthetic */ AbstractBiMap f7267a;

        protected final /* synthetic */ Collection m13211b() {
            return m13210a();
        }

        protected final /* synthetic */ Object m13212e() {
            return m13210a();
        }

        public KeySet(AbstractBiMap abstractBiMap) {
            this.f7267a = abstractBiMap;
        }

        protected final Set<K> m13210a() {
            return this.f7267a.f7263b.keySet();
        }

        public void clear() {
            this.f7267a.clear();
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            AbstractBiMap.m13198c(this.f7267a, obj);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return c(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return d(collection);
        }

        public Iterator<K> iterator() {
            return Maps.a(this.f7267a.entrySet().iterator());
        }
    }

    /* compiled from: cameraZoom */
    class ValueSet extends ForwardingSet<V> {
        final Set<V> f7268a = this.f7269b.f7262a.keySet();
        final /* synthetic */ AbstractBiMap f7269b;

        protected final /* synthetic */ Collection m13214b() {
            return m13213a();
        }

        protected final /* synthetic */ Object m13215e() {
            return m13213a();
        }

        public ValueSet(AbstractBiMap abstractBiMap) {
            this.f7269b = abstractBiMap;
        }

        protected final Set<V> m13213a() {
            return this.f7268a;
        }

        public Iterator<V> iterator() {
            return Maps.b(this.f7269b.entrySet().iterator());
        }

        public Object[] toArray() {
            return o();
        }

        public <T> T[] toArray(T[] tArr) {
            return a(tArr);
        }

        public String toString() {
            return m();
        }
    }

    protected /* synthetic */ Object mo880e() {
        return mo877a();
    }

    public /* synthetic */ Collection values() {
        return m13205c();
    }

    public AbstractBiMap(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
        this.f7263b = map;
        this.f7262a = abstractBiMap;
    }

    protected final Map<K, V> mo877a() {
        return this.f7263b;
    }

    K mo887a(@Nullable K k) {
        return k;
    }

    V mo888b(@Nullable V v) {
        return v;
    }

    final void m13203a(Map<K, V> map, Map<V, K> map2) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkState(this.f7263b == null);
        if (this.f7262a == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkArgument(map2.isEmpty());
        if (map == map2) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.f7263b = map;
        this.f7262a = new Inverse(map2, this);
    }

    public boolean containsValue(@Nullable Object obj) {
        return this.f7262a.containsKey(obj);
    }

    public V put(@Nullable K k, @Nullable V v) {
        return m13196a(k, v, false);
    }

    public V mo922a(@Nullable K k, @Nullable V v) {
        return m13196a(k, v, true);
    }

    private V m13196a(@Nullable K k, @Nullable V v, boolean z) {
        mo887a(k);
        mo888b(v);
        boolean containsKey = containsKey(k);
        if (containsKey && Objects.equal(v, get(k))) {
            return v;
        }
        if (z) {
            a_().remove(v);
        } else {
            Preconditions.checkArgument(!containsValue(v), "value already present: %s", new Object[]{v});
        }
        V put = this.f7263b.put(k, v);
        m13197a(this, k, containsKey, put, v);
        return put;
    }

    public static void m13197a(AbstractBiMap abstractBiMap, Object obj, boolean z, Object obj2, Object obj3) {
        if (z) {
            m13199d(abstractBiMap, obj2);
        }
        abstractBiMap.f7262a.f7263b.put(obj3, obj);
    }

    public V remove(@Nullable Object obj) {
        return containsKey(obj) ? m13198c(this, obj) : null;
    }

    public static Object m13198c(AbstractBiMap abstractBiMap, Object obj) {
        Object remove = abstractBiMap.f7263b.remove(obj);
        m13199d(abstractBiMap, remove);
        return remove;
    }

    public static void m13199d(AbstractBiMap abstractBiMap, Object obj) {
        abstractBiMap.f7262a.f7263b.remove(obj);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public void clear() {
        this.f7263b.clear();
        this.f7262a.f7263b.clear();
    }

    public BiMap<V, K> a_() {
        return this.f7262a;
    }

    public Set<K> keySet() {
        Set<K> set = this.f7264c;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet(this);
        this.f7264c = keySet;
        return keySet;
    }

    public Set<V> m13205c() {
        Set<V> set = this.f7265d;
        if (set != null) {
            return set;
        }
        ValueSet valueSet = new ValueSet(this);
        this.f7265d = valueSet;
        return valueSet;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.f7266e;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet(this);
        this.f7266e = entrySet;
        return entrySet;
    }
}
