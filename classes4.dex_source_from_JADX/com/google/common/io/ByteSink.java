package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: fb_temp */
public abstract class ByteSink {
    public abstract OutputStream mo896a();

    protected ByteSink() {
    }

    public final void m12633a(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        Closer a = Closer.m11942a();
        try {
            OutputStream outputStream = (OutputStream) a.m11943a(mo896a());
            outputStream.write(bArr);
            outputStream.flush();
            a.close();
        } catch (Throwable th) {
            a.close();
        }
    }

    public final long m12631a(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream);
        Closer a = Closer.m11942a();
        try {
            OutputStream outputStream = (OutputStream) a.m11943a(mo896a());
            long a2 = ByteStreams.m11949a(inputStream, outputStream);
            outputStream.flush();
            a.close();
            return a2;
        } catch (Throwable th) {
            a.close();
        }
    }
}
