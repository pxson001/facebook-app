package com.facebook.crypto.streams;

import com.facebook.crypto.cipher.NativeGCMCipher;
import java.io.InputStream;

/* compiled from: aac-profile */
public class NativeGCMCipherInputStream extends InputStream {
    private final TailInputStream f11742a;
    private final NativeGCMCipher f11743b;
    private byte[] f11744c;
    private boolean f11745d = false;

    public NativeGCMCipherInputStream(InputStream inputStream, NativeGCMCipher nativeGCMCipher, int i) {
        this.f11742a = new TailInputStream(inputStream, i);
        this.f11743b = nativeGCMCipher;
    }

    public int available() {
        return this.f11742a.available();
    }

    public void close() {
        try {
            m19790a();
        } finally {
            this.f11742a.close();
        }
    }

    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    public int read() {
        throw new UnsupportedOperationException();
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (bArr.length < i + i2) {
            throw new ArrayIndexOutOfBoundsException(i + i2);
        }
        int read = this.f11742a.read(bArr, i, i2);
        if (read != -1) {
            return this.f11743b.a(bArr, i, read, bArr, i);
        }
        m19790a();
        return -1;
    }

    private void m19790a() {
        if (!this.f11745d) {
            this.f11745d = true;
            try {
                byte[] a = this.f11742a.m19793a();
                this.f11743b.c(a, a.length);
            } finally {
                this.f11743b.a();
            }
        }
    }

    public synchronized void reset() {
        throw new UnsupportedOperationException();
    }

    public long skip(long j) {
        if (this.f11744c == null) {
            this.f11744c = new byte[256];
        }
        long j2 = 0;
        while (j > 0) {
            int read = read(this.f11744c, 0, (int) Math.min(j, 256));
            if (read < 0) {
                break;
            }
            j2 += (long) read;
            j -= (long) read;
        }
        return j2 == 0 ? -1 : j2;
    }
}
