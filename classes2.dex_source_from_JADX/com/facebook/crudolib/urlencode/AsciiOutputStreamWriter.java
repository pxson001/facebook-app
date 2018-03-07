package com.facebook.crudolib.urlencode;

import java.io.OutputStream;
import java.io.Writer;

/* compiled from: noAutomaticForeground */
public class AsciiOutputStreamWriter extends Writer {
    private final OutputStream f12241a;

    public AsciiOutputStreamWriter(OutputStream outputStream) {
        super(outputStream);
        this.f12241a = outputStream;
    }

    public void write(char[] cArr) {
        synchronized (this.lock) {
            for (char a : cArr) {
                m18191a(a);
            }
        }
    }

    public void write(char[] cArr, int i, int i2) {
        if ((i | i2) < 0 || i > cArr.length - i2) {
            throw new ArrayIndexOutOfBoundsException("length=" + cArr.length + "; offset=" + i + "; count=" + i2);
        }
        synchronized (this.lock) {
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0) {
                    int i4 = i + 1;
                    m18191a(cArr[i]);
                    i2 = i3;
                    i = i4;
                }
            }
        }
    }

    public void write(String str) {
        synchronized (this.lock) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                m18191a(str.charAt(i));
            }
        }
    }

    public void write(String str, int i, int i2) {
        if ((i | i2) < 0 || i > str.length() - i2) {
            throw new StringIndexOutOfBoundsException("length=" + str.length() + "; offset=" + i + "; count=" + i2);
        }
        synchronized (this.lock) {
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0) {
                    int i4 = i + 1;
                    m18191a(str.charAt(i));
                    i2 = i3;
                    i = i4;
                }
            }
        }
    }

    public void write(int i) {
        synchronized (this.lock) {
            m18191a(i);
        }
    }

    private void m18191a(int i) {
        if (i < 0 || i > 127) {
            throw new IllegalArgumentException("Non-ASCII character detected: " + i);
        }
        this.f12241a.write(i);
    }

    public void flush() {
        this.f12241a.flush();
    }

    public void close() {
        this.f12241a.close();
    }
}
