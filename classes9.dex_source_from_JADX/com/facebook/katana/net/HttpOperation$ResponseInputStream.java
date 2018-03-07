package com.facebook.katana.net;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: p2p_payment */
public class HttpOperation$ResponseInputStream extends InputStream {
    private final String f7563a;
    private final int f7564b;
    private int f7565c = 0;
    private InputStream f7566d;

    private static int m7868a(String str) {
        if (str.startsWith("application/json") || str.startsWith("text/html") || str.startsWith("text/javascript")) {
            return 2097152;
        }
        if (str.equals("image/jpeg") || str.equals("image/gif") || str.equals("image/png") || str.equals("image/webp")) {
            return 220000;
        }
        throw new IllegalArgumentException("Unsupported content type: " + str);
    }

    public HttpOperation$ResponseInputStream(InputStream inputStream, String str) {
        this.f7566d = inputStream;
        this.f7563a = str;
        this.f7564b = m7868a(str);
    }

    private void m7869a() {
        if (this.f7565c >= this.f7564b) {
            throw new IOException("Content too large (length unknown): " + this.f7565c + " (" + this.f7563a + ")");
        }
    }

    public int read() {
        m7869a();
        int read = this.f7566d.read();
        this.f7565c++;
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        m7869a();
        if (this.f7565c + i2 > this.f7564b) {
            i2 -= (this.f7565c + i2) - this.f7564b;
        }
        int read = this.f7566d.read(bArr, i, i2);
        this.f7565c += read;
        return read;
    }

    public void close() {
        this.f7566d.close();
    }
}
