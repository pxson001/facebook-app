package com.google.common.util.concurrent;

import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@GwtCompatible
@Beta
/* compiled from: weinre */
public final class Uninterruptibles {
    @GwtIncompatible("concurrency")
    public static void m1586a(CountDownLatch countDownLatch) {
        Object obj = null;
        while (true) {
            try {
                countDownLatch.await();
                break;
            } catch (InterruptedException e) {
                obj = 1;
            } catch (Throwable th) {
                if (obj != null) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        if (obj != null) {
            Thread.currentThread().interrupt();
        }
    }

    @GwtIncompatible("concurrency")
    public static boolean m1587a(CountDownLatch countDownLatch, long j, TimeUnit timeUnit) {
        Object obj = null;
        try {
            boolean await;
            long toNanos = timeUnit.toNanos(j);
            long nanoTime = System.nanoTime() + toNanos;
            while (true) {
                try {
                    await = countDownLatch.await(toNanos, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException e) {
                    obj = 1;
                    toNanos = nanoTime - System.nanoTime();
                }
            }
            return await;
        } finally {
            if (obj != null) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static <V> V m1584a(Future<V> future) {
        V a;
        Object obj = null;
        while (true) {
            try {
                a = FutureDetour.a(future, -446198905);
                break;
            } catch (InterruptedException e) {
                obj = 1;
            } catch (Throwable th) {
                if (obj != null) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        if (obj != null) {
            Thread.currentThread().interrupt();
        }
        return a;
    }

    @GwtIncompatible("TODO")
    public static <V> V m1585a(Future<V> future, long j, TimeUnit timeUnit) {
        Object obj = null;
        try {
            V a;
            long toNanos = timeUnit.toNanos(j);
            long nanoTime = System.nanoTime() + toNanos;
            while (true) {
                try {
                    a = FutureDetour.a(future, toNanos, TimeUnit.NANOSECONDS, -1727890501);
                    break;
                } catch (InterruptedException e) {
                    obj = 1;
                    toNanos = nanoTime - System.nanoTime();
                }
            }
            return a;
        } finally {
            if (obj != null) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private Uninterruptibles() {
    }
}
