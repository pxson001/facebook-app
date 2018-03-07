package com.facebook.http.common;

import com.facebook.inject.Assisted;
import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Inject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

/* compiled from: mHaveData= */
public class MeasuringEntity implements HttpEntity {
    private final MeasuringInputStreamProvider f15554a;
    private final HttpEntity f15555b;
    private MeasuringInputStream f15556c;

    @Inject
    public MeasuringEntity(MeasuringInputStreamProvider measuringInputStreamProvider, @Assisted HttpEntity httpEntity) {
        Preconditions.checkState(!httpEntity.isRepeatable());
        this.f15554a = measuringInputStreamProvider;
        this.f15555b = httpEntity;
    }

    public final synchronized long m22192a() {
        return this.f15556c == null ? -1 : this.f15556c.m22202a();
    }

    public boolean isRepeatable() {
        return this.f15555b.isRepeatable();
    }

    public boolean isChunked() {
        return this.f15555b.isChunked();
    }

    public long getContentLength() {
        return this.f15555b.getContentLength();
    }

    public Header getContentType() {
        return this.f15555b.getContentType();
    }

    public Header getContentEncoding() {
        return this.f15555b.getContentEncoding();
    }

    public synchronized InputStream getContent() {
        if (this.f15556c == null) {
            this.f15556c = this.f15554a.m22193a(this.f15555b.getContent());
        }
        return this.f15556c;
    }

    public void writeTo(OutputStream outputStream) {
        this.f15555b.writeTo(outputStream);
    }

    public boolean isStreaming() {
        return this.f15555b.isStreaming();
    }

    public void consumeContent() {
        this.f15555b.consumeContent();
    }
}
