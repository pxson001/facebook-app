package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@GwtCompatible
/* compiled from: zero_indicator_close */
public class RegularImmutableList<E> extends ImmutableList<E> {
    public static final ImmutableList<Object> f535a = new RegularImmutableList(ObjectArrays.f315a);
    private final transient int f536b;
    private final transient int f537c;
    private final transient Object[] f538d;

    private RegularImmutableList(Object[] objArr, int i, int i2) {
        this.f536b = i;
        this.f537c = i2;
        this.f538d = objArr;
    }

    RegularImmutableList(Object[] objArr) {
        this(objArr, 0, objArr.length);
    }

    public int size() {
        return this.f537c;
    }

    boolean isPartialView() {
        return this.f537c != this.f538d.length;
    }

    int copyIntoArray(Object[] objArr, int i) {
        System.arraycopy(this.f538d, this.f536b, objArr, i, this.f537c);
        return this.f537c + i;
    }

    public E get(int i) {
        Preconditions.checkElementIndex(i, this.f537c);
        return this.f538d[this.f536b + i];
    }

    ImmutableList<E> subListUnchecked(int i, int i2) {
        return new RegularImmutableList(this.f538d, this.f536b + i, i2 - i);
    }

    public UnmodifiableListIterator<E> listIterator(int i) {
        return Iterators.m1406a(this.f538d, this.f536b, this.f537c, i);
    }
}
