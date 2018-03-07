package com.facebook.livephotos.exoplayer;

import java.nio.ByteBuffer;

/* compiled from: pages_posts_by_others_module_name */
public final class SampleHolder {
    public final CryptoInfo f6869a = new CryptoInfo();
    public ByteBuffer f6870b;
    public int f6871c;
    public int f6872d;
    public long f6873e;
    private final int f6874f;

    public SampleHolder(int i) {
        this.f6874f = i;
    }

    public final void m8749a(int i) {
        if (this.f6870b == null) {
            this.f6870b = m8748b(i);
            return;
        }
        int capacity = this.f6870b.capacity();
        int position = this.f6870b.position();
        int i2 = position + i;
        if (capacity < i2) {
            ByteBuffer b = m8748b(i2);
            if (position > 0) {
                this.f6870b.position(0);
                this.f6870b.limit(position);
                b.put(this.f6870b);
            }
            this.f6870b = b;
        }
    }

    public final boolean m8750a() {
        return (this.f6872d & 2) != 0;
    }

    public final boolean m8751b() {
        return (this.f6872d & 134217728) != 0;
    }

    public final boolean m8752c() {
        return (this.f6872d & 1) != 0;
    }

    public final void m8753d() {
        if (this.f6870b != null) {
            this.f6870b.clear();
        }
    }

    private ByteBuffer m8748b(int i) {
        if (this.f6874f == 1) {
            return ByteBuffer.allocate(i);
        }
        if (this.f6874f == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        throw new IllegalStateException("Buffer too small (" + (this.f6870b == null ? 0 : this.f6870b.capacity()) + " < " + i + ")");
    }
}
