package com.facebook.inject.binder;

import com.facebook.inject.Binding;
import com.facebook.inject.InstanceProvider;
import com.facebook.inject.RedirectProvider;
import com.google.inject.Key;
import javax.inject.Provider;

/* compiled from: write_throwable */
public class LinkedBindingBuilderImpl<T> extends ScopedBindingBuilderImpl<T> implements LinkedBindingBuilder<T> {
    public LinkedBindingBuilderImpl(Binding<T> binding) {
        super(binding);
    }

    public final ScopedBindingBuilder mo200b(Class<? extends T> cls) {
        this.f676a.f672c = new RedirectProvider(Key.m1365a((Class) cls));
        return this;
    }

    public final void mo199a(T t) {
        this.f676a.f672c = new InstanceProvider(t);
    }

    public final ScopedBindingBuilder mo198a(Provider<? extends T> provider) {
        this.f676a.f672c = provider;
        return this;
    }
}
