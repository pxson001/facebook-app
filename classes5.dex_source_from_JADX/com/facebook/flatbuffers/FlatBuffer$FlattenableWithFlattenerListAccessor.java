package com.facebook.flatbuffers;

import com.facebook.flatbuffers.FlatBuffer.FlatBufferListAccessor;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: render_style */
public class FlatBuffer$FlattenableWithFlattenerListAccessor<T> implements FlatBufferListAccessor<Flattener<T>, T> {
    public static final FlatBuffer$FlattenableWithFlattenerListAccessor f3158a = new FlatBuffer$FlattenableWithFlattenerListAccessor();

    private FlatBuffer$FlattenableWithFlattenerListAccessor() {
    }

    @Nullable
    public final Object m4269a(Object obj, ByteBuffer byteBuffer, int i, int i2) {
        Flattener flattener = (Flattener) obj;
        int i3 = (i2 * 4) + i;
        int i4 = byteBuffer.getInt(i3);
        if (i4 == 0) {
            return null;
        }
        try {
            return flattener.mo609a(byteBuffer, i3 + i4);
        } catch (Throwable e) {
            throw new RuntimeException("Not able to create object", e);
        } catch (Throwable e2) {
            throw new RuntimeException("Access to constructor denied", e2);
        }
    }
}
