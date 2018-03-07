package com.facebook.crudolib.netengine.fbhttp;

import com.facebook.crudolib.netengine.HttpEngineRequestBody;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

/* compiled from: TincanNewConnection */
class CrudoNetEntityAdapter implements HttpEntity {
    private final HttpEngineRequestBody f24050a;
    @Nullable
    private final Header f24051b;

    public CrudoNetEntityAdapter(HttpEngineRequestBody httpEngineRequestBody, @Nullable Header header) {
        this.f24050a = httpEngineRequestBody;
        this.f24051b = header;
    }

    public boolean isRepeatable() {
        return true;
    }

    public boolean isChunked() {
        return getContentLength() < 0;
    }

    public long getContentLength() {
        return this.f24050a.mo1123a();
    }

    public Header getContentType() {
        return new BasicHeader("Content-Type", this.f24050a.mo1124b());
    }

    public Header getContentEncoding() {
        return this.f24051b;
    }

    public InputStream getContent() {
        throw new IllegalStateException();
    }

    public void writeTo(OutputStream outputStream) {
        this.f24050a.mo1126a(outputStream);
    }

    public boolean isStreaming() {
        return true;
    }

    public void consumeContent() {
    }
}
