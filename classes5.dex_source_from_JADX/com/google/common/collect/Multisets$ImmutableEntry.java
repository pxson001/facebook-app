package com.google.common.collect;

import java.io.Serializable;
import javax.annotation.Nullable;

/* compiled from: cameraTargetLat */
class Multisets$ImmutableEntry<E> extends Multisets$AbstractEntry<E> implements Serializable {
    private final int count;
    @Nullable
    private final E element;

    Multisets$ImmutableEntry(@Nullable E e, int i) {
        this.element = e;
        this.count = i;
        CollectPreconditions.a(i, "count");
    }

    @Nullable
    public final E mo889a() {
        return this.element;
    }

    public final int mo890b() {
        return this.count;
    }

    public Multisets$ImmutableEntry<E> mo981c() {
        return null;
    }
}
