package com.facebook.inject.binder;

import javax.inject.Provider;

/* compiled from: write_attempts */
public interface LinkedBindingBuilder<T> extends ScopedBindingBuilder {
    ScopedBindingBuilder mo198a(Provider<? extends T> provider);

    void mo199a(T t);

    ScopedBindingBuilder mo200b(Class<? extends T> cls);
}
