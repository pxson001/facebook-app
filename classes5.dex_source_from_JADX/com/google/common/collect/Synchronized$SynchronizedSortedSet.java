package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

/* compiled from: bug_report_retry_upload_success */
class Synchronized$SynchronizedSortedSet<E> extends Synchronized$SynchronizedSet<E> implements SortedSet<E> {
    final /* synthetic */ Set mo1001a() {
        return m13694d();
    }

    final /* synthetic */ Collection mo990b() {
        return m13694d();
    }

    final /* synthetic */ Object mo991c() {
        return m13694d();
    }

    Synchronized$SynchronizedSortedSet(SortedSet<E> sortedSet, @Nullable Object obj) {
        super(sortedSet, obj);
    }

    private SortedSet<E> m13694d() {
        return (SortedSet) super.mo1001a();
    }

    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator;
        synchronized (this.mutex) {
            comparator = m13694d().comparator();
        }
        return comparator;
    }

    public SortedSet<E> subSet(E e, E e2) {
        SortedSet<E> b;
        synchronized (this.mutex) {
            b = Synchronized.b(m13694d().subSet(e, e2), this.mutex);
        }
        return b;
    }

    public SortedSet<E> headSet(E e) {
        SortedSet<E> b;
        synchronized (this.mutex) {
            b = Synchronized.b(m13694d().headSet(e), this.mutex);
        }
        return b;
    }

    public SortedSet<E> tailSet(E e) {
        SortedSet<E> b;
        synchronized (this.mutex) {
            b = Synchronized.b(m13694d().tailSet(e), this.mutex);
        }
        return b;
    }

    public E first() {
        E first;
        synchronized (this.mutex) {
            first = m13694d().first();
        }
        return first;
    }

    public E last() {
        E last;
        synchronized (this.mutex) {
            last = m13694d().last();
        }
        return last;
    }
}
