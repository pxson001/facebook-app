package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: bug_report_did_upload */
public abstract class AbstractStreamingHashFunction$AbstractStreamingHasher extends AbstractHasher {
    private final ByteBuffer f7633a;
    private final int f7634b;
    private final int f7635c;

    protected abstract void mo1013a(ByteBuffer byteBuffer);

    abstract HashCode mo1014b();

    public final /* synthetic */ PrimitiveSink m13797b(byte[] bArr, int i, int i2) {
        return m13786a(bArr, i, i2);
    }

    public final /* synthetic */ PrimitiveSink m13799c(byte[] bArr) {
        return m13795b(bArr);
    }

    protected AbstractStreamingHashFunction$AbstractStreamingHasher(int i) {
        this(i, i);
    }

    private AbstractStreamingHashFunction$AbstractStreamingHasher(int i, int i2) {
        Preconditions.checkArgument(i2 % i == 0);
        this.f7633a = ByteBuffer.allocate(i2 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f7634b = i2;
        this.f7635c = i;
    }

    protected void mo1015b(ByteBuffer byteBuffer) {
        byteBuffer.position(byteBuffer.limit());
        byteBuffer.limit(this.f7635c + 7);
        while (byteBuffer.position() < this.f7635c) {
            byteBuffer.putLong(0);
        }
        byteBuffer.limit(this.f7635c);
        byteBuffer.flip();
        mo1013a(byteBuffer);
    }

    public final Hasher m13795b(byte[] bArr) {
        return m13786a(bArr, 0, bArr.length);
    }

    private Hasher m13786a(byte[] bArr, int i, int i2) {
        return m13787c(ByteBuffer.wrap(bArr, i, i2).order(ByteOrder.LITTLE_ENDIAN));
    }

    private Hasher m13787c(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.f7633a.remaining()) {
            this.f7633a.put(byteBuffer);
            m13788c();
        } else {
            int position = this.f7634b - this.f7633a.position();
            for (int i = 0; i < position; i++) {
                this.f7633a.put(byteBuffer.get());
            }
            m13789d();
            while (byteBuffer.remaining() >= this.f7635c) {
                mo1013a(byteBuffer);
            }
            this.f7633a.put(byteBuffer);
        }
        return this;
    }

    public final PrimitiveSink m13796b(byte b) {
        this.f7633a.put(b);
        m13788c();
        return this;
    }

    public final Hasher m13791a(int i) {
        this.f7633a.putInt(i);
        m13788c();
        return this;
    }

    public final Hasher m13792a(long j) {
        this.f7633a.putLong(j);
        m13788c();
        return this;
    }

    public final HashCode m13790a() {
        m13789d();
        this.f7633a.flip();
        if (this.f7633a.remaining() > 0) {
            mo1015b(this.f7633a);
        }
        return mo1014b();
    }

    private void m13788c() {
        if (this.f7633a.remaining() < 8) {
            m13789d();
        }
    }

    private void m13789d() {
        this.f7633a.flip();
        while (this.f7633a.remaining() >= this.f7635c) {
            mo1013a(this.f7633a);
        }
        this.f7633a.compact();
    }
}
