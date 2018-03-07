package com.facebook.http.engine;

import com.facebook.http.observer.ByteCounter;
import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: mGroupId */
public class ReportingInputStream extends FilterInputStream {
    private final ByteCounter f15562a;

    public ReportingInputStream(InputStream inputStream, ByteCounter byteCounter) {
        super((InputStream) Preconditions.checkNotNull(inputStream));
        this.f15562a = (ByteCounter) Preconditions.checkNotNull(byteCounter);
    }

    public int read() {
        int read = this.in.read();
        if (read != -1) {
            this.f15562a.m17704b(1);
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = this.in.read(bArr, i, i2);
        if (read != -1) {
            this.f15562a.m17704b((long) read);
        }
        return read;
    }

    public void close() {
        super.close();
        ByteCounter byteCounter = this.f15562a;
        if (byteCounter.f12006b != null) {
            byteCounter.f12006b.m17707a();
        }
    }

    public long skip(long j) {
        long skip = this.in.skip(j);
        this.f15562a.m17704b(skip);
        return skip;
    }

    public void mark(int i) {
        this.in.mark(i);
    }

    public boolean markSupported() {
        return false;
    }

    public void reset() {
        throw new IOException("Mark not supported");
    }
}
