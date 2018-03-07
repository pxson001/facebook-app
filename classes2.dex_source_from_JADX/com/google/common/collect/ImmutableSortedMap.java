package com.google.common.collect;

import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: qp_secondary_action_counter */
public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {
    public static final Comparator<Comparable> f8465a = NaturalOrdering.f22266a;
    public static final ImmutableSortedMap<Comparable, Object> f8466b = new ImmutableSortedMap(ImmutableSortedSet.m4687a((Comparator) NaturalOrdering.f22266a), RegularImmutableList.f535a);
    public final transient RegularImmutableSortedSet<K> f8467c;
    public final transient ImmutableList<V> f8468d;
    private transient ImmutableSortedMap<K, V> f8469e;

    public final /* synthetic */ NavigableMap headMap(Object obj, boolean z) {
        return m13023a(obj, z);
    }

    public final /* synthetic */ NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
        return m13024a(obj, z, obj2, z2);
    }

    public final /* synthetic */ NavigableMap tailMap(Object obj, boolean z) {
        return m13027b(obj, z);
    }

    public static <K, V> ImmutableSortedMap<K, V> m13028b(Comparator<? super K> comparator, K k, V v) {
        return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.of(k), (Comparator) Preconditions.checkNotNull(comparator)), ImmutableList.of(v));
    }

    static <K, V> ImmutableSortedMap<K, V> m13025a(Comparator<? super K> comparator) {
        if (NaturalOrdering.f22266a.equals(comparator)) {
            return f8466b;
        }
        return new ImmutableSortedMap(ImmutableSortedSet.m4687a((Comparator) comparator), RegularImmutableList.f535a);
    }

    public static <K, V> ImmutableSortedMap<K, V> m13030b(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        boolean z = false;
        if (map instanceof SortedMap) {
            Comparator comparator2 = ((SortedMap) map).comparator();
            boolean equals = comparator2 == null ? comparator == f8465a : comparator.equals(comparator2);
            z = equals;
        }
        if (z && (map instanceof ImmutableSortedMap)) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) map;
            if (!immutableSortedMap.isPartialView()) {
                return immutableSortedMap;
            }
        }
        Entry[] entryArr = (Entry[]) Iterables.m958a(map.entrySet(), ImmutableMap.EMPTY_ENTRY_ARRAY);
        return m13029b(comparator, z, entryArr, entryArr.length);
    }

    public static <K, V> ImmutableSortedMap<K, V> m13029b(Comparator<? super K> comparator, boolean z, Entry<K, V>[] entryArr, int i) {
        int i2 = 0;
        switch (i) {
            case 0:
                return m13025a(comparator);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return m13028b(comparator, entryArr[0].getKey(), entryArr[0].getValue());
            default:
                Object[] objArr = new Object[i];
                Object[] objArr2 = new Object[i];
                Object key;
                if (z) {
                    while (i2 < i) {
                        key = entryArr[i2].getKey();
                        Object value = entryArr[i2].getValue();
                        CollectPreconditions.m616a(key, value);
                        objArr[i2] = key;
                        objArr2[i2] = value;
                        i2++;
                    }
                } else {
                    Arrays.sort(entryArr, 0, i, Ordering.m30178a((Comparator) comparator).m30195e());
                    key = entryArr[0].getKey();
                    objArr[0] = key;
                    objArr2[0] = entryArr[0].getValue();
                    int i3 = 1;
                    while (i3 < i) {
                        boolean z2;
                        Object key2 = entryArr[i3].getKey();
                        Object value2 = entryArr[i3].getValue();
                        CollectPreconditions.m616a(key2, value2);
                        objArr[i3] = key2;
                        objArr2[i3] = value2;
                        if (comparator.compare(key, key2) != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        ImmutableMap.checkNoConflict(z2, "key", entryArr[i3 - 1], entryArr[i3]);
                        i3++;
                        key = key2;
                    }
                }
                return new ImmutableSortedMap(new RegularImmutableSortedSet(new RegularImmutableList(objArr), comparator), new RegularImmutableList(objArr2));
        }
    }

    public static <K extends Comparable<?>, V> Builder<K, V> m13026b() {
        return new Builder(NaturalOrdering.f22266a);
    }

    ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList) {
        this(regularImmutableSortedSet, immutableList, null);
    }

    private ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList, ImmutableSortedMap<K, V> immutableSortedMap) {
        this.f8467c = regularImmutableSortedSet;
        this.f8468d = immutableList;
        this.f8469e = immutableSortedMap;
    }

    public final int size() {
        return this.f8468d.size();
    }

    public final V get(@Nullable Object obj) {
        int a = this.f8467c.a(obj);
        return a == -1 ? null : this.f8468d.get(a);
    }

    final boolean isPartialView() {
        return this.f8467c.isPartialView() || this.f8468d.isPartialView();
    }

    public final ImmutableSet<Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    final ImmutableSet<Entry<K, V>> createEntrySet() {
        return isEmpty() ? RegularImmutableSet.f688a : new 1EntrySet(this);
    }

    public final Comparator<? super K> comparator() {
        return this.f8467c.comparator();
    }

    public final K firstKey() {
        return this.f8467c.first();
    }

    public final /* synthetic */ ImmutableSet keySet() {
        return this.f8467c;
    }

    public final /* synthetic */ Set m32804keySet() {
        return this.f8467c;
    }

    public final K lastKey() {
        return this.f8467c.last();
    }

    public final ImmutableCollection<V> values() {
        return this.f8468d;
    }

    private ImmutableSortedMap<K, V> m13022a(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        if (i == i2) {
            return m13025a(comparator());
        }
        return new ImmutableSortedMap(this.f8467c.a(i, i2), this.f8468d.subList(i, i2));
    }

    public final SortedMap headMap(Object obj) {
        return m13023a(obj, false);
    }

    private ImmutableSortedMap<K, V> m13023a(K k, boolean z) {
        return m13022a(0, this.f8467c.e(Preconditions.checkNotNull(k), z));
    }

    public final SortedMap subMap(Object obj, Object obj2) {
        return m13024a(obj, true, obj2, false);
    }

    private ImmutableSortedMap<K, V> m13024a(K k, boolean z, K k2, boolean z2) {
        boolean z3;
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(k2);
        if (comparator().compare(k, k2) <= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "expected fromKey <= toKey but %s > %s", k, k2);
        return m13023a((Object) k2, z2).m13027b((Object) k, z);
    }

    public final SortedMap tailMap(Object obj) {
        return m13027b(obj, true);
    }

    private ImmutableSortedMap<K, V> m13027b(K k, boolean z) {
        return m13022a(this.f8467c.f(Preconditions.checkNotNull(k), z), size());
    }

    public final Entry<K, V> lowerEntry(K k) {
        return m13023a((Object) k, false).lastEntry();
    }

    public final K lowerKey(K k) {
        return Maps.m830b(lowerEntry(k));
    }

    public final Entry<K, V> floorEntry(K k) {
        return m13023a((Object) k, true).lastEntry();
    }

    public final K floorKey(K k) {
        return Maps.m830b(floorEntry(k));
    }

    public final Entry<K, V> ceilingEntry(K k) {
        return m13027b((Object) k, true).firstEntry();
    }

    public final K ceilingKey(K k) {
        return Maps.m830b(ceilingEntry(k));
    }

    public final Entry<K, V> higherEntry(K k) {
        return m13027b((Object) k, false).firstEntry();
    }

    public final K higherKey(K k) {
        return Maps.m830b(higherEntry(k));
    }

    public final Entry<K, V> firstEntry() {
        return isEmpty() ? null : (Entry) entrySet().asList().get(0);
    }

    public final Entry<K, V> lastEntry() {
        return isEmpty() ? null : (Entry) entrySet().asList().get(size() - 1);
    }

    @Deprecated
    public final Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public final NavigableMap descendingMap() {
        NavigableMap navigableMap = this.f8469e;
        if (navigableMap != null) {
            return navigableMap;
        }
        if (isEmpty()) {
            return m13025a(Ordering.m30178a(comparator()).mo3241a());
        }
        return new ImmutableSortedMap((RegularImmutableSortedSet) this.f8467c.m4692a(), this.f8468d.reverse(), this);
    }

    public final /* synthetic */ NavigableSet navigableKeySet() {
        return this.f8467c;
    }

    public final NavigableSet descendingKeySet() {
        return this.f8467c.m4692a();
    }

    final Object writeReplace() {
        return new SerializedForm(this);
    }
}
