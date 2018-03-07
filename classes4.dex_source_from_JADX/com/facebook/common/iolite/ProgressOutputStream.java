package com.facebook.common.iolite;

import java.io.OutputStream;

/* compiled from: pack_order */
public class ProgressOutputStream extends FbFilterOutputStream {
    private final Listener f5554a;
    private long f5555b = 0;

    public ProgressOutputStream(OutputStream outputStream, Listener listener) {
        super(outputStream);
        this.f5554a = listener;
    }

    public void write(byte[] bArr, int i, int i2) {
        this.out.write(bArr, i, i2);
        m5981a((long) i2);
    }

    public void write(int i) {
        this.out.write(i);
        m5981a(1);
    }

    private void m5981a(long j) {
        this.f5555b += j;
        this.f5554a.a(j, this.f5555b);
    }
}
