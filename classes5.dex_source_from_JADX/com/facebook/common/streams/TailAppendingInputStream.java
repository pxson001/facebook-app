package com.facebook.common.streams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: aim_importer */
public class TailAppendingInputStream extends FilterInputStream {
    private final byte[] f11121a;
    private int f11122b;
    private int f11123c;

    public TailAppendingInputStream(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        if (inputStream == null) {
            throw new NullPointerException();
        } else if (bArr == null) {
            throw new NullPointerException();
        } else {
            this.f11121a = bArr;
        }
    }

    public int read() {
        int read = this.in.read();
        return read != -1 ? read : m19116a();
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = this.in.read(bArr, i, i2);
        if (read != -1) {
            return read;
        }
        if (i2 == 0) {
            return 0;
        }
        read = 0;
        while (read < i2) {
            int a = m19116a();
            if (a == -1) {
                break;
            }
            bArr[i + read] = (byte) a;
            read++;
        }
        return read <= 0 ? -1 : read;
    }

    public void reset() {
        if (this.in.markSupported()) {
            this.in.reset();
            this.f11122b = this.f11123c;
            return;
        }
        throw new IOException("mark is not supported");
    }

    public void mark(int i) {
        if (this.in.markSupported()) {
            super.mark(i);
            this.f11123c = this.f11122b;
        }
    }

    private int m19116a() {
        if (this.f11122b >= this.f11121a.length) {
            return -1;
        }
        byte[] bArr = this.f11121a;
        int i = this.f11122b;
        this.f11122b = i + 1;
        return bArr[i] & 255;
    }
}
