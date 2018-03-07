package com.facebook.datasource;

import android.util.Pair;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: mediaprovider_uri */
public abstract class AbstractDataSource<T> implements DataSource<T> {
    @GuardedBy("this")
    private DataSourceStatus f14492a = DataSourceStatus.IN_PROGRESS;
    @GuardedBy("this")
    private boolean f14493b = false;
    @GuardedBy("this")
    @Nullable
    private T f14494c = null;
    @GuardedBy("this")
    private Throwable f14495d = null;
    @GuardedBy("this")
    private float f14496e = 0.0f;
    public final ConcurrentLinkedQueue<Pair<DataSubscriber<T>, Executor>> f14497f = new ConcurrentLinkedQueue();

    /* compiled from: mediaprovider_uri */
    enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    protected AbstractDataSource() {
    }

    public final synchronized boolean m20883a() {
        return this.f14493b;
    }

    public final synchronized boolean mo2784b() {
        return this.f14492a != DataSourceStatus.IN_PROGRESS;
    }

    public synchronized boolean mo2785c() {
        return this.f14494c != null;
    }

    @Nullable
    public synchronized T mo2781d() {
        return this.f14494c;
    }

    private synchronized boolean m20878h() {
        return this.f14492a == DataSourceStatus.FAILURE;
    }

    @Nullable
    public final synchronized Throwable mo2786e() {
        return this.f14495d;
    }

    public final synchronized float mo2787f() {
        return this.f14496e;
    }

    public boolean mo2782g() {
        boolean z = true;
        synchronized (this) {
            if (this.f14493b) {
                z = false;
            } else {
                this.f14493b = true;
                Object obj = this.f14494c;
                this.f14494c = null;
                if (obj != null) {
                    mo2779a(obj);
                }
                if (!mo2784b()) {
                    m20879i();
                }
                synchronized (this) {
                    this.f14497f.clear();
                }
            }
        }
        return z;
    }

