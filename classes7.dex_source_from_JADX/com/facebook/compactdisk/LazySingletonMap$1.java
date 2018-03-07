package com.facebook.compactdisk;

import java.util.concurrent.Callable;

/* compiled from: tue */
class LazySingletonMap$1 implements Callable<V> {
    final /* synthetic */ Object f1196a;
    final /* synthetic */ LazySingletonMap f1197b;

    LazySingletonMap$1(LazySingletonMap lazySingletonMap, Object obj) {
        this.f1197b = lazySingletonMap;
        this.f1196a = obj;
    }

    public V call() {
        return this.f1197b.a.a(this.f1196a);
    }
}
