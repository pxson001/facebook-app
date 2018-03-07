package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.collect.Sets.ImprovedAbstractSet;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: buttonAction */
public final class LinkedHashMultimap<K, V> extends AbstractSetMultimap<K, V> {
    @VisibleForTesting
    transient int f7381a = 2;
    public transient ValueEntry<K, V> f7382b;

    /* compiled from: buttonAction */
    class C08201 implements Iterator<Entry<K, V>> {
        ValueEntry<K, V> f7367a = this.f7369c.f7382b.successorInMultimap;
        ValueEntry<K, V> f7368b;
        final /* synthetic */ LinkedHashMultimap f7369c;

        C08201(LinkedHashMultimap linkedHashMultimap) {
            this.f7369c = linkedHashMultimap;
        }

        public boolean hasNext() {
            return this.f7367a != this.f7369c.f7382b;
        }

        public Object next() {
            if (hasNext()) {
                ValueEntry valueEntry = this.f7367a;
                this.f7368b = valueEntry;
                this.f7367a = this.f7367a.successorInMultimap;
                return valueEntry;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            CollectPreconditions.a(this.f7368b != null);
            this.f7369c.c(this.f7368b.getKey(), this.f7368b.getValue());
            this.f7368b = null;
        }
    }

    /* compiled from: buttonAction */
    public interface ValueSetLink<K, V> {
        ValueSetLink<K, V> mo935a();

        void mo936a(ValueSetLink<K, V> valueSetLink);

        ValueSetLink<K, V> mo937b();

        void mo938b(ValueSetLink<K, V> valueSetLink);
    }

    @VisibleForTesting
    /* compiled from: buttonAction */
    public final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements ValueSetLink<K, V> {
        @Nullable
        public ValueEntry<K, V> nextInValueBucket;
        public ValueEntry<K, V> predecessorInMultimap;
        ValueSetLink<K, V> predecessorInValueSet;
        public final int smearedValueHash;
        public ValueEntry<K, V> successorInMultimap;
        ValueSetLink<K, V> successorInValueSet;

        ValueEntry(@Nullable K k, @Nullable V v, int i, @Nullable ValueEntry<K, V> valueEntry) {
            super(k, v);
            this.smearedValueHash = i;
            this.nextInValueBucket = valueEntry;
        }

        final boolean m13440a(@Nullable Object obj, int i) {
            return this.smearedValueHash == i && Objects.equal(getValue(), obj);
        }

        public final ValueSetLink<K, V> mo935a() {
            return this.predecessorInValueSet;
        }

        public final ValueSetLink<K, V> mo937b() {
            return this.successorInValueSet;
        }

        public final void mo936a(ValueSetLink<K, V> valueSetLink) {
            this.predecessorInValueSet = valueSetLink;
        }

        public final void mo938b(ValueSetLink<K, V> valueSetLink) {
            this.successorInValueSet = valueSetLink;
        }
    }

    @VisibleForTesting
    /* compiled from: buttonAction */
    public final class ValueSet extends ImprovedAbstractSet<V> implements ValueSetLink<K, V> {
        @VisibleForTesting
        public ValueEntry<K, V>[] f7374a;
        final /* synthetic */ LinkedHashMultimap f7375b;
        private final K f7376c;
        public int f7377d = 0;
        public int f7378e = 0;
        public ValueSetLink<K, V> f7379f;
        private ValueSetLink<K, V> f7380g;

        /* compiled from: buttonAction */
        class C08211 implements Iterator<V> {
            ValueSetLink<K, V> f7370a = this.f7373d.f7379f;
            ValueEntry<K, V> f7371b;
            int f7372c = this.f7373d.f7378e;
            final /* synthetic */ ValueSet f7373d;

            C08211(ValueSet valueSet) {
                this.f7373d = valueSet;
            }

            private void m13443a() {
                if (this.f7373d.f7378e != this.f7372c) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                m13443a();
                return this.f7370a != this.f7373d;
            }

