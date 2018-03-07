package com.google.common.util.concurrent;

import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.collect.ForwardingObject;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: profile_picture_is_silhouette */
public abstract class ForwardingFuture<V> extends ForwardingObject implements Future<V> {
    protected abstract Future<V> mo1830a();

    protected /* synthetic */ Object mo105e() {
        return mo1830a();
    }

    protected ForwardingFuture() {
    }

    public boolean cancel(boolean z) {
        return mo1830a().cancel(z);
    }

    public boolean isCancelled() {
        return mo1830a().isCancelled();
    }

    public boolean isDone() {
        return mo1830a().isDone();
    }

    public V get() {
        return FutureDetour.a(mo1830a(), 1913750589);
    }

    public V get(long j, TimeUnit timeUnit) {
        return FutureDetour.a(mo1830a(), j, timeUnit, -468286773);
    }
}
