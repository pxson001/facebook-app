package com.facebook.proxygen;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* compiled from: src_big */
class HTTPRequestHandler$CloseSuppressingOutputStream extends FilterOutputStream {
    public HTTPRequestHandler$CloseSuppressingOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void reallyClose() {
        this.out.close();
    }

    public void close() {
    }

    public void write(byte[] bArr, int i, int i2) {
        this.out.write(bArr, i, i2);
    }

    public void write(int i) {
        this.out.write(i);
    }

    public void write(byte[] bArr) {
        this.out.write(bArr);
    }
}
