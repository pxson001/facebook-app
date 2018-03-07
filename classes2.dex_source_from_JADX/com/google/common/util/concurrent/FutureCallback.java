package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: waiting_for_new_connection */
public interface FutureCallback<V> {
    void onFailure(Throwable th);

    void onSuccess(@Nullable V v);
}
