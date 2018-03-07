package com.google.common.io;

import java.io.ByteArrayOutputStream;

/* compiled from: source_location */
public final class ByteStreams$FastByteArrayOutputStream extends ByteArrayOutputStream {
    public final void m13816a(byte[] bArr, int i) {
        System.arraycopy(this.buf, 0, bArr, i, this.count);
    }
}
