package com.facebook.inject.binder;

import com.facebook.inject.Binding;
import java.lang.annotation.Annotation;

/* compiled from: write_exceptions */
public class ScopedBindingBuilderImpl<T> implements ScopedBindingBuilder {
    public final Binding<T> f676a;

    public ScopedBindingBuilderImpl(Binding<T> binding) {
        this.f676a = binding;
    }

    public final void mo201c(Class<? extends Annotation> cls) {
        this.f676a.f673d = cls;
    }
}
