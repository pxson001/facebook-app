package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: password_account_counter_incremented */
public abstract class ImmutableMultimap<K, V> extends AbstractMultimap<K, V> implements Serializable {
    public final transient ImmutableMap<K, ? extends ImmutableCollection<V>> f10361b;
    final transient int f10362c;

    public abstract ImmutableCollection<V> m15439h(K k);

    public /* synthetic */ Collection mo427c(Object obj) {
        return m15439h(obj);
    }

    @Deprecated
    public /* synthetic */ Collection mo429d(Object obj) {
        return m15440i(obj);
    }

    public final /* synthetic */ Collection mo418i() {
        return m15453w();
    }

    final /* synthetic */ Iterator mo433j() {
        return m15454x();
    }

    public /* synthetic */ Collection mo419k() {
        return m15451u();
    }

    final /* synthetic */ Iterator mo434l() {
        return m15452v();
    }

    public final /* synthetic */ Set mo421p() {
        return m15434e();
    }

    public static <K, V> Builder<K, V> m15425c() {
        return new Builder();
    }

    ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i) {
        this.f10361b = immutableMap;
        this.f10362c = i;
    }

    @Deprecated
    public ImmutableCollection<V> m15440i(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void mo415g() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean mo431a(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean mo409a(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean mo408a(Multimap<? extends K, ? extends V> multimap) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean mo412c(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public final boolean m15433d() {
        return this.f10361b.isPartialView();
    }

    public final boolean mo414f(@Nullable Object obj) {
        return this.f10361b.containsKey(obj);
    }

    public final boolean mo416g(@Nullable Object obj) {
        return obj != null && super.mo416g(obj);
    }

    public final int mo413f() {
        return this.f10362c;
    }

    public final ImmutableSet<K> m15434e() {
        return this.f10361b.keySet();
    }

    public final /* synthetic */ Map mo426b() {
        return this.f10361b;
    }

    final Map<K, Collection<V>> mo435m() {
        throw new AssertionError("should never be called");
    }

    public ImmutableCollection<Entry<K, V>> m15451u() {
        return (ImmutableCollection) super.mo419k();
    }

    final Collection mo1992o() {
        return new EntryCollection(this);
    }

    final UnmodifiableIterator<Entry<K, V>> m15452v() {
        return new 1(this);
    }

    public final Multiset mo422q() {
        return (ImmutableMultiset) super.mo422q();
    }

    final Multiset mo1993r() {
        return new Keys(this);
    }

    public final ImmutableCollection<V> m15453w() {
        return (ImmutableCollection) super.mo418i();
    }

    final Collection mo1994s() {
        return new Values(this);
    }

    final UnmodifiableIterator<V> m15454x() {
        return new 2(this);
    }
}
