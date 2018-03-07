package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection.ArrayBasedBuilder;
import com.google.common.collect.ImmutableSet.Builder;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: button_type */
public final class ImmutableSortedSet$Builder<E> extends Builder<E> {
    private final Comparator<? super E> f7351c;

    public final /* synthetic */ ArrayBasedBuilder m13417a(Object obj) {
        return m13431d(obj);
    }

    public final /* synthetic */ ImmutableCollection.Builder m13418a(Iterable iterable) {
        return m13428c(iterable);
    }

    public final /* synthetic */ ImmutableCollection.Builder m13419a(Iterator it) {
        return m13416c(it);
    }

    public final /* synthetic */ ImmutableCollection.Builder m13420a(Object[] objArr) {
        return m13429c(objArr);
    }

    public final /* synthetic */ ImmutableCollection m13421a() {
        return m13430c();
    }

    public final /* synthetic */ ImmutableCollection.Builder m13422b(Object obj) {
        return m13431d(obj);
    }

    public final /* synthetic */ Builder m13423b(Iterable iterable) {
        return m13428c(iterable);
    }

    public final /* synthetic */ Builder m13424b(Iterator it) {
        return m13416c(it);
    }

    public final /* synthetic */ Builder m13425b(Object[] objArr) {
        return m13429c(objArr);
    }

    public final /* synthetic */ ImmutableSet m13426b() {
        return m13430c();
    }

    public final /* synthetic */ Builder m13427c(Object obj) {
        return m13431d(obj);
    }

    public ImmutableSortedSet$Builder(Comparator<? super E> comparator) {
        this.f7351c = (Comparator) Preconditions.checkNotNull(comparator);
    }

    public final ImmutableSortedSet$Builder<E> m13431d(E e) {
        super.c(e);
        return this;
    }

    public final ImmutableSortedSet$Builder<E> m13429c(E... eArr) {
        super.b(eArr);
        return this;
    }

    public final ImmutableSortedSet$Builder<E> m13428c(Iterable<? extends E> iterable) {
        super.b(iterable);
        return this;
    }

    private ImmutableSortedSet$Builder<E> m13416c(Iterator<? extends E> it) {
        super.b(it);
        return this;
    }

    public final ImmutableSortedSet<E> m13430c() {
        ImmutableSortedSet<E> a = ImmutableSortedSet.a(this.f7351c, this.b, this.a);
        this.b = a.size();
        return a;
    }
}
