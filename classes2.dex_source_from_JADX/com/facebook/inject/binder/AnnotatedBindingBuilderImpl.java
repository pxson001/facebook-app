package com.facebook.inject.binder;

import com.facebook.inject.Binding;

/* compiled from: writes guarded by mLock */
public class AnnotatedBindingBuilderImpl<T> extends LinkedBindingBuilderImpl<T> implements AnnotatedBindingBuilder<T> {
    public AnnotatedBindingBuilderImpl(Binding<T> binding) {
        super(binding);
    }
}
