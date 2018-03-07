package com.facebook.common.executors;

import android.os.Handler;
import android.os.Looper;
import com.google.common.util.concurrent.ForwardingFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: profile_picture_size */
abstract class HandlerDeadlockAwareForwardingFuture<V> extends ForwardingFuture<V> {
    private final Handler f8825a;

    public HandlerDeadlockAwareForwardingFuture(Handler handler) {
        this.f8825a = handler;
    }

    private boolean m13659b() {
        return Looper.myLooper() == this.f8825a.getLooper();
    }

    private void m13660c() {
        if (!isDone()) {
            throw new IllegalStateException("Must not call get() function from this Handler thread. Will deadlock!");
        }
    }

    public V get() {
        if (m13659b()) {
            m13660c();
        }
        return super.get();
    }

    public V get(long j, TimeUnit timeUnit) {
        if (m13659b()) {
            m13660c();
        }
        return super.get(j, timeUnit);
    }
}
