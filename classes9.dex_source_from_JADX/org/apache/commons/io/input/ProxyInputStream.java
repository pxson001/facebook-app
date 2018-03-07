package org.apache.commons.io.input;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: aliasMinChars */
public abstract class ProxyInputStream extends FilterInputStream {
    public ProxyInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public int read() {
        try {
            return this.in.read();
        } catch (IOException e) {
            m21529a(e);
            return -1;
        }
    }

    public int read(byte[] bArr) {
        try {
            return this.in.read(bArr);
        } catch (IOException e) {
            m21529a(e);
            return -1;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.in.read(bArr, i, i2);
        } catch (IOException e) {
            m21529a(e);
            return -1;
        }
    }

    public long skip(long j) {
        try {
            return this.in.skip(j);
        } catch (IOException e) {
            m21529a(e);
            return 0;
        }
    }

    public int available() {
        try {
            return super.available();
        } catch (IOException e) {
            m21529a(e);
            return 0;
        }
    }

    public void close() {
        try {
            this.in.close();
        } catch (IOException e) {
            m21529a(e);
        }
    }

    public synchronized void mark(int i) {
        this.in.mark(i);
    }

    public synchronized void reset() {
        try {
            this.in.reset();
        } catch (IOException e) {
            m21529a(e);
        }
    }

    public boolean markSupported() {
        return this.in.markSupported();
    }

    private static void m21529a(IOException iOException) {
        throw iOException;
    }
}
