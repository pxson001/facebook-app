package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Equivalence.Equals;
import com.google.common.base.Function;
import com.google.common.base.Joiner.MapJoiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.MapDifference.ValueDifference;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: zero_rating2/clearable/default_optin/ttl_key */
public final class Maps {
    static final MapJoiner f414a = Collections2.f415a.withKeyValueSeparator("=");

    /* compiled from: zero_rating2/clearable/default_optin/ttl_key */
    public class KeySet<K, V> extends ImprovedAbstractSet<K> {
        @Weak
        final Map<K, V> f15144c;

        KeySet(Map<K, V> map) {
            this.f15144c = (Map) Preconditions.checkNotNull(map);
        }

        Map<K, V> m21659a() {
            return this.f15144c;
        }

        public Iterator<K> iterator() {
            return Maps.m814a(m21659a().entrySet().iterator());
        }

        public int size() {
            return m21659a().size();
        }

        public boolean isEmpty() {
            return m21659a().isEmpty();
        }

        public boolean contains(Object obj) {
            return m21659a().containsKey(obj);
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            m21659a().remove(obj);
            return true;
        }

        public void clear() {
            m21659a().clear();
        }
    }

    /* compiled from: zero_rating2/clearable/default_optin/ttl_key */
    public abstract class IteratorBasedAbstractMap<K, V> extends AbstractMap<K, V> {
        abstract Iterator<Entry<K, V>> mo2921d();

        IteratorBasedAbstractMap() {
        }

        public Set<Entry<K, V>> entrySet() {
            return new 1(this);
        }

        public void clear() {
            Iterators.m1429h(mo2921d());
        }
    }

    @GwtCompatible
    /* compiled from: zero_rating2/clearable/default_optin/ttl_key */
    public abstract class ViewCachingAbstractMap<K, V> extends AbstractMap<K, V> {
        private transient Set<Entry<K, V>> f23131a;
        private transient Set<K> f23132b;
        private transient Collection<V> f23133c;

        abstract Set<Entry<K, V>> mo3403a();

        ViewCachingAbstractMap() {
        }

        public Set<Entry<K, V>> entrySet() {
            Set<Entry<K, V>> set = this.f23131a;
            if (set != null) {
                return set;
            }
            set = mo3403a();
            this.f23131a = set;
            return set;
        }

        public Set<K> keySet() {
            Set<K> set = this.f23132b;
            if (set != null) {
                return set;
            }
            set = m31242b();
            this.f23132b = set;
            return set;
        }

        Set<K> m31242b() {
            return new KeySet(this);
        }

        public Collection<V> values() {
            Collection<V> collection = this.f23133c;
            if (collection != null) {
                return collection;
            }
            collection = m31243d();
            this.f23133c = collection;
            return collection;
        }

        Collection<V> m31243d() {
            return new Values(this);
        }
    }

    private Maps() {
    }

    static <K> Predicate<Entry<K, ?>> m806a(Predicate<? super K> predicate) {
        return Predicates.compose(predicate, EntryFunction.KEY);
    }

    static <K, V> Iterator<K> m814a(Iterator<Entry<K, V>> it) {
        return Iterators.m1409a((Iterator) it, (Function) EntryFunction.KEY);
    }

    public static <V> Predicate<Entry<?, V>> m828b(Predicate<? super V> predicate) {
        return Predicates.compose(predicate, EntryFunction.VALUE);
    }

    static <K, V> Iterator<V> m832b(Iterator<Entry<K, V>> it) {
        return Iterators.m1409a((Iterator) it, (Function) EntryFunction.VALUE);
    }

    public static <K, V> HashMap<K, V> m838c() {
        return new HashMap();
    }

    public static <K, V> HashMap<K, V> m812a(int i) {
        return new HashMap(m827b(i));
    }

