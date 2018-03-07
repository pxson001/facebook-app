package com.facebook.http.entity.mime.apache;

import android.support.v7.widget.LinearLayoutCompat;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.http.util.ByteArrayBuffer;

/* compiled from: disclaimer_accept_button_text */
public class HttpMultipart {
    public static final ByteArrayBuffer f5031a = m9961a(MIME.f5039a, ": ");
    public static final ByteArrayBuffer f5032b = m9961a(MIME.f5039a, "\r\n");
    private static final ByteArrayBuffer f5033c = m9961a(MIME.f5039a, "--");
    private final String f5034d;
    private final Charset f5035e;
    public final String f5036f;
    public final List<FormBodyPart> f5037g;
    private final HttpMultipartMode f5038h;

    /* compiled from: disclaimer_accept_button_text */
    /* synthetic */ class C04801 {
        static final /* synthetic */ int[] f5029a = new int[HttpMultipartMode.values().length];

        static {
            try {
                f5029a[HttpMultipartMode.STRICT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5029a[HttpMultipartMode.BROWSER_COMPATIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: disclaimer_accept_button_text */
    class ByteCountingOutputStream extends OutputStream {
        int f5030a = 0;

        public void write(byte[] bArr, int i, int i2) {
            this.f5030a += i2;
        }

        public void write(byte[] bArr) {
            this.f5030a += bArr.length;
        }

        public void write(int i) {
            this.f5030a++;
        }
    }

    private static void m9963a(MinimalField minimalField, Charset charset, OutputStream outputStream) {
        m9965a(minimalField.f5040a, charset, outputStream);
        m9966a(f5031a, outputStream);
        m9965a(minimalField.f5041b, charset, outputStream);
        m9966a(f5032b, outputStream);
    }

    private static ByteArrayBuffer m9961a(Charset charset, String str) {
        ByteBuffer encode = charset.encode(CharBuffer.wrap(str));
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(encode.remaining());
        byteArrayBuffer.append(encode.array(), encode.position(), encode.remaining());
        return byteArrayBuffer;
    }

    public static void m9966a(ByteArrayBuffer byteArrayBuffer, OutputStream outputStream) {
        outputStream.write(byteArrayBuffer.buffer(), 0, byteArrayBuffer.length());
    }

    private static void m9965a(String str, Charset charset, OutputStream outputStream) {
        m9966a(m9961a(charset, str), outputStream);
    }

    public static void m9964a(String str, OutputStream outputStream) {
        m9966a(m9961a(MIME.f5039a, str), outputStream);
    }

    public HttpMultipart(String str, @Nullable Charset charset, String str2, HttpMultipartMode httpMultipartMode) {
        if (str == null) {
            throw new IllegalArgumentException("Multipart subtype may not be null");
        } else if (str2 == null) {
            throw new IllegalArgumentException("Multipart boundary may not be null");
        } else {
            this.f5034d = str;
            if (charset == null) {
                charset = MIME.f5039a;
            }
            this.f5035e = charset;
            this.f5036f = str2;
            this.f5037g = new ArrayList();
            this.f5038h = httpMultipartMode;
        }
    }

    private void m9962a(HttpMultipartMode httpMultipartMode, OutputStream outputStream, boolean z) {
        ByteArrayBuffer a = m9961a(this.f5035e, this.f5036f);
        for (FormBodyPart formBodyPart : this.f5037g) {
            m9966a(f5033c, outputStream);
            m9966a(a, outputStream);
            m9966a(f5032b, outputStream);
            Header header = formBodyPart.f5025b;
            switch (C04801.f5029a[httpMultipartMode.ordinal()]) {
                case 1:
                    Iterator it = header.iterator();
                    while (it.hasNext()) {
                        MinimalField minimalField = (MinimalField) it.next();
                        m9964a(minimalField.f5040a, outputStream);
                        m9966a(f5031a, outputStream);
                        m9964a(minimalField.f5041b, outputStream);
                        m9966a(f5032b, outputStream);
                    }
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    m9963a(formBodyPart.f5025b.m9960a("Content-Disposition"), this.f5035e, outputStream);
                    if (formBodyPart.f5026c.mo615a() != null) {
                        m9963a(formBodyPart.f5025b.m9960a("Content-Type"), this.f5035e, outputStream);
                        break;
                    }
                    break;
            }
            m9966a(f5032b, outputStream);
            if (z) {
                formBodyPart.f5026c.mo616a(outputStream);
            }
            m9966a(f5032b, outputStream);
        }
        m9966a(f5033c, outputStream);
        m9966a(a, outputStream);
        m9966a(f5033c, outputStream);
        m9966a(f5032b, outputStream);
    }

    public final void m9967a(OutputStream outputStream) {
        m9962a(this.f5038h, outputStream, true);
    }

    public final long m9968b() {
        long j = 0;
        for (FormBodyPart b : this.f5037g) {
            long d = b.m9959b().mo619d();
            if (d < 0) {
                return -1;
            }
            j = d + j;
        }
        OutputStream byteCountingOutputStream = new ByteCountingOutputStream();
        try {
            m9962a(this.f5038h, byteCountingOutputStream, false);
            return ((long) byteCountingOutputStream.f5030a) + j;
        } catch (IOException e) {
            return -1;
        }
    }
}
