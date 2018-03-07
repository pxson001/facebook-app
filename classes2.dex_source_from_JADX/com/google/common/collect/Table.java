package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: sum */
public interface Table<R, C, V> {
    V mo886a(@Nullable Object obj, @Nullable Object obj2);

    @Nullable
    V mo887a(R r, C c, V v);

    Map<C, V> mo890b(R r);

    Set<Cell<R, C, V>> mo894b();

    Map<R, Map<C, V>> mo892e();

    int mo893f();
}
