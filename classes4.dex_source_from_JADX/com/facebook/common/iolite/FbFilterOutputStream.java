package com.facebook.common.iolite;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* compiled from: pack_types */
public class FbFilterOutputStream extends FilterOutputStream {
    public FbFilterOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.out.write(bArr, i, i2);
    }
}
