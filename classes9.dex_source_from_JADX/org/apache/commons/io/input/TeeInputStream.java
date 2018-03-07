package org.apache.commons.io.input;

import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: aliasMaxChars */
public class TeeInputStream extends ProxyInputStream {
    private final OutputStream f21044a;
    private final boolean f21045b;

    public TeeInputStream(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, false);
    }

    private TeeInputStream(InputStream inputStream, OutputStream outputStream, boolean z) {
        super(inputStream);
        this.f21044a = outputStream;
        this.f21045b = z;
    }

    public void close() {
        try {
            super.close();
        } finally {
            if (this.f21045b) {
                this.f21044a.close();
            }
        }
    }

    public int read() {
        int read = super.read();
        if (read != -1) {
            this.f21044a.write(read);
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.f21044a.write(bArr, i, read);
        }
        return read;
    }

    public int read(byte[] bArr) {
        int read = super.read(bArr);
        if (read != -1) {
            this.f21044a.write(bArr, 0, read);
        }
        return read;
    }
}
