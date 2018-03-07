package com.facebook.ui.media.cache;

import com.google.common.base.Preconditions;
import javax.inject.Provider;

/* compiled from: offline_mode_operation_retried */
public class MemoizedProvider<T> implements Provider<T> {
    private Provider<T> f11390a;
    private T f11391b;

    public MemoizedProvider(Provider<T> provider) {
        this.f11390a = (Provider) Preconditions.checkNotNull(provider);
    }

    public synchronized T get() {
        if (this.f11390a != null) {
            this.f11391b = this.f11390a.get();
            this.f11390a = null;
        }
        return this.f11391b;
    }
}
