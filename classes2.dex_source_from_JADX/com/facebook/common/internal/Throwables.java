package com.facebook.common.internal;

import javax.annotation.Nullable;

/* compiled from: whistle_android */
public final class Throwables {
    private Throwables() {
    }

    private static <X extends Throwable> void m15699a(@Nullable Throwable th, Class<X> cls) {
        if (th != null && cls.isInstance(th)) {
            throw ((Throwable) cls.cast(th));
        }
    }

    public static void m15698a(@Nullable Throwable th) {
        m15699a(th, Error.class);
        m15699a(th, RuntimeException.class);
    }

    public static RuntimeException m15700b(Throwable th) {
        m15698a((Throwable) Preconditions.a(th));
        throw new RuntimeException(th);
    }
}
