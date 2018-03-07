package com.facebook.http.entity.mime.apache;

import com.facebook.http.entity.mime.apache.content.AbstractContentBody;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Random;
import javax.annotation.Nullable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

/* compiled from: discover_search */
public class MultipartEntity implements HttpEntity {
    public static final char[] f5009a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    public final HttpMultipart f5010b;
    private final Header f5011c;
    private long f5012d;
    public volatile boolean f5013e;

    private MultipartEntity(HttpMultipartMode httpMultipartMode, @Nullable String str, @Nullable Charset charset) {
        if (str == null) {
            StringBuilder stringBuilder = new StringBuilder();
            Random random = new Random();
            int nextInt = random.nextInt(11) + 30;
            for (int i = 0; i < nextInt; i++) {
                stringBuilder.append(f5009a[random.nextInt(f5009a.length)]);
            }
            str = stringBuilder.toString();
        }
        if (httpMultipartMode == null) {
            httpMultipartMode = HttpMultipartMode.STRICT;
        }
        this.f5010b = new HttpMultipart("form-data", charset, str, httpMultipartMode);
        String str2 = "Content-Type";
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("multipart/form-data; boundary=");
        stringBuilder2.append(str);
        if (charset != null) {
            stringBuilder2.append("; charset=");
            stringBuilder2.append(charset.name());
        }
        this.f5011c = new BasicHeader(str2, stringBuilder2.toString());
        this.f5013e = true;
    }

    public MultipartEntity() {
        this(HttpMultipartMode.STRICT, null, null);
    }

    public final void m9940a(String str, AbstractContentBody abstractContentBody) {
        FormBodyPart formBodyPart = new FormBodyPart(str, abstractContentBody);
        HttpMultipart httpMultipart = this.f5010b;
        if (formBodyPart != null) {
            httpMultipart.f5037g.add(formBodyPart);
        }
        this.f5013e = true;
    }

    public boolean isRepeatable() {
        for (FormBodyPart formBodyPart : this.f5010b.f5037g) {
            if (formBodyPart.f5026c.mo619d() < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isChunked() {
        return !isRepeatable();
    }

    public boolean isStreaming() {
        return !isRepeatable();
    }

    public long getContentLength() {
        if (this.f5013e) {
            this.f5012d = this.f5010b.m9968b();
            this.f5013e = false;
        }
        return this.f5012d;
    }

    public Header getContentType() {
        return this.f5011c;
    }

    public Header getContentEncoding() {
        return null;
    }

    public void consumeContent() {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public InputStream getContent() {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    public void writeTo(OutputStream outputStream) {
        this.f5010b.m9967a(outputStream);
    }
}
