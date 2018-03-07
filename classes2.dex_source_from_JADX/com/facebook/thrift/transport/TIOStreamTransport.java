package com.facebook.thrift.transport;

import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: flush */
public class TIOStreamTransport extends TTransport {
    protected InputStream f23583a = null;
    protected OutputStream f23584b = null;

    protected TIOStreamTransport() {
    }

    public TIOStreamTransport(InputStream inputStream) {
        this.f23583a = inputStream;
    }

    public TIOStreamTransport(OutputStream outputStream) {
        this.f23584b = outputStream;
    }

    public final void m31918a() {
        if (this.f23583a != null) {
            try {
                this.f23583a.close();
                this.f23583a = null;
            } catch (Throwable e) {
                throw new RuntimeException("Error closing input stream.", e);
            }
        }
        if (this.f23584b != null) {
            try {
                this.f23584b.close();
                this.f23584b = null;
            } catch (Throwable e2) {
                throw new RuntimeException("Error closing output stream.", e2);
            }
        }
    }

    public final int mo3466a(byte[] bArr, int i, int i2) {
        if (this.f23583a == null) {
            throw new TTransportException(1, "Cannot read from null inputStream");
        }
        try {
            int read = this.f23583a.read(bArr, i, i2);
            if (read >= 0) {
                return read;
            }
            throw new TTransportException(4);
        } catch (Throwable e) {
            throw new TTransportException(0, e);
        }
    }

    public final void mo3467b(byte[] bArr, int i, int i2) {
        if (this.f23584b == null) {
            throw new TTransportException(1, "Cannot write to null outputStream");
        }
        try {
            this.f23584b.write(bArr, i, i2);
        } catch (Throwable e) {
            throw new TTransportException(0, e);
        }
    }
}
