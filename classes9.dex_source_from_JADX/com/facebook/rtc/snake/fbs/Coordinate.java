package com.facebook.rtc.snake.fbs;

import com.google.flatbuffers.Struct;
import java.nio.ByteBuffer;

/* compiled from: application/json */
public final class Coordinate extends Struct {
    public final Coordinate m19703a(int i, ByteBuffer byteBuffer) {
        this.a = i;
        this.b = byteBuffer;
        return this;
    }

    public final short m19704a() {
        return this.b.getShort(this.a + 0);
    }

    public final short m19705b() {
        return this.b.getShort(this.a + 2);
    }
}
