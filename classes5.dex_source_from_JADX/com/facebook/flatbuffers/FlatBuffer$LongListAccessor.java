package com.facebook.flatbuffers;

import com.facebook.flatbuffers.FlatBuffer.FlatBufferListAccessor;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: render_style */
class FlatBuffer$LongListAccessor implements FlatBufferListAccessor<Class<Void>, Long> {
    static final FlatBuffer$LongListAccessor f3160a = new FlatBuffer$LongListAccessor();

    private FlatBuffer$LongListAccessor() {
    }

    @Nullable
    public final Object m4271a(Object obj, ByteBuffer byteBuffer, int i, int i2) {
        return Long.valueOf(byteBuffer.getLong((i2 * 8) + i));
    }
}
