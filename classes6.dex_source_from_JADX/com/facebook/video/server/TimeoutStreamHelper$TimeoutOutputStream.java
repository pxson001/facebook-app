package com.facebook.video.server;

import java.io.OutputStream;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: commerce_collection_load_time */
class TimeoutStreamHelper$TimeoutOutputStream extends OutputStream {
    final /* synthetic */ TimeoutStreamHelper f19537a;
    private final OutputStream f19538b;
    private final Thread f19539c;
    private final Object f19540d = new Object();
    @GuardedBy("mLock")
    private boolean f19541e;
    @GuardedBy("mLock")
    private long f19542f;

    public TimeoutStreamHelper$TimeoutOutputStream(TimeoutStreamHelper timeoutStreamHelper, OutputStream outputStream) {
        this.f19537a = timeoutStreamHelper;
        this.f19538b = outputStream;
        this.f19539c = Thread.currentThread();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m28260a(long r8) {
        /*
        r7 = this;
        r1 = r7.f19540d;
        monitor-enter(r1);
        r0 = r7.f19539c;	 Catch:{ all -> 0x002d }
        r2 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x002d }
        if (r0 == r2) goto L_0x0015;
    L_0x000b:
        r0 = 1;
    L_0x000c:
        com.google.common.base.Preconditions.checkState(r0);	 Catch:{ all -> 0x002d }
        r0 = r7.f19541e;	 Catch:{ all -> 0x002d }
        if (r0 != 0) goto L_0x0017;
    L_0x0013:
        monitor-exit(r1);	 Catch:{ all -> 0x002d }
    L_0x0014:
        return;
    L_0x0015:
        r0 = 0;
        goto L_0x000c;
    L_0x0017:
        r0 = r7.f19537a;	 Catch:{ all -> 0x002d }
        r0 = r0.c;	 Catch:{ all -> 0x002d }
        r2 = r0.now();	 Catch:{ all -> 0x002d }
        r4 = r7.f19542f;	 Catch:{ all -> 0x002d }
        r2 = r2 - r4;
        r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x002b;
    L_0x0026:
        r0 = r7.f19539c;	 Catch:{ all -> 0x002d }
        r0.interrupt();	 Catch:{ all -> 0x002d }
    L_0x002b:
        monitor-exit(r1);	 Catch:{ all -> 0x002d }
        goto L_0x0014;
    L_0x002d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.server.TimeoutStreamHelper$TimeoutOutputStream.a(long):void");
    }

    public void write(int i) {
        try {
            m28258a();
            this.f19538b.write(i);
        } finally {
            m28259b();
        }
    }

    public void write(byte[] bArr) {
        try {
            m28258a();
            this.f19538b.write(bArr);
        } finally {
            m28259b();
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        try {
            m28258a();
            this.f19538b.write(bArr, i, i2);
        } finally {
            m28259b();
        }
    }

    private void m28258a() {
        synchronized (this.f19540d) {
            this.f19542f = this.f19537a.c.now();
            this.f19541e = true;
        }
    }

    private void m28259b() {
        synchronized (this.f19540d) {
            this.f19541e = false;
        }
    }
}
