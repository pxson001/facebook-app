package com.google.common.collect;

import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection.ArrayBasedBuilder;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: zero_optin_interstitial */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    /* compiled from: zero_optin_interstitial */
    public final class Builder<E> extends ArrayBasedBuilder<E> {
        public final /* synthetic */ ArrayBasedBuilder mo93a(Object obj) {
            return m1069c(obj);
        }

        public final /* synthetic */ com.google.common.collect.ImmutableCollection.Builder mo94a(Iterable iterable) {
            return m1065b(iterable);
        }

        public final /* synthetic */ com.google.common.collect.ImmutableCollection.Builder mo95a(Iterator it) {
            return m1066b(it);
        }

        public final /* synthetic */ com.google.common.collect.ImmutableCollection.Builder mo96a(Object[] objArr) {
            return m1067b(objArr);
        }

        public final /* synthetic */ ImmutableCollection mo97a() {
            return m1068b();
        }

        public final /* synthetic */ com.google.common.collect.ImmutableCollection.Builder mo98b(Object obj) {
            return m1069c(obj);
        }

        public Builder() {
            this(4);
        }

        Builder(int i) {
            super(i);
        }

        public final Builder<E> m1069c(E e) {
            super.mo93a((Object) e);
            return this;
        }

        public final Builder<E> m1065b(Iterable<? extends E> iterable) {
            super.mo94a((Iterable) iterable);
            return this;
        }

        public final Builder<E> m1067b(E... eArr) {
            super.mo96a((Object[]) eArr);
            return this;
        }

        public final Builder<E> m1066b(Iterator<? extends E> it) {
            super.mo95a((Iterator) it);
            return this;
        }

        public final ImmutableList<E> m1068b() {
            return ImmutableList.asImmutableList(this.f532a, this.f533b);
        }
    }

    public static <E> ImmutableList<E> of() {
        return RegularImmutableList.f535a;
    }

    public static <E> ImmutableList<E> of(E e) {
        return new SingletonImmutableList(e);
    }

    public static <E> ImmutableList<E> of(E e, E e2) {
        return construct(e, e2);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3) {
        return construct(e, e2, e3);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4) {
        return construct(e, e2, e3, e4);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5) {
        return construct(e, e2, e3, e4, e5);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6) {
        return construct(e, e2, e3, e4, e5, e6);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7) {
        return construct(e, e2, e3, e4, e5, e6, e7);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return construct(e, e2, e3, e4, e5, e6, e7, e8);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        return construct(e, e2, e3, e4, e5, e6, e7, e8, e9);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        return construct(e, e2, e3, e4, e5, e6, e7, e8, e9, e10);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11) {
        return construct(e, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12, E... eArr) {
        Object obj = new Object[(eArr.length + 12)];
        obj[0] = e;
        obj[1] = e2;
        obj[2] = e3;
        obj[3] = e4;
        obj[4] = e5;
        obj[5] = e6;
        obj[6] = e7;
        obj[7] = e8;
        obj[8] = e9;
        obj[9] = e10;
        obj[10] = e11;
        obj[11] = e12;
        System.arraycopy(eArr, 0, obj, 12, eArr.length);
        return construct(obj);
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> collection) {
        if (!(collection instanceof ImmutableCollection)) {
            return construct(collection.toArray());
        }
        ImmutableList<E> asList = ((ImmutableCollection) collection).asList();
        if (asList.isPartialView()) {
            return asImmutableList(asList.toArray());
        }
        return asList;
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return RegularImmutableList.f535a;
        }
        Object next = it.next();
        if (it.hasNext()) {
            return new Builder().m1069c(next).m1066b((Iterator) it).m1068b();
        }
        return of(next);
    }

    public static <E> ImmutableList<E> copyOf(E[] eArr) {
        switch (eArr.length) {
            case 0:
                return RegularImmutableList.f535a;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new SingletonImmutableList(eArr[0]);
            default:
                return new RegularImmutableList(ObjectArrays.m631a((Object[]) eArr.clone()));
        }
    }

    private static <E> ImmutableList<E> construct(Object... objArr) {
        return asImmutableList(ObjectArrays.m631a(objArr));
    }

    static <E> ImmutableList<E> asImmutableList(Object[] objArr) {
        return asImmutableList(objArr, objArr.length);
    }

    static <E> ImmutableList<E> asImmutableList(Object[] objArr, int i) {
        switch (i) {
            case 0:
                return RegularImmutableList.f535a;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new SingletonImmutableList(objArr[0]);
            default:
                if (i < objArr.length) {
                    objArr = ObjectArrays.m633b(objArr, i);
                }
                return new RegularImmutableList(objArr);
        }
    }

    ImmutableList() {
    }

    public UnmodifiableIterator<E> iterator() {
        return listIterator();
    }

    public UnmodifiableListIterator<E> listIterator() {
        return listIterator(0);
    }

    public UnmodifiableListIterator<E> listIterator(int i) {
        return new AbstractIndexedListIterator<E>(this, size(), i) {
            final /* synthetic */ ImmutableList f13938a;

            protected final E mo210a(int i) {
                return this.f13938a.get(i);
            }
        };
    }

    public int indexOf(@Nullable Object obj) {
        if (obj == null) {
            return -1;
        }
        int i;
        if (this instanceof RandomAccess) {
            int i2 = 0;
            int size = size();
            if (obj == null) {
                while (i2 < size) {
                    if (get(i2) == null) {
                        break;
                    }
                    i2++;
                }
                i2 = -1;
            } else {
                while (i2 < size) {
                    if (obj.equals(get(i2))) {
                        break;
                    }
                    i2++;
                }
                i2 = -1;
            }
            i = i2;
        } else {
            ListIterator listIterator = listIterator();
            while (listIterator.hasNext()) {
                if (Objects.equal(obj, listIterator.next())) {
                    i = listIterator.previousIndex();
                    break;
                }
            }
            i = -1;
        }
        return i;
    }

    public int lastIndexOf(@Nullable Object obj) {
        if (obj == null) {
            return -1;
        }
        int i;
        if (this instanceof RandomAccess) {
            int size;
            if (obj == null) {
                size = size() - 1;
                while (size >= 0) {
                    if (get(size) == null) {
                        break;
                    }
                    size--;
                }
                size = -1;
            } else {
                size = size() - 1;
                while (size >= 0) {
                    if (obj.equals(get(size))) {
                        break;
                    }
                    size--;
                }
                size = -1;
            }
            i = size;
        } else {
            ListIterator listIterator = listIterator(size());
            while (listIterator.hasPrevious()) {
                if (Objects.equal(obj, listIterator.previous())) {
                    i = listIterator.nextIndex();
                    break;
                }
            }
            i = -1;
        }
        return i;
    }

    public boolean contains(@Nullable Object obj) {
        return indexOf(obj) >= 0;
    }

    public ImmutableList<E> subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        switch (i3) {
            case 0:
                return RegularImmutableList.f535a;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return of(get(i));
            default:
                return subListUnchecked(i, i2);
        }
    }

    ImmutableList<E> subListUnchecked(int i, int i2) {
        return new SubList(this, i, i2 - i);
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    public final ImmutableList<E> asList() {
        return this;
    }

    int copyIntoArray(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public ImmutableList<E> reverse() {
        return size() <= 1 ? this : new ReverseImmutableList(this);
    }

    public boolean equals(@Nullable Object obj) {
        return Lists.m1304a((List) this, obj);
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < size(); i2++) {
            i = (((i * 31) + get(i2).hashCode()) ^ -1) ^ -1;
        }
        return i;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> Builder<E> builder() {
        return new Builder();
    }
}
