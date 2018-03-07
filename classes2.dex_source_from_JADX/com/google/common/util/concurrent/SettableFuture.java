package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.AbstractFuture.TrustedFuture;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: whitelisted_callercontext */
public final class SettableFuture<V> extends TrustedFuture<V> {
    public static <V> SettableFuture<V> m1547f() {
        return new SettableFuture();
    }

    private SettableFuture() {
    }

    public final boolean mo221a(@Nullable V v) {
        return super.mo221a((Object) v);
    }

    public final boolean mo222a(Throwable th) {
        return super.mo222a(th);
    }

    @Beta
    public final boolean mo220a(ListenableFuture<? extends V> listenableFuture) {
        return super.mo220a((ListenableFuture) listenableFuture);
    }
}
