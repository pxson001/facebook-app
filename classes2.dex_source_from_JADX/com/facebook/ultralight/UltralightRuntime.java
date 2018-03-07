package com.facebook.ultralight;

import com.facebook.inject.Lazy;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: zero_rating2/clearable/ttl */
public abstract class UltralightRuntime {
    public static final Provider<Object> f367a = new C00091();
    public static final Lazy<Object> f368b = new C00102();

    /* compiled from: zero_rating2/clearable/ttl */
    final class C00091 implements Provider<Object> {
        C00091() {
        }

        public final Object get() {
            return UltralightRuntime.m731d();
        }
    }

    /* compiled from: zero_rating2/clearable/ttl */
    final class C00102 implements Lazy<Object> {
        C00102() {
        }

        @Nullable
        public final Object get() {
            return null;
        }
    }

    public static <T> Provider<T> m729a() {
        return f367a;
    }

    public static <T> Lazy<T> m730b() {
        return f368b;
    }

    public static <T> T m731d() {
        throw new LocalInjectionBeforeInstanceInjectionException("A local injection was attempted before the constructor completed or before injectMe was called.");
    }
}
