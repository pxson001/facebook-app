package com.google.common.collect;

import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList.SerializedForm;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: zero_token_dont_fetch_on_null_carrier */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private transient ImmutableList<E> asList;

    /* compiled from: zero_token_dont_fetch_on_null_carrier */
    public abstract class Builder<E> {
        public abstract ImmutableCollection<E> mo97a();

        public abstract Builder<E> mo98b(E e);

        static int m618a(int i, int i2) {
            if (i2 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i3 = ((i >> 1) + i) + 1;
            if (i3 < i2) {
                i3 = Integer.highestOneBit(i2 - 1) << 1;
            }
            if (i3 < 0) {
                return Integer.MAX_VALUE;
            }
            return i3;
        }

        Builder() {
        }

        public Builder<E> mo96a(E... eArr) {
            for (Object b : eArr) {
                mo98b(b);
            }
            return this;
        }

        public Builder<E> mo94a(Iterable<? extends E> iterable) {
            for (Object b : iterable) {
                mo98b(b);
            }
            return this;
        }

        public Builder<E> mo95a(Iterator<? extends E> it) {
            while (it.hasNext()) {
                mo98b(it.next());
            }
            return this;
        }
    }

    /* compiled from: zero_token_dont_fetch_on_null_carrier */
    public abstract class ArrayBasedBuilder<E> extends Builder<E> {
        Object[] f532a;
        int f533b = 0;

        public /* synthetic */ Builder mo98b(Object obj) {
            return mo93a(obj);
        }

        ArrayBasedBuilder(int i) {
            CollectPreconditions.m615a(i, "initialCapacity");
            this.f532a = new Object[i];
        }

        private void m1070a(int i) {
            if (this.f532a.length < i) {
                this.f532a = ObjectArrays.m633b(this.f532a, Builder.m618a(this.f532a.length, i));
            }
        }

        public ArrayBasedBuilder<E> mo93a(E e) {
            Preconditions.checkNotNull(e);
            m1070a(this.f533b + 1);
            Object[] objArr = this.f532a;
            int i = this.f533b;
            this.f533b = i + 1;
            objArr[i] = e;
            return this;
        }

        public Builder<E> mo96a(E... eArr) {
            ObjectArrays.m631a((Object[]) eArr);
            m1070a(this.f533b + eArr.length);
            System.arraycopy(eArr, 0, this.f532a, this.f533b, eArr.length);
            this.f533b += eArr.length;
            return this;
        }

        public Builder<E> mo94a(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                m1070a(collection.size() + this.f533b);
            }
            super.mo94a((Iterable) iterable);
            return this;
        }
    }

    public abstract boolean contains(@Nullable Object obj);

    public abstract boolean isPartialView();

    public abstract UnmodifiableIterator<E> iterator();

    ImmutableCollection() {
    }

    public final Object[] toArray() {
        int size = size();
        if (size == 0) {
            return ObjectArrays.f315a;
        }
        Object[] objArr = new Object[size];
        copyIntoArray(objArr, 0);
        return objArr;
    }

    public final <T> T[] toArray(T[] tArr) {
        Preconditions.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            tArr = Platform.m648a((Object[]) tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        immutableList = createAsList();
        this.asList = immutableList;
        return immutableList;
    }

    ImmutableList<E> createAsList() {
        switch (size()) {
            case 0:
                return RegularImmutableList.f535a;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return ImmutableList.of(iterator().next());
            default:
                return new RegularImmutableAsList(this, toArray());
        }
    }

    int copyIntoArray(Object[] objArr, int i) {
        Iterator it = iterator();
        while (it.hasNext()) {
            int i2 = i + 1;
            objArr[i] = it.next();
            i = i2;
        }
        return i;
    }

    Object writeReplace() {
        return new SerializedForm(toArray());
    }
}
