package com.google.common.cache;

import java.io.ObjectInputStream;
import java.io.Serializable;

/* compiled from: campaign_title */
final class LocalCache$LoadingSerializationProxy<K, V> extends LocalCache$ManualSerializationProxy<K, V> implements LoadingCache<K, V>, Serializable {
    transient LoadingCache<K, V> f7201a;

    LocalCache$LoadingSerializationProxy(LocalCache<K, V> localCache) {
        super(localCache);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f7201a = m13157f().a(this.loader);
    }

    public final V m13158c(K k) {
        return this.f7201a.c(k);
    }

    public final V m13159d(K k) {
        return this.f7201a.d(k);
    }

    public final V apply(K k) {
        return this.f7201a.apply(k);
    }

    private Object readResolve() {
        return this.f7201a;
    }
}
