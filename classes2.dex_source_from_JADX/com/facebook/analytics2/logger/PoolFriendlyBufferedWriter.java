package com.facebook.analytics2.logger;

import java.io.IOException;
import java.io.Writer;

/* compiled from: t_rtc_multi */
class PoolFriendlyBufferedWriter extends Writer {
    private Writer f3502a;
    private char[] f3503b;
    private int f3504c;

    public PoolFriendlyBufferedWriter(Writer writer, char[] cArr) {
        super(writer);
        this.f3502a = writer;
        this.f3503b = cArr;
    }

    public void close() {
        Throwable th = null;
        synchronized (this.lock) {
            if (m5716c()) {
                return;
            }
            Throwable th2;
            try {
                m5715b();
            } catch (Throwable th3) {
                th = th3;
            }
            this.f3503b = null;
            try {
                this.f3502a.close();
                th2 = th;
            } catch (Throwable th4) {
                th2 = th4;
                if (th != null) {
                    th2 = th;
                }
            }
            this.f3502a = null;
            if (th2 != null) {
                throw ((Error) th2);
            }
        }
    }

    public void flush() {
        synchronized (this.lock) {
            m5714a();
            m5715b();
            this.f3502a.flush();
        }
    }

    private void m5714a() {
        if (m5716c()) {
            throw new IOException("BufferedWriter is closed");
        }
    }

    private void m5715b() {
        if (this.f3504c > 0) {
            this.f3502a.write(this.f3503b, 0, this.f3504c);
        }
        this.f3504c = 0;
    }

