package com.facebook.groups.datautil;

import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.MonotonicClock;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: fake */
public class GroupsIdempotentRequestRunner<T> {
    private final RunnerDelegate<T> f13824a;
    private final FutureCallback<T> f13825b;
    private final DefaultAndroidThreadUtil f13826c;
    private final MonotonicClock f13827d;
    private ListenableFuture<T> f13828e;
    public boolean f13829f;
    public boolean f13830g;
    public int f13831h = 0;
    private long f13832i = Long.MAX_VALUE;

    /* compiled from: fake */
    public interface RunnerDelegate<T> {
        ListenableFuture<T> mo838a();
    }

    public GroupsIdempotentRequestRunner(RunnerDelegate<T> runnerDelegate, final FutureCallback<T> futureCallback, MonotonicClock monotonicClock, AndroidThreadUtil androidThreadUtil) {
        this.f13824a = runnerDelegate;
        this.f13827d = monotonicClock;
        this.f13826c = androidThreadUtil;
        this.f13825b = new FutureCallback<T>(this) {
            final /* synthetic */ GroupsIdempotentRequestRunner f13821b;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onSuccess(T r4) {
                /*
                r3 = this;
                r1 = r3.f13821b;
                monitor-enter(r1);
                r0 = r3.f13821b;	 Catch:{ all -> 0x0024 }
                r0 = r0.f13830g;	 Catch:{ all -> 0x0024 }
                if (r0 != 0) goto L_0x000f;
            L_0x0009:
                r0 = r3.f13821b;	 Catch:{ all -> 0x0024 }
                r0 = r0.f13829f;	 Catch:{ all -> 0x0024 }
                if (r0 != 0) goto L_0x0011;
            L_0x000f:
                monitor-exit(r1);	 Catch:{ all -> 0x0024 }
            L_0x0010:
                return;
            L_0x0011:
                r0 = r3.f13821b;	 Catch:{ all -> 0x0024 }
                r2 = 0;
                r0.f13828e = r2;	 Catch:{ all -> 0x0024 }
                r0 = r3.f13821b;	 Catch:{ all -> 0x0024 }
                r2 = 0;
                r0.f13829f = r2;	 Catch:{ all -> 0x0024 }
                r0 = r4;	 Catch:{ all -> 0x0024 }
                r0.onSuccess(r4);	 Catch:{ all -> 0x0024 }
                monitor-exit(r1);	 Catch:{ all -> 0x0024 }
                goto L_0x0010;
            L_0x0024:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x0024 }
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.datautil.GroupsIdempotentRequestRunner.1.onSuccess(java.lang.Object):void");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onFailure(java.lang.Throwable r4) {
                /*
                r3 = this;
                r1 = r3.f13821b;
                monitor-enter(r1);
                r0 = r3.f13821b;	 Catch:{ all -> 0x0028 }
                r0 = r0.f13830g;	 Catch:{ all -> 0x0028 }
                if (r0 != 0) goto L_0x0013;
            L_0x0009:
                r0 = r3.f13821b;	 Catch:{ all -> 0x0028 }
                r0 = r0.f13829f;	 Catch:{ all -> 0x0028 }
                if (r0 == 0) goto L_0x0013;
            L_0x000f:
                r0 = r4 instanceof java.util.concurrent.CancellationException;	 Catch:{ all -> 0x0028 }
                if (r0 == 0) goto L_0x0015;
            L_0x0013:
                monitor-exit(r1);	 Catch:{ all -> 0x0028 }
            L_0x0014:
                return;
            L_0x0015:
                r0 = r3.f13821b;	 Catch:{ all -> 0x0028 }
                r2 = 0;
                r0.f13828e = r2;	 Catch:{ all -> 0x0028 }
                r0 = r3.f13821b;	 Catch:{ all -> 0x0028 }
                r2 = 0;
                r0.f13829f = r2;	 Catch:{ all -> 0x0028 }
                r0 = r4;	 Catch:{ all -> 0x0028 }
                r0.onFailure(r4);	 Catch:{ all -> 0x0028 }
                monitor-exit(r1);	 Catch:{ all -> 0x0028 }
                goto L_0x0014;
            L_0x0028:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x0028 }
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.datautil.GroupsIdempotentRequestRunner.1.onFailure(java.lang.Throwable):void");
            }
        };
    }

    public final synchronized boolean m15474a() {
        ListenableFuture listenableFuture = true;
        boolean z = false;
        synchronized (this) {
            if (!(this.f13829f || this.f13830g)) {
                this.f13829f = true;
                this.f13831h++;
                this.f13832i = Long.MAX_VALUE;
                try {
                    this.f13828e = this.f13824a.mo838a();
                    if (this.f13829f) {
                        this.f13826c.a(this.f13828e, this.f13825b);
                        z = listenableFuture;
                    }
                } finally {
                    listenableFuture = this.f13828e;
                    if (listenableFuture == null) {
                        listenableFuture = null;
                        this.f13829f = false;
                    }
                }
            }
        }
        return z;
    }

    public final synchronized void m15473a(long j) {
        long now = this.f13827d.now() + j;
        if (!this.f13830g && now <= this.f13832i) {
            this.f13832i = now;
            final int i = this.f13831h + 1;
            this.f13831h = i;
            this.f13826c.b(new Runnable(this) {
                final /* synthetic */ GroupsIdempotentRequestRunner f13823b;

                public void run() {
                    synchronized (this.f13823b) {
                        this.f13823b.f13832i = Long.MAX_VALUE;
                        if (i == this.f13823b.f13831h) {
                            this.f13823b.m15474a();
                        }
                    }
                }
            }, j);
        }
    }

    public final synchronized void m15475b() {
        if (this.f13829f) {
            if (this.f13828e != null) {
                this.f13828e.cancel(true);
            }
            this.f13828e = null;
            this.f13829f = false;
        }
        this.f13831h++;
        this.f13832i = Long.MAX_VALUE;
    }
}
