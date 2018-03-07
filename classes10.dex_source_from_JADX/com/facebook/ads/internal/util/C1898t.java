package com.facebook.ads.internal.util;

import java.lang.ref.WeakReference;

public abstract class C1898t<T> implements Runnable {
    private final WeakReference<T> f13991a;

    public C1898t(T t) {
        this.f13991a = new WeakReference(t);
    }

    public final T m14235a() {
        return this.f13991a.get();
    }
}
