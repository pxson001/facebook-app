package com.facebook.ui.images.fetch;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: recent_searches */
public class ProgressAwareCountingInputStream extends FilterInputStream {
    private long f3614a;
    private long f3615b = -1;
    private DownloadAndInsertIntoCacheProgressUpdate f3616c;

    public ProgressAwareCountingInputStream(InputStream inputStream, DownloadAndInsertIntoCacheProgressUpdate downloadAndInsertIntoCacheProgressUpdate) {
        super(inputStream);
        this.f3616c = downloadAndInsertIntoCacheProgressUpdate;
    }

    public final long m4039a() {
        return this.f3614a;
    }

    public int read() {
        int read = this.in.read();
        if (read != -1) {
            this.f3614a++;
            this.f3616c.m4038a((long) read);
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = this.in.read(bArr, i, i2);
        if (read != -1) {
            this.f3614a += (long) read;
            this.f3616c.m4038a((long) read);
        }
        return read;
    }

    public long skip(long j) {
        long skip = this.in.skip(j);
        this.f3614a += skip;
        return skip;
    }

    public void mark(int i) {
        this.in.mark(i);
        this.f3615b = this.f3614a;
    }

    public void reset() {
        if (!this.in.markSupported()) {
            this.f3616c.m4037a();
            throw new IOException("Mark not supported");
        } else if (this.f3615b == -1) {
            this.f3616c.m4037a();
            throw new IOException("Mark not set");
        } else {
            this.in.reset();
            this.f3616c.m4037a();
            this.f3616c.m4038a(this.f3615b);
            this.f3614a = this.f3615b;
        }
    }
}
