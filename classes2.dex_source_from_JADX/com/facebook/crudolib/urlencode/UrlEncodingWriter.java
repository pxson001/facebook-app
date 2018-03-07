package com.facebook.crudolib.urlencode;

import com.facebook.proxygen.HTTPTransportCallback;
import java.io.FilterWriter;
import java.io.Writer;

/* compiled from: no source for ref value  */
public class UrlEncodingWriter extends FilterWriter {
    private static final byte[] f12243a = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90};
    private char f12244b = '\u0000';

    public UrlEncodingWriter(Writer writer) {
        super(writer);
    }

    private void m18195a(byte b) {
        this.out.write(37);
        this.out.write(f12243a[(b >> 4) & 15]);
        this.out.write(f12243a[b & 15]);
    }

    private void m18197b(byte b) {
        if ((b >= (byte) 97 && b <= (byte) 122) || ((b >= (byte) 65 && b <= (byte) 90) || ((b >= (byte) 48 && b <= (byte) 57) || b == (byte) 46 || b == (byte) 45 || b == (byte) 42 || b == (byte) 95))) {
            this.out.write(b);
        } else if (b == (byte) 32) {
            this.out.write(43);
        } else {
            m18195a(b);
        }
    }

    private static boolean m18198c(char c) {
        return (63488 & c) == 55296;
    }

    private void m18194a() {
        if (this.f12244b != '\u0000') {
            m18195a((byte) 63);
            m18196b();
        }
    }

    private void m18196b() {
        this.f12244b = '\u0000';
    }

    public void close() {
        flush();
    }

    public void flush() {
        m18194a();
        super.flush();
    }

    public void write(String str, int i, int i2) {
        synchronized (this.lock) {
            for (int i3 = i; i3 < i + i2; i3++) {
                write(str.charAt(i3));
            }
        }
    }

    public void write(char[] cArr, int i, int i2) {
        synchronized (this.lock) {
            for (int i3 = i; i3 < i + i2; i3++) {
                write(cArr[i3]);
            }
        }
    }

    public void write(int i) {
        char c = (char) i;
        Object obj;
        if (this.f12244b != '\u0000') {
            if (m18198c(c)) {
                if ((c & 1024) != 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    int i2 = ((this.f12244b << 10) + c) - 56613888;
                    m18195a((byte) ((i2 >> 18) | 240));
                    m18195a((byte) (((i2 >> 12) & 63) | HTTPTransportCallback.BODY_BYTES_RECEIVED));
                    m18195a((byte) (((i2 >> 6) & 63) | HTTPTransportCallback.BODY_BYTES_RECEIVED));
                    m18195a((byte) ((i2 & 63) | HTTPTransportCallback.BODY_BYTES_RECEIVED));
                    m18196b();
                    return;
                }
            }
            m18195a((byte) 63);
            m18196b();
            write(c);
        } else if ((c & 65535) < HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            m18197b((byte) c);
        } else if ((c & 65535) < 2048) {
            m18195a((byte) ((c >> 6) | 192));
            m18195a((byte) ((c & 63) | HTTPTransportCallback.BODY_BYTES_RECEIVED));
        } else if (m18198c(c)) {
            if ((c & 1024) == 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                this.f12244b = c;
            } else {
                m18195a((byte) 63);
            }
        } else {
            m18195a((byte) ((c >> 12) | 224));
            m18195a((byte) (((c >> 6) & 63) | HTTPTransportCallback.BODY_BYTES_RECEIVED));
            m18195a((byte) ((c & 63) | HTTPTransportCallback.BODY_BYTES_RECEIVED));
        }
    }
}
