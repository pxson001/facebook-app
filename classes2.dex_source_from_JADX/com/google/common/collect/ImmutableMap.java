package com.google.common.collect;

import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.collect.Maps.EntryFunction;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: zero_unknown_state */
public abstract class ImmutableMap<K, V> implements Serializable, Map<K, V> {
    public static final Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Entry[0];
    private transient ImmutableSet<Entry<K, V>> entrySet;
    private transient ImmutableSet<K> keySet;
    private transient ImmutableSetMultimap<K, V> multimapView;
    private transient ImmutableCollection<V> values;

    /* compiled from: zero_unknown_state */
    public class Builder<K, V> {
        Comparator<? super V> f311a;
        ImmutableMapEntry<K, V>[] f312b;
        int f313c;
        boolean f314d;

        public Builder() {
            this(4);
        }

        Builder(int i) {
            this.f312b = new ImmutableMapEntry[i];
            this.f313c = 0;
            this.f314d = false;
        }

        private void m605a(int i) {
            if (i > this.f312b.length) {
                this.f312b = (ImmutableMapEntry[]) ObjectArrays.m633b(this.f312b, com.google.common.collect.ImmutableCollection.Builder.m618a(this.f312b.length, i));
                this.f314d = false;
            }
        }

        public Builder<K, V> m609b(K k, V v) {
            m605a(this.f313c + 1);
            ImmutableMapEntry entryOf = ImmutableMap.entryOf(k, v);
            ImmutableMapEntry[] immutableMapEntryArr = this.f312b;
            int i = this.f313c;
            this.f313c = i + 1;
            immutableMapEntryArr[i] = entryOf;
            return this;
        }

        public Builder<K, V> m607a(Entry<? extends K, ? extends V> entry) {
            return m609b(entry.getKey(), entry.getValue());
        }

        public Builder<K, V> m608a(Map<? extends K, ? extends V> map) {
            return m606a(map.entrySet());
        }

        @Beta
        public Builder<K, V> m606a(Iterable<? extends Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                m605a(((Collection) iterable).size() + this.f313c);
            }
            for (Entry a : iterable) {
                m607a(a);
            }
            return this;
        }

        public ImmutableMap<K, V> m610b() {
            switch (this.f313c) {
                case 0:
                    return RegularImmutableBiMap.f695a;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    return ImmutableBiMap.m978b(this.f312b[0].getKey(), this.f312b[0].getValue());
                default:
                    if (this.f311a != null) {
                        if (this.f314d) {
                            this.f312b = (ImmutableMapEntry[]) ObjectArrays.m633b(this.f312b, this.f313c);
                        }
                        Arrays.sort(this.f312b, 0, this.f313c, Ordering.m30178a(this.f311a).m30182a((Function) EntryFunction.VALUE));
                    }
                    this.f314d = this.f313c == this.f312b.length;
                    return RegularImmutableMap.m649a(this.f313c, this.f312b);
            }
        }
    }

    abstract ImmutableSet<Entry<K, V>> createEntrySet();

    public abstract V get(@Nullable Object obj);

    abstract boolean isPartialView();

    public static <K, V> ImmutableMap<K, V> of() {
        return RegularImmutableBiMap.f695a;
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v) {
        return ImmutableBiMap.m978b(k, v);
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2) {
        return RegularImmutableMap.m650a(entryOf(k, v), entryOf(k2, v2));
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return RegularImmutableMap.m650a(entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3));
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return RegularImmutableMap.m650a(entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4));
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return RegularImmutableMap.m650a(entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4), entryOf(k5, v5));
    }

    static <K, V> ImmutableMapEntry<K, V> entryOf(K k, V v) {
        return new ImmutableMapEntry(k, v);
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    static void checkNoConflict(boolean z, String str, Entry<?, ?> entry, Entry<?, ?> entry2) {
        if (!z) {
            throw new IllegalArgumentException("Multiple entries with same " + str + ": " + entry + " and " + entry2);
        }
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof ImmutableSortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        } else if (map instanceof EnumMap) {
            return copyOfEnumMap((EnumMap) map);
        }
        return copyOf(map.entrySet());
    }

    @Beta
    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Entry<? extends K, ? extends V>> iterable) {
        Entry[] entryArr = (Entry[]) Iterables.m958a((Iterable) iterable, EMPTY_ENTRY_ARRAY);
        switch (entryArr.length) {
            case 0:
                return RegularImmutableBiMap.f695a;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                Entry entry = entryArr[0];
                return ImmutableBiMap.m978b(entry.getKey(), entry.getValue());
            default:
                return RegularImmutableMap.m650a(entryArr);
        }
    }

    private static <K extends Enum<K>, V> ImmutableMap<K, V> copyOfEnumMap(EnumMap<K, ? extends V> enumMap) {
        ImmutableEnumMap immutableEnumMap;
        EnumMap enumMap2 = new EnumMap(enumMap);
        for (Entry entry : enumMap2.entrySet()) {
            CollectPreconditions.m616a(entry.getKey(), entry.getValue());
        }
        switch (enumMap2.size()) {
            case 0:
                immutableEnumMap = RegularImmutableBiMap.f695a;
                break;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                Entry entry2 = (Entry) Iterables.m968d(enumMap2.entrySet());
                immutableEnumMap = ImmutableBiMap.m978b(entry2.getKey(), entry2.getValue());
                break;
            default:
                immutableEnumMap = new ImmutableEnumMap(enumMap2);
                break;
        }
        return immutableEnumMap;
    }

    ImmutableMap() {
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(@Nullable Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@Nullable Object obj) {
        return values().contains(obj);
    }

    public ImmutableSet<Entry<K, V>> entrySet() {
        ImmutableSet<Entry<K, V>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = createEntrySet();
        this.entrySet = immutableSet;
        return immutableSet;
    }

    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.keySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = createKeySet();
        this.keySet = immutableSet;
        return immutableSet;
    }

    ImmutableSet<K> createKeySet() {
        return isEmpty() ? RegularImmutableSet.f688a : new ImmutableMapKeySet(this);
    }

    UnmodifiableIterator<K> keyIterator() {
        final UnmodifiableIterator it = entrySet().iterator();
        return new UnmodifiableIterator<K>(this) {
            final /* synthetic */ ImmutableMap f8065b;

            public boolean hasNext() {
                return it.hasNext();
            }

            public K next() {
                return ((Entry) it.next()).getKey();
            }
        };
    }

    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.values;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        immutableCollection = new ImmutableMapValues(this);
        this.values = immutableCollection;
        return immutableCollection;
    }

    @Beta
    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty()) {
            return EmptyImmutableSetMultimap.a;
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.multimapView;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        immutableSetMultimap = new ImmutableSetMultimap(new MapViewOfValuesAsSingletonSets(this), size(), null);
        this.multimapView = immutableSetMultimap;
        return immutableSetMultimap;
    }

    public boolean equals(@Nullable Object obj) {
        return Maps.m841d(this, obj);
    }

    public int hashCode() {
        return Sets.m1310a(entrySet());
    }

    boolean isHashCodeFast() {
        return false;
    }

    public String toString() {
        return Maps.m837c((Map) this);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }
}
