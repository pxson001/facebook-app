package com.facebook.common.iolite;

import java.io.OutputStream;

/* compiled from: pack */
class NonClosingOutputStream extends FbFilterOutputStream {
    public NonClosingOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void close() {
    }
}
