package com.facebook.proxygen.utils;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: source_dialect_name */
class RequestDefragmentingOutputStream$FallbackOutputStream extends OutputStream {
    final /* synthetic */ RequestDefragmentingOutputStream this$0;

    public RequestDefragmentingOutputStream$FallbackOutputStream(RequestDefragmentingOutputStream requestDefragmentingOutputStream) {
        this.this$0 = requestDefragmentingOutputStream;
    }

    public void write(int i) {
        if (!this.this$0.mHandlerInterface.sendBody(new byte[]{(byte) i}, 0, 1)) {
            throw new IOException();
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        if (!this.this$0.mHandlerInterface.sendBody(bArr, i, i2)) {
            throw new IOException();
        }
    }
}
