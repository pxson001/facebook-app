package com.google.common.collect;

import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection.ArrayBasedBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: worst_row_key */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    static final int MAX_TABLE_SIZE = 1073741824;

    /* compiled from: worst_row_key */
    public class Builder<E> extends ArrayBasedBuilder<E> {
        public /* synthetic */ ArrayBasedBuilder mo93a(Object obj) {
            return m4813c(obj);
        }

        public /* synthetic */ com.google.common.collect.ImmutableCollection.Builder mo94a(Iterable iterable) {
            return m4809b(iterable);
        }

        public /* synthetic */ com.google.common.collect.ImmutableCollection.Builder mo95a(Iterator it) {
            return m4810b(it);
        }

        public /* synthetic */ com.google.common.collect.ImmutableCollection.Builder mo96a(Object[] objArr) {
            return m4811b(objArr);
        }

        public /* synthetic */ ImmutableCollection mo97a() {
            return m4812b();
        }

        public /* synthetic */ com.google.common.collect.ImmutableCollection.Builder mo98b(Object obj) {
            return m4813c(obj);
        }

        public Builder() {
            this(4);
        }

        private Builder(int i) {
            super(i);
        }

        public Builder<E> m4813c(E e) {
            super.mo93a((Object) e);
            return this;
        }

        public Builder<E> m4811b(E... eArr) {
            super.mo96a((Object[]) eArr);
            return this;
        }

        public Builder<E> m4809b(Iterable<? extends E> iterable) {
            super.mo94a((Iterable) iterable);
            return this;
        }

        public Builder<E> m4810b(Iterator<? extends E> it) {
            super.mo95a((Iterator) it);
            return this;
        }

        public ImmutableSet<E> m4812b() {
            ImmutableSet<E> construct = ImmutableSet.construct(this.f533b, this.f532a);
            this.b = construct.size();
            return construct;
        }
    }

    /* compiled from: worst_row_key */
    abstract class Indexed<E> extends ImmutableSet<E> {
        abstract E mo1720a(int i);

        Indexed() {
        }

        public UnmodifiableIterator<E> iterator() {
            return asList().iterator();
        }

        ImmutableList<E> createAsList() {
            return new 1(this);
        }
    }

    public abstract UnmodifiableIterator<E> iterator();

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.f688a;
    }

    public static <E> ImmutableSet<E> of(E e) {
        return new SingletonImmutableSet(e);
    }

    public static <E> ImmutableSet<E> of(E e, E e2) {
        return construct(2, e, e2);
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3) {
        return construct(3, e, e2, e3);
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4) {
        return construct(4, e, e2, e3, e4);
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4, E e5) {
        return construct(5, e, e2, e3, e4, e5);
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        Object obj = new Object[(eArr.length + 6)];
        obj[0] = e;
        obj[1] = e2;
        obj[2] = e3;
        obj[3] = e4;
        obj[4] = e5;
        obj[5] = e6;
        System.arraycopy(eArr, 0, obj, 6, eArr.length);
        return construct(obj.length, obj);
    }

    public static <E> ImmutableSet<E> construct(int i, Object... objArr) {
        switch (i) {
            case 0:
                return RegularImmutableSet.f688a;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return of(objArr[0]);
            default:
                int chooseTableSize = chooseTableSize(i);
                Object[] objArr2 = new Object[chooseTableSize];
                int i2 = chooseTableSize - 1;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i3 < i) {
                    Object a = ObjectArrays.m624a(objArr[i3], i3);
                    int hashCode = a.hashCode();
                    int a2 = Hashing.m653a(hashCode);
                    while (true) {
                        int i6 = a2 & i2;
                        Object obj = objArr2[i6];
                        if (obj == null) {
                            a2 = i4 + 1;
                            objArr[i4] = a;
                            objArr2[i6] = a;
                            i4 = i5 + hashCode;
                        } else if (obj.equals(a)) {
                            a2 = i4;
                            i4 = i5;
                        } else {
                            a2++;
                        }
                        i3++;
                        i5 = i4;
                        i4 = a2;
                    }
                }
                Arrays.fill(objArr, i4, i, null);
                if (i4 == 1) {
                    return new SingletonImmutableSet(objArr[0], i5);
                }
                if (chooseTableSize != chooseTableSize(i4)) {
                    return construct(i4, objArr);
                }
                if (i4 < objArr.length) {
                    objArr = ObjectArrays.m633b(objArr, i4);
                }
                return new RegularImmutableSet(objArr, i5, objArr2, i2);
        }
    }

    @VisibleForTesting
    static int chooseTableSize(int i) {
        if (i < CUTOFF) {
            int highestOneBit = Integer.highestOneBit(i - 1) << 1;
            while (((double) highestOneBit) * DESIRED_LOAD_FACTOR < ((double) i)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        Preconditions.checkArgument(i < MAX_TABLE_SIZE, "collection too large");
        return MAX_TABLE_SIZE;
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof ImmutableSortedSet)) {
            ImmutableSet immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        } else if (collection instanceof EnumSet) {
            return copyOfEnumSet((EnumSet) collection);
        }
        Object[] toArray = collection.toArray();
        return construct(toArray.length, toArray);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return RegularImmutableSet.f688a;
        }
        Object next = it.next();
        if (it.hasNext()) {
            return new Builder().m4813c(next).m4810b((Iterator) it).m4812b();
        }
        return of(next);
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        switch (eArr.length) {
            case 0:
                return RegularImmutableSet.f688a;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return of(eArr[0]);
            default:
                return construct(eArr.length, (Object[]) eArr.clone());
        }
    }

    private static ImmutableSet copyOfEnumSet(EnumSet enumSet) {
        return ImmutableEnumSet.a(EnumSet.copyOf(enumSet));
    }

    ImmutableSet() {
    }

    boolean isHashCodeFast() {
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.m1320a((Set) this, obj);
    }

    public int hashCode() {
        return Sets.m1310a((Set) this);
    }

    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> Builder<E> builder() {
        return new Builder();
    }
}
