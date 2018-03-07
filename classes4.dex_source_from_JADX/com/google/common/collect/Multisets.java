package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset.Entry;
import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: validation_int */
public final class Multisets {
    private static final Ordering<Entry<?>> f386a = new C00365();

    /* compiled from: validation_int */
    final class C00365 extends Ordering<Entry<?>> {
        C00365() {
        }

        public final int compare(Object obj, Object obj2) {
            return Ints.a(((AbstractEntry) obj2).b(), ((AbstractEntry) obj).b());
        }
    }

    private Multisets() {
    }

    public static <E> Entry<E> m649a(@Nullable E e, int i) {
        return new ImmutableEntry(e, i);
    }

    public static int m648a(Iterable<?> iterable) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).d().size();
        }
        return 11;
    }

    static boolean m651a(Multiset<?> multiset, @Nullable Object obj) {
        if (obj == multiset) {
            return true;
        }
        if (!(obj instanceof Multiset)) {
            return false;
        }
        Multiset multiset2 = (Multiset) obj;
        if (multiset.size() != multiset2.size() || multiset.a().size() != multiset2.a().size()) {
            return false;
        }
        for (AbstractEntry abstractEntry : multiset2.a()) {
            if (multiset.a(abstractEntry.a()) != abstractEntry.b()) {
                return false;
            }
        }
        return true;
    }

    static <E> boolean m652a(Multiset<E> multiset, Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        if (collection instanceof Multiset) {
            for (AbstractEntry abstractEntry : m653b(collection).a()) {
                multiset.a(abstractEntry.a(), abstractEntry.b());
            }
        } else {
            Iterators.a(multiset, collection.iterator());
        }
        return true;
    }

    static boolean m654b(Multiset<?> multiset, Collection<?> collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).d();
        }
        return multiset.d().removeAll(collection);
    }

    static boolean m655c(Multiset<?> multiset, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).d();
        }
        return multiset.d().retainAll(collection);
    }

    public static <E> Iterator<E> m650a(Multiset<E> multiset) {
        return new MultisetIteratorImpl(multiset, multiset.a().iterator());
    }

    static <T> Multiset<T> m653b(Iterable<T> iterable) {
        return (Multiset) iterable;
    }
}
