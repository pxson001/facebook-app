package com.facebook.inject;

import com.google.inject.Key;
import java.lang.annotation.Annotation;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: zero_header_send_state */
public interface Injector {
    @Deprecated
    <T> T getInstance(Key<T> key);

    @Deprecated
    <T> T getInstance(Class<T> cls);

    @Deprecated
    <T> T getInstance(Class<T> cls, Class<? extends Annotation> cls2);

    @Deprecated
    <T> Lazy<T> getLazy(Key<T> key);

    @Deprecated
    <T> Lazy<T> getLazy(Class<T> cls);

    @Deprecated
    <T> Lazy<T> getLazy(Class<T> cls, Class<? extends Annotation> cls2);

    @Deprecated
    <T> Lazy<Set<T>> getLazySet(Key<T> key);

    @Deprecated
    <T> Lazy<Set<T>> getLazySet(Class<T> cls);

    @Deprecated
    <T> Lazy<Set<T>> getLazySet(Class<T> cls, Class<? extends Annotation> cls2);

    @Deprecated
    <T> Provider<T> getProvider(Key<T> key);

    @Deprecated
    <T> Provider<T> getProvider(Class<T> cls);

    @Deprecated
    <T> Provider<T> getProvider(Class<T> cls, Class<? extends Annotation> cls2);

    @Deprecated
    <T> Set<T> getSet(Key<T> key);

    @Deprecated
    <T> Set<T> getSet(Class<T> cls);

    @Deprecated
    <T> Set<T> getSet(Class<T> cls, Class<? extends Annotation> cls2);

    @Deprecated
    <T> Provider<Set<T>> getSetProvider(Key<T> key);

    @Deprecated
    <T> Provider<Set<T>> getSetProvider(Class<T> cls);

    @Deprecated
    <T> Provider<Set<T>> getSetProvider(Class<T> cls, Class<? extends Annotation> cls2);

    @Deprecated
    <T> boolean hasBinding(Class<T> cls, Class<? extends Annotation> cls2);
}
