package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: write binary value */
public final class RegularImmutableSet<E> extends ImmutableSet<E> {
    public static final RegularImmutableSet<Object> f688a = new RegularImmutableSet(ObjectArrays.f315a, 0, null, 0);
    @VisibleForTesting
    final transient Object[] f689b;
    private final transient Object[] f690c;
    private final transient int f691d;
    private final transient int f692e;

    RegularImmutableSet(Object[] objArr, int i, Object[] objArr2, int i2) {
        this.f690c = objArr;
        this.f689b = objArr2;
        this.f691d = i2;
        this.f692e = i;
    }

    public final boolean contains(@Nullable Object obj) {
        Object[] objArr = this.f689b;
        if (obj == null || objArr == null) {
            return false;
        }
        int a = Hashing.m655a(obj);
        while (true) {
            a &= this.f691d;
            Object obj2 = objArr[a];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            a++;
        }
    }

    public final int size() {
        return this.f690c.length;
    }

    public final UnmodifiableIterator<E> iterator() {
        return Iterators.m1405a(this.f690c);
    }

    final int copyIntoArray(Object[] objArr, int i) {
        System.arraycopy(this.f690c, 0, objArr, i, this.f690c.length);
        return this.f690c.length + i;
    }

    final ImmutableList<E> createAsList() {
        return this.f689b == null ? RegularImmutableList.f535a : new RegularImmutableAsList((ImmutableCollection) this, this.f690c);
    }

    final boolean isPartialView() {
        return false;
    }

    public final int hashCode() {
        return this.f692e;
    }

    final boolean isHashCodeFast() {
        return true;
    }
}
