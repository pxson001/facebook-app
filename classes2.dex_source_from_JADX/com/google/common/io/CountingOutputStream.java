package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.OutputStream;

@Beta
/* compiled from: no_cancel */
public final class CountingOutputStream extends FilterOutputStream {
    public long f12240a;

    public CountingOutputStream(OutputStream outputStream) {
        super((OutputStream) Preconditions.checkNotNull(outputStream));
    }

    public final long m18190a() {
        return this.f12240a;
    }

    public final void write(byte[] bArr, int i, int i2) {
        this.out.write(bArr, i, i2);
        this.f12240a += (long) i2;
    }

    public final void write(int i) {
        this.out.write(i);
        this.f12240a++;
    }

    public final void close() {
        this.out.close();
    }
}
