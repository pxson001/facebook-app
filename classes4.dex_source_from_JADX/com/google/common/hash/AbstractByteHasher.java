package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: stop_qpl_marker */
abstract class AbstractByteHasher extends AbstractHasher {
    private final ByteBuffer f1660a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    protected abstract void mo117a(byte b);

    AbstractByteHasher() {
    }

    public final /* synthetic */ PrimitiveSink mo125c(byte[] bArr) {
        return mo122b(bArr);
    }

    protected void mo118a(byte[] bArr) {
        mo119a(bArr, 0, bArr.length);
    }

    protected void mo119a(byte[] bArr, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            mo117a(bArr[i3]);
        }
    }

    public final PrimitiveSink mo123b(byte b) {
        mo117a(b);
        return this;
    }

    public final Hasher mo122b(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        mo118a(bArr);
        return this;
    }

    public final PrimitiveSink mo124b(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        mo119a(bArr, i, i2);
        return this;
    }

    private Hasher m1892b(int i) {
        try {
            mo119a(this.f1660a.array(), 0, i);
            return this;
        } finally {
            this.f1660a.clear();
        }
    }

    public final Hasher mo120a(int i) {
        this.f1660a.putInt(i);
        return m1892b(4);
    }

    public final Hasher mo121a(long j) {
        this.f1660a.putLong(j);
        return m1892b(8);
    }
}
