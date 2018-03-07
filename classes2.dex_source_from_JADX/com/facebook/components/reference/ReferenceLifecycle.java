package com.facebook.components.reference;

import android.support.v4.util.Pools$SynchronizedPool;
import com.facebook.components.ComponentContext;
import com.facebook.components.Diff;

/* compiled from: idx.type = ' */
public abstract class ReferenceLifecycle<T> {
    private static final Pools$SynchronizedPool<Diff<?>> f20583a = new Pools$SynchronizedPool(20);

    protected abstract T mo3151a(ComponentContext componentContext, Reference<T> reference);

    protected void mo3365a(ComponentContext componentContext, T t, Reference<T> reference) {
    }
}
