package com.facebook.dracula.api;

import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import java.nio.ByteBuffer;

/* compiled from: schedulePublishTime */
public class DraculaReturnValue {
    public static final ThreadLocal<DraculaReturnValue> f2923d = new ThreadLocal();
    public MutableFlatBuffer f2924a;
    public int f2925b;
    public int f2926c;

    public static DraculaReturnValue m4063a(int i) {
        return m4065a(null, 0, i);
    }

    public static DraculaReturnValue m4065a(MutableFlatBuffer mutableFlatBuffer, int i, int i2) {
        DraculaReturnValue draculaReturnValue = (DraculaReturnValue) f2923d.get();
        if (draculaReturnValue == null) {
            draculaReturnValue = new DraculaReturnValue();
            f2923d.set(draculaReturnValue);
        }
        DraculaReturnValue draculaReturnValue2 = draculaReturnValue;
        draculaReturnValue2.f2924a = mutableFlatBuffer;
        draculaReturnValue2.f2925b = i;
        draculaReturnValue2.f2926c = i2;
        return draculaReturnValue2;
    }

    public static DraculaReturnValue m4064a(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return m4065a(new MutableFlatBuffer(wrap, null, null, false, null), FlatBuffer.a(wrap), i);
    }
}
