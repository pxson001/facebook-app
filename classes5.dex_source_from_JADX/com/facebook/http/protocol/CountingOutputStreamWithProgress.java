package com.facebook.http.protocol;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* compiled from: dialtone_wifi_interstitial_back_pressed */
public class CountingOutputStreamWithProgress extends FilterOutputStream {
    private final ProgressListener f5066a;
    private long f5067b = 0;

    /* compiled from: dialtone_wifi_interstitial_back_pressed */
    public interface ProgressListener {
        void m9990a(long j);
    }

    public CountingOutputStreamWithProgress(OutputStream outputStream, ProgressListener progressListener) {
        super(outputStream);
        this.f5066a = progressListener;
    }

    public void write(byte[] bArr, int i, int i2) {
        this.out.write(bArr, i, i2);
        this.f5067b += (long) i2;
        this.f5066a.m9990a(this.f5067b);
    }

    public void write(int i) {
        this.out.write(i);
        this.f5067b++;
        this.f5066a.m9990a(this.f5067b);
    }
}
