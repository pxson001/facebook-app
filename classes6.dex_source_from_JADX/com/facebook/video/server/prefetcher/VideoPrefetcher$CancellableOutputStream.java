package com.facebook.video.server.prefetcher;

import java.io.FilterOutputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms.maps.model.internal.ITileProviderDelegate */
class VideoPrefetcher$CancellableOutputStream extends FilterOutputStream {
    private AtomicBoolean f19586a = new AtomicBoolean(false);
    private int f19587b;

    public VideoPrefetcher$CancellableOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void write(byte[] bArr) {
        m28293d();
        this.out.write(bArr);
        this.f19587b += bArr.length;
    }

    public void write(byte[] bArr, int i, int i2) {
        m28293d();
        this.out.write(bArr, i, i2);
        this.f19587b += i2;
    }

    public void write(int i) {
        m28293d();
        this.out.write(i);
        this.f19587b++;
    }

    public final void m28294a() {
        this.f19586a.set(true);
    }

    private void m28293d() {
        if (this.f19586a.get()) {
            throw new InterruptedIOException("Prefetch uri cancelled");
        }
    }

    public final boolean m28295b() {
        return this.f19586a.get();
    }

    public final int m28296c() {
        return this.f19587b;
    }
}
