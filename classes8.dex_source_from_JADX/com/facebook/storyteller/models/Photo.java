package com.facebook.storyteller.models;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

/* compiled from: measureWithLargestChild */
public final class Photo extends Table {
    public static int m10768a(FlatBufferBuilder flatBufferBuilder, int i, int i2, int i3, byte b, int i4, boolean z, int i5) {
        flatBufferBuilder.b(7);
        flatBufferBuilder.c(6, i5, 0);
        flatBufferBuilder.c(4, i4, 0);
        flatBufferBuilder.b(2, i3, 1);
        flatBufferBuilder.b(1, i2, 0);
        flatBufferBuilder.b(0, i, 0);
        flatBufferBuilder.a(5, z, false);
        flatBufferBuilder.a(3, b, 2);
        return flatBufferBuilder.c();
    }
}
