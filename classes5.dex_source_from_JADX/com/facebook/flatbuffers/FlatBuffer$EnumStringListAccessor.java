package com.facebook.flatbuffers;

import com.facebook.flatbuffers.FlatBuffer.FlatBufferListAccessor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: render_style */
class FlatBuffer$EnumStringListAccessor<T extends Enum> implements FlatBufferListAccessor<Class<T>, T> {
    @Nullable
    private final Method f3152a;

    @Nullable
    public final Object m4268a(Object obj, ByteBuffer byteBuffer, int i, int i2) {
        Class cls = (Class) obj;
        int i3 = (i2 * 4) + i;
        int i4 = byteBuffer.getInt(i3);
        if (i4 == 0) {
            return null;
        }
        String a = FlatBuffer.a(byteBuffer, i3 + i4);
        if (this.f3152a != null) {
            try {
                return (Enum) this.f3152a.invoke(null, new Object[]{a});
            } catch (Exception e) {
            }
        }
        return Enum.valueOf(cls, a);
    }

    FlatBuffer$EnumStringListAccessor(@Nullable Method method) {
        this.f3152a = method;
    }
}