    private boolean m5716c() {
        return this.f3502a == null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(char[] r7, int r8, int r9) {
        /*
        r6 = this;
        r1 = r6.lock;
        monitor-enter(r1);
        r6.m5714a();	 Catch:{ all -> 0x0010 }
        if (r7 != 0) goto L_0x0013;
    L_0x0008:
        r0 = new java.lang.NullPointerException;	 Catch:{ all -> 0x0010 }
        r2 = "buffer == null";
        r0.<init>(r2);	 Catch:{ all -> 0x0010 }
        throw r0;	 Catch:{ all -> 0x0010 }
    L_0x0010:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0010 }
        throw r0;
    L_0x0013:
        r0 = r7.length;	 Catch:{  }
        com.facebook.analytics2.logger.LibcoreUtils.m5733a(r0, r8, r9);	 Catch:{  }
        r0 = r6.f3504c;	 Catch:{  }
        if (r0 != 0) goto L_0x0027;
    L_0x001b:
        r0 = r6.f3503b;	 Catch:{  }
        r0 = r0.length;	 Catch:{  }
        if (r9 < r0) goto L_0x0027;
    L_0x0020:
        r0 = r6.f3502a;	 Catch:{  }
        r0.write(r7, r8, r9);	 Catch:{  }
        monitor-exit(r1);	 Catch:{  }
    L_0x0026:
        return;
    L_0x0027:
        r0 = r6.f3503b;	 Catch:{  }
        r0 = r0.length;	 Catch:{  }
        r2 = r6.f3504c;	 Catch:{  }
        r0 = r0 - r2;
        if (r9 >= r0) goto L_0x0030;
    L_0x002f:
        r0 = r9;
    L_0x0030:
        if (r0 <= 0) goto L_0x003e;
    L_0x0032:
        r2 = r6.f3503b;	 Catch:{  }
        r3 = r6.f3504c;	 Catch:{  }
        java.lang.System.arraycopy(r7, r8, r2, r3, r0);	 Catch:{  }
        r2 = r6.f3504c;	 Catch:{  }
        r2 = r2 + r0;
        r6.f3504c = r2;	 Catch:{  }
    L_0x003e:
        r2 = r6.f3504c;	 Catch:{  }
        r3 = r6.f3503b;	 Catch:{  }
        r3 = r3.length;	 Catch:{  }
        if (r2 != r3) goto L_0x0071;
    L_0x0045:
        r2 = r6.f3502a;	 Catch:{  }
        r3 = r6.f3503b;	 Catch:{  }
        r4 = 0;
        r5 = r6.f3503b;	 Catch:{  }
        r5 = r5.length;	 Catch:{  }
        r2.write(r3, r4, r5);	 Catch:{  }
        r2 = 0;
        r6.f3504c = r2;	 Catch:{  }
        if (r9 <= r0) goto L_0x0071;
    L_0x0055:
        r2 = r8 + r0;
        r0 = r9 - r0;
        r3 = r6.f3503b;	 Catch:{  }
        r3 = r3.length;	 Catch:{  }
        if (r0 < r3) goto L_0x0065;
    L_0x005e:
        r3 = r6.f3502a;	 Catch:{  }
        r3.write(r7, r2, r0);	 Catch:{  }
        monitor-exit(r1);	 Catch:{  }
        goto L_0x0026;
    L_0x0065:
        r3 = r6.f3503b;	 Catch:{  }
        r4 = r6.f3504c;	 Catch:{  }
        java.lang.System.arraycopy(r7, r2, r3, r4, r0);	 Catch:{  }
        r2 = r6.f3504c;	 Catch:{  }
        r0 = r0 + r2;
        r6.f3504c = r0;	 Catch:{  }
    L_0x0071:
        monitor-exit(r1);	 Catch:{  }
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics2.logger.PoolFriendlyBufferedWriter.write(char[], int, int):void");
    }

    public void write(int i) {
        synchronized (this.lock) {
            m5714a();
            if (this.f3504c >= this.f3503b.length) {
                this.f3502a.write(this.f3503b, 0, this.f3503b.length);
                this.f3504c = 0;
            }
            char[] cArr = this.f3503b;
            int i2 = this.f3504c;
            this.f3504c = i2 + 1;
            cArr[i2] = (char) i;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(java.lang.String r7, int r8, int r9) {
        /*
        r6 = this;
        r1 = r6.lock;
        monitor-enter(r1);
        r6.m5714a();	 Catch:{ all -> 0x0018 }
        if (r9 > 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
    L_0x0009:
        return;
    L_0x000a:
        if (r8 < 0) goto L_0x0013;
    L_0x000c:
        r0 = r7.length();	 Catch:{ all -> 0x0018 }
        r0 = r0 - r9;
        if (r8 <= r0) goto L_0x001b;
    L_0x0013:
        r0 = com.facebook.analytics2.logger.LibcoreUtils.m5732a(r7, r8, r9);	 Catch:{ all -> 0x0018 }
        throw r0;	 Catch:{ all -> 0x0018 }
    L_0x0018:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
        throw r0;
    L_0x001b:
        r0 = r6.f3504c;	 Catch:{  }
        if (r0 != 0) goto L_0x0034;
    L_0x001f:
        r0 = r6.f3503b;	 Catch:{  }
        r0 = r0.length;	 Catch:{  }
        if (r9 < r0) goto L_0x0034;
    L_0x0024:
        r0 = new char[r9];	 Catch:{  }
        r2 = r8 + r9;
        r3 = 0;
        r7.getChars(r8, r2, r0, r3);	 Catch:{  }
        r2 = r6.f3502a;	 Catch:{  }
        r3 = 0;
        r2.write(r0, r3, r9);	 Catch:{  }
        monitor-exit(r1);	 Catch:{  }
        goto L_0x0009;
    L_0x0034:
        r0 = r6.f3503b;	 Catch:{  }
        r0 = r0.length;	 Catch:{  }
        r2 = r6.f3504c;	 Catch:{  }
        r0 = r0 - r2;
        if (r9 >= r0) goto L_0x003d;
    L_0x003c:
        r0 = r9;
    L_0x003d:
        if (r0 <= 0) goto L_0x004d;
    L_0x003f:
        r2 = r8 + r0;
        r3 = r6.f3503b;	 Catch:{  }
        r4 = r6.f3504c;	 Catch:{  }
        r7.getChars(r8, r2, r3, r4);	 Catch:{  }
        r2 = r6.f3504c;	 Catch:{  }
        r2 = r2 + r0;
        r6.f3504c = r2;	 Catch:{  }
    L_0x004d:
        r2 = r6.f3504c;	 Catch:{  }
        r3 = r6.f3503b;	 Catch:{  }
        r3 = r3.length;	 Catch:{  }
        if (r2 != r3) goto L_0x008b;
    L_0x0054:
        r2 = r6.f3502a;	 Catch:{  }
        r3 = r6.f3503b;	 Catch:{  }
        r4 = 0;
        r5 = r6.f3503b;	 Catch:{  }
        r5 = r5.length;	 Catch:{  }
        r2.write(r3, r4, r5);	 Catch:{  }
        r2 = 0;
        r6.f3504c = r2;	 Catch:{  }
        if (r9 <= r0) goto L_0x008b;
    L_0x0064:
        r2 = r8 + r0;
        r0 = r9 - r0;
        r3 = r6.f3503b;	 Catch:{  }
        r3 = r3.length;	 Catch:{  }
        if (r0 < r3) goto L_0x007d;
    L_0x006d:
        r3 = new char[r9];	 Catch:{  }
        r4 = r2 + r0;
        r5 = 0;
        r7.getChars(r2, r4, r3, r5);	 Catch:{  }
        r2 = r6.f3502a;	 Catch:{  }
        r4 = 0;
        r2.write(r3, r4, r0);	 Catch:{  }
        monitor-exit(r1);	 Catch:{  }
        goto L_0x0009;
    L_0x007d:
        r3 = r2 + r0;
        r4 = r6.f3503b;	 Catch:{  }
        r5 = r6.f3504c;	 Catch:{  }
        r7.getChars(r2, r3, r4, r5);	 Catch:{  }
        r2 = r6.f3504c;	 Catch:{  }
        r0 = r0 + r2;
        r6.f3504c = r0;	 Catch:{  }
    L_0x008b:
        monitor-exit(r1);	 Catch:{  }
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics2.logger.PoolFriendlyBufferedWriter.write(java.lang.String, int, int):void");
    }
}
