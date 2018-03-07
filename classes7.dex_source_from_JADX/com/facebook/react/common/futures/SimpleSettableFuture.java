package com.facebook.react.common.futures;

import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

/* compiled from: getDouble */
public class SimpleSettableFuture<T> implements Future<T> {
    private final CountDownLatch f11583a = new CountDownLatch(1);
    @Nullable
    private T f11584b;
    @Nullable
    private Exception f11585c;

    public final void m13617a(@Nullable T t) {
        m13614b();
        this.f11584b = t;
        this.f11583a.countDown();
    }

    public final void m13616a(Exception exception) {
        m13614b();
        this.f11585c = exception;
        this.f11583a.countDown();
    }

    public boolean cancel(boolean z) {
        throw new UnsupportedOperationException();
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return this.f11583a.getCount() == 0;
    }

    @Nullable
    public T get() {
        this.f11583a.await();
        if (this.f11585c == null) {
            return this.f11584b;
        }
        throw new ExecutionException(this.f11585c);
    }

    @Nullable
    public T get(long j, TimeUnit timeUnit) {
        if (!this.f11583a.await(j, timeUnit)) {
            throw new TimeoutException("Timed out waiting for result");
        } else if (this.f11585c == null) {
            return this.f11584b;
        } else {
            throw new ExecutionException(this.f11585c);
        }
    }

    @Nullable
    public final T m13615a() {
        Throwable e;
        try {
            return FutureDetour.a(this, 2140082028);
        } catch (InterruptedException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (ExecutionException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    private void m13614b() {
        if (this.f11583a.getCount() == 0) {
            throw new RuntimeException("Result has already been set!");
        }
    }
}
