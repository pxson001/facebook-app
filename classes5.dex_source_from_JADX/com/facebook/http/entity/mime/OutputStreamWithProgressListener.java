package com.facebook.http.entity.mime;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* compiled from: discover_feed */
public class OutputStreamWithProgressListener extends FilterOutputStream {
    private final ContentSerializationListener f5016a;
    private long f5017b = 0;

    OutputStreamWithProgressListener(OutputStream outputStream, ContentSerializationListener contentSerializationListener) {
        super(outputStream);
        this.f5016a = contentSerializationListener;
    }

    public void write(byte[] bArr, int i, int i2) {
        this.out.write(bArr, i, i2);
        m9943a(i2);
    }

    public void write(byte[] bArr) {
        this.out.write(bArr);
        m9943a(bArr.length);
    }

    public void write(int i) {
        this.out.write(i);
        m9943a(1);
    }

    private void m9943a(int i) {
        this.f5017b += (long) i;
        if (this.f5016a != null) {
            this.f5016a.mo620a(this.f5017b);
        }
    }
}
