package com.facebook.storyteller.models;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

/* compiled from: mechanism_turn_on_button */
public final class CheckPoints extends Table {
    public static int m10761a(FlatBufferBuilder flatBufferBuilder, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        flatBufferBuilder.b(6);
        flatBufferBuilder.a(5, z6, false);
        flatBufferBuilder.a(4, z5, false);
        flatBufferBuilder.a(3, z4, false);
        flatBufferBuilder.a(2, z3, false);
        flatBufferBuilder.a(1, z2, false);
        flatBufferBuilder.a(0, z, false);
        return flatBufferBuilder.c();
    }
}
