package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.ListIterator;

/* compiled from: cacheIds */
class ImmutableList$SubList extends ImmutableList<E> {
    final transient int f7321a;
    final transient int f7322b;
    final /* synthetic */ ImmutableList this$0;

    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return super.listIterator();
    }

    public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return super.listIterator(i);
    }

    ImmutableList$SubList(ImmutableList immutableList, int i, int i2) {
        this.this$0 = immutableList;
        this.f7321a = i;
        this.f7322b = i2;
    }

    public int size() {
        return this.f7322b;
    }

    public E get(int i) {
        Preconditions.checkElementIndex(i, this.f7322b);
        return this.this$0.get(this.f7321a + i);
    }

    public ImmutableList<E> subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, this.f7322b);
        return this.this$0.subList(this.f7321a + i, this.f7321a + i2);
    }

    boolean isPartialView() {
        return true;
    }
}
