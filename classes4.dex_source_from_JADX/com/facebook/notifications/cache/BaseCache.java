package com.facebook.notifications.cache;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: mms */
public abstract class BaseCache<K, V> {
    @Nullable
    private final Comparator<V> f7622a;
    @GuardedBy("this")
    private final Map<K, V> f7623b = Maps.c();

    protected abstract K mo618a(V v);

    public BaseCache(@Nullable Comparator<V> comparator) {
        this.f7622a = comparator;
    }

    public final void m7954b(@Nonnull V v) {
        Preconditions.checkNotNull(v, "Can't add null value to the cache!");
        Object a = mo618a((Object) v);
        Preconditions.checkState(a != null);
        synchronized (this) {
            this.f7623b.put(a, v);
        }
        mo619e();
    }

    public final void m7951a(@Nonnull Iterable<V> iterable) {
        Preconditions.checkNotNull(iterable);
        Map c = Maps.c();
        for (Object next : iterable) {
            c.put(mo618a(next), next);
        }
        synchronized (this) {
            this.f7623b.putAll(c);
        }
        mo619e();
    }

    public final void m7956c(K k) {
        Preconditions.checkNotNull(k);
        synchronized (this) {
            Object remove = this.f7623b.remove(k);
        }
        if (remove != null) {
            mo619e();
        }
    }

    @Nullable
    public final V m7957d(@Nonnull K k) {
        V v;
        Preconditions.checkNotNull(k, "Can't query cache with null key");
        synchronized (this) {
            v = this.f7623b.get(k);
        }
        return v;
    }

    public final Collection<V> m7950a() {
        ImmutableList copyOf;
        synchronized (this) {
            copyOf = ImmutableList.copyOf(this.f7623b.values());
        }
        return copyOf;
    }

    public final Collection<V> m7953b() {
        Preconditions.checkNotNull(this.f7622a, "Must be constructed with non-null Comparator to use this function");
        Collection a = Lists.a();
        synchronized (this) {
            a.addAll(this.f7623b.values());
        }
        Collections.sort(a, this.f7622a);
        return ImmutableList.copyOf(a);
    }

    public final void m7952a(@Nonnull Collection<K> collection) {
        Preconditions.checkNotNull(collection, "Can't retain null collection");
        synchronized (this) {
            this.f7623b.keySet().retainAll(collection);
        }
        mo619e();
    }

    public final synchronized int m7955c() {
        return this.f7623b.size();
    }

    public final void m7958d() {
        synchronized (this) {
            this.f7623b.clear();
        }
        mo619e();
    }

    protected void mo619e() {
    }
}
