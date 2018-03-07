package com.google.common.cache;

import com.google.common.collect.ForwardingObject;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* compiled from: zero_dialog */
public abstract class ForwardingCache<K, V> extends ForwardingObject implements Cache<K, V> {
    protected abstract Cache<K, V> mo104d();

    protected /* synthetic */ Object mo105e() {
        return mo104d();
    }

    protected ForwardingCache() {
    }

    @Nullable
    public final V mo110a(Object obj) {
        return mo104d().mo110a(obj);
    }

    public final V mo111a(K k, Callable<? extends V> callable) {
        return mo104d().mo111a((Object) k, (Callable) callable);
    }

    public final void mo114a(K k, V v) {
        mo104d().mo114a((Object) k, (Object) v);
    }

    public final void mo116b(Object obj) {
        mo104d().mo116b(obj);
    }

    public final void mo113a(Iterable<?> iterable) {
        mo104d().mo113a((Iterable) iterable);
    }

    public final void mo112a() {
        mo104d().mo112a();
    }

    public final ConcurrentMap<K, V> mo115b() {
        return mo104d().mo115b();
    }

    public final void mo117c() {
        mo104d().mo117c();
    }
}
