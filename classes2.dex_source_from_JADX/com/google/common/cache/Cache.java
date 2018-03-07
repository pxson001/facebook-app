package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: zero_data_state_change_event */
public interface Cache<K, V> {
    @Nullable
    V mo110a(Object obj);

    V mo111a(K k, Callable<? extends V> callable);

    void mo112a();

    void mo113a(Iterable<?> iterable);

    void mo114a(K k, V v);

    ConcurrentMap<K, V> mo115b();

    void mo116b(Object obj);

    void mo117c();
}
