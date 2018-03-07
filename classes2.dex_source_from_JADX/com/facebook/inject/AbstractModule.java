package com.facebook.inject;

import com.facebook.inject.binder.AnnotatedBindingBuilder;
import com.facebook.inject.binder.LinkedBindingBuilder;
import com.facebook.inject.binder.LinkedComponentBindingBuilder;
import com.facebook.inject.binder.LinkedComponentBindingBuilderImpl;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Key;
import java.lang.annotation.Annotation;

/* compiled from: zero_kex */
public abstract class AbstractModule implements Module {
    public BinderImpl mBinder;

    protected abstract void configure();

    AbstractModule() {
    }

    protected BinderImpl getBinder() {
        return this.mBinder;
    }

    public final void configure(BinderImpl binderImpl) {
        this.mBinder = binderImpl;
        configure();
    }

    protected <T> AnnotatedBindingBuilder<T> bind(Class<T> cls) {
        return this.mBinder.m1344a((Class) cls);
    }

    protected <T> LinkedBindingBuilder<T> bind(Key<T> key) {
        return this.mBinder.m1345a((Key) key);
    }

    protected <T> AnnotatedBindingBuilder<T> bindDefault(Class<T> cls) {
        return this.mBinder.m1348b((Class) cls);
    }

    protected <T> LinkedBindingBuilder<T> bindDefault(Key<T> key) {
        return this.mBinder.m1349b((Key) key);
    }

    protected <T> LinkedComponentBindingBuilder<T> bindComponent(Class<T> cls) {
        BinderImpl binderImpl = this.mBinder;
        Key a = Key.m1365a((Class) cls);
        if (binderImpl.f656c == null) {
            binderImpl.f656c = Lists.m1296a();
        }
        ComponentBinding componentBinding = new ComponentBinding();
        componentBinding.a = binderImpl.f654a.getClass().getName();
        componentBinding.b = a;
        binderImpl.f656c.add(componentBinding);
        return new LinkedComponentBindingBuilderImpl(componentBinding);
    }

    protected <T> void bindAssistedProvider(Class<? extends AssistedProvider<T>> cls) {
        this.mBinder.m1355d((Class) cls);
    }

    protected <T> void declareMultiBinding(Class<T> cls) {
        this.mBinder.m1352c(Key.m1365a((Class) cls));
    }

    protected <T> void declareMultiBinding(Class<T> cls, Class<? extends Annotation> cls2) {
        this.mBinder.m1352c(Key.m1366a((Class) cls, (Class) cls2));
    }

    protected <T> void declareMultiBinding(Key<T> key) {
        this.mBinder.m1352c(key);
    }

    protected <T> MultiBinding<T> bindMulti(Class<T> cls) {
        return this.mBinder.m1358f((Class) cls);
    }

    protected <T> MultiBinding<T> bindMulti(Class<T> cls, Class<? extends Annotation> cls2) {
        return this.mBinder.m1347b(cls, cls2);
    }

    protected <T> MultiBinding<T> bindMulti(Key<T> key) {
        return this.mBinder.m1353d((Key) key);
    }

    protected <T> void assertBindingInstalled(Class<T> cls) {
        BinderImpl binderImpl = this.mBinder;
        if (binderImpl.f658e == null) {
            binderImpl.f658e = Sets.m1313a();
        }
        binderImpl.f658e.add(Key.m1365a((Class) cls));
    }

    protected <T> void assertBindingInstalled(Class<T> cls, Class<? extends Annotation> cls2) {
        this.mBinder.m1357e(Key.m1366a((Class) cls, (Class) cls2));
    }

    protected <T> void assertBindingInstalled(Key<T> key) {
        this.mBinder.m1357e(key);
    }

    protected void require(Class<? extends LibraryModule> cls) {
        this.mBinder.m1361h((Class) cls);
    }

    protected void bindScope(Class<? extends Annotation> cls, Scope scope) {
        BinderImpl binderImpl = this.mBinder;
        if (binderImpl.f662i == null) {
            binderImpl.f662i = Maps.m838c();
        }
        binderImpl.f662i.put(cls, scope);
    }
}
