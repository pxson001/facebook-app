package com.facebook.http.common;

import android.annotation.SuppressLint;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.Assisted;
import com.google.common.base.Preconditions;
import java.io.InputStream;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: mFrameRate */
public class MeasuringInputStream extends InputStream {
    private final MonotonicClock f15566a;
    private final InputStream f15567b;
    @GuardedBy("this")
    private long f15568c;
    @GuardedBy("this")
    private long f15569d;

    @Inject
    public MeasuringInputStream(MonotonicClock monotonicClock, @Assisted InputStream inputStream) {
        this.f15566a = monotonicClock;
        this.f15567b = inputStream;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    public final long m22202a() {
        return this.f15568c;
    }

    public synchronized int read() {
        int read;
        m22200b();
        try {
            read = this.f15567b.read();
        } finally {
            m22201c();
        }
        return read;
    }

    public synchronized int read(byte[] bArr) {
        int read;
        m22200b();
        try {
            read = this.f15567b.read(bArr);
        } finally {
            m22201c();
        }
        return read;
    }

    public synchronized int read(byte[] bArr, int i, int i2) {
        int read;
        m22200b();
        try {
            read = this.f15567b.read(bArr, i, i2);
        } finally {
            m22201c();
        }
        return read;
    }

    public synchronized boolean markSupported() {
        boolean markSupported;
        m22200b();
        try {
            markSupported = this.f15567b.markSupported();
        } finally {
            m22201c();
        }
        return markSupported;
    }

    public synchronized void mark(int i) {
        m22200b();
        try {
            this.f15567b.mark(i);
        } finally {
            m22201c();
        }
    }

    public synchronized int available() {
        int available;
        m22200b();
        try {
            available = this.f15567b.available();
        } finally {
            m22201c();
        }
        return available;
    }

    public synchronized long skip(long j) {
        long skip;
        m22200b();
        try {
            skip = this.f15567b.skip(j);
        } finally {
            m22201c();
        }
        return skip;
    }

    public synchronized void reset() {
        m22200b();
        try {
            this.f15567b.reset();
        } finally {
            m22201c();
        }
    }

    public void close() {
        this.f15567b.close();
    }

    private synchronized void m22200b() {
        Preconditions.checkState(this.f15569d == 0);
        this.f15569d = this.f15566a.now();
    }

    private synchronized void m22201c() {
        Preconditions.checkState(this.f15569d > 0);
        this.f15568c += this.f15566a.now() - this.f15569d;
        this.f15569d = 0;
    }
}
