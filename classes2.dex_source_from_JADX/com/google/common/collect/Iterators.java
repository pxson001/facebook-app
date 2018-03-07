package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Absent;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: work_list */
public final class Iterators {
    public static final UnmodifiableListIterator<Object> f693a = new C00421();
    public static final Iterator<Object> f694b = new C00432();

    /* compiled from: work_list */
    final class C00421 extends UnmodifiableListIterator<Object> {
        C00421() {
        }

        public final boolean hasNext() {
            return false;
        }

        public final Object next() {
            throw new NoSuchElementException();
        }

        public final boolean hasPrevious() {
            return false;
        }

        public final Object previous() {
            throw new NoSuchElementException();
        }

        public final int nextIndex() {
            return 0;
        }

        public final int previousIndex() {
            return -1;
        }
    }

    /* compiled from: work_list */
    final class C00432 implements Iterator<Object> {
        C00432() {
        }

        public final boolean hasNext() {
            return false;
        }

        public final Object next() {
            throw new NoSuchElementException();
        }

        public final void remove() {
            CollectPreconditions.m617a(false);
        }
    }

    /* compiled from: work_list */
    final class C00467 extends AbstractIterator<T> {
        final /* synthetic */ Iterator f708a;
        final /* synthetic */ Predicate f709b;

        C00467(Iterator it, Predicate predicate) {
            this.f708a = it;
            this.f709b = predicate;
        }

        protected final T mo209a() {
            while (this.f708a.hasNext()) {
                T next = this.f708a.next();
                if (this.f709b.apply(next)) {
                    return next;
                }
            }
            return m1437b();
        }
    }

    /* compiled from: work_list */
    final class C00475 implements Iterator<T> {
        Iterator<? extends T> f713a = Iterators.f693a;
        Iterator<? extends T> f714b;
        final /* synthetic */ Iterator f715c;

        C00475(Iterator it) {
            this.f715c = it;
        }

        public final boolean hasNext() {
            boolean hasNext;
            while (true) {
                hasNext = ((Iterator) Preconditions.checkNotNull(this.f713a)).hasNext();
                if (hasNext || !this.f715c.hasNext()) {
                    return hasNext;
                }
                this.f713a = (Iterator) this.f715c.next();
            }
            return hasNext;
        }

        public final T next() {
            if (hasNext()) {
                this.f714b = this.f713a;
                return this.f713a.next();
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            CollectPreconditions.m617a(this.f714b != null);
            this.f714b.remove();
            this.f714b = null;
        }
    }

    /* compiled from: work_list */
    final class C00483 extends UnmodifiableIterator<T> {
        final /* synthetic */ Iterator f716a;

        C00483(Iterator it) {
            this.f716a = it;
        }

        public final boolean hasNext() {
            return this.f716a.hasNext();
        }

        public final T next() {
            return this.f716a.next();
        }
    }

    /* compiled from: work_list */
    final class AnonymousClass11 extends AbstractIndexedListIterator<T> {
        final /* synthetic */ Object[] f718a;
        final /* synthetic */ int f719b;

        AnonymousClass11(int i, int i2, Object[] objArr, int i3) {
            this.f718a = objArr;
            this.f719b = i3;
            super(i, i2);
        }

        protected final T mo210a(int i) {
            return this.f718a[this.f719b + i];
        }
    }

    /* compiled from: work_list */
    final class AnonymousClass12 extends UnmodifiableIterator<T> {
        boolean f2299a;
        final /* synthetic */ Object f2300b;

        AnonymousClass12(Object obj) {
            this.f2300b = obj;
        }

        public final boolean hasNext() {
            return !this.f2299a;
        }

        public final T next() {
            if (this.f2299a) {
                throw new NoSuchElementException();
            }
            this.f2299a = true;
            return this.f2300b;
        }
    }

    /* compiled from: work_list */
    final class C02838 extends TransformedIterator<F, T> {
        final /* synthetic */ Function f6370a;

        C02838(Iterator it, Function function) {
            this.f6370a = function;
            super(it);
        }

        final T mo1480a(F f) {
            return this.f6370a.apply(f);
        }
    }

    private Iterators() {
    }

    public static <T> UnmodifiableIterator<T> m1404a(Iterator<T> it) {
        Preconditions.checkNotNull(it);
        if (it instanceof UnmodifiableIterator) {
            return (UnmodifiableIterator) it;
        }
        return new C00483(it);
    }

    public static int m1415b(Iterator<?> it) {
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
        }
        return i;
    }

    public static boolean m1413a(Iterator<?> it, Collection<?> collection) {
        return m1412a((Iterator) it, Predicates.in(collection));
    }

