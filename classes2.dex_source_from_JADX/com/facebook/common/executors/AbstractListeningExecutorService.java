package com.facebook.common.executors;

import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

/* compiled from: wantFirstFrameForThumbnail */
public abstract class AbstractListeningExecutorService implements ListeningExecutorService {
    static final /* synthetic */ boolean f958a = (!AbstractListeningExecutorService.class.desiredAssertionStatus());

    public /* synthetic */ Future submit(Runnable runnable) {
        return mo269a(runnable);
    }

    public /* synthetic */ Future submit(Runnable runnable, @Nullable Object obj) {
        return mo270a(runnable, obj);
    }

    public /* synthetic */ Future submit(Callable callable) {
        return mo271a(callable);
    }

    public final ListenableFuture<?> mo269a(Runnable runnable) {
        return mo270a(runnable, null);
    }

    public final <T> ListenableFuture<T> mo270a(Runnable runnable, @Nullable T t) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        Object b = mo302b(runnable, t);
        ExecutorDetour.a(this, b, -710947987);
        return b;
    }

    public final <T> ListenableFuture<T> mo271a(Callable<T> callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        Object b = mo303b(callable);
        ExecutorDetour.a(this, b, -1482167449);
        return b;
    }

    protected <T> ListenableFutureTask<T> mo302b(Runnable runnable, @Nullable T t) {
        return ListenableFutureTask.m2436a(runnable, (Object) t);
    }

    protected <T> ListenableFutureTask<T> mo303b(Callable<T> callable) {
        return ListenableFutureTask.m2437a(callable);
    }

    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        try {
            return m1928a(collection, false, 0);
        } catch (TimeoutException e) {
            if (f958a) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return m1928a(collection, true, timeUnit.toNanos(j));
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        List<Future<T>> arrayList = new ArrayList(collection.size());
        try {
            for (Callable b : collection) {
                Runnable b2 = mo303b(b);
                arrayList.add(b2);
                ExecutorDetour.a(this, b2, 272375085);
            }
            for (Future future : arrayList) {
                if (!future.isDone()) {
                    try {
                        FutureDetour.a(future, -1547836324);
                    } catch (CancellationException e) {
                    } catch (ExecutionException e2) {
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            Throwable th2 = th;
            for (Future future2 : arrayList) {
                future2.cancel(true);
            }
        }
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        if (collection == null || timeUnit == null) {
            throw new NullPointerException();
        }
        long toNanos = timeUnit.toNanos(j);
        List<Future<T>> arrayList = new ArrayList(collection.size());
        try {
            long nanoTime;
            for (Callable b : collection) {
                arrayList.add(mo303b(b));
            }
            long nanoTime2 = System.nanoTime();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ExecutorDetour.a(this, (Runnable) it.next(), -1236421293);
                nanoTime = System.nanoTime();
                toNanos -= nanoTime - nanoTime2;
                if (toNanos <= 0) {
                    for (Future cancel : arrayList) {
                        cancel.cancel(true);
                    }
                    return arrayList;
                }
                nanoTime2 = nanoTime;
            }
            for (Future cancel2 : arrayList) {
                if (cancel2.isDone()) {
                    nanoTime = nanoTime2;
                    nanoTime2 = toNanos;
                } else if (toNanos <= 0) {
                    for (Future cancel22 : arrayList) {
                        cancel22.cancel(true);
                    }
                    return arrayList;
                } else {
                    try {
                        FutureDetour.a(cancel22, toNanos, TimeUnit.NANOSECONDS, -247799896);
                    } catch (CancellationException e) {
                    } catch (ExecutionException e2) {
                    } catch (TimeoutException e3) {
                        for (Future cancel222 : arrayList) {
                            cancel222.cancel(true);
                        }
                        return arrayList;
                    }
                    nanoTime = System.nanoTime();
                    nanoTime2 = toNanos - (nanoTime - nanoTime2);
                }
                toNanos = nanoTime2;
                nanoTime2 = nanoTime;
            }
            return arrayList;
        } catch (Throwable th) {
            Throwable th2 = th;
            for (Future cancel2222 : arrayList) {
                cancel2222.cancel(true);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> T m1928a(java.util.Collection<? extends java.util.concurrent.Callable<T>> r20, boolean r21, long r22) {
        /*
        r19 = this;
        if (r20 != 0) goto L_0x0008;
    L_0x0002:
        r2 = new java.lang.NullPointerException;
        r2.<init>();
        throw r2;
    L_0x0008:
        r4 = r20.size();
        if (r4 != 0) goto L_0x0014;
    L_0x000e:
        r2 = new java.lang.IllegalArgumentException;
        r2.<init>();
        throw r2;
    L_0x0014:
        r11 = new java.util.ArrayList;
        r11.<init>(r4);
        r14 = new java.util.concurrent.ExecutorCompletionService;
        r0 = r19;
        r14.<init>(r0);
        r3 = 0;
        if (r21 == 0) goto L_0x0080;
    L_0x0023:
        r6 = java.lang.System.nanoTime();	 Catch:{ all -> 0x0095 }
    L_0x0027:
        r15 = r20.iterator();	 Catch:{ all -> 0x0095 }
        r2 = r15.next();	 Catch:{ all -> 0x0095 }
        r2 = (java.util.concurrent.Callable) r2;	 Catch:{ all -> 0x0095 }
        r5 = -787404722; // 0xffffffffd111284e float:-3.8965404E10 double:NaN;
        r2 = com.facebook.tools.dextr.runtime.detour.ExecutorDetour.a(r14, r2, r5);	 Catch:{ all -> 0x0095 }
        r11.add(r2);	 Catch:{ all -> 0x0095 }
        r5 = r4 + -1;
        r2 = 1;
        r10 = r5;
        r12 = r22;
        r5 = r2;
    L_0x0042:
        r4 = r14.poll();	 Catch:{ all -> 0x0095 }
        if (r4 != 0) goto L_0x00e2;
    L_0x0048:
        if (r10 <= 0) goto L_0x0083;
    L_0x004a:
        r8 = r10 + -1;
        r2 = r15.next();	 Catch:{ all -> 0x0095 }
        r2 = (java.util.concurrent.Callable) r2;	 Catch:{ all -> 0x0095 }
        r9 = 529032757; // 0x1f886635 float:5.776733E-20 double:2.61376911E-315;
        r2 = com.facebook.tools.dextr.runtime.detour.ExecutorDetour.a(r14, r2, r9);	 Catch:{ all -> 0x0095 }
        r11.add(r2);	 Catch:{ all -> 0x0095 }
        r2 = r5 + 1;
        r5 = r8;
        r8 = r12;
    L_0x0060:
        if (r4 == 0) goto L_0x00d2;
    L_0x0062:
        r2 = r2 + -1;
        r3 = -1331085342; // 0xffffffffb0a93fe2 float:-1.2314525E-9 double:NaN;
        r3 = com.facebook.tools.dextr.runtime.detour.FutureDetour.a(r4, r3);	 Catch:{ ExecutionException -> 0x00c6, RuntimeException -> 0x00cc }
        r4 = r11.iterator();
    L_0x006f:
        r2 = r4.hasNext();
        if (r2 == 0) goto L_0x00e1;
    L_0x0075:
        r2 = r4.next();
        r2 = (java.util.concurrent.Future) r2;
        r5 = 1;
        r2.cancel(r5);
        goto L_0x006f;
    L_0x0080:
        r6 = 0;
        goto L_0x0027;
    L_0x0083:
        if (r5 == 0) goto L_0x00d7;
    L_0x0085:
        if (r21 == 0) goto L_0x00bd;
    L_0x0087:
        r2 = java.util.concurrent.TimeUnit.NANOSECONDS;	 Catch:{  }
        r2 = r14.poll(r12, r2);	 Catch:{  }
        if (r2 != 0) goto L_0x00ac;
    L_0x008f:
        r2 = new java.util.concurrent.TimeoutException;	 Catch:{  }
        r2.<init>();	 Catch:{  }
        throw r2;	 Catch:{  }
    L_0x0095:
        r2 = move-exception;
        r3 = r2;
        r4 = r11.iterator();
    L_0x009b:
        r2 = r4.hasNext();
        if (r2 == 0) goto L_0x00e0;
    L_0x00a1:
        r2 = r4.next();
        r2 = (java.util.concurrent.Future) r2;
        r5 = 1;
        r2.cancel(r5);
        goto L_0x009b;
    L_0x00ac:
        r8 = java.lang.System.nanoTime();	 Catch:{  }
        r6 = r8 - r6;
        r6 = r12 - r6;
        r4 = r2;
        r2 = r5;
        r5 = r10;
        r16 = r8;
        r8 = r6;
        r6 = r16;
        goto L_0x0060;
    L_0x00bd:
        r2 = r14.take();	 Catch:{  }
        r4 = r2;
        r8 = r12;
        r2 = r5;
        r5 = r10;
        goto L_0x0060;
    L_0x00c6:
        r3 = move-exception;
        r10 = r5;
        r12 = r8;
        r5 = r2;
        goto L_0x0042;
    L_0x00cc:
        r4 = move-exception;
        r3 = new java.util.concurrent.ExecutionException;	 Catch:{  }
        r3.<init>(r4);	 Catch:{  }
    L_0x00d2:
        r10 = r5;
        r12 = r8;
        r5 = r2;
        goto L_0x0042;
    L_0x00d7:
        if (r3 != 0) goto L_0x00df;
    L_0x00d9:
        r3 = new java.util.concurrent.ExecutionException;	 Catch:{  }
        r2 = 0;
        r3.<init>(r2);	 Catch:{  }
    L_0x00df:
        throw r3;	 Catch:{  }
    L_0x00e0:
        throw r3;
    L_0x00e1:
        return r3;
    L_0x00e2:
        r2 = r5;
        r8 = r12;
        r5 = r10;
        goto L_0x0060;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.executors.AbstractListeningExecutorService.a(java.util.Collection, boolean, long):T");
    }
}
