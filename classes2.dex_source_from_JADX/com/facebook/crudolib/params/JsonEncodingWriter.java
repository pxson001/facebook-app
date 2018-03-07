package com.facebook.crudolib.params;

import com.facebook.proxygen.HTTPTransportCallback;
import java.io.FilterWriter;
import java.io.Writer;

/* compiled from: t_ps */
public class JsonEncodingWriter extends FilterWriter {
    protected JsonEncodingWriter(Writer writer) {
        super(writer);
    }

    public void write(String str, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            write(str.charAt(i3));
        }
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            write(cArr[i3]);
        }
    }

    public void write(int i) {
        synchronized (this.lock) {
            m5728a(this.out, (char) i);
        }
    }

    public static void m5728a(Writer writer, char c) {
        switch (c) {
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                writer.write(92);
                writer.write(98);
                return;
            case '\t':
                writer.write(92);
                writer.write(116);
                return;
            case '\n':
                writer.write(92);
                writer.write("n");
                return;
            case '\f':
                writer.write(92);
                writer.write(102);
                return;
            case '\r':
                writer.write(92);
                writer.write(114);
                return;
            case '\"':
            case '\\':
                writer.write(92);
                break;
            default:
                if (c <= '\u001f' || c == ' ' || c == ' ') {
                    writer.write(String.format("\\u%04x", new Object[]{Integer.valueOf(c)}));
                    return;
                }
        }
        writer.write(c);
    }
}
