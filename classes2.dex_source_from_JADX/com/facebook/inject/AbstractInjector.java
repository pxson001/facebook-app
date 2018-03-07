package com.facebook.inject;

import com.google.inject.Key;
import java.lang.annotation.Annotation;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: zero */
public abstract class AbstractInjector extends FbInjector {
    protected abstract <T> void mo160a(Class<T> cls, T t);

    public abstract <T> T getInstance(Key<T> key);

    public abstract <T> Lazy<T> getLazy(Key<T> key);

    public abstract <T> Provider<T> getProvider(Key<T> key);

    public <T> T getInstance(Class<T> cls) {
        return getInstance(Key.m1365a((Class) cls));
    }

    public <T> T getInstance(Class<T> cls, Class<? extends Annotation> cls2) {
        return getInstance(Key.m1366a((Class) cls, (Class) cls2));
    }

    public <T> Provider<T> getProvider(Class<T> cls) {
        return getProvider(Key.m1365a((Class) cls));
    }

    public <T> Provider<T> getProvider(Class<T> cls, Class<? extends Annotation> cls2) {
        return getProvider(Key.m1366a((Class) cls, (Class) cls2));
    }

    public <T> Lazy<T> getLazy(Class<T> cls) {
        return getLazy(Key.m1365a((Class) cls));
    }

    public <T> Lazy<T> getLazy(Class<T> cls, Class<? extends Annotation> cls2) {
        return getLazy(Key.m1366a((Class) cls, (Class) cls2));
    }

    public <T> Set<T> getSet(Class<T> cls) {
        return (Set) getInstance(FbInjector.m1078a((Class) cls, null));
    }

    public <T> Set<T> getSet(Class<T> cls, Class<? extends Annotation> cls2) {
        return (Set) getInstance(FbInjector.m1078a((Class) cls, (Class) cls2));
    }

    public <T> Set<T> getSet(Key<T> key) {
        return (Set) getInstance(FbInjector.m1084b((Key) key));
    }

    public <T> Provider<Set<T>> getSetProvider(Class<T> cls) {
        return getProvider(FbInjector.m1078a((Class) cls, null));
    }

    public <T> Provider<Set<T>> getSetProvider(Class<T> cls, Class<? extends Annotation> cls2) {
        return getProvider(FbInjector.m1078a((Class) cls, (Class) cls2));
    }

    public <T> Provider<Set<T>> getSetProvider(Key<T> key) {
        return getProvider(FbInjector.m1084b((Key) key));
    }

    public <T> Lazy<Set<T>> getLazySet(Class<T> cls) {
        return getLazy(FbInjector.m1078a((Class) cls, null));
    }

    public <T> Lazy<Set<T>> getLazySet(Class<T> cls, Class<? extends Annotation> cls2) {
        return getLazy(FbInjector.m1078a((Class) cls, (Class) cls2));
    }

    public <T> Lazy<Set<T>> getLazySet(Key<T> key) {
        return getLazy(FbInjector.m1084b((Key) key));
    }

    public <T> boolean hasBinding(Class<T> cls, Class<? extends Annotation> cls2) {
        return mo161a(Key.m1366a((Class) cls, (Class) cls2));
    }

    public FbInjector getModuleInjector(Class<? extends Module> cls) {
        return this;
    }
}
