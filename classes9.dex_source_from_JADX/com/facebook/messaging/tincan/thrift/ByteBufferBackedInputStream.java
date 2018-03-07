package com.facebook.messaging.tincan.thrift;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: click_log_in_button */
public class ByteBufferBackedInputStream extends InputStream {
    ByteBuffer f18111a;

    public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
        this.f18111a = byteBuffer;
    }

    public int read() {
        if (this.f18111a.hasRemaining()) {
            return this.f18111a.get() & 255;
        }
        return -1;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (!this.f18111a.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i2, this.f18111a.remaining());
        this.f18111a.get(bArr, i, min);
        return min;
    }
}
