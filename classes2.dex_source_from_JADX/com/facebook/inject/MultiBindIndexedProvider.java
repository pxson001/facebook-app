package com.facebook.inject;

/* compiled from: webpimage */
public interface MultiBindIndexedProvider<T> {
    T provide(Injector injector, int i);

    int size();
}
