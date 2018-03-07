package com.facebook.storyteller.models;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: mechanism_niem */
public final class Config extends Table {
    public static Config m10765a(ByteBuffer byteBuffer) {
        Config config = new Config();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        config.a = byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position();
        config.b = byteBuffer;
        return config;
    }

    public static int m10764a(FlatBufferBuilder flatBufferBuilder, int i, int i2, boolean z, boolean z2, boolean z3, int i3) {
        flatBufferBuilder.b(6);
        flatBufferBuilder.c(5, i3, 0);
        flatBufferBuilder.c(1, i2, 0);
        flatBufferBuilder.c(0, i, 0);
        flatBufferBuilder.a(4, z3, false);
        flatBufferBuilder.a(3, z2, false);
        flatBufferBuilder.a(2, z, false);
        return flatBufferBuilder.c();
    }

    public static void m10766a(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.c(i);
    }
}
