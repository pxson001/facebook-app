package com.facebook.crypto.streams;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: syncContactsFull (%d contacts) */
public class FixedSizeByteArrayOutputStream extends ByteArrayOutputStream {
    public FixedSizeByteArrayOutputStream(int i) {
        super(i);
    }

    public final byte[] m1730a() {
        if (this.buf.length == this.count) {
            return this.buf;
        }
        throw new IOException("Size supplied is too small");
    }
}
