package com.facebook.inject;

import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: video_spec_display */
public class AbstractAssistedProvider<T> implements AssistedProviderWithInjector<T> {
    public InjectorLike f1098a;

    public <S> S getInstance(Class<S> cls) {
        return this.f1098a.getInstance((Class) cls);
    }

    public <S> S getInstance(Class<S> cls, Class<? extends Annotation> cls2) {
        return this.f1098a.getInstance(cls, cls2);
    }

    public <S> S getInstance(Key<S> key) {
        return this.f1098a.getInstance((Key) key);
    }

    public <S> Provider<S> getProvider(Class<S> cls) {
        return m2221a().getProvider((Class) cls);
    }

    public <S> Provider<S> getProvider(Class<S> cls, Class<? extends Annotation> cls2) {
        return m2221a().getProvider(cls, cls2);
    }

    public <S> Provider<S> getProvider(Key<S> key) {
        return m2221a().getProvider((Key) key);
    }

    public <S> Lazy<S> getLazy(Class<S> cls) {
        return this.f1098a.getLazy((Class) cls);
    }

    public <S> Lazy<S> getLazy(Class<S> cls, Class<? extends Annotation> cls2) {
        return this.f1098a.getLazy(cls, cls2);
    }

    public <S> Lazy<S> getLazy(Key<S> key) {
        return this.f1098a.getLazy((Key) key);
    }

    public <S> Set<S> getSet(Class<S> cls) {
        return this.f1098a.getSet((Class) cls);
    }

    public <S> Set<S> getSet(Class<S> cls, Class<? extends Annotation> cls2) {
        return this.f1098a.getSet(cls, cls2);
    }

    public <T> Set<T> getSet(Key<T> key) {
        return this.f1098a.getSet((Key) key);
    }

    public <S> Provider<Set<S>> getSetProvider(Class<S> cls) {
        return m2221a().getSetProvider((Class) cls);
    }

    public <S> Provider<Set<S>> getSetProvider(Class<S> cls, Class<? extends Annotation> cls2) {
        return m2221a().getSetProvider(cls, cls2);
    }

    public <T> Provider<Set<T>> getSetProvider(Key<T> key) {
        return m2221a().getSetProvider((Key) key);
    }

    public <S> Lazy<Set<S>> getLazySet(Class<S> cls) {
        return this.f1098a.getLazySet((Class) cls);
    }

    public <S> Lazy<Set<S>> getLazySet(Class<S> cls, Class<? extends Annotation> cls2) {
        return this.f1098a.getLazySet(cls, cls2);
    }

    public <T> Lazy<Set<T>> getLazySet(Key<T> key) {
        return this.f1098a.getLazySet((Key) key);
    }

    public <S> boolean hasBinding(Class<S> cls, Class<? extends Annotation> cls2) {
        return this.f1098a.hasBinding(cls, cls2);
    }

    @Deprecated
    public ScopeUnawareInjector getScopeUnawareInjector() {
        return this.f1098a.getScopeUnawareInjector();
    }

    @Deprecated
    public ScopeAwareInjector getScopeAwareInjector() {
        return this.f1098a.getScopeAwareInjector();
    }

    @Deprecated
    public InjectorThreadStack getInjectorThreadStack() {
        return this.f1098a.getInjectorThreadStack();
    }

    public Map<Class<? extends Module>, Binder> getBinders() {
        return this.f1098a.getBinders();
    }

    public FbInjector getApplicationInjector() {
        return this.f1098a.getApplicationInjector();
    }

    public FbInjector getModuleInjector(Class<? extends Module> cls) {
        return this.f1098a.getModuleInjector(cls);
    }

    public int getProcessIdentifier() {
        return this.f1098a.getProcessIdentifier();
    }

    public <T> AssistedProvider<T> getOnDemandAssistedProviderForStaticDi(Class<? extends AssistedProvider<T>> cls) {
        return this.f1098a.getOnDemandAssistedProviderForStaticDi(cls);
    }

    @VisibleForTesting
    private Injector m2221a() {
        return this.f1098a.getScopeAwareInjector();
    }
}
