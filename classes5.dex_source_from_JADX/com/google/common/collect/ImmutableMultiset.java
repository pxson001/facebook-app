package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet.Indexed;
import com.google.common.collect.Multiset.Entry;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: byteOffset */
public abstract class ImmutableMultiset<E> extends ImmutableCollection<E> implements Multiset<E> {
    private transient ImmutableSet<Entry<E>> f7337a;

    /* compiled from: byteOffset */
    public class Builder<E> extends com.google.common.collect.ImmutableCollection.Builder<E> {
        public final Multiset<E> f7343a;

        public Builder() {
            this(LinkedHashMultiset.m13472g());
        }

        private Builder(Multiset<E> multiset) {
            this.f7343a = multiset;
        }

        public final com.google.common.collect.ImmutableCollection.Builder m13394b(Object obj) {
            this.f7343a.add(Preconditions.checkNotNull(obj));
            return this;
        }

        public final com.google.common.collect.ImmutableCollection.Builder m13392a(Object[] objArr) {
            super.a(objArr);
            return this;
        }

        public final com.google.common.collect.ImmutableCollection.Builder m13390a(Iterable iterable) {
            if (iterable instanceof Multiset) {
                for (Multisets$AbstractEntry multisets$AbstractEntry : Multisets.b(iterable).a()) {
                    Object a = multisets$AbstractEntry.mo889a();
                    this.f7343a.a(Preconditions.checkNotNull(a), multisets$AbstractEntry.mo890b());
                }
            } else {
                super.a(iterable);
            }
            return this;
        }

        public final com.google.common.collect.ImmutableCollection.Builder m13391a(Iterator it) {
            super.a(it);
            return this;
        }

        public final ImmutableCollection m13393a() {
            return ImmutableMultiset.m13379a(this.f7343a);
        }
    }

    /* compiled from: byteOffset */
    public final class EntrySet extends Indexed<Entry<E>> {
        final boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        final Object m13395a(int i) {
            return ImmutableMultiset.this.mo928a(i);
        }

        public final int size() {
            return ImmutableMultiset.this.d().size();
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Multisets$AbstractEntry)) {
                return false;
            }
            Multisets$AbstractEntry multisets$AbstractEntry = (Multisets$AbstractEntry) obj;
            if (multisets$AbstractEntry.mo890b() > 0 && ImmutableMultiset.this.a(multisets$AbstractEntry.mo889a()) == multisets$AbstractEntry.mo890b()) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        final Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }
    }

    /* compiled from: byteOffset */
    class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        Object readResolve() {
            return this.multiset.m13385b();
        }
    }

    /* compiled from: byteOffset */
    class SerializedForm implements Serializable {
        final int[] counts;
        final Object[] elements;

        SerializedForm(Multiset<?> multiset) {
            int size = multiset.a().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i = 0;
            for (Multisets$AbstractEntry multisets$AbstractEntry : multiset.a()) {
                this.elements[i] = multisets$AbstractEntry.mo889a();
                this.counts[i] = multisets$AbstractEntry.mo890b();
                i++;
            }
        }

        Object readResolve() {
            Iterable a = LinkedHashMultiset.m13471a(this.elements.length);
            for (int i = 0; i < this.elements.length; i++) {
                a.a(this.elements[i], this.counts[i]);
            }
            return ImmutableMultiset.m13379a(a);
        }
    }

    abstract Entry<E> mo928a(int i);

    public final /* synthetic */ Set m13382a() {
        return m13385b();
    }

    public static <E> ImmutableMultiset<E> m13379a(Iterable<? extends E> iterable) {
        Multiset b;
        ImmutableMultiset immutableMultiset;
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset2 = (ImmutableMultiset) iterable;
            if (!immutableMultiset2.isPartialView()) {
                return immutableMultiset2;
            }
        }
        if (iterable instanceof Multiset) {
            b = Multisets.b(iterable);
        } else {
            LinkedHashMultiset a = LinkedHashMultiset.m13471a(Multisets.a(iterable));
            Iterables.a(a, iterable);
            b = a;
        }
        Collection a2 = b.a();
        if (a2.isEmpty()) {
            immutableMultiset = RegularImmutableMultiset.f7532a;
        } else {
            immutableMultiset = new RegularImmutableMultiset(a2);
        }
        return immutableMultiset;
    }

    ImmutableMultiset() {
    }

    public UnmodifiableIterator<E> iterator() {
        final UnmodifiableIterator it = m13385b().iterator();
        return new UnmodifiableIterator<E>(this) {
            int f7339a;
            E f7340b;
            final /* synthetic */ ImmutableMultiset f7342d;

            public boolean hasNext() {
                return this.f7339a > 0 || it.hasNext();
            }

            public E next() {
                if (this.f7339a <= 0) {
                    Multisets$AbstractEntry multisets$AbstractEntry = (Multisets$AbstractEntry) it.next();
                    this.f7340b = multisets$AbstractEntry.mo889a();
                    this.f7339a = multisets$AbstractEntry.mo890b();
                }
                this.f7339a--;
                return this.f7340b;
            }
        };
    }

    public boolean contains(@Nullable Object obj) {
        return a(obj) > 0;
    }

    @Deprecated
    public final int m13380a(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final int m13384b(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final int m13386c(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean m13383a(E e, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible("not present in emulated superclass")
    int copyIntoArray(Object[] objArr, int i) {
        UnmodifiableIterator it = m13385b().iterator();
        while (it.hasNext()) {
            Multisets$AbstractEntry multisets$AbstractEntry = (Multisets$AbstractEntry) it.next();
            Arrays.fill(objArr, i, multisets$AbstractEntry.mo890b() + i, multisets$AbstractEntry.mo889a());
            i += multisets$AbstractEntry.mo890b();
        }
        return i;
    }

    public boolean equals(@Nullable Object obj) {
        return Multisets.a(this, obj);
    }

    public int hashCode() {
        return Sets.a(m13385b());
    }

    public String toString() {
        return m13385b().toString();
    }

    public final ImmutableSet<Entry<E>> m13385b() {
        ImmutableSet<Entry<E>> immutableSet = this.f7337a;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = isEmpty() ? RegularImmutableSet.a : new EntrySet();
        this.f7337a = immutableSet;
        return immutableSet;
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }
}
