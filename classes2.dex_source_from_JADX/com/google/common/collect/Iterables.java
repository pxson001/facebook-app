package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: zero_rating2/clearable/default_optin/facepile_text_key */
public final class Iterables {

    /* compiled from: zero_rating2/clearable/default_optin/facepile_text_key */
    final class C02808 extends FluentIterable<T> {
        final /* synthetic */ Iterable f6365a;
        final /* synthetic */ Function f6366b;

        C02808(Iterable iterable, Function function) {
            this.f6365a = iterable;
            this.f6366b = function;
        }

        public final Iterator<T> iterator() {
            return Iterators.m1409a(this.f6365a.iterator(), this.f6366b);
        }
    }

    /* compiled from: zero_rating2/clearable/default_optin/facepile_text_key */
    final class C02812 extends FluentIterable<T> {
        final /* synthetic */ Iterable f6368a;

        C02812(Iterable iterable) {
            this.f6368a = iterable;
        }

        public final Iterator<T> iterator() {
            return Iterators.m1425e(new C02823(this.f6368a.iterator()));
        }
    }

    /* compiled from: zero_rating2/clearable/default_optin/facepile_text_key */
    public final class C02823 extends TransformedIterator<Iterable<? extends T>, Iterator<? extends T>> {
        public C02823(Iterator it) {
            super(it);
        }

        final Object mo1480a(Object obj) {
            return ((Iterable) obj).iterator();
        }
    }

    private Iterables() {
    }

    public static <T> Iterable<T> m944a(Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return ((iterable instanceof UnmodifiableIterable) || (iterable instanceof ImmutableCollection)) ? iterable : new UnmodifiableIterable(iterable);
    }

    public static int m959b(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return Iterators.m1415b(iterable.iterator());
    }

