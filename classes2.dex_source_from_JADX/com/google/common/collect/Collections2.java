package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
@CheckReturnValue
/* compiled from: zero_rating2/clearable/default_optin/title_key */
public final class Collections2 {
    public static final Joiner f415a = Joiner.on(", ").useForNull("null");

    /* compiled from: zero_rating2/clearable/default_optin/title_key */
    public class FilteredCollection<E> extends AbstractCollection<E> {
        public final Collection<E> f12022a;
        public final Predicate<? super E> f12023b;

        public FilteredCollection(Collection<E> collection, Predicate<? super E> predicate) {
            this.f12022a = collection;
            this.f12023b = predicate;
        }

        public boolean add(E e) {
            Preconditions.checkArgument(this.f12023b.apply(e));
            return this.f12022a.add(e);
        }

        public boolean addAll(Collection<? extends E> collection) {
            for (Object apply : collection) {
                Preconditions.checkArgument(this.f12023b.apply(apply));
            }
            return this.f12022a.addAll(collection);
        }

        public void clear() {
            Iterables.m953a(this.f12022a, this.f12023b);
        }

        public boolean contains(@Nullable Object obj) {
            if (Collections2.m849a(this.f12022a, obj)) {
                return this.f12023b.apply(obj);
            }
            return false;
        }

        public boolean containsAll(Collection<?> collection) {
            return Collections2.m850a((Collection) this, (Collection) collection);
        }

        public boolean isEmpty() {
            return !Iterables.m969d(this.f12022a, this.f12023b);
        }

        public Iterator<E> iterator() {
            return Iterators.m1417b(this.f12022a.iterator(), this.f12023b);
        }

        public boolean remove(Object obj) {
            return contains(obj) && this.f12022a.remove(obj);
        }

        public boolean removeAll(Collection<?> collection) {
            return Iterables.m953a(this.f12022a, Predicates.and(this.f12023b, Predicates.in(collection)));
        }

        public boolean retainAll(Collection<?> collection) {
            return Iterables.m953a(this.f12022a, Predicates.and(this.f12023b, Predicates.not(Predicates.in(collection))));
        }

        public int size() {
            return Iterators.m1415b(iterator());
        }

        public Object[] toArray() {
            return Lists.m1299a(iterator()).toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return Lists.m1299a(iterator()).toArray(tArr);
        }
    }

    private Collections2() {
    }

    @CheckReturnValue
    public static <E> Collection<E> m848a(Collection<E> collection, Predicate<? super E> predicate) {
        if (!(collection instanceof FilteredCollection)) {
            return new FilteredCollection((Collection) Preconditions.checkNotNull(collection), (Predicate) Preconditions.checkNotNull(predicate));
        }
        FilteredCollection filteredCollection = (FilteredCollection) collection;
        return new FilteredCollection(filteredCollection.f12022a, Predicates.and(filteredCollection.f12023b, predicate));
    }

    static boolean m849a(Collection<?> collection, @Nullable Object obj) {
        boolean z = false;
        Preconditions.checkNotNull(collection);
        try {
            z = collection.contains(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return z;
    }

    static boolean m851b(Collection<?> collection, @Nullable Object obj) {
        boolean z = false;
        Preconditions.checkNotNull(collection);
        try {
            z = collection.remove(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return z;
    }

    public static <F, T> Collection<T> m847a(Collection<F> collection, Function<? super F, T> function) {
        return new TransformedCollection(collection, function);
    }

    public static boolean m850a(Collection<?> collection, Collection<?> collection2) {
        return Iterables.m970e(collection2, Predicates.in(collection));
    }

    public static StringBuilder m845a(int i) {
        CollectPreconditions.m615a(i, "size");
        return new StringBuilder((int) Math.min(((long) i) * 8, 1073741824));
    }

    static <T> Collection<T> m846a(Iterable<T> iterable) {
        return (Collection) iterable;
    }
}
