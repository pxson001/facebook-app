package com.facebook.controllercallbacks.api;

import javax.annotation.Nullable;

/* compiled from: pages_identity_ufi */
public class Holder<T> {
    public T f10429a;

    public final void m15525a(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Set called with null data.");
        }
        this.f10429a = t;
    }

    @Nullable
    public final T m15526b() {
        return this.f10429a;
    }
}
