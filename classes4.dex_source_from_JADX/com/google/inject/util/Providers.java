package com.google.inject.util;

import javax.inject.Provider;

/* compiled from: mEnabled */
public final class Providers {

    /* compiled from: mEnabled */
    final class C04161 implements Provider<T> {
        final /* synthetic */ Object f8717a;

        C04161(Object obj) {
            this.f8717a = obj;
        }

        public final T get() {
            return this.f8717a;
        }

        public final String toString() {
            return "of(" + this.f8717a + ")";
        }
    }

    private Providers() {
    }

    public static <T> Provider<T> m9000a(T t) {
        return new C04161(t);
    }
}
