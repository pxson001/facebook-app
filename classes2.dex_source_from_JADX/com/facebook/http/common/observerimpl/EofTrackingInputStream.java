package com.facebook.http.common.observerimpl;

import com.facebook.http.common.observerimpl.ResponseTrackingEntity.ResponseEofTracker;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: mGradient */
class EofTrackingInputStream extends FilterInputStream {
    private final ResponseEofTracker f15563a;
    private boolean f15564b;

    public EofTrackingInputStream(InputStream inputStream, ResponseEofTracker responseEofTracker) {
        super(inputStream);
        this.f15563a = responseEofTracker;
    }

    private void m22198a() {
        if (!this.f15564b) {
            this.f15564b = true;
            this.f15563a.f15565a.f15546a.m17714b();
        }
    }

    private void m22199a(IOException iOException) {
        if (!this.f15564b) {
            this.f15564b = true;
            this.f15563a.f15565a.f15546a.m17711a(iOException);
        }
    }

    private int m22196a(int i) {
        if (i == -1) {
            m22198a();
        }
        return i;
    }

    private long m22197a(long j) {
        if (j == -1) {
            m22198a();
        }
        return j;
    }

    public int read() {
        try {
            return m22196a(this.in.read());
        } catch (IOException e) {
            m22199a(e);
            throw e;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            return m22196a(this.in.read(bArr, i, i2));
        } catch (IOException e) {
            m22199a(e);
            throw e;
        }
    }

    public long skip(long j) {
        try {
            return m22197a(this.in.skip(j));
        } catch (IOException e) {
            m22199a(e);
            throw e;
        }
    }

    public void close() {
        m22198a();
        super.close();
    }
}
