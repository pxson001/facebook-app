package com.facebook.storyteller.models;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

/* compiled from: me/megaphones/%s */
public final class Video extends Table {
    public static int m10791a(FlatBufferBuilder flatBufferBuilder, int i, int i2, float f, int i3, boolean z, int i4) {
        flatBufferBuilder.b(6);
        flatBufferBuilder.c(5, i4, 0);
        flatBufferBuilder.c(3, i3, 0);
        flatBufferBuilder.a(2, f, 0.0d);
        flatBufferBuilder.b(1, i2, 0);
        flatBufferBuilder.b(0, i, 0);
        flatBufferBuilder.a(4, z, false);
        return flatBufferBuilder.c();
    }
}
