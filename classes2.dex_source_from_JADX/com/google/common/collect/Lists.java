package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: xout_menu_opened */
public final class Lists {

    /* compiled from: xout_menu_opened */
    public class ReverseList<T> extends AbstractList<T> {
        public final List<T> f6456a;

        ReverseList(List<T> list) {
            this.f6456a = (List) Preconditions.checkNotNull(list);
        }

        private int m11180a(int i) {
            int size = size();
            Preconditions.checkElementIndex(i, size);
            return (size - 1) - i;
        }

        public static int m11181b(ReverseList reverseList, int i) {
            int size = reverseList.size();
            Preconditions.checkPositionIndex(i, size);
            return size - i;
        }

        public void add(int i, @Nullable T t) {
            this.f6456a.add(m11181b(this, i), t);
        }

        public void clear() {
            this.f6456a.clear();
        }

        public T remove(int i) {
            return this.f6456a.remove(m11180a(i));
        }

        protected void removeRange(int i, int i2) {
            subList(i, i2).clear();
        }

        public T set(int i, @Nullable T t) {
            return this.f6456a.set(m11180a(i), t);
        }

        public T get(int i) {
            return this.f6456a.get(m11180a(i));
        }

        public int size() {
            return this.f6456a.size();
        }

        public List<T> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            return Lists.m1301a(this.f6456a.subList(m11181b(this, i2), m11181b(this, i)));
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i) {
            return new 1(this, this.f6456a.listIterator(m11181b(this, i)));
        }
    }

    /* compiled from: xout_menu_opened */
    class RandomAccessReverseList<T> extends ReverseList<T> implements RandomAccess {
        RandomAccessReverseList(List<T> list) {
            super(list);
        }
    }

    /* compiled from: xout_menu_opened */
    class TransformingRandomAccessList<F, T> extends AbstractList<T> implements Serializable, RandomAccess {
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        TransformingRandomAccessList(List<F> list, Function<? super F, ? extends T> function) {
            this.fromList = (List) Preconditions.checkNotNull(list);
            this.function = (Function) Preconditions.checkNotNull(function);
        }

        public void clear() {
            this.fromList.clear();
        }

        public T get(int i) {
            return this.function.apply(this.fromList.get(i));
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i) {
            return new TransformedListIterator<F, T>(this, this.fromList.listIterator(i)) {
                final /* synthetic */ TransformingRandomAccessList f13937a;

                final T mo1480a(F f) {
                    return this.f13937a.function.apply(f);
                }
            };
        }

        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        public T remove(int i) {
            return this.function.apply(this.fromList.remove(i));
        }

        public int size() {
            return this.fromList.size();
        }
    }

    private Lists() {
    }

    @GwtCompatible
    public static <E> ArrayList<E> m1296a() {
        return new ArrayList();
    }

    @GwtCompatible
    public static <E> ArrayList<E> m1300a(E... eArr) {
        Preconditions.checkNotNull(eArr);
        Object arrayList = new ArrayList(m1308c(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    @VisibleForTesting
    private static int m1308c(int i) {
        CollectPreconditions.m615a(i, "arraySize");
        return Ints.m4489b((5 + ((long) i)) + ((long) (i / 10)));
    }

    @GwtCompatible
    public static <E> ArrayList<E> m1298a(Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList(Collections2.m846a((Iterable) iterable));
        }
        return m1299a(iterable.iterator());
    }

    @GwtCompatible
    public static <E> ArrayList<E> m1299a(Iterator<? extends E> it) {
        Collection a = m1296a();
        Iterators.m1411a(a, (Iterator) it);
        return a;
    }

    @GwtCompatible
    public static <E> ArrayList<E> m1297a(int i) {
        CollectPreconditions.m615a(i, "initialArraySize");
        return new ArrayList(i);
    }

    @GwtCompatible
    public static <E> ArrayList<E> m1305b(int i) {
        return new ArrayList(m1308c(i));
    }

    @GwtCompatible
    public static <E> LinkedList<E> m1306b() {
        return new LinkedList();
    }

    @GwtCompatible
    public static <E> LinkedList<E> m1307b(Iterable<? extends E> iterable) {
        Collection b = m1306b();
        Iterables.m955a(b, (Iterable) iterable);
        return b;
    }

    @CheckReturnValue
    public static <F, T> List<T> m1303a(List<F> list, Function<? super F, ? extends T> function) {
        return list instanceof RandomAccess ? new TransformingRandomAccessList(list, function) : new TransformingSequentialList(list, function);
    }

    public static <T> List<List<T>> m1302a(List<T> list, int i) {
        Preconditions.checkNotNull(list);
        Preconditions.checkArgument(i > 0);
        return list instanceof RandomAccess ? new RandomAccessPartition(list, i) : new Partition(list, i);
    }

    @CheckReturnValue
    public static <T> List<T> m1301a(List<T> list) {
        if (list instanceof ImmutableList) {
            return ((ImmutableList) list).reverse();
        }
        if (list instanceof ReverseList) {
            return ((ReverseList) list).f6456a;
        }
        if (list instanceof RandomAccess) {
            return new RandomAccessReverseList(list);
        }
        return new ReverseList(list);
    }

    static boolean m1304a(List<?> list, @Nullable Object obj) {
        if (obj == Preconditions.checkNotNull(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return Iterators.m1414a(list.iterator(), list2.iterator());
        }
        for (int i = 0; i < size; i++) {
            if (!Objects.equal(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    static <T> List<T> m1309c(Iterable<T> iterable) {
        return (List) iterable;
    }
}
