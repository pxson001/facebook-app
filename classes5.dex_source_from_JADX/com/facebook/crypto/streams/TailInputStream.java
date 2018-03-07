package com.facebook.crypto.streams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: a_md */
public class TailInputStream extends FilterInputStream {
    private final byte[] f11746a;
    private final int f11747b;
    private int f11748c;
    private boolean f11749d;

    protected TailInputStream(InputStream inputStream, int i) {
        super(inputStream);
        this.f11746a = new byte[i];
        this.f11747b = i;
    }

    public int read() {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        while (read == 0) {
            read = read(bArr, 0, 1);
        }
        if (read == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    public int read(byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (this.f11749d) {
            return -1;
        }
        if (i2 == 0) {
            return 0;
        }
        while (i3 == 0) {
            i3 = m19791a(bArr, i, i2);
        }
        return i3;
    }

    private int m19791a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int read;
        if (i2 >= this.f11748c) {
            read = this.in.read(bArr, this.f11748c + i, i2 - this.f11748c);
            if (read == -1) {
                this.f11749d = true;
                return -1;
            }
            if (this.f11748c > 0) {
                System.arraycopy(this.f11746a, 0, bArr, i, this.f11748c);
            }
            int i4 = this.f11748c + read;
            read = this.in.read(this.f11746a, 0, this.f11747b);
            if (read == -1) {
                this.f11749d = true;
            } else {
                i3 = read;
            }
            return m19792a(bArr, i4, i3, i);
        }
        read = this.f11748c - i2;
        System.arraycopy(this.f11746a, 0, bArr, i, i2);
        System.arraycopy(this.f11746a, i2, this.f11746a, 0, read);
        i4 = this.in.read(this.f11746a, read, this.f11747b - read);
        if (i4 != -1) {
            return m19792a(bArr, i2, i4 + read, i);
        }
        System.arraycopy(this.f11746a, 0, this.f11746a, i2, read);
        System.arraycopy(bArr, i, this.f11746a, 0, i2);
        this.f11749d = true;
        return -1;
    }

    private int m19792a(byte[] bArr, int i, int i2, int i3) {
        int i4 = this.f11747b - i2;
        int max = Math.max(0, i - i4) + i3;
        i4 = Math.min(i4, i);
        if (i4 > 0) {
            if (i2 > 0) {
                System.arraycopy(this.f11746a, 0, this.f11746a, i4, i2);
            }
            System.arraycopy(bArr, max, this.f11746a, 0, i4);
        }
        this.f11748c = i4 + i2;
        return max - i3;
    }

    public boolean markSupported() {
        return false;
    }

    public final byte[] m19793a() {
        if (this.f11748c == this.f11747b) {
            return this.f11746a;
        }
        throw new IOException("Not enough tail data");
    }
}