    protected void mo2779a(@Nullable T t) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo2783a(com.facebook.datasource.DataSubscriber<T> r3, java.util.concurrent.Executor r4) {
        /*
        r2 = this;
        com.facebook.common.internal.Preconditions.a(r3);
        com.facebook.common.internal.Preconditions.a(r4);
        monitor-enter(r2);
        r0 = r2.f14493b;	 Catch:{ all -> 0x0040 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r2);	 Catch:{ all -> 0x0040 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r2.f14492a;	 Catch:{ all -> 0x0040 }
        r1 = com.facebook.datasource.AbstractDataSource.DataSourceStatus.IN_PROGRESS;	 Catch:{ all -> 0x0040 }
        if (r0 != r1) goto L_0x001c;
    L_0x0013:
        r0 = r2.f14497f;	 Catch:{ all -> 0x0040 }
        r1 = android.util.Pair.create(r3, r4);	 Catch:{ all -> 0x0040 }
        r0.add(r1);	 Catch:{ all -> 0x0040 }
    L_0x001c:
        r0 = r2.mo2785c();	 Catch:{ all -> 0x0040 }
        if (r0 != 0) goto L_0x002e;
    L_0x0022:
        r0 = r2.mo2784b();	 Catch:{ all -> 0x0040 }
        if (r0 != 0) goto L_0x002e;
    L_0x0028:
        r0 = r2.m20880j();	 Catch:{ all -> 0x0040 }
        if (r0 == 0) goto L_0x003e;
    L_0x002e:
        r0 = 1;
    L_0x002f:
        monitor-exit(r2);	 Catch:{ all -> 0x0040 }
        if (r0 == 0) goto L_0x000c;
    L_0x0032:
        r0 = r2.m20878h();
        r1 = r2.m20880j();
        r2.m20874a(r3, r4, r0, r1);
        goto L_0x000c;
    L_0x003e:
        r0 = 0;
        goto L_0x002f;
    L_0x0040:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{  }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.AbstractDataSource.a(com.facebook.datasource.DataSubscriber, java.util.concurrent.Executor):void");
    }

    private void m20879i() {
        boolean h = m20878h();
        boolean j = m20880j();
        Iterator it = this.f14497f.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            m20874a((DataSubscriber) pair.first, (Executor) pair.second, h, j);
        }
    }

    private void m20874a(final DataSubscriber<T> dataSubscriber, Executor executor, final boolean z, final boolean z2) {
        ExecutorDetour.a(executor, new Runnable(this) {
            final /* synthetic */ AbstractDataSource f15042d;

            public void run() {
                if (z) {
                    dataSubscriber.mo2806b(this.f15042d);
                } else if (z2) {
                    dataSubscriber.mo2807c(this.f15042d);
                } else {
                    dataSubscriber.mo2805a(this.f15042d);
                }
            }
        }, -2050190287);
    }

    private synchronized boolean m20880j() {
        boolean z;
        z = m20883a() && !mo2784b();
        return z;
    }

    protected boolean m20885a(@Nullable T t, boolean z) {
        boolean b = mo2780b(t, z);
        if (b) {
            m20879i();
        }
        return b;
    }

    public boolean m20886a(Throwable th) {
        boolean b = m20877b(th);
        if (b) {
            m20879i();
        }
        return b;
    }

    public boolean m20884a(float f) {
        boolean b = m20875b(f);
        if (b) {
            Iterator it = this.f14497f.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                final DataSubscriber dataSubscriber = (DataSubscriber) pair.first;
                ExecutorDetour.a((Executor) pair.second, new Runnable(this) {
                    final /* synthetic */ AbstractDataSource f17512b;

                    public void run() {
                        dataSubscriber.mo2802d(this.f17512b);
                    }
                }, 2029468784);
            }
        }
        return b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean mo2780b(@javax.annotation.Nullable T r4, boolean r5) {
        /*
        r3 = this;
        r1 = 0;
        monitor-enter(r3);	 Catch:{ all -> 0x003a }
        r0 = r3.f14493b;	 Catch:{ all -> 0x002f }
        if (r0 != 0) goto L_0x000c;
    L_0x0006:
        r0 = r3.f14492a;	 Catch:{ all -> 0x002f }
        r2 = com.facebook.datasource.AbstractDataSource.DataSourceStatus.IN_PROGRESS;	 Catch:{ all -> 0x002f }
        if (r0 == r2) goto L_0x0014;
    L_0x000c:
        monitor-exit(r3);	 Catch:{ all -> 0x003d }
        if (r4 == 0) goto L_0x0012;
    L_0x000f:
        r3.mo2779a(r4);
    L_0x0012:
        r0 = 0;
    L_0x0013:
        return r0;
    L_0x0014:
        if (r5 == 0) goto L_0x001e;
    L_0x0016:
        r0 = com.facebook.datasource.AbstractDataSource.DataSourceStatus.SUCCESS;	 Catch:{  }
        r3.f14492a = r0;	 Catch:{  }
        r0 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3.f14496e = r0;	 Catch:{  }
    L_0x001e:
        r0 = r3.f14494c;	 Catch:{  }
        if (r0 == r4) goto L_0x0042;
    L_0x0022:
        r1 = r3.f14494c;	 Catch:{  }
        r3.f14494c = r4;	 Catch:{ all -> 0x003f }
        r4 = r1;
    L_0x0027:
        monitor-exit(r3);	 Catch:{  }
        if (r4 == 0) goto L_0x002d;
    L_0x002a:
        r3.mo2779a(r4);
    L_0x002d:
        r0 = 1;
        goto L_0x0013;
    L_0x002f:
        r0 = move-exception;
        r4 = r1;
    L_0x0031:
        monitor-exit(r3);	 Catch:{  }
        throw r0;	 Catch:{ all -> 0x0033 }
    L_0x0033:
        r0 = move-exception;
    L_0x0034:
        if (r4 == 0) goto L_0x0039;
    L_0x0036:
        r3.mo2779a(r4);
    L_0x0039:
        throw r0;
    L_0x003a:
        r0 = move-exception;
        r4 = r1;
        goto L_0x0034;
    L_0x003d:
        r0 = move-exception;
        goto L_0x0031;
    L_0x003f:
        r0 = move-exception;
        r4 = r1;
        goto L_0x0031;
    L_0x0042:
        r4 = r1;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.AbstractDataSource.b(java.lang.Object, boolean):boolean");
    }

    private synchronized boolean m20877b(Throwable th) {
        boolean z;
        if (this.f14493b || this.f14492a != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.f14492a = DataSourceStatus.FAILURE;
            this.f14495d = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean m20875b(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.f14493b && this.f14492a == DataSourceStatus.IN_PROGRESS && f >= this.f14496e) {
                this.f14496e = f;
                z = true;
            }
        }
        return z;
    }
}
