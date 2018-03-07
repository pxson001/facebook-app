package com.facebook.rtc.snake.fbs;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

/* compiled from: appid */
public final class SnakeCommand extends Table {
    public static void m19712a(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.b(2);
    }

    public static void m19713a(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.a(0, b, 0);
    }

    public static int m19714b(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.c();
    }
}
