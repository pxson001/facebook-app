package com.facebook.stetho.common;

/* compiled from: serialized_media_item */
public class ExceptionUtil {
    public static <T extends Throwable> void m7711a(Throwable th, Class<T> cls) {
        if (cls.isInstance(th)) {
            throw th;
        }
    }

    public static RuntimeException m7710a(Throwable th) {
        m7711a(th, Error.class);
        m7711a(th, RuntimeException.class);
        throw new RuntimeException(th);
    }
}
