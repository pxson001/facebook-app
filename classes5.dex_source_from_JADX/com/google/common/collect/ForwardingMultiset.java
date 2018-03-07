package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset.Entry;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: calling sendUrgentData(int) on FakeSocketImpl */
public abstract class ForwardingMultiset<E> extends ForwardingCollection<E> implements Multiset<E> {
    protected abstract Multiset<E> mo908l();

    protected /* synthetic */ Collection mo899b() {
        return mo908l();
    }

    protected /* synthetic */ Object mo902e() {
        return mo908l();
    }

    protected ForwardingMultiset() {
    }

    public final int m13241a(Object obj) {
        return mo908l().a(obj);
    }

    public final int m13242a(E e, int i) {
        return mo908l().a(e, i);
    }

    public final int m13245b(Object obj, int i) {
        return mo908l().b(obj, i);
    }

    public Set<E> mo901d() {
        return mo908l().d();
    }

    public Set<Entry<E>> mo897a() {
        return mo908l().a();
    }

    public boolean equals(@Nullable Object obj) {
        return obj == this || mo908l().equals(obj);
    }

    public int hashCode() {
        return mo908l().hashCode();
    }

    public final int m13248c(E e, int i) {
        return mo908l().c(e, i);
    }

    public final boolean m13244a(E e, int i, int i2) {
        return mo908l().a(e, i, i2);
    }

    @Beta
    protected final boolean m13247b(Collection<? extends E> collection) {
        return Multisets.a(this, collection);
    }

    protected final boolean m13249c(Collection<?> collection) {
        return Multisets.b(this, collection);
    }

    protected final boolean m13251d(Collection<?> collection) {
        return Multisets.c(this, collection);
    }

    protected final String m13254m() {
        return mo897a().toString();
    }
}