            public V next() {
                if (hasNext()) {
                    ValueEntry valueEntry = (ValueEntry) this.f7370a;
                    V value = valueEntry.getValue();
                    this.f7371b = valueEntry;
                    this.f7370a = valueEntry.mo937b();
                    return value;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                m13443a();
                CollectPreconditions.a(this.f7371b != null);
                this.f7373d.remove(this.f7371b.getValue());
                this.f7372c = this.f7373d.f7378e;
                this.f7371b = null;
            }
        }

        ValueSet(LinkedHashMultimap linkedHashMultimap, K k, int i) {
            this.f7375b = linkedHashMultimap;
            this.f7376c = k;
            this.f7379f = this;
            this.f7380g = this;
            this.f7374a = new ValueEntry[Hashing.a(i, 1.0d)];
        }

        private int m13444c() {
            return this.f7374a.length - 1;
        }

        public final ValueSetLink<K, V> mo935a() {
            return this.f7380g;
        }

        public final ValueSetLink<K, V> mo937b() {
            return this.f7379f;
        }

        public final void mo936a(ValueSetLink<K, V> valueSetLink) {
            this.f7380g = valueSetLink;
        }

        public final void mo938b(ValueSetLink<K, V> valueSetLink) {
            this.f7379f = valueSetLink;
        }

        public final Iterator<V> iterator() {
            return new C08211(this);
        }

        public final int size() {
            return this.f7377d;
        }

