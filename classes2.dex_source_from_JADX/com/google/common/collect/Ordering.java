package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps.EntryFunction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: gl */
public abstract class Ordering<T> implements Comparator<T> {
    public abstract int compare(@Nullable T t, @Nullable T t2);

    final <T2 extends T> Ordering<Entry<T2, ?>> m30195e() {
        return m30182a((Function) EntryFunction.KEY);
    }

    @GwtCompatible
    public static <C extends Comparable> Ordering<C> m30180d() {
        return NaturalOrdering.f22266a;
    }

    @GwtCompatible
    public static <T> Ordering<T> m30178a(Comparator<T> comparator) {
        return comparator instanceof Ordering ? (Ordering) comparator : new ComparatorOrdering(comparator);
    }

    protected Ordering() {
    }

    @GwtCompatible
    public <S extends T> Ordering<S> mo3241a() {
        return new ReverseOrdering(this);
    }

    @GwtCompatible
    public <S extends T> Ordering<S> m30187b() {
        return new NullsFirstOrdering(this);
    }

    @GwtCompatible
    public <S extends T> Ordering<S> m30192c() {
        return new NullsLastOrdering(this);
    }

    @GwtCompatible
    public final <F> Ordering<F> m30182a(Function<F, ? extends T> function) {
        return new ByFunctionOrdering(function, this);
    }

    @GwtCompatible
    public final <U extends T> Ordering<U> m30188b(Comparator<? super U> comparator) {
        return new CompoundOrdering(this, (Comparator) Preconditions.checkNotNull(comparator));
    }

    public <E extends T> E mo3245a(Iterator<E> it) {
        Object next = it.next();
        while (it.hasNext()) {
            next = mo3244a(next, it.next());
        }
        return next;
    }

    public <E extends T> E mo3243a(Iterable<E> iterable) {
        return mo3245a(iterable.iterator());
    }

    public <E extends T> E mo3244a(@Nullable E e, @Nullable E e2) {
        return compare(e, e2) <= 0 ? e : e2;
    }

    public <E extends T> E mo3248b(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = mo3247b(next, it.next());
        }
        return next;
    }

    public <E extends T> E mo3246b(Iterable<E> iterable) {
        return mo3248b(iterable.iterator());
    }

    public <E extends T> E mo3247b(@Nullable E e, @Nullable E e2) {
        return compare(e, e2) >= 0 ? e : e2;
    }

    public final <E extends T> List<E> m30186a(Iterable<E> iterable, int i) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (((long) collection.size()) <= 2 * ((long) i)) {
                Object[] toArray = collection.toArray();
                Arrays.sort(toArray, this);
                if (toArray.length > i) {
                    toArray = ObjectArrays.m633b(toArray, i);
                }
                return Collections.unmodifiableList(Arrays.asList(toArray));
            }
        }
        return m30179a(iterable.iterator(), i);
    }

    private <E extends T> List<E> m30179a(Iterator<E> it, int i) {
        Preconditions.checkNotNull(it);
        CollectPreconditions.m615a(i, "k");
        if (i == 0 || !it.hasNext()) {
            return RegularImmutableList.f535a;
        }
        if (i >= 1073741823) {
            List a = Lists.m1299a((Iterator) it);
            Collections.sort(a, this);
            if (a.size() > i) {
                a.subList(i, a.size()).clear();
            }
            a.trimToSize();
            return Collections.unmodifiableList(a);
        }
        int i2 = i * 2;
        Object[] objArr = new Object[i2];
        Object next = it.next();
        objArr[0] = next;
        int i3 = 1;
        while (i3 < i && it.hasNext()) {
            Object next2 = it.next();
            int i4 = i3 + 1;
            objArr[i3] = next2;
            next = mo3247b(next, next2);
            i3 = i4;
        }
        while (it.hasNext()) {
            next2 = it.next();
            if (compare(next2, next) < 0) {
                i4 = i3 + 1;
                objArr[i3] = next2;
                if (i4 == i2) {
                    i4 = i2 - 1;
                    int i5 = 0;
                    i3 = 0;
                    while (i5 < i4) {
                        int a2 = m30177a(objArr, i5, i4, ((i5 + i4) + 1) >>> 1);
                        if (a2 <= i) {
                            if (a2 >= i) {
                                break;
                            }
                            i5 = Math.max(a2, i5 + 1);
                            i3 = a2;
                        } else {
                            i4 = a2 - 1;
                        }
                    }
                    next = objArr[i3];
                    for (i3++; i3 < i; i3++) {
                        next = mo3247b(next, objArr[i3]);
                    }
                    i3 = i;
                } else {
                    i3 = i4;
                }
            }
        }
        Arrays.sort(objArr, 0, i3, this);
        return Collections.unmodifiableList(Arrays.asList(ObjectArrays.m633b(objArr, Math.min(i3, i))));
    }

    private <E extends T> int m30177a(E[] eArr, int i, int i2, int i3) {
        Object obj = eArr[i3];
        eArr[i3] = eArr[i2];
        eArr[i2] = obj;
        int i4 = i;
        while (i < i2) {
            if (compare(eArr[i], obj) < 0) {
                ObjectArrays.m625a(eArr, i4, i);
                i4++;
            }
            i++;
        }
        ObjectArrays.m625a(eArr, i2, i4);
        return i4;
    }

    public final <E extends T> List<E> m30193c(Iterable<E> iterable) {
        Object[] e = Iterables.m971e(iterable);
        Arrays.sort(e, this);
        return Lists.m1298a(Arrays.asList(e));
    }

    public final <E extends T> ImmutableList<E> m30194d(Iterable<E> iterable) {
        Object[] e = Iterables.m971e(iterable);
        for (Object checkNotNull : e) {
            Preconditions.checkNotNull(checkNotNull);
        }
        Arrays.sort(e, this);
        return ImmutableList.asImmutableList(e);
    }
}
