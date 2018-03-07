package com.facebook.inject;

import com.google.inject.Key;
import javax.inject.Provider;

/* compiled from: wirehog_profiling */
public class RedirectProvider<T> extends AbstractProvider<T> {
    private final Key<? extends T> f722a;
    private volatile Provider<? extends T> f723b;

    public RedirectProvider(Key<? extends T> key) {
        this.f722a = key;
    }

    public T get() {
        if (this.f723b == null) {
            this.f723b = getScopeUnawareInjector().getProvider(this.f722a);
        }
        return this.f723b.get();
    }
}
