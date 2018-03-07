package com.facebook.inject;

import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: writeFixedData */
public abstract class AbstractProvider<T> implements InjectorLike, ProviderWithInjector<T> {
    public InjectorLike mInjector;

    public <S> Provider<S> getProvider(Class<S> cls) {
        return getScopeAwareInjectorInternal().getProvider((Class) cls);
    }

    public <S> Provider<S> getProvider(Class<S> cls, Class<? extends Annotation> cls2) {
        return getScopeAwareInjectorInternal().getProvider(cls, cls2);
    }

    public <S> Provider<S> getProvider(Key<S> key) {
        return getScopeAwareInjectorInternal().getProvider((Key) key);
    }

    public <S> Lazy<S> getLazy(Class<S> cls) {
        return this.mInjector.getLazy((Class) cls);
    }

    public <S> Lazy<S> getLazy(Class<S> cls, Class<? extends Annotation> cls2) {
        return this.mInjector.getLazy(cls, cls2);
    }

    public <S> Lazy<S> getLazy(Key<S> key) {
        return this.mInjector.getLazy((Key) key);
    }

    public <S> S getInstance(Class<S> cls) {
        return this.mInjector.getInstance((Class) cls);
    }

    public <S> S getInstance(Class<S> cls, Class<? extends Annotation> cls2) {
        return this.mInjector.getInstance(cls, cls2);
    }

    public <S> S getInstance(Key<S> key) {
        return this.mInjector.getInstance((Key) key);
    }

    public <S> Set<S> getSet(Class<S> cls) {
        return this.mInjector.getSet((Class) cls);
    }

    public <S> Set<S> getSet(Class<S> cls, Class<? extends Annotation> cls2) {
        return this.mInjector.getSet(cls, cls2);
    }

    public <T> Set<T> getSet(Key<T> key) {
        return this.mInjector.getSet((Key) key);
    }

    public <S> Provider<Set<S>> getSetProvider(Class<S> cls) {
        return getScopeAwareInjectorInternal().getSetProvider((Class) cls);
    }

    public <S> Provider<Set<S>> getSetProvider(Class<S> cls, Class<? extends Annotation> cls2) {
        return getScopeAwareInjectorInternal().getSetProvider(cls, cls2);
    }

    public <T> Provider<Set<T>> getSetProvider(Key<T> key) {
        return getScopeAwareInjectorInternal().getSetProvider((Key) key);
    }

    public <S> Lazy<Set<S>> getLazySet(Class<S> cls) {
        return this.mInjector.getLazySet((Class) cls);
    }

    public <S> Lazy<Set<S>> getLazySet(Class<S> cls, Class<? extends Annotation> cls2) {
        return this.mInjector.getLazySet(cls, cls2);
    }

    public <T> Lazy<Set<T>> getLazySet(Key<T> key) {
        return this.mInjector.getLazySet((Key) key);
    }

    public <T> boolean hasBinding(Class<T> cls, Class<? extends Annotation> cls2) {
        return this.mInjector.hasBinding(cls, cls2);
    }

    @Deprecated
    public ScopeUnawareInjector getScopeUnawareInjector() {
        return this.mInjector.getScopeUnawareInjector();
    }

    @Deprecated
    public ScopeAwareInjector getScopeAwareInjector() {
        return this.mInjector.getScopeAwareInjector();
    }

    @Deprecated
    public InjectorThreadStack getInjectorThreadStack() {
        return this.mInjector.getInjectorThreadStack();
    }

    public Map<Class<? extends Module>, Binder> getBinders() {
        return this.mInjector.getBinders();
    }

    public FbInjector getApplicationInjector() {
        return this.mInjector.getApplicationInjector();
    }

    public FbInjector getModuleInjector(Class<? extends Module> cls) {
        return this.mInjector.getModuleInjector(cls);
    }

    public int getProcessIdentifier() {
        return this.mInjector.getProcessIdentifier();
    }

    public <T> AssistedProvider<T> getOnDemandAssistedProviderForStaticDi(Class<? extends AssistedProvider<T>> cls) {
        return this.mInjector.getOnDemandAssistedProviderForStaticDi(cls);
    }

    @VisibleForTesting
    protected Injector getScopeAwareInjectorInternal() {
        return this.mInjector.getScopeAwareInjector();
    }
}
