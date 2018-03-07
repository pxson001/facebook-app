package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class zzly<R extends Result> extends PendingResult<R> {
    protected final zza<R> f6830a;
    private final Object f6831b = new Object();
    private final CountDownLatch f6832c = new CountDownLatch(1);
    private final ArrayList<Object> f6833d = new ArrayList();
    private ResultCallback<? super R> f6834e;
    private volatile R f6835f;
    private volatile boolean f6836g;
    private boolean f6837h;
    private boolean f6838i;
    private zzq f6839j;
    private Integer f6840k;
    private volatile zzms<R> f6841l;

    public class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        private static void m12781b(ResultCallback<? super R> resultCallback, R r) {
            try {
                resultCallback.a(r);
            } catch (RuntimeException e) {
                zzly.m12746b((Result) r);
                throw e;
            }
        }

        public final void m12782a(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    m12781b((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    ((zzly) message.obj).m12755b(Status.d);
                    return;
                default:
                    Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
                    return;
            }
        }
    }

    @Deprecated
    protected zzly(Looper looper) {
        this.f6830a = new zza(looper);
    }

    public static void m12746b(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).mo737c();
            } catch (Throwable e) {
                Log.w("BasePendingResult", "Unable to release " + result, e);
            }
        }
    }

    private void m12747c(R r) {
        this.f6835f = r;
        this.f6839j = null;
        this.f6832c.countDown();
        this.f6835f.cp_();
        if (this.f6834e != null) {
            this.f6830a.removeMessages(2);
            if (!this.f6837h) {
                this.f6830a.m12782a(this.f6834e, m12749j());
            }
        }
        Iterator it = this.f6833d.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.f6833d.clear();
    }

    private boolean m12748i() {
        boolean z;
        synchronized (this.f6831b) {
            z = this.f6837h;
        }
        return z;
    }

    private R m12749j() {
        R r;
        boolean z = true;
        synchronized (this.f6831b) {
            if (this.f6836g) {
                z = false;
            }
            zzx.a(z, "Result has already been consumed.");
            zzx.a(m12758g(), "Result is not ready.");
            r = this.f6835f;
            this.f6835f = null;
            this.f6834e = null;
            this.f6836g = true;
        }
        mo835f();
        return r;
    }

    public final R mo824a() {
        boolean z = true;
        zzx.a(Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread");
        zzx.a(!this.f6836g, "Result has already been consumed");
        if (this.f6841l != null) {
            z = false;
        }
        zzx.a(z, "Cannot await if then() has been called.");
        try {
            this.f6832c.await();
        } catch (InterruptedException e) {
            m12755b(Status.b);
        }
        zzx.a(m12758g(), "Result is not ready.");
        return m12749j();
    }

    public final R mo825a(long j, TimeUnit timeUnit) {
        boolean z = true;
        boolean z2 = j <= 0 || Looper.myLooper() != Looper.getMainLooper();
        zzx.a(z2, "await must not be called on the UI thread when time is greater than zero.");
        zzx.a(!this.f6836g, "Result has already been consumed.");
        if (this.f6841l != null) {
            z = false;
        }
        zzx.a(z, "Cannot await if then() has been called.");
        try {
            if (!this.f6832c.await(j, timeUnit)) {
                m12755b(Status.d);
            }
        } catch (InterruptedException e) {
            m12755b(Status.b);
        }
        zzx.a(m12758g(), "Result is not ready.");
        return m12749j();
    }

    public final void m12752a(R r) {
        boolean z = true;
        synchronized (this.f6831b) {
            if (this.f6838i || this.f6837h) {
                m12746b((Result) r);
                return;
            }
            zzx.a(!m12758g(), "Results have already been set");
            if (this.f6836g) {
                z = false;
            }
            zzx.a(z, "Result has already been consumed");
            m12747c((Result) r);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo826a(com.google.android.gms.common.api.ResultCallback<? super R> r5) {
        /*
        r4 = this;
        r1 = 1;
        r2 = 0;
        r0 = r4.f6836g;
        if (r0 != 0) goto L_0x0020;
    L_0x0006:
        r0 = r1;
    L_0x0007:
        r3 = "Result has already been consumed.";
        com.google.android.gms.common.internal.zzx.a(r0, r3);
        r3 = r4.f6831b;
        monitor-enter(r3);
        r0 = r4.f6841l;	 Catch:{ all -> 0x0035 }
        if (r0 != 0) goto L_0x0022;
    L_0x0013:
        r0 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.zzx.a(r1, r0);	 Catch:{ all -> 0x0035 }
        r0 = r4.m12748i();	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x0024;
    L_0x001e:
        monitor-exit(r3);	 Catch:{ all -> 0x0035 }
    L_0x001f:
        return;
    L_0x0020:
        r0 = r2;
        goto L_0x0007;
    L_0x0022:
        r1 = r2;
        goto L_0x0013;
    L_0x0024:
        r0 = r4.m12758g();	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x0038;
    L_0x002a:
        r0 = r4.f6830a;	 Catch:{ all -> 0x0035 }
        r1 = r4.m12749j();	 Catch:{ all -> 0x0035 }
        r0.m12782a(r5, r1);	 Catch:{ all -> 0x0035 }
    L_0x0033:
        monitor-exit(r3);	 Catch:{ all -> 0x0035 }
        goto L_0x001f;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0035 }
        throw r0;
    L_0x0038:
        r4.f6834e = r5;	 Catch:{  }
        goto L_0x0033;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzly.a(com.google.android.gms.common.api.ResultCallback):void");
    }

    public final Integer mo827b() {
        return this.f6840k;
    }

    public final void m12755b(Status status) {
        synchronized (this.f6831b) {
            if (!m12758g()) {
                m12752a(m12756c(status));
                this.f6838i = true;
            }
        }
    }

    protected abstract R m12756c(Status status);

    protected void mo835f() {
    }

    public final boolean m12758g() {
        return this.f6832c.getCount() == 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m12759h() {
        /*
        r2 = this;
        r1 = r2.f6831b;
        monitor-enter(r1);
        r0 = r2.f6837h;	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.f6836g;	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r2.f6835f;	 Catch:{ all -> 0x0023 }
        m12746b(r0);	 Catch:{ all -> 0x0023 }
        r0 = 0;
        r2.f6834e = r0;	 Catch:{ all -> 0x0023 }
        r0 = 1;
        r2.f6837h = r0;	 Catch:{ all -> 0x0023 }
        r0 = com.google.android.gms.common.api.Status.e;	 Catch:{ all -> 0x0023 }
        r0 = r2.m12756c(r0);	 Catch:{ all -> 0x0023 }
        r2.m12747c(r0);	 Catch:{ all -> 0x0023 }
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x000c;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzly.h():void");
    }
}
