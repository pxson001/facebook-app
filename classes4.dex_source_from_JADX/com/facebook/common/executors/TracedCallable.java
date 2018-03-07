package com.facebook.common.executors;

import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.debug.log.LogPrefixer;
import com.facebook.debug.tracer.Tracer;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

/* compiled from: ended */
public class TracedCallable<V> implements ProvidesName, Callable<V> {
    private final Callable<V> f12994a;
    private final Class<?> f12995b;
    private final MonotonicClock f12996c;
    private final long f12997d;
    private long f12998e = -1;
    @Nullable
    public String f12999f;

    public static <T> TracedCallable<T> m13858a(Callable<T> callable, Class<?> cls, MonotonicClock monotonicClock) {
        return new TracedCallable(callable, cls, monotonicClock);
    }

    public final String m13860a() {
        if (this.f12994a instanceof ProvidesName) {
            return ((ProvidesName) this.f12994a).a();
        }
        return this.f12995b.getSimpleName();
    }

    @VisibleForTesting
    private TracedCallable(Callable<V> callable, Class<?> cls, MonotonicClock monotonicClock) {
        this.f12994a = (Callable) Preconditions.checkNotNull(callable);
        this.f12995b = (Class) Preconditions.checkNotNull(cls);
        this.f12996c = (MonotonicClock) Preconditions.checkNotNull(monotonicClock);
        this.f12997d = monotonicClock.now();
    }

    private long m13859b() {
        Preconditions.checkState(this.f12998e >= 0, "Job has not been run yet");
        return this.f12998e - this.f12997d;
    }

    public V call() {
        this.f12998e = this.f12996c.now();
        long b = m13859b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f12995b.getSimpleName());
        if (this.f12999f != null) {
            stringBuilder.append(' ').append(this.f12999f);
        }
        TracerDetour.a(stringBuilder.toString(), 1177737024);
        try {
            Tracer.d("queuedTime: %d ms", new Object[]{Long.valueOf(b)});
            V call = this.f12994a.call();
            return call;
        } finally {
            TracerDetour.a(-191181606);
            if (BLog.b(3)) {
                Tracer.c(LogPrefixer.a(this.f12995b));
            }
        }
    }
}