    public static int m827b(int i) {
        if (i < 3) {
            CollectPreconditions.m615a(i, "expectedSize");
            return i + 1;
        } else if (i < 1073741824) {
            return (int) ((((float) i) / 0.75f) + 1.0f);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static <K, V> HashMap<K, V> m813a(Map<? extends K, ? extends V> map) {
        return new HashMap(map);
    }

    public static <K, V> LinkedHashMap<K, V> m840d() {
        return new LinkedHashMap();
    }

    public static <K, V> LinkedHashMap<K, V> m839c(int i) {
        return new LinkedHashMap(m827b(i));
    }

    public static <K, V> ConcurrentMap<K, V> m843e() {
        return new MapMaker().m1489l();
    }

    public static <K extends Comparable, V> TreeMap<K, V> m844f() {
        return new TreeMap();
    }

    private static <C, K extends C, V> TreeMap<K, V> m824a(@Nullable Comparator<C> comparator) {
        return new TreeMap(comparator);
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> m811a(Class<K> cls) {
        return new EnumMap((Class) Preconditions.checkNotNull(cls));
    }

    private static <K, V> void m825a(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, Equivalence<? super V> equivalence, Map<K, V> map3, Map<K, V> map4, Map<K, V> map5, Map<K, ValueDifference<V>> map6) {
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (map2.containsKey(key)) {
                Object remove = map4.remove(key);
                if (equivalence.equivalent(value, remove)) {
                    map5.put(key, value);
                } else {
                    map6.put(key, new ValueDifferenceImpl(value, remove));
                }
            } else {
                map3.put(key, value);
            }
        }
    }

    public static <K, V> Map<K, V> m842e(Map<K, V> map) {
        if (map instanceof SortedMap) {
            return Collections.unmodifiableSortedMap((SortedMap) map);
        }
        return Collections.unmodifiableMap(map);
    }

    public static <K, V> SortedMapDifference<K, V> m809a(SortedMap<K, ? extends V> sortedMap, Map<? extends K, ? extends V> map) {
        Preconditions.checkNotNull(sortedMap);
        Preconditions.checkNotNull(map);
        Comparator b = m831b(sortedMap.comparator());
        Object a = m824a(b);
        Object a2 = m824a(b);
        a2.putAll(map);
        Object a3 = m824a(b);
        Object a4 = m824a(b);
        m825a(sortedMap, map, Equals.INSTANCE, a, a2, a3, a4);
        return new SortedMapDifferenceImpl(a, a2, a3, a4);
    }

    private static <E> Comparator<? super E> m831b(@Nullable Comparator<? super E> comparator) {
        if (comparator != null) {
            return comparator;
        }
        return NaturalOrdering.f22266a;
    }

    static <K, V> Iterator<Entry<K, V>> m815a(Set<K> set, Function<? super K, V> function) {
        return new 1(set.iterator(), function);
    }

    public static <K, V> ImmutableMap<K, V> m807a(Iterable<V> iterable, Function<? super V, K> function) {
        return m808a(iterable.iterator(), (Function) function);
    }

    public static <K, V> ImmutableMap<K, V> m808a(Iterator<V> it, Function<? super V, K> function) {
        Preconditions.checkNotNull(function);
        Builder builder = ImmutableMap.builder();
        while (it.hasNext()) {
            Object next = it.next();
            builder.m609b(function.apply(next), next);
        }
        try {
            return builder.m610b();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage() + ". To index multiple values under a key, use Multimaps.index.");
        }
    }

    @GwtCompatible
    public static <K, V> Entry<K, V> m817a(@Nullable K k, @Nullable V v) {
        return new ImmutableEntry(k, v);
    }

    static <K, V> Entry<K, V> m818a(Entry<? extends K, ? extends V> entry) {
        Preconditions.checkNotNull(entry);
        return new 5(entry);
    }

    public static <K, V1, V2> Map<K, V2> m820a(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        if (map instanceof SortedMap) {
            return Platform.m646a((SortedMap) map, (EntryTransformer) entryTransformer);
        }
        return new TransformedEntriesMap(map, entryTransformer);
    }

    @GwtIncompatible("NavigableMap")
    public static <K, V1, V2> NavigableMap<K, V2> m822a(NavigableMap<K, V1> navigableMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new TransformedEntriesNavigableMap(navigableMap, entryTransformer);
    }

    static <V2, K, V1> Entry<K, V2> m816a(EntryTransformer<? super K, ? super V1, V2> entryTransformer, Entry<K, V1> entry) {
        Preconditions.checkNotNull(entryTransformer);
        Preconditions.checkNotNull(entry);
        return new 10(entry, entryTransformer);
    }

    @CheckReturnValue
    public static <K, V> Map<K, V> m819a(Map<K, V> map, Predicate<? super V> predicate) {
        if (map instanceof SortedMap) {
            return Platform.m645a((SortedMap) map, m828b((Predicate) predicate));
        }
        return map instanceof BiMap ? m829b((BiMap) map, m828b((Predicate) predicate)) : m833b((Map) map, m828b((Predicate) predicate));
    }

    @CheckReturnValue
    private static <K, V> Map<K, V> m833b(Map<K, V> map, Predicate<? super Entry<K, V>> predicate) {
        if (map instanceof SortedMap) {
            return Platform.m645a((SortedMap) map, (Predicate) predicate);
        }
        if (map instanceof BiMap) {
            return m829b((BiMap) map, (Predicate) predicate);
        }
        Preconditions.checkNotNull(predicate);
        if (!(map instanceof AbstractFilteredMap)) {
            return new FilteredEntryMap((Map) Preconditions.checkNotNull(map), predicate);
        }
        AbstractFilteredMap abstractFilteredMap = (AbstractFilteredMap) map;
        return new FilteredEntryMap(abstractFilteredMap.a, Predicates.and(abstractFilteredMap.b, predicate));
    }

    static <K, V> SortedMap<K, V> m823a(SortedMap<K, V> sortedMap, Predicate<? super Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (!(sortedMap instanceof FilteredEntrySortedMap)) {
            return new FilteredEntrySortedMap((SortedMap) Preconditions.checkNotNull(sortedMap), predicate);
        }
        FilteredEntrySortedMap filteredEntrySortedMap = (FilteredEntrySortedMap) sortedMap;
        return new FilteredEntrySortedMap(filteredEntrySortedMap.c(), Predicates.and(filteredEntrySortedMap.b, predicate));
    }

    @CheckReturnValue
    @GwtIncompatible("NavigableMap")
    public static <K, V> NavigableMap<K, V> m821a(NavigableMap<K, V> navigableMap, Predicate<? super Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (!(navigableMap instanceof FilteredEntryNavigableMap)) {
            return new FilteredEntryNavigableMap((NavigableMap) Preconditions.checkNotNull(navigableMap), predicate);
        }
        FilteredEntryNavigableMap filteredEntryNavigableMap = (FilteredEntryNavigableMap) navigableMap;
        return new FilteredEntryNavigableMap(filteredEntryNavigableMap.a, Predicates.and(filteredEntryNavigableMap.b, predicate));
    }

    @CheckReturnValue
    public static <K, V> BiMap<K, V> m829b(BiMap<K, V> biMap, Predicate<? super Entry<K, V>> predicate) {
        Preconditions.checkNotNull(biMap);
        Preconditions.checkNotNull(predicate);
        if (!(biMap instanceof FilteredEntryBiMap)) {
            return new FilteredEntryBiMap(biMap, predicate);
        }
        FilteredEntryBiMap filteredEntryBiMap = (FilteredEntryBiMap) biMap;
        return new FilteredEntryBiMap(filteredEntryBiMap.e(), Predicates.and(filteredEntryBiMap.b, predicate));
    }

    static <V> V m810a(Map<?, V> map, @Nullable Object obj) {
        V v = null;
        Preconditions.checkNotNull(map);
        try {
            v = map.get(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return v;
    }

    static boolean m835b(Map<?, ?> map, Object obj) {
        boolean z = false;
        Preconditions.checkNotNull(map);
        try {
            z = map.containsKey(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return z;
    }

    public static <V> V m836c(Map<?, V> map, Object obj) {
        V v = null;
        Preconditions.checkNotNull(map);
        try {
            v = map.remove(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return v;
    }

    static <K, V> boolean m826a(Collection<Entry<K, V>> collection, Object obj) {
        if (obj instanceof Entry) {
            return collection.contains(m818a((Entry) obj));
        }
        return false;
    }

    static <K, V> boolean m834b(Collection<Entry<K, V>> collection, Object obj) {
        if (obj instanceof Entry) {
            return collection.remove(m818a((Entry) obj));
        }
        return false;
    }

    static boolean m841d(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return map.entrySet().equals(((Map) obj).entrySet());
    }

    public static String m837c(Map<?, ?> map) {
        StringBuilder append = Collections2.m845a(map.size()).append('{');
        StringBuilder appendTo = f414a.appendTo(append, map.entrySet().iterator());
        return append.append('}').toString();
    }

    @Nullable
    static <K> K m830b(@Nullable Entry<K, ?> entry) {
        return entry == null ? null : entry.getKey();
    }
}