        public final boolean contains(@Nullable Object obj) {
            int a = Hashing.a(obj);
            for (ValueEntry valueEntry = this.f7374a[m13444c() & a]; valueEntry != null; valueEntry = valueEntry.nextInValueBucket) {
                if (valueEntry.m13440a(obj, a)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean add(@Nullable V v) {
            ValueEntry valueEntry;
            int a = Hashing.a(v);
            int c = a & m13444c();
            ValueEntry valueEntry2 = this.f7374a[c];
            for (valueEntry = valueEntry2; valueEntry != null; valueEntry = valueEntry.nextInValueBucket) {
                if (valueEntry.m13440a(v, a)) {
                    return false;
                }
            }
            valueEntry = new ValueEntry(this.f7376c, v, a, valueEntry2);
            LinkedHashMultimap.m13451b(this.f7380g, (ValueSetLink) valueEntry);
            LinkedHashMultimap.m13451b((ValueSetLink) valueEntry, (ValueSetLink) this);
            LinkedHashMultimap.m13450b(this.f7375b.f7382b.predecessorInMultimap, valueEntry);
            LinkedHashMultimap.m13450b(valueEntry, this.f7375b.f7382b);
            this.f7374a[c] = valueEntry;
            this.f7377d++;
            this.f7378e++;
            if (Hashing.a(this.f7377d, this.f7374a.length, 1.0d)) {
                ValueEntry[] valueEntryArr = new ValueEntry[(this.f7374a.length * 2)];
                this.f7374a = valueEntryArr;
                int length = valueEntryArr.length - 1;
                for (ValueSetLink valueSetLink = this.f7379f; valueSetLink != this; valueSetLink = valueSetLink.mo937b()) {
                    ValueEntry valueEntry3 = (ValueEntry) valueSetLink;
                    int i = valueEntry3.smearedValueHash & length;
                    valueEntry3.nextInValueBucket = valueEntryArr[i];
                    valueEntryArr[i] = valueEntry3;
                }
            }
            return true;
        }

        public final boolean remove(@Nullable Object obj) {
            int a = Hashing.a(obj);
            int c = a & m13444c();
            ValueEntry valueEntry = null;
            for (ValueSetLink valueSetLink = this.f7374a[c]; valueSetLink != null; valueSetLink = valueSetLink.nextInValueBucket) {
                if (valueSetLink.m13440a(obj, a)) {
                    if (valueEntry == null) {
                        this.f7374a[c] = valueSetLink.nextInValueBucket;
                    } else {
                        valueEntry.nextInValueBucket = valueSetLink.nextInValueBucket;
                    }
                    LinkedHashMultimap.m13451b(valueSetLink.mo935a(), valueSetLink.mo937b());
                    LinkedHashMultimap.m13449b(valueSetLink);
                    this.f7377d--;
                    this.f7378e++;
                    return true;
                }
                ValueSetLink valueSetLink2 = valueSetLink;
            }
            return false;
        }

        public final void clear() {
            Arrays.fill(this.f7374a, null);
            this.f7377d = 0;
            for (ValueSetLink valueSetLink = this.f7379f; valueSetLink != this; valueSetLink = valueSetLink.mo937b()) {
                LinkedHashMultimap.m13449b((ValueEntry) valueSetLink);
            }
            LinkedHashMultimap.m13451b((ValueSetLink) this, (ValueSetLink) this);
            this.f7378e++;
        }
    }

    public final /* bridge */ /* synthetic */ boolean m13454a(Multimap multimap) {
        return super.a(multimap);
    }

    public final /* bridge */ /* synthetic */ boolean m13455a(@Nullable Object obj, Iterable iterable) {
        return super.a(obj, iterable);
    }

    final /* synthetic */ Collection m13457c() {
        return m13453a();
    }

    public final /* bridge */ /* synthetic */ boolean m13458c(@Nullable Object obj, @Nullable Object obj2) {
        return super.c(obj, obj2);
    }

    public final /* bridge */ /* synthetic */ int m13460f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ boolean m13461f(@Nullable Object obj) {
        return super.f(obj);
    }

    public final /* bridge */ /* synthetic */ boolean m13463g(@Nullable Object obj) {
        return super.g(obj);
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* synthetic */ Collection m13466k() {
        return t();
    }

    public final /* bridge */ /* synthetic */ boolean m13468n() {
        return super.n();
    }

    public final /* bridge */ /* synthetic */ Set m13469p() {
        return super.p();
    }

    public final /* bridge */ /* synthetic */ Multiset m13470q() {
        return super.q();
    }

    public final /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <K, V> LinkedHashMultimap<K, V> m13452u() {
        return new LinkedHashMultimap(16, 2);
    }

    public static <K, V> void m13451b(ValueSetLink<K, V> valueSetLink, ValueSetLink<K, V> valueSetLink2) {
        valueSetLink.mo938b(valueSetLink2);
        valueSetLink2.mo936a(valueSetLink);
    }

    public static <K, V> void m13449b(ValueEntry<K, V> valueEntry) {
        m13450b(valueEntry.predecessorInMultimap, valueEntry.successorInMultimap);
    }

    public static <K, V> void m13450b(ValueEntry<K, V> valueEntry, ValueEntry<K, V> valueEntry2) {
        valueEntry.successorInMultimap = valueEntry2;
        valueEntry2.predecessorInMultimap = valueEntry;
    }

    private LinkedHashMultimap(int i, int i2) {
        super(new LinkedHashMap(i));
        CollectPreconditions.a(i2, "expectedValuesPerKey");
        this.f7381a = i2;
        this.f7382b = new ValueEntry(null, null, 0, null);
        m13450b(this.f7382b, this.f7382b);
    }

    final Set<V> m13453a() {
        return new LinkedHashSet(this.f7381a);
    }

    final Collection<V> m13459e(K k) {
        return new ValueSet(this, k, this.f7381a);
    }

    public final Collection<V> m13464i() {
        return super.i();
    }

    final Iterator<Entry<K, V>> m13467l() {
        return new C08201(this);
    }

    final Iterator<V> m13465j() {
        return Maps.b(m13467l());
    }

    public final void m13462g() {
        super.g();
        m13450b(this.f7382b, this.f7382b);
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(p().size());
        for (Object writeObject : p()) {
            objectOutputStream.writeObject(writeObject);
        }
        objectOutputStream.writeInt(f());
        for (Entry entry : t()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        int i;
        objectInputStream.defaultReadObject();
        this.f7382b = new ValueEntry(null, null, 0, null);
        m13450b(this.f7382b, this.f7382b);
        this.f7381a = 2;
        int readInt = objectInputStream.readInt();
        Map linkedHashMap = new LinkedHashMap();
        for (i = 0; i < readInt; i++) {
            Object readObject = objectInputStream.readObject();
            linkedHashMap.put(readObject, m13459e(readObject));
        }
        readInt = objectInputStream.readInt();
        for (i = 0; i < readInt; i++) {
            Object readObject2 = objectInputStream.readObject();
            ((Collection) linkedHashMap.get(readObject2)).add(objectInputStream.readObject());
        }
        a(linkedHashMap);
    }
}
