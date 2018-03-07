package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.j2objc.annotations.Weak;

@GwtCompatible
/* compiled from: reaction_dialog */
public class RegularImmutableAsList<E> extends ImmutableAsList<E> {
    @Weak
    private final ImmutableCollection<E> delegate;
    private final ImmutableList<? extends E> delegateList;

    RegularImmutableAsList(ImmutableCollection<E> immutableCollection, ImmutableList<? extends E> immutableList) {
        this.delegate = immutableCollection;
        this.delegateList = immutableList;
    }

    RegularImmutableAsList(ImmutableCollection<E> immutableCollection, Object[] objArr) {
        this((ImmutableCollection) immutableCollection, ImmutableList.asImmutableList(objArr));
    }

    ImmutableCollection<E> mo1722a() {
        return this.delegate;
    }

    public UnmodifiableListIterator<E> listIterator(int i) {
        return this.delegateList.listIterator(i);
    }

    @GwtIncompatible("not present in emulated superclass")
    int copyIntoArray(Object[] objArr, int i) {
        return this.delegateList.copyIntoArray(objArr, i);
    }

    public E get(int i) {
        return this.delegateList.get(i);
    }
}
