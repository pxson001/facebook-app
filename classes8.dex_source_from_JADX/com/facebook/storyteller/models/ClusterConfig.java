package com.facebook.storyteller.models;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

/* compiled from: mechanism_passive */
public final class ClusterConfig extends Table {
    public final float m10763b() {
        int a = a(6);
        return a != 0 ? this.b.getFloat(a + this.a) : 0.0f;
    }

    public static int m10762a(FlatBufferBuilder flatBufferBuilder, float f, float f2, float f3, float f4, float f5) {
        flatBufferBuilder.b(5);
        flatBufferBuilder.a(4, f5, 0.0d);
        flatBufferBuilder.a(3, f4, 0.0d);
        flatBufferBuilder.a(2, f3, 0.0d);
        flatBufferBuilder.a(1, f2, 0.0d);
        flatBufferBuilder.a(0, f, 0.0d);
        return flatBufferBuilder.c();
    }
}
