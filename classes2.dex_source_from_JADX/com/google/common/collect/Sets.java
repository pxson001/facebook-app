package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2.FilteredCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: xml_megaphone */
public final class Sets {

    /* compiled from: xml_megaphone */
    final class C00443 extends SetView<E> {
        final /* synthetic */ Set f702a;
        final /* synthetic */ Predicate f703b;
        final /* synthetic */ Set f704c;

        C00443(Set set, Predicate predicate, Set set2) {
            this.f702a = set;
            this.f703b = predicate;
            this.f704c = set2;
        }

        public final Iterator<E> iterator() {
            return Iterators.m1417b(this.f702a.iterator(), this.f703b);
        }

        public final int size() {
            return Iterators.m1415b(iterator());
        }

        public final boolean isEmpty() {
            return this.f704c.containsAll(this.f702a);
        }

        public final boolean contains(Object obj) {
            return this.f702a.contains(obj) && !this.f704c.contains(obj);
        }
    }

    /* compiled from: xml_megaphone */
    public abstract class SetView<E> extends AbstractSet<E> {
    }

    /* compiled from: xml_megaphone */
    public final class C00451 extends SetView<E> {
        final /* synthetic */ Set f705a;
        final /* synthetic */ Set f706b;
        final /* synthetic */ Set f707c;

        public C00451(Set set, Set set2, Set set3) {
            this.f705a = set;
            this.f706b = set2;
            this.f707c = set3;
        }

        public final int size() {
            return this.f705a.size() + this.f706b.size();
        }

        public final boolean isEmpty() {
            return this.f705a.isEmpty() && this.f707c.isEmpty();
        }

        public final Iterator<E> iterator() {
            Iterator it = this.f705a.iterator();
            Iterator it2 = this.f706b.iterator();
            Preconditions.checkNotNull(it);
            Preconditions.checkNotNull(it2);
            return Iterators.m1404a(Iterators.m1425e(new ConsumingQueueIterator(it, it2)));
        }

        public final boolean contains(Object obj) {
            return this.f705a.contains(obj) || this.f707c.contains(obj);
        }
    }

    /* compiled from: xml_megaphone */
    abstract class ImprovedAbstractSet<E> extends AbstractSet<E> {
        ImprovedAbstractSet() {
        }

