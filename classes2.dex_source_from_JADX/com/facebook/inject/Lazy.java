package com.facebook.inject;

import javax.inject.Provider;

/* compiled from: zero_rating2/clearable/token */
public interface Lazy<T> extends Provider<T> {
    T get();
}
