package com.facebook.crypto.streams;

import com.facebook.crypto.cipher.NativeGCMCipher;
import java.io.OutputStream;

/* compiled from: syncCoefficients */
public class NativeGCMCipherOutputStream extends OutputStream {
    private final OutputStream f1518a;
    private final NativeGCMCipher f1519b;
    private final int f1520c;
    private final byte[] f1521d;
    private final byte[] f1522e;
    private boolean f1523f = false;

    public NativeGCMCipherOutputStream(OutputStream outputStream, NativeGCMCipher nativeGCMCipher, byte[] bArr, int i) {
        this.f1518a = outputStream;
        this.f1519b = nativeGCMCipher;
        this.f1522e = new byte[i];
        int b = this.f1519b.m1738b();
        if (bArr == null) {
            bArr = new byte[(b + 256)];
        } else {
            int i2 = b + 1;
            if (bArr.length < i2) {
                throw new IllegalArgumentException("encryptBuffer cannot be smaller than " + i2 + "B");
            }
        }
        this.f1520c = bArr.length - b;
        this.f1521d = bArr;
    }

    public void close() {
        try {
            m1744a();
        } finally {
            this.f1518a.close();
        }
    }

    private void m1744a() {
        if (!this.f1523f) {
            this.f1523f = true;
            try {
                this.f1519b.m1739b(this.f1522e, this.f1522e.length);
                this.f1518a.write(this.f1522e);
            } finally {
                this.f1519b.m1735a();
            }
        }
    }

    public void flush() {
        this.f1518a.flush();
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        if (bArr.length < i + i2) {
            throw new ArrayIndexOutOfBoundsException(i + i2);
        }
        int i3 = i2 / this.f1520c;
        int i4 = i2 % this.f1520c;
        int i5 = i;
        for (int i6 = 0; i6 < i3; i6++) {
            this.f1518a.write(this.f1521d, 0, this.f1519b.m1734a(bArr, i5, this.f1520c, this.f1521d, 0));
            i5 += this.f1520c;
        }
        if (i4 > 0) {
            this.f1518a.write(this.f1521d, 0, this.f1519b.m1734a(bArr, i5, i4, this.f1521d, 0));
        }
    }

    public void write(int i) {
        write(new byte[]{(byte) i}, 0, 1);
    }
}
