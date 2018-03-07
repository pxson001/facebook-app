package com.facebook.http.entity.mime;

import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

/* compiled from: relevant_reaction_key */
public class GzipCompressingEntity extends UnwrappableHttpEntityWrapper {
    public GzipCompressingEntity(HttpEntity httpEntity) {
        super(httpEntity);
    }

    public Header getContentEncoding() {
        return new BasicHeader("Content-Encoding", "gzip");
    }

    public long getContentLength() {
        return -1;
    }

    public boolean isChunked() {
        return true;
    }

    public void writeTo(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        OutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        try {
            this.wrappedEntity.writeTo(gZIPOutputStream);
        } finally {
            gZIPOutputStream.close();
        }
    }
}