    public static <T> boolean m953a(Iterable<T> iterable, Predicate<? super T> predicate) {
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            return m956a((List) iterable, (Predicate) Preconditions.checkNotNull(predicate));
        }
        return Iterators.m1412a(iterable.iterator(), (Predicate) predicate);
    }

    private static <T> boolean m956a(List<T> list, Predicate<? super T> predicate) {
        int i = 0;
        int i2 = 0;
        while (i2 < list.size()) {
            Object obj = list.get(i2);
            if (!predicate.apply(obj)) {
                if (i2 > i) {
                    try {
                        list.set(i, obj);
                    } catch (UnsupportedOperationException e) {
                        m952a((List) list, (Predicate) predicate, i, i2);
                        return true;
                    }
                }
                i++;
            }
            i2++;
        }
        list.subList(i, list.size()).clear();
        if (i2 != i) {
            return true;
        }
        return false;
    }

    private static <T> void m952a(List<T> list, Predicate<? super T> predicate, int i, int i2) {
        int size;
        for (size = list.size() - 1; size > i2; size--) {
            if (predicate.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (size = i2 - 1; size >= i; size--) {
            list.remove(size);
        }
    }

    @Nullable
    static <T> T m963b(Iterable<T> iterable, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    @CheckReturnValue
    public static boolean m954a(Iterable<?> iterable, Iterable<?> iterable2) {
        if ((iterable instanceof Collection) && (iterable2 instanceof Collection)) {
            if (((Collection) iterable).size() != ((Collection) iterable2).size()) {
                return false;
            }
        }
        return Iterators.m1414a(iterable.iterator(), iterable2.iterator());
    }

    public static String m967c(Iterable<?> iterable) {
        return Collections2.f415a.appendTo(new StringBuilder("["), iterable.iterator()).append(']').toString();
    }

    public static <T> T m968d(Iterable<T> iterable) {
        return Iterators.m1423d(iterable.iterator());
    }

    @GwtIncompatible("Array.newInstance(Class, int)")
    public static <T> T[] m957a(Iterable<? extends T> iterable, Class<T> cls) {
        Collection i = m975i(iterable);
        return i.toArray(ObjectArrays.m626a((Class) cls, i.size()));
    }

    public static <T> T[] m958a(Iterable<? extends T> iterable, T[] tArr) {
        return m975i(iterable).toArray(tArr);
    }

    public static Object[] m971e(Iterable<?> iterable) {
        return m975i(iterable).toArray();
    }

    private static <E> Collection<E> m975i(Iterable<E> iterable) {
        if (iterable instanceof Collection) {
            return (Collection) iterable;
        }
        return Lists.m1299a(iterable.iterator());
    }

    public static <T> boolean m955a(Collection<T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll(Collections2.m846a((Iterable) iterable));
        }
        return Iterators.m1411a((Collection) collection, ((Iterable) Preconditions.checkNotNull(iterable)).iterator());
    }

    public static <T> Iterable<T> m962b(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return m972f(ImmutableList.of(iterable, iterable2));
    }

    public static <T> Iterable<T> m946a(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return m972f(ImmutableList.of(iterable, iterable2, iterable3, iterable4));
    }

    public static <T> Iterable<T> m972f(Iterable<? extends Iterable<? extends T>> iterable) {
        Preconditions.checkNotNull(iterable);
        return new C02812(iterable);
    }

    @CheckReturnValue
    public static <T> Iterable<T> m966c(Iterable<T> iterable, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(predicate);
        return new 6(iterable, predicate);
    }

    @CheckReturnValue
    @GwtIncompatible("Class.isInstance")
    public static <T> Iterable<T> m961b(Iterable<?> iterable, Class<T> cls) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(cls);
        return new 7(iterable, cls);
    }

    public static <T> boolean m969d(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.m1422c(iterable.iterator(), (Predicate) predicate);
    }

    public static <T> boolean m970e(Iterable<T> iterable, Predicate<? super T> predicate) {
        boolean z;
        Preconditions.checkNotNull(predicate);
        for (T apply : iterable) {
            if (!predicate.apply(apply)) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }

    public static <T> T m973f(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.m1424e(iterable.iterator(), predicate);
    }

    @Nullable
    public static <T> T m949a(Iterable<? extends T> iterable, Predicate<? super T> predicate, @Nullable T t) {
        return Iterators.m1408a(iterable.iterator(), predicate, t);
    }

    @CheckReturnValue
    public static <F, T> Iterable<T> m945a(Iterable<F> iterable, Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(function);
        return new C02808(iterable, function);
    }

    public static <T> T m947a(Iterable<T> iterable, int i) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof List) {
            return ((List) iterable).get(i);
        }
        return Iterators.m1407a(iterable.iterator(), i);
    }

    @Nullable
    public static <T> T m948a(Iterable<? extends T> iterable, int i, @Nullable T t) {
        Preconditions.checkNotNull(iterable);
        Iterators.m1410a(i);
        if (iterable instanceof List) {
            List c = Lists.m1309c((Iterable) iterable);
            if (i < c.size()) {
                return c.get(i);
            }
            return t;
        }
        Iterator it = iterable.iterator();
        Iterators.m1416b(it, i);
        return Iterators.m1418b(it, (Object) t);
    }

    @Nullable
    public static <T> T m950a(Iterable<? extends T> iterable, @Nullable T t) {
        return Iterators.m1418b(iterable.iterator(), (Object) t);
    }

    public static <T> T m974g(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return Iterators.m1427f(iterable.iterator());
        }
        List list = (List) iterable;
        if (!list.isEmpty()) {
            return m951a(list);
        }
        throw new NoSuchElementException();
    }

    @Nullable
    public static <T> T m964b(Iterable<? extends T> iterable, @Nullable T t) {
        if (iterable instanceof Collection) {
            if (Collections2.m846a((Iterable) iterable).isEmpty()) {
                return t;
            }
            if (iterable instanceof List) {
                return m951a(Lists.m1309c((Iterable) iterable));
            }
        }
        return Iterators.m1420c(iterable.iterator(), (Object) t);
    }

    private static <T> T m951a(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> Iterable<T> m960b(Iterable<T> iterable, int i) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(i >= 0, "number to skip cannot be negative");
        if (iterable instanceof List) {
            return new 9((List) iterable, i);
        }
        return new 10(iterable, i);
    }

    public static <T> Iterable<T> m965c(Iterable<T> iterable, int i) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(i >= 0, "limit is negative");
        return new 11(iterable, i);
    }
}
