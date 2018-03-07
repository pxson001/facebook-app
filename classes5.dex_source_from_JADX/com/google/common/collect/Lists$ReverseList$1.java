package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists.ReverseList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: bump_story_deduplication_key */
class Lists$ReverseList$1 implements ListIterator<T> {
    boolean f7421a;
    final /* synthetic */ ListIterator f7422b;
    final /* synthetic */ ReverseList f7423c;

    Lists$ReverseList$1(ReverseList reverseList, ListIterator listIterator) {
        this.f7423c = reverseList;
        this.f7422b = listIterator;
    }

    public void add(T t) {
        this.f7422b.add(t);
        this.f7422b.previous();
        this.f7421a = false;
    }

    public boolean hasNext() {
        return this.f7422b.hasPrevious();
    }

    public boolean hasPrevious() {
        return this.f7422b.hasNext();
    }

    public T next() {
        if (hasNext()) {
            this.f7421a = true;
            return this.f7422b.previous();
        }
        throw new NoSuchElementException();
    }

    public int nextIndex() {
        return ReverseList.b(this.f7423c, this.f7422b.nextIndex());
    }

    public T previous() {
        if (hasPrevious()) {
            this.f7421a = true;
            return this.f7422b.next();
        }
        throw new NoSuchElementException();
    }

    public int previousIndex() {
        return nextIndex() - 1;
    }

    public void remove() {
        CollectPreconditions.a(this.f7421a);
        this.f7422b.remove();
        this.f7421a = false;
    }

    public void set(T t) {
        Preconditions.checkState(this.f7421a);
        this.f7422b.set(t);
    }
}
