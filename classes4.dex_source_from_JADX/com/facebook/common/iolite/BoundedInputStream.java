package com.facebook.common.iolite;

import java.io.FilterInputStream;
import java.io.InputStream;

/* compiled from: other_mtrack */
public class BoundedInputStream extends FilterInputStream {
    private long f5855a;
    private long f5856b = -1;
    private boolean f5857c;

    public BoundedInputStream(InputStream inputStream, long j, boolean z) {
        super(inputStream);
        this.f5855a = j;
        this.f5857c = z;
    }

    public synchronized void mark(int i) {
        super.mark(i);
        this.f5856b = this.f5855a;
    }

    public synchronized void reset() {
        super.reset();
        this.f5855a = this.f5856b;
        this.f5856b = -1;
    }

    public int read() {
        byte[] bArr = new byte[1];
        if (read(bArr, 0, 1) == 1) {
            return bArr[0];
        }
        return -1;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.f5855a <= 0) {
            return i2 == 0 ? 0 : -1;
        } else {
            if (this.f5855a < ((long) i2)) {
                i2 = (int) this.f5855a;
            }
            int read = super.read(bArr, i, i2);
            if (read < 0) {
                return read;
            }
            this.f5855a -= (long) read;
            return read;
        }
    }

    public long skip(long j) {
        if (this.f5855a > 0) {
            if (this.f5855a < j) {
                j = this.f5855a;
            }
            long skip = super.skip(j);
            if (skip >= 0) {
                this.f5855a -= skip;
            }
            return skip;
        } else if (j == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    public void close() {
        if (this.f5857c) {
            super.close();
        }
    }
}
