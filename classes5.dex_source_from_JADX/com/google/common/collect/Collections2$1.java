package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Collection;

/* compiled from: calling close() on FakeSocketImpl */
public final class Collections2$1 implements Function<Object, Object> {
    final /* synthetic */ Collection f7293a;

    public Collections2$1(Collection collection) {
        this.f7293a = collection;
    }

    public final Object apply(Object obj) {
        return obj == this.f7293a ? "(this Collection)" : obj;
    }
}
