package com.facebook.common.internal;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* compiled from: second_option */
public class CountingOutputStream extends FilterOutputStream {
    private long f2932a = 0;

    public CountingOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public final long m3175a() {
        return this.f2932a;
    }

    public void write(byte[] bArr, int i, int i2) {
        this.out.write(bArr, i, i2);
        this.f2932a += (long) i2;
    }

    public void write(int i) {
        this.out.write(i);
        this.f2932a++;
    }

    public void close() {
        this.out.close();
    }
}
