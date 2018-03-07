package com.google.common.cache;

/* compiled from: zero_feature_key_string */
public abstract class ForwardingLoadingCache<K, V> extends ForwardingCache<K, V> implements LoadingCache<K, V> {
    protected abstract LoadingCache<K, V> mo106f();

    protected /* synthetic */ Cache mo104d() {
        return mo106f();
    }

    protected /* synthetic */ Object mo105e() {
        return mo106f();
    }

    protected ForwardingLoadingCache() {
    }

    public V mo108c(K k) {
        return mo106f().mo108c(k);
    }

    public final V mo109d(K k) {
        return mo106f().mo109d(k);
    }

    public V apply(K k) {
        return mo106f().apply(k);
    }
}