        public boolean removeAll(Collection<?> collection) {
            return Sets.m1321a((Set) this, (Collection) collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) Preconditions.checkNotNull(collection));
        }
    }

    /* compiled from: xml_megaphone */
    class FilteredSet<E> extends FilteredCollection<E> implements Set<E> {
        FilteredSet(Set<E> set, Predicate<? super E> predicate) {
            super(set, predicate);
        }

        public boolean equals(@Nullable Object obj) {
            return Sets.m1320a((Set) this, obj);
        }

        public int hashCode() {
            return Sets.m1310a((Set) this);
        }
    }

    private Sets() {
    }

    @GwtCompatible
    public static <E extends Enum<E>> ImmutableSet<E> m1311a(Iterable<E> iterable) {
        if (iterable instanceof ImmutableEnumSet) {
            return (ImmutableEnumSet) iterable;
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.isEmpty()) {
                return RegularImmutableSet.f688a;
            }
            return ImmutableEnumSet.a(EnumSet.copyOf(collection));
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return RegularImmutableSet.f688a;
        }
        Collection of = EnumSet.of((Enum) it.next());
        Iterators.m1411a(of, it);
        return ImmutableEnumSet.a(of);
    }

    public static <E extends Enum<E>> EnumSet<E> m1312a(Iterable<E> iterable, Class<E> cls) {
        Collection noneOf = EnumSet.noneOf(cls);
        Iterables.m955a(noneOf, (Iterable) iterable);
        return noneOf;
    }

    public static <E> HashSet<E> m1313a() {
        return new HashSet();
    }

    public static <E> HashSet<E> m1315a(E... eArr) {
        Object a = m1314a(eArr.length);
        Collections.addAll(a, eArr);
        return a;
    }

    public static <E> HashSet<E> m1314a(int i) {
        return new HashSet(Maps.m827b(i));
    }

    public static <E> HashSet<E> m1324b(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new HashSet(Collections2.m846a((Iterable) iterable));
        }
        Iterator it = iterable.iterator();
        Collection a = m1313a();
        Iterators.m1411a(a, it);
        return a;
    }

    public static <E> Set<E> m1325b() {
        return Platform.m644a(new ConcurrentHashMap());
    }

    public static <E> LinkedHashSet<E> m1327c() {
        return new LinkedHashSet();
    }

    public static <E> LinkedHashSet<E> m1328c(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedHashSet(Collections2.m846a((Iterable) iterable));
        }
        Collection c = m1327c();
        Iterables.m955a(c, (Iterable) iterable);
        return c;
    }

    public static <E extends Comparable> TreeSet<E> m1329d() {
        return new TreeSet();
    }

    public static <E> TreeSet<E> m1319a(Comparator<? super E> comparator) {
        return new TreeSet((Comparator) Preconditions.checkNotNull(comparator));
    }

    public static <E> SetView<E> m1323b(Set<E> set, Set<?> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new 2(set, Predicates.in(set2), set2);
    }

    public static <E> SetView<E> m1326c(Set<E> set, Set<?> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new C00443(set, Predicates.not(Predicates.in(set2)), set2);
    }

    @CheckReturnValue
    public static <E> Set<E> m1317a(Set<E> set, Predicate<? super E> predicate) {
        if (set instanceof SortedSet) {
            return Platform.m647a((SortedSet) set, (Predicate) predicate);
        }
        if (!(set instanceof FilteredSet)) {
            return new FilteredSet((Set) Preconditions.checkNotNull(set), (Predicate) Preconditions.checkNotNull(predicate));
        }
        FilteredSet filteredSet = (FilteredSet) set;
        return new FilteredSet((Set) filteredSet.f12022a, Predicates.and(filteredSet.f12023b, predicate));
    }

    static <E> SortedSet<E> m1318a(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        if (!(sortedSet instanceof FilteredSet)) {
            return new FilteredSortedSet((SortedSet) Preconditions.checkNotNull(sortedSet), (Predicate) Preconditions.checkNotNull(predicate));
        }
        FilteredSet filteredSet = (FilteredSet) sortedSet;
        return new FilteredSortedSet((SortedSet) filteredSet.f12022a, Predicates.and(filteredSet.f12023b, predicate));
    }

    @CheckReturnValue
    @GwtIncompatible("NavigableSet")
    public static <E> NavigableSet<E> m1316a(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
        if (!(navigableSet instanceof FilteredSet)) {
            return new FilteredNavigableSet((NavigableSet) Preconditions.checkNotNull(navigableSet), (Predicate) Preconditions.checkNotNull(predicate));
        }
        FilteredSet filteredSet = (FilteredSet) navigableSet;
        return new FilteredNavigableSet((NavigableSet) filteredSet.f12022a, Predicates.and(filteredSet.f12023b, predicate));
    }

    static int m1310a(Set<?> set) {
        int i = 0;
        for (Object next : set) {
            int hashCode;
            if (next != null) {
                hashCode = next.hashCode();
            } else {
                hashCode = 0;
            }
            i = ((i + hashCode) ^ -1) ^ -1;
        }
        return i;
    }

    static boolean m1320a(Set<?> set, @Nullable Object obj) {
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

    static boolean m1322a(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    static boolean m1321a(Set<?> set, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof Multiset) {
            Collection d = ((Multiset) collection).mo2155d();
        }
        if (!(d instanceof Set) || d.size() <= set.size()) {
            return m1322a((Set) set, d.iterator());
        }
        return Iterators.m1413a(set.iterator(), d);
    }
}
