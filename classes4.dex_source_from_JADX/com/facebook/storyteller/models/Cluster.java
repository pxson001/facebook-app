package com.facebook.storyteller.models;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

/* compiled from: graph_cursor */
public final class Cluster extends Table {
    public static int m11459a(FlatBufferBuilder flatBufferBuilder, long j, long j2, int i) {
        flatBufferBuilder.b(3);
        flatBufferBuilder.a(1, j2, 0);
        m11460a(flatBufferBuilder, j);
        flatBufferBuilder.c(2, i, 0);
        return flatBufferBuilder.c();
    }

    private static void m11460a(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.a(0, j, 0);
    }
}