    public static <T> boolean m1412a(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        boolean z = false;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean m1419b(Iterator<?> it, Collection<?> collection) {
        return m1412a((Iterator) it, Predicates.not(Predicates.in(collection)));
    }

    public static boolean m1414a(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext()) {
                return false;
            }
            if (!Objects.equal(it.next(), it2.next())) {
                return false;
            }
        }
        if (it2.hasNext()) {
            return false;
        }
        return true;
    }

    public static <T> T m1423d(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("expected one element but was: <" + next);
        for (int i = 0; i < 4 && it.hasNext(); i++) {
            stringBuilder.append(", " + it.next());
        }
        if (it.hasNext()) {
            stringBuilder.append(", ...");
        }
        stringBuilder.append('>');
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static <T> boolean m1411a(Collection<T> collection, Iterator<? extends T> it) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkNotNull(it);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    public static <T> Iterator<T> m1425e(Iterator<? extends Iterator<? extends T>> it) {
        Preconditions.checkNotNull(it);
        return new C00475(it);
    }

    @CheckReturnValue
    public static <T> UnmodifiableIterator<T> m1417b(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        return new C00467(it, predicate);
    }

    public static <T> T m1424e(Iterator<T> it, Predicate<? super T> predicate) {
        return m1417b((Iterator) it, (Predicate) predicate).next();
    }

    @Nullable
    public static <T> T m1408a(Iterator<? extends T> it, Predicate<? super T> predicate, @Nullable T t) {
        return m1418b(m1417b((Iterator) it, (Predicate) predicate), (Object) t);
    }

    public static <T> Optional<T> m1426f(Iterator<T> it, Predicate<? super T> predicate) {
        UnmodifiableIterator b = m1417b((Iterator) it, (Predicate) predicate);
        if (b.hasNext()) {
            return Optional.of(b.next());
        }
        return Absent.INSTANCE;
    }

    public static <T> boolean m1422c(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate, "predicate");
        int i = 0;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                break;
            }
            i++;
        }
        i = -1;
        return i != -1;
    }

    public static <F, T> Iterator<T> m1409a(Iterator<F> it, Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(function);
        return new C02838(it, function);
    }

    public static <T> T m1407a(Iterator<T> it, int i) {
        m1410a(i);
        int b = m1416b((Iterator) it, i);
        if (it.hasNext()) {
            return it.next();
        }
        throw new IndexOutOfBoundsException("position (" + i + ") must be less than the number of elements that remained (" + b + ")");
    }

    static void m1410a(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("position (" + i + ") must not be negative");
        }
    }

    @Nullable
    public static <T> T m1418b(Iterator<? extends T> it, @Nullable T t) {
        return it.hasNext() ? it.next() : t;
    }

    public static <T> T m1427f(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    @Nullable
    public static <T> T m1420c(Iterator<? extends T> it, @Nullable T t) {
        return it.hasNext() ? m1427f(it) : t;
    }

    public static int m1416b(Iterator<?> it, int i) {
        boolean z;
        int i2 = 0;
        Preconditions.checkNotNull(it);
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "numberToAdvance must be nonnegative");
        while (i2 < i && it.hasNext()) {
            it.next();
            i2++;
        }
        return i2;
    }

    public static <T> Iterator<T> m1421c(Iterator<T> it, int i) {
        Preconditions.checkNotNull(it);
        Preconditions.checkArgument(i >= 0, "limit is negative");
        return new 9(i, it);
    }

    @Nullable
    static <T> T m1428g(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    static void m1429h(Iterator<?> it) {
        Preconditions.checkNotNull(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> UnmodifiableIterator<T> m1405a(T... tArr) {
        return m1406a(tArr, 0, tArr.length, 0);
    }

    static <T> UnmodifiableListIterator<T> m1406a(T[] tArr, int i, int i2, int i3) {
        Preconditions.checkArgument(i2 >= 0);
        Preconditions.checkPositionIndexes(i, i + i2, tArr.length);
        Preconditions.checkPositionIndex(i3, i2);
        if (i2 == 0) {
            return f693a;
        }
        return new AnonymousClass11(i2, i3, tArr, i);
    }

    public static <T> UnmodifiableIterator<T> m1403a(@Nullable T t) {
        return new AnonymousClass12(t);
    }

    public static <T> PeekingIterator<T> m1430i(Iterator<? extends T> it) {
        if (it instanceof PeekingImpl) {
            return (PeekingImpl) it;
        }
        return new PeekingImpl(it);
    }

    static <T> ListIterator<T> m1431j(Iterator<T> it) {
        return (ListIterator) it;
    }
}
