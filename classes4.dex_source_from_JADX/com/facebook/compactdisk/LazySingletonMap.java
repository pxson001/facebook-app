package com.facebook.compactdisk;

/* compiled from: max_pages_to_fetch */
public class LazySingletonMap<K, V> {
    public Factory<K, V> f8186a;
    private CallableLazySingletonMap<K, V> f8187b = new CallableLazySingletonMap();

    /* compiled from: max_pages_to_fetch */
    public interface Factory<K, V> {
        V mo670a(K k);
    }

    public LazySingletonMap(Factory<K, V> factory) {
        this.f8186a = factory;
    }

    public final synchronized void m8486a() {
        this.f8187b.m8490a();
    }

    public final V m8485a(K k) {
        return this.f8187b.m8489a(k, new 1(this, k));
    }
}
