package com.facebook.storyteller.models;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: graph_search_null_state */
public final class StoryTellerItem extends Table {
    public static StoryTellerItem m11448a(ByteBuffer byteBuffer) {
        StoryTellerItem storyTellerItem = new StoryTellerItem();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return storyTellerItem.m11454a(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public final StoryTellerItem m11454a(int i, ByteBuffer byteBuffer) {
        this.a = i;
        this.b = byteBuffer;
        return this;
    }

    public final String m11456a() {
        int a = m11443a(4);
        return a != 0 ? m11445c(a + this.f10990a) : null;
    }

    public final double m11457b() {
        int a = m11443a(6);
        return a != 0 ? this.f10991b.getDouble(a + this.f10990a) : 0.0d;
    }

    public final byte m11458c() {
        int a = m11443a(10);
        return a != 0 ? this.f10991b.get(a + this.f10990a) : (byte) 0;
    }

    public final Table m11455a(Table table) {
        int a = m11443a(12);
        if (a == 0) {
            return null;
        }
        int i = this.f10990a + a;
        table.f10990a = i + this.f10991b.getInt(i);
        table.f10991b = this.f10991b;
        return table;
    }

    public static void m11449a(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.b(5);
    }

    public static void m11452b(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.d(2, i, 0);
    }

    public static void m11450a(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.a(3, b, 0);
    }

    public static void m11453c(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.c(4, i, 0);
    }

    public static int m11451b(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.c();
    }
}
