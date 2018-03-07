package com.facebook.livephotos.exoplayer.extractor;

import com.facebook.livephotos.exoplayer.upstream.DataSource;
import java.io.EOFException;
import java.util.Arrays;

/* compiled from: page_suggest_edit_successful */
public final class DefaultExtractorInput {
    private static final byte[] f6961a = new byte[4096];
    private final DataSource f6962b;
    public final long f6963c;
    public long f6964d;
    public byte[] f6965e = new byte[8192];
    public int f6966f;
    private int f6967g;

    public DefaultExtractorInput(DataSource dataSource, long j, long j2) {
        this.f6962b = dataSource;
        this.f6964d = j;
        this.f6963c = j2;
    }

    public final int m8837a(byte[] bArr, int i, int i2) {
        int d = m8832d(bArr, i, i2);
        if (d == 0) {
            d = m8829a(bArr, i, i2, 0, true);
        }
        m8835g(d);
        return d;
    }

    public final boolean m8839a(byte[] bArr, int i, int i2, boolean z) {
        int d = m8832d(bArr, i, i2);
        while (d < i2 && d != -1) {
            d = m8829a(bArr, i, i2, d, z);
        }
        m8835g(d);
        return d != -1;
    }

    public final void m8842b(byte[] bArr, int i, int i2) {
        m8839a(bArr, i, i2, false);
    }

    public final int m8836a(int i) {
        int e = m8833e(i);
        if (e == 0) {
            e = m8829a(f6961a, 0, Math.min(i, f6961a.length), 0, true);
        }
        m8835g(e);
        return e;
    }

    private boolean m8830a(int i, boolean z) {
        int e = m8833e(i);
        while (e < i && e != -1) {
            e = m8829a(f6961a, -e, Math.min(i, f6961a.length + e), e, z);
        }
        m8835g(e);
        return e != -1;
    }

    public final void m8841b(int i) {
        m8830a(i, false);
    }

    public final boolean m8843b(byte[] bArr, int i, int i2, boolean z) {
        if (!m8831b(i2, z)) {
            return false;
        }
        System.arraycopy(this.f6965e, this.f6966f - i2, bArr, i, i2);
        return true;
    }

    public final void m8846c(byte[] bArr, int i, int i2) {
        m8843b(bArr, i, i2, false);
    }

    public final void m8845c(int i) {
        m8831b(i, false);
    }

    public final void m8838a() {
        this.f6966f = 0;
    }

    public final long m8840b() {
        return this.f6964d + ((long) this.f6966f);
    }

    public final long m8844c() {
        return this.f6964d;
    }

    public final long m8847d() {
        return this.f6963c;
    }

    private boolean m8831b(int i, boolean z) {
        int i2 = this.f6966f + i;
        if (i2 > this.f6965e.length) {
            this.f6965e = Arrays.copyOf(this.f6965e, Math.max(this.f6965e.length * 2, i2));
        }
        int min = Math.min(this.f6967g - this.f6966f, i);
        this.f6967g += i - min;
        while (min < i) {
            min = m8829a(this.f6965e, this.f6966f, i, min, z);
            if (min == -1) {
                return false;
            }
        }
        this.f6966f += i;
        return true;
    }

    private int m8833e(int i) {
        int min = Math.min(this.f6967g, i);
        m8834f(min);
        return min;
    }

    private int m8832d(byte[] bArr, int i, int i2) {
        if (this.f6967g == 0) {
            return 0;
        }
        int min = Math.min(this.f6967g, i2);
        System.arraycopy(this.f6965e, 0, bArr, i, min);
        m8834f(min);
        return min;
    }

    private void m8834f(int i) {
        this.f6967g -= i;
        this.f6966f = 0;
        System.arraycopy(this.f6965e, i, this.f6965e, 0, this.f6967g);
    }

    private int m8829a(byte[] bArr, int i, int i2, int i3, boolean z) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int a = this.f6962b.mo440a(bArr, i + i3, i2 - i3);
        if (a != -1) {
            return i3 + a;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    private void m8835g(int i) {
        if (i != -1) {
            this.f6964d += (long) i;
        }
    }
}
