package com.facebook.flatbuffers;

import com.facebook.common.foreach.RandomAccessList;
import com.facebook.flatbuffers.FlatBuffer.FlatBufferListAccessor;
import java.nio.ByteBuffer;
import java.util.AbstractList;
import javax.annotation.Nullable;

/* compiled from: render_style */
class FlatBuffer$FlatBufferList<THelper, TItem> extends AbstractList<TItem> implements RandomAccessList<TItem> {
    private final ByteBuffer f3153a;
    private final int f3154b;
    private final int f3155c;
    private final FlatBufferListAccessor<THelper, TItem> f3156d;
    private final THelper f3157e;

    FlatBuffer$FlatBufferList(ByteBuffer byteBuffer, int i, int i2, FlatBufferListAccessor<THelper, TItem> flatBufferListAccessor, THelper tHelper) {
        this.f3153a = byteBuffer;
        this.f3154b = i;
        this.f3155c = i2;
        this.f3156d = flatBufferListAccessor;
        this.f3157e = tHelper;
    }

    @Nullable
    public TItem get(int i) {
        if (i >= 0 && i < this.f3155c) {
            return this.f3156d.a(this.f3157e, this.f3153a, this.f3154b, i);
        }
        throw new IndexOutOfBoundsException();
    }

    public int size() {
        return this.f3155c;
    }
}
