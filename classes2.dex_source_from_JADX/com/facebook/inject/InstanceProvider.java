package com.facebook.inject;

import javax.inject.Provider;

/* compiled from: writeToDisk */
public class InstanceProvider<T> implements Provider<T> {
    private final T f677a;

    public InstanceProvider(T t) {
        this.f677a = t;
    }

    public T get() {
        return this.f677a;
    }
}
