package com.facebook.common.internal;

import java.io.ByteArrayOutputStream;

/* compiled from: source_location */
final class ByteStreams$FastByteArrayOutputStream extends ByteArrayOutputStream {
    final void m3746a(byte[] bArr, int i) {
        System.arraycopy(this.buf, 0, bArr, i, this.count);
    }
}
