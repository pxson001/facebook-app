package com.facebook.common.init;

import com.facebook.inject.InjectorLike;

/* compiled from: souvenir_media_type */
public final class EmptyINeedInitIterator implements INeedInitIterator {
    public static EmptyINeedInitIterator m3737a(InjectorLike injectorLike) {
        return new EmptyINeedInitIterator();
    }

    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        return null;
    }

    public final void remove() {
        throw new IllegalStateException();
    }
}
