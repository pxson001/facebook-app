package com.facebook.flatbuffers;

import com.facebook.flatbuffers.FlatBuffer.FlatBufferListAccessor;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: render_style */
class FlatBuffer$IntegerListAccessor implements FlatBufferListAccessor<Class<Void>, Integer> {
    static final FlatBuffer$IntegerListAccessor f3159a = new FlatBuffer$IntegerListAccessor();

    private FlatBuffer$IntegerListAccessor() {
    }

    @Nullable
    public final Object m4270a(Object obj, ByteBuffer byteBuffer, int i, int i2) {
        return Integer.valueOf(byteBuffer.getInt((i2 * 4) + i));
    }
}
