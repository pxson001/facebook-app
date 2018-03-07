package com.facebook.inject;

import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: departure_label */
public final class Lazies {

    /* compiled from: departure_label */
    final class ProviderMemoizingLazy<T> implements Lazy<T> {
        @Nullable
        private Provider<T> f5131a;
        private T f5132b;

        public ProviderMemoizingLazy(Provider<T> provider) {
            this.f5131a = (Provider) Preconditions.checkNotNull(provider);
        }

        public final T get() {
            if (this.f5131a != null) {
                synchronized (this) {
                    if (this.f5131a != null) {
                        this.f5132b = this.f5131a.get();
                        this.f5131a = null;
                    }
                }
            }
            return this.f5132b;
        }
    }

    private Lazies() {
    }

    public static <T> Lazy<T> m10019a(Provider<T> provider) {
        if (provider instanceof Lazy) {
            return (Lazy) provider;
        }
        return new ProviderMemoizingLazy(provider);
    }
}
