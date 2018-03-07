package com.facebook.http.engine;

import com.facebook.http.observer.ByteCounter;
import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.OutputStream;

/* compiled from: dispatchCommand */
public class ReportingOutputStream extends FilterOutputStream {
    private final ByteCounter f5004a;

    public ReportingOutputStream(OutputStream outputStream, ByteCounter byteCounter) {
        super((OutputStream) Preconditions.checkNotNull(outputStream));
        this.f5004a = (ByteCounter) Preconditions.checkNotNull(byteCounter);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.out.write(bArr, i, i2);
        this.f5004a.b((long) i2);
    }

    public void write(int i) {
        this.out.write(i);
        this.f5004a.b(1);
    }
}
