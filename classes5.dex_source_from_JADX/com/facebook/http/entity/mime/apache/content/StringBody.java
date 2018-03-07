package com.facebook.http.entity.mime.apache.content;

import java.io.OutputStream;
import java.nio.charset.Charset;

/* compiled from: disabling */
public class StringBody extends AbstractContentBody {
    private final int f5042b;
    private final byte[] f5043c;
    private final Charset f5044d;

    private StringBody(String str, String str2, Charset charset) {
        super(str2);
        this.f5042b = 4096;
        if (str == null) {
            throw new IllegalArgumentException("Text may not be null");
        }
        if (charset == null) {
            charset = Charset.forName("US-ASCII");
        }
        this.f5043c = str.getBytes(charset.name());
        this.f5044d = charset;
    }

    public StringBody(String str, Charset charset) {
        this(str, "text/plain", charset);
    }

    public StringBody(String str) {
        this(str, "text/plain", null);
    }

    public final void mo616a(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        int length = this.f5043c.length;
        for (int i = 0; i < length; i += 4096) {
            outputStream.write(this.f5043c, i, Math.min(length - i, 4096));
        }
        outputStream.flush();
    }

    public final String mo618c() {
        return "8bit";
    }

    public final String mo617b() {
        return this.f5044d.name();
    }

    public final long mo619d() {
        return (long) this.f5043c.length;
    }

    public final String mo615a() {
        return null;
    }
}
