package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* compiled from: collectionsPeek */
public abstract class BaseReader extends Reader {
    protected final IOContext f5941a;
    protected InputStream f5942b;
    protected byte[] f5943c;
    protected int f5944d;
    protected int f5945e;
    protected char[] f5946f = null;

    protected BaseReader(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i2) {
        this.f5941a = iOContext;
        this.f5942b = inputStream;
        this.f5943c = bArr;
        this.f5944d = i;
        this.f5945e = i2;
    }

    public void close() {
        InputStream inputStream = this.f5942b;
        if (inputStream != null) {
            this.f5942b = null;
            m10748a();
            inputStream.close();
        }
    }

    public int read() {
        if (this.f5946f == null) {
            this.f5946f = new char[1];
        }
        if (read(this.f5946f, 0, 1) <= 0) {
            return -1;
        }
        return this.f5946f[0];
    }

    public final void m10748a() {
        byte[] bArr = this.f5943c;
        if (bArr != null) {
            this.f5943c = null;
            this.f5941a.a(bArr);
        }
    }

    protected static void m10746a(char[] cArr, int i, int i2) {
        throw new ArrayIndexOutOfBoundsException("read(buf," + i + "," + i2 + "), cbuf[" + cArr.length + "]");
    }

    protected static void m10747b() {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }
}
