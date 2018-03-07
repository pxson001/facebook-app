package com.facebook.http.entity.mime;

import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.crudolib.params.ParamsFormEncoder;
import com.facebook.crudolib.urlencode.AsciiOutputStreamWriter;
import com.google.common.io.CountingOutputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

/* compiled from: remove_admins_from_group */
public final class UrlEncodingEntityWithProgressListener implements Releasable, HttpEntity {
    static final BasicHeader f7613a = new BasicHeader("Content-Type", "application/x-www-form-urlencoded");
    public ContentSerializationListener f7614b;
    private final ParamsCollectionMap f7615c;

    public UrlEncodingEntityWithProgressListener(ParamsCollectionMap paramsCollectionMap) {
        this.f7615c = paramsCollectionMap;
    }

    public final boolean isRepeatable() {
        return true;
    }

    public final boolean isChunked() {
        return false;
    }

    public final long getContentLength() {
        return -1;
    }

    public final Header getContentType() {
        return f7613a;
    }

    public final Header getContentEncoding() {
        return null;
    }

    public final InputStream getContent() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        writeTo(byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    public final void writeTo(OutputStream outputStream) {
        BufferedOutputStream bufferedOutputStream = null;
        if (!((outputStream instanceof ByteArrayOutputStream) || (outputStream instanceof BufferedOutputStream))) {
            bufferedOutputStream = new BufferedOutputStream(outputStream, 2048);
            outputStream = bufferedOutputStream;
        }
        OutputStream countingOutputStream = new CountingOutputStream(outputStream);
        ParamsFormEncoder.m18192a().mo746a(new AsciiOutputStreamWriter(countingOutputStream), this.f7615c);
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        if (this.f7614b != null) {
            this.f7614b.a(countingOutputStream.f12240a);
        }
    }

    public final void mo1674a() {
        this.f7615c.m5434a();
    }

    public final boolean isStreaming() {
        return false;
    }

    public final void consumeContent() {
    }

    @Deprecated
    public static String m12187a(ParamsCollectionMap paramsCollectionMap) {
        Writer stringWriter = new StringWriter();
        try {
            ParamsFormEncoder.m18192a().mo746a(stringWriter, paramsCollectionMap);
            return stringWriter.toString();
        } catch (Throwable e) {
            throw new RuntimeException("Platform error", e);
        }
    }
}
