package com.facebook.qe.store;

import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.manager.Authority;
import java.nio.ByteBuffer;

/* compiled from: two */
public class View {
    private final ByteBuffer f2179a;
    private final int f2180b = this.f2179a.getInt(12);
    public final boolean f2181c;

    /* compiled from: two */
    /* synthetic */ class C01751 {
        static final /* synthetic */ int[] f2758a = new int[Authority.values().length];

        static {
            try {
                f2758a[Authority.EFFECTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2758a[Authority.ASSIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2758a[Authority.OVERRIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public View(ViewBuilder viewBuilder) {
        this.f2179a = viewBuilder.a();
        this.f2181c = this.f2179a.getInt(16) > 0;
    }

    public View(ByteBuffer byteBuffer) {
        this.f2179a = byteBuffer;
        m4312b();
        this.f2181c = this.f2179a.getInt(16) > 0;
    }

    public final boolean m4320a() {
        return this.f2181c;
    }

    public final synchronized String m4319a(Authority authority, int i, String str) {
        int g = m4313g(authority, i);
        if (g >= 0) {
            int i2 = this.f2179a.getInt(g);
            byte[] bArr = new byte[i2];
            this.f2179a.position(g + 4);
            this.f2179a.get(bArr, 0, i2);
            str = new String(bArr, Constants.f2759a);
        }
        return str;
    }

    public final synchronized <T extends Enum> T m4317a(Authority authority, int i, Class<T> cls, T t) {
        int g = m4313g(authority, i);
        if (g >= 0) {
            int i2 = this.f2179a.getInt(g);
            byte[] bArr = new byte[i2];
            this.f2179a.position(g + 4);
            this.f2179a.get(bArr, 0, i2);
            String str = new String(bArr, Constants.f2759a);
            for (T t2 : (Enum[]) cls.getEnumConstants()) {
                if (t2.toString().equals(str)) {
                    t = t2;
                    break;
                }
            }
        }
        return t;
    }

    public final synchronized int m4315a(Authority authority, int i, int i2) {
        int g = m4313g(authority, i);
        if (g >= 0) {
            i2 = this.f2179a.getInt(g);
        }
        return i2;
    }

    public final synchronized long m4316a(Authority authority, int i, long j) {
        int g = m4313g(authority, i);
        if (g >= 0) {
            j = this.f2179a.getLong(g);
        }
        return j;
    }

    public final synchronized float m4314a(Authority authority, int i, float f) {
        int g = m4313g(authority, i);
        if (g >= 0) {
            f = this.f2179a.getFloat(g);
        }
        return f;
    }

    public final synchronized boolean m4322a(Authority authority, int i, boolean z) {
        int g = m4313g(authority, i);
        if (g >= 0) {
            z = this.f2179a.get(g) == (byte) 1;
        }
        return z;
    }

    public final synchronized String m4318a(Authority authority, int i) {
        byte[] bArr;
        int g = m4313g(authority, i);
        int i2 = this.f2179a.getInt(g);
        bArr = new byte[i2];
        this.f2179a.position(g + 4);
        this.f2179a.get(bArr, 0, i2);
        return new String(bArr, Constants.f2759a);
    }

    public final synchronized int m4323b(Authority authority, int i) {
        return this.f2179a.getInt(m4313g(authority, i));
    }

    public final synchronized long m4324c(Authority authority, int i) {
        return this.f2179a.getLong(m4313g(authority, i));
    }

    public final synchronized float m4325d(Authority authority, int i) {
        return this.f2179a.getFloat(m4313g(authority, i));
    }

    public final synchronized boolean m4326e(Authority authority, int i) {
        boolean z = true;
        synchronized (this) {
            if (this.f2179a.get(m4313g(authority, i)) != (byte) 1) {
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean m4327f(Authority authority, int i) {
        return m4313g(authority, i) >= 0;
    }

    public final synchronized boolean m4321a(int i) {
        return m4313g(Authority.OVERRIDE, i) == -2;
    }

    private synchronized int m4313g(Authority authority, int i) {
        int i2;
        switch (C01751.f2758a[authority.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                i2 = this.f2179a.getInt((i * 4) + 20);
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                i2 = this.f2179a.getInt(((this.f2180b + i) * 4) + 20);
                break;
            case 3:
                i2 = this.f2179a.getInt((((this.f2180b * 2) + i) * 4) + 20);
                break;
            default:
                throw new IllegalArgumentException("Invalid authority: " + authority);
        }
        return i2;
    }

    private synchronized void m4312b() {
        this.f2179a.position(0);
        int remaining = this.f2179a.remaining();
        if (remaining < 20) {
            throw new StoreIntegrityException("data.bin is too small to verify: " + remaining + " bytes less than expected: 20" + " bytes");
        }
        int i = this.f2179a.getInt(0);
        if (i != -87109619) {
            throw new StoreIntegrityException("Unexpected magic: " + i + " Expected: -87109619");
        }
        i = this.f2179a.getInt(4);
        if (i != 538251284) {
            throw new StoreIntegrityException("Unexpected version: " + i + " Expected: 538251284");
        }
        i = this.f2179a.getInt(8);
        this.f2179a.position(0);
        if (remaining != i) {
            throw new StoreIntegrityException("Unexpected data.bin size: '" + remaining + " Expected: " + i);
        }
    }
}
