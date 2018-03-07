package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: page/{%s}/videolist?page_id={%s}&source={%s} */
public class PoolFactory {
    public final PoolConfig f10520a;
    private BitmapPool f10521b;
    private FlexByteArrayPool f10522c;
    private NativeMemoryChunkPool f10523d;
    private NativePooledByteBufferFactory f10524e;
    private PooledByteStreams f10525f;
    public SharedByteArray f10526g;
    private GenericByteArrayPool f10527h;

    public PoolFactory(PoolConfig poolConfig) {
        this.f10520a = (PoolConfig) Preconditions.a(poolConfig);
    }

    public final BitmapPool m15637a() {
        if (this.f10521b == null) {
            this.f10521b = new BitmapPool(this.f10520a.f10506d, this.f10520a.f10503a, this.f10520a.f10504b);
        }
        return this.f10521b;
    }

    public final FlexByteArrayPool m15638b() {
        if (this.f10522c == null) {
            this.f10522c = new FlexByteArrayPool(this.f10520a.f10506d, this.f10520a.f10505c);
        }
        return this.f10522c;
    }

    public final int m15639c() {
        return this.f10520a.f10505c.f10502f;
    }

    public final NativeMemoryChunkPool m15640d() {
        if (this.f10523d == null) {
            this.f10523d = new NativeMemoryChunkPool(this.f10520a.f10506d, this.f10520a.f10507e, this.f10520a.f10508f);
        }
        return this.f10523d;
    }

    public final NativePooledByteBufferFactory m15641e() {
        if (this.f10524e == null) {
            this.f10524e = new NativePooledByteBufferFactory(m15640d(), m15642f());
        }
        return this.f10524e;
    }

    public final PooledByteStreams m15642f() {
        if (this.f10525f == null) {
            this.f10525f = new PooledByteStreams(m15643h());
        }
        return this.f10525f;
    }

    public final GenericByteArrayPool m15643h() {
        if (this.f10527h == null) {
            this.f10527h = new GenericByteArrayPool(this.f10520a.f10506d, this.f10520a.f10509g, this.f10520a.f10510h);
        }
        return this.f10527h;
    }
}
