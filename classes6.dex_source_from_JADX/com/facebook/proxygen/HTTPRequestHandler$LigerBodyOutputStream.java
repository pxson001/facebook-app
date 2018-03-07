package com.facebook.proxygen;

import java.io.OutputStream;

/* compiled from: src_big */
class HTTPRequestHandler$LigerBodyOutputStream extends OutputStream {
    final /* synthetic */ HTTPRequestHandler this$0;

    public HTTPRequestHandler$LigerBodyOutputStream(HTTPRequestHandler hTTPRequestHandler) {
        this.this$0 = hTTPRequestHandler;
    }

    public void write(int i) {
        if (!HTTPRequestHandler.sendBody(this.this$0, new byte[]{(byte) i}, 0, 1)) {
            throw new HTTPRequestHandler$LigerNetworkException();
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        if (!HTTPRequestHandler.sendBody(this.this$0, bArr, i, i2)) {
            throw new HTTPRequestHandler$LigerNetworkException();
        }
    }
}
